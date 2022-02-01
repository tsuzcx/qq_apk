package com.tencent.mm.gpu.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class c$3
  implements Runnable
{
  public c$3(c paramc, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(219527);
    synchronized (c.a(this.gtQ))
    {
      Iterator localIterator = c.a(this.gtQ).values().iterator();
      if (localIterator.hasNext()) {
        ((Map)localIterator.next()).remove(Long.valueOf(this.gtR));
      }
    }
    AppMethodBeat.o(219527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.gpu.d.c.3
 * JD-Core Version:    0.7.0.1
 */