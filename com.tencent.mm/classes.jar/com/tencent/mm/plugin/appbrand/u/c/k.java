package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.v;

public final class k
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147403);
    parami = parami.optString("apiName");
    ((j)paramc.czP.K(j.class)).amj(parami);
    AppMethodBeat.o(147403);
  }
  
  public final int ccB()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.k
 * JD-Core Version:    0.7.0.1
 */