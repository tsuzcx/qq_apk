package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends RecyclerView.c
{
  a$1(a parama) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(255170);
    super.onChanged();
    a.a(this.wiN);
    AppMethodBeat.o(255170);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255172);
    super.onItemRangeChanged(paramInt1, paramInt2);
    a.a(this.wiN);
    AppMethodBeat.o(255172);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(255173);
    super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    a.a(this.wiN);
    AppMethodBeat.o(255173);
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255174);
    super.onItemRangeInserted(paramInt1, paramInt2);
    a.a(this.wiN);
    AppMethodBeat.o(255174);
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(255176);
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    a.a(this.wiN);
    AppMethodBeat.o(255176);
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255175);
    super.onItemRangeRemoved(paramInt1, paramInt2);
    a.a(this.wiN);
    AppMethodBeat.o(255175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */