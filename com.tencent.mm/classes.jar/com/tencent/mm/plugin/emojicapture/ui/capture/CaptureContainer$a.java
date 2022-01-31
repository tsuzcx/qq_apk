package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.d.b.g;
import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.y;

final class CaptureContainer$a
  implements b
{
  CaptureContainer$a(CaptureContainer paramCaptureContainer) {}
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    y.i(CaptureContainer.a(this.jpm), "camera data view available: " + paramSurfaceTexture);
    a.a locala = this.jpm.getPresenter();
    g.j(paramSurfaceTexture, "surface");
    locala.f(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.a
 * JD-Core Version:    0.7.0.1
 */