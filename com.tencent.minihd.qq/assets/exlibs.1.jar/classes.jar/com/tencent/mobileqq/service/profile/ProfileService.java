package com.tencent.mobileqq.service.profile;

import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.ReqGetSettings;
import GeneralSettings.ReqHeader;
import GeneralSettings.ReqSetSettings;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespHeader;
import GeneralSettings.RespSetSettings;
import GeneralSettings.RespUpgradeSettings;
import KQQ.ChangeFriendNameReq;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateReq;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigReq;
import KQQ.GetRichSigRes;
import KQQ.GroupMngReq;
import KQQ.ProfFriendInfoReq;
import KQQ.ProfFullUsrQryReq;
import KQQ.ProfGroupInfoReq;
import KQQ.ProfGroupInfoRes;
import KQQ.ProfIncInfoReq;
import KQQ.ProfSmpInfoRes;
import KQQ.ProfUsrFullInfoRes;
import KQQ.ProfUsrQryReq;
import KQQ.ProfVipqqInfoReq;
import KQQ.ProfVipqqInfoRes;
import KQQ.ReqItem;
import KQQ.ReqRichInfo;
import KQQ.SetRichSigReq;
import KQQ.SetRichSigRes;
import KQQ.SetUserInfoReq;
import KQQ.SetUserInfoResp;
import KQQ.SyncRes;
import KQQ.WeatherInfoReq;
import QQService.SvcReqBindUin;
import QQService.SvcReqDelLoginInfo;
import QQService.SvcReqGetDevLoginInfo;
import QQService.SvcReqKikOut;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import ResPackage.ReqResOrder;
import ResPackage.ReqResUpdate;
import ResPackage.RspResOrder;
import ResPackage.RspResUpdate;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.troop.TroopService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ProfileService
  extends BaseProtocolCoder
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "ProfileService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ProfileService", "StatSvc", "AvatarInfoSvr", "NickQuerySvc", "GetAvatarInfo", "ChatAvatar" };
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 7;
  private static final int g = 8;
  private static final int h = 9;
  private static final int i = 10;
  private static final int j = 11;
  private static final int k = 12;
  private static final int l = 13;
  private static final int m = 14;
  private static final int n = 15;
  private static final int o = 16;
  private static final int p = 17;
  private static final int q = 18;
  private static final int r = 22;
  private static final int s = 23;
  private static final int t = 24;
  private static final int u = 25;
  private static final int v = 26;
  private static final int w = 27;
  private static final int x = 28;
  private static final int y = 29;
  private static final int z = 30;
  private int A = 0;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TroopService jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService;
  
  public ProfileService(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GetWeatherInfo", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GetSimpleInfo", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GetRichSig", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.ReqGetSettings", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.ReqSetSettings", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.SetRichSig", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.ChangeFriendName", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GetSglUsrFullInfo", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.SetUserInfoReq", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GetProfIncInfo", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.ProfVipqqInfo", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilHashMap.put("AvatarInfoSvr.QQHeadUrlReq", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.getFriendInfoReq", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.getGroupInfoReq", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.GroupMngReq", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.CheckUpdateReq", Integer.valueOf(23));
    this.jdField_a_of_type_JavaUtilHashMap.put("ChatAvatar.ReqResOrder", Integer.valueOf(24));
    this.jdField_a_of_type_JavaUtilHashMap.put("ChatAvatar.ReqResUpdate", Integer.valueOf(25));
    this.jdField_a_of_type_JavaUtilHashMap.put("StatSvc.GetDevLoginInfo", Integer.valueOf(26));
    this.jdField_a_of_type_JavaUtilHashMap.put("StatSvc.DelDevLoginInfo", Integer.valueOf(27));
    this.jdField_a_of_type_JavaUtilHashMap.put("StatSvc.SvcReqKikOut", Integer.valueOf(28));
    this.jdField_a_of_type_JavaUtilHashMap.put("StatSvc.BindUin", Integer.valueOf(29));
    this.jdField_a_of_type_JavaUtilHashMap.put("ProfileService.ReqBatchProcess", Integer.valueOf(30));
    this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService = new TroopService(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a();
  }
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 8;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    localGroupMngReq.wSourceSubID = 32;
    localGroupMngReq.wSourceID = 3;
    Object localObject = paramToServiceMsg.extraData.getStringArrayList("Invite_uins");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(((ArrayList)localObject).size() * 4 + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putShort((short)((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localByteBuffer.putInt((int)a((String)((Iterator)localObject).next()));
    }
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopReport", 4, "handleInviteGroup: wSourceSubID=" + localGroupMngReq.wSourceSubID);
    }
    return true;
  }
  
  private boolean B(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 9;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean C(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 3;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    Object localObject = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    paramToServiceMsg = ByteBuffer.allocate(((ArrayList)localObject).size() * 4 + 8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramToServiceMsg.putInt((int)a((String)((Iterator)localObject).next()));
    }
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean D(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 4;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean E(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 5;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean F(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 6;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean G(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 7;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l1 = Long.parseLong(paramString);
        if (l1 >= 10000L) {
          return l1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetSimpleInfo");
    int i1;
    int i2;
    if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
    {
      i1 = 1;
      if (!paramToServiceMsg.extraData.getBoolean("reqXMan", false)) {
        break label102;
      }
      i2 = 1;
      label48:
      if (!paramToServiceMsg.extraData.getBoolean("reqDateNick", false)) {
        break label108;
      }
    }
    label102:
    label108:
    for (byte b1 = 1;; b1 = 0)
    {
      paramUniPacket.put("req", new ProfUsrQryReq(0, "", paramArrayList, 1, 1, (byte)0, i1, i2, (byte)1, b1));
      return true;
      i1 = 0;
      break;
      i2 = 0;
      break label48;
    }
  }
  
  private boolean a(String paramString, UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetWeatherInfo");
    int i1 = this.A;
    this.A = (i1 + 1);
    paramUniPacket.put("req", new WeatherInfoReq(i1, "", paramString));
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg) {}
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspGetDevLoginInfo)a(paramFromServiceMsg.getWupBuffer(), "SvcRspGetDevLoginInfo", new SvcRspGetDevLoginInfo());
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResUpdate");
    ReqResUpdate localReqResUpdate = new ReqResUpdate();
    localReqResUpdate.SeqID = paramToServiceMsg.extraData.getInt("seq_id", 0);
    localReqResUpdate.ResID = paramToServiceMsg.extraData.getInt("ResID", 2);
    paramUniPacket.put("ReqResUpdate", localReqResUpdate);
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspDelLoginInfo)a(paramFromServiceMsg.getWupBuffer(), "SvcRspDelLoginInfo", new SvcRspDelLoginInfo());
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResOrder");
    ReqResOrder localReqResOrder = new ReqResOrder();
    localReqResOrder.ResID = 1;
    localReqResOrder.Path = Integer.toString(paramToServiceMsg.extraData.getInt("req_res_order_pkgid", 0));
    paramUniPacket.put("ReqResOrder", localReqResOrder);
    return true;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespKikOut)a(paramFromServiceMsg.getWupBuffer(), "resp", new SvcRespKikOut());
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq called");
    }
    CheckUpdateReq localCheckUpdateReq = new CheckUpdateReq();
    localCheckUpdateReq.isSupportSubPack = true;
    localCheckUpdateReq.vecReqPkg = new ArrayList();
    int i1 = ((Integer)paramToServiceMsg.getAttribute("CheckUpdateType", Integer.valueOf(0))).intValue();
    paramToServiceMsg = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a.a().entrySet().iterator();
    while (paramToServiceMsg.hasNext())
    {
      Object localObject = (Map.Entry)paramToServiceMsg.next();
      Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
      localObject = (CheckUpdateItemInterface)((Map.Entry)localObject).getValue();
      if ((((CheckUpdateItemInterface)localObject).a() & i1) != 0)
      {
        localObject = ((CheckUpdateItemInterface)localObject).a();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq item:eServiceId=" + ((ReqItem)localObject).eServiceID + ",cOperType=" + ((ReqItem)localObject).cOperType);
          }
          localCheckUpdateReq.vecReqPkg.add(localObject);
        }
      }
    }
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("CheckUpdateReq");
    paramUniPacket.put("CheckUpdateReq", localCheckUpdateReq);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspBindUin)a(paramFromServiceMsg.getWupBuffer(), "SvcRspBindUin", new SvcRspBindUin());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqGetDevLoginInfo");
    SvcReqGetDevLoginInfo localSvcReqGetDevLoginInfo = new SvcReqGetDevLoginInfo();
    localSvcReqGetDevLoginInfo.iLoginType = paramToServiceMsg.extraData.getLong("iLoginType");
    localSvcReqGetDevLoginInfo.iNextItemIndex = paramToServiceMsg.extraData.getLong("iNextItemIndex");
    localSvcReqGetDevLoginInfo.iRequireMax = paramToServiceMsg.extraData.getLong("iRequireMax");
    localSvcReqGetDevLoginInfo.iTimeStamp = paramToServiceMsg.extraData.getLong("iTimeStamp");
    localSvcReqGetDevLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqGetDevLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqGetDevLoginInfo.iGetDevListType = paramToServiceMsg.extraData.getLong("iGetDevListType");
    paramUniPacket.put("SvcReqGetDevLoginInfo", localSvcReqGetDevLoginInfo);
    return true;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfGroupInfoRes)a(paramFromServiceMsg.getWupBuffer(), "res", new ProfGroupInfoRes());
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqDelLoginInfo");
    SvcReqDelLoginInfo localSvcReqDelLoginInfo = new SvcReqDelLoginInfo();
    localSvcReqDelLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqDelLoginInfo.vecDeviceItemDes = ((ArrayList)paramToServiceMsg.getAttribute("vecDeviceItemDes"));
    paramToServiceMsg.addAttribute("vecDeviceItemDes", null);
    localSvcReqDelLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqDelLoginInfo.iDelType = paramToServiceMsg.extraData.getInt("iDelType");
    localSvcReqDelLoginInfo.iDelMe = paramToServiceMsg.extraData.getInt("iDelMe");
    localSvcReqDelLoginInfo.iAppId = paramToServiceMsg.extraData.getLong("iAppId");
    paramUniPacket.put("SvcReqDelLoginInfo", localSvcReqDelLoginInfo);
    return true;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfVipqqInfoRes)a(paramFromServiceMsg.getWupBuffer(), "res", new ProfVipqqInfoRes());
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqKikOut");
    SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut();
    localSvcReqKikOut.appid = paramToServiceMsg.extraData.getLong("appid");
    localSvcReqKikOut.cKeyType = paramToServiceMsg.extraData.getByte("cKeyType");
    localSvcReqKikOut.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcReqKikOut.sKey = paramToServiceMsg.extraData.getByteArray("sKey");
    paramUniPacket.put("req", localSvcReqKikOut);
    return true;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "decodeGetFullInfo() ");
    }
    return (ProfUsrFullInfoRes)a(paramFromServiceMsg.getWupBuffer(), "res", new ProfUsrFullInfoRes());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqBindUin");
    SvcReqBindUin localSvcReqBindUin = new SvcReqBindUin();
    localSvcReqBindUin.cCmd = paramToServiceMsg.extraData.getByte("cCmd");
    localSvcReqBindUin.vecBindUin = ((ArrayList)paramToServiceMsg.getAttribute("vecBindUin"));
    paramToServiceMsg.addAttribute("vecBindUin", null);
    paramUniPacket.put("SvcReqBindUin", localSvcReqBindUin);
    return true;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "decodeSetUserInfo() ");
    }
    return (SetUserInfoResp)a(paramFromServiceMsg.getWupBuffer(), "res", new SetUserInfoResp());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i1 = 0;
    String str2 = paramToServiceMsg.extraData.getString("uin");
    String str1 = paramToServiceMsg.extraData.getString("friend_uin");
    short[] arrayOfShort = paramToServiceMsg.extraData.getShortArray("fieldidlist");
    if (a(str2) == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfFriendInfoReq();
    paramToServiceMsg.cDataCode = 0;
    paramToServiceMsg.uFriendUin = a(str1);
    paramToServiceMsg.vFieldIdList = new ArrayList();
    while (i1 < arrayOfShort.length)
    {
      paramToServiceMsg.vFieldIdList.add(Short.valueOf(arrayOfShort[i1]));
      i1 += 1;
    }
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("FriendInfoReq");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramFromServiceMsg.getWupBuffer(), "SetRichSigRes", new SetRichSigRes());
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = paramToServiceMsg.extraData.getString("uin");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    if (a((String)localObject) == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    localObject = new ProfGroupInfoReq();
    ((ProfGroupInfoReq)localObject).uGroupCode = a(str);
    ((ProfGroupInfoReq)localObject).dwTimeStamp = paramToServiceMsg.extraData.getLong("groupablm_timestamp");
    ((ProfGroupInfoReq)localObject).cIsGetGroupAlbum = paramToServiceMsg.extraData.getByte("get_groupablm");
    ((ProfGroupInfoReq)localObject).wSourceID = paramToServiceMsg.extraData.getInt("cStatOption", 0);
    ((ProfGroupInfoReq)localObject).cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupInfoReq");
    paramUniPacket.put("req", localObject);
    return true;
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ChangeFriendNameRes)a(paramFromServiceMsg.getWupBuffer(), "res", new ChangeFriendNameRes());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrlReq();
    JceInputStream localJceInputStream = new JceInputStream(paramToServiceMsg.extraData.getByteArray("QQHeadUrlReq"));
    localJceInputStream.setServerEncoding("UTF-8");
    localQQHeadUrlReq.readFrom(localJceInputStream);
    if ((localQQHeadUrlReq.dstUsrType < 0) && (QLog.isColorLevel())) {
      QLog.e("", 2, "==============================handleGetQQHead error! ");
    }
    paramUniPacket.setServantName("GetAvatarInfo");
    paramUniPacket.setFuncName("QQHeadUrlReq");
    paramUniPacket.put("QQHeadUrlReq", localQQHeadUrlReq);
    paramToServiceMsg.setServiceCmd("AvatarInfoSvr.QQHeadUrlReq");
    return true;
  }
  
  private Object m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramToServiceMsg = (RespSetSettings)a(paramFromServiceMsg.getWupBuffer(), "RespSetSettings", new RespSetSettings());
    if (localRespHeader == null) {
      paramToServiceMsg = null;
    }
    while (localRespHeader.Result == 0) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    if (l1 == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfVipqqInfoReq();
    paramToServiceMsg.iUin = l1;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ProfVipqqInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    return (RespUpgradeSettings)a(paramFromServiceMsg.getWupBuffer(), "RespUpgradeSettings", new RespUpgradeSettings());
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    if (l1 == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfIncInfoReq();
    paramToServiceMsg.iUin = l1;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetProfIncInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    paramToServiceMsg = (RespGetSettings)a(paramFromServiceMsg.getWupBuffer(), "RespGetSettings", new RespGetSettings());
    if (localRespHeader == null) {
      paramToServiceMsg = null;
    }
    while (localRespHeader.Result == 0) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleGetFullInfo() ");
    }
    long l1 = a((String)paramToServiceMsg.getAttribute("uin"));
    if (l1 == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    ArrayList localArrayList2 = null;
    String[] arrayOfString = (String[])paramToServiceMsg.getAttribute("array_uin");
    ArrayList localArrayList1 = localArrayList2;
    if (arrayOfString != null)
    {
      localArrayList1 = localArrayList2;
      if (arrayOfString.length > 0)
      {
        localArrayList2 = new ArrayList();
        int i1 = 0;
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i1 >= arrayOfString.length) {
            break;
          }
          long l2 = a(arrayOfString[i1]);
          if (l2 == 0L)
          {
            b(paramToServiceMsg);
            return false;
          }
          localArrayList2.add(Long.valueOf(l2));
          i1 += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleGetFullInfo() uin = " + l1);
    }
    paramToServiceMsg = new ProfFullUsrQryReq(0, "", l1, localArrayList1, 1, 1, 0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetSglUsrFullInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramFromServiceMsg.getWupBuffer(), "GetRichSigRes", new GetRichSigRes());
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.SetUserInfoReq", 2, "handleSetUserInfo()");
    }
    String str = paramToServiceMsg.getUin();
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    Byte localByte = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer[] arrayOfInteger = (Integer[])paramToServiceMsg.getAttribute("city");
    int i1;
    int i3;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes();
      i1 = localObject.length;
      i3 = i1 + 4 + 0;
    }
    for (int i4 = 1;; i4 = 0)
    {
      i1 = i3;
      int i2 = i4;
      if (localInteger != null)
      {
        i2 = i4 + 1;
        i1 = i3 + 8;
      }
      i3 = i1;
      i4 = i2;
      if (localByte != null)
      {
        i4 = i2 + 1;
        i3 = i1 + 5;
      }
      i1 = i3;
      int i5 = i4;
      if (arrayOfInteger != null)
      {
        i1 = i3;
        i5 = i4;
        if (arrayOfInteger.length == 3)
        {
          i5 = i4 + 1;
          i1 = i3 + 16;
        }
      }
      byte[] arrayOfByte = new byte[i1];
      i2 = 0;
      if (localObject != null)
      {
        short s1 = (short)localObject.length;
        PkgTools.a(arrayOfByte, 0, (short)20002);
        PkgTools.a(arrayOfByte, 2, s1);
        PkgTools.a(arrayOfByte, 4, (byte[])localObject, localObject.length);
        i2 = s1 + 4;
      }
      i1 = i2;
      if (localInteger != null)
      {
        PkgTools.a(arrayOfByte, i2, (short)20031);
        i1 = i2 + 2;
        PkgTools.a(arrayOfByte, i1, (short)4);
        i1 += 2;
        PkgTools.a(arrayOfByte, i1, localInteger.intValue());
        i1 += 4;
      }
      i2 = i1;
      if (localByte != null)
      {
        PkgTools.a(arrayOfByte, i1, (short)20009);
        i1 += 2;
        PkgTools.a(arrayOfByte, i1, (short)1);
        i1 += 2;
        arrayOfByte[i1] = Byte.valueOf((byte)(localByte.byteValue() + 1)).byteValue();
        i2 = i1 + 1;
      }
      if ((arrayOfInteger != null) && (arrayOfInteger.length == 3))
      {
        PkgTools.a(arrayOfByte, i2, (short)20032);
        i1 = i2 + 2;
        PkgTools.a(arrayOfByte, i1, (short)12);
        i1 += 2;
        PkgTools.a(arrayOfByte, i1, arrayOfInteger[0].intValue());
        i1 += 4;
        PkgTools.a(arrayOfByte, i1, arrayOfInteger[1].intValue());
        i1 += 4;
        PkgTools.a(arrayOfByte, i1, arrayOfInteger[2].intValue());
      }
      localObject = new SetUserInfoReq(Long.parseLong(str), i5, arrayOfByte);
      paramUniPacket.setServantName("ProfileService");
      paramUniPacket.setFuncName("SetUserInfoReq");
      paramUniPacket.put("req", localObject);
      paramToServiceMsg.setServiceCmd("ProfileService.SetUserInfoReq");
      return true;
      i3 = 0;
      localObject = null;
    }
  }
  
  private Object q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new ArrayList();
      paramFromServiceMsg.add(new ProfSmpInfoRes());
      return (ArrayList)paramToServiceMsg.getByClass("res", paramFromServiceMsg);
    }
    catch (Exception paramToServiceMsg)
    {
      return null;
    }
    catch (RuntimeException paramToServiceMsg) {}
    return null;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SetRichSigReq(paramToServiceMsg.extraData.getByteArray("sig_value"), paramToServiceMsg.extraData.getInt("key"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("SetRichSig");
    paramUniPacket.put("SetRichSigReq", paramToServiceMsg);
    return true;
  }
  
  private Object r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (QQHeadUrlResp)a(paramFromServiceMsg.getWupBuffer(), "QQHeadUrlResp", new QQHeadUrlResp());
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    if (l1 == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ChangeFriendNameReq(l1, paramToServiceMsg.extraData.getString("com_value"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ChangeFriendName");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResUpdate)a(paramFromServiceMsg.getWupBuffer(), "RspResUpdate", new RspResUpdate());
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    int i2 = paramToServiceMsg.extraData.getInt("reqType", 0);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("showDateNickname");
    paramToServiceMsg = new ArrayList();
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(8);
    CircleManager localCircleManager = (CircleManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(34);
    int i3 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i3)
    {
      Object localObject = arrayOfString[i1];
      long l2;
      for (;;)
      {
        try
        {
          l2 = Long.parseLong((String)localObject);
          if (i2 != 1) {
            break label171;
          }
          localObject = localCircleManager.a((String)localObject);
          if (localObject != null)
          {
            l1 = ((CircleBuddy)localObject).richTime;
            paramToServiceMsg.add(new ReqRichInfo(l2, l1));
            i1 += 1;
          }
        }
        catch (NumberFormatException paramToServiceMsg)
        {
          return false;
        }
        l1 = 0L;
      }
      label171:
      localObject = localFriendManager.a((String)localObject);
      if (localObject != null) {}
      for (long l1 = ((ExtensionInfo)localObject).richTime;; l1 = 0L)
      {
        paramToServiceMsg.add(new ReqRichInfo(l2, l1));
        break;
      }
    }
    if (i2 == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramToServiceMsg = new GetRichSigReq(paramToServiceMsg, bool1, bool2);
      paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
      paramUniPacket.setFuncName("GetRichSig");
      paramUniPacket.put("GetRichSigReq", paramToServiceMsg);
      return true;
    }
  }
  
  private Object t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResOrder)a(paramFromServiceMsg.getWupBuffer(), "RspResOrder", new RspResOrder());
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new ReqSetSettings((ArrayList)paramToServiceMsg.extraData.getSerializable("Settings"));
    ReqHeader localReqHeader = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqSetSettings");
    paramUniPacket.put("ReqHeader", localReqHeader);
    paramUniPacket.put("ReqSetSettings", paramToServiceMsg);
    return true;
  }
  
  private Object u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SyncRes)a(paramFromServiceMsg.getWupBuffer(), "SyncRes", new SyncRes());
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
    paramToServiceMsg = new ReqGetSettings(paramToServiceMsg.extraData.getInt("Revision"), (ArrayList)localObject, paramToServiceMsg.extraData.getLong("Offset"), paramToServiceMsg.extraData.getLong("Count"));
    localObject = new ReqHeader(0);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ReqGetSettings");
    paramUniPacket.put("ReqHeader", localObject);
    paramUniPacket.put("ReqGetSettings", paramToServiceMsg);
    return true;
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (a(paramToServiceMsg.extraData.getString("uin")) == 0L)
    {
      b(paramToServiceMsg);
      return false;
    }
    switch (paramToServiceMsg.extraData.getInt("groupreqtype"))
    {
    default: 
      b(paramToServiceMsg);
      return false;
    case 0: 
      return w(paramToServiceMsg, paramUniPacket);
    case 1: 
      return x(paramToServiceMsg, paramUniPacket);
    case 2: 
      return y(paramToServiceMsg, paramUniPacket);
    case 3: 
      return C(paramToServiceMsg, paramUniPacket);
    case 4: 
      return D(paramToServiceMsg, paramUniPacket);
    case 5: 
      return E(paramToServiceMsg, paramUniPacket);
    case 6: 
      return F(paramToServiceMsg, paramUniPacket);
    case 7: 
      return G(paramToServiceMsg, paramUniPacket);
    case 8: 
      return A(paramToServiceMsg, paramUniPacket);
    case 9: 
      return B(paramToServiceMsg, paramUniPacket);
    }
    return z(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 0;
    localGroupMngReq.uin = l1;
    localGroupMngReq.cIsSupportAuthQuestionJoin = 1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)l1);
    localGroupMngReq.vecBody = localByteBuffer.array();
    localGroupMngReq.wSourceID = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 1;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    String str = paramToServiceMsg.extraData.getString("back_msg");
    int i1 = str.getBytes().length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 9);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.put((byte)i1);
    localByteBuffer.put(str.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    i1 = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.wSourceSubID = i1;
    localGroupMngReq.wSourceID = 3;
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopReport", 4, "handleJoinGroup: wSourceSubID=" + i1);
    }
    return true;
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 2;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.putInt((int)l2);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 10;
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    localGroupMngReq.uin = l1;
    localGroupMngReq.sGroupLocation = paramToServiceMsg.extraData.getString("groupcity");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    byte b2 = paramToServiceMsg.extraData.getByte("group_ops");
    String str1 = paramToServiceMsg.extraData.getString("group_name");
    String str2 = paramToServiceMsg.extraData.getString("group_memo");
    String str3 = paramToServiceMsg.extraData.getString("group_finger_memo");
    String str4 = paramToServiceMsg.extraData.getString("group_class_text");
    int i1 = paramToServiceMsg.extraData.getInt("group_class");
    long l2 = paramToServiceMsg.extraData.getLong("group_discussuin");
    paramToServiceMsg = ByteBuffer.allocate(str1.getBytes().length + 19 + 2 + 1 + str2.getBytes().length + 1 + str3.getBytes().length + 1 + str4.getBytes().length);
    paramToServiceMsg.put(b1);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.put(b2);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt(i1);
    paramToServiceMsg.put((byte)str1.getBytes().length);
    paramToServiceMsg.put(str1.getBytes());
    paramToServiceMsg.putShort((short)0);
    paramToServiceMsg.put((byte)str2.getBytes().length);
    paramToServiceMsg.put(str2.getBytes());
    paramToServiceMsg.put((byte)str3.getBytes().length);
    paramToServiceMsg.put(str3.getBytes());
    paramToServiceMsg.put((byte)str4.getBytes().length);
    paramToServiceMsg.put(str4.getBytes());
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    localGroupMngReq.dwDiscussUin = Long.valueOf(l2).longValue();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramFromServiceMsg.getServiceCmd())).intValue())
    {
    case 6: 
    case 11: 
    case 14: 
    case 16: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    default: 
      return null;
    case 3: 
      return p(paramToServiceMsg, paramFromServiceMsg);
    case 4: 
      return o(paramToServiceMsg, paramFromServiceMsg);
    case 5: 
      return m(paramToServiceMsg, paramFromServiceMsg);
    case 2: 
      return q(paramToServiceMsg, paramFromServiceMsg);
    case 13: 
      return r(paramToServiceMsg, paramFromServiceMsg);
    case 8: 
      return l(paramToServiceMsg, paramFromServiceMsg);
    case 15: 
      return g(paramToServiceMsg, paramFromServiceMsg);
    case 7: 
      return k(paramToServiceMsg, paramFromServiceMsg);
    case 9: 
      return i(paramToServiceMsg, paramFromServiceMsg);
    case 10: 
      return j(paramToServiceMsg, paramFromServiceMsg);
    case 12: 
      h(paramToServiceMsg, paramFromServiceMsg);
    case 17: 
      b(paramToServiceMsg, paramFromServiceMsg);
    case 22: 
      return u(paramToServiceMsg, paramFromServiceMsg);
    case 23: 
      return b(paramToServiceMsg, paramFromServiceMsg);
    case 24: 
      return t(paramToServiceMsg, paramFromServiceMsg);
    case 25: 
      return s(paramToServiceMsg, paramFromServiceMsg);
    case 26: 
      return c(paramToServiceMsg, paramFromServiceMsg);
    case 27: 
      return d(paramToServiceMsg, paramFromServiceMsg);
    case 28: 
      return e(paramToServiceMsg, paramFromServiceMsg);
    case 29: 
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return b(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "decodeCheckUpdateReq() ");
    }
    return (CheckUpdateResp)a(paramFromServiceMsg.getWupBuffer(), "CheckUpdateResp", new CheckUpdateResp());
  }
  
  public void b() {}
  
  public boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject;
    switch (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramToServiceMsg.getServiceCmd())).intValue())
    {
    case 6: 
    case 16: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      return false;
    case 1: 
      localObject = paramToServiceMsg.extraData.getString("city");
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (localObject == null) {
        paramToServiceMsg = "";
      }
      a(paramToServiceMsg, paramUniPacket);
      return true;
    case 2: 
      localObject = new ArrayList();
      Iterator localIterator = paramToServiceMsg.extraData.getStringArrayList("uinList").iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      a(paramToServiceMsg, (ArrayList)localObject, paramUniPacket);
      return true;
    case 3: 
      return s(paramToServiceMsg, paramUniPacket);
    case 4: 
      return u(paramToServiceMsg, paramUniPacket);
    case 5: 
      return t(paramToServiceMsg, paramUniPacket);
    case 7: 
      return q(paramToServiceMsg, paramUniPacket);
    case 8: 
      return r(paramToServiceMsg, paramUniPacket);
    case 9: 
      return o(paramToServiceMsg, paramUniPacket);
    case 10: 
      return p(paramToServiceMsg, paramUniPacket);
    case 11: 
      return n(paramToServiceMsg, paramUniPacket);
    case 12: 
      return m(paramToServiceMsg, paramUniPacket);
    case 13: 
      return l(paramToServiceMsg, paramUniPacket);
    case 14: 
      return j(paramToServiceMsg, paramUniPacket);
    case 15: 
      return k(paramToServiceMsg, paramUniPacket);
    case 17: 
      return v(paramToServiceMsg, paramUniPacket);
    case 23: 
      return e(paramToServiceMsg, paramUniPacket);
    case 24: 
      return d(paramToServiceMsg, paramUniPacket);
    case 25: 
      return c(paramToServiceMsg, paramUniPacket);
    case 26: 
      return f(paramToServiceMsg, paramUniPacket);
    case 27: 
      return g(paramToServiceMsg, paramUniPacket);
    case 28: 
      return h(paramToServiceMsg, paramUniPacket);
    case 29: 
      return i(paramToServiceMsg, paramUniPacket);
    }
    return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.ProfileService
 * JD-Core Version:    0.7.0.1
 */