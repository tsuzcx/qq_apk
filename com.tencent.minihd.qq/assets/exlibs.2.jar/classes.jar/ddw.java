import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime.Status;

public class ddw
  implements View.OnClickListener
{
  public ddw(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.online;
    int i = paramView.getId();
    if (i == 2131296592)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800403A", "0X800403A", 0, 0, "", "", "", "");
      paramView = AppRuntime.Status.online;
    }
    for (;;)
    {
      this.a.a(paramView);
      if (((paramView == AppRuntime.Status.online) || (paramView == AppRuntime.Status.invisiable) || (paramView == AppRuntime.Status.away)) && (paramView != this.a.app.getOnlineStatus()))
      {
        if (!NetworkUtil.e(this.a.getApplicationContext())) {
          break;
        }
        this.a.app.a(this.a.a(paramView), true);
      }
      return;
      if (i == 2131296288)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800403B", "0X800403B", 0, 0, "", "", "", "");
        paramView = AppRuntime.Status.invisiable;
      }
      else
      {
        paramView = localStatus;
        if (i == 2131296593) {
          paramView = AppRuntime.Status.away;
        }
      }
    }
    Toast.makeText(BaseApplication.getContext(), 2131365985, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddw
 * JD-Core Version:    0.7.0.1
 */