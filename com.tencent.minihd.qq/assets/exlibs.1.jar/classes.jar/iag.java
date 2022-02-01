import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.dating.DatingManager;
import java.util.List;

public class iag
  implements Runnable
{
  public iag(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void run()
  {
    List localList = ((DatingManager)this.a.app.getManager(67)).b();
    this.a.runOnUiThread(new iah(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iag
 * JD-Core Version:    0.7.0.1
 */