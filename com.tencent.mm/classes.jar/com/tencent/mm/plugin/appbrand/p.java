package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class p
{
  private static final Map<String, p> hno;
  private static final p kCN;
  public volatile int jjN;
  public volatile int jjS;
  public c kCO;
  public volatile String kCP;
  public final AtomicInteger kCQ;
  public final AtomicBoolean kCR;
  public i.a kCS;
  public volatile String kCT;
  public volatile String kCU;
  public volatile boolean kCV;
  public volatile boolean kCW;
  public volatile boolean kCX;
  public volatile String kCY;
  public volatile int kCZ;
  public volatile boolean kDa;
  public volatile boolean kDb;
  public volatile boolean kDc;
  public volatile boolean kDd;
  public volatile boolean kDe;
  public volatile boolean kDf;
  public volatile long lastResumeTime;
  
  static
  {
    AppMethodBeat.i(134573);
    hno = new a();
    kCN = new p();
    AppMethodBeat.o(134573);
  }
  
  private p()
  {
    AppMethodBeat.i(134566);
    this.kCO = new c();
    this.kCQ = new AtomicInteger();
    this.kCR = new AtomicBoolean(false);
    this.kCS = null;
    this.kDa = false;
    this.kDb = false;
    this.kDc = false;
    this.kDd = false;
    this.kDe = false;
    this.jjN = -1;
    this.jjS = 0;
    this.kDf = false;
    AppMethodBeat.o(134566);
  }
  
  public static p Uj(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = Uk(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static p Uk(String paramString)
  {
    AppMethodBeat.i(134568);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (hno)
    {
      p localp2 = (p)hno.get(paramString);
      p localp1 = localp2;
      if (localp2 == null)
      {
        localp1 = new p();
        hno.put(paramString, localp1);
      }
      AppMethodBeat.o(134568);
      return localp1;
    }
  }
  
  private static p Ul(String paramString)
  {
    AppMethodBeat.i(134569);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (hno)
    {
      paramString = (p)hno.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static p Um(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = Ul(paramString);
    if (paramString == null)
    {
      paramString = kCN;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static p Un(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = Uk(paramString);
    AppMethodBeat.o(134572);
    return paramString;
  }
  
  static void remove(String paramString)
  {
    AppMethodBeat.i(134570);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134570);
      return;
    }
    synchronized (hno)
    {
      hno.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */