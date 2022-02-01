package com.tencent.mm.plugin.finder.live.widget.manager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/manager/FinderLiveMsgLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "DEFAULT_SPEED", "", "HARD_CODE_SPEED", "getHARD_CODE_SPEED", "()I", "setHARD_CODE_SPEED", "(I)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveMsgLinearLayoutManager
  extends LinearLayoutManager
{
  private final float Ewp;
  int Ewq;
  private Context context;
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(362341);
    paramRecyclerView = this.context;
    if (paramRecyclerView == null)
    {
      s.bIx("context");
      paramRecyclerView = null;
    }
    for (;;)
    {
      paramRecyclerView = new a(this, paramRecyclerView);
      paramRecyclerView.cag = paramInt;
      startSmoothScroll((RecyclerView.r)paramRecyclerView);
      AppMethodBeat.o(362341);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/manager/FinderLiveMsgLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends o
  {
    a(FinderLiveMsgLinearLayoutManager paramFinderLiveMsgLinearLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(362337);
      s.u(paramDisplayMetrics, "displayMetrics");
      if (this.Ewr.Ewq > 0)
      {
        f = this.Ewr.Ewq / paramDisplayMetrics.densityDpi;
        AppMethodBeat.o(362337);
        return f;
      }
      float f = FinderLiveMsgLinearLayoutManager.a(this.Ewr) / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(362337);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.manager.FinderLiveMsgLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */