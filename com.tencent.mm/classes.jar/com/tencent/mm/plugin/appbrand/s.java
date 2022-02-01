package com.tencent.mm.plugin.appbrand;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.r;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
{
  private static final Map<String, s> jZc;
  private static final s nvX;
  public volatile int lZJ;
  public volatile int lZO;
  public volatile long lastResumeTime;
  public c nvY;
  public r nvZ;
  public volatile String nwa;
  public final AtomicInteger nwb;
  public final AtomicBoolean nwc;
  public i.a nwd;
  public volatile String nwe;
  public volatile String nwf;
  public volatile boolean nwg;
  public volatile boolean nwh;
  public volatile boolean nwi;
  public volatile String nwj;
  public volatile int nwk;
  public volatile boolean nwl;
  public volatile boolean nwm;
  public volatile boolean nwn;
  public volatile boolean nwo;
  public volatile boolean nwp;
  public volatile boolean nwq;
  
  static
  {
    AppMethodBeat.i(134573);
    jZc = new a();
    nvX = new s();
    AppMethodBeat.o(134573);
  }
  
  private s()
  {
    AppMethodBeat.i(134566);
    this.nvY = new c();
    this.nvZ = null;
    this.nwb = new AtomicInteger();
    this.nwc = new AtomicBoolean(false);
    this.nwd = null;
    this.nwl = false;
    this.nwm = false;
    this.nwn = false;
    this.nwo = false;
    this.nwp = false;
    this.lZJ = -1;
    this.lZO = 0;
    this.nwq = false;
    AppMethodBeat.o(134566);
  }
  
  public static s abS(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = abT(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static s abT(String paramString)
  {
    AppMethodBeat.i(134568);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (jZc)
    {
      s locals2 = (s)jZc.get(paramString);
      s locals1 = locals2;
      if (locals2 == null)
      {
        locals1 = new s();
        jZc.put(paramString, locals1);
      }
      AppMethodBeat.o(134568);
      return locals1;
    }
  }
  
  private static s abU(String paramString)
  {
    AppMethodBeat.i(134569);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (jZc)
    {
      paramString = (s)jZc.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static s abV(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = abU(paramString);
    if (paramString == null)
    {
      paramString = nvX;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static s abW(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = abT(paramString);
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
    synchronized (jZc)
    {
      jZc.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */