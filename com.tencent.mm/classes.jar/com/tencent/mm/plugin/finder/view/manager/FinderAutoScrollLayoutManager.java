package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "Companion", "plugin-finder_release"})
public final class FinderAutoScrollLayoutManager
  extends LinearLayoutManager
{
  public static final a Bff;
  
  static
  {
    AppMethodBeat.i(274046);
    Bff = new a((byte)0);
    AppMethodBeat.o(274046);
  }
  
  public FinderAutoScrollLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(274045);
    AppMethodBeat.o(274045);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(274044);
    if (paramRecyclerView != null) {}
    for (params = paramRecyclerView.getContext();; params = null)
    {
      paramRecyclerView = new b(paramRecyclerView, params);
      if (paramInt < 0) {
        break;
      }
      paramRecyclerView.cV(paramInt);
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(274044);
      return;
    }
    Log.e("Finder.AutoScrollLayoutManager", "Invalid target position");
    AppMethodBeat.o(274044);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$Companion;", "", "()V", "DURATION_PER_SCREEN", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder_release"})
  public static final class b
    extends androidx.recyclerview.widget.p
  {
    b(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(273225);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 4000.0F / paramDisplayMetrics.widthPixels;
      AppMethodBeat.o(273225);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(273229);
      kotlin.g.b.p.k(paramView, "targetView");
      kotlin.g.b.p.k(params, "state");
      kotlin.g.b.p.k(parama, "action");
      int i = F(paramView, kQ());
      int j = E(paramView, kR());
      int k = cF((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        parama.a(-i, -j, k, (Interpolator)this.ajt);
      }
      AppMethodBeat.o(273229);
    }
    
    public final int cE(int paramInt)
    {
      AppMethodBeat.i(273227);
      paramInt = cF(paramInt);
      AppMethodBeat.o(273227);
      return paramInt;
    }
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt4 - paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager
 * JD-Core Version:    0.7.0.1
 */