package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public final class b
{
  private static a klA;
  private static a klB;
  
  static
  {
    AppMethodBeat.i(121457);
    klA = new a((byte)0);
    klB = new a((byte)0);
    AppMethodBeat.o(121457);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    AppMethodBeat.i(121456);
    int i = parama.count;
    long l1 = parama.clS;
    long l2 = parama.klC;
    long l3 = parama.klD;
    if ((l1 <= 0L) || (l2 <= 0L) || (i <= 0) || (l3 <= 0L))
    {
      AppMethodBeat.o(121456);
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
    g.yxI.b(parama, false);
    AppMethodBeat.o(121456);
  }
  
  private static void a(a parama, long paramLong, int paramInt)
  {
    try
    {
      parama.clS += paramLong / 1000L;
      parama.klC += paramInt;
      parama.klD += paramLong / paramInt;
      parama.count += 1;
      return;
    }
    finally {}
  }
  
  public static void bgZ()
  {
    AppMethodBeat.i(121455);
    a(5, 6, 7, 8, klB);
    a(0, 1, 2, 3, klA);
    klB.reset();
    klA.reset();
    AppMethodBeat.o(121455);
  }
  
  public static void h(long paramLong, int paramInt)
  {
    AppMethodBeat.i(121454);
    if ((paramLong <= 0L) || (paramInt <= 0))
    {
      AppMethodBeat.o(121454);
      return;
    }
    switch (h.aiE())
    {
    default: 
      a(klA, paramLong, paramInt);
      AppMethodBeat.o(121454);
      return;
    }
    a(klB, paramLong, paramInt);
    AppMethodBeat.o(121454);
  }
  
  static final class a
  {
    volatile long clS;
    volatile int count;
    volatile long klC;
    volatile long klD;
    
    final void reset()
    {
      try
      {
        this.clS = 0L;
        this.klC = 0L;
        this.count = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.b
 * JD-Core Version:    0.7.0.1
 */