package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w$a
  extends c.a
{
  public static final a AWh;
  
  static
  {
    AppMethodBeat.i(363648);
    AWh = new a((byte)0);
    AppMethodBeat.o(363648);
  }
  
  public w$a(MMActivity paramMMActivity, int paramInt, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramInt, paramBaseFinderFeedLoader);
    AppMethodBeat.i(363642);
    AppMethodBeat.o(363642);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(363680);
    s.u(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(363680);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363668);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(363668);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(363684);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(363684);
      return localObject;
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(363675);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(363675);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(363653);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(363653);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363694);
    super.onDetach();
    FinderLbsStreamFeedLoader.a locala = FinderLbsStreamFeedLoader.BgQ;
    Log.i(FinderLbsStreamFeedLoader.access$getTAG$cp(), "clearCache");
    FinderLbsStreamFeedLoader.edU().clear();
    AppMethodBeat.o(363694);
  }
  
  public final void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.a
 * JD-Core Version:    0.7.0.1
 */