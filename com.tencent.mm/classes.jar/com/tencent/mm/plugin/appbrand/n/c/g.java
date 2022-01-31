package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends b
{
  static void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(102202);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.C(localHashMap);
    AppMethodBeat.o(102202);
  }
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(102201);
    parami = parami.optString("apiName");
    r localr = paramc.bEw;
    if (d.cP(localr.getAppId(), parami))
    {
      a(paramc, 1);
      AppMethodBeat.o(102201);
      return;
    }
    d.a(localr, parami, new g.1(this, paramc, parami));
    AppMethodBeat.o(102201);
  }
  
  public final int aIA()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.g
 * JD-Core Version:    0.7.0.1
 */