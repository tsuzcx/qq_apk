package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.r;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.dzp;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class j
  extends f<k, l, BaseFinderFeed>
  implements com.tencent.mm.al.g
{
  private final Map<r, e<BaseFinderFeed>> map;
  
  public j(dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(198319);
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(198319);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(166070);
    com.tencent.mm.kernel.g.aeS().a(3965, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(166070);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(166071);
    com.tencent.mm.kernel.g.aeS().b(3965, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(166071);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166072);
    e locale = (e)this.map.get(paramn);
    if (locale != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetLikedList");
        AppMethodBeat.o(166072);
        throw paramString;
      }
      r localr = (r)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localr.ckO() != 1)) {}
      for (boolean bool = false;; bool = true)
      {
        paramn = new m(paramInt1, paramInt2, paramString);
        paramString = localr.qpi;
        if (paramString == null) {
          break label246;
        }
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          b.a locala = b.qKG;
          paramString.add(b.a.h(localFinderItem));
        }
      }
      label246:
      for (paramString = (List)paramString;; paramString = null)
      {
        paramn.setIncrementList(paramString);
        paramn.setPullType(localr.pullType);
        paramn.setLastBuffer(localr.ckN());
        paramn.setHasMore(bool);
        locale.onFetchDone((IResponse)paramn);
        AppMethodBeat.o(166072);
        return;
      }
    }
    AppMethodBeat.o(166072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.j
 * JD-Core Version:    0.7.0.1
 */