package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class j
  extends ca
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(103405);
    info = ca.ajs();
    AppMethodBeat.o(103405);
  }
  
  public static int HV(int paramInt)
  {
    return 1 << paramInt;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.j
 * JD-Core Version:    0.7.0.1
 */