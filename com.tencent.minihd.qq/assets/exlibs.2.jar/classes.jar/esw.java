import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class esw
  implements View.OnClickListener
{
  public esw(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 0: 
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_QQshare", 0, 0, "", "", "", "");
      this.a.t();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setCleanCachOnPause(false);
    if (QfavBuilder.a((float)this.a.jdField_a_of_type_Double, (float)this.a.b, this.a.n, this.a.k, null).c(this.a.getIntent().getStringExtra("uin")).a(this.a, this.a.getIntent().getStringExtra("uin"), 1, null))
    {
      int i = QQMapActivity.d(this.a).getDimensionPixelSize(2131492923);
      QQToast.a(this.a, 2, this.a.getString(2131364628), 1).b(i);
    }
    QfavReport.a(null, 65, 7);
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esw
 * JD-Core Version:    0.7.0.1
 */