package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends RecyclerView.c
{
  a$1(a parama) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(220455);
    super.onChanged();
    a.a(this.sCT);
    AppMethodBeat.o(220455);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220456);
    super.onItemRangeChanged(paramInt1, paramInt2);
    a.a(this.sCT);
    AppMethodBeat.o(220456);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(220457);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    a.a(this.sCT);
    AppMethodBeat.o(220457);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220458);
    super.onItemRangeInserted(paramInt1, paramInt2);
    a.a(this.sCT);
    AppMethodBeat.o(220458);
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220460);
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    a.a(this.sCT);
    AppMethodBeat.o(220460);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220459);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    a.a(this.sCT);
    AppMethodBeat.o(220459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */