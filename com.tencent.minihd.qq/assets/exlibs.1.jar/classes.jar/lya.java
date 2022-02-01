import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkBridgeActivity;

public class lya
  implements DialogInterface.OnDismissListener
{
  public lya(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lya
 * JD-Core Version:    0.7.0.1
 */