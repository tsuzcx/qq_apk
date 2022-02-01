package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$RetransmitSourceInit;", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$RetransmitSourceRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class w$c
  extends e<w.d, w.e, BaseFinderFeed>
  implements com.tencent.mm.ak.g
{
  private final Map<ao, d<BaseFinderFeed>> map;
  
  public w$c()
  {
    AppMethodBeat.i(165854);
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(165854);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(165850);
    com.tencent.mm.kernel.g.agi().a(3581, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(165850);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(165851);
    com.tencent.mm.kernel.g.agi().a(3581, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(165851);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(165852);
    d locald = (d)this.map.get(paramn);
    if (locald != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOriginalUserFeeds");
        AppMethodBeat.o(165852);
        throw paramString;
      }
      ao localao = (ao)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (localao.csM().continueFlag == 0)) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localao.qYc;
        paramn = (n)localObject1;
        if (localObject1 == null) {
          paramn = (List)new LinkedList();
        }
        localObject1 = (Iterable)paramn;
        paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          b.a locala = b.rFl;
          paramn.add(b.a.i((FinderItem)localObject2));
        }
      }
      paramn = (List)paramn;
      if (!bs.gY(paramn))
      {
        localObject1 = ai.getContext();
        if (((BaseFinderFeed)j.iO(paramn)).feedObject.getId() == localao.refObjectId) {
          break label346;
        }
        localObject2 = (BaseFinderFeed)j.iO(paramn);
        localObject1 = ((Context)localObject1).getString(2131759189);
        k.g(localObject1, "context.getString(R.string.finder_deleted_tip2)");
        k.h(localObject1, "<set-?>");
        ((BaseFinderFeed)localObject2).headerWording = ((String)localObject1);
      }
      for (;;)
      {
        paramString = new w.f(paramInt1, paramInt2, paramString);
        paramString.setIncrementList(paramn);
        paramString.setPullType(localao.pullType);
        paramString.setLastBuffer(localao.csM().lastBuffer);
        paramString.setHasMore(bool);
        locald.onFetchDone((IResponse)paramString);
        AppMethodBeat.o(165852);
        return;
        label346:
        if (paramn.size() > 1)
        {
          localObject2 = (BaseFinderFeed)j.iO(paramn);
          localObject1 = ((Context)localObject1).getString(2131759190);
          k.g(localObject1, "context.getString(R.string.finder_deleted_tip3)");
          k.h(localObject1, "<set-?>");
          ((BaseFinderFeed)localObject2).footerWording = ((String)localObject1);
        }
      }
    }
    AppMethodBeat.o(165852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.c
 * JD-Core Version:    0.7.0.1
 */