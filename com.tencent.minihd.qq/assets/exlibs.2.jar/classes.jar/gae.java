import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;

public class gae
  implements Runnable
{
  public gae(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    FriendChatPie.a(this.a).b(1);
    FriendChatPie.a(this.a).b(2);
    FriendChatPie.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gae
 * JD-Core Version:    0.7.0.1
 */