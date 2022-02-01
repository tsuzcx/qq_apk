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
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.gpu.service.GpuHookService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mmkv.MMKV;
import com.tencent.wxperf.jni.egl.EglHook;

public class PluginGpuRes
  extends f
  implements o, com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c
{
  private static int gwa = 0;
  private static boolean gwb = false;
  public static boolean gwd = false;
  private static boolean isFront = true;
  private String[] gvZ;
  private boolean gwc;
  private EGLDisplay gwe;
  private EGLConfig gwf;
  private EGLContext gwg;
  private EGLSurface gwh;
  private com.tencent.mm.sdk.b.c gwi;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(209605);
    this.gvZ = new String[] { com.tencent.mm.gpu.b.a.gwk, com.tencent.mm.gpu.b.a.gwm, com.tencent.mm.gpu.b.a.gwn };
    this.gwc = false;
    this.gwi = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(209605);
  }
  
  public static int getCurrSpend()
  {
    return gwa / 60000;
  }
  
  private void handleEGLHookReport(ay paramay)
  {
    AppMethodBeat.i(209610);
    gwd = false;
    boolean bool1 = paramay.getBoolean("eglCreateContext_status", false);
    boolean bool2 = paramay.getBoolean("eglCreateSurface_status", false);
    boolean bool3 = paramay.getBoolean("eglDestroySurface_status", false);
    boolean bool4 = paramay.getBoolean("eglDestroyContext_status", false);
    if (bool1)
    {
      com.tencent.mm.gpu.e.c.ahd();
      ae.e("Gpu.PluginGpuRes", "hook EGL create context success");
      if (!bool2) {
        break label120;
      }
      com.tencent.mm.gpu.e.c.ahd();
      ae.e("Gpu.PluginGpuRes", "hook EGL create surface success");
      label71:
      if (!bool3) {
        break label133;
      }
      com.tencent.mm.gpu.e.c.ahd();
      ae.e("Gpu.PluginGpuRes", "hook EGL destroy context success");
    }
    for (;;)
    {
      if (!bool4) {
        break label146;
      }
      com.tencent.mm.gpu.e.c.ahd();
      ae.e("Gpu.PluginGpuRes", "hook EGL destroy surface success");
      AppMethodBeat.o(209610);
      return;
      com.tencent.mm.gpu.e.c.ahe();
      ae.e("Gpu.PluginGpuRes", "hook EGL create context fail");
      break;
      label120:
      com.tencent.mm.gpu.e.c.ahe();
      ae.e("Gpu.PluginGpuRes", "hook EGL create surface fail");
      break label71;
      label133:
      com.tencent.mm.gpu.e.c.ahe();
      ae.e("Gpu.PluginGpuRes", "hook EGL destroy context fail");
    }
    label146:
    com.tencent.mm.gpu.e.c.ahe();
    ae.e("Gpu.PluginGpuRes", "hook EGL destroy surface fail");
    AppMethodBeat.o(209610);
  }
  
  private void initOpenGL(boolean paramBoolean)
  {
    AppMethodBeat.i(209614);
    this.gwe = EGL14.eglGetDisplay(0);
    if (this.gwe == EGL14.EGL_NO_DISPLAY)
    {
      ae.e("Gpu.PluginGpuRes", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.gwe, (int[])localObject, 0, (int[])localObject, 1))
    {
      ae.e("Gpu.PluginGpuRes", "eglInitialize fail");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!EGL14.eglChooseConfig(this.gwe, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, (int[])localObject, 0))
    {
      ae.e("Gpu.PluginGpuRes", "eglChooseConfig fail");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    this.gwf = arrayOfEGLConfig[0];
    localObject = ay.aRX("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      ((ay)localObject).putBoolean("eglCreateContext_status", false);
    }
    this.gwg = EGL14.eglCreateContext(this.gwe, this.gwf, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if (this.gwg == EGL14.EGL_NO_CONTEXT)
    {
      ae.e("Gpu.PluginGpuRes", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
      ae.e("Gpu.PluginGpuRes", "mEglContext == EGL14.EGL_NO_CONTEXT");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    if (paramBoolean) {
      ((ay)localObject).putBoolean("eglCreateSurface_status", false);
    }
    this.gwh = EGL14.eglCreatePbufferSurface(this.gwe, this.gwf, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    if (this.gwh == EGL14.EGL_NO_SURFACE)
    {
      ae.e("Gpu.PluginGpuRes", "mEglSurface == EGL14.EGL_NO_SURFACE");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    if (!EGL14.eglMakeCurrent(this.gwe, this.gwh, this.gwh, this.gwg))
    {
      ae.e("Gpu.PluginGpuRes", "eglMakeCurrent fail");
      this.gwc = true;
      AppMethodBeat.o(209614);
      return;
    }
    GLES20.glFlush();
    AppMethodBeat.o(209614);
  }
  
  public static boolean isFront()
  {
    return isFront;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(209612);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(209612);
      return false;
    }
    if (paramString.startsWith(com.tencent.mm.gpu.b.a.gwl))
    {
      AppMethodBeat.o(209612);
      return true;
    }
    String[] arrayOfString = this.gvZ;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(209612);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(209612);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return gwb;
  }
  
  private void release(boolean paramBoolean)
  {
    AppMethodBeat.i(209613);
    ay localay = ay.aRX("mmkv_gpu_service_key_single");
    if (paramBoolean) {
      localay.putBoolean("eglDestroySurface_status", false);
    }
    EGL14.eglDestroySurface(this.gwe, this.gwh);
    if (paramBoolean) {
      localay.putBoolean("eglDestroyContext_status", false);
    }
    EGL14.eglDestroyContext(this.gwe, this.gwg);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.gwe);
    this.gwe = null;
    this.gwf = null;
    this.gwg = null;
    this.gwh = null;
    AppMethodBeat.o(209613);
  }
  
  private static void skipCurrentModel()
  {
    gwb = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(209609);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwk, true))
    {
      AppMethodBeat.o(209609);
      return;
    }
    ae.d("Gpu.PluginGpuRes", "PluginGpuRes execute");
    MMKV.initialize(ak.getContext());
    Object localObject1 = ay.aRW("mmkv_gpu_service_key_muti");
    ay localay = ay.aRX("mmkv_gpu_service_key_single");
    int i;
    if (localay.getInt("glGetErrorOOM_is_die", 0) == 1)
    {
      i = com.tencent.mm.gpu.e.c.wU(ak.getProcessName());
      if (i != -1)
      {
        int j = getCurrSpend();
        if (j > 0) {
          break label146;
        }
        ae.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      localay.putInt("glGetErrorOOM_is_die", 0);
      localay.commit();
      if (isInWhiteList(ak.getProcessName())) {
        break;
      }
      AppMethodBeat.o(209609);
      return;
      label146:
      com.tencent.mm.gpu.e.c.e(i, 137L, 1L);
    }
    h.MqF.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209603);
        PluginGpuRes.access$102(PluginGpuRes.gwa + 1800000);
        AppMethodBeat.o(209603);
      }
    }, 1800000L, 1800000L);
    Object localObject2 = new com.tencent.mm.gpu.e.b();
    com.tencent.mm.gpu.e.a locala = new com.tencent.mm.gpu.e.a();
    h.MqF.a((Runnable)localObject2, 1800000L, 1800000L);
    h.MqF.a(locala, 1800000L, 1800000L);
    localObject2 = com.tencent.mm.gpu.g.a.ahm();
    if (((com.tencent.mm.gpu.g.a)localObject2).gwQ) {
      ae.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.b(this.gwi);
      bool1 = ((ay)localObject1).getBoolean("key_has_function_seek_start", false);
      boolean bool2 = ((ay)localObject1).getBoolean("key_finish_function_seek", false);
      ae.e("Gpu.PluginGpuRes", "hasStart = ".concat(String.valueOf(bool1)));
      ae.e("Gpu.PluginGpuRes", "hasFinish = ".concat(String.valueOf(bool2)));
      if (!bool1) {
        break label587;
      }
      if (!bool2) {
        break label624;
      }
      com.tencent.mm.gpu.e.c.ahf();
      i = localay.getInt("openGL_api_hook_flag", -1);
      if ((i == -1) || (i == 1)) {
        break;
      }
      ae.e("Gpu.PluginGpuRes", "has fail before");
      AppMethodBeat.o(209609);
      return;
      if (isSkipModel())
      {
        ae.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      }
      else
      {
        ae.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        h.MqF.a((Runnable)localObject2, 900000L, 900000L);
        ((com.tencent.mm.gpu.g.a)localObject2).gwQ = true;
      }
    }
    localay.putInt("openGL_api_hook_flag", 2);
    localay.commit();
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwl, false);
    ae.i("Gpu.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(bool1)));
    if (bool1)
    {
      ae.e("Gpu.PluginGpuRes", "open opengl hook");
      startGLHook();
      localay.putInt("openGL_api_hook_flag", 1);
      localay.commit();
      localObject1 = EglHook.MLC;
      EglHook.a(new com.tencent.mm.gpu.c.a());
      EglHook.a(new PluginGpuRes.a((byte)0));
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwj, false)) {
        break label613;
      }
      ae.e("Gpu.PluginGpuRes", "open egl hook");
      startEGLHook();
      this.gwc = false;
      initOpenGL(true);
      if (!this.gwc) {
        release(true);
      }
      handleEGLHookReport(localay);
    }
    for (;;)
    {
      label587:
      ae.d("Gpu.PluginGpuRes", "PluginGpuRes execute end");
      AppMethodBeat.o(209609);
      return;
      ae.e("Gpu.PluginGpuRes", "close opengl hook");
      break;
      label613:
      ae.e("Gpu.PluginGpuRes", "close egl hook");
      continue;
      label624:
      com.tencent.mm.gpu.e.c.ahg();
    }
  }
  
  private void startEGLHook() {}
  
  private void startGLHook()
  {
    AppMethodBeat.i(209611);
    Object localObject = ay.aRW("mmkv_gpu_service_key_muti");
    initOpenGL(false);
    if (this.gwc)
    {
      AppMethodBeat.o(209611);
      return;
    }
    testMemoryShake();
    int i = ((ay)localObject).getInt("glGenTextures_index", -1000);
    int j = ((ay)localObject).getInt("glDeleteTextures_index", -1000);
    int k = ((ay)localObject).getInt("glGenBuffers_index", -1000);
    int m = ((ay)localObject).getInt("glDeleteBuffers_index", -1000);
    int n = ((ay)localObject).getInt("glGenFramebuffers_index", -1000);
    int i1 = ((ay)localObject).getInt("glDeleteFramebuffers_index", -1000);
    int i2 = ((ay)localObject).getInt("glGenRenderbuffers_index", -1000);
    int i3 = ((ay)localObject).getInt("glDeleteRenderbuffers_index", -1000);
    int i4 = ((ay)localObject).getInt("glGetError_index", -1000);
    OpenGLHook.getInstance().init();
    OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.c.a());
    if ((i < 0) || (j < 0))
    {
      ae.e("Gpu.PluginGpuRes", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 6L, 1L);
      com.tencent.mm.gpu.e.c.ahg();
      if ((k >= 0) && (m >= 0)) {
        break label501;
      }
      ae.e("Gpu.PluginGpuRes", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 7L, 1L);
      com.tencent.mm.gpu.e.c.ahg();
      label266:
      if ((n >= 0) && (i1 >= 0)) {
        break label586;
      }
      ae.e("Gpu.PluginGpuRes", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 8L, 1L);
      com.tencent.mm.gpu.e.c.ahg();
      label317:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label673;
      }
      ae.e("Gpu.PluginGpuRes", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 9L, 1L);
      com.tencent.mm.gpu.e.c.ahg();
      label368:
      if (i4 >= 0) {
        break label760;
      }
      ae.e("Gpu.PluginGpuRes", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 10L, 1L);
      com.tencent.mm.gpu.e.c.ahg();
    }
    for (;;)
    {
      release(false);
      AppMethodBeat.o(209611);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      ae.i("Gpu.PluginGpuRes", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.gpu.e.c.e(1403L, 13L, 1L);
      com.tencent.mm.gpu.e.c.ahf();
      break;
      label501:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject, 0);
      ae.i("Gpu.PluginGpuRes", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      com.tencent.mm.gpu.e.c.e(1403L, 14L, 1L);
      com.tencent.mm.gpu.e.c.ahf();
      break label266;
      label586:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      ae.i("Gpu.PluginGpuRes", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      com.tencent.mm.gpu.e.c.e(1403L, 15L, 1L);
      com.tencent.mm.gpu.e.c.ahf();
      break label317;
      label673:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject, 0);
      ae.i("Gpu.PluginGpuRes", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      com.tencent.mm.gpu.e.c.e(1403L, 16L, 1L);
      com.tencent.mm.gpu.e.c.ahf();
      break label368;
      label760:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      ae.i("Gpu.PluginGpuRes", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      com.tencent.mm.gpu.e.c.e(1403L, 17L, 1L);
      com.tencent.mm.gpu.e.c.ahf();
    }
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(209617);
    ay localay = ay.aRW("mmkv_gpu_service_key_muti");
    long l1 = localay.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localay.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      ae.i("Gpu.PluginGpuRes", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(1), "OpenGL_Api_Hook", Integer.valueOf(120) });
      try
      {
        GpuHookService.G(ak.getContext(), "OpenGL_Api_Hook");
        AppMethodBeat.o(209617);
        return;
      }
      catch (Exception localException)
      {
        long l2;
        ae.e("Gpu.PluginGpuRes", "GpuHookService.enableGpuHook");
        AppMethodBeat.o(209617);
      }
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        ae.e("Gpu.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(209617);
        return;
      }
      localay.putLong("openGL_api_service_time", l2);
      ae.e("Gpu.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(209615);
    Object localObject1 = new com.tencent.mm.gpu.f.a();
    int i = ((com.tencent.mm.gpu.f.a)localObject1).ahk();
    int j = ((com.tencent.mm.gpu.f.a)localObject1).ahj();
    int k = ((com.tencent.mm.gpu.f.a)localObject1).ahi();
    Object localObject2 = BitmapFactory.decodeResource(ak.getResources(), 2131234174);
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
    int m = ((com.tencent.mm.gpu.f.a)localObject2).ahk();
    int n = ((com.tencent.mm.gpu.f.a)localObject2).ahj();
    int i1 = ((com.tencent.mm.gpu.f.a)localObject2).ahi();
    if ((i == m) && (k == i1) && (j == n))
    {
      ae.d("Gpu.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    ae.d("Gpu.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(209615);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(209607);
    dependsOnRoot();
    AppMethodBeat.o(209607);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(209608);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209600);
        PluginGpuRes.access$000(PluginGpuRes.this);
        AppMethodBeat.o(209600);
      }
    });
    AppMethodBeat.o(209608);
  }
  
  public void installed()
  {
    AppMethodBeat.i(209606);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(209606);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(209616);
    ae.e("Gpu.PluginGpuRes", "onAccountInitialized start");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwh, false);
    ae.i("Gpu.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(209616);
      return;
    }
    startGpuHookService();
    ae.e("Gpu.PluginGpuRes", "onAccountInitialized end");
    AppMethodBeat.o(209616);
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