package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getCurrentVideoPosSec", "", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p$a
  extends ae.a
{
  private final i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  
  public p$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(362694);
    k localk = k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)k.d((AppCompatActivity)paramMMActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    localk = k.aeZF;
    this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
    AppMethodBeat.o(362694);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(362721);
    s.u(paramBaseFinderFeedLoader, "model");
    s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.Aye.a(2, this.AJo, (b)new a(this));
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    this.Ayf.a((m)new b(this), null);
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a(this.Ayf.edV());
      }
    }
    AppMethodBeat.o(362721);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362710);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(362710);
  }
  
  public final void eby()
  {
    AppMethodBeat.i(362735);
    super.eby();
    ce localce = (ce)h.ax(ce.class);
    Object localObject = this.ATo;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((b.b)localObject).ATx.getRecyclerView())
    {
      localce.b((RecyclerView)localObject, q.w.DwQ, "21", com.tencent.mm.plugin.finder.live.report.d.Dnh);
      AppMethodBeat.o(362735);
      return;
    }
  }
  
  public final int ecg()
  {
    AppMethodBeat.i(362755);
    Object localObject = this.ATo;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).ATx.getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(362755);
          throw ((Throwable)localObject);
        }
        localObject = ((RecyclerView)localObject).fT(((LinearLayoutManager)localLayoutManager).Ju());
        if ((localObject instanceof com.tencent.mm.view.recyclerview.j)) {
          localObject = (com.tencent.mm.view.recyclerview.j)localObject;
        }
        while ((localObject != null) && ((((com.tencent.mm.view.recyclerview.j)localObject).CSA instanceof BaseFinderFeed)))
        {
          localObject = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject).UH(e.e.finder_banner_video_layout);
          if (localObject == null)
          {
            AppMethodBeat.o(362755);
            return 0;
            localObject = null;
          }
          else
          {
            int i = ((FinderVideoLayout)localObject).getCurrentPosSec();
            AppMethodBeat.o(362755);
            return i;
          }
        }
      }
    }
    AppMethodBeat.o(362755);
    return 0;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362729);
    this.Aye.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    this.Ayf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((c)localObject).b(this.Ayf.edV());
      }
    }
    super.onDetach();
    AppMethodBeat.o(362729);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362701);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      localBaseFinderFeedLoader.requestRefresh();
    }
    AppMethodBeat.o(362701);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, cc>
  {
    a(p.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    b(p.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.p.a
 * JD-Core Version:    0.7.0.1
 */