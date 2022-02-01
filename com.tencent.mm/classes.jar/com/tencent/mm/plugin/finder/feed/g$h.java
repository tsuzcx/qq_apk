package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getScene", "()I", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class g$h
  extends e.a
{
  private final e qvy;
  private final int scene;
  
  public g$h(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(197615);
    this.scene = paramInt;
    this.qvy = new e(paramMMActivity);
    AppMethodBeat.o(197615);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
  {
    AppMethodBeat.i(197613);
    k.h(paramBaseFinderFeedLoader, "model");
    k.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.qvy.a(this.scene, this.qqE, (b)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.Ljl;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.lB((Context)this.imP);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((f)this.qvy);
        AppMethodBeat.o(197613);
        return;
      }
    }
    AppMethodBeat.o(197613);
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(197612);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(197612);
      return;
    }
    AppMethodBeat.o(197612);
  }
  
  public final h clZ()
  {
    AppMethodBeat.i(197610);
    h localh = (h)new g.d((g)new a());
    AppMethodBeat.o(197610);
    return localh;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(197614);
    this.qvy.onDetach();
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB((Context)this.imP);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((d)localObject).b((f)this.qvy);
      }
    }
    super.onDetach();
    AppMethodBeat.o(197614);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(197611);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(197611);
      return;
    }
    AppMethodBeat.o(197611);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements g
  {
    public final void call(int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Integer, BaseFinderFeed>
  {
    b(g.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.h
 * JD-Core Version:    0.7.0.1
 */