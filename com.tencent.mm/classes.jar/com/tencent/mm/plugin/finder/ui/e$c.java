package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$2", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
public final class e$c
  extends RecyclerView.c
{
  e$c(RecyclerView paramRecyclerView1, LinearLayoutManager paramLinearLayoutManager, e parame, RecyclerView paramRecyclerView2) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(252404);
    super.onChanged();
    this.uMW.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252400);
        e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
        AppMethodBeat.o(252400);
      }
    }, 600L);
    AppMethodBeat.o(252404);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(252405);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    this.uMW.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252401);
        e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
        AppMethodBeat.o(252401);
      }
    }, 600L);
    AppMethodBeat.o(252405);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252406);
    super.onItemRangeInserted(paramInt1, paramInt2);
    this.uMW.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252402);
        e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
        AppMethodBeat.o(252402);
      }
    }, 600L);
    AppMethodBeat.o(252406);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252407);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    this.uMW.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252403);
        e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
        AppMethodBeat.o(252403);
      }
    }, 600L);
    AppMethodBeat.o(252407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e.c
 * JD-Core Version:    0.7.0.1
 */