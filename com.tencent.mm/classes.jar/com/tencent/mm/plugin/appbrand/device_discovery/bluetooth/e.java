package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.g.b.z;
import kotlin.j;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery;", "", "()V", "TAG", "", "autoConnectWillBeCanceledAfterCallbackDisConnected", "", "getAutoConnectWillBeCanceledAfterCallbackDisConnected$plugin_appbrand_integration_release", "()Z", "bluetoothStateChangeListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IBluetoothStateChangeListener;", "deviceId2GattMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/bluetooth/BluetoothGatt;", "isSupportLE", "sysBluetoothStateChangeListener", "com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysBluetoothStateChangeListener$2$1", "getSysBluetoothStateChangeListener", "()Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysBluetoothStateChangeListener$2$1;", "sysBluetoothStateChangeListener$delegate", "Lkotlin/Lazy;", "sysGattCallback", "com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysGattCallback$2$1", "getSysGattCallback", "()Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysGattCallback$2$1;", "sysGattCallback$delegate", "<set-?>", "trustAutoConnectWillBeCanceledAfterCallbackDisConnected", "getTrustAutoConnectWillBeCanceledAfterCallbackDisConnected", "setTrustAutoConnectWillBeCanceledAfterCallbackDisConnected", "(Z)V", "trustAutoConnectWillBeCanceledAfterCallbackDisConnected$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "autoConnectGatt", "deviceId", "gattConnectListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "disAutoConnect", "setBluetoothStateChangeListener", "", "connectGattCompat", "Landroid/bluetooth/BluetoothDevice;", "context", "Landroid/content/Context;", "autoConnect", "callback", "Landroid/bluetooth/BluetoothGattCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e rgJ;
  private static final g rgK;
  private static final boolean rgL;
  private static volatile k rgM;
  private static final j rgN;
  private static final ConcurrentHashMap<String, BluetoothGatt> rgO;
  private static final j rgP;
  private static final boolean rgQ;
  
  static
  {
    AppMethodBeat.i(321738);
    aYe = new o[] { (o)ai.a((z)new aa(e.class, "trustAutoConnectWillBeCanceledAfterCallbackDisConnected", "getTrustAutoConnectWillBeCanceledAfterCallbackDisConnected()Z", 0)) };
    rgJ = new e();
    rgK = new g(Boolean.FALSE);
    e locale = rgJ;
    boolean bool = ((Boolean)rgK.a(locale, aYe[0])).booleanValue();
    Log.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("autoConnectWillBeCanceledAfterCallbackDisConnected: ", Boolean.valueOf(bool)));
    rgL = bool;
    rgN = kotlin.k.cm((kotlin.g.a.a)e.b.rgS);
    rgO = new ConcurrentHashMap();
    rgP = kotlin.k.cm((kotlin.g.a.a)e.c.rgT);
    rgQ = c.crt();
    AppMethodBeat.o(321738);
  }
  
  public static boolean YF(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(321692);
    s.u(paramString, "deviceId");
    Object localObject1 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("disAutoConnect, deviceId: ", paramString));
    localObject1 = (BluetoothGatt)rgO.remove(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(321692);
      return false;
    }
    Object localObject2 = cmG();
    s.u(paramString, "deviceId");
    if (((e.c.1)localObject2).rgU.remove(paramString) != null) {
      bool = true;
    }
    localObject2 = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "unBind, deviceId: " + paramString + ", originBond: " + bool);
    a((BluetoothGatt)localObject1);
    AppMethodBeat.o(321692);
    return true;
  }
  
  private static void a(BluetoothGatt paramBluetoothGatt)
  {
    AppMethodBeat.i(321699);
    f.bt((kotlin.g.a.a)new a(paramBluetoothGatt));
    AppMethodBeat.o(321699);
  }
  
  public static void a(k paramk)
  {
    AppMethodBeat.i(321659);
    rgM = paramk;
    if (paramk != null)
    {
      paramk = cmF();
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "enable#sysBluetoothStateChangeListener");
      BluetoothAbility4DeviceDiscovery.sysBluetoothStateChangeListener.2.1.cmL();
      localObject = MMApplicationContext.getContext();
      if (localObject != null) {
        ((Context)localObject).registerReceiver((BroadcastReceiver)paramk, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
      }
      AppMethodBeat.o(321659);
      return;
    }
    paramk = cmF();
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "disable#sysBluetoothStateChangeListener");
    try
    {
      localObject = MMApplicationContext.getContext();
      if (localObject != null)
      {
        ((Context)localObject).unregisterReceiver((BroadcastReceiver)paramk);
        AppMethodBeat.o(321659);
        return;
      }
    }
    catch (Exception paramk)
    {
      localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("disable#sysBluetoothStateChangeListener, unregister fail since ", paramk));
      AppMethodBeat.o(321659);
    }
  }
  
  public static boolean b(String paramString, l paraml)
  {
    AppMethodBeat.i(321680);
    s.u(paramString, "deviceId");
    s.u(paraml, "gattConnectListener");
    Object localObject = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
    com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("autoConnectGatt, deviceId: ", paramString));
    localObject = c.crs();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((BluetoothAdapter)localObject).getRemoteDevice(paramString))
    {
      paramString = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
      com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "autoConnectGatt, bluetoothDevice is null");
      AppMethodBeat.o(321680);
      return false;
    }
    for (;;)
    {
      try
      {
        localContext = MMApplicationContext.getContext();
        e.c.1 local1 = cmG();
        s.u(paramString, "deviceId");
        s.u(paraml, "gattConnectListener");
        com.tencent.mm.plugin.appbrand.device_discovery.a locala = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("bindOnce, deviceId: ", paramString));
        ((Map)local1.rgU).put(paramString, paraml);
        paraml = (BluetoothGattCallback)local1;
        if (Build.VERSION.SDK_INT < 23) {
          continue;
        }
        paraml = ((BluetoothDevice)localObject).connectGatt(localContext, true, paraml, 2);
        if (paraml == null) {
          continue;
        }
        ((Map)rgO).put(paramString, paraml);
        bool = true;
      }
      catch (Exception paramString)
      {
        Context localContext;
        paraml = com.tencent.mm.plugin.appbrand.device_discovery.a.rfZ;
        com.tencent.mm.plugin.appbrand.device_discovery.a.w("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("autoConnectGatt, connectGattCompat fail since ", paramString));
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(321680);
      return bool;
      paraml = ((BluetoothDevice)localObject).connectGatt(localContext, true, paraml);
      continue;
      bool = false;
    }
  }
  
  public static boolean cmE()
  {
    return rgL;
  }
  
  private static BluetoothAbility4DeviceDiscovery.sysBluetoothStateChangeListener.2.1 cmF()
  {
    AppMethodBeat.i(321624);
    BluetoothAbility4DeviceDiscovery.sysBluetoothStateChangeListener.2.1 local1 = (BluetoothAbility4DeviceDiscovery.sysBluetoothStateChangeListener.2.1)rgN.getValue();
    AppMethodBeat.o(321624);
    return local1;
  }
  
  private static e.c.1 cmG()
  {
    AppMethodBeat.i(321632);
    e.c.1 local1 = (e.c.1)rgP.getValue();
    AppMethodBeat.o(321632);
    return local1;
  }
  
  public static boolean cmH()
  {
    return rgQ;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(BluetoothGatt paramBluetoothGatt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.e
 * JD-Core Version:    0.7.0.1
 */