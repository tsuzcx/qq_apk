import android.os.Handler;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class gjw
  extends TroopObserver
{
  public gjw(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a.b = false;
    if (this.a.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 800L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 800L);
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList)
  {
    this.a.b = false;
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0))
    {
      this.a.jdField_a_of_type_Int = 0;
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.q())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      paramList = new ArrayList();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList);
      paramInt = this.a.getTitleBarHeight();
      QQToast.a(this.a, 1, this.a.getString(2131363985), 0).b(paramInt);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.q())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    this.a.jdField_a_of_type_JavaUtilList = paramList;
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(99);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjw
 * JD-Core Version:    0.7.0.1
 */