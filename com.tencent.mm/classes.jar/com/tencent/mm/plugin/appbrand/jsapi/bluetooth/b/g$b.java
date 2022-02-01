package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;", "", "uuid", "", "major", "", "minor", "measuredPower", "([BIII)V", "getMajor", "()I", "getMeasuredPower", "getMinor", "getUuid", "()[B", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b
{
  public static final a rLy;
  final int rLA;
  final byte[] rLz;
  final int rid;
  final int rie;
  
  static
  {
    AppMethodBeat.i(329637);
    rLy = new a((byte)0);
    AppMethodBeat.o(329637);
  }
  
  public g$b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(329633);
    this.rLz = paramArrayOfByte;
    this.rid = paramInt1;
    this.rie = paramInt2;
    this.rLA = paramInt3;
    AppMethodBeat.o(329633);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon$Companion;", "", "()V", "fromJson", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Beacon;", "json", "Lorg/json/JSONObject;", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g.b
 * JD-Core Version:    0.7.0.1
 */