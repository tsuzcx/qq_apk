package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger lol;
  private long jIt;
  private c lmp;
  String lmq;
  private int loA;
  private int loB;
  Future<?> loj;
  boolean lom;
  private int lon;
  private int loo;
  o lop;
  private final Object loq;
  int lor;
  int los;
  long lot;
  long lou;
  public boolean lov;
  String low;
  String lox;
  public String loy;
  String loz;
  int priority;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(206128);
    lol = new AtomicInteger(10000);
    AppMethodBeat.o(206128);
  }
  
  public n()
  {
    AppMethodBeat.i(206120);
    this.lon = 0;
    this.loo = 0;
    this.loq = new Object();
    this.los = 0;
    this.priority = -1;
    this.jIt = -1L;
    this.lmq = "";
    this.lmp = c.lnp;
    this.lor = lol.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(206120);
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(206122);
      this.jIt = paramLong;
      this.lmp = paramc;
      if (this.lmp.equals(c.lnr)) {
        this.los |= 0x8;
      }
      AppMethodBeat.o(206122);
      return;
    }
    finally {}
  }
  
  public final long baK()
  {
    try
    {
      long l = this.jIt;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c bnC()
  {
    try
    {
      c localc = this.lmp;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long bnI()
  {
    AppMethodBeat.i(206124);
    long l = System.currentTimeMillis();
    l = ((float)(this.loA * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(206124);
    return l;
  }
  
  public final void bnJ()
  {
    AppMethodBeat.i(206125);
    if (dU(2, 3))
    {
      if (this.lop != null) {
        this.lop.bnL();
      }
      if (a.bnx().cFj) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.lor);
      }
    }
    AppMethodBeat.o(206125);
  }
  
  public final void bnK()
  {
    AppMethodBeat.i(206126);
    if ((dU(1, 2)) && (a.bnx().cFj)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.lor);
    }
    AppMethodBeat.o(206126);
  }
  
  final boolean dU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206127);
    synchronized (this.loq)
    {
      if (this.loo == paramInt1)
      {
        this.loo = paramInt2;
        AppMethodBeat.o(206127);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.loo), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(206127);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(206121);
    String str = this.lmq + "VideoRequest";
    AppMethodBeat.o(206121);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206123);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.lor).append(",priority=").append(this.priority).append(",range=[").append(this.lot).append(",").append(this.lou).append("],uuid=").append(this.uuid).append(",contentType=").append(this.loy).append(",cancelState=").append(this.loo).append(",sourceUrl=").append(this.lox).append(",videoKey=").append(this.low).append(",task=");
    if (this.loj == null) {}
    for (String str = "null";; str = this.loj.toString())
    {
      str = str + "}";
      AppMethodBeat.o(206123);
      return str;
    }
  }
  
  public final void tw(int paramInt)
  {
    try
    {
      this.loB = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void tx(int paramInt)
  {
    try
    {
      this.loA += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ty(int paramInt)
  {
    if ((this.lon & paramInt) == 0) {
      this.lon += paramInt;
    }
  }
  
  public final boolean tz(int paramInt)
  {
    for (;;)
    {
      synchronized (this.loq)
      {
        if (this.loo == paramInt)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */