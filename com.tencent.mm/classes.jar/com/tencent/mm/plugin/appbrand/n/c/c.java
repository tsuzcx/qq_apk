package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.n.a.d;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends d
{
  public final int aIA()
  {
    return 6;
  }
  
  public final String b(i parami, com.tencent.mm.plugin.appbrand.n.a.c paramc)
  {
    AppMethodBeat.i(102194);
    parami = (String)j.DV(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    if (j.DX(parami) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isLANIp", Boolean.valueOf(bool));
      parami = paramc.C(localHashMap);
      AppMethodBeat.o(102194);
      return parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.c
 * JD-Core Version:    0.7.0.1
 */