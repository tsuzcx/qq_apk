package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.b;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143185);
    boolean bool = a.b(this.htO, a.b(this.htO).getSurfaceTexture());
    a.c(this.htO).getAndSet(false);
    a.a(this.htO).release(bool);
    if (a.g(this.htO) != null)
    {
      EGL14.eglDestroyContext(a.g(this.htO).eZx, a.g(this.htO).eZz);
      EGL14.eglDestroySurface(a.g(this.htO).eZx, a.g(this.htO).eZy);
      a.h(this.htO).release();
    }
    AppMethodBeat.o(143185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a.4
 * JD-Core Version:    0.7.0.1
 */