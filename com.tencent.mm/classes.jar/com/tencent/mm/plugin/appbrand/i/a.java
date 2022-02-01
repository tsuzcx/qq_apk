package com.tencent.mm.plugin.appbrand.i;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.12;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin.PluginLoadResult;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  extends SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
{
  private static a kmC;
  private Map<Integer, c> kmD;
  
  private a()
  {
    AppMethodBeat.i(139394);
    this.kmD = new ConcurrentHashMap();
    AppMethodBeat.o(139394);
  }
  
  public static a bhg()
  {
    AppMethodBeat.i(139395);
    if (kmC == null) {}
    try
    {
      if (kmC == null) {
        kmC = new a();
      }
      a locala = kmC;
      AppMethodBeat.o(139395);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(139395);
    }
  }
  
  public final void a(int paramInt1, c paramc, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(177195);
    if ((paramSurfaceTexture != null) && ((paramInt2 != 0) || (paramInt3 != 0)))
    {
      ae.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "registerMediaPlayer, id:%s, width:%s, height:%s, surface:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramSurfaceTexture.hashCode()) });
      this.kmD.put(Integer.valueOf(paramInt1), paramc);
      registerInstance(paramInt1, paramString, paramInt2, paramInt3, paramSurfaceTexture);
    }
    AppMethodBeat.o(177195);
  }
  
  public void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString)
  {
    AppMethodBeat.i(177198);
    ae.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceDestroy, id:%s appTag:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.onPluginInstanceDestroy(paramISkiaCanvasExternalTextureHandler, paramInt, paramString);
    AppMethodBeat.o(177198);
  }
  
  public SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(177197);
    ae.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceLoad, type:%s, id:%s appTag:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramISkiaCanvasExternalTextureHandler = super.onPluginInstanceLoad(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    AppMethodBeat.o(177197);
    return paramISkiaCanvasExternalTextureHandler;
  }
  
  public void replaceDisplaySurface(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(177196);
    paramString = (c)this.kmD.get(Integer.valueOf(paramInt));
    if ((paramString != null) && (paramSurfaceTexture != null))
    {
      ae.w("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, surface:%s", new Object[] { Integer.valueOf(paramSurfaceTexture.hashCode()) });
      paramString.k(new c.12(paramString, paramSurfaceTexture));
      AppMethodBeat.o(177196);
      return;
    }
    ae.w("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, video plugin handler or surface texture is null");
    AppMethodBeat.o(177196);
  }
  
  public boolean supportType(String paramString)
  {
    AppMethodBeat.i(139398);
    if (paramString.equals("video"))
    {
      AppMethodBeat.o(139398);
      return true;
    }
    AppMethodBeat.o(139398);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.a
 * JD-Core Version:    0.7.0.1
 */