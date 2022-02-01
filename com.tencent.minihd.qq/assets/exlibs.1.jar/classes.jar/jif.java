import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class jif
  implements Runnable
{
  public jif(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 1;
    Object localObject = this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.e("Q.nearby_people_card.", 2, "downloadHDAvatar()  uin=" + this.b + ", mgSize=" + this.jdField_a_of_type_Int + ", url = " + (String)localObject);
    }
    File localFile1 = new File(ProfileCardUtil.a(String.valueOf(this.b)));
    boolean bool2;
    if ((localFile1.exists()) && (!this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby_people_card.", 2, "download HDAvatar file is exists");
      }
      bool2 = true;
      localObject = new Message();
      ((Message)localObject).what = 102;
      if (!bool2) {
        break label296;
      }
      i = 1;
      label158:
      ((Message)localObject).arg1 = i;
      if (!this.jdField_a_of_type_Boolean) {
        break label301;
      }
    }
    label296:
    label301:
    for (int i = j;; i = 0)
    {
      ((Message)localObject).arg2 = i;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.sendMessage((Message)localObject);
      return;
      File localFile2 = new File(localFile1.getPath() + Long.toString(System.currentTimeMillis()));
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", (String)localObject), localFile2, 0), null) == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = localFile2.renameTo(localFile1);
        }
        NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, bool2);
        break;
      }
      i = 0;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jif
 * JD-Core Version:    0.7.0.1
 */