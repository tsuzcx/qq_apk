import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class jja
  implements DialogInterface.OnClickListener
{
  public jja(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((NearbyProfileDisplayPanel.a(this.a) != null) && (!NearbyProfileDisplayPanel.a(this.a).isEnabled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating", 2, "profile add friend return");
      }
      return;
    }
    NearbyProfileDisplayPanel.c(this.a);
    if ((NearbyProfileDisplayPanel.a(this.a) != null) && (NearbyProfileDisplayPanel.a(this.a).isShowing())) {
      NearbyProfileDisplayPanel.a(this.a).dismiss();
    }
    ReportController.b(NearbyProfileDisplayPanel.a(this.a).app, "CliOper", "", "", "0X8004829", "0X8004829", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jja
 * JD-Core Version:    0.7.0.1
 */