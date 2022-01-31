package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXNontaxPay$Resp
  extends BaseResp
{
  public String wxOrderId;
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128222);
    super.fromBundle(paramBundle);
    this.wxOrderId = paramBundle.getString("_wxapi_nontax_pay_order_id");
    AppMethodBeat.o(128222);
  }
  
  public final int getType()
  {
    return 21;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128221);
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
    AppMethodBeat.o(128221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp
 * JD-Core Version:    0.7.0.1
 */