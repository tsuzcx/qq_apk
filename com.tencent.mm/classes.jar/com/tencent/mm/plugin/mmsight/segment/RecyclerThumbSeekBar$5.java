package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecyclerThumbSeekBar$5
  extends RecyclerView.m
{
  RecyclerThumbSeekBar$5(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(54981);
    if ((paramInt == 0) && (RecyclerThumbSeekBar.p(this.oLp) != null)) {
      RecyclerThumbSeekBar.p(this.oLp).V(this.oLp.bRy(), this.oLp.bRz());
    }
    AppMethodBeat.o(54981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.5
 * JD-Core Version:    0.7.0.1
 */