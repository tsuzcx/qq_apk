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
  private volatile boolean bzr;
  public String lWh;
  public c mBl;
  public f mBm;
  public com.tencent.mm.ac.b.d mBn;
  private volatile boolean mBo;
  public e.a mBp;
  
  public final void a(com.tencent.mm.ac.b.c paramc)
  {
    AppMethodBeat.i(144814);
    if (this.mBo)
    {
      AppMethodBeat.o(144814);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[] { this.lWh });
    this.mBo = true;
    if (this.mBn.aZi()) {
      this.mBn.pause();
    }
    for (;;)
    {
      if (this.mBp != null) {
        this.mBp.as(this.lWh, 3);
      }
      AppMethodBeat.o(144814);
      return;
      a(paramc, null);
    }
  }
  
  public final void a(com.tencent.mm.ac.b.d paramd)
  {
    AppMethodBeat.i(144817);
    if (this.mBn != null)
    {
      Log.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      AppMethodBeat.o(144817);
      return;
    }
    this.mBn = paramd;
    AppMethodBeat.o(144817);
  }
  
  public final boolean a(com.tencent.mm.ac.b.c paramc, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(144812);
    f localf = this.mBm;
    if (paramc == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
      AppMethodBeat.o(144812);
      return false;
    }
    Object localObject = localf.mBq.Fh(paramc.name);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    if (!localf.mBe.sk(((com.tencent.mm.ac.b.e)localObject).getIndex()))
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[] { paramc });
      AppMethodBeat.o(144812);
      return false;
    }
    localObject = paramc.aZh().toString();
    Log.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramc.name, Integer.valueOf(((String)localObject).length()), Integer.valueOf(0) });
    localf.mBn.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramc.name, localObject, "undefined", f.aZl() }), paramValueCallback);
    AppMethodBeat.o(144812);
    return true;
  }
  
  public final boolean aF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144811);
    f localf = this.mBm;
    Object localObject = localf.mBq.Fh(paramString1);
    if (localObject == null)
    {
      Log.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[] { paramString1 });
      AppMethodBeat.o(144811);
      return false;
    }
    if (!localf.mBe.sk(((com.tencent.mm.ac.b.e)localObject).getIndex()))
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
    localf.mBn.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, localObject, "undefined", f.aZl() }), null);
    AppMethodBeat.o(144811);
    return true;
  }
  
  public final ad.b aZk()
  {
    return this.mBl.mBd.mBj;
  }
  
  public final void b(com.tencent.mm.ac.b.c paramc)
  {
    AppMethodBeat.i(144815);
    if (!this.mBo)
    {
      AppMethodBeat.o(144815);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[] { this.lWh });
    if (this.mBn.aZi()) {
      this.mBn.resume();
    }
    for (;;)
    {
      this.mBo = false;
      if (this.mBp != null) {
        this.mBp.as(this.lWh, 2);
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
    if (!this.bzr)
    {
      paramString1 = this.mBl.mBg.aE(paramString1, "fail:JsApi core not started");
      AppMethodBeat.o(144810);
      return paramString1;
    }
    paramString1 = this.mBl.k(paramString1, paramString2, paramInt);
    AppMethodBeat.o(144810);
    return paramString1;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(144816);
    if (this.bzr)
    {
      AppMethodBeat.o(144816);
      return;
    }
    Log.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[] { this.lWh });
    this.bzr = true;
    if (this.mBp != null) {
      this.mBp.as(this.lWh, 1);
    }
    Iterator localIterator = this.mBl.mBf.mBk.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(144816);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(144813);
    Log.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[] { this.lWh });
    this.bzr = false;
    this.mBn.destroy();
    c localc = this.mBl;
    localc.mBg.quit();
    localc.mBd.mBj.recycle();
    if (this.mBp != null)
    {
      this.mBp.as(this.lWh, 4);
      this.mBp = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.c.e
 * JD-Core Version:    0.7.0.1
 */