package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXPayInsurance$Resp
  extends BaseResp
{
  public String wxOrderId;
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128168);
    super.fromBundle(paramBundle);
    this.wxOrderId = paramBundle.getString("_wxapi_pay_insourance_order_id");
    AppMethodBeat.o(128168);
  }
  
  public final int getType()
  {
    return 22;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128167);
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
    AppMethodBeat.o(128167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp
 * JD-Core Version:    0.7.0.1
 */