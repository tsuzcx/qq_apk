package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.skia_canvas.demo.SkiaCanvasView;

final class a$1
  implements Runnable
{
  a$1(a parama, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(154430);
    if (a.a(this.iif) != null)
    {
      a.a(this.iif).swapSurface(this.iie);
      if (a.b(this.iif) == null)
      {
        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
        AppMethodBeat.o(154430);
        return;
      }
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d %d %d", new Object[] { Integer.valueOf(a.c(this.iif)), Integer.valueOf(a.d(this.iif)), Integer.valueOf(a.e(this.iif)) });
      c.d(a.b(this.iif), a.c(this.iif));
      a.f(this.iif).setDefaultBufferSize(a.d(this.iif), a.e(this.iif));
      AppMethodBeat.o(154430);
      return;
    }
    ab.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
    AppMethodBeat.o(154430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a.1
 * JD-Core Version:    0.7.0.1
 */