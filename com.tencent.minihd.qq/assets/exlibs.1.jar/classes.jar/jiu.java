import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class jiu
  implements View.OnClickListener
{
  public jiu(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    NearbyProfileDisplayPanel.b(this.a);
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X800482D", "0X800482D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jiu
 * JD-Core Version:    0.7.0.1
 */