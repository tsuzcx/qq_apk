import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class eeg
  implements Runnable
{
  public eeg(HotChatListActivity paramHotChatListActivity) {}
  
  public void run()
  {
    ((HotChatHandler)this.a.app.a(37)).a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */