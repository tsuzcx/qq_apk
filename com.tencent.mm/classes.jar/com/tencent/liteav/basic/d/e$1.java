package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  e$1(e parame) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(146564);
    e.a(this.a, 103, new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(146527);
        e.a(e.1.this.a, true);
        e.a(e.1.this.a, 102);
        AppMethodBeat.o(146527);
      }
    });
    paramSurfaceTexture.setOnFrameAvailableListener(null);
    AppMethodBeat.o(146564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.d.e.1
 * JD-Core Version:    0.7.0.1
 */