package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o
{
  static final Map<Integer, n> oIh;
  private static k.c oIi;
  private static volatile boolean oIj;
  public static final o oIk;
  
  static
  {
    AppMethodBeat.i(144787);
    oIk = new o();
    oIh = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean Ae(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (oIj)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)oIh.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (oIh.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n Af(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (oIj)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)oIh.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public static boolean bQO()
  {
    AppMethodBeat.i(144783);
    if (oIh.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public final int p(e parame)
  {
    AppMethodBeat.i(144784);
    p.k(parame, "component");
    try
    {
      if (oIi == null)
      {
        oIi = (k.c)new a();
        k.a(parame.getAppId(), oIi);
      }
      boolean bool = oIj;
      if (bool) {
        return -1;
      }
      Object localObject = x.aazN;
      int i;
      do
      {
        i = b.bRi();
      } while (oIh.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(parame, i);
      oIh.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a
    extends k.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      Log.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      ??? = o.oIk;
      o.ig(true);
      Object localObject3;
      synchronized (o.oIk)
      {
        localObject3 = o.oIh;
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
        Log.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + ((n)localObject3).nld);
        ((n)localObject3).onDestroy();
      }
      o.oIh.clear();
      localObject2 = x.aazN;
      ??? = o.oIk;
      o.bQP();
      ??? = o.oIk;
      o.ig(false);
      AppMethodBeat.o(144782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */