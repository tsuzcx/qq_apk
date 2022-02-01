package com.tencent.mm.plugin.appbrand.jsapi.aa.c;

import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.k;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  extends k
{
  public n kzA;
  public Set<n> kzB;
  public boolean kzz;
  
  public d()
  {
    AppMethodBeat.i(195082);
    this.kzz = true;
    this.kzB = new HashSet();
    AppMethodBeat.o(195082);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(195085);
    a locala = new a();
    locala.kzu.appId = paramAppBrandRuntime.mAppId;
    locala.kzu.aTC = 4;
    locala.kzu.dbV = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(locala);
    AppMethodBeat.o(195085);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(195086);
    ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.kzz;
    this.kzz = paramBoolean;
    if (bool != paramBoolean) {
      a(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(195086);
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    AppMethodBeat.i(195083);
    boolean bool;
    if ((aSL()) && (paramInt != 3)) {
      if ((paramn instanceof com.tencent.luggage.k.a.a.a.b.a)) {
        if (this.kzA == paramn) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(aSL()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(195083);
      return bool;
      bool = false;
      continue;
      if ((paramn instanceof com.tencent.luggage.k.a.a.a.a.a)) {
        bool = this.kzB.contains(paramn);
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean aSL()
  {
    return this.kzA != null;
  }
  
  public final void aWq()
  {
    try
    {
      AppMethodBeat.i(195084);
      if (this.kzA != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.kzA.EP() });
        this.kzA.EO();
      }
      Iterator localIterator = this.kzB.iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        if (localn != null)
        {
          ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localn.EP() });
          localn.EO();
        }
      }
      AppMethodBeat.o(195084);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.d
 * JD-Core Version:    0.7.0.1
 */