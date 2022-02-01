package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import com.tencent.mm.sdk.e.c.a;

public final class j
  extends by
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(103405);
    info = by.Th();
    AppMethodBeat.o(103405);
  }
  
  public static int Df(int paramInt)
  {
    return 1 << paramInt;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.j
 * JD-Core Version:    0.7.0.1
 */