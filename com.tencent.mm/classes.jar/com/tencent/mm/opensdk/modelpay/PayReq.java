package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class PayReq
  extends BaseReq
{
  private static final int EXTDATA_MAX_LENGTH = 1024;
  private static final String TAG = "MicroMsg.PaySdk.PayReq";
  public String appId;
  public String extData;
  public String nonceStr;
  public Options options;
  public String packageValue;
  public String partnerId;
  public String prepayId;
  public String sign;
  public String signType;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3847);
    String str = this.appId;
    if ((str != null) && (str.length() != 0))
    {
      str = this.partnerId;
      if ((str != null) && (str.length() != 0))
      {
        str = this.prepayId;
        if ((str != null) && (str.length() != 0))
        {
          str = this.nonceStr;
          if ((str != null) && (str.length() != 0))
          {
            str = this.timeStamp;
            if ((str != null) && (str.length() != 0))
            {
              str = this.packageValue;
              if ((str != null) && (str.length() != 0))
              {
                str = this.sign;
                if ((str != null) && (str.length() != 0))
                {
                  str = this.extData;
                  if ((str != null) && (str.length() > 1024))
                  {
                    Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, extData length too long");
                    AppMethodBeat.o(3847);
                    return false;
                  }
                  AppMethodBeat.o(3847);
                  return true;
                }
                Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
                AppMethodBeat.o(3847);
                return false;
              }
              Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
              AppMethodBeat.o(3847);
              return false;
            }
            Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
            AppMethodBeat.o(3847);
            return false;
          }
          Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
          AppMethodBeat.o(3847);
          return false;
        }
        Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
        AppMethodBeat.o(3847);
        return false;
      }
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
      AppMethodBeat.o(3847);
      return false;
    }
    Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
    AppMethodBeat.o(3847);
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3849);
    super.fromBundle(paramBundle);
    this.appId = a.a(paramBundle, "_wxapi_payreq_appid");
    this.partnerId = a.a(paramBundle, "_wxapi_payreq_partnerid");
    this.prepayId = a.a(paramBundle, "_wxapi_payreq_prepayid");
    this.nonceStr = a.a(paramBundle, "_wxapi_payreq_noncestr");
    this.timeStamp = a.a(paramBundle, "_wxapi_payreq_timestamp");
    this.packageValue = a.a(paramBundle, "_wxapi_payreq_packagevalue");
    this.sign = a.a(paramBundle, "_wxapi_payreq_sign");
    this.extData = a.a(paramBundle, "_wxapi_payreq_extdata");
    this.signType = a.a(paramBundle, "_wxapi_payreq_sign_type");
    Options localOptions = new Options();
    this.options = localOptions;
    localOptions.fromBundle(paramBundle);
    AppMethodBeat.o(3849);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3848);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payreq_appid", this.appId);
    paramBundle.putString("_wxapi_payreq_partnerid", this.partnerId);
    paramBundle.putString("_wxapi_payreq_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
    paramBundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
    paramBundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
    paramBundle.putString("_wxapi_payreq_sign", this.sign);
    paramBundle.putString("_wxapi_payreq_extdata", this.extData);
    paramBundle.putString("_wxapi_payreq_sign_type", this.signType);
    Options localOptions = this.options;
    if (localOptions != null) {
      localOptions.toBundle(paramBundle);
    }
    AppMethodBeat.o(3848);
  }
  
  public static class Options
  {
    public static final int INVALID_FLAGS = -1;
    public String callbackClassName;
    public int callbackFlags;
    
    public Options()
    {
      AppMethodBeat.i(190399);
      this.callbackFlags = -1;
      AppMethodBeat.o(190399);
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      int j = -1;
      AppMethodBeat.i(3846);
      this.callbackClassName = a.a(paramBundle, "_wxapi_payoptions_callback_classname");
      int i = j;
      if (paramBundle != null) {}
      try
      {
        i = paramBundle.getInt("_wxapi_payoptions_callback_flags", -1);
        this.callbackFlags = i;
        AppMethodBeat.o(3846);
        return;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + paramBundle.getMessage());
          i = j;
        }
      }
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3845);
      paramBundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
      paramBundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
      AppMethodBeat.o(3845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.PayReq
 * JD-Core Version:    0.7.0.1
 */