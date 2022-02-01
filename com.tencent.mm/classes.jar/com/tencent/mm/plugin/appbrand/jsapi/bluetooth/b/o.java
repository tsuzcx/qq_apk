package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o
{
  static final Map<Integer, n> lLS;
  private static h.c lLT;
  private static volatile boolean lLU;
  public static final o lLV;
  
  static
  {
    AppMethodBeat.i(144787);
    lLV = new o();
    lLS = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(144787);
  }
  
  public static boolean bFk()
  {
    AppMethodBeat.i(144783);
    if (lLS.size() + 1 > 10)
    {
      AppMethodBeat.o(144783);
      return true;
    }
    AppMethodBeat.o(144783);
    return false;
  }
  
  public static boolean wP(int paramInt)
  {
    AppMethodBeat.i(144785);
    if (lLU)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    n localn = (n)lLS.get(Integer.valueOf(paramInt));
    if (localn == null)
    {
      AppMethodBeat.o(144785);
      return false;
    }
    localn.onDestroy();
    if (lLS.remove(Integer.valueOf(paramInt)) != null)
    {
      AppMethodBeat.o(144785);
      return true;
    }
    AppMethodBeat.o(144785);
    return false;
  }
  
  public static n wQ(int paramInt)
  {
    AppMethodBeat.i(144786);
    if (lLU)
    {
      AppMethodBeat.o(144786);
      return null;
    }
    n localn = (n)lLS.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(144786);
    return localn;
  }
  
  public final int n(f paramf)
  {
    AppMethodBeat.i(144784);
    p.h(paramf, "component");
    try
    {
      if (lLT == null)
      {
        lLT = (h.c)new a();
        h.a(paramf.getAppId(), lLT);
      }
      boolean bool = lLU;
      if (bool) {
        return -1;
      }
      Object localObject = x.SXb;
      int i;
      do
      {
        i = b.bFA();
      } while (lLS.containsKey(Integer.valueOf(i)));
      localObject = new n();
      ((n)localObject).c(paramf, i);
      lLS.put(Integer.valueOf(i), localObject);
      AppMethodBeat.o(144784);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144784);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
  public static final class a
    extends h.c
  {
    public final void onDestroy()
    {
      AppMethodBeat.i(144782);
      super.onDestroy();
      Log.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
      ??? = o.lLV;
      o.hp(true);
      Object localObject3;
      synchronized (o.lLV)
      {
        localObject3 = o.lLS;
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
        Log.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + ((n)localObject3).ktp);
        ((n)localObject3).onDestroy();
      }
      o.lLS.clear();
      localObject2 = x.SXb;
      ??? = o.lLV;
      o.bFl();
      ??? = o.lLV;
      o.hp(false);
      AppMethodBeat.o(144782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o
 * JD-Core Version:    0.7.0.1
 */