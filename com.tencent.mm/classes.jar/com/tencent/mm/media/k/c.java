package com.tencent.mm.media.k;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/util/GLEnvironmentUtil;", "", "()V", "Companion", "EGLEnvironment", "plugin-mediaeditor_release"})
public final class c
{
  private static final int[] hrA;
  private static final int[] hrB;
  private static final int[] hrC;
  public static final a hrD;
  public static final float[] hrw;
  public static final float[] hrx;
  public static final float[] hry;
  private static final int[] hrz;
  
  static
  {
    AppMethodBeat.i(93890);
    hrD = new a((byte)0);
    hrw = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    hrx = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    hry = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    hrz = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    hrA = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, 12610, 1, 12344 };
    hrB = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 };
    hrC = new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 };
    AppMethodBeat.o(93890);
  }
  
  public static final void auv()
  {
    AppMethodBeat.i(93891);
    a.auv();
    AppMethodBeat.o(93891);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "DEFAULT_EGL_CONTEXT_CLIENT_VERSION", "", "EGL_RECORDABLE_ANDROID", "HAS_REPORTED_EGL_VERSION", "", "MMKV_GL_KEY", "ROTATION_180", "ROTATION_270", "ROTATION_90", "SUPPORT_EGL_CONTEXT_CLIENT_VERSION", "TAG", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "shareEGLSurfaceTypeAttributeList", "getShareEGLSurfaceTypeAttributeList", "()[I", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "texture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "deleteFrameBuffer", "deleteTexture", "deleteTextures", "textures", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglBindSurface", "mEGLContext", "mEGLDisplay", "mSurface", "eglCreateSurface", "Landroid/opengl/EGLSurface;", "eglSetupByShareGLContext", "mShareGLContext", "eglSetupBySurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "shareEGLContext", "eglSetupWithoutSurface", "eglUnbindSurface", "eglEnvironment", "backupSurface", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "eglDisplay", "resolveMirror", "textureCoords", "resolveRotate", "rotation", "saveExternalTexture", "saveGLPixels", "saveTexture", "saveTextureExternal", "setupDeviceSupportGLVersion", "context", "Landroid/content/Context;", "swap", "prevIndex", "afterIndex", "swapBuffers", "uploadBitmapTexture", "texName", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static EGLSurface a(EGLDisplay paramEGLDisplay, Object paramObject)
    {
      AppMethodBeat.i(217541);
      p.h(paramEGLDisplay, "mEGLDisplay");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(paramEGLDisplay, c.auu(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      paramEGLDisplay = EGL14.eglCreateWindowSurface(paramEGLDisplay, arrayOfEGLConfig[0], paramObject, new int[] { 12344 }, 0);
      p.g(paramEGLDisplay, "EGL14.eglCreateWindowSur…rayOf(EGL14.EGL_NONE), 0)");
      AppMethodBeat.o(217541);
      return paramEGLDisplay;
    }
    
    public static c.b a(EGLContext paramEGLContext, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93885);
      p.h(paramEGLContext, "eglContext");
      ae.i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
      if ((paramObject != null) && (!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceHolder)))
      {
        paramEGLContext = (Throwable)new IllegalArgumentException("unsupported surface");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = (Throwable)new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramEGLContext = (Throwable)new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      EGL14.eglChooseConfig(localEGLDisplay, c.auu(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
      if (arrayOfEGLConfig[0] == null)
      {
        paramEGLContext = (Throwable)new RuntimeException("chooseConfig failed");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      int i = ay.aRW("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
      localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
      if (p.i(localObject, EGL14.EGL_NO_CONTEXT))
      {
        paramEGLContext = (Throwable)new RuntimeException("EGL error " + EGL14.eglGetError());
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      yR("eglCreateContext");
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
              break label491;
            }
            yR("eglCreateWindowSurface");
            if (((paramEGLContext == null) || (paramEGLContext == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
              ae.e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
            }
            if (paramEGLContext != null)
            {
              EGL14.eglMakeCurrent(localEGLDisplay, paramEGLContext, paramEGLContext, (EGLContext)localObject);
              yR("eglMakeCurrent");
            }
            p.g(localEGLDisplay, "eglDisplay");
            if (paramEGLContext == null) {
              p.gkB();
            }
            p.g(localObject, "outputEGLContext");
            paramEGLContext = new c.b(localEGLDisplay, paramEGLContext, (EGLContext)localObject);
            AppMethodBeat.o(93885);
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
            ae.e("MicroMsg.GLEnvironmentUtil", "eglCreateWindowSurface", new Object[] { paramEGLContext });
            paramEGLContext = null;
            continue;
            label491:
            yR("eglCreatePbufferSurface");
          }
        }
      }
    }
    
    public static c.b a(Surface paramSurface, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(217539);
      ae.i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + paramSurface + ", surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramSurface = (Throwable)new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(217539);
        throw paramSurface;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramSurface = (Throwable)new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.o(217539);
        throw paramSurface;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        EGL14.eglChooseConfig(localEGLDisplay, c.auu(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        yR("eglCreateContext RGB888+recordable ES2");
        int i = ay.aRW("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
        localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
        yR("eglCreateContext");
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          break label380;
        }
        paramEGLContext = new int[5];
        paramEGLContext[0] = 12375;
        paramEGLContext[1] = paramInt1;
        paramEGLContext[2] = 12374;
        paramEGLContext[3] = paramInt2;
        paramEGLContext[4] = 12344;
        label274:
        if (paramSurface == null) {
          break label395;
        }
        paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurface, paramEGLContext, 0);
        label292:
        if (paramSurface == null) {
          break label432;
        }
        yR("eglCreateWindowSurface");
      }
      for (;;)
      {
        if (paramSurfaceTexture != null)
        {
          EGL14.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
          yR("eglMakeCurrent");
        }
        p.g(localEGLDisplay, "mEGLDisplay");
        p.g(localObject, "mEGLContext");
        paramSurface = new c.b(localEGLDisplay, paramSurfaceTexture, (EGLContext)localObject);
        AppMethodBeat.o(217539);
        return paramSurface;
        EGL14.eglChooseConfig(localEGLDisplay, c.auu(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        break;
        label380:
        paramEGLContext = new int[1];
        paramEGLContext[0] = 12344;
        break label274;
        label395:
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurfaceTexture, paramEGLContext, 0);
          break label292;
        }
        paramSurfaceTexture = EGL14.eglCreatePbufferSurface(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, 0);
        break label292;
        label432:
        yR("eglCreatePbufferSurface");
      }
    }
    
    public static void a(a parama, d paramd, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93877);
      if (parama == null)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "fbo is null !");
        AppMethodBeat.o(93877);
        return;
      }
      if (paramd == null)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "texture is null");
        AppMethodBeat.o(93877);
        return;
      }
      GLES30.glBindFramebuffer(36160, parama.hmV);
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        d.a(paramd, paramInt1, paramInt2, 0, null, 0, 0, 60);
      }
      GLES30.glFramebufferTexture2D(36160, 36064, 3553, paramd.hnc, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(93877);
    }
    
    public static void a(c.b paramb)
    {
      AppMethodBeat.i(93881);
      p.h(paramb, "eglEnvironment");
      if (paramb.eglSurface != EGL14.EGL_NO_DISPLAY)
      {
        localObject = paramb.hrE;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(paramb.hrE, paramb.eglSurface);
        EGL14.eglDestroyContext(paramb.hrE, paramb.hrF);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(paramb.hrE);
      }
      Object localObject = EGL14.EGL_NO_DISPLAY;
      p.g(localObject, "EGL14.EGL_NO_DISPLAY");
      paramb.a((EGLDisplay)localObject);
      localObject = EGL14.EGL_NO_CONTEXT;
      p.g(localObject, "EGL14.EGL_NO_CONTEXT");
      paramb.a((EGLContext)localObject);
      paramb.eglSurface = EGL14.EGL_NO_SURFACE;
      AppMethodBeat.o(93881);
    }
    
    public static boolean a(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(93880);
      if ((paramEGLDisplay == null) || (paramEGLSurface == null))
      {
        AppMethodBeat.o(93880);
        return false;
      }
      boolean bool = EGL14.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
      yR("eglSwapBuffers");
      AppMethodBeat.o(93880);
      return bool;
    }
    
    private static boolean aA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93882);
      p.h(paramString1, "msg");
      p.h(paramString2, "tag");
      int i = EGL14.eglGetError();
      if (i != 12288)
      {
        ae.m(paramString2, paramString1 + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
        AppMethodBeat.o(93882);
        return true;
      }
      AppMethodBeat.o(93882);
      return false;
    }
    
    private static int aa(String paramString, int paramInt)
    {
      AppMethodBeat.i(93874);
      p.h(paramString, "shaderSource");
      int[] arrayOfInt = new int[1];
      paramInt = GLES30.glCreateShader(paramInt);
      GLES30.glShaderSource(paramInt, paramString);
      GLES30.glCompileShader(paramInt);
      GLES30.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] == 0)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: " + GLES30.glGetShaderInfoLog(paramInt));
        AppMethodBeat.o(93874);
        return 0;
      }
      AppMethodBeat.o(93874);
      return paramInt;
    }
    
    public static void auv()
    {
      AppMethodBeat.i(93876);
      GLES30.glClear(16640);
      GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES30.glBindFramebuffer(36160, 0);
      AppMethodBeat.o(93876);
    }
    
    public static int auw()
    {
      AppMethodBeat.i(164119);
      int[] arrayOfInt = new int[1];
      GLES30.glGenTextures(1, arrayOfInt, 0);
      GLES30.glBindTexture(3553, arrayOfInt[0]);
      GLES30.glTexParameteri(3553, 10241, 9729);
      GLES30.glTexParameteri(3553, 10240, 9728);
      GLES30.glTexParameteri(3553, 10242, 33071);
      GLES30.glTexParameteri(3553, 10243, 33071);
      GLES30.glBindTexture(3553, 0);
      yS("genTexture");
      int i = arrayOfInt[0];
      AppMethodBeat.o(164119);
      return i;
    }
    
    public static int az(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93875);
      p.h(paramString1, "vertexShaderSource");
      p.h(paramString2, "fragmentShaderSource");
      int[] arrayOfInt = new int[1];
      int i = aa(paramString1, 35633);
      if (i == 0)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      int j = aa(paramString2, 35632);
      if (j == 0)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      int k = GLES30.glCreateProgram();
      GLES30.glAttachShader(k, i);
      GLES30.glAttachShader(k, j);
      GLES30.glLinkProgram(k);
      GLES30.glGetProgramiv(k, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] <= 0)
      {
        ae.e("MicroMsg.GLEnvironmentUtil", "link program failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      GLES30.glDeleteShader(i);
      GLES30.glDeleteShader(j);
      AppMethodBeat.o(93875);
      return k;
    }
    
    public static void b(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(164120);
      p.h(paramBitmap, "bitmap");
      GLES30.glBindTexture(3553, paramInt);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(164120);
    }
    
    public static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217542);
      p.h(paramArrayOfFloat, "textureCoords");
      float f = paramArrayOfFloat[paramInt1];
      paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
      paramArrayOfFloat[paramInt2] = f;
      AppMethodBeat.o(217542);
    }
    
    public static void yS(String paramString)
    {
      AppMethodBeat.i(93884);
      int i = GLES30.glGetError();
      if (i != 0) {
        ae.m("MicroMsg.GLEnvironmentUtil", paramString + ": GL error: 0x" + Integer.toHexString(i), new Object[0]);
      }
      AppMethodBeat.o(93884);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"})
  public static final class b
  {
    public EGLSurface eglSurface;
    public EGLDisplay hrE;
    public EGLContext hrF;
    
    public b(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93889);
      this.hrE = paramEGLDisplay;
      this.eglSurface = paramEGLSurface;
      this.hrF = paramEGLContext;
      AppMethodBeat.o(93889);
    }
    
    public final void a(EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93888);
      p.h(paramEGLContext, "<set-?>");
      this.hrF = paramEGLContext;
      AppMethodBeat.o(93888);
    }
    
    public final void a(EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(93886);
      p.h(paramEGLDisplay, "<set-?>");
      this.hrE = paramEGLDisplay;
      AppMethodBeat.o(93886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.k.c
 * JD-Core Version:    0.7.0.1
 */