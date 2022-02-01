package com.tencent.mm.media.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/GLEnvironmentUtil;", "", "()V", "Companion", "EGLEnvironment", "plugin-mediaeditor_release"})
public final class c
{
  public static final float[] ilm;
  public static final float[] iln;
  public static final float[] ilo;
  private static final int[] ilp;
  private static final int[] ilq;
  private static final int[] ilr;
  private static final int[] ils;
  public static final a ilt;
  
  static
  {
    AppMethodBeat.i(93890);
    ilt = new a((byte)0);
    ilm = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    iln = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    ilo = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    ilp = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    ilq = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, 12610, 1, 12344 };
    ilr = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 };
    ils = new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 };
    AppMethodBeat.o(93890);
  }
  
  public static final void aMY()
  {
    AppMethodBeat.i(93891);
    a.aMY();
    AppMethodBeat.o(93891);
  }
  
  public static final void e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218795);
    a.e(paramInt, paramArrayOfFloat);
    AppMethodBeat.o(218795);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "DEFAULT_EGL_CONTEXT_CLIENT_VERSION", "", "EGL_RECORDABLE_ANDROID", "HAS_REPORTED_EGL_VERSION", "", "MMKV_GL_KEY", "ROTATION_180", "ROTATION_270", "ROTATION_90", "SUPPORT_EGL_CONTEXT_CLIENT_VERSION", "TAG", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "shareEGLSurfaceTypeAttributeList", "getShareEGLSurfaceTypeAttributeList", "()[I", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "texture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "deleteFrameBuffer", "deleteTexture", "deleteTextures", "textures", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglBindSurface", "mEGLContext", "mEGLDisplay", "mSurface", "eglCreateSurface", "Landroid/opengl/EGLSurface;", "eglSetupByShareGLContext", "mShareGLContext", "eglSetupBySurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "shareEGLContext", "eglSetupWithoutSurface", "eglUnbindSurface", "eglEnvironment", "backupSurface", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "eglDisplay", "resolveMirror", "textureCoords", "resolveRotate", "rotation", "saveExternalTexture", "saveGLPixels", "saveTexture", "saveTextureExternal", "setupDeviceSupportGLVersion", "context", "Landroid/content/Context;", "swap", "prevIndex", "afterIndex", "swapBuffers", "uploadBitmapTexture", "texName", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static void Hr(String paramString)
    {
      AppMethodBeat.i(93884);
      int i = GLES30.glGetError();
      if (i != 0) {
        Log.printInfoStack("MicroMsg.GLEnvironmentUtil", paramString + ": GL error: 0x" + Integer.toHexString(i), new Object[0]);
      }
      AppMethodBeat.o(93884);
    }
    
    public static Bitmap L(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(218791);
      int[] arrayOfInt = new int[1];
      GLES30.glGenFramebuffers(1, arrayOfInt, 0);
      GLES30.glBindFramebuffer(36160, arrayOfInt[0]);
      GLES30.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
      GLES30.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localByteBuffer);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer((Buffer)localByteBuffer);
      GLES30.glBindFramebuffer(36160, 0);
      GLES30.glDeleteFramebuffers(1, arrayOfInt, 0);
      p.g(localBitmap, "bitmap");
      AppMethodBeat.o(218791);
      return localBitmap;
    }
    
    public static EGLSurface a(EGLDisplay paramEGLDisplay, Object paramObject)
    {
      AppMethodBeat.i(218792);
      p.h(paramEGLDisplay, "mEGLDisplay");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(paramEGLDisplay, c.aMW(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      paramEGLDisplay = EGL14.eglCreateWindowSurface(paramEGLDisplay, arrayOfEGLConfig[0], paramObject, new int[] { 12344 }, 0);
      p.g(paramEGLDisplay, "EGL14.eglCreateWindowSur…rayOf(EGL14.EGL_NONE), 0)");
      AppMethodBeat.o(218792);
      return paramEGLDisplay;
    }
    
    public static c.b a(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Object paramObject)
    {
      AppMethodBeat.i(218786);
      p.h(paramEGLContext, "mEGLContext");
      p.h(paramEGLDisplay, "mEGLDisplay");
      Log.i("MicroMsg.GLEnvironmentUtil", "eglBind Surface");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(paramEGLDisplay, c.aMW(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      paramObject = EGL14.eglCreateWindowSurface(paramEGLDisplay, arrayOfEGLConfig[0], paramObject, new int[] { 12344 }, 0);
      Hq("eglCreateWindowSurface");
      EGL14.eglMakeCurrent(paramEGLDisplay, paramObject, paramObject, paramEGLContext);
      Hq("eglMakeCurrent");
      paramEGLContext = new c.b(paramEGLDisplay, paramObject, paramEGLContext);
      AppMethodBeat.o(218786);
      return paramEGLContext;
    }
    
    public static c.b a(EGLContext paramEGLContext, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93885);
      p.h(paramEGLContext, "eglContext");
      Log.i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
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
      EGL14.eglChooseConfig(localEGLDisplay, c.aMW(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
      if (arrayOfEGLConfig[0] == null)
      {
        paramEGLContext = (Throwable)new RuntimeException("chooseConfig failed");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
      localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
      if (p.j(localObject, EGL14.EGL_NO_CONTEXT))
      {
        paramEGLContext = (Throwable)new RuntimeException("EGL error " + EGL14.eglGetError());
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      Hq("eglCreateContext");
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
              break label508;
            }
            Hq("eglCreateWindowSurface");
            if (((paramEGLContext == null) || (paramEGLContext == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
              Log.e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
            }
            if (paramEGLContext != null)
            {
              EGL14.eglMakeCurrent(localEGLDisplay, paramEGLContext, paramEGLContext, (EGLContext)localObject);
              Hq("eglMakeCurrent");
            }
            p.g(localEGLDisplay, "eglDisplay");
            if (paramEGLContext == null) {
              p.hyc();
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
            Log.e("MicroMsg.GLEnvironmentUtil", "eglCreateWindowSurface", new Object[] { paramEGLContext });
            paramEGLContext = null;
            continue;
            label508:
            Hq("eglCreatePbufferSurface");
          }
        }
      }
    }
    
    public static c.b a(Surface paramSurface, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(218788);
      Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + paramSurface + ", surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramSurface = (Throwable)new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(218788);
        throw paramSurface;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramSurface = (Throwable)new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.o(218788);
        throw paramSurface;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        EGL14.eglChooseConfig(localEGLDisplay, c.aMW(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        Hq("eglCreateContext RGB888+recordable ES2");
        int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
        localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
        Hq("eglCreateContext");
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          break label384;
        }
        paramEGLContext = new int[5];
        paramEGLContext[0] = 12375;
        paramEGLContext[1] = paramInt1;
        paramEGLContext[2] = 12374;
        paramEGLContext[3] = paramInt2;
        paramEGLContext[4] = 12344;
        label278:
        if (paramSurface == null) {
          break label399;
        }
        paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurface, paramEGLContext, 0);
        label296:
        if (paramSurface == null) {
          break label436;
        }
        Hq("eglCreateWindowSurface");
      }
      for (;;)
      {
        if (paramSurfaceTexture != null)
        {
          EGL14.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
          Hq("eglMakeCurrent");
        }
        p.g(localEGLDisplay, "mEGLDisplay");
        p.g(localObject, "mEGLContext");
        paramSurface = new c.b(localEGLDisplay, paramSurfaceTexture, (EGLContext)localObject);
        AppMethodBeat.o(218788);
        return paramSurface;
        EGL14.eglChooseConfig(localEGLDisplay, c.aMW(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        break;
        label384:
        paramEGLContext = new int[1];
        paramEGLContext[0] = 12344;
        break label278;
        label399:
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurfaceTexture, paramEGLContext, 0);
          break label296;
        }
        paramSurfaceTexture = EGL14.eglCreatePbufferSurface(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, 0);
        break label296;
        label436:
        Hq("eglCreatePbufferSurface");
      }
    }
    
    public static void a(a parama, d paramd, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93877);
      if (parama == null)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", "fbo is null !");
        AppMethodBeat.o(93877);
        return;
      }
      if (paramd == null)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", "texture is null");
        AppMethodBeat.o(93877);
        return;
      }
      GLES30.glBindFramebuffer(36160, parama.igo);
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        d.a(paramd, paramInt1, paramInt2, 0, null, 0, 0, 60);
      }
      GLES30.glFramebufferTexture2D(36160, 36064, 3553, paramd.igv, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(93877);
    }
    
    public static void a(c.b paramb)
    {
      AppMethodBeat.i(93881);
      p.h(paramb, "eglEnvironment");
      if (paramb.eglSurface != EGL14.EGL_NO_DISPLAY)
      {
        localObject = paramb.ilu;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(paramb.ilu, paramb.eglSurface);
        EGL14.eglDestroyContext(paramb.ilu, paramb.ilv);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(paramb.ilu);
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
    
    public static void a(c.b paramb, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(218787);
      p.h(paramEGLSurface, "backupSurface");
      if (paramb != null)
      {
        Log.i("MicroMsg.GLEnvironmentUtil", "eglUnbindSurface");
        EGL14.eglDestroySurface(paramb.ilu, paramb.eglSurface);
        EGL14.eglMakeCurrent(paramb.ilu, paramEGLSurface, paramEGLSurface, paramb.ilv);
      }
      AppMethodBeat.o(218787);
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
      Hq("eglSwapBuffers");
      AppMethodBeat.o(93880);
      return bool;
    }
    
    public static int aB(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93875);
      p.h(paramString1, "vertexShaderSource");
      p.h(paramString2, "fragmentShaderSource");
      int[] arrayOfInt = new int[1];
      int i = ac(paramString1, 35633);
      if (i == 0)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      int j = ac(paramString2, 35632);
      if (j == 0)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
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
        Log.e("MicroMsg.GLEnvironmentUtil", "link program failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      GLES30.glDeleteShader(i);
      GLES30.glDeleteShader(j);
      AppMethodBeat.o(93875);
      return k;
    }
    
    private static boolean aC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93882);
      p.h(paramString1, "msg");
      p.h(paramString2, "tag");
      int i = EGL14.eglGetError();
      if (i != 12288)
      {
        Log.printInfoStack(paramString2, paramString1 + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
        AppMethodBeat.o(93882);
        return true;
      }
      AppMethodBeat.o(93882);
      return false;
    }
    
    public static void aMY()
    {
      AppMethodBeat.i(93876);
      GLES30.glClear(16640);
      GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES30.glBindFramebuffer(36160, 0);
      AppMethodBeat.o(93876);
    }
    
    public static int aMZ()
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
      Hr("genTexture");
      int i = arrayOfInt[0];
      AppMethodBeat.o(164119);
      return i;
    }
    
    private static int ac(String paramString, int paramInt)
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
        Log.e("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: " + GLES30.glGetShaderInfoLog(paramInt));
        AppMethodBeat.o(93874);
        return 0;
      }
      AppMethodBeat.o(93874);
      return paramInt;
    }
    
    public static void c(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(164120);
      p.h(paramBitmap, "bitmap");
      GLES30.glBindTexture(3553, paramInt);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(164120);
    }
    
    public static void e(int paramInt, float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(218793);
      p.h(paramArrayOfFloat, "textureCoords");
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(218793);
        return;
        float f1 = paramArrayOfFloat[0];
        float f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = paramArrayOfFloat[4];
        paramArrayOfFloat[1] = paramArrayOfFloat[5];
        paramArrayOfFloat[4] = paramArrayOfFloat[6];
        paramArrayOfFloat[5] = paramArrayOfFloat[7];
        paramArrayOfFloat[6] = paramArrayOfFloat[2];
        paramArrayOfFloat[7] = paramArrayOfFloat[3];
        paramArrayOfFloat[2] = f1;
        paramArrayOfFloat[3] = f2;
        AppMethodBeat.o(218793);
        return;
        swap(paramArrayOfFloat, 0, 6);
        swap(paramArrayOfFloat, 1, 7);
        swap(paramArrayOfFloat, 2, 4);
        swap(paramArrayOfFloat, 3, 5);
        AppMethodBeat.o(218793);
        return;
        f1 = paramArrayOfFloat[0];
        f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = paramArrayOfFloat[2];
        paramArrayOfFloat[1] = paramArrayOfFloat[3];
        paramArrayOfFloat[2] = paramArrayOfFloat[6];
        paramArrayOfFloat[3] = paramArrayOfFloat[7];
        paramArrayOfFloat[6] = paramArrayOfFloat[4];
        paramArrayOfFloat[7] = paramArrayOfFloat[5];
        paramArrayOfFloat[4] = f1;
        paramArrayOfFloat[5] = f2;
      }
    }
    
    private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(218794);
      p.h(paramArrayOfFloat, "textureCoords");
      float f = paramArrayOfFloat[paramInt1];
      paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
      paramArrayOfFloat[paramInt2] = f;
      AppMethodBeat.o(218794);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"})
  public static final class b
  {
    public EGLSurface eglSurface;
    public EGLDisplay ilu;
    public EGLContext ilv;
    
    public b(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93889);
      this.ilu = paramEGLDisplay;
      this.eglSurface = paramEGLSurface;
      this.ilv = paramEGLContext;
      AppMethodBeat.o(93889);
    }
    
    public final void a(EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93888);
      p.h(paramEGLContext, "<set-?>");
      this.ilv = paramEGLContext;
      AppMethodBeat.o(93888);
    }
    
    public final void a(EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(93886);
      p.h(paramEGLDisplay, "<set-?>");
      this.ilu = paramEGLDisplay;
      AppMethodBeat.o(93886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.k.c
 * JD-Core Version:    0.7.0.1
 */