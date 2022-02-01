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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.gpu.service.GpuHookService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mmkv.MMKV;
import com.tencent.wxperf.jni.egl.EglHook;

public class PluginGpuRes
  extends f
  implements n, com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c
{
  private static int gtt = 0;
  private static boolean gtu = false;
  public static boolean gtw = false;
  private static boolean isFront = true;
  private EGLSurface gtA;
  private com.tencent.mm.sdk.b.c gtB;
  private String[] gts;
  private boolean gtv;
  private EGLDisplay gtx;
  private EGLConfig gty;
  private EGLContext gtz;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(219483);
    this.gts = new String[] { com.tencent.mm.gpu.b.a.gtD, com.tencent.mm.gpu.b.a.gtF, com.tencent.mm.gpu.b.a.gtG };
    this.gtv = false;
    this.gtB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(219483);
  }
  
  public static int getCurrSpend()
  {
    return gtt / 60000;
  }
  
  private void handleEGLHookReport(ax paramax)
  {
    AppMethodBeat.i(219488);
    gtw = false;
    boolean bool1 = paramax.getBoolean("eglCreateContext_status", false);
    boolean bool2 = paramax.getBoolean("eglCreateSurface_status", false);
    boolean bool3 = paramax.getBoolean("eglDestroySurface_status", false);
    boolean bool4 = paramax.getBoolean("eglDestroyContext_status", false);
    if (bool1)
    {
      com.tencent.mm.gpu.e.c.agO();
      ad.e("Gpu.PluginGpuRes", "hook EGL create context success");
      if (!bool2) {
        break label120;
      }
      com.tencent.mm.gpu.e.c.agO();
      ad.e("Gpu.PluginGpuRes", "hook EGL create surface success");
      label71:
      if (!bool3) {
        break label133;
      }
      com.tencent.mm.gpu.e.c.agO();
      ad.e("Gpu.PluginGpuRes", "hook EGL destroy context success");
    }
    for (;;)
    {
      if (!bool4) {
        break label146;
      }
      com.tencent.mm.gpu.e.c.agO();
      ad.e("Gpu.PluginGpuRes", "hook EGL destroy surface success");
      AppMethodBeat.o(219488);
      return;
      com.tencent.mm.gpu.e.c.agP();
      ad.e("Gpu.PluginGpuRes", "hook EGL create context fail");
      break;
      label120:
      com.tencent.mm.gpu.e.c.agP();
      ad.e("Gpu.PluginGpuRes", "hook EGL create surface fail");
      break label71;
      label133:
      com.tencent.mm.gpu.e.c.agP();
      ad.e("Gpu.PluginGpuRes", "hook EGL destroy context fail");
    }
    label146:
    com.tencent.mm.gpu.e.c.agP();
    ad.e("Gpu.PluginGpuRes", "hook EGL destroy surface fail");
    AppMethodBeat.o(219488);
  }
  
  private void initOpenGL(boolean paramBoolean)
  {
    AppMethodBeat.i(219492);
    this.gtx = EGL14.eglGetDisplay(0);
    if (this.gtx == EGL14.EGL_NO_DISPLAY)
    {
      ad.e("Gpu.PluginGpuRes", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.gtx, (int[])localObject, 0, (int[])localObject, 1))
    {
      ad.e("Gpu.PluginGpuRes", "eglInitialize fail");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!EGL14.eglChooseConfig(this.gtx, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0))
    {
      ad.e("Gpu.PluginGpuRes", "eglChooseConfig fail");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    this.gty = arrayOfEGLConfig[0];
    localObject = ax.aQA("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      ((ax)localObject).putBoolean("eglCreateContext_status", false);
    }
    this.gtz = EGL14.eglCreateContext(this.gtx, this.gty, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if (this.gtz == EGL14.EGL_NO_CONTEXT)
    {
      ad.e("Gpu.PluginGpuRes", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
      ad.e("Gpu.PluginGpuRes", "mEglContext == EGL14.EGL_NO_CONTEXT");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    if (paramBoolean) {
      ((ax)localObject).putBoolean("eglCreateSurface_status", false);
    }
    this.gtA = EGL14.eglCreatePbufferSurface(this.gtx, this.gty, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    if (this.gtA == EGL14.EGL_NO_SURFACE)
    {
      ad.e("Gpu.PluginGpuRes", "mEglSurface == EGL14.EGL_NO_SURFACE");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    if (!EGL14.eglMakeCurrent(this.gtx, this.gtA, this.gtA, this.gtz))
    {
      ad.e("Gpu.PluginGpuRes", "eglMakeCurrent fail");
      this.gtv = true;
      AppMethodBeat.o(219492);
      return;
    }
    GLES20.glFlush();
    AppMethodBeat.o(219492);
  }
  
  public static boolean isFront()
  {
    return isFront;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(219490);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(219490);
      return false;
    }
    if (paramString.startsWith(com.tencent.mm.gpu.b.a.gtE))
    {
      AppMethodBeat.o(219490);
      return true;
    }
    String[] arrayOfString = this.gts;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(219490);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(219490);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return gtu;
  }
  
  private void release(boolean paramBoolean)
  {
    AppMethodBeat.i(219491);
    ax localax = ax.aQA("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      localax.putBoolean("eglDestroySurface_status", false);
    }
    EGL14.eglDestroySurface(this.gtx, this.gtA);
    if (paramBoolean) {
      localax.putBoolean("eglDestroyContext_status", false);
    }
    EGL14.eglDestroyContext(this.gtx, this.gtz);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.gtx);
    this.gtx = null;
    this.gty = null;
    this.gtz = null;
    this.gtA = null;
    AppMethodBeat.o(219491);
  }
  
  private static void skipCurrentModel()
  {
    gtu = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(219487);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpD, true))
    {
      AppMethodBeat.o(219487);
      return;
    }
    ad.d("Gpu.PluginGpuRes", "PluginGpuRes execute");
    MMKV.initialize(aj.getContext());
    Object localObject1 = ax.aQz("mmkv_gpu_service_key_muti");
    ax localax = ax.aQA("mmkv_gpu_service_key_single");
    int i;
    if (localax.getInt("glGetErrorOOM_is_die", 0) == 1)
    {
      i = com.tencent.mm.gpu.e.c.wl(aj.getProcessName());
      if (i != -1)
      {
        int j = getCurrSpend();
        if (j > 0) {
          break label146;
        }
        ad.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      localax.putInt("glGetErrorOOM_is_die", 0);
      localax.commit();
      if (isInWhiteList(aj.getProcessName())) {
        break;
      }
      AppMethodBeat.o(219487);
      return;
      label146:
      com.tencent.mm.gpu.e.c.e(i, 137L, 1L);
    }
    h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219481);
        PluginGpuRes.access$102(PluginGpuRes.gtt + 1800000);
        AppMethodBeat.o(219481);
      }
    }, 1800000L, 1800000L);
    Object localObject2 = new com.tencent.mm.gpu.e.b();
    com.tencent.mm.gpu.e.a locala = new com.tencent.mm.gpu.e.a();
    h.LTJ.a((Runnable)localObject2, 1800000L, 1800000L);
    h.LTJ.a(locala, 1800000L, 1800000L);
    localObject2 = com.tencent.mm.gpu.g.a.agX();
    if (((com.tencent.mm.gpu.g.a)localObject2).guj) {
      ad.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.b(this.gtB);
      bool1 = ((ax)localObject1).getBoolean("key_has_function_seek_start", false);
      boolean bool2 = ((ax)localObject1).getBoolean("key_finish_function_seek", false);
      ad.e("Gpu.PluginGpuRes", "hasStart = ".concat(String.valueOf(bool1)));
      ad.e("Gpu.PluginGpuRes", "hasFinish = ".concat(String.valueOf(bool2)));
      if (!bool1) {
        break label587;
      }
      if (!bool2) {
        break label624;
      }
      com.tencent.mm.gpu.e.c.agQ();
      i = localax.getInt("openGL_api_hook_flag", -1);
      if ((i == -1) || (i == 1)) {
        break;
      }
      ad.e("Gpu.PluginGpuRes", "has fail before");
      AppMethodBeat.o(219487);
      return;
      if (isSkipModel())
      {
        ad.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      }
      else
      {
        ad.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        h.LTJ.a((Runnable)localObject2, 900000L, 900000L);
        ((com.tencent.mm.gpu.g.a)localObject2).guj = true;
      }
    }
    localax.putInt("openGL_api_hook_flag", 2);
    localax.commit();
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpE, false);
    ad.i("Gpu.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(bool1)));
    if (bool1)
    {
      ad.e("Gpu.PluginGpuRes", "open opengl hook");
      startGLHook();
      localax.putInt("openGL_api_hook_flag", 1);
      localax.commit();
      localObject1 = EglHook.MoG;
      EglHook.a(new com.tencent.mm.gpu.c.a());
      EglHook.a(new PluginGpuRes.a((byte)0));
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpC, false)) {
        break label613;
      }
      ad.e("Gpu.PluginGpuRes", "open egl hook");
      startEGLHook();
      this.gtv = false;
      initOpenGL(true);
      if (!this.gtv) {
        release(true);
      }
      handleEGLHookReport(localax);
    }
    for (;;)
    {
      label587:
      ad.d("Gpu.PluginGpuRes", "PluginGpuRes execute end");
      AppMethodBeat.o(219487);
      return;
      ad.e("Gpu.PluginGpuRes", "close opengl hook");
      break;
      label613:
      ad.e("Gpu.PluginGpuRes", "close egl hook");
      continue;
      label624:
      com.tencent.mm.gpu.e.c.agR();
    }
  }
  
  private void startEGLHook() {}
  
  private void startGLHook()
  {
    AppMethodBeat.i(219489);
    Object localObject = ax.aQz("mmkv_gpu_service_key_muti");
    initOpenGL(false);
    if (this.gtv)
    {
      AppMethodBeat.o(219489);
      return;
    }
    testMemoryShake();
    int i = ((ax)localObject).getInt("glGenTextures_index", -1000);
    int j = ((ax)localObject).getInt("glDeleteTextures_index", -1000);
    int k = ((ax)localObject).getInt("glGenBuffers_index", -1000);
    int m = ((ax)localObject).getInt("glDeleteBuffers_index", -1000);
    int n = ((ax)localObject).getInt("glGenFramebuffers_index", -1000);
    int i1 = ((ax)localObject).getInt("glDeleteFramebuffers_index", -1000);
    int i2 = ((ax)localObject).getInt("glGenRenderbuffers_index", -1000);
    int i3 = ((ax)localObject).getInt("glDeleteRenderbuffers_index", -1000);
    int i4 = ((ax)localObject).getInt("glGetError_index", -1000);
    OpenGLHook.getInstance().init();
    OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.c.a());
    if ((i < 0) || (j < 0))
    {
      ad.e("Gpu.PluginGpuRes", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 6L, 1L);
      com.tencent.mm.gpu.e.c.agR();
      if ((k >= 0) && (m >= 0)) {
        break label501;
      }
      ad.e("Gpu.PluginGpuRes", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 7L, 1L);
      com.tencent.mm.gpu.e.c.agR();
      label266:
      if ((n >= 0) && (i1 >= 0)) {
        break label586;
      }
      ad.e("Gpu.PluginGpuRes", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 8L, 1L);
      com.tencent.mm.gpu.e.c.agR();
      label317:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label673;
      }
      ad.e("Gpu.PluginGpuRes", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 9L, 1L);
      com.tencent.mm.gpu.e.c.agR();
      label368:
      if (i4 >= 0) {
        break label760;
      }
      ad.e("Gpu.PluginGpuRes", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 10L, 1L);
      com.tencent.mm.gpu.e.c.agR();
    }
    for (;;)
    {
      release(false);
      AppMethodBeat.o(219489);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      ad.i("Gpu.PluginGpuRes", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 13L, 1L);
      com.tencent.mm.gpu.e.c.agQ();
      break;
      label501:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject, 0);
      ad.i("Gpu.PluginGpuRes", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 14L, 1L);
      com.tencent.mm.gpu.e.c.agQ();
      break label266;
      label586:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      ad.i("Gpu.PluginGpuRes", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 15L, 1L);
      com.tencent.mm.gpu.e.c.agQ();
      break label317;
      label673:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject, 0);
      ad.i("Gpu.PluginGpuRes", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 16L, 1L);
      com.tencent.mm.gpu.e.c.agQ();
      break label368;
      label760:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      ad.i("Gpu.PluginGpuRes", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 17L, 1L);
      com.tencent.mm.gpu.e.c.agQ();
    }
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(219495);
    ax localax = ax.aQz("mmkv_gpu_service_key_muti");
    long l1 = localax.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localax.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      ad.i("Gpu.PluginGpuRes", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(1), "OpenGL_Api_Hook", Integer.valueOf(120) });
      try
      {
        GpuHookService.F(aj.getContext(), "OpenGL_Api_Hook");
        AppMethodBeat.o(219495);
        return;
      }
      catch (Exception localException)
      {
        long l2;
        ad.e("Gpu.PluginGpuRes", "GpuHookService.enableGpuHook");
        AppMethodBeat.o(219495);
      }
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        ad.e("Gpu.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(219495);
        return;
      }
      localax.putLong("openGL_api_service_time", l2);
      ad.e("Gpu.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(219493);
    Object localObject1 = new com.tencent.mm.gpu.f.a();
    int i = ((com.tencent.mm.gpu.f.a)localObject1).agV();
    int j = ((com.tencent.mm.gpu.f.a)localObject1).agU();
    int k = ((com.tencent.mm.gpu.f.a)localObject1).agT();
    Object localObject2 = BitmapFactory.decodeResource(aj.getResources(), 2131234174);
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
    int m = ((com.tencent.mm.gpu.f.a)localObject2).agV();
    int n = ((com.tencent.mm.gpu.f.a)localObject2).agU();
    int i1 = ((com.tencent.mm.gpu.f.a)localObject2).agT();
    if ((i == m) && (k == i1) && (j == n))
    {
      ad.d("Gpu.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    ad.d("Gpu.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(219493);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(219485);
    dependsOnRoot();
    AppMethodBeat.o(219485);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(219486);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219478);
        PluginGpuRes.access$000(PluginGpuRes.this);
        AppMethodBeat.o(219478);
      }
    });
    AppMethodBeat.o(219486);
  }
  
  public void installed()
  {
    AppMethodBeat.i(219484);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(219484);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(219494);
    ad.e("Gpu.PluginGpuRes", "onAccountInitialized start");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpA, false);
    ad.i("Gpu.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(219494);
      return;
    }
    startGpuHookService();
    ad.e("Gpu.PluginGpuRes", "onAccountInitialized end");
    AppMethodBeat.o(219494);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes
 * JD-Core Version:    0.7.0.1
 */