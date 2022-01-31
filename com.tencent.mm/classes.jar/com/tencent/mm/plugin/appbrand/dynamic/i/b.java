package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  private static b.a hqE;
  private static b.a hqF;
  
  static
  {
    AppMethodBeat.i(10976);
    hqE = new b.a((byte)0);
    hqF = new b.a((byte)0);
    AppMethodBeat.o(10976);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, b.a parama)
  {
    AppMethodBeat.i(10975);
    int i = parama.count;
    long l1 = parama.bCz;
    long l2 = parama.hqG;
    long l3 = parama.hqH;
    if ((l1 <= 0L) || (l2 <= 0L) || (i <= 0) || (l3 <= 0L))
    {
      AppMethodBeat.o(10975);
      return;
    }
    parama = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(690);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(l1);
    parama.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(690);
    localIDKey.SetKey(paramInt2);
    localIDKey.SetValue(l2);
    parama.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(690);
    localIDKey.SetKey(paramInt3);
    localIDKey.SetValue(i);
    parama.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(690);
    localIDKey.SetKey(paramInt4);
    localIDKey.SetValue(l3);
    parama.add(localIDKey);
    com.tencent.mm.plugin.report.service.h.qsU.b(parama, false);
    AppMethodBeat.o(10975);
  }
  
  private static void a(b.a parama, long paramLong, int paramInt)
  {
    try
    {
      parama.bCz += paramLong / 1000L;
      parama.hqG += paramInt;
      parama.hqH += paramLong / paramInt;
      parama.count += 1;
      return;
    }
    finally {}
  }
  
  public static void aAi()
  {
    AppMethodBeat.i(10974);
    a(5, 6, 7, 8, hqF);
    a(0, 1, 2, 3, hqE);
    hqF.reset();
    hqE.reset();
    AppMethodBeat.o(10974);
  }
  
  public static void f(long paramLong, int paramInt)
  {
    AppMethodBeat.i(10973);
    if ((paramLong <= 0L) || (paramInt <= 0))
    {
      AppMethodBeat.o(10973);
      return;
    }
    switch (com.tencent.mm.aa.h.QB())
    {
    default: 
      a(hqE, paramLong, paramInt);
      AppMethodBeat.o(10973);
      return;
    }
    a(hqF, paramLong, paramInt);
    AppMethodBeat.o(10973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.b
 * JD-Core Version:    0.7.0.1
 */