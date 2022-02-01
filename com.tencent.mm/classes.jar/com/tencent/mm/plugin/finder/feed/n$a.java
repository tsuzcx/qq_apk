package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "autoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;IZ)V", "getAutoRefresh", "()Z", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "requestRefresh", "plugin-finder_release"})
public final class n$a
  extends aa.a
{
  private final boolean bFt;
  private final int scene;
  private final i xve;
  private final com.tencent.mm.plugin.finder.feed.model.k xvf;
  
  public n$a(MMActivity paramMMActivity, int paramInt, boolean paramBoolean)
  {
    super(paramMMActivity);
    AppMethodBeat.i(286647);
    this.scene = paramInt;
    this.bFt = paramBoolean;
    g localg = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    localg = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    AppMethodBeat.o(286647);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(286644);
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
        paramBaseFinderFeedLoader.a((d)this.xve);
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
      paramBaseFinderFeedLoader.a((d)this.xvf);
      AppMethodBeat.o(286644);
      return;
    }
    AppMethodBeat.o(286644);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(286643);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(286643);
      return;
    }
    AppMethodBeat.o(286643);
  }
  
  public final void dst()
  {
    AppMethodBeat.i(286646);
    super.dst();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.xvC;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).xvJ.getRecyclerView();; localObject = null)
    {
      com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject, s.t.yGO, "40", com.tencent.mm.plugin.finder.live.report.c.yAk);
      AppMethodBeat.o(286646);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(286645);
    this.xve.onDetach();
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.xve);
      }
    }
    this.xvf.onDetach();
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.xvf);
      }
    }
    super.onDetach();
    AppMethodBeat.o(286645);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(286642);
    if (this.bFt)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(286642);
        return;
      }
    }
    AppMethodBeat.o(286642);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bu>
  {
    a(n.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    b(n.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n.a
 * JD-Core Version:    0.7.0.1
 */