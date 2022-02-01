package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b onU;
  
  public a(b paramb)
  {
    this.onU = paramb;
  }
  
  private void bUs()
  {
    try
    {
      AppMethodBeat.i(120764);
      this.onU.bUr();
      AppMethodBeat.o(120764);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void bUt()
  {
    try
    {
      AppMethodBeat.i(120765);
      this.onU.remove();
      AppMethodBeat.o(120765);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void bUu()
  {
    try
    {
      AppMethodBeat.i(120766);
      this.onU.clear();
      AppMethodBeat.o(120766);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean add(E paramE)
  {
    try
    {
      AppMethodBeat.i(120767);
      boolean bool = super.add(paramE);
      bUs();
      AppMethodBeat.o(120767);
      return bool;
    }
    finally
    {
      paramE = finally;
      throw paramE;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(120768);
    super.clear();
    bUu();
    AppMethodBeat.o(120768);
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(120769);
      boolean bool = super.remove(paramObject);
      bUt();
      AppMethodBeat.o(120769);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.e.a
 * JD-Core Version:    0.7.0.1
 */