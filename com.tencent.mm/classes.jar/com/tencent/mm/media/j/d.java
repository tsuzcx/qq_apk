package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.opengles.GL10;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "(I)V", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "plugin-mediaeditor_release"})
public abstract class d
  extends a
{
  public d(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 2);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture != null) {
        localSurfaceTexture.updateTexImage();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Media.AbsSurfaceRenderer", (Throwable)localException, "updateTexImage error", new Object[0]);
      }
      super.onDrawFrame(paramGL10);
    }
    if (this.ijr)
    {
      this.ijr = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.d
 * JD-Core Version:    0.7.0.1
 */