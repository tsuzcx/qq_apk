package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String appId;
    public String nonceStr;
    public String packageExt;
    public String signType;
    public String signature;
    public String timeStamp;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3850);
      if ((this.appId == null) || (this.appId.length() <= 0))
      {
        AppMethodBeat.o(3850);
        return false;
      }
      if ((this.timeStamp == null) || (this.timeStamp.length() <= 0))
      {
        AppMethodBeat.o(3850);
        return false;
      }
      if ((this.nonceStr == null) || (this.nonceStr.length() <= 0))
      {
        AppMethodBeat.o(3850);
        return false;
      }
      if ((this.signType == null) || (this.signType.length() <= 0))
      {
        AppMethodBeat.o(3850);
        return false;
      }
      if ((this.signature == null) || (this.signature.length() <= 0))
      {
        AppMethodBeat.o(3850);
        return false;
      }
      AppMethodBeat.o(3850);
      return true;
    }
    
    public int getType()
    {
      return 13;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3851);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
      paramBundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
      paramBundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
      paramBundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
      paramBundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
      paramBundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
      AppMethodBeat.o(3851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney
 * JD-Core Version:    0.7.0.1
 */