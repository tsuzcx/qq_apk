import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ecn
  extends Thread
{
  public ecn(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString1, byte paramByte, String paramString2, String paramString3)
  {
    super(paramString1);
  }
  
  public void run()
  {
    int j = 0;
    int i;
    if ((this.jdField_a_of_type_Byte & 0x20) != 0) {
      i = 0;
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_JavaLangString + i;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_JavaNetURL = new URL((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar()  uin=" + this.b + ", mgSize=" + i + ", url = " + (String)localObject);
        }
        File localFile1 = new File(ProfileCardUtil.a(String.valueOf(this.b)));
        File localFile2 = new File(localFile1.getPath() + Long.toString(System.currentTimeMillis()));
        if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", (String)localObject), localFile2, 0), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar) == 0)
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (bool1) {
            bool2 = localFile2.renameTo(localFile1);
          }
          localObject = Message.obtain();
          ((Message)localObject).what = 3;
          i = j;
          if (bool2) {
            i = 1;
          }
          ((Message)localObject).arg1 = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
          return;
          if ((this.jdField_a_of_type_Byte & 0x10) != 0)
          {
            i = 640;
            continue;
          }
          if ((this.jdField_a_of_type_Byte & 0x8) != 0)
          {
            i = 140;
            continue;
          }
          if ((this.jdField_a_of_type_Byte & 0x4) != 0)
          {
            i = 100;
            continue;
          }
          i = 40;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          boolean bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.profilecard.Avatar", 2, localMalformedURLException.toString());
            continue;
            bool1 = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecn
 * JD-Core Version:    0.7.0.1
 */