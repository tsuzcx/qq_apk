import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class fbw
  implements Runnable
{
  public fbw(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (!this.a.isResume()) {}
    do
    {
      return;
      localIntent = this.a.app.a();
      this.a.app.a(null);
    } while (localIntent == null);
    String str = localIntent.getStringExtra("wording");
    int i = localIntent.getIntExtra("timetowait", 360000);
    Intent localIntent = new Intent("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
    localIntent.putExtra("wording", str);
    localIntent.putExtra("timetowait", i);
    SplashActivity.a(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fbw
 * JD-Core Version:    0.7.0.1
 */