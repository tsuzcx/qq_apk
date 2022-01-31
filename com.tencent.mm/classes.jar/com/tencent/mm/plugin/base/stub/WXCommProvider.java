package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.h.a.cc;
import com.tencent.mm.h.a.fa;
import com.tencent.mm.h.a.fb;
import com.tencent.mm.h.a.fb.b;
import com.tencent.mm.h.a.fh;
import com.tencent.mm.h.a.fh.b;
import com.tencent.mm.h.a.g;
import com.tencent.mm.h.a.ih;
import com.tencent.mm.h.a.on;
import com.tencent.mm.h.a.oo;
import com.tencent.mm.h.a.op;
import com.tencent.mm.h.a.oq;
import com.tencent.mm.h.a.ty;
import com.tencent.mm.h.a.ty.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ar;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class WXCommProvider
  extends ContentProvider
{
  public static final String PREF_NAME = ae.getPackageName() + "_comm_preferences";
  private static final String[] hSm = { "packageName", "data" };
  private static final UriMatcher hSo = new UriMatcher(-1);
  private static volatile boolean hSp;
  protected static boolean hSq = false;
  private static final Object lock = new Object();
  private SharedPreferences dnD;
  protected MatrixCursor hSn = new MatrixCursor(new String[0]);
  private ah handler;
  
  static
  {
    hSp = false;
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "getWifiList", 37);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "connectWifi", 38);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "genTokenForOpenSdk", 43);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "jumpToOfflinePay", 49);
    hSo.addURI("com.tencent.mm.sdk.comm.provider", "openBusinessWebview", 50);
  }
  
  /* Error */
  private String[] awb()
  {
    // Byte code:
    //   0: invokestatic 185	android/os/Binder:getCallingUid	()I
    //   3: istore_2
    //   4: aload_0
    //   5: invokevirtual 189	com/tencent/mm/plugin/base/stub/WXCommProvider:getContext	()Landroid/content/Context;
    //   8: invokevirtual 195	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   11: invokestatic 185	android/os/Binder:getCallingUid	()I
    //   14: invokevirtual 201	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +47 -> 68
    //   24: iconst_0
    //   25: istore_1
    //   26: ldc 203
    //   28: ldc 205
    //   30: iconst_2
    //   31: anewarray 73	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: iload_2
    //   37: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: iload_1
    //   44: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 217	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload 4
    //   53: ifnonnull +22 -> 75
    //   56: ldc 203
    //   58: ldc 219
    //   60: invokestatic 223	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_0
    //   64: anewarray 58	java/lang/String
    //   67: areturn
    //   68: aload 4
    //   70: arraylength
    //   71: istore_1
    //   72: goto -46 -> 26
    //   75: aload 4
    //   77: arraylength
    //   78: istore_2
    //   79: iconst_0
    //   80: istore_1
    //   81: aload 4
    //   83: astore_3
    //   84: iload_1
    //   85: iload_2
    //   86: if_icmpge +52 -> 138
    //   89: ldc 203
    //   91: ldc 225
    //   93: iconst_1
    //   94: anewarray 73	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload 4
    //   101: iload_1
    //   102: aaload
    //   103: aastore
    //   104: invokestatic 217	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_1
    //   111: goto -30 -> 81
    //   114: astore_3
    //   115: ldc 203
    //   117: ldc 227
    //   119: iconst_1
    //   120: anewarray 73	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: invokevirtual 230	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 233	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: iconst_0
    //   134: anewarray 58	java/lang/String
    //   137: astore_3
    //   138: aload_3
    //   139: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	WXCommProvider
    //   25	86	1	i	int
    //   3	84	2	j	int
    //   83	1	3	arrayOfString1	String[]
    //   114	12	3	localException	Exception
    //   137	2	3	arrayOfString2	String[]
    //   17	83	4	arrayOfString3	String[]
    // Exception table:
    //   from	to	target	type
    //   0	19	114	java/lang/Exception
    //   26	51	114	java/lang/Exception
    //   56	68	114	java/lang/Exception
    //   68	72	114	java/lang/Exception
    //   75	79	114	java/lang/Exception
    //   89	107	114	java/lang/Exception
  }
  
  private boolean awc()
  {
    try
    {
      y.i("MicroMsg.WXCommProvider", "checkIsLogin()");
      if ((!hSq) && (!((Boolean)new WXCommProvider.6(this, Boolean.valueOf(false)).b(this.handler)).booleanValue()))
      {
        y.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
        hSq = false;
        return false;
      }
      if ((au.DK()) && (au.Hz()) && (!au.CW())) {}
      for (hSq = true;; hSq = false)
      {
        y.i("MicroMsg.WXCommProvider", "hasLogin = " + hSq);
        return hSq;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.WXCommProvider", localException.getMessage());
      y.printErrStackTrace("MicroMsg.WXCommProvider", localException, "", new Object[0]);
    }
  }
  
  private boolean awd()
  {
    try
    {
      y.i("MicroMsg.WXCommProvider", "checkIsLogin()");
      if (!hSq)
      {
        com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
        localb.b(4000L, new WXCommProvider.7(this, localb));
      }
      if ((au.DK()) && (au.Hz()) && (!au.CW())) {}
      for (hSq = true;; hSq = false)
      {
        y.i("MicroMsg.WXCommProvider", "hasLogin = " + hSq);
        return hSq;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.WXCommProvider", localException.getMessage());
      y.printErrStackTrace("MicroMsg.WXCommProvider", localException, "", new Object[0]);
    }
  }
  
  public final Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, int paramInt, String[] paramArrayOfString3)
  {
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
      paramArrayOfString1 = new MatrixCursor(hSm);
      paramUri = (Cursor)new WXCommProvider.4(this, paramUri, paramInt, paramArrayOfString3, paramArrayOfString1).b(this.handler);
      if (paramUri == null) {
        paramArrayOfString1.close();
      }
      return paramUri;
    case 18: 
    case 19: 
    case 20: 
      if (!awc()) {
        return null;
      }
      paramArrayOfString1 = new fb();
      paramArrayOfString1.bLt.bLv = paramInt;
      paramArrayOfString1.bLt.uri = paramUri;
      paramArrayOfString1.bLt.selectionArgs = paramArrayOfString2;
      paramArrayOfString1.bLt.context = getContext();
      paramArrayOfString1.bLt.bEY = paramArrayOfString3;
      if (!a.udP.m(paramArrayOfString1))
      {
        y.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
        return null;
      }
      return paramArrayOfString1.bLu.bLw;
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
      long l = System.currentTimeMillis();
      if (!awd())
      {
        String str = com.tencent.mm.sdk.platformtools.bk.pm(paramUri.getQueryParameter("appid"));
        if ("1".equals(com.tencent.mm.sdk.platformtools.bk.aM(paramUri.getQueryParameter("autoLogin"), "0")))
        {
          y.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
          ar.rVA = new ar(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramInt, paramArrayOfString3);
          ar.rVB = System.currentTimeMillis();
          paramUri = new Intent(getContext(), LoginUI.class);
          getContext().startActivity(paramUri);
          paramUri = new MatrixCursor(com.tencent.mm.protocal.b.jJI);
          paramUri.addRow(new Object[] { Integer.valueOf(9) });
          return paramUri;
        }
        y.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(3) });
        h.nFQ.f(10505, new Object[] { com.tencent.mm.sdk.platformtools.bk.pm(paramArrayOfString3[0]), str, Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - l) });
        paramUri = new MatrixCursor(com.tencent.mm.protocal.b.jJI);
        paramUri.addRow(new Object[] { Integer.valueOf(3) });
        return paramUri;
      }
      paramArrayOfString1 = new fh();
      paramArrayOfString1.bMa.bLv = paramInt;
      paramArrayOfString1.bMa.uri = paramUri;
      paramArrayOfString1.bMa.selectionArgs = paramArrayOfString2;
      paramArrayOfString1.bMa.context = getContext();
      paramArrayOfString1.bMa.bEY = paramArrayOfString3;
      if (!a.udP.m(paramArrayOfString1))
      {
        y.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
        paramUri = new MatrixCursor(com.tencent.mm.protocal.b.jJI);
        paramUri.addRow(new Object[] { Integer.valueOf(8) });
        return paramUri;
      }
      y.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return paramArrayOfString1.bMb.bLw;
    case 24: 
      if (!awc()) {
        return this.hSn;
      }
      paramArrayOfString1 = new ty();
      paramArrayOfString1.cek.bLv = paramInt;
      paramArrayOfString1.cek.uri = paramUri;
      paramArrayOfString1.cek.context = getContext();
      paramInt = 0;
      for (;;)
      {
        if (paramInt < paramArrayOfString3.length)
        {
          if (paramArrayOfString3[paramInt] != null) {
            paramArrayOfString1.cek.cem = paramArrayOfString3[paramInt];
          }
        }
        else
        {
          if (a.udP.m(paramArrayOfString1)) {
            break;
          }
          y.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
          return null;
        }
        paramInt += 1;
      }
      return paramArrayOfString1.cel.bLw;
    case 21: 
      paramUri = new fa();
      paramUri.bLr.op = 21;
      paramUri.bLr.source = 1;
      paramUri.bLr.selectionArgs = paramArrayOfString2;
      paramUri.bLr.context = getContext();
      paramUri.bLr.bEY = paramArrayOfString3;
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      return null;
    case 27: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 2))
      {
        y.e("MicroMsg.WXCommProvider", "wrong args");
        return null;
      }
      paramUri = new fa();
      paramUri.bLr.op = 27;
      paramUri.bLr.source = 1;
      paramUri.bLr.selectionArgs = paramArrayOfString2;
      paramUri.bLr.context = getContext();
      paramUri.bLr.bEY = paramArrayOfString3;
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      return null;
    case 28: 
      paramUri = new fa();
      paramUri.bLr.op = paramInt;
      paramUri.bLr.selectionArgs = paramArrayOfString2;
      paramUri.bLr.context = getContext();
      paramUri.bLr.bEY = paramArrayOfString3;
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
      }
      return null;
    case 26: 
      paramUri = new g();
      paramUri.bEX.selectionArgs = paramArrayOfString2;
      paramUri.bEX.bEY = paramArrayOfString3;
      paramUri.bEX.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "add card to wx fail");
      }
      return null;
    case 30: 
    case 45: 
      paramUri = new oq();
      paramUri.bYh.selectionArgs = paramArrayOfString2;
      paramUri.bYh.bEY = paramArrayOfString3;
      paramUri.bYh.context = getContext();
      paramArrayOfString1 = paramUri.bYh;
      if (paramInt == 45) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfString1.bYi = bool;
        if ((paramInt == 30) && (paramArrayOfString2 != null) && (paramArrayOfString2.length > 2)) {
          com.tencent.mm.pluginsdk.d.rSx = paramArrayOfString2[2];
        }
        if (!a.udP.m(paramUri)) {
          y.e("MicroMsg.WXCommProvider", "open webview fail");
        }
        return null;
      }
    case 50: 
      e.a(getContext(), paramArrayOfString2, paramArrayOfString3);
      return null;
    case 47: 
      paramUri = new on();
      paramUri.bYe.selectionArgs = paramArrayOfString2;
      paramUri.bYe.bEY = paramArrayOfString3;
      paramUri.bYe.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
      }
      return null;
    case 49: 
      paramUri = new op();
      paramUri.bYg.selectionArgs = paramArrayOfString2;
      paramUri.bYg.bEY = paramArrayOfString3;
      paramUri.bYg.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "open offline pay fail");
      }
      return null;
    case 31: 
      paramUri = new oo();
      paramUri.bYf.selectionArgs = paramArrayOfString2;
      paramUri.bYf.bEY = paramArrayOfString3;
      paramUri.bYf.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
      }
      return null;
    case 32: 
      paramUri = new cc();
      paramUri.bIh.action = 1;
      paramUri.bIh.selectionArgs = paramArrayOfString2;
      paramUri.bIh.bEY = paramArrayOfString3;
      paramUri.bIh.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "open webview fail");
      }
      return null;
    case 33: 
      paramUri = new cc();
      paramUri.bIh.action = 2;
      paramUri.bIh.selectionArgs = paramArrayOfString2;
      paramUri.bIh.bEY = paramArrayOfString3;
      paramUri.bIh.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "open webview fail");
      }
      return null;
    case 39: 
      paramUri = new com.tencent.mm.h.a.bk();
      paramUri.bHL.selectionArgs = paramArrayOfString2;
      paramUri.bHL.bEY = paramArrayOfString3;
      paramUri.bHL.context = getContext();
      if (!a.udP.m(paramUri)) {
        y.e("MicroMsg.WXCommProvider", "choose card from wx fail");
      }
      return null;
    case 44: 
      paramUri = new ih();
      paramUri.bQx.selectionArgs = paramArrayOfString2;
      paramUri.bQx.bEY = paramArrayOfString3;
      paramUri.bQx.context = getContext();
      if (!a.udP.m(paramUri))
      {
        y.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
        ai.l(new WXCommProvider.3(this, paramUri), 200L);
      }
      return null;
    }
    if (paramArrayOfString3.length > 0)
    {
      paramUri = "OpenSdkToken@" + com.tencent.mm.sdk.platformtools.bk.UY();
      u.Hc().v(paramUri, true).h("open_sdk_token_package_name", paramArrayOfString3[0]);
      y.i("MicroMsg.WXCommProvider", "gen token for opensdk ,package = %s", new Object[] { paramArrayOfString3[0] });
      paramArrayOfString1 = new MatrixCursor(new String[] { "token" });
      paramArrayOfString1.addRow(new String[] { paramUri });
      return paramArrayOfString1;
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (paramUri == null)
    {
      y.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
      return 0;
    }
    return ((Integer)new WXCommProvider.5(this, Integer.valueOf(0), paramUri, hSo.match(paramUri), awb()).b(this.handler)).intValue();
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
    boolean bool = false;
    y.d("MicroMsg.WXCommProvider", "onCreate");
    this.handler = new ah();
    y.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
    this.dnD = getContext().getSharedPreferences(PREF_NAME, 0);
    getContext().registerReceiver(new WXCommProvider.1(this), new IntentFilter("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    if (this.dnD != null) {
      bool = true;
    }
    return bool;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.WXCommProvider", "uri:%s", new Object[] { paramUri });
    if (paramUri == null)
    {
      y.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
      return null;
    }
    String[] arrayOfString = awb();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      y.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
      return null;
    }
    int i = hSo.match(paramUri);
    if ((WorkerProfile.ts() == null) || (!WorkerProfile.ts().bxB))
    {
      new am(Looper.getMainLooper(), new WXCommProvider.2(this), true).S(50L, 50L);
      try
      {
        synchronized (lock)
        {
          y.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
          if (hSp) {
            break label206;
          }
          lock.wait();
        }
        return a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, i, arrayOfString);
      }
      catch (InterruptedException localInterruptedException)
      {
        y.e("MicroMsg.WXCommProvider", "the lock may have some problem," + localInterruptedException.getMessage());
        y.printErrStackTrace("MicroMsg.WXCommProvider", localInterruptedException, "", new Object[0]);
      }
    }
    for (;;)
    {
      label206:
      hSp = false;
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