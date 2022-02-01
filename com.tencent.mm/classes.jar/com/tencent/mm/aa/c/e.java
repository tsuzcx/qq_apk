package com.tencent.mm.aa.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  public String gIx;
  private volatile boolean gc;
  public c hpp;
  public f hpq;
  public com.tencent.mm.aa.b.d hpr;
  private volatile boolean hps;
  public e.a hpt;
  
  public final void a(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.hps)
    {
      AppMethodBeat.o(144814);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.gIx });
    this.hps = true;
    if (this.hpr.ayP()) {
      this.hpr.pause();
    }
    for (;;)
    {
      if (this.hpt != null) {
        this.hpt.S(this.gIx, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.aa.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.hpr != null)
    {
      Log.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.hpr = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.aa.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.hpq;
    if (paramc == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.hpu.Fy(paramc.name);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.hpi.pP(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.ayR() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final boolean at(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.hpq;
    Object localObject = localf.hpu.Fy(paramString1);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.hpi.pP(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    localObject = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      localObject = "{}";
    }
    Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.ayR() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final ad.b ayQ()
  {
    return this.hpp.hph.hpn;
  }
  
  public final void b(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.hps)
    {
      AppMethodBeat.o(144815);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.gIx });
    if (this.hpr.ayP()) {
      this.hpr.resume();
    }
    for (;;)
    {
      this.hps = false;
      if (this.hpt != null) {
        this.hpt.S(this.gIx, 2);
      }
      AppMethodBeat.o(144815);
      return;
      a(paramc, null);
    }
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(144810);
    if (!this.gc)
    {
      paramString1 = this.hpp.hpk.as(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.hpp.h(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.gc)
    {
      AppMethodBeat.o(144816);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.gIx });
    this.gc = true;
    if (this.hpt != null) {
      this.hpt.S(this.gIx, 1);
    }
    Iterator localIterator = this.hpp.hpj.hpo.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    Log.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.gIx });
    this.gc = false;
    this.hpr.destroy();
    c localc = this.hpp;
    localc.hpk.quit();
    localc.hph.hpn.recycle();
    if (this.hpt != null)
    {
      this.hpt.S(this.gIx, 4);
      this.hpt = null;
    }
    AppMethodBeat.o(144813);
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    AppMethodBeat.i(144809);
    if (paramString2 == null) {}
    for (;;)
    {
      Log.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(144809);
      return;
      i = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.e
 * JD-Core Version:    0.7.0.1
 */