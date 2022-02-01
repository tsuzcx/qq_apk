import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarShareActivity;
import com.tencent.mobileqq.utils.TroopBarShareUtils;

public class kgu
  implements DialogInterface.OnClickListener
{
  public kgu(TroopBarShareActivity paramTroopBarShareActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.finish();
      TroopBarShareUtils.a(this.a.app, "suc_app", this.a.b);
      return;
    }
    TroopBarShareUtils.a(this.a.app, "suc_tribe", this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgu
 * JD-Core Version:    0.7.0.1
 */