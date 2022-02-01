import android.os.Handler;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import java.util.TimerTask;

public class gdh
  extends TimerTask
{
  public gdh(FraudTipsBar paramFraudTipsBar) {}
  
  public void run()
  {
    FraudTipsBar.a(this.a).post(new gdi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdh
 * JD-Core Version:    0.7.0.1
 */