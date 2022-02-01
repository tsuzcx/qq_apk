package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.h;
import com.tencent.mm.plugin.finder.viewmodel.h.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class m$a
  extends aa.a
{
  private final long feedId;
  private final int scene;
  private final i xve;
  private final k xvf;
  private final h xyj;
  
  public m$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(255936);
    this.feedId = paramLong;
    this.scene = paramInt;
    g localg = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    localg = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    paramMMActivity = g.Xox;
    paramMMActivity = g.bD(PluginFinder.class).i(h.class);
    p.j(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.xyj = ((h)paramMMActivity);
    AppMethodBeat.o(255936);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(255931);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(this.scene, this.xkX, (b)new a(this));
    paramBaseFinderFeedLoader = aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xve);
      }
    }
    paramb = this.xvf;
    m localm = (m)new b(this);
    paramBaseFinderFeedLoader = this.xvC;
    if (paramBaseFinderFeedLoader != null) {}
    for (paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.xvJ.getRecyclerView();; paramBaseFinderFeedLoader = null)
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = aj.Bnu;
      paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
      AppMethodBeat.o(255931);
      return;
    }
    AppMethodBeat.o(255931);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(255929);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(255929);
      return;
    }
    AppMethodBeat.o(255929);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(255932);
    this.xve.onDetach();
    Object localObject2 = this.xyj;
    String str = String.valueOf(this.feedId);
    Object localObject1 = this.xnX;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      if (localObject1 == null) {}
    }
    for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
    {
      p.k(str, "key");
      p.k(localObject1, "lastDataList");
      Log.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((h)localObject2).Bht;
      h.a locala = new h.a(str);
      locala.Bgy = 0;
      locala.Bgz = 0;
      localObject1 = (List)localObject1;
      p.k(localObject1, "<set-?>");
      locala.Bgw = ((List)localObject1);
      locala.BgA = System.currentTimeMillis();
      ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
      localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.iXq);
      if (localObject1 != null)
      {
        localObject1 = aj.a((aj)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.xve);
        }
      }
      this.xvf.onDetach();
      localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.iXq);
      if (localObject1 != null)
      {
        localObject1 = aj.a((aj)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
        }
      }
      super.onDetach();
      AppMethodBeat.o(255932);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(255928);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(255928);
      return;
    }
    AppMethodBeat.o(255928);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bu>
  {
    a(m.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    b(m.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.m.a
 * JD-Core Version:    0.7.0.1
 */