package com.tencent.liteav.basic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class a
{
  private final LinkedList<Runnable> a;
  
  public a()
  {
    AppMethodBeat.i(229910);
    this.a = new LinkedList();
    AppMethodBeat.o(229910);
  }
  
  public void a()
  {
    AppMethodBeat.i(229924);
    Object localObject1 = null;
    synchronized (this.a)
    {
      if (!this.a.isEmpty())
      {
        localObject1 = new LinkedList(this.a);
        this.a.clear();
      }
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
      }
    }
    AppMethodBeat.o(229924);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(229916);
    synchronized (this.a)
    {
      this.a.add(paramRunnable);
      AppMethodBeat.o(229916);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.basic.a.a
 * JD-Core Version:    0.7.0.1
 */