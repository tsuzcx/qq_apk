package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b kDW;
  
  public a(b paramb)
  {
    this.kDW = paramb;
  }
  
  private void bfW()
  {
    try
    {
      AppMethodBeat.i(932);
      this.kDW.bfV();
      AppMethodBeat.o(932);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void bfX()
  {
    try
    {
      AppMethodBeat.i(933);
      this.kDW.remove();
      AppMethodBeat.o(933);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void bfY()
  {
    try
    {
      AppMethodBeat.i(934);
      this.kDW.clear();
      AppMethodBeat.o(934);
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
      AppMethodBeat.i(935);
      boolean bool = super.add(paramE);
      bfW();
      AppMethodBeat.o(935);
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
    AppMethodBeat.i(936);
    super.clear();
    bfY();
    AppMethodBeat.o(936);
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(937);
      boolean bool = super.remove(paramObject);
      bfX();
      AppMethodBeat.o(937);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.e.a
 * JD-Core Version:    0.7.0.1
 */