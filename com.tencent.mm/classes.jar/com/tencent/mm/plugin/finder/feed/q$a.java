package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
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
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getCurrentVideoPosSec", "", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "requestRefresh", "plugin-finder_release"})
public final class q$a
  extends aa.a
{
  private final com.tencent.mm.plugin.finder.feed.model.i xve;
  private final com.tencent.mm.plugin.finder.feed.model.k xvf;
  
  public q$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(289991);
    g localg = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    localg = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    AppMethodBeat.o(289991);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(289987);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(2, this.xkX, (b)new a(this));
    paramBaseFinderFeedLoader = aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((d)this.xve);
      }
    }
    com.tencent.mm.plugin.finder.feed.model.k.a(this.xvf, (m)new b(this));
    paramBaseFinderFeedLoader = aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((d)this.xvf);
        AppMethodBeat.o(289987);
        return;
      }
    }
    AppMethodBeat.o(289987);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(289986);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(289986);
      return;
    }
    AppMethodBeat.o(289986);
  }
  
  public final void dst()
  {
    AppMethodBeat.i(289989);
    super.dst();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.xvC;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).xvJ.getRecyclerView();; localObject = null)
    {
      com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject, s.t.yGO, "21", com.tencent.mm.plugin.finder.live.report.c.yAk);
      AppMethodBeat.o(289989);
      return;
    }
  }
  
  public final int dtf()
  {
    AppMethodBeat.i(289990);
    Object localObject1 = this.xvC;
    if (localObject1 != null)
    {
      localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();
      if (localObject1 != null)
      {
        Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(289990);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((RecyclerView)localObject1).cJ(((LinearLayoutManager)localObject2).kJ());
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
        if ((localObject1 != null) && ((((com.tencent.mm.view.recyclerview.i)localObject1).ihX() instanceof BaseFinderFeed)))
        {
          localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.i)localObject1).RD(b.f.finder_banner_video_layout);
          if (localObject1 != null)
          {
            int i = ((FinderVideoLayout)localObject1).getCurrentPosSec();
            AppMethodBeat.o(289990);
            return i;
          }
          AppMethodBeat.o(289990);
          return 0;
        }
      }
    }
    AppMethodBeat.o(289990);
    return 0;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(289988);
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
    AppMethodBeat.o(289988);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(289985);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(289985);
      return;
    }
    AppMethodBeat.o(289985);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bu>
  {
    a(q.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    b(q.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.a
 * JD-Core Version:    0.7.0.1
 */