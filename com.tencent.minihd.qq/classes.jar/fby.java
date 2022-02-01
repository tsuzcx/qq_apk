import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class fby
  implements Runnable
{
  public fby(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if ((this.a.app != null) && (this.a.app.a() != null)) {
      RecentDataListManager.a().a(this.a.app, this.a.app.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fby
 * JD-Core Version:    0.7.0.1
 */