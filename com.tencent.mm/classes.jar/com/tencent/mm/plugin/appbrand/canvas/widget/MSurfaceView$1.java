package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

final class MSurfaceView$1
  implements Runnable
{
  MSurfaceView$1(MSurfaceView paramMSurfaceView) {}
  
  public final void run()
  {
    if (MSurfaceView.a(this.fMW)) {}
    Canvas localCanvas;
    do
    {
      return;
      localCanvas = MSurfaceView.b(this.fMW).lockCanvas();
    } while (localCanvas == null);
    localCanvas.drawColor(-1);
    this.fMW.f(localCanvas);
    MSurfaceView.b(this.fMW).unlockCanvasAndPost(localCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */