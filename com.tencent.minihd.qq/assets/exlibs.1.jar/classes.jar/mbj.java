import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.TranslucentActivity;

public class mbj
  implements DialogInterface.OnDismissListener
{
  public mbj(TranslucentActivity paramTranslucentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbj
 * JD-Core Version:    0.7.0.1
 */