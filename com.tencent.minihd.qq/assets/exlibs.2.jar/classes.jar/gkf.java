import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class gkf
  implements View.OnClickListener
{
  public gkf(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.a(true);
      return;
    case 2131298681: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      paramView = (TroopCreateLogic)this.a.app.getManager(31);
      if (paramView != null) {
        paramView.a(this.a, 0);
      }
      this.a.a(false);
      return;
    case 2131298874: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      this.a.a(false);
      return;
    case 2131298876: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(paramView);
      this.a.a(false);
      return;
    case 2131299329: 
      TroopActivity.a(this.a);
      this.a.a(false);
      return;
    case 2131297357: 
      this.a.finish();
      return;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
    if (this.a.a.getVisibility() == 0)
    {
      this.a.a(true);
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkf
 * JD-Core Version:    0.7.0.1
 */