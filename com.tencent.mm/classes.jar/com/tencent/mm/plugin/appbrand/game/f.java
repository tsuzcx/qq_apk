package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.c;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.l;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
  implements com.tencent.mm.plugin.appbrand.i.f
{
  private g fZY;
  private boolean vF = false;
  
  public f(String paramString, g paramg)
  {
    i locali = i.gad;
    y.i("MicroMsg.V8JsVmManager", "lm:GameRenderer.initJsVmContext ThreadName = [%s]", new Object[] { Thread.currentThread().getName() });
    if (locali.gae != null) {
      throw new IllegalStateException("Init JsVm Context second time");
    }
    int i = locali.gaf.addAndGet(1);
    y.i("MicroMsg.V8JsVmManager", "hy: GameRenderer.initJsVmContext new WAGameJsContextImpl");
    locali.gae = new e(true, new c(paramString, com.tencent.mm.plugin.appbrand.u.d.wC("wxa_library/v8_snapshot.bin"), i), i);
    y.i("MicroMsg.V8JsVmManager", "hy: GameRenderer.initJsVmContext new WAGameJsContextImpl finished");
    locali.gag.put(Integer.valueOf(i), locali.gae);
    y.i("MicroMsg.V8JsVmManager", "hy: GameRenderer.initJsVmContext finished");
    this.fZY = paramg;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.i.g> T I(Class<T> paramClass)
  {
    Object localObject;
    if ((paramClass.equals(l.class)) || (paramClass.equals(h.class)) || (paramClass.equals(com.tencent.mm.plugin.appbrand.i.i.class))) {
      localObject = i.gad;
    }
    do
    {
      return localObject;
      localObject = this;
    } while (paramClass.isInstance(this));
    return null;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    e locale = i.gad.gae;
    if (locale == null) {
      throw new IllegalStateException("JsVmContext Not Initialized, main");
    }
    if ((paramString == null) || (paramString.isEmpty()))
    {
      y.e("WAGameJsEngine", "js script is null");
      throw new IllegalArgumentException("js script is null");
    }
    try
    {
      if (this.vF)
      {
        y.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + paramString);
        return;
      }
      locale.a(paramURL, paramString, paramValueCallback);
      return;
    }
    finally {}
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      a(paramURL, paramString3, paramValueCallback);
      return;
    }
    e locale = i.gad.gae;
    if (locale == null) {
      throw new IllegalStateException("JsVmContext Not Initialized, main");
    }
    try
    {
      if (this.vF)
      {
        y.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + paramString3);
        return;
      }
    }
    finally {}
    locale.a(paramURL, paramString1, paramString2, paramString3, paramValueCallback);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    e locale = i.gad.gae;
    if ((paramObject == null) || (paramString == null) || (paramString.isEmpty()))
    {
      y.w("WAGameJsEngine", "addJavaScriptInterface empty! : " + paramString);
      return;
    }
    if (locale == null)
    {
      y.w("WAGameJsEngine", "");
      return;
    }
    try
    {
      if (this.vF)
      {
        y.w("WAGameJsEngine", "addJavaScriptInterface mDestroyed. name : " + paramString);
        return;
      }
    }
    finally {}
    y.i("WAGameJsEngine", "addJavaScriptInterface name : " + paramString);
    locale.addJavascriptInterface(paramObject, paramString);
  }
  
  public final void destroy()
  {
    try
    {
      this.vF = true;
      return;
    }
    finally {}
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    e locale = i.gad.gae;
    if (locale == null) {
      throw new IllegalStateException("JsVmContext Not Initialized, main");
    }
    if ((paramString == null) || (paramString.isEmpty()))
    {
      y.e("WAGameJsEngine", "js script is null");
      throw new IllegalArgumentException("js script is null");
    }
    if (locale == null)
    {
      y.w("WAGameJsEngine", "WAGameJsEngine.evaluateJavaScriptImpl jsVmContext == null");
      return;
    }
    try
    {
      if (this.vF)
      {
        y.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + paramString);
        return;
      }
    }
    finally {}
    locale.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.i.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f
 * JD-Core Version:    0.7.0.1
 */