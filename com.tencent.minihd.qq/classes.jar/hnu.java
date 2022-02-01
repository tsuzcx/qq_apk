import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

public class hnu
  implements Runnable
{
  public hnu(QQAppInterface paramQQAppInterface, String paramString, File paramFile) {}
  
  public void run()
  {
    File localFile;
    if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MsfSdkUtils.insertMtype("lingyin", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile))
    {
      localFile = new File(QQAppInterface.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getApplicationContext().getFilesDir(), this.jdField_a_of_type_JavaLangString);
      if (localFile == null) {
        break label69;
      }
    }
    label69:
    for (long l = localFile.length();; l = 0L)
    {
      QQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnu
 * JD-Core Version:    0.7.0.1
 */