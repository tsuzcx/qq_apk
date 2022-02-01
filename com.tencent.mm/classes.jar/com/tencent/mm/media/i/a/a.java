package com.tencent.mm.media.i.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "plugin-mediaeditor_release"})
public final class a
  implements GLSurfaceView.EGLConfigChooser
{
  private static final String TAG = "GLConfigChooser";
  public static final a.a guR;
  private final int EGL_OPENGL_ES2_BIT;
  private int fJA;
  private int fJB;
  private int fJC;
  private final int[] fJw;
  private int fJx;
  private int fJy;
  private int fJz;
  private final String fLc;
  private final int[] guQ;
  
  static
  {
    AppMethodBeat.i(93850);
    guR = new a.a((byte)0);
    TAG = "GLConfigChooser";
    AppMethodBeat.o(93850);
  }
  
  public a()
  {
    AppMethodBeat.i(93849);
    this.fJx = 5;
    this.fJy = 6;
    this.fJz = 5;
    this.fJA = 0;
    this.fJB = 0;
    this.fJC = 0;
    this.fLc = "MicroMsg.RenderConfigChooser";
    this.EGL_OPENGL_ES2_BIT = 4;
    this.guQ = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
    this.fJw = new int[1];
    AppMethodBeat.o(93849);
  }
  
  private final int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(93847);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.fJw))
    {
      paramInt = this.fJw[0];
      AppMethodBeat.o(93847);
      return paramInt;
    }
    AppMethodBeat.o(93847);
    return 0;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(93846);
    k.h(paramEGL10, "egl");
    k.h(paramEGLDisplay, "display");
    k.h(paramArrayOfEGLConfig, "configs");
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    if (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      if (localEGLConfig == null) {
        k.fvU();
      }
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k < this.fJB) || (m < this.fJC)) {}
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
      } while ((k != this.fJx) || (m != this.fJy) || (n != this.fJz) || (i1 != this.fJA));
      AppMethodBeat.o(93846);
      return localEGLConfig;
    }
    AppMethodBeat.o(93846);
    return null;
  }
  
  private final void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(93848);
    int k = paramArrayOfEGLConfig.length;
    Object localObject1 = this.fLc;
    Object localObject2 = z.Jhz;
    localObject2 = String.format("%d configurations", Arrays.copyOf(new Object[] { Integer.valueOf(k) }, 1));
    k.g(localObject2, "java.lang.String.format(format, *args)");
    ad.i((String)localObject1, (String)localObject2);
    int i = 0;
    while (i < k)
    {
      localObject1 = this.fLc;
      localObject2 = z.Jhz;
      localObject2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
      k.g(localObject2, "java.lang.String.format(format, *args)");
      ad.i((String)localObject1, (String)localObject2);
      localObject1 = paramArrayOfEGLConfig[i];
      if (localObject1 == null) {
        k.fvU();
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
    AppMethodBeat.o(93848);
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(93845);
    k.h(paramEGL10, "egl");
    k.h(paramEGLDisplay, "display");
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.guQ, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = (Throwable)new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(93845);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.guQ, arrayOfEGLConfig, i, arrayOfInt);
    c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(93845);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.a.a
 * JD-Core Version:    0.7.0.1
 */