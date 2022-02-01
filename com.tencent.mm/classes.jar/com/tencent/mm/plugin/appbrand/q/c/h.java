package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;

public final class h
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147403);
    parami = parami.optString("apiName");
    ((g)paramc.ceh.K(g.class)).Qn(parami);
    AppMethodBeat.o(147403);
  }
  
  public final int bpA()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.h
 * JD-Core Version:    0.7.0.1
 */