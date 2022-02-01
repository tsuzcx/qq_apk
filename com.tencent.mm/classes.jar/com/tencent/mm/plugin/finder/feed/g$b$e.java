package com.tencent.mm.plugin.finder.feed;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "plugin-finder_release"})
public final class g$b$e
  extends RefreshLoadMoreLayout.a
{
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165829);
    b localb = new b();
    localb.be(paramc);
    a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
    k.h(paramc, "reason");
    super.a(paramc);
    ad.i(FinderProfileUIContract.ProfileViewCallback.f(this.qwx), "[onLoadMoreEnd] reason=".concat(String.valueOf(paramc)));
    if (!paramc.HXq) {
      FinderProfileUIContract.ProfileViewCallback.e(this.qwx).hasMore = false;
    }
    a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(165829);
  }
  
  public final void agP(int paramInt)
  {
    AppMethodBeat.i(197874);
    b localb = new b();
    localb.lT(paramInt);
    a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
    super.agP(paramInt);
    ad.i(FinderProfileUIContract.ProfileViewCallback.f(this.qwx), "onRequestRefresh");
    h.Iye.aP((Runnable)new b(this));
    a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
    AppMethodBeat.o(197874);
  }
  
  public final void b(RefreshLoadMoreLayout.c paramc)
  {
    AppMethodBeat.i(197875);
    b localb = new b();
    localb.be(paramc);
    a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
    super.b(paramc);
    a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(197875);
  }
  
  public final void bMu()
  {
    AppMethodBeat.i(165828);
    a.b("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
    super.bMu();
    ad.i(FinderProfileUIContract.ProfileViewCallback.f(this.qwx), "onRequestLoadMore");
    h.Iye.aP((Runnable)new a(this));
    a.a(this, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
    AppMethodBeat.o(165828);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g.b.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165825);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)FinderProfileUIContract.ProfileViewCallback.c(this.qwG.qwx).getLast();
      if ((!FinderProfileUIContract.ProfileViewCallback.c(this.qwG.qwx).isEmpty()) && (localBaseFinderFeed != null)) {
        FinderProfileUIContract.ProfileViewCallback.e(this.qwG.qwx).cmd();
      }
      AppMethodBeat.o(165825);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g.b.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(165826);
      g.a locala = FinderProfileUIContract.ProfileViewCallback.e(this.qwG.qwx);
      ad.i(locala.TAG, "requestRefresh feedLoader hashCode:" + locala.fTm().hashCode());
      locala.fTm().requestRefresh();
      AppMethodBeat.o(165826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b.e
 * JD-Core Version:    0.7.0.1
 */