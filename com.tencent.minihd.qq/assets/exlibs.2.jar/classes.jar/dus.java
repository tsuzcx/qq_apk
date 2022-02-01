import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class dus
  implements Runnable
{
  public dus(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    if (this.a.app == null) {
      return;
    }
    Object localObject = this.a.app.a();
    localObject = this.a.app.b((String)localObject);
    this.a.runOnUiThread(new dut(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dus
 * JD-Core Version:    0.7.0.1
 */