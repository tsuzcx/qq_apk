package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXOpenBusinessWebview$Resp
  extends BaseResp
{
  public int businessType;
  public String resultInfo;
  
  public WXOpenBusinessWebview$Resp() {}
  
  public WXOpenBusinessWebview$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3895);
    fromBundle(paramBundle);
    AppMethodBeat.o(3895);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3896);
    super.fromBundle(paramBundle);
    this.resultInfo = paramBundle.getString("_wxapi_open_business_webview_result");
    this.businessType = paramBundle.getInt("_wxapi_open_business_webview_query_type", 0);
    AppMethodBeat.o(3896);
  }
  
  public int getType()
  {
    return 25;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3897);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_open_business_webview_result", this.resultInfo);
    paramBundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
    AppMethodBeat.o(3897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp
 * JD-Core Version:    0.7.0.1
 */