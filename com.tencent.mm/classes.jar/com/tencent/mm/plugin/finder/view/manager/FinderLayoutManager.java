package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.MediaBanner.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollVertically", "getCanScrollVertically", "()Z", "setCanScrollVertically", "(Z)V", "scrollState", "scroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "canScrollHorizontally", "onScrollStateChanged", "", "state", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public final class FinderLayoutManager
  extends LinearLayoutManager
  implements MediaBanner.b
{
  public static final a sYD;
  private boolean sYC;
  private int vi;
  
  static
  {
    AppMethodBeat.i(168537);
    sYD = new a((byte)0);
    AppMethodBeat.o(168537);
  }
  
  public FinderLayoutManager()
  {
    super(0);
    AppMethodBeat.i(168536);
    aw(true);
    cb(4);
    this.sYC = true;
    AppMethodBeat.o(168536);
  }
  
  public FinderLayoutManager(byte paramByte)
  {
    AppMethodBeat.i(205360);
    aw(true);
    cb(4);
    this.sYC = true;
    AppMethodBeat.o(205360);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(168532);
    int i = super.a(paramInt, paramo, paramt);
    if ((i == 0) && (paramInt != 0) && (this.vi == 2))
    {
      paramo = getChildAt(0);
      if (paramo == null) {
        break label118;
      }
    }
    label118:
    for (paramo = paramo.getParent();; paramo = null)
    {
      paramt = paramo;
      if (!(paramo instanceof RecyclerView)) {
        paramt = null;
      }
      paramo = (RecyclerView)paramt;
      ad.i("Finder.FinderLayoutManager", "horizontal fling to end, " + paramInt + ' ' + i + ", " + paramo);
      if (paramo != null) {
        paramo.kJ();
      }
      AppMethodBeat.o(168532);
      return i;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(168531);
    ad.i("Finder.FinderLayoutManager", "[smoothScrollToPosition] position=".concat(String.valueOf(paramInt)));
    if (paramRecyclerView != null) {}
    for (paramt = paramRecyclerView.getContext();; paramt = null)
    {
      paramRecyclerView = new b(paramRecyclerView, paramt);
      paramRecyclerView.cz(paramInt);
      a((RecyclerView.s)paramRecyclerView);
      AppMethodBeat.o(168531);
      return;
    }
  }
  
  public final void ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168530);
    super.ag(paramInt1, paramInt2);
    ad.i("Finder.FinderLayoutManager", "[scrollToPositionWithOffset] position=" + paramInt1 + " offset=" + paramInt2);
    AppMethodBeat.o(168530);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(168534);
    int i = super.b(paramInt, paramo, paramt);
    if ((i == 0) && (paramInt != 0) && (this.vi == 2))
    {
      paramo = getChildAt(0);
      if (paramo == null) {
        break label118;
      }
    }
    label118:
    for (paramo = paramo.getParent();; paramo = null)
    {
      paramt = paramo;
      if (!(paramo instanceof RecyclerView)) {
        paramt = null;
      }
      paramo = (RecyclerView)paramt;
      ad.i("Finder.FinderLayoutManager", "vertical fling to end, " + paramInt + ' ' + i + ", " + paramo);
      if (paramo != null) {
        paramo.kJ();
      }
      AppMethodBeat.o(168534);
      return i;
    }
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(168529);
    super.ca(paramInt);
    ad.i("Finder.FinderLayoutManager", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(168529);
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(168533);
    super.cp(paramInt);
    this.vi = paramInt;
    AppMethodBeat.o(168533);
  }
  
  public final boolean kc()
  {
    AppMethodBeat.i(205359);
    boolean bool = super.kc();
    AppMethodBeat.o(205359);
    return bool;
  }
  
  public final boolean kd()
  {
    AppMethodBeat.i(168535);
    if ((this.sYC) && (super.kd()))
    {
      AppMethodBeat.o(168535);
      return true;
    }
    AppMethodBeat.o(168535);
    return false;
  }
  
  public final void mu(boolean paramBoolean)
  {
    this.sYC = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/manager/FinderLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
  public static final class b
    extends ae
  {
    b(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(168528);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 5.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(168528);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager
 * JD-Core Version:    0.7.0.1
 */