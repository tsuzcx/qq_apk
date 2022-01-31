package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.f;

final class b$1
  extends com.tencent.luggage.game.a.a
{
  b$1(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(com.tencent.luggage.game.a.c paramc)
  {
    AppMethodBeat.i(143534);
    b.a(this.iJp, paramc);
    super.a(paramc);
    paramc.bzO.gc_factor = com.tencent.mm.plugin.appbrand.game.a.c.hsj.cI(((c)b.a(this.iJp)).getContext());
    paramc.bzO.enable_wxbindcanvastexture = f.aAy();
    AppMethodBeat.o(143534);
  }
  
  public final void as(long paramLong)
  {
    AppMethodBeat.i(143535);
    com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)b.b(this.iJp)).aud(), ((c)b.c(this.iJp)).getAppId(), paramLong);
    AppMethodBeat.o(143535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b.1
 * JD-Core Version:    0.7.0.1
 */