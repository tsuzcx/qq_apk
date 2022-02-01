package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$4", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class b$d
  implements g.a
{
  b$d(g.a parama) {}
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(197356);
    k.h(paramc, "info");
    if (this.KKp.IoU == 4)
    {
      Object localObject = ((Iterable)paramc.incrementList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject).next();
        i locali = i.KXv;
        i.a(localBaseFinderFeed.feedObject.getId(), localBaseFinderFeed.feedObject.parseJsonOfPosTriggerConfig());
      }
      localObject = i.KXv;
      i.a(b.a(this.KKp), true, "onFetchDone#".concat(String.valueOf(paramInt)));
    }
    this.KKj.a(paramc, paramInt);
    AppMethodBeat.o(197356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.b.d
 * JD-Core Version:    0.7.0.1
 */