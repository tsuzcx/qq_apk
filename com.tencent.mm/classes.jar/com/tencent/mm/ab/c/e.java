package com.tencent.mm.ab.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private volatile boolean ga;
  public String gaR;
  public c gzU;
  public f gzV;
  public com.tencent.mm.ab.b.d gzW;
  private volatile boolean gzX;
  public e.a gzY;
  
  public final void a(com.tencent.mm.ab.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.gzX)
    {
      AppMethodBeat.o(144814);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.gaR });
    this.gzX = true;
    if (this.gzW.aik()) {
      this.gzW.pause();
    }
    for (;;)
    {
      if (this.gzY != null) {
        this.gzY.P(this.gaR, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.ab.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.gzW != null)
    {
      ad.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.gzW = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.ab.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.gzV;
    if (paramc == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.gzZ.wD(paramc.name);
    if (localObject == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.gzN.mz(((com.tencent.mm.ab.b.e)localObject).getIndex()))
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    ad.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.gzW.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.aim() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final y.b ail()
  {
    return this.gzU.gzM.gzS;
  }
  
  public final boolean aq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.gzV;
    Object localObject = localf.gzZ.wD(paramString1);
    if (localObject == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.gzN.mz(((com.tencent.mm.ab.b.e)localObject).getIndex()))
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    localObject = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      localObject = "{}";
    }
    ad.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.gzW.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.aim() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final void b(com.tencent.mm.ab.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.gzX)
    {
      AppMethodBeat.o(144815);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.gaR });
    if (this.gzW.aik()) {
      this.gzW.resume();
    }
    for (;;)
    {
      this.gzX = false;
      if (this.gzY != null) {
        this.gzY.P(this.gaR, 2);
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
    if (!this.ga)
    {
      paramString1 = this.gzU.gzP.ap(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.gzU.i(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.ga)
    {
      AppMethodBeat.o(144816);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.gaR });
    this.ga = true;
    if (this.gzY != null) {
      this.gzY.P(this.gaR, 1);
    }
    Iterator localIterator = this.gzU.gzO.gzT.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    ad.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.gaR });
    this.ga = false;
    this.gzW.destroy();
    c localc = this.gzU;
    localc.gzP.quit();
    localc.gzM.gzS.recycle();
    if (this.gzY != null)
    {
      this.gzY.P(this.gaR, 4);
      this.gzY = null;
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
      ad.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(144809);
      return;
      i = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.c.e
 * JD-Core Version:    0.7.0.1
 */