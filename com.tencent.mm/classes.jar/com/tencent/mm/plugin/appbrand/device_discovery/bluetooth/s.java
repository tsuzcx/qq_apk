package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/StatEvent;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "SET_MONITORED_BLUETOOTH_DEVICE", "DELETE_MONITORED_BLUETOOTH_DEVICE", "MONITORED_BLUETOOTH_DEVICE_FOUND", "START_WE_APP", "START_WE_APP_SUCCESS", "START_WE_APP_FAILURE", "DISPATCH_ON_MONITORED_BLUETOOTH_DEVICE_FOUND", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum s
{
  final int rht;
  
  static
  {
    AppMethodBeat.i(321647);
    rhu = new s("SET_MONITORED_BLUETOOTH_DEVICE", 0, 1);
    rhv = new s("DELETE_MONITORED_BLUETOOTH_DEVICE", 1, 2);
    rhw = new s("MONITORED_BLUETOOTH_DEVICE_FOUND", 2, 3);
    rhx = new s("START_WE_APP", 3, 4);
    rhy = new s("START_WE_APP_SUCCESS", 4, 5);
    rhz = new s("START_WE_APP_FAILURE", 5, 6);
    rhA = new s("DISPATCH_ON_MONITORED_BLUETOOTH_DEVICE_FOUND", 6, 7);
    rhB = new s[] { rhu, rhv, rhw, rhx, rhy, rhz, rhA };
    AppMethodBeat.o(321647);
  }
  
  private s(int paramInt)
  {
    this.rht = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.s
 * JD-Core Version:    0.7.0.1
 */