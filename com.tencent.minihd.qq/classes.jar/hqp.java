import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class hqp
  implements Runnable
{
  public hqp(ActivateFriendsManager paramActivateFriendsManager, int paramInt, long[] paramArrayOfLong1, String paramString, long[] paramArrayOfLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = this.jdField_a_of_type_ArrayOfLong;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        l = localObject[i];
        localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = String.valueOf(l);
        localSessionInfo.jdField_a_of_type_Int = 0;
        localSessionInfo.d = ContactUtils.j(ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager), String.valueOf(l));
        ChatActivityFacade.a(ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager), ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager).a(), localSessionInfo, this.jdField_a_of_type_JavaLangString, null, false);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(this.jdField_a_of_type_ArrayOfLong, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager).notifyObservers(ActivateFriendsObserver.class, 113, true, (Bundle)localObject);
    }
    while (ActivateFriendServlet.a(ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong, this.b))
    {
      int j;
      int i;
      long l;
      SessionInfo localSessionInfo;
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_rt_type", 2);
    ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager).notifyObservers(ActivateFriendsObserver.class, 113, false, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqp
 * JD-Core Version:    0.7.0.1
 */