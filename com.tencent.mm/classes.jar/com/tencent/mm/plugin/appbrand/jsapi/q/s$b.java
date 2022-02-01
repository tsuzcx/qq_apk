package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.x;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class s$b
  implements Runnable
{
  s$b(s params, g paramg, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(243902);
    Object localObject = this.owL.getRuntime();
    p.j(localObject, "env.runtime");
    boolean bool = ((AppBrandRuntime)localObject).bBX().at(this.piL, this.piM);
    g localg = this.owL;
    int i = this.otk;
    s locals = this.piK;
    if (bool) {}
    for (localObject = "ok";; localObject = "fail")
    {
      localg.j(i, locals.agS((String)localObject));
      AppMethodBeat.o(243902);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.s.b
 * JD-Core Version:    0.7.0.1
 */