package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.model.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "commentDrawerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getCommentDrawerViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setCommentDrawerViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool
  extends ViewModel
{
  public static final a Lht;
  public final RecyclerView.n Lho;
  public RecyclerView.n Lhp;
  public RecyclerView.n Lhq;
  public RecyclerView.n Lhr;
  public RecyclerView.n Lhs;
  public RecyclerView.n qub;
  
  static
  {
    AppMethodBeat.i(200325);
    Lht = new a((byte)0);
    AppMethodBeat.o(200325);
  }
  
  public FinderRecyclerViewPool()
  {
    AppMethodBeat.i(200324);
    Object localObject = new b();
    ((b)localObject).aB(4, 18);
    ((b)localObject).aB(2, 12);
    ((b)localObject).aB(9999, 3);
    this.Lho = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(2, 16);
    ((RecyclerView.n)localObject).aB(4, 12);
    this.qub = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 20);
    ((RecyclerView.n)localObject).aB(2, 20);
    ((RecyclerView.n)localObject).aB(-3, 2);
    this.Lhp = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 20);
    ((RecyclerView.n)localObject).aB(2, 20);
    ((RecyclerView.n)localObject).aB(-3, 2);
    this.Lhq = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    h.a locala = h.qDD;
    ((RecyclerView.n)localObject).aB(h.cmY(), 10);
    locala = h.qDD;
    ((RecyclerView.n)localObject).aB(h.cmZ(), 10);
    this.Lhr = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aB(4, 10);
    ((RecyclerView.n)localObject).aB(2, 10);
    this.Lhs = ((RecyclerView.n)localObject);
    AppMethodBeat.o(200324);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.n
  {
    public final RecyclerView.v cs(int paramInt)
    {
      AppMethodBeat.i(200323);
      RecyclerView.v localv = super.cs(paramInt);
      StringBuilder localStringBuilder;
      View localView;
      if (ad.getLogLevel() <= 1)
      {
        localStringBuilder = new StringBuilder("getRecycledView hash=");
        if (localv == null) {
          break label94;
        }
        localView = localv.arI;
        if (localView == null) {
          break label99;
        }
      }
      label94:
      label99:
      for (int i = localView.hashCode();; i = 0)
      {
        ad.d("Finder.RecyclerViewPoolVM", i + " viewType=" + paramInt + " size=" + cr(paramInt));
        AppMethodBeat.o(200323);
        return localv;
        localView = null;
        break;
      }
    }
    
    public final void q(RecyclerView.v paramv)
    {
      AppMethodBeat.i(200322);
      k.h(paramv, "scrap");
      super.q(paramv);
      if (ad.getLogLevel() <= 1) {
        ad.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + paramv.arI.hashCode() + " viewType=" + paramv.lp() + " size=" + cr(paramv.lp()));
      }
      AppMethodBeat.o(200322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */