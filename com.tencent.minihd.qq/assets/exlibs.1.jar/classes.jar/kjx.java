import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class kjx
  implements DialogInterface.OnDismissListener
{
  public kjx(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjx
 * JD-Core Version:    0.7.0.1
 */