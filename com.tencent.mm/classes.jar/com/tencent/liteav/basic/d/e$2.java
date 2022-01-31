package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  e$2(e parame) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(146551);
    e.a(this.a, 103, new e.2.1(this));
    paramSurfaceTexture.setOnFrameAvailableListener(null);
    AppMethodBeat.o(146551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.d.e.2
 * JD-Core Version:    0.7.0.1
 */