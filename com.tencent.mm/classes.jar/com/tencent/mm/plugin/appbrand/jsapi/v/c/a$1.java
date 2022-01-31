package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(117344);
    synchronized (this.iiH.iiG)
    {
      if (this.iiH.iiF == null)
      {
        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
        AppMethodBeat.o(117344);
        return;
      }
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
      this.iiH.iiF.g(this.iiH.mSurfaceTexture);
      AppMethodBeat.o(117344);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.1
 * JD-Core Version:    0.7.0.1
 */