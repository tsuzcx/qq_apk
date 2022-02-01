import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class eac
  implements View.OnClickListener
{
  public eac(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131299473)
    {
      ForwardRecentActivity.a(this.a, 10);
      return;
    }
    if (i == 2131297357)
    {
      if ((ForwardRecentActivity.a(this.a) != null) && (ForwardRecentActivity.a(this.a).v == 11))
      {
        ForwardOperations.a(this.a, false, "shareToQQ", ForwardRecentActivity.a(this.a).a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      this.a.finish();
      return;
    }
    if (i == 2131297737)
    {
      paramView = new Intent(this.a, SelectMemberActivity.class);
      paramView.putExtra("param_type", 3000);
      paramView.putExtra("param_subtype", 0);
      paramView.putExtra("param_min", 2);
      paramView.putExtra("param_max", 49);
      this.a.startActivityForResult(paramView, 20003);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004E8D", "0X8004E8D", 0, 0, "", "", "", "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("call_by_forward", true);
    if (this.a.jdField_a_of_type_AndroidNetUri != null) {
      localIntent.setData(this.a.jdField_a_of_type_AndroidNetUri);
    }
    if (this.a.getIntent().getBooleanExtra("isFromShare", false))
    {
      localIntent.putExtras(this.a.jdField_a_of_type_AndroidOsBundle);
      localIntent.setAction(this.a.getIntent().getAction());
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297275: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 1);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404D", "0X800404D", 0, 0, "", "", "", "");
      return;
      Bundle localBundle = this.a.getIntent().getExtras();
      if ("com.tencent.intent.QQ_FORWARD".equals(this.a.getIntent().getAction())) {
        localIntent.setAction("com.tencent.intent.QQ_FORWARD");
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        break;
        if (this.a.b) {
          localIntent.setAction("com.tencent.intent.QQ_FORWARD");
        }
      }
    case 2131297729: 
      localIntent.setClass(this.a, PhoneFrameActivity.class);
      localIntent.putExtra("key_req_type", 2);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "1", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404B", "0X800404B", 0, 0, "", "", "", "");
      return;
    case 2131297733: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404C", "0X800404C", 0, 0, "", "", "", "");
      return;
    case 2131297731: 
      ReportController.b(this.a.app, "CliOper", "", "", "Network_circle", "Forward_circle_clk", 0, 0, "", "", "", "");
      localIntent.setClass(this.a, NewFriendActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      return;
    case 2131297727: 
      localIntent.setClass(this.a, ForwardFriendListActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404A", "0X800404A", 0, 0, "", "", "", "");
      return;
    }
    if ((this.a.b) && (this.a.h != 11)) {
      ForwardRecentActivity.a(this.a);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404E", "0X800404E", 0, 0, "", "", "", "");
      return;
      ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131363525));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     eac
 * JD-Core Version:    0.7.0.1
 */