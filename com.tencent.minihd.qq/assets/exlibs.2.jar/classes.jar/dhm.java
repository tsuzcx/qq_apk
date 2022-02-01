import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;

public class dhm
  implements Runnable
{
  public dhm(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.a(this.a) <= 1)
    {
      AuthDevVerifyCodeActivity.a(this.a).setText(2131366883);
      AuthDevVerifyCodeActivity.a(this.a).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b(this.a);
    AuthDevVerifyCodeActivity.a(this.a).setText(this.a.getString(2131366883) + "(" + AuthDevVerifyCodeActivity.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhm
 * JD-Core Version:    0.7.0.1
 */