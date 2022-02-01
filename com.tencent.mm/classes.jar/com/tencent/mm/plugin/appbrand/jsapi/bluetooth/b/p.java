package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "", "(Ljava/lang/String;I)V", "INIT", "CREATED", "CONNECTED", "DESTROYED", "TROUBLESOME", "luggage-commons-jsapi-connectivity-ext_release"})
public enum p
{
  static
  {
    AppMethodBeat.i(144788);
    p localp1 = new p("INIT", 0);
    oIl = localp1;
    p localp2 = new p("CREATED", 1);
    oIm = localp2;
    p localp3 = new p("CONNECTED", 2);
    oIn = localp3;
    p localp4 = new p("DESTROYED", 3);
    oIo = localp4;
    p localp5 = new p("TROUBLESOME", 4);
    oIp = localp5;
    oIq = new p[] { localp1, localp2, localp3, localp4, localp5 };
    AppMethodBeat.o(144788);
  }
  
  private p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.p
 * JD-Core Version:    0.7.0.1
 */