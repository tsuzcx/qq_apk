package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.mm.sdk.platformtools.y;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class MMSightCameraGLSurfaceView$a
  implements GLSurfaceView.EGLConfigChooser
{
  private int EGL_OPENGL_ES2_BIT = 4;
  protected int fwA = 0;
  protected int fwB = 0;
  private int[] fwC = new int[1];
  private int[] fwv = { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
  protected int fww = 5;
  protected int fwx = 6;
  protected int fwy = 5;
  protected int fwz = 0;
  
  public MMSightCameraGLSurfaceView$a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView) {}
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.fwC)) {
      i = this.fwC[0];
    }
    return i;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
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
  
  private static void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int k = paramArrayOfEGLConfig.length;
    y.i("GLConfigChooser", String.format("%d configurations", new Object[] { Integer.valueOf(k) }));
    int i = 0;
    while (i < k)
    {
      y.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int[] arrayOfInt = new int[1];
      int j = 0;
      while (j < 33)
      {
        paramEGL10.eglGetConfigAttrib(paramEGLDisplay, localEGLConfig, new int[] { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 }[j], arrayOfInt);
        j += 1;
      }
      i += 1;
    }
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.fwv, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.fwv, arrayOfEGLConfig, i, arrayOfInt);
    c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    return b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.a
 * JD-Core Version:    0.7.0.1
 */