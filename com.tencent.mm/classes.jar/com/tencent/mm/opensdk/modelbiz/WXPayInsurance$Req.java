package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXPayInsurance$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String url;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(128200);
    if (d.b(this.url))
    {
      Log.i("MicroMsg.SDK.WXPayInsurance.Req", "url should not be empty");
      AppMethodBeat.o(128200);
      return false;
    }
    if (this.url.length() > 10240)
    {
      Log.e("MicroMsg.SDK.WXPayInsurance.Req", "url must be in 10k");
      AppMethodBeat.o(128200);
      return false;
    }
    AppMethodBeat.o(128200);
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128202);
    super.fromBundle(paramBundle);
    this.url = paramBundle.getString("_wxapi_pay_insourance_req_url");
    AppMethodBeat.o(128202);
  }
  
  public final int getType()
  {
    return 22;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128201);
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_pay_insourance_req_url", this.url);
    AppMethodBeat.o(128201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req
 * JD-Core Version:    0.7.0.1
 */