package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class GLSurfaceView$h
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
  
  public GLSurfaceView$h(WeakReference<GLSurfaceView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  private static String formatEglError(String paramString, int paramInt)
  {
    AppMethodBeat.i(133984);
    paramString = paramString + " failed: " + paramInt;
    AppMethodBeat.o(133984);
    return paramString;
  }
  
  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133983);
    ab.w(paramString1, formatEglError(paramString2, paramInt));
    AppMethodBeat.o(133983);
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    AppMethodBeat.i(133982);
    paramString = formatEglError(paramString, paramInt);
    ab.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString);
    paramString = new RuntimeException(paramString);
    AppMethodBeat.o(133982);
    throw paramString;
  }
  
  final void destroySurfaceImp()
  {
    AppMethodBeat.i(133981);
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      Object localObject = this.mEgl;
      EGLDisplay localEGLDisplay = this.mEglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      localObject = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localObject != null) {
        GLSurfaceView.d((GLSurfaceView)localObject).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
    AppMethodBeat.o(133981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h
 * JD-Core Version:    0.7.0.1
 */