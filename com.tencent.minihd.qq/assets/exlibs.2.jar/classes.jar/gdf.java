import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.CommingRingTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class gdf
  implements View.OnClickListener
{
  public gdf(CommingRingTipsBar paramCommingRingTipsBar) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    paramView = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    String str = VasWebviewConstants.PERSONALITY_QQ_COLOR_RING_URL + "&type=" + "comering";
    VasWebviewUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, str, 4194304L, paramView, true, -1);
    int i = ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).f();
    ReportController.b(null, "CliOper", "", "", "0X8005001", "0X8005001", 0, 0, "" + i, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdf
 * JD-Core Version:    0.7.0.1
 */