package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.data.Friends;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.VipUserInfo;
import mqq.app.MobileQQ;

public class VipInfoHandler
  extends BusinessHandler
{
  static int a = 0;
  public static final String a = "ClubInfoSvc.GetVipInfoReq";
  static String b;
  static String c;
  static String d;
  private static String e = "VipInfoHandler";
  
  static
  {
    b = "k_uin";
    c = "k_type";
    d = "k_skey";
    jdField_a_of_type_Int = 1;
  }
  
  VipInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo == null) || (paramInt1 > 2) || (paramInt1 < 1)) {
      return paramInt2;
    }
    if (1 == paramInt1) {}
    for (paramInt1 = paramVipUserInfo.iOpenVip;; paramInt1 = paramVipUserInfo.iOpenSVip) {
      return (paramInt1 << 8 | (byte)paramVipUserInfo.iVipType) << 16 | (short)paramVipUserInfo.iVipLevel;
    }
  }
  
  protected Class a()
  {
    return VipInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    int i = Integer.valueOf(paramToServiceMsg.extraData.getInt(c)).intValue();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.GetVipInfoReq".equals(localObject))
    {
      bool2 = bool1;
      if (i == jdField_a_of_type_Int)
      {
        if (!bool1) {
          break label279;
        }
        localObject = paramToServiceMsg.extraData.getString(b);
        paramToServiceMsg = (VipUserInfo)paramObject;
        if ((paramToServiceMsg == null) || (paramToServiceMsg.iOpenVip < 0) || (paramToServiceMsg.iOpenSVip < 0)) {
          break label273;
        }
        paramFromServiceMsg = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject = paramFromServiceMsg.b((String)localObject);
        ((Friends)localObject).qqVipInfo = a(paramToServiceMsg, 1, ((Friends)localObject).qqVipInfo);
        ((Friends)localObject).superVipInfo = a(paramToServiceMsg, 2, ((Friends)localObject).superVipInfo);
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        localSharedPreferences.edit().putLong("sp_vip_info_request_time", paramToServiceMsg.iUpdateTime);
        localSharedPreferences.edit().putInt("sp_vip_info_update_freq", paramToServiceMsg.iUpdateFreq);
        localSharedPreferences.edit().commit();
        paramFromServiceMsg.a((Friends)localObject);
      }
    }
    for (boolean bool2 = bool1;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(e, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool2);
      }
      a(jdField_a_of_type_Int, bool2, paramObject);
      return;
      label273:
      bool1 = false;
      break;
      label279:
      ReportCenter.a().a("ClubInfoSvc.GetVipInfoReq", 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[CMD:ClubInfoSvc.GetVipInfoReqfailed]", true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ClubInfoSvc.GetVipInfoReq");
    localToServiceMsg.extraData.putString(b, paramString2);
    localToServiceMsg.extraData.putInt(c, jdField_a_of_type_Int);
    localToServiceMsg.extraData.putString(d, paramString1);
    a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.GetVipInfoReq");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler
 * JD-Core Version:    0.7.0.1
 */