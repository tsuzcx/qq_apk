import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.device.msg.activities.DeviceShareAgentActivity;

public class dbe
  implements DialogInterface.OnDismissListener
{
  public dbe(DeviceShareAgentActivity paramDeviceShareAgentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbe
 * JD-Core Version:    0.7.0.1
 */