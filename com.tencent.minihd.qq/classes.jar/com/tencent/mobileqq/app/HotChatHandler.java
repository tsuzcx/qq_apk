package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.JoinPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetHotChatList.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.oidb_0x8a8.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class HotChatHandler
  extends BusinessHandler
{
  public static final int a = 2;
  public static final String a = "退出热聊失败";
  public static final int b = 11;
  public static final String b = "退出热聊成功";
  public static final int c = 12;
  private static final String c = HotChatHandler.class.getSimpleName();
  private volatile boolean a;
  
  HotChatHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static String a()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(5, 1);
    localDate = localCalendar.getTime();
    return new SimpleDateFormat("yyyyMMdd").format(localDate);
  }
  
  private void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "joinHotChat()");
    }
    Object localObject1 = new oidb_0x89b.JoinPublicGroupReqBody();
    ((oidb_0x89b.JoinPublicGroupReqBody)localObject1).uint64_visitor_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    if (paramHotChatInfo.isWifiHotChat)
    {
      localObject2 = a();
      if (localObject2 != null)
      {
        ((oidb_0x89b.JoinPublicGroupReqBody)localObject1).setHasFlag(true);
        ((oidb_0x89b.JoinPublicGroupReqBody)localObject1).wifi_info.set((MessageMicro)localObject2);
      }
    }
    Object localObject2 = new oidb_0x89b.ReqBody();
    ((oidb_0x89b.ReqBody)localObject2).uint64_group_code.set(a(paramHotChatInfo.troopUin));
    ((oidb_0x89b.ReqBody)localObject2).uint32_req_type.set(4);
    ((oidb_0x89b.ReqBody)localObject2).msg_join_group.set((MessageMicro)localObject1);
    if (paramHotChatInfo.isWifiHotChat) {
      i = 1;
    }
    ((oidb_0x89b.ReqBody)localObject2).uint32_hot_group_type.set(i);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2203);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89b.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x89b_3");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putSerializable("HOT_CHAT_INFO", paramHotChatInfo);
    ((ToServiceMsg)localObject2).extraData.putBoolean("isJoin", true);
    ((ToServiceMsg)localObject2).extraData.putInt("preHotChatState", paramInt);
    ((ToServiceMsg)localObject2).setTimeout(10000L);
    b((ToServiceMsg)localObject2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "<<---handleError serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a3".equals(str)) {}
    do
    {
      return;
      if ("OidbSvc.0x8a4".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, false);
        return;
      }
      if ("OidbSvc.0x89b_3".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("isJoin"))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a2".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a8".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x8ab".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "handleGetMyHostChatListRespError timeOut: " + paramBoolean);
    }
    a(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(null);
    }
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "createHotChat() hotchat = " + paramWifiPOIInfo);
    }
    HotChatInfo localHotChatInfo = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean);
    Object localObject = new CreateHotChat.ReqBody();
    ((CreateHotChat.ReqBody)localObject).create_req_info.setHasFlag(true);
    ((CreateHotChat.ReqBody)localObject).create_req_info.set(paramWifiPOIInfo);
    paramWifiPOIInfo = new oidb_sso.OIDBSSOPkg();
    paramWifiPOIInfo.uint32_command.set(2210);
    paramWifiPOIInfo.uint32_result.set(0);
    if (paramBoolean)
    {
      LBS.LBSInfo localLBSInfo = a(true);
      i = j;
      if (localLBSInfo != null) {
        ((CreateHotChat.ReqBody)localObject).lbs_info.set(localLBSInfo);
      }
    }
    for (int i = j;; i = 0)
    {
      paramWifiPOIInfo.uint32_service_type.set(i);
      paramWifiPOIInfo.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((CreateHotChat.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x8a2");
      ((ToServiceMsg)localObject).putWupBuffer(paramWifiPOIInfo.toByteArray());
      ((ToServiceMsg)localObject).extraData.putSerializable("HOT_CHAT_INFO", localHotChatInfo);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a3".equals(str)) {
      f(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("OidbSvc.0x8a4".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, true);
        return;
      }
      if ("OidbSvc.0x89b_3".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("isJoin"))
        {
          d(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a2".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a8".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"OidbSvc.0x8ab".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    a(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), "退出热聊失败" });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "handleExitHotChatResp()");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1033, false, new Object[] { str, "退出热聊失败" });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(1033, false, new Object[] { str, "退出热聊失败" });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        a(1033, false, new Object[] { str, "退出热聊失败" });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "handleExitHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
        paramFromServiceMsg = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
        paramFromServiceMsg.a(paramFromServiceMsg.a(str), paramToServiceMsg);
        a(1033, true, new Object[] { str, "退出热聊成功" });
        return;
      }
      a(1033, false, new Object[] { str, "退出热聊失败" });
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    a(1032, false, new Object[] { paramToServiceMsg.troopUin, "加入热聊失败，请稍后再试。", paramToServiceMsg.name });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, "加热聊失败", localHotChatInfo.name });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加热聊失败", localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加热聊失败", localHotChatInfo.name });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "handleJoinHotChatResp result " + i);
      }
      if (i == 0)
      {
        i = paramToServiceMsg.extraData.getInt("preHotChatState");
        paramToServiceMsg = new oidb_0x89b.RspBody();
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.uint64_group_uin.get();
          localHotChatInfo.troopUin = String.valueOf(paramToServiceMsg.uint64_group_code.get());
          localHotChatInfo.troopCode = String.valueOf(l);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(localHotChatInfo, i);
          a(1032, true, new Object[] { "加群成功", localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(localHotChatInfo.isWifiHotChat) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          a(1032, false, new Object[] { localHotChatInfo.troopUin, "加热聊失败", localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1282: 
      case 1283: 
      case 1285: 
      case 1287: 
      default: 
        paramToServiceMsg = "加入热聊失败，请稍后再试。";
      }
    }
    for (;;)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = "该热聊已满员，换个热聊试试吧。";
      continue;
      paramToServiceMsg = "你加入的热聊已达到数量上限，请退出其他热聊后再试。";
      continue;
      paramToServiceMsg = "由于你发表了不良信息，暂不允许加入热聊。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    a(1032, false, new Object[] { paramToServiceMsg.troopUin, "加入热聊失败，请稍后再试。", paramToServiceMsg.name });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
      }
      if (!paramToServiceMsg.uint32_result.has())
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
        return;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "handleCreateHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramFromServiceMsg = new CreateHotChat.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = Utils.a(paramFromServiceMsg.uint32_group_code.get());
          long l2 = Utils.a(paramFromServiceMsg.uint32_group_uin.get());
          localHotChatInfo.troopUin = String.valueOf(l1);
          localHotChatInfo.troopCode = String.valueOf(l2);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(localHotChatInfo, 4);
          a(1032, true, new Object[] { "加群成功", localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1284: 
      case 1285: 
      case 1286: 
      case 1287: 
      case 1288: 
      case 1289: 
      default: 
        paramToServiceMsg = "加入热聊失败，请稍后再试。";
      }
    }
    for (;;)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = "你加入的热聊已达到数量上限，请退出其他热聊后再试。";
      continue;
      paramToServiceMsg = "由于你发表了不良信息，暂不允许加入热聊。";
      continue;
      paramToServiceMsg = "退出热聊失败，请稍后再试。";
      continue;
      paramToServiceMsg = "获取位置失败，无法加入热聊。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1030, false, new Object[] { Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("ONLY_WIFI", false)) });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    paramToServiceMsg = new GetJoinedHotChatList.RspBody();
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label289;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label283;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {}
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "handleGetMyHotChatListResp isSuccess: " + bool + ", result:" + i);
          }
          if (paramToServiceMsg == null) {
            break label269;
          }
          paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
          paramToServiceMsg = new ArrayList();
          if (paramFromServiceMsg == null) {
            continue;
          }
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          if (!paramFromServiceMsg.hasNext()) {
            continue;
          }
          paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
          if (paramObject.uint32_wifi_poi_type.get() != 1) {
            continue;
          }
          bool = true;
          paramToServiceMsg.add(HotChatInfo.createHotChat(paramObject, bool));
          continue;
          bool = false;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        i = 0;
        bool = false;
        paramToServiceMsg = null;
        continue;
        bool = false;
        continue;
        ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(paramToServiceMsg);
        a(1031, true, null);
        return;
      }
      label269:
      a(1031, false, null);
      return;
      label283:
      int i = 0;
      continue;
      label289:
      i = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleReportWifiRespErrorOrTimeOut");
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    System.out.println("-----> handleReportWifi");
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = null;
    localHotChatManager = null;
    str = paramToServiceMsg.extraData.getString("hotnamecode");
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getResultCode() != 1000) {
          continue;
        }
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        int j;
        try
        {
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (!paramObject.poi_info.has()) {
            continue;
          }
          paramToServiceMsg = (Common.WifiPOIInfo)paramObject.poi_info.get();
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
        }
        try
        {
          if (!paramObject.join_poi_status.has()) {
            continue;
          }
          i = paramObject.join_poi_status.get();
          paramFromServiceMsg = localHotChatManager;
          if (paramToServiceMsg != null)
          {
            paramObject = HotChatInfo.createHotChat(paramToServiceMsg, false);
            if (i != 1) {
              continue;
            }
            ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(paramObject, 4);
            paramFromServiceMsg = paramObject;
          }
          a(1034, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i), str });
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "handleQuickJoinHotChat, " + j + "," + paramFromServiceMsg + "," + paramToServiceMsg);
          }
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          continue;
        }
        paramObject = paramObject;
        paramToServiceMsg = null;
        paramFromServiceMsg = paramToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(c, 2, paramObject.toString());
        paramFromServiceMsg = paramToServiceMsg;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, paramFromServiceMsg.toString());
        }
        int i = 0;
        continue;
        paramFromServiceMsg = paramObject;
        if (i != 2) {
          continue;
        }
        localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
        paramFromServiceMsg = paramObject;
        if (localHotChatManager.a(paramObject.troopUin) != null) {
          continue;
        }
        localHotChatManager.a(paramObject, 4);
        paramFromServiceMsg = paramObject;
        continue;
        a(1034, false, new Object[] { null, null, Integer.valueOf(j), str });
        paramToServiceMsg = null;
        paramFromServiceMsg = localObject;
        continue;
        paramToServiceMsg = null;
        continue;
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg;
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          continue;
        }
        j = paramFromServiceMsg.uint32_result.get();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        continue;
        i = 0;
        continue;
        paramToServiceMsg = null;
        continue;
        j = -2147483648;
      }
    }
    if (j == 0) {
      paramObject = new oidb_0x8ab.RspBody();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  protected Class a()
  {
    return HotChatObserver.class;
  }
  
  public LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    SosoInterface.a(60000L, getClass().getSimpleName());
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    Object localObject2 = new LBS.GPS();
    ((LBS.GPS)localObject2).latitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
    ((LBS.GPS)localObject2).longitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
    ((LBS.GPS)localObject2).altitude.set(-1);
    ((LBS.GPS)localObject2).coordinate.set(0);
    localLBSInfo.gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        LBS.Wifi localWifi = new LBS.Wifi();
        localWifi.mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
        localWifi.rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
        localLBSInfo.rpt_wifi.add(localWifi);
      }
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localObject3 = new LBS.Cell();
        ((LBS.Cell)localObject3).mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
        ((LBS.Cell)localObject3).mnc.set(((SosoInterface.SosoCell)localObject2).b);
        ((LBS.Cell)localObject3).lac.set(((SosoInterface.SosoCell)localObject2).c);
        ((LBS.Cell)localObject3).cellid.set(((SosoInterface.SosoCell)localObject2).d);
        ((LBS.Cell)localObject3).rssi.set(((SosoInterface.SosoCell)localObject2).e);
        localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
      }
    }
    localObject1 = new LBS.Attribute();
    localObject2 = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localObject2 = DeviceInfoUtil.b();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localLBSInfo.attribute.set((MessageMicro)localObject1);
    return localLBSInfo;
  }
  
  public LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = ((WifiManager)localObject1).getConnectionInfo();
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoInterface.SosoWifi.a(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return localObject2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "getMyHotChatList()");
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x8a4");
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    GetJoinedHotChatList.ReqBody localReqBody = new GetJoinedHotChatList.ReqBody();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_req_type.set(3);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2212);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "exitHotChat() hotchat = " + paramHotChatInfo);
    }
    if (paramHotChatInfo == null)
    {
      a(1033, false, new Object[] { "", "退出热聊失败" });
      return;
    }
    Object localObject2 = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject2).uint64_visitor_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject1 = new oidb_0x89b.ReqBody();
    ((oidb_0x89b.ReqBody)localObject1).uint64_group_code.set(a(paramHotChatInfo.troopUin));
    ((oidb_0x89b.ReqBody)localObject1).uint32_req_type.set(5);
    ((oidb_0x89b.ReqBody)localObject1).msg_exit_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2203);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89b.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x89b_3");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramHotChatInfo.troopUin);
    ((ToServiceMsg)localObject1).extraData.putSerializable("targetHotChatState", paramHotChatStateWrapper);
    ((ToServiceMsg)localObject1).setTimeout(10000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a3".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a4".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x89b_3".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("isJoin"))
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a2".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a8".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x8ab".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x8ab");
    localToServiceMsg.extraData.putString("hotnamecode", paramString);
    oidb_0x8ab.ReqBody localReqBody = new oidb_0x8ab.ReqBody();
    localReqBody.hotnamecode.set(paramString);
    paramString = a(false);
    if (paramString != null) {
      localReqBody.lbs_info.set(paramString);
    }
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2219);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
  }
  
  public void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i(c, 2, "joinHotChat() WifiPOIInfo = " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + ", " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8());
      label64:
      int i;
      if (!paramWifiPOIInfo.uint32_group_uin.has()) {
        i = j;
      }
      while (i != 0)
      {
        a(paramWifiPOIInfo, paramBoolean);
        return;
        String str = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
        i = j;
        if (str != null)
        {
          i = j;
          if (!str.equals(""))
          {
            i = j;
            if (!str.equals("0")) {
              i = 0;
            }
          }
        }
      }
      a(HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean), paramInt);
      return;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "getHotChatList() onlyWifi = " + paramBoolean1 + ", getCityWifiSwitch = " + paramBoolean2);
    }
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x8a3");
    localToServiceMsg.extraData.putBoolean("ONLY_WIFI", paramBoolean1);
    GetHotChatList.ReqBody localReqBody = new GetHotChatList.ReqBody();
    localReqBody.get_wifi_group.set(1);
    if (!paramBoolean1) {
      localReqBody.get_poi_group.set(1);
    }
    for (;;)
    {
      Object localObject = a();
      if (localObject != null) {
        localReqBody.joined_wifi.set((MessageMicro)localObject);
      }
      localObject = a(paramBoolean1);
      if (localObject != null) {
        localReqBody.lbs_info.set((MessageMicro)localObject);
      }
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2211);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(i);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      localToServiceMsg.setTimeout(30000L);
      b(localToServiceMsg);
      return;
      if (paramBoolean2) {
        localReqBody.uint32_msg_tab_switch_off_all.set(1);
      }
      i = 2;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x89b_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a8");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8ab");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(LBS.Wifi paramWifi)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("qb_hc_hotchat_global", 0);
    String str2 = localSharedPreferences.getString("qb_hc_report_wifi_cache2", "");
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "isTodayWiFiReported wifiCache = " + str2);
    }
    String str1 = MD5Utils.b("" + paramWifi.essid.get().toStringUtf8() + paramWifi.mac.get());
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str2))
        {
          paramWifi = new JSONObject();
          long l1 = paramWifi.optLong(str1, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 <= 86400000L) {
            continue;
          }
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {}
        }
      }
      catch (Exception paramWifi)
      {
        long l2;
        bool1 = false;
      }
      try
      {
        paramWifi.put(str1, l2);
        localSharedPreferences.edit().putString("qb_hc_report_wifi_cache2", paramWifi.toString()).commit();
        bool2 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "isTodayWiFiReported isNeed = " + bool2);
        }
        return bool2;
      }
      catch (Exception paramWifi)
      {
        break label255;
      }
      paramWifi = new JSONObject(str2);
      continue;
      boolean bool1 = false;
      continue;
      label255:
      paramWifi.printStackTrace();
      localSharedPreferences.edit().putString("qb_hc_report_wifi_cache2", "").commit();
      boolean bool2 = bool1;
    }
  }
  
  public void b() {}
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, paramFromServiceMsg.toString());
    }
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("ONLY_WIFI", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1030, false, new Object[] { Boolean.valueOf(bool2) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label86:
      break label86;
    }
    int i = paramToServiceMsg.uint32_result.get();
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "handleGetHotChatListResp result " + i);
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      a(1030, false, new Object[] { Boolean.valueOf(bool2) });
      return;
    }
    if (i == 0) {
      paramObject = new GetHotChatList.RspBody();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramObject.uint32_msg_tab_switch_off_all.has()) {
          break label361;
        }
        if (paramObject.uint32_msg_tab_switch_off_all.get() != 1) {
          break label355;
        }
        bool1 = true;
        paramFromServiceMsg = Boolean.valueOf(bool1);
        if (!paramObject.wifi_info.has()) {
          break label395;
        }
        paramToServiceMsg = (Common.WifiPOIInfo)paramObject.wifi_info.get();
        if ((paramToServiceMsg == null) || (!TextUtils.isEmpty(paramToServiceMsg.bytes_name.get().toStringUtf8()))) {
          break label392;
        }
        paramToServiceMsg = null;
        if (!paramObject.poi_info_list.has()) {
          break label387;
        }
        paramObject = paramObject.poi_info_list.get();
        a(1030, true, new Object[] { Boolean.valueOf(bool2), paramFromServiceMsg, paramToServiceMsg, paramObject });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        a(1030, false, new Object[] { Boolean.valueOf(bool2) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(c, 2, "handleGetHotChatListResp exception", paramToServiceMsg);
      return;
      label355:
      boolean bool1 = false;
      continue;
      label361:
      paramFromServiceMsg = null;
      continue;
      a(1030, false, new Object[] { Boolean.valueOf(bool2) });
      return;
      label387:
      paramObject = null;
      continue;
      label392:
      continue;
      label395:
      paramToServiceMsg = null;
    }
  }
  
  public void c() {}
  
  public void d()
  {
    if (!NetworkUtil.g(BaseApplication.getContext())) {
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "reportWifi no wifi connect");
      }
    }
    do
    {
      do
      {
        return;
        localObject = a();
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(c, 2, "reportWifi no wifiInfo getted");
      return;
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "reportWifi call wifi = " + localObject);
      }
      if (!a((LBS.Wifi)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(c, 2, "reportWifi already report today");
    return;
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x8a8");
    oidb_0x8a8.ReqBody localReqBody = new oidb_0x8a8.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.joined_wifi.set((MessageMicro)localObject);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2216);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(10000L);
    b(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHandler
 * JD-Core Version:    0.7.0.1
 */