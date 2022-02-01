package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXInvoiceAuthInsert
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String url;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3852);
      if (b.b(this.url))
      {
        Log.i("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url should not be empty");
        AppMethodBeat.o(3852);
        return false;
      }
      if (this.url.length() > 10240)
      {
        Log.e("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url must be in 10k");
        AppMethodBeat.o(3852);
        return false;
      }
      AppMethodBeat.o(3852);
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3854);
      super.fromBundle(paramBundle);
      this.url = paramBundle.getString("_wxapi_invoice_auth_insert_req_url");
      AppMethodBeat.o(3854);
    }
    
    public final int getType()
    {
      return 20;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3853);
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
      AppMethodBeat.o(3853);
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
      AppMethodBeat.i(3856);
      super.fromBundle(paramBundle);
      this.wxOrderId = paramBundle.getString("_wxapi_invoice_auth_insert_order_id");
      AppMethodBeat.o(3856);
    }
    
    public final int getType()
    {
      return 20;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3855);
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
      AppMethodBeat.o(3855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert
 * JD-Core Version:    0.7.0.1
 */