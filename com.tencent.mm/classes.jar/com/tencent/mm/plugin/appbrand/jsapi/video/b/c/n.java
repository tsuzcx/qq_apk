package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger kRI;
  private long jox;
  private c kPP;
  String kPQ;
  Future<?> kRG;
  boolean kRJ;
  private int kRK;
  private int kRL;
  o kRM;
  private final Object kRN;
  int kRO;
  int kRP;
  long kRQ;
  long kRR;
  public boolean kRS;
  String kRT;
  String kRU;
  public String kRV;
  String kRW;
  private int kRX;
  private int kRY;
  int priority;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(194316);
    kRI = new AtomicInteger(10000);
    AppMethodBeat.o(194316);
  }
  
  public n()
  {
    AppMethodBeat.i(194308);
    this.kRK = 0;
    this.kRL = 0;
    this.kRN = new Object();
    this.kRP = 0;
    this.priority = -1;
    this.jox = -1L;
    this.kPQ = "";
    this.kPP = c.kQO;
    this.kRO = kRI.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(194308);
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(194310);
      this.jox = paramLong;
      this.kPP = paramc;
      if (this.kPP.equals(c.kQQ)) {
        this.kRP |= 0x8;
      }
      AppMethodBeat.o(194310);
      return;
    }
    finally {}
  }
  
  public final long aXm()
  {
    try
    {
      long l = this.jox;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c bjR()
  {
    try
    {
      c localc = this.kPP;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long bjX()
  {
    AppMethodBeat.i(194312);
    long l = System.currentTimeMillis();
    l = ((float)(this.kRX * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(194312);
    return l;
  }
  
  public final void bjY()
  {
    AppMethodBeat.i(194313);
    if (dS(2, 3))
    {
      if (this.kRM != null) {
        this.kRM.bka();
      }
      if (a.bjM().cuo) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.kRO);
      }
    }
    AppMethodBeat.o(194313);
  }
  
  public final void bjZ()
  {
    AppMethodBeat.i(194314);
    if ((dS(1, 2)) && (a.bjM().cuo)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.kRO);
    }
    AppMethodBeat.o(194314);
  }
  
  final boolean dS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194315);
    synchronized (this.kRN)
    {
      if (this.kRL == paramInt1)
      {
        this.kRL = paramInt2;
        AppMethodBeat.o(194315);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.kRL), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(194315);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(194309);
    String str = this.kPQ + "VideoRequest";
    AppMethodBeat.o(194309);
    return str;
  }
  
  public final void sT(int paramInt)
  {
    try
    {
      this.kRY = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sU(int paramInt)
  {
    try
    {
      this.kRX += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sV(int paramInt)
  {
    if ((this.kRK & paramInt) == 0) {
      this.kRK += paramInt;
    }
  }
  
  public final boolean sW(int paramInt)
  {
    for (;;)
    {
      synchronized (this.kRN)
      {
        if (this.kRL == paramInt)
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
    AppMethodBeat.i(194311);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.kRO).append(",priority=").append(this.priority).append(",range=[").append(this.kRQ).append(",").append(this.kRR).append("],uuid=").append(this.uuid).append(",contentType=").append(this.kRV).append(",cancelState=").append(this.kRL).append(",sourceUrl=").append(this.kRU).append(",videoKey=").append(this.kRT).append(",task=");
    if (this.kRG == null) {}
    for (String str = "null";; str = this.kRG.toString())
    {
      str = str + "}";
      AppMethodBeat.o(194311);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */