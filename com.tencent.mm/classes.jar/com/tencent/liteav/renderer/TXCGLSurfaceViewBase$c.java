package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class TXCGLSurfaceViewBase$c
  implements TXCGLSurfaceViewBase.f
{
  private int b = 12440;
  
  private TXCGLSurfaceViewBase$c(TXCGLSurfaceViewBase paramTXCGLSurfaceViewBase) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(67219);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.b;
    arrayOfInt[1] = TXCGLSurfaceViewBase.h(this.a);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (TXCGLSurfaceViewBase.h(this.a) != 0) {}
    for (;;)
    {
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      AppMethodBeat.o(67219);
      return paramEGL10;
      arrayOfInt = null;
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(67220);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      TXCLog.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      TXCGLSurfaceViewBase.h.a("eglDestroyContex", paramEGL10.eglGetError());
    }
    AppMethodBeat.o(67220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.c
 * JD-Core Version:    0.7.0.1
 */