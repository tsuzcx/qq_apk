import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class jit
  implements View.OnClickListener
{
  public jit(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    NearbyProfileDisplayPanel.a(this.a);
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X800482C", "0X800482C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jit
 * JD-Core Version:    0.7.0.1
 */