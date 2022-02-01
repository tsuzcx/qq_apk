package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class x$2
  implements Runnable
{
  public x$2(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(44911);
    Iterator localIterator = this.kcr.iterator();
    while (localIterator.hasNext()) {
      x.a((String)localIterator.next(), true, null);
    }
    AppMethodBeat.o(44911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.x.2
 * JD-Core Version:    0.7.0.1
 */