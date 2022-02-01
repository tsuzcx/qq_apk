package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E>
  extends LinkedList<E>
{
  private byte[] lock;
  
  public h()
  {
    AppMethodBeat.i(111324);
    this.lock = new byte[0];
    AppMethodBeat.o(111324);
  }
  
  private boolean aM(E paramE)
  {
    AppMethodBeat.i(111326);
    synchronized (this.lock)
    {
      boolean bool = super.contains(paramE);
      AppMethodBeat.o(111326);
      return bool;
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(111328);
    synchronized (this.lock)
    {
      boolean bool = super.add(paramE);
      AppMethodBeat.o(111328);
      return bool;
    }
  }
  
  public final E cXS()
  {
    AppMethodBeat.i(111325);
    synchronized (this.lock)
    {
      if (size() > 0)
      {
        Object localObject1 = super.poll();
        AppMethodBeat.o(111325);
        return localObject1;
      }
      AppMethodBeat.o(111325);
      return null;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(111330);
    synchronized (this.lock)
    {
      super.clear();
      AppMethodBeat.o(111330);
      return;
    }
  }
  
  public final void dk(E paramE)
  {
    AppMethodBeat.i(111327);
    synchronized (this.lock)
    {
      if (aM(paramE)) {
        super.remove(paramE);
      }
      AppMethodBeat.o(111327);
      return;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(111329);
    synchronized (this.lock)
    {
      int i = super.size();
      AppMethodBeat.o(111329);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.h
 * JD-Core Version:    0.7.0.1
 */