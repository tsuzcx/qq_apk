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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class FinderAtTimelineUIContract$b
  extends u.a
{
  private final com.tencent.mm.plugin.finder.feed.model.d rTq;
  private final int scene;
  
  public FinderAtTimelineUIContract$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201677);
    this.scene = paramInt;
    a locala = a.KiD;
    this.rTq = ((FinderCommentPreloaderUIC)a.s(paramMMActivity).get(FinderCommentPreloaderUIC.class)).rTq;
    AppMethodBeat.o(201677);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(201675);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.rTq.a(this.scene, this.rTD, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.tcM;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.eY((Context)this.fLP);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
        AppMethodBeat.o(201675);
        return;
      }
    }
    AppMethodBeat.o(201675);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201674);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201674);
      return;
    }
    AppMethodBeat.o(201674);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201676);
    this.rTq.onDetach();
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY((Context)this.fLP);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
      }
    }
    super.onDetach();
    AppMethodBeat.o(201676);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201673);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(201673);
      return;
    }
    AppMethodBeat.o(201673);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, BaseFinderFeed>
  {
    a(FinderAtTimelineUIContract.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.b
 * JD-Core Version:    0.7.0.1
 */