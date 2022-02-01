import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnSearchResultItemClick;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.AdapterView;

public class jfr
  implements RoamSearchDialog.OnSearchResultItemClick
{
  public jfr(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, LocationDetail paramLocationDetail)
  {
    double d1;
    double d2;
    if (paramLocationDetail != null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a.dismiss();
      }
      d1 = paramLocationDetail.a;
      d2 = paramLocationDetail.b;
      paramView = paramLocationDetail.c;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null) && (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null) && (d1 > 0.0D) && (d2 > 0.0D))
      {
        paramLocationDetail = this.a.app;
        if (!VipUtils.a(this.a.app)) {
          break label369;
        }
      }
    }
    label369:
    for (paramAdapterView = "1";; paramAdapterView = "0")
    {
      VipUtils.a(paramLocationDetail, "Vip_MapRoam", "0X8004A31", "0X8004A31", 0, 0, new String[] { paramAdapterView });
      paramAdapterView = new GeoPoint((int)(1000000.0D * d1), (int)(1000000.0D * d2));
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(paramAdapterView);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(paramView))
      {
        this.a.jdField_f_of_type_JavaLangString = paramView;
        if (this.a.jdField_f_of_type_Boolean) {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        }
      }
      this.a.b = paramAdapterView.Copy();
      this.a.h = false;
      this.a.d = false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null) && (this.a.b != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "OnSearchResultItemClick onItemClick start to getLocationInfo lat=" + this.a.b.getLatitudeE6() + ",lng=" + this.a.b.getLongitudeE6());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(false, true, this.a.b.getLatitudeE6(), this.a.b.getLongitudeE6());
      }
      this.a.a(true, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfr
 * JD-Core Version:    0.7.0.1
 */