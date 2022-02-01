package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.ac.c.b
{
  private MMHandler cqJ;
  public String jsP;
  public com.tencent.mm.plugin.appbrand.dynamic.i.a oiv;
  private LruCache<String, JSONObject> oiw;
  
  public c()
  {
    AppMethodBeat.i(121351);
    this.cqJ = new MMHandler("JsApiExecutor-Thread:" + hashCode());
    this.oiw = new c.1(this);
    AppMethodBeat.o(121351);
  }
  
  public final String Mx(String paramString)
  {
    AppMethodBeat.i(121352);
    Log.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[] { paramString });
    paramString = aw(paramString, "fail:not supported");
    AppMethodBeat.o(121352);
    return paramString;
  }
  
  public final String a(final com.tencent.mm.ac.c.a parama, final com.tencent.mm.ac.d.a parama1, final com.tencent.mm.ac.b.b paramb, final String paramString, final b.a parama2)
  {
    AppMethodBeat.i(121353);
    final String str = paramb.name;
    if (!parama1.so(paramb.index))
    {
      u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[] { str });
      parama = aw(str, "fail:access denied");
      AppMethodBeat.o(121353);
      return parama;
    }
    parama1 = n.HF(System.nanoTime());
    final boolean bool = com.tencent.mm.plugin.appbrand.dynamic.h.d.aeC(str);
    com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", parama1, "start_jsapi_invoke", bool);
    com.tencent.mm.plugin.appbrand.collector.c.cZ(parama1, "after_draw_actions");
    if ((paramb instanceof b))
    {
      parama1 = agl(paramString);
      if (parama1 == null)
      {
        parama = aw(str, "fail:invalid data");
        AppMethodBeat.o(121353);
        return parama;
      }
    }
    for (parama = paramb.a(parama, parama1, parama2);; parama = "")
    {
      if (this.oiv != null) {
        this.oiv.agr(str);
      }
      AppMethodBeat.o(121353);
      return parama;
      this.cqJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121350);
          com.tencent.mm.plugin.appbrand.collector.c.k(parama1, "parse_json_start", bool);
          JSONObject localJSONObject = c.this.agl(paramString);
          if (localJSONObject == null)
          {
            parama2.bt(c.this.aw(str, "fail:invalid data"));
            AppMethodBeat.o(121350);
            return;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("rawJsapiData", paramString);
          com.tencent.mm.plugin.appbrand.collector.c.k(parama1, "parse_json_end", bool);
          com.tencent.mm.plugin.appbrand.dynamic.h.d.a(parama1, paramString, localJSONObject);
          paramb.a(parama, localJSONObject, localBundle, parama2);
          AppMethodBeat.o(121350);
        }
      });
    }
  }
  
  final JSONObject agl(String paramString)
  {
    AppMethodBeat.i(121355);
    paramString = (JSONObject)this.oiw.get(paramString);
    AppMethodBeat.o(121355);
    return paramString;
  }
  
  public final String aw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121356);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", paramString1 + ":" + paramString2);
    paramString1 = new JSONObject(localHashMap).toString();
    AppMethodBeat.o(121356);
    return paramString1;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(121354);
    this.cqJ.getSerial().Zxu.quit();
    if (this.oiv != null) {
      this.oiv.report();
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.a.agn(this.jsP);
    u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + (float)(this.oiw.hitCount() * 1.0D / (this.oiw.hitCount() + this.oiw.missCount())), new Object[] { Integer.valueOf(this.oiw.hitCount()), Integer.valueOf(this.oiw.missCount()) });
    AppMethodBeat.o(121354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c
 * JD-Core Version:    0.7.0.1
 */