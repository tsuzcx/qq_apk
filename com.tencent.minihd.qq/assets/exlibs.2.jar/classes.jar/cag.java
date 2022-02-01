import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;

public class cag
  implements DialogInterface.OnDismissListener
{
  public cag(JoinGroupHandler paramJoinGroupHandler) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    JoinGroupHandler.a(this.a).c();
    JoinGroupHandler.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cag
 * JD-Core Version:    0.7.0.1
 */