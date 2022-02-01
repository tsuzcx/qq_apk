package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.s.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool;", "Landroid/arch/lifecycle/ViewModel;", "()V", "bulletSubtitleViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getBulletSubtitleViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setBulletSubtitleViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "commentDrawerViewPool", "getCommentDrawerViewPool", "setCommentDrawerViewPool", "foldedLayoutViewPool", "getFoldedLayoutViewPool", "setFoldedLayoutViewPool", "fullFoldedLayoutViewPool", "getFullFoldedLayoutViewPool", "setFullFoldedLayoutViewPool", "fullTimeLinePool", "getFullTimeLinePool", "gridViewPool", "getGridViewPool", "setGridViewPool", "mediaBannerViewPool", "getMediaBannerViewPool", "setMediaBannerViewPool", "staggeredViewPool", "getStaggeredViewPool", "setStaggeredViewPool", "timelinePool", "getTimelinePool", "Companion", "plugin-finder_release"})
public final class FinderRecyclerViewPool
  extends ViewModel
{
  public static final a wuC;
  public RecyclerView.m tLO;
  private RecyclerView.m wuA;
  public RecyclerView.m wuB;
  public final RecyclerView.m wuu;
  public final RecyclerView.m wuv;
  public RecyclerView.m wuw;
  public RecyclerView.m wux;
  public RecyclerView.m wuy;
  public RecyclerView.m wuz;
  
  static
  {
    AppMethodBeat.i(255359);
    wuC = new a((byte)0);
    AppMethodBeat.o(255359);
  }
  
  public FinderRecyclerViewPool()
  {
    AppMethodBeat.i(255358);
    Object localObject = new c();
    ((c)localObject).aw(4, 18);
    ((c)localObject).aw(2, 6);
    ((c)localObject).aw(2003, 0);
    this.wuu = ((RecyclerView.m)localObject);
    localObject = new b();
    ((b)localObject).aw(4, 18);
    ((b)localObject).aw(2, 6);
    this.wuv = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aw(2, 16);
    ((RecyclerView.m)localObject).aw(4, 12);
    this.tLO = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aw(4, 20);
    ((RecyclerView.m)localObject).aw(2, 20);
    ((RecyclerView.m)localObject).aw(-3, 2);
    ((RecyclerView.m)localObject).aw(2003, 0);
    this.wuw = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aw(4, 20);
    ((RecyclerView.m)localObject).aw(2, 20);
    ((RecyclerView.m)localObject).aw(-3, 2);
    this.wux = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    s.a locala = s.uOj;
    ((RecyclerView.m)localObject).aw(s.dky(), 10);
    locala = s.uOj;
    ((RecyclerView.m)localObject).aw(s.dkz(), 10);
    this.wuy = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    locala = s.uOj;
    ((RecyclerView.m)localObject).aw(s.dky(), 10);
    locala = s.uOj;
    ((RecyclerView.m)localObject).aw(s.dkz(), 5);
    this.wuz = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aw(4, 10);
    ((RecyclerView.m)localObject).aw(2, 10);
    this.wuA = ((RecyclerView.m)localObject);
    localObject = new RecyclerView.m();
    ((RecyclerView.m)localObject).aw(4, 10);
    this.wuB = ((RecyclerView.m)localObject);
    AppMethodBeat.o(255358);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$fullTimeLinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.m
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/FinderRecyclerViewPool$timelinePool$1", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */