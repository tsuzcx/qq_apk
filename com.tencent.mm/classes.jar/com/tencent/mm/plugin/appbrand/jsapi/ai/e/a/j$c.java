package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a.a;
import com.tencent.mm.plugin.appbrand.g.b.b;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
public final class j$c
  implements a.a
{
  public final void a(c paramc)
  {
    Object localObject3 = null;
    int j = 0;
    AppMethodBeat.i(139788);
    p.k(paramc, "device");
    label468:
    for (;;)
    {
      Object localObject4;
      b localb;
      Object localObject2;
      try
      {
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: ".concat(String.valueOf(paramc)));
        p.k(paramc, "$this$isRecentDevice");
        localObject4 = MultiProcessMMKV.getSingleDefault();
        Object localObject1 = paramc.bMJ();
        if (localObject1 != null)
        {
          localObject1 = ((b)localObject1).oeD;
          if (((MultiProcessMMKV)localObject4).getLong((String)localObject1, 0L) == 0L) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localObject1 = (Iterable)this.pNU.pNN;
          if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
            continue;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject4 = ((e)((Iterator)localObject1).next()).pMy.bMJ();
          if (localObject4 == null) {
            p.iCn();
          }
          localObject4 = ((b)localObject4).oeD;
          localb = paramc.bMJ();
          if (localb == null) {
            p.iCn();
          }
          if (!p.h(localObject4, localb.oeD)) {
            continue;
          }
          i = j;
          if (i != 0) {
            this.pNU.pNN.add(new e(paramc));
          }
          localObject1 = this.pNU.pNO;
          if (localObject1 != null) {
            ((a)localObject1).invoke();
          }
          localObject1 = new StringBuilder("onAddDevice: ");
          localObject4 = paramc.bMJ();
          paramc = localObject3;
          if (localObject4 != null) {
            paramc = ((b)localObject4).oeA;
          }
          Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
          AppMethodBeat.o(139788);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
        continue;
        localObject2 = null;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        localObject2 = (Iterable)this.pNU.pNM;
        if (!(localObject2 instanceof Collection)) {
          break label358;
        }
      }
      if (!((Collection)localObject2).isEmpty())
      {
        label358:
        localObject2 = ((Iterable)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject4 = ((e)((Iterator)localObject2).next()).pMy.bMJ();
          if (localObject4 == null) {
            p.iCn();
          }
          localObject4 = ((b)localObject4).oeD;
          localb = paramc.bMJ();
          if (localb == null) {
            p.iCn();
          }
        } while (!p.h(localObject4, localb.oeD));
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label468;
        }
        this.pNU.pNM.add(new e(paramc));
        break;
      }
    }
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(139789);
    p.k(paramc, "device");
    this.pNU.pNM.remove(new e(paramc));
    this.pNU.pNN.remove(new e(paramc));
    Object localObject = this.pNU.pNO;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = new StringBuilder("onRemoveDevice: ");
    paramc = paramc.bMJ();
    if (paramc != null) {}
    for (paramc = paramc.oeA;; paramc = null)
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", paramc);
      AppMethodBeat.o(139789);
      return;
    }
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(139790);
    p.k(paramc, "device");
    try
    {
      Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(139790);
      return;
    }
    catch (Exception paramc)
    {
      Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", new Object[] { paramc });
      AppMethodBeat.o(139790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.j.c
 * JD-Core Version:    0.7.0.1
 */