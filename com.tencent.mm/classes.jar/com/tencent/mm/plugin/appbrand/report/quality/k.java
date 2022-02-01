package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

final class k
{
  static String ltp = "QualityKVReporter_19941";
  volatile int ltq;
  b ltr;
  private long lts;
  private final Map<Integer, c> ltt;
  boolean mStarted;
  
  private k()
  {
    AppMethodBeat.i(196102);
    this.ltt = new HashMap();
    this.ltt.put(Integer.valueOf(1), new c(1));
    this.ltt.put(Integer.valueOf(2), new c(2));
    this.ltt.put(Integer.valueOf(3), new c(3));
    this.ltt.put(Integer.valueOf(4), new c(4));
    this.ltt.put(Integer.valueOf(5), new c(5));
    this.ltt.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(196102);
  }
  
  private void bmQ()
  {
    AppMethodBeat.i(196100);
    Object localObject = com.tencent.luggage.game.c.h.ccm;
    localObject = com.tencent.luggage.game.c.h.BB();
    ((c)this.ltt.get(Integer.valueOf(1))).tS(((h.a)localObject).ccp);
    c localc = (c)this.ltt.get(Integer.valueOf(2));
    if (((h.a)localObject).ccv > 0) {}
    for (int i = ((h.a)localObject).ccv;; i = ((h.a)localObject).ccr)
    {
      localc.tS(i);
      ((c)this.ltt.get(Integer.valueOf(3))).tS(((h.a)localObject).ccq);
      ((c)this.ltt.get(Integer.valueOf(4))).tS(((h.a)localObject).ccs);
      ((c)this.ltt.get(Integer.valueOf(5))).tS(((h.a)localObject).ccw);
      ((c)this.ltt.get(Integer.valueOf(6))).tS(((h.a)localObject).ccx);
      AppMethodBeat.o(196100);
      return;
    }
  }
  
  public static k bmR()
  {
    AppMethodBeat.i(196101);
    k localk = a.bmS();
    AppMethodBeat.o(196101);
    return localk;
  }
  
  public final int tQ(int paramInt)
  {
    AppMethodBeat.i(196098);
    long l = bt.eGO();
    if (l - this.lts > 1000L)
    {
      bmQ();
      this.lts = l;
    }
    paramInt = tR(paramInt).ltx;
    AppMethodBeat.o(196098);
    return paramInt;
  }
  
  final c tR(int paramInt)
  {
    AppMethodBeat.i(196099);
    Object localObject = (c)this.ltt.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(196099);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(196099);
    return localObject;
  }
  
  static final class a
  {
    private static final k ltu;
    
    static
    {
      AppMethodBeat.i(196096);
      ltu = new k((byte)0);
      AppMethodBeat.o(196096);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(196097);
      k.a(k.this);
      com.tencent.e.h.Iye.a(this, k.b(k.this), k.ltp);
      AppMethodBeat.o(196097);
    }
  }
  
  public static final class c
  {
    int ltw;
    int ltx;
    int mCount;
    int mPeak = -2147483648;
    private final int mType;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void tS(int paramInt)
    {
      this.mCount += 1;
      this.ltw += paramInt;
      if (paramInt > this.mPeak) {}
      for (int i = paramInt;; i = this.mPeak)
      {
        this.mPeak = i;
        this.ltx = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */