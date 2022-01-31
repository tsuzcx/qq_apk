package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.z.b.b.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.z.c.b
{
  private Handler byg;
  public String equ;
  public com.tencent.mm.plugin.appbrand.dynamic.i.a hpf;
  private ae<String, JSONObject> hpg;
  
  public c()
  {
    AppMethodBeat.i(10871);
    HandlerThread localHandlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
    localHandlerThread.start();
    this.byg = new Handler(localHandlerThread.getLooper());
    this.hpg = new c.1(this);
    AppMethodBeat.o(10871);
  }
  
  final JSONObject Bi(String paramString)
  {
    AppMethodBeat.i(10875);
    paramString = (JSONObject)this.hpg.get(paramString);
    AppMethodBeat.o(10875);
    return paramString;
  }
  
  public final String U(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10876);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", paramString1 + ":" + paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    AppMethodBeat.o(10876);
    return paramString1;
  }
  
  public final String a(com.tencent.mm.z.c.a parama, com.tencent.mm.z.d.a parama1, com.tencent.mm.z.b.b paramb, String paramString, b.a parama2)
  {
    AppMethodBeat.i(10873);
    String str = paramb.name;
    if (!parama1.jy(paramb.index))
    {
      u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[] { str });
      parama = U(str, "fail:access denied");
      AppMethodBeat.o(10873);
      return parama;
    }
    parama1 = n.hH(System.nanoTime());
    boolean bool = d.zP(str);
    com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", parama1, "start_jsapi_invoke", bool);
    com.tencent.mm.plugin.appbrand.collector.c.bI(parama1, "after_draw_actions");
    if ((paramb instanceof b))
    {
      parama1 = Bi(paramString);
      if (parama1 == null)
      {
        parama = U(str, "fail:invalid data");
        AppMethodBeat.o(10873);
        return parama;
      }
    }
    for (parama = paramb.a(parama, parama1, parama2);; parama = "")
    {
      if (this.hpf != null) {
        this.hpf.Bo(str);
      }
      AppMethodBeat.o(10873);
      return parama;
      this.byg.post(new c.2(this, parama1, bool, paramString, parama2, str, paramb, parama));
    }
  }
  
  public final String mh(String paramString)
  {
    AppMethodBeat.i(10872);
    ab.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[] { paramString });
    paramString = U(paramString, "fail:not supported");
    AppMethodBeat.o(10872);
    return paramString;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(10874);
    this.byg.getLooper().quit();
    if (this.hpf != null) {
      this.hpf.IE();
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.a.Bk(this.equ);
    u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + (float)(this.hpg.hitCount() * 1.0D / (this.hpg.hitCount() + this.hpg.missCount())), new Object[] { Integer.valueOf(this.hpg.hitCount()), Integer.valueOf(this.hpg.missCount()) });
    AppMethodBeat.o(10874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c
 * JD-Core Version:    0.7.0.1
 */