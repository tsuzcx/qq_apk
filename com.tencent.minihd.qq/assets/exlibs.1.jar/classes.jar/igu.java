import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class igu
  extends DownloadListener
{
  public igu(EmotionPreviewLayout paramEmotionPreviewLayout, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a() == 3)
    {
      localObject1 = (EmojiManager)EmotionPreviewLayout.a(this.a).getManager(42);
      localObject3 = paramDownloadTask.a();
      localObject2 = (EmoticonPackage)((Bundle)localObject3).getSerializable("emoticonPackage");
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId))) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      Object localObject4 = EmosmUtils.getEmosmJsonUrl(((EmoticonPackage)localObject2).epId);
      int i = ((Bundle)localObject3).getInt("jsonType", EmojiManager.c);
      paramDownloadTask = (File)paramDownloadTask.a.get(localObject4);
      Object localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      ReqInfo localReqInfo = new ReqInfo();
      if (paramDownloadTask.exists()) {}
      for (paramDownloadTask = FileUtils.a(paramDownloadTask);; paramDownloadTask = null)
      {
        ((EmojiManager)localObject1).a((EmoticonPackage)localObject2, i, paramDownloadTask, (ArrayList)localObject3, (ArrayList)localObject4, localReqInfo);
        return;
      }
    }
    Object localObject1 = EmotionPreviewLayout.a;
    Object localObject2 = new StringBuilder().append("jsonDetailDownloadListener Failure, currUrl:");
    if (paramDownloadTask.b != null) {}
    for (paramDownloadTask = paramDownloadTask.b;; paramDownloadTask = "~")
    {
      QLog.e((String)localObject1, 2, paramDownloadTask);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igu
 * JD-Core Version:    0.7.0.1
 */