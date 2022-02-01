package com.tencent.mm.aa.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  public c gCB;
  public f gCC;
  public com.tencent.mm.aa.b.d gCD;
  private volatile boolean gCE;
  public e.a gCF;
  private volatile boolean ga;
  public String gcZ;
  
  public final void a(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.gCE)
    {
      AppMethodBeat.o(144814);
      return;
    }
    ae.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.gcZ });
    this.gCE = true;
    if (this.gCD.aiz()) {
      this.gCD.pause();
    }
    for (;;)
    {
      if (this.gCF != null) {
        this.gCF.Q(this.gcZ, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.aa.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.gCD != null)
    {
      ae.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.gCD = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.aa.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.gCC;
    if (paramc == null)
    {
      ae.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.gCG.xm(paramc.name);
    if (localObject == null)
    {
      ae.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.gCu.mC(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      ae.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    ae.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.gCD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.aiB() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final z.b aiA()
  {
    return this.gCB.gCt.gCz;
  }
  
  public final boolean ar(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.gCC;
    Object localObject = localf.gCG.xm(paramString1);
    if (localObject == null)
    {
      ae.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.gCu.mC(((com.tencent.mm.aa.b.e)localObject).getIndex()))
    {
      ae.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    localObject = paramString2;
    if (bu.isNullOrNil(paramString2)) {
      localObject = "{}";
    }
    ae.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.gCD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.aiB() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final void b(com.tencent.mm.aa.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.gCE)
    {
      AppMethodBeat.o(144815);
      return;
    }
    ae.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.gcZ });
    if (this.gCD.aiz()) {
      this.gCD.resume();
    }
    for (;;)
    {
      this.gCE = false;
      if (this.gCF != null) {
        this.gCF.Q(this.gcZ, 2);
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
      paramString1 = this.gCB.gCw.aq(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.gCB.i(paramString1, paramString2, paramInt);
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
    ae.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.gcZ });
    this.ga = true;
    if (this.gCF != null) {
      this.gCF.Q(this.gcZ, 1);
    }
    Iterator localIterator = this.gCB.gCv.gCA.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    ae.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.gcZ });
    this.ga = false;
    this.gCD.destroy();
    c localc = this.gCB;
    localc.gCw.quit();
    localc.gCt.gCz.recycle();
    if (this.gCF != null)
    {
      this.gCF.Q(this.gcZ, 4);
      this.gCF = null;
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
      ae.d("MicroMsg.MiniJsBridge", "publishHandler, event: %s, data size: %d", new Object[] { paramString1, Integer.valueOf(i) });
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