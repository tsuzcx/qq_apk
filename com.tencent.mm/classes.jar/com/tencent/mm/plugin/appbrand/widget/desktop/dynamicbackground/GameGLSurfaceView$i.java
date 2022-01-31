package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class GameGLSurfaceView$i
{
  EGLSurface jht;
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  WeakReference<GameGLSurfaceView> mGLSurfaceViewWeakRef;
  
  public GameGLSurfaceView$i(WeakReference<GameGLSurfaceView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  private static String formatEglError(String paramString, int paramInt)
  {
    AppMethodBeat.i(134076);
    paramString = paramString + " failed: " + GameGLSurfaceView.g.getErrorString(paramInt);
    AppMethodBeat.o(134076);
    return paramString;
  }
  
  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134075);
    c.c.w(paramString1, formatEglError(paramString2, paramInt), new Object[0]);
    AppMethodBeat.o(134075);
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    AppMethodBeat.i(134074);
    paramString = formatEglError(paramString, paramInt);
    c.c.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString, new Object[0]);
    paramString = new RuntimeException(paramString);
    AppMethodBeat.o(134074);
    throw paramString;
  }
  
  final void destroySurfaceImp()
  {
    AppMethodBeat.i(134073);
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      Object localObject = this.mEgl;
      EGLDisplay localEGLDisplay = this.mEglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      localObject = (GameGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localObject != null) {
        GameGLSurfaceView.d((GameGLSurfaceView)localObject).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
    AppMethodBeat.o(134073);
  }
  
  public final void start()
  {
    AppMethodBeat.i(134072);
    c.c.w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY)
    {
      localObject = new RuntimeException("eglGetDisplay failed");
      AppMethodBeat.o(134072);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject))
    {
      localObject = new RuntimeException("eglInitialize failed");
      AppMethodBeat.o(134072);
      throw ((Throwable)localObject);
    }
    localObject = (GameGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
    if (localObject == null)
    {
      this.mEglConfig = null;
      this.mEglContext = null;
      c.c.w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
    }
    for (;;)
    {
      if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
      {
        this.mEglContext = null;
        throwEglException("createContext", this.mEgl.eglGetError());
      }
      c.c.w("MicroMsg.GLThread", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId(), new Object[0]);
      this.jht = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[] { 12375, 16, 12374, 16, 12344 });
      this.mEgl.eglMakeCurrent(this.mEglDisplay, this.jht, this.jht, this.mEglContext);
      this.mEglSurface = null;
      AppMethodBeat.o(134072);
      return;
      this.mEglConfig = GameGLSurfaceView.b((GameGLSurfaceView)localObject).chooseConfig(this.mEgl, this.mEglDisplay);
      c.c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", new Object[] { Integer.valueOf(this.mEglConfig.hashCode()), Integer.valueOf(this.mEglDisplay.hashCode()) });
      this.mEglContext = GameGLSurfaceView.c((GameGLSurfaceView)localObject).b(this.mEgl, this.mEglDisplay, this.mEglConfig, EGL10.EGL_NO_CONTEXT);
      c.c.i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.i
 * JD-Core Version:    0.7.0.1
 */