package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.b;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static final Map<String, n> gxT;
  private static final n jyR;
  public b jyS;
  public volatile String jyT;
  public final AtomicInteger jyU;
  public final AtomicBoolean jyV;
  public c.a jyW;
  public volatile String jyX;
  public volatile String jyY;
  public volatile boolean jyZ;
  public volatile boolean jza;
  public volatile boolean jzb;
  public volatile String jzc;
  public volatile int jzd;
  public volatile boolean jze;
  public volatile boolean jzf;
  public volatile boolean jzg;
  public volatile boolean jzh;
  public volatile long lastResumeTime;
  
  static
  {
    AppMethodBeat.i(134573);
    gxT = new a();
    jyR = new n();
    AppMethodBeat.o(134573);
  }
  
  private n()
  {
    AppMethodBeat.i(134566);
    this.jyS = new b();
    this.jyU = new AtomicInteger();
    this.jyV = new AtomicBoolean(false);
    this.jyW = null;
    this.jze = false;
    this.jzf = false;
    this.jzg = false;
    this.jzh = false;
    AppMethodBeat.o(134566);
  }
  
  public static n KB(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = KC(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static n KC(String paramString)
  {
    AppMethodBeat.i(134568);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (gxT)
    {
      n localn2 = (n)gxT.get(paramString);
      n localn1 = localn2;
      if (localn2 == null)
      {
        localn1 = new n();
        gxT.put(paramString, localn1);
      }
      AppMethodBeat.o(134568);
      return localn1;
    }
  }
  
  private static n KD(String paramString)
  {
    AppMethodBeat.i(134569);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (gxT)
    {
      paramString = (n)gxT.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static n KE(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = KD(paramString);
    if (paramString == null)
    {
      paramString = jyR;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static n KF(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = KC(paramString);
    AppMethodBeat.o(134572);
    return paramString;
  }
  
  static void remove(String paramString)
  {
    AppMethodBeat.i(134570);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134570);
      return;
    }
    synchronized (gxT)
    {
      gxT.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */