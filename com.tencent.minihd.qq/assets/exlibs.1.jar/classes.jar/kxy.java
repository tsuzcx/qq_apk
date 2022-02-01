import android.database.DataSetObserver;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import com.tencent.mobileqq.widget.GridListView.WraperAdapter;

public class kxy
  extends DataSetObserver
{
  public kxy(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null) {
      GridListView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxy
 * JD-Core Version:    0.7.0.1
 */