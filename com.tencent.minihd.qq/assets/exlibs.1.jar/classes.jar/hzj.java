import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class hzj
  implements View.OnClickListener
{
  public hzj(CarrierHelper paramCarrierHelper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (Integer)paramView.getTag(2131296428);
    paramView = (String)paramView.getTag();
    if ((localObject == null) || (paramView == null)) {}
    label267:
    for (;;)
    {
      return;
      if (CarrierHelper.a(this.a) == 0)
      {
        ReportController.b(CarrierHelper.a(this.a).app, "CliOper", "", "", "0X8004ECC", "0X8004ECC", 1, 0, String.valueOf(localObject), "", "", "");
        localObject = JumpParser.a(CarrierHelper.a(this.a).app, CarrierHelper.a(this.a), paramView);
        if (localObject == null) {
          break label227;
        }
        ((JumpAction)localObject).b();
      }
      for (;;)
      {
        if ((CarrierHelper.a(this.a) != 0) || (!(CarrierHelper.a(this.a) instanceof NearbyActivity)) || (((NearbyActivity)CarrierHelper.a(this.a)).a == null)) {
          break label267;
        }
        ((NearbyActivity)CarrierHelper.a(this.a)).a.b(8);
        return;
        if ((CarrierHelper.a(this.a) != 2) && (CarrierHelper.a(this.a) != 1)) {
          break;
        }
        ReportController.b(CarrierHelper.a(this.a).app, "CliOper", "", "", "0X80050D1", "0X80050D1", CarrierHelper.a(this.a), 0, String.valueOf(localObject), "", "", "");
        break;
        label227:
        localObject = new Intent(CarrierHelper.a(this.a), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramView));
        CarrierHelper.a(this.a).startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzj
 * JD-Core Version:    0.7.0.1
 */