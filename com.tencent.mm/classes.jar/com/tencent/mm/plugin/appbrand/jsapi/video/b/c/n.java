package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger mzm;
  String eby;
  boolean ifP;
  private long kNt;
  private c mxv;
  String mxw;
  private int mzA;
  Future<?> mzk;
  private int mzn;
  private int mzo;
  o mzp;
  private final Object mzq;
  int mzr;
  int mzs;
  long mzt;
  long mzu;
  public boolean mzv;
  String mzw;
  public String mzx;
  String mzy;
  private int mzz;
  int priority;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(234824);
    mzm = new AtomicInteger(10000);
    AppMethodBeat.o(234824);
  }
  
  public n()
  {
    AppMethodBeat.i(234816);
    this.mzn = 0;
    this.mzo = 0;
    this.mzq = new Object();
    this.mzs = 0;
    this.priority = -1;
    this.kNt = -1L;
    this.mxw = "";
    this.mxv = c.myu;
    this.mzr = mzm.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(234816);
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(234818);
      this.kNt = paramLong;
      this.mxv = paramc;
      if (this.mxv.equals(c.myw)) {
        this.mzs |= 0x8;
      }
      AppMethodBeat.o(234818);
      return;
    }
    finally {}
  }
  
  public final c bJP()
  {
    try
    {
      c localc = this.mxv;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long bJV()
  {
    AppMethodBeat.i(234820);
    long l = System.currentTimeMillis();
    l = ((float)(this.mzz * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(234820);
    return l;
  }
  
  public final void bJW()
  {
    AppMethodBeat.i(234821);
    if (eg(2, 3))
    {
      if (this.mzp != null) {
        this.mzp.bJY();
      }
      if (a.bJK().cWq) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.mzr);
      }
    }
    AppMethodBeat.o(234821);
  }
  
  public final void bJX()
  {
    AppMethodBeat.i(234822);
    if ((eg(1, 2)) && (a.bJK().cWq)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.mzr);
    }
    AppMethodBeat.o(234822);
  }
  
  final boolean eg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234823);
    synchronized (this.mzq)
    {
      if (this.mzo == paramInt1)
      {
        this.mzo = paramInt2;
        AppMethodBeat.o(234823);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.mzo), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(234823);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(234817);
    String str = this.mxw + "VideoRequest";
    AppMethodBeat.o(234817);
    return str;
  }
  
  public final long getTotalLength()
  {
    try
    {
      long l = this.kNt;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234819);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.mzr).append(",priority=").append(this.priority).append(",range=[").append(this.mzt).append(",").append(this.mzu).append("],uuid=").append(this.uuid).append(",contentType=").append(this.mzx).append(",cancelState=").append(this.mzo).append(",sourceUrl=").append(this.eby).append(",videoKey=").append(this.mzw).append(",task=");
    if (this.mzk == null) {}
    for (String str = "null";; str = this.mzk.toString())
    {
      str = str + "}";
      AppMethodBeat.o(234819);
      return str;
    }
  }
  
  public final void xA(int paramInt)
  {
    if ((this.mzn & paramInt) == 0) {
      this.mzn += paramInt;
    }
  }
  
  public final boolean xB(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mzq)
      {
        if (this.mzo == paramInt)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void xy(int paramInt)
  {
    try
    {
      this.mzA = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void xz(int paramInt)
  {
    try
    {
      this.mzz += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */