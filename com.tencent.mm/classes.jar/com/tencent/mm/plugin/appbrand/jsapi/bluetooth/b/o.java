package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o
{
  static final Map<Integer, n> kje;
  private static g.c kjf;
  private static volatile boolean kjg;
  public static final o kjh;
  
  static
  {
    AppMethodBeat.i(144787);
    kjh = new o();
    kje = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean bfH()
  {
    AppMethodBeat.i(144783);
    if (kje.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public static boolean so(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (kjg)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)kje.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (kje.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n sp(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (kjg)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)kje.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public final int n(c paramc)
  {
    AppMethodBeat.i(144784);
    k.h(paramc, "component");
    try
    {
      if (kjf == null)
      {
        kjf = (g.c)new a();
        g.a(paramc.getAppId(), kjf);
      }
      boolean bool = kjg;
      if (bool) {
        return -1;
      }
      Object localObject = y.KTp;
      int i;
      do
      {
        i = b.bfR();
      } while (kje.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(paramc, i);
      kje.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a
    extends g.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      ac.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      ??? = o.kjh;
      o.gn(true);
      Object localObject3;
      synchronized (o.kjh)
      {
        localObject3 = o.kje;
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
        ac.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + ((n)localObject3).iYZ);
        ((n)localObject3).onDestroy();
      }
      o.kje.clear();
      localObject2 = y.KTp;
      ??? = o.kjh;
      o.bfI();
      ??? = o.kjh;
      o.gn(false);
      AppMethodBeat.o(144782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */