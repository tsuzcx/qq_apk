package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.u.a.d;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.u.a.c paramc)
  {
    AppMethodBeat.i(147394);
    parami = (String)j.adc(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    if (j.adf(parami) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isLANIp", Boolean.valueOf(bool));
      parami = paramc.Y(localHashMap);
      AppMethodBeat.o(147394);
      return parami;
    }
  }
  
  public final int bPT()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.c
 * JD-Core Version:    0.7.0.1
 */