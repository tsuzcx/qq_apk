package com.tencent.mm.plugin.finder.gallery;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.n;
import com.tencent.mm.view.recyclerview.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;I)V", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getTabType", "()I", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c.a
{
  private final b Bnx;
  final int hJx;
  
  public e(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader, b paramb, int paramInt)
  {
    super(paramMMActivity, 0, paramBaseFinderFeedLoader);
    AppMethodBeat.i(334294);
    this.Bnx = paramb;
    this.hJx = paramInt;
    AppMethodBeat.o(334294);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(334343);
    s.u(paramb, "callback");
    super.a(paramb);
    paramb = this.ATE;
    if (paramb == null) {}
    for (paramb = null;; paramb = paramb.getAdapter())
    {
      if (paramb != null) {
        paramb.agOS = ((o)new a(this));
      }
      AppMethodBeat.o(334343);
      return;
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(334310);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(334310);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(334327);
    g localg = this.Bnx.Os(this.hJx);
    AppMethodBeat.o(334327);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(334319);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(334319);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(334336);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(334336);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(334304);
    this.ALH.requestRefresh();
    AppMethodBeat.o(334304);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryPresenter$onAttach$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "wxRVData", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements o
  {
    a(e parame) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(334156);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramm, "wxRVData");
      if ((paramm.state == 0) || (paramm.state == 8))
      {
        paramm = (Iterable)paramm.agOB;
        paramRecyclerView = this.BuS;
        paramm = paramm.iterator();
        while (paramm.hasNext())
        {
          a locala = ((n)paramm.next()).agOG;
          if ((locala instanceof BaseFinderFeed))
          {
            f localf = f.BuT;
            f.R(locala.bZA(), paramRecyclerView.hJx);
          }
        }
      }
      AppMethodBeat.o(334156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.e
 * JD-Core Version:    0.7.0.1
 */