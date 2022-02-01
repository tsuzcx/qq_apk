package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothAuthorizeState;", "", "(Ljava/lang/String;I)V", "REJECTED", "ACCEPTED_IN_FOREGROUND", "ALWAYS_ACCEPTED", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  static
  {
    AppMethodBeat.i(329530);
    rKe = new c("REJECTED", 0);
    rKf = new c("ACCEPTED_IN_FOREGROUND", 1);
    rKg = new c("ALWAYS_ACCEPTED", 2);
    rKh = new c[] { rKe, rKf, rKg };
    AppMethodBeat.o(329530);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c
 * JD-Core Version:    0.7.0.1
 */