package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.feed.model.a;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.model.internal.j.c;
import com.tencent.mm.plugin.finder.view.i;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1$request$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class b$e$a
  implements l.a
{
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(201235);
    k.h(parama, "info");
    j.c localc = new j.c(new LinkedList((Collection)parama.incrementList));
    localc.rov = parama;
    this.qZt.qZr.qZp.a(localc);
    parama = new vw();
    parama.dyL.diw = this.qZt.qZr.diw;
    parama.dyL.dyM = this.qZt.qZr.qZp.length;
    i.a(parama);
    AppMethodBeat.o(201235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b.e.a
 * JD-Core Version:    0.7.0.1
 */