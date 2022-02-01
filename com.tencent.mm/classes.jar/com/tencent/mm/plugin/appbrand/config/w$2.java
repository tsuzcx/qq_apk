package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class w$2
  implements Runnable
{
  public w$2(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(44911);
    Iterator localIterator = this.jEV.iterator();
    while (localIterator.hasNext()) {
      w.a((String)localIterator.next(), true, null);
    }
    AppMethodBeat.o(44911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w.2
 * JD-Core Version:    0.7.0.1
 */