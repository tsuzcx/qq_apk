package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e
{
  public static abstract interface b
  {
    public abstract void C(ArrayList<IDKey> paramArrayList);
    
    public abstract void tM(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean Ee();
    
    public abstract void RW(String paramString);
    
    public abstract void RX(String paramString);
    
    public abstract void RY(String paramString);
    
    public abstract void X(JSONObject paramJSONObject);
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract boolean bpL();
    
    public abstract void bpM();
    
    public abstract boolean bpO();
    
    public abstract void cF(String paramString);
    
    public abstract String getAppId();
    
    public abstract String[] getJsApiReportArgs();
    
    public abstract z getPageView();
    
    public abstract e.b getReporter();
    
    public abstract MMWebView getWebView();
    
    public abstract boolean post(Runnable paramRunnable);
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void u(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e
 * JD-Core Version:    0.7.0.1
 */