package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b oXR;
  
  public a(b paramb)
  {
    this.oXR = paramb;
  }
  
  private void cam()
  {
    try
    {
      AppMethodBeat.i(120764);
      this.oXR.cal();
      AppMethodBeat.o(120764);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void can()
  {
    try
    {
      AppMethodBeat.i(120765);
      this.oXR.remove();
      AppMethodBeat.o(120765);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cao()
  {
    try
    {
      AppMethodBeat.i(120766);
      this.oXR.clear();
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
      cam();
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
    cao();
    AppMethodBeat.o(120768);
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(120769);
      boolean bool = super.remove(paramObject);
      can();
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