import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import java.util.List;

public class gjo
  implements Runnable
{
  public gjo(RecommendTroopView paramRecommendTroopView, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_Gjt.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_Gjt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_Gjt.notifyDataSetChanged();
    }
    for (;;)
    {
      RecommendTroopView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        gjp localgjp = new gjp(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localgjp);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList = new ArrayList();
      break;
      label134:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjo
 * JD-Core Version:    0.7.0.1
 */