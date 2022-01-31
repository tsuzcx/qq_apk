package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.d.f;
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
    d.f.i("MicroMsg.GLThread", "createContext", new Object[0]);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = GameGLSurfaceView.a(this.fYU);
    arrayOfInt[2] = 12344;
    if (GameGLSurfaceView.a(this.fYU) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    d.f.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      d.f.e("MicroMsg.GLThread", "display:" + paramEGLDisplay + " context: " + paramEGLContext, new Object[0]);
      GameGLSurfaceView.i.aM("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.c
 * JD-Core Version:    0.7.0.1
 */