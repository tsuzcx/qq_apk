package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.a.a;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$c
  implements SurfaceTexture.OnFrameAvailableListener
{
  c$c(c paramc) {}
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.jrg;
    y.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
    paramSurfaceTexture.c((a)new c.d(paramSurfaceTexture));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.c.c
 * JD-Core Version:    0.7.0.1
 */