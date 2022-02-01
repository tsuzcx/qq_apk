package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b
{
  private volatile int count;
  private final LinkedList<Runnable> tmf;
  
  b()
  {
    AppMethodBeat.i(147340);
    this.tmf = new LinkedList();
    this.count = 2;
    AppMethodBeat.o(147340);
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(147341);
    Object localObject = null;
    if (paramRunnable != null) {}
    try
    {
      this.tmf.addLast(paramRunnable);
      int i = this.count - 1;
      this.count = i;
      paramRunnable = localObject;
      if (i <= 0)
      {
        paramRunnable = localObject;
        if (this.tmf.size() > 0)
        {
          paramRunnable = new LinkedList();
          paramRunnable.addAll(this.tmf);
          this.tmf.clear();
        }
      }
      if (paramRunnable != null)
      {
        paramRunnable = paramRunnable.iterator();
        while (paramRunnable.hasNext()) {
          ((Runnable)paramRunnable.next()).run();
        }
      }
      AppMethodBeat.o(147341);
    }
    finally
    {
      AppMethodBeat.o(147341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b
 * JD-Core Version:    0.7.0.1
 */