package com.tencent.mm.cg.a;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends DataSetObserver
{
  e$1(e parame) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(59146);
    e.a(this.yRu);
    AppMethodBeat.o(59146);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(59147);
    e.b(this.yRu);
    AppMethodBeat.o(59147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cg.a.e.1
 * JD-Core Version:    0.7.0.1
 */