import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;

public class enu
  implements DialogInterface.OnClickListener
{
  public enu(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseApplicationImpl.a().a(null, null, null, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     enu
 * JD-Core Version:    0.7.0.1
 */