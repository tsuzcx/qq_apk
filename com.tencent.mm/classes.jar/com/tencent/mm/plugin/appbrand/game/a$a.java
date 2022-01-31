package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.a.f;
import com.tencent.mm.plugin.appbrand.i;

final class a$a
  extends com.tencent.luggage.game.a.b
{
  private com.tencent.luggage.game.a.c bzF;
  
  a$a(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(com.tencent.luggage.game.a.c paramc)
  {
    AppMethodBeat.i(143089);
    this.bzF = paramc;
    super.a(paramc);
    paramc.bzO.allow_antialias_ = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUV, false);
    paramc.bzO.gc_factor = com.tencent.mm.plugin.appbrand.game.a.c.hsj.cI(((com.tencent.mm.plugin.appbrand.service.c)a.d(this.hrX)).getContext());
    paramc.bzO.enable_wxbindcanvastexture = f.aAy();
    paramc.bzO.allow_opengl3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.hsd.Uw()).booleanValue();
    AppMethodBeat.o(143089);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(143091);
    super.a(parami, true);
    com.tencent.mm.plugin.appbrand.game.c.a.hsP.a(this.bzF.bzI, parami);
    a.g(this.hrX);
    AppMethodBeat.o(143091);
  }
  
  public final void as(long paramLong)
  {
    AppMethodBeat.i(143090);
    com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(((com.tencent.mm.plugin.appbrand.service.c)a.e(this.hrX)).aud(), ((com.tencent.mm.plugin.appbrand.service.c)a.f(this.hrX)).getAppId(), paramLong);
    AppMethodBeat.o(143090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.a
 * JD-Core Version:    0.7.0.1
 */