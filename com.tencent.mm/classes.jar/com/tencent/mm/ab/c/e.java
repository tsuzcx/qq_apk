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
  private volatile boolean arf;
  public String fDK;
  public c gbE;
  public f gbF;
  public com.tencent.mm.ab.b.d gbG;
  private volatile boolean gbH;
  public e.a gbI;
  
  public final void a(com.tencent.mm.ab.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.gbH)
    {
      AppMethodBeat.o(144814);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.fDK });
    this.gbH = true;
    if (this.gbG.aei()) {
      this.gbG.pause();
    }
    for (;;)
    {
      if (this.gbI != null) {
        this.gbI.M(this.fDK, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.ab.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.gbG != null)
    {
      ad.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.gbG = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.ab.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.gbF;
    if (paramc == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.gbJ.qy(paramc.name);
    if (localObject == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.gbx.mb(((com.tencent.mm.ab.b.e)localObject).getIndex()))
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    ad.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.gbG.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.aek() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final y.b aej()
  {
    return this.gbE.gbw.gbC;
  }
  
  public final boolean am(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.gbF;
    Object localObject = localf.gbJ.qy(paramString1);
    if (localObject == null)
    {
      ad.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.gbx.mb(((com.tencent.mm.ab.b.e)localObject).getIndex()))
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
    localf.gbG.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.aek() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final void b(com.tencent.mm.ab.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.gbH)
    {
      AppMethodBeat.o(144815);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.fDK });
    if (this.gbG.aei()) {
      this.gbG.resume();
    }
    for (;;)
    {
      this.gbH = false;
      if (this.gbI != null) {
        this.gbI.M(this.fDK, 2);
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
    if (!this.arf)
    {
      paramString1 = this.gbE.gbz.al(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.gbE.i(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.arf)
    {
      AppMethodBeat.o(144816);
      return;
    }
    ad.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.fDK });
    this.arf = true;
    if (this.gbI != null) {
      this.gbI.M(this.fDK, 1);
    }
    Iterator localIterator = this.gbE.gby.gbD.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    ad.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.fDK });
    this.arf = false;
    this.gbG.destroy();
    c localc = this.gbE;
    localc.gbz.quit();
    localc.gbw.gbC.recycle();
    if (this.gbI != null)
    {
      this.gbI.M(this.fDK, 4);
      this.gbI = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.c.e
 * JD-Core Version:    0.7.0.1
 */