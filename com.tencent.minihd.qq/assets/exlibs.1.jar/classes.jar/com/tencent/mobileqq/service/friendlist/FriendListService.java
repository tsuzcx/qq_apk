package com.tencent.mobileqq.service.friendlist;

import BumpSvc.ReqConfirmContactFriend;
import NeighborComm.ReqHeader;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import friendlist.AddFriendReq;
import friendlist.AddFriendResp;
import friendlist.CheckFriendReq;
import friendlist.DelFriendReq;
import friendlist.DelFriendResp;
import friendlist.EAddFriendSourceID;
import friendlist.GetAutoInfoReq;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.GetFriendsVideoAbiResp;
import friendlist.GetLastLoginInfoReq;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoReq;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoReq;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingReq;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMem;
import friendlist.MovGroupMemReq;
import friendlist.MovGroupMemResp;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfo;

public class FriendListService
  extends BaseProtocolCoder
{
  private static final int jdField_a_of_type_Int = 200;
  private static final String jdField_a_of_type_JavaLangString = "FriendListService";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "friendlist", "BumpSvc" };
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopService jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService;
  
  public FriendListService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService = new TroopService(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a();
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  private void a(int paramInt, byte paramByte1, long paramLong, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetFriendListReq");
    if (paramShort2 == 0) {
      paramShort2 = 200;
    }
    for (;;)
    {
      if (paramByte5 == 0) {
        paramByte5 = -56;
      }
      for (;;)
      {
        paramUniPacket.put("FL", new GetFriendListReq(paramInt, paramByte1, paramLong, paramShort1, paramShort2, paramByte2, paramByte3, paramByte4, paramByte5, (byte)0, (byte)1, 6L, null));
        return;
      }
    }
  }
  
  private void a(String paramString, UniPacket paramUniPacket)
  {
    a(3, (byte)1, Long.valueOf(paramString).longValue(), (short)0, (short)20, (byte)0, (byte)1, (byte)0, (byte)0, paramUniPacket);
  }
  
  private void a(String paramString, short paramShort1, short paramShort2, UniPacket paramUniPacket)
  {
    a(3, (byte)1, Long.valueOf(paramString).longValue(), paramShort1, paramShort2, (byte)0, (byte)0, (byte)0, (byte)0, paramUniPacket);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return paramFromServiceMsg;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("bType");
    long l2 = paramToServiceMsg.extraData.getLong("lToMID");
    long l3 = paramToServiceMsg.extraData.getLong("lFromMobile");
    long l4 = paramToServiceMsg.extraData.getLong("lToMobile");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vSig");
    byte b = paramToServiceMsg.extraData.getByte("bGroupId");
    String str = paramToServiceMsg.extraData.getString("strNickName");
    paramToServiceMsg = new ReqHeader();
    paramToServiceMsg.shVersion = 1;
    paramToServiceMsg.lMID = l1;
    paramToServiceMsg.iAppID = AppSetting.a;
    paramToServiceMsg.eBusiType = 1;
    paramToServiceMsg.eMqqSysType = 2;
    localObject = new ReqConfirmContactFriend((byte)i, l2, l3, l4, (byte[])localObject, b, null, str);
    paramUniPacket.setServantName("BumpSvc");
    paramUniPacket.setFuncName("CMD_CONFIRM_CONTACT_FRIEND");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqConfirmContactFriend", localObject);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    if ("GetOnlineInfoReq".equals(paramFromServiceMsg.getFuncName()))
    {
      paramToServiceMsg = (GetOnlineInfoResp)a(paramToServiceMsg, "GetOnlineInfoResp", new GetOnlineInfoResp());
      if (paramToServiceMsg == null) {
        return null;
      }
      paramToServiceMsg.dwStatus = ((byte)(int)paramToServiceMsg.dwStatus);
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = new GetSimpleOnlineFriendInfoReq(l, (byte)0, (byte)0, null, paramToServiceMsg.extraData.getByte("ifShowTermType"), 5L, paramToServiceMsg.extraData.getByte("srcType"));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetSimpleOnlineFriendInfoReq");
    paramUniPacket.put("FSOLREQ", paramToServiceMsg);
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getFuncName();
    if ("GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)a(paramToServiceMsg, "FSOLRESP", new GetSimpleOnlineFriendInfoResp());
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = null;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramToServiceMsg;
            paramToServiceMsg = paramFromServiceMsg;
          } while (paramFromServiceMsg == null);
          paramToServiceMsg = paramFromServiceMsg;
        } while (paramFromServiceMsg.result != 1);
        return null;
        if (!"GetFriendsVideoAbiResp".equals(paramFromServiceMsg)) {
          break;
        }
        paramFromServiceMsg = (GetFriendsVideoAbiResp)a(paramToServiceMsg, "VABRESP", new GetFriendsVideoAbiResp());
        paramToServiceMsg = paramFromServiceMsg;
      } while (paramFromServiceMsg == null);
      paramToServiceMsg = paramFromServiceMsg;
    } while (paramFromServiceMsg.result != 1);
    return null;
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType");
    if (l == 0L) {}
    for (paramToServiceMsg = new GetOnlineInfoReq(l, paramToServiceMsg.extraData.getLong("dwUin"), null, 5L);; paramToServiceMsg = new GetOnlineInfoReq(l, 0L, paramToServiceMsg.extraData.getString("strMobile"), 5L))
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetOnlineInfoReq");
      paramUniPacket.put("GetOnlineInfoReq", paramToServiceMsg);
      return true;
    }
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (DelFriendResp)a(paramFromServiceMsg.getWupBuffer(), "DFRESP", new DelFriendResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    do
    {
      return false;
      l2 = a(paramToServiceMsg.extraData.getString("uin"));
    } while (l2 == 0L);
    paramToServiceMsg = new CheckFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.fuin = l2;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("CheckFriendReq");
    paramUniPacket.put("CF", paramToServiceMsg);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AddFriendResp)a(paramFromServiceMsg.getWupBuffer(), "AFRESP", new AddFriendResp());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    long l2 = a(paramToServiceMsg.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    if (l1 == l2) {
      return false;
    }
    byte b2 = paramToServiceMsg.getByte("del_type");
    byte b1;
    if (b2 == 1)
    {
      b1 = b2;
      if (b2 == 2) {}
    }
    else
    {
      b1 = 1;
    }
    paramToServiceMsg = new DelFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.deluin = l2;
    paramToServiceMsg.delType = b1;
    paramToServiceMsg.version = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("DelFriendReq");
    paramUniPacket.put("DF", paramToServiceMsg);
    return true;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (MovGroupMemResp)a(paramFromServiceMsg.getWupBuffer(), "MovGroupMemResp", new MovGroupMemResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    paramToServiceMsg = localBundle.getString("uin");
    i = localBundle.getInt("source_id", 10004);
    AddFriendReq localAddFriendReq = new AddFriendReq();
    localAddFriendReq.uin = l1;
    Object localObject;
    int j;
    int k;
    byte b2;
    boolean bool;
    byte[] arrayOfByte;
    byte b1;
    if (i == 3016)
    {
      localObject = localBundle.getString("extra");
      if ((TextUtils.isEmpty(paramToServiceMsg)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        return false;
      }
      localAddFriendReq.name = paramToServiceMsg.getBytes();
      localAddFriendReq.name1 = ((String)localObject).getBytes();
      j = localBundle.getInt("sub_source_id", 0);
      k = localBundle.getInt("friend_setting");
      b2 = localBundle.getByte("group_id");
      localObject = localBundle.getString("msg");
      bool = localBundle.getBoolean("auto_send");
      arrayOfByte = localBundle.getByteArray("sig");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label472;
      }
      b1 = 0;
    }
    for (;;)
    {
      localAddFriendReq.adduinsetting = k;
      localAddFriendReq.myAllowFlag = 1;
      localAddFriendReq.msgLen = b1;
      localAddFriendReq.sourceSubID = j;
      if (localObject != null) {
        localAddFriendReq.msg = ((String)localObject);
      }
      localAddFriendReq.myfriendgroupid = b2;
      localAddFriendReq.sourceID = i;
      localAddFriendReq.contact_bothway_friend = localBundle.getBoolean("contact_bothway", false);
      localObject = localBundle.getString("remark");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramToServiceMsg = null;
      }
      try
      {
        localObject = ((String)localObject).getBytes("utf-8");
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          long l2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          i = 0;
        }
      }
      localAddFriendReq.remark = paramToServiceMsg;
      if (!bool) {
        break label517;
      }
      i = 1;
      localAddFriendReq.autoSend = ((byte)i);
      if (arrayOfByte != null) {
        localAddFriendReq.sig = arrayOfByte;
      }
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("AddFriendReq");
      paramUniPacket.put("AF", localAddFriendReq);
      return true;
      if (EAddFriendSourceID.a(i))
      {
        if (!TextUtils.isEmpty(paramToServiceMsg))
        {
          localAddFriendReq.name = paramToServiceMsg.getBytes();
          break;
        }
        return false;
      }
      l2 = a(paramToServiceMsg);
      if ((l2 == 0L) || (l1 == l2)) {
        return false;
      }
      localAddFriendReq.adduin = l2;
      if (3004 != i) {
        break;
      }
      paramToServiceMsg = localBundle.getString("extra");
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() <= 0)) {
        break;
      }
      localObject = new FrdSysMsg.GroupInfo();
      ((FrdSysMsg.GroupInfo)localObject).uint64_group_uin.set(a(paramToServiceMsg));
      localAddFriendReq.friend_src_desc = ((FrdSysMsg.GroupInfo)localObject).toByteArray();
      break;
      label472:
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (((String)localObject).length() >= 127) {
        paramToServiceMsg = ((String)localObject).substring(0, 126);
      }
      b1 = (byte)paramToServiceMsg.getBytes().length;
      localObject = paramToServiceMsg;
    }
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetUserAddFriendSettingResp)a(paramFromServiceMsg.getWupBuffer(), "FSRESP", new GetUserAddFriendSettingResp());
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Byte localByte = Byte.valueOf(paramToServiceMsg.extraData.getByte("move_fri_type"));
    if (localByte.byteValue() == 0) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if (localByte.byteValue() == 1) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetFriendListResp)a(paramFromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    byte b;
    do
    {
      do
      {
        return false;
        paramToServiceMsg = paramToServiceMsg.extraData;
        l2 = a(paramToServiceMsg.getString("uin"));
      } while ((l2 == 0L) || (l1 == l2));
      b = paramToServiceMsg.getByte("group_id");
    } while (b < 0);
    paramToServiceMsg = new MovGroupMem();
    paramToServiceMsg.Ver = 1;
    paramToServiceMsg.wReqLen = 5;
    paramToServiceMsg.dwUin = l2;
    paramToServiceMsg.cGroupid = b;
    paramToServiceMsg.wReserveLen = 0;
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 0;
    paramToServiceMsg = null;
    try
    {
      Object localObject = new ByteArrayOutputStream(10);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeShort(5);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeByte(b);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    catch (IOException localIOException)
    {
      label191:
      break label191;
    }
    localMovGroupMemReq.vecBody = paramToServiceMsg;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("MovGroupMemReq");
    paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
    return true;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetLastLoginInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GetLastLoginInfoResp", new GetLastLoginInfoResp());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    String[] arrayOfString = ((Bundle)localObject).getStringArray("uins");
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 1;
    paramToServiceMsg = null;
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeByte(1);
        localDataOutputStream.writeShort(arrayOfString.length * 5);
        i = 0;
        if ((arrayOfString != null) && (i < arrayOfString.length))
        {
          l2 = a(arrayOfString[i]);
          if (l2 != 0L) {
            continue;
          }
        }
        localDataOutputStream.writeShort(0);
        localDataOutputStream.close();
        localObject = localByteArrayOutputStream.toByteArray();
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      catch (IOException localIOException)
      {
        DataOutputStream localDataOutputStream;
        int i;
        long l2;
        int j;
        continue;
      }
      localMovGroupMemReq.vecBody = paramToServiceMsg;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("MovGroupMemReq");
      paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
      return true;
      if (l1 != l2)
      {
        j = ((Bundle)localObject).getByte("group_id");
        if (j >= 0)
        {
          localDataOutputStream.writeInt((int)l2);
          localDataOutputStream.writeByte(j);
          i += 1;
        }
      }
    }
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SetGroupResp)a(paramFromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    int i = ((Bundle)localObject).getInt("source_id");
    paramToServiceMsg = ((Bundle)localObject).getString("uin");
    localObject = ((Bundle)localObject).getString("extra");
    GetUserAddFriendSettingReq localGetUserAddFriendSettingReq = new GetUserAddFriendSettingReq();
    localGetUserAddFriendSettingReq.version = 1L;
    localGetUserAddFriendSettingReq.uin = l;
    localGetUserAddFriendSettingReq.sourceID = i;
    if (EAddFriendSourceID.a(i)) {
      localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
    }
    for (;;)
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetUserAddFriendSettingReq");
      paramUniPacket.put("FS", localGetUserAddFriendSettingReq);
      return true;
      if (i == 3016)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
        localGetUserAddFriendSettingReq.name1 = ((String)localObject).getBytes();
        continue;
      }
      l = a(paramToServiceMsg);
      if (l == 0L) {
        break;
      }
      localGetUserAddFriendSettingReq.queryuin = l;
    }
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetAutoInfoResp)a(paramFromServiceMsg.getWupBuffer(), "GAIRESP", new GetAutoInfoResp());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    return n(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    if (TextUtils.isEmpty(paramToServiceMsg)) {
      return false;
    }
    GetFriendListReq localGetFriendListReq = new GetFriendListReq();
    localGetFriendListReq.reqtype = 3;
    localGetFriendListReq.ifReflush = 1;
    localGetFriendListReq.ifShowTermType = 1;
    localGetFriendListReq.version = 6L;
    ArrayList localArrayList = new ArrayList(1);
    try
    {
      localGetFriendListReq.uin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localArrayList.add(Long.valueOf(Long.parseLong(paramToServiceMsg)));
      localGetFriendListReq.uinList = localArrayList;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", localGetFriendListReq);
      return true;
    }
    catch (NumberFormatException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    short s1 = paramToServiceMsg.extraData.getShort("friendStartIndex");
    short s2 = paramToServiceMsg.extraData.getShort("friendCount");
    byte b1 = paramToServiceMsg.extraData.getByte("groupStartIndex");
    byte b2 = paramToServiceMsg.extraData.getByte("groupCount");
    byte b3 = paramToServiceMsg.extraData.getByte("ifShowTermType");
    if (s1 > 0) {}
    for (int i = 0;; i = 1)
    {
      paramToServiceMsg = new GetFriendListReq(3, (byte)i, Long.valueOf(paramToServiceMsg.getUin()).longValue(), s1, s2, (byte)0, (byte)i, b1, b2, (byte)0, b3, 6L, null);
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", paramToServiceMsg);
      return true;
    }
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    long l2 = paramToServiceMsg.extraData.getLong("current_req_uin");
    long l3 = paramToServiceMsg.extraData.getLong("current_req_index");
    paramToServiceMsg = new GetLastLoginInfoReq(l1, new LastLoginPageInfo(paramToServiceMsg.extraData.getLong("total_req_times"), l3, l2));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetLastLoginInfoReq");
    paramUniPacket.put("GetLastLoginInfoReq", paramToServiceMsg);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetAutoInfoReq localGetAutoInfoReq = new GetAutoInfoReq();
    localGetAutoInfoReq.uin = a(paramToServiceMsg.getUin());
    localGetAutoInfoReq.dwFriendUin = a(paramToServiceMsg.extraData.getString("uin"));
    localGetAutoInfoReq.cType = paramToServiceMsg.extraData.getByte("cType");
    localGetAutoInfoReq.sourceID = paramToServiceMsg.extraData.getInt("source_id", 10004);
    localGetAutoInfoReq.sourceSubID = paramToServiceMsg.extraData.getInt("sub_source_id", 0);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetAutoInfoReq");
    paramUniPacket.put("GAIREQ", localGetAutoInfoReq);
    return true;
  }
  
  /* Error */
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 63
    //   3: invokevirtual 69	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc_w 651
    //   10: invokevirtual 74	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   13: new 653	friendlist/SetGroupReq
    //   16: dup
    //   17: invokespecial 654	friendlist/SetGroupReq:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 107	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   28: invokestatic 52	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   31: putfield 655	friendlist/SetGroupReq:uin	J
    //   34: aload 4
    //   36: aload_1
    //   37: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 657
    //   43: invokevirtual 121	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   46: putfield 658	friendlist/SetGroupReq:reqtype	I
    //   49: new 495	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: bipush 10
    //   55: invokespecial 498	java/io/ByteArrayOutputStream:<init>	(I)V
    //   58: astore 5
    //   60: new 500	java/io/DataOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 503	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore 6
    //   71: aload 4
    //   73: getfield 658	friendlist/SetGroupReq:reqtype	I
    //   76: tableswitch	default:+371 -> 447, 0:+32->108, 1:+140->216, 2:+225->301, 3:+262->338
    //   109: iconst_m1
    //   110: lcmp
    //   111: dup
    //   112: invokespecial 661	friendlist/AddGroup:<init>	()V
    //   115: astore 7
    //   117: aload 7
    //   119: aload_1
    //   120: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   123: ldc_w 663
    //   126: invokevirtual 142	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   129: putfield 666	friendlist/AddGroup:cSortId	B
    //   132: aload 7
    //   134: aload_1
    //   135: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   138: ldc_w 668
    //   141: invokevirtual 148	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 671	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   147: aload 7
    //   149: getfield 671	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   152: invokevirtual 338	java/lang/String:getBytes	()[B
    //   155: astore_1
    //   156: aload 7
    //   158: aload_1
    //   159: arraylength
    //   160: i2b
    //   161: putfield 674	friendlist/AddGroup:cLen	B
    //   164: aload 6
    //   166: aload 7
    //   168: getfield 666	friendlist/AddGroup:cSortId	B
    //   171: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   174: aload 6
    //   176: aload 7
    //   178: getfield 674	friendlist/AddGroup:cLen	B
    //   181: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   184: aload 6
    //   186: aload_1
    //   187: invokevirtual 677	java/io/DataOutputStream:write	([B)V
    //   190: aload 6
    //   192: invokevirtual 515	java/io/DataOutputStream:close	()V
    //   195: aload 4
    //   197: aload 5
    //   199: invokevirtual 516	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   202: putfield 678	friendlist/SetGroupReq:vecBody	[B
    //   205: aload_2
    //   206: ldc_w 651
    //   209: aload 4
    //   211: invokevirtual 87	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   214: iconst_1
    //   215: ireturn
    //   216: new 680	friendlist/RenameGroup
    //   219: dup
    //   220: invokespecial 681	friendlist/RenameGroup:<init>	()V
    //   223: astore 7
    //   225: aload 7
    //   227: aload_1
    //   228: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   231: ldc_w 351
    //   234: invokevirtual 142	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   237: putfield 684	friendlist/RenameGroup:cGroupId	B
    //   240: aload 7
    //   242: aload_1
    //   243: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   246: ldc_w 668
    //   249: invokevirtual 148	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   252: putfield 685	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   255: aload 7
    //   257: getfield 685	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   260: invokevirtual 338	java/lang/String:getBytes	()[B
    //   263: astore_1
    //   264: aload 7
    //   266: aload_1
    //   267: arraylength
    //   268: i2b
    //   269: putfield 686	friendlist/RenameGroup:cLen	B
    //   272: aload 6
    //   274: aload 7
    //   276: getfield 684	friendlist/RenameGroup:cGroupId	B
    //   279: invokevirtual 688	java/io/DataOutputStream:write	(I)V
    //   282: aload 6
    //   284: aload 7
    //   286: getfield 686	friendlist/RenameGroup:cLen	B
    //   289: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   292: aload 6
    //   294: aload_1
    //   295: invokevirtual 677	java/io/DataOutputStream:write	([B)V
    //   298: goto -108 -> 190
    //   301: new 690	friendlist/DelGroup
    //   304: dup
    //   305: invokespecial 691	friendlist/DelGroup:<init>	()V
    //   308: astore 7
    //   310: aload 7
    //   312: aload_1
    //   313: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   316: ldc_w 351
    //   319: invokevirtual 142	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   322: putfield 692	friendlist/DelGroup:cGroupId	B
    //   325: aload 6
    //   327: aload 7
    //   329: getfield 692	friendlist/DelGroup:cGroupId	B
    //   332: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   335: goto -145 -> 190
    //   338: new 694	friendlist/ReSortGroup
    //   341: dup
    //   342: invokespecial 695	friendlist/ReSortGroup:<init>	()V
    //   345: astore 7
    //   347: aload 7
    //   349: aload_1
    //   350: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   353: ldc_w 697
    //   356: invokevirtual 136	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   359: putfield 699	friendlist/ReSortGroup:cGroupId	[B
    //   362: aload 7
    //   364: aload_1
    //   365: getfield 113	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   368: ldc_w 701
    //   371: invokevirtual 136	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   374: putfield 703	friendlist/ReSortGroup:cSortId	[B
    //   377: aload 7
    //   379: aload 7
    //   381: getfield 699	friendlist/ReSortGroup:cGroupId	[B
    //   384: arraylength
    //   385: i2b
    //   386: putfield 706	friendlist/ReSortGroup:cNum	B
    //   389: aload 6
    //   391: aload 7
    //   393: getfield 706	friendlist/ReSortGroup:cNum	B
    //   396: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   399: aload 7
    //   401: getfield 699	friendlist/ReSortGroup:cGroupId	[B
    //   404: astore_1
    //   405: aload 7
    //   407: getfield 703	friendlist/ReSortGroup:cSortId	[B
    //   410: astore 7
    //   412: iconst_0
    //   413: istore_3
    //   414: iload_3
    //   415: aload_1
    //   416: arraylength
    //   417: if_icmpge -227 -> 190
    //   420: aload 6
    //   422: aload_1
    //   423: iload_3
    //   424: baload
    //   425: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   428: aload 6
    //   430: aload 7
    //   432: iload_3
    //   433: baload
    //   434: invokevirtual 506	java/io/DataOutputStream:writeByte	(I)V
    //   437: iload_3
    //   438: iconst_1
    //   439: iadd
    //   440: istore_3
    //   441: goto -27 -> 414
    //   444: astore_1
    //   445: iconst_0
    //   446: ireturn
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_1
    //   450: iconst_0
    //   451: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	FriendListService
    //   0	452	1	paramToServiceMsg	ToServiceMsg
    //   0	452	2	paramUniPacket	UniPacket
    //   413	28	3	i	int
    //   20	190	4	localSetGroupReq	friendlist.SetGroupReq
    //   58	140	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   69	360	6	localDataOutputStream	DataOutputStream
    //   115	316	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	34	444	java/lang/NumberFormatException
    //   71	108	449	java/io/IOException
    //   108	190	449	java/io/IOException
    //   190	195	449	java/io/IOException
    //   216	298	449	java/io/IOException
    //   301	335	449	java/io/IOException
    //   338	412	449	java/io/IOException
    //   414	437	449	java/io/IOException
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("friendlist.getFriendGroupList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetLastLoginInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.MovGroupMemReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("BumpSvc.ReqComfirmContactFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.addFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getUserAddFriendSetting".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetSimpleOnlineFriendInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetOnlineInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.delFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.SetGroupReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetAutoInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramFromServiceMsg);
    }
    if (("friendlist.GetTroopListReqV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopRemark".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopMemberList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getFriendGroupList")) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetLastLoginInfoReq")) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.delFriend")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.addFriend")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.checkFriend")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getUserAddFriendSetting")) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetSimpleOnlineFriendInfoReq")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetOnlineInfoReq")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("BumpSvc.ReqComfirmContactFriend")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.MovGroupMemReq")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.SetGroupReq")) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq")) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopListReqV2")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopMemberList")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopRemark")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetMultiTroopInfoReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupCardReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopAppointRemarkReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupInfoReq"))) {
      return this.jdField_a_of_type_ComTencentMobileqqServiceTroopTroopService.a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.FriendListService
 * JD-Core Version:    0.7.0.1
 */