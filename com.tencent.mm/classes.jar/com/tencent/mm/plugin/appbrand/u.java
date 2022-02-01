package com.tencent.mm.plugin.appbrand;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.t;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
{
  private static final Map<String, u> mza;
  private static final u quU;
  public c quV;
  public t quW;
  public volatile String quX;
  public final AtomicInteger quY;
  public final AtomicBoolean quZ;
  public m.a qva;
  public volatile String qvb;
  public volatile String qvc;
  public volatile boolean qvd;
  public volatile boolean qve;
  public volatile boolean qvf;
  public volatile String qvg;
  public volatile int qvh;
  public volatile boolean qvi;
  public volatile boolean qvj;
  public volatile boolean qvk;
  public volatile long qvl;
  public volatile boolean qvm;
  public volatile boolean qvn;
  public volatile int qvo;
  public volatile int qvp;
  public volatile boolean qvq;
  
  static
  {
    AppMethodBeat.i(134573);
    mza = new a();
    quU = new u();
    AppMethodBeat.o(134573);
  }
  
  private u()
  {
    AppMethodBeat.i(134566);
    this.quV = new c();
    this.quW = null;
    this.quY = new AtomicInteger();
    this.quZ = new AtomicBoolean(false);
    this.qva = null;
    this.qvi = false;
    this.qvj = false;
    this.qvk = false;
    this.qvm = false;
    this.qvn = false;
    this.qvo = -1;
    this.qvp = 0;
    this.qvq = false;
    AppMethodBeat.o(134566);
  }
  
  public static u Uu(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = Uv(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static u Uv(String paramString)
  {
    AppMethodBeat.i(134568);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (mza)
    {
      u localu2 = (u)mza.get(paramString);
      u localu1 = localu2;
      if (localu2 == null)
      {
        localu1 = new u();
        mza.put(paramString, localu1);
      }
      AppMethodBeat.o(134568);
      return localu1;
    }
  }
  
  private static u Uw(String paramString)
  {
    AppMethodBeat.i(134569);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (mza)
    {
      paramString = (u)mza.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static u Ux(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = Uw(paramString);
    if (paramString == null)
    {
      paramString = quU;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static u Uy(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = Uv(paramString);
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
    synchronized (mza)
    {
      mza.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u
 * JD-Core Version:    0.7.0.1
 */