package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysBluetoothStateChangeListener$2$1", "Landroid/content/BroadcastReceiver;", "isCurBluetoothOn", "", "()Ljava/lang/Boolean;", "disable", "", "dispatchBluetoothStateChange", "enable", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BluetoothAbility4DeviceDiscovery$sysBluetoothStateChangeListener$2$1
  extends BroadcastReceiver
{
  private static Boolean cmK()
  {
    AppMethodBeat.i(321617);
    Object localObject = c.crs();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((BluetoothAdapter)localObject).getState()))
    {
      localObject = a.rfZ;
      a.w("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "get#isCurBluetoothOn, state is null");
      AppMethodBeat.o(321617);
      return null;
    }
    if (12 == ((Integer)localObject).intValue())
    {
      localObject = Boolean.TRUE;
      AppMethodBeat.o(321617);
      return localObject;
    }
    if (10 == ((Integer)localObject).intValue())
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(321617);
      return localObject;
    }
    a locala = a.rfZ;
    a.w("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", s.X("get#isCurBluetoothOn, state: ", localObject));
    AppMethodBeat.o(321617);
    return null;
  }
  
  static void cmL()
  {
    AppMethodBeat.i(321620);
    Object localObject = cmK();
    if (localObject != null)
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      localObject = e.cmI();
      if (localObject != null) {
        ((k)localObject).onBluetoothStateChange(bool);
      }
    }
    AppMethodBeat.o(321620);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(321625);
    cmL();
    AppMethodBeat.o(321625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.BluetoothAbility4DeviceDiscovery.sysBluetoothStateChangeListener.2.1
 * JD-Core Version:    0.7.0.1
 */