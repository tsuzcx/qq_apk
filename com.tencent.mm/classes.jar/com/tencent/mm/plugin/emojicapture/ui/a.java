package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public final class a
  implements GLSurfaceView.EGLConfigChooser
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int[] fwv = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  public static final a.a jnX = new a.a((byte)0);
  private int fwA = 0;
  private int fwB = 0;
  private final int[] fwC = new int[1];
  private int fww = 8;
  private int fwx = 8;
  private int fwy = 8;
  private int fwz = 8;
  
  private final int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.fwC)) {
      i = this.fwC[0];
    }
    return i;
  }
  
  private final EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    if (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k;
      int m;
      if (localEGLConfig != null)
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.fwA) && (m >= this.fwB)) {
          break label78;
        }
      }
      label78:
      int n;
      int i1;
      do
      {
        i += 1;
        break;
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
      } while ((k != this.fww) || (m != this.fwx) || (n != this.fwy) || (i1 != this.fwz));
      return localEGLConfig;
    }
    return null;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    g.k(paramEGL10, "egl");
    g.k(paramEGLDisplay, "display");
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, fwv, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw ((Throwable)new IllegalArgumentException("No configs match configSpec"));
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, fwv, arrayOfEGLConfig, i, arrayOfInt);
    return b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a
 * JD-Core Version:    0.7.0.1
 */