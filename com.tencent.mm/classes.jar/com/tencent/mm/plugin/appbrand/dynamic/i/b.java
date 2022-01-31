package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

public final class b
{
  private static b.a fXd = new b.a((byte)0);
  private static b.a fXe = new b.a((byte)0);
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, b.a parama)
  {
    int i = parama.count;
    long l1 = parama.fXf;
    long l2 = parama.fXg;
    long l3 = parama.fXh;
    if ((l1 <= 0L) || (l2 <= 0L) || (i <= 0) || (l3 <= 0L)) {
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
    com.tencent.mm.plugin.report.service.h.nFQ.b(parama, false);
  }
  
  private static void a(b.a parama, long paramLong, int paramInt)
  {
    try
    {
      parama.fXf += paramLong / 1000L;
      parama.fXg += paramInt;
      parama.fXh += paramLong / paramInt;
      parama.count += 1;
      return;
    }
    finally {}
  }
  
  public static void afE()
  {
    a(5, 6, 7, 8, fXe);
    a(0, 1, 2, 3, fXd);
    fXe.reset();
    fXd.reset();
  }
  
  public static void e(long paramLong, int paramInt)
  {
    if ((paramLong <= 0L) || (paramInt <= 0)) {
      return;
    }
    switch (com.tencent.mm.ab.h.CJ())
    {
    default: 
      a(fXd, paramLong, paramInt);
      return;
    }
    a(fXe, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i.b
 * JD-Core Version:    0.7.0.1
 */