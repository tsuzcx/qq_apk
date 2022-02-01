package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

final class k
{
  static String tRX = "QualityKVReporter_19941";
  boolean mStarted;
  volatile int tRY;
  b tRZ;
  private long tSa;
  private final Map<Integer, c> tSb;
  
  private k()
  {
    AppMethodBeat.i(321402);
    this.tSb = new HashMap();
    this.tSb.put(Integer.valueOf(1), new c(1));
    this.tSb.put(Integer.valueOf(2), new c(2));
    this.tSb.put(Integer.valueOf(3), new c(3));
    this.tSb.put(Integer.valueOf(4), new c(4));
    this.tSb.put(Integer.valueOf(5), new c(5));
    this.tSb.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(321402);
  }
  
  private void cJf()
  {
    AppMethodBeat.i(321394);
    Object localObject = com.tencent.luggage.game.c.h.elJ;
    localObject = com.tencent.luggage.game.c.h.apd();
    ((c)this.tSb.get(Integer.valueOf(1))).Di(((h.a)localObject).elN);
    c localc = (c)this.tSb.get(Integer.valueOf(2));
    if (((h.a)localObject).elT > 0) {}
    for (int i = ((h.a)localObject).elT;; i = ((h.a)localObject).elP)
    {
      localc.Di(i);
      ((c)this.tSb.get(Integer.valueOf(3))).Di(((h.a)localObject).elO);
      ((c)this.tSb.get(Integer.valueOf(4))).Di(((h.a)localObject).elQ);
      ((c)this.tSb.get(Integer.valueOf(5))).Di(((h.a)localObject).elU);
      ((c)this.tSb.get(Integer.valueOf(6))).Di(((h.a)localObject).elV);
      AppMethodBeat.o(321394);
      return;
    }
  }
  
  public static k cJg()
  {
    AppMethodBeat.i(321397);
    k localk = a.cJh();
    AppMethodBeat.o(321397);
    return localk;
  }
  
  public final int Dg(int paramInt)
  {
    AppMethodBeat.i(321424);
    long l = Util.nowMilliSecond();
    if (l - this.tSa > 1000L)
    {
      cJf();
      this.tSa = l;
    }
    paramInt = Dh(paramInt).tSg;
    AppMethodBeat.o(321424);
    return paramInt;
  }
  
  final c Dh(int paramInt)
  {
    AppMethodBeat.i(321427);
    Object localObject = (c)this.tSb.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(321427);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(321427);
    return localObject;
  }
  
  static final class a
  {
    private static final k tSc;
    
    static
    {
      AppMethodBeat.i(321451);
      tSc = new k((byte)0);
      AppMethodBeat.o(321451);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(321458);
      k.a(k.this);
      com.tencent.threadpool.h.ahAA.a(this, k.b(k.this), k.tRX);
      AppMethodBeat.o(321458);
    }
  }
  
  public static final class c
  {
    int mCount;
    private final int mType;
    int tSe;
    int tSf = -2147483648;
    int tSg;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void Di(int paramInt)
    {
      this.mCount += 1;
      this.tSe += paramInt;
      if (paramInt > this.tSf) {}
      for (int i = paramInt;; i = this.tSf)
      {
        this.tSf = i;
        this.tSg = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */