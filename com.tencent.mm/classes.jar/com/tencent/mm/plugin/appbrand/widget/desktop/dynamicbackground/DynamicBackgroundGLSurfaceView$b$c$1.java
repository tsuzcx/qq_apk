package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class DynamicBackgroundGLSurfaceView$b$c$1
  implements Runnable
{
  DynamicBackgroundGLSurfaceView$b$c$1(DynamicBackgroundGLSurfaceView.b.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(135227);
    GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.jgO.jgM);
    if (localGameGLSurfaceView != null) {
      localGameGLSurfaceView.onPause();
    }
    localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.jgO.jgM);
    if (localGameGLSurfaceView != null)
    {
      localGameGLSurfaceView.setVisibility(4);
      AppMethodBeat.o(135227);
      return;
    }
    AppMethodBeat.o(135227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.c.1
 * JD-Core Version:    0.7.0.1
 */