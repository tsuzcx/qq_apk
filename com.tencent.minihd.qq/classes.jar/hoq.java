import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class hoq
  implements Runnable
{
  public hoq(RouterHandler paramRouterHandler, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    MsgCSBody localMsgCSBody = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFTNNotify(this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x7SubMsgType0x7$MsgBody$MsgHeader, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(localMsgCSBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hoq
 * JD-Core Version:    0.7.0.1
 */