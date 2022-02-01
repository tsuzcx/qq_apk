import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ddf
  implements DialogInterface.OnClickListener
{
  public ddf(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.a, SubAccountBindActivity.class);
    paramDialogInterface.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    this.a.startActivity(paramDialogInterface);
    ReportController.a(this.a.app, "CliOper", "", "", "0X80040A6", "0X80040A6", 0, 0, "", "", "", "");
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddf
 * JD-Core Version:    0.7.0.1
 */