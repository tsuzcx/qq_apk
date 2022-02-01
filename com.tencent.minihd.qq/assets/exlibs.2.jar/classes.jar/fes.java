import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class fes
  implements DialogInterface.OnDismissListener
{
  public fes(SubLoginActivity paramSubLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SubLoginActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fes
 * JD-Core Version:    0.7.0.1
 */