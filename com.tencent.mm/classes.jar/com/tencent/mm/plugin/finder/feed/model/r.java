package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/TimelineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "dead", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class r
  extends f<s, t, BaseFinderFeed>
  implements g.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.b KQj;
  private final com.tencent.mm.plugin.finder.cgi.a.b KQn;
  private m quD;
  
  public r(com.tencent.mm.plugin.finder.cgi.a.b paramb, com.tencent.mm.plugin.finder.feed.model.internal.b paramb1, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(198325);
    this.KQn = paramb;
    this.KQj = paramb1;
    AppMethodBeat.o(198325);
  }
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(166090);
    k.h(paramc, "info");
    AppMethodBeat.o(166090);
  }
  
  public final void alive()
  {
    AppMethodBeat.i(166092);
    if (this.KQj == com.tencent.mm.plugin.finder.feed.model.internal.b.KQz)
    {
      this.quD = ((PluginFinder)g.ad(PluginFinder.class)).getFollowTlSingleExecutor();
      localm = this.quD;
      if (localm != null)
      {
        localm.clean();
        AppMethodBeat.o(166092);
        return;
      }
      AppMethodBeat.o(166092);
      return;
    }
    m localm = new m("SingleExecutor#TabType=" + this.KQn.IoU);
    localm.start();
    this.quD = localm;
    AppMethodBeat.o(166092);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(166093);
    m localm = this.quD;
    if (localm != null) {
      localm.reset();
    }
    this.quD = null;
    AppMethodBeat.o(166093);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166089);
    k.h(parama, "p0");
    AppMethodBeat.o(166089);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
  {
    a(r paramr, t paramt, long paramLong, e parame)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/model/TimelineData$call$1$2$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
    public static final class a
      implements g.a
    {
      a(r.a parama, com.tencent.mm.plugin.finder.utils.l paraml) {}
      
      public final void a(c paramc, int paramInt)
      {
        AppMethodBeat.i(198322);
        k.h(paramc, "info");
        u localu = new u(paramc.errType, paramc.errCode, paramc.errMsg, (byte)0);
        localu.setIncrementList(paramc.incrementList);
        localu.setPullType(paramInt);
        localu.setHasMore(true);
        localu.setRequest((j)this.qyT.qyR);
        localu.BZy = paramc.KPI;
        com.tencent.mm.plugin.finder.preload.a locala = com.tencent.mm.plugin.finder.preload.a.KTw;
        com.tencent.mm.plugin.finder.preload.a.a(paramc.DmE, paramc.incrementList);
        this.qyT.qyS.onFetchDone((IResponse)localu);
        this.KQt.a(h.gla);
        AppMethodBeat.o(198322);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.r
 * JD-Core Version:    0.7.0.1
 */