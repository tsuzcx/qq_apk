package com.pay;

import android.app.Activity;
import android.content.Context;
import com.pay.api.APPayResponseInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;

public class AndroidPay
{
  public static final int LANDSCAPE = 0;
  public static final int PORTRAINT = 1;
  private static volatile AndroidPay gInstance = null;
  public Context applicationContext;
  public Activity fromActivity;
  public boolean isShowListOtherNum;
  public boolean isShowNum;
  public String offerId;
  public APPayResponseInfo payResponseInfo;
  public byte[] resdata;
  public String unit;
  
  private AndroidPay()
  {
    AppMethodBeat.i(207532);
    this.applicationContext = null;
    this.payResponseInfo = null;
    this.unit = "";
    this.isShowNum = true;
    this.isShowListOtherNum = true;
    this.payResponseInfo = new APPayResponseInfo();
    AppMethodBeat.o(207532);
  }
  
  public static void Destory() {}
  
  public static String getPaySDKVersion(Activity paramActivity)
  {
    AppMethodBeat.i(207597);
    paramActivity = APMidasPayAPI.getMidasSDKVersion(paramActivity);
    AppMethodBeat.o(207597);
    return paramActivity;
  }
  
  public static void setCustomUrlParam(String paramString) {}
  
  public static void setElseNumberVisible(boolean paramBoolean)
  {
    gInstance.isShowListOtherNum = paramBoolean;
  }
  
  public static void setEnv(String paramString)
  {
    AppMethodBeat.i(207559);
    APMidasPayAPI.setEnv(paramString);
    AppMethodBeat.o(207559);
  }
  
  public static void setIsShowSaveNum(boolean paramBoolean)
  {
    gInstance.isShowNum = paramBoolean;
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(207566);
    APMidasPayAPI.setLogEnable(paramBoolean);
    AppMethodBeat.o(207566);
  }
  
  public static void setNumberVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(207570);
    setIsShowSaveNum(paramBoolean);
    AppMethodBeat.o(207570);
  }
  
  public static void setOfferId(String paramString)
  {
    gInstance.offerId = paramString;
  }
  
  public static void setPropUnit(String paramString)
  {
    gInstance.unit = paramString;
  }
  
  public static void setResData(byte[] paramArrayOfByte)
  {
    gInstance.resdata = paramArrayOfByte;
  }
  
  public static void setScreenType(int paramInt) {}
  
  public static void setWechatAppId(String paramString) {}
  
  public static AndroidPay singleton()
  {
    AppMethodBeat.i(207541);
    if (gInstance == null) {}
    try
    {
      if (gInstance == null) {
        gInstance = new AndroidPay();
      }
      AndroidPay localAndroidPay = gInstance;
      AppMethodBeat.o(207541);
      return localAndroidPay;
    }
    finally
    {
      AppMethodBeat.o(207541);
    }
  }
  
  public Context getContext()
  {
    return this.applicationContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.AndroidPay
 * JD-Core Version:    0.7.0.1
 */