package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXInvoiceAuthInsert$Resp
  extends BaseResp
{
  public String wxOrderId;
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128161);
    super.fromBundle(paramBundle);
    this.wxOrderId = paramBundle.getString("_wxapi_invoice_auth_insert_order_id");
    AppMethodBeat.o(128161);
  }
  
  public final int getType()
  {
    return 20;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128160);
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
    AppMethodBeat.o(128160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp
 * JD-Core Version:    0.7.0.1
 */