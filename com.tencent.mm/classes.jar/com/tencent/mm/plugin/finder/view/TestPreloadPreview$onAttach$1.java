package com.tencent.mm.plugin.finder.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$onAttach$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TestPreloadPreview$onAttach$1
  extends LinearLayoutManager
{
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(344378);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(344378);
      return;
    }
    finally
    {
      Log.e("TestPreloadView", "onLayoutChildren:", new Object[] { paramn });
      AppMethodBeat.o(344378);
    }
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int i = 0;
    AppMethodBeat.i(344382);
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(344382);
      return paramInt;
    }
    finally
    {
      for (;;)
      {
        Log.e("TestPreloadView", "scrollVerticallyBy:", new Object[] { paramn });
        paramInt = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview.onAttach.1
 * JD-Core Version:    0.7.0.1
 */