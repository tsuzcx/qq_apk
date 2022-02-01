import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController.HongbaoMsg;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.statistics.ReportController;

class gli
  implements View.OnClickListener
{
  gli(glh paramglh) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.hbMsg.a) {
      ReportController.b(FloatAioController.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController), "CliOper", "", "", "0X800617D", "0X800628A", 0, 0, "", "", "", "");
    }
    FloatAioController.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController, this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gli
 * JD-Core Version:    0.7.0.1
 */