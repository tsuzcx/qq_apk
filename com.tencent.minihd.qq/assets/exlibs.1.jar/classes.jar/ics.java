import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.dating.DetailGuest;

public class ics
  implements DialogInterface.OnDismissListener
{
  public ics(DetailGuest paramDetailGuest) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ics
 * JD-Core Version:    0.7.0.1
 */