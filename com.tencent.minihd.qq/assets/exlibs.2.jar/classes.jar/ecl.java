import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class ecl
  implements Runnable
{
  public ecl(FriendProfileImageAvatar paramFriendProfileImageAvatar, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo) {}
  
  public void run()
  {
    localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.a().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      Setting localSetting = (Setting)localEntityManager.a(Setting.class, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.e);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localEntityManager.a(localSetting);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localEntityManager.a();
      }
    }
    finally
    {
      localEntityManager.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecl
 * JD-Core Version:    0.7.0.1
 */