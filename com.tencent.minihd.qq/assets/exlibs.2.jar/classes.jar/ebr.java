import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ebr
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
  public ebr(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramProfileCardTemplate);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    boolean bool4 = true;
    int i = 0;
    Object localObject1;
    boolean bool2;
    boolean bool3;
    Object localObject2;
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.b == null)) {
        break label729;
      }
      localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject1 = (ProfileCardTemplate)this.b.get();
      if ((localFriendProfileCardActivity == null) || (localObject1 == null)) {
        break label729;
      }
      if (!localFriendProfileCardActivity.a(this.jdField_a_of_type_JavaLangString, true)) {
        return;
      }
      localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateBegin", "downloadTemplateStart", false);
      localObject1 = Message.obtain();
      bool2 = ProfileCardUtil.a(localFriendProfileCardActivity.app);
      bool3 = ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString);
      if (bool3) {
        break label726;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "start download background=" + this.jdField_a_of_type_JavaLangString + ",isExistBgResource=" + bool3);
      }
      localObject2 = new File(ProfileCardUtil.b(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString));
      localObject2 = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject2);
      ((DownloadTask)localObject2).e = "profileCardDownload";
      ((DownloadTask)localObject2).d = "VIP_profilecard";
      if ((DownloaderFactory.a((DownloadTask)localObject2, localFriendProfileCardActivity.app) != 0) || (!ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString))) {
        break label413;
      }
      bool1 = true;
    }
    catch (Exception localException1)
    {
      FriendProfileCardActivity localFriendProfileCardActivity;
      localException1.printStackTrace();
      return;
    }
    localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateBackground", "downloadTemplateStart", false);
    boolean bool1 = bool2;
    File localFile;
    Object localObject3;
    if (!bool2)
    {
      localObject2 = ProfileCardUtil.a(localFriendProfileCardActivity.app, -1L);
      bool1 = bool2;
      if ("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_53.zip" != null)
      {
        bool1 = bool2;
        if (localObject2 != null)
        {
          localFile = new File((String)localObject2);
          localObject3 = new File((String)localObject2 + File.separator + "config_black.json");
          if ((!localFile.isDirectory()) || (!((File)localObject3).exists())) {
            break label418;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateCommon", "downloadTemplateStart", false);
      if ((bool1) && (bool3))
      {
        ((Message)localObject1).what = 6;
        localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
        label413:
        bool1 = false;
        break label730;
        label418:
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "start downloadCardTemplate path= " + (String)localObject2);
        }
        localFile = new File((String)localObject2 + ".zip");
        if (localFile.exists()) {
          localFile.delete();
        }
        localObject3 = new DownloadTask("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_53.zip", localFile);
        ((DownloadTask)localObject3).e = "profileCardDownload";
        ((DownloadTask)localObject3).d = "VIP_profilecard";
        int j = DownloaderFactory.a((DownloadTask)localObject3, localException1.app);
        if (j == 0) {
          i = 1;
        }
        bool1 = bool2;
        if (i == 0) {
          continue;
        }
        try
        {
          FileUtils.a(localFile.getAbsolutePath(), (String)localObject2 + File.separator, false);
          localFile.delete();
          ProfileCardUtil.a(localException1.app, "common", "53");
          if (ProfileCardUtil.a(localException1.app))
          {
            bool1 = bool4;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate unzip success");
              bool1 = bool4;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  success but unzip error");
            }
            bool1 = bool2;
          }
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  exception msg=" + localIOException.getMessage());
          }
          localIOException.printStackTrace();
          bool1 = bool2;
          continue;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          bool1 = bool2;
        }
      }
      else
      {
        ((Message)localObject1).what = 7;
        localException1.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
        label726:
        break;
        label729:
        return;
      }
      label730:
      bool3 = bool1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ebr
 * JD-Core Version:    0.7.0.1
 */