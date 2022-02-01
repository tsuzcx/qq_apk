import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.PositionActivatePage;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.util.WeakReference;

public class foi
  implements View.OnClickListener
{
  public foi(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      paramView = new Intent((Context)PositionActivatePage.a(this.a).get(), NearbyActivity.class);
      paramView.putExtra("FROM_WHERE", 1002);
      paramView.putExtra("is_skip_nearby_guide", true);
      paramView.setFlags(67108864);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).startActivity(paramView);
      ReportController.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E07", "0X8004E07", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     foi
 * JD-Core Version:    0.7.0.1
 */