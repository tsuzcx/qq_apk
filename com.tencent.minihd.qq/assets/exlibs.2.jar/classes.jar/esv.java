import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.IconPopupWindow;

public class esv
  implements View.OnClickListener
{
  public esv(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    QQMapActivity.a(this.a, new IconPopupWindow(this.a));
    QQMapActivity.a(this.a).a(2131364741, QQMapActivity.a(this.a));
    QQMapActivity.a(this.a).a(2131364620, QQMapActivity.a(this.a));
    QQMapActivity.a(this.a).a(paramView, 1);
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esv
 * JD-Core Version:    0.7.0.1
 */