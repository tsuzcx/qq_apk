import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.SogouEmoji.OnEmojiJsonBackSogou;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class ieu
  extends DownloadListener
{
  public ieu(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    if (paramDownloadTask.a() == 3)
    {
      localBundle = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      Object localObject = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
      int i = localBundle.getInt("jsonType", EmojiManager.c);
      paramDownloadTask = (File)paramDownloadTask.a.get(localObject);
      localObject = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      ReqInfo localReqInfo = new ReqInfo();
      if (!paramDownloadTask.exists()) {
        break label154;
      }
      paramDownloadTask = FileUtils.a(paramDownloadTask);
      paramDownloadTask = this.a.a(localEmoticonPackage, i, paramDownloadTask, (ArrayList)localObject, localArrayList, localReqInfo);
      if (paramDownloadTask == null) {
        break label159;
      }
      this.a.a("param_error", paramDownloadTask);
      this.a.a(localEmoticonPackage, 11008);
      this.a.a(localEmoticonPackage, 11008, 0L);
    }
    label154:
    label159:
    do
    {
      return;
      paramDownloadTask = null;
      break;
      paramDownloadTask = EmojiManager.a(this.a).get(localEmoticonPackage.epId);
    } while (localBundle == null);
    paramDownloadTask = (Object[])paramDownloadTask;
    if ((paramDownloadTask != null) && (paramDownloadTask.length == 4)) {
      ((SogouEmoji.OnEmojiJsonBackSogou)paramDownloadTask[0]).a(((Integer)paramDownloadTask[1]).intValue(), (String)paramDownloadTask[2], (String)paramDownloadTask[3]);
    }
    EmojiManager.a(this.a).remove(localEmoticonPackage.epId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ieu
 * JD-Core Version:    0.7.0.1
 */