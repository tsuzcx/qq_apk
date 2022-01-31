package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static final Map<String, n> eEq;
  private static final n gQU;
  public volatile String gQV;
  public final AtomicInteger gQW;
  public final AtomicBoolean gQX;
  public c.a gQY;
  public volatile String gQZ;
  public volatile String gRa;
  public volatile boolean gRb;
  public volatile boolean gRc;
  public volatile boolean gRd;
  public volatile String gRe;
  public volatile int gRf;
  public volatile boolean gRg;
  public volatile boolean gRh;
  public volatile boolean gRi;
  
  static
  {
    AppMethodBeat.i(86746);
    eEq = new a();
    gQU = new n();
    AppMethodBeat.o(86746);
  }
  
  private n()
  {
    AppMethodBeat.i(86739);
    this.gQW = new AtomicInteger();
    this.gQX = new AtomicBoolean(false);
    this.gQY = null;
    this.gRg = false;
    this.gRh = false;
    this.gRi = false;
    AppMethodBeat.o(86739);
  }
  
  static void remove(String paramString)
  {
    AppMethodBeat.i(86743);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(86743);
      return;
    }
    synchronized (eEq)
    {
      eEq.remove(paramString);
      AppMethodBeat.o(86743);
      return;
    }
  }
  
  public static n xZ(String paramString)
  {
    AppMethodBeat.i(86740);
    paramString = ya(paramString);
    AppMethodBeat.o(86740);
    return paramString;
  }
  
  private static n ya(String paramString)
  {
    AppMethodBeat.i(86741);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(86741);
      return null;
    }
    synchronized (eEq)
    {
      n localn2 = (n)eEq.get(paramString);
      n localn1 = localn2;
      if (localn2 == null)
      {
        localn1 = new n();
        eEq.put(paramString, localn1);
      }
      AppMethodBeat.o(86741);
      return localn1;
    }
  }
  
  private static n yb(String paramString)
  {
    AppMethodBeat.i(86742);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(86742);
      return null;
    }
    synchronized (eEq)
    {
      paramString = (n)eEq.get(paramString);
      AppMethodBeat.o(86742);
      return paramString;
    }
  }
  
  public static n yc(String paramString)
  {
    AppMethodBeat.i(86744);
    paramString = yb(paramString);
    if (paramString == null)
    {
      paramString = gQU;
      AppMethodBeat.o(86744);
      return paramString;
    }
    AppMethodBeat.o(86744);
    return paramString;
  }
  
  public static n yd(String paramString)
  {
    AppMethodBeat.i(86745);
    paramString = ya(paramString);
    AppMethodBeat.o(86745);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */