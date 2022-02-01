package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.feed.model.i.c;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class a$g
  implements l.a
{
  public a$g(int paramInt, a.a parama) {}
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.a parama, int paramInt)
  {
    AppMethodBeat.i(201224);
    k.h(parama, "info");
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      this.qZf.qYW.qZd = parama.lastBuffer;
    }
    ac.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
    if (parama.qXl != 0) {}
    i.c localc;
    for (boolean bool = true;; bool = false)
    {
      localc = new i.c(parama.errType, parama.errCode, parama.errMsg);
      localObject1 = new LinkedList();
      if (!bs.gY((List)this.qZf.qYW.qZe))
      {
        ((LinkedList)localObject1).addAll((Collection)this.qZf.qYW.qZe);
        this.qZf.qYW.qZe.clear();
      }
      Object localObject3 = (Iterable)parama.incrementList;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
        s locals = s.rio;
        ((Collection)localObject2).add(s.g(localBaseFinderFeed));
      }
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localc.setIncrementList((List)localObject1);
    Object localObject2 = new StringBuilder("incrementList size: ");
    Object localObject1 = localc.getIncrementList();
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
    {
      ac.i("Finder.FinderLbsFeedFetcher", localObject1);
      localc.setPullType(this.qZo);
      localc.setLastBuffer(parama.lastBuffer);
      localc.setHasMore(bool);
      this.qZg.a(localc);
      AppMethodBeat.o(201224);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a.g
 * JD-Core Version:    0.7.0.1
 */