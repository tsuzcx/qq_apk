package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o
{
  static final Map<Integer, n> kEc;
  private static g.c kEd;
  private static volatile boolean kEe;
  public static final o kEf;
  
  static
  {
    AppMethodBeat.i(144787);
    kEf = new o();
    kEc = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean bjl()
  {
    AppMethodBeat.i(144783);
    if (kEc.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public static boolean sQ(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (kEe)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)kEc.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (kEc.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n sR(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (kEe)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)kEc.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public final int n(c paramc)
  {
    AppMethodBeat.i(144784);
    p.h(paramc, "component");
    try
    {
      if (kEd == null)
      {
        kEd = (g.c)new a();
        g.a(paramc.getAppId(), kEd);
      }
      boolean bool = kEe;
      if (bool) {
        return -1;
      }
      Object localObject = z.MKo;
      int i;
      do
      {
        i = b.bjv();
      } while (kEc.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(paramc, i);
      kEc.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a
    extends g.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      ad.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      ??? = o.kEf;
      o.gt(true);
      Object localObject3;
      synchronized (o.kEf)
      {
        localObject3 = o.kEc;
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
        ad.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + ((n)localObject3).jsi);
        ((n)localObject3).onDestroy();
      }
      o.kEc.clear();
      localObject2 = z.MKo;
      ??? = o.kEf;
      o.bjm();
      ??? = o.kEf;
      o.gt(false);
      AppMethodBeat.o(144782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */