package com.tencent.mm.plugin.appbrand.game;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GameGLSurfaceView$a
  implements GameGLSurfaceView.e
{
  protected int[] fYT;
  
  public GameGLSurfaceView$a(GameGLSurfaceView paramGameGLSurfaceView, int[] paramArrayOfInt)
  {
    if ((GameGLSurfaceView.a(this.fYU) != 2) && (GameGLSurfaceView.a(this.fYU) != 3))
    {
      this.fYT = paramArrayOfInt;
      return;
    }
    paramGameGLSurfaceView = new int[15];
    System.arraycopy(paramArrayOfInt, 0, paramGameGLSurfaceView, 0, 12);
    paramGameGLSurfaceView[12] = 12352;
    if (GameGLSurfaceView.a(this.fYU) == 2) {
      paramGameGLSurfaceView[13] = 4;
    }
    for (;;)
    {
      paramGameGLSurfaceView[14] = 12344;
      paramArrayOfInt = paramGameGLSurfaceView;
      break;
      paramGameGLSurfaceView[13] = 64;
    }
  }
  
  abstract EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.fYT, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.fYT, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.a
 * JD-Core Version:    0.7.0.1
 */