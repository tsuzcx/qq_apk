package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e
{
  public static abstract interface b
  {
    public abstract void C(ArrayList<IDKey> paramArrayList);
    
    public abstract void tH(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract boolean Eb();
    
    public abstract void Rn(String paramString);
    
    public abstract void Ro(String paramString);
    
    public abstract void Rp(String paramString);
    
    public abstract void X(JSONObject paramJSONObject);
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract boolean bpb();
    
    public abstract void bpc();
    
    public abstract boolean bpe();
    
    public abstract void cE(String paramString);
    
    public abstract String getAppId();
    
    public abstract String[] getJsApiReportArgs();
    
    public abstract aa getPageView();
    
    public abstract e.b getReporter();
    
    public abstract MMWebView getWebView();
    
    public abstract boolean post(Runnable paramRunnable);
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void s(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.e
 * JD-Core Version:    0.7.0.1
 */