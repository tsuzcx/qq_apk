package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.l;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$SurfaceAvailableListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "request", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;)V", "getRequest", "()Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-appbrand-integration_release"})
final class g$c
  implements TextureView.SurfaceTextureListener
{
  private final g.b hJM;
  
  public g$c(g.b paramb)
  {
    AppMethodBeat.i(134666);
    this.hJM = paramb;
    AppMethodBeat.o(134666);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134665);
    paramSurfaceTexture = this.hJM;
    paramSurfaceTexture.hJJ = true;
    if (paramSurfaceTexture.hJK != null) {
      paramSurfaceTexture.ate();
    }
    AppMethodBeat.o(134665);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g.c
 * JD-Core Version:    0.7.0.1
 */