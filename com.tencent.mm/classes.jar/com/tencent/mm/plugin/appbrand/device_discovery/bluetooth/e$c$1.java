package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothAbility4DeviceDiscovery$sysGattCallback$2$1", "Landroid/bluetooth/BluetoothGattCallback;", "deviceId2ListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "bindOnce", "deviceId", "gattConnectListener", "onConnectionStateChange", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "status", "", "newState", "unBind", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$c$1
  extends BluetoothGattCallback
{
  final ConcurrentHashMap<String, l> rgU;
  
  e$c$1()
  {
    AppMethodBeat.i(321671);
    this.rgU = new ConcurrentHashMap();
    AppMethodBeat.o(321671);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(321687);
    if (paramBluetoothGatt == null) {
      paramBluetoothGatt = null;
    }
    Object localObject;
    for (;;)
    {
      localObject = a.rfZ;
      a.i("MicroMsg.AppBrand.BluetoothAbility4DeviceDiscovery", "onConnectionStateChange, gatt(" + paramBluetoothGatt + "), status: " + paramInt1 + ", newState: " + paramInt2);
      if (paramBluetoothGatt != null) {
        break;
      }
      AppMethodBeat.o(321687);
      return;
      paramBluetoothGatt = paramBluetoothGatt.getDevice();
      if (paramBluetoothGatt == null) {
        paramBluetoothGatt = null;
      } else {
        paramBluetoothGatt = paramBluetoothGatt.getAddress();
      }
    }
    if (2 == paramInt2) {
      localObject = Boolean.TRUE;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(321687);
      return;
      if (paramInt2 == 0) {
        localObject = Boolean.FALSE;
      } else {
        localObject = null;
      }
    }
    ((Boolean)localObject).booleanValue();
    if (paramInt1 == 0) {}
    l locall;
    for (paramInt1 = 1; (((Boolean)localObject).booleanValue()) && (paramInt1 != 0); paramInt1 = 0)
    {
      locall = (l)this.rgU.get(paramBluetoothGatt);
      if (locall == null) {
        break label353;
      }
      locall.onConnectStateChange(paramBluetoothGatt, ((Boolean)localObject).booleanValue());
      AppMethodBeat.o(321687);
      return;
    }
    if ((!((Boolean)localObject).booleanValue()) && (paramInt1 == 0))
    {
      locall = (l)this.rgU.get(paramBluetoothGatt);
      if (locall != null) {
        locall.onConnectStateChange(paramBluetoothGatt, ((Boolean)localObject).booleanValue());
      }
      localObject = e.rgJ;
      if (e.cmE())
      {
        this.rgU.remove(paramBluetoothGatt);
        paramBluetoothGatt = (BluetoothGatt)e.cmJ().remove(paramBluetoothGatt);
        if (paramBluetoothGatt != null)
        {
          localObject = e.rgJ;
          e.b(paramBluetoothGatt);
          AppMethodBeat.o(321687);
        }
      }
    }
    else if (((((Boolean)localObject).booleanValue()) && (paramInt1 == 0)) || ((!((Boolean)localObject).booleanValue()) && (paramInt1 != 0)))
    {
      localObject = e.rgJ;
      if (e.cmE())
      {
        this.rgU.remove(paramBluetoothGatt);
        paramBluetoothGatt = (BluetoothGatt)e.cmJ().remove(paramBluetoothGatt);
        if (paramBluetoothGatt != null)
        {
          localObject = e.rgJ;
          e.b(paramBluetoothGatt);
        }
      }
    }
    label353:
    AppMethodBeat.o(321687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.e.c.1
 * JD-Core Version:    0.7.0.1
 */