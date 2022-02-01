package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.s.a;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "Companion", "plugin-finder_release"})
public final class FinderAutoScrollLayoutManager
  extends LinearLayoutManager
{
  public static final a sYg;
  
  static
  {
    AppMethodBeat.i(205357);
    sYg = new a((byte)0);
    AppMethodBeat.o(205357);
  }
  
  public FinderAutoScrollLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(205356);
    AppMethodBeat.o(205356);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(205355);
    if (paramRecyclerView != null) {}
    for (paramt = paramRecyclerView.getContext();; paramt = null)
    {
      paramRecyclerView = new b(paramRecyclerView, paramt);
      if (paramInt < 0) {
        break;
      }
      paramRecyclerView.cz(paramInt);
      a((RecyclerView.s)paramRecyclerView);
      AppMethodBeat.o(205355);
      return;
    }
    ad.e("Finder.AutoScrollLayoutManager", "Invalid target position");
    AppMethodBeat.o(205355);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$Companion;", "", "()V", "DURATION_PER_SCREEN", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder_release"})
  public static final class b
    extends ae
  {
    b(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(205352);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 4000.0F / paramDisplayMetrics.widthPixels;
      AppMethodBeat.o(205352);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.t paramt, RecyclerView.s.a parama)
    {
      AppMethodBeat.i(205354);
      p.h(paramView, "targetView");
      p.h(paramt, "state");
      p.h(parama, "action");
      int i = F(paramView, kt());
      int j = E(paramView, ku());
      int k = ce((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        parama.a(-i, -j, k, (Interpolator)this.aqG);
      }
      AppMethodBeat.o(205354);
    }
    
    public final int cd(int paramInt)
    {
      AppMethodBeat.i(205353);
      paramInt = ce(paramInt);
      AppMethodBeat.o(205353);
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