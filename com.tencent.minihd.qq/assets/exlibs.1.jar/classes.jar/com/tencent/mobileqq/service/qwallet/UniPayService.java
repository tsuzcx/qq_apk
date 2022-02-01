package com.tencent.mobileqq.service.qwallet;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class UniPayService
  extends BaseProtocolCoder
{
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (UniPayResponse)paramToServiceMsg.getByClass("stResponse", new UniPayResponse());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      return null;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.VipSTCheckServer.VipSTCheckObj");
    paramUniPacket.setFuncName("mobileUniPayCheck");
    paramUniPacket.put("stRequest", (UniPayRequest)paramToServiceMsg.extraData.getSerializable("UniPayRequest"));
    return true;
  }
  
  public String[] a()
  {
    return new String[] { "VipSTCheckServer" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.UniPayService
 * JD-Core Version:    0.7.0.1
 */