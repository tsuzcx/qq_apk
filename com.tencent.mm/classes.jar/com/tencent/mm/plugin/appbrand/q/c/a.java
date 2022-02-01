package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.appbrand.q.a.d
{
  public final String b(i parami, com.tencent.mm.plugin.appbrand.q.a.c paramc)
  {
    AppMethodBeat.i(147392);
    parami = paramc.ceh;
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.getRuntime().jdK.jqZ.aXJ().ordinal()));
    parami = paramc.O(localHashMap);
    AppMethodBeat.o(147392);
    return parami;
  }
  
  public final int bpA()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.a
 * JD-Core Version:    0.7.0.1
 */