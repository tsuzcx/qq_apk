package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

final class k
{
  static String mzW = "QualityKVReporter_19941";
  private final Map<Integer, c> mAa;
  boolean mStarted;
  volatile int mzX;
  b mzY;
  private long mzZ;
  
  private k()
  {
    AppMethodBeat.i(222960);
    this.mAa = new HashMap();
    this.mAa.put(Integer.valueOf(1), new c(1));
    this.mAa.put(Integer.valueOf(2), new c(2));
    this.mAa.put(Integer.valueOf(3), new c(3));
    this.mAa.put(Integer.valueOf(4), new c(4));
    this.mAa.put(Integer.valueOf(5), new c(5));
    this.mAa.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(222960);
  }
  
  private void byK()
  {
    AppMethodBeat.i(222958);
    Object localObject = com.tencent.luggage.game.c.h.cjD;
    localObject = com.tencent.luggage.game.c.h.CH();
    ((c)this.mAa.get(Integer.valueOf(1))).vt(((h.a)localObject).cjG);
    c localc = (c)this.mAa.get(Integer.valueOf(2));
    if (((h.a)localObject).cjM > 0) {}
    for (int i = ((h.a)localObject).cjM;; i = ((h.a)localObject).cjI)
    {
      localc.vt(i);
      ((c)this.mAa.get(Integer.valueOf(3))).vt(((h.a)localObject).cjH);
      ((c)this.mAa.get(Integer.valueOf(4))).vt(((h.a)localObject).cjJ);
      ((c)this.mAa.get(Integer.valueOf(5))).vt(((h.a)localObject).cjN);
      ((c)this.mAa.get(Integer.valueOf(6))).vt(((h.a)localObject).cjO);
      AppMethodBeat.o(222958);
      return;
    }
  }
  
  public static k byL()
  {
    AppMethodBeat.i(222959);
    k localk = a.byM();
    AppMethodBeat.o(222959);
    return localk;
  }
  
  public final int vr(int paramInt)
  {
    AppMethodBeat.i(222956);
    long l = bu.fpO();
    if (l - this.mzZ > 1000L)
    {
      byK();
      this.mzZ = l;
    }
    paramInt = vs(paramInt).mAe;
    AppMethodBeat.o(222956);
    return paramInt;
  }
  
  final c vs(int paramInt)
  {
    AppMethodBeat.i(222957);
    Object localObject = (c)this.mAa.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(222957);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(222957);
    return localObject;
  }
  
  static final class a
  {
    private static final k mAb;
    
    static
    {
      AppMethodBeat.i(222954);
      mAb = new k((byte)0);
      AppMethodBeat.o(222954);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(222955);
      k.a(k.this);
      com.tencent.e.h.MqF.a(this, k.b(k.this), k.mzW);
      AppMethodBeat.o(222955);
    }
  }
  
  public static final class c
  {
    int mAd;
    int mAe;
    int mCount;
    int mPeak = -2147483648;
    private final int mType;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void vt(int paramInt)
    {
      this.mCount += 1;
      this.mAd += paramInt;
      if (paramInt > this.mPeak) {}
      for (int i = paramInt;; i = this.mPeak)
      {
        this.mPeak = i;
        this.mAe = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.k
 * JD-Core Version:    0.7.0.1
 */