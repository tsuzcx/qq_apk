import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class lyl
  implements DialogInterface.OnDismissListener
{
  public lyl(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyl
 * JD-Core Version:    0.7.0.1
 */