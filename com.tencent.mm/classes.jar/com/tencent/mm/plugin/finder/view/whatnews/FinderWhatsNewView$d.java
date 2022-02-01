package com.tencent.mm.plugin.finder.view.whatnews;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class FinderWhatsNewView$d
  implements Runnable
{
  FinderWhatsNewView$d(FinderWhatsNewView paramFinderWhatsNewView) {}
  
  public final void run()
  {
    AppMethodBeat.i(168558);
    Object localObject = a.wtG;
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).azQ().set(ar.a.Olu, Boolean.TRUE);
    h.CyF.n(1305L, 0L, 1L);
    FinderWhatsNewView.a(this.wtM);
    AppMethodBeat.o(168558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView.d
 * JD-Core Version:    0.7.0.1
 */