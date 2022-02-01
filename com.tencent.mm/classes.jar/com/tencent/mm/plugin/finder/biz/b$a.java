package com.tencent.mm.plugin.finder.biz;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.j;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "requestRefresh", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
  extends ae.a
{
  private final i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  
  public b$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(330464);
    k localk = k.aeZF;
    this.Aye = ((j)k.d((AppCompatActivity)paramMMActivity).q(j.class)).Aye;
    localk = k.aeZF;
    this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
    AppMethodBeat.o(330464);
  }
  
  private static final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(330471);
    s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/biz/FinderBizTimelineContract$Presenter", "smoothScrollToNextPosition$lambda-1", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/biz/FinderBizTimelineContract$Presenter", "smoothScrollToNextPosition$lambda-1", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(330471);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(330506);
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
        paramBaseFinderFeedLoader.a((d)this.Aye);
      }
    }
    paramb = this.Ayf;
    m localm = (m)new b(this);
    paramBaseFinderFeedLoader = this.ATo;
    if (paramBaseFinderFeedLoader == null) {}
    for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.ATx.getRecyclerView())
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a(this.Ayf.edV());
        }
      }
      AppMethodBeat.o(330506);
      return;
    }
  }
  
  public final void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(330497);
    s.u(paramd, "reason");
    if ((paramd.agJw) && (paramd.agJu))
    {
      paramd = this.ATo;
      if (paramd != null)
      {
        paramd = paramd.ATx.getRecyclerView();
        if (paramd != null)
        {
          RecyclerView.LayoutManager localLayoutManager = paramd.getLayoutManager();
          if (localLayoutManager == null)
          {
            paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
            AppMethodBeat.o(330497);
            throw paramd;
          }
          int i = ((FinderLinearLayoutManager)localLayoutManager).Ju() + 1;
          Log.i(getTAG(), s.X("[smoothScrollToNextPosition] nextPosition=", Integer.valueOf(i)));
          paramd.post(new b.a..ExternalSyntheticLambda0(paramd, i));
        }
      }
    }
    AppMethodBeat.o(330497);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(330488);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(330488);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(330512);
    this.Aye.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.Aye);
      }
    }
    this.Ayf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(this.Ayf.edV());
      }
    }
    super.onDetach();
    AppMethodBeat.o(330512);
  }
  
  public final void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, cc>
  {
    a(b.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    b(b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.biz.b.a
 * JD-Core Version:    0.7.0.1
 */