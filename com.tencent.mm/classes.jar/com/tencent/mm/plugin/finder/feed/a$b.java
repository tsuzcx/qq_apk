package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ah;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ac;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class a$b
  extends e<a.c, a.d, BaseFinderFeed>
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private final Map<ah, d<BaseFinderFeed>> map;
  
  public a$b()
  {
    AppMethodBeat.i(201497);
    this.TAG = "Finder.FinderAtTimelineData";
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(201497);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(201493);
    com.tencent.mm.kernel.g.agi().a(3810, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(201493);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(201494);
    com.tencent.mm.kernel.g.agi().a(3810, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(201494);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(201495);
    d locald = (d)this.map.get(paramn);
    if (locald != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionedFeed");
        AppMethodBeat.o(201495);
        throw paramString;
      }
      ah localah = (ah)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = localah.rr.aBD();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
          AppMethodBeat.o(201495);
          throw paramString;
        }
        if (((ala)localObject1).qXl != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localah.rr.aBD();
        if (localObject1 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(201495);
        throw paramString;
      }
      Object localObject1 = (ala)localObject1;
      if (localObject1 != null) {}
      for (localObject1 = ((ala)localObject1).object;; localObject1 = null)
      {
        localObject1 = new a.e(((LinkedList)localObject1).size(), paramInt1, paramInt2, paramString);
        paramn = (Iterable)((ah)paramn).csC();
        paramString = (Collection)new ArrayList(j.a(paramn, 10));
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          localObject2 = (FinderObject)paramn.next();
          Object localObject3 = FinderItem.rDA;
          localObject2 = FinderItem.a.a((FinderObject)localObject2, 8192);
          localObject3 = FinderAtTimelineUI.roG;
          ((Map)FinderAtTimelineUI.cvK()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
          paramString.add(b.a.i((FinderItem)localObject2));
        }
      }
      ((a.e)localObject1).setIncrementList((List)paramString);
      paramn = this.TAG;
      Object localObject2 = new StringBuilder("incrementList size: ");
      paramString = ((a.e)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ac.i(paramn, paramString);
        ((a.e)localObject1).setPullType(localah.pullType);
        paramString = localah.rr.aBD();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(201495);
        throw paramString;
      }
      ((a.e)localObject1).setLastBuffer(((ala)paramString).EEJ);
      ((a.e)localObject1).setHasMore(bool);
      locald.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(201495);
      return;
    }
    AppMethodBeat.o(201495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */