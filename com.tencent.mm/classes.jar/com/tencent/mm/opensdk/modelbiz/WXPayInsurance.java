package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXPayInsurance
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String url;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3892);
      if (d.b(this.url))
      {
        Log.i("MicroMsg.SDK.WXPayInsurance.Req", "url should not be empty");
        AppMethodBeat.o(3892);
        return false;
      }
      if (this.url.length() > 10240)
      {
        Log.e("MicroMsg.SDK.WXPayInsurance.Req", "url must be in 10k");
        AppMethodBeat.o(3892);
        return false;
      }
      AppMethodBeat.o(3892);
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3894);
      super.fromBundle(paramBundle);
      this.url = paramBundle.getString("_wxapi_pay_insourance_req_url");
      AppMethodBeat.o(3894);
    }
    
    public final int getType()
    {
      return 22;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3893);
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_pay_insourance_req_url", this.url);
      AppMethodBeat.o(3893);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String wxOrderId;
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3863);
      super.fromBundle(paramBundle);
      this.wxOrderId = paramBundle.getString("_wxapi_pay_insourance_order_id");
      AppMethodBeat.o(3863);
    }
    
    public final int getType()
    {
      return 22;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3862);
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
      AppMethodBeat.o(3862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPayInsurance
 * JD-Core Version:    0.7.0.1
 */