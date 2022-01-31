package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.d.f;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class GameGLSurfaceView$i
{
  WeakReference<GameGLSurfaceView> fZa;
  EGLConfig fZb;
  EGL10 fwH;
  EGLDisplay fwI;
  EGLContext fwJ;
  EGLSurface fwK;
  
  public GameGLSurfaceView$i(WeakReference<GameGLSurfaceView> paramWeakReference)
  {
    this.fZa = paramWeakReference;
  }
  
  public static void aM(String paramString, int paramInt)
  {
    paramString = aN(paramString, paramInt);
    d.f.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString, new Object[0]);
    throw new RuntimeException(paramString);
  }
  
  private static String aN(String paramString, int paramInt)
  {
    return paramString + " failed: " + GameGLSurfaceView.g.getErrorString(paramInt);
  }
  
  public static void m(String paramString1, String paramString2, int paramInt)
  {
    d.f.w(paramString1, aN(paramString2, paramInt), new Object[0]);
  }
  
  final void afQ()
  {
    if ((this.fwK != null) && (this.fwK != EGL10.EGL_NO_SURFACE))
    {
      this.fwH.eglMakeCurrent(this.fwI, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      GameGLSurfaceView localGameGLSurfaceView = (GameGLSurfaceView)this.fZa.get();
      if (localGameGLSurfaceView != null) {
        GameGLSurfaceView.d(localGameGLSurfaceView).destroySurface(this.fwH, this.fwI, this.fwK);
      }
      this.fwK = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i
 * JD-Core Version:    0.7.0.1
 */