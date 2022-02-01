package com.tencent.mm.media.util;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/GLEnvironmentUtil;", "", "()V", "Companion", "EGLEnvironment", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final int[] nFA;
  public static final a nFs;
  public static final float[] nFt;
  public static final float[] nFu;
  public static final float[] nFv;
  private static final int[] nFw;
  private static final int[] nFx;
  private static final int[] nFy;
  private static final int[] nFz;
  
  static
  {
    AppMethodBeat.i(93890);
    nFs = new a((byte)0);
    nFt = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    nFu = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    nFv = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    nFw = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    nFx = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, 12610, 1, 12344 };
    nFy = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 };
    nFz = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 };
    nFA = new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 };
    AppMethodBeat.o(93890);
  }
  
  public static final void bqi()
  {
    AppMethodBeat.i(93891);
    a.bqi();
    AppMethodBeat.o(93891);
  }
  
  public static final void e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(236930);
    s.u(paramArrayOfFloat, "textureCoords");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236930);
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
      AppMethodBeat.o(236930);
      return;
      a.swap(paramArrayOfFloat, 0, 6);
      a.swap(paramArrayOfFloat, 1, 7);
      a.swap(paramArrayOfFloat, 2, 4);
      a.swap(paramArrayOfFloat, 3, 5);
      AppMethodBeat.o(236930);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "DEFAULT_EGL_CONTEXT_CLIENT_VERSION", "", "EGL_RECORDABLE_ANDROID", "HAS_REPORTED_EGL_VERSION", "", "MMKV_GL_KEY", "ROTATION_180", "ROTATION_270", "ROTATION_90", "SUPPORT_EGL_CONTEXT_CLIENT_VERSION", "TAG", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "commonEGLAttributeListWithoutRecordable", "pBufferEGLAttributeList", "shareEGLSurfaceTypeAttributeList", "getShareEGLSurfaceTypeAttributeList", "()[I", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "texture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "deleteFrameBuffer", "deleteTexture", "deleteTextures", "textures", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglBindSurface", "mEGLContext", "mEGLDisplay", "mSurface", "eglCreateBufferSurface", "Landroid/opengl/EGLSurface;", "eglCreateSurface", "eglReleaseSurface", "eglEnvironment", "backupSurface", "eglSetupByPbufferSurface", "shareEGLContext", "eglSetupByShareGLContext", "mShareGLContext", "eglSetupBySurface", "Landroid/view/Surface;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "eglSetupWithoutSurface", "eglUnbindSurface", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "eglDisplay", "resolveMirror", "textureCoords", "resolveRotate", "rotation", "saveExternalTexture", "saveGLPixels", "saveTexture", "saveTextureExternal", "saveTextureWithRGB", "setupDeviceSupportGLVersion", "context", "Landroid/content/Context;", "swap", "prevIndex", "afterIndex", "swapBuffers", "uploadBitmapTexture", "texName", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void GS(String paramString)
    {
      AppMethodBeat.i(93884);
      int i = GLES30.glGetError();
      if (i != 0) {
        Log.printInfoStack("MicroMsg.GLEnvironmentUtil", paramString + ": GL error: 0x" + Integer.toHexString(i), new Object[0]);
      }
      AppMethodBeat.o(93884);
    }
    
    public static EGLSurface a(EGLDisplay paramEGLDisplay, Object paramObject)
    {
      AppMethodBeat.i(237138);
      s.u(paramEGLDisplay, "mEGLDisplay");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(paramEGLDisplay, c.bqj(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      paramEGLDisplay = EGL14.eglCreateWindowSurface(paramEGLDisplay, arrayOfEGLConfig[0], paramObject, new int[] { 12344 }, 0);
      s.s(paramEGLDisplay, "eglCreateWindowSurface(m…rayOf(EGL14.EGL_NONE), 0)");
      AppMethodBeat.o(237138);
      return paramEGLDisplay;
    }
    
    private static c.b a(int paramInt1, int paramInt2, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(236997);
      Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupByPbufferSurface, width:" + paramInt1 + ", height:" + paramInt2);
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(236997);
        throw paramEGLContext;
      }
      Object localObject1 = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1))
      {
        paramEGLContext = new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.o(236997);
        throw paramEGLContext;
      }
      localObject1 = new EGLConfig[1];
      Object localObject2 = new int[1];
      EGL14.eglChooseConfig(localEGLDisplay, c.bqj(), 0, (EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
      GR("eglCreateContext RGB888+recordable ES2");
      int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
      localObject2 = EGL14.eglCreateContext(localEGLDisplay, localObject1[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
      GR("eglCreateContext");
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
        paramEGLContext = EGL14.eglCreatePbufferSurface(localEGLDisplay, localObject1[0], paramEGLContext, 0);
        GR("eglCreatePbufferSurface");
        if (paramEGLContext != null)
        {
          EGL14.eglMakeCurrent(localEGLDisplay, paramEGLContext, paramEGLContext, (EGLContext)localObject2);
          GR("eglMakeCurrent");
        }
        s.s(localEGLDisplay, "mEGLDisplay");
        s.s(localObject2, "mEGLContext");
        paramEGLContext = new c.b(localEGLDisplay, paramEGLContext, (EGLContext)localObject2);
        AppMethodBeat.o(236997);
        return paramEGLContext;
        paramEGLContext = new int[1];
        paramEGLContext[0] = 12344;
      }
    }
    
    private static c.b a(EGLContext paramEGLContext)
    {
      AppMethodBeat.i(237059);
      Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupWithoutSurface");
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(237059);
        throw paramEGLContext;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramEGLContext = new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.o(237059);
        throw paramEGLContext;
      }
      localObject = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(localEGLDisplay, c.bqk(), 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
      GR("eglCreateContext RGB888+recordable ES2");
      int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
      paramEGLContext = EGL14.eglCreateContext(localEGLDisplay, localObject[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
      GR("eglCreateContext");
      localObject = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject, (EGLSurface)localObject, paramEGLContext);
      GR("eglMakeCurrent");
      s.s(localEGLDisplay, "mEGLDisplay");
      localObject = EGL14.EGL_NO_SURFACE;
      s.s(paramEGLContext, "mEGLContext");
      paramEGLContext = new c.b(localEGLDisplay, (EGLSurface)localObject, paramEGLContext);
      AppMethodBeat.o(237059);
      return paramEGLContext;
    }
    
    public static c.b a(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Object paramObject)
    {
      AppMethodBeat.i(236976);
      s.u(paramEGLContext, "mEGLContext");
      s.u(paramEGLDisplay, "mEGLDisplay");
      Log.i("MicroMsg.GLEnvironmentUtil", "eglBind Surface");
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGL14.eglChooseConfig(paramEGLDisplay, c.bqj(), 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
      paramObject = EGL14.eglCreateWindowSurface(paramEGLDisplay, arrayOfEGLConfig[0], paramObject, new int[] { 12344 }, 0);
      GR("eglCreateWindowSurface");
      EGL14.eglMakeCurrent(paramEGLDisplay, paramObject, paramObject, paramEGLContext);
      GR("eglMakeCurrent");
      paramEGLContext = new c.b(paramEGLDisplay, paramObject, paramEGLContext);
      AppMethodBeat.o(236976);
      return paramEGLContext;
    }
    
    public static c.b a(EGLContext paramEGLContext, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93885);
      s.u(paramEGLContext, "eglContext");
      Log.i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
      if ((paramObject != null) && (!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceHolder)))
      {
        paramEGLContext = new IllegalArgumentException("unsupported surface");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramEGLContext = new RuntimeException("eglInitialize failed");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      EGL14.eglChooseConfig(localEGLDisplay, c.bqj(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
      if (arrayOfEGLConfig[0] == null)
      {
        paramEGLContext = new RuntimeException("chooseConfig failed");
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
      localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, new int[] { 12440, i, 12344 }, 0);
      if (s.p(localObject, EGL14.EGL_NO_CONTEXT))
      {
        paramEGLContext = new RuntimeException(s.X("EGL error ", Integer.valueOf(EGL14.eglGetError())));
        AppMethodBeat.o(93885);
        throw paramEGLContext;
      }
      GR("eglCreateContext");
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
              break label482;
            }
            GR("eglCreateWindowSurface");
            if (((paramEGLContext == null) || (paramEGLContext == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
              Log.e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
            }
            if (paramEGLContext != null)
            {
              EGL14.eglMakeCurrent(localEGLDisplay, paramEGLContext, paramEGLContext, (EGLContext)localObject);
              GR("eglMakeCurrent");
            }
            s.s(localEGLDisplay, "eglDisplay");
            s.checkNotNull(paramEGLContext);
            s.s(localObject, "outputEGLContext");
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
            label482:
            GR("eglCreatePbufferSurface");
          }
        }
      }
    }
    
    public static c.b a(Surface paramSurface, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(237030);
      Log.i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + paramSurface + ", surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
      EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
      if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
      {
        paramSurface = new RuntimeException("unable to get EGL14 display");
        AppMethodBeat.o(237030);
        throw paramSurface;
      }
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(localEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        paramSurface = new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.o(237030);
        throw paramSurface;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      localObject = new int[1];
      if ((paramSurface != null) || (paramSurfaceTexture != null))
      {
        EGL14.eglChooseConfig(localEGLDisplay, c.bqj(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        GR("eglCreateContext RGB888+recordable ES2");
        int i = MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3);
        int[] arrayOfInt = new int[3];
        arrayOfInt[0] = 12440;
        arrayOfInt[1] = i;
        arrayOfInt[2] = 12344;
        EGLContext localEGLContext = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, arrayOfInt, 0);
        GR("eglCreateContext");
        localObject = localEGLContext;
        if (s.p(localEGLContext, EGL14.EGL_NO_CONTEXT))
        {
          Log.e("MicroMsg.GLEnvironmentUtil", "create " + i + " EGL context failed");
          localObject = localEGLContext;
          if (i == 3)
          {
            Log.i("MicroMsg.GLEnvironmentUtil", "retry create EGL 2.0 context");
            arrayOfInt[1] = 2;
            localObject = EGL14.eglCreateContext(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, arrayOfInt, 0);
            GR("eglCreateContext fallback");
          }
        }
        if (!s.p(localObject, EGL14.EGL_NO_CONTEXT))
        {
          paramEGLContext = f.nFE;
          f.bqD();
        }
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          break label490;
        }
        paramEGLContext = new int[5];
        paramEGLContext[0] = 12375;
        paramEGLContext[1] = paramInt1;
        paramEGLContext[2] = 12374;
        paramEGLContext[3] = paramInt2;
        paramEGLContext[4] = 12344;
        label384:
        if (paramSurface == null) {
          break label505;
        }
        paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurface, paramEGLContext, 0);
        label402:
        if (paramSurface == null) {
          break label542;
        }
        GR("eglCreateWindowSurface");
      }
      for (;;)
      {
        if (paramSurfaceTexture != null)
        {
          EGL14.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
          GR("eglMakeCurrent");
        }
        s.s(localEGLDisplay, "mEGLDisplay");
        s.s(localObject, "mEGLContext");
        paramSurface = new c.b(localEGLDisplay, paramSurfaceTexture, (EGLContext)localObject);
        AppMethodBeat.o(237030);
        return paramSurface;
        EGL14.eglChooseConfig(localEGLDisplay, c.bqj(), 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0);
        break;
        label490:
        paramEGLContext = new int[1];
        paramEGLContext[0] = 12344;
        break label384;
        label505:
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture = EGL14.eglCreateWindowSurface(localEGLDisplay, arrayOfEGLConfig[0], paramSurfaceTexture, paramEGLContext, 0);
          break label402;
        }
        paramSurfaceTexture = EGL14.eglCreatePbufferSurface(localEGLDisplay, arrayOfEGLConfig[0], paramEGLContext, 0);
        break label402;
        label542:
        GR("eglCreatePbufferSurface");
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
      GLES30.glBindFramebuffer(36160, parama.nAy);
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        d.a(paramd, paramInt1, paramInt2, 0, null, 0, 0, 60);
      }
      GLES30.glFramebufferTexture2D(36160, 36064, 3553, paramd.nAF, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(93877);
    }
    
    public static void a(c.b paramb)
    {
      AppMethodBeat.i(93881);
      if (paramb == null)
      {
        AppMethodBeat.o(93881);
        return;
      }
      if (paramb.eglSurface != EGL14.EGL_NO_DISPLAY)
      {
        localObject = paramb.nFB;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(paramb.nFB, paramb.eglSurface);
        EGL14.eglDestroyContext(paramb.nFB, paramb.eXL);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(paramb.nFB);
      }
      Object localObject = EGL14.EGL_NO_DISPLAY;
      s.s(localObject, "EGL_NO_DISPLAY");
      paramb.a((EGLDisplay)localObject);
      localObject = EGL14.EGL_NO_CONTEXT;
      s.s(localObject, "EGL_NO_CONTEXT");
      paramb.b((EGLContext)localObject);
      paramb.eglSurface = EGL14.EGL_NO_SURFACE;
      AppMethodBeat.o(93881);
    }
    
    public static void a(c.b paramb, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(236983);
      s.u(paramEGLSurface, "backupSurface");
      if (paramb != null)
      {
        Log.i("MicroMsg.GLEnvironmentUtil", "eglUnbindSurface");
        EGL14.eglDestroySurface(paramb.nFB, paramb.eglSurface);
        EGL14.eglMakeCurrent(paramb.nFB, paramEGLSurface, paramEGLSurface, paramb.eXL);
      }
      AppMethodBeat.o(236983);
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
      GR("eglSwapBuffers");
      AppMethodBeat.o(93880);
      return bool;
    }
    
    private static int aD(String paramString, int paramInt)
    {
      AppMethodBeat.i(93874);
      s.u(paramString, "shaderSource");
      int[] arrayOfInt = new int[1];
      paramInt = GLES30.glCreateShader(paramInt);
      GLES30.glShaderSource(paramInt, paramString);
      GLES30.glCompileShader(paramInt);
      GLES30.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] == 0)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", s.X("loadShader error, infoLog: ", GLES30.glGetShaderInfoLog(paramInt)));
        AppMethodBeat.o(93874);
        return 0;
      }
      AppMethodBeat.o(93874);
      return paramInt;
    }
    
    public static int aN(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93875);
      s.u(paramString1, "vertexShaderSource");
      s.u(paramString2, "fragmentShaderSource");
      int[] arrayOfInt = new int[1];
      int i = aD(paramString1, 35633);
      if (i == 0)
      {
        Log.e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
        AppMethodBeat.o(93875);
        return 0;
      }
      int j = aD(paramString2, 35632);
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
    
    public static boolean aO(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93882);
      s.u(paramString1, "msg");
      s.u(paramString2, "tag");
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
    
    public static Bitmap ad(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(237097);
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
      s.s(localBitmap, "bitmap");
      AppMethodBeat.o(237097);
      return localBitmap;
    }
    
    public static void bqi()
    {
      AppMethodBeat.i(93876);
      GLES30.glClear(16640);
      GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES30.glBindFramebuffer(36160, 0);
      AppMethodBeat.o(93876);
    }
    
    public static int bql()
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
      GS("genTexture");
      int i = arrayOfInt[0];
      AppMethodBeat.o(164119);
      return i;
    }
    
    public static void c(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(164120);
      s.u(paramBitmap, "bitmap");
      GLES30.glBindTexture(3553, paramInt);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES30.glBindTexture(3553, 0);
      AppMethodBeat.o(164120);
    }
    
    public static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(237158);
      s.u(paramArrayOfFloat, "textureCoords");
      float f = paramArrayOfFloat[paramInt1];
      paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
      paramArrayOfFloat[paramInt2] = f;
      AppMethodBeat.o(237158);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public EGLContext eXL;
    public EGLSurface eglSurface;
    public EGLDisplay nFB;
    
    public b(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93889);
      this.nFB = paramEGLDisplay;
      this.eglSurface = paramEGLSurface;
      this.eXL = paramEGLContext;
      AppMethodBeat.o(93889);
    }
    
    public final void a(EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(93886);
      s.u(paramEGLDisplay, "<set-?>");
      this.nFB = paramEGLDisplay;
      AppMethodBeat.o(93886);
    }
    
    public final void b(EGLContext paramEGLContext)
    {
      AppMethodBeat.i(93888);
      s.u(paramEGLContext, "<set-?>");
      this.eXL = paramEGLContext;
      AppMethodBeat.o(93888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.util.c
 * JD-Core Version:    0.7.0.1
 */