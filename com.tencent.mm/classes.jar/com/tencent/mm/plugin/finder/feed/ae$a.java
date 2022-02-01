package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"})
public final class ae$a
  extends c.a
{
  public static final a xzJ;
  
  static
  {
    AppMethodBeat.i(271590);
    xzJ = new a((byte)0);
    AppMethodBeat.o(271590);
  }
  
  public ae$a(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(271589);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    paramBaseFinderFeedLoader = localBaseFinderFeedLoader;
    if (!(localBaseFinderFeedLoader instanceof FinderPoiFeedLoader)) {
      paramBaseFinderFeedLoader = null;
    }
    paramBaseFinderFeedLoader = (FinderPoiFeedLoader)paramBaseFinderFeedLoader;
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader.fetchEndCallback = ((b)new q(paramMMActivity) {});
      AppMethodBeat.o(271589);
      return;
    }
    AppMethodBeat.o(271589);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(271584);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(271584);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(271586);
    BaseFeedLoader.requestInit$default(this.xnX, false, 1, null);
    AppMethodBeat.o(271586);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(271588);
    c.b localb = this.xvU;
    if (localb != null)
    {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
      AppMethodBeat.o(271588);
      return;
    }
    AppMethodBeat.o(271588);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(271587);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(271587);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(271583);
    this.xnX.requestRefresh();
    AppMethodBeat.o(271583);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.a
 * JD-Core Version:    0.7.0.1
 */