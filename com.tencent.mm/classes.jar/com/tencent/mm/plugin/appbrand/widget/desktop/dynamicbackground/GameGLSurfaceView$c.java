package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class GameGLSurfaceView$c
  implements GameGLSurfaceView.f
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  private GameGLSurfaceView$c(GameGLSurfaceView paramGameGLSurfaceView) {}
  
  public final EGLContext b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(134021);
    c.c.i("MicroMsg.GLThread", "createContext", new Object[0]);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GameGLSurfaceView.a(this.jhn);
    arrayOfInt[2] = 12344;
    if (GameGLSurfaceView.a(this.jhn) != 0) {}
    for (;;)
    {
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, arrayOfInt);
      AppMethodBeat.o(134021);
      return paramEGL10;
      arrayOfInt = null;
    }
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(134022);
    c.c.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      c.c.e("MicroMsg.GLThread", "display:" + paramEGLDisplay + " context: " + paramEGLContext, new Object[0]);
      GameGLSurfaceView.i.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
    AppMethodBeat.o(134022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.c
 * JD-Core Version:    0.7.0.1
 */