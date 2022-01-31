package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MSurfaceView$1
  implements Runnable
{
  MSurfaceView$1(MSurfaceView paramMSurfaceView) {}
  
  public final void run()
  {
    AppMethodBeat.i(103782);
    if (MSurfaceView.a(this.hgg))
    {
      AppMethodBeat.o(103782);
      return;
    }
    Canvas localCanvas = MSurfaceView.b(this.hgg).lockCanvas();
    if (localCanvas == null)
    {
      AppMethodBeat.o(103782);
      return;
    }
    localCanvas.drawColor(-1);
    this.hgg.f(localCanvas);
    MSurfaceView.b(this.hgg).unlockCanvasAndPost(localCanvas);
    AppMethodBeat.o(103782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */