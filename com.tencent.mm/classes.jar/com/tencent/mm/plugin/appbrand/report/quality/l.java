package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.e.i;
import com.tencent.luggage.game.c.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

final class l
{
  static String qNn = "QualityKVReporter_19941";
  boolean mStarted;
  volatile int qNo;
  b qNp;
  private long qNq;
  private final Map<Integer, c> qNr;
  
  private l()
  {
    AppMethodBeat.i(277748);
    this.qNr = new HashMap();
    this.qNr.put(Integer.valueOf(1), new c(1));
    this.qNr.put(Integer.valueOf(2), new c(2));
    this.qNr.put(Integer.valueOf(3), new c(3));
    this.qNr.put(Integer.valueOf(4), new c(4));
    this.qNr.put(Integer.valueOf(5), new c(5));
    this.qNr.put(Integer.valueOf(6), new c(6));
    AppMethodBeat.o(277748);
  }
  
  private void cio()
  {
    AppMethodBeat.i(277745);
    Object localObject = com.tencent.luggage.game.c.h.ctP;
    localObject = com.tencent.luggage.game.c.h.OV();
    ((c)this.qNr.get(Integer.valueOf(1))).CP(((h.a)localObject).ctT);
    c localc = (c)this.qNr.get(Integer.valueOf(2));
    if (((h.a)localObject).ctZ > 0) {}
    for (int i = ((h.a)localObject).ctZ;; i = ((h.a)localObject).ctV)
    {
      localc.CP(i);
      ((c)this.qNr.get(Integer.valueOf(3))).CP(((h.a)localObject).ctU);
      ((c)this.qNr.get(Integer.valueOf(4))).CP(((h.a)localObject).ctW);
      ((c)this.qNr.get(Integer.valueOf(5))).CP(((h.a)localObject).cua);
      ((c)this.qNr.get(Integer.valueOf(6))).CP(((h.a)localObject).cub);
      AppMethodBeat.o(277745);
      return;
    }
  }
  
  public static l cip()
  {
    AppMethodBeat.i(277746);
    l locall = l.a.ciq();
    AppMethodBeat.o(277746);
    return locall;
  }
  
  public final int CN(int paramInt)
  {
    AppMethodBeat.i(277742);
    long l = Util.nowMilliSecond();
    if (l - this.qNq > 1000L)
    {
      cio();
      this.qNq = l;
    }
    paramInt = CO(paramInt).qNw;
    AppMethodBeat.o(277742);
    return paramInt;
  }
  
  final c CO(int paramInt)
  {
    AppMethodBeat.i(277744);
    Object localObject = (c)this.qNr.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(277744);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(277744);
    return localObject;
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(282557);
      l.a(l.this);
      com.tencent.e.h.ZvG.a(this, l.b(l.this), l.qNn);
      AppMethodBeat.o(282557);
    }
  }
  
  public static final class c
  {
    int mCount;
    private final int mType;
    int qNu;
    int qNv = -2147483648;
    int qNw;
    
    public c(int paramInt)
    {
      this.mType = paramInt;
    }
    
    public final void CP(int paramInt)
    {
      this.mCount += 1;
      this.qNu += paramInt;
      if (paramInt > this.qNv) {}
      for (int i = paramInt;; i = this.qNv)
      {
        this.qNv = i;
        this.qNw = paramInt;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.l
 * JD-Core Version:    0.7.0.1
 */