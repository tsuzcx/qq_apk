package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.b.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.ab.c.b
{
  private ap bZx;
  public String fDK;
  public com.tencent.mm.plugin.appbrand.dynamic.i.a jmn;
  private ag<String, JSONObject> jmo;
  
  public c()
  {
    AppMethodBeat.i(121351);
    this.bZx = new ap("JsApiExecutor-Thread:" + hashCode());
    this.jmo = new c.1(this);
    AppMethodBeat.o(121351);
  }
  
  final JSONObject Hg(String paramString)
  {
    AppMethodBeat.i(121355);
    paramString = (JSONObject)this.jmo.get(paramString);
    AppMethodBeat.o(121355);
    return paramString;
  }
  
  public final String a(final com.tencent.mm.ab.c.a parama, final com.tencent.mm.ab.d.a parama1, final com.tencent.mm.ab.b.b paramb, final String paramString, final b.a parama2)
  {
    AppMethodBeat.i(121353);
    final String str = paramb.name;
    if (!parama1.mb(paramb.index))
    {
      u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[] { str });
      parama = al(str, "fail:access denied");
      AppMethodBeat.o(121353);
      return parama;
    }
    parama1 = m.no(System.nanoTime());
    final boolean bool = com.tencent.mm.plugin.appbrand.dynamic.h.d.FD(str);
    com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", parama1, "start_jsapi_invoke", bool);
    com.tencent.mm.plugin.appbrand.collector.c.co(parama1, "after_draw_actions");
    if ((paramb instanceof b))
    {
      parama1 = Hg(paramString);
      if (parama1 == null)
      {
        parama = al(str, "fail:invalid data");
        AppMethodBeat.o(121353);
        return parama;
      }
    }
    for (parama = paramb.a(parama, parama1, parama2);; parama = "")
    {
      if (this.jmn != null) {
        this.jmn.Hm(str);
      }
      AppMethodBeat.o(121353);
      return parama;
      this.bZx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121350);
          com.tencent.mm.plugin.appbrand.collector.c.k(parama1, "parse_json_start", bool);
          JSONObject localJSONObject = c.this.Hg(paramString);
          if (localJSONObject == null)
          {
            parama2.bl(c.this.al(str, "fail:invalid data"));
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
  
  public final String al(String paramString1, String paramString2)
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
    this.bZx.getSerial().IzX.quit();
    if (this.jmn != null) {
      this.jmn.report();
    }
    com.tencent.mm.plugin.appbrand.dynamic.d.b.a.Hi(this.fDK);
    u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + (float)(this.jmo.hitCount() * 1.0D / (this.jmo.hitCount() + this.jmo.missCount())), new Object[] { Integer.valueOf(this.jmo.hitCount()), Integer.valueOf(this.jmo.missCount()) });
    AppMethodBeat.o(121354);
  }
  
  public final String qx(String paramString)
  {
    AppMethodBeat.i(121352);
    ad.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[] { paramString });
    paramString = al(paramString, "fail:not supported");
    AppMethodBeat.o(121352);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c
 * JD-Core Version:    0.7.0.1
 */