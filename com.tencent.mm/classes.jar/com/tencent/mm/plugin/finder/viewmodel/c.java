package com.tencent.mm.plugin.finder.viewmodel;

import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.s.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroidx/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "fullFoldedLayoutViewPool", "getFullFoldedLayoutViewPool", "setFullFoldedLayoutViewPool", "fullTimeLinePool", "getFullTimeLinePool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class c
  extends x
{
  public static final a Bhb;
  public final RecyclerView.m BgT;
  public final RecyclerView.m BgU;
  public RecyclerView.m BgV;
  public RecyclerView.m BgW;
  public RecyclerView.m BgX;
  public RecyclerView.m BgY;
  private RecyclerView.m BgZ;
  public RecyclerView.m Bha;
  public RecyclerView.m xvD;
  
  static
  {
    AppMethodBeat.i(288683);
    Bhb = new a((byte)0);
    AppMethodBeat.o(288683);
  }
  
  public c()
  {
    AppMethodBeat.i(288682);
    Object localObject = new c();
    ((c)localObject).aJ(4, 18);
    ((c)localObject).aJ(2, 6);
    ((c)localObject).aJ(2003, 0);
    this.BgT = ((RecyclerView.m)localObject);
    localObject = new b();
    ((b)localObject).aJ(4, 18);
    ((b)localObject).aJ(2, 6);
    this.BgU = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aJ(2, 16);
    ((RecyclerView.m)localObject).aJ(4, 12);
    this.xvD = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aJ(4, 20);
    ((RecyclerView.m)localObject).aJ(2, 20);
    ((RecyclerView.m)localObject).aJ(-3, 2);
    ((RecyclerView.m)localObject).aJ(2003, 0);
    this.BgV = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aJ(4, 20);
    ((RecyclerView.m)localObject).aJ(2, 20);
    ((RecyclerView.m)localObject).aJ(-3, 2);
    this.BgW = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    s.a locala = s.zAx;
    ((RecyclerView.m)localObject).aJ(s.dKv(), 10);
    locala = s.zAx;
    ((RecyclerView.m)localObject).aJ(s.dKw(), 10);
    this.BgX = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    locala = s.zAx;
    ((RecyclerView.m)localObject).aJ(s.dKv(), 10);
    locala = s.zAx;
    ((RecyclerView.m)localObject).aJ(s.dKw(), 5);
    this.BgY = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aJ(4, 10);
    ((RecyclerView.m)localObject).aJ(2, 10);
    this.BgZ = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aJ(4, 10);
    this.Bha = ((RecyclerView.m)localObject);
    AppMethodBeat.o(288682);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$fullTimeLinePool$1", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */