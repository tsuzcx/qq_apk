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
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaa.a;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.l.a;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletIapUI;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.NetStatusUtil.CellInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.f;
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
  public static WxCrossServices.MaybeCrashReport report;
  private IListener<l> appListener;
  private q mDialogForScanPay;
  private boolean mInitFlag;
  private p netListener;
  
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
    this.appListener = new IListener()
    {
      public boolean callback(l paramAnonymousl)
      {
        AppMethodBeat.i(178755);
        if ((paramAnonymousl != null) && (paramAnonymousl.dCi != null))
        {
          if (!paramAnonymousl.dCi.isActive) {
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
    this.netListener = new p.a()
    {
      public void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(178757);
        com.tencent.mm.wallet_core.b.hgC();
        if ((!com.tencent.mm.wallet_core.b.b(b.a.rWd, true)) || (!WxCrossServices.this.mInitFlag) || (!KindaApp.appKinda().isInAnyUseCase()))
        {
          AppMethodBeat.o(178757);
          return;
        }
        ITransmitKvData localITransmitKvData = ITransmitKvData.create();
        Object localObject1 = MMApplicationContext.getContext();
        if (!NetStatusUtil.isConnected((Context)localObject1)) {
          localITransmitKvData.putString("type", "NON_NETWORK");
        }
        Object localObject2;
        Object localObject3;
        for (;;)
        {
          KindaApp.appKinda().networkChange(localITransmitKvData);
          AppMethodBeat.o(178757);
          return;
          if (!NetStatusUtil.isWifi((Context)localObject1)) {
            break;
          }
          localITransmitKvData.putString("type", "WIFI");
          localObject2 = NetStatusUtil.getWifiInfo((Context)localObject1);
          localObject1 = ((WifiInfo)localObject2).getSSID();
          localObject2 = ((WifiInfo)localObject2).getBSSID();
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject3 = new HashMap();
            ((Map)localObject3).put("ssid", localObject1);
            ((Map)localObject3).put("bssid", localObject2);
            localObject1 = com.tencent.mm.plugin.wallet_core.model.k.aZ((Map)localObject3);
            localITransmitKvData.putString("info", ((bf)localObject1).KEF);
            localITransmitKvData.putString("info_key", ((bf)localObject1).KEG);
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
          localObject3 = (NetStatusUtil.CellInfo)((List)localObject1).get(0);
          localObject1 = ((NetStatusUtil.CellInfo)localObject3).cellid;
          localObject2 = ((NetStatusUtil.CellInfo)localObject3).mcc;
          localObject3 = ((NetStatusUtil.CellInfo)localObject3).mnc;
          if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
            break;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("cellid", localObject1);
          localHashMap.put("mcc", localObject2);
          localHashMap.put("mnc", localObject3);
          localObject1 = com.tencent.mm.plugin.wallet_core.model.k.aZ(localHashMap);
          localITransmitKvData.putString("info", ((bf)localObject1).KEF);
          localITransmitKvData.putString("info_key", ((bf)localObject1).KEG);
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
    AppMethodBeat.o(18276);
  }
  
  private void initIfNeed()
  {
    AppMethodBeat.i(18278);
    tryLoadLibrary();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala != null)
    {
      Log.i("MicroMsg.WxCrossServices", "IFingerPrintMgr is not null");
      locala.dJV();
    }
    if (!this.mInitFlag)
    {
      EventCenter.instance.add(this.appListener);
      g.aAg().a(this.netListener);
      KindaApp.instance().onCreate();
      this.mInitFlag = true;
    }
    ActivityController.resetFlag();
    AppMethodBeat.o(18278);
  }
  
  public static void judgeReprot()
  {
    AppMethodBeat.i(214413);
    report.judgeReport();
    AppMethodBeat.o(214413);
  }
  
  private void preparePayDesk()
  {
    AppMethodBeat.i(18279);
    com.tencent.mm.plugin.wallet_core.model.k.aeJ(5);
    AppMethodBeat.o(18279);
  }
  
  public static void tryLoadLibrary()
  {
    AppMethodBeat.i(18277);
    if (KindaApp.isEnabled()) {
      com.tencent.mm.plugin.expansions.a.aoa("kinda_android");
    }
    AppMethodBeat.o(18277);
  }
  
  public boolean TenPaySDKABTestKindaEnable()
  {
    AppMethodBeat.i(18293);
    com.tencent.mm.wallet_core.b.hgC();
    boolean bool = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
    AppMethodBeat.o(18293);
    return bool;
  }
  
  public boolean canOpenKindaCashier(Context paramContext)
  {
    AppMethodBeat.i(18290);
    initIfNeed();
    com.tencent.mm.wallet_core.b.hgC();
    if (!com.tencent.mm.wallet_core.b.b(b.a.rWd, true))
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
  
  public boolean isSwitch2InWxAppPay(String paramString)
  {
    AppMethodBeat.i(214420);
    if (paramString == null)
    {
      Log.i("MicroMsg.WxCrossServices", "isSwitch2InWxAppPay prepayId is null");
      AppMethodBeat.o(214420);
      return false;
    }
    if (paramString.startsWith("ts_"))
    {
      AppMethodBeat.o(214420);
      return false;
    }
    AppMethodBeat.o(214420);
    return true;
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 16L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startBindCardUseCase %s", new Object[] { Util.getStack() });
    initIfNeed();
    if (paramBundle.getInt("key_bind_scene", -1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int j = paramBundle.getInt("reg_flag", -1);
      int i = j;
      if (j == -1) {
        i = com.tencent.mm.plugin.wallet_core.model.t.fQD().fRN().field_is_reg;
      }
      if (paramBundle.getInt("key_bind_scene") == 8) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRt()) {}
        for (j = 2;; j = 1)
        {
          paramContext = com.tencent.mm.plugin.wallet_core.model.t.fQI().getTrueName();
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
            localITransmitKvData.putString("rn_true_name", paramContext.HTZ);
            localITransmitKvData.putString("rn_cre_type", paramContext.HUc);
            localITransmitKvData.putString("rn_cre_name", paramContext.HUd);
            localITransmitKvData.putString("rn_identify_card_origin", paramContext.HUa);
            localITransmitKvData.putString("rn_encry_identity_card", paramContext.HUb);
            localITransmitKvData.putInt("rn_creid_renewal_origin", paramContext.HUj);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_year", paramContext.HUl);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_month", paramContext.HUm);
            localITransmitKvData.putInt("rn_cre_expire_date_origin_day", paramContext.HUn);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_year", paramContext.HUx);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_month", paramContext.HUy);
            localITransmitKvData.putInt("rn_cre_effect_date_origin_day", paramContext.HUz);
            localITransmitKvData.putInt("rn_birth_date_origin_year", paramContext.HUp);
            localITransmitKvData.putInt("rn_birth_date_origin_month", paramContext.HUq);
            localITransmitKvData.putInt("rn_birth_date_origin_day", paramContext.HUr);
            localITransmitKvData.putString("rn_country", paramContext.HUf);
            localITransmitKvData.putString("rn_province", paramContext.HUg);
            localITransmitKvData.putString("rn_city", paramContext.HUh);
            localITransmitKvData.putString("rn_areaStr", paramContext.HUi);
            localITransmitKvData.putString("rn_profession_type", paramContext.HUe.HTY);
            localITransmitKvData.putString("rn_profession_name", paramContext.HUe.HTX);
            localITransmitKvData.putString("rn_iso_country_code", paramContext.HUs);
            localITransmitKvData.putInt("rn_sex", paramContext.fuA);
            localITransmitKvData.putString("rn_detail_address", paramContext.HUv);
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
              Log.i("MicroMsg.WxCrossServices", "startBindCardUseCase callback");
              lj locallj = new lj();
              if (paramAnonymousITransmitKvData.getInt("retcode") == 1)
              {
                locallj.dQz.dQA = true;
                locallj.dQz.dQm = paramAnonymousITransmitKvData.getString("bind_serial");
                locallj.dQz.dQC = paramAnonymousITransmitKvData.getString("password");
                locallj.dQz.dQl = paramAnonymousITransmitKvData.getString("bank_type");
                locallj.dQz.dQD = paramAnonymousITransmitKvData.getString("mobile_no");
                locallj.dQz.dQE = paramAnonymousITransmitKvData.getString("realname_title");
                locallj.dQz.dQF = paramAnonymousITransmitKvData.getString("realname_desc");
                locallj.dQz.dQG = paramAnonymousITransmitKvData.getString("realname_btn_title");
                locallj.dQz.dQH = paramAnonymousITransmitKvData.getString("realname_err_jump_page");
              }
              for (;;)
              {
                locallj.dQz.dQB = paramBundle.getBoolean("key_need_bind_response", false);
                EventCenter.instance.publish(locallj);
                AppMethodBeat.o(178758);
                return;
                if (paramAnonymousITransmitKvData.getInt("retcode") == -1) {
                  locallj.dQz.dQA = false;
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
    AppMethodBeat.i(214418);
    Log.i("MicroMsg.WxCrossServices", "start startFastBindUseCase");
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("qr_code", paramString);
    localITransmitKvData.putInt("channel", paramInt);
    KindaApp.appKinda().startUseCase("fastbindcard", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214406);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(214406);
      }
    });
    AppMethodBeat.o(214418);
  }
  
  public void startInWxAppPayUseCase(final Context paramContext, final String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214421);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 19L, 1L, false);
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
    if ((paramContext instanceof EmojiStoreV2RewardUI)) {
      localITransmitKvData.putString("succ_tip", paramContext.getString(2131764551));
    }
    KindaApp.appKinda().startUseCase("inWxAppPay", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214407);
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
          if (((WalletLqtSaveFetchUI)localObject4).HAM != null)
          {
            paramAnonymousITransmitKvData = ((WalletLqtSaveFetchUI)localObject4).HAM;
            localObject4 = ((WalletLqtSaveFetchUI)localObject4).HBx;
            if (((String)localObject1).equalsIgnoreCase("ok"))
            {
              Log.i("MicroMsg.LqtSaveFetchLogic", "%s onKindaInWxAppPayCallback, doQueryPurchaseResult, accountType: %s, reqkey: %s", new Object[] { Integer.valueOf(paramAnonymousITransmitKvData.hashCode()), Integer.valueOf(paramAnonymousITransmitKvData.accountType), localObject3 });
              paramAnonymousITransmitKvData.dDM = ((String)localObject2);
              localObject1 = (String)paramAnonymousITransmitKvData.HuG.get(localObject3);
              if (!Util.isNullOrNil((String)localObject1)) {
                paramAnonymousITransmitKvData.HuA = ((String)localObject1);
              }
              if ((paramAnonymousITransmitKvData.Huz instanceof WalletLqtSaveFetchUI))
              {
                ((WalletLqtSaveFetchUI)paramAnonymousITransmitKvData.Huz).xQ(true);
                ((WalletLqtSaveFetchUI)paramAnonymousITransmitKvData.Huz).fNV();
              }
              paramAnonymousITransmitKvData.fW((String)localObject4, 0);
            }
          }
        }
        for (;;)
        {
          WxCrossServices.report.reset();
          AppMethodBeat.o(214407);
          return;
          if ((paramContext instanceof EmojiStoreV2RewardUI))
          {
            paramAnonymousITransmitKvData = paramAnonymousITransmitKvData.getString("result");
            localObject1 = (EmojiStoreV2RewardUI)paramContext;
            if (paramAnonymousITransmitKvData.equalsIgnoreCase("ok"))
            {
              ((EmojiStoreV2RewardUI)localObject1).cIf();
              com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).rcq, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rln), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rbG), Integer.valueOf(1) });
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 9L, 1L, false);
              ((EmojiStoreV2RewardUI)localObject1).lB(true);
              ((EmojiStoreV2RewardUI)localObject1).finish();
            }
            else if (paramAnonymousITransmitKvData.equalsIgnoreCase("cancel"))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).rcq, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rln), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rbG), Integer.valueOf(3) });
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 3L, 1L, false);
            }
            else if (paramAnonymousITransmitKvData.equalsIgnoreCase("fail"))
            {
              if (!((EmojiStoreV2RewardUI)localObject1).rlA)
              {
                ((EmojiStoreV2RewardUI)localObject1).rlA = true;
                com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { ((EmojiStoreV2RewardUI)localObject1).rcq, Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rln), Integer.valueOf(((EmojiStoreV2RewardUI)localObject1).rbG), Integer.valueOf(2) });
              }
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(408L, 4L, 1L, false);
            }
          }
          else if ((paramContext instanceof WalletIapUI))
          {
            localObject1 = paramAnonymousITransmitKvData.getString("result");
            localObject2 = (WalletIapUI)paramContext;
            if (((WalletIapUI)localObject2).Isj != null) {
              break;
            }
            Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback mPurchaseFinishedListener is null");
          }
        }
        if (((String)localObject1).equalsIgnoreCase("ok")) {
          paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.c.c.cJ(0, "");
        }
        for (;;)
        {
          localObject3 = new com.tencent.mm.plugin.wallet_index.b.a.c(((WalletIapUI)localObject2).Irh.rcD, ((WalletIapUI)localObject2).Irh.Irm, ((WalletIapUI)localObject2).Irh.IqF, ((WalletIapUI)localObject2).Irh.IqG);
          ((WalletIapUI)localObject2).Isj.a(paramAnonymousITransmitKvData, (com.tencent.mm.plugin.wallet_index.b.a.c)localObject3);
          Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback result:%s iapResult:%s", new Object[] { localObject1, paramAnonymousITransmitKvData });
          break;
          if (((String)localObject1).equalsIgnoreCase("cancel")) {
            paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.c.c.cJ(1, "");
          } else {
            paramAnonymousITransmitKvData = com.tencent.mm.plugin.wallet_index.c.c.cJ(6, "");
          }
        }
      }
    });
    AppMethodBeat.o(214421);
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
    if (paramWalletJsapiData.KxP != null)
    {
      Iterator localIterator = paramWalletJsapiData.KxP.entrySet().iterator();
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
          parama.d(paramInt, i, paramAnonymousString);
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
    KindaApp.appKinda().startUseCase(paramWalletJsapiData.DWX, paramContext, null);
    AppMethodBeat.o(18296);
  }
  
  public void startLqtFixedDepositEntranceUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214414);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositEntranceUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositEntranceUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214403);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).bn(0, true);
        }
        AppMethodBeat.o(214403);
      }
    });
    AppMethodBeat.o(214414);
  }
  
  public void startLqtFixedDepositMakePlanUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214415);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositMakePlanUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositMakePlanUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214404);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).bn(0, true);
        }
        AppMethodBeat.o(214404);
      }
    });
    AppMethodBeat.o(214415);
  }
  
  public void startLqtFixedDepositPlanListUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214416);
    Log.i("MicroMsg.WxCrossServices", "start LqtFixedDepositPlanListUseCase");
    paramBundle = ITransmitKvData.create();
    KindaApp.appKinda().startUseCase("LQTFixedDepositPlanListUseCase", paramBundle, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214405);
        if (((paramContext instanceof WalletLqtDetailUI)) && (paramAnonymousITransmitKvData != null) && (paramAnonymousITransmitKvData.getInt("LQTMainPageShouldRefresh") == 1)) {
          ((WalletLqtDetailUI)paramContext).bn(0, true);
        }
        AppMethodBeat.o(214405);
      }
    });
    AppMethodBeat.o(214416);
  }
  
  public void startModifyPwdUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214417);
    Log.i("MicroMsg.WxCrossServices", "start startModifyPwdUseCase");
    paramContext = ITransmitKvData.create();
    paramBundle = new StringBuilder();
    g.aAf();
    paramContext.putString("sessionId", com.tencent.mm.kernel.a.ayV() + "_" + f.hhV());
    KindaApp.appKinda().startUseCase("modifyPwdUseCase", paramContext, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData) {}
    });
    AppMethodBeat.o(214417);
  }
  
  public void startOfflinePay(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(18288);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 18L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startOfflinePay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.flL();
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
        Log.i("MicroMsg.WxCrossServices", "startOfflinePay UseCaseCallback pay_result: ".concat(String.valueOf(bool)));
        aaa localaaa = new aaa();
        localaaa.egJ.result = 0;
        if (bool)
        {
          localaaa.egJ.result = -1;
          localaaa.egJ.intent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putInt("payScene", 8);
          localBundle.putString("pay_bind_serial", paramAnonymousITransmitKvData.getString("pay_bind_serial"));
          localaaa.egJ.intent.putExtras(localBundle);
        }
        EventCenter.instance.publish(localaaa);
        WxCrossServices.report.reset();
        AppMethodBeat.o(170111);
      }
    });
    AppMethodBeat.o(18288);
  }
  
  public void startOfflinePrePay(final Context paramContext, int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap)
  {
    AppMethodBeat.i(18289);
    Log.i("MicroMsg.WxCrossServices", "startOfflinePrePay %s", new Object[] { Util.getStack() });
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
  
  public boolean startOverseaWalletSuccPageUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214422);
    com.tencent.mm.wallet_core.b.hgC();
    if (!com.tencent.mm.wallet_core.b.b(b.a.rWf, false))
    {
      Log.i("MicroMsg.WxCrossServices", "startOverseaWalletSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
      AppMethodBeat.o(214422);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 20L, 1L, false);
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
    KindaApp.appKinda().startUseCase("overseaWalletSuccPage", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        int i = 0;
        AppMethodBeat.i(214408);
        if ((paramContext instanceof WalletMixOrderInfoUI))
        {
          Object localObject = paramAnonymousITransmitKvData.getString("result");
          boolean bool1 = paramAnonymousITransmitKvData.getBool("is_pending");
          boolean bool2 = paramAnonymousITransmitKvData.getBool("is_jsapi_close_page");
          paramAnonymousITransmitKvData = (WalletMixOrderInfoUI)paramContext;
          Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack begin, result=%s is_pending=%b is_jsapi_close_page=%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousITransmitKvData.Ihg = bool1;
          if (((String)localObject).equalsIgnoreCase("pre_succ"))
          {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack not handle pre_succ");
            AppMethodBeat.o(214408);
            return;
          }
          if (((String)localObject).equalsIgnoreCase("after_show_succ_page"))
          {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle after_show_succ_page, payScene=%d", new Object[] { Integer.valueOf(paramAnonymousITransmitKvData.efQ) });
            if (paramAnonymousITransmitKvData.efQ == 1)
            {
              WalletMixOrderInfoUI.aeS(-1);
              paramAnonymousITransmitKvData.setResult(-1);
              paramAnonymousITransmitKvData.finish();
              AppMethodBeat.o(214408);
            }
          }
          else if (((String)localObject).equalsIgnoreCase("ok"))
          {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle ok, payScene=%d prepayId=%s", new Object[] { Integer.valueOf(paramAnonymousITransmitKvData.efQ), paramAnonymousITransmitKvData.prepayId });
            if (paramAnonymousITransmitKvData.efQ == 2)
            {
              WalletMixOrderInfoUI.aeS(-1);
              if (!Util.isNullOrNil(paramAnonymousITransmitKvData.prepayId))
              {
                localObject = new aaa();
                Intent localIntent = new Intent();
                localIntent.putExtra("intent_pay_end", true);
                if (bool2) {
                  i = 1;
                }
                localIntent.putExtra("is_jsapi_close_page", i);
                ((aaa)localObject).egJ.intent = localIntent;
                ((aaa)localObject).egJ.dDL = paramAnonymousITransmitKvData.prepayId;
                ((aaa)localObject).egJ.result = -1;
                ((aaa)localObject).egJ.egM = 1;
                EventCenter.instance.publish((IEvent)localObject);
              }
              paramAnonymousITransmitKvData.setResult(-1);
              paramAnonymousITransmitKvData.finish();
              AppMethodBeat.o(214408);
            }
          }
          else
          {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle else, payScene=%d prepayId=%s", new Object[] { Integer.valueOf(paramAnonymousITransmitKvData.efQ), paramAnonymousITransmitKvData.prepayId });
            WalletMixOrderInfoUI.aeS(0);
            localObject = new aaa();
            ((aaa)localObject).egJ.dDL = paramAnonymousITransmitKvData.prepayId;
            ((aaa)localObject).egJ.result = 0;
            EventCenter.instance.publish((IEvent)localObject);
            paramAnonymousITransmitKvData.setResult(0);
            paramAnonymousITransmitKvData.finish();
          }
        }
        AppMethodBeat.o(214408);
      }
    });
    AppMethodBeat.o(214422);
    return true;
  }
  
  public boolean startPayIBGJsGetSuccPageUseCase(final Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(214423);
    com.tencent.mm.wallet_core.b.hgC();
    if (!com.tencent.mm.wallet_core.b.b(b.a.rWf, false))
    {
      Log.i("MicroMsg.WxCrossServices", "startPayIBGJsGetSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
      AppMethodBeat.o(214423);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 21L, 1L, false);
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
    KindaApp.appKinda().startUseCase("payIbgGetSuccPage", localITransmitKvData, new UseCaseCallback()
    {
      public void call(ITransmitKvData paramAnonymousITransmitKvData)
      {
        AppMethodBeat.i(214409);
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
          AppMethodBeat.o(214409);
          return;
          label76:
          if (str.equalsIgnoreCase("ok"))
          {
            if (!Util.isNullOrNil(paramAnonymousITransmitKvData))
            {
              Log.i("MicroMsg.WalletIbgOrderInfoUI", "hy: doing netscene subscribe...subscribe_username: %s", new Object[] { paramAnonymousITransmitKvData });
              g.aAi();
              g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(paramAnonymousITransmitKvData), 0);
            }
            localWalletIbgOrderInfoUI.setResult(-1);
          }
        }
      }
    });
    AppMethodBeat.o(214423);
    return true;
  }
  
  public void startResetPwdUseCase(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(170112);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 17L, 1L, false);
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 10L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startSNSPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.flL();
    report.markEnterPay(paramPayInfo.dVv);
    if (!((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(paramContext))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131767779), "", paramContext.getString(2131756920), new DialogInterface.OnClickListener()
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
    ISnsSceneService localISnsSceneService = SnsSceneServiceFactory.createService(paramPayInfo.dVv);
    ISnsUseCaseCallback localISnsUseCaseCallback = SnsSceneServiceFactory.createCallback(paramPayInfo.dVv);
    localISnsSceneService.setData(paramContext, paramPayInfo);
    localISnsUseCaseCallback.setData(paramContext, paramPayInfo);
    KindaApp.appKinda().startUseCase("snsPay", localISnsSceneService.generateSnsUseCaseData(), localISnsUseCaseCallback);
    AppMethodBeat.o(18287);
  }
  
  public void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(18286);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 13L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startScanQRCodePay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.flL();
    report.markEnterPay(1);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("m_A8keyScene", paramInt1);
    localITransmitKvData.putString("qrCodeUrl", paramString);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putInt("payScene", 1);
    if (this.mDialogForScanPay != null) {
      this.mDialogForScanPay.dismiss();
    }
    paramContext.getString(2131755797);
    this.mDialogForScanPay = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131768146), false, new DialogInterface.OnCancelListener()
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
        aaa localaaa = new aaa();
        localaaa.egJ.result = paramAnonymousITransmitKvData.getInt("scanQRCodeState");
        localaaa.egJ.egL = true;
        EventCenter.instance.publish(localaaa);
        WxCrossServices.report.reset();
        AppMethodBeat.o(18272);
      }
    });
    AppMethodBeat.o(18286);
  }
  
  public void startUseCase(String paramString, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(214419);
    Log.i("MicroMsg.WxCrossServices", "start common useCase");
    if (((paramObject1 instanceof ITransmitKvData)) && ((paramObject2 instanceof UseCaseCallback)))
    {
      KindaApp.appKinda().startUseCase(paramString, (ITransmitKvData)paramObject1, (UseCaseCallback)paramObject2);
      AppMethodBeat.o(214419);
      return;
    }
    Log.i("MicroMsg.WxCrossServices", "startUseCase fail, data or callback is not the right type");
    AppMethodBeat.o(214419);
  }
  
  public void startWalletBalanceFetchUseCase(final Context paramContext, final Bundle paramBundle)
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
        Log.i("MicroMsg.WxCrossServices", "startWalletBalanceFetchUseCase result：%s", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        default: 
          Log.i("MicroMsg.WxCrossServices", "startWalletBalanceFetch unknown result：%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(178760);
          return;
        case 1: 
          Object localObject = new Intent(paramContext, WalletBalanceManagerUI.class);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousITransmitKvData = paramContext;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousITransmitKvData.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousITransmitKvData, "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(178760);
          return;
        case 2: 
          AppMethodBeat.o(178760);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(16398, new Object[] { paramBundle.getString("reportSessionId"), Integer.valueOf(8), "", "" });
        AppMethodBeat.o(178760);
      }
    });
    AppMethodBeat.o(170113);
  }
  
  public void startWxpayAppPay(final Context paramContext, final Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18282);
    Log.i("MicroMsg.WxCrossServices", "startWxpayAppPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 11L, 1L, false);
    com.tencent.mm.plugin.soter.d.a.flL();
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
      Log.i("MicroMsg.WxCrossServices", "app url: %s", new Object[] { paramBundle });
      if (((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) {
        break;
      }
      Log.w("MicroMsg.WxCrossServices", "soter has not initialized, wait 1s");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 48);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(170102);
          Log.d("MicroMsg.WxCrossServices", "soter initialized: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) });
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 14L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayH5Pay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.flL();
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 12L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayJsApiPay %s", new Object[] { Util.getStack() });
    initIfNeed();
    preparePayDesk();
    com.tencent.mm.plugin.soter.d.a.flL();
    report.markEnterPay(paramWalletJsapiData.dVv);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("appid", paramWalletJsapiData.appId);
    localITransmitKvData.putString("package", paramWalletJsapiData.packageExt);
    localITransmitKvData.putString("signType", paramWalletJsapiData.signType);
    localITransmitKvData.putString("timeStamp", paramWalletJsapiData.timeStamp);
    localITransmitKvData.putString("paySign", paramWalletJsapiData.dVt);
    localITransmitKvData.putString("nonce_str", paramWalletJsapiData.nonceStr);
    localITransmitKvData.putString("stepInAppUserName", paramWalletJsapiData.dVu);
    localITransmitKvData.putString("stepInURL", paramWalletJsapiData.url);
    localITransmitKvData.putInt("payChannel", paramWalletJsapiData.payChannel);
    localITransmitKvData.putInt("payScene", paramWalletJsapiData.dVv);
    localITransmitKvData.putInt("weappEnterScene", paramWalletJsapiData.KxG);
    localITransmitKvData.putString("weappPayCookies", paramWalletJsapiData.iDk);
    localITransmitKvData.putString("adUxInfo", paramWalletJsapiData.KxO);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setIMMOnActivityResult(parama);
    localKindaJSEvent.setRequestCode(paramInt);
    localKindaJSEvent.setType(KindaJSEventType.WEB);
    localITransmitKvData.putJSEvent("JSEvent", localKindaJSEvent);
    if (paramWalletJsapiData.KxN) {}
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
              if (!com.tencent.matrix.trace.g.b.eP(str))
              {
                str = str.replaceAll("[^0-9\\.]", "");
                Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback totalFee after format is: ".concat(String.valueOf(str)));
                Intent localIntent = new Intent();
                localIntent.putExtra("key_total_fee", str);
                if ((!Util.isNullOrNil(paramAnonymousITransmitKvData.IrN)) && (paramAnonymousITransmitKvData.IrN.equalsIgnoreCase("key_from_scene_appbrandgame"))) {
                  paramAnonymousITransmitKvData.n(i, localIntent);
                }
              }
              if (((String)localObject).equals("pre_ok"))
              {
                Log.i("MicroMsg.WxCrossServices", "JsApiPay UseCaseCallback preSuccess!");
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
    }
  }
  
  public void startWxpayQueryCashierPay(String paramString, int paramInt)
  {
    AppMethodBeat.i(18285);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1004L, 15L, 1L, false);
    Log.i("MicroMsg.WxCrossServices", "startWxpayQueryCashierPay %s", new Object[] { Util.getStack() });
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
        aaa localaaa = new aaa();
        aaa.a locala = localaaa.egJ;
        if (paramAnonymousITransmitKvData.getString("result").equals("ok")) {}
        for (int i = -1;; i = 0)
        {
          locala.result = i;
          EventCenter.instance.publish(localaaa);
          WxCrossServices.report.reset();
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