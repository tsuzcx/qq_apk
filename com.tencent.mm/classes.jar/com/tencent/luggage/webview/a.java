package com.tencent.luggage.webview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.s;
import com.tencent.luggage.d.p;
import java.util.Map;

public abstract interface a
  extends s
{
  public abstract void a(a parama);
  
  public abstract boolean canGoBack();
  
  public abstract void destroy();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract View getView();
  
  public abstract void goBack();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void loadUrl(String paramString, Map<String, String> paramMap);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setWebCore(p paramp);
  
  public abstract void stopLoading();
  
  public static abstract interface a
  {
    public abstract WebResourceResponse a(WebResourceRequest paramWebResourceRequest, Bundle paramBundle);
    
    public abstract boolean cC(String paramString);
    
    public abstract void cD(String paramString);
    
    public abstract void cE(String paramString);
    
    public abstract WebResourceResponse cF(String paramString);
    
    public abstract String cG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.webview.a
 * JD-Core Version:    0.7.0.1
 */