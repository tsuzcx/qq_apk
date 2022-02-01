package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger sCN;
  private final Object aoW;
  String ibx;
  boolean nAi;
  int priority;
  private long qHg;
  private c sAV;
  String sAW;
  Future<?> sCL;
  private int sCO;
  private int sCP;
  o sCQ;
  int sCR;
  int sCS;
  long sCT;
  long sCU;
  public boolean sCV;
  String sCW;
  public String sCX;
  String sCY;
  private int sCZ;
  private int sDa;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(328467);
    sCN = new AtomicInteger(10000);
    AppMethodBeat.o(328467);
  }
  
  public n()
  {
    AppMethodBeat.i(328456);
    this.sCO = 0;
    this.sCP = 0;
    this.aoW = new Object();
    this.sCS = 0;
    this.priority = -1;
    this.qHg = -1L;
    this.sAW = "";
    this.sAV = c.sBU;
    this.sCR = sCN.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(328456);
  }
  
  public final void Bk(int paramInt)
  {
    try
    {
      this.sDa = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Bl(int paramInt)
  {
    try
    {
      this.sCZ += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Bm(int paramInt)
  {
    if ((this.sCO & paramInt) == 0) {
      this.sCO += paramInt;
    }
  }
  
  public final boolean Bn(int paramInt)
  {
    synchronized (this.aoW)
    {
      if (this.sCP == paramInt)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final void a(long paramLong, c paramc)
  {
    try
    {
      AppMethodBeat.i(328500);
      this.qHg = paramLong;
      this.sAV = paramc;
      if (this.sAV.equals(c.sBW)) {
        this.sCS |= 0x8;
      }
      AppMethodBeat.o(328500);
      return;
    }
    finally {}
  }
  
  public final c cvM()
  {
    try
    {
      c localc = this.sAV;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long cvS()
  {
    AppMethodBeat.i(328513);
    long l = System.currentTimeMillis();
    l = ((float)(this.sCZ * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(328513);
    return l;
  }
  
  public final void cvT()
  {
    AppMethodBeat.i(328521);
    if (fy(2, 3))
    {
      if (this.sCQ != null) {
        this.sCQ.cvV();
      }
      if (a.cvH().eYL) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.sCR);
      }
    }
    AppMethodBeat.o(328521);
  }
  
  public final void cvU()
  {
    AppMethodBeat.i(328528);
    if ((fy(1, 2)) && (a.cvH().eYL)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.sCR);
    }
    AppMethodBeat.o(328528);
  }
  
  final boolean fy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328549);
    synchronized (this.aoW)
    {
      if (this.sCP == paramInt1)
      {
        this.sCP = paramInt2;
        AppMethodBeat.o(328549);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.sCP), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(328549);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(328486);
    String str = this.sAW + "VideoRequest";
    AppMethodBeat.o(328486);
    return str;
  }
  
  public final long getTotalLength()
  {
    try
    {
      long l = this.qHg;
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
    AppMethodBeat.i(328505);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.sCR).append(",priority=").append(this.priority).append(",range=[").append(this.sCT).append(",").append(this.sCU).append("],uuid=").append(this.uuid).append(",contentType=").append(this.sCX).append(",cancelState=").append(this.sCP).append(",sourceUrl=").append(this.ibx).append(",videoKey=").append(this.sCW).append(",task=");
    if (this.sCL == null) {}
    for (String str = "null";; str = this.sCL.toString())
    {
      str = str + "}";
      AppMethodBeat.o(328505);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */