package com.tencent.mm.media.j.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements GLSurfaceView.EGLConfigChooser
{
  private static final String TAG;
  public static final a.a nDC;
  private final int EGL_OPENGL_ES2_BIT;
  private final int[] mcA;
  private int mcB;
  private int mcC;
  private int mcD;
  private int mcE;
  private int mcF;
  private int mcG;
  private final String mgf;
  private final int[] nDD;
  
  static
  {
    AppMethodBeat.i(93850);
    nDC = new a.a((byte)0);
    TAG = "GLConfigChooser";
    AppMethodBeat.o(93850);
  }
  
  public a()
  {
    AppMethodBeat.i(93849);
    this.mcB = 5;
    this.mcC = 6;
    this.mcD = 5;
    this.mcE = 0;
    this.mcF = 0;
    this.mcG = 0;
    this.mgf = "MicroMsg.RenderConfigChooser";
    this.EGL_OPENGL_ES2_BIT = 4;
    this.nDD = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
    this.mcA = new int[1];
    AppMethodBeat.o(93849);
  }
  
  private final int b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(93847);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mcA))
    {
      paramInt = this.mcA[0];
      AppMethodBeat.o(93847);
      return paramInt;
    }
    AppMethodBeat.o(93847);
    return 0;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(93846);
    s.u(paramEGL10, "egl");
    s.u(paramEGLDisplay, "display");
    s.u(paramArrayOfEGLConfig, "configs");
    int k = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < k)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int j = i + 1;
      s.checkNotNull(localEGLConfig);
      int m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      i = j;
      if (m >= this.mcF)
      {
        i = j;
        if (n >= this.mcG)
        {
          m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int i1 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i2 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          i = j;
          if (m == this.mcB)
          {
            i = j;
            if (n == this.mcC)
            {
              i = j;
              if (i1 == this.mcD)
              {
                i = j;
                if (i2 == this.mcE)
                {
                  AppMethodBeat.o(93846);
                  return localEGLConfig;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(93846);
    return null;
  }
  
  private final void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(93848);
    int m = paramArrayOfEGLConfig.length;
    Object localObject1 = this.mgf;
    Object localObject2 = am.aixg;
    localObject2 = String.format("%d configurations", Arrays.copyOf(new Object[] { Integer.valueOf(m) }, 1));
    s.s(localObject2, "java.lang.String.format(format, *args)");
    Log.i((String)localObject1, (String)localObject2);
    int j;
    if (m > 0)
    {
      i = 0;
      j = i + 1;
      localObject1 = this.mgf;
      localObject2 = am.aixg;
      localObject2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      Log.i((String)localObject1, (String)localObject2);
      localObject1 = paramArrayOfEGLConfig[i];
      s.checkNotNull(localObject1);
      localObject2 = new int[1];
    }
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      paramEGL10.eglGetConfigAttrib(paramEGLDisplay, (EGLConfig)localObject1, new int[] { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 }[i], (int[])localObject2);
      if (k > 32)
      {
        if (j >= m)
        {
          AppMethodBeat.o(93848);
          return;
        }
        i = j;
        break;
      }
    }
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(93845);
    s.u(paramEGL10, "egl");
    s.u(paramEGLDisplay, "display");
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.nDD, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(93845);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.nDD, arrayOfEGLConfig, i, arrayOfInt);
    c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(93845);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.media.j.a.a
 * JD-Core Version:    0.7.0.1
 */