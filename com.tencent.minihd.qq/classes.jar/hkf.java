import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public final class hkf
  implements DialogInterface.OnDismissListener
{
  public hkf(Activity paramActivity, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkf
 * JD-Core Version:    0.7.0.1
 */