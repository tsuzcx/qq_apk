import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class eec
  implements View.OnClickListener
{
  public eec(HotChatListActivity paramHotChatListActivity, Runnable paramRunnable) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      if ((HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity) != null) && (HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity).isShowing())) {
        HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity).dismiss();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.app, "CliOper", "", "", "0X8004B1B", "0X8004B1B", 1, 0, "", "", "", "");
    }
    do
    {
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.getString(2131369501), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.getTitleBarHeight());
    } while ((HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity) == null) || (!HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity).isShowing()));
    HotChatListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eec
 * JD-Core Version:    0.7.0.1
 */