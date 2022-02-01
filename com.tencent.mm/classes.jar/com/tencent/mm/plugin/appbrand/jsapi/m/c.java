package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
  implements h
{
  protected com.tencent.mm.plugin.appbrand.jsapi.base.a laO = new com.tencent.mm.plugin.appbrand.jsapi.base.a();
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (j.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    a(paramc, paramJSONObject, paramInt, paramc.aYB());
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = aOZ();
    HashMap localHashMap = new HashMap();
    localHashMap.put(aeV(), str);
    this.laO.a(str, paramo);
    paramc.h(paramInt, n("ok", localHashMap));
    a(paramc, paramJSONObject, str);
  }
  
  public final boolean biS()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c
 * JD-Core Version:    0.7.0.1
 */