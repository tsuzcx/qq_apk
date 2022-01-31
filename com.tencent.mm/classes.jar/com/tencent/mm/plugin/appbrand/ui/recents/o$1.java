package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class o$1
  implements RecyclerView.f.a
{
  o$1(o paramo) {}
  
  public final void jx()
  {
    AppMethodBeat.i(133503);
    Iterator localIterator = this.iVw.iVf.iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.f.a)localIterator.next()).jx();
    }
    this.iVw.iVv = false;
    AppMethodBeat.o(133503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.1
 * JD-Core Version:    0.7.0.1
 */