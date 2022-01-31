package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MTextureView$1
  implements Runnable
{
  MTextureView$1(MTextureView paramMTextureView) {}
  
  public final void run()
  {
    AppMethodBeat.i(103811);
    if (!this.hgi.isAvailable())
    {
      AppMethodBeat.o(103811);
      return;
    }
    Canvas localCanvas = this.hgi.lockCanvas();
    if (localCanvas == null)
    {
      AppMethodBeat.o(103811);
      return;
    }
    synchronized (MTextureView.a(this.hgi))
    {
      MTextureView.a(this.hgi, true);
      localCanvas.drawColor(-1);
      this.hgi.f(localCanvas);
      this.hgi.unlockCanvasAndPost(localCanvas);
    }
    synchronized (MTextureView.a(this.hgi))
    {
      MTextureView.a(this.hgi, false);
      MTextureView.a(this.hgi).notifyAll();
      AppMethodBeat.o(103811);
      return;
      localObject2 = finally;
      AppMethodBeat.o(103811);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView.1
 * JD-Core Version:    0.7.0.1
 */