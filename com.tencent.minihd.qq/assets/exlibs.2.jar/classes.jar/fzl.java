import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public class fzl
  implements View.OnClickListener
{
  public fzl(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.h = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramView.c(2131366480);
      paramView.e(2131365736);
      paramView.a(new fzm(this));
      paramView.a(new fzn(this, paramView));
      paramView.show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBusinessCmrTmpChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049E2", "0X80049E2", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzl
 * JD-Core Version:    0.7.0.1
 */