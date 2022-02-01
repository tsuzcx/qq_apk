import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;

public class eyr
  implements Runnable
{
  public eyr(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void run()
  {
    if (RegisterVerifyCodeActivity.a(this.a) == 1)
    {
      RegisterVerifyCodeActivity.a(this.a).setText(2131366883);
      RegisterVerifyCodeActivity.a(this.a).setEnabled(true);
      RegisterVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    RegisterVerifyCodeActivity.b(this.a);
    RegisterVerifyCodeActivity.a(this.a).setText(this.a.getString(2131366883) + "(" + RegisterVerifyCodeActivity.a(this.a) + ")");
    this.a.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyr
 * JD-Core Version:    0.7.0.1
 */