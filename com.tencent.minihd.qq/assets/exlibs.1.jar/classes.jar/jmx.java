import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jmx
  implements DialogInterface.OnClickListener
{
  public jmx(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.e();
    this.a.f();
    ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_VIPOPENSERVICE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmx
 * JD-Core Version:    0.7.0.1
 */