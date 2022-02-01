import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class gdy
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public gdy(VipFunCallTipsBar paramVipFunCallTipsBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    String str = VasWebviewConstants.PERSONALITY_FUNCALL_URL.replace("[src]", String.valueOf(4)).replace("[uin]", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_AndroidAppActivity, str, 524288L, paramView, false, -1);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdy
 * JD-Core Version:    0.7.0.1
 */