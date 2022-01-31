package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.d.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class GameGLSurfaceView$d
  implements GameGLSurfaceView.h
{
  public final EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      d.f.e("MicroMsg.GameGLSurfaceView", "eglCreateWindowSurface", new Object[] { paramEGL10 });
    }
    return null;
  }
  
  public final void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.d
 * JD-Core Version:    0.7.0.1
 */