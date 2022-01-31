package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class OpenWebview$Req
  extends BaseReq
{
  private static final int MAX_URL_LENGHT = 10240;
  public String url;
  
  public boolean checkArgs()
  {
    if ((this.url == null) || (this.url.length() < 0)) {}
    while (this.url.length() > 10240) {
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.url = paramBundle.getString("_wxapi_jump_to_webview_url");
  }
  
  public int getType()
  {
    return 12;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview.Req
 * JD-Core Version:    0.7.0.1
 */