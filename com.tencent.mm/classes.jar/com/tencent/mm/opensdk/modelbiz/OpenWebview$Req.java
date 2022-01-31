package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class OpenWebview$Req
  extends BaseReq
{
  private static final int MAX_URL_LENGHT = 10240;
  public String url;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128218);
    if ((this.url == null) || (this.url.length() < 0))
    {
      AppMethodBeat.o(128218);
      return false;
    }
    if (this.url.length() > 10240)
    {
      AppMethodBeat.o(128218);
      return false;
    }
    AppMethodBeat.o(128218);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128219);
    super.fromBundle(paramBundle);
    this.url = paramBundle.getString("_wxapi_jump_to_webview_url");
    AppMethodBeat.o(128219);
  }
  
  public int getType()
  {
    return 12;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128220);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
    AppMethodBeat.o(128220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview.Req
 * JD-Core Version:    0.7.0.1
 */