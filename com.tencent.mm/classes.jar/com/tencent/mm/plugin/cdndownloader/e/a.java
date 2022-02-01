package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b tLF;
  
  public a(b paramb)
  {
    this.tLF = paramb;
  }
  
  private void cMA()
  {
    try
    {
      AppMethodBeat.i(120766);
      this.tLF.clear();
      AppMethodBeat.o(120766);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cMy()
  {
    try
    {
      AppMethodBeat.i(120764);
      this.tLF.cMx();
      AppMethodBeat.o(120764);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cMz()
  {
    try
    {
      AppMethodBeat.i(120765);
      this.tLF.remove();
      AppMethodBeat.o(120765);
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
      cMy();
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
    cMA();
    AppMethodBeat.o(120768);
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(120769);
      boolean bool = super.remove(paramObject);
      cMz();
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