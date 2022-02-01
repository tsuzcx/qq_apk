import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class gic
  implements Runnable
{
  gic(gib paramgib, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Gib.a.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    if ((this.jdField_a_of_type_Gib.a.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Gib.a.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_Gib.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a() != this.jdField_a_of_type_Gib.a.jdField_a_of_type_Gil) {
        this.jdField_a_of_type_Gib.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Gib.a.jdField_a_of_type_Gil);
      }
      this.jdField_a_of_type_Gib.a.jdField_a_of_type_Gil.notifyDataSetChanged();
      return;
    }
    if (this.jdField_a_of_type_Gib.a.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_Gib.a.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Gib.a.jdField_a_of_type_Gil.notifyDataSetChanged();
    this.jdField_a_of_type_Gib.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_Gib.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gic
 * JD-Core Version:    0.7.0.1
 */