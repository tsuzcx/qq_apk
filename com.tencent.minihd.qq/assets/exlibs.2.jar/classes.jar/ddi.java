import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class ddi
  implements View.OnClickListener
{
  public ddi(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c) {
      return;
    }
    paramView = this.a;
    boolean bool;
    if (!this.a.b)
    {
      bool = true;
      paramView.b = bool;
      if (!this.a.b) {
        break label225;
      }
      AccountManageActivity.a(this.a).setVisibility(8);
      AccountManageActivity.b(this.a).setVisibility(0);
      AccountManageActivity.c(this.a).setText(2131367064);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427975));
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        ((ShaderAnimLayout)AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView)).d();
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      this.a.b();
      this.a.a(this.a.b);
      this.a.c = false;
      AccountManageActivity.a(this.a).postDelayed(new ddj(this), 400L);
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label225:
      AccountManageActivity.d(this.a).setVisibility(0);
      AccountManageActivity.e(this.a).setVisibility(8);
      AccountManageActivity.f(this.a).setText(2131367082);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131427938));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddi
 * JD-Core Version:    0.7.0.1
 */