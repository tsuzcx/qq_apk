package com.tencent.mm.plugin.appbrand.jsapi.af;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e
{
  public static abstract interface b
  {
    public abstract void H(ArrayList<IDKey> paramArrayList);
    
    public abstract void xK(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean NA();
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract void abB(String paramString);
    
    public abstract void abC(String paramString);
    
    public abstract void abD(String paramString);
    
    public abstract void ah(JSONObject paramJSONObject);
    
    public abstract boolean bLr();
    
    public abstract void bLs();
    
    public abstract boolean bLu();
    
    public abstract void cW(String paramString);
    
    public abstract String getAppId();
    
    public abstract String[] getJsApiReportArgs();
    
    public abstract ac getPageView();
    
    public abstract e.b getReporter();
    
    public abstract MMWebView getWebView();
    
    public abstract boolean post(Runnable paramRunnable);
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void z(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.e
 * JD-Core Version:    0.7.0.1
 */