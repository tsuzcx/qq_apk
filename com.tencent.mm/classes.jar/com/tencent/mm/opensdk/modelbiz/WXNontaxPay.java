package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXNontaxPay
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXNontaxPay.Req";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String url;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3926);
      if (b.b(this.url))
      {
        Log.i("MicroMsg.SDK.WXNontaxPay.Req", "url should not be empty");
        AppMethodBeat.o(3926);
        return false;
      }
      if (this.url.length() > 10240)
      {
        Log.e("MicroMsg.SDK.WXNontaxPay.Req", "url must be in 10k");
        AppMethodBeat.o(3926);
        return false;
      }
      AppMethodBeat.o(3926);
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3928);
      super.fromBundle(paramBundle);
      this.url = paramBundle.getString("_wxapi_nontax_pay_req_url");
      AppMethodBeat.o(3928);
    }
    
    public final int getType()
    {
      return 21;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3927);
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_nontax_pay_req_url", this.url);
      AppMethodBeat.o(3927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXNontaxPay
 * JD-Core Version:    0.7.0.1
 */