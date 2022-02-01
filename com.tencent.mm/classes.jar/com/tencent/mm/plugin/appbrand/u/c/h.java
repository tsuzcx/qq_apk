package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;

public final class h
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147403);
    parami = parami.optString("apiName");
    ((j)paramc.cAJ.M(j.class)).aep(parami);
    AppMethodBeat.o(147403);
  }
  
  public final int bPT()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.h
 * JD-Core Version:    0.7.0.1
 */