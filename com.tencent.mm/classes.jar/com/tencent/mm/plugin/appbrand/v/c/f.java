package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.plugin.appbrand.v.a.d;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends d
{
  public final String b(com.tencent.mm.ad.i parami, c paramc)
  {
    AppMethodBeat.i(147394);
    parami = (String)com.tencent.mm.plugin.appbrand.t.i.aed(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    if (com.tencent.mm.plugin.appbrand.t.i.aef(parami) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isLANIp", Boolean.valueOf(bool));
      parami = paramc.Y(localHashMap);
      AppMethodBeat.o(147394);
      return parami;
    }
  }
  
  public final int cCX()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.f
 * JD-Core Version:    0.7.0.1
 */