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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp
 * JD-Core Version:    0.7.0.1
 */