package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundAppCounter;", "", "()V", "backgroundApps", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundApp;", "Lkotlin/collections/HashSet;", "canIEnableBackgroundSupport", "", "me", "maxCount", "", "decrement", "", "app", "increment", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class s
{
  public static final s rKD;
  private static final HashSet<WCBluetoothBackgroundApp> rKE;
  
  static
  {
    AppMethodBeat.i(329571);
    rKD = new s();
    rKE = new HashSet();
    AppMethodBeat.o(329571);
  }
  
  public static boolean a(WCBluetoothBackgroundApp paramWCBluetoothBackgroundApp, int paramInt)
  {
    AppMethodBeat.i(329561);
    kotlin.g.b.s.u(paramWCBluetoothBackgroundApp, "me");
    HashSet localHashSet = rKE;
    p.a((Iterable)localHashSet, (b)a.rKF);
    if (localHashSet.contains(paramWCBluetoothBackgroundApp))
    {
      Log.i("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "canIEnableBackgroundSupport, backgroundApps contains me");
      AppMethodBeat.o(329561);
      return true;
    }
    if (paramInt >= localHashSet.size() + 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", kotlin.g.b.s.X("canIEnableBackgroundSupport, can: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(329561);
      return bool;
    }
  }
  
  public final void a(WCBluetoothBackgroundApp paramWCBluetoothBackgroundApp)
  {
    try
    {
      AppMethodBeat.i(329578);
      kotlin.g.b.s.u(paramWCBluetoothBackgroundApp, "app");
      rKE.add(paramWCBluetoothBackgroundApp);
      AppMethodBeat.o(329578);
      return;
    }
    finally
    {
      paramWCBluetoothBackgroundApp = finally;
      throw paramWCBluetoothBackgroundApp;
    }
  }
  
  public final void b(WCBluetoothBackgroundApp paramWCBluetoothBackgroundApp)
  {
    try
    {
      AppMethodBeat.i(329590);
      kotlin.g.b.s.u(paramWCBluetoothBackgroundApp, "app");
      rKE.remove(paramWCBluetoothBackgroundApp);
      AppMethodBeat.o(329590);
      return;
    }
    finally
    {
      paramWCBluetoothBackgroundApp = finally;
      throw paramWCBluetoothBackgroundApp;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "app", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundApp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<WCBluetoothBackgroundApp, Boolean>
  {
    public static final a rKF;
    
    static
    {
      AppMethodBeat.i(329563);
      rKF = new a();
      AppMethodBeat.o(329563);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.s
 * JD-Core Version:    0.7.0.1
 */