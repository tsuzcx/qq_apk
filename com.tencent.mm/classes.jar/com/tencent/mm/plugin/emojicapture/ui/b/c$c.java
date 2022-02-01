package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
final class c$c
  implements SurfaceTexture.OnFrameAvailableListener
{
  c$c(c paramc) {}
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(840);
    paramSurfaceTexture = this.pYC;
    ad.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
    paramSurfaceTexture.i((a)new c.d(paramSurfaceTexture));
    AppMethodBeat.o(840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.c.c
 * JD-Core Version:    0.7.0.1
 */