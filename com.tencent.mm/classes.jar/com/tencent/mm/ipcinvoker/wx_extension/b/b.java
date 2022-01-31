package com.tencent.mm.ipcinvoker.wx_extension.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private final List<b.b<a>> eEX;
  private final List<Object> eEY;
  
  private b()
  {
    AppMethodBeat.i(126214);
    this.eEX = new LinkedList();
    this.eEY = new LinkedList();
    AppMethodBeat.o(126214);
  }
  
  private void PW()
  {
    try
    {
      AppMethodBeat.i(126219);
      Iterator localIterator = this.eEY.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(126219);
    }
    finally {}
  }
  
  private void PX()
  {
    try
    {
      AppMethodBeat.i(126220);
      Iterator localIterator = this.eEY.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(126220);
    }
    finally {}
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(126215);
    if (c(parama))
    {
      AppMethodBeat.o(126215);
      return false;
    }
    synchronized (this.eEX)
    {
      this.eEX.add(new b.b(parama));
      PW();
      AppMethodBeat.o(126215);
      return true;
    }
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(126216);
    if (parama == null)
    {
      AppMethodBeat.o(126216);
      return false;
    }
    synchronized (this.eEX)
    {
      boolean bool = this.eEX.remove(new b.b(parama));
      PX();
      AppMethodBeat.o(126216);
      return bool;
    }
  }
  
  public final boolean c(a parama)
  {
    AppMethodBeat.i(126217);
    if (parama == null)
    {
      AppMethodBeat.o(126217);
      return false;
    }
    synchronized (this.eEX)
    {
      Iterator localIterator = this.eEX.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b.b)localIterator.next();
        if (localObject != null)
        {
          localObject = (a)((b.b)localObject).get();
          if ((localObject != null) && (parama.equals(localObject)))
          {
            AppMethodBeat.o(126217);
            return true;
          }
        }
      }
      AppMethodBeat.o(126217);
      return false;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(126218);
    synchronized (this.eEX)
    {
      int i = this.eEX.size();
      AppMethodBeat.o(126218);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b
 * JD-Core Version:    0.7.0.1
 */