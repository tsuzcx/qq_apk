package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.feed.model.a;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.protocal.protobuf.amz;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$notifyPrefetch$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class d$h$1
  implements l.a
{
  d$h$1(q paramq) {}
  
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(201454);
    k.h(parama, "info");
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      this.reN.reD.a(parama, this.reN.reL.EGc, ((PluginFinder)g.ad(PluginFinder.class)).isInFinder(), this.reN.reM);
    }
    this.reJ.a(h.gLN);
    AppMethodBeat.o(201454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d.h.1
 * JD-Core Version:    0.7.0.1
 */