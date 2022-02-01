import android.widget.TextView;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class jfq
  implements Runnable
{
  public jfq(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void run()
  {
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      GeoPoint localGeoPoint = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      if ((this.a.b == null) || (localGeoPoint == null) || (Math.abs(this.a.b.getLatitudeE6() - localGeoPoint.getLatitudeE6()) <= 1) || (Math.abs(this.a.b.getLongitudeE6() - localGeoPoint.getLongitudeE6()) <= 1)) {
        break label226;
      }
      i = 1;
      if ((this.a.b != null) && (i == 0)) {
        break label231;
      }
      this.a.b = localGeoPoint;
      this.a.d = false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) && (this.a.b != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "mRefreshBubbleView run start to getLocationInfo lat=" + this.a.b.getLatitudeE6() + ",lng=" + this.a.b.getLongitudeE6());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(false, true, this.a.b.getLatitudeE6(), this.a.b.getLongitudeE6());
      }
    }
    label226:
    label231:
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "mRefreshBubbleView run start map is not move show last address");
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1) || (!this.a.d));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfq
 * JD-Core Version:    0.7.0.1
 */