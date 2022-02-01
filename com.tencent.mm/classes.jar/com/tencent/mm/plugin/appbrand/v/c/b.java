package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.appbrand.v.a.d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.v.a.c paramc)
  {
    AppMethodBeat.i(147392);
    parami = paramc.esk;
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.getRuntime().qsB.qKC.chD().ordinal()));
    parami = paramc.Y(localHashMap);
    AppMethodBeat.o(147392);
    return parami;
  }
  
  public final int cCX()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.b
 * JD-Core Version:    0.7.0.1
 */