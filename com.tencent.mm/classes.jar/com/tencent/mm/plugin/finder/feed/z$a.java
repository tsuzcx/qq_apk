package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class z$a
  extends u.a
{
  private final com.tencent.mm.plugin.finder.feed.model.d sbU;
  private final int scene;
  
  public z$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202483);
    this.scene = paramInt;
    a locala = a.KEX;
    this.sbU = ((FinderCommentPreloaderUIC)a.s(paramMMActivity).get(FinderCommentPreloaderUIC.class)).sbU;
    AppMethodBeat.o(202483);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(202481);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.sbU.a(this.scene, this.sch, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.tnG;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fc((Context)this.fNT);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
        AppMethodBeat.o(202481);
        return;
      }
    }
    AppMethodBeat.o(202481);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202480);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(202480);
      return;
    }
    AppMethodBeat.o(202480);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202482);
    this.sbU.onDetach();
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)this.fNT);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
      }
    }
    super.onDetach();
    AppMethodBeat.o(202482);
  }
  
  public final void requestRefresh() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, BaseFinderFeed>
  {
    a(z.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z.a
 * JD-Core Version:    0.7.0.1
 */