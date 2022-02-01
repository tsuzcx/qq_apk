package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.vipfuncall.VipSetFunCall.SFunCallSetReq;
import com.tencent.pb.vipfuncall.VipSetFunCall.SFunCallSetRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class VipSetFunCallHandler
  extends BusinessHandler
{
  private QQAppInterface b;
  
  public VipSetFunCallHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return VipFunCallObserver.class;
  }
  
  public void a(int paramInt, String paramString)
  {
    VipSetFunCall.SFunCallSetReq localSFunCallSetReq = new VipSetFunCall.SFunCallSetReq();
    localSFunCallSetReq.uin.set(Long.parseLong(this.a.a()));
    localSFunCallSetReq.id.set(paramInt);
    localSFunCallSetReq.platform.set(109);
    localSFunCallSetReq.touin.set(Long.parseLong(paramString));
    localSFunCallSetReq.client_version.set("5.9.3.3468");
    ToServiceMsg localToServiceMsg = a("FunCall.Set");
    localToServiceMsg.extraData.putLong("touin", Long.parseLong(paramString));
    localToServiceMsg.putWupBuffer(localSFunCallSetReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("FunCall.Set"))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      if (QLog.isColorLevel()) {
        QLog.d("VipSetFunCallHandler", 2, "isSuccess=" + bool);
      }
      if (!bool)
      {
        paramToServiceMsg = new Bundle();
        paramToServiceMsg.putInt("ret", VipFunCallManager.h);
        a(1, false, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("VipSetFunCallHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.a.a());
        }
        ReportCenter.a().a("FunCall.Set", 100, paramFromServiceMsg.getBusinessFailCode(), this.a.a(), 1000277, "趣味来电设置失败", true);
      }
    }
    else
    {
      return;
    }
    paramFromServiceMsg = new VipSetFunCall.SFunCallSetRsp();
    try
    {
      paramObject = (VipSetFunCall.SFunCallSetRsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        long l;
        int i;
        int j;
        paramFromServiceMsg.ret.set(-1);
        paramFromServiceMsg.msg.set("prb.mergeFrom exception");
        paramObject.printStackTrace();
      }
      a(1, false, paramToServiceMsg);
    }
    l = paramToServiceMsg.extraData.getLong("touin");
    i = paramFromServiceMsg.ret.get();
    paramToServiceMsg = new Bundle();
    paramToServiceMsg.putInt("ret", i);
    j = paramFromServiceMsg.id.get();
    paramToServiceMsg.putInt("fun_call_id", j);
    if (QLog.isColorLevel()) {
      QLog.d("VipSetFunCallHandler", 2, "ret=" + i + ", funcall=" + j + ", touin=" + paramFromServiceMsg.touin.get());
    }
    if ((i == 0) && (l == paramFromServiceMsg.touin.get()))
    {
      paramFromServiceMsg = (VipFunCallManager)this.b.getManager(79);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(j);
      }
      a(1, true, paramToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler
 * JD-Core Version:    0.7.0.1
 */