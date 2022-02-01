import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class gbz
  implements View.OnClickListener
{
  public gbz(StrangerChatPie paramStrangerChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.h = true;
    int i;
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)
    {
    default: 
      i = 0;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1001) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
      PlusPanelUtils.a(StrangerChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1010) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbz
 * JD-Core Version:    0.7.0.1
 */