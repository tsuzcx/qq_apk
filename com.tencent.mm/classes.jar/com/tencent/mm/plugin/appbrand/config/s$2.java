package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class s$2
  implements Runnable
{
  public s$2(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(129906);
    Iterator localIterator = this.hjA.iterator();
    while (localIterator.hasNext()) {
      s.ac((String)localIterator.next(), true);
    }
    AppMethodBeat.o(129906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s.2
 * JD-Core Version:    0.7.0.1
 */