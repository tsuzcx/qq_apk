package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static AtomicInteger pxH;
  String fVx;
  boolean kUD;
  private long nHt;
  int priority;
  private c pvP;
  String pvQ;
  Future<?> pxF;
  private int pxI;
  private int pxJ;
  o pxK;
  private final Object pxL;
  int pxM;
  int pxN;
  long pxO;
  long pxP;
  public boolean pxQ;
  String pxR;
  public String pxS;
  String pxT;
  private int pxU;
  private int pxV;
  long startTime;
  String uuid;
  
  static
  {
    AppMethodBeat.i(228796);
    pxH = new AtomicInteger(10000);
    AppMethodBeat.o(228796);
  }
  
  public n()
  {
    AppMethodBeat.i(228748);
    this.pxI = 0;
    this.pxJ = 0;
    this.pxL = new Object();
    this.pxN = 0;
    this.priority = -1;
    this.nHt = -1L;
    this.pvQ = "";
    this.pvP = c.pwO;
    this.pxM = pxH.incrementAndGet();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(228748);
  }
  
  public final void AV(int paramInt)
  {
    try
    {
      this.pxV = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void AW(int paramInt)
  {
    try
    {
      this.pxU += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void AX(int paramInt)
  {
    if ((this.pxI & paramInt) == 0) {
      this.pxI += paramInt;
    }
  }
  
  public final boolean AY(int paramInt)
  {
    synchronized (this.pxL)
    {
      if (this.pxJ == paramInt)
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
      AppMethodBeat.i(228761);
      this.nHt = paramLong;
      this.pvP = paramc;
      if (this.pvP.equals(c.pwQ)) {
        this.pxN |= 0x8;
      }
      AppMethodBeat.o(228761);
      return;
    }
    finally {}
  }
  
  public final long bVF()
  {
    AppMethodBeat.i(228773);
    long l = System.currentTimeMillis();
    l = ((float)(this.pxU * 1000L) / (float)((l - this.startTime) * 1024L));
    AppMethodBeat.o(228773);
    return l;
  }
  
  public final void bVG()
  {
    AppMethodBeat.i(228778);
    if (eE(2, 3))
    {
      if (this.pxK != null) {
        this.pxK.bVI();
      }
      if (a.bVt().dal) {
        h.log(3, getLogTag(), "cancel success, seq=" + this.pxM);
      }
    }
    AppMethodBeat.o(228778);
  }
  
  public final void bVH()
  {
    AppMethodBeat.i(228782);
    if ((eE(1, 2)) && (a.bVt().dal)) {
      h.log(3, getLogTag(), "cancel proceeding, seq=" + this.pxM);
    }
    AppMethodBeat.o(228782);
  }
  
  public final c bVy()
  {
    try
    {
      c localc = this.pvP;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final boolean eE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228795);
    synchronized (this.pxL)
    {
      if (this.pxJ == paramInt1)
      {
        this.pxJ = paramInt2;
        AppMethodBeat.o(228795);
        return true;
      }
      h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.pxJ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(228795);
      return false;
    }
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(228755);
    String str = this.pvQ + "VideoRequest";
    AppMethodBeat.o(228755);
    return str;
  }
  
  public final long getTotalLength()
  {
    try
    {
      long l = this.nHt;
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
    AppMethodBeat.i(228768);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{seq=").append(this.pxM).append(",priority=").append(this.priority).append(",range=[").append(this.pxO).append(",").append(this.pxP).append("],uuid=").append(this.uuid).append(",contentType=").append(this.pxS).append(",cancelState=").append(this.pxJ).append(",sourceUrl=").append(this.fVx).append(",videoKey=").append(this.pxR).append(",task=");
    if (this.pxF == null) {}
    for (String str = "null";; str = this.pxF.toString())
    {
      str = str + "}";
      AppMethodBeat.o(228768);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n
 * JD-Core Version:    0.7.0.1
 */