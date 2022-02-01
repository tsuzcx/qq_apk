package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.MonitoredBluetoothDeviceInfo;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.g;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.m;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/OnMonitoredBluetoothDeviceFoundEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "deviceInfo", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "(Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;)V", "dispatchWhenReady", "", "doAfterDispatch", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lkotlin/ParameterName;", "name", "service", "runOnAppBrandCreate", "appId", "", "block", "Lkotlin/Function0;", "runOnAppBrandInitReady", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends bc
{
  public static final int CTRL_INDEX = 1090;
  public static final String NAME = "onMonitoredBluetoothDeviceFound";
  public static final a rKy;
  private final MonitoredBluetoothDeviceInfo rKz;
  
  static
  {
    AppMethodBeat.i(329574);
    rKy = new a((byte)0);
    AppMethodBeat.o(329574);
  }
  
  public r(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    AppMethodBeat.i(329525);
    this.rKz = paramMonitoredBluetoothDeviceInfo;
    paramMonitoredBluetoothDeviceInfo = this.rKz.field_appId;
    String str = this.rKz.field_bluetoothDeviceId;
    Log.i("MicroMsg.AppBrand.MonitoredBluetoothDevices", "<init>#OnMonitoredBluetoothDeviceFoundEvent, appId: " + paramMonitoredBluetoothDeviceInfo + ", deviceId: " + str);
    w("bluetoothDeviceId", str);
    AppMethodBeat.o(329525);
  }
  
  private static final void a(r paramr, b<? super y, ah> paramb, y paramy)
  {
    AppMethodBeat.i(329560);
    paramr.i((f)paramy).cpV();
    g.a(paramr.rKz, com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.s.rhA, (m)new c(paramy));
    if (paramb != null) {
      paramb.invoke(paramy);
    }
    AppMethodBeat.o(329560);
  }
  
  private static final void a(b paramb, w paramw)
  {
    AppMethodBeat.i(329566);
    kotlin.g.b.s.u(paramb, "$block");
    kotlin.g.b.s.u(paramw, "$this_apply");
    paramb.invoke(paramw);
    AppMethodBeat.o(329566);
  }
  
  private static void f(String paramString, final b<? super AppBrandRuntime, ah> paramb)
  {
    AppMethodBeat.i(329545);
    w localw = com.tencent.mm.plugin.appbrand.d.Uc(paramString);
    if (localw == null) {
      localw = null;
    }
    for (;;)
    {
      if (localw == null) {
        n(paramString, (a)new e(paramString, paramb));
      }
      AppMethodBeat.o(329545);
      return;
      localw.U(new r..ExternalSyntheticLambda0(paramb, localw));
    }
  }
  
  private static void n(String paramString, a<ah> parama)
  {
    AppMethodBeat.i(329551);
    k.a(paramString, (k.c)new r.d(parama, paramString));
    AppMethodBeat.o(329551);
  }
  
  public final void Q(final b<? super y, ah> paramb)
  {
    AppMethodBeat.i(329588);
    String str = this.rKz.field_appId;
    Object localObject = com.tencent.mm.plugin.appbrand.d.Uc(str);
    int i;
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (true != ((c)localObject).ZK("onMonitoredBluetoothDeviceFound"))) {
        break label112;
      }
      i = 1;
      label47:
      if (i != 0) {
        break label122;
      }
      if (localObject == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.MonitoredBluetoothDevices", kotlin.g.b.s.X("dispatchWhenReady, dispatchWhenRuntimeReady, appService exists: ", Boolean.valueOf(bool)));
      kotlin.g.b.s.s(str, "appId");
      f(str, (b)new b(this, paramb));
      AppMethodBeat.o(329588);
      return;
      localObject = ((w)localObject).ccO();
      break;
      i = 0;
      break label47;
    }
    label122:
    a(this, paramb, (y)localObject);
    AppMethodBeat.o(329588);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/OnMonitoredBluetoothDeviceFoundEvent$Companion;", "", "()V", "CTRL_INDEX", "", "DATA_KEY_BLUETOOTH_DEVICE_ID", "", "NAME", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<AppBrandRuntime, ah>
  {
    b(r paramr, b<? super y, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/OnMonitoredBluetoothDeviceFoundEvent$dispatchWhenReady$doDispatch$1", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatContext;", "appInstanceId", "", "getAppInstanceId", "()Ljava/lang/String;", "appSessionId", "getAppSessionId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.r
  {
    private final String rhd;
    private final String rhe;
    
    c(y paramy)
    {
      AppMethodBeat.i(329602);
      paramy = this.rKC;
      if ((paramy instanceof com.tencent.luggage.sdk.b.a.d.d))
      {
        paramy = (com.tencent.luggage.sdk.b.a.d.d)paramy;
        if (paramy != null) {
          break label83;
        }
        paramy = "";
        label38:
        this.rhd = paramy;
        paramy = this.rKC;
        if (!(paramy instanceof com.tencent.luggage.sdk.b.a.d.d)) {
          break label130;
        }
        paramy = (com.tencent.luggage.sdk.b.a.d.d)paramy;
        label60:
        if (paramy != null) {
          break label135;
        }
        paramy = "";
      }
      for (;;)
      {
        this.rhe = paramy;
        AppMethodBeat.o(329602);
        return;
        paramy = null;
        break;
        label83:
        paramy = paramy.aqZ();
        if (paramy == null)
        {
          paramy = "";
          break label38;
        }
        paramy = paramy.asA();
        if (paramy == null)
        {
          paramy = "";
          break label38;
        }
        String str = paramy.eoQ;
        paramy = str;
        if (str != null) {
          break label38;
        }
        paramy = "";
        break label38;
        label130:
        paramy = null;
        break label60;
        label135:
        paramy = paramy.aqZ();
        if (paramy == null)
        {
          paramy = "";
        }
        else
        {
          paramy = paramy.asA();
          if (paramy == null)
          {
            paramy = "";
          }
          else
          {
            str = paramy.eoP;
            paramy = str;
            if (str == null) {
              paramy = "";
            }
          }
        }
      }
    }
    
    public final String cmP()
    {
      return this.rhd;
    }
    
    public final String getAppInstanceId()
    {
      return this.rhe;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(String paramString, b<? super AppBrandRuntime, ah> paramb)
    {
      super();
    }
    
    private static final void b(b paramb, w paramw)
    {
      AppMethodBeat.i(329603);
      kotlin.g.b.s.u(paramb, "$block");
      kotlin.g.b.s.u(paramw, "$this_apply");
      paramb.invoke(paramw);
      AppMethodBeat.o(329603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.r
 * JD-Core Version:    0.7.0.1
 */