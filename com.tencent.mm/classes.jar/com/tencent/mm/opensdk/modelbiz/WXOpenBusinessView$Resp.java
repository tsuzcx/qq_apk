package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXOpenBusinessView$Resp
  extends BaseResp
{
  public String businessType;
  public String extMsg;
  
  public WXOpenBusinessView$Resp() {}
  
  public WXOpenBusinessView$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3898);
    fromBundle(paramBundle);
    AppMethodBeat.o(3898);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3899);
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_openbusinessview_ext_msg");
    this.businessType = paramBundle.getString("_openbusinessview_business_type");
    AppMethodBeat.o(3899);
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3900);
    super.toBundle(paramBundle);
    paramBundle.putString("_openbusinessview_ext_msg", this.extMsg);
    paramBundle.putString("_openbusinessview_business_type", this.businessType);
    AppMethodBeat.o(3900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp
 * JD-Core Version:    0.7.0.1
 */