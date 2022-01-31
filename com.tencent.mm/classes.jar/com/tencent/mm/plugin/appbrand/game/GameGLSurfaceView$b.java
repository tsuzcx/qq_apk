package com.tencent.mm.plugin.appbrand.game;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$b
  extends GameGLSurfaceView.a
{
  protected int fwA = 16;
  protected int fwB = 8;
  private int[] fwC = new int[1];
  protected int fww = 8;
  protected int fwx = 8;
  protected int fwy = 8;
  protected int fwz = 8;
  
  public GameGLSurfaceView$b(GameGLSurfaceView paramGameGLSurfaceView)
  {
    super(paramGameGLSurfaceView, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344 });
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.fwC)) {
      i = this.fwC[0];
    }
    return i;
  }
  
  public final EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.fwA) && (m >= this.fwB))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.fww) && (m == this.fwx) && (n == this.fwy) && (i1 == this.fwz)) {
          return localEGLConfig;
        }
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */