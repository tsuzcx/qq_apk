import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class fmk
  implements DialogInterface.OnClickListener
{
  public fmk(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    UpgradeActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmk
 * JD-Core Version:    0.7.0.1
 */