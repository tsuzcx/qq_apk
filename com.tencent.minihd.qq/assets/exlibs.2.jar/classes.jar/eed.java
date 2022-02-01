import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.HotChatListActivity;

public class eed
  implements DialogInterface.OnDismissListener
{
  public eed(HotChatListActivity paramHotChatListActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    HotChatListActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eed
 * JD-Core Version:    0.7.0.1
 */