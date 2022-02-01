import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class fxj
  implements View.OnClickListener
{
  public fxj(ThumbItemBuilder paramThumbItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    VasWebviewUtil.a(this.a.jdField_a_of_type_AndroidContentContext, VasWebviewConstants.PERSONALITY_QQ_COLOR_RING_URL, 4194304L, paramView, true, -1);
    int i = ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).f();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxj
 * JD-Core Version:    0.7.0.1
 */