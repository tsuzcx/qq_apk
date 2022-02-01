package com.tencent.mm.ac.c;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private volatile boolean Tb;
  public String jsP;
  public c kbg;
  public f kbh;
  public com.tencent.mm.ac.b.d kbi;
  private volatile boolean kbj;
  public e.a kbk;
  
  public final void a(com.tencent.mm.ac.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.kbj)
    {
      AppMethodBeat.o(144814);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.jsP });
    this.kbj = true;
    if (this.kbi.aGi()) {
      this.kbi.pause();
    }
    for (;;)
    {
      if (this.kbk != null) {
        this.kbk.aj(this.jsP, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.ac.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.kbi != null)
    {
      Log.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.kbi = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.ac.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.kbh;
    if (paramc == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.kbl.My(paramc.name);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.kaZ.so(((com.tencent.mm.ac.b.e)localObject).getIndex()))
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.toJSONObject().toString();
    Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.kbi.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.aGk() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final ad.b aGj()
  {
    return this.kbg.kaY.kbe;
  }
  
  public final boolean ax(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.kbh;
    Object localObject = localf.kbl.My(paramString1);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.kaZ.so(((com.tencent.mm.ac.b.e)localObject).getIndex()))
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
    localf.kbi.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.aGk() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final void b(com.tencent.mm.ac.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.kbj)
    {
      AppMethodBeat.o(144815);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.jsP });
    if (this.kbi.aGi()) {
      this.kbi.resume();
    }
    for (;;)
    {
      this.kbj = false;
      if (this.kbk != null) {
        this.kbk.aj(this.jsP, 2);
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
    if (!this.Tb)
    {
      paramString1 = this.kbg.kbb.aw(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.kbg.h(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.Tb)
    {
      AppMethodBeat.o(144816);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.jsP });
    this.Tb = true;
    if (this.kbk != null) {
      this.kbk.aj(this.jsP, 1);
    }
    Iterator localIterator = this.kbg.kba.kbf.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    Log.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.jsP });
    this.Tb = false;
    this.kbi.destroy();
    c localc = this.kbg;
    localc.kbb.quit();
    localc.kaY.kbe.recycle();
    if (this.kbk != null)
    {
      this.kbk.aj(this.jsP, 4);
      this.kbk = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ac.c.e
 * JD-Core Version:    0.7.0.1
 */