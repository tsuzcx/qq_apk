package com.pay.api;

import com.pay.AndroidPay;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.network.model.APMpAns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APPayGameService
{
  public static final String ACCOUNT_TYPE_COMMON = "common";
  public static final String ACCOUNT_TYPE_SECURITY = "secrety";
  public static final int LOGINPLATFORM_MOBILEQQ = 2;
  public static final int LOGINPLATFORM_WECHAT = 1;
  public static final String PAY_CHANNEL_BANK = "bank";
  public static final String PAY_CHANNEL_WECHAT = "wechat";
  private static IAPMidasPayCallBack midasCallBack;
  private static IAPPayGameServiceCallBack serviceDelegate;
  
  static
  {
    AppMethodBeat.i(207628);
    serviceDelegate = null;
    midasCallBack = new IAPMidasPayCallBack()
    {
      public final void MidasPayCallBack(APMidasResponse paramAnonymousAPMidasResponse)
      {
        AppMethodBeat.i(207477);
        APPayResponseInfo localAPPayResponseInfo;
        if (APPayGameService.serviceDelegate != null) {
          localAPPayResponseInfo = new APPayResponseInfo();
        }
        try
        {
          APBeanUtil.copyProperties(paramAnonymousAPMidasResponse, localAPPayResponseInfo);
          APLog.i("midasCallBack", "MidasPayCallBack");
          APPayGameService.serviceDelegate.PayGameServiceCallBack(localAPPayResponseInfo);
          AppMethodBeat.o(207477);
          return;
        }
        catch (Exception paramAnonymousAPMidasResponse)
        {
          for (;;)
          {
            APLog.i("APPayGameService", "midas callBack copyProperties error:" + paramAnonymousAPMidasResponse.toString());
          }
        }
      }
      
      public final void MidasPayNeedLogin()
      {
        AppMethodBeat.i(207470);
        if (APPayGameService.serviceDelegate != null)
        {
          APLog.i("midasCallBack", "MidasPayNeedLogin");
          APPayGameService.serviceDelegate.PayGameNeedLogin();
        }
        AppMethodBeat.o(207470);
      }
    };
    AppMethodBeat.o(207628);
  }
  
  public static IAPPayGameServiceCallBack GetDelegate()
  {
    return serviceDelegate;
  }
  
  public static void LauchVmallView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(207493);
    paramString8 = new APMidasGoodsRequest();
    setCommParams(paramString8, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    paramString8.mallType = 2;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, paramString8, midasCallBack);
    AppMethodBeat.o(207493);
  }
  
  public static void LaunchGroupBuyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(207501);
    paramString8 = new APMidasGoodsRequest();
    setCommParams(paramString8, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    paramString8.mallType = 1;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, paramString8, midasCallBack);
    AppMethodBeat.o(207501);
  }
  
  public static void LaunchMPSaveCurrencyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    AppMethodBeat.i(207557);
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    setCommParams(localAPMidasGameRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGameRequest.acctType = paramString8;
    localAPMidasGameRequest.saveValue = paramString9;
    localAPMidasGameRequest.resId = paramInt;
    localAPMidasGameRequest.mpInfo.payChannel = paramString10;
    localAPMidasGameRequest.mpInfo.discountType = paramString11;
    localAPMidasGameRequest.mpInfo.discountUrl = paramString12;
    localAPMidasGameRequest.mpInfo.extras = paramString13;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGameRequest, midasCallBack);
    AppMethodBeat.o(207557);
  }
  
  public static void LaunchMPSaveGoodsView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    AppMethodBeat.i(207572);
    APMidasGoodsRequest localAPMidasGoodsRequest = new APMidasGoodsRequest();
    localAPMidasGoodsRequest.tokenType = 1;
    setCommParams(localAPMidasGoodsRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGoodsRequest.goodsTokenUrl = paramString8;
    localAPMidasGoodsRequest.resId = paramInt;
    localAPMidasGoodsRequest.mpInfo.payChannel = paramString9;
    localAPMidasGoodsRequest.mpInfo.discountType = paramString10;
    localAPMidasGoodsRequest.mpInfo.discountUrl = paramString11;
    localAPMidasGoodsRequest.mpInfo.extras = paramString12;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGoodsRequest, midasCallBack);
    AppMethodBeat.o(207572);
  }
  
  public static void LaunchMp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(207585);
    startMpNetWork(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "", paramIAPHttpAnsObserver);
    AppMethodBeat.o(207585);
  }
  
  public static void LaunchMp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(207591);
    startMpNetWork(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramIAPHttpAnsObserver);
    AppMethodBeat.o(207591);
  }
  
  public static void LaunchSaveCurrencyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(207534);
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    setCommParams(localAPMidasGameRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGameRequest.acctType = paramString8;
    localAPMidasGameRequest.saveValue = "";
    localAPMidasGameRequest.isCanChange = true;
    localAPMidasGameRequest.resId = paramInt;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGameRequest, midasCallBack);
    AppMethodBeat.o(207534);
  }
  
  public static void LaunchSaveCurrencyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    AppMethodBeat.i(207548);
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    setCommParams(localAPMidasGameRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGameRequest.acctType = paramString8;
    localAPMidasGameRequest.saveValue = "";
    localAPMidasGameRequest.isCanChange = true;
    localAPMidasGameRequest.resId = paramInt;
    localAPMidasGameRequest.mpInfo.drmInfo = paramString9;
    localAPMidasGameRequest.mpInfo.discoutId = paramString10;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGameRequest, midasCallBack);
    AppMethodBeat.o(207548);
  }
  
  public static void LaunchSaveCurrencyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207512);
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    setCommParams(localAPMidasGameRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGameRequest.acctType = paramString8;
    localAPMidasGameRequest.saveValue = paramString9;
    localAPMidasGameRequest.isCanChange = paramBoolean;
    localAPMidasGameRequest.resId = paramInt;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGameRequest, midasCallBack);
    AppMethodBeat.o(207512);
  }
  
  public static void LaunchSaveCurrencyView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, int paramInt, String paramString10, String paramString11)
  {
    AppMethodBeat.i(207522);
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    setCommParams(localAPMidasGameRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGameRequest.acctType = paramString8;
    localAPMidasGameRequest.saveValue = paramString9;
    localAPMidasGameRequest.isCanChange = paramBoolean;
    localAPMidasGameRequest.resId = paramInt;
    localAPMidasGameRequest.mpInfo.drmInfo = paramString10;
    localAPMidasGameRequest.mpInfo.discoutId = paramString11;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGameRequest, midasCallBack);
    AppMethodBeat.o(207522);
  }
  
  public static void LaunchSaveGoodsView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(207563);
    APMidasGoodsRequest localAPMidasGoodsRequest = new APMidasGoodsRequest();
    localAPMidasGoodsRequest.tokenType = 1;
    setCommParams(localAPMidasGoodsRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasGoodsRequest.goodsTokenUrl = paramString8;
    localAPMidasGoodsRequest.resId = paramInt;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasGoodsRequest, midasCallBack);
    AppMethodBeat.o(207563);
  }
  
  public static void LaunchSaveGoodsViewWithoutToken(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    AppMethodBeat.i(207580);
    paramString10 = new APMidasGoodsRequest();
    paramString10.tokenType = 2;
    setCommParams(paramString10, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    paramString10.prodcutId = paramString8;
    paramString10.saveValue = paramString9;
    paramString10.isCanChange = paramBoolean;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, paramString10, midasCallBack);
    AppMethodBeat.o(207580);
  }
  
  public static void SetDelegate(IAPPayGameServiceCallBack paramIAPPayGameServiceCallBack)
  {
    serviceDelegate = paramIAPPayGameServiceCallBack;
  }
  
  @Deprecated
  public static void SetNeedReloginInSDK(boolean paramBoolean) {}
  
  public static void release()
  {
    serviceDelegate = null;
  }
  
  @Deprecated
  public static void reportCrashApLog(Throwable paramThrowable) {}
  
  private static void setCommParams(APMidasBaseRequest paramAPMidasBaseRequest, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(207622);
    paramAPMidasBaseRequest.offerId = AndroidPay.singleton().offerId;
    paramAPMidasBaseRequest.openId = paramString1;
    paramAPMidasBaseRequest.openKey = paramString2;
    paramAPMidasBaseRequest.sessionId = paramString3;
    paramAPMidasBaseRequest.sessionType = paramString4;
    paramAPMidasBaseRequest.zoneId = paramString5;
    paramAPMidasBaseRequest.pf = paramString6;
    paramAPMidasBaseRequest.pfKey = paramString7;
    paramAPMidasBaseRequest.extendInfo.unit = AndroidPay.singleton().unit;
    paramAPMidasBaseRequest.extendInfo.isShowNum = AndroidPay.singleton().isShowNum;
    paramAPMidasBaseRequest.resData = AndroidPay.singleton().resdata;
    paramAPMidasBaseRequest.extendInfo.isShowListOtherNum = AndroidPay.singleton().isShowListOtherNum;
    AppMethodBeat.o(207622);
  }
  
  private static void startMpNetWork(final String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(207603);
    APMidasNetRequest localAPMidasNetRequest = new APMidasNetRequest();
    setCommParams(localAPMidasNetRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasNetRequest.reqType = APMidasNetRequest.NET_REQ_MP;
    if ((paramString8 != null) || ("".equals(paramString8))) {
      localAPMidasNetRequest.mpInfo.drmInfo = paramString8;
    }
    paramString1 = new APMpAns(APHttpHandle.getIntanceHandel(), paramIAPHttpAnsObserver, new HashMap(), APMidasNetRequest.NET_REQ_MP);
    APMidasPayAPI.launchNet(AndroidPay.singleton().fromActivity, localAPMidasNetRequest, new IAPMidasNetCallBack()
    {
      public final void MidasNetError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(207484);
        paramString1.resultCode = paramAnonymousInt;
        paramString1.resultMsg = paramAnonymousString2;
        this.val$observer.onError(paramString1);
        AppMethodBeat.o(207484);
      }
      
      public final void MidasNetFinish(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(207478);
        paramString1.onFinishAns(paramAnonymousString2.getBytes(), null);
        this.val$observer.onFinish(paramString1);
        AppMethodBeat.o(207478);
      }
      
      public final void MidasNetStop(String paramAnonymousString)
      {
        AppMethodBeat.i(207474);
        this.val$observer.onStop(paramString1);
        AppMethodBeat.o(207474);
      }
    });
    AppMethodBeat.o(207603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.api.APPayGameService
 * JD-Core Version:    0.7.0.1
 */