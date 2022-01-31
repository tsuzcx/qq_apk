package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.j;
import java.net.URL;

public class ak
  implements ap
{
  ap iuy;
  
  public ak(ap paramap)
  {
    this.iuy = paramap;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(141816);
    this.iuy.a(paramURL, paramString, paramValueCallback);
    AppMethodBeat.o(141816);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(141817);
    this.iuy.a(paramURL, paramString1, paramString2, paramString3, paramValueCallback);
    AppMethodBeat.o(141817);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(141832);
    boolean bool = this.iuy.a(paramCanvas);
    AppMethodBeat.o(141832);
    return bool;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(141814);
    this.iuy.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(141814);
  }
  
  public void ap(Context paramContext)
  {
    AppMethodBeat.i(141803);
    this.iuy.ap(paramContext);
    AppMethodBeat.o(141803);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(141819);
    this.iuy.destroy();
    AppMethodBeat.o(141819);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(141815);
    this.iuy.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(141815);
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(141811);
    int i = this.iuy.getContentHeight();
    AppMethodBeat.o(141811);
    return i;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(141805);
    View localView = this.iuy.getContentView();
    AppMethodBeat.o(141805);
    return localView;
  }
  
  public d getFullscreenImpl()
  {
    AppMethodBeat.i(141829);
    d locald = this.iuy.getFullscreenImpl();
    AppMethodBeat.o(141829);
    return locald;
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(141810);
    int i = this.iuy.getHeight();
    AppMethodBeat.o(141810);
    return i;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(141808);
    String str = this.iuy.getUserAgentString();
    AppMethodBeat.o(141808);
    return str;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(141812);
    int i = this.iuy.getWebScrollX();
    AppMethodBeat.o(141812);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(141813);
    int i = this.iuy.getWebScrollY();
    AppMethodBeat.o(141813);
    return i;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(141809);
    int i = this.iuy.getWidth();
    AppMethodBeat.o(141809);
    return i;
  }
  
  public View getWrapperView()
  {
    AppMethodBeat.i(141804);
    View localView = this.iuy.getWrapperView();
    AppMethodBeat.o(141804);
    return localView;
  }
  
  public final void h(Runnable paramRunnable)
  {
    AppMethodBeat.i(141806);
    this.iuy.h(paramRunnable);
    AppMethodBeat.o(141806);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(141822);
    this.iuy.onBackground();
    AppMethodBeat.o(141822);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(141821);
    this.iuy.onForeground();
    AppMethodBeat.o(141821);
  }
  
  public final void q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(141827);
    this.iuy.q(paramInt, paramLong);
    AppMethodBeat.o(141827);
  }
  
  public void setFullscreenImpl(d paramd)
  {
    AppMethodBeat.i(141828);
    this.iuy.setFullscreenImpl(paramd);
    AppMethodBeat.o(141828);
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(141818);
    this.iuy.setJsExceptionHandler(paramh);
    AppMethodBeat.o(141818);
  }
  
  public void setOnScrollChangedListener(aj paramaj)
  {
    AppMethodBeat.i(141823);
    this.iuy.setOnScrollChangedListener(paramaj);
    AppMethodBeat.o(141823);
  }
  
  public void setOnTrimListener(ah paramah)
  {
    AppMethodBeat.i(141825);
    this.iuy.setOnTrimListener(paramah);
    AppMethodBeat.o(141825);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(141831);
    this.iuy.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(141831);
  }
  
  public void setWebViewLayoutListener(ag paramag)
  {
    AppMethodBeat.i(141824);
    this.iuy.setWebViewLayoutListener(paramag);
    AppMethodBeat.o(141824);
  }
  
  public final void t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141807);
    this.iuy.t(paramString1, paramString2);
    AppMethodBeat.o(141807);
  }
  
  public final <T extends j> T v(Class<T> paramClass)
  {
    AppMethodBeat.i(141820);
    if (paramClass.isInstance(this))
    {
      paramClass = (j)paramClass.cast(this);
      AppMethodBeat.o(141820);
      return paramClass;
    }
    if (paramClass.isInstance(this.iuy))
    {
      paramClass = (j)paramClass.cast(this.iuy);
      AppMethodBeat.o(141820);
      return paramClass;
    }
    paramClass = this.iuy.v(paramClass);
    AppMethodBeat.o(141820);
    return paramClass;
  }
  
  public final void vp()
  {
    AppMethodBeat.i(141826);
    this.iuy.vp();
    AppMethodBeat.o(141826);
  }
  
  public final boolean vq()
  {
    AppMethodBeat.i(141830);
    boolean bool = this.iuy.vq();
    AppMethodBeat.o(141830);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */