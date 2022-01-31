package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.r;

public final class h
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(102203);
    parami = parami.optString("apiName");
    ((f)paramc.bEw.q(f.class)).Ez(parami);
    AppMethodBeat.o(102203);
  }
  
  public final int aIA()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.h
 * JD-Core Version:    0.7.0.1
 */