package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e
  extends j
{
  public Set<o> sPA;
  public boolean sPy;
  public o sPz;
  
  public e()
  {
    AppMethodBeat.i(327092);
    this.sPy = true;
    this.sPA = new HashSet();
    AppMethodBeat.o(327092);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, o paramo)
  {
    AppMethodBeat.i(327095);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { paramAppBrandRuntime.mAppId, paramo.atL() });
    b(paramAppBrandRuntime, 1);
    AppMethodBeat.o(327095);
  }
  
  public static void b(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(327099);
    a locala = new a();
    locala.sPs.appId = paramAppBrandRuntime.mAppId;
    locala.sPs.cIi = 4;
    locala.sPs.hAf = paramInt;
    locala.publish();
    AppMethodBeat.o(327099);
  }
  
  public final boolean a(o paramo, int paramInt)
  {
    AppMethodBeat.i(327109);
    boolean bool;
    if ((cjS()) && (paramInt != 3)) {
      if ((paramo instanceof r)) {
        if (this.sPz == paramo) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(cjS()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(327109);
      return bool;
      bool = false;
      continue;
      if ((paramo instanceof b)) {
        bool = this.sPA.contains(paramo);
      } else {
        bool = false;
      }
    }
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(327121);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.sPy;
    this.sPy = paramBoolean;
    if (bool != paramBoolean) {
      b(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(327121);
  }
  
  public final boolean cjS()
  {
    AppMethodBeat.i(327101);
    if ((this.sPz != null) && (!this.sPA.isEmpty()))
    {
      AppMethodBeat.o(327101);
      return true;
    }
    AppMethodBeat.o(327101);
    return false;
  }
  
  public final void cow()
  {
    try
    {
      AppMethodBeat.i(327116);
      if (this.sPz != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.sPz.atL() });
        this.sPz.forceStop();
      }
      Iterator localIterator = this.sPA.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (localo != null)
        {
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localo.atL() });
          localo.forceStop();
        }
      }
      AppMethodBeat.o(327116);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.e
 * JD-Core Version:    0.7.0.1
 */