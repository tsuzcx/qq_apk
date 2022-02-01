import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gbn
  implements DialogInterface.OnDismissListener
{
  public gbn(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PublicAccountChatPie.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbn
 * JD-Core Version:    0.7.0.1
 */