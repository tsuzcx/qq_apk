package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends RecyclerView.c
{
  a$1(a parama) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(300502);
    super.onChanged();
    a.a(this.zEQ);
    AppMethodBeat.o(300502);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300507);
    super.onItemRangeChanged(paramInt1, paramInt2);
    a.a(this.zEQ);
    AppMethodBeat.o(300507);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(300513);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    a.a(this.zEQ);
    AppMethodBeat.o(300513);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300521);
    super.onItemRangeInserted(paramInt1, paramInt2);
    a.a(this.zEQ);
    AppMethodBeat.o(300521);
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(300533);
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    a.a(this.zEQ);
    AppMethodBeat.o(300533);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300528);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    a.a(this.zEQ);
    AppMethodBeat.o(300528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */