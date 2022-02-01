package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.cgi.l.c;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/TimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "dead", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class w
  extends e<x, z, BaseFinderFeed>
  implements l.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private r rgF;
  private final c rne;
  private final com.tencent.mm.plugin.finder.cgi.fetcher.b rnh;
  
  public w(com.tencent.mm.plugin.finder.cgi.fetcher.b paramb, c paramc, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(202237);
    this.rnh = paramb;
    this.rne = paramc;
    AppMethodBeat.o(202237);
  }
  
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(202236);
    k.h(parama, "info");
    AppMethodBeat.o(202236);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(166092);
    if (this.rne == c.rnY)
    {
      this.rgF = ((PluginFinder)g.ad(PluginFinder.class)).getFollowTlSingleExecutor();
      localr = this.rgF;
      if (localr != null)
      {
        localr.clean();
        AppMethodBeat.o(166092);
        return;
      }
      AppMethodBeat.o(166092);
      return;
    }
    r localr = new r("SingleExecutor#TabType=" + this.rnh.diw);
    localr.start();
    this.rgF = localr;
    AppMethodBeat.o(166092);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(166093);
    r localr = this.rgF;
    if (localr != null) {
      localr.reset();
    }
    this.rgF = null;
    AppMethodBeat.o(166093);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166089);
    k.h(parama, "p0");
    AppMethodBeat.o(166089);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<q, y>
  {
    a(w paramw, z paramz, long paramLong, d paramd)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/model/TimelineData$call$1$2$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public static final class a
      implements l.a
    {
      a(w.a parama, q paramq) {}
      
      public final void a(a parama, int paramInt)
      {
        AppMethodBeat.i(202233);
        k.h(parama, "info");
        aa localaa = new aa(parama.errType, parama.errCode, parama.errMsg, (byte)0);
        localaa.setIncrementList(parama.incrementList);
        localaa.setPullType(paramInt);
        localaa.setHasMore(true);
        localaa.setRequest((i)this.rnz.rny);
        localaa.rnF = parama.rmv;
        this.rnz.rmU.onFetchDone((IResponse)localaa);
        this.rnA.a(h.gLN);
        AppMethodBeat.o(202233);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.w
 * JD-Core Version:    0.7.0.1
 */