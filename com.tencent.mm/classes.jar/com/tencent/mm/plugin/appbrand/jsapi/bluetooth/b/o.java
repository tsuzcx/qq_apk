package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o
{
  static final Map<Integer, n> kHr;
  private static h.c kHs;
  private static volatile boolean kHt;
  public static final o kHu;
  
  static
  {
    AppMethodBeat.i(144787);
    kHu = new o();
    kHr = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean bjU()
  {
    AppMethodBeat.i(144783);
    if (kHr.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public static boolean sT(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (kHt)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)kHr.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (kHr.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n sU(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (kHt)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)kHr.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public final int n(c paramc)
  {
    AppMethodBeat.i(144784);
    p.h(paramc, "component");
    try
    {
      if (kHs == null)
      {
        kHs = (h.c)new a();
        h.a(paramc.getAppId(), kHs);
      }
      boolean bool = kHt;
      if (bool) {
        return -1;
      }
      Object localObject = z.Nhr;
      int i;
      do
      {
        i = b.bke();
      } while (kHr.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(paramc, i);
      kHr.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a
    extends h.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      ae.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      ??? = o.kHu;
      o.gr(true);
      Object localObject3;
      synchronized (o.kHu)
      {
        localObject3 = o.kHr;
        Collection localCollection = (Collection)new ArrayList(((Map)localObject3).size());
        localObject3 = ((Map)localObject3).entrySet().iterator();
        if (((Iterator)localObject3).hasNext()) {
          localCollection.add((n)((Map.Entry)((Iterator)localObject3).next()).getValue());
        }
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (n)((Iterator)localObject2).next();
        ae.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + ((n)localObject3).jvb);
        ((n)localObject3).onDestroy();
      }
      o.kHr.clear();
      localObject2 = z.Nhr;
      ??? = o.kHu;
      o.bjV();
      ??? = o.kHu;
      o.gr(false);
      AppMethodBeat.o(144782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */