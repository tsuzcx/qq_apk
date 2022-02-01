package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "(Landroid/bluetooth/BluetoothDevice;II)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getRequestId", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  final int offset;
  final BluetoothDevice rLH;
  final int requestId;
  
  public m(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144772);
    this.rLH = paramBluetoothDevice;
    this.requestId = paramInt1;
    this.offset = paramInt2;
    AppMethodBeat.o(144772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.m
 * JD-Core Version:    0.7.0.1
 */