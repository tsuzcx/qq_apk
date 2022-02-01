import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class jis
  implements View.OnClickListener
{
  public jis(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = (NearbyPeopleProfileActivity.PicInfo)paramView.getTag();
    NearbyProfileDisplayPanel.a(this.a).b(NearbyProfileDisplayPanel.a(this.a).a.indexOf(paramView));
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jis
 * JD-Core Version:    0.7.0.1
 */