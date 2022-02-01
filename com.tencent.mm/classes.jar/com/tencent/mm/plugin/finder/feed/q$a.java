package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
public final class q$a
  extends b.a
{
  public static final q.a.a seN;
  
  static
  {
    AppMethodBeat.i(202348);
    seN = new q.a.a((byte)0);
    AppMethodBeat.o(202348);
  }
  
  public q$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202347);
    AppMethodBeat.o(202347);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(202343);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(202343);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202341);
    this.scw.requestLoadMore();
    AppMethodBeat.o(202341);
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(202342);
    BaseFeedLoader.requestInit$default(this.scw, false, 1, null);
    AppMethodBeat.o(202342);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202340);
    b.b localb = this.scu;
    if (localb != null)
    {
      localb.U((ArrayList)this.scw.getDataListJustForAdapter());
      AppMethodBeat.o(202340);
      return;
    }
    AppMethodBeat.o(202340);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(202345);
    Object localObject = this.scu;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cCD();; localObject = null)
    {
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((z)localObject).cCV();
      AppMethodBeat.o(202345);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202346);
    super.onDetach();
    FinderLbsStreamFeedLoader.a locala = FinderLbsStreamFeedLoader.skv;
    ae.i(FinderLbsStreamFeedLoader.access$getTAG$cp(), "clearCache");
    FinderLbsStreamFeedLoader.cDF().clear();
    AppMethodBeat.o(202346);
  }
  
  public final void requestRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.a
 * JD-Core Version:    0.7.0.1
 */