package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.t.b.a.a;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$15
  implements a.b
{
  a$15(a parama) {}
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(138423);
    if (paramInt != 0)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(138423);
      return;
    }
    ab.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(parama.latitude), Double.valueOf(parama.longitude) });
    if (!a.aDH())
    {
      ab.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
      AppMethodBeat.o(138423);
      return;
    }
    if ((!a.l(this.hOM)) || (a.m(this.hOM)))
    {
      AppMethodBeat.o(138423);
      return;
    }
    m.runOnUiThread(new a.15.1(this, parama));
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.15
 * JD-Core Version:    0.7.0.1
 */