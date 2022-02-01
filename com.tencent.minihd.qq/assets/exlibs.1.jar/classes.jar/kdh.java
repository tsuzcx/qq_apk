import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;

class kdh
  implements Runnable
{
  kdh(kdg paramkdg) {}
  
  public void run()
  {
    if (!NearbyTroopsView.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.postDelayed(this, 200L);
      return;
    }
    NearbyTroopsView.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView).setVisibility(0);
    int i = NearbyTroopsView.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView).getTop();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelectionFromTop(0, -(i + this.a.jdField_a_of_type_Int));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.e(-this.a.jdField_a_of_type_Int, 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdh
 * JD-Core Version:    0.7.0.1
 */