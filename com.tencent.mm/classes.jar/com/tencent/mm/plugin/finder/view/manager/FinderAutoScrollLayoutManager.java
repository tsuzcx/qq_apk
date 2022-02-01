package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "Companion", "plugin-finder_release"})
public final class FinderAutoScrollLayoutManager
  extends LinearLayoutManager
{
  public static final a wsO;
  
  static
  {
    AppMethodBeat.i(255258);
    wsO = new a((byte)0);
    AppMethodBeat.o(255258);
  }
  
  public FinderAutoScrollLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(255257);
    AppMethodBeat.o(255257);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(255256);
    if (paramRecyclerView != null) {}
    for (params = paramRecyclerView.getContext();; params = null)
    {
      paramRecyclerView = new b(paramRecyclerView, params);
      if (paramInt < 0) {
        break;
      }
      paramRecyclerView.ct(paramInt);
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(255256);
      return;
    }
    Log.e("Finder.AutoScrollLayoutManager", "Invalid target position");
    AppMethodBeat.o(255256);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$Companion;", "", "()V", "DURATION_PER_SCREEN", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder_release"})
  public static final class b
    extends ae
  {
    b(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(255253);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 4000.0F / paramDisplayMetrics.widthPixels;
      AppMethodBeat.o(255253);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(255255);
      p.h(paramView, "targetView");
      p.h(params, "state");
      p.h(parama, "action");
      int i = F(paramView, kz());
      int j = E(paramView, kA());
      int k = cd((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        parama.a(-i, -j, k, (Interpolator)this.aqS);
      }
      AppMethodBeat.o(255255);
    }
    
    public final int cc(int paramInt)
    {
      AppMethodBeat.i(255254);
      paramInt = cd(paramInt);
      AppMethodBeat.o(255254);
      return paramInt;
    }
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt4 - paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager
 * JD-Core Version:    0.7.0.1
 */