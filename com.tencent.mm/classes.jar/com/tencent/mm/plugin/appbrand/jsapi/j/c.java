package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends y<com.tencent.mm.plugin.appbrand.jsapi.c>
  implements e
{
  protected a kaj = new a();
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    if (h.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    return a(paramc, paramJSONObject, paramc.aOf());
  }
  
  public final String a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, o paramo)
  {
    final String str = aEB();
    HashMap localHashMap = new HashMap();
    localHashMap.put(abh(), str);
    this.kaj.a(str, paramo);
    paramc.aOe().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144184);
        c.this.a(paramc, paramJSONObject, str);
        AppMethodBeat.o(144184);
      }
    });
    return k("ok", localHashMap);
  }
  
  public final boolean aXI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c
 * JD-Core Version:    0.7.0.1
 */