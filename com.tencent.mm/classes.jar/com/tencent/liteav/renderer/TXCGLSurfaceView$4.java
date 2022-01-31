package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCGLSurfaceView$4
  implements Runnable
{
  TXCGLSurfaceView$4(TXCGLSurfaceView paramTXCGLSurfaceView) {}
  
  public void run()
  {
    AppMethodBeat.i(67356);
    try
    {
      TXCLog.d("TXCGLSurfaceView", "background capture exit background");
      this.a.c = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(67356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */