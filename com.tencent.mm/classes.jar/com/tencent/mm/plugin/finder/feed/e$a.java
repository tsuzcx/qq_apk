package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.d.a;
import com.tencent.mm.plugin.finder.feed.model.d.a.a;
import com.tencent.mm.plugin.finder.feed.model.d.c;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class e$a
  extends c.a
{
  long rhr;
  
  public e$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201559);
    AppMethodBeat.o(201559);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(201555);
    k.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201555);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201553);
    this.rgh.requestLoadMore();
    AppMethodBeat.o(201553);
  }
  
  public final void cuB()
  {
    AppMethodBeat.i(201554);
    com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(this.rgh, (g)new d.c(0L, false, (f)new a(this)), false, 2, null);
    AppMethodBeat.o(201554);
  }
  
  public final void cur()
  {
    AppMethodBeat.i(201551);
    c.b localb = this.rgf;
    if (localb != null)
    {
      localb.U((ArrayList)this.rgh.getDataListJustForAdapter());
      AppMethodBeat.o(201551);
      return;
    }
    AppMethodBeat.o(201551);
  }
  
  public final c cut()
  {
    AppMethodBeat.i(201557);
    Object localObject = this.rgf;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).cuF();; localObject = null)
    {
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((r)localObject).cuS();
      AppMethodBeat.o(201557);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201558);
    super.onDetach();
    d.a locala = d.rmH;
    ac.i(d.access$getTAG$cp(), "clearCache");
    d.cvA().clear();
    AppMethodBeat.o(201558);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201552);
    this.rgh.requestRefresh();
    AppMethodBeat.o(201552);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201550);
      Object localObject = this.rhs.rgh;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(201550);
        throw ((Throwable)localObject);
      }
      localObject = (d)localObject;
      d.a locala = d.rmH;
      ((d)localObject).lastBuffer = d.a.ul(this.rhs.rhr).lastBuffer;
      localObject = this.rhs.rgf;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = this.rhs.rgf;
          if (localObject != null)
          {
            localObject = ((c.b)localObject).rfT.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          com.tencent.mm.sdk.b.a.GpY.l((b)new ha());
          AppMethodBeat.o(201550);
          return;
        }
      }
      AppMethodBeat.o(201550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e.a
 * JD-Core Version:    0.7.0.1
 */