package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

class o$a
  extends RecyclerView.f.c
{
  final boolean aNv()
  {
    return (this.ajj & 0x800) > 0;
  }
  
  public final RecyclerView.f.c c(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(133518);
    super.c(paramv, paramInt);
    this.ajj = paramInt;
    AppMethodBeat.o(133518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.a
 * JD-Core Version:    0.7.0.1
 */