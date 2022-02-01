package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class OpenWebview
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String url;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3910);
      if ((this.url == null) || (this.url.length() < 0))
      {
        AppMethodBeat.o(3910);
        return false;
      }
      if (this.url.length() > 10240)
      {
        AppMethodBeat.o(3910);
        return false;
      }
      AppMethodBeat.o(3910);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3911);
      super.fromBundle(paramBundle);
      this.url = paramBundle.getString("_wxapi_jump_to_webview_url");
      AppMethodBeat.o(3911);
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3912);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
      AppMethodBeat.o(3912);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String result;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3859);
      fromBundle(paramBundle);
      AppMethodBeat.o(3859);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3860);
      super.fromBundle(paramBundle);
      this.result = paramBundle.getString("_wxapi_open_webview_result");
      AppMethodBeat.o(3860);
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3861);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_open_webview_result", this.result);
      AppMethodBeat.o(3861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview
 * JD-Core Version:    0.7.0.1
 */