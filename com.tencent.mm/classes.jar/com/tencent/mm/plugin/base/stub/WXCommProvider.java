package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fe.b;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fk.b;
import com.tencent.mm.g.a.g;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.vu.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class WXCommProvider
  extends ContentProvider
{
  public static final String jLU;
  private static final String[] jLV;
  private static final UriMatcher jLX;
  private static volatile boolean jLY;
  protected static boolean jLZ;
  private static final Object lock;
  private ak handler;
  protected MatrixCursor jLW;
  private SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(18180);
    jLU = ah.getPackageName() + "_comm_preferences";
    jLV = new String[] { "packageName", "data" };
    jLX = new UriMatcher(-1);
    lock = new Object();
    jLY = false;
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "getWifiList", 37);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "connectWifi", 38);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openBusinessView", 53);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "genTokenForOpenSdk", 43);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "jumpToOfflinePay", 49);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openBusinessWebview", 50);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "getWxaInfo", 51);
    jLX.addURI("com.tencent.mm.sdk.comm.provider", "openWxaDesktopOrWxaMyFavorite", 52);
    jLZ = false;
    AppMethodBeat.o(18180);
  }
  
  public WXCommProvider()
  {
    AppMethodBeat.i(18172);
    this.jLW = new MatrixCursor(new String[0]);
    AppMethodBeat.o(18172);
  }
  
  private String[] aVF()
  {
    AppMethodBeat.i(18177);
    try
    {
      int j = Binder.getCallingUid();
      String[] arrayOfString = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
      if (arrayOfString == null) {}
      for (int i = 0;; i = arrayOfString.length)
      {
        ab.i("MicroMsg.WXCommProvider", "getCallingPackages, callingUid = %d, packages size = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if (arrayOfString != null) {
          break;
        }
        ab.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
        AppMethodBeat.o(18177);
        return new String[0];
      }
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ab.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", new Object[] { arrayOfString[i] });
        i += 1;
      }
      AppMethodBeat.o(18177);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(18177);
    }
    return new String[0];
  }
  
  private boolean aVG()
  {
    AppMethodBeat.i(18178);
    try
    {
      ab.i("MicroMsg.WXCommProvider", "checkIsLogin()");
      if ((!jLZ) && (!((Boolean)new WXCommProvider.6(this, Boolean.FALSE).b(this.handler)).booleanValue()))
      {
        ab.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
        jLZ = false;
        AppMethodBeat.o(18178);
        return false;
      }
      if ((aw.RG()) && (aw.aaB()) && (!aw.QP())) {}
      for (jLZ = true;; jLZ = false)
      {
        ab.i("MicroMsg.WXCommProvider", "hasLogin = " + jLZ);
        boolean bool = jLZ;
        AppMethodBeat.o(18178);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.WXCommProvider", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.WXCommProvider", localException, "", new Object[0]);
      AppMethodBeat.o(18178);
    }
  }
  
  private boolean aVH()
  {
    AppMethodBeat.i(18179);
    try
    {
      ab.i("MicroMsg.WXCommProvider", "checkIsLogin()");
      if (!jLZ)
      {
        com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
        localb.b(4000L, new WXCommProvider.7(this, localb));
      }
      if ((aw.RG()) && (aw.aaB()) && (!aw.QP())) {}
      for (jLZ = true;; jLZ = false)
      {
        ab.i("MicroMsg.WXCommProvider", "hasLogin = " + jLZ);
        boolean bool = jLZ;
        AppMethodBeat.o(18179);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.WXCommProvider", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.WXCommProvider", localException, "", new Object[0]);
      AppMethodBeat.o(18179);
    }
  }
  
  public final Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, int paramInt, String[] paramArrayOfString3)
  {
    AppMethodBeat.i(18175);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    default: 
      paramArrayOfString1 = new MatrixCursor(jLV);
      paramUri = (Cursor)new WXCommProvider.4(this, paramUri, paramInt, paramArrayOfString3, paramArrayOfString1).b(this.handler);
      if (paramUri == null) {
        paramArrayOfString1.close();
      }
      AppMethodBeat.o(18175);
      return paramUri;
    case 18: 
    case 19: 
    case 20: 
      if (!aVG())
      {
        AppMethodBeat.o(18175);
        return null;
      }
      paramArrayOfString1 = new fe();
      paramArrayOfString1.csN.csP = paramInt;
      paramArrayOfString1.csN.uri = paramUri;
      paramArrayOfString1.csN.selectionArgs = paramArrayOfString2;
      paramArrayOfString1.csN.context = getContext();
      paramArrayOfString1.csN.cmj = paramArrayOfString3;
      if (!a.ymk.l(paramArrayOfString1))
      {
        ab.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
        AppMethodBeat.o(18175);
        return null;
      }
      paramUri = paramArrayOfString1.csO.csQ;
      AppMethodBeat.o(18175);
      return paramUri;
    case 3: 
    case 9: 
    case 13: 
    case 22: 
    case 23: 
    case 25: 
    case 29: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 40: 
    case 41: 
    case 42: 
    case 46: 
    case 48: 
    case 51: 
    case 52: 
      long l = System.currentTimeMillis();
      if (!aVH())
      {
        String str = bo.nullAsNil(paramUri.getQueryParameter("appid"));
        if ("1".equals(bo.bf(paramUri.getQueryParameter("autoLogin"), "0")))
        {
          ab.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
          an.vMo = new an(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramInt, paramArrayOfString3);
          an.vMp = System.currentTimeMillis();
          paramUri = new Intent(getContext(), LoginUI.class);
          paramUri.addFlags(268435456);
          getContext().startActivity(paramUri);
          paramUri = new MatrixCursor(com.tencent.mm.protocal.b.mdM);
          paramUri.addRow(new Object[] { Integer.valueOf(9) });
          AppMethodBeat.o(18175);
          return paramUri;
        }
        ab.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(3) });
        h.qsU.e(10505, new Object[] { bo.nullAsNil(paramArrayOfString3[0]), str, Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
        paramUri = new MatrixCursor(com.tencent.mm.protocal.b.mdM);
        paramUri.addRow(new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(18175);
        return paramUri;
      }
      paramArrayOfString1 = new fk();
      paramArrayOfString1.ctu.csP = paramInt;
      paramArrayOfString1.ctu.uri = paramUri;
      paramArrayOfString1.ctu.selectionArgs = paramArrayOfString2;
      paramArrayOfString1.ctu.context = getContext();
      paramArrayOfString1.ctu.cmj = paramArrayOfString3;
      if (!a.ymk.l(paramArrayOfString1))
      {
        ab.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
        paramUri = new MatrixCursor(com.tencent.mm.protocal.b.mdM);
        paramUri.addRow(new Object[] { Integer.valueOf(8) });
        AppMethodBeat.o(18175);
        return paramUri;
      }
      ab.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramUri = paramArrayOfString1.ctv.csQ;
      AppMethodBeat.o(18175);
      return paramUri;
    case 24: 
      if (!aVG())
      {
        paramUri = this.jLW;
        AppMethodBeat.o(18175);
        return paramUri;
      }
      paramArrayOfString1 = new vu();
      paramArrayOfString1.cMY.csP = paramInt;
      paramArrayOfString1.cMY.uri = paramUri;
      paramArrayOfString1.cMY.context = getContext();
      paramInt = 0;
      for (;;)
      {
        if (paramInt < paramArrayOfString3.length)
        {
          if (paramArrayOfString3[paramInt] != null) {
            paramArrayOfString1.cMY.callingPackage = paramArrayOfString3[paramInt];
          }
        }
        else
        {
          if (a.ymk.l(paramArrayOfString1)) {
            break;
          }
          ab.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
          AppMethodBeat.o(18175);
          return null;
        }
        paramInt += 1;
      }
      paramUri = paramArrayOfString1.cMZ.csQ;
      AppMethodBeat.o(18175);
      return paramUri;
    case 21: 
      paramUri = new fd();
      paramUri.csL.op = 21;
      paramUri.csL.cpt = 1;
      paramUri.csL.selectionArgs = paramArrayOfString2;
      paramUri.csL.context = getContext();
      paramUri.csL.cmj = paramArrayOfString3;
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 27: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 2))
      {
        ab.e("MicroMsg.WXCommProvider", "wrong args");
        AppMethodBeat.o(18175);
        return null;
      }
      paramUri = new fd();
      paramUri.csL.op = 27;
      paramUri.csL.cpt = 1;
      paramUri.csL.selectionArgs = paramArrayOfString2;
      paramUri.csL.context = getContext();
      paramUri.csL.cmj = paramArrayOfString3;
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 28: 
      paramUri = new fd();
      paramUri.csL.op = paramInt;
      paramUri.csL.selectionArgs = paramArrayOfString2;
      paramUri.csL.context = getContext();
      paramUri.csL.cmj = paramArrayOfString3;
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 26: 
      paramUri = new g();
      paramUri.cmi.selectionArgs = paramArrayOfString2;
      paramUri.cmi.cmj = paramArrayOfString3;
      paramUri.cmi.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "add card to wx fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 30: 
    case 45: 
      paramUri = new ps();
      paramUri.cGi.selectionArgs = paramArrayOfString2;
      paramUri.cGi.cmj = paramArrayOfString3;
      paramUri.cGi.context = getContext();
      paramArrayOfString1 = paramUri.cGi;
      if (paramInt == 45) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfString1.cGj = bool;
        if ((paramInt == 30) && (paramArrayOfString2 != null) && (paramArrayOfString2.length > 2)) {
          com.tencent.mm.pluginsdk.e.vJt = paramArrayOfString2[2];
        }
        if (!a.ymk.l(paramUri)) {
          ab.e("MicroMsg.WXCommProvider", "open webview fail");
        }
        AppMethodBeat.o(18175);
        return null;
      }
    case 50: 
      e.a(getContext(), paramArrayOfString2, paramArrayOfString3);
      AppMethodBeat.o(18175);
      return null;
    case 47: 
      paramUri = new pp();
      paramUri.cGf.selectionArgs = paramArrayOfString2;
      paramUri.cGf.cmj = paramArrayOfString3;
      paramUri.cGf.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 53: 
      e.b(getContext(), paramArrayOfString2, paramArrayOfString3);
      AppMethodBeat.o(18175);
      return null;
    case 49: 
      paramUri = new pr();
      paramUri.cGh.selectionArgs = paramArrayOfString2;
      paramUri.cGh.cmj = paramArrayOfString3;
      paramUri.cGh.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "open offline pay fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 31: 
      paramUri = new pq();
      paramUri.cGg.selectionArgs = paramArrayOfString2;
      paramUri.cGg.cmj = paramArrayOfString3;
      paramUri.cGg.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 32: 
      paramUri = new cf();
      paramUri.cpC.action = 1;
      paramUri.cpC.selectionArgs = paramArrayOfString2;
      paramUri.cpC.cmj = paramArrayOfString3;
      paramUri.cpC.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "open webview fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 33: 
      paramUri = new cf();
      paramUri.cpC.action = 2;
      paramUri.cpC.selectionArgs = paramArrayOfString2;
      paramUri.cpC.cmj = paramArrayOfString3;
      paramUri.cpC.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "open webview fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 39: 
      paramUri = new bm();
      paramUri.cpa.selectionArgs = paramArrayOfString2;
      paramUri.cpa.cmj = paramArrayOfString3;
      paramUri.cpa.context = getContext();
      if (!a.ymk.l(paramUri)) {
        ab.e("MicroMsg.WXCommProvider", "choose card from wx fail");
      }
      AppMethodBeat.o(18175);
      return null;
    case 44: 
      paramUri = new im();
      paramUri.cxT.selectionArgs = paramArrayOfString2;
      paramUri.cxT.cmj = paramArrayOfString3;
      paramUri.cxT.context = getContext();
      if (!a.ymk.l(paramUri))
      {
        ab.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
        al.p(new WXCommProvider.3(this, paramUri), 200L);
      }
      AppMethodBeat.o(18175);
      return null;
    }
    if (paramArrayOfString3.length > 0)
    {
      paramUri = "OpenSdkToken@" + bo.aoy();
      v.aae().z(paramUri, true).i("open_sdk_token_package_name", paramArrayOfString3[0]);
      ab.i("MicroMsg.WXCommProvider", "gen token for opensdk ,package = %s", new Object[] { paramArrayOfString3[0] });
      paramArrayOfString1 = new MatrixCursor(new String[] { "token" });
      paramArrayOfString1.addRow(new String[] { paramUri });
      AppMethodBeat.o(18175);
      return paramArrayOfString1;
    }
    AppMethodBeat.o(18175);
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(18176);
    if (paramUri == null)
    {
      ab.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
      AppMethodBeat.o(18176);
      return 0;
    }
    int i = ((Integer)new WXCommProvider.5(this, Integer.valueOf(0), paramUri, jLX.match(paramUri), aVF()).b(this.handler)).intValue();
    AppMethodBeat.o(18176);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(18173);
    ab.d("MicroMsg.WXCommProvider", "onCreate");
    this.handler = new ak();
    ab.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
    this.sp = getContext().getSharedPreferences(jLU, 0);
    getContext().registerReceiver(new WXCommProvider.1(this), new IntentFilter("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    if (this.sp != null)
    {
      AppMethodBeat.o(18173);
      return true;
    }
    AppMethodBeat.o(18173);
    return false;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(18174);
    ab.i("MicroMsg.WXCommProvider", "uri:%s", new Object[] { paramUri });
    if (paramUri == null)
    {
      ab.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
      AppMethodBeat.o(18174);
      return null;
    }
    String[] arrayOfString = aVF();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      ab.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
      AppMethodBeat.o(18174);
      return null;
    }
    int i = jLX.match(paramUri);
    if ((WorkerProfile.BW() == null) || (!WorkerProfile.BW().bZD))
    {
      new ap(Looper.getMainLooper(), new WXCommProvider.2(this), true).ag(50L, 50L);
      try
      {
        synchronized (lock)
        {
          ab.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
          if (jLY) {
            break label238;
          }
          lock.wait();
        }
        paramUri = a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, i, arrayOfString);
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.e("MicroMsg.WXCommProvider", "the lock may have some problem," + localInterruptedException.getMessage());
        ab.printErrStackTrace("MicroMsg.WXCommProvider", localInterruptedException, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(18174);
      return paramUri;
      label238:
      jLY = false;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider
 * JD-Core Version:    0.7.0.1
 */