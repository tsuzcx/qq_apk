import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ein
  implements ActionSheet.OnButtonClickListener
{
  public ein(LoginActivity paramLoginActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (LoginActivity.e(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, CommonWebActivity.class);
      paramView.putExtra("uin", this.a.app.a());
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      LoginActivity.f(this.a, true);
      LoginActivity.a(this.a).dismiss();
      return;
      if (paramInt == 1)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
        boolean bool = this.a.getIntent().getBooleanExtra("login_from_account_change", false);
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("login_from_account_change", bool);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ein
 * JD-Core Version:    0.7.0.1
 */