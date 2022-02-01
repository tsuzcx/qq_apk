import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.troopbar.TroopBarDetailActivity;

public class coq
  implements DialogInterface.OnDismissListener
{
  public coq(TroopBarDetailActivity paramTroopBarDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TroopBarDetailActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coq
 * JD-Core Version:    0.7.0.1
 */