package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MRecyclerView$3
  implements c
{
  MRecyclerView$3(MRecyclerView paramMRecyclerView) {}
  
  public final boolean M(View paramView, int paramInt)
  {
    AppMethodBeat.i(77493);
    if (MRecyclerView.c(this.jww) != null)
    {
      boolean bool = MRecyclerView.c(this.jww).O(paramView, paramInt);
      AppMethodBeat.o(77493);
      return bool;
    }
    AppMethodBeat.o(77493);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.3
 * JD-Core Version:    0.7.0.1
 */