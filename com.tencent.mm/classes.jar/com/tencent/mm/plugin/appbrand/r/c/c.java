package com.tencent.mm.plugin.appbrand.r.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.a.d;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(147394);
    parami = (String)j.Le(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    if (j.Lg(parami) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isLANIp", Boolean.valueOf(bool));
      parami = paramc.O(localHashMap);
      AppMethodBeat.o(147394);
      return parami;
    }
  }
  
  public final int biH()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c.c
 * JD-Core Version:    0.7.0.1
 */