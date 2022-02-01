package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.x.c;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class a$g
  implements g.a
{
  public a$g(int paramInt, a.a parama) {}
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(197346);
    k.h(paramc, "info");
    if ((paramc.errType == 0) && (paramc.errCode == 0)) {
      this.KKc.KJS.KKa = paramc.lastBuffer;
    }
    ad.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(paramInt)));
    if (paramc.qys != 0) {}
    x.c localc;
    for (boolean bool = true;; bool = false)
    {
      localc = new x.c(paramc.errType, paramc.errCode, paramc.errMsg);
      localObject1 = new LinkedList();
      if (!bt.gL((List)this.KKc.KJS.KKb))
      {
        ((LinkedList)localObject1).addAll((Collection)this.KKc.KJS.KKb);
        this.KKc.KJS.KKb.clear();
      }
      Object localObject3 = (Iterable)paramc.incrementList;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
        z localz = z.KNQ;
        ((Collection)localObject2).add(z.m(localBaseFinderFeed));
      }
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localc.setIncrementList((List)localObject1);
    Object localObject2 = new StringBuilder("incrementList size: ");
    Object localObject1 = localc.getIncrementList();
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
    {
      ad.i("Finder.FinderLbsFeedFetcher", localObject1);
      localc.setPullType(this.KKl);
      localc.setLastBuffer(paramc.lastBuffer);
      localc.setHasMore(bool);
      this.KKd.a(localc);
      AppMethodBeat.o(197346);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.a.g
 * JD-Core Version:    0.7.0.1
 */