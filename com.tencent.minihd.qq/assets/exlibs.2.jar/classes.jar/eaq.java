import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;

class eaq
  implements View.OnClickListener
{
  eaq(ean paramean) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X80047F1", "0X80047F1", 0, 0, "", "", "", VipUtils.a(this.a.a.app, this.a.a.app.a()));
    if ((FriendProfileCardActivity.b(this.a.a) == 160L) || (ProfileCardUtil.d(FriendProfileCardActivity.a(this.a.a))))
    {
      Toast.makeText(this.a.a.getApplicationContext(), 2131369059, 0).show();
      return;
    }
    this.a.a.a(FriendProfileCardActivity.a(this.a.a), FriendProfileCardActivity.b(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eaq
 * JD-Core Version:    0.7.0.1
 */