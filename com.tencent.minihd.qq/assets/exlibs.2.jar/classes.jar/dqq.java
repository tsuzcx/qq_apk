import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class dqq
  implements Runnable
{
  public dqq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (this.a.app != null) {
      ((FriendsManagerImp)this.a.app.getManager(8)).b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqq
 * JD-Core Version:    0.7.0.1
 */