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
import android.os.Build.VERSION;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.gpu.e.d;
import com.tencent.mm.gpu.service.GpuHookService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.performance.jni.HookManager;
import com.tencent.mm.performance.jni.HookManager.HookFailedException;
import com.tencent.mm.performance.jni.egl.EglHook;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mmkv.MMKV;

public class PluginGpuRes
  extends f
  implements n, com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c
{
  private static int fZX = 0;
  private static boolean fZY = false;
  private static boolean isFront = true;
  private String[] fZW;
  private EGLDisplay fZZ;
  private EGLConfig gaa;
  private EGLContext gab;
  private EGLSurface gac;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(209382);
    this.fZW = new String[] { com.tencent.mm.gpu.b.a.gae, com.tencent.mm.gpu.b.a.gag, com.tencent.mm.gpu.b.a.gah };
    AppMethodBeat.o(209382);
  }
  
  public static int getCurrSpend()
  {
    return fZX / 60000;
  }
  
  private void initOpenGL()
  {
    AppMethodBeat.i(209390);
    this.fZZ = EGL14.eglGetDisplay(0);
    if (this.fZZ == EGL14.EGL_NO_DISPLAY)
    {
      ac.e("Gpu.PluginGpuRes", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
      AppMethodBeat.o(209390);
      return;
    }
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(this.fZZ, arrayOfInt, 0, arrayOfInt, 1))
    {
      ac.e("Gpu.PluginGpuRes", "eglInitialize fail");
      AppMethodBeat.o(209390);
      return;
    }
    arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!EGL14.eglChooseConfig(this.fZZ, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0))
    {
      ac.e("Gpu.PluginGpuRes", "eglChooseConfig fail");
      AppMethodBeat.o(209390);
      return;
    }
    this.gaa = arrayOfEGLConfig[0];
    this.gab = EGL14.eglCreateContext(this.fZZ, this.gaa, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if (this.gab == EGL14.EGL_NO_CONTEXT)
    {
      ac.e("Gpu.PluginGpuRes", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
      ac.e("Gpu.PluginGpuRes", "mEglContext == EGL14.EGL_NO_CONTEXT");
      AppMethodBeat.o(209390);
      return;
    }
    this.gac = EGL14.eglCreatePbufferSurface(this.fZZ, this.gaa, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    if (this.gac == EGL14.EGL_NO_SURFACE)
    {
      ac.e("Gpu.PluginGpuRes", "mEglSurface == EGL14.EGL_NO_SURFACE");
      AppMethodBeat.o(209390);
      return;
    }
    if (!EGL14.eglMakeCurrent(this.fZZ, this.gac, this.gac, this.gab))
    {
      ac.e("Gpu.PluginGpuRes", "eglMakeCurrent fail");
      AppMethodBeat.o(209390);
      return;
    }
    GLES20.glFlush();
    AppMethodBeat.o(209390);
  }
  
  public static boolean isFront()
  {
    return isFront;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(209388);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(209388);
      return false;
    }
    if (paramString.startsWith(com.tencent.mm.gpu.b.a.gaf))
    {
      AppMethodBeat.o(209388);
      return true;
    }
    String[] arrayOfString = this.fZW;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(209388);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(209388);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return fZY;
  }
  
  private void release()
  {
    AppMethodBeat.i(209389);
    EGL14.eglDestroySurface(this.fZZ, this.gac);
    EGL14.eglDestroyContext(this.fZZ, this.gab);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.fZZ);
    this.fZZ = null;
    this.gaa = null;
    this.gab = null;
    this.gac = null;
    AppMethodBeat.o(209389);
  }
  
  private static void skipCurrentModel()
  {
    fZY = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(210485);
    MMKV.initialize(ai.getContext());
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pLQ, true))
    {
      AppMethodBeat.o(210485);
      return;
    }
    ac.d("Gpu.PluginGpuRes", "PluginGpuRes execute");
    aw localaw1 = aw.aKT("mmkv_gpu_service_key_muti");
    aw localaw2 = aw.aKU("mmkv_gpu_service_key_single");
    int i;
    if (localaw2.getInt("glGetErrorOOM_is_die", 0) == 1)
    {
      i = d.tv(ai.getProcessName());
      if (i != -1)
      {
        int j = getCurrSpend();
        if (j > 0) {
          break label138;
        }
        ac.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      localaw2.putInt("glGetErrorOOM_is_die", 0);
      localaw2.commit();
      if (isInWhiteList(ai.getProcessName())) {
        break;
      }
      AppMethodBeat.o(210485);
      return;
      label138:
      d.e(i, 137L, 1L);
    }
    h.JZN.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209381);
        PluginGpuRes.access$002(PluginGpuRes.fZX + 1800000);
        AppMethodBeat.o(209381);
      }
    }, 1800000L, 1800000L);
    Object localObject = new com.tencent.mm.gpu.e.c();
    com.tencent.mm.gpu.e.b localb = new com.tencent.mm.gpu.e.b();
    h.JZN.a((Runnable)localObject, 1800000L, 1800000L);
    h.JZN.a(localb, 1800000L, 1800000L);
    localObject = com.tencent.mm.gpu.e.a.aei();
    if (((com.tencent.mm.gpu.e.a)localObject).gas) {
      ac.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
    }
    for (;;)
    {
      bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pLR, false);
      ac.i("Gpu.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(bool1)));
      if (bool1) {
        break;
      }
      AppMethodBeat.o(210485);
      return;
      if (isSkipModel())
      {
        ac.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      }
      else
      {
        ac.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        h.JZN.a((Runnable)localObject, 900000L, 900000L);
        ((com.tencent.mm.gpu.e.a)localObject).gas = true;
      }
    }
    boolean bool1 = localaw1.getBoolean("key_has_function_seek_start", false);
    boolean bool2 = localaw1.getBoolean("key_finish_function_seek", false);
    ac.e("Gpu.PluginGpuRes", "hasStart = ".concat(String.valueOf(bool1)));
    ac.e("Gpu.PluginGpuRes", "hasFinish = ".concat(String.valueOf(bool2)));
    if (bool1)
    {
      if (!bool2) {
        break label535;
      }
      d.e(1403L, 1L, 1L);
      i = localaw2.getInt("openGL_api_hook_flag", -1);
      if ((i != -1) && (i != 1))
      {
        ac.e("Gpu.PluginGpuRes", "has fail before");
        AppMethodBeat.o(210485);
        return;
      }
      localaw2.putInt("openGL_api_hook_flag", 2);
      localaw2.commit();
      startGLHook();
      localaw2.putInt("openGL_api_hook_flag", 1);
      localaw2.commit();
      if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pLP, false)) {
        break label524;
      }
      ac.e("Gpu.PluginGpuRes", "open egl hook");
    }
    for (;;)
    {
      ac.d("Gpu.PluginGpuRes", "PluginGpuRes execute end");
      AppMethodBeat.o(210485);
      return;
      label524:
      ac.e("Gpu.PluginGpuRes", "close egl hook");
      continue;
      label535:
      d.e(1403L, 2L, 1L);
    }
  }
  
  private void startEGLHook()
  {
    AppMethodBeat.i(209386);
    try
    {
      HookManager.INSTANCE.addHook(EglHook.INSTANCE).commitHooks();
      d.e(d.tv(ai.getProcessName()), 176L, 1L);
      AppMethodBeat.o(209386);
      return;
    }
    catch (HookManager.HookFailedException localHookFailedException)
    {
      d.e(d.tv(ai.getProcessName()), 177L, 1L);
      ac.e("Gpu.PluginGpuRes", "egl hook fail");
      AppMethodBeat.o(209386);
    }
  }
  
  private void startGLHook()
  {
    AppMethodBeat.i(209387);
    Object localObject = aw.aKT("mmkv_gpu_service_key_muti");
    initOpenGL();
    testMemoryShake();
    int i = ((aw)localObject).getInt("glGenTextures_index", -1000);
    int j = ((aw)localObject).getInt("glDeleteTextures_index", -1000);
    int k = ((aw)localObject).getInt("glGenBuffers_index", -1000);
    int m = ((aw)localObject).getInt("glDeleteBuffers_index", -1000);
    int n = ((aw)localObject).getInt("glGenFramebuffers_index", -1000);
    int i1 = ((aw)localObject).getInt("glDeleteFramebuffers_index", -1000);
    int i2 = ((aw)localObject).getInt("glGenRenderbuffers_index", -1000);
    int i3 = ((aw)localObject).getInt("glDeleteRenderbuffers_index", -1000);
    int i4 = ((aw)localObject).getInt("glGetError_index", -1000);
    OpenGLHook.getInstance().init();
    OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.c.a());
    if ((i < 0) || (j < 0))
    {
      ac.e("Gpu.PluginGpuRes", "opengl hook fail : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      d.e(1403L, 6L, 1L);
      if ((k >= 0) && (m >= 0)) {
        break label466;
      }
      ac.e("Gpu.PluginGpuRes", "opengl hook fail : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      d.e(1403L, 7L, 1L);
      label244:
      if ((n >= 0) && (i1 >= 0)) {
        break label548;
      }
      ac.e("Gpu.PluginGpuRes", "opengl hook fail : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      d.e(1403L, 8L, 1L);
      label292:
      if ((i2 >= 0) && (i3 >= 0)) {
        break label632;
      }
      ac.e("Gpu.PluginGpuRes", "opengl hook fail : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      d.e(1403L, 9L, 1L);
      label340:
      if (i4 >= 0) {
        break label716;
      }
      ac.e("Gpu.PluginGpuRes", "opengl hook fail : GetError : %d", new Object[] { Integer.valueOf(i4) });
      d.e(1403L, 10L, 1L);
    }
    for (;;)
    {
      release();
      AppMethodBeat.o(209387);
      return;
      OpenGLHook.getInstance().hook("glGenTextures", i);
      OpenGLHook.getInstance().hook("glDeleteTextures", j);
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      ac.i("Gpu.PluginGpuRes", "opengl hook succ : Textures : %d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      d.e(1403L, 13L, 1L);
      break;
      label466:
      OpenGLHook.getInstance().hook("glGenBuffers", k);
      OpenGLHook.getInstance().hook("glDeleteBuffers", m);
      localObject = new int[1];
      GLES20.glGenBuffers(1, (int[])localObject, 0);
      GLES20.glDeleteBuffers(1, (int[])localObject, 0);
      ac.i("Gpu.PluginGpuRes", "opengl hook succ : Buffers : %d,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      d.e(1403L, 14L, 1L);
      break label244;
      label548:
      OpenGLHook.getInstance().hook("glGenFramebuffers", n);
      OpenGLHook.getInstance().hook("glDeleteFramebuffers", i1);
      localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      ac.i("Gpu.PluginGpuRes", "opengl hook succ : Framebuffers : %d,%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      d.e(1403L, 15L, 1L);
      break label292;
      label632:
      OpenGLHook.getInstance().hook("glGenRenderbuffers", i2);
      OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i3);
      localObject = new int[1];
      GLES20.glGenRenderbuffers(1, (int[])localObject, 0);
      GLES20.glDeleteRenderbuffers(1, (int[])localObject, 0);
      ac.i("Gpu.PluginGpuRes", "opengl hook succ : Renderbuffers : %d,%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
      d.e(1403L, 16L, 1L);
      break label340;
      label716:
      OpenGLHook.getInstance().hook("glGetError", i4);
      GLES20.glGetError();
      ac.i("Gpu.PluginGpuRes", "opengl hook succ : GetError : %d", new Object[] { Integer.valueOf(i4) });
      d.e(1403L, 17L, 1L);
    }
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(209393);
    aw localaw = aw.aKT("mmkv_gpu_service_key_muti");
    long l1 = localaw.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localaw.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      ac.i("Gpu.PluginGpuRes", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(1), "OpenGL_Api_Hook", Integer.valueOf(120) });
      try
      {
        GpuHookService.G(ai.getContext(), "OpenGL_Api_Hook");
        AppMethodBeat.o(209393);
        return;
      }
      catch (Exception localException)
      {
        long l2;
        ac.e("Gpu.PluginGpuRes", "GpuHookService.enableGpuHook");
        AppMethodBeat.o(209393);
      }
      l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        ac.e("Gpu.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(209393);
        return;
      }
      localaw.putLong("openGL_api_service_time", l2);
      ac.e("Gpu.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(209391);
    Object localObject1 = new com.tencent.mm.gpu.f.a();
    int i = ((com.tencent.mm.gpu.f.a)localObject1).aeo();
    int j = ((com.tencent.mm.gpu.f.a)localObject1).aen();
    int k = ((com.tencent.mm.gpu.f.a)localObject1).aem();
    Object localObject2 = BitmapFactory.decodeResource(ai.getResources(), 2131234174);
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
    int m = ((com.tencent.mm.gpu.f.a)localObject2).aeo();
    int n = ((com.tencent.mm.gpu.f.a)localObject2).aen();
    int i1 = ((com.tencent.mm.gpu.f.a)localObject2).aem();
    if ((i == m) && (k == i1) && (j == n))
    {
      ac.d("Gpu.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    ac.d("Gpu.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(209391);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(209384);
    dependsOnRoot();
    AppMethodBeat.o(209384);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(209385);
    if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25))
    {
      AppMethodBeat.o(209385);
      return;
    }
    start();
    AppMethodBeat.o(209385);
  }
  
  public void installed()
  {
    AppMethodBeat.i(209383);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(209383);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(209392);
    ac.e("Gpu.PluginGpuRes", "onAccountInitialized start");
    startGpuHookService();
    ac.e("Gpu.PluginGpuRes", "onAccountInitialized end");
    AppMethodBeat.o(209392);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes
 * JD-Core Version:    0.7.0.1
 */