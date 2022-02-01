import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class drl
  implements DialogInterface.OnCancelListener
{
  public drl(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     drl
 * JD-Core Version:    0.7.0.1
 */