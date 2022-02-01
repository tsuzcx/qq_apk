import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.qphone.base.util.QLog;

public class hqo
  implements Runnable
{
  public hqo(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastCheckTime = " + ActivateFriendsManager.a(this.a) + " | timeInterval = " + Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.a)) + " | checkInterval = " + ActivateFriendsManager.b(this.a));
    }
    if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.a)) <= ActivateFriendsManager.b(this.a)) {
      return;
    }
    ActivateFriendServlet.a(ActivateFriendsManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqo
 * JD-Core Version:    0.7.0.1
 */