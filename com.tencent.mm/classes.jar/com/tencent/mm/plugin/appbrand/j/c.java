package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;

public final class c
  extends a
{
  public final void aXv()
  {
    AppMethodBeat.i(45022);
    if (aXw()) {
      aG(-104L, 3L);
    }
    AppMethodBeat.o(45022);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(45023);
    if (!iV(-104, 3))
    {
      AppMethodBeat.o(45023);
      return true;
    }
    AppMethodBeat.o(45023);
    return false;
  }
  
  public final String getName()
  {
    return "FTS5WeAppStorage";
  }
  
  public final int getPriority()
  {
    return 512;
  }
  
  public final String getTableName()
  {
    return "WeApp";
  }
  
  public final int getType()
  {
    return 512;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.c
 * JD-Core Version:    0.7.0.1
 */