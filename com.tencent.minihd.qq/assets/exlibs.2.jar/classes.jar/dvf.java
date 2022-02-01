import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dvf
  implements DialogInterface.OnClickListener
{
  public dvf(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "P_CliOper", "Grp_discuss", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvf
 * JD-Core Version:    0.7.0.1
 */