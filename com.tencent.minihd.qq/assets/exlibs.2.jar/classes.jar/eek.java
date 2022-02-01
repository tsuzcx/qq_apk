import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class eek
  implements Runnable
{
  public eek(HotChatListActivity paramHotChatListActivity) {}
  
  public void run()
  {
    ((HotChatHandler)this.a.app.a(37)).a(this.a.a, true, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eek
 * JD-Core Version:    0.7.0.1
 */