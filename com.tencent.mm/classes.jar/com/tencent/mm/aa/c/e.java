package com.tencent.mm.aa.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private volatile boolean eg;
  public String fHr;
  public c ggk;
  public f ggl;
  public com.tencent.mm.aa.b.d ggm;
  private volatile boolean ggn;
  public e.a ggo;
  
  public final void a(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.ggn)
    {
      AppMethodBeat.o(144814);
      return;
    }
    ac.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.fHr });
    this.ggn = true;
    if (this.ggm.afy()) {
      this.ggm.pause();
    }
    for (;;)
    {
      if (this.ggo != null) {
        this.ggo.M(this.fHr, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.aa.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.ggm != null)
    {
      ac.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.ggm = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.aa.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.ggl;
    if (paramc == null)
    {
      ac.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.ggp.tN(paramc.name);
    if (localObject == null)
    {
      ac.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.ggd.ma(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      ac.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    ac.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.ggm.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.afA() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final y.b afz()
  {
    return this.ggk.ggc.ggi;
  }
  
  public final boolean ap(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.ggl;
    Object localObject = localf.ggp.tN(paramString1);
    if (localObject == null)
    {
      ac.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.ggd.ma(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      ac.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    localObject = paramString2;
    if (bs.isNullOrNil(paramString2)) {
      localObject = "{}";
    }
    ac.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.ggm.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.afA() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final void b(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.ggn)
    {
      AppMethodBeat.o(144815);
      return;
    }
    ac.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.fHr });
    if (this.ggm.afy()) {
      this.ggm.resume();
    }
    for (;;)
    {
      this.ggn = false;
      if (this.ggo != null) {
        this.ggo.M(this.fHr, 2);
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
    if (!this.eg)
    {
      paramString1 = this.ggk.ggf.ao(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.ggk.j(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.eg)
    {
      AppMethodBeat.o(144816);
      return;
    }
    ac.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.fHr });
    this.eg = true;
    if (this.ggo != null) {
      this.ggo.M(this.fHr, 1);
    }
    Iterator localIterator = this.ggk.gge.ggj.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    ac.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.fHr });
    this.eg = false;
    this.ggm.destroy();
    c localc = this.ggk;
    localc.ggf.quit();
    localc.ggc.ggi.recycle();
    if (this.ggo != null)
    {
      this.ggo.M(this.fHr, 4);
      this.ggo = null;
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
      ac.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
      AppMethodBeat.o(144809);
      return;
      i = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.c.e
 * JD-Core Version:    0.7.0.1
 */