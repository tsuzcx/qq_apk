package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.b;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static final Map<String, n> gej;
  private static final n jfL;
  public b jfM;
  public volatile String jfN;
  public final AtomicInteger jfO;
  public final AtomicBoolean jfP;
  public c.a jfQ;
  public volatile String jfR;
  public volatile String jfS;
  public volatile boolean jfT;
  public volatile boolean jfU;
  public volatile boolean jfV;
  public volatile String jfW;
  public volatile int jfX;
  public volatile boolean jfY;
  public volatile boolean jfZ;
  public volatile boolean jga;
  public volatile boolean jgb;
  public volatile long lastResumeTime;
  
  static
  {
    AppMethodBeat.i(134573);
    gej = new a();
    jfL = new n();
    AppMethodBeat.o(134573);
  }
  
  private n()
  {
    AppMethodBeat.i(134566);
    this.jfM = new b();
    this.jfO = new AtomicInteger();
    this.jfP = new AtomicBoolean(false);
    this.jfQ = null;
    this.jfY = false;
    this.jfZ = false;
    this.jga = false;
    this.jgb = false;
    AppMethodBeat.o(134566);
  }
  
  public static n Ho(String paramString)
  {
    AppMethodBeat.i(134567);
    paramString = Hp(paramString);
    AppMethodBeat.o(134567);
    return paramString;
  }
  
  private static n Hp(String paramString)
  {
    AppMethodBeat.i(134568);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134568);
      return null;
    }
    synchronized (gej)
    {
      n localn2 = (n)gej.get(paramString);
      n localn1 = localn2;
      if (localn2 == null)
      {
        localn1 = new n();
        gej.put(paramString, localn1);
      }
      AppMethodBeat.o(134568);
      return localn1;
    }
  }
  
  private static n Hq(String paramString)
  {
    AppMethodBeat.i(134569);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134569);
      return null;
    }
    synchronized (gej)
    {
      paramString = (n)gej.get(paramString);
      AppMethodBeat.o(134569);
      return paramString;
    }
  }
  
  public static n Hr(String paramString)
  {
    AppMethodBeat.i(134571);
    paramString = Hq(paramString);
    if (paramString == null)
    {
      paramString = jfL;
      AppMethodBeat.o(134571);
      return paramString;
    }
    AppMethodBeat.o(134571);
    return paramString;
  }
  
  public static n Hs(String paramString)
  {
    AppMethodBeat.i(134572);
    paramString = Hp(paramString);
    AppMethodBeat.o(134572);
    return paramString;
  }
  
  static void remove(String paramString)
  {
    AppMethodBeat.i(134570);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134570);
      return;
    }
    synchronized (gej)
    {
      gej.remove(paramString);
      AppMethodBeat.o(134570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */