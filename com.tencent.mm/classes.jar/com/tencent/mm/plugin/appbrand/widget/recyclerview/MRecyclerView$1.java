package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MRecyclerView$1
  extends RecyclerView.c
{
  MRecyclerView$1(MRecyclerView paramMRecyclerView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(77491);
    View localView;
    if (MRecyclerView.a(this.jww) != null)
    {
      localView = MRecyclerView.a(this.jww);
      if (!this.jww.aSm()) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(77491);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */