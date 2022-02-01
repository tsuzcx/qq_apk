package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/DefaultBluetoothBackgroundSupportClient;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "debugName", "", "getDebugName", "()Ljava/lang/String;", "debugName$1", "isNeedKeepAlive", "", "()Z", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "checkCanIEnable", "disable", "closeConnection", "enable", "removeListener", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements l
{
  public static final a rKq;
  private static final String roK;
  private final AppBrandRuntime qzz;
  private final String rKr;
  private final boolean rKs;
  
  static
  {
    AppMethodBeat.i(329518);
    rKq = new a((byte)0);
    roK = "DefaultBluetoothBackgroundSupportClientFactory";
    AppMethodBeat.o(329518);
  }
  
  public i(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329507);
    this.qzz = paramAppBrandRuntime;
    paramAppBrandRuntime = e.rKk;
    this.rKr = s.X("DefaultBluetoothBackgroundSupportClient#", e.a.ah(this.qzz));
    AppMethodBeat.o(329507);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(329552);
    s.u(paramb, "listener");
    AppMethodBeat.o(329552);
  }
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(329558);
    s.u(paramb, "listener");
    AppMethodBeat.o(329558);
  }
  
  public final boolean cjR()
  {
    return this.rKs;
  }
  
  public final String com()
  {
    return this.rKr;
  }
  
  public final void cqH()
  {
    AppMethodBeat.i(329531);
    Object localObject = a.e.rVy;
    s.s(localObject, "JSAPI_NOT_SUPPORTED");
    localObject = new f((a.d)localObject, (byte)0);
    AppMethodBeat.o(329531);
    throw ((Throwable)localObject);
  }
  
  public final void cqI() {}
  
  public final void enable() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/DefaultBluetoothBackgroundSupportClient$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;", "()V", "debugName", "", "getDebugName", "()Ljava/lang/String;", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/DefaultBluetoothBackgroundSupportClient;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements l.a
  {
    public final String com()
    {
      AppMethodBeat.i(329528);
      String str = i.cqJ();
      AppMethodBeat.o(329528);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i
 * JD-Core Version:    0.7.0.1
 */