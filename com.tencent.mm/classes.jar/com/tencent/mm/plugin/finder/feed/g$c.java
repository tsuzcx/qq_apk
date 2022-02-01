package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class g$c
  extends f<g.d, g.e, BaseFinderFeed>
  implements com.tencent.mm.al.g
{
  private final String TAG;
  private final Map<au, e<BaseFinderFeed>> map;
  
  public g$c()
  {
    AppMethodBeat.i(197600);
    this.TAG = "Finder.FinderAtTimelineData";
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(197600);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(197596);
    com.tencent.mm.kernel.g.aeS().a(3810, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(197596);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(197597);
    com.tencent.mm.kernel.g.aeS().a(3810, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(197597);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(197598);
    e locale = (e)this.map.get(paramn);
    if (locale != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionedFeed");
        AppMethodBeat.o(197598);
        throw paramString;
      }
      au localau = (au)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = localau.rr.auM();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
          AppMethodBeat.o(197598);
          throw paramString;
        }
        if (((dyw)localObject1).qys != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localau.rr.auM();
        if (localObject1 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(197598);
        throw paramString;
      }
      Object localObject1 = (dyw)localObject1;
      if (localObject1 != null) {}
      for (localObject1 = ((dyw)localObject1).object;; localObject1 = null)
      {
        localObject1 = new g.f(((LinkedList)localObject1).size(), paramInt1, paramInt2, paramString);
        paramn = (Iterable)((au)paramn).ckL();
        paramString = (Collection)new ArrayList(j.a(paramn, 10));
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          localObject2 = (FinderObject)paramn.next();
          Object localObject3 = FinderItem.qJU;
          localObject2 = FinderItem.a.a((FinderObject)localObject2, 8192);
          localObject3 = FinderAtTimelineUI.KRb;
          ((Map)FinderAtTimelineUI.cmQ()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          paramString.add(b.a.h((FinderItem)localObject2));
        }
      }
      ((g.f)localObject1).setIncrementList((List)paramString);
      paramn = this.TAG;
      Object localObject2 = new StringBuilder("incrementList size: ");
      paramString = ((g.f)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ad.i(paramn, paramString);
        ((g.f)localObject1).setPullType(localau.pullType);
        paramString = localau.rr.auM();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(197598);
        throw paramString;
      }
      ((g.f)localObject1).setLastBuffer(((dyw)paramString).Dlt);
      ((g.f)localObject1).setHasMore(bool);
      locale.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(197598);
      return;
    }
    AppMethodBeat.o(197598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.c
 * JD-Core Version:    0.7.0.1
 */