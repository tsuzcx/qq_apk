import android.app.Dialog;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;

public class fnl
  implements Runnable
{
  public fnl(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fnl
 * JD-Core Version:    0.7.0.1
 */