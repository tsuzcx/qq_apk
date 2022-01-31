package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCGLSurfaceView$2
  implements Runnable
{
  TXCGLSurfaceView$2(TXCGLSurfaceView paramTXCGLSurfaceView, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(67336);
    TXCGLSurfaceView.b(this.b, this.a);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    AppMethodBeat.o(67336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */