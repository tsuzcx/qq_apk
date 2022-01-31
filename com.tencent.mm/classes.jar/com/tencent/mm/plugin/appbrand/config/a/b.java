package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Timer;

final class b
{
  int hkN = 0;
  b.a hkO = null;
  Timer hkP = null;
  
  final void a(b.a parama)
  {
    AppMethodBeat.i(86934);
    al.d(new b.1(this, parama));
    AppMethodBeat.o(86934);
  }
  
  final void ayO()
  {
    AppMethodBeat.i(141653);
    ab.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    al.d(new b.2(this));
    AppMethodBeat.o(141653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */