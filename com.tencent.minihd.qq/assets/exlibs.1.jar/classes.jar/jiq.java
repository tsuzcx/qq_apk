import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class jiq
  implements DialogInterface.OnClickListener
{
  public jiq(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((NearbyProfileDisplayPanel.a(this.a) != null) && (NearbyProfileDisplayPanel.a(this.a).isShowing())) {
      NearbyProfileDisplayPanel.a(this.a).dismiss();
    }
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X8004829", "0X8004829", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jiq
 * JD-Core Version:    0.7.0.1
 */