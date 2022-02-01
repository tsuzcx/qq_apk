package com.tencent.mm.plugin.appbrand.r.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.appbrand.r.a.d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(147392);
    parami = paramc.chm;
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.getRuntime().iDK.iQP.aQO().ordinal()));
    parami = paramc.O(localHashMap);
    AppMethodBeat.o(147392);
    return parami;
  }
  
  public final int biH()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c.a
 * JD-Core Version:    0.7.0.1
 */