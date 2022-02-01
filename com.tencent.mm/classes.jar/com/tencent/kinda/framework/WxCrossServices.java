package com.tencent.kinda.framework;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
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
import com.tencent.mm.g.a.k.a;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WxCrossServices
  implements com.tencent.mm.pluginsdk.wallet.a
{
  public static final int REPORT_IDKEY = 1004;
  public static final String TAG = "MicroMsg.WxCrossServices";
  private static final String TAG_SCAN_QR_CODE_PAY = "tag_scan_qrcode_pay";
  private c<com.tencent.mm.g.a.k> appListener;
  private KindaCacheServiceImpl kindaCacheService;
  private p mDialogForScanPay;
  private boolean mInitFlag;
  private n netListener;
  
  static
  {
    AppMethodBeat.i(18298);
    tryLoadLibrary();
    KindaContext.initStack();
    AppMethodBeat.o(18298);
  }
  
  public WxCrossServices()
  {
    AppMethodBeat.i(18276);
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.mInitFlag = false;
    this.appListener = new c()
    {
      public boolean callback(com.tencent.mm.g.a.k paramAnonymousk)
      {
        AppMethodBeat.i(178755);
        if ((paramAnonymousk != null) && (paramAnonymousk.cYC != null))
        {
          if (!paramAnonymousk.cYC.isActive) {
            break label39;
          }
          KindaApp.appKinda().applicationEnterForeground();
        }
        for (;;)
        {
          AppMethodBeat.o(178755);
          return false;
          label39:
          KindaApp.appKinda().applicationEnterBackground();
        }
      }
    };
    this.netListener = new n.a()
    {
      public void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(178757);
        com.tencent.mm.wallet_core.b.fzz();
        if ((!com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) || (!WxCrossServices.this.mInitFlag) || (!KindaApp.appKinda().isInAnyUseCase()))
        {
          AppMethodBeat.o(178757);
          return;
        }
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        Object localObject1 = ai.getContext();
        if (!ax.isConnected((Context)localObject1)) {
          localITransmitKvData.putString("type", "NON_NETWORK");
        }
        Object localObject2;
        Object localObject3;
        for (;;)
        {
          KindaApp.appKinda().networkChange(localITransmitKvData);
          AppMethodBeat.o(178757);
          return;
          if (!ax.isWifi((Context)localObject1)) {
            break;
          }
          localITransmitKvData.putString("type", "WIFI");
          localObject2 = ax.getWifiInfo((Context)localObject1);
          localObject1 = ((WifiInfo)localObject2).getSSID();
          localObject2 = ((WifiInfo)localObject2).getBSSID();
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject3 = new HashMap();
            ((Map)localObject3).put("ssid", localObject1);
            ((Map)localObject3).put("bssid", localObject2);
            localObject1 = com.tencent.mm.plugin.wallet_core.model.k.aR((Map)localObject3);
            localITransmitKvData.putString("info", ((bb)localObject1).DNC);
            localITransmitKvData.putString("info_key", ((bb)localObject1).DND);
          }
        }
        if (ax.is4G((Context)localObject1)) {
          localITransmitKvData.putString("type", "4G");
        }
        for (;;)
        {
          localObject1 = ax.iQ((Context)localObject1);
          if (((List)localObject1).size() <= 0) {
            break;
          }
          localObject3 = (ax.a)((List)localObject1).get(0);
          localObject1 = ((ax.a)localObject3).uHQ;
          localObject2 = ((ax.a)localObject3).uHO;
          localObject3 = ((ax.a)localObject3).uHP;
          if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
            break;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("cellid", localObject1);
          localHashMap.put("mcc", localObject2);
          localHashMap.put("mnc", localObject3);
          localObject1 = com.tencent.mm.plugin.wallet_core.model.k.aR(localHashMap);
          localITransmitKvData.putString("info", ((bb)localObject1).DNC);
          localITransmitKvData.putString("info_key", ((bb)localObject1).DND);
          break;
          if (ax.is3G((Context)localObject1)) {
            localITransmitKvData.putString("type", "3G");
          } else if (ax.is2G((Context)localObject1)) {
            localITransmitKvData.putString("type", "2G");
          } else {
            localITransmitKvData.putString("type", "UNKNOW");
          }
        }
      }
    };
    AppMethodBeat.o(18276);
  }
  
  private void initIfNeed()
  {
    AppMethodBeat.i(18278);
    tryLoadLibrary();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala != null)
    {
      ac.i("MicroMsg.WxCrossServices", "IFingerPrintMgr is not null");
      locala.cHg();
    }
    if (!this.mInitFlag)
    {
      com.tencent.mm.sdk.b.a.GpY.b(this.appListener);
      g.agQ().a(this.netListener);
      KindaApp.instance().onCreate();
      this.mInitFlag = true;
    }
    ActivityController.resetFlag();
    AppMethodBeat.o(18278);
  }
  
  private void preparePayDesk()
  {
    AppMethodBeat.i(18279);
    com.tencent.mm.plugin.wallet_core.model.k.TG(5);
    AppMethodBeat.o(18279);
  }
  
  public static void tryLoadLibrary()
  {
    AppMethodBeat.i(18277);
    if (KindaApp.isEnabled()) {
      com.tencent.mm.plugin.expansions.a.Zu("kinda_android");
    }
    AppMethodBeat.o(18277);
  }
  
  public boolean TenPaySDKABTestKindaEnable()
  {
    AppMethodBeat.i(18293);
    com.tencent.mm.wallet_core.b.fzz();
    boolean bool = com.tencent.mm.wallet_core.b.b(b.a.pRO, true);
    AppMethodBeat.o(18293);
    return bool;
  }
  
  public boolean canOpenKindaCashier(Context paramContext)
  {
    AppMethodBeat.i(18290);
    initIfNeed();
    com.tencent.mm.wallet_core.b.fzz();
    if (!com.tencent.mm.wallet_core.b.b(b.a.pRO, true))
    {
      AppMethodBeat.o(18290);
      return true;
    }
    if (KindaApp.appKinda().getIsPaying())
    {
      ac.i("canOpenKindaCashier", "is paying");
      AppMethodBeat.o(18290);
      return false;
    }
    ac.i("canOpenKindaCashier", "not paying");
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
  
  public boolean kindaCacheServiceGetBool(String paramString)
  {
    AppMethodBeat.i(18292);
    if ("open".equals(com.tencent.mm.sdk.platformtools.h.KINDA_DEFAULT))
    {
      AppMethodBeat.o(18292);
      return true;
    }
    if ("close".equals(com.tencent.mm.sdk.platformtools.h.KINDA_DEFAULT))
    {
      AppMethodBeat.o(18292);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(18292);
      return true;
    }
    if (this.kindaCacheService != null)
    {
      boolean bool = this.kindaCacheService.getBool(paramString);
      ac.i("MicroMsg.WxCrossServices", "kindaCacheServiceGetBool key: %s ret: %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(18292);
      return bool;
    }
    AppMethodBeat.o(18292);
    return false;
  }
  
  public void kindaCacheServiceSetBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(18291);
    if (this.kindaCacheService != null) {
      this.kindaCacheService.setBool(paramString, paramBoolean, 0L);
    }
    AppMethodBeat.o(18291);
  }
  
  public void notifyUploadCardSuccess()
  {
    AppMethodBeat.i(18297);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("upload_id_success_notifycation", "1");
    KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
    AppMethodBeat.o(18297);
  }
  
  public void startBindCardUseCase(Context paramContext, final Bundle paramBundle)
  {
    AppMethodBeat.i(18294);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 16L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startBindCardUseCase %s", new Object[] { bs.eWi() });
    initIfNeed();
    if (paramBundle.getInt("key_bind_scene", -1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int j = paramBundle.getInt("reg_flag", -1);
      int i = j;
      if (j == -1) {
        i = s.ert().eta().field_is_reg;
      }
      if (paramBundle.getInt("key_bind_scene") == 8) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (s.ery().esj()) {}
        for (j = 2;; j = 1)
        {
          paramContext = s.ery().getTrueName();
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
            localITransmitKvData.putString("rn_true_name", paramContext.BsL);
            localITransmitKvData.putString("rn_cre_type", paramContext.BsO);
            localITransmitKvData.putString("rn_cre_name", paramContext.BsP);
            localITransmitKvData.putString("rn_identify_card_origin", paramContext.BsM);
            localITransmitKvData.putString("rn_encry_identity_card", paramContext.BsN);
            localITransmitKvData.putInt("rn_creid_renewal_origin", paramContext.BsV);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_year", paramContext.BsX);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_month", paramContext.BsY);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_day", paramContext.BsZ);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_year", paramContext.Btj);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_month", paramContext.Btk);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_day", paramContext.Btl);
            localITransmitKvData.putInt("rn_birth_date_origin_year", paramContext.Btb);
            localITransmitKvData.putInt("rn_birth_date_origin_month", paramContext.Btc);
            localITransmitKvData.putInt("rn_birth_date_origin_day", paramContext.Btd);
            localITransmitKvData.putString("rn_country", paramContext.BsR);
            localITransmitKvData.putString("rn_province", paramContext.BsS);
            localITransmitKvData.putString("rn_city", paramContext.BsT);
            localITransmitKvData.putString("rn_areaStr", paramContext.BsU);
            localITransmitKvData.putString("rn_profession_type", paramContext.BsQ.BsK);
            localITransmitKvData.putString("rn_profession_name", paramContext.BsQ.BsJ);
            localITransmitKvData.putString("rn_iso_country_code", paramContext.Bte);
            localITransmitKvData.putInt("rn_sex", paramContext.exL);
            localITransmitKvData.putString("rn_detail_address", paramContext.Bth);
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
          localITransmitKvData.putString("bindCardUuid", z.getBindCardUuid());
          localITransmitKvData.putString("deviceName", Build.MODEL);
          localITransmitKvData.putString("deviceType", "");
          localITransmitKvData.putBool("BindCardV2", true);
          KindaApp.appKinda().startUseCase("addPayCard", localITransmitKvData, new UseCaseCallback()
          {
            public void call(ITransmitKvData paramAnonymousITransmitKvData)
            {
              AppMethodBeat.i(178758);
              ac.i("MicroMsg.WxCrossServices", "startBindCardUseCase callback");
              kj localkj = new kj();
              if (paramAnonymousITransmitKvData.getInt("retcode") == 1)
              {
                localkj.dlR.dlS = true;
                localkj.dlR.dlU = paramAnonymousITransmitKvData.getString("bind_serial");
                localkj.dlR.dlV = paramAnonymousITransmitKvData.getString("password");
                localkj.dlR.dlW = paramAnonymousITransmitKvData.getString("bank_type");
                localkj.dlR.dlX = paramAnonymousITransmitKvData.getString("mobile_no");
                localkj.dlR.dlY = paramAnonymousITransmitKvData.getString("realname_title");
                localkj.dlR.dlZ = paramAnonymousITransmitKvData.getString("realname_desc");
                localkj.dlR.dma = paramAnonymousITransmitKvData.getString("realname_btn_title");
                localkj.dlR.dmb = paramAnonymousITransmitKvData.getString("realname_err_jump_page");
              }
              for (;;)
              {
                localkj.dlR.dlT = paramBundle.getBoolean("key_need_bind_response", false);
                com.tencent.mm.sdk.b.a.GpY.l(localkj);
                AppMethodBeat.o(178758);
                return;
                if (paramAnonymousITransmitKvData.getInt("retcode") == -1) {
                  localkj.dlR.dlS = false;
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
    KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
    AppMethodBeat.o(18295);
  }
  
  public void startJsApiComponentUseCase(Context paramContext, WalletJsapiData paramWalletJsapiData, final MMActivity.a parama, final int paramInt)
  {
    AppMethodBeat.i(18296);
    initIfNeed();
    paramContext = ITransmitKvData.create();
    if (paramWalletJsapiData.DHf != null)
    {
      Iterator localIterator = paramWalletJsapiData.DHf.entrySet().iterator();
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
        AppMethodBeat.i(178759);
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
          parama.c(paramInt, i, paramAnonymousString);
          AppMethodBeat.o(178759);
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
    KindaApp.appKinda().startUseCase(paramWalletJsapiData.yht, paramContext, null);
    AppMethodBeat.o(18296);
  }
  
  public void startOfflinePay(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(18288);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 18L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startOfflinePay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.dTp();
    paramContext = ITransmitKvData.create();
    paramContext.putString("req_key", paramString1);
    paramContext.putString("prefer_bind_serial", paramString2);
    paramContext.putInt("payScene", 8);
    paramContext.putInt("payChannel", paramInt);
    KindaApp.appKinda().startUseCase("offlinePay", paramContext, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(170111);
        boolean bool = paramAnonymousITransmitKvData.getBool("pay_result");
        ac.i("MicroMsg.WxCrossServices", "startOfflinePay UseCaseCallback pay_result: ".concat(String.valueOf(bool)));
        paramAnonymousITransmitKvData = new xv();
        paramAnonymousITransmitKvData.dBk.result = 0;
        if (bool)
        {
          paramAnonymousITransmitKvData.dBk.result = -1;
          paramAnonymousITransmitKvData.dBk.intent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putInt("payScene", 8);
          paramAnonymousITransmitKvData.dBk.intent.putExtras(localBundle);
        }
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousITransmitKvData);
        AppMethodBeat.o(170111);
      }
    });
    AppMethodBeat.o(18288);
  }
  
  public void startOfflinePrePay(final Context paramContext, int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    AppMethodBeat.i(18289);
    ac.i("MicroMsg.WxCrossServices", "startOfflinePrePay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData1 = ITransmitKvData.create();
    localITransmitKvData1.putInt("entry_scene", paramInt1);
    localITransmitKvData1.putInt("payScene", 8);
    localITransmitKvData1.putInt("payChannel", paramInt2);
    localITransmitKvData1.putInt("pay_receipt_scene", paramInt3);
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
        if ((paramContext instanceof WalletOfflineEntranceUI)) {
          ((WalletOfflineEntranceUI)paramContext).finish();
        }
        AppMethodBeat.o(178753);
      }
    });
    AppMethodBeat.o(18289);
  }
  
  public void startResetPwdUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(170112);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 17L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startResetPwdUseCase %s", new Object[] { bs.eWi() });
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
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 10L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startSNSPay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.dTp();
    if (!((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(paramContext))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131765336), "", paramContext.getString(2131756757), new DialogInterface.OnClickListener()
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
    ISnsSceneService localISnsSceneService = SnsSceneServiceFactory.createService(paramPayInfo.dqL);
    ISnsUseCaseCallback localISnsUseCaseCallback = SnsSceneServiceFactory.createCallback(paramPayInfo.dqL);
    localISnsSceneService.setData(paramContext, paramPayInfo);
    localISnsUseCaseCallback.setData(paramContext, paramPayInfo);
    KindaApp.appKinda().startUseCase("snsPay", localISnsSceneService.generateSnsUseCaseData(), localISnsUseCaseCallback);
    AppMethodBeat.o(18287);
  }
  
  public void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(18286);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 13L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startScanQRCodePay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.dTp();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("m_A8keyScene", paramInt1);
    localITransmitKvData.putString("qrCodeUrl", paramString);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putInt("payScene", 1);
    if (this.mDialogForScanPay != null) {
      this.mDialogForScanPay.dismiss();
    }
    paramContext.getString(2131755726);
    this.mDialogForScanPay = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ac.d("tag_scan_qrcode_pay", "扫码支付打开正在加载进度框。");
    KindaApp.appKinda().startUseCase("scanQRCodePay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18272);
        ac.i("MicroMsg.WxCrossServices", "startScanQRCodePay call()");
        if (WxCrossServices.this.mDialogForScanPay != null)
        {
          ac.d("tag_scan_qrcode_pay", "扫码支付关闭正在加载进度框。");
          WxCrossServices.this.mDialogForScanPay.dismiss();
          WxCrossServices.access$002(WxCrossServices.this, null);
        }
        xv localxv = new xv();
        localxv.dBk.result = paramAnonymousITransmitKvData.getInt("scanQRCodeState");
        localxv.dBk.dBm = true;
        com.tencent.mm.sdk.b.a.GpY.l(localxv);
        AppMethodBeat.o(18272);
      }
    });
    AppMethodBeat.o(18286);
  }
  
  public void startWalletBalanceFetchUseCase(final Context paramContext, final Bundle paramBundle)
  {
    AppMethodBeat.i(170113);
    ac.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("payScene", paramBundle.getInt("payScene"));
    localITransmitKvData.putString("totalFee", paramBundle.getString("totalFee"));
    localITransmitKvData.putString("feeType", paramBundle.getString("feeType"));
    localITransmitKvData.putString("bankType", paramBundle.getString("bankType"));
    localITransmitKvData.putString("bindSerial", paramBundle.getString("bindSerial"));
    localITransmitKvData.putString("operation", paramBundle.getString("operation"));
    KindaApp.appKinda().startUseCase("fetchBalance", localITransmitKvData, new UseCaseCallback()
    {
      private byte _hellAccFlag_;
      
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(178760);
        if (!(paramContext instanceof WalletBalanceFetchUI))
        {
          AppMethodBeat.o(178760);
          return;
        }
        int i = paramAnonymousITransmitKvData.getInt("result");
        ac.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase result：%s", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        default: 
          ac.i("MicroMsg.WxCrossServices", "startWalletBalanceFetch unknown result：%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(178760);
          return;
        case 1: 
          Object localObject = new Intent(paramContext, WalletBalanceManagerUI.class);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousITransmitKvData = paramContext;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousITransmitKvData.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(178760);
          return;
        case 2: 
          AppMethodBeat.o(178760);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(16398, new Object[] { paramBundle.getString("reportSessionId"), Integer.valueOf(8), "", "" });
        AppMethodBeat.o(178760);
      }
    });
    AppMethodBeat.o(170113);
  }
  
  public void startWxpayAppPay(final Context paramContext, final Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18282);
    ac.i("MicroMsg.WxCrossServices", "startWxpayAppPay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 11L, 1L, false);
    com.tencent.mm.plugin.soter.d.a.dTp();
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
    if (paramBundle.getInt("_wxapi_command_type", 0) == 27) {}
    for (paramBundle = "jointPay";; paramBundle = "appPay")
    {
      ac.i("MicroMsg.WxCrossServices", "app url: %s", new Object[] { paramBundle });
      if (((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) {
        break;
      }
      ac.w("MicroMsg.WxCrossServices", "soter has not initialized, wait 1s");
      com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 48);
      ap.n(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170102);
          ac.d("MicroMsg.WxCrossServices", "soter initialized: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) });
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
        if ((paramContext instanceof OrderHandlerUI)) {
          ((OrderHandlerUI)paramContext).finish();
        }
        AppMethodBeat.o(18268);
      }
    });
    AppMethodBeat.o(18282);
  }
  
  public void startWxpayH5Pay(final Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18284);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 14L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startWxpayH5Pay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.dTp();
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
    KindaApp.appKinda().startUseCase("h5Pay", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18270);
        if ((paramContext instanceof OrderHandlerUI)) {
          ((OrderHandlerUI)paramContext).finish();
        }
        AppMethodBeat.o(18270);
      }
    });
    AppMethodBeat.o(18284);
  }
  
  public void startWxpayJsApiPay(final Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt)
  {
    AppMethodBeat.i(18283);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 12L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startWxpayJsApiPay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.dTp();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramWalletJsapiData.appId);
    localITransmitKvData.putString("package", paramWalletJsapiData.packageExt);
    localITransmitKvData.putString("signType", paramWalletJsapiData.signType);
    localITransmitKvData.putString("timeStamp", paramWalletJsapiData.timeStamp);
    localITransmitKvData.putString("paySign", paramWalletJsapiData.dqJ);
    localITransmitKvData.putString("nonce_str", paramWalletJsapiData.nonceStr);
    localITransmitKvData.putString("stepInAppUserName", paramWalletJsapiData.dqK);
    localITransmitKvData.putString("stepInURL", paramWalletJsapiData.url);
    localITransmitKvData.putInt("payChannel", paramWalletJsapiData.dcB);
    localITransmitKvData.putInt("payScene", paramWalletJsapiData.dqL);
    localITransmitKvData.putInt("weappEnterScene", paramWalletJsapiData.DGW);
    localITransmitKvData.putString("weappPayCookies", paramWalletJsapiData.hnq);
    localITransmitKvData.putString("adUxInfo", paramWalletJsapiData.DHe);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setIMMOnActivityResult(parama);
    localKindaJSEvent.setRequestCode(paramInt);
    localKindaJSEvent.setType(KindaJSEventType.WEB);
    localITransmitKvData.putJSEvent("JSEvent", localKindaJSEvent);
    if (paramWalletJsapiData.DHd) {}
    for (paramWalletJsapiData = "jointPay";; paramWalletJsapiData = "jsapiPay")
    {
      ac.i("MicroMsg.WxCrossServices", "jsapi url: %s", new Object[] { paramWalletJsapiData });
      KindaApp.appKinda().startUseCase(paramWalletJsapiData, localITransmitKvData, new UseCaseCallback()
      {
        public void call(ITransmitKvData paramAnonymousITransmitKvData)
        {
          AppMethodBeat.i(18269);
          Object localObject;
          if ((paramAnonymousITransmitKvData != null) && ((paramContext instanceof WalletBrandUI)))
          {
            localObject = paramAnonymousITransmitKvData.getString("result");
            if (localObject != null) {
              break label259;
            }
            ac.e("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback get result null! ");
            localObject = "";
          }
          label259:
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
              ac.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback receive data, result: %s, resultCode:%d, total_fee_str: ", new Object[] { localObject, Integer.valueOf(i), str });
              if (!com.tencent.matrix.trace.g.b.cX(str))
              {
                str = str.replaceAll("[^0-9\\.]", "");
                ac.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback totalFee after format is: ".concat(String.valueOf(str)));
                Intent localIntent = new Intent();
                localIntent.putExtra("key_total_fee", str);
                if ((!bs.isNullOrNil(paramAnonymousITransmitKvData.BQy)) && (paramAnonymousITransmitKvData.BQy.equalsIgnoreCase("key_from_scene_appbrandgame"))) {
                  paramAnonymousITransmitKvData.n(i, localIntent);
                }
              }
              if (((String)localObject).equals("pre_ok"))
              {
                ac.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback preSuccess!");
                localObject = new Intent();
                ((Intent)localObject).putExtra("key_is_clear_failure", -1);
                paramAnonymousITransmitKvData.o(i, (Intent)localObject);
                AppMethodBeat.o(18269);
                return;
                if (((String)localObject).endsWith("fail")) {
                  i = 5;
                }
              }
              else
              {
                ac.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback finish WalletBrandUI.");
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
    }
  }
  
  public void startWxpayQueryCashierPay(String paramString, int paramInt)
  {
    AppMethodBeat.i(18285);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1004L, 15L, 1L, false);
    ac.i("MicroMsg.WxCrossServices", "startWxpayQueryCashierPay %s", new Object[] { bs.eWi() });
    initIfNeed();
    preparePayDesk();
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("req_key", paramString);
    localITransmitKvData.putInt("payScene", paramInt);
    KindaApp.appKinda().startUseCase("queryCashierPay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(170110);
        xv localxv = new xv();
        xv.a locala = localxv.dBk;
        if (paramAnonymousITransmitKvData.getString("result").equals("ok")) {}
        for (int i = -1;; i = 0)
        {
          locala.result = i;
          com.tencent.mm.sdk.b.a.GpY.l(localxv);
          AppMethodBeat.o(170110);
          return;
        }
      }
    });
    AppMethodBeat.o(18285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices
 * JD-Core Version:    0.7.0.1
 */