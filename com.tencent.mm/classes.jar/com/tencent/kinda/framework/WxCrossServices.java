package com.tencent.kinda.framework;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.sns_cross.ISnsSceneService;
import com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback;
import com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.a;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.ade.a;
import com.tencent.mm.autogen.a.my;
import com.tencent.mm.autogen.a.my.a;
import com.tencent.mm.autogen.a.n;
import com.tencent.mm.autogen.a.n.a;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.network.p.a;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.offline.a.u.a;
import com.tencent.mm.plugin.offline.a.u.c;
import com.tencent.mm.plugin.offline.a.u.d;
import com.tencent.mm.plugin.offline.a.u.f;
import com.tencent.mm.plugin.offline.a.u.i;
import com.tencent.mm.plugin.offline.a.u.j;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletIapUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.NetStatusUtil.CellInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.t;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WxCrossServices
  implements u.a, com.tencent.mm.pluginsdk.wallet.a
{
  public static final int REPORT_IDKEY = 1004;
  public static final String TAG = "MicroMsg.WxCrossServices";
  private static final String TAG_SCAN_QR_CODE_PAY = "tag_scan_qrcode_pay";
  public static WxCrossServices.MaybeCrashReport report;
  private IListener<n> appListener;
  my jsApiOfflineUserBindQueryEvent;
  private IListener<my> jsApiOfflineUserBindQueryListener;
  private w mDialogForScanPay;
  private boolean mInitFlag;
  private com.tencent.mm.network.p netListener;
  private IListener<ada> walletLockListener;
  
  static
  {
    AppMethodBeat.i(18298);
    report = new WxCrossServices.MaybeCrashReport();
    tryLoadLibrary();
    KindaContext.initStack();
    AppMethodBeat.o(18298);
  }
  
  public WxCrossServices()
  {
    AppMethodBeat.i(18276);
    this.mInitFlag = false;
    this.appListener = new IListener(f.hfK)
    {
      public boolean callback(final n paramAnonymousn)
      {
        AppMethodBeat.i(178755);
        if ((paramAnonymousn != null) && (paramAnonymousn.hzf != null)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(226342);
              if (paramAnonymousn.hzf.isActive)
              {
                KindaApp.appKinda().applicationEnterForeground();
                AppMethodBeat.o(226342);
                return;
              }
              KindaApp.appKinda().applicationEnterBackground();
              WxCrossServices.report.reset();
              AppMethodBeat.o(226342);
            }
          });
        }
        AppMethodBeat.o(178755);
        return false;
      }
    };
    this.netListener = new p.a()
    {
      public void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(178757);
        com.tencent.mm.wallet_core.b.jNX();
        if ((!com.tencent.mm.wallet_core.b.b(c.a.yRc, true)) || (!WxCrossServices.this.mInitFlag) || (!KindaApp.appKinda().isInAnyUseCase()))
        {
          AppMethodBeat.o(178757);
          return;
        }
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        Object localObject1 = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected((Context)localObject1)) {
          localITransmitKvData.putString("type", "NON_NETWORK");
        }
        String str;
        Object localObject2;
        for (;;)
        {
          KindaApp.appKinda().networkChange(localITransmitKvData);
          AppMethodBeat.o(178757);
          return;
          if (!NetStatusUtil.isWifi((Context)localObject1)) {
            break;
          }
          localITransmitKvData.putString("type", "WIFI");
          localObject1 = ConnectivityCompat.Companion.getWiFiSsid();
          str = ConnectivityCompat.Companion.getWiFiBssid();
          if ((localObject1 != null) && (str != null))
          {
            localObject2 = new HashMap();
            ((Map)localObject2).put("ssid", localObject1);
            ((Map)localObject2).put("bssid", str);
            localObject1 = com.tencent.mm.plugin.wallet_core.model.k.bk((Map)localObject2);
            localITransmitKvData.putString("info", ((bi)localObject1).YCL);
            localITransmitKvData.putString("info_key", ((bi)localObject1).YCM);
          }
        }
        if (NetStatusUtil.is4G((Context)localObject1)) {
          localITransmitKvData.putString("type", "4G");
        }
        for (;;)
        {
          localObject1 = NetStatusUtil.getCellInfoList((Context)localObject1);
          if (((List)localObject1).size() <= 0) {
            break;
          }
          localObject2 = (NetStatusUtil.CellInfo)((List)localObject1).get(0);
          localObject1 = ((NetStatusUtil.CellInfo)localObject2).cellid;
          str = ((NetStatusUtil.CellInfo)localObject2).mcc;
          localObject2 = ((NetStatusUtil.CellInfo)localObject2).mnc;
          if ((localObject1 == null) || (str == null) || (localObject2 == null)) {
            break;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("cellid", localObject1);
          localHashMap.put("mcc", str);
          localHashMap.put("mnc", localObject2);
          localObject1 = com.tencent.mm.plugin.wallet_core.model.k.bk(localHashMap);
          localITransmitKvData.putString("info", ((bi)localObject1).YCL);
          localITransmitKvData.putString("info_key", ((bi)localObject1).YCM);
          break;
          if (NetStatusUtil.is3G((Context)localObject1)) {
            localITransmitKvData.putString("type", "3G");
          } else if (NetStatusUtil.is2G((Context)localObject1)) {
            localITransmitKvData.putString("type", "2G");
          } else {
            localITransmitKvData.putString("type", "UNKNOW");
          }
        }
      }
    };
    this.walletLockListener = new IListener(f.hfK)
    {
      public boolean callback(ada paramAnonymousada)
      {
        AppMethodBeat.i(226292);
        switch (paramAnonymousada.igZ.ihb)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(226292);
          return false;
          paramAnonymousada = ITransmitKvData.create();
          paramAnonymousada.putBool("check_wallet_lock_cancel", true);
          KindaApp.appKinda().notifyAllUseCases(paramAnonymousada);
        }
      }
    };
    this.jsApiOfflineUserBindQueryEvent = null;
    this.jsApiOfflineUserBindQueryListener = new IListener(f.hfK)
    {
      public boolean callback(my paramAnonymousmy)
      {
        AppMethodBeat.i(226295);
        if (!WxCrossServices.this.isUseCaseAlive("offline"))
        {
          AppMethodBeat.o(226295);
          return false;
        }
        WxCrossServices.this.jsApiOfflineUserBindQueryEvent = paramAnonymousmy;
        Log.i("MicroMsg.WxCrossServices", "on JsApiOfflineUserBindQueryResultCallBackEvent callback，appid: %s, package: %s", new Object[] { paramAnonymousmy.hPa.appId, paramAnonymousmy.hPa.hPd });
        paramAnonymousmy = new com.tencent.mm.plugin.wallet_core.c.d(paramAnonymousmy.hPa.appId, paramAnonymousmy.hPa.timeStamp, paramAnonymousmy.hPa.nonceStr, paramAnonymousmy.hPa.hPd, paramAnonymousmy.hPa.signType, paramAnonymousmy.hPa.hPe, 23, paramAnonymousmy.hPa.appName, paramAnonymousmy.hPa.hPc, "requestOfflineUserBindQuery", 1137);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(580, new com.tencent.mm.am.h()
        {
          public void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.am.p paramAnonymous2p)
          {
            AppMethodBeat.i(226303);
            if ((paramAnonymous2p instanceof com.tencent.mm.plugin.wallet_core.c.d))
            {
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                break label119;
              }
              Log.i("MicroMsg.WxCrossServices", "onScene end NetSceneCheckPayJsapi ok");
              if (WxCrossServices.this.jsApiOfflineUserBindQueryEvent != null)
              {
                paramAnonymous2String = ITransmitKvData.create();
                paramAnonymous2String.putString("package", WxCrossServices.this.jsApiOfflineUserBindQueryEvent.hPa.hPd);
                paramAnonymous2String.putString("func_name", "offline_request_bindquery");
                paramAnonymous2String.putJSEvent("JSEvent", new KJSEvent()
                {
                  public void kindaCloseWebViewImpl(boolean paramAnonymous3Boolean, VoidCallback paramAnonymous3VoidCallback) {}
                  
                  public void kindaEndWithResult(String paramAnonymous3String, HashMap<String, String> paramAnonymous3HashMap)
                  {
                    AppMethodBeat.i(226300);
                    if (WxCrossServices.this.jsApiOfflineUserBindQueryEvent != null)
                    {
                      WxCrossServices.this.jsApiOfflineUserBindQueryEvent.hPb.errMsg = paramAnonymous3String;
                      WxCrossServices.this.jsApiOfflineUserBindQueryEvent.hPa.callback.run();
                      WxCrossServices.this.jsApiOfflineUserBindQueryEvent = null;
                    }
                    AppMethodBeat.o(226300);
                  }
                  
                  public KindaJSEventType kindaGetType()
                  {
                    return KindaJSEventType.TINYAPP;
                  }
                });
                KindaApp.appKinda().notifyAllUseCases(paramAnonymous2String);
              }
            }
            for (;;)
            {
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.b(580, this);
              AppMethodBeat.o(226303);
              return;
              label119:
              Log.i("MicroMsg.WxCrossServices", "onScene end NetSceneCheckPayJsapi fail");
              if (WxCrossServices.this.jsApiOfflineUserBindQueryEvent != null)
              {
                WxCrossServices.this.jsApiOfflineUserBindQueryEvent.hPb.errMsg = "fail:NetSceneCheckPayJsapi";
                WxCrossServices.this.jsApiOfflineUserBindQueryEvent.hPa.callback.run();
                WxCrossServices.this.jsApiOfflineUserBindQueryEvent = null;
              }
            }
          }
        });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousmy, 0);
        AppMethodBeat.o(226295);
        return false;
      }
    };
    AppMethodBeat.o(18276);
  }
  
  private void initIfNeed()
  {
    AppMethodBeat.i(18278);
    tryLoadLibrary();
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if (locala != null)
    {
      Log.i("MicroMsg.WxCrossServices", "IFingerPrintMgr is not null");
      locala.ftx();
    }
    if (!this.mInitFlag)
    {
      this.appListener.alive();
      com.tencent.mm.kernel.h.baD().a(this.netListener);
      KindaApp.instance().onCreate();
      this.mInitFlag = true;
    }
    ActivityController.resetFlag();
    AppMethodBeat.o(18278);
  }
  
  public static boolean isKindaEnabled()
  {
    AppMethodBeat.i(226315);
    boolean bool = com.tencent.mm.plugin.expansions.e.aQh();
    AppMethodBeat.o(226315);
    return bool;
  }
  
  public static void judgeReprot()
  {
    AppMethodBeat.i(226331);
    report.judgeReport();
    AppMethodBeat.o(226331);
  }
  
  private void preparePayDesk()
  {
    AppMethodBeat.i(18279);
    com.tencent.mm.plugin.wallet_core.model.k.asj(5);
    AppMethodBeat.o(18279);
  }
  
  public static void tryLoadLibrary()
  {
    AppMethodBeat.i(18277);
    if (isKindaEnabled()) {
      com.tencent.mm.plugin.expansions.e.tryLoadLibrary("kinda_android");
    }
    AppMethodBeat.o(18277);
  }
  
  public boolean TenPaySDKABTestKindaEnable()
  {
    AppMethodBeat.i(18293);
    com.tencent.mm.wallet_core.b.jNX();
    boolean bool = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
    AppMethodBeat.o(18293);
    return bool;
  }
  
  public boolean canOpenKindaCashier(Context paramContext)
  {
    AppMethodBeat.i(18290);
    initIfNeed();
    com.tencent.mm.wallet_core.b.jNX();
    if (!com.tencent.mm.wallet_core.b.b(c.a.yRc, true))
    {
      AppMethodBeat.o(18290);
      return true;
    }
    if (KindaApp.appKinda().getIsPaying())
    {
      Log.i("canOpenKindaCashier", "is paying");
      AppMethodBeat.o(18290);
      return false;
    }
    Log.i("canOpenKindaCashier", "not paying");
    KindaApp.appKinda().stopUseCase("rootUseCase");
    AppMethodBeat.o(18290);
    return true;
  }
  
  public long getColorByMode(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18280);
    DynamicColor localDynamicColor = new DynamicColor();
    localDynamicColor.mNormalColor = paramLong1;
    localDynamicColor.mDarkmodeColor = paramLong2;
    paramLong1 = ColorUtil.getColorByMode(localDynamicColor, false);
    AppMethodBeat.o(18280);
    return paramLong1;
  }
  
  public Activity getCrossActivity()
  {
    AppMethodBeat.i(18281);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    AppMethodBeat.o(18281);
    return localActivity;
  }
  
  public boolean isOfflineReady()
  {
    AppMethodBeat.i(226418);
    boolean bool = KindaApp.appKinda().checkOfflineReady();
    AppMethodBeat.o(226418);
    return bool;
  }
  
  public boolean isSwitch2InWxAppPay(String paramString)
  {
    AppMethodBeat.i(226400);
    if (paramString == null)
    {
      Log.i("MicroMsg.WxCrossServices", "isSwitch2InWxAppPay prepayId is null");
      AppMethodBeat.o(226400);
      return false;
    }
    if (paramString.startsWith("ts_"))
    {
      AppMethodBeat.o(226400);
      return false;
    }
    AppMethodBeat.o(226400);
    return true;
  }
  
  public boolean isUseCaseAlive(String paramString)
  {
    AppMethodBeat.i(226414);
    com.tencent.mm.wallet_core.b.jNX();
    if (!com.tencent.mm.wallet_core.b.b(c.a.yRc, true))
    {
      AppMethodBeat.o(226414);
      return false;
    }
    boolean bool = KindaApp.appKinda().isUseCaseAlive(paramString);
    AppMethodBeat.o(226414);
    return bool;
  }
  
  public void notifyUploadCardSuccess()
  {
    AppMethodBeat.i(18297);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("upload_id_success_notifycation", "1");
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
    AppMethodBeat.o(18297);
  }
  
  public boolean onNotify(u.d paramd)
  {
    AppMethodBeat.i(226364);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("PayMsgType", paramd.MzB);
    localITransmitKvData.putString("ack_key", paramd.MzC);
    localITransmitKvData.putString("req_key", paramd.hAT);
    localITransmitKvData.putString("func_name", "offline_push_xml");
    int i;
    if (paramd.MzB == 20)
    {
      paramd = (u.j)paramd;
      if (paramd.ihd.MzO)
      {
        i = 1;
        localITransmitKvData.putInt("guide_block", i);
        localITransmitKvData.putInt("guide_flag", Integer.parseInt(paramd.ihd.igC));
        localITransmitKvData.putString("guide_wording", paramd.ihd.igD);
        localITransmitKvData.putString("left_button_wording", paramd.ihd.igE);
        localITransmitKvData.putString("right_button_wording", paramd.ihd.igF);
        localITransmitKvData.putString("upload_credit_url", paramd.ihd.igG);
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(226364);
      return false;
      i = 0;
      break;
      if (paramd.MzB == 5)
      {
        paramd = (u.f)paramd;
        localITransmitKvData.putInt("pay_cmd", paramd.MzI);
        localITransmitKvData.putInt("cftretcode", Integer.parseInt(paramd.MzD));
        localITransmitKvData.putInt("wxretcode", Integer.parseInt(paramd.MzF));
        localITransmitKvData.putString("cftretmsg", paramd.MzE);
        localITransmitKvData.putString("wxretmsg", paramd.MzG);
        localITransmitKvData.putString("error_detail_url", paramd.MzH);
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 6)
      {
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 8)
      {
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 4)
      {
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 23)
      {
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 24)
      {
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
      else if (paramd.MzB == 42)
      {
        localITransmitKvData.putString("PayMsgInfo", ((u.c)paramd).MzA);
        KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      }
    }
  }
  
  public void startBindCardUseCase(Context paramContext, final Bundle paramBundle)
  {
    AppMethodBeat.i(18294);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 16L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startBindCardUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    if (paramBundle.getInt("key_bind_scene", -1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int j = paramBundle.getInt("reg_flag", -1);
      int i = j;
      if (j == -1) {
        i = com.tencent.mm.plugin.wallet_core.model.u.iix().ijK().field_is_reg;
      }
      if (paramBundle.getInt("key_bind_scene") == 8) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijq()) {}
        for (j = 2;; j = 1)
        {
          paramContext = com.tencent.mm.plugin.wallet_core.model.u.iiC().getTrueName();
          ITransmitKvData localITransmitKvData = ITransmitKvData.create();
          localITransmitKvData.putBool("bPresent", bool1);
          localITransmitKvData.putInt("regFlag", i);
          localITransmitKvData.putInt("cardUserFlag", j);
          localITransmitKvData.putString("trueName", paramContext);
          localITransmitKvData.putInt("addPayCardScene", paramBundle.getInt("key_bind_scene", -1));
          localITransmitKvData.putInt("bindScene", paramBundle.getInt("key_bind_scene", -1));
          localITransmitKvData.putInt("realnameScene", paramBundle.getInt("entry_scene", -1));
          localITransmitKvData.putBool("isWebankLoadScene", bool2);
          localITransmitKvData.putString("password", paramBundle.getString("key_pwd1"));
          if (!paramBundle.getString("kreq_token", "").isEmpty()) {
            localITransmitKvData.putString("token", paramBundle.getString("kreq_token"));
          }
          localITransmitKvData.putBool("canChangeRealname", paramBundle.getBoolean("key_bind_show_change_card", false));
          localITransmitKvData.putBool("canPassPwd", paramBundle.getBoolean("key_bind_card_can_pass_pwd", false));
          localITransmitKvData.putString("usertoken", paramBundle.getString("key_bind_card_user_token", ""));
          paramContext = null;
          if (paramBundle.containsKey("realname_verify_process_bundle")) {
            paramContext = (RealNameBundle)paramBundle.getParcelable("realname_verify_process_bundle");
          }
          if (paramContext != null)
          {
            localITransmitKvData.putBool("isNewRealname", true);
            localITransmitKvData.putString("rn_realname_scene", paramBundle.getString("key_realname_scene", ""));
            localITransmitKvData.putString("rn_true_name", paramContext.VBL);
            localITransmitKvData.putString("rn_cre_type", paramContext.VBO);
            localITransmitKvData.putString("rn_cre_name", paramContext.VBP);
            localITransmitKvData.putString("rn_identify_card_origin", paramContext.VBM);
            localITransmitKvData.putString("rn_encry_identity_card", paramContext.VBN);
            localITransmitKvData.putInt("rn_creid_renewal_origin", paramContext.VBV);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_year", paramContext.VBX);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_month", paramContext.VBY);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_day", paramContext.VBZ);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_year", paramContext.VCj);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_month", paramContext.VCk);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_day", paramContext.VCl);
            localITransmitKvData.putInt("rn_birth_date_origin_year", paramContext.VCb);
            localITransmitKvData.putInt("rn_birth_date_origin_month", paramContext.VCc);
            localITransmitKvData.putInt("rn_birth_date_origin_day", paramContext.VCd);
            localITransmitKvData.putString("rn_country", paramContext.VBR);
            localITransmitKvData.putString("rn_province", paramContext.VBS);
            localITransmitKvData.putString("rn_city", paramContext.VBT);
            localITransmitKvData.putString("rn_areaStr", paramContext.VBU);
            localITransmitKvData.putString("rn_profession_type", paramContext.VBQ.VBK);
            localITransmitKvData.putString("rn_profession_name", paramContext.VBQ.VBJ);
            localITransmitKvData.putString("rn_iso_country_code", paramContext.VCe);
            localITransmitKvData.putInt("rn_sex", paramContext.sex);
            localITransmitKvData.putString("rn_detail_address", paramContext.VCh);
            bool1 = paramBundle.getBoolean("realname_verify_process_need_face", false);
            localITransmitKvData.putBool("rn_is_need_face", bool1);
            if (bool1)
            {
              localITransmitKvData.putInt("rn_scene", (int)paramBundle.getLong("realname_verify_process_face_scene"));
              localITransmitKvData.putString("rn_package", paramBundle.getString("realname_verify_process_face_package"));
              localITransmitKvData.putString("rn_package_sign", paramBundle.getString("realname_verify_process_face_package_sign"));
            }
            localITransmitKvData.putString("rn_session_id", paramBundle.getString("key_realname_sessionid", ""));
          }
          localITransmitKvData.putInt("bindCardScene", paramBundle.getInt("key_bind_scene"));
          localITransmitKvData.putString("bindCardUuid", aa.getBindCardUuid());
          localITransmitKvData.putString("deviceName", com.tencent.mm.compatible.deviceinfo.q.aPo());
          localITransmitKvData.putString("deviceType", "");
          localITransmitKvData.putBool("BindCardV2", true);
          localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
          KindaApp.appKinda().startUseCase("addPayCard", localITransmitKvData, new UseCaseCallback()
          {
            public void call(ITransmitKvData paramAnonymousITransmitKvData)
            {
              AppMethodBeat.i(178760);
              Log.i("MicroMsg.WxCrossServices", "startBindCardUseCase callback");
              ng localng = new ng();
              if (paramAnonymousITransmitKvData.getInt("retcode") == 1)
              {
                localng.hPv.hPw = true;
                localng.hPv.hPg = paramAnonymousITransmitKvData.getString("bind_serial");
                localng.hPv.hPy = paramAnonymousITransmitKvData.getString("password");
                localng.hPv.hPf = paramAnonymousITransmitKvData.getString("bank_type");
                localng.hPv.hPz = paramAnonymousITransmitKvData.getString("mobile_no");
                localng.hPv.hPA = paramAnonymousITransmitKvData.getString("realname_title");
                localng.hPv.hPB = paramAnonymousITransmitKvData.getString("realname_desc");
                localng.hPv.hPC = paramAnonymousITransmitKvData.getString("realname_btn_title");
                localng.hPv.hPD = paramAnonymousITransmitKvData.getString("realname_err_jump_page");
              }
              for (;;)
              {
                localng.hPv.hPx = paramBundle.getBoolean("key_need_bind_response", false);
                localng.publish();
                AppMethodBeat.o(178760);
                return;
                if (paramAnonymousITransmitKvData.getInt("retcode") == -1) {
                  localng.hPv.hPw = false;
                }
              }
            }
          });
          AppMethodBeat.o(18294);
          return;
        }
      }
    }
  }
  
  public void startFastBindUseCase(String paramString, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(226394);
    Log.i("MicroMsg.WxCrossServices", "start startFastBindUseCase");
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("qr_code", paramString);
    localITransmitKvData.putInt("channel", paramInt);
    localITransmitKvData.putInt("bind_card_entrance_scene", 2);
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("fastbindcard", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226350);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(226350);
      }
    });
    AppMethodBeat.o(226394);
  }
  
  public void startInWxAppPayUseCase(final Context paramContext, final String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226402);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 19L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startInWxAppPayUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    report.markEnterPay(paramInt1);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("prepay_id", paramString1);
    localITransmitKvData.putString("bank_type", paramString3);
    localITransmitKvData.putString("bind_serial", paramString2);
    localITransmitKvData.putInt("payScene", paramInt1);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    if ((paramContext instanceof EmojiStoreV2RewardUI)) {
      localITransmitKvData.putString("succ_tip", paramContext.getString(R.string.remittance_emoji_reward_desc));
    }
    KindaApp.appKinda().startUseCase("inWxAppPay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226353);
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if ((paramContext instanceof WalletLqtSaveFetchUI))
        {
          localObject1 = paramAnonymousITransmitKvData.getString("result");
          localObject2 = paramAnonymousITransmitKvData.getString("transaction_id");
          Object localObject4 = (WalletLqtSaveFetchUI)paramContext;
          localObject3 = paramString1;
          Log.i("MicroMsg.WalletLqtSaveFetchUI", "onKindaInWxAppPayCallback result:%s transactionId:%s", new Object[] { localObject1, localObject2 });
          if (((WalletLqtSaveFetchUI)localObject4).VhH != null)
          {
            paramAnonymousITransmitKvData = ((WalletLqtSaveFetchUI)localObject4).VhH;
            localObject4 = ((WalletLqtSaveFetchUI)localObject4).Viu;
            if (((String)localObject1).equalsIgnoreCase("ok"))
            {
              Log.i("MicroMsg.LqtSaveFetchLogic", "%s onKindaInWxAppPayCallback, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(paramAnonymousITransmitKvData.hashCode()), Integer.valueOf(paramAnonymousITransmitKvData.VaW), localObject3 });
              paramAnonymousITransmitKvData.hAU = ((String)localObject2);
              localObject1 = (String)paramAnonymousITransmitKvData.VaZ.get(localObject3);
              if (!Util.isNullOrNil((String)localObject1)) {
                paramAnonymousITransmitKvData.VaS = ((String)localObject1);
              }
              if ((paramAnonymousITransmitKvData.VaR instanceof WalletLqtSaveFetchUI))
              {
                ((WalletLqtSaveFetchUI)paramAnonymousITransmitKvData.VaR).Hp(true);
                ((WalletLqtSaveFetchUI)paramAnonymousITransmitKvData.VaR).ifD();
              }
              paramAnonymousITransmitKvData.hC((String)localObject4, 0);
            }
          }
        }
        for (;;)
        {
          WxCrossServices.report.reset();
          AppMethodBeat.o(226353);
          return;
          if ((paramContext instanceof EmojiStoreV2RewardUI))
          {
            paramAnonymousITransmitKvData = paramAnonymousITransmitKvData.getString("result");
            localObject1 = (EmojiStoreV2RewardUI)paramContext;
            if (paramAnonymousITransmitKvData.equalsIgnoreCase("ok"))
            {
              ((EmojiStoreV2RewardUI)localObject1).dCs();
              com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).xNX, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xXj), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xNn), Integer.valueOf(1) });
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 9L, 1L, false);
              ((EmojiStoreV2RewardUI)localObject1).oj(true);
              ((EmojiStoreV2RewardUI)localObject1).finish();
            }
            else if (paramAnonymousITransmitKvData.equalsIgnoreCase("cancel"))
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).xNX, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xXj), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xNn), Integer.valueOf(3) });
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 3L, 1L, false);
            }
            else if (paramAnonymousITransmitKvData.equalsIgnoreCase("fail"))
            {
              if (!((EmojiStoreV2RewardUI)localObject1).xXw)
              {
                ((EmojiStoreV2RewardUI)localObject1).xXw = true;
                com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).xNX, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xXj), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).xNn), Integer.valueOf(2) });
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(408L, 4L, 1L, false);
            }
          }
          else if ((paramContext instanceof WalletIapUI))
          {
            localObject1 = paramAnonymousITransmitKvData.getString("result");
            localObject2 = (WalletIapUI)paramContext;
            if (((WalletIapUI)localObject2).WbV != null) {
              break;
            }
            Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback mPurchaseFinishedListener is null");
          }
        }
        if (((String)localObject1).equalsIgnoreCase("ok")) {
          paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.model.c.dA(0, "");
        }
        for (;;)
        {
          localObject3 = new com.tencent.mm.plugin.wallet_index.b.a.e(((WalletIapUI)localObject2).WaT.xOk, ((WalletIapUI)localObject2).WaT.WaY, ((WalletIapUI)localObject2).WaT.Wag, ((WalletIapUI)localObject2).WaT.Wah);
          ((WalletIapUI)localObject2).WbV.a(paramAnonymousITransmitKvData, (com.tencent.mm.plugin.wallet_index.b.a.e)localObject3);
          Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback result:%s iapResult:%s", new Object[] { localObject1, paramAnonymousITransmitKvData });
          break;
          if (((String)localObject1).equalsIgnoreCase("cancel")) {
            paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.model.c.dA(1, "");
          } else {
            paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.model.c.dA(6, "");
          }
        }
      }
    });
    AppMethodBeat.o(226402);
  }
  
  public void startJSApiWCPaySecurityCrosscut(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(18295);
    if (paramMap == null)
    {
      AppMethodBeat.o(18295);
      return;
    }
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("secure_crosscut", "1");
    localITransmitKvData.putString("appId", (String)paramMap.get("appId"));
    localITransmitKvData.putString("timeStamp", (String)paramMap.get("timeStamp"));
    localITransmitKvData.putString("nonceStr", (String)paramMap.get("nonceStr"));
    localITransmitKvData.putString("package", (String)paramMap.get("package"));
    localITransmitKvData.putString("signType", (String)paramMap.get("signType"));
    localITransmitKvData.putString("paySign", (String)paramMap.get("paySign"));
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
    AppMethodBeat.o(18295);
  }
  
  public void startJsApiComponentUseCase(Context paramContext, WalletJsapiData paramWalletJsapiData, final MMActivity.a parama, final int paramInt)
  {
    AppMethodBeat.i(18296);
    initIfNeed();
    paramContext = ITransmitKvData.create();
    if (paramWalletJsapiData.Ywc != null)
    {
      Iterator localIterator = paramWalletJsapiData.Ywc.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramContext.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    paramContext.putJSEvent("JSEvent", new KJSEvent()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback) {}
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(226299);
        int i;
        if (parama != null) {
          if (paramAnonymousString.endsWith("ok")) {
            i = -1;
          }
        }
        for (;;)
        {
          paramAnonymousString = new Intent();
          paramAnonymousHashMap = paramAnonymousHashMap.entrySet().iterator();
          for (;;)
          {
            if (paramAnonymousHashMap.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousHashMap.next();
              paramAnonymousString.putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
              continue;
              if (!paramAnonymousString.endsWith("fail")) {
                break label124;
              }
              i = 5;
              break;
            }
          }
          parama.mmOnActivityResult(paramInt, i, paramAnonymousString);
          AppMethodBeat.o(226299);
          return;
          label124:
          i = 0;
        }
      }
      
      public KindaJSEventType kindaGetType()
      {
        return KindaJSEventType.WEB;
      }
    });
    paramContext.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase(paramWalletJsapiData.QIe, paramContext, null);
    AppMethodBeat.o(18296);
  }
  
  public void startLqtFixedDepositEntranceUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226383);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositEntranceUseCase");
    paramBundle = ITransmitKvData.create();
    paramBundle.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("LQTFixedDepositEntranceUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226297);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).cg(0, true);
        }
        AppMethodBeat.o(226297);
      }
    });
    AppMethodBeat.o(226383);
  }
  
  public void startLqtFixedDepositMakePlanUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226385);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositMakePlanUseCase");
    paramBundle = ITransmitKvData.create();
    paramBundle.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("LQTFixedDepositMakePlanUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226290);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).cg(0, true);
        }
        AppMethodBeat.o(226290);
      }
    });
    AppMethodBeat.o(226385);
  }
  
  public void startLqtFixedDepositPlanListUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226388);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositPlanListUseCase");
    paramBundle = ITransmitKvData.create();
    paramBundle.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("LQTFixedDepositPlanListUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226349);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).cg(0, true);
        }
        AppMethodBeat.o(226349);
      }
    });
    AppMethodBeat.o(226388);
  }
  
  public void startModifyPwdUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226392);
    Log.i("MicroMsg.WxCrossServices", "start startModifyPwdUseCase");
    paramContext = ITransmitKvData.create();
    paramBundle = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramContext.putString("sessionId", com.tencent.mm.kernel.b.aZs() + "_" + i.jPu());
    paramContext.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("modifyPwdUseCase", paramContext, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData) {}
    });
    AppMethodBeat.o(226392);
  }
  
  public void startOfflinePay(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(18288);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 18L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startOfflinePay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(8);
    paramContext = ITransmitKvData.create();
    paramContext.putString("req_key", paramString1);
    paramContext.putString("prefer_bind_serial", paramString2);
    paramContext.putInt("payScene", 8);
    paramContext.putInt("payChannel", paramInt);
    paramContext.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("offlinePay", paramContext, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(170111);
        boolean bool = paramAnonymousITransmitKvData.getBool("pay_result");
        Log.i("MicroMsg.WxCrossServices", "startOfflinePay UseCaseCallback pay_result: ".concat(String.valueOf(bool)));
        ade localade = new ade();
        localade.ihj.result = 0;
        if (bool)
        {
          localade.ihj.result = -1;
          localade.ihj.intent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putInt("payScene", 8);
          localBundle.putString("pay_bind_serial", paramAnonymousITransmitKvData.getString("pay_bind_serial"));
          localBundle.putInt("isFromKinda", 1);
          localade.ihj.intent.putExtras(localBundle);
        }
        for (;;)
        {
          localade.publish();
          WxCrossServices.report.reset();
          AppMethodBeat.o(170111);
          return;
          localade.ihj.result = 0;
          localade.ihj.intent = new Intent();
          paramAnonymousITransmitKvData = new Bundle();
          paramAnonymousITransmitKvData.putInt("payScene", 8);
          paramAnonymousITransmitKvData.putInt("isFromKinda", 1);
          localade.ihj.intent.putExtras(paramAnonymousITransmitKvData);
        }
      }
    });
    AppMethodBeat.o(18288);
  }
  
  public void startOfflinePrePay(final Context paramContext, int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    AppMethodBeat.i(18289);
    Log.i("MicroMsg.WxCrossServices", "startOfflinePrePay %s", new Object[] { Util.getStack() });
    initIfNeed();
    this.walletLockListener.alive();
    this.jsApiOfflineUserBindQueryListener.alive();
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.k.gvk().a(this);
    ITransmitKvData localITransmitKvData1 = ITransmitKvData.create();
    localITransmitKvData1.putInt("entry_scene", paramInt1);
    localITransmitKvData1.putInt("payScene", 8);
    localITransmitKvData1.putInt("payChannel", paramInt2);
    localITransmitKvData1.putInt("pay_receipt_scene", paramInt3);
    localITransmitKvData1.putString("nativeReportSessionId", g.getSessionId());
    if (paramMap != null)
    {
      ITransmitKvData localITransmitKvData2 = ITransmitKvData.create();
      localITransmitKvData2.putString("card_id", (String)paramMap.get("card_id"));
      localITransmitKvData2.putString("user_card_id", (String)paramMap.get("user_card_id"));
      localITransmitKvData2.putString("card_code", (String)paramMap.get("card_code"));
      localITransmitKvData1.putKvData("member_card", localITransmitKvData2);
    }
    KindaApp.appKinda().startUseCase("offline", localITransmitKvData1, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(178753);
        WxCrossServices.this.walletLockListener.dead();
        WxCrossServices.this.jsApiOfflineUserBindQueryListener.dead();
        com.tencent.mm.plugin.offline.k.gvj();
        com.tencent.mm.plugin.offline.k.gvk().b(WxCrossServices.this);
        if ((paramContext instanceof WalletOfflineEntranceUI)) {
          ((WalletOfflineEntranceUI)paramContext).finish();
        }
        AppMethodBeat.o(178753);
      }
    });
    AppMethodBeat.o(18289);
  }
  
  public boolean startOverseaWalletSuccPageUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226409);
    com.tencent.mm.wallet_core.b.jNX();
    if (!com.tencent.mm.wallet_core.b.b(c.a.yRe, true))
    {
      Log.i("MicroMsg.WxCrossServices", "startOverseaWalletSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
      AppMethodBeat.o(226409);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 20L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startOverseaWalletSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is true");
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramBundle.getString("appid"));
    localITransmitKvData.putString("timestamp", paramBundle.getString("timestamp"));
    localITransmitKvData.putString("nonce_str", paramBundle.getString("nonce_str"));
    localITransmitKvData.putString("package", paramBundle.getString("package"));
    localITransmitKvData.putInt("input_pay_scene", paramBundle.getInt("input_pay_scene"));
    localITransmitKvData.putString("sign_type", paramBundle.getString("sign_type"));
    localITransmitKvData.putString("pay_sign", paramBundle.getString("pay_sign"));
    localITransmitKvData.putString("req_key", paramBundle.getString("req_key"));
    localITransmitKvData.putInt("origin_pay_scene", paramBundle.getInt("origin_pay_scene"));
    localITransmitKvData.putString("order_id", paramBundle.getString("order_id"));
    localITransmitKvData.putInt("retry_max_count", paramBundle.getInt("retry_max_count"));
    localITransmitKvData.putInt("retry_interval_seconds", paramBundle.getInt("retry_interval_seconds"));
    localITransmitKvData.putString("retry_default_wording", paramBundle.getString("retry_default_wording"));
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("overseaWalletSuccPage", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226354);
        if ((paramContext instanceof WalletMixOrderInfoUI))
        {
          Object localObject2 = paramAnonymousITransmitKvData.getString("result");
          boolean bool1 = paramAnonymousITransmitKvData.getBool("is_pending");
          boolean bool2 = paramAnonymousITransmitKvData.getBool("is_jsapi_close_page");
          Object localObject1 = (WalletMixOrderInfoUI)paramContext;
          Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack begin, result=%s is_pending=%b is_jsapi_close_page=%b", new Object[] { localObject2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          ((WalletMixOrderInfoUI)localObject1).VPA = bool1;
          if (((String)localObject2).equalsIgnoreCase("pre_succ")) {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack not handle pre_succ");
          }
          while (paramAnonymousITransmitKvData.getString("result").equals("ok"))
          {
            Log.i("MicroMsg.WxCrossServices", "startOverseaWalletSuccPageUseCase, publish ok WalletPayResultEvent");
            paramAnonymousITransmitKvData = new ade();
            paramAnonymousITransmitKvData.ihj.result = -1;
            paramAnonymousITransmitKvData.ihj.ihm = 2;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_is_clear_failure", -1);
            paramAnonymousITransmitKvData.ihj.intent = ((Intent)localObject1);
            paramAnonymousITransmitKvData.publish();
            AppMethodBeat.o(226354);
            return;
            if (((String)localObject2).equalsIgnoreCase("after_show_succ_page"))
            {
              Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle after_show_succ_page, payScene=%d", new Object[] { Integer.valueOf(((WalletMixOrderInfoUI)localObject1).igp) });
              if (((WalletMixOrderInfoUI)localObject1).igp == 1)
              {
                WalletMixOrderInfoUI.asv(-1);
                ((WalletMixOrderInfoUI)localObject1).setResult(-1);
                ((WalletMixOrderInfoUI)localObject1).finish();
              }
            }
            else if (((String)localObject2).equalsIgnoreCase("ok"))
            {
              Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle ok, payScene=%d prepayId=%s", new Object[] { Integer.valueOf(((WalletMixOrderInfoUI)localObject1).igp), ((WalletMixOrderInfoUI)localObject1).prepayId });
              if (((WalletMixOrderInfoUI)localObject1).igp == 2)
              {
                WalletMixOrderInfoUI.asv(-1);
                Intent localIntent;
                if (!Util.isNullOrNil(((WalletMixOrderInfoUI)localObject1).prepayId))
                {
                  localObject2 = new ade();
                  localIntent = new Intent();
                  localIntent.putExtra("intent_pay_end", true);
                  if (!bool2) {
                    break label411;
                  }
                }
                label411:
                for (int i = 1;; i = 0)
                {
                  localIntent.putExtra("is_jsapi_close_page", i);
                  ((ade)localObject2).ihj.intent = localIntent;
                  ((ade)localObject2).ihj.hAT = ((WalletMixOrderInfoUI)localObject1).prepayId;
                  ((ade)localObject2).ihj.result = -1;
                  ((ade)localObject2).ihj.ihm = 1;
                  ((ade)localObject2).publish();
                  ((WalletMixOrderInfoUI)localObject1).setResult(-1);
                  ((WalletMixOrderInfoUI)localObject1).finish();
                  break;
                }
              }
            }
            else
            {
              Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle else, payScene=%d prepayId=%s", new Object[] { Integer.valueOf(((WalletMixOrderInfoUI)localObject1).igp), ((WalletMixOrderInfoUI)localObject1).prepayId });
              WalletMixOrderInfoUI.asv(0);
              localObject2 = new ade();
              ((ade)localObject2).ihj.hAT = ((WalletMixOrderInfoUI)localObject1).prepayId;
              ((ade)localObject2).ihj.result = 0;
              ((ade)localObject2).publish();
              ((WalletMixOrderInfoUI)localObject1).setResult(0);
              ((WalletMixOrderInfoUI)localObject1).finish();
            }
          }
          if (paramAnonymousITransmitKvData.getString("result").equals("fail"))
          {
            Log.i("MicroMsg.WxCrossServices", "startOverseaWalletSuccPageUseCase, publish canceled WalletPayResultEvent");
            paramAnonymousITransmitKvData = new ade();
            paramAnonymousITransmitKvData.ihj.result = 0;
            paramAnonymousITransmitKvData.ihj.ihm = 2;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_is_clear_failure", -1);
            paramAnonymousITransmitKvData.ihj.intent = ((Intent)localObject1);
            paramAnonymousITransmitKvData.publish();
          }
        }
        AppMethodBeat.o(226354);
      }
    });
    AppMethodBeat.o(226409);
    return true;
  }
  
  public boolean startPayIBGJsGetSuccPageUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226411);
    com.tencent.mm.wallet_core.b.jNX();
    if (!com.tencent.mm.wallet_core.b.b(c.a.yRe, true))
    {
      Log.i("MicroMsg.WxCrossServices", "startPayIBGJsGetSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
      AppMethodBeat.o(226411);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 21L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startPayIBGJsGetSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is true");
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramBundle.getString("appid"));
    localITransmitKvData.putString("timestamp", paramBundle.getString("timestamp"));
    localITransmitKvData.putString("nonce_str", paramBundle.getString("nonce_str"));
    localITransmitKvData.putString("package", paramBundle.getString("package"));
    localITransmitKvData.putString("sign_type", paramBundle.getString("sign_type"));
    localITransmitKvData.putString("pay_sign", paramBundle.getString("pay_sign"));
    localITransmitKvData.putString("webview_url", paramBundle.getString("webview_url"));
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("payIbgGetSuccPage", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(226352);
        String str;
        WalletIbgOrderInfoUI localWalletIbgOrderInfoUI;
        if ((paramContext instanceof WalletIbgOrderInfoUI))
        {
          str = paramAnonymousITransmitKvData.getString("result");
          paramAnonymousITransmitKvData = paramAnonymousITransmitKvData.getString("subscribe_username");
          localWalletIbgOrderInfoUI = (WalletIbgOrderInfoUI)paramContext;
          Log.i("MicroMsg.WalletIbgOrderInfoUI", "onKindaPayIBGGetSuccPageBack, result: %s", new Object[] { str });
          if (!str.equalsIgnoreCase("fail")) {
            break label76;
          }
          localWalletIbgOrderInfoUI.setResult(0);
        }
        for (;;)
        {
          localWalletIbgOrderInfoUI.finish();
          AppMethodBeat.o(226352);
          return;
          label76:
          if (str.equalsIgnoreCase("ok"))
          {
            if (!Util.isNullOrNil(paramAnonymousITransmitKvData))
            {
              Log.i("MicroMsg.WalletIbgOrderInfoUI", "hy: doing netscene subscribe...subscribe_username: %s", new Object[] { paramAnonymousITransmitKvData });
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new t(paramAnonymousITransmitKvData), 0);
            }
            localWalletIbgOrderInfoUI.setResult(-1);
          }
        }
      }
    });
    AppMethodBeat.o(226411);
    return true;
  }
  
  public void startResetPwdUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(170112);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 17L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startResetPwdUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    paramContext = ITransmitKvData.create();
    if (paramBundle == null)
    {
      paramContext.putBool("bResetPwdFromPayManage", false);
      paramContext.putInt("realnameScene", 0);
      paramContext.putInt("payScene", 0);
    }
    for (;;)
    {
      paramContext.putString("nativeReportSessionId", g.getSessionId());
      KindaApp.appKinda().startUseCase("resetPwdUseCase", paramContext, null);
      AppMethodBeat.o(170112);
      return;
      paramContext.putBool("bResetPwdFromPayManage", paramBundle.getBoolean("key_is_paymanager", false));
      paramContext.putInt("realnameScene", 0);
      paramContext.putInt("payScene", 0);
    }
  }
  
  public void startSNSPay(final Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18287);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 10L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startSNSPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(paramPayInfo.hUR);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(paramContext))
    {
      com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(a.i.wallet_is_paying_tips), "", paramContext.getString(a.i.button_ok), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(178761);
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).finish();
          }
          AppMethodBeat.o(178761);
        }
      });
      AppMethodBeat.o(18287);
      return;
    }
    ISnsSceneService localISnsSceneService = SnsSceneServiceFactory.createService(paramPayInfo.hUR);
    ISnsUseCaseCallback localISnsUseCaseCallback = SnsSceneServiceFactory.createCallback(paramPayInfo.hUR);
    localISnsSceneService.setData(paramContext, paramPayInfo);
    localISnsUseCaseCallback.setData(paramContext, paramPayInfo);
    paramContext = localISnsSceneService.generateSnsUseCaseData();
    paramContext.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("snsPay", paramContext, localISnsUseCaseCallback);
    AppMethodBeat.o(18287);
  }
  
  public void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(18286);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 13L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startScanQRCodePay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(1);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("m_A8keyScene", paramInt1);
    localITransmitKvData.putString("qrCodeUrl", paramString);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putInt("payScene", 1);
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    if (this.mDialogForScanPay != null) {
      this.mDialogForScanPay.dismiss();
    }
    paramContext.getString(R.string.app_empty_string);
    this.mDialogForScanPay = com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(R.string.wallet_pay_loading), false, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    Log.d("tag_scan_qrcode_pay", "扫码支付打开正在加载进度框。");
    KindaApp.appKinda().startUseCase("scanQRCodePay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18272);
        Log.i("MicroMsg.WxCrossServices", "startScanQRCodePay call()");
        if (WxCrossServices.this.mDialogForScanPay != null)
        {
          Log.d("tag_scan_qrcode_pay", "扫码支付关闭正在加载进度框。");
          WxCrossServices.this.mDialogForScanPay.dismiss();
          WxCrossServices.access$002(WxCrossServices.this, null);
        }
        ade localade = new ade();
        localade.ihj.result = paramAnonymousITransmitKvData.getInt("scanQRCodeState");
        localade.ihj.ihl = true;
        localade.publish();
        WxCrossServices.report.reset();
        AppMethodBeat.o(18272);
      }
    });
    AppMethodBeat.o(18286);
  }
  
  public void startUiTest()
  {
    AppMethodBeat.i(226405);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("uiTest", localITransmitKvData, new WxCrossServices.25(this));
    AppMethodBeat.o(226405);
  }
  
  public void startUseCase(String paramString, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(226396);
    Log.i("MicroMsg.WxCrossServices", "start common useCase");
    if (((paramObject1 instanceof ITransmitKvData)) && ((paramObject2 instanceof UseCaseCallback)))
    {
      ((ITransmitKvData)paramObject1).putString("nativeReportSessionId", g.getSessionId());
      KindaApp.appKinda().startUseCase(paramString, (ITransmitKvData)paramObject1, (UseCaseCallback)paramObject2);
      AppMethodBeat.o(226396);
      return;
    }
    Log.i("MicroMsg.WxCrossServices", "startUseCase fail, data or callback is not the right type");
    AppMethodBeat.o(226396);
  }
  
  public void startWalletBalanceFetchUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(170113);
    Log.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("payScene", paramBundle.getInt("payScene"));
    localITransmitKvData.putString("totalFee", paramBundle.getString("totalFee"));
    localITransmitKvData.putString("feeType", paramBundle.getString("feeType"));
    localITransmitKvData.putString("bankType", paramBundle.getString("bankType"));
    localITransmitKvData.putString("bindSerial", paramBundle.getString("bindSerial"));
    localITransmitKvData.putString("operation", paramBundle.getString("operation"));
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("fetchBalance", localITransmitKvData, new WxCrossServices.17(this, paramContext, paramBundle));
    AppMethodBeat.o(170113);
  }
  
  public void startWalletBalanceSaveUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(226380);
    Log.i("MicroMsg.WxCrossServices", "startWalletBalanceSaveUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("payScene", paramBundle.getInt("payScene"));
    localITransmitKvData.putString("totalFee", paramBundle.getString("totalFee"));
    localITransmitKvData.putString("feeType", paramBundle.getString("feeType"));
    localITransmitKvData.putString("bankType", paramBundle.getString("bankType"));
    localITransmitKvData.putString("bindSerial", paramBundle.getString("bindSerial"));
    localITransmitKvData.putString("operation", paramBundle.getString("operation"));
    KindaApp.appKinda().startUseCase("saveBalance", localITransmitKvData, new WxCrossServices.18(this, paramContext, paramBundle));
    AppMethodBeat.o(226380);
  }
  
  public void startWxpayAppPay(final Context paramContext, final Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18282);
    Log.i("MicroMsg.WxCrossServices", "startWxpayAppPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 11L, 1L, false);
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(2);
    PayReq localPayReq = new PayReq();
    localPayReq.fromBundle(paramBundle);
    final ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", localPayReq.appId);
    localITransmitKvData.putString("partner_id", localPayReq.partnerId);
    localITransmitKvData.putString("prepay_id", localPayReq.prepayId);
    localITransmitKvData.putString("nonce_str", localPayReq.nonceStr);
    localITransmitKvData.putString("timestamp", localPayReq.timeStamp);
    localITransmitKvData.putString("package", localPayReq.packageValue);
    localITransmitKvData.putString("sign", localPayReq.sign);
    localITransmitKvData.putString("sign_type", localPayReq.signType);
    localITransmitKvData.putString("scene", paramString1);
    localITransmitKvData.putString("app_package_name", paramString2);
    localITransmitKvData.putString("app_display_name", paramString3);
    localITransmitKvData.putString("android_sign", paramString4);
    localITransmitKvData.putString("android_sign", paramString4);
    localITransmitKvData.putString("bundle_id", "");
    localITransmitKvData.putInt("payScene", 2);
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    if (paramBundle.getInt("_wxapi_command_type", 0) == 27) {}
    for (paramBundle = "jointPay";; paramBundle = "appPay")
    {
      Log.i("MicroMsg.WxCrossServices", "app url: %s", new Object[] { paramBundle });
      if (((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) {
        break;
      }
      Log.w("MicroMsg.WxCrossServices", "soter has not initialized, wait 1s");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 48);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170102);
          Log.d("MicroMsg.WxCrossServices", "soter initialized: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) });
          KindaApp.appKinda().startUseCase(paramBundle, localITransmitKvData, new UseCaseCallback()
          {
            public void call(ITransmitKvData paramAnonymous2ITransmitKvData)
            {
              AppMethodBeat.i(170101);
              if ((WxCrossServices.1.this.val$context instanceof OrderHandlerUI)) {
                ((OrderHandlerUI)WxCrossServices.1.this.val$context).finish();
              }
              AppMethodBeat.o(170101);
            }
          });
          AppMethodBeat.o(170102);
        }
      }, 1000L);
      AppMethodBeat.o(18282);
      return;
    }
    KindaApp.appKinda().startUseCase(paramBundle, localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18268);
        if ((paramContext instanceof OrderHandlerUI))
        {
          ((OrderHandlerUI)paramContext).finish();
          WxCrossServices.report.reset();
        }
        AppMethodBeat.o(18268);
      }
    });
    AppMethodBeat.o(18282);
  }
  
  public void startWxpayH5Pay(final Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18284);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 14L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayH5Pay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(36);
    PayReq localPayReq = new PayReq();
    localPayReq.fromBundle(paramBundle);
    paramBundle = ITransmitKvData.create();
    paramBundle.putString("appid", localPayReq.appId);
    paramBundle.putString("partner_id", localPayReq.partnerId);
    paramBundle.putString("prepay_id", localPayReq.prepayId);
    paramBundle.putString("nonce_str", localPayReq.nonceStr);
    paramBundle.putString("timestamp", localPayReq.timeStamp);
    paramBundle.putString("package", localPayReq.packageValue);
    paramBundle.putString("sign", localPayReq.sign);
    paramBundle.putString("sign_type", localPayReq.signType);
    paramBundle.putString("scene", paramString1);
    paramBundle.putString("app_package_name", paramString2);
    paramBundle.putString("app_display_name", paramString3);
    paramBundle.putString("android_sign", paramString4);
    paramBundle.putString("android_sign", paramString4);
    paramBundle.putString("bundle_id", "");
    paramBundle.putInt("payScene", 36);
    paramBundle.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("h5Pay", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18270);
        if ((paramContext instanceof OrderHandlerUI))
        {
          ((OrderHandlerUI)paramContext).finish();
          WxCrossServices.report.reset();
        }
        AppMethodBeat.o(18270);
      }
    });
    AppMethodBeat.o(18284);
  }
  
  public void startWxpayJsApiPay(final Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt)
  {
    AppMethodBeat.i(18283);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 12L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayJsApiPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.model.a.hty();
    report.markEnterPay(paramWalletJsapiData.hUR);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramWalletJsapiData.appId);
    localITransmitKvData.putString("package", paramWalletJsapiData.packageExt);
    localITransmitKvData.putString("signType", paramWalletJsapiData.signType);
    localITransmitKvData.putString("timeStamp", paramWalletJsapiData.timeStamp);
    localITransmitKvData.putString("paySign", paramWalletJsapiData.hUP);
    localITransmitKvData.putString("nonce_str", paramWalletJsapiData.nonceStr);
    localITransmitKvData.putString("stepInAppUserName", paramWalletJsapiData.hUQ);
    localITransmitKvData.putString("stepInURL", paramWalletJsapiData.url);
    localITransmitKvData.putInt("payChannel", paramWalletJsapiData.payChannel);
    localITransmitKvData.putInt("payScene", paramWalletJsapiData.hUR);
    localITransmitKvData.putInt("codeScene", paramWalletJsapiData.tOn);
    localITransmitKvData.putInt("weappEnterScene", paramWalletJsapiData.YvS);
    localITransmitKvData.putString("weappPayCookies", paramWalletJsapiData.okK);
    localITransmitKvData.putString("adUxInfo", paramWalletJsapiData.Ywb);
    localITransmitKvData.putInt("chatType", paramWalletJsapiData.chatType);
    boolean bool;
    if (paramWalletJsapiData.YvT == 1)
    {
      bool = true;
      localITransmitKvData.putBool("imitationNativeTinyApp", bool);
      localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
      KindaJSEvent localKindaJSEvent = new KindaJSEvent();
      localKindaJSEvent.setIMMOnActivityResult(parama);
      localKindaJSEvent.setRequestCode(paramInt);
      localKindaJSEvent.setType(KindaJSEventType.WEB);
      localITransmitKvData.putJSEvent("JSEvent", localKindaJSEvent);
      if (!paramWalletJsapiData.Ywa) {
        break label375;
      }
    }
    label375:
    for (paramWalletJsapiData = "jointPay";; paramWalletJsapiData = "jsapiPay")
    {
      Log.i("MicroMsg.WxCrossServices", "jsapi url: %s", new Object[] { paramWalletJsapiData });
      KindaApp.appKinda().startUseCase(paramWalletJsapiData, localITransmitKvData, new UseCaseCallback()
      {
        public void call(ITransmitKvData paramAnonymousITransmitKvData)
        {
          AppMethodBeat.i(18269);
          Object localObject;
          if ((paramAnonymousITransmitKvData != null) && ((paramContext instanceof WalletBrandUI)))
          {
            localObject = paramAnonymousITransmitKvData.getString("result");
            WxCrossServices.report.reset();
            if (localObject != null) {
              break label265;
            }
            Log.e("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback get result null! ");
            localObject = "";
          }
          label265:
          for (;;)
          {
            int i;
            if (((String)localObject).endsWith("ok")) {
              i = -1;
            }
            for (;;)
            {
              String str = paramAnonymousITransmitKvData.getString("total_fee_str");
              paramAnonymousITransmitKvData = (WalletBrandUI)paramContext;
              Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback receive data, result: %s, resultCode:%d, total_fee_str: ", new Object[] { localObject, Integer.valueOf(i), str });
              if (!com.tencent.matrix.trace.f.c.hm(str))
              {
                str = str.replaceAll("[^0-9\\.]", "");
                Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback totalFee after format is: ".concat(String.valueOf(str)));
                Intent localIntent = new Intent();
                localIntent.putExtra("key_total_fee", str);
                if ((!Util.isNullOrNil(paramAnonymousITransmitKvData.Wbz)) && (paramAnonymousITransmitKvData.Wbz.equalsIgnoreCase("key_from_scene_appbrandgame"))) {
                  paramAnonymousITransmitKvData.q(i, localIntent);
                }
              }
              if (((String)localObject).equals("pre_ok"))
              {
                Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback preSuccess!");
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_is_clear_failure", -1);
                paramAnonymousITransmitKvData.r(i, (Intent)localObject);
                AppMethodBeat.o(18269);
                return;
                if (((String)localObject).endsWith("fail")) {
                  i = 5;
                }
              }
              else
              {
                Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback finish WalletBrandUI.");
                paramAnonymousITransmitKvData.finish();
                AppMethodBeat.o(18269);
                return;
              }
              i = 0;
            }
          }
        }
      });
      AppMethodBeat.o(18283);
      return;
      bool = false;
      break;
    }
  }
  
  public void startWxpayQueryCashierPay(String paramString, int paramInt)
  {
    AppMethodBeat.i(18285);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1004L, 15L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayQueryCashierPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    report.markEnterPay(paramInt);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("req_key", paramString);
    localITransmitKvData.putInt("payScene", paramInt);
    localITransmitKvData.putString("nativeReportSessionId", g.getSessionId());
    KindaApp.appKinda().startUseCase("queryCashierPay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(170110);
        ade localade = new ade();
        ade.a locala = localade.ihj;
        if (paramAnonymousITransmitKvData.getString("result").equals("ok")) {}
        for (int i = -1;; i = 0)
        {
          locala.result = i;
          localade.publish();
          WxCrossServices.report.reset();
          AppMethodBeat.o(170110);
          return;
        }
      }
    });
    AppMethodBeat.o(18285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices
 * JD-Core Version:    0.7.0.1
 */