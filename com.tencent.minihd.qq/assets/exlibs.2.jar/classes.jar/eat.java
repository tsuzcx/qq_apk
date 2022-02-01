import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;

public class eat
  implements DialogInterface.OnClickListener
{
  public eat(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((FriendProfileCardActivity.a(this.a) != null) && (FriendProfileCardActivity.a(this.a).isShowing())) {
      FriendProfileCardActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eat
 * JD-Core Version:    0.7.0.1
 */