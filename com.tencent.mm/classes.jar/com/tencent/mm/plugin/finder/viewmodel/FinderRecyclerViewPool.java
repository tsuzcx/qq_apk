package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.model.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool
  extends ViewModel
{
  public static final a sZJ;
  public RecyclerView.n rTA;
  public final RecyclerView.n sZD;
  public RecyclerView.n sZE;
  public RecyclerView.n sZF;
  public RecyclerView.n sZG;
  public RecyclerView.n sZH;
  private RecyclerView.n sZI;
  
  static
  {
    AppMethodBeat.i(205414);
    sZJ = new a((byte)0);
    AppMethodBeat.o(205414);
  }
  
  public FinderRecyclerViewPool()
  {
    AppMethodBeat.i(205413);
    Object localObject = new b();
    ((b)localObject).aC(4, 18);
    ((b)localObject).aC(2, 12);
    this.sZD = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(2, 16);
    ((RecyclerView.n)localObject).aC(4, 12);
    this.rTA = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 20);
    ((RecyclerView.n)localObject).aC(2, 20);
    ((RecyclerView.n)localObject).aC(-3, 2);
    this.sZE = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 20);
    ((RecyclerView.n)localObject).aC(2, 20);
    ((RecyclerView.n)localObject).aC(-3, 2);
    this.sZF = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    m.a locala = m.skk;
    ((RecyclerView.n)localObject).aC(m.cCJ(), 10);
    locala = m.skk;
    ((RecyclerView.n)localObject).aC(m.cCK(), 10);
    this.sZG = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    locala = m.skk;
    ((RecyclerView.n)localObject).aC(m.cCJ(), 10);
    locala = m.skk;
    ((RecyclerView.n)localObject).aC(m.cCK(), 5);
    this.sZH = ((RecyclerView.n)localObject);
    localObject = new RecyclerView.n();
    ((RecyclerView.n)localObject).aC(4, 10);
    ((RecyclerView.n)localObject).aC(2, 10);
    this.sZI = ((RecyclerView.n)localObject);
    AppMethodBeat.o(205413);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getRecycledView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewType", "", "putRecycledView", "", "scrap", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.n
  {
    public final RecyclerView.w cr(int paramInt)
    {
      AppMethodBeat.i(205412);
      RecyclerView.w localw = super.cr(paramInt);
      StringBuilder localStringBuilder;
      View localView;
      if (ad.getLogLevel() <= 1)
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
        ad.d("Finder.RecyclerViewPoolVM", i + " viewType=" + paramInt + " size=" + cq(paramInt));
        AppMethodBeat.o(205412);
        return localw;
        localView = null;
        break;
      }
    }
    
    public final void q(RecyclerView.w paramw)
    {
      AppMethodBeat.i(205411);
      p.h(paramw, "scrap");
      super.q(paramw);
      if (ad.getLogLevel() <= 1) {
        ad.d("Finder.RecyclerViewPoolVM", "putRecycledView hash=" + paramw.auu.hashCode() + " viewType=" + paramw.lQ() + " size=" + cq(paramw.lQ()));
      }
      AppMethodBeat.o(205411);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */