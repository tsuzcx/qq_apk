import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;

public class kdf
  implements View.OnClickListener
{
  public kdf(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.a.w();
      return;
      TroopCreateEnterActivity.a(this.a, 2, 51);
      this.a.w();
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
      return;
      TroopQQBrowserHelper.c(this.a, this.a.jdField_e_of_type_JavaLangString);
      this.a.w();
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "ac", "create", 0, 0, "", "", "", "");
      return;
      this.a.onBackPressed();
      return;
      if (this.a.jdField_e_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.a.w();
        return;
      }
      this.a.a();
      return;
      TroopCreateEnterActivity.a(this.a, 2, 51);
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdf
 * JD-Core Version:    0.7.0.1
 */