package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum p
{
  private static volatile cwv qOY;
  private static final Set<Object> qOZ;
  
  static
  {
    AppMethodBeat.i(44546);
    qPa = new p[0];
    qOZ = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean ciO()
  {
    return true;
  }
  
  public static boolean ciP()
  {
    AppMethodBeat.i(44539);
    switch (1.qPb[ciQ().ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(44539);
      return false;
      AppMethodBeat.o(44539);
      return false;
      AppMethodBeat.o(44539);
      return true;
      if (ciR())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (qOY == null);
    if (qOY.uYb >= qOY.aaCi)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a ciQ()
  {
    AppMethodBeat.i(44541);
    if (!h.baz())
    {
      locala = a.qPc;
      AppMethodBeat.o(44541);
      return locala;
    }
    a locala = a.qPd;
    AppMethodBeat.o(44541);
    return locala;
  }
  
  static boolean ciR()
  {
    AppMethodBeat.i(44542);
    boolean bool = h.baE().ban().getBoolean(at.a.acNB, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void ciS()
  {
    AppMethodBeat.i(44543);
    h.baE().ban().set(at.a.acNB, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static cwv ciT()
  {
    return qOY;
  }
  
  public static void clearData()
  {
    qOY = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      qPc = new a("FORCE_OFF", 0, 0);
      qPd = new a("FORCE_ON", 1, 1);
      qPe = new a("DYNAMIC_THRESHOLD", 2, 2);
      qPf = new a[] { qPc, qPd, qPe };
      AppMethodBeat.o(44534);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.p
 * JD-Core Version:    0.7.0.1
 */