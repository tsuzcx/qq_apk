import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

class kzr
  implements Runnable
{
  kzr(kzq paramkzq) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long);
    MQPSensitiveMsgUtil.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kzr
 * JD-Core Version:    0.7.0.1
 */