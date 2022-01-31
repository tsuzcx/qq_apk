package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bq;
import com.tencent.mm.sdk.e.c.a;

public final class j
  extends bq
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(102665);
    info = bq.Hm();
    AppMethodBeat.o(102665);
  }
  
  public static int vS(int paramInt)
  {
    return 1 << paramInt;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.j
 * JD-Core Version:    0.7.0.1
 */