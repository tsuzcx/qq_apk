package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class GLSurfaceView$c
  implements GLSurfaceView.f
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  private GLSurfaceView$c(GLSurfaceView paramGLSurfaceView) {}
  
  public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(133977);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GLSurfaceView.a(this.jhc);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLSurfaceView.a(this.jhc) != 0) {}
    for (;;)
    {
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      AppMethodBeat.o(133977);
      return paramEGL10;
      arrayOfInt = null;
    }
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(133978);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      ab.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      ab.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
      GLSurfaceView.h.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
    AppMethodBeat.o(133978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.c
 * JD-Core Version:    0.7.0.1
 */