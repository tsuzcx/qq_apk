import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public final class lyt
  implements DialogInterface.OnDismissListener
{
  public lyt(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyt
 * JD-Core Version:    0.7.0.1
 */