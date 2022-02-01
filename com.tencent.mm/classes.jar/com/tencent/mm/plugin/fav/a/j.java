package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bw;
import com.tencent.mm.sdk.e.c.a;

public final class j
  extends bw
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(103405);
    info = bw.So();
    AppMethodBeat.o(103405);
  }
  
  public static int Ck(int paramInt)
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