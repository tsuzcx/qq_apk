package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class TXCGLSurfaceViewBase$d
  implements TXCGLSurfaceViewBase.g
{
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(67311);
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      AppMethodBeat.o(67311);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      for (;;)
      {
        TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
        TXCLog.e("TXCGLSurfaceViewBase", paramEGL10.toString());
        paramEGL10 = localObject;
      }
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(67312);
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    AppMethodBeat.o(67312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.d
 * JD-Core Version:    0.7.0.1
 */