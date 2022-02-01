import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.dating.DatingBaseActivity;

public class hzu
  implements DialogInterface.OnDismissListener
{
  public hzu(DatingBaseActivity paramDatingBaseActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (DatingBaseActivity.a(this.a) != null) {
      DatingBaseActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzu
 * JD-Core Version:    0.7.0.1
 */