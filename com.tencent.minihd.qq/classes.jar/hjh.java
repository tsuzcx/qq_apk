import android.os.Bundle;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class hjh
  extends DownloadListener
{
  public hjh(EmoticonManagerImp paramEmoticonManagerImp, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    EmojiManager localEmojiManager = (EmojiManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    Object localObject1 = paramDownloadTask.a();
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    Object localObject2 = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
    int i = ((Bundle)localObject1).getInt("jsonType", EmojiManager.c);
    localObject1 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(localObject2);
    localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    if (((File)localObject1).exists())
    {
      localObject1 = FileUtils.a((File)localObject1);
      localObject1 = localEmojiManager.a(localEmoticonPackage, i, (byte[])localObject1, (ArrayList)localObject2, localArrayList, localReqInfo);
      if (localObject1 == null) {
        break label151;
      }
      localEmojiManager.a("param_error", (String)localObject1);
      localEmojiManager.a(localEmoticonPackage, 11008);
    }
    label151:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
      } while (paramDownloadTask.a() != 3);
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonManagerImp", 2, "json is complete,result ok: " + localEmoticonPackage.epId);
      }
      paramDownloadTask = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilMap.get(localEmoticonPackage.epId);
    } while (paramDownloadTask == null);
    paramDownloadTask.name = localEmoticonPackage.name;
    paramDownloadTask.mark = localEmoticonPackage.mark;
    paramDownloadTask.type = localEmoticonPackage.type;
    paramDownloadTask.mobileFeetype = localEmoticonPackage.mobileFeetype;
    paramDownloadTask.downloadCount = localEmoticonPackage.downloadCount;
    paramDownloadTask.type = localEmoticonPackage.type;
    this.a.a(paramDownloadTask);
    this.a.a(paramDownloadTask.epId);
    localEmojiManager.b(localEmoticonPackage);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006649", "0X8006649", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjh
 * JD-Core Version:    0.7.0.1
 */