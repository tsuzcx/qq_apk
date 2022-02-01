package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothAuthorizeStateQuickAccess;", "", "()V", "TAG", "", "listenerMap", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothAuthorizeStateListener;", "addListener", "", "appId", "listener", "onAuthorizeStateChange", "newState", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothAuthorizeState;", "removeListener", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d rKi;
  private static final com.tencent.mm.plugin.appbrand.af.j<String, j> rKj;
  
  static
  {
    AppMethodBeat.i(329549);
    rKi = new d();
    rKj = new com.tencent.mm.plugin.appbrand.af.j();
    AppMethodBeat.o(329549);
  }
  
  private static final void a(c paramc, j paramj)
  {
    AppMethodBeat.i(329542);
    paramj.a(paramc);
    AppMethodBeat.o(329542);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(329522);
    Log.i("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", "onAuthorizeStateChange, appId: " + paramString + ", newState: " + paramc);
    if (paramString == null)
    {
      AppMethodBeat.o(329522);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(329522);
      return;
    }
    rKj.a(paramString, new d..ExternalSyntheticLambda0(paramc));
    AppMethodBeat.o(329522);
  }
  
  public static void a(String paramString, j paramj)
  {
    AppMethodBeat.i(329526);
    Log.i("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", s.X("addListener, appId: ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(329526);
      return;
    }
    if (paramj == null)
    {
      AppMethodBeat.o(329526);
      return;
    }
    rKj.v(paramString, paramj);
    AppMethodBeat.o(329526);
  }
  
  public static void b(String paramString, j paramj)
  {
    AppMethodBeat.i(329535);
    Log.i("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", s.X("removeListener, appId: ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(329535);
      return;
    }
    if (paramj == null)
    {
      AppMethodBeat.o(329535);
      return;
    }
    rKj.O(paramString, paramj);
    AppMethodBeat.o(329535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d
 * JD-Core Version:    0.7.0.1
 */