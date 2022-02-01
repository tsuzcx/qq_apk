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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class FinderTopicTimelineUIContract$a
  extends u.a
{
  private final com.tencent.mm.plugin.finder.feed.model.d sbU;
  private final int scene;
  
  public FinderTopicTimelineUIContract$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202770);
    this.scene = paramInt;
    a locala = a.KEX;
    this.sbU = ((FinderCommentPreloaderUIC)a.s(paramMMActivity).get(FinderCommentPreloaderUIC.class)).sbU;
    AppMethodBeat.o(202770);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(178281);
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
        AppMethodBeat.o(178281);
        return;
      }
    }
    AppMethodBeat.o(178281);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(166000);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(166000);
      return;
    }
    AppMethodBeat.o(166000);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(178282);
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
    AppMethodBeat.o(178282);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165999);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(165999);
      return;
    }
    AppMethodBeat.o(165999);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, BaseFinderFeed>
  {
    a(FinderTopicTimelineUIContract.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.a
 * JD-Core Version:    0.7.0.1
 */