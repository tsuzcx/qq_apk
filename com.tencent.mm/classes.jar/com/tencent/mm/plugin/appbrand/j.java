package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class j
  extends i.c
{
  private final o gQn;
  volatile boolean gQo = false;
  private volatile e.b gQp;
  
  j(o paramo)
  {
    this.gQn = paramo;
  }
  
  final void a(e.b paramb)
  {
    AppMethodBeat.i(128958);
    if (this.gQo)
    {
      ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone hasPreload=TRUE, preloadReasonBefore[%s], preloadReasonNow[%s]", new Object[] { this.gQp, paramb });
      AppMethodBeat.o(128958);
      return;
    }
    this.gQo = true;
    this.gQp = paramb;
    o localo = this.gQn;
    d locald = localo.gPC;
    paramb = new j.1(this, localo, this, paramb);
    if (locald.getAnimation() == null)
    {
      paramb.run();
      AppMethodBeat.o(128958);
      return;
    }
    locald.jam.add(paramb);
    AppMethodBeat.o(128958);
  }
  
  public final void prepare() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */