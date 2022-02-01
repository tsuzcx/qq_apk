package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "appStateListener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "authStateListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothAuthorizeStateListener;", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static j rKJ;
  public static final o rLP;
  private static final Map<Integer, n> rLQ;
  private static k.c rLR;
  private static volatile boolean rLS;
  
  static
  {
    AppMethodBeat.i(144787);
    rLP = new o();
    rLQ = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean Av(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (rLS)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)rLQ.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (rLQ.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n Aw(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (rLS)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)rLQ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public static boolean cqV()
  {
    AppMethodBeat.i(144783);
    if (rLQ.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(329670);
    Object localObject3;
    try
    {
      localObject3 = rLQ;
      Collection localCollection = (Collection)new ArrayList(((Map)localObject3).size());
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((n)((Map.Entry)((Iterator)localObject3).next()).getValue());
      }
      localObject2 = ((Iterable)localObject1).iterator();
    }
    finally
    {
      AppMethodBeat.o(329670);
    }
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (n)((Iterator)localObject2).next();
      Log.i("MicroMsg.BLE.PeripheralBleServerManager", s.X("destroy server #", Integer.valueOf(((n)localObject3).qim)));
      ((n)localObject3).onDestroy();
    }
    rLQ.clear();
    Object localObject2 = ah.aiuX;
    AppMethodBeat.o(329670);
  }
  
  public final int r(f paramf)
  {
    AppMethodBeat.i(144784);
    s.u(paramf, "component");
    try
    {
      if (rLR == null)
      {
        rLR = (k.c)new a();
        k.a(paramf.getAppId(), rLR);
      }
      if (rKJ == null)
      {
        rKJ = (j)new b(paramf);
        localObject = d.rKi;
        d.a(paramf.getAppId(), rKJ);
      }
      boolean bool = rLS;
      if (bool) {
        return -1;
      }
      Object localObject = ah.aiuX;
      int i;
      do
      {
        i = b.crq();
      } while (rLQ.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(paramf, i);
      rLQ.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends k.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      Log.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      o localo = o.rLP;
      o.jf(true);
      o.rLP.clear();
      localo = o.rLP;
      o.cqW();
      localo = o.rLP;
      o.jf(false);
      AppMethodBeat.o(144782);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothAuthorizeStateListener;", "onAuthorizeStateChange", "", "newState", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothAuthorizeState;", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(f paramf) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(329657);
      s.u(paramc, "newState");
      Log.i("MicroMsg.BLE.PeripheralBleServerManager", s.X("onAuthorizeStateChange, newState: ", paramc));
      if (c.rKe == paramc)
      {
        paramc = d.rKi;
        d.b(this.rLT.getAppId(), (j)this);
        paramc = o.rLP;
        o.jf(true);
        o.rLP.clear();
        paramc = o.rLP;
        o.cqX();
        paramc = o.rLP;
        o.jf(false);
      }
      AppMethodBeat.o(329657);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */