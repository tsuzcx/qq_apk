package com.tencent.mm.plugin.finder.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
public final class e$c
  extends RecyclerView.c
{
  e$c(RecyclerView paramRecyclerView1, LinearLayoutManager paramLinearLayoutManager, e parame, RecyclerView paramRecyclerView2) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(276014);
    super.onChanged();
    this.xMC.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276007);
        e.a(this.Aro.Arl, this.Aro.xMC, this.Aro.xDp, true);
        AppMethodBeat.o(276007);
      }
    }, 600L);
    AppMethodBeat.o(276014);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(276015);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    this.xMC.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228145);
        e.a(this.Aro.Arl, this.Aro.xMC, this.Aro.xDp, true);
        AppMethodBeat.o(228145);
      }
    }, 600L);
    AppMethodBeat.o(276015);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276016);
    super.onItemRangeInserted(paramInt1, paramInt2);
    this.xMC.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(290704);
        e.a(this.Aro.Arl, this.Aro.xMC, this.Aro.xDp, true);
        AppMethodBeat.o(290704);
      }
    }, 600L);
    AppMethodBeat.o(276016);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276017);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    this.xMC.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287558);
        e.a(this.Aro.Arl, this.Aro.xMC, this.Aro.xDp, true);
        AppMethodBeat.o(287558);
      }
    }, 600L);
    AppMethodBeat.o(276017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e.c
 * JD-Core Version:    0.7.0.1
 */