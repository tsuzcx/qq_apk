package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.vending.e.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/LocationListenerLeakFix;", "", "()V", "bind", "Lcom/tencent/mm/plugin/appbrand/utils/lbs/ILocationManager$OnLocationListener;", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "ListenerWrapper", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t sas;
  
  static
  {
    AppMethodBeat.i(329245);
    sas = new t();
    AppMethodBeat.o(329245);
  }
  
  public static final a.b a(g paramg, a.b paramb)
  {
    AppMethodBeat.i(329241);
    s.u(paramg, "env");
    s.u(paramb, "listener");
    paramg = paramg.getRuntime();
    s.s(paramg, "env.runtime");
    paramg = (a.b)new a(paramg, paramb);
    AppMethodBeat.o(329241);
    return paramg;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/LocationListenerLeakFix$ListenerWrapper;", "Lcom/tencent/mm/plugin/appbrand/utils/lbs/ILocationManager$OnLocationListener;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Lcom/tencent/mm/plugin/appbrand/utils/lbs/ILocationManager$OnLocationListener;)V", "dead", "", "onLocationChange", "errCode", "", "errStr", "", "location", "Lcom/tencent/mm/plugin/appbrand/utils/lbs/ILocationManager$Location;", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements a.b, a
  {
    private AppBrandRuntime qzz;
    private a.b sat;
    
    public a(AppBrandRuntime paramAppBrandRuntime, a.b paramb)
    {
      AppMethodBeat.i(329225);
      this.qzz = paramAppBrandRuntime;
      this.sat = paramb;
      paramAppBrandRuntime.keep((a)this);
      AppMethodBeat.o(329225);
    }
    
    public final void a(int paramInt, String paramString, a.a parama)
    {
      AppMethodBeat.i(329228);
      a.b localb = this.sat;
      if (localb != null) {
        localb.a(paramInt, paramString, parama);
      }
      dead();
      AppMethodBeat.o(329228);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(329234);
      this.sat = null;
      AppBrandRuntime localAppBrandRuntime = this.qzz;
      if (localAppBrandRuntime != null) {
        localAppBrandRuntime.a((a)this);
      }
      this.qzz = null;
      AppMethodBeat.o(329234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.t
 * JD-Core Version:    0.7.0.1
 */