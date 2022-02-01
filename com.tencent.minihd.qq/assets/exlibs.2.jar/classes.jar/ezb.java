import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class ezb
  implements AbsListView.OnScrollListener
{
  public ezb(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_Boolean))
    {
      paramInt = this.a.jdField_a_of_type_ComTencentWidgetXListView.t();
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
        this.a.c();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ezb
 * JD-Core Version:    0.7.0.1
 */