package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.MediaBanner.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollVertically", "getCanScrollVertically", "()Z", "setCanScrollVertically", "(Z)V", "extraLayoutSpace", "getExtraLayoutSpace", "()I", "setExtraLayoutSpace", "(I)V", "isSupportScrollConflictAdapt", "setSupportScrollConflictAdapt", "scrollState", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "touchSlop", "getTouchSlop", "touchSlop$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "init", "", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLinearLayoutManager
  extends LinearLayoutManager
  implements MediaBanner.b
{
  public static final FinderLinearLayoutManager.a GHS;
  private final j Fmi;
  public float GGx;
  private boolean GHT;
  public boolean GHU;
  private Context context;
  private int dyP;
  public int xwJ;
  
  static
  {
    AppMethodBeat.i(346128);
    GHS = new FinderLinearLayoutManager.a((byte)0);
    AppMethodBeat.o(346128);
  }
  
  public FinderLinearLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(346106);
    this.Fmi = k.cm((a)new c(this));
    setItemPrefetchEnabled(false);
    this.GGx = 5.0F;
    this.xwJ = -1;
    this.GHU = true;
    init(paramContext);
    AppMethodBeat.o(346106);
  }
  
  public FinderLinearLayoutManager(Context paramContext, byte paramByte)
  {
    super(0, false);
    AppMethodBeat.i(346109);
    this.Fmi = k.cm((a)new c(this));
    setItemPrefetchEnabled(false);
    this.GGx = 5.0F;
    this.xwJ = -1;
    this.GHU = true;
    init(paramContext);
    AppMethodBeat.o(346109);
  }
  
  private final int getTouchSlop()
  {
    AppMethodBeat.i(346104);
    int i = ((Number)this.Fmi.getValue()).intValue();
    AppMethodBeat.o(346104);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(346114);
    s.u(paramContext, "context");
    this.context = paramContext;
    AppMethodBeat.o(346114);
  }
  
  public final int b(RecyclerView.s params)
  {
    return 100;
  }
  
  public final void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346153);
    super.bo(paramInt1, paramInt2);
    Log.i("Finder.FinderLayoutManager", "[scrollToPositionWithOffset] position=" + paramInt1 + " offset=" + paramInt2);
    AppMethodBeat.o(346153);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(346182);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(346182);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(346179);
    if ((this.GHU) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(346179);
      return true;
    }
    AppMethodBeat.o(346179);
    return false;
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(346170);
    super.onScrollStateChanged(paramInt);
    this.dyP = paramInt;
    AppMethodBeat.o(346170);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(346167);
    if ((this.GHT) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollHorizontallyBy(paramInt, paramn, params);
      AppMethodBeat.o(346167);
      return paramInt;
    }
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.dyP == 2))
    {
      paramn = getChildAt(0);
      if (paramn != null) {
        break label144;
      }
      paramn = null;
      if (!(paramn instanceof RecyclerView)) {
        break label152;
      }
    }
    label144:
    label152:
    for (paramn = (RecyclerView)paramn;; paramn = null)
    {
      Log.i("Finder.FinderLayoutManager", "horizontal fling to end, " + paramInt + ' ' + i + ", " + paramn);
      if (paramn != null) {
        paramn.JO();
      }
      AppMethodBeat.o(346167);
      return i;
      paramn = paramn.getParent();
      break;
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(346144);
    super.scrollToPosition(paramInt);
    Log.i("Finder.FinderLayoutManager", s.X("[scrollToPosition] position=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(346144);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(346175);
    if ((this.GHT) && (Math.abs(paramInt) >= getTouchSlop()))
    {
      super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(346175);
      return paramInt;
    }
    int i = super.scrollVerticallyBy(paramInt, paramn, params);
    if ((i == 0) && (paramInt != 0) && (this.dyP == 2))
    {
      paramn = getChildAt(0);
      if (paramn != null) {
        break label148;
      }
      paramn = null;
      if (!(paramn instanceof RecyclerView)) {
        break label156;
      }
    }
    label148:
    label156:
    for (paramn = (RecyclerView)paramn;; paramn = null)
    {
      Log.i("Finder.FinderLayoutManager", "vertical fling to end, " + paramInt + ' ' + i + ", " + paramn);
      if (paramn != null) {
        paramn.JO();
      }
      AppMethodBeat.o(346175);
      return i;
      paramn = paramn.getParent();
      break;
    }
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(346159);
    Log.i("Finder.FinderLayoutManager", s.X("[smoothScrollToPosition] position=", Integer.valueOf(paramInt)));
    paramRecyclerView = this.context;
    if (paramRecyclerView == null)
    {
      s.bIx("context");
      paramRecyclerView = null;
    }
    for (;;)
    {
      paramRecyclerView = new b(this, paramRecyclerView);
      paramRecyclerView.cag = paramInt;
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(346159);
      return;
    }
  }
  
  public final void vd(boolean paramBoolean)
  {
    this.GHU = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends o
  {
    b(FinderLinearLayoutManager paramFinderLinearLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(346102);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = this.GHV.GGx / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(346102);
      return f;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
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