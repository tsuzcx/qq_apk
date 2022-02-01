package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

final class k
{
  static String muZ = "QualityKVReporter_19941";
  boolean mStarted;
  volatile int mva;
  b mvb;
  private long mvc;
  private final Map<Integer, c> mvd;
  
  private k()
  {
    AppMethodBeat.i(188742);
    this.mvd = new HashMap();
    this.mvd.put(Integer.valueOf(1), new c(1));
    this.mvd.put(Integer.valueOf(2), new c(2));
    this.mvd.put(Integer.valueOf(3), new c(3));
    this.mvd.put(Integer.valueOf(4), new c(4));
    this.mvd.put(Integer.valueOf(5), new c(5));
    this.mvd.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(188742);
  }
  
  private void bxR()
  {
    AppMethodBeat.i(188740);
    Object localObject = com.tencent.luggage.game.c.h.cjB;
    localObject = com.tencent.luggage.game.c.h.CE();
    ((c)this.mvd.get(Integer.valueOf(1))).vo(((h.a)localObject).cjE);
    c localc = (c)this.mvd.get(Integer.valueOf(2));
    if (((h.a)localObject).cjK > 0) {}
    for (int i = ((h.a)localObject).cjK;; i = ((h.a)localObject).cjG)
    {
      localc.vo(i);
      ((c)this.mvd.get(Integer.valueOf(3))).vo(((h.a)localObject).cjF);
      ((c)this.mvd.get(Integer.valueOf(4))).vo(((h.a)localObject).cjH);
      ((c)this.mvd.get(Integer.valueOf(5))).vo(((h.a)localObject).cjL);
      ((c)this.mvd.get(Integer.valueOf(6))).vo(((h.a)localObject).cjM);
      AppMethodBeat.o(188740);
      return;
    }
  }
  
  public static k bxS()
  {
    AppMethodBeat.i(188741);
    k localk = a.bxT();
    AppMethodBeat.o(188741);
    return localk;
  }
  
  public final int vm(int paramInt)
  {
    AppMethodBeat.i(188738);
    long l = bt.flT();
    if (l - this.mvc > 1000L)
    {
      bxR();
      this.mvc = l;
    }
    paramInt = vn(paramInt).mvh;
    AppMethodBeat.o(188738);
    return paramInt;
  }
  
  final c vn(int paramInt)
  {
    AppMethodBeat.i(188739);
    Object localObject = (c)this.mvd.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(188739);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(188739);
    return localObject;
  }
  
  static final class a
  {
    private static final k mve;
    
    static
    {
      AppMethodBeat.i(188736);
      mve = new k((byte)0);
      AppMethodBeat.o(188736);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(188737);
      k.a(k.this);
      com.tencent.e.h.LTJ.a(this, k.b(k.this), k.muZ);
      AppMethodBeat.o(188737);
    }
  }
  
  public static final class c
  {
    int mCount;
    int mPeak = -2147483648;
    private final int mType;
    int mvg;
    int mvh;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void vo(int paramInt)
    {
      this.mCount += 1;
      this.mvg += paramInt;
      if (paramInt > this.mPeak) {}
      for (int i = paramInt;; i = this.mPeak)
      {
        this.mPeak = i;
        this.mvh = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */