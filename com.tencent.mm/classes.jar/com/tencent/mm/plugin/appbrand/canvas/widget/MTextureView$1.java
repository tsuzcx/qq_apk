package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;

final class MTextureView$1
  implements Runnable
{
  MTextureView$1(MTextureView paramMTextureView) {}
  
  public final void run()
  {
    if (!this.fMY.isAvailable()) {}
    Canvas localCanvas;
    do
    {
      return;
      localCanvas = this.fMY.lockCanvas();
    } while (localCanvas == null);
    synchronized (MTextureView.a(this.fMY))
    {
      MTextureView.a(this.fMY, true);
      localCanvas.drawColor(-1);
      this.fMY.f(localCanvas);
      this.fMY.unlockCanvasAndPost(localCanvas);
      synchronized (MTextureView.a(this.fMY))
      {
        MTextureView.a(this.fMY, false);
        MTextureView.a(this.fMY).notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView.1
 * JD-Core Version:    0.7.0.1
 */