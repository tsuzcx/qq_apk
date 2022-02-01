package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.v.a.b;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.plugin.appbrand.y;

public final class k
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147403);
    parami = parami.optString("apiName");
    ((com.tencent.mm.plugin.appbrand.permission.k)paramc.esk.T(com.tencent.mm.plugin.appbrand.permission.k.class)).afr(parami);
    AppMethodBeat.o(147403);
  }
  
  public final int cCX()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.k
 * JD-Core Version:    0.7.0.1
 */