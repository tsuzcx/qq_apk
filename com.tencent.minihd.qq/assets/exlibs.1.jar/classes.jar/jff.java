import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.util.concurrent.atomic.AtomicBoolean;

public class jff
  implements View.OnTouchListener
{
  public jff(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.a.e = true;
      this.a.jdField_c_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.jdField_b_of_type_Float = paramMotionEvent.getY();
      return false;
    case 2: 
      i = j;
      if (Math.abs(paramMotionEvent.getX() - this.a.jdField_a_of_type_Float) <= 3.0F) {
        if (Math.abs(paramMotionEvent.getY() - this.a.jdField_b_of_type_Float) <= 3.0F) {
          break label212;
        }
      }
      label212:
      for (i = j; (i != 0) && (this.a.e); i = 0)
      {
        this.a.e = false;
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationAnimation);
        return false;
      }
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
    if (this.a.jdField_c_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null)
    {
      j = Math.abs(this.a.jdField_c_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() - paramView.getLatitudeE6());
      i = Math.abs(this.a.jdField_c_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() - paramView.getLongitudeE6());
    }
    for (;;)
    {
      if ((j > 1) || (i > 1)) {}
      for (i = 1;; i = 0)
      {
        if ((i != 0) || (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          break label381;
        }
        this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.a.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_c_of_type_AndroidViewAnimationAnimation);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1) || (!this.a.d)) {
          break;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return false;
      }
      label381:
      break;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jff
 * JD-Core Version:    0.7.0.1
 */