package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(138414);
    if ((a.c(this.hOM) != null) && (a.l(this.hOM)))
    {
      double d1 = a.c(this.hOM).getLatitude();
      double d2 = a.c(this.hOM).getLongitude();
      this.hOM.hOi.getIController().animateTo(d1, d2);
      ab.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
    }
    AppMethodBeat.o(138414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.3
 * JD-Core Version:    0.7.0.1
 */