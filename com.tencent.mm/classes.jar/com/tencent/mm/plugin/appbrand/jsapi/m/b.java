package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends y<c>
  implements h
{
  protected a laM = new a();
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    if (j.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    return a(paramc, paramJSONObject, paramc.aYB());
  }
  
  public final String a(final c paramc, final JSONObject paramJSONObject, o paramo)
  {
    final String str = aOZ();
    HashMap localHashMap = new HashMap();
    localHashMap.put(aeV(), str);
    this.laM.a(str, paramo);
    paramc.aYA().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144184);
        b.this.a(paramc, paramJSONObject, str);
        AppMethodBeat.o(144184);
      }
    });
    return n("ok", localHashMap);
  }
  
  public final boolean biS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b
 * JD-Core Version:    0.7.0.1
 */