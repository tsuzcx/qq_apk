package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.appbrand.u.a.d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.u.a.c paramc)
  {
    AppMethodBeat.i(147392);
    parami = paramc.cAJ;
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.getRuntime().kAH.kQM.bwY().ordinal()));
    parami = paramc.Y(localHashMap);
    AppMethodBeat.o(147392);
    return parami;
  }
  
  public final int bPT()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.a
 * JD-Core Version:    0.7.0.1
 */