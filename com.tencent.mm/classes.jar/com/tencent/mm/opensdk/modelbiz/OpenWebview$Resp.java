package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class OpenWebview$Resp
  extends BaseResp
{
  public String result;
  
  public OpenWebview$Resp() {}
  
  public OpenWebview$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128164);
    fromBundle(paramBundle);
    AppMethodBeat.o(128164);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128165);
    super.fromBundle(paramBundle);
    this.result = paramBundle.getString("_wxapi_open_webview_result");
    AppMethodBeat.o(128165);
  }
  
  public int getType()
  {
    return 12;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128166);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_open_webview_result", this.result);
    AppMethodBeat.o(128166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp
 * JD-Core Version:    0.7.0.1
 */