package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothBackgroundSupportAccessible;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportAccessible;", "clientFactory", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;)V", "destroyClientIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getClient", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "requireClient", "IMPL", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements k
{
  public static final a rKk;
  private static volatile k rKm;
  private final l.a rKl;
  
  static
  {
    AppMethodBeat.i(329541);
    rKk = new a((byte)0);
    rKm = (k)new e((l.a)i.rKq);
    AppMethodBeat.o(329541);
  }
  
  public e(l.a parama)
  {
    AppMethodBeat.i(329521);
    this.rKl = parama;
    AppMethodBeat.o(329521);
  }
  
  public final l ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329548);
    s.u(paramAppBrandRuntime, "runtime");
    l locall = af(paramAppBrandRuntime);
    if (locall == null)
    {
      locall = this.rKl.aj(paramAppBrandRuntime);
      paramAppBrandRuntime.a((n)locall);
      AppMethodBeat.o(329548);
      return locall;
    }
    AppMethodBeat.o(329548);
    return locall;
  }
  
  public final l af(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329554);
    s.u(paramAppBrandRuntime, "runtime");
    paramAppBrandRuntime = (l)paramAppBrandRuntime.aO(l.class);
    AppMethodBeat.o(329554);
    return paramAppBrandRuntime;
  }
  
  public final void ag(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329562);
    s.u(paramAppBrandRuntime, "runtime");
    l locall = af(paramAppBrandRuntime);
    if (locall != null) {
      paramAppBrandRuntime.b((n)locall);
    }
    AppMethodBeat.o(329562);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothBackgroundSupportAccessible$IMPL;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportAccessible;", "()V", "TAG", "", "realAccessible", "destroyClientIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "dump", "getClient", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "install", "clientFactory", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;", "isInBackground", "", "requireClient", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements k
  {
    public static String ah(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(329593);
      s.u(paramAppBrandRuntime, "runtime");
      AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.asH();
      if (localAppBrandInitConfig == null)
      {
        i = paramAppBrandRuntime.hashCode();
        AppMethodBeat.o(329593);
        return String.valueOf(i);
      }
      paramAppBrandRuntime = localAppBrandInitConfig.appId;
      int i = localAppBrandInitConfig.eul;
      paramAppBrandRuntime = paramAppBrandRuntime + '#' + i;
      AppMethodBeat.o(329593);
      return paramAppBrandRuntime;
    }
    
    public static boolean ai(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(329600);
      s.u(paramAppBrandRuntime, "runtime");
      paramAppBrandRuntime = paramAppBrandRuntime.qsB;
      if (paramAppBrandRuntime == null)
      {
        Log.w("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", "isRuntimeInBackground, runningStateController is null");
        AppMethodBeat.o(329600);
        return false;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.qKC.chD();
      Log.i("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", s.X("isRuntimeInBackground, currentState: ", paramAppBrandRuntime));
      if (b.qKx == paramAppBrandRuntime)
      {
        AppMethodBeat.o(329600);
        return true;
      }
      AppMethodBeat.o(329600);
      return false;
    }
    
    public final l ae(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(329611);
      s.u(paramAppBrandRuntime, "runtime");
      Log.i("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", s.X("requireClient, runtime: ", ah(paramAppBrandRuntime)));
      paramAppBrandRuntime = e.cqG().ae(paramAppBrandRuntime);
      AppMethodBeat.o(329611);
      return paramAppBrandRuntime;
    }
    
    public final l af(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(329615);
      s.u(paramAppBrandRuntime, "runtime");
      Log.i("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", s.X("getClient, runtime: ", ah(paramAppBrandRuntime)));
      paramAppBrandRuntime = e.cqG().af(paramAppBrandRuntime);
      AppMethodBeat.o(329615);
      return paramAppBrandRuntime;
    }
    
    public final void ag(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(329620);
      s.u(paramAppBrandRuntime, "runtime");
      Log.i("MicroMsg.AppBrand.BluetoothBackgroundSupportAccessible", s.X("destroyClientIfNeed, runtime: ", ah(paramAppBrandRuntime)));
      e.cqG().ag(paramAppBrandRuntime);
      AppMethodBeat.o(329620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e
 * JD-Core Version:    0.7.0.1
 */