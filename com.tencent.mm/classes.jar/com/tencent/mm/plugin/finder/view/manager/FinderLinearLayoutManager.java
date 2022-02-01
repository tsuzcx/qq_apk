package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.MediaBanner.b;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollVertically", "getCanScrollVertically", "()Z", "setCanScrollVertically", "(Z)V", "isSupportScrollConflictAdapt", "setSupportScrollConflictAdapt", "scrollState", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "init", "", "onScrollStateChanged", "state", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public final class FinderLinearLayoutManager
  extends LinearLayoutManager
  implements MediaBanner.b
{
  public static final a wtm;
  private Context context;
  private int vp;
  private final f wcJ;
  public float wsx;
  private boolean wtk;
  public boolean wtl;
  
  static
  {
    AppMethodBeat.i(255279);
    wtm = new a((byte)0);
    AppMethodBeat.o(255279);
  }
  
  public FinderLinearLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(255277);
    this.wcJ = g.ah((a)new c(this));
    setItemPrefetchEnabled(true);
    ca(6);
    this.wsx = 5.0F;
    this.wtl = true;
    init(paramContext);
    AppMethodBeat.o(255277);
  }
  
  public FinderLinearLayoutManager(Context paramContext, byte paramByte)
  {
    super(0, false);
    AppMethodBeat.i(255278);
    this.wcJ = g.ah((a)new c(this));
    setItemPrefetchEnabled(true);
    ca(6);
    this.wsx = 5.0F;
    this.wtl = true;
    init(paramContext);
    AppMethodBeat.o(255278);
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(255267);
    int i = ((Number)this.wcJ.getValue()).intValue();
    AppMethodBeat.o(255267);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(255268);
    p.h(paramContext, "context");
    this.context = paramContext;
    AppMethodBeat.o(255268);
  }
  
  public final void ah(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255270);
    super.ah(paramInt1, paramInt2);
    Log.i("Finder.FinderLayoutManager", "[scrollToPositionWithOffset] position=" + paramInt1 + " offset=" + paramInt2);
    AppMethodBeat.o(255270);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(255276);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(255276);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(255275);
    if ((this.wtl) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(255275);
      return true;
    }
    AppMethodBeat.o(255275);
    return false;
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(255273);
    super.onScrollStateChanged(paramInt);
    this.vp = paramInt;
    AppMethodBeat.o(255273);
  }
  
  public final void pc(boolean paramBoolean)
  {
    this.wtl = paramBoolean;
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(255272);
    if ((this.wtk) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollHorizontallyBy(paramInt, paramn, params);
      AppMethodBeat.o(255272);
      return paramInt;
    }
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.vp == 2))
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
        paramn.kQ();
      }
      AppMethodBeat.o(255272);
      return i;
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(255269);
    super.scrollToPosition(paramInt);
    Log.i("Finder.FinderLayoutManager", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(255269);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(255274);
    if ((this.wtk) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(255274);
      return paramInt;
    }
    int i = super.scrollVerticallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.vp == 2))
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
        paramn.kQ();
      }
      AppMethodBeat.o(255274);
      return i;
    }
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(255271);
    Log.i("Finder.FinderLayoutManager", "[smoothScrollToPosition] position=".concat(String.valueOf(paramInt)));
    paramRecyclerView = this.context;
    if (paramRecyclerView == null) {
      p.btv("context");
    }
    paramRecyclerView = new b(this, paramRecyclerView);
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(255271);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
  public static final class b
    extends ae
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(255265);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = this.wtn.wsx / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(255265);
      return f;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */