import com.tencent.mobileqq.troop.activity.NearbyRecommendView;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

public class kcw
  implements Runnable
{
  public kcw(NearbyRecommendView paramNearbyRecommendView, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_Kcx);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_Kcx.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyRecommendView.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcw
 * JD-Core Version:    0.7.0.1
 */