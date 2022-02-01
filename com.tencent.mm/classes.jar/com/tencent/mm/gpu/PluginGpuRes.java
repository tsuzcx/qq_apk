package com.tencent.mm.gpu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.gpu.service.GpuHookService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mmkv.MMKV;
import com.tencent.wxperf.jni.egl.EglHook;

public class PluginGpuRes
  extends f
  implements o, com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c
{
  private static int hiP = 0;
  private static boolean hiQ = false;
  public static boolean hiS = false;
  private static boolean isFront = true;
  private String[] hiO;
  private boolean hiR;
  private EGLConfig hiT;
  private EGLContext hiU;
  private EGLSurface hiV;
  private IListener hiW;
  private EGLDisplay mEGLDisplay;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(186137);
    this.hiO = new String[] { com.tencent.mm.gpu.b.a.hiY, com.tencent.mm.gpu.b.a.hja, com.tencent.mm.gpu.b.a.hjb };
    this.hiR = false;
    this.hiW = new IListener() {};
    AppMethodBeat.o(186137);
  }
  
  public static int getCurrSpend()
  {
    return hiP / 60000;
  }
  
  private void handleEGLHookReport(MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(186142);
    hiS = false;
    boolean bool1 = paramMultiProcessMMKV.getBoolean("eglCreateContext_status", false);
    boolean bool2 = paramMultiProcessMMKV.getBoolean("eglCreateSurface_status", false);
    boolean bool3 = paramMultiProcessMMKV.getBoolean("eglDestroySurface_status", false);
    boolean bool4 = paramMultiProcessMMKV.getBoolean("eglDestroyContext_status", false);
    if (bool1)
    {
      com.tencent.mm.gpu.e.c.axp();
      Log.e("Gpu.PluginGpuRes", "hook EGL create context success");
      if (!bool2) {
        break label120;
      }
      com.tencent.mm.gpu.e.c.axp();
      Log.e("Gpu.PluginGpuRes", "hook EGL create surface success");
      label71:
      if (!bool3) {
        break label133;
      }
      com.tencent.mm.gpu.e.c.axp();
      Log.e("Gpu.PluginGpuRes", "hook EGL destroy context success");
    }
    for (;;)
    {
      if (!bool4) {
        break label146;
      }
      com.tencent.mm.gpu.e.c.axp();
      Log.e("Gpu.PluginGpuRes", "hook EGL destroy surface success");
      AppMethodBeat.o(186142);
      return;
      com.tencent.mm.gpu.e.c.axq();
      Log.e("Gpu.PluginGpuRes", "hook EGL create context fail");
      break;
      label120:
      com.tencent.mm.gpu.e.c.axq();
      Log.e("Gpu.PluginGpuRes", "hook EGL create surface fail");
      break label71;
      label133:
      com.tencent.mm.gpu.e.c.axq();
      Log.e("Gpu.PluginGpuRes", "hook EGL destroy context fail");
    }
    label146:
    com.tencent.mm.gpu.e.c.axq();
    Log.e("Gpu.PluginGpuRes", "hook EGL destroy surface fail");
    AppMethodBeat.o(186142);
  }
  
  private void initOpenGL(boolean paramBoolean)
  {
    AppMethodBeat.i(186146);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      Log.e("Gpu.PluginGpuRes", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      Log.e("Gpu.PluginGpuRes", "eglInitialize fail");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0))
    {
      Log.e("Gpu.PluginGpuRes", "eglChooseConfig fail");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    this.hiT = arrayOfEGLConfig[0];
    localObject = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      ((MultiProcessMMKV)localObject).putBoolean("eglCreateContext_status", false);
    }
    this.hiU = EGL14.eglCreateContext(this.mEGLDisplay, this.hiT, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if (this.hiU == EGL14.EGL_NO_CONTEXT)
    {
      Log.e("Gpu.PluginGpuRes", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
      Log.e("Gpu.PluginGpuRes", "mEglContext == EGL14.EGL_NO_CONTEXT");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    if (paramBoolean) {
      ((MultiProcessMMKV)localObject).putBoolean("eglCreateSurface_status", false);
    }
    this.hiV = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.hiT, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    if (this.hiV == EGL14.EGL_NO_SURFACE)
    {
      Log.e("Gpu.PluginGpuRes", "mEglSurface == EGL14.EGL_NO_SURFACE");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.hiV, this.hiV, this.hiU))
    {
      Log.e("Gpu.PluginGpuRes", "eglMakeCurrent fail");
      this.hiR = true;
      AppMethodBeat.o(186146);
      return;
    }
    GLES20.glFlush();
    AppMethodBeat.o(186146);
  }
  
  public static boolean isFront()
  {
    return isFront;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(186144);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(186144);
      return false;
    }
    if (paramString.startsWith(com.tencent.mm.gpu.b.a.hiZ))
    {
      AppMethodBeat.o(186144);
      return true;
    }
    String[] arrayOfString = this.hiO;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(186144);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(186144);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return hiQ;
  }
  
  private void release(boolean paramBoolean)
  {
    AppMethodBeat.i(186145);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      localMultiProcessMMKV.putBoolean("eglDestroySurface_status", false);
    }
    EGL14.eglDestroySurface(this.mEGLDisplay, this.hiV);
    if (paramBoolean) {
      localMultiProcessMMKV.putBoolean("eglDestroyContext_status", false);
    }
    EGL14.eglDestroyContext(this.mEGLDisplay, this.hiU);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mEGLDisplay = null;
    this.hiT = null;
    this.hiU = null;
    this.hiV = null;
    AppMethodBeat.o(186145);
  }
  
  private static void skipCurrentModel()
  {
    hiQ = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(186141);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNV, true))
    {
      AppMethodBeat.o(186141);
      return;
    }
    Log.d("Gpu.PluginGpuRes", "PluginGpuRes execute");
    MMKV.initialize(MMApplicationContext.getContext());
    Object localObject1 = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
    int i;
    if (localMultiProcessMMKV.getInt("glGetErrorOOM_is_die", 0) == 1)
    {
      i = com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName());
      if (i != -1)
      {
        int j = getCurrSpend();
        if (j > 0) {
          break label146;
        }
        Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      localMultiProcessMMKV.putInt("glGetErrorOOM_is_die", 0);
      localMultiProcessMMKV.commit();
      if (isInWhiteList(MMApplicationContext.getProcessName())) {
        break;
      }
      AppMethodBeat.o(186141);
      return;
      label146:
      com.tencent.mm.gpu.e.c.e(i, 137L, 1L);
    }
    h.RTc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186136);
        PluginGpuRes.access$102(PluginGpuRes.hiP + 1800000);
        AppMethodBeat.o(186136);
      }
    }, 1800000L, 1800000L);
    Object localObject2 = new com.tencent.mm.gpu.e.b();
    com.tencent.mm.gpu.e.a locala = new com.tencent.mm.gpu.e.a();
    h.RTc.a((Runnable)localObject2, 1800000L, 1800000L);
    h.RTc.a(locala, 1800000L, 1800000L);
    localObject2 = com.tencent.mm.gpu.g.a.axy();
    if (((com.tencent.mm.gpu.g.a)localObject2).hjE) {
      Log.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
    }
    for (;;)
    {
      EventCenter.instance.add(this.hiW);
      bool1 = ((MultiProcessMMKV)localObject1).getBoolean("key_has_function_seek_start", false);
      boolean bool2 = ((MultiProcessMMKV)localObject1).getBoolean("key_finish_function_seek", false);
      Log.e("Gpu.PluginGpuRes", "hasStart = ".concat(String.valueOf(bool1)));
      Log.e("Gpu.PluginGpuRes", "hasFinish = ".concat(String.valueOf(bool2)));
      if (!bool1) {
        break label576;
      }
      if (!bool2) {
        break label613;
      }
      com.tencent.mm.gpu.e.c.axr();
      i = localMultiProcessMMKV.getInt("openGL_api_hook_flag", -1);
      if ((i == -1) || (i == 1)) {
        break;
      }
      Log.e("Gpu.PluginGpuRes", "has fail before");
      AppMethodBeat.o(186141);
      return;
      if (isSkipModel())
      {
        Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      }
      else
      {
        Log.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        h.RTc.a((Runnable)localObject2, 900000L, 900000L);
        ((com.tencent.mm.gpu.g.a)localObject2).hjE = true;
      }
    }
    localMultiProcessMMKV.putInt("openGL_api_hook_flag", 2);
    localMultiProcessMMKV.commit();
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNW, false);
    Log.i("Gpu.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(bool1)));
    if (bool1)
    {
      Log.e("Gpu.PluginGpuRes", "open opengl hook");
      startGLHook();
      localMultiProcessMMKV.putInt("openGL_api_hook_flag", 1);
      localMultiProcessMMKV.commit();
      localObject1 = EglHook.Syq;
      EglHook.a(new com.tencent.mm.gpu.c.a());
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNU, false)) {
        break label602;
      }
      Log.e("Gpu.PluginGpuRes", "open egl hook");
      startEGLHook();
      this.hiR = false;
      initOpenGL(true);
      if (!this.hiR) {
        release(true);
      }
      handleEGLHookReport(localMultiProcessMMKV);
    }
    for (;;)
    {
      label576:
      Log.d("Gpu.PluginGpuRes", "PluginGpuRes execute end");
      AppMethodBeat.o(186141);
      return;
      Log.e("Gpu.PluginGpuRes", "close opengl hook");
      break;
      label602:
      Log.e("Gpu.PluginGpuRes", "close egl hook");
      continue;
      label613:
      com.tencent.mm.gpu.e.c.axs();
    }
  }
  
  private void startEGLHook() {}
  
  private void startGLHook()
  {
    AppMethodBeat.i(186143);
    Object localObject = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    initOpenGL(false);
    if (this.hiR)
    {
      AppMethodBeat.o(186143);
      return;
    }
    testMemoryShake();
    int i = ((MultiProcessMMKV)localObject).getInt("glGenTextures_index", -1000);
    int j = ((MultiProcessMMKV)localObject).getInt("glDeleteTextures_index", -1000);
    int k = ((MultiProcessMMKV)localObject).getInt("glGenBuffers_index", -1000);
    int m = ((MultiProcessMMKV)localObject).getInt("glDeleteBuffers_index", -1000);
    int n = ((MultiProcessMMKV)localObject).getInt("glGenFramebuffers_index", -1000);
    int i1 = ((MultiProcessMMKV)localObject).getInt("glDeleteFramebuffers_index", -1000);
    int i2 = ((MultiProcessMMKV)localObject).getInt("glGenRenderbuffers_index", -1000);
    int i3 = ((MultiProcessMMKV)localObject).getInt("glDeleteRenderbuffers_index", -1000);
    int i4 = ((MultiProcessMMKV)localObject).getInt("glGetError_index", -1000);
    OpenGLHook.getInstance().init();
    OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.c.a());
    if ((i < 0) || (j < 0))
    {
      Log.e("Gpu.PluginGpuRes", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 6L, 1L);
      com.tencent.mm.gpu.e.c.axs();
      if ((k >= 0) && (m >= 0)) {
        break label501;
      }
      Log.e("Gpu.PluginGpuRes", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 7L, 1L);
      com.tencent.mm.gpu.e.c.axs();
      label266:
      if ((n >= 0) && (i1 >= 0)) {
        break label586;
      }
      Log.e("Gpu.PluginGpuRes", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 8L, 1L);
      com.tencent.mm.gpu.e.c.axs();
      label317:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label673;
      }
      Log.e("Gpu.PluginGpuRes", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 9L, 1L);
      com.tencent.mm.gpu.e.c.axs();
      label368:
      if (i4 >= 0) {
        break label760;
      }
      Log.e("Gpu.PluginGpuRes", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 10L, 1L);
      com.tencent.mm.gpu.e.c.axs();
    }
    for (;;)
    {
      release(false);
      AppMethodBeat.o(186143);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      Log.i("Gpu.PluginGpuRes", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 13L, 1L);
      com.tencent.mm.gpu.e.c.axr();
      break;
      label501:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject, 0);
      Log.i("Gpu.PluginGpuRes", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 14L, 1L);
      com.tencent.mm.gpu.e.c.axr();
      break label266;
      label586:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      Log.i("Gpu.PluginGpuRes", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 15L, 1L);
      com.tencent.mm.gpu.e.c.axr();
      break label317;
      label673:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject, 0);
      Log.i("Gpu.PluginGpuRes", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 16L, 1L);
      com.tencent.mm.gpu.e.c.axr();
      break label368;
      label760:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      Log.i("Gpu.PluginGpuRes", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 17L, 1L);
      com.tencent.mm.gpu.e.c.axr();
    }
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(186149);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    long l1 = localMultiProcessMMKV.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localMultiProcessMMKV.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      Log.i("Gpu.PluginGpuRes", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(1), "OpenGL_Api_Hook", Integer.valueOf(120) });
      try
      {
        GpuHookService.F(MMApplicationContext.getContext(), "OpenGL_Api_Hook");
        AppMethodBeat.o(186149);
        return;
      }
      catch (Exception localException)
      {
        long l2;
        Log.e("Gpu.PluginGpuRes", "GpuHookService.enableGpuHook");
        AppMethodBeat.o(186149);
      }
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        Log.e("Gpu.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(186149);
        return;
      }
      localMultiProcessMMKV.putLong("openGL_api_service_time", l2);
      Log.e("Gpu.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(186147);
    Object localObject1 = new com.tencent.mm.gpu.f.a();
    int i = ((com.tencent.mm.gpu.f.a)localObject1).axw();
    int j = ((com.tencent.mm.gpu.f.a)localObject1).axv();
    int k = ((com.tencent.mm.gpu.f.a)localObject1).axu();
    Object localObject2 = BitmapFactory.decodeResource(MMApplicationContext.getResources(), 2131235045);
    localObject1 = new int[1];
    GLES20.glGenTextures(1, (int[])localObject1, 0);
    GLES20.glBindTexture(3553, localObject1[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLUtils.texImage2D(3553, 0, (Bitmap)localObject2, 0);
    GLES20.glBindTexture(3553, 0);
    ((Bitmap)localObject2).recycle();
    localObject2 = new com.tencent.mm.gpu.f.a();
    int m = ((com.tencent.mm.gpu.f.a)localObject2).axw();
    int n = ((com.tencent.mm.gpu.f.a)localObject2).axv();
    int i1 = ((com.tencent.mm.gpu.f.a)localObject2).axu();
    if ((i == m) && (k == i1) && (j == n))
    {
      Log.d("Gpu.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    Log.d("Gpu.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(186147);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(186139);
    dependsOnRoot();
    AppMethodBeat.o(186139);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(186140);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186133);
        PluginGpuRes.access$000(PluginGpuRes.this);
        AppMethodBeat.o(186133);
      }
    });
    AppMethodBeat.o(186140);
  }
  
  public void installed()
  {
    AppMethodBeat.i(186138);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(186138);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(186148);
    Log.e("Gpu.PluginGpuRes", "onAccountInitialized start");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNS, false);
    Log.i("Gpu.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(186148);
      return;
    }
    startGpuHookService();
    Log.e("Gpu.PluginGpuRes", "onAccountInitialized end");
    AppMethodBeat.o(186148);
  }
  
  public void onAccountRelease() {}
  
  public void onAppBackground(String paramString)
  {
    isFront = false;
  }
  
  public void onAppForeground(String paramString)
  {
    isFront = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes
 * JD-Core Version:    0.7.0.1
 */