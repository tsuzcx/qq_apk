package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import KQQ.SetRichSigRes;
import MessageSvcPack.RequestPushFStatus;
import QQService.BindUinResult;
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListResp;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.GroupInfo;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import hjp;
import hjq;
import hjr;
import hjs;
import hju;
import hny;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.Key;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.RspBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendListHandler
  extends BusinessHandler
{
  public static final int A = 39;
  public static final int B = 41;
  public static final int C = 42;
  public static final int D = 43;
  public static final int E = 44;
  public static final int F = 45;
  public static final int G = 47;
  public static final int H = 48;
  public static final int I = 49;
  public static final int J = 50;
  public static final int K = 51;
  public static final int L = 52;
  public static final int M = 53;
  public static final int N = 54;
  public static final int O = 55;
  public static final int P = 56;
  public static final int Q = 57;
  public static final int R = 58;
  public static final int S = 59;
  public static final int T = 60;
  public static final int U = 61;
  public static final int V = 62;
  public static final int W = 63;
  public static final int X = 64;
  public static final int Y = 65;
  public static final int Z = 66;
  public static final byte a = 0;
  public static final int a = 1;
  public static final long a = 2048L;
  public static final String a = "FriendListHandler";
  private static final short jdField_a_of_type_Short = 20002;
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int aA = 93;
  public static final int aB = 94;
  public static final int aC = 95;
  public static final int aD = 96;
  public static final int aE = 97;
  public static final int aF = 98;
  public static final int aG = 99;
  public static final int aH = 100;
  public static final int aI = 1;
  public static final int aJ = 4;
  public static final int aK = 8;
  public static final int aL = 11;
  public static final int aM = 32;
  public static final int aN = 200;
  public static final int aO = 202;
  public static final int aP = 204;
  public static final int aQ = 100;
  public static final int aR = 3000;
  public static final int aS = 3001;
  public static final int aT = 3002;
  public static final int aU = 60000;
  public static final int aV = 0;
  public static final int aW = 9201;
  public static final int aX = 9202;
  public static final int aY = 9203;
  public static final int aZ = 9204;
  public static final int aa = 67;
  public static final int ab = 68;
  public static final int ac = 69;
  public static final int ad = 70;
  public static final int ae = 71;
  public static final int af = 72;
  public static final int ag = 73;
  public static final int ah = 74;
  public static final int ai = 75;
  public static final int aj = 76;
  public static final int ak = 77;
  public static final int al = 78;
  public static final int am = 79;
  public static final int an = 80;
  public static final int ao = 81;
  public static final int ap = 82;
  public static final int aq = 83;
  public static final int ar = 84;
  public static final int as = 85;
  public static final int at = 86;
  public static final int au = 87;
  public static final int av = 88;
  public static final int aw = 89;
  public static final int ax = 90;
  public static final int ay = 91;
  public static final int az = 92;
  public static final byte b = 1;
  public static final int b = 2;
  public static final long b = 102400L;
  public static final String b = "get_troop_member";
  private static final int bA = 20;
  private static final int bB = 200;
  private static final int bC = 100;
  private static final int bF = 0;
  private static final int bH = 15;
  private static int bI = 100;
  public static final int ba = 9205;
  public static final int bb = 9206;
  public static final int bc = 9207;
  public static final int bd = 4051;
  public static final int be = 1;
  public static final int bf = 2;
  public static final int bg = 146;
  public static final int bh = 147;
  public static final int bi = 1;
  public static final int bj = 2;
  public static final int bk = 3;
  public static final int bl = 4;
  public static final int bm = 20059;
  public static final int bn = 27025;
  public static final int bo = 27032;
  public static final int bp = 27041;
  public static final int bq = 1;
  public static final int br = 2;
  public static final int bs = 3;
  public static final int bt = 0;
  public static final int bu = 1;
  public static final int bv = 2;
  public static final int bw = 1;
  public static final int bx = 2;
  public static final int by = 3;
  public static final int bz = 4;
  public static final byte c = 0;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 60000L;
  public static final String c = "uin";
  private static final short jdField_c_of_type_Short = 500;
  public static final byte d = 1;
  public static final int d = 4;
  private static final long jdField_d_of_type_Long = 5000L;
  public static final String d = "safety_flag";
  public static final byte e = 2;
  public static final int e = 5;
  private static final long e = 8L;
  public static final String e = "param_type";
  public static final byte f = 0;
  public static final int f = 7;
  private static final long f = 1800000L;
  public static final String f = "param_uins";
  public static final byte g = 1;
  public static final int g = 8;
  public static final String g = "param_switch_state";
  public static final byte h = 2;
  public static final int h = 9;
  public static final String h = "param_uin";
  public static final byte i = 0;
  public static final int i = 10;
  private static final long i = 15000L;
  public static final String i = "param_ring_ids";
  public static final byte j = 1;
  public static final int j = 11;
  public static final String j = "param_is_set_switches_of_a_person";
  public static final byte k = 2;
  public static final int k = 12;
  private static final long jdField_k_of_type_Long = 15000L;
  private static final String jdField_k_of_type_JavaLangString = "Q.qqhead.flh";
  public static final int l = 13;
  private static final String jdField_l_of_type_JavaLangString = "StatusEntry";
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 18;
  public static final int q = 19;
  public static final int r = 21;
  public static final int s = 22;
  public static final int t = 27;
  public static final int u = 28;
  public static final int v = 30;
  public static final int w = 33;
  public static final int x = 35;
  public static final int y = 37;
  public static final int z = 38;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private hny jdField_a_of_type_Hny;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private short jdField_b_of_type_Short = 20002;
  private boolean jdField_b_of_type_Boolean;
  private int bD = 0;
  private int bE = -1;
  private int bG = 0;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean = false;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_d_of_type_Boolean = false;
  private long g = 0L;
  private long h = 0L;
  private final long j = 86400000L;
  private long jdField_l_of_type_Long;
  private long m = 0L;
  private long n = 0L;
  
  protected FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.l = 15000L;
    this.jdField_a_of_type_AndroidOsHandler = new hjp(this, paramQQAppInterface.a().getMainLooper());
    OnlineStatusIconHelper.a();
    try
    {
      this.jdField_b_of_type_Boolean = ContactConfig.a(paramQQAppInterface.a().getApplicationContext(), paramQQAppInterface.getAccount());
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if (paramVipBaseInfo != null) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    int i1 = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int i2 = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      i1 = i2;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return i1;
    return 0;
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
  
  public static SpecialCareInfo a(QQAppInterface paramQQAppInterface, Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong)
  {
    paramQQAppInterface = null;
    Object localObject1 = null;
    if (paramSnsUpateBuffer == null) {}
    while (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
      return localObject1;
    }
    Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
    for (;;)
    {
      localObject1 = paramQQAppInterface;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject2 = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
      if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.has()))
      {
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          localObject1 = new SpecialCareInfo();
          ((SpecialCareInfo)localObject1).uin = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
          ((SpecialCareInfo)localObject1).dateTime = paramLong;
        }
        int i1 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.get();
        localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
        a((SpecialCareInfo)localObject1, i1, (String)localObject2);
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "decodeSC_oidb0x5d0 uin=" + ((SpecialCareInfo)localObject1).uin + ", itemtype=" + i1 + ",itemVal=" + (String)localObject2);
          paramQQAppInterface = (QQAppInterface)localObject1;
        }
      }
    }
  }
  
  private Map a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        localHashMap.put(localSetting.Path, Integer.valueOf(Integer.parseInt(localSetting.Value)));
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, byte paramByte1, byte paramByte2, String paramString2, boolean paramBoolean)
  {
    label149:
    Object localObject;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "getQQHead|type=" + paramInt1 + ", uinOrMobile=" + paramString1 + ",uinType=" + paramInt2 + ",sourceType=" + paramByte1 + ", faceFileType=" + paramByte2 + ", encid=" + paramString2 + ",isGetStrangerHead=" + paramBoolean);
        }
        if (paramInt1 == 1)
        {
          paramBoolean = Friends.isValidUin(paramString1);
          if (!paramBoolean) {
            return;
          }
        }
        if ((paramString1 == null) || (paramString1.equals(""))) {
          continue;
        }
        if (paramInt1 != 32) {
          break label542;
        }
        if (paramInt2 == 3000)
        {
          paramInt2 = 200;
          localObject = paramInt1 + "_" + paramString1;
          if (paramInt1 == 32) {
            localObject = "stranger_" + String.valueOf(paramInt2) + "_" + paramString1;
          }
          if (d((String)localObject)) {
            break;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qqhead.flh", 2, "getQQHead|repeat type=" + paramInt1 + ", uinOrMobile=" + (String)localObject);
          continue;
        }
        if (paramInt2 != 3001) {
          break label291;
        }
      }
      finally {}
      paramInt2 = 202;
      continue;
      label291:
      if (paramInt2 != 3002) {
        break label542;
      }
      paramInt2 = 204;
    }
    b((String)localObject, false);
    int i1;
    if (paramInt1 == 32)
    {
      i1 = paramInt2;
      label321:
      this.bD += 1;
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i1), localObject);
        break label547;
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString1, l1, paramByte1, paramString2));
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b())) {
          break;
        }
        if (this.bD >= 10) {
          f();
        }
        c();
        break;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      break label547;
      i1 = paramInt1;
      break label321;
      label542:
      paramInt2 = 0;
      break label149;
      label547:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    int i3 = 0;
    Object localObject1;
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead_Stranger").append(", size=");
      if (paramArrayList != null) {}
      for (i1 = paramArrayList.size();; i1 = 0)
      {
        ((StringBuilder)localObject2).append(i1);
        if (paramArrayList == null) {
          break;
        }
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i1));
          i1 += 1;
        }
      }
      QLog.d("Q.qqhead.flh", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i2;
    label227:
    MultiHeadUrl.ReqUsrInfo localReqUsrInfo;
    switch (paramInt)
    {
    case 201: 
    case 203: 
    default: 
      i1 = 0;
      localObject1 = new MultiHeadUrl.MultiBusidUrlReq();
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.set(0);
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(1));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.add(Integer.valueOf(32));
      ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.set(i1);
      i2 = 0;
      if (i2 >= paramArrayList.size()) {
        break label355;
      }
      localObject2 = (FriendListHandler.QQHeadDetails)paramArrayList.get(i2);
      localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      if (i1 != 0) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
        ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        continue;
      }
      i2 += 1;
      break label227;
      i1 = 0;
      break;
      i1 = 2;
      break;
      i1 = 1;
      break;
      if (i1 == 1) {
        localReqUsrInfo.dstTid.set(Long.parseLong(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString));
      } else if (i1 == 2) {
        localReqUsrInfo.dstOpenid.set(((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
    label355:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QQHead_Stranger request.srcUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).srcUidType.get()).append(";srcUin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append("\n\n").append(";dstUsrType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUsrType.get()).append(";dstUidType=" + ((MultiHeadUrl.MultiBusidUrlReq)localObject1).dstUidType.get()).append("\n\n").append(";uinset={");
      if (paramArrayList != null)
      {
        i1 = i3;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject2).append(paramArrayList.get(i1) + ",");
          i1 += 1;
        }
      }
      ((StringBuilder)localObject2).append("}");
      QLog.d("headstranger", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject2).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject2).extraData.putInt("subtype", paramInt);
    ((ToServiceMsg)localObject2).putWupBuffer(((MultiHeadUrl.MultiBusidUrlReq)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  private void a(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    int i2 = 0;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead|dstUsrType=").append(paramInt).append(", size=");
      if (paramArrayList != null) {}
      for (i1 = paramArrayList.size();; i1 = 0)
      {
        ((StringBuilder)localObject2).append(i1);
        if (paramArrayList == null) {
          break;
        }
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i1));
          i1 += 1;
        }
      }
      QLog.d("Q.qqhead.flh", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject1 = a("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject2 = new ArrayList();
    int i1 = i2;
    while (i1 < paramArrayList.size())
    {
      ((ArrayList)localObject2).add(((FriendListHandler.QQHeadDetails)paramArrayList.get(i1)).a());
      i1 += 1;
    }
    ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject2, (byte)paramInt);
    localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject2);
    ((ToServiceMsg)localObject1).extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject2).toByteArray());
    a((ToServiceMsg)localObject1);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ToServiceMsg localToServiceMsg = a("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l1);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    a(localToServiceMsg);
  }
  
  private void a(FriendsManagerImp paramFriendsManagerImp)
  {
    Object localObject = QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((paramFriendsManagerImp != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManagerImp.b(str))
        {
          QvipSpecialCareManager.b(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QvipSpecialCareManager.b(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            QvipSpecialCareManager.c(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
    }
  }
  
  public static void a(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
  {
    if (paramInt == 13568)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.specialRingSwitch = 0;
          return;
        }
        if (!Pattern.compile("[0-9]*").matcher(paramString).matches()) {
          return;
        }
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString);
        paramSpecialCareInfo.specialRingSwitch = 1;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramString);
        }
        paramSpecialCareInfo.specialRingSwitch = 0;
        return;
      }
    }
    else
    {
      if (paramInt == 13573)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label111;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          return;
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
        return;
        label111:
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
      if (paramInt == 13572) {
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            paramSpecialCareInfo.qzoneSwitch = 0;
            return;
          }
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (QLog.isColorLevel())
          {
            QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
            return;
            paramSpecialCareInfo.qzoneSwitch = 1;
          }
        }
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.c();
    }
    ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).d(String.valueOf(paramDelFriendResp.deluin));
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = paramFromServiceMsg.a(String.valueOf(paramDelFriendResp.deluin), 0);
    if (localRecentUser != null) {
      paramFromServiceMsg.b(localRecentUser);
    }
    a(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      a(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        a(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      a(48, true, Boolean.valueOf(false));
      a(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    a(48, false, Boolean.valueOf(true));
  }
  
  @Deprecated
  private void a(FromServiceMsg paramFromServiceMsg, String[] paramArrayOfString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramFromServiceMsg.getUin()).createEntityManager();
    paramFromServiceMsg = localEntityManager.a();
    paramFromServiceMsg.a();
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramArrayOfString.length;
        i1 = 0;
        if (i1 < i2)
        {
          String str = paramArrayOfString[i1];
          Ability localAbility = (Ability)localEntityManager.a(Ability.class, str);
          if (localAbility == null)
          {
            localAbility = new Ability();
            localAbility.uin = str;
            localAbility.flags = 2;
            localEntityManager.a(localAbility);
          }
          else
          {
            localAbility.addAbility(2);
            localEntityManager.a(localAbility);
          }
        }
      }
      finally
      {
        paramFromServiceMsg.b();
      }
      paramFromServiceMsg.c();
      paramFromServiceMsg.b();
      return;
      i1 += 1;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
      if (localArrayList != null)
      {
        paramInt = localArrayList.size();
        ((StringBuilder)localObject).append(paramInt);
      }
    }
    for (;;)
    {
      if ((localArrayList == null) || (localArrayList.size() == 0)) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqhead.flh", 2, localStringBuilder.toString());
        }
      }
      do
      {
        return;
        paramInt = -1;
        break;
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localArrayList.get(paramInt);
          String str = localQQHeadDetails.jdField_a_of_type_Int + "_" + localQQHeadDetails.jdField_a_of_type_JavaLangString;
          localObject = str;
          if (localQQHeadDetails.jdField_a_of_type_Int == 32)
          {
            int i1 = paramToServiceMsg.extraData.getInt("subtype");
            localObject = "stranger_" + i1 + "_" + str;
          }
          b((String)localObject, true);
          if ((QLog.isColorLevel()) && (localQQHeadDetails != null)) {
            localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long);
          }
          paramInt += 1;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqhead.flh", 2, localStringBuilder.toString());
      return;
      localStringBuilder = null;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i1;
    if ((??? == null) || (???.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i1 = 65535;
      if (paramQQHeadUrlResp != null)
      {
        i1 = paramQQHeadUrlResp.result;
        a(paramToServiceMsg, i1);
      }
    }
    for (;;)
    {
      return;
      if (??? == null) {
        break;
      }
      i1 = ???.getResultCode();
      break;
      Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        ??? = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label236;
          }
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)((Iterator)localObject).next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(String.valueOf(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
            ???.add(localQQHeadInfo);
          }
        }
        label236:
        paramQQHeadUrlResp.UserHeadInfoList = ???;
      }
      if (this.jdField_a_of_type_Hny == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Hny == null) {
          this.jdField_a_of_type_Hny = new hny(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i1 = 0;
        if (i1 >= paramQQHeadUrlResp.UserHeadInfoList.size()) {
          continue;
        }
        ??? = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i1);
        this.jdField_a_of_type_Hny.a(???, paramToServiceMsg);
        i1 += 1;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int i3 = paramToServiceMsg.extraData.getInt("Revision");
      int i2 = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l1 = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h(false, true);
        a(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label289;
          }
        }
        label289:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((i2 != -1) && (i2 < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + i2 + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h(false, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(bool);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int i1 = i2;
      if (i2 == -1) {
        i1 = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(i3).append(" lastRespRevision=").append(i1).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l1).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label591;
        }
      }
      label591:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        DBUtils.a().a(paramRespGetSettings.Settings, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        l1 += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l1) {
          break;
        }
        ((RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30)).a(i3, l1, i1, bool, null);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    boolean bool1 = false;
    Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i1 = paramToServiceMsg.extraData.getInt("localRevision");
    boolean bool2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i1).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler", 2, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg = (RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (!paramFromServiceMsg.isSuccess()) {
        break label215;
      }
      if (i1 + 1 != paramRespSetSettings.Revision) {
        break label200;
      }
      DBUtils.a().a((ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      DBUtils.a().a(paramRespSetSettings.Revision, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i(true, false);
      bool2 = true;
    }
    for (;;)
    {
      if (localObject != null) {
        break label230;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
      }
      return;
      paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
      break;
      label200:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i(true, true);
      bool2 = true;
      continue;
      label215:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i(false, false);
      bool2 = false;
    }
    label230:
    paramFromServiceMsg = b((ArrayList)localObject);
    paramRespSetSettings = ((ArrayList)localObject).iterator();
    label243:
    if (paramRespSetSettings.hasNext())
    {
      localObject = (GeneralSettings.Setting)paramRespSetSettings.next();
      if (((GeneralSettings.Setting)localObject).Path == null) {
        break label1134;
      }
      if (!((GeneralSettings.Setting)localObject).Path.startsWith("message.group.policy.")) {
        break label411;
      }
      if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.a())))) {
        break label322;
      }
      a(38, bool2, paramFromServiceMsg);
      bool1 = true;
    }
    label322:
    label1134:
    for (;;)
    {
      break label243;
      break;
      if (QLog.isColorLevel())
      {
        QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + " hasNotifyTroop=" + bool1 + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
        continue;
        if (((GeneralSettings.Setting)localObject).Path.startsWith("message.ring.switch"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(43, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.vibrate.switch"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(44, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("sync.c2c_message"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(47, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.group.ring"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(41, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.group.vibrate"))
        {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(42, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
        else if (((GeneralSettings.Setting)localObject).Path.startsWith("message.ring.care")) {
          if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
            a(78, bool2, paramFromServiceMsg);
          } else if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "-->handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject).Path + " value=" + ((GeneralSettings.Setting)localObject).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          }
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerKickOutDev index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
        return;
      }
      a(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
      return;
    }
    a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int i1 = 0;
          if (i1 < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i1);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(61, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(61, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(50, false, null);
      return;
    }
    a(50, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label225;
      }
    }
    label225:
    for (int i1 = paramArrayOfByte.length;; i1 = -1)
    {
      QLog.d("FriendListHandler", 2, i1);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      a(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    if (localFriendInfo.isRemark == 1) {
      paramToServiceMsg = localFriendInfo.remark;
    }
    boolean bool;
    label183:
    label440:
    SpecialCareInfo localSpecialCareInfo;
    label680:
    Friends localFriends2;
    for (;;)
    {
      localFriends1.remark = paramToServiceMsg;
      localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
      localFriends1.faceid = localFriendInfo.faceId;
      localFriends1.groupid = localFriendInfo.groupId;
      localFriends1.sqqtype = localFriendInfo.sqqtype;
      localFriends1.status = localFriendInfo.status;
      localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
      if (localFriendInfo.isMqqOnLine == 1)
      {
        bool = true;
        localFriends1.isMqqOnLine = bool;
        localFriends1.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends1.memberLevel = localFriendInfo.memberLevel;
        localFriends1.alias = localFriendInfo.sShowName;
        localFriends1.isRemark = localFriendInfo.isRemark;
        localFriends1.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localFriends1.iTermType = localFriendInfo.iTermType;
        localFriends1.cNetwork = localFriendInfo.cNetwork;
        localFriends1.abilityBits = localFriendInfo.uAbiFlag;
        localFriends1.netTypeIconId = localFriendInfo.eIconType;
        localFriends1.strTermDesc = localFriendInfo.strTermDesc;
        if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1)) {
          localFriends1.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
        }
        if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
        {
          localFriends1.eNetwork = localFriendInfo.eNetworkType;
          a(13, true, null);
        }
        localFriends1.setShieldFlag(false);
        paramToServiceMsg = localFriendsManager.c(localFriends1.uin);
        if (paramToServiceMsg != null)
        {
          if (paramToServiceMsg.gathtertype != 1) {
            break label680;
          }
          localFriends1.gathtertype = 1;
          localFriends1.age = paramToServiceMsg.age;
          localFriends1.smartRemark = paramToServiceMsg.smartRemark;
          localFriends1.gender = paramToServiceMsg.gender;
          localFriends1.recommReason = paramToServiceMsg.recommReason;
          if (((paramToServiceMsg.gathtertype == 1) || (paramToServiceMsg.gathtertype == 2)) && (QLog.isColorLevel())) {
            QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + localFriends1.gathtertype + " | friend.age = " + localFriends1.age + " | friend.recommReason = " + localFriends1.recommReason);
          }
        }
        paramGetFriendListResp = localFriendInfo.vecRing;
        paramToServiceMsg = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramGetFriendListResp);
        a(paramToServiceMsg, localFriendInfo.friendUin);
        localSpecialCareInfo = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 0L);
        localFriendsManager.a(localSpecialCareInfo);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.rpt_uin32_idlist.has()))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (paramToServiceMsg.hasNext()) {
              if (((Integer)paramToServiceMsg.next()).intValue() == 4051)
              {
                localFriends1.setShieldFlag(true);
                continue;
                paramToServiceMsg = "";
                break;
                bool = false;
                break label183;
                if (paramToServiceMsg.gathtertype != 2) {
                  break label440;
                }
                localFriends1.gathtertype = 2;
              }
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg.printStackTrace();
          paramToServiceMsg = null;
        }
        localFriends2 = localFriendsManager.c(localFriends1.uin);
        paramToServiceMsg = localFriendInfo.oVipInfo;
        i2 = EVIPSPEC.E_SP_QQVIP.value();
        if (localFriends2 == null) {
          break label1231;
        }
      }
    }
    int i1 = localFriends2.qqVipInfo;
    localFriends1.qqVipInfo = a(paramToServiceMsg, i2, i1);
    paramToServiceMsg = localFriendInfo.oVipInfo;
    int i2 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localFriends2 != null)
    {
      i1 = localFriends2.superQqInfo;
      label781:
      localFriends1.superQqInfo = a(paramToServiceMsg, i2, i1);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      i2 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label1241;
      }
      i1 = localFriends2.superVipInfo;
      label818:
      localFriends1.superVipInfo = a(paramToServiceMsg, i2, i1);
      if (localFriends2 != null)
      {
        localFriends1.signature = localFriends2.signature;
        localFriends1.datetime = localFriends2.datetime;
        localFriends1.lastLoginType = localFriends2.lastLoginType;
        if (localFriends2.gathtertype == 1)
        {
          localFriends1.gender = localFriends2.gender;
          localFriends1.age = localFriends2.age;
          localFriends1.smartRemark = localFriends2.smartRemark;
          localFriends1.recommReason = localFriends2.recommReason;
        }
      }
      if (localFriends2 == null) {
        break label1252;
      }
      if (localFriends2.groupid == localFriends1.groupid) {
        break label1246;
      }
      bool = true;
    }
    for (;;)
    {
      localFriendsManager.a(localFriends1, bool);
      if (localFriendsManager != null)
      {
        paramGetFriendListResp = localFriendsManager.a(localFriends2.uin);
        paramToServiceMsg = paramGetFriendListResp;
        if (paramGetFriendListResp == null)
        {
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = localFriends2.uin;
        }
        paramToServiceMsg.pendantId = localFriendInfo.ulFaceAddonId;
        paramToServiceMsg.uVipFont = localFriendInfo.uVipFont;
        paramToServiceMsg.colorRingId = localFriendInfo.uColorRing;
        paramToServiceMsg.timestamp = System.currentTimeMillis();
        localFriendsManager.a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, Get ExtensionInfo, uin=" + localFriends2.uin + ", id=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + localFriends1.uin + " | group = " + localFriends1.groupid);
      }
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      paramToServiceMsg = new ArrayList();
      paramToServiceMsg.add(localSpecialCareInfo);
      a(98, true, new Object[] { Boolean.valueOf(true), paramToServiceMsg });
      paramToServiceMsg = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.e();
      }
      a(new String[] { localFriends1.uin });
      return;
      label1231:
      i1 = 0;
      break;
      i1 = 0;
      break label781;
      label1241:
      i1 = 0;
      break label818;
      label1246:
      bool = false;
      continue;
      label1252:
      if (localFriends1.groupid != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      a(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label173;
      }
    }
    label173:
    for (int i1 = paramGetUserAddFriendSettingResp.result;; i1 = -10000)
    {
      QLog.d("FriendListHandler", 2, i1);
      a(12, false, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int i1;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      i1 = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (i1 == paramSetGroupResp.reqtype) {
        break label691;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleSetGroupResp | unmatched reqtype, local = " + i1 + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label691:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      Object localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      switch (i1)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject3 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject3).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject3).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject3).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject3).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = ((FriendsManagerImp)localObject2).a(((AddGroupResp)localObject3).cGroupId + "");
          if (localObject1 == null) {
            break label317;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject3).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject3).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          ((FriendsManagerImp)localObject2).a(paramToServiceMsg);
          a(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject3));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject3).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject3).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject3 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject3).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject3).dwSequence = ((ByteBuffer)localObject1).getInt();
          i1 = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject3).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject3).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject3).cLen);
          ((RenameGroupResp)localObject3).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = ((FriendsManagerImp)localObject2).a(String.valueOf(i1));
          if (paramToServiceMsg == null) {
            break label508;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject3).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject3).sGroupName)
        {
          ((FriendsManagerImp)localObject2).a(paramToServiceMsg);
          a(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject3));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject3).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        a(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        label317:
        label508:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((FriendsManager)localObject3).a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        a(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject2 = (GetRichSigRes)paramObject;
    Object localObject1 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    if ((localObject2 == null) || (((GetRichSigRes)localObject2).cResult != 0) || (((GetRichSigRes)localObject2).vstSigInfo == null) || (((GetRichSigRes)localObject2).vstSigInfo.size() == 0) || (localObject1 == null)) {}
    do
    {
      return;
      paramObject = new ArrayList();
      ArrayList localArrayList = new ArrayList(((GetRichSigRes)localObject2).vstSigInfo.size());
      localObject2 = ((GetRichSigRes)localObject2).vstSigInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject2).next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if ((localObject1 != null) && ((localResRichSigInfo.cStatus == 0) || (localResRichSigInfo.cStatus == 1)))
        {
          CircleBuddy localCircleBuddy = ((CircleManager)localObject1).a(String.valueOf(localResRichSigInfo.lUin));
          if (localCircleBuddy != null)
          {
            localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
            if (localResRichSigInfo.cStatus == 1)
            {
              localCircleBuddy.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
              localArrayList.add(localCircleBuddy);
              paramObject.add(str);
            }
          }
        }
      }
      if (localObject1 != null) {
        ((CircleManager)localObject1).b(localArrayList);
      }
    } while (paramObject.size() <= 0);
    localObject1 = new String[paramObject.size()];
    paramObject.toArray((Object[])localObject1);
    a(64, true, new Object[] { localObject1, paramToServiceMsg.extraData.getBundle("circleBundle") });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i1 = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    String str = "";
    long l2;
    int i2;
    boolean bool1;
    label258:
    boolean bool2;
    if ((i1 == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      i2 = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
      }
      if (i2 == 0)
      {
        paramRspBody = localFriendsManagerImp.c(String.valueOf(l1));
        paramToServiceMsg = str;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          localFriendsManagerImp.a(paramRspBody);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          l2 = MessageCache.a();
          paramRspBody = MessageRecordFactory.a(-2012);
          paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已屏蔽%s的会话", l2, 0, 0, l2);
          paramRspBody.msgtype = -2012;
          paramRspBody.isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          paramToServiceMsg = str;
        }
        if (i2 != 0) {
          break label327;
        }
        bool1 = true;
        if (i2 != 0) {
          break label333;
        }
        bool2 = true;
        label266:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label327:
    label333:
    label625:
    label631:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label258;
      bool2 = false;
      break label266;
      if ((i1 == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i1 + "result : " + i2 + " newSeq:" + l2);
        }
        if (i2 == 0)
        {
          paramToServiceMsg = localFriendsManagerImp.c(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            localFriendsManagerImp.a(paramToServiceMsg);
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            l2 = MessageCache.a();
            paramRspBody = MessageRecordFactory.a(-2012);
            paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已允许接收%s的会话", l2, 0, 0, l2);
            paramRspBody.msgtype = -2012;
            paramRspBody.isread = true;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (i2 != 0) {
            break label625;
          }
          bool1 = true;
          if (i2 != 0) {
            break label631;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label556;
        }
      }
    } while (!QLog.isColorLevel());
    label556:
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i1 = paramToServiceMsg.extraData.getInt("bType");
    long l1 = paramToServiceMsg.extraData.getLong("lToMID");
    int i2 = paramToServiceMsg.extraData.getByte("bGroupId");
    if (i1 == 1) {
      i1 = 2;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        paramToServiceMsg.extraData.getString("strNickName");
        a(String.valueOf(l1), i2, 10004, null, false, false);
      }
      String str = l1 + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
      ContactConfig.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), str, i1);
      a(10, true, new Object[] { paramToServiceMsg.getUin(), Integer.valueOf(i1) });
      return;
    }
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null)
    {
      a(11, false, localBundle);
      return;
    }
    localBundle.putInt("resultCode", paramAddFriendResp.result);
    localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int i2 = paramToServiceMsg.getInt("source_id");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      int i1;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2)))
      {
        i1 = 1;
        if ((bool1) && (i1 != 0) && (paramAddFriendResp.adduin != 0L)) {
          a(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, i2, paramToServiceMsg.getString("src_name"), true, false);
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(i2).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, i2, bool2));
          QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        }
        localBundle.putByteArray("sig", paramAddFriendResp.sig);
        localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
        if ((!bool1) || (i1 == 0)) {
          break label318;
        }
      }
      label318:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("addDirect", bool1);
        a(11, true, localBundle);
        return;
        i1 = 0;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString + "resultCode" + paramAddFriendResp.result);
    }
    a(11, true, localBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean)
    {
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b()) {
        a(1, true, null);
      }
    }
    else {
      a(1, true, Boolean.valueOf(false));
    }
    paramString = a("friendlist.getFriendGroupList");
    paramString.setEnableFastResend(true);
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    a(paramString);
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, long paramLong, ArrayList paramArrayList)
  {
    int i3 = paramGetFriendListResp.startIndex;
    int i4 = paramGetFriendListResp.friend_count;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + i3 + ", " + i4 + " totalCount=" + paramGetFriendListResp.totoal_friend_count);
    }
    if (paramGetFriendListResp.result == 1)
    {
      a(1, false, Boolean.valueOf(false));
      a(98, false, null);
      return;
    }
    TraceUtils.a("handleGetFriendList");
    if (i3 == 0) {
      paramLong = System.currentTimeMillis();
    }
    b(paramGetFriendListResp.cShowPcIcon);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    Object localObject1;
    if ((paramGetFriendListResp.stSelfInfo != null) && (i3 == 0))
    {
      localObject3 = paramGetFriendListResp.stSelfInfo;
      localObject2 = localFriendsManagerImp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).name = ((FriendInfo)localObject3).nick;
        if (((FriendInfo)localObject3).isRemark != 1) {
          break label639;
        }
        localObject1 = ((FriendInfo)localObject3).remark;
        ((Friends)localObject2).remark = ((String)localObject1);
        ((Friends)localObject2).uin = String.valueOf(((FriendInfo)localObject3).friendUin);
        ((Friends)localObject2).faceid = ((FriendInfo)localObject3).faceId;
        ((Friends)localObject2).sqqtype = ((FriendInfo)localObject3).sqqtype;
        ((Friends)localObject2).status = ((FriendInfo)localObject3).status;
        ((Friends)localObject2).cSpecialFlag = ((FriendInfo)localObject3).cSpecialFlag;
        if (((FriendInfo)localObject3).isMqqOnLine != 1) {
          break label647;
        }
      }
    }
    int i1;
    label647:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Friends)localObject2).isMqqOnLine = bool1;
      ((Friends)localObject2).sqqOnLineState = ((FriendInfo)localObject3).sqqOnLineState;
      ((Friends)localObject2).detalStatusFlag = ((FriendInfo)localObject3).detalStatusFlag;
      ((Friends)localObject2).memberLevel = ((FriendInfo)localObject3).memberLevel;
      ((Friends)localObject2).alias = ((FriendInfo)localObject3).sShowName;
      ((Friends)localObject2).isRemark = ((FriendInfo)localObject3).isRemark;
      ((Friends)localObject2).isIphoneOnline = ((FriendInfo)localObject3).isIphoneOnline;
      localObject1 = localObject2;
      ((Friends)localObject1).cNetwork = ((FriendInfo)localObject3).cNetwork;
      ((Friends)localObject1).abilityBits = ((FriendInfo)localObject3).uAbiFlag;
      ((Friends)localObject1).eNetwork = ((FriendInfo)localObject3).eNetworkType;
      ((Friends)localObject1).groupid = -1;
      ((Friends)localObject1).qqVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), ((Friends)localObject1).qqVipInfo);
      ((Friends)localObject1).superQqInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), ((Friends)localObject1).superQqInfo);
      ((Friends)localObject1).superVipInfo = a(((FriendInfo)localObject3).oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), ((Friends)localObject1).superVipInfo);
      localFriendsManagerImp.a((Friends)localObject1);
      i2 = paramGetFriendListResp.vecGroupInfo.size();
      localObject1 = new Groups[i2];
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i1);
        localObject3 = new Groups();
        ((Groups)localObject3).group_id = ((GroupInfo)localObject2).groupId;
        ((Groups)localObject3).group_name = ((GroupInfo)localObject2).groupname;
        ((Groups)localObject3).group_online_friend_count = ((GroupInfo)localObject2).online_friend_count;
        ((Groups)localObject3).group_friend_count = ((GroupInfo)localObject2).friend_count;
        ((Groups)localObject3).sqqOnLine_count = ((GroupInfo)localObject2).sqqOnLine_count;
        ((Groups)localObject3).seqid = ((GroupInfo)localObject2).seqid;
        ((Groups)localObject3).datetime = paramLong;
        localObject1[i1] = localObject3;
        i1 += 1;
      }
      label639:
      localObject1 = "";
      break;
    }
    if ((i2 > 0) && (QLog.isColorLevel()))
    {
      localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + Utils.a(((GroupInfo)localObject2).groupname) + ", " + ((GroupInfo)localObject2).friend_count + ", " + ((GroupInfo)localObject2).sqqOnLine_count + ", " + ((GroupInfo)localObject2).seqid);
    }
    localFriendsManagerImp.a((Groups[])localObject1);
    int i5 = paramGetFriendListResp.vecFriendInfo.size();
    Object localObject2 = new Friends[i5];
    Object localObject3 = new ArrayList(i5);
    if (i3 + i4 >= paramGetFriendListResp.totoal_friend_count) {
      bool1 = true;
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    HashMap localHashMap;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    FriendInfo localFriendInfo;
    Friends localFriends;
    label915:
    label1329:
    Object localObject5;
    for (;;)
    {
      Set localSet = QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localHashMap = new HashMap();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      i1 = 0;
      if (i1 >= i5) {
        break label1862;
      }
      localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i1);
      localFriends = new Friends();
      localFriends.name = localFriendInfo.nick;
      boolean bool2;
      Object localObject4;
      if (localFriendInfo.isRemark == 1)
      {
        localObject1 = localFriendInfo.remark;
        localFriends.remark = ((String)localObject1);
        localFriends.uin = String.valueOf(localFriendInfo.friendUin);
        paramArrayList.add(localFriends.uin);
        localFriends.faceid = localFriendInfo.faceId;
        localFriends.groupid = localFriendInfo.groupId;
        localFriends.sqqtype = localFriendInfo.sqqtype;
        localFriends.status = localFriendInfo.status;
        localFriends.cSpecialFlag = localFriendInfo.cSpecialFlag;
        if (localFriendInfo.isMqqOnLine != 1) {
          break label1329;
        }
        bool2 = true;
        localFriends.isMqqOnLine = bool2;
        localFriends.sqqOnLineState = localFriendInfo.sqqOnLineState;
        localFriends.detalStatusFlag = localFriendInfo.detalStatusFlag;
        localFriends.memberLevel = localFriendInfo.memberLevel;
        localFriends.datetime = paramLong;
        localFriends.alias = localFriendInfo.sShowName;
        localFriends.isRemark = localFriendInfo.isRemark;
        localFriends.cNetwork = localFriendInfo.cNetwork;
        localFriends.abilityBits = localFriendInfo.uAbiFlag;
        localFriends.eNetwork = localFriendInfo.eNetworkType;
        localFriends.netTypeIconId = localFriendInfo.eIconType;
        localFriends.strTermDesc = localFriendInfo.strTermDesc;
        if (((localFriendInfo.iTermType == 67586) || (localFriendInfo.iTermType == 66566) || (localFriendInfo.iTermType == 72194) || (localFriendInfo.iTermType == 65804) || (localFriendInfo.iTermType == 72706)) && (localFriendInfo.eNetworkType != 1)) {
          localFriends.netTypeIconIdIphoneOrWphoneNoWifi = localFriendInfo.eIconType;
        }
        localFriends.setShieldFlag(false);
        localObject4 = localFriendInfo.vecRing;
        localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
      }
      try
      {
        ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom((byte[])localObject4);
        a((Oidb_0x5d0.SnsUpateBuffer)localObject1, localFriendInfo.friendUin, localSet, localArrayList1, localArrayList2, localHashMap, localArrayList3);
        if ((localObject1 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.has()))
        {
          localObject4 = ((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_uin32_idlist.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext()) {
              if (((Integer)((Iterator)localObject4).next()).intValue() == 4051)
              {
                localFriends.setShieldFlag(true);
                continue;
                bool1 = false;
                break;
                localObject1 = "";
                break label915;
                bool2 = false;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = null;
          localException.printStackTrace();
        }
        localFriends.isIphoneOnline = localFriendInfo.isIphoneOnline;
        localFriends.iTermType = localFriendInfo.iTermType;
        localObject5 = localFriendsManagerImp.c(localFriends.uin);
        localVipBaseInfo = localFriendInfo.oVipInfo;
        i6 = EVIPSPEC.E_SP_QQVIP.value();
        if (localObject5 == null) {
          break label1737;
        }
      }
    }
    int i2 = ((Friends)localObject5).qqVipInfo;
    label1407:
    localFriends.qqVipInfo = a(localVipBaseInfo, i6, i2);
    VipBaseInfo localVipBaseInfo = localFriendInfo.oVipInfo;
    int i6 = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localObject5 != null)
    {
      i2 = ((Friends)localObject5).superQqInfo;
      label1448:
      localFriends.superQqInfo = a(localVipBaseInfo, i6, i2);
      localVipBaseInfo = localFriendInfo.oVipInfo;
      i6 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject5 == null) {
        break label1749;
      }
      i2 = ((Friends)localObject5).superVipInfo;
      label1489:
      localFriends.superVipInfo = a(localVipBaseInfo, i6, i2);
      if (localObject5 != null)
      {
        localFriends.showLoginClient = ((Friends)localObject5).showLoginClient;
        localFriends.lastLoginType = ((Friends)localObject5).lastLoginType;
      }
      localObject5 = localFriendsManagerImp.c(localFriends.uin);
      if (localObject5 != null)
      {
        if (((Friends)localObject5).gathtertype != 1) {
          break label1755;
        }
        localFriends.gathtertype = 1;
        label1560:
        localFriends.age = ((Friends)localObject5).age;
        localFriends.smartRemark = ((Friends)localObject5).smartRemark;
        localFriends.gender = ((Friends)localObject5).gender;
        localFriends.recommReason = ((Friends)localObject5).recommReason;
      }
      localObject2[i1] = localFriends;
      localObject5 = localFriendsManagerImp.a(String.valueOf(localFriends.uin));
      if (localObject5 != null) {
        break label1773;
      }
      localObject5 = new ExtensionInfo();
      ((ExtensionInfo)localObject5).uin = String.valueOf(localFriends.uin);
      ((ExtensionInfo)localObject5).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject5).uVipFont = localFriendInfo.uVipFont;
      ((ExtensionInfo)localObject5).colorRingId = localFriendInfo.uColorRing;
      ((ExtensionInfo)localObject5).timestamp = paramLong;
      ((ArrayList)localObject3).add(localObject5);
    }
    for (;;)
    {
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Oidb_0x5d0.SnsUpateBuffer)localObject1, paramLong);
      if ((localObject1 != null) && (((SpecialCareInfo)localObject1).globalSwitch != 0)) {
        localArrayList4.add(localObject1);
      }
      i1 += 1;
      break;
      label1737:
      i2 = 0;
      break label1407;
      i2 = 0;
      break label1448;
      label1749:
      i2 = 0;
      break label1489;
      label1755:
      if (((Friends)localObject5).gathtertype != 2) {
        break label1560;
      }
      localFriends.gathtertype = 2;
      break label1560;
      label1773:
      if ((((ExtensionInfo)localObject5).pendantId != localFriendInfo.ulFaceAddonId) || (((ExtensionInfo)localObject5).uVipFont != localFriendInfo.uVipFont) || (((ExtensionInfo)localObject5).colorRingId != localFriendInfo.uColorRing))
      {
        ((ExtensionInfo)localObject5).pendantId = localFriendInfo.ulFaceAddonId;
        ((ExtensionInfo)localObject5).uVipFont = localFriendInfo.uVipFont;
        ((ExtensionInfo)localObject5).colorRingId = localFriendInfo.uColorRing;
        ((ExtensionInfo)localObject5).timestamp = paramLong;
        ((ArrayList)localObject3).add(localObject5);
      }
    }
    label1862:
    if ((i5 > 0) && (QLog.isColorLevel()))
    {
      localObject1 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject1).friendUin + " | eNetwork=" + ((FriendInfo)localObject1).eNetworkType + " | iTermType=" + ((FriendInfo)localObject1).iTermType + " | abilityBits=" + ((FriendInfo)localObject1).uAbiFlag + " | name=" + Utils.a(((FriendInfo)localObject1).nick) + " | netTypeIconId=" + ((FriendInfo)localObject1).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject1).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject1).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject1).eIconType);
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        localObject1 = (ExtensionInfo)((ArrayList)localObject3).get(0);
        QLog.d("FriendListHandler", 2, "handleGetFriendList, Get Extension, uin=" + ((ExtensionInfo)localObject1).uin + ", id=" + ((ExtensionInfo)localObject1).pendantId + "/font=" + ((ExtensionInfo)localObject1).uVipFont);
      }
    }
    localFriendsManagerImp.a((Friends[])localObject2, paramLong, bool1);
    localFriendsManagerImp.d((List)localObject3);
    localFriendsManager.a(localArrayList4, paramLong, bool1);
    QvipSpecialCareManager.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.b(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.c(localArrayList3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TraceUtils.a();
    if (!bool1)
    {
      a(paramString, i3 + i4, 200, 0, 0, paramLong, paramArrayList, true);
      a(1, true, Boolean.valueOf(false));
      a(98, true, new Object[] { Boolean.valueOf(false), null });
      return;
    }
    this.g = 0L;
    paramString = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramString != null)
    {
      paramString.e();
      paramString.c();
    }
    a(1, true, Boolean.valueOf(true));
    a(98, true, new Object[] { Boolean.valueOf(true), null });
    if (!paramArrayList.isEmpty())
    {
      paramString = new String[paramArrayList.size()];
      paramArrayList.toArray(paramString);
      paramArrayList.clear();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b()) {
        break label2431;
      }
      a(paramString);
    }
    for (;;)
    {
      a(localFriendsManagerImp);
      paramLong = paramGetFriendListResp.serverTime;
      i1 = 1;
      while (i1 < 14)
      {
        if (i1 != 13) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i1, paramLong).commit();
        }
        i1 += 1;
      }
      label2431:
      this.jdField_a_of_type_ArrayOfJavaLangString = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler in handleGetFriendList() to getGatheredContactsList()");
    }
    f(0);
  }
  
  private void a(List paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        i1 = paramList.size();
        QLog.d("FriendListHandler", 2, i1);
      }
    }
    else
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      localObject2 = ((FriendsManager)localObject1).b();
      if ((paramList == null) || (localObject2 == null)) {
        break label335;
      }
      localArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (paramList.size() != 0) {
        break label188;
      }
      paramList = ((ArrayList)localObject2).iterator();
      label102:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label356;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label188:
    label335:
    label351:
    label356:
    for (int i1 = 1;; i1 = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        i1 = 1;
      }
      if (i1 == 0) {
        break label102;
      }
      localArrayList.add(localObject2);
      break label102;
      i1 = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((FriendsManager)localObject1).c(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label351;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          i1 = 1;
        }
        if (i1 == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong)
  {
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()) && (localSnsUpdateItem.uint32_update_sns_type.get() == 13568)) {
            QvipSpecialCareManager.a(String.valueOf(paramSnsUpateBuffer.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if (QvipSpecialCareManager.a(paramSnsUpateBuffer, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    } while (!QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    QvipSpecialCareManager.c(paramSnsUpateBuffer, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, long paramLong, Set paramSet, List paramList1, List paramList2, Map paramMap, List paramList3)
  {
    if (paramSnsUpateBuffer == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!paramSnsUpateBuffer.rpt_msg_sns_update_item.has()) {
          break;
        }
        Iterator localIterator = paramSnsUpateBuffer.rpt_msg_sns_update_item.get().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
          if ((localObject != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject).uint32_update_sns_type.get() == 13568))
          {
            String str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            localObject = ((Oidb_0x5d0.SnsUpdateItem)localObject).bytes_value.get().toStringUtf8();
            if ((localObject == null) || (((String)localObject).length() == 0))
            {
              if ((paramSet != null) && (paramSet.contains(str))) {
                paramList2.add(str);
              }
              if (QvipSpecialCareManager.b(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                paramList3.add(str);
              }
            }
            else
            {
              try
              {
                int i1 = Integer.parseInt((String)localObject);
                paramList1.add(str);
                paramMap.put(str, Integer.valueOf(i1));
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "dealWithRespSound|exception = " + localException.toString());
              }
            }
          }
        }
      }
      paramSnsUpateBuffer = String.valueOf(paramLong);
      if ((paramSet != null) && (paramSet.contains(paramSnsUpateBuffer))) {
        paramList2.add(paramSnsUpateBuffer);
      }
    } while (!QvipSpecialCareManager.b(paramSnsUpateBuffer, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    paramList3.add(paramSnsUpateBuffer);
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i1;
      if (paramInt1 < paramArrayOfString.length)
      {
        i1 = paramInt1 + 1;
        localArrayList.add(paramArrayOfString[paramInt1]);
        if (localArrayList.size() >= 50) {
          a(paramArrayOfString, i1, paramInt2, paramBundle, paramBoolean);
        }
      }
      else
      {
        paramArrayOfString = new String[localArrayList.size()];
        localArrayList.toArray(paramArrayOfString);
        ToServiceMsg localToServiceMsg = a("ProfileService.GetRichSig");
        localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
        localToServiceMsg.extraData.putStringArray("sendArray", paramArrayOfString);
        localToServiceMsg.extraData.putInt("reqType", paramInt2);
        localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
        localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
        a(localToServiceMsg);
        return;
      }
      paramInt1 = i1;
    }
  }
  
  private String b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = paramLong + 4294967296L;
    }
    return String.valueOf(l1);
  }
  
  private Map b(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i1);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void b(byte paramByte)
  {
    boolean bool = true;
    if ((paramByte == 0) || (paramByte == 1)) {
      if (paramByte != 1) {
        break label55;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean ^ bool))
      {
        this.jdField_b_of_type_Boolean = bool;
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_b_of_type_Boolean);
      }
      return;
      label55:
      bool = false;
    }
  }
  
  private void b(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((StringBuilder)localObject1).append("realGetQQHead_New|dstUsrType=").append(paramInt).append(", size=");
      if (paramArrayList != null) {}
      for (i1 = paramArrayList.size();; i1 = 0)
      {
        ((StringBuilder)localObject2).append(i1);
        if (paramArrayList == null) {
          break;
        }
        i1 = 0;
        while (i1 < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append(',').append(paramArrayList.get(i1));
          i1 += 1;
        }
      }
      QLog.d("Q.qqhead.flh", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    if (paramInt == 4)
    {
      paramInt = 8;
      i1 = 0;
    }
    for (;;)
    {
      localObject1 = a("IncreaseURLSvr.QQHeadUrlReq", null);
      localObject2 = new QQHeadUrl.QQHeadUrlReq();
      ((QQHeadUrl.QQHeadUrlReq)localObject2).srcUsrType.set(1);
      ((QQHeadUrl.QQHeadUrlReq)localObject2).srcUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      ((QQHeadUrl.QQHeadUrlReq)localObject2).dstUsrType.set(paramInt);
      paramInt = i2;
      if (i1 != 0)
      {
        ((QQHeadUrl.QQHeadUrlReq)localObject2).dstEncryptType.set(1);
        paramInt = i2;
      }
      label221:
      if (paramInt < paramArrayList.size())
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
        QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
        if (i1 != 0)
        {
          localReqUsrInfo.dstUin.set(0L);
          localReqUsrInfo.dstEncid.set(localQQHeadDetails.jdField_b_of_type_JavaLangString);
          localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
          ((QQHeadUrl.QQHeadUrlReq)localObject2).dstUsrInfos.add(localReqUsrInfo);
        }
        for (;;)
        {
          for (;;)
          {
            paramInt += 1;
            break label221;
            if (paramInt != 100) {
              break label390;
            }
            i1 = 1;
            paramInt = 1;
            break;
            try
            {
              localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
            }
            catch (Exception localException) {}
          }
        }
      }
      ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("uinList", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject1).putWupBuffer(((QQHeadUrl.QQHeadUrlReq)localObject2).toByteArray());
      b((ToServiceMsg)localObject1);
      return;
      label390:
      i1 = 0;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        a(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      a(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      i1 = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.ch = i1;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int i1 = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i1 = 180000)
    {
      QQAppInterface.cg = i1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.cg);
      }
      b(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label186;
      }
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramFromServiceMsg.vecFriendInfo);
      a(13, true, null);
      return;
      i1 = 30000;
      break;
    }
    label186:
    a(13, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l1 + " isSet:" + bool);
    }
    a(56, false, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(62, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(62, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i1;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i1);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i1);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(58, false, null);
      return;
    }
    a(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      a(33, true, paramToServiceMsg);
      return;
    }
    a(33, false, paramToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      a(65, false, new Object[] { paramToServiceMsg, null });
      return;
    }
    paramObject = new HashMap(paramToServiceMsg.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      paramObject.put(Long.toString(localResRichSigInfo.lUin), RichStatus.a(localResRichSigInfo.vbSigInfo));
    }
    a(65, true, new Object[] { paramToServiceMsg, paramObject });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i1);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(51, false, new Object[] { null, Integer.valueOf(i1) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
        return;
      }
      a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(51, false, new Object[] { null, Integer.valueOf(i1) });
      return;
    }
    a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i1) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i1);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(59, false, null);
      return;
    }
    a(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {
        break label793;
      }
    }
    label793:
    label799:
    label809:
    label815:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          return;
          bool = false;
          break;
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label809;
        }
        bool = true;
        i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i1 = paramToServiceMsg.get();
          int i3 = paramToServiceMsg.getInt();
          i2 = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(i2);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch cNickCut=" + i1 + " dwNextUin=" + i3 + " wSimpleInfoNum=" + i2);
          }
          if (i3 == -1)
          {
            paramObject = new StringBuffer();
            i1 = 0;
            if (i1 < i2)
            {
              String str = String.valueOf(Utils.a(paramToServiceMsg.getInt()));
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldNum=");
                paramObject.append(i3);
              }
              if (i3 != 1) {
                break label799;
              }
              i3 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldID=");
                paramObject.append(i3);
              }
              if (i3 != this.jdField_b_of_type_Short) {
                break label799;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" uin=");
                paramObject.append(str.substring(0, 4));
                paramObject.append(" nick=");
                paramObject.append(Utils.a((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label799;
            }
            if (!QLog.isColorLevel()) {
              break label815;
            }
            QLog.d("FriendListHandler", 2, paramObject.toString());
            break label815;
            a(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          i1 = i2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      a(75, false, Integer.valueOf(i1));
      return;
      int i2 = 0;
      continue;
      int i1 = (short)(i1 + 1);
      continue;
      bool = false;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (GetRichSigRes)paramObject;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    if ((paramToServiceMsg == null) || (paramToServiceMsg.cResult != 0) || (paramToServiceMsg.vstSigInfo == null) || (paramToServiceMsg.vstSigInfo.size() == 0) || (localFriendsManager == null)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      CircleManager localCircleManager = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      localArrayList1 = new ArrayList(paramToServiceMsg.vstSigInfo.size());
      ArrayList localArrayList3 = new ArrayList(paramToServiceMsg.vstSigInfo.size());
      localArrayList2 = new ArrayList();
      Iterator localIterator = paramToServiceMsg.vstSigInfo.iterator();
      while (localIterator.hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if (localResRichSigInfo.cStatus == 1)
        {
          paramObject = localFriendsManager.a(str);
          paramToServiceMsg = paramObject;
          if (paramObject == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = str;
          }
          if (paramToServiceMsg.richTime != localResRichSigInfo.dwTime)
          {
            paramToServiceMsg.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
            localArrayList1.add(paramToServiceMsg);
            localArrayList2.add(str);
          }
        }
        if ((localCircleManager != null) && ((localResRichSigInfo.cStatus == 0) || (localResRichSigInfo.cStatus == 1)))
        {
          paramToServiceMsg = localCircleManager.a(String.valueOf(localResRichSigInfo.lUin));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.checkUpdateTime = System.currentTimeMillis();
            if (localResRichSigInfo.cStatus == 1)
            {
              paramToServiceMsg.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
              localArrayList3.add(paramToServiceMsg);
            }
          }
        }
      }
      if (localCircleManager != null) {
        localCircleManager.b(localArrayList3);
      }
    } while (localArrayList2.size() <= 0);
    paramToServiceMsg = new String[localArrayList2.size()];
    localArrayList2.toArray(paramToServiceMsg);
    a(2, true, paramToServiceMsg);
    localFriendsManager.b(localArrayList1);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int i1 = 0;
          if (i1 < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i1);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + PkgTools.b(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.b(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(60, false, null);
      return;
    }
    a(60, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switch", 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    int i3 = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int i4;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i1;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switch", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i4 != 0)
            {
              paramToServiceMsg.e(paramFromServiceMsg);
              paramObject = new SpecialCareInfo();
              paramObject.globalSwitch = 1;
              paramObject.specialRingSwitch = 1;
              paramObject.friendRingId = 1;
              paramObject.qzoneSwitch = 1;
              paramObject.uin = paramFromServiceMsg;
              paramToServiceMsg.a(paramObject);
              QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (i4 == 0) {
              break label391;
            }
          }
          for (i2 = 1;; i2 = 0)
          {
            paramObject.specialRingSwitch = i2;
            paramToServiceMsg.a(paramObject);
            if (i4 == 0) {
              break;
            }
            QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (i4 == 0) {
          break label429;
        }
        for (i2 = 1;; i2 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i2;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i4 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switch", 2, "ssoPkg.uint32_result=" + i1);
        }
        if (i1 == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          i1 = 0;
          while (i1 < arrayOfString.length)
          {
            paramFromServiceMsg = arrayOfString[i1];
            i4 = arrayOfBoolean[i1];
            switch (i3)
            {
            default: 
              i1 += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i2;
      label391:
      label429:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(i3);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (i3)
      {
      default: 
        return;
      case 1: 
        a(95, i4, paramToServiceMsg);
        return;
      case 2: 
        a(96, i4, paramToServiceMsg);
        return;
      }
      a(97, i4, paramToServiceMsg);
      return;
      int i5 = 0;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switches_of_a_person", 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String str = paramToServiceMsg.extraData.getString("param_uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_type");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_ring_ids");
    int i1;
    int i4;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i2;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switches_of_a_person", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (i4 != 0)
            {
              paramToServiceMsg.e(str);
              paramFromServiceMsg = new SpecialCareInfo();
              paramFromServiceMsg.globalSwitch = 1;
              paramFromServiceMsg.uin = str;
              paramToServiceMsg.a(paramFromServiceMsg);
              QvipSpecialCareManager.a(str, "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (i4 == 0) {
              break label396;
            }
          }
          for (i3 = 1;; i3 = 0)
          {
            paramObject.specialRingSwitch = i3;
            paramToServiceMsg.a(paramObject);
            if (i4 == 0) {
              break;
            }
            QvipSpecialCareManager.a(str, paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (i4 == 0) {
          break label435;
        }
        for (int i3 = 1;; i3 = 0)
        {
          paramFromServiceMsg.qzoneSwitch = i3;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        i4 = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i1 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switches_of_a_person", 2, "ssoPkg.uint32_result=" + i1);
        }
        if (i1 == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          i2 = 0;
          while (i2 < arrayOfInt.length)
          {
            i3 = arrayOfInt[i2];
            i4 = arrayOfBoolean[i2];
            paramFromServiceMsg = arrayOfString[i2];
            switch (i3)
            {
            default: 
              i2 += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label396:
      label435:
      a(99, i4, new Object[] { Integer.valueOf(i1), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int i5 = 0;
      continue;
      i5 = 0;
      i1 = -1;
    }
  }
  
  private boolean e(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramString);
      if (l1 / 86400000L == System.currentTimeMillis() / 86400000L) {
        break label135;
      }
    }
    label135:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqXMan | lastReqTime = " + l1 + " day = " + l1 / 86400000L + " | currentTime = " + System.currentTimeMillis() + " day = " + System.currentTimeMillis() / 86400000L);
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void f()
  {
    for (;;)
    {
      int i1;
      ArrayList localArrayList;
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        Object localObject1;
        if (this.bD > 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 == null) {
            break label210;
          }
        }
        try
        {
          l1 = Long.valueOf((String)localObject1).longValue();
          if (l1 == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l1 = -1L;
          continue;
          localObject1 = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label195;
          }
        }
        i1 = ((Integer)((Enumeration)localObject1).nextElement()).intValue();
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i1));
        if (i1 == 11)
        {
          a(l1, i1, localArrayList);
          continue;
        }
        if (i1 < 200) {
          break label184;
        }
      }
      finally {}
      a(i1, localArrayList);
      continue;
      label184:
      b(l1, i1, localArrayList);
      continue;
      label195:
      this.bD = 0;
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      continue;
      label210:
      long l1 = -1L;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      a(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        i1 = 1;
        if (i1 != 0) {
          break label119;
        }
        a(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      i1 = 0;
    }
    label119:
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int i5 = localByteBuffer.getShort();
        paramFromServiceMsg = new ArrayList(i5);
        paramObject = new HashSet(i5);
        FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        int i3 = 0;
        while (i3 < i5)
        {
          long l1 = Utils.a(localByteBuffer.getInt());
          paramToServiceMsg = localFriendsManagerImp.a(String.valueOf(l1));
          if (paramToServiceMsg != null) {
            break label731;
          }
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = String.valueOf(l1);
          i1 = 1;
          int i6 = localByteBuffer.getShort();
          int i2;
          if (i6 > 0)
          {
            int i4 = 0;
            i2 = i1;
            if (i4 < i6)
            {
              int i7 = localByteBuffer.getShort();
              long l2;
              if (i7 == 27025)
              {
                if (localByteBuffer.getShort() != 8) {
                  break label728;
                }
                l2 = localByteBuffer.getLong();
                if (paramToServiceMsg.pendantId == l2) {
                  break label728;
                }
                paramToServiceMsg.pendantId = l2;
                i1 = 1;
                i2 = i1;
              }
              for (;;)
              {
                i4 += 1;
                i1 = i2;
                break;
                if (i7 == 27032)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    l2 = localByteBuffer.getInt();
                    i2 = i1;
                    if (paramToServiceMsg.uVipFont != l2)
                    {
                      paramToServiceMsg.uVipFont = l2;
                      i2 = 1;
                    }
                  }
                }
                else if (i7 == 27041)
                {
                  i2 = i1;
                  if (localByteBuffer.getShort() == 4)
                  {
                    i7 = localByteBuffer.getInt();
                    i2 = i1;
                    if (paramToServiceMsg.colorRingId != i7)
                    {
                      paramToServiceMsg.colorRingId = i7;
                      i2 = 1;
                    }
                  }
                }
                else
                {
                  i2 = i1;
                  if (i7 == 20059)
                  {
                    i2 = i1;
                    if (localByteBuffer.getShort() == 4)
                    {
                      i7 = localByteBuffer.getInt();
                      i2 = i1;
                      if (i7 >= 0)
                      {
                        i2 = i1;
                        if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                        {
                          ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(i7, true);
                          ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(i7);
                          i2 = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            i2 = i1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l1 + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont);
          }
          if (i2 != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            paramFromServiceMsg.add(paramToServiceMsg);
            paramObject.add(paramToServiceMsg.uin);
          }
          i3 += 1;
        }
        localFriendsManagerImp.d(paramFromServiceMsg);
        paramToServiceMsg = paramObject;
      }
    }
    for (;;)
    {
      label259:
      label336:
      a(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      label728:
      break label336;
      label731:
      i1 = 0;
      break label259;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (??? != null) {
      localObject1 = localObject3;
    }
    int i1;
    Object localObject2;
    label815:
    label834:
    List localList;
    ArrayList localArrayList;
    try
    {
      if (???.getResultCode() == 1000)
      {
        localObject1 = localObject3;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (??? != null) {
          i1 = ???.getResultCode();
        }
      }
      if (!QLog.isColorLevel()) {
        break label834;
      }
      ??? = new StringBuilder();
      ???.append("start ====================================================================================\n\n");
      ???.append("QQHead_Stranger response.srcUidType=" + paramObject.srcUidType.get()).append(";srcUin=" + paramObject.srcUin.get()).append("\n\n").append(";srcTid=" + paramObject.srcTid.get()).append(";srcOpenid=" + paramObject.srcOpenid.get()).append("\n\n").append(";dstUidType=" + paramObject.dstUidType.get()).append(";result=" + paramObject.result.get()).append("\n\n");
      localObject2 = paramObject.dstUsrHeadInfos.get();
      if (localObject2 == null) {
        break label815;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiHeadUrl.RspUsrHeadInfo)((Iterator)localObject2).next();
        ???.append("-------------------------------------------------------------------------------------\n\n");
        ???.append("RspUsrHeadInfo.dstUin=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstUin.get()).append(";dstTid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstTid.get()).append(";dstOpenid=" + ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstOpenid.get()).append("\n\n");
        localObject3 = ((MultiHeadUrl.RspUsrHeadInfo)localObject3).dstHeadInfos.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (MultiHeadUrl.RspHeadInfo)((Iterator)localObject3).next();
          ???.append("RspHeadInfo.usrType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).usrType.get()).append("\n\n").append(";faceType=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceType.get()).append("\n\n").append(";timestamp=" + ((MultiHeadUrl.RspHeadInfo)localObject4).timestamp.get()).append("\n\n").append(";faceFlag=" + ((MultiHeadUrl.RspHeadInfo)localObject4).faceFlag.get()).append("\n\n").append(";url=" + ((MultiHeadUrl.RspHeadInfo)localObject4).url.get()).append("\n\n").append(";sysid=" + ((MultiHeadUrl.RspHeadInfo)localObject4).sysid.get()).append("\n\n");
        }
      }
      ???.append("end ====================================================================================\n\n");
      QLog.d("headstranger", 2, ???.toString());
      localList = paramObject.dstUsrHeadInfos.get();
      localObject4 = new ArrayList();
      ??? = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      localArrayList = new ArrayList();
      i3 = paramObject.dstUidType.get();
      i2 = paramToServiceMsg.extraData.getInt("subtype");
      localIterator1 = ???.iterator();
    }
    if ((??? == null) || (???.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = paramObject.result.get();
        a(paramToServiceMsg, i1);
        return;
      }
    }
    Object localObject4;
    int i3;
    int i2;
    Iterator localIterator1;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      label930:
      if (localIterator2.hasNext())
      {
        ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (i3 == 0)
        {
          localObject2 = String.valueOf(???.dstUin.get());
          label968:
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(localObject2)) {
            break label1078;
          }
          localObject3 = ???.dstHeadInfos.get();
          paramObject = null;
          ??? = null;
          Iterator localIterator3 = ((List)localObject3).iterator();
          label1003:
          if (!localIterator3.hasNext()) {
            break label1104;
          }
          localObject3 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i1 = ((MultiHeadUrl.RspHeadInfo)localObject3).usrType.get();
          if (i1 != 1) {
            break label1080;
          }
          paramObject = localObject3;
        }
      }
    }
    label1298:
    for (;;)
    {
      break label1003;
      if (i3 == 1)
      {
        localObject2 = String.valueOf(???.dstTid.get());
        break label968;
      }
      localObject2 = ???.dstOpenid.get();
      break label968;
      label1078:
      break label930;
      label1080:
      if ((i1 == 32) && (((MultiHeadUrl.RspHeadInfo)localObject3).faceType.get() != 0))
      {
        ??? = (FromServiceMsg)localObject3;
        continue;
        label1104:
        if (??? != null)
        {
          label1108:
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)localObject2, i2);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, (String)localObject2, i2)) {
            break label1298;
          }
          i1 = 1;
        }
        for (;;)
        {
          if (i1 == 0) {
            break label1362;
          }
          paramObject = new QQHeadInfo();
          paramObject.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
          paramObject.subType = i2;
          paramObject.phoneNum = ((String)localObject2);
          paramObject.dwTimestamp = ???.timestamp.get();
          paramObject.cHeadType = ((byte)???.faceType.get());
          paramObject.dstUsrType = 32;
          paramObject.dwFaceFlgas = ((byte)???.faceFlag.get());
          paramObject.downLoadUrl = ???.url.get();
          paramObject.systemHeadID = ((short)???.sysid.get());
          localArrayList.add(paramObject);
          break label930;
          if (paramObject != null)
          {
            ??? = paramObject;
            break label1108;
          }
          if (!QLog.isColorLevel()) {
            break label930;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + (String)localObject2);
          break label930;
          break;
          if (paramObject != null)
          {
            paramObject = (com.tencent.mobileqq.data.Setting)paramObject.second;
            if (paramObject == null)
            {
              i1 = 1;
            }
            else if (paramObject.headImgTimestamp != ???.timestamp.get())
            {
              i1 = 1;
            }
            else
            {
              ((List)localObject4).add(localQQHeadDetails);
              i1 = 0;
            }
          }
          else
          {
            i1 = 1;
          }
        }
        label1362:
        break label930;
        if (this.jdField_a_of_type_Hny == null) {}
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Hny == null) {
            this.jdField_a_of_type_Hny = new hny(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          i1 = 0;
          if (i1 < localArrayList.size())
          {
            ??? = (QQHeadInfo)localArrayList.get(i1);
            this.jdField_a_of_type_Hny.a(???, paramToServiceMsg);
            i1 += 1;
          }
        }
        if (((List)localObject4).size() <= 0) {
          break;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        paramToServiceMsg = ???.a();
        paramToServiceMsg.a();
        i1 = 0;
        try
        {
          while (i1 < ((List)localObject4).size())
          {
            paramObject = (FriendListHandler.QQHeadDetails)((List)localObject4).get(i1);
            paramObject = "stranger_" + String.valueOf(i2) + "_" + paramObject.jdField_a_of_type_JavaLangString;
            localObject2 = (com.tencent.mobileqq.data.Setting)???.a(com.tencent.mobileqq.data.Setting.class, paramObject);
            if (localObject2 != null)
            {
              ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
              ???.a((Entity)localObject2);
            }
            b(paramObject, true);
            i1 += 1;
          }
        }
        catch (Exception ???)
        {
          paramToServiceMsg.c();
          paramToServiceMsg.b();
          return;
        }
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (??? != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (???.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject = null;
        continue;
        if (??? != null) {
          i1 = ???.getResultCode();
        }
      }
      i1 = paramObject.dstUsrType.get();
      if (i1 != 8) {
        break label745;
      }
    }
    if ((??? == null) || (???.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      i1 = 65535;
      if (paramObject != null)
      {
        i1 = paramObject.result.get();
        a(paramToServiceMsg, i1);
        return;
      }
    }
    int i1 = 4;
    label214:
    label739:
    label743:
    label745:
    for (;;)
    {
      int i3 = (byte)paramObject.dstEncryptType.get();
      localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      ??? = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Iterator localIterator1;
      if ((??? != null) && (???.size() > 0))
      {
        paramObject = paramObject.dstHeadInfos.get();
        localIterator1 = ???.iterator();
      }
      for (;;)
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails;
        label244:
        QQHeadUrl.RspHeadInfo localRspHeadInfo;
        int i2;
        if (localIterator1.hasNext())
        {
          localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
          Iterator localIterator2 = paramObject.iterator();
          if (!localIterator2.hasNext()) {
            break label739;
          }
          localRspHeadInfo = (QQHeadUrl.RspHeadInfo)localIterator2.next();
          if (i3 == 1)
          {
            ??? = localRspHeadInfo.dstUid.get();
            if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(???)) {
              break label442;
            }
            ??? = new QQHeadInfo();
            ???.soruceType = localQQHeadDetails.jdField_a_of_type_Byte;
            if (i3 != 1) {
              break label444;
            }
            ???.phoneNum = localRspHeadInfo.dstUid.get();
            ???.dwTimestamp = localRspHeadInfo.timestamp.get();
            ???.cHeadType = ((byte)localRspHeadInfo.faceType.get());
            ???.dstUsrType = ((byte)i1);
            ???.dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
            ???.downLoadUrl = localRspHeadInfo.url.get();
            ???.systemHeadID = ((short)localRspHeadInfo.sysid.get());
            ((List)localObject2).add(???);
            i2 = 1;
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label743;
          }
          ((List)localObject1).add(localQQHeadDetails);
          break label214;
          ??? = String.valueOf(localRspHeadInfo.dstUin.get());
          break label281;
          break label244;
          ???.uin = localRspHeadInfo.dstUin.get();
          break label328;
          if (this.jdField_a_of_type_Hny == null) {}
          synchronized (this.jdField_b_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_Hny == null) {
              this.jdField_a_of_type_Hny = new hny(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
            }
            i2 = 0;
            if (i2 < ((List)localObject2).size())
            {
              ??? = (QQHeadInfo)((List)localObject2).get(i2);
              this.jdField_a_of_type_Hny.a(???, paramToServiceMsg);
              i2 += 1;
            }
          }
          if (((List)localObject1).size() <= 0) {
            break;
          }
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          ??? = paramObject.a();
          ???.a();
          i2 = 0;
          try
          {
            if (i2 < ((List)localObject1).size())
            {
              localObject2 = (FriendListHandler.QQHeadDetails)((List)localObject1).get(i2);
              if (i1 == 4) {}
              for (paramToServiceMsg = "troop_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString;; paramToServiceMsg = ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString)
              {
                paramToServiceMsg = (com.tencent.mobileqq.data.Setting)paramObject.a(com.tencent.mobileqq.data.Setting.class, paramToServiceMsg);
                if (paramToServiceMsg != null)
                {
                  paramToServiceMsg.updateTimestamp = System.currentTimeMillis();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg);
                  paramObject.a(paramToServiceMsg);
                }
                b(i1 + "_" + ((FriendListHandler.QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString, true);
                i2 += 1;
                break;
              }
            }
            i2 = 0;
          }
          catch (Exception paramToServiceMsg)
          {
            ???.c();
            ???.b();
            return;
          }
        }
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("search_version");
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (i1 != 2) {
        break label130;
      }
      bool &= paramObject instanceof RespSearch;
      i1 = 87;
    }
    for (;;)
    {
      label45:
      int i2;
      if (bool)
      {
        paramToServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (paramToServiceMsg != null)
        {
          i2 = paramToServiceMsg.iResult;
          paramToServiceMsg = paramToServiceMsg.strErrorMsg;
        }
      }
      for (;;)
      {
        a(49, bool, new Object[] { Integer.valueOf(i1), paramObject, Integer.valueOf(i2), paramToServiceMsg });
        return;
        bool = false;
        break;
        label130:
        if (i1 != 3) {
          break label171;
        }
        bool &= paramObject instanceof ArrayList;
        i1 = 88;
        break label45;
        paramToServiceMsg = null;
        bool = false;
        i2 = 0;
        continue;
        paramToServiceMsg = null;
        i2 = 0;
      }
      label171:
      i1 = -1;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label119;
      }
      paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label110;
      }
      i1 = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i1) });
      return;
      bool = false;
      break;
      label110:
      i1 = 0;
      bool = false;
      continue;
      label119:
      i1 = 0;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l1 == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      a(68, false, new Object[] { Long.valueOf(l1), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if ((l1 == 0L) && (paramFromServiceMsg.result == 0)) {
      ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    paramFromServiceMsg.dwInterval *= 1000L;
    if (paramFromServiceMsg.dwInterval < 15000L) {
      paramFromServiceMsg.dwInterval = 15000L;
    }
    this.l = paramFromServiceMsg.dwInterval;
    a(68, true, new Object[] { Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("com_value");
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramToServiceMsg;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        a(str, paramToServiceMsg, true);
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        a(27, true, arrayOfObject);
        return;
      }
      if (paramFromServiceMsg != null) {
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
      }
      for (;;)
      {
        a(27, false, arrayOfObject);
        return;
        arrayOfObject[2] = Byte.valueOf(-1);
      }
    }
    arrayOfObject[2] = Byte.valueOf(-1);
    a(27, false, arrayOfObject);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (paramObject.cResult == 0)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        if (localFriendsManager != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramObject.dwTime == 0L) {
            paramObject.dwTime = 1L;
          }
          paramFromServiceMsg = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
          if (paramToServiceMsg.timestamp != paramObject.dwTime)
          {
            paramToServiceMsg.setRichBuffer(arrayOfByte, paramObject.dwTime);
            localFriendsManager.a(paramToServiceMsg);
          }
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(paramObject.cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i1 = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i1);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int i1 = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : setId:" + i1 + "hex:" + "");
      }
      if (i1 != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (i1 == 147) {}
    for (i1 = 72;; i1 = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i1, false, localBundle);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l1 = Utils.a(paramFromServiceMsg, 0);
          int i2 = paramToServiceMsg.get();
          localBundle.putLong("uin", l1);
          localBundle.putInt("safety_flag", i2 & 0x1F);
          a(i1, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i1, false, localBundle);
        return;
      }
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label192;
      }
    }
    label192:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
        a(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l1 = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
      }
      a(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList()");
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(80, false, Boolean.valueOf(false));
      this.n = 0L;
    }
    for (;;)
    {
      return;
      int i1 = paramToServiceMsg.extraData.getInt("startIndex");
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("beforeShowTip");
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        label91:
        if (!paramToServiceMsg.uint32_result.has())
        {
          a(80, false, Boolean.valueOf(false));
          this.n = 0L;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label91;
        int i2 = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList result " + i2);
        }
        if (i2 == 0)
        {
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
          Object localObject = new cmd0x7c4.RspBody();
          int i3;
          ArrayList localArrayList;
          for (;;)
          {
            try
            {
              ((cmd0x7c4.RspBody)localObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              paramObject = (cmd0x7c4.GetRecommendSNFrdListRsp)((cmd0x7c4.RspBody)localObject).msg_get_recommend_sn_frd_list_rsp.get();
              paramObject.uint64_uin.get();
              i2 = paramObject.uint32_sequence.get();
              i3 = paramObject.uint32_over.get();
              if (((cmd0x7c4.RspBody)localObject).rpt_msg_recommend_reason.has())
              {
                paramToServiceMsg = ((cmd0x7c4.RspBody)localObject).rpt_msg_recommend_reason.get();
                ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).f(paramToServiceMsg);
              }
              paramToServiceMsg = paramObject.rpt_msg_one_frd_data.get();
              if (paramToServiceMsg == null) {
                break label661;
              }
              localObject = paramFromServiceMsg.edit();
              if (paramToServiceMsg.size() > 0)
              {
                bool1 = true;
                ((SharedPreferences.Editor)localObject).putBoolean("hasPulledRecomGathered", bool1).commit();
                localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
                localArrayList = new ArrayList();
                Iterator localIterator = paramToServiceMsg.iterator();
                if (!localIterator.hasNext()) {
                  break;
                }
                cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
                Friends localFriends = new Friends();
                localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
                localFriends.age = localOneFrdData.uint32_ages.get();
                if (!localOneFrdData.bytes_smart_remark.has()) {
                  break label647;
                }
                paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
                localFriends.smartRemark = paramToServiceMsg;
                localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
                int i4 = localOneFrdData.uint32_reason_id.get();
                localFriends.recommReason = ((FriendsManager)localObject).a(i4);
                localArrayList.add(localFriends);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.i("FriendListHandler", 2, "handleGetRecommGatheredContactsList Recom List : " + localFriends.uin + " ; resonId = " + i4 + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
                continue;
              }
              boolean bool1 = false;
            }
            catch (Exception paramToServiceMsg)
            {
              a(80, false, Boolean.valueOf(false));
              paramFromServiceMsg.edit().putBoolean("hasPulledRecomGathered", false).commit();
              return;
            }
            continue;
            label647:
            paramToServiceMsg = null;
          }
          ((FriendsManager)localObject).b(localArrayList, i1);
          label661:
          if (i3 == 0)
          {
            i1 = paramObject.uint32_next_start_idx.get();
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "FriendListHandler handleGetRecommGatheredContactsList. not Completed. continue to get. startIndex = " + i1);
            }
            a(i1, bool2);
            a(80, true, Boolean.valueOf(false));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "FriendListHandler handleGetRecommGatheredContactsList. Completed.");
          }
          paramFromServiceMsg.edit().putInt("GetRecomFrdListReq_seq", i2).commit();
          a(80, true, Boolean.valueOf(true));
          if (bool2)
          {
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1036));
            }
          }
        }
        else
        {
          if (i2 == 1)
          {
            this.n = 0L;
            a(80, true, Boolean.valueOf(true));
            return;
          }
          this.n = 0L;
          a(80, false, Boolean.valueOf(true));
        }
      }
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    int i1 = paramToServiceMsg.extraData.getInt("startIndex");
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label73:
      break label73;
      int i2 = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label155;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + i2);
      if (i2 != 0) {
        break label1003;
      }
      paramObject = new cmd0x7c4.RspBody();
      int i3;
      FriendsManager localFriendsManager;
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramFromServiceMsg = (cmd0x7c4.GetSNFrdListRsp)paramObject.msg_get_sn_frd_list_rsp.get();
          paramFromServiceMsg.uint64_uin.get();
          i2 = paramFromServiceMsg.uint32_sequence.get();
          i3 = paramFromServiceMsg.uint32_over.get();
          if (paramObject.rpt_msg_recommend_reason.has())
          {
            paramToServiceMsg = paramObject.rpt_msg_recommend_reason.get();
            ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).f(paramToServiceMsg);
          }
          paramToServiceMsg = paramFromServiceMsg.rpt_msg_one_frd_data.get();
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          if (paramToServiceMsg == null) {
            break label577;
          }
          localArrayList = new ArrayList();
          Iterator localIterator = paramToServiceMsg.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
          Friends localFriends = new Friends();
          localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
          localFriends.age = localOneFrdData.uint32_ages.get();
          if (localOneFrdData.bytes_smart_remark.has())
          {
            paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
            localFriends.smartRemark = paramToServiceMsg;
            localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
            int i4 = localOneFrdData.uint32_reason_id.get();
            localFriends.recommReason = localFriendsManager.a(i4);
            localArrayList.add(localFriends);
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList Gather List : " + localFriends.uin + " ; resonId = " + i4 + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
            }
          }
          else
          {
            paramToServiceMsg = null;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      localFriendsManager.a(localArrayList, i1);
      if (!paramFromServiceMsg.uint32_recommend_frd_count.has()) {
        break label848;
      }
      i1 = paramFromServiceMsg.uint32_recommend_frd_count.get();
      if (!QLog.isColorLevel()) {
        break label629;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  推荐人数 : " + i1);
      localFriendsManager.b(i1);
      boolean bool = paramObject.msg_box.has();
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (!bool) {
        break label889;
      }
      if (!QLog.isColorLevel()) {
        break label676;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      bool = paramObject.getBoolean("hasPulledRecomGathered", false);
      paramObject.edit().putBoolean("hasMsgBox", true).commit();
      this.n = 0L;
      if (!bool) {
        break label866;
      }
      if (!QLog.isColorLevel()) {
        break label753;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. ");
      if (paramToServiceMsg == null) {
        break label769;
      }
      paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1036));
      for (;;)
      {
        if (i3 != 0) {
          break label923;
        }
        i1 = paramFromServiceMsg.uint32_next_start_idx.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. not Completed. continue to get. startIndex = " + i1);
        }
        f(i1);
        a(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  no recommended field. ");
        break;
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. go to get.");
        }
        e(true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList no has MsgBox. ");
        }
        if (paramToServiceMsg != null) {
          paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1037));
        }
      }
      if (!QLog.isColorLevel()) {
        break label938;
      }
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. Completed.");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putInt("GetFrdListReq_seq", i2).commit();
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
      return;
      if (i2 != 1) {
        break label1035;
      }
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
      return;
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    label155:
    label577:
    label629:
    label889:
    return;
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    boolean bool1;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject) == null)
    {
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {
        if (i1 == 1) {
          bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
        }
      }
      label257:
      for (;;)
      {
        label73:
        if (i1 == 1) {
          a(81, bool1, Boolean.valueOf(bool2));
        }
        label167:
        do
        {
          return;
          if (i1 == 1) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              break label167;
            }
            QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission " + paramToServiceMsg.getMessage());
          }
          if (i1 == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool2, false);
            break label260;
            bool1 = false;
            break;
          }
          if (i1 != 3) {
            break label260;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool2, false);
          break label260;
          if (i1 != 2) {
            break label257;
          }
          bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          break label73;
          if (i1 == 2)
          {
            a(83, bool1, Boolean.valueOf(bool2));
            return;
          }
        } while (i1 != 3);
        a(85, bool1, null);
        return;
      }
      label260:
      bool1 = true;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1;
    int i1;
    Object localObject;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i1 = paramToServiceMsg.extraData.getInt("key_permission_opcode");
      paramFromServiceMsg = null;
      localObject = null;
      if (!bool1) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          bool2 = true;
          if (!bool2) {
            continue;
          }
          paramObject = new cmd0x7c7.RspBody();
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (i1 != 1) {
            continue;
          }
          i2 = paramObject.uint32_not_see_qzone.get();
          if (i2 != 1) {
            continue;
          }
          bool1 = true;
          bool3 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (paramObject.uint32_not_see_qzone.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.add(Boolean.valueOf(bool1));
            if (paramObject.uint32_prevent_dynamic.get() == 1)
            {
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.f(bool1, false);
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.g(bool1, false);
              bool1 = true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (paramToServiceMsg == null) {
            continue;
          }
          int i2 = paramToServiceMsg.uint32_result.get();
          paramToServiceMsg = localObject;
          bool1 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission  fail resultCode : " + i2);
          paramToServiceMsg = localObject;
          bool1 = bool4;
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
          bool1 = bool3;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission Exception " + paramToServiceMsg.getMessage());
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = false;
        continue;
        paramToServiceMsg = localObject;
        bool1 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "ssoPkg is null");
        paramToServiceMsg = localObject;
        bool1 = bool4;
        continue;
        if (i1 == 2)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          paramFromServiceMsg = paramToServiceMsg;
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool3 = bool1;
        if (i1 != 3) {
          continue;
        }
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false)));
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false)));
        bool3 = bool1;
        continue;
        if (i1 == 2)
        {
          a(84, bool2, Boolean.valueOf(bool3));
          return;
        }
        if (i1 != 3) {
          continue;
        }
        a(86, bool2, paramFromServiceMsg);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool1, false);
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
        continue;
        paramToServiceMsg = null;
        bool1 = true;
        continue;
      }
      paramFromServiceMsg = paramToServiceMsg;
      bool3 = bool1;
      if (!bool2)
      {
        if (i1 == 1)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      else
      {
        if (i1 != 1) {
          continue;
        }
        a(82, bool2, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool1 = false;
        continue;
        if (i1 == 2)
        {
          i2 = paramObject.uint32_prevent_dynamic.get();
          if (i2 == 1)
          {
            bool1 = true;
            bool3 = bool1;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool1, false);
            paramToServiceMsg = null;
            continue;
          }
          bool1 = false;
          continue;
        }
        if (i1 != 3) {
          break label694;
        }
        paramToServiceMsg = new ArrayList();
      }
      label694:
      label702:
      bool3 = true;
      boolean bool2 = bool1;
      paramToServiceMsg = null;
      bool1 = bool3;
    }
  }
  
  /* Error */
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_1
    //   4: getfield 816	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   7: ldc_w 2986
    //   10: iconst_1
    //   11: invokevirtual 2022	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   14: istore 7
    //   16: aload_1
    //   17: ifnull +124 -> 141
    //   20: aload_2
    //   21: ifnull +120 -> 141
    //   24: aload_2
    //   25: invokevirtual 1004	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   28: ifeq +113 -> 141
    //   31: aload_3
    //   32: ifnull +109 -> 141
    //   35: iconst_1
    //   36: istore 5
    //   38: aconst_null
    //   39: astore_2
    //   40: iload 5
    //   42: ifeq +296 -> 338
    //   45: new 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   48: dup
    //   49: invokespecial 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   52: astore 8
    //   54: aload 8
    //   56: aload_3
    //   57: checkcast 627	[B
    //   60: checkcast 627	[B
    //   63: invokevirtual 461	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   66: pop
    //   67: aload 8
    //   69: ifnull +78 -> 147
    //   72: aload 8
    //   74: getfield 630	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 469	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: ifne +67 -> 147
    //   83: iload 6
    //   85: istore 5
    //   87: iload 5
    //   89: ifeq +114 -> 203
    //   92: aload_1
    //   93: getfield 816	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc_w 2988
    //   99: invokevirtual 2991	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 686	com/tencent/mobileqq/app/FriendListHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: bipush 49
    //   109: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   112: checkcast 1440	com/tencent/mobileqq/app/FriendsManager
    //   115: astore_2
    //   116: iload 7
    //   118: ifeq +35 -> 153
    //   121: aload_2
    //   122: aload_1
    //   123: invokevirtual 2993	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/util/List;)V
    //   126: iload 7
    //   128: ifeq +196 -> 324
    //   131: aload_0
    //   132: bipush 90
    //   134: iload 5
    //   136: aload_1
    //   137: invokevirtual 969	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   140: return
    //   141: iconst_0
    //   142: istore 5
    //   144: goto -106 -> 38
    //   147: iconst_0
    //   148: istore 5
    //   150: goto -63 -> 87
    //   153: aload_2
    //   154: aload_1
    //   155: invokevirtual 2994	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/util/List;)V
    //   158: goto -32 -> 126
    //   161: astore_2
    //   162: invokestatic 475	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +32 -> 197
    //   168: ldc 64
    //   170: iconst_2
    //   171: new 477	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 2996
    //   181: invokevirtual 484	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 2536	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 484	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 493	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_0
    //   198: istore 5
    //   200: goto -74 -> 126
    //   203: aload 8
    //   205: ifnull +53 -> 258
    //   208: aload 8
    //   210: getfield 630	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   213: invokevirtual 469	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   216: istore 4
    //   218: aload_2
    //   219: astore_1
    //   220: invokestatic 475	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq -97 -> 126
    //   226: ldc 64
    //   228: iconst_2
    //   229: new 477	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 2998
    //   239: invokevirtual 484	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload 4
    //   244: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 493	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_2
    //   254: astore_1
    //   255: goto -129 -> 126
    //   258: aload_2
    //   259: astore_1
    //   260: invokestatic 475	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -137 -> 126
    //   266: ldc 64
    //   268: iconst_2
    //   269: ldc_w 3000
    //   272: invokestatic 493	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_2
    //   276: astore_1
    //   277: goto -151 -> 126
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: invokestatic 475	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +32 -> 318
    //   289: ldc 64
    //   291: iconst_2
    //   292: new 477	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 2996
    //   302: invokevirtual 484	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 487	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   309: invokevirtual 484	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 493	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iconst_0
    //   319: istore 5
    //   321: goto -195 -> 126
    //   324: aload_0
    //   325: bipush 91
    //   327: iload 5
    //   329: aload_1
    //   330: invokevirtual 969	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   333: return
    //   334: astore_2
    //   335: goto -52 -> 283
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -214 -> 126
    //   343: astore_2
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -184 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	FriendListHandler
    //   0	349	1	paramToServiceMsg	ToServiceMsg
    //   0	349	2	paramFromServiceMsg	FromServiceMsg
    //   0	349	3	paramObject	Object
    //   216	27	4	i1	int
    //   36	292	5	bool1	boolean
    //   1	83	6	bool2	boolean
    //   14	113	7	bool3	boolean
    //   52	157	8	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    // Exception table:
    //   from	to	target	type
    //   103	116	161	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   121	126	161	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   153	158	161	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	67	280	java/lang/Exception
    //   72	83	280	java/lang/Exception
    //   92	103	280	java/lang/Exception
    //   208	218	280	java/lang/Exception
    //   220	253	280	java/lang/Exception
    //   260	275	280	java/lang/Exception
    //   103	116	334	java/lang/Exception
    //   121	126	334	java/lang/Exception
    //   153	158	334	java/lang/Exception
    //   45	67	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   72	83	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   92	103	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   208	218	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   220	253	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   260	275	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i1 = 0;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend success=" + bool1);
      }
      if (!bool1) {
        break label1304;
      }
    }
    for (;;)
    {
      int i5;
      ArrayList localArrayList;
      MayKnowRecommend localMayKnowRecommend;
      Object localObject;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result != null))
        {
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleMayKnowRecommend isSuccess=" + bool1 + " result=" + 0);
          }
          if (bool1)
          {
            i2 = paramFromServiceMsg.uint32_result.get();
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("FriendListHandler", 2, "handleMayKnowRecommend result=" + i2);
              i1 = i2;
            }
          }
          if ((i1 & 0xFF) != 132) {
            continue;
          }
          bool1 = paramToServiceMsg.extraData.getBoolean("isExpired", false);
          if (bool1) {
            ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).g(null);
          }
          a(92, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(false), null });
          return;
          bool1 = false;
          break;
        }
        bool1 = false;
        continue;
        if ((!bool1) || (i1 != 0) || (paramFromServiceMsg.bytes_bodybuffer == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          break label1249;
        }
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i1 = paramFromServiceMsg.get();
        i2 = paramFromServiceMsg.getShort();
        int i4 = paramFromServiceMsg.get();
        if (i4 != 1) {
          break label1298;
        }
        bool1 = false;
        i5 = paramFromServiceMsg.getShort();
        int i3 = paramFromServiceMsg.getShort();
        new HashMap(i3);
        paramObject = new StringBuffer();
        if (QLog.isColorLevel())
        {
          paramObject.append("handleMayKnowRecommend cFlag=");
          paramObject.append(i1);
          paramObject.append(" wTotalUinNum=");
          paramObject.append(i2);
          paramObject.append(" cEndFlag=");
          paramObject.append(i4);
          paramObject.append(" wEndPos=");
          paramObject.append(i5);
          paramObject.append(" wUinNum=");
          paramObject.append(i3);
        }
        localArrayList = new ArrayList(i3);
        if (i3 <= 0) {
          break label1147;
        }
        i1 = 0;
        if (i1 >= i3) {
          break label1131;
        }
        localMayKnowRecommend = new MayKnowRecommend();
        paramFromServiceMsg.getShort();
        localObject = String.valueOf(Utils.a(paramFromServiceMsg.getInt()));
        localMayKnowRecommend.uin = ((String)localObject);
        if (QLog.isColorLevel())
        {
          paramObject.append(" \nuin=");
          paramObject.append((String)localObject);
        }
        paramFromServiceMsg.get();
        i4 = paramFromServiceMsg.get();
        i2 = 0;
        if (i2 >= i4) {
          break label1111;
        }
        i5 = paramFromServiceMsg.get();
        int i6 = paramFromServiceMsg.get();
        localObject = new byte[i6];
        paramFromServiceMsg.get((byte[])localObject, 0, i6);
        if (!QLog.isColorLevel()) {
          break label1310;
        }
        paramObject.append(" type=");
        paramObject.append(i5);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleMayKnowRecommend e", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        i1 = i2;
        a(92, false, Integer.valueOf(i1));
        return;
        localMayKnowRecommend.age = Utils.a((byte[])localObject, 0);
        if (!QLog.isColorLevel()) {
          break label1360;
        }
        paramObject.append(" age=");
        paramObject.append(localMayKnowRecommend.age);
      }
      catch (Exception paramToServiceMsg)
      {
        i2 = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleMayKnowRecommend ex", paramToServiceMsg);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        i1 = i2;
        continue;
        localMayKnowRecommend.gender = Utils.a((byte[])localObject, 0);
        if (!QLog.isColorLevel()) {
          break label1360;
        }
        paramObject.append(" gender=");
        paramObject.append(localMayKnowRecommend.gender);
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
      }
      localMayKnowRecommend.remark = new String((byte[])localObject);
      if (QLog.isColorLevel())
      {
        paramObject.append(" remark=");
        paramObject.append(localMayKnowRecommend.remark);
        break label1360;
        label756:
        localMayKnowRecommend.country = new String((byte[])localObject);
        if (QLog.isColorLevel())
        {
          paramObject.append(" country=");
          paramObject.append(localMayKnowRecommend.country);
          break label1360;
          localMayKnowRecommend.province = new String((byte[])localObject);
          if (QLog.isColorLevel())
          {
            paramObject.append(" province=");
            paramObject.append(localMayKnowRecommend.province);
            break label1360;
            localMayKnowRecommend.city = new String((byte[])localObject);
            if (QLog.isColorLevel())
            {
              paramObject.append(" city=");
              paramObject.append(localMayKnowRecommend.city);
              break label1360;
              localMayKnowRecommend.nick = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" nick=");
                paramObject.append(localMayKnowRecommend.nick);
                break label1360;
                label1111:
                localArrayList.add(localMayKnowRecommend);
                i1 = (short)(i1 + 1);
                continue;
                label1131:
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, paramObject.toString());
                }
                label1147:
                boolean bool2 = paramToServiceMsg.extraData.getBoolean("isExpired", false);
                if (bool2) {
                  ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).g(localArrayList);
                }
                a(92, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localArrayList });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
                return;
                label1249:
                for (i2 = i1;; i2 = 0)
                {
                  i1 = i2;
                  if (!QLog.isColorLevel()) {
                    break label756;
                  }
                  QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
                  i1 = i2;
                  break label756;
                  bool1 = true;
                  break;
                }
                label1298:
                label1304:
                label1310:
                switch (i5)
                {
                }
              }
            }
          }
        }
      }
      label1360:
      int i2 = (byte)(i2 + 1);
    }
  }
  
  private void x(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool;
    Object localObject;
    if ((??? != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label732;
      }
      localObject = new oidb_0x7df.RspBody();
      ??? = a(???, paramFromServiceMsg, paramObject);
      if (??? == null) {
        break label369;
      }
    }
    int i1;
    label369:
    label375:
    label381:
    do
    {
      for (;;)
      {
        try
        {
          ((oidb_0x7df.RspBody)localObject).mergeFrom(???.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + bool);
          }
          if (!bool) {
            break label732;
          }
          a(94, true, localObject);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend isOver: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_over.has()) {
              break label375;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_over.get();
            ??? = ???.append(i1).append(", next: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_next_start.has()) {
              break label381;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_next_start.get();
            ??? = ???.append(i1).append(", total: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_total.has()) {
              break label387;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_total.get();
            ??? = ???.append(i1).append(", lowest: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_low_score.has()) {
              break label393;
            }
            i1 = ((oidb_0x7df.RspBody)localObject).uint32_low_score.get();
            QLog.d("FriendListHandler", 2, i1);
          }
          if (((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.has()) {
            break label399;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
          bool = false;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
          }
          ???.printStackTrace();
          bool = false;
          continue;
        }
        bool = false;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
        continue;
        i1 = -1;
      }
      paramFromServiceMsg = ((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
        break label437;
      }
    } while (!QLog.isColorLevel());
    label387:
    label393:
    label399:
    QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
    return;
    label437:
    paramObject = paramFromServiceMsg.iterator();
    while (paramObject.hasNext())
    {
      localObject = (oidb_0x7df.FriendScore)paramObject.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend uin: ");
        if (((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.has())
        {
          ??? = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          label508:
          ??? = localStringBuilder.append(???).append(", score: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_friend_score.has()) {
            break label675;
          }
          i1 = ((oidb_0x7df.FriendScore)localObject).uint32_friend_score.get();
          label542:
          localStringBuilder = ???.append(i1).append(", relation: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_relation_name.has()) {
            break label681;
          }
          ??? = ((oidb_0x7df.FriendScore)localObject).bytes_relation_name.get().toStringUtf8();
          label579:
          ??? = localStringBuilder.append(???).append(", rank: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_rank.has()) {
            break label688;
          }
          i1 = ((oidb_0x7df.FriendScore)localObject).uint32_rank.get();
          label613:
          localStringBuilder = ???.append(i1).append(", nick: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_nick.has()) {
            break label694;
          }
        }
        label675:
        label681:
        label688:
        label694:
        for (??? = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();; ??? = "")
        {
          QLog.d("FriendListHandler", 2, ???);
          break;
          ??? = "";
          break label508;
          i1 = -1;
          break label542;
          ??? = "";
          break label579;
          i1 = -1;
          break label613;
        }
      }
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramFromServiceMsg);
      return;
    }
    label732:
    a(94, false, null);
  }
  
  protected Class a()
  {
    return FriendListObserver.class;
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public String a(long paramLong)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int i2 = localObject1.length;
          while (i1 < i2)
          {
            Object localObject2 = localObject1[i1].split(":");
            long l1 = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), localObject2);
            i1 += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public ArrayList a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.ring");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 2);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    localArrayList.add("message.ring.care");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l1 = Long.parseLong((String)localObject);; l1 = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l1);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, 0, null, 0);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    boolean bool;
    if (paramInt1 == 0)
    {
      bool = true;
      if (paramInt2 != 1) {
        break label550;
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
      }
      paramString2 = new hju(this);
      paramString2.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilHashtable.put(paramString1, paramString2);
    }
    for (;;)
    {
      Object localObject;
      if (((!bool) || (paramInt2 == 4)) && (paramString2 != null))
      {
        long l3 = paramString2.b - paramString2.jdField_a_of_type_Long;
        long l2 = 0L;
        long l1 = l2;
        if (paramString2.c > paramString2.b)
        {
          l1 = l2;
          if (paramString2.b > 0L) {
            l1 = paramString2.c - paramString2.b;
          }
        }
        l2 = paramString2.d - paramString2.c;
        localObject = new StringBuffer(200);
        ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
        ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
        ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.e) }));
        ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
        ((StringBuffer)localObject).append(", downInfoTime=").append(l3);
        ((StringBuffer)localObject).append(", intervalTime=").append(l1);
        ((StringBuffer)localObject).append(", downPicTime=").append(l2);
        ((StringBuffer)localObject).append(", reasonCode=").append(paramInt4);
        ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("QQHeadCostTime", 2, ((StringBuffer)localObject).toString());
        }
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l3));
          ((HashMap)localObject).put("interval_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l2));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", paramInt1 + "");
          if (paramInt4 != 0) {
            ((HashMap)localObject).put("fail_reason", paramInt4 + "");
          }
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actFriendGetQQHead", bool, paramString2.e, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
      }
      return;
      bool = false;
      break;
      label550:
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1))
      {
        localObject = (hju)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        switch (paramInt2)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((hju)localObject).b = System.currentTimeMillis();
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((hju)localObject).e = (((hju)localObject).b - ((hju)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((hju)localObject).c = System.currentTimeMillis();
          paramString2 = (String)localObject;
          break;
          ((hju)localObject).d = System.currentTimeMillis();
          ((hju)localObject).jdField_a_of_type_Int = paramInt3;
          ((hju)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((hju)localObject).e = (((hju)localObject).d - ((hju)localObject).jdField_a_of_type_Long);
          this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
        }
      }
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = a("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getRecomGatheredList(). startIndex = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    localToServiceMsg.extraData.putBoolean("isGetRecomm", true);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localToServiceMsg.extraData.putBoolean("beforeShowTip", paramBoolean);
    cmd0x7c4.GetRecommendSNFrdListReq localGetRecommendSNFrdListReq = new cmd0x7c4.GetRecommendSNFrdListReq();
    localGetRecommendSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getInt("GetRecomFrdListReq_seq", 0);
    localGetRecommendSNFrdListReq.uint32_sequence.set(i1);
    localGetRecommendSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetRecommendSNFrdListReq.uint32_req_num.set(bI);
    localReqBody.msg_get_recommend_sn_frd_list_req.set(localGetRecommendSNFrdListReq);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    int i2 = -1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setSpecialCareSwitch(). type=").append(paramInt).append(", uin size=");
      if (paramArrayOfString != null) {
        break label112;
      }
      i1 = -1;
      localObject1 = ((StringBuilder)localObject1).append(i1).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label119;
      }
    }
    label112:
    label119:
    for (int i1 = i2;; i1 = paramArrayOfBoolean.length)
    {
      QLog.d("set_special_care_switch", 2, i1);
      if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label126;
      }
      return;
      i1 = paramArrayOfString.length;
      break;
    }
    label126:
    Object localObject1 = new ArrayList();
    i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i1];
      int i3 = paramArrayOfBoolean[i1];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i1 += 1;
        break;
        byte[] arrayOfByte;
        if (i3 != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          if (i3 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          if (i3 != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index", ConditionSearchManager.b(paramInt3));
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i1 = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < i1)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      DeviceLockItemInfo localDeviceLockItemInfo = (DeviceLockItemInfo)paramArrayList.get(paramInt2);
      if (localDeviceLockItemInfo == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_b_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localDeviceLockItemInfo.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localDeviceLockItemInfo.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = a("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i1;
    Object localObject1;
    long l1;
    Object localObject2;
    if (paramBoolean)
    {
      i1 = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i1);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l1);
      }
      if (!paramBoolean) {
        break label321;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
      i1 = 2;
      break;
      label321:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l1);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", 0L);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = a("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 4051, paramBoolean);
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate called");
    }
    if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("FriendListHandler::handleCheckUpdate called data result = ");
        if (paramCheckUpdateResp == null) {
          break label80;
        }
      }
      label80:
      for (int i1 = paramCheckUpdateResp.result;; i1 = -1)
      {
        QLog.d("ProfileService.CheckUpdateReq", 2, i1 + " decode failed return now");
        return;
      }
    }
    Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
    paramCheckUpdateResp = null;
    if (localIterator.hasNext())
    {
      Object localObject2 = (RespItem)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      CheckUpdateItemInterface localCheckUpdateItemInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(((RespItem)localObject2).eServiceID);
      if (localCheckUpdateItemInterface != null) {
        if (((RespItem)localObject2).eServiceID == 101)
        {
          localObject1 = localCheckUpdateItemInterface;
          paramCheckUpdateResp = (CheckUpdateResp)localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject1 = paramCheckUpdateResp;
        paramCheckUpdateResp = (CheckUpdateResp)localObject2;
        break;
        localCheckUpdateItemInterface.a((RespItem)localObject2);
        if ((localObject2 != null) && (((RespItem)localObject2).eServiceID == 109) && (2 == ((RespItem)localObject2).cResult)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(Integer.valueOf(((RespItem)localObject2).eServiceID));
        }
        localObject2 = paramCheckUpdateResp;
        paramCheckUpdateResp = (CheckUpdateResp)localObject1;
        localObject1 = localObject2;
      }
    }
    if ((paramCheckUpdateResp != null) && (localObject1 != null)) {
      paramCheckUpdateResp.a((RespItem)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int i2 = paramFromServiceMsg.size();
          int i1 = 0;
          label137:
          if (i1 < i2)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(i1);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              i1 += 1;
              break label137;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              paramObject.printStackTrace();
              break;
              DeviceLockItemInfo localDeviceLockItemInfo = new DeviceLockItemInfo();
              if (localDeviceInfo.bytes_appname.has())
              {
                localDeviceLockItemInfo.jdField_c_of_type_JavaLangString = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localDeviceLockItemInfo.jdField_b_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localDeviceLockItemInfo.jdField_a_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localDeviceLockItemInfo.jdField_c_of_type_Int = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localDeviceLockItemInfo.jdField_a_of_type_Int = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localDeviceLockItemInfo.jdField_b_of_type_Int = localDeviceInfo.uint32_subappid.get();
                            paramObject.add(localDeviceLockItemInfo);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (paramObject.size() <= 0) {
            break label444;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        a(69, true, paramObject);
        return;
      }
      label444:
      a(69, false, null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label184:
    label319:
    label1221:
    label1227:
    do
    {
      int i1;
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList")) {
                  break label319;
                }
                if (!paramFromServiceMsg.isSuccess()) {
                  break label184;
                }
                paramObject = (GetFriendListResp)paramObject;
                if (paramObject == null) {
                  break;
                }
                if (paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                {
                  a(paramToServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
                {
                  a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg.extraData.getLong("timeStamp"), paramToServiceMsg.extraData.getStringArrayList("uinList"));
                  return;
                }
              } while (!QLog.isColorLevel());
              QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
              return;
              this.g = 0L;
              a(1, false, null);
              a(98, false, null);
              return;
              if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
              {
                i1 = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "k_resend_cnt" + i1);
                }
                if (i1 < 2)
                {
                  paramToServiceMsg.extraData.putInt("k_resend_cnt", i1 + 1);
                  a(paramToServiceMsg);
                  return;
                }
                this.g = 0L;
                a(1, false, null);
                a(98, false, null);
                return;
              }
              this.g = 0L;
              a(1, false, null);
              a(98, false, null);
              return;
              if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.RecommendAuth"))
              {
                a(paramFromServiceMsg, paramObject);
                return;
              }
              if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.ConfirmAuth"))
              {
                c(paramFromServiceMsg.isSuccess());
                return;
              }
              if (paramFromServiceMsg.getServiceCmd().equals("friendlist.GetLastLoginInfoReq"))
              {
                a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
                return;
              }
              if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
                break;
              }
            } while (!paramFromServiceMsg.isSuccess());
            i1 = paramToServiceMsg.extraData.getInt("reqType", 0);
            if (i1 == 1)
            {
              a(paramToServiceMsg, paramObject);
              return;
            }
            if (i1 == 0)
            {
              c(paramToServiceMsg, paramObject);
              return;
            }
            b(paramToServiceMsg, paramObject);
            return;
            if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
          } while (!paramFromServiceMsg.isSuccess());
          paramObject = (ArrayList)paramObject;
        } while ((paramObject == null) || (localObject == null));
        a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
        return;
        if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
          return;
        }
        if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("StatSvc.GetDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
          {
            b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
          {
            c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
          {
            d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
            return;
          }
          a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
          return;
        }
        if ("StatSvc.DelDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
          {
            b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
            return;
          }
          if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
          {
            a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
            return;
          }
          c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
          return;
        }
        if ("StatSvc.SvcReqKikOut".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
          return;
        }
        if ("StatSvc.BindUin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
          return;
        }
        if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
          return;
        }
        if ("ProfileService.ReqSetSettings".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
          return;
        }
        if (!"friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        i1 = paramToServiceMsg.extraData.getByte("move_fri_type");
        if (i1 == 0)
        {
          if (paramObject != null)
          {
            a(paramToServiceMsg, (MovGroupMemResp)paramObject);
            return;
          }
          a(9, false, null);
          return;
        }
      } while ((i1 != 1) || (paramObject == null));
      paramToServiceMsg = (MovGroupMemResp)paramObject;
      return;
      if ("BumpSvc.ReqComfirmContactFriend".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramFromServiceMsg.isSuccess())
        {
          a(paramToServiceMsg, true);
          return;
        }
        a(10, false, null);
        return;
      }
      if ("friendlist.addFriend".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a((AddFriendResp)paramObject, paramToServiceMsg);
        return;
      }
      if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
        return;
      }
      if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          b(paramFromServiceMsg, paramObject);
          return;
        }
        a(13, false, null);
        return;
      }
      if ("friendlist.GetOnlineInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.delFriend".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (DelFriendResp)paramObject);
          return;
        }
        a(15, false, null);
        return;
      }
      if ("friendlist.SetGroupReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", -1000)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
          if (paramObject == null) {
            break label1221;
          }
        }
        for (;;)
        {
          QLog.d("FriendListHandler", 2, bool);
          if (!paramFromServiceMsg.isSuccess()) {
            break label1227;
          }
          paramFromServiceMsg = (SetGroupResp)paramObject;
          if (paramFromServiceMsg == null) {
            break;
          }
          a(paramToServiceMsg, paramFromServiceMsg);
          return;
          bool = false;
        }
        switch (paramToServiceMsg.extraData.getInt("set_type", -1))
        {
        default: 
          return;
        case 0: 
          a(18, false, null);
          return;
        case 1: 
          a(19, false, null);
          return;
        case 2: 
          a(21, false, null);
          return;
        }
        a(22, false, null);
        return;
      }
      if ("ProfileService.ChangeFriendName".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
        }
        if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
        }
        a((CheckUpdateResp)paramObject);
        return;
      }
      if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x491_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x490_107".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5e1_8".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0x49d_107".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("isGetRecomm"))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c6_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c7_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x847_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7df_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        x(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList1, FromServiceMsg paramFromServiceMsg, ArrayList paramArrayList2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    localEntityTransaction = localFriendsManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        Iterator localIterator = paramArrayList2.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localProfSmpInfoRes = (ProfSmpInfoRes)localIterator.next();
        str = String.valueOf(localProfSmpInfoRes.dwUin);
        if (!paramArrayList1.contains(str)) {
          continue;
        }
        if (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, localProfSmpInfoRes.strNick);
        }
        if (255 == localProfSmpInfoRes.cSpecialFlag) {
          localProfSmpInfoRes.cSpecialFlag = 0;
        }
        int i1 = localProfSmpInfoRes.cSpecialFlag;
        if (1 == i1) {
          try
          {
            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              paramFromServiceMsg = paramFromServiceMsg.iterator();
              if (paramFromServiceMsg.hasNext())
              {
                localObject = (MessageRecord)paramFromServiceMsg.next();
                if (((MessageRecord)localObject).msgtype != -1013) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0, ((MessageRecord)localObject).uniseq);
                continue;
              }
            }
            localFriendsManager.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.wFace, localProfSmpInfoRes.strNick, null, localProfSmpInfoRes.cSpecialFlag, (short)localProfSmpInfoRes.cSex, localProfSmpInfoRes.wAge);
          }
          catch (Exception paramFromServiceMsg)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
        paramFromServiceMsg = localFriendsManager.b(str);
        paramFromServiceMsg.nFaceID = localProfSmpInfoRes.wFace;
        paramFromServiceMsg.shGender = ((short)localProfSmpInfoRes.cSex);
        paramFromServiceMsg.age = localProfSmpInfoRes.wAge;
        paramFromServiceMsg.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          paramFromServiceMsg.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          paramFromServiceMsg.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          paramFromServiceMsg.strCity = localProfSmpInfoRes.sCity;
        }
        if ((str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localProfSmpInfoRes.wLevel != 0)) {
          paramFromServiceMsg.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay < 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          continue;
        }
        paramFromServiceMsg.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        paramFromServiceMsg.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList1)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList1);
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        if (!paramToServiceMsg.extraData.getBoolean("batch_data")) {
          continue;
        }
        a(67, true, paramArrayList2);
        return;
        boolean bool = false;
        continue;
        localEntityTransaction.c();
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
      }
      paramFromServiceMsg.setXManFlag(bool);
      if (paramArrayList1.size() == 1)
      {
        if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          paramFromServiceMsg.allowPeopleSee = localProfSmpInfoRes.bOpenLoginDays;
        }
        paramFromServiceMsg.allowClick = localProfSmpInfoRes.bXManIconClick;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "card.allowClick=" + paramFromServiceMsg.allowClick + ";card.allowPeopleSee= " + paramFromServiceMsg.allowPeopleSee);
      }
      localFriendsManager.a(paramFromServiceMsg);
      if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
      {
        localObject = localProfSmpInfoRes.sDateNick;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramFromServiceMsg = localProfSmpInfoRes.strNick;
        }
        localObject = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          localObject = str;
        }
        localFriendsManager.b(str, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | uin=" + str + " | datenick = " + localProfSmpInfoRes.sDateNick + " | nick=" + localProfSmpInfoRes.strNick);
        }
        a(89, true, new Object[] { str, localObject });
      }
      if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
      {
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + localProfSmpInfoRes.wLevel);
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
      {
        ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay = " + localProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay = " + localProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan = " + localProfSmpInfoRes.isShowXMan);
        }
      }
      a(3, true, str);
    }
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramBoolean) {
      localFriendsManagerImp.a(paramDelGroupResp.cGroupid);
    }
    a(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 3000, (byte)0, paramByte, null, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 3000, paramByte1, paramByte2, null, false);
  }
  
  public void a(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2)
  {
    if (paramByte1 == 1)
    {
      a(100, paramString1, 3000, paramByte2, paramByte3, paramString2, false);
      return;
    }
    a(1, paramString1, 3000, paramByte2, paramByte3, null, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      if (paramInt == 2)
      {
        ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
      break;
      label168:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      }
    }
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((Friends.isValidUin(paramString)) && (b(paramString)))
    {
      a(new String[] { paramString });
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putInt("type", paramInt);
      localToServiceMsg.extraData.putString("discussionUin", String.valueOf(paramLong));
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    b(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriend" + paramString1 + ";friendSetting " + paramInt1 + ";groupId " + paramByte + ";msg " + paramString3 + ";sourceID " + paramInt2 + ";subSourceId " + paramInt3 + ";autoSend " + paramBoolean1 + ";extraUin " + paramString2 + ";isContactBothWay " + paramBoolean2 + ";remark " + paramString4 + ";srcName " + paramString5);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.addFriend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("uin", paramString1);
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putByte("group_id", paramByte);
    localBundle.putString("msg", paramString3);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("extra", paramString2);
    localBundle.putBoolean("auto_send", paramBoolean1);
    localBundle.putByteArray("sig", paramArrayOfByte);
    localBundle.putBoolean("contact_bothway", paramBoolean2);
    localBundle.putString("remark", paramString4);
    localBundle.putString("src_name", paramString5);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = a("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      a((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      Card localCard = paramString2.b(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.a(paramString1, (String)localObject, (byte)1);
      paramString2.a(paramString1, (String)localObject);
      paramString1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    } while (paramString1 == null);
    paramString1.e();
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (b(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", c(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", e(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("uin=").append(paramString).append(", type size=");
      if (paramArrayOfInt != null) {
        break label142;
      }
      localObject1 = "";
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", switchState size=");
      if (paramArrayOfBoolean != null) {
        break label152;
      }
      localObject1 = "null";
      label64:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ringId size=");
      if (paramArrayOfString != null) {
        break label162;
      }
    }
    label142:
    label152:
    label162:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayOfString.length))
    {
      QLog.d("set_special_care_switches_of_a_person", 2, localObject1);
      if ((!StringUtil.b(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
        break label173;
      }
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt.length);
      break;
      localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      break label64;
    }
    label173:
    Object localObject2 = new ArrayList();
    localObject1 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      int i2 = paramArrayOfInt[i1];
      int i3 = paramArrayOfBoolean[i1];
      Object localObject3 = paramArrayOfString[i1];
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      switch (i2)
      {
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i3 != 0)
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
        }
        else
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          if (i3 != 0)
          {
            if (StringUtil.b((String)localObject3)) {
              throw new IllegalArgumentException("special ring id can not be empty!");
            }
            localObject3 = ((String)localObject3).getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          if (i3 != 0)
          {
            localObject3 = "1".getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
        }
      }
    }
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatusPush", 2, "handlePushBatchFStatus uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + " at " + System.currentTimeMillis());
    }
    ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramArrayList);
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localHashMap.put(String.valueOf(((RequestPushFStatus)paramArrayList.next()).lUin), "");
    }
    a(8, true, localHashMap);
    if (this.bG == 0)
    {
      this.bG = 1;
      new Handler(Looper.getMainLooper()).postDelayed(new hjq(this), 15000L);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      String str = (String)paramArrayList1.get(i1);
      int i2 = ((Integer)paramArrayList2.get(i1)).intValue();
      localArrayList1.add("message.group.policy." + str);
      localArrayList2.add(String.valueOf(i2));
      i1 += 1;
    }
    a(localArrayList1, localArrayList2, 1);
  }
  
  protected void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList1.size())
    {
      localArrayList.add(new GeneralSettings.Setting((String)paramArrayList1.get(i1), (String)paramArrayList2.get(i1)));
      i1 += 1;
    }
    paramArrayList1 = a("ProfileService.ReqSetSettings");
    paramArrayList1.extraData.putSerializable("Settings", localArrayList);
    paramArrayList1.extraData.putInt("local_type", paramInt);
    a(paramArrayList1);
  }
  
  public void a(short paramShort, List paramList, boolean paramBoolean)
  {
    if ((paramShort <= 0) || (paramList == null) || (paramShort != paramList.size())) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1268);
        localOIDBSSOPkg.uint32_service_type.set(5);
        if (!paramBoolean) {
          break label289;
        }
        s1 = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s1);
        ((ByteBuffer)localObject).putShort(paramShort);
        s1 = 0;
        if (s1 >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramList.get(s1))));
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putShort((short)2);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject).putShort((short)1);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)0);
        }
      }
      catch (Exception paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "gatherContacts  Exception " + paramList.getMessage());
      return;
      label203:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      Object localObject = a("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      s1 += 1;
      continue;
      label289:
      short s1 = paramShort * 9 + 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + l1 + ", " + this.g);
    }
    if ((this.g > 0L) && (l1 - this.g < 300000L)) {
      return;
    }
    this.g = l1;
    ArrayList localArrayList = new ArrayList();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 20, 0, 100, 0L, localArrayList, paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().entrySet().iterator();
      Object localObject2 = new ArrayList();
      while (((Iterator)localObject1).hasNext())
      {
        Integer localInteger = (Integer)((Map.Entry)((Iterator)localObject1).next()).getKey();
        if (localInteger.intValue() != 101) {
          ((ArrayList)localObject2).add(localInteger);
        }
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().remove(localObject2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate called CheckUpdateItemInterface count = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a().size());
    }
    Object localObject1 = a("ProfileService.CheckUpdateReq");
    ((ToServiceMsg)localObject1).addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject1);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c6.ReqBody();
    ((cmd0x7c6.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    int i1;
    if (paramInt == 1)
    {
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
      if (paramBoolean)
      {
        i1 = 1;
        paramString.set(i1);
        label48:
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1990);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c6.ReqBody)localObject).toByteArray()));
        localObject = a("OidbSvc.0x7c6_0");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        if (paramInt != 1) {
          break label290;
        }
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putBoolean("key_dongtai_permission", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      i1 = 0;
      break;
      if (paramInt == 2)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
        if (paramBoolean) {}
        for (i1 = 1;; i1 = 0)
        {
          paramString.set(i1);
          break;
        }
      }
      if (paramInt == 3)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
        if (paramBoolean)
        {
          i1 = 1;
          label216:
          paramString.set(i1);
          paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
          if (!paramBoolean) {
            break label250;
          }
        }
        label250:
        for (i1 = 1;; i1 = 0)
        {
          paramString.set(i1);
          break;
          i1 = 0;
          break label216;
        }
      }
      if (paramInt != 4) {
        break label48;
      }
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_recv_msg_box;
      if (paramBoolean == true) {}
      for (i1 = 1;; i1 = 0)
      {
        paramString.set(i1);
        break;
      }
      label290:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      } else if (paramInt == 4) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 4);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    a(localToServiceMsg);
  }
  
  public void a(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    int i2 = 0;
    if ((paramArrayOfLong == null) || (paramArrayOfInt == null)) {
      return;
    }
    int i3 = paramArrayOfLong.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 2 + 4 + i3 * 4);
    localByteBuffer.putShort((short)paramArrayOfInt.length);
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      localByteBuffer.putShort((short)paramArrayOfInt[i1]);
      i1 += 1;
    }
    localByteBuffer.putShort((short)i3);
    i1 = i2;
    while (i1 < i3)
    {
      localByteBuffer.putInt(Utils.a(paramArrayOfLong[i1]));
      i1 += 1;
    }
    paramArrayOfLong = new oidb_sso.OIDBSSOPkg();
    paramArrayOfLong.uint32_command.set(1276);
    paramArrayOfLong.uint32_service_type.set(30);
    paramArrayOfLong.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfInt = a("OidbSvc.0x4fc_30");
    paramArrayOfInt.putWupBuffer(paramArrayOfLong.toByteArray());
    paramArrayOfInt.setTimeout(10000L);
    b(paramArrayOfInt);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
  }
  
  public void a(String[] paramArrayOfString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)1);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    int i1 = 0;
    if (i1 < paramArrayOfString.length)
    {
      int i2;
      label85:
      String[] arrayOfString;
      if (paramArrayOfString.length - i1 < 15)
      {
        i2 = paramArrayOfString.length - i1;
        arrayOfString = new String[i2];
        i2 = 0;
      }
      for (;;)
      {
        if ((i2 >= 15) || (i1 + i2 >= paramArrayOfString.length))
        {
          localToServiceMsg.extraData.putStringArray("uins", arrayOfString);
          a(localToServiceMsg);
          i1 += 15;
          break;
          i2 = 15;
          break label85;
        }
        arrayOfString[i2] = paramArrayOfString[(i1 + i2)];
        i2 += 1;
      }
    }
  }
  
  public void a(String[] paramArrayOfString, Bundle paramBundle)
  {
    a(paramArrayOfString, 0, 1, paramBundle, false);
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfString.length;
    long[] arrayOfLong = new long[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          arrayOfLong[i1] = Long.parseLong(paramArrayOfString[i1]);
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfLong[i1] = 0L;
          }
        }
      }
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      a(arrayOfLong, paramArrayOfInt);
    }
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis() - this.h;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l1 + " | sGetOnlineFriendDelay = " + QQAppInterface.ch);
    }
    return (this.h > 0L) && ((l1 < QQAppInterface.ch) || (l1 > QQAppInterface.cg - QQAppInterface.ch));
  }
  
  public boolean a(int paramInt1, int paramInt2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: start: " + paramInt1 + ", count: " + paramInt2 + ", uinList: " + paramArrayList + ", isSort: " + paramBoolean1 + ", reqNick: " + paramBoolean2);
    }
    if (((paramArrayList == null) || (paramArrayList.size() <= 0)) && ((paramInt1 < 0) || (paramInt2 <= 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
      }
      return false;
    }
    paramArrayList = new oidb_0x7df.ReqBody();
    paramArrayList.uint32_seq.set(0);
    paramArrayList.uint32_start_index.set(paramInt1);
    paramArrayList.uint32_req_num.set(paramInt2);
    Object localObject = paramArrayList.uint32_sort;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = paramArrayList.uint32_nick;
      paramInt1 = i1;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2015);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      paramArrayList = a("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      b(paramArrayList);
      return true;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getFriendGroupList");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetLastLoginInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetRichSig");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_a_of_type_JavaUtilSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.jdField_a_of_type_JavaUtilSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.GetDevLoginInfo");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.DelDevLoginInfo");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.SvcReqKikOut");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.BindUin");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqGetSettings");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqSetSettings");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.MovGroupMemReq");
      this.jdField_a_of_type_JavaUtilSet.add("BumpSvc.ReqComfirmContactFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.addFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getUserAddFriendSetting");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetOnlineInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.delFriend");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.SetGroupReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ChangeFriendName");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.SetRichSig");
      this.jdField_a_of_type_JavaUtilSet.add("StatSvc.register");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetAutoInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.CheckUpdateReq");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSearch");
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqCondSearch");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d1_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4fc_30");
      this.jdField_a_of_type_JavaUtilSet.add("DevLockAuthSvc.RecommendAuth");
      this.jdField_a_of_type_JavaUtilSet.add("DevLockAuthSvc.ConfirmAuth");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x476_146");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x476_147");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x490_107");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x491_107");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5e1_8");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x49d_107");
      this.jdField_a_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7c4_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4f4_5");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7c6_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7c7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x847_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x7df_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d6_7");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localObject != null) {
      ((PhoneContactManager)localObject).c();
    }
    paramBoolean2 = localFriendsManagerImp.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean2);
    }
    if (paramBoolean2)
    {
      if (this.g == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      a(63, true, paramString1);
      localObject = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (localObject != null) {
        ((CircleManager)localObject).a(paramString1);
      }
      a(paramString1);
      localFriendsManagerImp.a(paramString1, false);
      ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85)).a(Long.valueOf(paramString1).longValue());
      if ((!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) && (!CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label333;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, -1L, paramInt2, false, paramString2, paramBoolean1);
      }
    }
    for (;;)
    {
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramString2);
      return paramBoolean2;
      label333:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, -1L, paramInt2, false);
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(short paramShort, boolean paramBoolean, List paramList)
  {
    Object localObject;
    int i2;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getMayKnowRecommend|uinsize = ");
      if (paramList != null) {
        break label235;
      }
      i2 = 0;
    }
    label71:
    int i1;
    ByteBuffer localByteBuffer;
    ArrayList localArrayList;
    for (;;)
    {
      QLog.d("FriendListHandler", 2, i2 + " expected=" + paramShort + " isExpired=" + paramBoolean);
      int i3;
      if (paramList == null)
      {
        i2 = 0;
        if (i2 <= paramShort * 10) {
          break label258;
        }
        i3 = paramShort * 10;
        i1 = (short)i3;
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2119);
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
        localByteBuffer = ByteBuffer.allocate(i1 * 4 + 8 + 2 + 2);
        localByteBuffer.put((byte)1).put((byte)1).putInt(0).putShort(i1);
        localArrayList = new ArrayList();
        i3 = (short)(i2 - i1);
        label173:
        if (i3 >= i2) {
          break label305;
        }
      }
      try
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.get(i3);
        long l1 = Long.parseLong(localMayKnowRecommend.uin);
        localArrayList.add(localMayKnowRecommend.uin);
        localByteBuffer.putInt(Utils.a(l1));
        i3 = (short)(i3 + 1);
        break label173;
        label235:
        i2 = paramList.size();
        continue;
        i2 = (short)paramList.size();
        break label71;
        label258:
        i3 = i2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "getMayKnowRecommend parseLong err index=" + i3, localException);
          }
        }
      }
    }
    label305:
    localByteBuffer.putShort((short)0).putShort(paramShort);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = a("OidbSvc.0x847_3");
    paramList.extraData.putStringArrayList("batchuin", localArrayList);
    paramList.extraData.putShort("uincount", i1);
    paramList.extraData.putBoolean("isExpired", paramBoolean);
    paramList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramList.setTimeout(30000L);
    b(paramList);
    return true;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((!TextUtils.isEmpty(str)) && (e(str))) {
      b(str);
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.vibrate");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 3);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    a(localToServiceMsg);
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 3000, (byte)0, paramByte, null, false);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l1 = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l1 - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i1);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        i1 += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i1 = 0;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      i2 = paramArrayOfString.length;
      i1 = 0;
      if (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((Friends.isValidUin(str)) && (b(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      paramArrayOfString[i1] = ((String)localArrayList.get(i1));
      i1 += 1;
    }
    a(paramArrayOfString);
    paramArrayOfString = a("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    a(paramArrayOfString);
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.m;
    if ((l2 < this.l) && (l2 > -this.l)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.m = l1;
      }
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.jdField_d_of_type_JavaUtilHashtable)
    {
      if (!this.jdField_d_of_type_JavaUtilHashtable.containsKey(paramString)) {
        break label181;
      }
      paramString = (hjs)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
      l2 = Math.abs(l1 - paramString.jdField_a_of_type_Long);
      if (paramString.c > 0L)
      {
        if (l1 < paramString.c) {
          return false;
        }
        paramString.c = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.b = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.b += 1L;
    if (l2 > 60000L)
    {
      if ((paramString.b < 8L) || (l2 >= 120000L)) {
        break label163;
      }
      paramString.c = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      label163:
      paramString.c = 0L;
      paramString.jdField_a_of_type_Long = l1;
      paramString.b = 1L;
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.jdField_d_of_type_JavaUtilHashtable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_d_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        hjs localhjs = (hjs)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localhjs.c == 0L) && (l1 - localhjs.jdField_a_of_type_Long > 60000L)) || ((localhjs.c > 0L) && (l1 > localhjs.c))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int i1;
      if (i1 < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(i1);
        this.jdField_d_of_type_JavaUtilHashtable.remove(localObject2);
        i1 += 1;
      }
      else
      {
        localObject1 = new hjs();
        ((hjs)localObject1).jdField_a_of_type_Long = l1;
        ((hjs)localObject1).b = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i1 = 0;
      }
    }
  }
  
  public void c()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void c(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.ring.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 4);
  }
  
  public void c(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    a(localToServiceMsg);
  }
  
  public void c(String paramString)
  {
    a(1, paramString, 3000, (byte)0, (byte)0, null, false);
  }
  
  public void c(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", Long.parseLong(paramString));
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    boolean bool2 = bool1;
    long l1;
    if (bool1)
    {
      l1 = ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (Math.abs(System.currentTimeMillis() - l1) <= 86400000L) {
        break label109;
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l1 + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void d()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void d(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.vibrate.switch");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 5);
  }
  
  public void d(String paramString)
  {
    a(4, paramString, 3000, (byte)0, (byte)0, null, false);
  }
  
  public void d(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (a())) {}
    do
    {
      return;
      this.h = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public void d(boolean paramBoolean)
  {
    int i1 = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i1 = 0;
    }
    ((ByteBuffer)localObject).put((byte)i1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public boolean d()
  {
    String str;
    if (this.bE == -1)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str == null) || (str.length() <= 0)) {}
    }
    try
    {
      this.bE = Integer.parseInt(str);
      if (this.bE == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.bE + ", " + localException.toString());
        }
      }
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label213;
        }
        long l1 = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l1) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            return bool2;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), true);
          return bool1;
          label213:
          bool1 = true;
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Hny != null) {
      this.jdField_a_of_type_Hny.a();
    }
    super.e();
  }
  
  public void e(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("sync.c2c_message");
    localArrayList2.add(String.valueOf(paramInt));
    a(localArrayList1, localArrayList2, 6);
  }
  
  public void e(String paramString)
  {
    a(11, paramString, 3000, (byte)0, (byte)0, null, false);
  }
  
  public void e(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if ((this.n > 0L) && (l1 - this.n < 3600000L))
    {
      a(80, true, Boolean.valueOf(true));
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "FriendListHandler getRecommGatheredContactsList. smaller than 1 hour.");
      }
      return;
    }
    this.n = l1;
    a(0, paramBoolean);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return false;
    }
    boolean bool = ContactConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (bool) {
      a(0L, 0L, 0L);
    }
    return bool;
  }
  
  public void f(int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    localToServiceMsg.extraData.putBoolean("isGetRecomm", false);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(i1);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(bI);
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getGatheredContactsList(). startIndex = " + paramInt + " | seq = " + i1);
    }
    localReqBody.msg_get_sn_frd_list_req.set(localGetSNFrdListReq);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void f(String paramString)
  {
    new hjr(this, "saveSelfSig", paramString).start();
    ToServiceMsg localToServiceMsg = a("ProfileService.SetRichSig");
    localToServiceMsg.extraData.putString("sig_value", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */