package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger lsJ;
  String dJL;
  private long jLu;
  private c lqP;
  String lqQ;
  Future<?> lsH;
  boolean lsK;
  private int lsL;
  private int lsM;
  o lsN;
  private final Object lsO;
  int lsP;
  int lsQ;
  long lsR;
  long lsS;
  public boolean lsT;
  String lsU;
  public String lsV;
  String lsW;
  private int lsX;
  private int lsY;
  int priority;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(211155);
    lsJ = new AtomicInteger(10000);
    AppMethodBeat.o(211155);
  }
  
  public n()
  {
    AppMethodBeat.i(211147);
    this.lsL = 0;
    this.lsM = 0;
    this.lsO = new Object();
    this.lsQ = 0;
    this.priority = -1;
    this.jLu = -1L;
    this.lqQ = "";
    this.lqP = c.lrO;
    this.lsP = lsJ.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(211147);
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(211149);
      this.jLu = paramLong;
      this.lqP = paramc;
      if (this.lqP.equals(c.lrQ)) {
        this.lsQ |= 0x8;
      }
      AppMethodBeat.o(211149);
      return;
    }
    finally {}
  }
  
  public final long bbj()
  {
    try
    {
      long l = this.jLu;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c bom()
  {
    try
    {
      c localc = this.lqP;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long bos()
  {
    AppMethodBeat.i(211151);
    long l = System.currentTimeMillis();
    l = ((float)(this.lsX * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(211151);
    return l;
  }
  
  public final void bot()
  {
    AppMethodBeat.i(211152);
    if (dU(2, 3))
    {
      if (this.lsN != null) {
        this.lsN.bov();
      }
      if (a.boh().cFS) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.lsP);
      }
    }
    AppMethodBeat.o(211152);
  }
  
  public final void bou()
  {
    AppMethodBeat.i(211153);
    if ((dU(1, 2)) && (a.boh().cFS)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.lsP);
    }
    AppMethodBeat.o(211153);
  }
  
  final boolean dU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211154);
    synchronized (this.lsO)
    {
      if (this.lsM == paramInt1)
      {
        this.lsM = paramInt2;
        AppMethodBeat.o(211154);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.lsM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(211154);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(211148);
    String str = this.lqQ + "VideoRequest";
    AppMethodBeat.o(211148);
    return str;
  }
  
  public final void tA(int paramInt)
  {
    try
    {
      this.lsY = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void tB(int paramInt)
  {
    try
    {
      this.lsX += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void tC(int paramInt)
  {
    if ((this.lsL & paramInt) == 0) {
      this.lsL += paramInt;
    }
  }
  
  public final boolean tD(int paramInt)
  {
    for (;;)
    {
      synchronized (this.lsO)
      {
        if (this.lsM == paramInt)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211150);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.lsP).append(",priority=").append(this.priority).append(",range=[").append(this.lsR).append(",").append(this.lsS).append("],uuid=").append(this.uuid).append(",contentType=").append(this.lsV).append(",cancelState=").append(this.lsM).append(",sourceUrl=").append(this.dJL).append(",videoKey=").append(this.lsU).append(",task=");
    if (this.lsH == null) {}
    for (String str = "null";; str = this.lsH.toString())
    {
      str = str + "}";
      AppMethodBeat.o(211150);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */