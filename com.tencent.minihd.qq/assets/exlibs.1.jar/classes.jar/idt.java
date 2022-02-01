import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class idt
  implements View.OnClickListener
{
  public idt(NearbyTransitActivity paramNearbyTransitActivity, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity) != null) && (NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity).isShowing())) {
      NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity).dismiss();
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity).sendEmptyMessageDelayed(5, 200L);
      NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity).sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.b(new idu(this));
      return;
    }
    paramView = Message.obtain();
    paramView.what = 1;
    paramView.obj = this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity.getString(2131369501);
    NearbyTransitActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingNearbyTransitActivity).sendMessage(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idt
 * JD-Core Version:    0.7.0.1
 */