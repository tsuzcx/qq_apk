package com.tencent.mm.plugin.appbrand.jsapi.ac.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.o;
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
  public boolean lxQ;
  public o lxR;
  public Set<o> lxS;
  
  public d()
  {
    AppMethodBeat.i(186914);
    this.lxQ = true;
    this.lxS = new HashSet();
    AppMethodBeat.o(186914);
  }
  
  public static void b(AppBrandRuntime paramAppBrandRuntime, int paramInt)
  {
    AppMethodBeat.i(186917);
    a locala = new a();
    locala.lxL.appId = paramAppBrandRuntime.mAppId;
    locala.lxL.beO = 4;
    locala.lxL.dkM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(locala);
    AppMethodBeat.o(186917);
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(186918);
    ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.lxQ;
    this.lxQ = paramBoolean;
    if (bool != paramBoolean) {
      b(paramAppBrandRuntime, 1);
    }
    AppMethodBeat.o(186918);
  }
  
  public final boolean a(o paramo, int paramInt)
  {
    AppMethodBeat.i(186915);
    boolean bool;
    if ((bdh()) && (paramInt != 3)) {
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a)) {
        if (this.lxR == paramo) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bdh()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(186915);
      return bool;
      bool = false;
      continue;
      if ((paramo instanceof com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a)) {
        bool = this.lxS.contains(paramo);
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean bdh()
  {
    return this.lxR != null;
  }
  
  public final void bgS()
  {
    try
    {
      AppMethodBeat.i(186916);
      if (this.lxR != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", new Object[] { this.lxR.FS() });
        this.lxR.FR();
      }
      Iterator localIterator = this.lxS.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (localo != null)
        {
          ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", new Object[] { localo.FS() });
          localo.FR();
        }
      }
      AppMethodBeat.o(186916);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.d
 * JD-Core Version:    0.7.0.1
 */