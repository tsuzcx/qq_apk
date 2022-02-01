import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class ekc
  implements AbsListView.OnScrollListener
{
  public ekc(MayKnowManActivity paramMayKnowManActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MayKnowManActivity.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged:" + paramInt);
    }
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (paramInt == 0) && (this.a.jdField_a_of_type_Boolean))
    {
      int i = this.a.jdField_a_of_type_ComTencentWidgetXListView.t();
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= i) {
        this.a.a();
      }
    }
    if (this.a.jdField_a_of_type_Ekj != null) {
      this.a.jdField_a_of_type_Ekj.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Ekj != null) {
      this.a.jdField_a_of_type_Ekj.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ekc
 * JD-Core Version:    0.7.0.1
 */