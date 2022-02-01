package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
public final class g$b$1
  implements d
{
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165811);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.qwx);
    FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.qvY;
    localRefreshLoadMoreLayout.at(FinderProfileUIContract.cmc() + paramInt1, paramInt2);
    FinderProfileUIContract.ProfileViewCallback.b(this.qwx);
    AppMethodBeat.o(165811);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165812);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.qwx);
    FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.qvY;
    localRefreshLoadMoreLayout.au(FinderProfileUIContract.cmc() + paramInt1, paramInt2);
    FinderProfileUIContract.ProfileViewCallback.b(this.qwx);
    AppMethodBeat.o(165812);
  }
  
  public final void c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165807);
    k.h(paramc, "reason");
    FinderProfileUIContract.ProfileViewCallback.g(this.qwx).c(paramc);
    FinderProfileUIContract.ProfileViewCallback.b(this.qwx);
    AppMethodBeat.o(165807);
  }
  
  public final void d(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(165808);
    k.h(paramc, "reason");
    FinderProfileUIContract.ProfileViewCallback.g(this.qwx).d(paramc);
    FinderProfileUIContract.ProfileViewCallback.b(this.qwx);
    AppMethodBeat.o(165808);
  }
  
  public final void f(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(165810);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderProfileUIContract.ProfileViewCallback.g(this.qwx);
    FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.qvY;
    localRefreshLoadMoreLayout.f(FinderProfileUIContract.cmc() + paramInt1, paramInt2, paramObject);
    FinderProfileUIContract.ProfileViewCallback.b(this.qwx);
    AppMethodBeat.o(165810);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(165809);
    FinderProfileUIContract.ProfileViewCallback.g(this.qwx).onChanged();
    this.qwx.kU(false);
    AppMethodBeat.o(165809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b.1
 * JD-Core Version:    0.7.0.1
 */