import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class mdz
  implements DialogInterface.OnDismissListener
{
  public mdz(SmartDevicePluginLoader paramSmartDevicePluginLoader, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdz
 * JD-Core Version:    0.7.0.1
 */