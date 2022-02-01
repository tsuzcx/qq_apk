package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e
  extends j
{
  public boolean mJN;
  public com.tencent.luggage.xweb_ext.extendplugin.component.o mJO;
  public Set<com.tencent.luggage.xweb_ext.extendplugin.component.o> mJP;
  
  public e()
  {
    AppMethodBeat.i(215853);
    this.mJN = true;
    this.mJP = new HashSet();
    AppMethodBeat.o(215853);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, com.tencent.luggage.xweb_ext.extendplugin.component.o paramo)
  {
    AppMethodBeat.i(215857);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { paramAppBrandRuntime.mAppId, paramo.PH() });
    b(paramAppBrandRuntime, 1);
    AppMethodBeat.o(215857);
  }
  
  public static void b(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(215858);
    a locala = new a();
    locala.mJH.appId = paramAppBrandRuntime.mAppId;
    locala.mJH.beL = 4;
    locala.mJH.dDe = paramInt;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(215858);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.o paramo, int paramInt)
  {
    AppMethodBeat.i(215855);
    boolean bool;
    if ((bzd()) && (paramInt != 3)) {
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o)) {
        if (this.mJO == paramo) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bzd()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(215855);
      return bool;
      bool = false;
      continue;
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a)) {
        bool = this.mJP.contains(paramo);
      } else {
        bool = false;
      }
    }
  }
  
  public final void bCO()
  {
    try
    {
      AppMethodBeat.i(215856);
      if (this.mJO != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.mJO.PH() });
        this.mJO.PG();
      }
      Iterator localIterator = this.mJP.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.xweb_ext.extendplugin.component.o localo = (com.tencent.luggage.xweb_ext.extendplugin.component.o)localIterator.next();
        if (localo != null)
        {
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localo.PH() });
          localo.PG();
        }
      }
      AppMethodBeat.o(215856);
    }
    finally {}
  }
  
  public final boolean bzd()
  {
    AppMethodBeat.i(215854);
    if ((this.mJO != null) && (!this.mJP.isEmpty()))
    {
      AppMethodBeat.o(215854);
      return true;
    }
    AppMethodBeat.o(215854);
    return false;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(215859);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.mJN;
    this.mJN = paramBoolean;
    if (bool != paramBoolean) {
      b(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(215859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.e
 * JD-Core Version:    0.7.0.1
 */