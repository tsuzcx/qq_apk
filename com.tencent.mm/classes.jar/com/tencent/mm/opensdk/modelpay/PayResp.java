package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class PayResp
  extends BaseResp
{
  public String extData;
  public String prepayId;
  public String returnKey;
  
  public PayResp() {}
  
  public PayResp(Bundle paramBundle)
  {
    AppMethodBeat.i(3833);
    fromBundle(paramBundle);
    AppMethodBeat.o(3833);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3835);
    super.fromBundle(paramBundle);
    this.prepayId = paramBundle.getString("_wxapi_payresp_prepayid");
    this.returnKey = paramBundle.getString("_wxapi_payresp_returnkey");
    this.extData = paramBundle.getString("_wxapi_payresp_extdata");
    AppMethodBeat.o(3835);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3834);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payresp_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payresp_returnkey", this.returnKey);
    paramBundle.putString("_wxapi_payresp_extdata", this.extData);
    AppMethodBeat.o(3834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.PayResp
 * JD-Core Version:    0.7.0.1
 */