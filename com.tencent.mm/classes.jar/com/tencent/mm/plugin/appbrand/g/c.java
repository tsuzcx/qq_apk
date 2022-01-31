package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;

public final class c
  extends a
{
  public final void Pn()
  {
    AppMethodBeat.i(129968);
    if (Po()) {
      M(-104L, 2L);
    }
    AppMethodBeat.o(129968);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(129969);
    if (!er(-104, 2))
    {
      AppMethodBeat.o(129969);
      return true;
    }
    AppMethodBeat.o(129969);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c
 * JD-Core Version:    0.7.0.1
 */