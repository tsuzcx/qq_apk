package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
public final class q$a
  extends b.a
{
  public static final a rWg;
  
  static
  {
    AppMethodBeat.i(201888);
    rWg = new a((byte)0);
    AppMethodBeat.o(201888);
  }
  
  public q$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201887);
    AppMethodBeat.o(201887);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(201883);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201883);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201881);
    this.rTS.requestLoadMore();
    AppMethodBeat.o(201881);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(201880);
    b.b localb = this.rTQ;
    if (localb != null)
    {
      localb.U((ArrayList)this.rTS.getDataListJustForAdapter());
      AppMethodBeat.o(201880);
      return;
    }
    AppMethodBeat.o(201880);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(201885);
    Object localObject = this.rTQ;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cAR();; localObject = null)
    {
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((z)localObject).cBj();
      AppMethodBeat.o(201885);
      return localObject;
    }
  }
  
  public final void cAO()
  {
    AppMethodBeat.i(201882);
    BaseFeedLoader.requestInit$default(this.rTS, false, 1, null);
    AppMethodBeat.o(201882);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201886);
    super.onDetach();
    FinderLbsStreamFeedLoader.a locala = FinderLbsStreamFeedLoader.sbE;
    ad.i(FinderLbsStreamFeedLoader.access$getTAG$cp(), "clearCache");
    FinderLbsStreamFeedLoader.cBT().clear();
    AppMethodBeat.o(201886);
  }
  
  public final void requestRefresh() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.a
 * JD-Core Version:    0.7.0.1
 */