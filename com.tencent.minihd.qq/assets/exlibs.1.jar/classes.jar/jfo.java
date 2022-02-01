import android.view.View;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity.UiHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class jfo
  implements OverScrollViewListener
{
  public jfo(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.a.b);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.a.b);
    if (NetworkUtil.e(this.a.getApplication()))
    {
      this.a.a(true, true);
      return true;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.obtainMessage(101, 200, 0);
    this.a.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.a.b);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfo
 * JD-Core Version:    0.7.0.1
 */