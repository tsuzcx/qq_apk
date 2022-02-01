package com.tencent.mobileqq.service.qwallet;

import VIP.ReqCheckPayAuth;
import VIP.ReqGetApiList;
import VIP.ReqGetOpenId;
import VIP.RespCheckPayAuth;
import VIP.RespGetApiList;
import VIP.RespGetOpenId;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletOpenService
  extends BaseProtocolCoder
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qwallet.open.OpenPayService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    a = new String[] { "OpenPayServer" };
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespGetOpenId)paramToServiceMsg.getByClass("resp", new RespGetOpenId());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.OpenPayObj");
    paramUniPacket.setFuncName("getOpenId");
    paramUniPacket.put("req", (ReqGetOpenId)paramToServiceMsg.extraData.getSerializable("reqGetOpenId"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespGetApiList)paramToServiceMsg.getByClass("resp", new RespGetApiList());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.OpenPayObj");
    paramUniPacket.setFuncName("getApiList");
    paramUniPacket.put("req", (ReqGetApiList)paramToServiceMsg.extraData.getSerializable("reqGetApiList"));
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespCheckPayAuth)paramToServiceMsg.getByClass("resp", new RespCheckPayAuth());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.open.OpenPayService", 4, "decodeRecommentWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.OpenPayObj");
    paramUniPacket.setFuncName("checkPayAuth");
    paramUniPacket.put("req", (ReqCheckPayAuth)paramToServiceMsg.extraData.getSerializable("reqCheckPayAuth"));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      if (str.compareTo("OpenPayServer.getOpenId") == 0) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
      if (str.compareTo("OpenPayServer.getApiList") == 0) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (str.compareTo("OpenPayServer.checkPayAuth") != 0);
    return d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (str.compareTo("OpenPayServer.getOpenId") == 0) {
        return b(paramToServiceMsg, paramUniPacket);
      }
      if (str.compareTo("OpenPayServer.getApiList") == 0) {
        return c(paramToServiceMsg, paramUniPacket);
      }
    } while (str.compareTo("OpenPayServer.checkPayAuth") != 0);
    return d(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.QWalletOpenService
 * JD-Core Version:    0.7.0.1
 */