package com.tencent.mm.plugin.appbrand.jsapi.ad.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  extends j
{
  public boolean lCo;
  public o lCp;
  public Set<o> lCq;
  
  public d()
  {
    AppMethodBeat.i(220611);
    this.lCo = true;
    this.lCq = new HashSet();
    AppMethodBeat.o(220611);
  }
  
  public static void b(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(220614);
    a locala = new a();
    locala.lCj.appId = paramAppBrandRuntime.mAppId;
    locala.lCj.beO = 4;
    locala.lCj.dlO = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(locala);
    AppMethodBeat.o(220614);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(220615);
    ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.lCo;
    this.lCo = paramBoolean;
    if (bool != paramBoolean) {
      b(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(220615);
  }
  
  public final boolean a(o paramo, int paramInt)
  {
    AppMethodBeat.i(220612);
    boolean bool;
    if ((bdM()) && (paramInt != 3)) {
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a)) {
        if (this.lCp == paramo) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bdM()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(220612);
      return bool;
      bool = false;
      continue;
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a)) {
        bool = this.lCq.contains(paramo);
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean bdM()
  {
    return this.lCp != null;
  }
  
  public final void bhA()
  {
    try
    {
      AppMethodBeat.i(220613);
      if (this.lCp != null)
      {
        ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.lCp.FY() });
        this.lCp.FX();
      }
      Iterator localIterator = this.lCq.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (localo != null)
        {
          ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localo.FY() });
          localo.FX();
        }
      }
      AppMethodBeat.o(220613);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.d
 * JD-Core Version:    0.7.0.1
 */