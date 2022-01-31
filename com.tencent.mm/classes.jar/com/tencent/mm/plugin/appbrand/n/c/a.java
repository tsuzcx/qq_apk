package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.appbrand.n.a.d
{
  public final int aIA()
  {
    return 2;
  }
  
  public final String b(com.tencent.mm.aa.i parami, com.tencent.mm.plugin.appbrand.n.a.c paramc)
  {
    AppMethodBeat.i(102192);
    parami = paramc.bEw;
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.getRuntime().gPL.gYj.awr().ordinal()));
    parami = paramc.C(localHashMap);
    AppMethodBeat.o(102192);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.a
 * JD-Core Version:    0.7.0.1
 */