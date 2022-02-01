package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class o
{
  private static final Map<String, o> gAA;
  private static final o jBR;
  public volatile int ioG;
  public volatile int ioL;
  public c jBS;
  public volatile String jBT;
  public final AtomicInteger jBU;
  public final AtomicBoolean jBV;
  public i.a jBW;
  public volatile String jBX;
  public volatile String jBY;
  public volatile boolean jBZ;
  public volatile boolean jCa;
  public volatile boolean jCb;
  public volatile String jCc;
  public volatile int jCd;
  public volatile boolean jCe;
  public volatile boolean jCf;
  public volatile boolean jCg;
  public volatile boolean jCh;
  public volatile boolean jCi;
  public volatile boolean kRc;
  public volatile long lastResumeTime;
  
  static
  {
    AppMethodBeat.i(134573);
    gAA = new a();
    jBR = new o();
    AppMethodBeat.o(134573);
  }
  
  private o()
  {
    AppMethodBeat.i(134566);
    this.jBS = new c();
    this.jBU = new AtomicInteger();
    this.jBV = new AtomicBoolean(false);
    this.jBW = null;
    this.jCe = false;
    this.jCf = false;
    this.jCg = false;
    this.jCh = false;
    this.jCi = false;
    this.ioG = -1;
    this.ioL = 0;
    this.kRc = false;
    AppMethodBeat.o(134566);
  }
  
  public static o La(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = Lb(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static o Lb(String paramString)
  {
    AppMethodBeat.i(134568);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (gAA)
    {
      o localo2 = (o)gAA.get(paramString);
      o localo1 = localo2;
      if (localo2 == null)
      {
        localo1 = new o();
        gAA.put(paramString, localo1);
      }
      AppMethodBeat.o(134568);
      return localo1;
    }
  }
  
  private static o Lc(String paramString)
  {
    AppMethodBeat.i(134569);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (gAA)
    {
      paramString = (o)gAA.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static o Ld(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = Lc(paramString);
    if (paramString == null)
    {
      paramString = jBR;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static o Le(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = Lb(paramString);
    AppMethodBeat.o(134572);
    return paramString;
  }
  
  static void remove(String paramString)
  {
    AppMethodBeat.i(134570);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134570);
      return;
    }
    synchronized (gAA)
    {
      gAA.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */