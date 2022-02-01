package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.ac.a;
import com.tencent.mm.protocal.protobuf.bbc;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$modeShopShelf$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "plugin-finder_release"})
public final class e$ad
  implements ac.a
{
  e$ad(m paramm) {}
  
  public final void a(final int paramInt1, final int paramInt2, final bbc parambbc)
  {
    AppMethodBeat.i(268162);
    p.k(parambbc, "resp");
    d.uiThread((a)new a(this, paramInt1, paramInt2, parambbc));
    AppMethodBeat.o(268162);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(e.ad paramad, int paramInt1, int paramInt2, bbc parambbc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e.ad
 * JD-Core Version:    0.7.0.1
 */