package com.tencent.mm.media.h.a;

import a.f.b.j;
import a.f.b.y;
import a.l;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements GLSurfaceView.EGLConfigChooser
{
  private static final String TAG = "GLConfigChooser";
  public static final a.a eYt;
  private final int EGL_OPENGL_ES2_BIT;
  private final String eYr;
  private final int[] eYs;
  private int mAlphaSize;
  private int mBlueSize;
  private int mDepthSize;
  private int mGreenSize;
  private int mRedSize;
  private int mStencilSize;
  private final int[] mValue;
  
  static
  {
    AppMethodBeat.i(13097);
    eYt = new a.a((byte)0);
    TAG = "GLConfigChooser";
    AppMethodBeat.o(13097);
  }
  
  public a()
  {
    AppMethodBeat.i(13096);
    this.mRedSize = 5;
    this.mGreenSize = 6;
    this.mBlueSize = 5;
    this.mAlphaSize = 0;
    this.mDepthSize = 0;
    this.mStencilSize = 0;
    this.eYr = "MicroMsg.RenderConfigChooser";
    this.EGL_OPENGL_ES2_BIT = 4;
    this.eYs = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
    this.mValue = new int[1];
    AppMethodBeat.o(13096);
  }
  
  private final int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(13094);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mValue))
    {
      paramInt = this.mValue[0];
      AppMethodBeat.o(13094);
      return paramInt;
    }
    AppMethodBeat.o(13094);
    return 0;
  }
  
  private final void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(13095);
    int k = paramArrayOfEGLConfig.length;
    Object localObject1 = this.eYr;
    Object localObject2 = y.BNt;
    localObject2 = String.format("%d configurations", Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
    j.p(localObject2, "java.lang.String.format(format, *args)");
    ab.i((String)localObject1, (String)localObject2);
    int i = 0;
    while (i < k)
    {
      localObject1 = this.eYr;
      localObject2 = y.BNt;
      localObject2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
      j.p(localObject2, "java.lang.String.format(format, *args)");
      ab.i((String)localObject1, (String)localObject2);
      localObject1 = paramArrayOfEGLConfig[i];
      if (localObject1 == null) {
        j.ebi();
      }
      localObject2 = new int[1];
      int j = 0;
      while (j < 33)
      {
        paramEGL10.eglGetConfigAttrib(paramEGLDisplay, (EGLConfig)localObject1, new int[] { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 }[j], (int[])localObject2);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(13095);
  }
  
  private EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(13093);
    j.q(paramEGL10, "egl");
    j.q(paramEGLDisplay, "display");
    j.q(paramArrayOfEGLConfig, "configs");
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    if (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      if (localEGLConfig == null) {
        j.ebi();
      }
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k < this.mDepthSize) || (m < this.mStencilSize)) {}
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
      } while ((k != this.mRedSize) || (m != this.mGreenSize) || (n != this.mBlueSize) || (i1 != this.mAlphaSize));
      AppMethodBeat.o(13093);
      return localEGLConfig;
    }
    AppMethodBeat.o(13093);
    return null;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(13092);
    j.q(paramEGL10, "egl");
    j.q(paramEGLDisplay, "display");
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.eYs, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = (Throwable)new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(13092);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.eYs, arrayOfEGLConfig, i, arrayOfInt);
    b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(13092);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.a.a
 * JD-Core Version:    0.7.0.1
 */