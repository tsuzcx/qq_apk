package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143186);
    try
    {
      if (a.a(this.htO).eYi)
      {
        ((SurfaceTexture)Objects.requireNonNull(a.b(this.htO).getSurfaceTexture())).updateTexImage();
        a.a(this.htO).onDrawFrame(null);
      }
      while (a.c(this.htO).get())
      {
        if (a.g(this.htO) == null) {
          break label194;
        }
        EGLExt.eglPresentationTimeANDROID(a.g(this.htO).eZx, a.g(this.htO).eZy, System.nanoTime());
        EGL14.eglSwapBuffers(a.g(this.htO).eZx, a.g(this.htO).eZy);
        AppMethodBeat.o(143186);
        return;
        ab.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
      }
      ab.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
      ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(808L, 2L, 1L, true);
      AppMethodBeat.o(143186);
      return;
    }
    label194:
    AppMethodBeat.o(143186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a.5
 * JD-Core Version:    0.7.0.1
 */