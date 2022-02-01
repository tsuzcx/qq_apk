package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "", "(Ljava/lang/String;I)V", "INIT", "CREATED", "CONNECTED", "DESTROYED", "TROUBLESOME", "luggage-commons-jsapi-connectivity-ext_release"})
public enum p
{
  static
  {
    AppMethodBeat.i(144788);
    p localp1 = new p("INIT", 0);
    kHv = localp1;
    p localp2 = new p("CREATED", 1);
    kHw = localp2;
    p localp3 = new p("CONNECTED", 2);
    kHx = localp3;
    p localp4 = new p("DESTROYED", 3);
    kHy = localp4;
    p localp5 = new p("TROUBLESOME", 4);
    kHz = localp5;
    kHA = new p[] { localp1, localp2, localp3, localp4, localp5 };
    AppMethodBeat.o(144788);
  }
  
  private p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.p
 * JD-Core Version:    0.7.0.1
 */