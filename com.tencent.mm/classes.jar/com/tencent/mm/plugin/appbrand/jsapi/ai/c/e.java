package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
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
  public boolean pKF;
  public o pKG;
  public Set<o> pKH;
  
  public e()
  {
    AppMethodBeat.i(222834);
    this.pKF = true;
    this.pKH = new HashSet();
    AppMethodBeat.o(222834);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, o paramo)
  {
    AppMethodBeat.i(222847);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { paramAppBrandRuntime.mAppId, paramo.Tg() });
    b(paramAppBrandRuntime, 1);
    AppMethodBeat.o(222847);
  }
  
  public static void b(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(222851);
    a locala = new a();
    locala.pKz.appId = paramAppBrandRuntime.mAppId;
    locala.pKz.aOm = 4;
    locala.pKz.fvK = paramInt;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(222851);
  }
  
  public final boolean a(o paramo, int paramInt)
  {
    AppMethodBeat.i(222839);
    boolean bool;
    if ((bKs()) && (paramInt != 3)) {
      if ((paramo instanceof p)) {
        if (this.pKG == paramo) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bKs()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(222839);
      return bool;
      bool = false;
      continue;
      if ((paramo instanceof b)) {
        bool = this.pKH.contains(paramo);
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean bKs()
  {
    AppMethodBeat.i(222835);
    if ((this.pKG != null) && (!this.pKH.isEmpty()))
    {
      AppMethodBeat.o(222835);
      return true;
    }
    AppMethodBeat.o(222835);
    return false;
  }
  
  public final void bOj()
  {
    try
    {
      AppMethodBeat.i(222841);
      if (this.pKG != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.pKG.Tg() });
        this.pKG.forceStop();
      }
      Iterator localIterator = this.pKH.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (localo != null)
        {
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localo.Tg() });
          localo.forceStop();
        }
      }
      AppMethodBeat.o(222841);
    }
    finally {}
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(222854);
    Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.pKF;
    this.pKF = paramBoolean;
    if (bool != paramBoolean) {
      b(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(222854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.e
 * JD-Core Version:    0.7.0.1
 */