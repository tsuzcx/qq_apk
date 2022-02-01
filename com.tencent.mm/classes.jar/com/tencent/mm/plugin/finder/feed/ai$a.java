package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "autoPlayManager", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "onUIPause", "onUIResume", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai$a
  extends c.a
{
  ak AXh;
  
  public ai$a(final MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, 81, paramBaseFinderFeedLoader);
    AppMethodBeat.i(362670);
    paramBaseFinderFeedLoader = this.ALH;
    if ((paramBaseFinderFeedLoader instanceof FinderPoiFeedLoader)) {}
    for (paramBaseFinderFeedLoader = (FinderPoiFeedLoader)paramBaseFinderFeedLoader;; paramBaseFinderFeedLoader = null)
    {
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.fetchEndCallback = ((b)new u(paramMMActivity) {});
      }
      AppMethodBeat.o(362670);
      return;
    }
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(362679);
    s.u(paramb, "callback");
    super.a(paramb);
    paramb = this.ATE;
    if (paramb != null)
    {
      paramb = paramb.ATx.getRecyclerView();
      if (paramb != null)
      {
        Object localObject = k.aeZF;
        ((al)k.cn(PluginFinder.class).cq(al.class)).a((AppCompatActivity)this.lzt);
        localObject = (com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class);
        Context localContext = (Context)this.lzt;
        ArrayList localArrayList = (ArrayList)this.ALH.getDataListJustForAdapter();
        c.b localb = this.ATE;
        s.checkNotNull(localb);
        this.AXh = ((com.tencent.mm.plugin.g)localObject).a(localContext, paramb, localArrayList, localb.getAdapter());
      }
    }
    AppMethodBeat.o(362679);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362716);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362716);
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(362731);
    com.tencent.mm.view.recyclerview.g localg = new e((Context)this.lzt, this.AJo).ech();
    AppMethodBeat.o(362731);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(362722);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362722);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(362736);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(362736);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362686);
    super.onDetach();
    ak localak = this.AXh;
    if (localak != null) {
      localak.detach();
    }
    AppMethodBeat.o(362686);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(362702);
    super.onUIPause();
    ak localak = this.AXh;
    if (localak != null) {
      localak.eET();
    }
    AppMethodBeat.o(362702);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(362695);
    super.onUIResume();
    ak localak = this.AXh;
    if (localak != null) {
      localak.eES();
    }
    AppMethodBeat.o(362695);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362709);
    this.ALH.requestRefresh();
    AppMethodBeat.o(362709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.a
 * JD-Core Version:    0.7.0.1
 */