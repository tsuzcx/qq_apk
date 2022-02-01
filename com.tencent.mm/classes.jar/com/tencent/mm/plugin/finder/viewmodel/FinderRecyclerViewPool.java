package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.model.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool
  extends ViewModel
{
  public static final FinderRecyclerViewPool.a tkX;
  public RecyclerView.n sce;
  public final RecyclerView.n tkR;
  public RecyclerView.n tkS;
  public RecyclerView.n tkT;
  public RecyclerView.n tkU;
  public RecyclerView.n tkV;
  private RecyclerView.n tkW;
  
  static
  {
    AppMethodBeat.i(206062);
    tkX = new FinderRecyclerViewPool.a((byte)0);
    AppMethodBeat.o(206062);
  }
  
  public FinderRecyclerViewPool()
  {
    AppMethodBeat.i(206061);
    Object localObject = new b();
    ((b)localObject).aC(4, 18);
    ((b)localObject).aC(2, 12);
    this.tkR = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(2, 16);
    ((RecyclerView.n)localObject).aC(4, 12);
    this.sce = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 20);
    ((RecyclerView.n)localObject).aC(2, 20);
    ((RecyclerView.n)localObject).aC(-3, 2);
    this.tkS = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 20);
    ((RecyclerView.n)localObject).aC(2, 20);
    ((RecyclerView.n)localObject).aC(-3, 2);
    this.tkT = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    n.a locala = n.sth;
    ((RecyclerView.n)localObject).aC(n.cEw(), 10);
    locala = n.sth;
    ((RecyclerView.n)localObject).aC(n.cEx(), 10);
    this.tkU = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    locala = n.sth;
    ((RecyclerView.n)localObject).aC(n.cEw(), 10);
    locala = n.sth;
    ((RecyclerView.n)localObject).aC(n.cEx(), 5);
    this.tkV = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 10);
    ((RecyclerView.n)localObject).aC(2, 10);
    this.tkW = ((RecyclerView.n)localObject);
    AppMethodBeat.o(206061);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.n
  {
    public final RecyclerView.w cr(int paramInt)
    {
      AppMethodBeat.i(206060);
      RecyclerView.w localw = super.cr(paramInt);
      StringBuilder localStringBuilder;
      View localView;
      if (ae.getLogLevel() <= 1)
      {
        localStringBuilder = new StringBuilder("getRecycledView hash=");
        if (localw == null) {
          break label94;
        }
        localView = localw.auu;
        if (localView == null) {
          break label99;
        }
      }
      label94:
      label99:
      for (int i = localView.hashCode();; i = 0)
      {
        ae.d("Finder.RecyclerViewPoolVM", i + " viewType=" + paramInt + " size=" + cq(paramInt));
        AppMethodBeat.o(206060);
        return localw;
        localView = null;
        break;
      }
    }
    
    public final void q(RecyclerView.w paramw)
    {
      AppMethodBeat.i(206059);
      p.h(paramw, "scrap");
      super.q(paramw);
      if (ae.getLogLevel() <= 1) {
        ae.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + paramw.auu.hashCode() + " viewType=" + paramw.lQ() + " size=" + cq(paramw.lQ()));
      }
      AppMethodBeat.o(206059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */