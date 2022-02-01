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
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
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
  public static MaybeCrashReport report;
  private c<com.tencent.mm.g.a.k> appListener;
  private KindaCacheServiceImpl kindaCacheService;
  private p mDialogForScanPay;
  private boolean mInitFlag;
  private n netListener;
  
  static
  {
    AppMethodBeat.i(18298);
    report = new MaybeCrashReport();
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
        if ((paramAnonymousk != null) && (paramAnonymousk.dkW != null))
        {
          if (!paramAnonymousk.dkW.isActive) {
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
          WxCrossServices.report.reset();
        }
      }
    };
    this.netListener = new n.a()
    {
      public void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(178757);
        com.tencent.mm.wallet_core.b.fVf();
        if ((!com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) || (!WxCrossServices.this.mInitFlag) || (!KindaApp.appKinda().isInAnyUseCase()))
        {
          AppMethodBeat.o(178757);
          return;
        }
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        Object localObject1 = ak.getContext();
        if (!az.isConnected((Context)localObject1)) {
          localITransmitKvData.putString("type", "NON_NETWORK");
        }
        Object localObject2;
        Object localObject3;
        for (;;)
        {
          KindaApp.appKinda().networkChange(localITransmitKvData);
          AppMethodBeat.o(178757);
          return;
          if (!az.isWifi((Context)localObject1)) {
            break;
          }
          localITransmitKvData.putString("type", "WIFI");
          localObject2 = az.getWifiInfo((Context)localObject1);
          localObject1 = ((WifiInfo)localObject2).getSSID();
          localObject2 = ((WifiInfo)localObject2).getBSSID();
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject3 = new HashMap();
            ((Map)localObject3).put("ssid", localObject1);
            ((Map)localObject3).put("bssid", localObject2);
            localObject1 = com.tencent.mm.plugin.wallet_core.model.k.ba((Map)localObject3);
            localITransmitKvData.putString("info", ((bb)localObject1).FLf);
            localITransmitKvData.putString("info_key", ((bb)localObject1).FLg);
          }
        }
        if (az.is4G((Context)localObject1)) {
          localITransmitKvData.putString("type", "4G");
        }
        for (;;)
        {
          localObject1 = az.jf((Context)localObject1);
          if (((List)localObject1).size() <= 0) {
            break;
          }
          localObject3 = (az.a)((List)localObject1).get(0);
          localObject1 = ((az.a)localObject3).vWZ;
          localObject2 = ((az.a)localObject3).vWX;
          localObject3 = ((az.a)localObject3).vWY;
          if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
            break;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("cellid", localObject1);
          localHashMap.put("mcc", localObject2);
          localHashMap.put("mnc", localObject3);
          localObject1 = com.tencent.mm.plugin.wallet_core.model.k.ba(localHashMap);
          localITransmitKvData.putString("info", ((bb)localObject1).FLf);
          localITransmitKvData.putString("info_key", ((bb)localObject1).FLg);
          break;
          if (az.is3G((Context)localObject1)) {
            localITransmitKvData.putString("type", "3G");
          } else if (az.is2G((Context)localObject1)) {
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
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala != null)
    {
      ae.i("MicroMsg.WxCrossServices", "IFingerPrintMgr is not null");
      locala.cSa();
    }
    if (!this.mInitFlag)
    {
      com.tencent.mm.sdk.b.a.IvT.b(this.appListener);
      com.tencent.mm.kernel.g.ajQ().a(this.netListener);
      KindaApp.instance().onCreate();
      this.mInitFlag = true;
    }
    ActivityController.resetFlag();
    AppMethodBeat.o(18278);
  }
  
  public static void judgeReprot()
  {
    AppMethodBeat.i(193133);
    report.judgeReport();
    AppMethodBeat.o(193133);
  }
  
  private void preparePayDesk()
  {
    AppMethodBeat.i(18279);
    com.tencent.mm.plugin.wallet_core.model.k.Wf(5);
    AppMethodBeat.o(18279);
  }
  
  public static void tryLoadLibrary()
  {
    AppMethodBeat.i(18277);
    if (KindaApp.isEnabled()) {
      com.tencent.mm.plugin.expansions.a.adR("kinda_android");
    }
    AppMethodBeat.o(18277);
  }
  
  public boolean TenPaySDKABTestKindaEnable()
  {
    AppMethodBeat.i(18293);
    com.tencent.mm.wallet_core.b.fVf();
    boolean bool = com.tencent.mm.wallet_core.b.b(b.a.qDk, true);
    AppMethodBeat.o(18293);
    return bool;
  }
  
  public boolean canOpenKindaCashier(Context paramContext)
  {
    AppMethodBeat.i(18290);
    initIfNeed();
    com.tencent.mm.wallet_core.b.fVf();
    if (!com.tencent.mm.wallet_core.b.b(b.a.qDk, true))
    {
      AppMethodBeat.o(18290);
      return true;
    }
    if (KindaApp.appKinda().getIsPaying())
    {
      ae.i("canOpenKindaCashier", "is paying");
      AppMethodBeat.o(18290);
      return false;
    }
    ae.i("canOpenKindaCashier", "not paying");
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
    if ("open".equals(j.KINDA_DEFAULT))
    {
      AppMethodBeat.o(18292);
      return true;
    }
    if ("close".equals(j.KINDA_DEFAULT))
    {
      AppMethodBeat.o(18292);
      return false;
    }
    if (j.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(18292);
      return true;
    }
    if (this.kindaCacheService != null)
    {
      boolean bool = this.kindaCacheService.getBool(paramString);
      ae.i("MicroMsg.WxCrossServices", "kindaCacheServiceGetBool key: %s ret: %s", new Object[] { paramString, Boolean.valueOf(bool) });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 16L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startBindCardUseCase %s", new Object[] { bu.fpN() });
    initIfNeed();
    if (paramBundle.getInt("key_bind_scene", -1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int j = paramBundle.getInt("reg_flag", -1);
      int i = j;
      if (j == -1) {
        i = t.eJa().eKO().field_is_reg;
      }
      if (paramBundle.getInt("key_bind_scene") == 8) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (t.eJf().eJQ()) {}
        for (j = 2;; j = 1)
        {
          paramContext = t.eJf().getTrueName();
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
            localITransmitKvData.putString("rn_true_name", paramContext.DkG);
            localITransmitKvData.putString("rn_cre_type", paramContext.DkJ);
            localITransmitKvData.putString("rn_cre_name", paramContext.DkK);
            localITransmitKvData.putString("rn_identify_card_origin", paramContext.DkH);
            localITransmitKvData.putString("rn_encry_identity_card", paramContext.DkI);
            localITransmitKvData.putInt("rn_creid_renewal_origin", paramContext.DkQ);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_year", paramContext.DkS);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_month", paramContext.DkT);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_day", paramContext.DkU);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_year", paramContext.Dle);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_month", paramContext.Dlf);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_day", paramContext.Dlg);
            localITransmitKvData.putInt("rn_birth_date_origin_year", paramContext.DkW);
            localITransmitKvData.putInt("rn_birth_date_origin_month", paramContext.DkX);
            localITransmitKvData.putInt("rn_birth_date_origin_day", paramContext.DkY);
            localITransmitKvData.putString("rn_country", paramContext.DkM);
            localITransmitKvData.putString("rn_province", paramContext.DkN);
            localITransmitKvData.putString("rn_city", paramContext.DkO);
            localITransmitKvData.putString("rn_areaStr", paramContext.DkP);
            localITransmitKvData.putString("rn_profession_type", paramContext.DkL.DkF);
            localITransmitKvData.putString("rn_profession_name", paramContext.DkL.DkE);
            localITransmitKvData.putString("rn_iso_country_code", paramContext.DkZ);
            localITransmitKvData.putInt("rn_sex", paramContext.eQV);
            localITransmitKvData.putString("rn_detail_address", paramContext.Dlc);
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
              ae.i("MicroMsg.WxCrossServices", "startBindCardUseCase callback");
              kt localkt = new kt();
              if (paramAnonymousITransmitKvData.getInt("retcode") == 1)
              {
                localkt.dyK.dyL = true;
                localkt.dyK.dyN = paramAnonymousITransmitKvData.getString("bind_serial");
                localkt.dyK.dyO = paramAnonymousITransmitKvData.getString("password");
                localkt.dyK.dyP = paramAnonymousITransmitKvData.getString("bank_type");
                localkt.dyK.dyQ = paramAnonymousITransmitKvData.getString("mobile_no");
                localkt.dyK.dyR = paramAnonymousITransmitKvData.getString("realname_title");
                localkt.dyK.dyS = paramAnonymousITransmitKvData.getString("realname_desc");
                localkt.dyK.dyT = paramAnonymousITransmitKvData.getString("realname_btn_title");
                localkt.dyK.dyU = paramAnonymousITransmitKvData.getString("realname_err_jump_page");
              }
              for (;;)
              {
                localkt.dyK.dyM = paramBundle.getBoolean("key_need_bind_response", false);
                com.tencent.mm.sdk.b.a.IvT.l(localkt);
                AppMethodBeat.o(178758);
                return;
                if (paramAnonymousITransmitKvData.getInt("retcode") == -1) {
                  localkt.dyK.dyL = false;
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
    if (paramWalletJsapiData.FEK != null)
    {
      Iterator localIterator = paramWalletJsapiData.FEK.entrySet().iterator();
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
    KindaApp.appKinda().startUseCase(paramWalletJsapiData.zOZ, paramContext, null);
    AppMethodBeat.o(18296);
  }
  
  public void startLqtFixedDepositEntranceUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(193134);
    ae.i("MicroMsg.WxCrossServices", "start LqtFixedDepositEntranceUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositEntranceUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(193127);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).aV(0, true);
        }
        AppMethodBeat.o(193127);
      }
    });
    AppMethodBeat.o(193134);
  }
  
  public void startLqtFixedDepositMakePlanUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(193135);
    ae.i("MicroMsg.WxCrossServices", "start LqtFixedDepositMakePlanUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositMakePlanUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(193128);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).aV(0, true);
        }
        AppMethodBeat.o(193128);
      }
    });
    AppMethodBeat.o(193135);
  }
  
  public void startLqtFixedDepositPlanListUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(193136);
    ae.i("MicroMsg.WxCrossServices", "start LqtFixedDepositPlanListUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositPlanListUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(193129);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).aV(0, true);
        }
        AppMethodBeat.o(193129);
      }
    });
    AppMethodBeat.o(193136);
  }
  
  public void startOfflinePay(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(18288);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 18L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startOfflinePay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.ejl();
    report.markEnterPay(8);
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
        ae.i("MicroMsg.WxCrossServices", "startOfflinePay UseCaseCallback pay_result: ".concat(String.valueOf(bool)));
        paramAnonymousITransmitKvData = new yv();
        paramAnonymousITransmitKvData.dON.result = 0;
        if (bool)
        {
          paramAnonymousITransmitKvData.dON.result = -1;
          paramAnonymousITransmitKvData.dON.intent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putInt("payScene", 8);
          paramAnonymousITransmitKvData.dON.intent.putExtras(localBundle);
        }
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousITransmitKvData);
        WxCrossServices.report.reset();
        AppMethodBeat.o(170111);
      }
    });
    AppMethodBeat.o(18288);
  }
  
  public void startOfflinePrePay(final Context paramContext, int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    AppMethodBeat.i(18289);
    ae.i("MicroMsg.WxCrossServices", "startOfflinePrePay %s", new Object[] { bu.fpN() });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 17L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startResetPwdUseCase %s", new Object[] { bu.fpN() });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 10L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startSNSPay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.ejl();
    report.markEnterPay(paramPayInfo.dDH);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(paramContext))
    {
      h.a(paramContext, paramContext.getString(2131765336), "", paramContext.getString(2131756757), new DialogInterface.OnClickListener()
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
    ISnsSceneService localISnsSceneService = SnsSceneServiceFactory.createService(paramPayInfo.dDH);
    ISnsUseCaseCallback localISnsUseCaseCallback = SnsSceneServiceFactory.createCallback(paramPayInfo.dDH);
    localISnsSceneService.setData(paramContext, paramPayInfo);
    localISnsUseCaseCallback.setData(paramContext, paramPayInfo);
    KindaApp.appKinda().startUseCase("snsPay", localISnsSceneService.generateSnsUseCaseData(), localISnsUseCaseCallback);
    AppMethodBeat.o(18287);
  }
  
  public void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(18286);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 13L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startScanQRCodePay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.ejl();
    report.markEnterPay(1);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("m_A8keyScene", paramInt1);
    localITransmitKvData.putString("qrCodeUrl", paramString);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putInt("payScene", 1);
    if (this.mDialogForScanPay != null) {
      this.mDialogForScanPay.dismiss();
    }
    paramContext.getString(2131755726);
    this.mDialogForScanPay = h.b(paramContext, paramContext.getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ae.d("tag_scan_qrcode_pay", "扫码支付打开正在加载进度框。");
    KindaApp.appKinda().startUseCase("scanQRCodePay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(18272);
        ae.i("MicroMsg.WxCrossServices", "startScanQRCodePay call()");
        if (WxCrossServices.this.mDialogForScanPay != null)
        {
          ae.d("tag_scan_qrcode_pay", "扫码支付关闭正在加载进度框。");
          WxCrossServices.this.mDialogForScanPay.dismiss();
          WxCrossServices.access$002(WxCrossServices.this, null);
        }
        yv localyv = new yv();
        localyv.dON.result = paramAnonymousITransmitKvData.getInt("scanQRCodeState");
        localyv.dON.dOP = true;
        com.tencent.mm.sdk.b.a.IvT.l(localyv);
        WxCrossServices.report.reset();
        AppMethodBeat.o(18272);
      }
    });
    AppMethodBeat.o(18286);
  }
  
  public void startWalletBalanceFetchUseCase(final Context paramContext, final Bundle paramBundle)
  {
    AppMethodBeat.i(170113);
    ae.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase %s", new Object[] { bu.fpN() });
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
        ae.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase result：%s", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        default: 
          ae.i("MicroMsg.WxCrossServices", "startWalletBalanceFetch unknown result：%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(178760);
          return;
        case 1: 
          Object localObject = new Intent(paramContext, WalletBalanceManagerUI.class);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousITransmitKvData = paramContext;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousITransmitKvData.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(178760);
          return;
        case 2: 
          AppMethodBeat.o(178760);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(16398, new Object[] { paramBundle.getString("reportSessionId"), Integer.valueOf(8), "", "" });
        AppMethodBeat.o(178760);
      }
    });
    AppMethodBeat.o(170113);
  }
  
  public void startWxpayAppPay(final Context paramContext, final Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18282);
    ae.i("MicroMsg.WxCrossServices", "startWxpayAppPay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 11L, 1L, false);
    com.tencent.mm.plugin.soter.d.a.ejl();
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
    if (paramBundle.getInt("_wxapi_command_type", 0) == 27) {}
    for (paramBundle = "jointPay";; paramBundle = "appPay")
    {
      ae.i("MicroMsg.WxCrossServices", "app url: %s", new Object[] { paramBundle });
      if (((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) {
        break;
      }
      ae.w("MicroMsg.WxCrossServices", "soter has not initialized, wait 1s");
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 48);
      ar.o(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170102);
          ae.d("MicroMsg.WxCrossServices", "soter initialized: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 14L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startWxpayH5Pay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.ejl();
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 12L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startWxpayJsApiPay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.ejl();
    report.markEnterPay(paramWalletJsapiData.dDH);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramWalletJsapiData.appId);
    localITransmitKvData.putString("package", paramWalletJsapiData.packageExt);
    localITransmitKvData.putString("signType", paramWalletJsapiData.signType);
    localITransmitKvData.putString("timeStamp", paramWalletJsapiData.timeStamp);
    localITransmitKvData.putString("paySign", paramWalletJsapiData.dDF);
    localITransmitKvData.putString("nonce_str", paramWalletJsapiData.nonceStr);
    localITransmitKvData.putString("stepInAppUserName", paramWalletJsapiData.dDG);
    localITransmitKvData.putString("stepInURL", paramWalletJsapiData.url);
    localITransmitKvData.putInt("payChannel", paramWalletJsapiData.dpc);
    localITransmitKvData.putInt("payScene", paramWalletJsapiData.dDH);
    localITransmitKvData.putInt("weappEnterScene", paramWalletJsapiData.FEB);
    localITransmitKvData.putString("weappPayCookies", paramWalletJsapiData.hIA);
    localITransmitKvData.putString("adUxInfo", paramWalletJsapiData.FEJ);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setIMMOnActivityResult(parama);
    localKindaJSEvent.setRequestCode(paramInt);
    localKindaJSEvent.setType(KindaJSEventType.WEB);
    localITransmitKvData.putJSEvent("JSEvent", localKindaJSEvent);
    if (paramWalletJsapiData.FEI) {}
    for (paramWalletJsapiData = "jointPay";; paramWalletJsapiData = "jsapiPay")
    {
      ae.i("MicroMsg.WxCrossServices", "jsapi url: %s", new Object[] { paramWalletJsapiData });
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
            ae.e("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback get result null! ");
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
              ae.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback receive data, result: %s, resultCode:%d, total_fee_str: ", new Object[] { localObject, Integer.valueOf(i), str });
              if (!com.tencent.matrix.trace.g.b.ef(str))
              {
                str = str.replaceAll("[^0-9\\.]", "");
                ae.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback totalFee after format is: ".concat(String.valueOf(str)));
                Intent localIntent = new Intent();
                localIntent.putExtra("key_total_fee", str);
                if ((!bu.isNullOrNil(paramAnonymousITransmitKvData.DIw)) && (paramAnonymousITransmitKvData.DIw.equalsIgnoreCase("key_from_scene_appbrandgame"))) {
                  paramAnonymousITransmitKvData.n(i, localIntent);
                }
              }
              if (((String)localObject).equals("pre_ok"))
              {
                ae.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback preSuccess!");
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
                ae.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback finish WalletBrandUI.");
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1004L, 15L, 1L, false);
    ae.i("MicroMsg.WxCrossServices", "startWxpayQueryCashierPay %s", new Object[] { bu.fpN() });
    initIfNeed();
    preparePayDesk();
    report.markEnterPay(paramInt);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("req_key", paramString);
    localITransmitKvData.putInt("payScene", paramInt);
    KindaApp.appKinda().startUseCase("queryCashierPay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(170110);
        yv localyv = new yv();
        yv.a locala = localyv.dON;
        if (paramAnonymousITransmitKvData.getString("result").equals("ok")) {}
        for (int i = -1;; i = 0)
        {
          locala.result = i;
          com.tencent.mm.sdk.b.a.IvT.l(localyv);
          WxCrossServices.report.reset();
          AppMethodBeat.o(170110);
          return;
        }
      }
    });
    AppMethodBeat.o(18285);
  }
  
  public static class MaybeCrashReport
  {
    public void judgeReport()
    {
      AppMethodBeat.i(193132);
      long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXq, Long.valueOf(0L))).longValue();
      if (l > 0L)
      {
        int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXr, Integer.valueOf(0))).intValue();
        com.tencent.mm.plugin.report.service.g.yxI.f(20560, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      }
      reset();
      AppMethodBeat.o(193132);
    }
    
    public void markEnterPay(int paramInt)
    {
      AppMethodBeat.i(193130);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXq, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXr, Integer.valueOf(paramInt));
      AppMethodBeat.o(193130);
    }
    
    public void reset()
    {
      AppMethodBeat.i(193131);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXq, Long.valueOf(0L));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXr, Integer.valueOf(0));
      AppMethodBeat.o(193131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices
 * JD-Core Version:    0.7.0.1
 */