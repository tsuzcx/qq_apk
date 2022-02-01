import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class gvg
  implements View.OnClickListener
{
  public gvg(RecentCallHelper paramRecentCallHelper, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    String str = VasWebviewConstants.PERSONALITY_FUNCALL_URL.replace("[src]", String.valueOf(2));
    paramView = str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a != null) {
      paramView = str.replace("[uin]", this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a.a());
    }
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 524288L, localIntent, false, -1);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 2, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvg
 * JD-Core Version:    0.7.0.1
 */