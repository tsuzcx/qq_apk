package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import org.json.JSONObject;

public final class e
{
  public static abstract interface b
  {
    public abstract boolean CZ();
    
    public abstract void JH(String paramString);
    
    public abstract void JI(String paramString);
    
    public abstract void JJ(String paramString);
    
    public abstract void V(JSONObject paramJSONObject);
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract void bV(String paramString);
    
    public abstract boolean bew();
    
    public abstract void bex();
    
    public abstract boolean bez();
    
    public abstract String getAppId();
    
    public abstract String[] getJsApiReportArgs();
    
    public abstract aa getPageView();
    
    public abstract MMWebView getWebView();
    
    public abstract boolean post(Runnable paramRunnable);
    
    public abstract void r(String paramString1, int paramInt, String paramString2);
    
    public abstract void runOnUiThread(Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e
 * JD-Core Version:    0.7.0.1
 */