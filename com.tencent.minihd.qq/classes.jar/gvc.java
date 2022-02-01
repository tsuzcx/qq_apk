import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class gvc
  implements View.OnClickListener
{
  public gvc(RecentCallHelper paramRecentCallHelper, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.h();
    paramView = "";
    if (LightTalkTipsData.a() != null) {
      paramView = LightTalkTipsData.a().f;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "gotoLightalkWeb() url = " + paramView);
    }
    if (StringUtil.b(paramView)) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    ThreadManager.b(new gvd(this));
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 524288L, localIntent, false, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a, "CliOper", "", "", "0X800510D", "0X800510D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvc
 * JD-Core Version:    0.7.0.1
 */