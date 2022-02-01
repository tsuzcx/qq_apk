import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class jfj
  implements Runnable
{
  public jfj(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void run()
  {
    View localView = this.a.findViewById(16908290);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = localView.getHeight();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null)
    {
      this.a.b = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      this.a.a(true, false);
      this.a.g = true;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) && (this.a.b != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(false, true, this.a.b.getLatitudeE6(), this.a.b.getLongitudeE6());
      }
    }
    VipMapRoamActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfj
 * JD-Core Version:    0.7.0.1
 */