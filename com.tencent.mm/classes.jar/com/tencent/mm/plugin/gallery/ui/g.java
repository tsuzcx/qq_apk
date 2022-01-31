package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends LinearLayoutManager
{
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(21604);
    paramRecyclerView = new g.1(this, paramRecyclerView.getContext());
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(21604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */