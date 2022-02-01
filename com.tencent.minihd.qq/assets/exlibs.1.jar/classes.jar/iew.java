import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class iew
  extends DownloadListener
{
  public iew(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "qfaceMaterialDownloadListener| onDone task=" + paramDownloadTask);
    }
    long l = paramDownloadTask.h - paramDownloadTask.g;
    Bundle localBundle = paramDownloadTask.a();
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
    int i;
    if (paramDownloadTask.a() == 3)
    {
      if (localBundle.getInt("status") == 2)
      {
        localEmoticonPackage.status = 2;
        this.a.a().a(localEmoticonPackage);
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d(localEmoticonPackage);
        this.a.a(localEmoticonPackage, 0);
        this.a.a(localEmoticonPackage, 0, l);
        return;
      }
      paramDownloadTask = (File)paramDownloadTask.a.get(paramDownloadTask.b);
      if (paramDownloadTask == null) {
        break label361;
      }
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), EmosmUtils.getQFaceMaterialFolderPath(localEmoticonPackage.epId, false), false);
        i = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          i = 0;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 11025, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.a.a(localEmoticonPackage, 11025);
        this.a.a(localEmoticonPackage, 11025, 0L);
        return;
      }
      paramDownloadTask.delete();
    }
    for (;;)
    {
      if (i != 0)
      {
        localEmoticonPackage.status = 2;
        this.a.a().a(localEmoticonPackage);
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d(localEmoticonPackage);
        this.a.a(localEmoticonPackage, 0);
        this.a.a(localEmoticonPackage, 0, l);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 11025, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.a(localEmoticonPackage, EmosmUtils.checkResultCode(paramDownloadTask.z));
      this.a.a(localEmoticonPackage, EmosmUtils.checkResultCode(paramDownloadTask.z), 0L);
      return;
      label361:
      i = 0;
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    this.a.a("param_epId", localEmoticonPackage.epId);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iew
 * JD-Core Version:    0.7.0.1
 */