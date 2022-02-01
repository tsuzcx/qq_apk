package com.tencent.mobileqq.utils.sso;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.qlsBusiness.sso_svrr.QLSSsoBSvrHeader;
import com.tencent.pb.qlsBusiness.sso_svrr.QLSSsoBSvrOpenId2UinReq;
import com.tencent.pb.qlsBusiness.sso_svrr.QLSSsoBSvrOpenId2UinRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class SsosvrrHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "qq_life_service.business_msg";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 70001;
  
  public SsosvrrHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return SsosvrrObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    SsosvrrObserver.SsosvrrData localSsosvrrData = new SsosvrrObserver.SsosvrrData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(70001, false, localSsosvrrData);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(70001, false, localSsosvrrData);
      return;
    }
    paramToServiceMsg = new sso_svrr.QLSSsoBSvrOpenId2UinRsp();
    try
    {
      paramToServiceMsg = (sso_svrr.QLSSsoBSvrOpenId2UinRsp)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(70001, false, localSsosvrrData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      a(70001, false, localSsosvrrData);
      return;
    }
    localSsosvrrData.b = paramToServiceMsg.appid.get();
    localSsosvrrData.jdField_a_of_type_JavaLangString = paramToServiceMsg.openid.get();
    localSsosvrrData.c = paramToServiceMsg.qquin.get();
    localSsosvrrData.jdField_a_of_type_Int = paramToServiceMsg.header.subcmd.get();
    localSsosvrrData.d = paramToServiceMsg.result.get();
    a(70001, true, localSsosvrrData);
  }
  
  public void a(String paramString, int paramInt)
  {
    sso_svrr.QLSSsoBSvrOpenId2UinReq localQLSSsoBSvrOpenId2UinReq = new sso_svrr.QLSSsoBSvrOpenId2UinReq();
    sso_svrr.QLSSsoBSvrHeader localQLSSsoBSvrHeader = new sso_svrr.QLSSsoBSvrHeader();
    localQLSSsoBSvrHeader.subcmd.set(1);
    localQLSSsoBSvrOpenId2UinReq.header.set(localQLSSsoBSvrHeader);
    localQLSSsoBSvrOpenId2UinReq.openid.set(paramString);
    localQLSSsoBSvrOpenId2UinReq.appid.set(paramInt);
    paramString = a("qq_life_service.business_msg");
    paramString.setTimeout(5000L);
    paramString.putWupBuffer(localQLSSsoBSvrOpenId2UinReq.toByteArray());
    b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.sso.SsosvrrHandler
 * JD-Core Version:    0.7.0.1
 */