package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import org.json.JSONObject;

public final class e
{
  public static abstract interface b
  {
    public abstract boolean CC();
    
    public abstract void NO(String paramString);
    
    public abstract void NP(String paramString);
    
    public abstract void NQ(String paramString);
    
    public abstract void V(JSONObject paramJSONObject);
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract void bL(String paramString);
    
    public abstract boolean blq();
    
    public abstract void blr();
    
    public abstract boolean blt();
    
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.e
 * JD-Core Version:    0.7.0.1
 */