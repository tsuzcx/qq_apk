import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class hli
  extends SendMessageHandler.SendMessageRunnable
{
  public hli(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, BusinessObserver paramBusinessObserver, boolean paramBoolean) {}
  
  public void run()
  {
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hli
 * JD-Core Version:    0.7.0.1
 */