import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class jmo
  implements Runnable
{
  public jmo(ProfileCardCheckUpdate paramProfileCardCheckUpdate, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 1;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate start downloadProfileCardFile url=" + this.jdField_a_of_type_JavaLangString + ",version=" + this.b);
    }
    for (;;)
    {
      int k;
      try
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getPreferences();
        Object localObject1 = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a.getApplication());
        Object localObject2 = new File((String)localObject1 + ".tmp");
        localSharedPreferences.edit().putBoolean("is_template_list_loaded", false).commit();
        Object localObject3 = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject2);
        ((DownloadTask)localObject3).e = "profileCardDownload";
        ((DownloadTask)localObject3).d = "VIP_profilecard";
        ((DownloadTask)localObject3).a = 1;
        k = DownloaderFactory.a((DownloadTask)localObject3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardCheckUpdate.a);
        if (k != 0) {
          break label589;
        }
        localSharedPreferences.edit().putBoolean("is_template_list_loaded", true).commit();
        if (i != 0)
        {
          if (!((File)localObject2).exists()) {
            break;
          }
          localObject3 = FileUtils.a((File)localObject2);
          if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
            break;
          }
          Object localObject4 = new JSONObject((String)localObject3);
          if ((((JSONObject)localObject4).has("background")) && (((JSONObject)localObject4).has("style")))
          {
            localObject3 = ((JSONObject)localObject4).optJSONArray("style");
            localObject4 = ((JSONObject)localObject4).optJSONArray("background");
            if ((((JSONArray)localObject3).length() <= 0) || (((JSONArray)localObject4).length() <= 0)) {
              break;
            }
            FileUtils.c((String)localObject1 + ".tmp", (String)localObject1);
            ((File)localObject2).delete();
            localObject1 = new File((String)localObject1).getParentFile().listFiles();
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              i = j;
              if (i < localObject1.length)
              {
                localObject2 = localObject1[i].getName();
                if ((!((String)localObject2).startsWith("qvip_profile_template.json")) || (((String)localObject2).endsWith("5.9.3"))) {
                  break label582;
                }
                FileUtils.d((String)localObject2);
                if (!QLog.isColorLevel()) {
                  break label582;
                }
                QLog.i("Q.profilecard.FrdProfileCard", 2, "delete old file=" + (String)localObject2);
                break label582;
              }
            }
            localSharedPreferences.edit().putString("cardTemplateVersion", this.b).commit();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate update template list file success version=" + this.b);
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate download file content error,url=" + this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ProfileCard.ProfileCardCheckUpdate", 2, "ProfileCardCheckUpdate download error resultCode=" + k + ",url=" + this.jdField_a_of_type_JavaLangString);
      return;
      label582:
      i += 1;
      continue;
      label589:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmo
 * JD-Core Version:    0.7.0.1
 */