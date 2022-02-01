import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;

public class ddv
  implements View.OnClickListener
{
  public ddv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296585: 
      String str;
      do
      {
        return;
        str = null;
        if ((paramView.getTag() instanceof String)) {
          str = String.valueOf(paramView.getTag());
        }
        if ("0X8004001".equals(str))
        {
          ReportController.a(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
          paramView = new Intent(this.a, SubAccountUgActivity.class);
          paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          this.a.startActivity(paramView);
          return;
        }
      } while (!"0X8004456".equals(str));
      ReportController.a(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, SubAccountBindActivity.class);
      paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      this.a.startActivity(paramView);
      DBUtils.a().a(this.a.app.a(), true);
      return;
    }
    paramView = new Intent();
    paramView.setClass(this.a, SubAccountInfoListActivity.class);
    paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddv
 * JD-Core Version:    0.7.0.1
 */