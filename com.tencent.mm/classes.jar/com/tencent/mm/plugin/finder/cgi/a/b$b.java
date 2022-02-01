package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.d.c;
import com.tencent.mm.plugin.finder.view.i;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class b$b
  implements g.a
{
  b$b(g.a parama) {}
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(197354);
    k.h(paramc, "info");
    d.c localc = new d.c(new LinkedList((Collection)paramc.incrementList));
    localc.KQU = paramc;
    this.KKp.KKn.a(localc);
    paramc.KPJ = this.KKp.KKn.fTA();
    this.KKj.a(paramc, paramInt);
    paramc = new ys();
    paramc.bhU.IoU = this.KKp.IoU;
    paramc.bhU.bpQ = this.KKp.KKn.length;
    i.a(paramc);
    AppMethodBeat.o(197354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.b.b
 * JD-Core Version:    0.7.0.1
 */