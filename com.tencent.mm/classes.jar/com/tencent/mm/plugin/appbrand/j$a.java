package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e.a;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.e.a;

final class j$a
  implements e.a, a
{
  private final e.b gQu;
  private o gQv;
  private i.c gQw;
  
  j$a(e.b paramb, o paramo, i.c paramc)
  {
    AppMethodBeat.i(128956);
    this.gQu = paramb;
    this.gQv = paramo;
    this.gQw = paramc;
    paramo.keep(this);
    AppMethodBeat.o(128956);
  }
  
  public final void dead()
  {
    this.gQv = null;
    this.gQw = null;
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(128957);
    if ((this.gQv == null) || (this.gQw == null))
    {
      AppMethodBeat.o(128957);
      return;
    }
    ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, READY!!! reason[%s], appId[%s]", new Object[] { this.gQu.name(), this.gQv.mAppId });
    this.gQw.tT();
    AppMethodBeat.o(128957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a
 * JD-Core Version:    0.7.0.1
 */