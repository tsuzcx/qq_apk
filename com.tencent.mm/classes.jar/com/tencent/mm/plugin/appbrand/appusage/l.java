package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmo;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l jRV;
  private final Set<Object> jRW;
  private volatile bmo jRX;
  private final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.jRW = new HashSet();
    this.jRX = null;
    AppMethodBeat.o(44498);
  }
  
  public static l bcF()
  {
    AppMethodBeat.i(44499);
    if (jRV == null) {}
    try
    {
      if (jRV == null) {
        jRV = new l();
      }
      l locall = jRV;
      AppMethodBeat.o(44499);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(44499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */