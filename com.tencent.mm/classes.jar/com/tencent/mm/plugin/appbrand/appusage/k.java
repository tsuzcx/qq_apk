package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxa;
import java.util.HashSet;
import java.util.Set;

public class k
{
  private static volatile k qOK;
  private final Object mLock;
  private final Set<Object> qOL;
  private volatile cxa qOM;
  
  public k()
  {
    AppMethodBeat.i(44498);
    this.mLock = new Object();
    this.qOL = new HashSet();
    this.qOM = null;
    AppMethodBeat.o(44498);
  }
  
  public static k ciN()
  {
    AppMethodBeat.i(44499);
    if (qOK == null) {}
    try
    {
      if (qOK == null) {
        qOK = new k();
      }
      k localk = qOK;
      AppMethodBeat.o(44499);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(44499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */