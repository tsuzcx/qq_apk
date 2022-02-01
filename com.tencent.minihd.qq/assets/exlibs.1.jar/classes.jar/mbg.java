import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public final class mbg
  implements DialogInterface.OnDismissListener
{
  public mbg(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbg
 * JD-Core Version:    0.7.0.1
 */