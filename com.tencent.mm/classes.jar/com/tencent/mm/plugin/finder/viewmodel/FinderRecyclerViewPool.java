package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "commentDrawerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getCommentDrawerViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setCommentDrawerViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool
  extends ViewModel
{
  public static final FinderRecyclerViewPool.a scp;
  public RecyclerView.n rfO;
  public final RecyclerView.n sck;
  public RecyclerView.n scl;
  public RecyclerView.n scm;
  public RecyclerView.n scn;
  private RecyclerView.n sco;
  
  static
  {
    AppMethodBeat.i(204399);
    scp = new FinderRecyclerViewPool.a((byte)0);
    AppMethodBeat.o(204399);
  }
  
  public FinderRecyclerViewPool()
  {
    AppMethodBeat.i(204398);
    Object localObject = new b();
    ((b)localObject).aB(4, 18);
    ((b)localObject).aB(2, 12);
    ((b)localObject).aB(9999, 3);
    this.sck = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(2, 16);
    ((RecyclerView.n)localObject).aB(4, 12);
    this.rfO = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 20);
    ((RecyclerView.n)localObject).aB(2, 20);
    ((RecyclerView.n)localObject).aB(-3, 2);
    this.scl = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 20);
    ((RecyclerView.n)localObject).aB(2, 20);
    ((RecyclerView.n)localObject).aB(-3, 2);
    this.scm = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    l.a locala = com.tencent.mm.plugin.finder.model.l.ruR;
    ((RecyclerView.n)localObject).aB(com.tencent.mm.plugin.finder.model.l.cwt(), 10);
    locala = com.tencent.mm.plugin.finder.model.l.ruR;
    ((RecyclerView.n)localObject).aB(com.tencent.mm.plugin.finder.model.l.cwu(), 10);
    this.scn = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 10);
    ((RecyclerView.n)localObject).aB(2, 10);
    this.sco = ((RecyclerView.n)localObject);
    AppMethodBeat.o(204398);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.n
  {
    public final RecyclerView.w cr(int paramInt)
    {
      AppMethodBeat.i(204397);
      RecyclerView.w localw = super.cr(paramInt);
      StringBuilder localStringBuilder;
      View localView;
      if (ac.getLogLevel() <= 1)
      {
        localStringBuilder = new StringBuilder("getRecycledView hash=");
        if (localw == null) {
          break label94;
        }
        localView = localw.asD;
        if (localView == null) {
          break label99;
        }
      }
      label94:
      label99:
      for (int i = localView.hashCode();; i = 0)
      {
        ac.d("Finder.RecyclerViewPoolVM", i + " viewType=" + paramInt + " size=" + cq(paramInt));
        AppMethodBeat.o(204397);
        return localw;
        localView = null;
        break;
      }
    }
    
    public final void q(RecyclerView.w paramw)
    {
      AppMethodBeat.i(204396);
      k.h(paramw, "scrap");
      super.q(paramw);
      if (ac.getLogLevel() <= 1) {
        ac.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + paramw.asD.hashCode() + " viewType=" + paramw.ly() + " size=" + cq(paramw.ly()));
      }
      AppMethodBeat.o(204396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */