import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class emu
  implements DialogInterface.OnClickListener
{
  public emu(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     emu
 * JD-Core Version:    0.7.0.1
 */