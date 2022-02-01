import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class hrx
  implements Runnable
{
  public hrx(TimerCheckMsgCount paramTimerCheckMsgCount) {}
  
  public void run()
  {
    TimerCheckMsgCount.a(this.a).a.a().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hrx
 * JD-Core Version:    0.7.0.1
 */