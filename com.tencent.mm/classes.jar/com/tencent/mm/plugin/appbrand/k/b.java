package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b
{
  private volatile int count;
  private final LinkedList<Runnable> irR;
  
  b()
  {
    AppMethodBeat.i(102143);
    this.irR = new LinkedList();
    this.count = 2;
    AppMethodBeat.o(102143);
  }
  
  public final void I(Runnable paramRunnable)
  {
    AppMethodBeat.i(102144);
    Object localObject = null;
    if (paramRunnable != null) {}
    try
    {
      this.irR.addLast(paramRunnable);
      int i = this.count - 1;
      this.count = i;
      paramRunnable = localObject;
      if (i <= 0)
      {
        paramRunnable = localObject;
        if (this.irR.size() > 0)
        {
          paramRunnable = new LinkedList();
          paramRunnable.addAll(this.irR);
          this.irR.clear();
        }
      }
      if (paramRunnable != null)
      {
        paramRunnable = paramRunnable.iterator();
        while (paramRunnable.hasNext()) {
          ((Runnable)paramRunnable.next()).run();
        }
      }
      AppMethodBeat.o(102144);
    }
    finally
    {
      AppMethodBeat.o(102144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.b
 * JD-Core Version:    0.7.0.1
 */