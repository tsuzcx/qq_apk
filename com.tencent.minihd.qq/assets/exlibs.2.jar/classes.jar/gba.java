import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class gba
  implements DialogInterface.OnDismissListener
{
  public gba(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PublicAccountChatPie.g(this.a, false);
    ReportController.b(this.a.a, "CliOper", "Pb_account_lifeservice", "", "0X8004EFA", "0X8004EFA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gba
 * JD-Core Version:    0.7.0.1
 */