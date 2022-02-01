package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

final class k
{
  static String lVj = "QualityKVReporter_19941";
  volatile int lVk;
  b lVl;
  private long lVm;
  private final Map<Integer, c> lVn;
  boolean mStarted;
  
  private k()
  {
    AppMethodBeat.i(186944);
    this.lVn = new HashMap();
    this.lVn.put(Integer.valueOf(1), new c(1));
    this.lVn.put(Integer.valueOf(2), new c(2));
    this.lVn.put(Integer.valueOf(3), new c(3));
    this.lVn.put(Integer.valueOf(4), new c(4));
    this.lVn.put(Integer.valueOf(5), new c(5));
    this.lVn.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(186944);
  }
  
  private void btM()
  {
    AppMethodBeat.i(186942);
    Object localObject = com.tencent.luggage.game.c.h.bZj;
    localObject = com.tencent.luggage.game.c.h.Bf();
    ((c)this.lVn.get(Integer.valueOf(1))).uK(((h.a)localObject).bZm);
    c localc = (c)this.lVn.get(Integer.valueOf(2));
    if (((h.a)localObject).bZs > 0) {}
    for (int i = ((h.a)localObject).bZs;; i = ((h.a)localObject).bZo)
    {
      localc.uK(i);
      ((c)this.lVn.get(Integer.valueOf(3))).uK(((h.a)localObject).bZn);
      ((c)this.lVn.get(Integer.valueOf(4))).uK(((h.a)localObject).bZp);
      ((c)this.lVn.get(Integer.valueOf(5))).uK(((h.a)localObject).bZt);
      ((c)this.lVn.get(Integer.valueOf(6))).uK(((h.a)localObject).bZu);
      AppMethodBeat.o(186942);
      return;
    }
  }
  
  public static k btN()
  {
    AppMethodBeat.i(186943);
    k localk = a.btO();
    AppMethodBeat.o(186943);
    return localk;
  }
  
  public final int uI(int paramInt)
  {
    AppMethodBeat.i(186940);
    long l = bs.eWj();
    if (l - this.lVm > 1000L)
    {
      btM();
      this.lVm = l;
    }
    paramInt = uJ(paramInt).lVr;
    AppMethodBeat.o(186940);
    return paramInt;
  }
  
  final c uJ(int paramInt)
  {
    AppMethodBeat.i(186941);
    Object localObject = (c)this.lVn.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(186941);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(186941);
    return localObject;
  }
  
  static final class a
  {
    private static final k lVo;
    
    static
    {
      AppMethodBeat.i(186938);
      lVo = new k((byte)0);
      AppMethodBeat.o(186938);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(186939);
      k.a(k.this);
      com.tencent.e.h.JZN.a(this, k.b(k.this), k.lVj);
      AppMethodBeat.o(186939);
    }
  }
  
  public static final class c
  {
    int lVq;
    int lVr;
    int mCount;
    int mPeak = -2147483648;
    private final int mType;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void uK(int paramInt)
    {
      this.mCount += 1;
      this.lVq += paramInt;
      if (paramInt > this.mPeak) {}
      for (int i = paramInt;; i = this.mPeak)
      {
        this.mPeak = i;
        this.lVr = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */