package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLSurfaceView$a
  implements GLSurfaceView.e
{
  protected int[] mConfigSpec;
  
  public GLSurfaceView$a(GLSurfaceView paramGLSurfaceView, int[] paramArrayOfInt)
  {
    if ((GLSurfaceView.a(this.jhc) != 2) && (GLSurfaceView.a(this.jhc) != 3))
    {
      this.mConfigSpec = paramArrayOfInt;
      return;
    }
    paramGLSurfaceView = new int[15];
    System.arraycopy(paramArrayOfInt, 0, paramGLSurfaceView, 0, 12);
    paramGLSurfaceView[12] = 12352;
    if (GLSurfaceView.a(this.jhc) == 2) {
      paramGLSurfaceView[13] = 4;
    }
    for (;;)
    {
      paramGLSurfaceView[14] = 12344;
      paramArrayOfInt = paramGLSurfaceView;
      break;
      paramGLSurfaceView[13] = 64;
    }
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
  
  abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.a
 * JD-Core Version:    0.7.0.1
 */