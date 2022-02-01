package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.MediaBanner.b;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollVertically", "getCanScrollVertically", "()Z", "setCanScrollVertically", "(Z)V", "extraLayoutSpace", "getExtraLayoutSpace", "()I", "setExtraLayoutSpace", "(I)V", "isSupportScrollConflictAdapt", "setSupportScrollConflictAdapt", "scrollState", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "touchSlop", "getTouchSlop", "touchSlop$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "init", "", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public final class FinderLinearLayoutManager
  extends LinearLayoutManager
  implements MediaBanner.b
{
  public static final a BfD;
  private final f ALs;
  public float BdV;
  private boolean BfB;
  public boolean BfC;
  private int bFP;
  private Context context;
  public int uqm;
  
  static
  {
    AppMethodBeat.i(233386);
    BfD = new a((byte)0);
    AppMethodBeat.o(233386);
  }
  
  public FinderLinearLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(233380);
    this.ALs = g.ar((a)new c(this));
    setItemPrefetchEnabled(true);
    cC(6);
    this.BdV = 5.0F;
    this.uqm = -1;
    this.BfC = true;
    init(paramContext);
    AppMethodBeat.o(233380);
  }
  
  public FinderLinearLayoutManager(Context paramContext, byte paramByte)
  {
    super(0, false);
    AppMethodBeat.i(233384);
    this.ALs = g.ar((a)new c(this));
    setItemPrefetchEnabled(true);
    cC(6);
    this.BdV = 5.0F;
    this.uqm = -1;
    this.BfC = true;
    init(paramContext);
    AppMethodBeat.o(233384);
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(233344);
    int i = ((Number)this.ALs.getValue()).intValue();
    AppMethodBeat.o(233344);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(233346);
    kotlin.g.b.p.k(paramContext, "context");
    this.context = paramContext;
    AppMethodBeat.o(233346);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233356);
    super.au(paramInt1, paramInt2);
    Log.i("Finder.FinderLayoutManager", "[scrollToPositionWithOffset] position=" + paramInt1 + " offset=" + paramInt2);
    AppMethodBeat.o(233356);
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(233348);
    if (this.uqm == -1)
    {
      i = super.b(params);
      AppMethodBeat.o(233348);
      return i;
    }
    int i = this.uqm;
    AppMethodBeat.o(233348);
    return i;
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(233372);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(233372);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(233370);
    if ((this.BfC) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(233370);
      return true;
    }
    AppMethodBeat.o(233370);
    return false;
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(233366);
    super.onScrollStateChanged(paramInt);
    this.bFP = paramInt;
    AppMethodBeat.o(233366);
  }
  
  public final void rw(boolean paramBoolean)
  {
    this.BfC = paramBoolean;
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(233364);
    if ((this.BfB) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollHorizontallyBy(paramInt, paramn, params);
      AppMethodBeat.o(233364);
      return paramInt;
    }
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.bFP == 2))
    {
      paramn = getChildAt(0);
      if (paramn == null) {
        break label151;
      }
    }
    label151:
    for (paramn = paramn.getParent();; paramn = null)
    {
      params = paramn;
      if (!(paramn instanceof RecyclerView)) {
        params = null;
      }
      paramn = (RecyclerView)params;
      Log.i("Finder.FinderLayoutManager", "horizontal fling to end, " + paramInt + ' ' + i + ", " + paramn);
      if (paramn != null) {
        paramn.ld();
      }
      AppMethodBeat.o(233364);
      return i;
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(233353);
    super.scrollToPosition(paramInt);
    Log.i("Finder.FinderLayoutManager", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(233353);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(233368);
    if ((this.BfB) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(233368);
      return paramInt;
    }
    int i = super.scrollVerticallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.bFP == 2))
    {
      paramn = getChildAt(0);
      if (paramn == null) {
        break label155;
      }
    }
    label155:
    for (paramn = paramn.getParent();; paramn = null)
    {
      params = paramn;
      if (!(paramn instanceof RecyclerView)) {
        params = null;
      }
      paramn = (RecyclerView)params;
      Log.i("Finder.FinderLayoutManager", "vertical fling to end, " + paramInt + ' ' + i + ", " + paramn);
      if (paramn != null) {
        paramn.ld();
      }
      AppMethodBeat.o(233368);
      return i;
    }
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(233360);
    Log.i("Finder.FinderLayoutManager", "[smoothScrollToPosition] position=".concat(String.valueOf(paramInt)));
    paramRecyclerView = this.context;
    if (paramRecyclerView == null) {
      kotlin.g.b.p.bGy("context");
    }
    paramRecyclerView = new b(this, paramRecyclerView);
    paramRecyclerView.cV(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(233360);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
  public static final class b
    extends androidx.recyclerview.widget.p
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(282244);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = this.BfE.BdV / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(282244);
      return f;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Integer>
  {
    c(FinderLinearLayoutManager paramFinderLinearLayoutManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */