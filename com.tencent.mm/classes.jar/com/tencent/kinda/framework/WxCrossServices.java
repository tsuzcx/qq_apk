package com.tencent.kinda.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.sns_cross.ISnsSceneService;
import com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback;
import com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;

public class WxCrossServices
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public static final int REPORT_IDKEY = 1004;
  public static final String TAG = "MicroMsg.WxCrossServices";
  private static final String TAG_SCAN_QR_CODE_PAY = "tag_scan_qrcode_pay";
  private c<k> appListener;
  private KindaCacheServiceImpl kindaCacheService;
  private p mDialogForScanPay;
  private boolean mInitFlag;
  private n netListener;
  
  static
  {
    AppMethodBeat.i(144263);
    System.loadLibrary("kinda_android");
    AppMethodBeat.o(144263);
  }
  
  public WxCrossServices()
  {
    AppMethodBeat.i(144249);
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.mInitFlag = false;
    this.appListener = new WxCrossServices.8(this);
    this.netListener = new WxCrossServices.9(this);
    AppMethodBeat.o(144249);
  }
  
  private void initIfNeed(Context paramContext)
  {
    AppMethodBeat.i(155664);
    KindaContext.init(paramContext);
    if (!this.mInitFlag)
    {
      a.ymk.b(this.appListener);
      g.RK().a(this.netListener);
      KindaApp.instance().onCreate();
      this.mInitFlag = true;
    }
    AppMethodBeat.o(155664);
  }
  
  public boolean TenPaySDKABTestKindaEnable()
  {
    AppMethodBeat.i(144262);
    com.tencent.mm.wallet_core.b.dRI();
    boolean bool = com.tencent.mm.wallet_core.b.dpQ();
    AppMethodBeat.o(144262);
    return bool;
  }
  
  public boolean canOpenKindaCashier(Context paramContext)
  {
    AppMethodBeat.i(144259);
    initIfNeed(paramContext);
    com.tencent.mm.wallet_core.b.dRI();
    if (!com.tencent.mm.wallet_core.b.dpQ())
    {
      AppMethodBeat.o(144259);
      return true;
    }
    if (KindaApp.appKinda().getIsPaying())
    {
      d.i("canOpenKindaCashier", "is paying");
      AppMethodBeat.o(144259);
      return false;
    }
    d.i("canOpenKindaCashier", "not paying");
    KindaApp.appKinda().stopUseCase("rootUseCase");
    AppMethodBeat.o(144259);
    return true;
  }
  
  public Activity getCrossActivity()
  {
    AppMethodBeat.i(144251);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    AppMethodBeat.o(144251);
    return localActivity;
  }
  
  public boolean kindaCacheServiceGetBool(String paramString)
  {
    AppMethodBeat.i(144261);
    if (f.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(144261);
      return true;
    }
    if (this.kindaCacheService != null)
    {
      boolean bool = this.kindaCacheService.getBool(paramString);
      d.i("MicroMsg.WxCrossServices", "kindaCacheServiceGetBool key: %s ret: %s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(144261);
      return bool;
    }
    AppMethodBeat.o(144261);
    return false;
  }
  
  public void kindaCacheServiceSetBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144260);
    if (this.kindaCacheService != null) {
      this.kindaCacheService.setBool(paramString, paramBoolean, 0L);
    }
    AppMethodBeat.o(144260);
  }
  
  public void startOfflinePay(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(144258);
    d.i("MicroMsg.WxCrossServices", "startOfflinePay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    paramContext = ITransmitKvData.create();
    paramContext.putString("req_key", paramString1);
    paramContext.putString("products_id", paramString2);
    paramContext.putString("prefer_bind_serial", paramString3);
    paramContext.putInt("payScene", 8);
    KindaApp.appKinda().startUseCase("offlinePay", paramContext, new WxCrossServices.7(this));
    AppMethodBeat.o(144258);
  }
  
  public void startSNSPay(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(144257);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 10L, 1L, false);
    d.i("MicroMsg.WxCrossServices", "startSNSPay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    ISnsSceneService localISnsSceneService = SnsSceneServiceFactory.createService(paramPayInfo.cCD);
    ISnsUseCaseCallback localISnsUseCaseCallback = SnsSceneServiceFactory.createCallback(paramPayInfo.cCD);
    localISnsSceneService.setData(paramContext, paramPayInfo);
    localISnsUseCaseCallback.setData(paramContext, paramPayInfo);
    KindaApp.appKinda().startUseCase("snsPay", localISnsSceneService.generateSnsUseCaseData(), localISnsUseCaseCallback);
    AppMethodBeat.o(144257);
  }
  
  public void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(144256);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 13L, 1L, false);
    d.i("MicroMsg.WxCrossServices", "startScanQRCodePay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putInt("m_A8keyScene", paramInt1);
    localITransmitKvData.putString("qrCodeUrl", paramString);
    localITransmitKvData.putInt("payChannel", paramInt2);
    localITransmitKvData.putInt("payScene", 1);
    if (this.mDialogForScanPay != null) {
      this.mDialogForScanPay.dismiss();
    }
    paramContext.getString(2131296919);
    this.mDialogForScanPay = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131305479), false, new WxCrossServices.5(this));
    d.d("tag_scan_qrcode_pay", "扫码支付打开正在加载进度框。");
    KindaApp.appKinda().startUseCase("scanQRCodePay", localITransmitKvData, new WxCrossServices.6(this));
    AppMethodBeat.o(144256);
  }
  
  public void startWxpayAppPay(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(144252);
    d.i("MicroMsg.WxCrossServices", "startWxpayAppPay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 11L, 1L, false);
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
    paramBundle.putInt("payScene", 2);
    KindaApp.appKinda().startUseCase("appPay", paramBundle, new WxCrossServices.1(this, paramContext));
    AppMethodBeat.o(144252);
  }
  
  public void startWxpayH5Pay(final Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(144254);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 14L, 1L, false);
    d.i("MicroMsg.WxCrossServices", "startWxpayH5Pay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
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
        AppMethodBeat.i(144241);
        if ((paramContext instanceof OrderHandlerUI)) {
          ((OrderHandlerUI)paramContext).finish();
        }
        AppMethodBeat.o(144241);
      }
    });
    AppMethodBeat.o(144254);
  }
  
  public void startWxpayJsApiPay(Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt)
  {
    AppMethodBeat.i(144253);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 12L, 1L, false);
    d.i("MicroMsg.WxCrossServices", "startWxpayJsApiPay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    paramContext = ITransmitKvData.create();
    paramContext.putString("appid", paramWalletJsapiData.appId);
    paramContext.putString("package", paramWalletJsapiData.packageExt);
    paramContext.putString("signType", paramWalletJsapiData.signType);
    paramContext.putString("timeStamp", paramWalletJsapiData.timeStamp);
    paramContext.putString("paySign", paramWalletJsapiData.cCB);
    paramContext.putString("nonce_str", paramWalletJsapiData.nonceStr);
    paramContext.putString("stepInAppUserName", paramWalletJsapiData.cCC);
    paramContext.putString("stepInURL", paramWalletJsapiData.url);
    paramContext.putInt("payChannel", paramWalletJsapiData.cqj);
    paramContext.putInt("payScene", paramWalletJsapiData.cCD);
    paramContext.putInt("weappEnterScene", paramWalletJsapiData.wgH);
    paramContext.putString("weappPayCookies", paramWalletJsapiData.flC);
    paramWalletJsapiData = new KindaJSEvent();
    paramWalletJsapiData.setType(KindaJSEventType.WEB);
    paramContext.putJSEvent("JSEvent", paramWalletJsapiData);
    KindaApp.appKinda().startUseCase("jsapiPay", paramContext, new WxCrossServices.2(this, paramWalletJsapiData, parama, paramInt));
    AppMethodBeat.o(144253);
  }
  
  public void startWxpayQueryCashierPay(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(144255);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1004L, 14L, 15L, false);
    d.i("MicroMsg.WxCrossServices", "startWxpayQueryCashierPay %s", new Object[] { bo.dtY() });
    initIfNeed(paramContext);
    paramContext = ITransmitKvData.create();
    paramContext.putString("req_key", paramString);
    paramContext.putInt("payScene", paramInt);
    KindaApp.appKinda().startUseCase("queryCashierPay", paramContext, new WxCrossServices.4(this));
    AppMethodBeat.o(144255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices
 * JD-Core Version:    0.7.0.1
 */