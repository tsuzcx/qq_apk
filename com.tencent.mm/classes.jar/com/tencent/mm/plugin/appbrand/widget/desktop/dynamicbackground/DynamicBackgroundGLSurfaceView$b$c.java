package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class DynamicBackgroundGLSurfaceView$b$c
  implements Runnable
{
  DynamicBackgroundGLSurfaceView$b$c(DynamicBackgroundGLSurfaceView.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135228);
    Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.jgM);
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setVisibility(0);
    }
    localObject = DynamicBackgroundGLSurfaceView.b.a(this.jgM);
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
    }
    ab.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView");
    localObject = DynamicBackgroundGLSurfaceView.b.b(this.jgM);
    if (localObject != null)
    {
      ((GameGLSurfaceView)localObject).postDelayed((Runnable)new DynamicBackgroundGLSurfaceView.b.c.1(this), 50L);
      AppMethodBeat.o(135228);
      return;
    }
    AppMethodBeat.o(135228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.c
 * JD-Core Version:    0.7.0.1
 */