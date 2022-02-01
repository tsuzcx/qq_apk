import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class jmn
  implements Runnable
{
  public jmn(ProfileCardCheckUpdate paramProfileCardCheckUpdate, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + this.jdField_a_of_type_JavaLangString + ",version=" + this.b);
    }
    try
    {
      Object localObject = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getApplication());
      localObject = new File((String)localObject + ".tmp");
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject);
      localDownloadTask.e = "profileCardDownload";
      localDownloadTask.d = "VIP_profilecard";
      localDownloadTask.a = 1;
      int j = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a);
      if (j == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + j);
        }
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success version=" + this.b);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getPreferences().edit().putString("profileLabelVersion", this.b).commit();
          ProfileCardCheckUpdate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate, (File)localObject);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmn
 * JD-Core Version:    0.7.0.1
 */