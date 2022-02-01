package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c$12
  implements Runnable
{
  public c$12(c paramc, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(138958);
    c localc = this.cJF;
    SurfaceTexture localSurfaceTexture = this.val$surfaceTexture;
    localc.mSurfaceTexture = localSurfaceTexture;
    localc.mSurface = new Surface(localSurfaceTexture);
    if (localc.cIV != null)
    {
      Log.i(localc.getLogTag(), "replaceSurfaceTextureInternal, setSurface:%s", new Object[] { localSurfaceTexture });
      localc.cIV.setSurface(localc.mSurface);
    }
    AppMethodBeat.o(138958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.12
 * JD-Core Version:    0.7.0.1
 */