package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  private static a jnN;
  private static a jnO;
  
  static
  {
    AppMethodBeat.i(121457);
    jnN = new a((byte)0);
    jnO = new a((byte)0);
    AppMethodBeat.o(121457);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    AppMethodBeat.i(121456);
    int i = parama.count;
    long l1 = parama.ceC;
    long l2 = parama.jnP;
    long l3 = parama.jnQ;
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
    com.tencent.mm.plugin.report.service.h.vKh.b(parama, false);
    AppMethodBeat.o(121456);
  }
  
  private static void a(a parama, long paramLong, int paramInt)
  {
    try
    {
      parama.ceC += paramLong / 1000L;
      parama.jnP += paramInt;
      parama.jnQ += paramLong / paramInt;
      parama.count += 1;
      return;
    }
    finally {}
  }
  
  public static void aVP()
  {
    AppMethodBeat.i(121455);
    a(5, 6, 7, 8, jnO);
    a(0, 1, 2, 3, jnN);
    jnO.reset();
    jnN.reset();
    AppMethodBeat.o(121455);
  }
  
  public static void g(long paramLong, int paramInt)
  {
    AppMethodBeat.i(121454);
    if ((paramLong <= 0L) || (paramInt <= 0))
    {
      AppMethodBeat.o(121454);
      return;
    }
    switch (com.tencent.mm.ac.h.aen())
    {
    default: 
      a(jnN, paramLong, paramInt);
      AppMethodBeat.o(121454);
      return;
    }
    a(jnO, paramLong, paramInt);
    AppMethodBeat.o(121454);
  }
  
  static final class a
  {
    volatile long ceC;
    volatile int count;
    volatile long jnP;
    volatile long jnQ;
    
    final void reset()
    {
      try
      {
        this.ceC = 0L;
        this.jnP = 0L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.b
 * JD-Core Version:    0.7.0.1
 */