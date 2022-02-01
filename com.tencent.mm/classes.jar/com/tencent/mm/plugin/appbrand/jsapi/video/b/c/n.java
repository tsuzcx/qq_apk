package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger kqp;
  private long iOo;
  private c kow;
  String kox;
  String kqA;
  String kqB;
  public String kqC;
  String kqD;
  private int kqE;
  private int kqF;
  Future<?> kqn;
  boolean kqq;
  private int kqr;
  private int kqs;
  o kqt;
  private final Object kqu;
  int kqv;
  int kqw;
  long kqx;
  long kqy;
  public boolean kqz;
  int priority;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(193969);
    kqp = new AtomicInteger(10000);
    AppMethodBeat.o(193969);
  }
  
  public n()
  {
    AppMethodBeat.i(193961);
    this.kqr = 0;
    this.kqs = 0;
    this.kqu = new Object();
    this.kqw = 0;
    this.priority = -1;
    this.iOo = -1L;
    this.kox = "";
    this.kow = c.kpv;
    this.kqv = kqp.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(193961);
  }
  
  public final String EE()
  {
    AppMethodBeat.i(193962);
    String str = this.kox + "VideoRequest";
    AppMethodBeat.o(193962);
    return str;
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(193963);
      this.iOo = paramLong;
      this.kow = paramc;
      if (this.kow.equals(c.kpx)) {
        this.kqw |= 0x8;
      }
      AppMethodBeat.o(193963);
      return;
    }
    finally {}
  }
  
  public final long aQu()
  {
    try
    {
      long l = this.iOo;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c bcW()
  {
    try
    {
      c localc = this.kow;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long bdc()
  {
    AppMethodBeat.i(193965);
    long l = System.currentTimeMillis();
    l = ((float)(this.kqE * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(193965);
    return l;
  }
  
  public final void bdd()
  {
    AppMethodBeat.i(193966);
    if (dR(2, 3))
    {
      if (this.kqt != null) {
        this.kqt.bdf();
      }
      if (a.bcR().cxf) {
        h.log(3, EE(), "cancel success, seq=" + this.kqv);
      }
    }
    AppMethodBeat.o(193966);
  }
  
  public final void bde()
  {
    AppMethodBeat.i(193967);
    if ((dR(1, 2)) && (a.bcR().cxf)) {
      h.log(3, EE(), "cancel proceeding, seq=" + this.kqv);
    }
    AppMethodBeat.o(193967);
  }
  
  final boolean dR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193968);
    synchronized (this.kqu)
    {
      if (this.kqs == paramInt1)
      {
        this.kqs = paramInt2;
        AppMethodBeat.o(193968);
        return true;
      }
      h.log(5, EE(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.kqs), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(193968);
      return false;
    }
  }
  
  public final void sd(int paramInt)
  {
    try
    {
      this.kqF = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void se(int paramInt)
  {
    try
    {
      this.kqE += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sf(int paramInt)
  {
    if ((this.kqr & paramInt) == 0) {
      this.kqr += paramInt;
    }
  }
  
  public final boolean sg(int paramInt)
  {
    for (;;)
    {
      synchronized (this.kqu)
      {
        if (this.kqs == paramInt)
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
    AppMethodBeat.i(193964);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.kqv).append(",priority=").append(this.priority).append(",range=[").append(this.kqx).append(",").append(this.kqy).append("],uuid=").append(this.uuid).append(",contentType=").append(this.kqC).append(",cancelState=").append(this.kqs).append(",sourceUrl=").append(this.kqB).append(",videoKey=").append(this.kqA).append(",task=");
    if (this.kqn == null) {}
    for (String str = "null";; str = this.kqn.toString())
    {
      str = str + "}";
      AppMethodBeat.o(193964);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */