package com.tencent.luggage.webview.default_impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.luggage.webview.a.a;
import java.util.Map;

public class a
  implements com.tencent.luggage.webview.a
{
  private DefaultWebView bjN;
  private Handler bjO = new Handler(Looper.getMainLooper());
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.bjN = new DefaultWebView(paramContext);
  }
  
  public final void a(final a.a parama)
  {
    parama = new Runnable()
    {
      public final void run()
      {
        a.a(a.this, parama);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      parama.run();
      return;
    }
    this.bjO.post(parama);
  }
  
  public final void aX(String paramString)
  {
    paramString = new a.4(this, paramString);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      return;
    }
    this.bjO.post(paramString);
  }
  
  public void addJavascriptInterface(final Object paramObject, final String paramString)
  {
    paramObject = new Runnable()
    {
      public final void run()
      {
        a.a(a.this).addJavascriptInterface(paramObject, paramString);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramObject.run();
      return;
    }
    this.bjO.post(paramObject);
  }
  
  public boolean canGoBack()
  {
    return this.bjN.canGoBack();
  }
  
  public void destroy()
  {
    this.bjN.destroy();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public View getView()
  {
    return this.bjN;
  }
  
  public void goBack()
  {
    this.bjN.goBack();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.bjN.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadUrl(String paramString)
  {
    paramString = new a.2(this, paramString);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      return;
    }
    this.bjO.post(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    this.bjN.loadUrl(paramString, paramMap);
  }
  
  public void stopLoading()
  {
    this.bjN.stopLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.a
 * JD-Core Version:    0.7.0.1
 */