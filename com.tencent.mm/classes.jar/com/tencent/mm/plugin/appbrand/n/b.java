package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b
{
  private volatile int count;
  private final LinkedList<Runnable> lvs;
  
  b()
  {
    AppMethodBeat.i(147340);
    this.lvs = new LinkedList();
    this.count = 2;
    AppMethodBeat.o(147340);
  }
  
  public final void aa(Runnable paramRunnable)
  {
    AppMethodBeat.i(147341);
    Object localObject = null;
    if (paramRunnable != null) {}
    try
    {
      this.lvs.addLast(paramRunnable);
      int i = this.count - 1;
      this.count = i;
      paramRunnable = localObject;
      if (i <= 0)
      {
        paramRunnable = localObject;
        if (this.lvs.size() > 0)
        {
          paramRunnable = new LinkedList();
          paramRunnable.addAll(this.lvs);
          this.lvs.clear();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b
 * JD-Core Version:    0.7.0.1
 */