package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;

final class h$a
{
  final SparseIntArray jla;
  
  private h$a()
  {
    AppMethodBeat.i(123619);
    this.jla = new SparseIntArray();
    AppMethodBeat.o(123619);
  }
  
  final void a(ap paramap, int paramInt)
  {
    AppMethodBeat.i(123621);
    this.jla.put(paramap.hashCode(), paramInt);
    AppMethodBeat.o(123621);
  }
  
  final int e(ap paramap)
  {
    AppMethodBeat.i(123620);
    int i = this.jla.get(paramap.hashCode(), 0);
    AppMethodBeat.o(123620);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h.a
 * JD-Core Version:    0.7.0.1
 */