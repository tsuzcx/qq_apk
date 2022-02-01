package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class MMSightCameraGLSurfaceView$a
  implements GLSurfaceView.EGLConfigChooser
{
  private int EGL_OPENGL_ES2_BIT;
  private int[] mcA;
  protected int mcB;
  protected int mcC;
  protected int mcD;
  protected int mcE;
  protected int mcF;
  protected int mcG;
  private int[] nDD;
  
  public MMSightCameraGLSurfaceView$a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(89194);
    this.EGL_OPENGL_ES2_BIT = 4;
    this.nDD = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
    this.mcA = new int[1];
    this.mcB = 5;
    this.mcC = 6;
    this.mcD = 5;
    this.mcE = 0;
    this.mcF = 0;
    this.mcG = 0;
    AppMethodBeat.o(89194);
  }
  
  private int b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(89197);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mcA))
    {
      paramInt = this.mcA[0];
      AppMethodBeat.o(89197);
      return paramInt;
    }
    AppMethodBeat.o(89197);
    return 0;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(89196);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.mcF) && (m >= this.mcG))
      {
        k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.mcB) && (m == this.mcC) && (n == this.mcD) && (i1 == this.mcE))
        {
          AppMethodBeat.o(89196);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(89196);
    return null;
  }
  
  private static void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(89198);
    int k = paramArrayOfEGLConfig.length;
    Log.i("GLConfigChooser", String.format("%d configurations", new Object[] { Integer.valueOf(k) }));
    int i = 0;
    while (i < k)
    {
      Log.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
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
    AppMethodBeat.o(89198);
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(89195);
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.nDD, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(89195);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.nDD, arrayOfEGLConfig, i, arrayOfInt);
    c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(89195);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.a
 * JD-Core Version:    0.7.0.1
 */