import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class krs
  implements DialogInterface.OnDismissListener
{
  public krs(JumpAction paramJumpAction) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((JumpAction.a(this.a) instanceof LoginActivity)) {
      ((LoginActivity)JumpAction.a(this.a)).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     krs
 * JD-Core Version:    0.7.0.1
 */