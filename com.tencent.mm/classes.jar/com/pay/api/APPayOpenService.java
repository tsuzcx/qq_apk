package com.pay.api;

import com.pay.AndroidPay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;

public class APPayOpenService
{
  private static IAPMidasPayCallBack midasCallBack;
  private static IAPPayOpenServiceCallBack serviceDelegate;
  
  static
  {
    AppMethodBeat.i(253889);
    serviceDelegate = null;
    midasCallBack = new IAPMidasPayCallBack()
    {
      public final void MidasPayCallBack(APMidasResponse paramAnonymousAPMidasResponse)
      {
        AppMethodBeat.i(253871);
        APPayResponseInfo localAPPayResponseInfo;
        if (APPayOpenService.serviceDelegate != null) {
          localAPPayResponseInfo = new APPayResponseInfo();
        }
        try
        {
          APBeanUtil.copyProperties(paramAnonymousAPMidasResponse, localAPPayResponseInfo);
          APPayOpenService.serviceDelegate.PayOpenServiceCallBack(localAPPayResponseInfo);
          AppMethodBeat.o(253871);
          return;
        }
        catch (Exception paramAnonymousAPMidasResponse)
        {
          for (;;)
          {
            APLog.i("APPayOpenService", "midasCallBack copyProperties error:" + paramAnonymousAPMidasResponse.toString());
          }
        }
      }
      
      public final void MidasPayNeedLogin()
      {
        AppMethodBeat.i(253868);
        if (APPayOpenService.serviceDelegate != null) {
          APPayOpenService.serviceDelegate.PayOpenServiceNeedLogin();
        }
        AppMethodBeat.o(253868);
      }
    };
    AppMethodBeat.o(253889);
  }
  
  public static IAPPayOpenServiceCallBack GetDelegate()
  {
    return serviceDelegate;
  }
  
  public static void LaunchOpenServiceView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10)
  {
    AppMethodBeat.i(253882);
    APMidasMonthRequest localAPMidasMonthRequest = new APMidasMonthRequest();
    setCommParams(localAPMidasMonthRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasMonthRequest.serviceCode = paramString8;
    localAPMidasMonthRequest.serviceName = paramString9;
    localAPMidasMonthRequest.resId = paramInt;
    localAPMidasMonthRequest.remark = paramString10;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasMonthRequest, midasCallBack);
    AppMethodBeat.o(253882);
  }
  
  public static void LaunchOpenServiceView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10, String paramString11, boolean paramBoolean, String paramString12)
  {
    AppMethodBeat.i(253884);
    APMidasSubscribeRequest localAPMidasSubscribeRequest = new APMidasSubscribeRequest();
    setCommParams(localAPMidasSubscribeRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasSubscribeRequest.serviceCode = paramString8;
    localAPMidasSubscribeRequest.serviceName = paramString9;
    localAPMidasSubscribeRequest.resId = paramInt;
    localAPMidasSubscribeRequest.saveValue = paramString10;
    localAPMidasSubscribeRequest.productId = paramString11;
    localAPMidasSubscribeRequest.isCanChange = paramBoolean;
    localAPMidasSubscribeRequest.remark = paramString12;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasSubscribeRequest, midasCallBack);
    AppMethodBeat.o(253884);
  }
  
  public static void LaunchOpenServiceView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10, boolean paramBoolean, String paramString11)
  {
    AppMethodBeat.i(253881);
    APMidasMonthRequest localAPMidasMonthRequest = new APMidasMonthRequest();
    setCommParams(localAPMidasMonthRequest, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localAPMidasMonthRequest.serviceCode = paramString8;
    localAPMidasMonthRequest.serviceName = paramString9;
    localAPMidasMonthRequest.resId = paramInt;
    localAPMidasMonthRequest.saveValue = paramString10;
    localAPMidasMonthRequest.isCanChange = paramBoolean;
    localAPMidasMonthRequest.remark = paramString11;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, localAPMidasMonthRequest, midasCallBack);
    AppMethodBeat.o(253881);
  }
  
  public static void LaunchOpenServiceView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt, String paramString10, boolean paramBoolean1, String paramString11, boolean paramBoolean2)
  {
    AppMethodBeat.i(253886);
    paramString10 = new APMidasMonthRequest();
    setCommParams(paramString10, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    paramString10.serviceCode = paramString8;
    paramString10.serviceName = paramString9;
    paramString10.resId = paramInt;
    paramString10.remark = paramString11;
    paramString10.autoPay = paramBoolean2;
    APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, paramString10, midasCallBack);
    AppMethodBeat.o(253886);
  }
  
  public static void SetDelegate(IAPPayOpenServiceCallBack paramIAPPayOpenServiceCallBack)
  {
    serviceDelegate = paramIAPPayOpenServiceCallBack;
  }
  
  @Deprecated
  public static void SetNeedReloginInSDK(boolean paramBoolean) {}
  
  public static void release()
  {
    serviceDelegate = null;
  }
  
  private static void setCommParams(APMidasBaseRequest paramAPMidasBaseRequest, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(253888);
    paramAPMidasBaseRequest.offerId = AndroidPay.singleton().offerId;
    paramAPMidasBaseRequest.openId = paramString1;
    paramAPMidasBaseRequest.openKey = paramString2;
    paramAPMidasBaseRequest.sessionId = paramString3;
    paramAPMidasBaseRequest.sessionType = paramString4;
    paramAPMidasBaseRequest.zoneId = paramString5;
    paramAPMidasBaseRequest.pf = paramString6;
    paramAPMidasBaseRequest.pfKey = paramString7;
    AppMethodBeat.o(253888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.pay.api.APPayOpenService
 * JD-Core Version:    0.7.0.1
 */