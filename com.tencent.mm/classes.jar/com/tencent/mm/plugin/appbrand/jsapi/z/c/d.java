package com.tencent.mm.plugin.appbrand.jsapi.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.k
{
  public boolean laQ;
  public com.tencent.luggage.k.a.a.k laR;
  public Set<com.tencent.luggage.k.a.a.k> laS;
  
  public d()
  {
    AppMethodBeat.i(206725);
    this.laQ = true;
    this.laS = new HashSet();
    AppMethodBeat.o(206725);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(206728);
    a locala = new a();
    locala.laL.appId = paramAppBrandRuntime.mAppId;
    locala.laL.aUu = 4;
    locala.laL.cZu = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(locala);
    AppMethodBeat.o(206728);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(206729);
    ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.laQ;
    this.laQ = paramBoolean;
    if (bool != paramBoolean) {
      a(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(206729);
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.k paramk, int paramInt)
  {
    AppMethodBeat.i(206726);
    boolean bool;
    if ((aZI()) && (paramInt != 3)) {
      if ((paramk instanceof com.tencent.luggage.k.a.a.a.b.a)) {
        if (this.laR == paramk) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(aZI()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(206726);
      return bool;
      bool = false;
      continue;
      if ((paramk instanceof com.tencent.luggage.k.a.a.a.a.a)) {
        bool = this.laS.contains(paramk);
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean aZI()
  {
    return this.laR != null;
  }
  
  public final void bdo()
  {
    try
    {
      AppMethodBeat.i(206727);
      if (this.laR != null)
      {
        ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.laR.Et() });
        this.laR.Es();
      }
      Iterator localIterator = this.laS.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.k.a.a.k localk = (com.tencent.luggage.k.a.a.k)localIterator.next();
        if (localk != null)
        {
          ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localk.Et() });
          localk.Es();
        }
      }
      AppMethodBeat.o(206727);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c.d
 * JD-Core Version:    0.7.0.1
 */