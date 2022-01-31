package com.tencent.luggage.webview.default_impl;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.luggage.d.k;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class a
  implements com.tencent.luggage.webview.a
{
  private DefaultWebView bFF;
  private Handler bFG;
  private k bzs;
  private Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(90930);
    this.bFG = new Handler(Looper.getMainLooper());
    this.mContext = paramContext;
    this.bFF = new DefaultWebView(paramContext);
    AppMethodBeat.o(90930);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(90931);
    parama = new a.1(this, parama);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      parama.run();
      AppMethodBeat.o(90931);
      return;
    }
    this.bFG.post(parama);
    AppMethodBeat.o(90931);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(90940);
    paramObject = new a.3(this, paramObject, paramString);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramObject.run();
      AppMethodBeat.o(90940);
      return;
    }
    this.bFG.post(paramObject);
    AppMethodBeat.o(90940);
  }
  
  public final void by(String paramString)
  {
    AppMethodBeat.i(90941);
    paramString = new a.4(this, paramString);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      AppMethodBeat.o(90941);
      return;
    }
    this.bFG.post(paramString);
    AppMethodBeat.o(90941);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(90938);
    boolean bool = this.bFF.canGoBack();
    AppMethodBeat.o(90938);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(90939);
    this.bFF.destroy();
    AppMethodBeat.o(90939);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public View getView()
  {
    return this.bFF;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(90937);
    this.bFF.goBack();
    AppMethodBeat.o(90937);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90935);
    this.bFF.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(90935);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(90933);
    paramString = new a.2(this, paramString);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramString.run();
      AppMethodBeat.o(90933);
      return;
    }
    this.bFG.post(paramString);
    AppMethodBeat.o(90933);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(90934);
    this.bFF.loadUrl(paramString, paramMap);
    AppMethodBeat.o(90934);
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(90932);
    if ((this.mContext instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)this.mContext).setBaseContext(paramContext);
    }
    AppMethodBeat.o(90932);
  }
  
  public void setWebCore(k paramk)
  {
    this.bzs = paramk;
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(90936);
    this.bFF.stopLoading();
    AppMethodBeat.o(90936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.a
 * JD-Core Version:    0.7.0.1
 */