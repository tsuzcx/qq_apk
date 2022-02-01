package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b wOU;
  
  public a(b paramb)
  {
    this.wOU = paramb;
  }
  
  private void dqc()
  {
    try
    {
      AppMethodBeat.i(120764);
      this.wOU.dqb();
      AppMethodBeat.o(120764);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dqd()
  {
    try
    {
      AppMethodBeat.i(120765);
      this.wOU.remove();
      AppMethodBeat.o(120765);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dqe()
  {
    try
    {
      AppMethodBeat.i(120766);
      this.wOU.clear();
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
      dqc();
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
    dqe();
    AppMethodBeat.o(120768);
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(120769);
      boolean bool = super.remove(paramObject);
      dqd();
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