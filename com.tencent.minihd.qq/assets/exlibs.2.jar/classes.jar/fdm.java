import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import mqq.app.MobileQQ;

public class fdm
  implements View.OnClickListener
{
  public fdm(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(View paramView)
  {
    SubLoginActivity localSubLoginActivity = SubLoginActivity.class;
    Intent localIntent = new Intent();
    List localList = this.a.app.getApplication().getAllAccounts();
    paramView = localSubLoginActivity;
    if (localList != null)
    {
      paramView = localSubLoginActivity;
      if (localList.size() > 2) {
        paramView = SubAccountBindActivity.class;
      }
    }
    localIntent.setClass(this.a, paramView);
    localIntent.putExtra("fromWhere", this.a.a);
    this.a.startActivity(localIntent);
    ReportController.a(this.a.app, "CliOper", "", "", "0X800445A", "0X800445A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdm
 * JD-Core Version:    0.7.0.1
 */