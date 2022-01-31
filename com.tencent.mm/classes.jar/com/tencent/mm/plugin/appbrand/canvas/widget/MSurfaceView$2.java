package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MSurfaceView$2
  implements Runnable
{
  MSurfaceView$2(MSurfaceView paramMSurfaceView) {}
  
  public final void run()
  {
    AppMethodBeat.i(103783);
    if (MSurfaceView.a(this.hgg))
    {
      AppMethodBeat.o(103783);
      return;
    }
    Canvas localCanvas = MSurfaceView.b(this.hgg).lockCanvas();
    if (localCanvas == null)
    {
      AppMethodBeat.o(103783);
      return;
    }
    localCanvas.drawColor(-1);
    this.hgg.f(localCanvas);
    MSurfaceView.b(this.hgg).unlockCanvasAndPost(localCanvas);
    AppMethodBeat.o(103783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */