package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.anm;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class o
  extends e<p, q, BaseFinderFeed>
  implements com.tencent.mm.ak.g
{
  private final Map<af, d<BaseFinderFeed>> map;
  
  public o(anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(202230);
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(202230);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(166070);
    com.tencent.mm.kernel.g.agi().a(3965, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(166070);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(166071);
    com.tencent.mm.kernel.g.agi().b(3965, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(166071);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166072);
    d locald = (d)this.map.get(paramn);
    if (locald != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetLikedList");
        AppMethodBeat.o(166072);
        throw paramString;
      }
      af localaf = (af)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localaf.csz() != 1)) {}
      for (boolean bool = false;; bool = true)
      {
        paramn = new r(paramInt1, paramInt2, paramString);
        paramString = localaf.qYc;
        if (paramString == null) {
          break label246;
        }
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          b.a locala = b.rFl;
          paramString.add(b.a.i(localFinderItem));
        }
      }
      label246:
      for (paramString = (List)paramString;; paramString = null)
      {
        paramn.setIncrementList(paramString);
        paramn.setPullType(localaf.pullType);
        paramn.setLastBuffer(localaf.csy());
        paramn.setHasMore(bool);
        locald.onFetchDone((IResponse)paramn);
        AppMethodBeat.o(166072);
        return;
      }
    }
    AppMethodBeat.o(166072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.o
 * JD-Core Version:    0.7.0.1
 */