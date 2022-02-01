package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import org.json.JSONObject;

public abstract interface g$c
  extends e
{
  public abstract void C(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(g.c.a parama);
  
  public abstract void a(String paramString, WebResourceRequest paramWebResourceRequest);
  
  public abstract void acw(String paramString);
  
  public abstract void acx(String paramString);
  
  public abstract void apO();
  
  public abstract boolean aqJ();
  
  public abstract void av(JSONObject paramJSONObject);
  
  public abstract void bm(Context paramContext);
  
  public abstract boolean cxE();
  
  public abstract boolean cxF();
  
  public abstract void cxG();
  
  public abstract boolean cxI();
  
  public abstract void destroy();
  
  public abstract void eG(String paramString);
  
  public abstract void eH(String paramString);
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.g.c
 * JD-Core Version:    0.7.0.1
 */