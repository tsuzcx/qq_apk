package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FlagInfo;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew;

public class ReqSystemMsgNewItem
  implements CheckUpdateItemInterface
{
  private static final String jdField_a_of_type_JavaLangString = "ReqSystemMsgNewItem";
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public ReqSystemMsgNewItem(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 114;
    Object localObject1 = new structmsg.ReqSystemMsgNew();
    ((structmsg.ReqSystemMsgNew)localObject1).msg_num.set(10);
    ((structmsg.ReqSystemMsgNew)localObject1).checktype.set(4);
    Object localObject2 = ((QQAppInterface)this.a).a();
    ((structmsg.ReqSystemMsgNew)localObject1).latest_friend_seq.set(((MessageHandler)localObject2).a().d("last_friend_seq_47"));
    ((structmsg.ReqSystemMsgNew)localObject1).latest_group_seq.set(((MessageHandler)localObject2).a().d("last_group_seq"));
    ((structmsg.ReqSystemMsgNew)localObject1).version.set(1000);
    ((structmsg.ReqSystemMsgNew)localObject1).is_get_grp_ribbon.set(false);
    localObject2 = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
    ((structmsg.ReqSystemMsgNew)localObject1).flag.set((MessageMicro)localObject2);
    ((structmsg.ReqSystemMsgNew)localObject1).is_get_frd_ribbon.set(false);
    localObject1 = ((structmsg.ReqSystemMsgNew)localObject1).toByteArray();
    localObject2 = new byte[localObject1.length + 4];
    PkgTools.a((byte[])localObject2, 0, localObject1.length + 4);
    PkgTools.a((byte[])localObject2, 4, (byte[])localObject1, localObject1.length);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem.eServiceID == 114)
    {
      if (paramRespItem.cResult != 2) {
        break label106;
      }
      localObject = paramRespItem.vecUpdate;
      i = localObject.length - 4;
      paramRespItem = new byte[i];
      System.arraycopy(localObject, 4, paramRespItem, 0, i);
      localObject = new ToServiceMsg("mobileqq.service", this.a.getAccount(), "ProfileService.Pb.ReqSystemMsgNew");
      localFromServiceMsg = new FromServiceMsg(this.a.getAccount(), "ProfileService.Pb.ReqSystemMsgNew");
      localFromServiceMsg.setServiceCmd("ProfileService.Pb.ReqSystemMsgNew");
      localFromServiceMsg.setMsgSuccess();
      ((QQAppInterface)this.a).a().a((ToServiceMsg)localObject, localFromServiceMsg, paramRespItem);
    }
    label106:
    while (!QLog.isColorLevel())
    {
      Object localObject;
      int i;
      FromServiceMsg localFromServiceMsg;
      return;
    }
    QLog.d("ReqSystemMsgNewItem", 2, "error happend item.cResult = " + paramRespItem.cResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqSystemMsgNewItem
 * JD-Core Version:    0.7.0.1
 */