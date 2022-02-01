import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jin
  implements View.OnClickListener
{
  public jin(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyPeopleProfileActivity.b(this.a) != null) && (!this.a.isFinishing()))
    {
      NearbyPeopleProfileActivity.b(this.a).dismiss();
      NearbyPeopleProfileActivity.b(this.a, null);
    }
    this.a.a(300L);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jin
 * JD-Core Version:    0.7.0.1
 */