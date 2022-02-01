package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdw;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l iUu;
  private final Set<Object> iUv;
  private volatile bdw iUw;
  private final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.iUv = new HashSet();
    this.iUw = null;
    AppMethodBeat.o(44498);
  }
  
  public static l aRH()
  {
    AppMethodBeat.i(44499);
    if (iUu == null) {}
    try
    {
      if (iUu == null) {
        iUu = new l();
      }
      l locall = iUu;
      AppMethodBeat.o(44499);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(44499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */