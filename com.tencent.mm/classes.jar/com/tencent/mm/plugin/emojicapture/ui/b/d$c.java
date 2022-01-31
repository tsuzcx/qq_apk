package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.a.a;
import a.l;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
final class d$c
  implements SurfaceTexture.OnFrameAvailableListener
{
  d$c(d paramd) {}
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(3158);
    paramSurfaceTexture = this.lAT;
    ab.i(paramSurfaceTexture.TAG, "onVideoSurfaceFrameAvailable");
    paramSurfaceTexture.d((a)new d.d(paramSurfaceTexture));
    AppMethodBeat.o(3158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.d.c
 * JD-Core Version:    0.7.0.1
 */