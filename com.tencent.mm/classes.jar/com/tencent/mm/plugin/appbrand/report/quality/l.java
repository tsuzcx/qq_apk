package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.f.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

final class l
{
  static String nLb = "QualityKVReporter_19941";
  boolean mStarted;
  volatile int nLc;
  b nLd;
  private long nLe;
  private final Map<Integer, c> nLf;
  
  private l()
  {
    AppMethodBeat.i(227411);
    this.nLf = new HashMap();
    this.nLf.put(Integer.valueOf(1), new c(1));
    this.nLf.put(Integer.valueOf(2), new c(2));
    this.nLf.put(Integer.valueOf(3), new c(3));
    this.nLf.put(Integer.valueOf(4), new c(4));
    this.nLf.put(Integer.valueOf(5), new c(5));
    this.nLf.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(227411);
  }
  
  private void bVd()
  {
    AppMethodBeat.i(227409);
    Object localObject = com.tencent.luggage.game.c.h.cvz;
    localObject = com.tencent.luggage.game.c.h.Md();
    ((c)this.nLf.get(Integer.valueOf(1))).zk(((h.a)localObject).cvD);
    c localc = (c)this.nLf.get(Integer.valueOf(2));
    if (((h.a)localObject).cvJ > 0) {}
    for (int i = ((h.a)localObject).cvJ;; i = ((h.a)localObject).cvF)
    {
      localc.zk(i);
      ((c)this.nLf.get(Integer.valueOf(3))).zk(((h.a)localObject).cvE);
      ((c)this.nLf.get(Integer.valueOf(4))).zk(((h.a)localObject).cvG);
      ((c)this.nLf.get(Integer.valueOf(5))).zk(((h.a)localObject).cvK);
      ((c)this.nLf.get(Integer.valueOf(6))).zk(((h.a)localObject).cvL);
      AppMethodBeat.o(227409);
      return;
    }
  }
  
  public static l bVe()
  {
    AppMethodBeat.i(227410);
    l locall = a.bVf();
    AppMethodBeat.o(227410);
    return locall;
  }
  
  public final int zi(int paramInt)
  {
    AppMethodBeat.i(227407);
    long l = Util.nowMilliSecond();
    if (l - this.nLe > 1000L)
    {
      bVd();
      this.nLe = l;
    }
    paramInt = zj(paramInt).nLj;
    AppMethodBeat.o(227407);
    return paramInt;
  }
  
  final c zj(int paramInt)
  {
    AppMethodBeat.i(227408);
    Object localObject = (c)this.nLf.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(227408);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(227408);
    return localObject;
  }
  
  static final class a
  {
    private static final l nLg;
    
    static
    {
      AppMethodBeat.i(227405);
      nLg = new l((byte)0);
      AppMethodBeat.o(227405);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(227406);
      l.a(l.this);
      com.tencent.f.h.RTc.a(this, l.b(l.this), l.nLb);
      AppMethodBeat.o(227406);
    }
  }
  
  public static final class c
  {
    int mCount;
    int mPeak = -2147483648;
    private final int mType;
    int nLi;
    int nLj;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void zk(int paramInt)
    {
      this.mCount += 1;
      this.nLi += paramInt;
      if (paramInt > this.mPeak) {}
      for (int i = paramInt;; i = this.mPeak)
      {
        this.mPeak = i;
        this.nLj = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.l
 * JD-Core Version:    0.7.0.1
 */