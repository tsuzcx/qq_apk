package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.TLV_CommRsp;
import oicq.wlogin_sdk.devicelock.i;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class WtloginHelper
{
  static final Object GET_ST_WITHOUT_PASSWORD_LOCK = new Object();
  static final Object GET_TICKET_LOCK = new Object();
  static final Object __sync_top;
  static int __top = 0;
  private static b mWtDataSender;
  private boolean isForLocal = false;
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private u mG = new u(null);
  private Handler mHelperHandler = initHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 16724722;
  private int mMiscBitmap = 150470524;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.k mRegStatus = new oicq.wlogin_sdk.a.k();
  private int mSubSigMap = 66560;
  
  static
  {
    __sync_top = new Object();
  }
  
  public WtloginHelper(Context paramContext)
  {
    this.isForLocal = false;
    this.mContext = paramContext;
    this.mG.b(paramContext);
    RequestInit();
  }
  
  public WtloginHelper(Context paramContext, Object paramObject)
  {
    WtloginMsfListener.TicketMgr = paramObject;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, Object paramObject, PrivacyListener paramPrivacyListener)
  {
    WtloginMsfListener.TicketMgr = paramObject;
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, PrivacyListener paramPrivacyListener)
  {
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, boolean paramBoolean)
  {
    localInit(paramContext, paramBoolean);
  }
  
  public WtloginHelper(Context paramContext, boolean paramBoolean, PrivacyListener paramPrivacyListener)
  {
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, paramBoolean);
  }
  
  private void AsyncGenRSAKey()
  {
    if (this.isForLocal) {
      return;
    }
    new WtloginHelper.2(this, "Wtlogin_AsyncGenRSAKey").start();
  }
  
  private int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckPictureAndGetSt").RunReq(2);
      return -1001;
    }
    paramInt = 0;
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    u localu = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(paramWUserSigInfo._seqence);
    util.LOGI("user:" + paramString + " CheckPictureAndGetSt Seq:" + localu.h + " ...", paramString);
    localu.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = localu.b(paramString);
      l1 = l2;
      if (l2 != 0L)
      {
        paramInt = 1;
        l1 = l2;
      }
    }
    int i;
    for (;;)
    {
      if (paramInt == 1)
      {
        localu.f = l1;
        paramWUserSigInfo.uin = (l1 + "");
      }
      if ((u.an == null) || (u.an.length == 0))
      {
        oicq.wlogin_sdk.pow.b.b(localasync_context._t546.get_data());
        util.LOGI("syncCalcPow", "");
      }
      int j = new o(localu).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      i = j;
      if (j == 204) {
        i = new q(localu).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      }
      if ((i == 0) || (i == 160)) {
        break;
      }
      paramInt = i;
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte != null) {
        break label1454;
      }
      paramArrayOfByte = new Ticket();
      label369:
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt != 0) {
        break label1426;
      }
      if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localu.f, localasync_context._appid);
      }
      label436:
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localu.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      u.b();
      localu.i();
      util.LOGI("user:" + paramString + " CheckPictureAndGetSt Seq:" + localu.h + " ret=" + paramInt, "" + localu.f);
      return paramInt;
      l1 = Long.parseLong(paramString);
      paramInt = 1;
    }
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l1 = localu.b(paramString);
      if (l1 == 0L) {
        break label1457;
      }
      paramInt = 1;
    }
    label901:
    label927:
    label1454:
    label1457:
    for (;;)
    {
      if ((localasync_context._msalt == 0L) && (paramInt == 0))
      {
        paramInt = -1003;
        break;
        l1 = Long.parseLong(paramString);
        paramInt = 1;
        continue;
      }
      localu.f = l1;
      paramWUserSigInfo.uin = (l1 + "");
      paramInt = i;
      if (i == 160) {
        break;
      }
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        util.LOGI("MSF SSO SEQ:" + localu.i, paramString);
      }
      for (;;)
      {
        paramArrayOfByte = localu.a(l1, localasync_context._appid);
        if (paramArrayOfByte == null) {
          break label901;
        }
        paramWUserSigInfo.get_clone(paramArrayOfByte);
        if ((localasync_context._sub_appid_list == null) || (paramArrayOfByte1 == null) || (localasync_context._sub_appid_list.length * 2 != paramArrayOfByte1.length)) {
          break;
        }
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte = localu.a(l1, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
        localu.i = 0;
      }
      paramInt = 0;
      break;
      Object localObject;
      if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0))
      {
        paramArrayOfByte = (byte[])paramWUserSigInfo._in_ksid.clone();
        if (localasync_context._tmp_pwd_type == 0) {
          break label1162;
        }
        localObject = new l(localu, this.mContext);
        ((l)localObject).g();
        paramInt = ((l)localObject).a(localasync_context._appid, localasync_context._sub_appid, localu.f, 0, u.ag, localasync_context._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, localasync_context._main_sigmap, localasync_context._sub_appid, u.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
        i = paramInt;
        if (paramInt == 204) {
          i = new q(localu).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
        }
        if (i != 0)
        {
          paramInt = i;
          if (i != 160) {
            break;
          }
        }
        if (!localasync_context.ifQQLoginInQim(u.aA)) {
          break label1290;
        }
      }
      for (l1 = localasync_context._uin;; l1 = localu.b(paramString))
      {
        paramWUserSigInfo.uin = (l1 + "");
        paramInt = i;
        if (i == 160) {
          break;
        }
        paramArrayOfByte = localu.a(l1, localasync_context._appid);
        if (paramArrayOfByte != null) {
          break label1301;
        }
        paramInt = -1004;
        break;
        paramArrayOfByte = u.ad;
        break label927;
        localObject = new byte[4];
        util.int64_to_buf32((byte[])localObject, 0, System.currentTimeMillis() / 1000L + u.af);
        if (localasync_context._isSmslogin) {}
        for (paramInt = 3;; paramInt = 1)
        {
          l locall = new l(localu, this.mContext);
          locall.g();
          paramInt = locall.a(localasync_context._appid, localasync_context._sub_appid, localu.f, 0, u.ag, (byte[])localObject, localasync_context._tmp_pwd, paramInt, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, localasync_context._main_sigmap, localasync_context._sub_appid, u.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
          break;
        }
      }
      paramWUserSigInfo.get_clone(paramArrayOfByte);
      if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
      {
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte = localu.a(l1, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localu.f, localasync_context._appid, 0);
      break label436;
      break label369;
    }
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte1 == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, "CheckSMSAndGetSt").RunReq(4);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    u localu = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(paramWUserSigInfo._seqence);
    util.LOGI(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + "user:" + paramString + " CheckSMSAndGetSt Seq:" + localu.h + "_msalt" + Long.toHexString(localasync_context._msalt) + " ...", paramString);
    localu.g = paramString;
    localu.f = 0L;
    localasync_context._last_err_msg = new ErrMsg();
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localu.i, paramString);
    }
    while (isGateWay(paramWUserSigInfo))
    {
      return checkSMSAndGetStForGateWay(localu, localasync_context, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte2);
      localu.i = 0;
    }
    long l;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = localu.b(paramString);
      if (l != 0L) {
        break label898;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt = -1003;
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      paramArrayOfByte1 = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        paramArrayOfByte1 = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid);
        }
        label425:
        if ((localu.d != null) && (localu.d.get_bitmap() != 0))
        {
          this.mG.d = localu.d;
          RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 1);
        }
        u.b();
        localu.i();
        util.LOGI("user:" + paramString + " CheckSMSAndGetSt Seq:" + localu.h + " ret=" + paramInt, "" + localu.f);
        return paramInt;
      }
    }
    else
    {
      l = Long.parseLong(paramString);
    }
    label898:
    for (;;)
    {
      localu.f = l;
      paramWUserSigInfo.uin = (l + "");
      int i = new p(localu).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
      paramArrayOfByte1 = new StringBuilder().append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV).append("user:").append(paramString).append("ret").append(i).append(",uin:").append(l).append("CheckSMSAndGetSt extraData:");
      if (paramArrayOfByte2 != null) {}
      for (paramInt = paramArrayOfByte2.length;; paramInt = 0)
      {
        util.LOGI(paramInt, "");
        paramInt = i;
        if (i != 0) {
          break;
        }
        paramArrayOfByte1 = localu.a(l, localasync_context._appid);
        if (paramArrayOfByte1 != null) {
          break label745;
        }
        paramInt = -1004;
        break;
      }
      label745:
      paramWUserSigInfo.get_clone(paramArrayOfByte1);
      if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte.length))
      {
        paramInt = 0;
        while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
        {
          paramArrayOfByte1 = localu.a(l, localasync_context._sub_appid_list[paramInt]);
          if (paramArrayOfByte1 != null)
          {
            paramArrayOfByte[(paramInt * 2)] = ((byte[])paramArrayOfByte1._userSt_Key.clone());
            paramArrayOfByte[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte1._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 0);
      break label425;
    }
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    oicq.wlogin_sdk.a.k.y = false;
    oicq.wlogin_sdk.a.k.z = 0L;
    if (((paramLong3 == -1L) && (paramString == null)) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramInt1, paramLong3, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
      return -1001;
    }
    Object localObject = this.mG.a(0L);
    paramWUserSigInfo._seqence = ((u)localObject).h;
    this.mAysncSeq = ((u)localObject).h;
    async_context localasync_context = u.b(((u)localObject).h);
    ((u)localObject).g = paramString;
    util.LOGI("user:" + paramString + " Seq:" + ((u)localObject).h + " CheckSMSVerifyLoginAccount ...", paramString);
    localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
    localasync_context._last_err_msg = new ErrMsg();
    paramInt2 = new y((u)localObject).a(paramLong1, paramLong2, this.mMainSigMap, u.ad, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramInt1, paramLong3, paramWUserSigInfo);
    paramInt1 = paramInt2;
    if (paramInt2 == 208) {
      paramInt1 = 0;
    }
    localObject = new StringBuilder().append("user:").append(((u)localObject).g).append(" Seq:").append(((u)localObject).h).append(" CheckSMSVerifyLoginAccount ret=");
    if (paramInt1 > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt1);; paramWUserSigInfo = Integer.valueOf(paramInt1))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt1;
    }
  }
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private int GetA1WithA1(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2)
  {
    if ((paramString == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramWUserSigInfo == null) || (paramWFastLoginInfo == null)) {
      return -1017;
    }
    int i = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong1, paramLong2, i, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, "GetA1WithA1").RunReq(6);
      return -1001;
    }
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    Object localObject1 = u.b(localu.h);
    util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localu.h + " ...", paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    u.E = util.get_network_type(this.mContext);
    if (paramInt1 != u.E)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, u.E);
    }
    u.G = util.get_apn_string(this.mContext).getBytes();
    localu.g = paramString;
    localu.f = 0L;
    ((async_context)localObject1)._sappid = paramLong1;
    ((async_context)localObject1)._appid = paramLong1;
    ((async_context)localObject1)._sub_appid = paramLong2;
    ((async_context)localObject1)._main_sigmap = i;
    ((async_context)localObject1)._last_err_msg = new ErrMsg();
    u.at.add_t2(new report_t2("login", new String(u.D), System.currentTimeMillis(), paramLong4, paramLong5, null));
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = localu.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label726;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt1 = -1003;
      paramArrayOfByte2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte2 != null) {
        break label968;
      }
      paramArrayOfByte2 = new Ticket();
    }
    label968:
    for (;;)
    {
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0) {
        if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, paramLong1);
        }
      }
      for (;;)
      {
        if ((localu.d != null) && (localu.d.get_bitmap() != 0))
        {
          this.mG.d = localu.d;
          RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, paramLong1, 1);
        }
        u.b();
        localu.i();
        util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localu.h + " ret=" + paramInt1, paramString);
        return paramInt1;
        l1 = Long.parseLong(paramString);
        label726:
        localu.f = l1;
        localu.k();
        Object localObject2 = getA1AndNopicSigByAccount(paramString, paramLong1);
        localObject1 = ((A1AndNopicSig)localObject2).a1;
        localObject2 = ((A1AndNopicSig)localObject2).noPicSig;
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          util.LOGI("user:" + paramString + " have no a1 or pic_sig.", paramString);
          paramInt1 = -1016;
          break;
        }
        util.LOGI("user:" + paramString + " login with A1 exchange A1.", paramString);
        paramInt2 = new m(localu).a(l1, paramLong1, paramLong2, 1, i, (byte[])localObject1, (byte[])localObject2, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
        paramInt1 = paramInt2;
        if (paramInt2 != 0) {
          break;
        }
        paramArrayOfByte2 = localu.a(l1, paramLong1);
        if (paramArrayOfByte2 == null)
        {
          paramInt1 = -1004;
          break;
        }
        paramWUserSigInfo.get_clone(paramArrayOfByte2);
        paramWFastLoginInfo.get_clone(localu.j);
        paramInt1 = paramInt2;
        break;
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, paramLong1, 0);
      }
    }
  }
  
  private int GetFastLoginInfo(byte[] paramArrayOfByte, async_context paramasync_context)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 3) || (paramasync_context == null)) {
      return -1017;
    }
    tlv_t106 localtlv_t106 = new tlv_t106();
    tlv_t10c localtlv_t10c = new tlv_t10c();
    tlv_t16a localtlv_t16a = new tlv_t16a();
    Object localObject = new tlv_t145();
    int i = paramArrayOfByte.length;
    if (localtlv_t106.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no tgtgt data", "");
      return -1017;
    }
    if (localtlv_t10c.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no gtkey data", "");
      return -1017;
    }
    if (localtlv_t16a.get_tlv(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no nopicsig data", "");
      return -1017;
    }
    if (((tlv_t145)localObject).get_tlv(paramArrayOfByte, 3, i) > 0)
    {
      paramArrayOfByte = ((tlv_t145)localObject).get_data();
      localObject = u.B;
      util.LOGD("new guid:" + util.buf_to_string(paramArrayOfByte) + " old guid:" + util.buf_to_string((byte[])localObject));
      if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
      {
        util.LOGI("fast login info guid not equal", "");
        util.saveGuidToFile(u.u, paramArrayOfByte);
        u.B = (byte[])paramArrayOfByte.clone();
        u.C = (byte[])paramArrayOfByte.clone();
      }
    }
    paramasync_context._tmp_pwd = oicq_request.b(localtlv_t106.get_data(), localtlv_t10c.get_data());
    paramasync_context._tmp_no_pic_sig = localtlv_t16a.get_data();
    return 0;
  }
  
  public static WFastLoginInfo GetFastLoginUrl(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() != 0)
        {
          util.LOGI("packageName:" + paramString + " uin:" + paramLong, "");
          if (paramLong == 1689053018L) {}
          for (String str = "https://imgcache.qq.com/wtlogin" + "/test";; str = "https://imgcache.qq.com/wtlogin" + "/app")
          {
            paramString = paramString.split("\\.");
            int i = 0;
            while (i < paramString.length)
            {
              str = str + "/";
              str = str + paramString[i];
              i += 1;
            }
          }
          paramString = new WFastLoginInfo();
          paramString.iconUrl = (str + "/icon.png");
          paramString.adUrl = (str + "/ad_img.png");
          paramString.profileUrl = (str + "/profile.js");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
    return null;
  }
  
  private int GetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, int paramInt2)
  {
    if ((paramString1 == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int j = paramInt1 | 0xC0;
    paramInt1 = this.mMiscBitmap;
    int i = paramInt1;
    if (u.ac) {
      i = paramInt1 | 0x2000000;
    }
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString1, paramLong1, j, paramLong2, paramArrayOfLong, paramBoolean1, paramString2, paramWUserSigInfo, paramArrayOfByte, paramBoolean2, "GetStWithPasswd").RunReq(0);
      return -1001;
    }
    paramInt1 = 1;
    u localu;
    async_context localasync_context;
    StringBuilder localStringBuilder;
    Object localObject;
    label528:
    long l1;
    if ((paramBoolean2) && (!oicq.wlogin_sdk.a.k.y))
    {
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      localasync_context = u.b(localu.h);
      util.LOGI("start GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:0x" + Integer.toHexString(j) + " dwSubAppid:" + paramLong2 + " Seq:" + localu.h + " ...", paramString1);
      localStringBuilder = new StringBuilder("GetStWithPasswd");
      localasync_context._isSmslogin = paramBoolean2;
      localObject = paramString2;
      if (paramBoolean2)
      {
        localObject = paramString2;
        if (paramString2.length() == 0) {
          localObject = localasync_context._mpasswd;
        }
      }
      oicq.wlogin_sdk.a.k.y = false;
      oicq.wlogin_sdk.a.k.A = "";
      paramString2 = (String)localObject;
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((String)localObject).length() > 16) {
          paramString2 = ((String)localObject).substring(0, 16);
        }
      }
      paramInt2 = util.get_saved_network_type(this.mContext);
      u.E = util.get_network_type(this.mContext);
      if (paramInt2 != u.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, u.E);
      }
      u.G = util.get_apn_string(this.mContext).getBytes();
      localu.g = paramString1;
      localu.f = 0L;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong1;
      localasync_context._sub_appid_list = null;
      localasync_context._sub_appid = paramLong2;
      localasync_context._main_sigmap = j;
      localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
      localasync_context._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        localasync_context._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData == null) || (paramWUserSigInfo._reserveData.length <= 3)) {
        break label967;
      }
      localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localu.i, paramString1);
      u.at.add_t2(new report_t2("login", new String(u.D), System.currentTimeMillis(), paramLong1, paramLong2, paramArrayOfLong));
      if (util.check_uin_account(paramString1).booleanValue()) {
        break label1041;
      }
      if (!localasync_context.ifQQLoginInQim(u.aA)) {
        break label976;
      }
      localStringBuilder.append(",ifQQLoginInQim found = 0");
      paramInt1 = 0;
      l1 = 0L;
      label599:
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label1073;
      }
      if (!paramBoolean1) {
        break label1060;
      }
    }
    label662:
    label686:
    label757:
    long l2;
    for (;;)
    {
      try
      {
        localasync_context._tmp_pwd = ((byte[])paramString2.getBytes("ISO-8859-1").clone());
        localasync_context._tmp_pwd_type = 0;
        if (paramInt1 != 0) {
          break label1837;
        }
        if (paramString1.length() <= util.MAX_NAME_LEN) {
          break label1275;
        }
        paramInt1 = -1008;
      }
      catch (Exception paramArrayOfLong)
      {
        label967:
        label976:
        paramInt1 = -1013;
        label1041:
        continue;
      }
      paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfLong != null) {
        break label2182;
      }
      paramArrayOfLong = new Ticket();
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 != 0) {
        break label2138;
      }
      if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
        RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid);
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      u.b();
      localu.i();
      util.LOGI("end GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:0x" + Integer.toHexString(j) + " dwSubAppid:" + paramLong2 + " Seq:" + localu.h + " ret=" + paramInt1, "" + localu.f);
      return paramInt1;
      localu = this.mG.a(0L);
      paramWUserSigInfo._seqence = localu.h;
      this.mAysncSeq = localu.h;
      break;
      localu.i = 0;
      break label528;
      if ((isGateWay(paramWUserSigInfo)) || (paramWUserSigInfo.businessType == 3))
      {
        localStringBuilder.append(",isGateWay found = 0");
        paramInt1 = 0;
        l1 = 0L;
        break label599;
      }
      l2 = localu.b(paramString1);
      l1 = l2;
      if (l2 != 0L) {
        break label599;
      }
      paramInt1 = 0;
      l1 = l2;
      break label599;
      l1 = Long.parseLong(paramString1);
      break label599;
      label1060:
      localasync_context._tmp_pwd = MD5.toMD5Byte(paramString2);
      continue;
      label1073:
      if ((paramWUserSigInfo._fastLoginBuf != null) && (paramWUserSigInfo._fastLoginBuf.length > 0))
      {
        util.LOGI("GetFastLoginInfo ...", paramString1);
        if (GetFastLoginInfo(paramWUserSigInfo._fastLoginBuf, localasync_context) < 0)
        {
          util.LOGI("GetFastLoginInfo failed", paramString1);
          paramInt1 = -1017;
          continue;
        }
        if (!paramString1.matches("([0-9]{5,10})@qq\\.com")) {
          break label2185;
        }
        l1 = Long.valueOf(paramString1.replaceAll("([0-9]{5,10})@qq\\.com", "$1")).longValue();
        paramInt1 = 1;
        localu.a(paramString1, Long.valueOf(l1));
      }
    }
    label2182:
    label2185:
    for (;;)
    {
      if ((localasync_context._tmp_pwd == null) || (localasync_context._tmp_pwd.length < 16))
      {
        paramInt1 = -1016;
        break label662;
        if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
        {
          localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
          localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
          oicq.wlogin_sdk.code2d.d.q = null;
          oicq.wlogin_sdk.code2d.d.r = null;
          continue;
        }
        paramString2 = getA1AndNopicSigByAccount(paramString1, paramLong1);
        localasync_context._tmp_pwd = paramString2.a1;
        localasync_context._tmp_no_pic_sig = paramString2.noPicSig;
        continue;
      }
      localasync_context._tmp_pwd_type = 1;
      break;
      label1275:
      paramInt2 = new t(localu).a(paramLong1, paramLong2, 1, j, paramString1.getBytes(), u.z, 0, 0, 1, i, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {
        break label662;
      }
      if (localasync_context._msalt != 0L)
      {
        localStringBuilder.append(",Name2Salt uin = 0");
        l1 = 0L;
        label1346:
        if (oicq.wlogin_sdk.a.k.z != 0L)
        {
          localasync_context._msalt = oicq.wlogin_sdk.a.k.z;
          oicq.wlogin_sdk.a.k.z = 0L;
        }
        localu.f = l1;
        paramWUserSigInfo.uin = ("" + l1);
        localStringBuilder.append(",thisG uin =").append(l1);
        if ((paramWUserSigInfo._in_ksid == null) || (paramWUserSigInfo._in_ksid.length <= 0)) {
          break label1840;
        }
      }
      label1823:
      label1837:
      label1840:
      for (paramString2 = (byte[])paramWUserSigInfo._in_ksid.clone();; paramString2 = u.ad)
      {
        if (localasync_context._tmp_pwd_type == 0) {
          break label1848;
        }
        util.LOGI("user:" + paramString1 + " login with saved A1.", "" + localu.f);
        localObject = new l(localu, this.mContext);
        ((l)localObject).g();
        paramInt1 = ((l)localObject).a(paramLong1, paramLong2, localu.f, 0, u.ag, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, i, this.mSubSigMap, paramArrayOfLong, j, paramLong2, u.z, 0, 0, 1, paramString2, paramWUserSigInfo);
        paramInt2 = paramInt1;
        if (paramInt1 == 204) {
          paramInt2 = new q(localu).a(i, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
        }
        if (paramInt2 != 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 != 160) {
            break;
          }
        }
        l2 = l1;
        if (l1 == 0L)
        {
          l2 = localasync_context._uin;
          localu.f = l2;
          paramWUserSigInfo.uin = ("" + l2);
          localStringBuilder.append(",uin == 0 reset ").append(l2);
        }
        paramInt1 = paramInt2;
        if (paramInt2 == 160) {
          break;
        }
        util.LOGI(localStringBuilder.toString());
        paramString2 = localu.a(l2, paramLong1);
        if (paramString2 != null) {
          break label2008;
        }
        util.LOGI("get_siginfo failed, AppID: " + paramLong1, "" + localu.f);
        paramInt1 = -1004;
        break;
        if (localasync_context.ifQQLoginInQim(u.aA)) {}
        for (l1 = localasync_context._uin;; l1 = localu.b(paramString1))
        {
          if (l1 != 0L) {
            break label1823;
          }
          paramInt1 = -1003;
          break;
        }
        localStringBuilder.append(",Name2Uin uin =").append(l1);
        break label1346;
      }
      label1848:
      util.LOGI("user:" + paramString1 + " login with input password.", "" + localu.f);
      localObject = new byte[4];
      util.int64_to_buf32((byte[])localObject, 0, System.currentTimeMillis() / 1000L + u.af);
      if (paramBoolean2) {}
      for (paramInt1 = 3;; paramInt1 = 1)
      {
        l locall = new l(localu, this.mContext);
        locall.g();
        paramInt1 = locall.a(paramLong1, paramLong2, localu.f, 0, u.ag, (byte[])localObject, localasync_context._tmp_pwd, paramInt1, i, this.mSubSigMap, paramArrayOfLong, j, paramLong2, u.z, 0, 0, 1, paramString2, paramWUserSigInfo);
        break;
      }
      label2008:
      paramWUserSigInfo.get_clone(paramString2);
      paramInt1 = paramInt2;
      if (paramArrayOfLong == null) {
        break label662;
      }
      paramInt1 = paramInt2;
      if (paramArrayOfByte == null) {
        break label662;
      }
      paramInt1 = paramInt2;
      if (paramArrayOfLong.length * 2 != paramArrayOfByte.length) {
        break label662;
      }
      i = 0;
      for (;;)
      {
        paramInt1 = paramInt2;
        if (paramArrayOfLong == null) {
          break;
        }
        paramInt1 = paramInt2;
        if (i >= paramArrayOfLong.length) {
          break;
        }
        paramString2 = localu.a(l2, paramArrayOfLong[i]);
        if (paramString2 != null)
        {
          paramArrayOfByte[(i * 2)] = ((byte[])paramString2._userSt_Key.clone());
          paramArrayOfByte[(i * 2 + 1)] = ((byte[])paramString2._userStSig.clone());
        }
        i += 1;
      }
      label2138:
      if ((paramInt1 == 2) || (paramInt1 == 160)) {
        break label757;
      }
      RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid, 0);
      break label757;
      break label686;
    }
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, int paramInt2, WtTicketPromise paramWtTicketPromise)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      paramInt1 = -1017;
    }
    do
    {
      do
      {
        return paramInt1;
        int i = paramInt1 | 0xC0;
        paramInt1 = i;
        if (2L == paramLong4) {
          paramInt1 = i & 0xFDFFFFFF;
        }
        if (paramInt2 == 0)
        {
          new HelperThread(this, this.mHelperHandler, paramWtTicketPromise, paramString, paramLong1, paramLong2, paramLong3, paramInt1, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, "GetStWithoutPasswd").RunReq(5);
          return -1001;
        }
        paramInt2 = realGetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt1, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, paramWtTicketPromise);
        paramInt1 = paramInt2;
      } while (paramInt2 == 0);
      paramInt1 = paramInt2;
    } while (paramInt2 == -1000);
    oicq.wlogin_sdk.report.event.c.a(new oicq.wlogin_sdk.report.event.b("wtlogin_change_ticket_error", String.valueOf(paramInt2), "").a(paramString).c(true));
    return paramInt2;
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo, WtTicketPromise paramWtTicketPromise)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, paramWtTicketPromise);
  }
  
  public static byte[] GetTicketSig(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig;
    }
    return new byte[0];
  }
  
  public static byte[] GetTicketSigKey(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramInt != 64) && (paramInt != 262144) && (paramInt != 128) && (paramInt != 16384) && (paramInt != 32768) && (paramInt != 16777216)) {
      throw null;
    }
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig_key;
    }
    return new byte[0];
  }
  
  public static Ticket GetUserSigInfoTicket(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (paramInt == 4194304) {
      return new Ticket(4194304, WloginSigInfo._LHSig, null, u.f(), 0L);
    }
    if (paramInt == 67108864) {
      return new Ticket(67108864, WloginSigInfo._QRPUSHSig, null, u.f(), 0L);
    }
    if (paramWUserSigInfo == null)
    {
      util.LOGI("GetUserSigInfoTicket userInfo is null " + Integer.toHexString(paramInt), "");
      return null;
    }
    if (paramWUserSigInfo._tickets == null)
    {
      util.LOGI("GetUserSigInfoTicket tickets is null " + Integer.toHexString(paramInt), paramWUserSigInfo.uin);
      return null;
    }
    if (paramWUserSigInfo._tickets != null)
    {
      int i = 0;
      while (i < paramWUserSigInfo._tickets.size())
      {
        Ticket localTicket = (Ticket)paramWUserSigInfo._tickets.get(i);
        if (localTicket._type == paramInt)
        {
          util.LOGI("GetUserSigInfoTicket type:0x" + Integer.toHexString(paramInt) + " sig:" + util.buf_len(localTicket._sig) + " key:" + util.buf_len(localTicket._sig_key) + " create time:" + localTicket._create_time + " expire time:" + localTicket._expire_time, "");
          util.LOGI(localTicket.getContent(), paramWUserSigInfo.uin);
          return localTicket;
        }
        i += 1;
      }
    }
    util.LOGI("GetUserSigInfoTicket type null: 0x" + Integer.toHexString(paramInt), "");
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new TLV_CommRsp();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    ErrMsg localErrMsg = new ErrMsg(0, 0, "", "", "");
    if (paramInt != 0)
    {
      util.LOGI("OnDeviceLockRequest ret:" + paramInt, paramString);
      localErrMsg.setMessage(util.get_error_msg(paramInt));
      localErrMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
    }
    int i;
    label626:
    int j;
    switch (paramTransReqContext.get_subcmd())
    {
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    default: 
      return;
    case 5: 
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.a().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockStatus ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          if ((localDevlockRst.devSetupInfo != null) && (localDevlockRst.devSetupInfo.get_data_len() > 0))
          {
            localDevlockInfo.DevSetup = localDevlockRst.devSetupInfo.a;
            localDevlockInfo.AllowSet = localDevlockRst.devSetupInfo.b;
            if ((localDevlockRst.devGuideInfo == null) || (localDevlockRst.devGuideInfo.get_data_len() <= 0)) {
              break label626;
            }
          }
        }
      }
      for (localDevlockInfo.ProtectIntro = new String(localDevlockRst.devGuideInfo.a);; localDevlockInfo.ProtectIntro = new String(localDevlockRst.devSetupInfo.d))
      {
        localDevlockInfo.WarningInfo = new String(localDevlockRst.devSetupInfo.g);
        localDevlockInfo.WarningTitle = new String(localDevlockRst.devSetupInfo.e);
        localDevlockInfo.WarningMsg = new String(localDevlockRst.devSetupInfo.f);
        localDevlockInfo.WarningInfoType = localDevlockRst.devSetupInfo.c;
        if ((localDevlockRst.mbMobileInfo != null) && (localDevlockRst.mbMobileInfo.get_data_len() > 0))
        {
          localDevlockInfo.CountryCode = new String(localDevlockRst.mbMobileInfo.a);
          localDevlockInfo.Mobile = new String(localDevlockRst.mbMobileInfo.b);
          localDevlockInfo.MbItemSmsCodeStatus = localDevlockRst.mbMobileInfo.c;
          localDevlockInfo.AvailableMsgCount = localDevlockRst.mbMobileInfo.d;
          localDevlockInfo.TimeLimit = localDevlockRst.mbMobileInfo.e;
        }
        if ((localDevlockRst.mbGuideInfo != null) && (localDevlockRst.mbGuideInfo.get_data_len() > 0))
        {
          localDevlockInfo.MbGuideType = localDevlockRst.mbGuideInfo.c;
          localDevlockInfo.MbGuideInfoType = localDevlockRst.mbGuideInfo.d;
          localDevlockInfo.MbGuideInfo = new String(localDevlockRst.mbGuideInfo.b);
          localDevlockInfo.MbGuideMsg = new String(localDevlockRst.mbGuideInfo.a);
        }
        i = paramInt;
        if (localDevlockRst.transferInfo != null)
        {
          i = paramInt;
          if (localDevlockRst.transferInfo.get_data_len() > 0)
          {
            localDevlockInfo.TransferInfo = localDevlockRst.transferInfo.get_data();
            i = paramInt;
          }
        }
        if (this.mListener == null) {
          break;
        }
        this.mListener.OnCheckDevLockStatus(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
        return;
      }
    case 12: 
      i = paramInt;
      if (paramInt == 0)
      {
        j = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CloseDevLock ret:" + j, paramString);
        i = j;
        if (j != -1009) {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          paramLong2 = this.mG.b(paramString);
          this.mG.b(paramLong2, paramLong1);
          paramInt = 0;
          i = j;
          if (paramInt < paramWUserSigInfo._tickets.size())
          {
            if (((Ticket)paramWUserSigInfo._tickets.get(paramInt))._type != 33554432) {
              break label1093;
            }
            paramWUserSigInfo._tickets.remove(paramInt);
            break label1093;
          }
        }
        else
        {
          paramLong2 = Long.parseLong(paramString);
          continue;
        }
        if (this.mListener == null) {
          break;
        }
      }
      catch (Exception paramString)
      {
        util.printException(paramString);
        i = j;
      }
      this.mListener.OnCloseDevLock(paramWUserSigInfo, i, localErrMsg);
      return;
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.d().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("AskDevLockSms ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          i = paramInt;
          if (localDevlockRst.smsInfo != null)
          {
            localDevlockInfo.AvailableMsgCount = localDevlockRst.smsInfo.a;
            localDevlockInfo.TimeLimit = localDevlockRst.smsInfo.b;
            i = paramInt;
          }
        }
      }
      if (this.mListener == null) {
        break;
      }
      this.mListener.OnAskDevLockSms(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
      return;
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.f().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockSms ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          i = paramInt;
        }
      }
      if (this.mListener == null) {
        break;
      }
      this.mListener.OnCheckDevLockSms(paramWUserSigInfo, i, localErrMsg);
      return;
      label1093:
      paramInt += 1;
    }
  }
  
  private void OnRequestCode2d(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null)
    {
      util.LOGI("OnRequestCode2d mListener is null", paramString);
      return;
    }
    oicq.wlogin_sdk.code2d.d locald = oicq.wlogin_sdk.code2d.c._status;
    if (paramInt != 0) {
      util.LOGI("OnRequestCode2d ret:" + paramInt, paramString);
    }
    switch (paramTransReqContext.get_subcmd())
    {
    default: 
      util.LOGW("OnRequestName unhandle cmd", "", paramString);
      this.mListener.OnException(new ErrMsg(), 9, paramWUserSigInfo);
      return;
    case 19: 
      if (paramInt != 0)
      {
        this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, paramInt);
        return;
      }
      locald.b = new oicq.wlogin_sdk.code2d.f().a(paramTransReqContext.get_body());
      util.LOGI("VerifyCode ret:" + locald.b, paramString);
      if ((locald.b == 0) && (locald.g != null) && (locald.g.length > 0)) {
        this.mG.a(locald.a, paramLong1, locald.g);
      }
      this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, locald.b);
      return;
    case 20: 
      if (paramInt != 0)
      {
        this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, paramInt);
        return;
      }
      oicq.wlogin_sdk.code2d.b localb = new oicq.wlogin_sdk.code2d.b();
      WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
      if (paramWUserSigInfo == null) {
        localWUserSigInfo = new WUserSigInfo();
      }
      locald.b = localb.a(paramTransReqContext.get_body(), paramLong1, u.u, localWUserSigInfo.loginTLVMap);
      util.LOGI("CloseCode ret:" + locald.b, paramString);
      oicq.wlogin_sdk.code2d.d.t = false;
      this.mListener.OnCloseCode(paramString, locald.d, locald.c, localWUserSigInfo, locald.f, locald.b);
      return;
    case 49: 
      if (paramInt == 0) {
        paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
      }
      break;
    }
    for (;;)
    {
      util.LOGI("FetchCodeSig ret:" + locald.b, paramString);
      this.mListener.OnFetchCodeSig(locald.j, locald.k, locald.l, paramWUserSigInfo, locald.f, paramInt);
      return;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
        util.LOGI("QueryCodeResult ret:" + locald.b, paramString);
      }
      for (;;)
      {
        this.mListener.OnQueryCodeResult(locald.a, locald.e, locald.c, paramWUserSigInfo, locald.f, paramInt);
        return;
      }
    }
  }
  
  private void OnRequestRegister(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null) {}
    String str;
    oicq.wlogin_sdk.a.k localk;
    label1612:
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
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    return;
                                                    str = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
                                                    if (paramInt == 0) {
                                                      break;
                                                    }
                                                  } while (this.mListener == null);
                                                  this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                                  return;
                                                  localk = this.mRegStatus;
                                                  switch (paramTransReqContext.get_subcmd())
                                                  {
                                                  default: 
                                                    util.LOGW("OnRequestRegister unhandle cmd:" + paramTransReqContext.get_subcmd(), "", paramString);
                                                  }
                                                } while (this.mListener == null);
                                                this.mListener.OnRegError(paramWUserSigInfo, -1010, str.getBytes());
                                                return;
                                                paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), localk);
                                                if (paramInt == 0) {
                                                  break;
                                                }
                                              } while (this.mListener == null);
                                              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                              return;
                                              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
                                              if (localk.d != 0) {
                                                break;
                                              }
                                            } while (this.mListener == null);
                                            this.mListener.OnRegCheckDownloadMsg(paramWUserSigInfo, localk.m, localk.n);
                                            return;
                                            if (localk.d != 2) {
                                              break;
                                            }
                                          } while (this.mListener == null);
                                          this.mListener.OnRegCheckUploadMsg(paramWUserSigInfo, new String(localk.q));
                                          return;
                                          if (localk.d != 3) {
                                            break;
                                          }
                                        } while (this.mListener == null);
                                        this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localk.r);
                                        return;
                                        if ((localk.d == 6) || (localk.d == 44))
                                        {
                                          if (this.mListener != null) {
                                            this.mListener.OnRegCheckWebSig(paramWUserSigInfo, new String(localk.r), new String(localk.f));
                                          }
                                          localk.r = new byte[0];
                                          return;
                                        }
                                        if (localk.d != 51) {
                                          break;
                                        }
                                      } while (this.mListener == null);
                                      this.mListener.OnGuaranteeCheckValidUrl(paramWUserSigInfo, localk.r);
                                      return;
                                      if (localk.d != 58) {
                                        break;
                                      }
                                    } while (this.mListener == null);
                                    this.mListener.OnRegCheckIframe(paramWUserSigInfo, localk.r, null);
                                    return;
                                    if (localk.d != 59) {
                                      break;
                                    }
                                    util.LOGW("OnRegCheckError REG_CHECK_ERROR_FACE regSig= " + util.printByte(localk.s), "");
                                  } while (this.mListener == null);
                                  this.mListener.OnRegError(paramWUserSigInfo, 59, localk.s);
                                  return;
                                  util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(localk.d), paramString);
                                } while (this.mListener == null);
                                this.mListener.OnRegError(paramWUserSigInfo, localk.d, localk.f);
                                return;
                                paramInt = oicq.wlogin_sdk.a.c.a(3, paramTransReqContext.get_body(), localk);
                                if (paramInt == 0) {
                                  break;
                                }
                              } while (this.mListener == null);
                              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                              return;
                              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
                              if ((localk.d == 0) || (localk.d == 4) || (localk.d == 31) || (localk.d == 118))
                              {
                                if (localk.d == 0)
                                {
                                  paramWUserSigInfo.regTLVMap = localk.C;
                                  localk.C = new HashMap();
                                }
                                this.mListener.OnRegQueryClientSentMsgStatus(paramWUserSigInfo, localk.d, localk.t, localk.u, new String(localk.f));
                                return;
                              }
                              if (localk.d != 3) {
                                break;
                              }
                            } while (this.mListener == null);
                            this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localk.r);
                            return;
                            util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(localk.d), paramString);
                          } while (this.mListener == null);
                          this.mListener.OnRegError(paramWUserSigInfo, localk.d, localk.f);
                          return;
                          paramInt = oicq.wlogin_sdk.a.c.a(paramTransReqContext.get_body(), localk);
                          if (paramInt == 0) {
                            break;
                          }
                        } while (this.mListener == null);
                        this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                        return;
                        util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
                        if (localk.d != 0) {
                          break;
                        }
                      } while (this.mListener == null);
                      this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localk.d, localk.t, localk.u);
                      return;
                      if (localk.d != 3) {
                        break;
                      }
                    } while (this.mListener == null);
                    this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localk.r);
                    return;
                    if (localk.d != 5) {
                      break;
                    }
                  } while (this.mListener == null);
                  this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localk.d, localk.t, localk.u);
                  return;
                  util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(localk.d), paramString);
                } while (this.mListener == null);
                this.mListener.OnRegError(paramWUserSigInfo, localk.d, localk.f);
                return;
                paramInt = oicq.wlogin_sdk.a.c.b(paramTransReqContext.get_body(), localk);
                if (paramInt == 0) {
                  break;
                }
              } while (this.mListener == null);
              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
              return;
              paramWUserSigInfo.regTLVMap = localk.C;
              localk.C = new HashMap();
              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
            } while (this.mListener == null);
            this.mListener.OnRegSubmitMsgChk(paramWUserSigInfo, localk.d, localk.f);
            return;
            paramInt = oicq.wlogin_sdk.a.c.c(paramTransReqContext.get_body(), localk);
            if (paramInt == 0) {
              break;
            }
          } while (this.mListener == null);
          this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
          return;
          paramWUserSigInfo.regTLVMap = localk.C;
          localk.C = new HashMap();
          util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
        } while (this.mListener == null);
        if ((localk.b != null) && (localk.b.indexOf("-") > 0))
        {
          paramInt = localk.b.indexOf("-");
          paramString = localk.b.substring(0, paramInt);
          if (!paramString.equals("86")) {
            break label1612;
          }
        }
        for (localk.b = localk.b.substring(paramInt + 1);; localk.b = ("00" + paramString + localk.b.substring(paramInt + 1)))
        {
          if ((localk.b != null) && (localk.b.length() != 0))
          {
            this.mG.d(localk.b);
            this.mG.a(localk.b, Long.valueOf(localk.v));
          }
          util.LOGI("reg userAccount: " + localk.b, localk.v + "");
          if ((oicq.wlogin_sdk.a.k.A.length() <= 0) || (!oicq.wlogin_sdk.a.k.y)) {
            break;
          }
          this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, localk.d, localk.v, localk.w, localk.x, localk.f);
          return;
        }
        this.mListener.OnRegGetAccount(paramWUserSigInfo, localk.d, localk.v, localk.w, localk.x, localk.f);
        return;
        paramInt = oicq.wlogin_sdk.a.c.d(paramTransReqContext.get_body(), localk);
        if (paramInt == 0) {
          break;
        }
      } while (this.mListener == null);
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
      return;
      util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
    } while (this.mListener == null);
    this.mListener.OnRegQueryAccount(paramWUserSigInfo, localk.d, localk.f);
    return;
    paramInt = oicq.wlogin_sdk.a.c.e(paramTransReqContext.get_body(), localk);
    if ((paramInt != 0) && (this.mListener != null)) {
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
    }
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
    this.mListener.OnQuickRegisterCheckAccount(paramWUserSigInfo, localk.d, localk.f);
    return;
    paramInt = oicq.wlogin_sdk.a.c.f(paramTransReqContext.get_body(), localk);
    if ((paramInt != 0) && (this.mListener != null)) {
      this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
    }
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localk.d, "");
    paramWUserSigInfo.regTLVMap = localk.C;
    localk.C = new HashMap();
    this.mListener.OnQuickRegisterGetAccount(paramWUserSigInfo, localk.d, localk.f);
    return;
    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd());
    this.mListener.onModifyQIMPassword(paramWUserSigInfo, paramTransReqContext.get_subcmd(), paramTransReqContext.get_body());
  }
  
  private int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = 0;
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshPictureData").RunReq(1);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    u localu = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(localu.h);
    util.LOGI("user:" + paramString + " Seq:" + localu.h + " RefreshPictureData ...", "" + paramString);
    localu.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = localu.b(paramString);
      if (l == 0L) {
        break label328;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localu.f = l;
      }
      paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      if (paramInt == 2) {
        paramInt = i;
      }
      for (;;)
      {
        util.LOGI("user:" + paramString + " Seq:" + localu.h + " RefreshPictureData ret=" + paramInt, "" + paramString);
        return paramInt;
        l = Long.parseLong(paramString);
        paramInt = 1;
        break;
      }
      label328:
      paramInt = 0;
    }
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    util.LOGI(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + "RefreshSMSData _seqence:" + paramWUserSigInfo._seqence + " mAysncSeq:" + this.mAysncSeq, "");
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, paramArrayOfByte, "RefreshSMSData").RunReq(3);
      return -1001;
    }
    paramInt = 0;
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    u localu = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(localu.h);
    util.LOGI(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + "RefreshSMSData user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localu.h + " RefreshSMSData ...", "" + paramString);
    localu.g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = localu.b(paramString);
      l1 = l2;
      if (l2 != 0L)
      {
        paramInt = 1;
        l1 = l2;
      }
    }
    for (;;)
    {
      if (paramInt == 1) {
        localu.f = l1;
      }
      int i = new s(localu).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte);
      paramInt = i;
      if (i == 160) {
        paramInt = 0;
      }
      util.LOGI("user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localu.h + " RefreshSMSData ret=" + paramInt, "" + paramString);
      return paramInt;
      l1 = Long.parseLong(paramString);
      paramInt = 1;
    }
  }
  
  private int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    Object localObject = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = ((u)localObject).h;
    async_context localasync_context = u.b(((u)localObject).h);
    util.LOGI("user:" + paramString + " Seq:" + ((u)localObject).h + " RefreshSMSVerifyLoginCode ...", paramString);
    ((u)localObject).g = paramString;
    localasync_context._last_err_msg = new ErrMsg();
    paramInt = new z((u)localObject).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    localObject = new StringBuilder().append("user:").append(((u)localObject).g).append(" Seq:").append(((u)localObject).h).append(" RefreshSMSVerifyLoginCode ret=");
    if (paramInt > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt);; paramWUserSigInfo = Integer.valueOf(paramInt))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt;
    }
  }
  
  private int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0) || (paramArrayOfByte4 == null)) {
      return -1017;
    }
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    for (;;)
    {
      byte[] arrayOfByte = u.F;
      long l1 = 0L;
      Object localObject1 = new byte[0];
      Object localObject2 = GetLastLoginInfo();
      paramArrayOfByte3 = (byte[])localObject1;
      if (localObject2 != null)
      {
        long l2 = ((WloginLastLoginInfo)localObject2).mUin;
        localObject2 = GetLocalTicket(((WloginLastLoginInfo)localObject2).mAccount, paramLong1, 64);
        l1 = l2;
        paramArrayOfByte3 = (byte[])localObject1;
        if (localObject2 != null)
        {
          l1 = l2;
          paramArrayOfByte3 = (byte[])localObject1;
          if (((Ticket)localObject2)._sig != null)
          {
            paramArrayOfByte3 = ((Ticket)localObject2)._sig;
            l1 = l2;
          }
        }
      }
      util.LOGI("has uin? " + l1 + ", a2: " + paramArrayOfByte3.length);
      util.LOGI("RegSubmitMobile mobile ..." + new String(paramArrayOfByte2) + " appname: " + new String(arrayOfByte) + "...", "");
      this.mRegStatus.c = new String(paramArrayOfByte2);
      localObject1 = new oicq.wlogin_sdk.a.h();
      localObject2 = new TransReqContext();
      oicq.wlogin_sdk.a.k localk = this.mRegStatus;
      localk.k = paramArrayOfByte2;
      localk.g = paramLong1;
      localk.h = paramLong2;
      ((TransReqContext)localObject2).set_register_req();
      ((TransReqContext)localObject2).set_subcmd(((oicq.wlogin_sdk.a.h)localObject1).a());
      ((TransReqContext)localObject2)._body = ((oicq.wlogin_sdk.a.h)localObject1).a(paramArrayOfByte2, arrayOfByte, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), u.ad, l1, paramArrayOfByte3, GetGuid(), paramArrayOfByte1, paramWUserSigInfo.extraRegTLVMap, paramMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, (TransReqContext)localObject2, paramWUserSigInfo);
    }
  }
  
  /* Error */
  private void RequestInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1555	oicq/wlogin_sdk/request/u:d	()V
    //   5: aload_0
    //   6: invokespecial 1558	oicq/wlogin_sdk/request/WtloginHelper:ShareKeyInit	()I
    //   9: pop
    //   10: aload_0
    //   11: invokespecial 1560	oicq/wlogin_sdk/request/WtloginHelper:AsyncGenRSAKey	()V
    //   14: getstatic 642	oicq/wlogin_sdk/request/u:B	[B
    //   17: getstatic 642	oicq/wlogin_sdk/request/u:B	[B
    //   20: arraylength
    //   21: invokestatic 1563	oicq/wlogin_sdk/tools/util:buf_to_string	([BI)Ljava/lang/String;
    //   24: astore_1
    //   25: invokestatic 1569	com/tencent/secprotocol/ByteData:getInstance	()Lcom/tencent/secprotocol/ByteData;
    //   28: iconst_1
    //   29: ldc_w 1571
    //   32: invokevirtual 1575	com/tencent/secprotocol/ByteData:processFilterSwitch	(ZLjava/lang/String;)V
    //   35: invokestatic 1569	com/tencent/secprotocol/ByteData:getInstance	()Lcom/tencent/secprotocol/ByteData;
    //   38: aload_0
    //   39: getfield 83	oicq/wlogin_sdk/request/WtloginHelper:mContext	Landroid/content/Context;
    //   42: ldc_w 1577
    //   45: aload_1
    //   46: ldc 223
    //   48: ldc_w 1579
    //   51: ldc_w 1581
    //   54: invokevirtual 1584	com/tencent/secprotocol/ByteData:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   57: invokestatic 1569	com/tencent/secprotocol/ByteData:getInstance	()Lcom/tencent/secprotocol/ByteData;
    //   60: ldc_w 1579
    //   63: invokevirtual 1587	com/tencent/secprotocol/ByteData:setData	(Ljava/lang/String;)V
    //   66: invokestatic 1589	oicq/wlogin_sdk/request/u:m	()Ljava/lang/String;
    //   69: astore_1
    //   70: aload_1
    //   71: invokestatic 1595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +29 -> 103
    //   77: aload_1
    //   78: ldc_w 1597
    //   81: invokevirtual 1600	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifeq +19 -> 103
    //   87: invokestatic 1605	oicq/wlogin_sdk/tools/d:a	()Loicq/wlogin_sdk/tools/d;
    //   90: aload_0
    //   91: getfield 75	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/u;
    //   94: invokevirtual 1607	oicq/wlogin_sdk/tools/d:a	(Loicq/wlogin_sdk/request/u;)V
    //   97: invokestatic 1605	oicq/wlogin_sdk/tools/d:a	()Loicq/wlogin_sdk/tools/d;
    //   100: invokevirtual 1608	oicq/wlogin_sdk/tools/d:b	()V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload_1
    //   108: ldc_w 1609
    //   111: invokestatic 1613	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   114: goto -11 -> 103
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	WtloginHelper
    //   24	54	1	str	String
    //   106	2	1	localThrowable	Throwable
    //   117	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	103	106	java/lang/Throwable
    //   2	66	117	finally
    //   66	103	117	finally
    //   103	105	117	finally
    //   107	114	117	finally
    //   118	120	117	finally
  }
  
  private int RequestReport(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, "RequestReport").RunReq(7);
      return -1001;
    }
    u localu = this.mG.a(0L);
    localu.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localu.h + " RequestReport...", "" + paramLong1);
    paramInt = new ac(localu).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localu.j();
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localu.h + " RequestReport ret=" + paramInt, "" + paramLong1);
    return paramInt;
  }
  
  private int RequestReportError(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, paramInt2, "RequestReportError").RunReq(8);
      return -1001;
    }
    u localu = this.mG.a(0L);
    localu.d = this.mG.d;
    localu.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localu.h + " RequestReportError...", "" + paramLong1);
    paramInt1 = new x(localu).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localu.h + " RequestReportError ret=" + paramInt1, "" + paramLong1);
    return paramInt1;
  }
  
  public static void SetWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraProductLoginTlvValue(paramWUserSigInfo, 1322, paramArrayOfByte);
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  private int ShareKeyInit()
  {
    util.LOGI("start ShareKeyInit", "");
    localEcdhCrypt = new EcdhCrypt(this.mContext);
    if (this.isForLocal) {
      return localEcdhCrypt.initShareKeyByDefault();
    }
    try
    {
      Pair localPair = oicq.wlogin_sdk.tools.d.a().c();
      if (localPair != null) {
        localEcdhCrypt.setPubKey((String)localPair.first, ((Integer)localPair.second).intValue());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        util.printThrowable(localThrowable, "ShareKeyInit");
        continue;
        util.saveInitKeyTime(this.mContext, i + 1);
        int j = localEcdhCrypt.initShareKey();
        int i = j;
        if (j == 0)
        {
          util.saveInitKeyTime(this.mContext, 0);
          i = j;
        }
      }
    }
    i = util.getInitKeyTime(this.mContext);
    if (i > 3)
    {
      i = localEcdhCrypt.initShareKeyByDefault();
      util.LOGI("end ShareKeyInit", "");
      this.mG.n = localEcdhCrypt.get_c_pub_key();
      this.mG.p = localEcdhCrypt.get_g_share_key();
      this.mG.r = localEcdhCrypt.get_pub_key_ver();
      return i;
    }
  }
  
  private int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString1, paramString2, paramWUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    u localu = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(localu.h);
    util.LOGI("user:" + localu.g + " code:" + paramString2 + " Seq:" + localu.h + " VerifySMSVerifyLoginCode ...", paramString1);
    localu.g = paramString1;
    localasync_context._last_err_msg = new ErrMsg();
    localasync_context._mpasswd = util.get_mpasswd();
    paramInt = new aa(localu).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    paramWUserSigInfo = new StringBuilder().append("user:").append(paramString1).append(" code:").append(paramString2).append(" Seq:").append(localu.h).append(" VerifySMSVerifyLoginAccount ret=");
    if (paramInt > 0) {}
    for (paramString2 = Integer.toHexString(paramInt);; paramString2 = Integer.valueOf(paramInt))
    {
      util.LOGI(paramString2, paramString1);
      return paramInt;
    }
  }
  
  public static void customizeLogDir(String paramString)
  {
    u.az = paramString;
    util.LOGI("set log dir " + paramString, "");
  }
  
  private A1AndNopicSig getA1AndNopicSigByAccount(String paramString, long paramLong)
  {
    A1AndNopicSig localA1AndNopicSig = new A1AndNopicSig(null);
    StringBuffer localStringBuffer = new StringBuffer("getA1AndNopicSigByAccount,userAccount=").append(paramString);
    paramString = getSigInfo(paramString, paramLong);
    if (paramString != null) {
      if ((paramString._en_A1 != null) && (paramString._en_A1.length > 0))
      {
        localA1AndNopicSig.a1 = ((byte[])paramString._en_A1.clone());
        localStringBuffer.append(",a1=").append(localA1AndNopicSig.a1.length);
        if ((paramString._noPicSig == null) || (paramString._noPicSig.length <= 0)) {
          break label158;
        }
        localA1AndNopicSig.noPicSig = ((byte[])paramString._noPicSig.clone());
        localStringBuffer.append(",noPicSig=").append(localA1AndNopicSig.noPicSig.length);
      }
    }
    for (;;)
    {
      util.LOGI(localStringBuffer.toString(), "");
      return localA1AndNopicSig;
      localStringBuffer.append(",a1=null");
      break;
      label158:
      localStringBuffer.append(",noPicSig=null");
      continue;
      localStringBuffer.append(",info == null");
    }
  }
  
  public static byte[] getLoginResultData(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(paramInt));
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static String getLoginResultField(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(1320));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField get str " + (String)localObject, paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static String getLoginResultField_S(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(new Integer(1328));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField2 get str " + (String)localObject, paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField2 get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static byte[] getLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginTLVMap.get(localInteger);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static byte[] getRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.regTLVMap.get(localInteger);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  private WloginSigInfo getSigInfo(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label47;
      }
    }
    label47:
    for (paramString = null;; paramString = this.mG.a(l1, paramLong))
    {
      return paramString;
      l1 = Long.parseLong(paramString);
    }
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, QuickLoginParam paramQuickLoginParam)
  {
    return getStWithPtSig(paramString1, paramString2, paramQuickLoginParam, 0);
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    return 0;
  }
  
  private int getStWithQQSig(String paramString, QuickLoginParam paramQuickLoginParam)
  {
    return getStWithQQSig(paramString, paramQuickLoginParam, 0);
  }
  
  private int getStWithQQSig(String paramString, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    return 0;
  }
  
  private int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int i = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong1, i, paramLong2, paramWUserSigInfo, "getStWithQrSig").RunReq(17);
      return -1001;
    }
    paramInt2 = 0;
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    this.mAysncSeq = localu.h;
    oicq.wlogin_sdk.a.k.A = "";
    async_context localasync_context = u.b(localu.h);
    util.LOGI("start getStWithQrSig:user:" + paramString + " appid:" + paramLong1 + " sigMap:0x" + Integer.toHexString(i) + " subAppid:" + paramLong2 + " Seq:" + localu.h, paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    u.E = util.get_network_type(this.mContext);
    if (paramInt1 != u.E)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, u.E);
    }
    u.G = util.get_apn_string(this.mContext).getBytes();
    if (!util.check_uin_account(paramString).booleanValue())
    {
      util.LOGI("userAccount " + paramString + " isn't valid", "");
      return -1017;
    }
    long l = Long.parseLong(paramString);
    paramWUserSigInfo.uin = paramString;
    localu.g = paramString;
    localu.f = l;
    localasync_context._sappid = paramLong1;
    localasync_context._appid = paramLong1;
    localasync_context._sub_appid_list = null;
    localasync_context._sub_appid = paramLong2;
    localasync_context._main_sigmap = i;
    localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
    localasync_context._last_err_msg = new ErrMsg();
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localu.i, paramString);
      u.at.add_t2(new report_t2("login", new String(u.D), System.currentTimeMillis(), paramLong1, paramLong2, null));
      if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
      {
        localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
        localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
        if ((localasync_context._tmp_no_pic_sig == null) || (localasync_context._tmp_no_pic_sig.length == 0)) {
          break label855;
        }
        util.LOGI("no pic sig length " + localasync_context._tmp_no_pic_sig.length, paramString);
        label529:
        localasync_context.tgtQR = oicq.wlogin_sdk.code2d.d.s;
        oicq.wlogin_sdk.code2d.d.q = null;
        oicq.wlogin_sdk.code2d.d.r = null;
        oicq.wlogin_sdk.code2d.d.s = null;
      }
      if ((localasync_context._tmp_pwd != null) && (localasync_context._tmp_pwd.length >= 16)) {
        break label865;
      }
      paramInt2 = -1016;
      label573:
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramWUserSigInfo != null) {
        break label1153;
      }
      paramWUserSigInfo = new Ticket();
    }
    label1153:
    for (;;)
    {
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt2), paramInt2);
      if (paramInt2 == 0) {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid);
        }
      }
      for (;;)
      {
        if ((localu.d != null) && (localu.d.get_bitmap() != 0))
        {
          this.mG.d = localu.d;
          RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid, 1);
        }
        oicq.wlogin_sdk.report.c.a();
        u.b();
        localu.i();
        util.LOGI("end getStWithQrSig user:" + paramString + " appid:" + paramLong1 + " sigMap:0x" + Integer.toHexString(i) + " subAppid:" + paramLong2 + " Seq:" + localu.h + " ret=" + paramInt2, "" + localu.f);
        return paramInt2;
        localu.i = 0;
        break;
        label855:
        util.LOGI("no pic sig length is 0", paramString);
        break label529;
        label865:
        localasync_context._tmp_pwd_type = 1;
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
        for (Object localObject = (byte[])paramWUserSigInfo._in_ksid.clone();; localObject = u.ad)
        {
          if (localasync_context._tmp_pwd_type != 0)
          {
            util.LOGI("user:" + paramString + " login with qrsig", paramString);
            l locall = new l(localu, this.mContext);
            locall.g();
            paramInt2 = locall.a(paramLong1, paramLong2, localu.f, 0, u.ag, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i, paramLong2, u.z, 0, 0, 1, (byte[])localObject, paramWUserSigInfo);
          }
          paramInt1 = paramInt2;
          if (paramInt2 == 204) {
            paramInt1 = new q(localu).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
          }
          if (paramInt1 != 0)
          {
            paramInt2 = paramInt1;
            if (paramInt1 != 160) {
              break;
            }
          }
          localObject = localu.a(l, paramLong1);
          if (localObject != null) {
            break label1095;
          }
          paramInt2 = -1004;
          break;
        }
        label1095:
        paramWUserSigInfo.get_clone((WloginSigInfo)localObject);
        paramInt2 = paramInt1;
        break label573;
        if ((paramInt2 != 2) && (paramInt2 != 160)) {
          RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid, 0);
        }
      }
    }
  }
  
  private int getTicketByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, StringBuilder paramStringBuilder, u paramu, async_context paramasync_context)
  {
    paramasync_context._tmp_pwd = MD5.toMD5Byte(paramasync_context._mpasswd.getBytes());
    Object localObject = new l(paramu, this.mContext);
    ((l)localObject).g();
    int i = ((l)localObject).a(paramLong1, paramLong2, paramu.f, 0, u.ag, util.getRequestInitTime(), paramasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, null, paramInt, paramLong2, u.z, 0, 0, 1, u.ad, paramWUserSigInfo);
    paramStringBuilder.append(",retPasswd =").append(i);
    paramInt = i;
    if (i == 204)
    {
      paramInt = new q(paramu).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramStringBuilder.append("，devlock = ").append(paramInt);
    }
    if (paramInt != 0)
    {
      paramStringBuilder.append(",fail");
      util.LOGI(paramStringBuilder.toString(), "");
      return -2005;
    }
    localObject = paramu.a(paramu.f, paramLong1);
    if (localObject == null)
    {
      paramStringBuilder.append(",info == null");
      util.LOGI(paramStringBuilder.toString(), "");
      return -1004;
    }
    paramWUserSigInfo.get_clone((WloginSigInfo)localObject);
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new Ticket();
    }
    for (;;)
    {
      u.at.commit_t2(paramu.f, paramu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0) {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramu.f, paramasync_context._appid);
        }
      }
      for (;;)
      {
        if ((paramu.d != null) && (paramu.d.get_bitmap() != 0))
        {
          this.mG.d = paramu.d;
          RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramu.f, paramasync_context._appid, 1);
        }
        oicq.wlogin_sdk.report.c.a();
        u.b();
        paramu.i();
        return 0;
        if ((paramInt != 2) && (paramInt != 160)) {
          RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramu.f, paramasync_context._appid, 0);
        }
      }
    }
  }
  
  public static b getWtDataSender()
  {
    return mWtDataSender;
  }
  
  private Handler initHelperHandler()
  {
    try
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private boolean isGateWay(WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo.businessType == 2) {}
    for (boolean bool = true;; bool = false)
    {
      util.LOGI("quickLoginByGateway isGateWay = " + bool);
      return bool;
    }
  }
  
  private int isPskeyExpired(int paramInt1, String[] paramArrayOfString, Ticket paramTicket, long paramLong, int paramInt2)
  {
    String str2;
    int i;
    int m;
    int j;
    label119:
    String str1;
    if ((paramInt1 == 1048576) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramInt1 = 0;
      int n = paramArrayOfString.length;
      int k = 0;
      for (;;)
      {
        if (k < n)
        {
          str2 = paramArrayOfString[k];
          if (str2 == null) {
            break label550;
          }
          if (str2.length() == 0)
          {
            k += 1;
          }
          else
          {
            i = str2.indexOf('(');
            m = str2.indexOf(')');
            if ((i != 0) || (m <= 0)) {
              break label553;
            }
            j = Integer.valueOf(str2.substring(i + 1, m)).intValue();
            if ((0x100000 & j) > 0)
            {
              i = 1;
              if ((j & 0x8000000) <= 0) {
                break label420;
              }
              j = 1;
              label131:
              str1 = str2.substring(m + 1);
              m = i;
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("isPskeyExpired domain ").append(str1).append(" req_pskey:");
      Object localObject;
      if (m != 0)
      {
        localObject = "1";
        label186:
        localStringBuilder = localStringBuilder.append((String)localObject).append(" req_pt4t:");
        if (i == 0) {
          break label434;
        }
        localObject = "1";
        label211:
        util.LOGI((String)localObject, "");
        if ((m == 0) || ((paramTicket._pskey_map.get(str1) != null) && (!Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get(str1)).longValue())))) {
          break label442;
        }
        j = 1;
        label271:
        if ((i == 0) || ((paramTicket._pt4token_map.get(str1) != null) && (!Ticket.isPskeyExpired(((Long)paramTicket._pt4token_expire.get(str1)).longValue())))) {
          break label448;
        }
        i = 1;
        label316:
        if ((j == 0) && (i == 0)) {
          break label550;
        }
        paramArrayOfString[paramInt1] = str2;
        localObject = new StringBuilder().append("PskeyExpired:").append(str1).append("pskey:");
        if (j == 0) {
          break label454;
        }
        str1 = "1";
        label367:
        localObject = ((StringBuilder)localObject).append(str1).append(",pt4t:");
        if (i == 0) {
          break label462;
        }
      }
      label420:
      label434:
      label442:
      label448:
      label454:
      label462:
      for (str1 = "1";; str1 = "0")
      {
        util.LOGI(str1, "");
        paramInt1 += 1;
        break;
        i = 0;
        break label119;
        j = 0;
        break label131;
        localObject = "0";
        break label186;
        localObject = "0";
        break label211;
        j = 0;
        break label271;
        i = 0;
        break label316;
        str1 = "0";
        break label367;
      }
      i = paramInt1;
      if (paramInt1 == 0) {
        return 3;
      }
      while (i < paramArrayOfString.length)
      {
        util.LOGI("isPskeyExpired domain " + paramArrayOfString[i] + " cleared", "");
        paramArrayOfString[i] = null;
        i += 1;
      }
      if (paramInt2 == 1) {
        return 1;
      }
      RefreshMemorySig();
      return 2;
      return 0;
      label550:
      break;
      label553:
      str1 = str2;
      i = 0;
      m = 1;
    }
  }
  
  private void localInit(Context paramContext, boolean paramBoolean)
  {
    this.isForLocal = paramBoolean;
    try
    {
      this.mContext = paramContext.getApplicationContext();
      this.mG.b(paramContext);
      RequestInit();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.mContext = paramContext;
        util.printThrowable(localThrowable, "");
      }
    }
  }
  
  private Handler newHelperHandler()
  {
    try
    {
      if (Looper.myLooper() == null) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private void printTicket(WloginSigInfo paramWloginSigInfo)
  {
    util.LOGI("a1 " + paramWloginSigInfo._en_A1.length);
    util.LOGI("a2 " + paramWloginSigInfo._TGT.length);
    util.LOGI("skey " + paramWloginSigInfo._sKey.length);
    util.LOGI("pskey " + paramWloginSigInfo._psKey.length);
    util.LOGI("superkey " + paramWloginSigInfo._superKey.length);
    util.LOGI("d2 " + paramWloginSigInfo._D2.length);
    util.LOGI("d2key " + paramWloginSigInfo._D2Key.length);
  }
  
  private int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramInt1, paramWUserSigInfo, "quickLoginByWeChat").RunReq(19);
      return -1001;
    }
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByGateway ").append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    if (paramWUserSigInfo == null)
    {
      localStringBuilder.append(",userSigInfo == null");
      paramWUserSigInfo = new WUserSigInfo();
    }
    for (;;)
    {
      u localu = this.mG.a(0L);
      paramWUserSigInfo._seqence = localu.h;
      paramInt1 |= 0x400C0;
      async_context localasync_context = u.b(localu.h);
      localasync_context._mpasswd = util.get_mpasswd();
      localasync_context._msalt = util.constructSalt();
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong1;
      localasync_context._sub_appid = paramLong2;
      localasync_context._main_sigmap = paramInt1;
      localStringBuilder.append(",seq=").append(localu.h);
      localStringBuilder.append(",_mpasswd=").append(localasync_context._mpasswd);
      localStringBuilder.append(",_msalt=").append(Long.toHexString(localasync_context._msalt));
      localStringBuilder.append(",_appid=").append(localasync_context._appid);
      localStringBuilder.append(",_sub_appid=").append(localasync_context._sappid);
      localStringBuilder.append(",_sappid=").append(localasync_context._sub_appid);
      localStringBuilder.append(",dwMainSigMap=").append(localasync_context._main_sigmap);
      paramInt2 = new v(localu).a(paramWUserSigInfo);
      localStringBuilder.append(",tlv104=").append(localasync_context._t104.get_data_len());
      localStringBuilder.append(",ret=").append(paramInt2);
      if (paramInt2 != 0)
      {
        util.LOGI(localStringBuilder.toString(), "");
        return paramInt2;
      }
      localStringBuilder.append(",uin=").append(localasync_context._uin);
      paramWUserSigInfo.uin = String.valueOf(localasync_context._uin);
      paramWUserSigInfo.extraLoginTLVMap.put(new Integer(260), localasync_context._t104);
      localasync_context._t104 = new tlv_t104();
      paramInt1 = getTicketByGateway(paramLong1, paramLong2, paramInt1, paramWUserSigInfo, localStringBuilder, localu, localasync_context);
      util.LOGI(localStringBuilder.toString(), "");
      return paramInt1;
    }
  }
  
  private int realGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, WtTicketPromise paramWtTicketPromise)
  {
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    async_context localasync_context = u.b(localu.h);
    Object localObject = new StringBuilder().append("start GetStWithoutPasswd: dwSrcAppid:").append(paramLong1).append(" dwDstAppid:").append(paramLong2).append(" dwDstAppPri:").append(paramLong3).append(" dwMainSigMap:0x").append(Integer.toHexString(paramInt)).append(" dwSubDstAppid:").append(paramLong4).append(" Seq:").append(localu.h).append("|");
    int i;
    label339:
    long l1;
    if (paramWtTicketPromise != null)
    {
      paramWtTicketPromise = "1";
      util.LOGI(paramWtTicketPromise + " at " + u.m(), paramString);
      i = util.get_saved_network_type(this.mContext);
      u.E = util.get_network_type(this.mContext);
      if (i != u.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, u.E);
      }
      u.G = util.get_apn_string(this.mContext).getBytes();
      localu.g = paramString;
      localu.f = 0L;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong2;
      localasync_context._sub_appid = paramLong4;
      localasync_context._main_sigmap = paramInt;
      localasync_context._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        localasync_context._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData == null) || (paramWUserSigInfo._reserveData.length <= 3)) {
        break label740;
      }
      localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localu.i, paramString);
      u.at.add_t2(new report_t2("exchg", new String(u.D), System.currentTimeMillis(), paramLong2, paramLong4, paramArrayOfLong));
      if (util.check_uin_account(paramString).booleanValue()) {
        break label749;
      }
      long l2 = localu.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label755;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      i = -1003;
      label437:
      paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfLong != null) {
        break label1871;
      }
      paramArrayOfLong = new Ticket();
    }
    label1720:
    label1871:
    for (;;)
    {
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(i), i);
      if (i == 0) {
        if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
          RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid);
        }
      }
      for (;;)
      {
        if ((localu.d != null) && (localu.d.get_bitmap() != 0))
        {
          this.mG.d = localu.d;
          RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid, 1);
        }
        oicq.wlogin_sdk.report.c.a();
        u.b();
        localu.i();
        util.LOGI("end GetStWithoutPasswd:user:" + paramString + " dwSrcAppid:" + paramLong1 + " dwDstAppid:" + paramLong2 + " dwDstAppPri:" + paramLong3 + " dwMainSigMap:0x" + Integer.toHexString(paramInt) + " dwSubDstAppid:" + paramLong4 + " Seq:" + localu.h + " ret=" + i, "" + localu.f);
        return i;
        paramWtTicketPromise = "0";
        break;
        label740:
        localu.i = 0;
        break label339;
        label749:
        l1 = Long.parseLong(paramString);
        label755:
        localu.f = l1;
        paramWUserSigInfo.uin = ("" + l1);
        int j;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
        {
          util.LOGI("user:" + paramString + " exchange A2 from A2/D2/KEY.", "" + localu.f);
          if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[1].length == 0) || (paramArrayOfByte2[2] == null) || (paramArrayOfByte2[2].length == 0) || (paramArrayOfByte2[3] == null) || (paramArrayOfByte2[3].length == 0))
          {
            i = -1004;
            break label437;
          }
          localu.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
          j = new n(localu).a(l1, paramLong2, paramLong4, 1, paramInt, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
        }
        for (;;)
        {
          i = j;
          if (j != 0) {
            break;
          }
          paramArrayOfByte2 = localu.a(l1, paramLong2);
          if (paramArrayOfByte2 != null) {
            break label1720;
          }
          i = -1004;
          break;
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
          {
            util.LOGI("user:" + paramString + " exchange A2 from A2/A2KEY.", "" + localu.f);
            if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[1].length == 0) || (paramArrayOfByte2[2] == null) || (paramArrayOfByte2[2].length == 0))
            {
              i = -1004;
              break;
            }
            localu.b = paramArrayOfByte2[2];
            j = new n(localu).a(l1, paramLong2, paramLong4, 1, paramInt, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
            continue;
          }
          localu.k();
          paramArrayOfByte2 = getA1AndNopicSigByAccount(String.valueOf(localu.f), paramLong1);
          paramWtTicketPromise = paramArrayOfByte2.a1;
          localObject = paramArrayOfByte2.noPicSig;
          if ((paramWtTicketPromise != null) && (paramWtTicketPromise.length > 0) && (localObject != null) && (localObject.length > 0))
          {
            util.LOGI("user:" + paramString + " exchange A2 from A1.", "" + localu.f);
            localasync_context._tmp_pwd = paramWtTicketPromise;
            localasync_context._tmp_no_pic_sig = ((byte[])localObject);
            if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
            for (paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();; paramArrayOfByte2 = u.ad)
            {
              ab localab = new ab(localu, this.mContext);
              WloginSigInfo localWloginSigInfo = FindUserSig(l1, paramLong1);
              if (localWloginSigInfo != null) {
                localab.a(localWloginSigInfo);
              }
              j = this.mMiscBitmap;
              i = j;
              if (u.ac) {
                i = j | 0x2000000;
              }
              j = localab.a(paramLong2, 1, localu.f, 0, u.ag, paramWtTicketPromise, (byte[])localObject, i, this.mSubSigMap, paramArrayOfLong, paramInt, paramLong4, 1, u.z, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
              i = j;
              if (j == 204) {
                i = new q(localu).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
              }
              j = i;
              break;
            }
          }
          util.LOGI("user:" + paramString + " exchange A2 from A2.", "" + localu.f);
          paramArrayOfByte2 = localu.a(l1, paramLong1);
          if ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(u.f())))
          {
            i = -1004;
            break;
          }
          util.LOGI("user:" + paramString + " exchange A2 from A2 without Priority.", "" + localu.f);
          printTicket(paramArrayOfByte2);
          localu.b = paramArrayOfByte2._TGTKey;
          j = new n(localu).a(l1, paramLong2, paramLong4, 1, paramInt, paramArrayOfByte2._TGT, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
        }
        paramWUserSigInfo.get_clone(paramArrayOfByte2);
        i = j;
        if (paramArrayOfLong == null) {
          break label437;
        }
        i = j;
        if (paramArrayOfByte1 == null) {
          break label437;
        }
        i = j;
        if (paramArrayOfLong.length * 2 != paramArrayOfByte1.length) {
          break label437;
        }
        int k = 0;
        for (;;)
        {
          i = j;
          if (k >= paramArrayOfLong.length) {
            break;
          }
          paramArrayOfByte2 = localu.a(l1, paramArrayOfLong[k]);
          if (paramArrayOfByte2 != null)
          {
            paramArrayOfByte1[(k * 2)] = ((byte[])paramArrayOfByte2._userSt_Key.clone());
            paramArrayOfByte1[(k * 2 + 1)] = ((byte[])paramArrayOfByte2._userStSig.clone());
          }
          k += 1;
        }
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, localasync_context._appid, 0);
      }
    }
  }
  
  public static void setCustomerGuid(Context paramContext, byte[] paramArrayOfByte)
  {
    util.LOGI("set customer guid " + util.buf_to_string(paramArrayOfByte), "");
    u.al = paramArrayOfByte;
    util.saveGuidToFile(paramContext, paramArrayOfByte);
  }
  
  public static void setExtraLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Integer localInteger = new Integer(paramInt);
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraLoginTLVMap.put(localInteger, localtlv_t);
    int i = paramArrayOfByte[0];
    util.LOGI("setExtraLoginTlvValue tag:" + paramInt + " value[0]: " + (i & 0xFF), paramWUserSigInfo.uin);
  }
  
  private static void setExtraProductLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo._loginExtraProductTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
    int i = paramArrayOfByte[0];
    util.LOGI("setExtraProductLoginTlvValue tag:" + paramInt + " value[0]: " + (i & 0xFF), paramWUserSigInfo.uin);
  }
  
  public static void setExtraRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Integer localInteger = new Integer(paramInt);
    RegTLV localRegTLV = new RegTLV(paramInt);
    localRegTLV.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraRegTLVMap.put(localInteger, localRegTLV);
  }
  
  @Deprecated
  public static void setExtraRegTlvValueWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  public static void setLoadEncryptSo(boolean paramBoolean)
  {
    util.loadEncryptSo = paramBoolean;
  }
  
  public static void setLoadSoFlg(boolean paramBoolean)
  {
    u.ay = paramBoolean;
  }
  
  public static void setProductType(int paramInt)
  {
    u.aA = paramInt;
  }
  
  public static void setQimeiListener(QimeiListener paramQimeiListener)
  {
    util.qimeiListener = paramQimeiListener;
  }
  
  public static void setRegisterFlg(int paramInt)
  {
    u.ak |= paramInt;
  }
  
  public static void setReportListener(ReportListener paramReportListener)
  {
    oicq.wlogin_sdk.report.c.a(paramReportListener);
  }
  
  public static void setSecTransInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    u.aB = paramString1;
    u.aC = paramString2;
    u.aD = paramInt;
    u.aE = paramString3;
  }
  
  public static void setWtDataSender(b paramb)
  {
    mWtDataSender = paramb;
  }
  
  private void tlvCommRsp2ErrMsg(TLV_CommRsp paramTLV_CommRsp, ErrMsg paramErrMsg)
  {
    if ((paramTLV_CommRsp == null) || (paramTLV_CommRsp.get_data_len() == 0)) {
      return;
    }
    paramErrMsg.setType(paramTLV_CommRsp.ErrInfoType);
    paramErrMsg.setOtherinfo(new String(paramTLV_CommRsp.ErrInfo));
    paramErrMsg.setTitle(new String(paramTLV_CommRsp.ErrTitle));
    paramErrMsg.setMessage(new String(paramTLV_CommRsp.ErrMsg));
  }
  
  public int AskDevLockSms(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    util.LOGI("AskDevLockSms ...", paramString);
    localObject = new oicq.wlogin_sdk.devicelock.d();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.devicelock.d)localObject).get_msgType());
    localTransReqContext._body = ((oicq.wlogin_sdk.devicelock.d)localObject).a(l, paramLong1, paramLong2);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, ((oicq.wlogin_sdk.devicelock.d)localObject).Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void CancelRequest()
  {
    this.mG.t = 1;
  }
  
  public int CheckDevLockSms(String paramString1, long paramLong1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString1 == null) {
      return -1017;
    }
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    Object localObject2 = FindUserSig(l, paramLong1);
    if (localObject2 == null) {
      return -1004;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      DevlockBase.rst.setSppKey(paramArrayOfByte);
    }
    util.LOGI("CheckDevLockSms ...", paramString1);
    oicq.wlogin_sdk.devicelock.f localf = new oicq.wlogin_sdk.devicelock.f();
    TransReqContext localTransReqContext = new TransReqContext();
    localObject1 = Build.VERSION.RELEASE;
    paramArrayOfByte = (byte[])localObject1;
    if (localObject1 == null) {
      paramArrayOfByte = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localf.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject2);
    localObject1 = ((WloginSigInfo)localObject2)._TGT;
    localObject2 = u.B;
    byte[] arrayOfByte1 = u.F;
    byte[] arrayOfByte2 = "6.0.0.2484".getBytes();
    byte[] arrayOfByte3 = "android".getBytes();
    paramArrayOfByte = paramArrayOfByte.getBytes();
    if (paramString2 == null) {}
    for (paramString2 = null;; paramString2 = paramString2.getBytes())
    {
      localTransReqContext._body = localf.a(l, paramLong1, paramLong2, (byte[])localObject1, (byte[])localObject2, arrayOfByte1, arrayOfByte2, arrayOfByte3, paramArrayOfByte, paramString2);
      if ((localTransReqContext._body != null) && (localTransReqContext._body.length != 0)) {
        break;
      }
      return -1017;
    }
    return RequestTransport(0, 1, paramString1, paramLong1, localf.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckDevLockStatus(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    localObject = FindUserSig(l, paramLong1);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("CheckDevLockStatus ...", paramString);
    DevlockBase.rst = new DevlockRst();
    oicq.wlogin_sdk.devicelock.a locala = new oicq.wlogin_sdk.devicelock.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(locala.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, u.B, u.F, "6.0.0.2484".getBytes(), u.L, u.K);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, locala.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    o.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    o.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, null, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, null, paramInt, paramLong3, paramWUserSigInfo, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, paramString, 1, -1L, paramWUserSigInfo, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    o.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    o.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, paramArrayOfByte, 0);
  }
  
  public void ClearPSkey(String paramString, long paramLong)
  {
    util.LOGI("user:" + paramString + " appid:" + paramLong + " ClearPSkey ...", paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    int i = 1;
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            i = 0;
            l1 = l2;
          }
          if (i != 0) {
            this.mG.d(l1, paramLong);
          }
          return;
        }
      }
      finally {}
      long l1 = Long.parseLong(paramString);
    }
  }
  
  /* Error */
  public Boolean ClearUserLoginData(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 170	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   7: ldc 173
    //   9: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_1
    //   13: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 1619
    //   19: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_2
    //   23: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc_w 2309
    //   29: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: aload_1
    //   36: invokestatic 192	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 690	java/lang/String:length	()I
    //   47: ifgt +8 -> 55
    //   50: iconst_1
    //   51: invokestatic 2312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: areturn
    //   55: aload_0
    //   56: monitorenter
    //   57: aload_1
    //   58: invokestatic 209	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   61: invokevirtual 215	java/lang/Boolean:booleanValue	()Z
    //   64: ifne +72 -> 136
    //   67: aload_0
    //   68: getfield 75	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/u;
    //   71: aload_1
    //   72: invokevirtual 218	oicq/wlogin_sdk/request/u:b	(Ljava/lang/String;)J
    //   75: lstore 5
    //   77: lload 5
    //   79: lconst_0
    //   80: lcmp
    //   81: ifne +41 -> 122
    //   84: iconst_0
    //   85: istore 4
    //   87: iload 4
    //   89: iconst_1
    //   90: if_icmpne +13 -> 103
    //   93: aload_0
    //   94: getfield 75	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/u;
    //   97: lload 5
    //   99: lload_2
    //   100: invokevirtual 2314	oicq/wlogin_sdk/request/u:e	(JJ)V
    //   103: aload_0
    //   104: monitorexit
    //   105: iconst_0
    //   106: newarray byte
    //   108: putstatic 901	oicq/wlogin_sdk/sharemem/WloginSigInfo:_QRPUSHSig	[B
    //   111: iconst_0
    //   112: newarray byte
    //   114: putstatic 892	oicq/wlogin_sdk/sharemem/WloginSigInfo:_LHSig	[B
    //   117: iconst_1
    //   118: invokestatic 2312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   121: areturn
    //   122: aload_0
    //   123: getfield 75	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/u;
    //   126: aload_1
    //   127: invokevirtual 1389	oicq/wlogin_sdk/request/u:d	(Ljava/lang/String;)V
    //   130: iconst_1
    //   131: istore 4
    //   133: goto -46 -> 87
    //   136: aload_1
    //   137: invokestatic 332	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore 5
    //   142: iconst_1
    //   143: istore 4
    //   145: goto -58 -> 87
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	WtloginHelper
    //   0	153	1	paramString	String
    //   0	153	2	paramLong	long
    //   85	59	4	i	int
    //   75	66	5	l	long
    // Exception table:
    //   from	to	target	type
    //   57	77	148	finally
    //   93	103	148	finally
    //   103	105	148	finally
    //   122	130	148	finally
    //   136	142	148	finally
    //   149	151	148	finally
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    this.mG.k();
    localObject = FindUserSig(l, paramLong);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("user:" + paramString + " CloseCode ...", paramString);
    oicq.wlogin_sdk.code2d.b localb = new oicq.wlogin_sdk.code2d.b();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localb.get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = localb.a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject)._TGT, u.B, paramInt, paramList, ((WloginSigInfo)localObject)._en_A1, ((WloginSigInfo)localObject)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, localb._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CloseDevLock(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong1);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    util.LOGI("CloseDevLock ...", paramString);
    oicq.wlogin_sdk.devicelock.b localb = new oicq.wlogin_sdk.devicelock.b();
    TransReqContext localTransReqContext = new TransReqContext();
    String str = Build.VERSION.RELEASE;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localb.get_msgType());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, u.B, u.F, "6.0.0.2484".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, localb.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int FetchCodeSig(long paramLong1, long paramLong2, fetch_code.QRCodeCustom paramQRCodeCustom, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" FetchCodeSig ...", "");
    fetch_code localfetch_code = new fetch_code();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localfetch_code.get_cmd());
    long l = this.mMiscBitmap;
    byte[] arrayOfByte = WloginSigInfo._QRPUSHSig;
    localTransReqContext._body = localfetch_code.get_request(0L, paramLong1, paramLong2, new byte[0], paramQRCodeCustom, l, 0L, arrayOfByte);
    return RequestTransport(0, 1, null, paramLong1, localfetch_code._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo)
  {
    return GetA1WithA1(paramString, paramLong1, paramLong2, this.mMainSigMap, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, 0);
  }
  
  public byte[] GetA2A2KeyBuf(String paramString, long paramLong)
  {
    Ticket localTicket = GetLocalTicket(paramString, paramLong, 64);
    if ((localTicket == null) || (localTicket._sig == null) || (localTicket._sig.length <= 0) || (localTicket._sig_key == null) || (localTicket._sig_key.length <= 0)) {}
    while ((u.C == null) || (u.C.length <= 0)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.getBytes().length + 2 + 8 + 2 + localTicket._sig.length + 2 + localTicket._sig_key.length];
    util.int16_to_buf(arrayOfByte, 0, paramString.getBytes().length);
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 2, paramString.getBytes().length);
    int i = paramString.getBytes().length + 2;
    util.int64_to_buf(arrayOfByte, i, paramLong);
    i += 8;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig.length);
    i += 2;
    System.arraycopy(localTicket._sig, 0, arrayOfByte, i, localTicket._sig.length);
    i += localTicket._sig.length;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig_key.length);
    i += 2;
    System.arraycopy(localTicket._sig_key, 0, arrayOfByte, i, localTicket._sig_key.length);
    i = localTicket._sig_key.length;
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, u.C);
  }
  
  public List<WloginLoginInfo> GetAllLoginInfo()
  {
    return this.mG.l();
  }
  
  public long GetAppidFromUrl(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    int i = paramString.indexOf("f=");
    if ((i == -1) || (i + 2 >= paramString.length())) {
      return -1L;
    }
    i += 2;
    String str = "";
    for (;;)
    {
      if ((i >= paramString.length()) || (paramString.charAt(i) == '&')) {}
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception paramString) {}
      str = str + paramString.charAt(i);
      i += 1;
    }
    return -1L;
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    boolean bool = true;
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    long l;
    int i;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l = this.mG.b(paramString);
      if (l != 0L) {
        break label173;
      }
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (i == 1)
      {
        paramString = this.mG.d(l);
        if (paramString == null) {
          j = 0;
        }
      }
      else
      {
        label66:
        if (j != 1) {
          break label167;
        }
      }
      for (;;)
      {
        return Boolean.valueOf(bool);
        l = Long.parseLong(paramString);
        i = 1;
        break;
        paramWloginSimpleInfo.setUin(paramString._uin);
        paramWloginSimpleInfo.setFace(paramString._face);
        paramWloginSimpleInfo.setGender(paramString._gender);
        paramWloginSimpleInfo.setNick(paramString._nick);
        paramWloginSimpleInfo.setAge(paramString._age);
        paramWloginSimpleInfo.setImgType(paramString._img_type);
        paramWloginSimpleInfo.setImgFormat(paramString._img_format);
        paramWloginSimpleInfo.setImgUrl(paramString._img_url);
        paramWloginSimpleInfo.setMainDisplayName(paramString.mainDisplayName);
        j = i;
        break label66;
        label167:
        bool = false;
      }
      label173:
      i = 1;
    }
  }
  
  public Boolean GetBasicUserInfoForQQLoginInQimOnly(WUserSigInfo paramWUserSigInfo, WloginSimpleInfo paramWloginSimpleInfo)
  {
    boolean bool = true;
    long l = Long.parseLong(paramWUserSigInfo.uin);
    paramWUserSigInfo = this.mG.d(l);
    int i;
    if (paramWUserSigInfo == null)
    {
      i = 0;
      if (i != 1) {
        break label116;
      }
    }
    for (;;)
    {
      return Boolean.valueOf(bool);
      paramWloginSimpleInfo.setUin(paramWUserSigInfo._uin);
      paramWloginSimpleInfo.setFace(paramWUserSigInfo._face);
      paramWloginSimpleInfo.setGender(paramWUserSigInfo._gender);
      paramWloginSimpleInfo.setNick(paramWUserSigInfo._nick);
      paramWloginSimpleInfo.setAge(paramWUserSigInfo._age);
      paramWloginSimpleInfo.setImgType(paramWUserSigInfo._img_type);
      paramWloginSimpleInfo.setImgFormat(paramWUserSigInfo._img_format);
      paramWloginSimpleInfo.setImgUrl(paramWUserSigInfo._img_url);
      paramWloginSimpleInfo.setMainDisplayName(paramWUserSigInfo.mainDisplayName);
      i = 1;
      break;
      label116:
      bool = false;
    }
  }
  
  public DevlockInfo GetDevLockInfo(String paramString)
  {
    return GetDevLockInfo(paramString, 0L);
  }
  
  public DevlockInfo GetDevLockInfo(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return u.b(l)._devlock_info;
  }
  
  public byte[] GetGuid()
  {
    byte[] arrayOfByte2 = u.a(this.mContext);
    if (arrayOfByte2 != null) {
      return arrayOfByte2;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    if (u.B != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (u.B.length > 0)
      {
        arrayOfByte1 = new byte[u.B.length];
        System.arraycopy(u.B, 0, arrayOfByte1, 0, u.B.length);
      }
    }
    util.LOGI("get guid " + util.buf_to_string(arrayOfByte1), "");
    return arrayOfByte1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.l();
    if (localObject == null) {}
    label124:
    label125:
    for (;;)
    {
      return null;
      Iterator localIterator = ((List)localObject).iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
        if (localObject == null)
        {
          localObject = localWloginLoginInfo;
        }
        else
        {
          if (localWloginLoginInfo.mCreateTime <= ((WloginLoginInfo)localObject).mCreateTime) {
            break label124;
          }
          localObject = localWloginLoginInfo;
        }
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label125;
        }
        if ((((WloginLoginInfo)localObject).mAccount != null) && (((WloginLoginInfo)localObject).mAccount.length() > 0)) {
          return new WloginLastLoginInfo(((WloginLoginInfo)localObject).mAccount, ((WloginLoginInfo)localObject).mUin);
        }
        return new WloginLastLoginInfo(String.valueOf(((WloginLoginInfo)localObject).mUin), ((WloginLoginInfo)localObject).mUin);
      }
    }
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          l = this.mG.b(paramString);
          if (l == 0L) {
            break;
          }
          localWloginSigInfo = this.mG.a(l, paramLong);
          if (localWloginSigInfo == null) {
            continue;
          }
          localWUserSigInfo = new WUserSigInfo();
        }
      }
      catch (Exception localException1)
      {
        long l;
        WloginSigInfo localWloginSigInfo;
        WUserSigInfo localWUserSigInfo = null;
        util.printException(localException1, paramString);
        continue;
        localWUserSigInfo = null;
        continue;
      }
      try
      {
        localWUserSigInfo.uin = paramString;
        localWUserSigInfo.get_clone(localWloginSigInfo);
        util.LOGI("skey in sigInfo " + util.getMaskBytes(localWloginSigInfo._sKey, 2, 2), paramString);
        return localWUserSigInfo;
      }
      catch (Exception localException2)
      {
        continue;
      }
      l = Long.parseLong(paramString);
    }
  }
  
  public Ticket GetLocalTicket(String paramString, long paramLong, int paramInt)
  {
    util.LOGI("GetLocalTicket appid " + paramLong + " type 0x" + String.format("%x", new Object[] { Integer.valueOf(paramInt) }), paramString);
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    return GetUserSigInfoTicket(GetLocalSig(paramString, paramLong), paramInt);
  }
  
  public int GetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, this.mOpenAppid, -1L, paramInt, paramLong2, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public byte[] GetPictureData(String paramString)
  {
    return GetPictureData(paramString, 0L);
  }
  
  public byte[] GetPictureData(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return u.b(l)._t105.get_pic();
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString)
  {
    return GetPicturePrompt(paramString, 0L);
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return u.b(l)._t165.get_data();
  }
  
  public String GetPicturePromptValue(String paramString)
  {
    return GetPicturePromptValue(paramString, 0L);
  }
  
  public String GetPicturePromptValue(String paramString, long paramLong)
  {
    paramString = GetPicturePrompt(paramString, paramLong);
    int k;
    int j;
    int i;
    if ((paramString != null) && (paramString.length > 3))
    {
      k = util.buf_to_int32(paramString, 0);
      j = 4;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (paramString.length < j + 1)) {}
      int m;
      String str1;
      do
      {
        do
        {
          do
          {
            return "";
            m = util.buf_to_int8(paramString, j);
            j += 1;
          } while (paramString.length < j + m);
          str1 = new String(paramString, j, m);
          m = j + m;
        } while (paramString.length < m + 2);
        j = util.buf_to_int32(paramString, m);
        m += 4;
      } while (paramString.length < m + j);
      String str2 = new String(paramString, m, j);
      if (str1.equals("pic_reason")) {
        return str2;
      }
      i += 1;
      j += m;
    }
  }
  
  public Ticket GetPskey(String paramString, long paramLong, String[] arg4, WtTicketPromise paramWtTicketPromise)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("domains", ???);
    String str = "";
    int i = 0;
    while (i < ???.length)
    {
      str = str + ???[i] + ",";
      i += 1;
    }
    synchronized (GET_TICKET_LOCK)
    {
      util.LOGI("GetPskey appid " + paramLong + " domains " + str, paramString);
      paramString = GetTicket(paramString, paramLong, 1048576, paramWtTicketPromise, localBundle);
      return paramString;
    }
  }
  
  public Ticket GetSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    synchronized (GET_TICKET_LOCK)
    {
      paramString = GetTicket(paramString, paramLong, 4096, paramWtTicketPromise, null);
      return paramString;
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
    if (oicq.wlogin_sdk.a.k.y) {}
    for (String str = oicq.wlogin_sdk.a.k.A;; str = "") {
      return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, null, false, str, paramWUserSigInfo, (byte[][])null, true, 0);
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = (byte[][])null;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int i = paramArrayOfLong.length;
      arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i, 0 });
    }
    for (;;)
    {
      util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
      if (oicq.wlogin_sdk.a.k.y) {}
      for (String str = oicq.wlogin_sdk.a.k.A;; str = "") {
        return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, paramArrayOfLong, false, str, paramWUserSigInfo, arrayOfByte, true, 0);
      }
    }
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, paramArrayOfLong, paramBoolean, paramString2, paramWUserSigInfo, paramArrayOfByte, false, 0);
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswd(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithPasswdMd5(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswdMd5(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = new byte[4][];
    arrayOfByte[0] = new byte[1];
    arrayOfByte[0][0] = 1;
    arrayOfByte[1] = paramArrayOfByte1;
    arrayOfByte[2] = paramArrayOfByte2;
    arrayOfByte[3] = paramArrayOfByte3;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, arrayOfByte, 0, null);
  }
  
  @Deprecated
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, this.mMainSigMap, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0, null);
  }
  
  public int GetStWithoutPasswd(byte[] paramArrayOfByte, long paramLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return -1017;
    }
    Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, u.C);
    if ((localObject == null) || (localObject.length <= 0)) {
      return -1017;
    }
    if (2 > localObject.length) {
      return -1017;
    }
    int i = util.buf_to_int16((byte[])localObject, 0);
    if ((i <= 0) || (i + 2 > localObject.length)) {
      return -1017;
    }
    paramArrayOfByte = new String((byte[])localObject, 2, i);
    i += 2;
    if (i + 8 > localObject.length) {
      return -1017;
    }
    long l = util.buf_to_int64((byte[])localObject, i);
    int j = i + 8;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte1, 0, arrayOfByte1.length);
    j += i;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte2, 0, arrayOfByte2.length);
    localObject = new byte[3][];
    localObject[0] = new byte[1];
    localObject[0][0] = 2;
    localObject[1] = arrayOfByte1;
    localObject[2] = arrayOfByte2;
    return GetStWithoutPasswd(paramArrayOfByte, l, paramLong, -1L, paramInt, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])localObject, 0, null);
  }
  
  public Ticket GetTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    Object localObject2 = new StringBuilder().append("GetTicket ").append(paramString).append(", ").append(paramLong).append(" sig ").append(Integer.toHexString(paramInt)).append(" ");
    if (paramBundle == null) {}
    int j;
    Object localObject3;
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramBundle.size()))
    {
      util.LOGI(localObject1, "");
      localObject1 = null;
      j = 2;
      localObject2 = GetLocalSig(paramString, paramLong);
      if (localObject2 != null) {
        break label227;
      }
      if (j != 1) {
        break;
      }
      localObject3 = localObject1;
      label103:
      if (!IsNeedLoginWithPasswd(paramString, paramLong).booleanValue()) {
        break label517;
      }
      paramBundle = new ErrMsg();
      paramBundle.setType(-1004);
      if (paramWtTicketPromise != null) {
        paramWtTicketPromise.Failed(paramBundle);
      }
      util.LOGI("get null for sigType:0x" + Integer.toHexString(paramInt), paramString);
      localObject1 = null;
      label177:
      return localObject1;
    }
    RefreshMemorySig();
    int i = j - 1;
    localObject2 = localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      j = i;
      if (i > 0) {
        break;
      }
      localObject3 = localObject2;
      break label103;
      label227:
      Ticket localTicket = GetUserSigInfoTicket((WUserSigInfo)localObject2, paramInt);
      if ((localTicket == null) || (localTicket._sig == null) || (localTicket._sig.length == 0))
      {
        localObject3 = localObject1;
        if (j == 1) {
          break label103;
        }
        RefreshMemorySig();
        i = j - 1;
        localObject2 = localObject1;
        continue;
      }
      long l = u.f();
      localObject2 = localObject1;
      if (paramBundle != null)
      {
        localObject2 = localObject1;
        if (paramInt == 1048576) {
          localObject2 = paramBundle.getStringArray("domains");
        }
      }
      i = isPskeyExpired(paramInt, (String[])localObject2, localTicket, l, j);
      localObject3 = localObject2;
      if (i == 1) {
        break label103;
      }
      if (i == 2)
      {
        i = j - 1;
      }
      else
      {
        localObject1 = localTicket;
        if (i == 3) {
          break label177;
        }
        util.LOGI("GetTicket sigType:0x" + Integer.toHexString(paramInt) + " expires in " + (localTicket._expire_time - l) / 60L / 60L + "h", "");
        if (paramInt == 4096)
        {
          localObject1 = localTicket;
          if (true != Ticket.isSkeyExpired(localTicket._expire_time)) {
            break label177;
          }
          localObject3 = localObject2;
          if (j == 1) {
            break label103;
          }
          RefreshMemorySig();
          i = j - 1;
          continue;
        }
        localObject1 = localTicket;
        if (l < localTicket._expire_time) {
          break label177;
        }
        localObject3 = localObject2;
        if (j == 1) {
          break label103;
        }
        RefreshMemorySig();
        i = j - 1;
      }
    }
    label517:
    localObject1 = new WUserSigInfo();
    if (paramBundle != null) {}
    for (i = paramBundle.getInt("subappid", 1);; i = 1)
    {
      if (localObject3 != null)
      {
        j = 0;
        int k = Math.min(20, localObject3.length);
        while (j < k)
        {
          paramBundle = localObject3[j];
          if ((paramBundle != null) && (paramBundle.length() > 0)) {
            ((WUserSigInfo)localObject1)._domains.add(paramBundle);
          }
          j += 1;
        }
      }
      GetStWithoutPasswd(paramString, paramLong, paramLong, i, paramInt, (WUserSigInfo)localObject1, new WtloginHelper.1(this, paramString, paramLong, paramInt, paramWtTicketPromise));
      break;
    }
  }
  
  public long GetTimeDifference()
  {
    return u.ae;
  }
  
  public Boolean IsNeedLoginWithPasswd(String paramString, long paramLong)
  {
    boolean bool = false;
    int i = 1;
    if (paramString == null) {
      return Boolean.valueOf(true);
    }
    for (;;)
    {
      try
      {
        long l1;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            bool = true;
            util.LOGI("NeedLoginWithPasswd:" + bool + " appid:" + paramLong + " flag=" + i, paramString);
            return Boolean.valueOf(bool);
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
        if ((localWloginSigInfo != null) && (localWloginSigInfo._en_A1 != null) && (localWloginSigInfo._en_A1.length != 0) && (localWloginSigInfo._noPicSig != null) && (localWloginSigInfo._noPicSig.length != 0))
        {
          i = 2;
          continue;
        }
        if ((localWloginSigInfo == null) || (localWloginSigInfo._TGT == null) || (localWloginSigInfo._TGT.length == 0) || (localWloginSigInfo.iSExpireA2(u.f()))) {
          break label215;
        }
        i = 0;
      }
      finally {}
      continue;
      label215:
      bool = true;
      i = 3;
    }
  }
  
  public Boolean IsUserHaveA1(String paramString, long paramLong)
  {
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    long l1;
    Object localObject;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 != 0L) {
        break label116;
      }
      localObject = null;
    }
    while ((localObject == null) || (localObject._en_A1 == null) || (localObject._en_A1.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: null", paramString);
      return Boolean.valueOf(false);
      l1 = Long.parseLong(paramString);
      label116:
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      localObject = localWloginSigInfo;
      if (localWloginSigInfo == null) {
        localObject = localWloginSigInfo;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: not null", paramString);
    return Boolean.valueOf(true);
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.indexOf("?k=");
      } while ((i == -1) || (i + 3 + 32 > paramString.length()));
      i += 3;
      paramString = paramString.substring(i, i + 32);
    } while (util.base64_decode_url(paramString.getBytes(), paramString.length()) == null);
    return true;
  }
  
  public byte[] PickupQRCode(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.matches(".*[?&]k=([^&$]+).*")) {
      return null;
    }
    paramString = paramString.replaceAll(".*[?&]k=([^&$]+).*", "$1");
    return util.base64_decode_url(paramString.getBytes(), paramString.length());
  }
  
  public Intent PrepareQloginIntent(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject1 = "com.tencent.mobileqq";
    boolean bool1 = util.isMQQExist(this.mContext);
    boolean bool2 = util.isPackageExist(this.mContext, "com.tencent.minihd.qq");
    if (!bool1)
    {
      if (bool2) {
        localObject1 = "com.tencent.minihd.qq";
      }
    }
    else
    {
      Object localObject3 = util.get_rsa_pubkey(this.mContext);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (localObject3.length != 0) {}
      }
      else
      {
        localObject2 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
      }
      localObject3 = new Intent();
      ((Intent)localObject3).setClassName((String)localObject1, "com.tencent.open.agent.AgentActivity");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("dstSsoVer", 1L);
      ((Bundle)localObject1).putLong("dstAppid", paramLong1);
      ((Bundle)localObject1).putLong("subDstAppid", paramLong2);
      ((Bundle)localObject1).putByteArray("dstAppVer", paramString.getBytes());
      ((Bundle)localObject1).putByteArray("publickey", (byte[])localObject2);
      ((Intent)localObject3).putExtra("key_params", (Bundle)localObject1);
      ((Intent)localObject3).putExtra("key_action", "action_quick_login");
      return localObject3;
    }
    return null;
  }
  
  public Intent PrepareQloginResult(String paramString, long paramLong1, long paramLong2, int paramInt, WFastLoginInfo paramWFastLoginInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_uin", paramString);
    paramString = (byte[])paramWFastLoginInfo._outA1.clone();
    if ((paramString != null) && (paramString.length > 0)) {
      localIntent.putExtra("quicklogin_buff", new RSACrypt(this.mContext).EncryptData(util.get_cp_pubkey(this.mContext, paramLong1, paramLong2), paramString));
    }
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("user_json", paramWFastLoginInfo.userJson);
    return localIntent;
  }
  
  public Intent PrepareSilenceLoginIntent(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject2 = util.get_rsa_pubkey(this.mContext);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
    }
    localObject2 = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putLong("dstSsoVer", 1L);
    localBundle.putLong("dstAppid", paramLong1);
    localBundle.putLong("subDstAppid", paramLong2);
    localBundle.putByteArray("dstAppVer", paramString.getBytes());
    localBundle.putByteArray("publickey", (byte[])localObject1);
    ((Intent)localObject2).putExtra("key_params", localBundle);
    ((Intent)localObject2).putExtra("key_action", "action_quick_login");
    return localObject2;
  }
  
  public int QueryCodeResult(long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" QueryCodeResult ...", "");
    oicq.wlogin_sdk.code2d.e locale = new oicq.wlogin_sdk.code2d.e();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locale.get_cmd());
    util.LOGI("qrsig " + util.buf_to_string(oicq.wlogin_sdk.code2d.d.i));
    localTransReqContext._body = locale.a(0L, paramLong, oicq.wlogin_sdk.code2d.d.i, new byte[0]);
    return RequestTransport(0, 1, null, paramLong, locale._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void RefreshMemorySig()
  {
    this.mG.k();
  }
  
  public int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
    if (paramWUserSigInfo == null) {
      localWUserSigInfo = new WUserSigInfo();
    }
    return RefreshPictureData(paramString, localWUserSigInfo, 0);
  }
  
  public int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new WUserSigInfo();
    }
    for (;;)
    {
      return RefreshSMSData(paramString, paramLong, paramWUserSigInfo, paramArrayOfByte, 0);
    }
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return RegGetAccount(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, null, paramInt, paramWUserSigInfo);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length <= 0)) {
      return -1017;
    }
    util.LOGI("RegGetAccount ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localk.j = ((byte[])paramArrayOfByte1.clone());; localk.j = new byte[0])
    {
      if ((paramInt == 4) || (paramInt == 5)) {
        localk.b = "";
      }
      oicq.wlogin_sdk.a.k.y = false;
      oicq.wlogin_sdk.a.k.z = 0L;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(locald.a());
      localTransReqContext._body = locald.a(localk.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, localk.b.getBytes(), paramArrayOfByte2, false, GetGuid(), 0L, u.F, paramArrayOfByte5, u.A, paramArrayOfByte6, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localk.j = ((byte[])paramArrayOfByte1.clone());; localk.j = new byte[0])
    {
      oicq.wlogin_sdk.a.k.y = true;
      oicq.wlogin_sdk.a.k.A = util.get_mpasswd();
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(locald.a());
      localTransReqContext._body = locald.a(localk.e, paramArrayOfByte1, oicq.wlogin_sdk.a.k.A.getBytes(), paramArrayOfByte3, 1, localk.b.getBytes(), paramArrayOfByte2, true, GetGuid(), localk.h, u.F, paramArrayOfByte4, u.A, null, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.k();
    this.mRegStatus.b = new String(arrayOfByte);
    paramArrayOfByte = new oicq.wlogin_sdk.a.e();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(paramArrayOfByte.a());
    localTransReqContext._body = paramArrayOfByte.a(paramInt, arrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSentMsgStatus ...", "");
    oicq.wlogin_sdk.a.f localf = new oicq.wlogin_sdk.a.f();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localf.a());
    localTransReqContext._body = localf.b(localk.e, this.mRegStatus.p);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegRequestServerResendMsg ...", "");
    g localg = new g();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localg.a());
    localTransReqContext._body = localg.b(localk.e, null);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = paramString.getBytes()) {
      return RegSubmitMobile(paramString, paramArrayOfByte1, null, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, paramMap);
    }
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return RegSubmitMobile(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, null);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    oicq.wlogin_sdk.a.j localj = new oicq.wlogin_sdk.a.j();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.k localk = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localj.a());
    localTransReqContext._body = localj.b(localk.e, paramArrayOfByte);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RequestTransport(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, paramWUserSigInfo, "RequestTransport").RunReq(9);
      return -1001;
    }
    u localu = this.mG.a(0L);
    util.LOGI("encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localu.h + "subcmd=" + paramTransReqContext._subcmd + " RequestTransport...", paramString);
    localu.g = paramString;
    if (paramInt2 != 0) {
      if (paramString == null)
      {
        localu.m = 0;
        paramInt1 = new ac(localu).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
    }
    for (;;)
    {
      localu.j();
      util.LOGI("encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localu.h + "subcmd=" + paramTransReqContext._subcmd + " RequestTransport ret=" + paramInt1, paramString);
      return paramInt1;
      WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()))
      {
        paramInt1 = -1003;
      }
      else
      {
        WloginSigInfo localWloginSigInfo = localu.a(localWloginSimpleInfo._uin, paramLong1);
        if (localWloginSigInfo == null)
        {
          paramInt1 = -1004;
        }
        else
        {
          localu.f = localWloginSimpleInfo._uin;
          paramInt1 = new ac(localu).a(localWloginSimpleInfo._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
          continue;
          localu.f = 0L;
          paramInt1 = new ac(localu).a(localu.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
        }
      }
    }
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    u localu = this.mG.a(0L);
    util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localu.h + " RequestTransportMsf...", paramString);
    localu.g = paramString;
    Object localObject1;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue())) {
        paramInt1 = -1003;
      }
    }
    for (;;)
    {
      localu.j();
      util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localu.h + " RequestTransportMsf ret=" + paramInt1, paramString);
      return paramInt1;
      Object localObject2 = localu.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
      if (localObject2 == null)
      {
        paramInt1 = -1004;
      }
      else
      {
        localu.f = ((WloginSimpleInfo)localObject1)._uin;
        paramInt1 = new ac(localu).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        continue;
        if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
        {
          localu.f = 0L;
          localObject1 = new ac(localu);
          localObject2 = new WUserSigInfo();
          paramInt1 = ((ac)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
        }
        else
        {
          localObject1 = new WloginSimpleInfo();
          if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
          {
            paramInt1 = -1003;
          }
          else
          {
            localObject2 = localu.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
            if (localObject2 == null)
            {
              paramInt1 = -1004;
            }
            else
            {
              localu.f = ((WloginSimpleInfo)localObject1)._uin;
              paramInt1 = new ac(localu).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
            }
          }
        }
      }
    }
  }
  
  public WUserSigInfo ResolveQloginIntentReserved(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    if (paramIntent.getExtras().getInt("quicklogin_ret") != 0)
    {
      util.LOGI("ResolveQloginIntentReserved quicklogin_ret is null", "");
      return null;
    }
    String str = paramIntent.getExtras().getString("quicklogin_uin");
    paramIntent = paramIntent.getExtras().getByteArray("quicklogin_buff");
    if ((str == null) || (paramIntent == null))
    {
      util.LOGI("ResolveQloginIntentReserved uin or buff is null", "");
      return null;
    }
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    localWUserSigInfo._fastLoginBuf = new RSACrypt(this.mContext).DecryptData(null, paramIntent);
    if (localWUserSigInfo._fastLoginBuf == null)
    {
      util.LOGI("rsa decrypt failed", "");
      return null;
    }
    localWUserSigInfo.uin = str;
    return localWUserSigInfo;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    u.x = paramInt;
  }
  
  public void SetCanWebVerify(int paramInt)
  {
    l.K = paramInt;
    util.LOGI("SetCanWebVerify old:" + l.K + " canWebVerify:" + paramInt, "");
  }
  
  public void SetDevlockMobileType(int paramInt)
  {
    s.K = paramInt;
  }
  
  public void SetImgType(int paramInt)
  {
    u.y = paramInt;
    this.mMiscBitmap |= 0x80;
  }
  
  public WtloginListener SetListener(WtloginListener paramWtloginListener)
  {
    WtloginListener localWtloginListener = this.mListener;
    this.mListener = paramWtloginListener;
    return localWtloginListener;
  }
  
  public void SetLocalId(int paramInt)
  {
    u.v = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    this.mG.k = paramInt;
    if (paramInt != 0)
    {
      u.ag = new byte[4];
      u.af = 0L;
      this.mG.l = 45000;
    }
  }
  
  public int SetNeedForPayToken(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      l.L = paramString1.getBytes();
      if (paramArrayOfByte != null) {
        l.N = paramArrayOfByte;
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        paramString1 = util.getChannelId(this.mContext, null);
      }
      l.M = paramString1.getBytes();
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        return -2;
      }
    }
    else
    {
      return -1;
    }
    return 0;
  }
  
  public void SetPicType(int paramInt)
  {
    u.z = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    u.A = paramInt;
  }
  
  public void SetSigMap(int paramInt)
  {
    this.mMainSigMap = (paramInt | 0xC0);
  }
  
  public void SetTestHost(int paramInt, String paramString)
  {
    oicq_request.a(paramInt, paramString);
  }
  
  public void SetTimeOut(int paramInt)
  {
    this.mG.l = paramInt;
  }
  
  public void SetUinDeviceToken(boolean paramBoolean)
  {
    u.ac = paramBoolean;
  }
  
  public int VerifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    Object localObject3 = new tlv_t400();
    Object localObject2 = new byte[0];
    localObject1 = localObject2;
    if (localWloginSigInfo._G != null)
    {
      localObject1 = localObject2;
      if (localWloginSigInfo._G.length > 0)
      {
        localObject1 = localObject2;
        if (localWloginSigInfo._dpwd != null)
        {
          localObject1 = localObject2;
          if (localWloginSigInfo._dpwd.length > 0)
          {
            localObject1 = localObject2;
            if (localWloginSigInfo._randseed != null)
            {
              localObject1 = localObject2;
              if (localWloginSigInfo._randseed.length > 0)
              {
                ((tlv_t400)localObject3).get_tlv_400(localWloginSigInfo._G, l, u.B, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
                localObject1 = ((tlv_t400)localObject3).get_data();
              }
            }
          }
        }
      }
    }
    util.LOGI("user:" + paramString + " VerifyCode ...", paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.f();
    localObject3 = new TransReqContext();
    ((TransReqContext)localObject3).set_code2d_func_req();
    ((TransReqContext)localObject3).set_subcmd(((oicq.wlogin_sdk.code2d.f)localObject2).get_cmd());
    ((TransReqContext)localObject3).setSTEncryptMethod();
    ((TransReqContext)localObject3).setWtST(localWloginSigInfo);
    ((TransReqContext)localObject3)._body = ((oicq.wlogin_sdk.code2d.f)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._TGT, u.B, u.F, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.f)localObject2)._role, (TransReqContext)localObject3, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
  }
  
  public int cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    this.mG.k();
    localObject = FindUserSig(l, paramLong);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("user:" + paramString + " CancelCode ...", paramString);
    oicq.wlogin_sdk.code2d.a locala = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locala.get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(l, paramLong, paramArrayOfByte, ((WloginSigInfo)localObject)._TGT);
    return RequestTransport(0, 1, paramString, paramLong, locala._role, localTransReqContext, paramWUserSigInfo);
  }
  
  protected int checkSMSAndGetStForGateWay(u paramu, async_context paramasync_context, String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2)
  {
    paramString = new StringBuilder("checkSMSAndGetStForGateWay").append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    paramString.append(",seq=").append(paramu.h);
    paramString.append(",_mpasswd=").append(paramasync_context._mpasswd);
    paramString.append(",_msalt=").append(Long.toHexString(paramasync_context._msalt));
    paramString.append(",_appid=").append(paramasync_context._appid);
    paramString.append(",_sub_appid=").append(paramasync_context._sappid);
    paramString.append(",_sappid=").append(paramasync_context._sub_appid);
    paramString.append(",dwMainSigMap=").append(paramasync_context._main_sigmap);
    paramu.f = 0L;
    paramWUserSigInfo.uin = "";
    int i = new p(paramu).b(2).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, paramasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
    if (i != 0)
    {
      paramString.append("，request_checksms fail ret = ").append(i);
      util.LOGI(paramString.toString(), "");
      return i;
    }
    long l1 = paramasync_context._sappid;
    long l2 = paramasync_context._sappid;
    i = paramasync_context._main_sigmap;
    paramString.append("，_ui=").append(paramu.f);
    paramWUserSigInfo.uin = String.valueOf(paramu.f);
    i = getTicketByGateway(l1, l2, i, paramWUserSigInfo, paramString, paramu, paramasync_context);
    util.LOGI(paramString.toString(), "");
    return i;
  }
  
  public boolean getHasPassword(long paramLong)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("getHasPasswd ..." + String.valueOf(str), "" + paramLong);
    if (str == null) {}
    UinInfo localUinInfo;
    do
    {
      return true;
      localUinInfo = this.mG.c(str);
    } while (localUinInfo == null);
    boolean bool = localUinInfo.getHasPassword();
    util.LOGI("getHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPasswd: " + bool, "");
    return bool;
  }
  
  public int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return getStWithQrSig(paramString, paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
  }
  
  public String getUserAccountFromQuickLoginResultData(Intent paramIntent)
  {
    return "";
  }
  
  public String getUserInputFromQuickLoginResultData(Intent paramIntent)
  {
    return "";
  }
  
  public int modifyQIMPassword(int paramInt, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return -1017;
    }
    util.LOGI("modifyQIMPassword : cmd=" + paramInt);
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(paramInt);
    localTransReqContext._body = paramArrayOfByte;
    int i = 6084;
    if (paramInt == 1749) {
      i = 5063;
    }
    return RequestTransport(0, 1, null, 16L, i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int onQuickLoginActivityResultData(QuickLoginParam paramQuickLoginParam, Intent paramIntent)
  {
    return 0;
  }
  
  public int quickLogin(Activity paramActivity, long paramLong1, long paramLong2, String paramString, QuickLoginParam paramQuickLoginParam)
  {
    util.LOGI("quickLogin start " + System.currentTimeMillis(), "");
    return 0;
  }
  
  public int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return quickLoginByGateway(paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
  }
  
  public int quickLoginByWeChat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, "", paramArrayOfByte1, paramArrayOfByte2, paramQuickLoginParam, "quickLoginByWeChat").RunReq(18);
      return -1001;
    }
    WUserSigInfo localWUserSigInfo = paramQuickLoginParam.userSigInfo;
    u localu = this.mG.a(0L);
    localu.g = paramQuickLoginParam.userAccount;
    localWUserSigInfo._seqence = localu.h;
    this.mAysncSeq = localu.h;
    async_context localasync_context = u.b(localu.h);
    util.LOGI("quickLoginByWeChat seq:" + localu.h, "");
    localasync_context._last_err_msg = new ErrMsg();
    paramQuickLoginParam.sigMap |= 0xC0;
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._sub_appid_list = paramQuickLoginParam.dstSubAppidList;
    paramInt = new w(localu).a(paramArrayOfByte1, paramArrayOfByte2, localWUserSigInfo);
    util.LOGI("quickLoginByWeChat request_login_by_wechat ret" + paramInt);
    if (paramInt != 0)
    {
      util.LOGI("quickLoginByWeChat seq " + localu.h + " ret " + paramInt);
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramArrayOfByte1 = new l(localu, this.mContext);
    paramArrayOfByte1.g();
    int i = paramArrayOfByte1.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localu.f, 0, u.ag, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, u.z, 0, 0, 1, u.ad, localWUserSigInfo);
    paramInt = i;
    if (i == 204)
    {
      util.LOGI("quickLoginByWeChat seq:" + localu.h + " ret:SEC_GUID", "");
      paramInt = new q(localu).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      util.LOGI("quickLoginByWeChat seq:" + localu.h + " ret:" + paramInt, "");
      return paramInt;
    }
    paramArrayOfByte1 = localu.a(localu.f, paramQuickLoginParam.appid);
    if (paramArrayOfByte1 == null)
    {
      util.LOGI("quickLoginByWeChat WloginSigInfo is null", "");
      return -1004;
    }
    localWUserSigInfo.get_clone(paramArrayOfByte1);
    paramArrayOfByte1 = GetUserSigInfoTicket(localWUserSigInfo, 128);
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new Ticket();
    }
    for (;;)
    {
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0) {
        if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid);
        }
      }
      for (;;)
      {
        if ((localu.d != null) && (localu.d.get_bitmap() != 0))
        {
          this.mG.d = localu.d;
          RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 1);
        }
        oicq.wlogin_sdk.report.c.a();
        u.b();
        localu.i();
        util.LOGI("quickLoginByWeChat seq:" + localu.h + " ret " + paramInt, "");
        return paramInt;
        if ((paramInt != 2) && (paramInt != 160)) {
          RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 0);
        }
      }
    }
  }
  
  public int quickRegisterCheckAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    util.LOGI("quickRegisterCheckAccount " + paramLong1 + " appid " + paramLong2, "" + paramLong1);
    Ticket localTicket = GetLocalTicket("" + paramLong1, paramLong2, 64);
    if (localTicket == null)
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig == null) || (localTicket._sig.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig_key == null) || (localTicket._sig_key.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    oicq.wlogin_sdk.a.a locala = new oicq.wlogin_sdk.a.a();
    TransReqContext localTransReqContext = new TransReqContext();
    this.mRegStatus.l = localTicket._sig_key;
    Object localObject = this.mRegStatus;
    ((oicq.wlogin_sdk.a.k)localObject).g = paramLong2;
    ((oicq.wlogin_sdk.a.k)localObject).h = paramInt2;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locala.a());
    localObject = FindUserSig(paramLong1, paramLong2);
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(paramLong1, (int)paramLong2, (byte)8, localTicket._sig, localTicket._sig_key, (byte)paramInt1, GetGuid(), paramInt2, u.F, paramArrayOfByte, util.generateGuid(this.mContext), util.get_IMSI(this.mContext));
    if (localTransReqContext._body == null)
    {
      util.LOGI("req_con._body is null", "" + paramLong1);
      return -1017;
    }
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int quickRegisterGetAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null) || (paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (6 > paramString.length()) {
      return -1017;
    }
    util.LOGI("quickRegisterGetAccount " + paramLong1 + " appid " + paramLong2, "" + paramLong1);
    Ticket localTicket = GetLocalTicket("" + paramLong1, paramLong2, 64);
    if (localTicket == null)
    {
      util.LOGI("quickRegisterCheckAccount " + paramLong1 + " appid " + paramLong2 + " no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig == null) || (localTicket._sig.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    if ((localTicket._sig_key == null) || (localTicket._sig_key.length == 0))
    {
      util.LOGI("quickRegisterCheckAccount no key", "" + paramLong1);
      return -1004;
    }
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    this.mRegStatus.l = localTicket._sig_key;
    Object localObject = this.mRegStatus;
    ((oicq.wlogin_sdk.a.k)localObject).g = paramLong2;
    ((oicq.wlogin_sdk.a.k)localObject).h = paramInt2;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localb.a());
    localObject = FindUserSig(paramLong1, paramLong2);
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = localb.a(paramLong1, (int)paramLong2, (byte)8, localTicket._sig, localTicket._sig_key, (byte)paramInt1, paramArrayOfByte2, GetGuid(), paramInt2, u.F, paramArrayOfByte1, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), paramString.getBytes(), this.mRegStatus.e);
    if (localTransReqContext._body == null)
    {
      util.LOGI("req_con._body is null", "" + paramLong1);
      return -1017;
    }
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.k.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public void setBabyQFlg(boolean paramBoolean)
  {
    u.aj = paramBoolean;
  }
  
  public void setCallSource(int paramInt)
  {
    u.ai = paramInt;
  }
  
  public void setForQCall()
  {
    u.ax = true;
    WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
  }
  
  public void setHasPassword(long paramLong, boolean paramBoolean)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("setHasPasswd ..." + String.valueOf(str), "");
    if (str == null) {
      return;
    }
    this.mG.a(str, Long.valueOf(paramLong), paramBoolean);
    util.LOGI("setHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPassword:" + paramBoolean, "");
  }
  
  public void setMsgType(int paramInt1, int paramInt2, int paramInt3)
  {
    oicq.wlogin_sdk.devicelock.DevlockBase.a.a = paramInt1;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.b = paramInt2;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.c = paramInt3;
  }
  
  private static class A1AndNopicSig
  {
    byte[] a1 = null;
    byte[] noPicSig = null;
  }
  
  private static class A1SRC
  {
    public static final int A1SRC_PASSWORD = 1;
    public static final int A1SRC_PTSIG = 4;
    public static final int A1SRC_QUICKLOGIN = 2;
    public static final int A1SRC_SMS = 3;
  }
  
  public class HelperThread
    extends Thread
  {
    public static final String THREAD_NAME_PRE = "Wtlogin_";
    boolean isSelfLooper = false;
    byte[] mAppName2;
    byte[] mAppSign2;
    byte[] mAppVer2;
    long mAppid1;
    long mAppid2;
    long mDwAppid;
    long mDwDstAppPri;
    long mDwDstAppid;
    long[] mDwDstSubAppidList;
    int mDwMainSigMap;
    long[] mDwSubAppidList;
    long mDwSubDstAppid;
    int mEncrypt;
    byte[] mExtraData;
    int mExtraFlag = 1;
    long mExtraUin = -1L;
    WFastLoginInfo mFastLoginInfo;
    Handler mHandler;
    WtloginHelper mHelper;
    boolean mIsSmslogin = false;
    String mMsgCode;
    byte[] mPictureData;
    WtTicketPromise mPromise;
    boolean mPwdMd5;
    int mReportErrType;
    TransReqContext mReqContext;
    int mReqType;
    byte[][] mReserve;
    long mRole;
    byte[][] mST;
    byte[] mST1;
    byte[] mST1Key;
    long mSmsAppid;
    long mSsoVer2;
    long mSubAppid1;
    long mSubAppid2;
    long mUIN;
    String mUserAccount;
    byte[] mUserInput;
    String mUserPasswd;
    WUserSigInfo mUserSigInfo = null;
    byte[] mWxAppid;
    String ptSig;
    WtloginHelper.QuickLoginParam quickLoginParam;
    byte[] weChatCode;
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mEncrypt = paramInt;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mRole = paramLong2;
      this.mReqContext = paramTransReqContext;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mEncrypt = paramInt;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mRole = paramLong2;
      this.mReqContext = paramTransReqContext;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mDwMainSigMap = paramInt;
      setName("Wtlogin_" + paramString);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong1, long paramLong2, String paramString1, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mExtraFlag = paramInt;
      this.mExtraUin = paramLong3;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUIN = paramLong;
      setName("Wtlogin_" + paramString);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong2;
      this.mDwSubAppidList = paramArrayOfLong;
      this.mPwdMd5 = paramBoolean1;
      this.mUserPasswd = paramString2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte;
      this.mIsSmslogin = paramBoolean2;
      setName("Wtlogin_" + paramString3);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mDwMainSigMap = paramInt;
      this.mAppName2 = paramArrayOfByte1;
      this.mSsoVer2 = paramLong4;
      this.mAppid2 = paramLong4;
      this.mSubAppid2 = paramLong5;
      this.mAppVer2 = paramArrayOfByte2;
      this.mAppSign2 = paramArrayOfByte3;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mFastLoginInfo = paramWFastLoginInfo;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mSmsAppid = paramLong;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mExtraData = paramArrayOfByte;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mMsgCode = paramString2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_" + paramString3);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.ptSig = paramString2;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName("Wtlogin_" + paramString3);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserInput = paramArrayOfByte;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte1;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserInput = paramArrayOfByte1;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte;
      this.mExtraData = paramArrayOfByte2;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.weChatCode = paramArrayOfByte2;
      this.mWxAppid = paramArrayOfByte1;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, WtTicketPromise paramWtTicketPromise, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mPromise = paramWtTicketPromise;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwDstAppid = paramLong2;
      this.mDwDstAppPri = paramLong3;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong4;
      this.mDwDstSubAppidList = paramArrayOfLong;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte1;
      this.mReserve = paramArrayOfByte2;
      setName("Wtlogin_" + paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mST1 = paramArrayOfByte1;
      this.mST1Key = paramArrayOfByte2;
      this.mUIN = paramLong1;
      this.mDwAppid = paramLong2;
      this.mReportErrType = paramInt;
      setName("Wtlogin_" + paramString);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mST1 = paramArrayOfByte1;
      this.mST1Key = paramArrayOfByte2;
      this.mUIN = paramLong1;
      this.mDwAppid = paramLong2;
      setName("Wtlogin_" + paramString);
    }
    
    private void quitSelfLooper()
    {
      try
      {
        if (this.isSelfLooper)
        {
          Looper localLooper = Looper.myLooper();
          if (localLooper != null) {
            localLooper.quit();
          }
          this.mHandler = null;
        }
        return;
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
    }
    
    private void saveContextCommonDataIntoExtentMap(async_context paramasync_context)
    {
      if (paramasync_context._t543 != null)
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv543 length " + paramasync_context._t543.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), paramasync_context._t543);
      }
      if (paramasync_context.tlv543In119 != null)
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv543In119 length " + paramasync_context.tlv543In119.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(1676611), paramasync_context.tlv543In119);
      }
    }
    
    private void saveContextDataIntoExtentMap(async_context paramasync_context, int paramInt)
    {
      if ((paramInt == 0) && (paramasync_context.tlv528 != null))
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv528 length " + paramasync_context.tlv528.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(1320), paramasync_context.tlv528);
      }
      if ((paramInt == 0) && (paramasync_context.tlv530 != null))
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv530 length " + paramasync_context.tlv530.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(1328), paramasync_context.tlv530);
      }
      if ((paramInt == 0) && (paramasync_context.tlv113 != null))
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv113 length " + paramasync_context.tlv113.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(275), paramasync_context.tlv113);
      }
    }
    
    private void saveContextSigSessionDataIntoExtentMap(async_context paramasync_context)
    {
      if (paramasync_context._t104 != null)
      {
        util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv104 length " + paramasync_context._t104.get_data_len(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(new Integer(260), paramasync_context._t104);
      }
    }
    
    public void RunReq(int paramInt)
    {
      this.mReqType = paramInt;
      if (this.mReqType == 7)
      {
        start();
        return;
      }
      synchronized (WtloginHelper.__sync_top)
      {
        Timer localTimer = new Timer();
        WtloginHelper.HelperThread.1 local1 = new WtloginHelper.HelperThread.1(this);
        paramInt = WtloginHelper.__top;
        WtloginHelper.__top = paramInt + 1;
        localTimer.schedule(local1, paramInt * 500);
        util.LOGI("push queue " + WtloginHelper.__top, "");
        return;
      }
    }
    
    public void run()
    {
      if ((this.mHelper.mListener == null) && (this.mPromise == null)) {}
      for (;;)
      {
        return;
        int k = this.mHelper.mG.t;
        boolean bool;
        if (this.mHandler == null)
        {
          bool = true;
          label39:
          this.isSelfLooper = bool;
          if (this.isSelfLooper)
          {
            Looper.prepare();
            this.mHandler = WtloginHelper.this.newHelperHandler();
          }
        }
        try
        {
          if (this.mHandler == null) {
            throw new Exception("Handler should not be null!");
          }
        }
        catch (Exception localException)
        {
          util.printException(localException, "");
          this.mHandler.post(new WtloginHelper.HelperThread.19(this, k));
          if (this.isSelfLooper) {
            Looper.loop();
          }
          if (this.mReqType == 7) {
            continue;
          }
          synchronized (WtloginHelper.__sync_top)
          {
            if (WtloginHelper.__top > 0) {
              WtloginHelper.__top -= 1;
            }
            util.LOGI("pop queue " + WtloginHelper.__top, "");
            return;
          }
          bool = false;
          break label39;
          if (this.mReqType == 0)
          {
            i = this.mHelper.GetStWithPasswd(this.mUserAccount, this.mDwAppid, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwSubAppidList, this.mPwdMd5, this.mUserPasswd, this.mUserSigInfo, this.mST, this.mIsSmslogin, 1);
            this.mHandler.post(new WtloginHelper.HelperThread.2(this, k, i));
          }
          for (;;)
          {
            if (this.isSelfLooper) {
              Looper.loop();
            }
            if (this.mReqType == 7) {
              break;
            }
            synchronized (WtloginHelper.__sync_top)
            {
              if (WtloginHelper.__top > 0) {
                WtloginHelper.__top -= 1;
              }
              util.LOGI("pop queue " + WtloginHelper.__top, "");
              return;
            }
            if (this.mReqType != 1) {
              break label472;
            }
            i = this.mHelper.RefreshPictureData(this.mUserAccount, this.mUserSigInfo, 1);
            this.mHandler.post(new WtloginHelper.HelperThread.3(this, k, i));
          }
        }
        finally
        {
          for (;;)
          {
            int i;
            if (this.isSelfLooper) {
              Looper.loop();
            }
            if (this.mReqType != 7) {}
            synchronized (WtloginHelper.__sync_top)
            {
              if (WtloginHelper.__top > 0) {
                WtloginHelper.__top -= 1;
              }
              util.LOGI("pop queue " + WtloginHelper.__top, "");
              throw localObject4;
              label472:
              if (this.mReqType == 2)
              {
                i = this.mHelper.CheckPictureAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.4(this, k, i));
                continue;
              }
              if (this.mReqType == 3)
              {
                i = this.mHelper.RefreshSMSData(this.mUserAccount, this.mSmsAppid, this.mUserSigInfo, this.mExtraData, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.5(this, k, i));
                continue;
              }
              if (this.mReqType == 4)
              {
                i = this.mHelper.CheckSMSAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, this.mExtraData, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.6(this, k, i));
                continue;
              }
              if (this.mReqType == 5) {
                synchronized (WtloginHelper.GET_ST_WITHOUT_PASSWORD_LOCK)
                {
                  int j = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                  if (j == 20)
                  {
                    util.LOGI("retry ret=0x14", "");
                    i = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                    if ((i == 0) && (j == 20)) {
                      oicq.wlogin_sdk.report.event.c.a(new oicq.wlogin_sdk.report.event.b("wtlogin_a1_seq_err", "", ""));
                    }
                    this.mHandler.post(new WtloginHelper.HelperThread.7(this, k, i));
                    continue;
                  }
                  i = j;
                }
              }
              if (this.mReqType == 6)
              {
                i = this.mHelper.GetA1WithA1(this.mUserAccount, this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mAppName2, this.mSsoVer2, this.mAppid2, this.mSubAppid2, this.mAppVer2, this.mAppSign2, this.mUserSigInfo, this.mFastLoginInfo, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.8(this, k, i));
                continue;
              }
              if (this.mReqType == 7)
              {
                this.mHelper.RequestReport(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid);
                continue;
              }
              if (this.mReqType == 9)
              {
                i = this.mHelper.RequestTransport(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext, this.mUserSigInfo);
                this.mHandler.post(new WtloginHelper.HelperThread.9(this, i, k));
                continue;
              }
              if (this.mReqType == 10)
              {
                i = this.mHelper.RequestTransportMsf(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext);
                this.mHandler.post(new WtloginHelper.HelperThread.10(this, k, i));
                continue;
              }
              if (this.mReqType == 12)
              {
                i = this.mHelper.CheckSMSVerifyLoginAccount(this.mAppid1, this.mSubAppid1, this.mUserAccount, this.mExtraFlag, this.mExtraUin, this.mUserSigInfo, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.11(this, k, i));
                continue;
              }
              if (this.mReqType == 13)
              {
                i = this.mHelper.VerifySMSVerifyLoginCode(this.mUserAccount, this.mMsgCode, this.mUserSigInfo, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.12(this, k, i));
                continue;
              }
              if (this.mReqType == 14)
              {
                i = this.mHelper.RefreshSMSVerifyLoginCode(this.mUserAccount, this.mUserSigInfo, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.13(this, k, i));
                continue;
              }
              if (this.mReqType == 8)
              {
                this.mHelper.RequestReportError(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid, this.mReportErrType);
                continue;
              }
              if (this.mReqType == 15)
              {
                i = this.mHelper.getStWithQQSig(this.mUserAccount, this.quickLoginParam, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.14(this, k, i));
                continue;
              }
              if (this.mReqType == 16)
              {
                i = this.mHelper.getStWithPtSig(this.mUserAccount, this.ptSig, this.quickLoginParam, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.15(this, k, i));
                continue;
              }
              if (this.mReqType == 17)
              {
                i = this.mHelper.getStWithQrSig(this.mUserAccount, this.mDwAppid, this.mDwSubDstAppid, this.mDwMainSigMap, this.mUserSigInfo, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.16(this, k, i));
                continue;
              }
              if (this.mReqType == 18)
              {
                i = this.mHelper.quickLoginByWeChat(this.mWxAppid, this.weChatCode, this.quickLoginParam, 1);
                this.mHandler.post(new WtloginHelper.HelperThread.17(this, k, i));
                continue;
              }
              if (this.mReqType != 19) {
                continue;
              }
              i = this.mHelper.quickLoginByGateway(this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.18(this, k, i));
            }
          }
        }
      }
    }
  }
  
  public static class LoginSourceType
  {
    public static final int IM = 10;
    public static final int QQConn = 20;
    public static final int QQWallet = 40;
    public static final int unknown = 0;
    public static final int webView = 30;
    public static final int webViewForceRefresh = 31;
    public static final int webViewOnTimeRefresh = 32;
  }
  
  public static class QuickLoginParam
  {
    public long appid;
    public long dstAppid;
    public long[] dstSubAppidList;
    public int finishAnimEnter = 0;
    public int finishAnimExit = 0;
    public boolean forceWebLogin = false;
    public boolean isUserAccountLocked = false;
    public int sigMap;
    public int startAnimEnter = 0;
    public int startAnimExit = 0;
    public long subAppid = 1L;
    public String titleBackgroundColor = "#3F51B5";
    public String titleTextColor = "#FFFFFF";
    public String userAccount;
    public WUserSigInfo userSigInfo = new WUserSigInfo();
    public String webViewActivityClassName;
  }
  
  public class QuickLoginRequestCode
  {
    public static final int REQUEST_PT_LOGIN = 1202;
    public static final int REQUEST_QQ_LOGIN = 1201;
    
    public QuickLoginRequestCode() {}
  }
  
  public static class RegTLVType
  {
    public static final int ADDRESS_BOOK = 7;
    public static final int APPID = 2;
    public static final int APPNAME = 14;
    public static final int CALL_BACK_URL = 5;
    public static final int EMAIL_URL = 4;
    public static final int GUID = 10;
    public static final int HAS_ADDRESS_BOOK = 8;
    public static final int ID = 1;
    public static final int LANGUAGE = 3;
    public static final int LIMIT_PHONE_REG = 51;
    public static final int MPASSWD = 11;
    public static final int MSALT = 12;
    public static final int NEW_UIN = 31;
    public static final int NICK_NAME = 6;
    public static final int NOPASSWD_REG = 9;
    public static final int PHONE_NUMBER = 30;
    public static final int PHONE_NUMBER_BOUND_UIN = 36;
    public static final int PICTURE_ID = 17;
    public static final int PICTURE_URL = 40;
    public static final int REGISTER_SIG = 16;
    public static final int REG_SIG = 33;
    public static final int SET_DEVLOCK_FLG = 15;
    public static final int SUBAPPID = 13;
  }
  
  public static final class SigType
  {
    public static final int WLOGIN_A2 = 64;
    public static final int WLOGIN_A5 = 2;
    public static final int WLOGIN_AQSIG = 2097152;
    public static final int WLOGIN_D2 = 262144;
    public static final int WLOGIN_DA2 = 33554432;
    public static final int WLOGIN_LHSIG = 4194304;
    public static final int WLOGIN_LSKEY = 512;
    public static final int WLOGIN_OPENKEY = 16384;
    public static final int WLOGIN_PAYTOKEN = 8388608;
    public static final int WLOGIN_PF = 16777216;
    public static final int WLOGIN_PSKEY = 1048576;
    public static final int WLOGIN_PT4Token = 134217728;
    public static final int WLOGIN_QRPUSH = 67108864;
    public static final int WLOGIN_RESERVED = 16;
    public static final int WLOGIN_SID = 524288;
    public static final int WLOGIN_SIG64 = 8192;
    public static final int WLOGIN_SKEY = 4096;
    public static final int WLOGIN_ST = 128;
    public static final int WLOGIN_STWEB = 32;
    public static final int WLOGIN_TOKEN = 32768;
    public static final int WLOGIN_VKEY = 131072;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper
 * JD-Core Version:    0.7.0.1
 */