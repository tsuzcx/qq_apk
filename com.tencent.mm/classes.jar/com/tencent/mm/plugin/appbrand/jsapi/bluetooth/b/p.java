package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "", "(Ljava/lang/String;I)V", "INIT", "CREATED", "CONNECTED", "DESTROYED", "TROUBLESOME", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum p
{
  static
  {
    AppMethodBeat.i(144788);
    rLU = new p("INIT", 0);
    rLV = new p("CREATED", 1);
    rLW = new p("CONNECTED", 2);
    rLX = new p("DESTROYED", 3);
    rLY = new p("TROUBLESOME", 4);
    rLZ = new p[] { rLU, rLV, rLW, rLX, rLY };
    AppMethodBeat.o(144788);
  }
  
  private p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.p
 * JD-Core Version:    0.7.0.1
 */