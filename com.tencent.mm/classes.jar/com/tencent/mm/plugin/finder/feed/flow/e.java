package com.tencent.mm.plugin.finder.feed.flow;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends RecyclerView.c
{
  RecyclerView.LayoutManager BcY;
  boolean BcZ;
  Integer Bda = null;
  int Bdb = 0;
  Integer Bdc = null;
  int Bdd = 0;
  boolean isRegistered;
  int pyp;
  int pyq;
  
  public e(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.BcY = paramLayoutManager;
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363606);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    this.BcZ = true;
    this.Bda = Integer.valueOf(this.Bdb);
    this.Bdc = Integer.valueOf(this.Bdd);
    AppMethodBeat.o(363606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.e
 * JD-Core Version:    0.7.0.1
 */