package com.tencent.luggage.webview.default_impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class a
  implements com.tencent.luggage.webview.a
{
  private DefaultWebView cDw;
  private p ctS;
  private Context mContext;
  private Handler mainThreadHandler;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(140543);
    this.mainThreadHandler = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    this.cDw = new DefaultWebView(paramContext);
    AppMethodBeat.o(140543);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(140544);
    parama = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140532);
        a.a(a.this, parama);
        AppMethodBeat.o(140532);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      parama.run();
      AppMethodBeat.o(140544);
      return;
    }
    this.mainThreadHandler.post(parama);
    AppMethodBeat.o(140544);
  }
  
  public void addJavascriptInterface(final Object paramObject, final String paramString)
  {
    AppMethodBeat.i(140553);
    paramObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140534);
        a.a(a.this).addJavascriptInterface(paramObject, paramString);
        AppMethodBeat.o(140534);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramObject.run();
      AppMethodBeat.o(140553);
      return;
    }
    this.mainThreadHandler.post(paramObject);
    AppMethodBeat.o(140553);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(140551);
    boolean bool = this.cDw.canGoBack();
    AppMethodBeat.o(140551);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(140552);
    this.cDw.destroy();
    AppMethodBeat.o(140552);
  }
  
  public void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(221211);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140535);
        a.a(a.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(140535);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      AppMethodBeat.o(221211);
      return;
    }
    this.mainThreadHandler.post(paramString);
    AppMethodBeat.o(221211);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    return "";
  }
  
  public View getView()
  {
    return this.cDw;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(140550);
    this.cDw.goBack();
    AppMethodBeat.o(140550);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140548);
    this.cDw.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(140548);
  }
  
  public void loadUrl(final String paramString)
  {
    AppMethodBeat.i(140546);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140533);
        a.a(a.this).loadUrl(paramString);
        AppMethodBeat.o(140533);
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      AppMethodBeat.o(140546);
      return;
    }
    this.mainThreadHandler.post(paramString);
    AppMethodBeat.o(140546);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(140547);
    this.cDw.loadUrl(paramString, paramMap);
    AppMethodBeat.o(140547);
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(140545);
    if ((this.mContext instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)this.mContext).setBaseContext(paramContext);
    }
    AppMethodBeat.o(140545);
  }
  
  public void setWebCore(p paramp)
  {
    this.ctS = paramp;
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(140549);
    this.cDw.stopLoading();
    AppMethodBeat.o(140549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.a
 * JD-Core Version:    0.7.0.1
 */