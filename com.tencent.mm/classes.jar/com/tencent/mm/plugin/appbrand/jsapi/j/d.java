package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
  implements e
{
  protected a kal = new a();
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (h.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    a(paramc, paramJSONObject, paramInt, paramc.aOf());
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = aEB();
    HashMap localHashMap = new HashMap();
    localHashMap.put(abh(), str);
    this.kal.a(str, paramo);
    a(paramc, paramJSONObject, str);
    paramc.h(paramInt, k("ok", localHashMap));
  }
  
  public final boolean aXI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.d
 * JD-Core Version:    0.7.0.1
 */