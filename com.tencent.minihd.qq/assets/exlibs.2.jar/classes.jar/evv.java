import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.activity.RecentSaidActivity.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class evv
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public evv(RecentSaidActivity paramRecentSaidActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.c) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.b) || (this.b <= 0)) {}
    while ((paramInt != 0) || (this.b > this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a(21);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a.getCount();
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evv
 * JD-Core Version:    0.7.0.1
 */