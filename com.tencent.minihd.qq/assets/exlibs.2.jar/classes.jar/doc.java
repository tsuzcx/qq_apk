import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;

public class doc
  implements DialogInterface.OnCancelListener
{
  public doc(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     doc
 * JD-Core Version:    0.7.0.1
 */