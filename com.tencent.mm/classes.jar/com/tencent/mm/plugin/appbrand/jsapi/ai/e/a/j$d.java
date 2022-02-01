package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
public final class j$d
  implements a.a
{
  public final void a(c paramc)
  {
    AppMethodBeat.i(139791);
    if (paramc != null)
    {
      localObject1 = paramc.bMJ();
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject1).oeD;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label32;
        }
      }
    }
    Object localObject1 = "";
    label32:
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(localObject1)));
    if ((paramc == null) || (n.ba((CharSequence)localObject1)))
    {
      paramc = this.pNU.pNQ;
      if (paramc != null)
      {
        paramc.invoke(Boolean.FALSE);
        AppMethodBeat.o(139791);
        return;
      }
      AppMethodBeat.o(139791);
      return;
    }
    Object localObject2 = this.pNU.bYJ().bMJ();
    if (localObject2 != null) {}
    for (localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;; localObject2 = null)
    {
      if (p.h(localObject1, localObject2))
      {
        localObject1 = this.pNU.pNQ;
        if (localObject1 != null) {
          ((kotlin.g.a.b)localObject1).invoke(Boolean.TRUE);
        }
        this.pNU.g(paramc);
      }
      AppMethodBeat.o(139791);
      return;
    }
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(161190);
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
    AppMethodBeat.o(161190);
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(161191);
    Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
    AppMethodBeat.o(161191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.j.d
 * JD-Core Version:    0.7.0.1
 */