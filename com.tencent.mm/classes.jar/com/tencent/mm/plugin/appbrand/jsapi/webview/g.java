package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.content.Context;
import android.view.View;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract interface g
{
  public static abstract interface a
  {
    public abstract void ajy(String paramString);
    
    public abstract void cleanup();
    
    public abstract int getBinderID();
    
    public abstract void onBackground();
    
    public abstract void onForeground();
    
    public abstract void v(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Bi(int paramInt);
    
    public abstract void I(ArrayList<IDKey> paramArrayList);
  }
  
  public static abstract interface c
    extends e
  {
    public abstract void A(String paramString1, int paramInt, String paramString2);
    
    public abstract void PE();
    
    public abstract boolean Qv();
    
    public abstract void a(a parama);
    
    public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
    
    public abstract void aD(Context paramContext);
    
    public abstract void ajv(String paramString);
    
    public abstract void ajw(String paramString);
    
    public abstract void al(JSONObject paramJSONObject);
    
    public abstract boolean bXs();
    
    public abstract boolean bXt();
    
    public abstract void bXu();
    
    public abstract boolean bXw();
    
    public abstract void destroy();
    
    public abstract void dv(String paramString);
    
    public abstract void dw(String paramString);
    
    public abstract Context getAndroidContext();
    
    public abstract View getAndroidView();
    
    public abstract String getAppId();
    
    public abstract int getBinderID();
    
    public abstract g.a getController();
    
    public abstract String getCurrentUrl();
    
    public abstract String[] getJsApiReportArgs();
    
    public abstract ad getPageView();
    
    public abstract g.b getReporter();
    
    public abstract MMWebView getWebView();
    
    public abstract boolean post(Runnable paramRunnable);
    
    public abstract void runOnUiThread(Runnable paramRunnable);
    
    public abstract void setAndroidViewId(int paramInt);
    
    public abstract void setBackgroundColor(int paramInt);
    
    public abstract void setCoverViewId(int paramInt);
    
    public static abstract interface a
    {
      public abstract void bXz();
    }
  }
  
  public static final class d
    extends r
  {
    public static final int CTRL_INDEX = 505;
    public static final String NAME = "onWebviewFinishLoad";
  }
  
  public static final class e
    extends r
  {
    public static final int CTRL_INDEX = 504;
    public static final String NAME = "onWebviewStartLoad";
  }
  
  public static final class f
    extends r
  {
    public static final int CTRL_INDEX = 506;
    public static final String NAME = "onWebviewError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.g
 * JD-Core Version:    0.7.0.1
 */