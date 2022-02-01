package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.feed.model.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.g;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$4", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class b$d
  implements l.a
{
  b$d(l.a parama) {}
  
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(201234);
    k.h(parama, "info");
    if (this.qZr.diw == 4)
    {
      Object localObject = ((Iterable)parama.incrementList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject).next();
        g localg = g.rEP;
        g.a(localBaseFinderFeed.feedObject.getId(), localBaseFinderFeed.feedObject.parseJsonOfPosTriggerConfig());
      }
      localObject = g.rEP;
      g.a(b.a(this.qZr), true, "onFetchDone#".concat(String.valueOf(paramInt)));
    }
    this.qZm.a(parama, paramInt);
    AppMethodBeat.o(201234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b.d
 * JD-Core Version:    0.7.0.1
 */