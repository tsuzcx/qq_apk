package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;

public class PayReq
  extends BaseReq
{
  private static final int EXTDATA_MAX_LENGTH = 1024;
  private static final String TAG = "MicroMsg.PaySdk.PayReq";
  public String appId;
  public String extData;
  public String nonceStr;
  public PayReq.Options options;
  public String packageValue;
  public String partnerId;
  public String prepayId;
  public String sign;
  public String signType;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128152);
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.partnerId == null) || (this.partnerId.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.prepayId == null) || (this.prepayId.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.nonceStr == null) || (this.nonceStr.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.timeStamp == null) || (this.timeStamp.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.packageValue == null) || (this.packageValue.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.sign == null) || (this.sign.length() == 0))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
      AppMethodBeat.o(128152);
      return false;
    }
    if ((this.extData != null) && (this.extData.length() > 1024))
    {
      Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, extData length too long");
      AppMethodBeat.o(128152);
      return false;
    }
    AppMethodBeat.o(128152);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128154);
    super.fromBundle(paramBundle);
    this.appId = a.b(paramBundle, "_wxapi_payreq_appid");
    this.partnerId = a.b(paramBundle, "_wxapi_payreq_partnerid");
    this.prepayId = a.b(paramBundle, "_wxapi_payreq_prepayid");
    this.nonceStr = a.b(paramBundle, "_wxapi_payreq_noncestr");
    this.timeStamp = a.b(paramBundle, "_wxapi_payreq_timestamp");
    this.packageValue = a.b(paramBundle, "_wxapi_payreq_packagevalue");
    this.sign = a.b(paramBundle, "_wxapi_payreq_sign");
    this.extData = a.b(paramBundle, "_wxapi_payreq_extdata");
    this.signType = a.b(paramBundle, "_wxapi_payreq_sign_type");
    this.options = new PayReq.Options();
    this.options.fromBundle(paramBundle);
    AppMethodBeat.o(128154);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128153);
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
    if (this.options != null) {
      this.options.toBundle(paramBundle);
    }
    AppMethodBeat.o(128153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.PayReq
 * JD-Core Version:    0.7.0.1
 */