package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

final class ag$3
  implements at
{
  ag$3(ag paramag) {}
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(281093);
    Iterator localIterator = new HashSet(ag.a(this.qth)).iterator();
    while (localIterator.hasNext())
    {
      at localat = (at)localIterator.next();
      if (localat != null) {
        localat.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    AppMethodBeat.o(281093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag.3
 * JD-Core Version:    0.7.0.1
 */