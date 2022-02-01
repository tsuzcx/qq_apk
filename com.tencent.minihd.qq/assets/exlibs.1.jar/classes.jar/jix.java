import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class jix
  implements View.OnClickListener
{
  public jix(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    if (NearbyProfileDisplayPanel.a(this.a).r == 0)
    {
      NearbyProfileDisplayPanel.a(this.a).b();
      return;
    }
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
    NearbyProfileDisplayPanel.a(this.a).a(300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jix
 * JD-Core Version:    0.7.0.1
 */