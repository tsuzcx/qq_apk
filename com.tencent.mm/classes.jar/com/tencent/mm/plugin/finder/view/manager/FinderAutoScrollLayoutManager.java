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
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAutoScrollLayoutManager
  extends LinearLayoutManager
{
  public static final FinderAutoScrollLayoutManager.a GHJ;
  
  static
  {
    AppMethodBeat.i(346091);
    GHJ = new FinderAutoScrollLayoutManager.a((byte)0);
    AppMethodBeat.o(346091);
  }
  
  public FinderAutoScrollLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(346088);
    AppMethodBeat.o(346088);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(346098);
    if (paramRecyclerView == null) {}
    for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.getContext())
    {
      paramRecyclerView = new b(paramRecyclerView);
      if (paramInt < 0) {
        break;
      }
      paramRecyclerView.cag = paramInt;
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(346098);
      return;
    }
    Log.e("Finder.AutoScrollLayoutManager", "Invalid target position");
    AppMethodBeat.o(346098);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends o
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(346100);
      s.u(paramView, "targetView");
      s.u(params, "state");
      s.u(parama, "action");
      int i = J(paramView, JB());
      int j = I(paramView, JC());
      int k = fP((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        parama.a(-i, -j, k, (Interpolator)this.bXX);
      }
      AppMethodBeat.o(346100);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(346087);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 4000.0F / paramDisplayMetrics.widthPixels;
      AppMethodBeat.o(346087);
      return f;
    }
    
    public final int fO(int paramInt)
    {
      AppMethodBeat.i(346092);
      paramInt = fP(paramInt);
      AppMethodBeat.o(346092);
      return paramInt;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt4 - paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager
 * JD-Core Version:    0.7.0.1
 */