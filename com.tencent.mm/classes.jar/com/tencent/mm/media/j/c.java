package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "scaleType", "(II)V", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends a
{
  public c(int paramInt1, int paramInt2)
  {
    super(0, 0, 0, 0, paramInt1, paramInt2);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      Object localObject = com.tencent.mm.media.j.c.a.nFo;
      com.tencent.mm.media.j.c.a.gt(true);
      localObject = getSurfaceTexture();
      if (localObject != null) {
        ((SurfaceTexture)localObject).updateTexImage();
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
    if (this.nDp)
    {
      this.nDp = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.c
 * JD-Core Version:    0.7.0.1
 */