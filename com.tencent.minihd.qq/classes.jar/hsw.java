import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class hsw
  implements BaseMessageProcessor.RequestBuilder
{
  public hsw(DiscMessageProcessor paramDiscMessageProcessor, long paramLong1, long paramLong2) {}
  
  public ToServiceMsg a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMessageProcessor", 2, "<ReadReport><S>_Discussion_disUin:" + this.jdField_a_of_type_Long + " lastReadSeq:" + this.b);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageDiscMessageProcessor.a.a("MessageSvc.DisMsgReadConfirm");
    localToServiceMsg.extraData.putLong("groupuin", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("lastReadSeq", this.b);
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hsw
 * JD-Core Version:    0.7.0.1
 */