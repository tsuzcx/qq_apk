package com.tencent.mm.media.i;

import a.f.b.j;
import a.l;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "EGL_RECORDABLE_ANDROID", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "texture", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglSetupBySurface", "mSurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "Landroid/opengl/EGLSurface;", "eglDisplay", "eglEnvironment", "swapBuffers", "plugin-mediaeditor_release"})
public final class b$a
{
  private static int M(String paramString, int paramInt)
  {
    AppMethodBeat.i(13115);
    j.q(paramString, "shaderSource");
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: %s", new Object[] { GLES20.glGetShaderInfoLog(paramInt) });
      AppMethodBeat.o(13115);
      return 0;
    }
    AppMethodBeat.o(13115);
    return paramInt;
  }
  
  public static int Vm()
  {
    AppMethodBeat.i(13114);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    mT("genTexture");
    int i = arrayOfInt[0];
    AppMethodBeat.o(13114);
    return i;
  }
  
  public static int Vn()
  {
    AppMethodBeat.i(13117);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
      AppMethodBeat.o(13117);
      return 0;
    }
    int i = arrayOfInt[0];
    AppMethodBeat.o(13117);
    return i;
  }
  
  public static void Vo()
  {
    AppMethodBeat.i(13118);
    GLES20.glClear(19798);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(13118);
  }
  
  public static int Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13116);
    j.q(paramString1, "vertexShaderSource");
    j.q(paramString2, "fragmentShaderSource");
    int[] arrayOfInt = new int[1];
    int i = M(paramString1, 35633);
    if (i == 0)
    {
      ab.e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
      AppMethodBeat.o(13116);
      return 0;
    }
    int j = M(paramString2, 35632);
    if (j == 0)
    {
      ab.e("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
      AppMethodBeat.o(13116);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      ab.e("MicroMsg.GLEnvironmentUtil", "link program failed");
      AppMethodBeat.o(13116);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(13116);
    return k;
  }
  
  public static b.b a(EGLContext paramEGLContext, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13124);
    j.q(paramEGLContext, "eglContext");
    ab.i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
    if ((paramObject != null) && (!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceHolder)))
    {
      paramEGLContext = (Throwable)new IllegalArgumentException("unsupported surface");
      AppMethodBeat.o(13124);
      throw paramEGLContext;
    }
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      paramEGLContext = (Throwable)new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(13124);
      throw paramEGLContext;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      paramEGLContext = (Throwable)new RuntimeException("eglInitialize failed");
      AppMethodBeat.o(13124);
      throw paramEGLContext;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    localObject = new int[1];
    EGL14.eglChooseConfig(localEGLDisplay, b.Vk(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
    if (arrayOfEGLConfig[0] == null)
    {
      paramEGLContext = (Throwable)new RuntimeException("chooseConfig failed");
      AppMethodBeat.o(13124);
      throw paramEGLContext;
    }
    localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, 2, 12344 }, 0);
    if (j.e(localObject, EGL14.EGL_NO_CONTEXT))
    {
      paramEGLContext = (Throwable)new RuntimeException("EGL error " + EGL14.eglGetError());
      AppMethodBeat.o(13124);
      throw paramEGLContext;
    }
    mS("eglCreateContext");
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      paramEGLContext = new int[5];
      paramEGLContext[0] = 12375;
      paramEGLContext[1] = paramInt1;
      paramEGLContext[2] = 12374;
      paramEGLContext[3] = paramInt2;
      paramEGLContext[4] = 12344;
    }
    for (;;)
    {
      if (paramObject != null) {}
      try
      {
        for (paramEGLContext = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramObject, paramEGLContext, 0);; paramEGLContext = EGL14.eglCreatePbufferSurface(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, 0))
        {
          if (paramObject == null) {
            break label502;
          }
          mS("eglCreateWindowSurface");
          if (((paramEGLContext == null) || (paramEGLContext == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
            ab.e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
          }
          if (!EGL14.eglMakeCurrent(localEGLDisplay, paramEGLContext, paramEGLContext, (EGLContext)localObject)) {
            ab.w("MicroMsg.GLEnvironmentUtil", "eglMakeCurrent:" + EGL14.eglGetError());
          }
          j.p(localEGLDisplay, "eglDisplay");
          if (paramEGLContext == null) {
            j.ebi();
          }
          j.p(localObject, "outputEGLContext");
          paramEGLContext = new b.b(localEGLDisplay, paramEGLContext, (EGLContext)localObject);
          AppMethodBeat.o(13124);
          return paramEGLContext;
          paramEGLContext = new int[1];
          paramEGLContext[0] = 12344;
          break;
        }
      }
      catch (IllegalArgumentException paramEGLContext)
      {
        for (;;)
        {
          ab.e("MicroMsg.GLEnvironmentUtil", "eglCreateWindowSurface", new Object[] { paramEGLContext });
          paramEGLContext = null;
          continue;
          label502:
          mS("eglCreatePbufferSurface");
        }
      }
    }
  }
  
  public static b.b a(Surface paramSurface, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152098);
    ab.i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + paramSurface + ", surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      paramSurface = (Throwable)new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(152098);
      throw paramSurface;
    }
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(localEGLDisplay, arrayOfInt, 0, arrayOfInt, 1))
    {
      paramSurface = (Throwable)new RuntimeException("unable to initialize EGL14");
      AppMethodBeat.o(152098);
      throw paramSurface;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    arrayOfInt = new int[1];
    EGLContext localEGLContext;
    if ((paramSurface != null) || (paramSurfaceTexture != null))
    {
      EGL14.eglChooseConfig(localEGLDisplay, b.Vk(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      mS("eglCreateContext RGB888+recordable ES2");
      localEGLContext = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
      mS("eglCreateContext");
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label372;
      }
      arrayOfInt = new int[5];
      arrayOfInt[0] = 12375;
      arrayOfInt[1] = paramInt1;
      arrayOfInt[2] = 12374;
      arrayOfInt[3] = paramInt2;
      arrayOfInt[4] = 12344;
      label262:
      if (paramSurface == null) {
        break label387;
      }
      paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurface, arrayOfInt, 0);
      label280:
      if (paramSurface == null) {
        break label424;
      }
      mS("eglCreateWindowSurface");
    }
    for (;;)
    {
      EGL14.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, localEGLContext);
      mS("eglMakeCurrent");
      j.p(localEGLDisplay, "mEGLDisplay");
      j.p(paramSurfaceTexture, "mEGLSurface");
      j.p(localEGLContext, "mEGLContext");
      paramSurface = new b.b(localEGLDisplay, paramSurfaceTexture, localEGLContext);
      AppMethodBeat.o(152098);
      return paramSurface;
      EGL14.eglChooseConfig(localEGLDisplay, b.Vl(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      break;
      label372:
      arrayOfInt = new int[1];
      arrayOfInt[0] = 12344;
      break label262;
      label387:
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurfaceTexture, arrayOfInt, 0);
        break label280;
      }
      paramSurfaceTexture = EGL14.eglCreatePbufferSurface(localEGLDisplay, arrayOfEGLConfig[0], arrayOfInt, 0);
      break label280;
      label424:
      mS("eglCreatePbufferSurface");
    }
  }
  
  public static void a(b.b paramb)
  {
    AppMethodBeat.i(152099);
    j.q(paramb, "eglEnvironment");
    if (paramb.eZy != EGL14.EGL_NO_DISPLAY)
    {
      localObject = paramb.eZx;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(paramb.eZx, paramb.eZy);
      EGL14.eglDestroyContext(paramb.eZx, paramb.eZz);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(paramb.eZx);
    }
    Object localObject = EGL14.EGL_NO_DISPLAY;
    j.p(localObject, "EGL14.EGL_NO_DISPLAY");
    paramb.a((EGLDisplay)localObject);
    localObject = EGL14.EGL_NO_CONTEXT;
    j.p(localObject, "EGL14.EGL_NO_CONTEXT");
    paramb.a((EGLContext)localObject);
    localObject = EGL14.EGL_NO_SURFACE;
    j.p(localObject, "EGL14.EGL_NO_SURFACE");
    paramb.a((EGLSurface)localObject);
    AppMethodBeat.o(152099);
  }
  
  public static boolean a(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(13120);
    if ((paramEGLDisplay == null) || (paramEGLSurface == null))
    {
      AppMethodBeat.o(13120);
      return false;
    }
    boolean bool = EGL14.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
    mS("eglSwapBuffers");
    AppMethodBeat.o(13120);
    return bool;
  }
  
  private static boolean aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13121);
    j.q(paramString1, "msg");
    j.q(paramString2, "tag");
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      ab.b(paramString2, paramString1 + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(13121);
      return true;
    }
    AppMethodBeat.o(13121);
    return false;
  }
  
  public static void mT(String paramString)
  {
    AppMethodBeat.i(13123);
    int i = GLES20.glGetError();
    if (i != 0) {
      ab.b("MicroMsg.GLEnvironmentUtil", paramString + ": GL error: 0x" + Integer.toHexString(i), new Object[0]);
    }
    AppMethodBeat.o(13123);
  }
  
  public static void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(152097);
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(152097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.a
 * JD-Core Version:    0.7.0.1
 */