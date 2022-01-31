package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E>
  extends LinkedList<E>
{
  private byte[] eKs;
  
  public h()
  {
    AppMethodBeat.i(21297);
    this.eKs = new byte[0];
    AppMethodBeat.o(21297);
  }
  
  public final boolean Z(E paramE)
  {
    AppMethodBeat.i(21299);
    synchronized (this.eKs)
    {
      boolean bool = super.contains(paramE);
      AppMethodBeat.o(21299);
      return bool;
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(21301);
    synchronized (this.eKs)
    {
      boolean bool = super.add(paramE);
      AppMethodBeat.o(21301);
      return bool;
    }
  }
  
  public final E bEi()
  {
    AppMethodBeat.i(21298);
    synchronized (this.eKs)
    {
      if (size() > 0)
      {
        Object localObject1 = super.poll();
        AppMethodBeat.o(21298);
        return localObject1;
      }
      AppMethodBeat.o(21298);
      return null;
    }
  }
  
  public final void bO(E paramE)
  {
    AppMethodBeat.i(21300);
    synchronized (this.eKs)
    {
      if (Z(paramE)) {
        super.remove(paramE);
      }
      AppMethodBeat.o(21300);
      return;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(21302);
    synchronized (this.eKs)
    {
      int i = super.size();
      AppMethodBeat.o(21302);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.h
 * JD-Core Version:    0.7.0.1
 */