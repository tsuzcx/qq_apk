import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class eim
  implements DialogInterface.OnDismissListener
{
  public eim(LoginActivity paramLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginActivity.f(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eim
 * JD-Core Version:    0.7.0.1
 */