import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class htp
  implements ProtoReqManager.IProtoRespBack
{
  public htp(SystemMessageProcessor paramSystemMessageProcessor, int paramInt1, int paramInt2, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, structmsg.StructMsg paramStructMsg, long paramLong) {}
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    bool1 = true;
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramProtoReq.a;
    if (paramProtoResp.a.getResultCode() != 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4012, false, localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception code:" + paramProtoResp.a.getResultCode());
      }
      return;
    }
    try
    {
      paramProtoResp = paramProtoResp.a.getWupBuffer();
      localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
      localRspSystemMsgAction.mergeFrom(paramProtoResp);
      j = localRspSystemMsgAction.head.result.get();
      if (j != 0) {
        break label444;
      }
      paramProtoResp = localRspSystemMsgAction.msg_detail.get();
      if (paramProtoResp != null) {
        break label550;
      }
      paramProtoResp = "";
    }
    catch (Exception paramProtoResp)
    {
      for (;;)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        int i;
        boolean bool2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramProtoResp);
        }
        bool1 = false;
      }
    }
    i = -1;
    if (localRspSystemMsgAction.remark_result.has()) {
      i = localRspSystemMsgAction.remark_result.get();
    }
    localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramProtoResp);
    localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
    localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
    localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
    localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
    bool2 = localToServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
    if ((bool1) && (this.jdField_a_of_type_Int == 0))
    {
      paramProtoReq = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.getManager(8);
      paramProtoReq = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a(1);
      if ((this.b != 3016) && (this.b != 2016)) {
        break label482;
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has())) {
        paramProtoReq.a(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get(), false, bool2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramProtoResp);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a(4011, bool1, localToServiceMsg);
      return;
      label444:
      paramProtoReq = localRspSystemMsgAction.head.msg_fail.get();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramProtoResp);
      bool1 = false;
      break;
      label482:
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.has()) {
        paramProtoReq.a(String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsgActionInfo.group_id.get(), this.b, null, false, bool2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     htp
 * JD-Core Version:    0.7.0.1
 */