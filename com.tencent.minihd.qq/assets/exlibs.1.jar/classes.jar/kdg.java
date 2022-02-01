import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;

public class kdg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public kdg(NearbyTroopsView paramNearbyTroopsView, int paramInt) {}
  
  public void onGlobalLayout()
  {
    if ((NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView)) || (NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView).getVisibility() != 4) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.c.getVisibility() != 0)) {
      return;
    }
    int i = NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView).getTop();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelectionFromTop(0, -(i + this.jdField_a_of_type_Int));
    NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, true);
    kdh localkdh = new kdh(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.postDelayed(localkdh, 700L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdg
 * JD-Core Version:    0.7.0.1
 */