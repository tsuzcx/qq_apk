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
  private static final Map<String, n> fZD;
  private static final n iFJ;
  public b iFK;
  public volatile String iFL;
  public final AtomicInteger iFM;
  public final AtomicBoolean iFN;
  public c.a iFO;
  public volatile String iFP;
  public volatile String iFQ;
  public volatile boolean iFR;
  public volatile boolean iFS;
  public volatile boolean iFT;
  public volatile String iFU;
  public volatile int iFV;
  public volatile boolean iFW;
  public volatile boolean iFX;
  public volatile boolean iFY;
  public volatile boolean iFZ;
  public volatile long lastResumeTime;
  
  static
  {
    AppMethodBeat.i(134573);
    fZD = new a();
    iFJ = new n();
    AppMethodBeat.o(134573);
  }
  
  private n()
  {
    AppMethodBeat.i(134566);
    this.iFK = new b();
    this.iFM = new AtomicInteger();
    this.iFN = new AtomicBoolean(false);
    this.iFO = null;
    this.iFW = false;
    this.iFX = false;
    this.iFY = false;
    this.iFZ = false;
    AppMethodBeat.o(134566);
  }
  
  public static n Dl(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = Dm(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static n Dm(String paramString)
  {
    AppMethodBeat.i(134568);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (fZD)
    {
      n localn2 = (n)fZD.get(paramString);
      n localn1 = localn2;
      if (localn2 == null)
      {
        localn1 = new n();
        fZD.put(paramString, localn1);
      }
      AppMethodBeat.o(134568);
      return localn1;
    }
  }
  
  private static n Dn(String paramString)
  {
    AppMethodBeat.i(134569);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (fZD)
    {
      paramString = (n)fZD.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static n Do(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = Dn(paramString);
    if (paramString == null)
    {
      paramString = iFJ;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static n Dp(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = Dm(paramString);
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
    synchronized (fZD)
    {
      fZD.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */