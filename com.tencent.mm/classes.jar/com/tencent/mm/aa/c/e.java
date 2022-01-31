package com.tencent.mm.aa.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  public volatile boolean ahC;
  public String dIX;
  public c dIY;
  public f dIZ;
  public com.tencent.mm.aa.b.d dJa;
  private volatile boolean dJb;
  public e.a dJc;
  
  public final void CE()
  {
    if (this.dJb) {}
    do
    {
      return;
      y.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.dIX });
      this.dJb = true;
      this.dJa.pause();
    } while (this.dJc == null);
    this.dJc.D(this.dIX, 3);
  }
  
  public final void CF()
  {
    if (!this.dJb) {}
    do
    {
      return;
      y.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.dIX });
      this.dJa.resume();
      this.dJb = false;
    } while (this.dJc == null);
    this.dJc.D(this.dIX, 2);
  }
  
  public final boolean a(com.tencent.mm.aa.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    f localf = this.dIZ;
    Object localObject = localf.dJd.fO(paramc.name);
    if (localObject == null)
    {
      y.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      return false;
    }
    if (!localf.dIP.hi(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      y.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      return false;
    }
    localObject = paramc.rB().toString();
    y.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.dJa.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.CG() }), paramValueCallback);
    return true;
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    if (!this.ahC) {
      return this.dIY.dIR.K(paramString1, "fail:JsApi core not started");
    }
    return this.dIY.d(paramString1, paramString2, paramInt);
  }
  
  public final void onStart()
  {
    if (this.ahC) {}
    for (;;)
    {
      return;
      y.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.dIX });
      this.ahC = true;
      if (this.dJc != null) {
        this.dJc.D(this.dIX, 1);
      }
      Iterator localIterator = this.dIY.dIQ.dIW.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (paramString2 == null) {}
    for (;;)
    {
      y.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
      return;
      i = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.e
 * JD-Core Version:    0.7.0.1
 */