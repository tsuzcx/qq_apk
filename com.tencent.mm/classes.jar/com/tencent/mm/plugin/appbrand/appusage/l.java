package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgz;
import java.util.HashSet;
import java.util.Set;

public class l
{
  private static volatile l nOS;
  private final Object mLock;
  private final Set<Object> nOT;
  private volatile cgz nOU;
  
  public l()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.nOT = new HashSet();
    this.nOU = null;
    AppMethodBeat.o(44498);
  }
  
  public static l bJj()
  {
    AppMethodBeat.i(44499);
    if (nOS == null) {}
    try
    {
      if (nOS == null) {
        nOS = new l();
      }
      l locall = nOS;
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