package com.tencent.mm.gpu;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.openglapihook.OpenGLInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public class PluginGpuRes
  extends f
  implements com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.b.a.a
{
  private static int jUO = 0;
  private static boolean jUQ = false;
  private String[] jUM;
  private boolean jUN;
  private String jUP;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(210924);
    this.jUM = new String[] { com.tencent.mm.gpu.b.a.jUS };
    this.jUN = false;
    this.jUP = "GPU_MEMORY_OPENGL_HOOK";
    AppMethodBeat.o(210924);
  }
  
  public static int getCurrSpend()
  {
    return jUO / 60000;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(210940);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(210940);
      return false;
    }
    String[] arrayOfString = this.jUM;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(210940);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(210940);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return jUQ;
  }
  
  private static void skipCurrentModel()
  {
    jUQ = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(210936);
    Log.d("MicroMsg.PluginGpuRes", "PluginGpuRes execute");
    if (this.jUN)
    {
      Log.e("MicroMsg.PluginGpuRes", "PluginGpuRes have start(), re entry start() maybe error");
      AppMethodBeat.o(210936);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV1 = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    MultiProcessMMKV localMultiProcessMMKV2 = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
    int i;
    if (localMultiProcessMMKV2.getInt("glGetErrorOOM_is_die", 0) == 1)
    {
      i = com.tencent.mm.gpu.f.c.Me(MMApplicationContext.getProcessName());
      if (i != -1)
      {
        int j = getCurrSpend();
        if (j > 0) {
          break label123;
        }
        Log.e("MicroMsg.GpuResReport", "spend error, spend = ".concat(String.valueOf(j)));
      }
    }
    for (;;)
    {
      localMultiProcessMMKV2.putInt("glGetErrorOOM_is_die", 0);
      localMultiProcessMMKV2.commit();
      if (isInWhiteList(MMApplicationContext.getProcessName())) {
        break;
      }
      AppMethodBeat.o(210936);
      return;
      label123:
      com.tencent.mm.gpu.f.c.f(i, 137L, 1L);
    }
    com.tencent.e.h.ZvG.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210831);
        PluginGpuRes.access$002(PluginGpuRes.jUO + 1800000);
        AppMethodBeat.o(210831);
      }
    }, 1800000L, 1800000L);
    Object localObject = new com.tencent.mm.gpu.f.b();
    com.tencent.mm.gpu.f.a locala = new com.tencent.mm.gpu.f.a();
    com.tencent.e.h.ZvG.b((Runnable)localObject, 1800000L, 1800000L);
    com.tencent.e.h.ZvG.b(locala, 1800000L, 1800000L);
    testMemoryShake();
    localObject = com.tencent.mm.gpu.h.a.aEU();
    if (((com.tencent.mm.gpu.h.a)localObject).jVu) {
      Log.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
    }
    for (;;)
    {
      bool1 = localMultiProcessMMKV1.getBoolean("key_has_function_seek_start", false);
      boolean bool2 = localMultiProcessMMKV1.getBoolean("key_finish_function_seek", false);
      Log.e("MicroMsg.PluginGpuRes", "hasStart = " + bool1 + " : hasFinish = " + bool2);
      if (!bool1) {
        break label459;
      }
      if (!bool2) {
        break label489;
      }
      com.tencent.mm.gpu.f.c.aEN();
      i = localMultiProcessMMKV2.getInt("openGL_api_hook_flag", -1);
      if ((i == -1) || (i == 1)) {
        break;
      }
      Log.e("MicroMsg.PluginGpuRes", "has fail before");
      AppMethodBeat.o(210936);
      return;
      if (isSkipModel())
      {
        Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
      }
      else
      {
        Log.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
        com.tencent.e.h.ZvG.b((Runnable)localObject, 1800000L, 1800000L);
        ((com.tencent.mm.gpu.h.a)localObject).jVu = true;
      }
    }
    localMultiProcessMMKV2.putInt("openGL_api_hook_flag", 2);
    localMultiProcessMMKV2.commit();
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtQ, true);
    Log.i("MicroMsg.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(bool1)));
    if (bool1)
    {
      Log.e("MicroMsg.PluginGpuRes", "open opengl hook");
      startGLHook();
      startLeakMonitor();
      localMultiProcessMMKV2.putInt("openGL_api_hook_flag", 1);
      localMultiProcessMMKV2.commit();
    }
    for (;;)
    {
      label459:
      this.jUN = true;
      Log.d("MicroMsg.PluginGpuRes", "PluginGpuRes execute end");
      AppMethodBeat.o(210936);
      return;
      Log.e("MicroMsg.PluginGpuRes", "close opengl hook");
      break;
      label489:
      com.tencent.mm.gpu.f.c.aEO();
    }
  }
  
  private void startGLHook()
  {
    AppMethodBeat.i(210939);
    com.tencent.mm.gpu.c.a.hook();
    AppMethodBeat.o(210939);
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(210943);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    long l1 = localMultiProcessMMKV.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localMultiProcessMMKV.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      com.tencent.mm.gpu.c.a.aEI();
      AppMethodBeat.o(210943);
      return;
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        Log.e("MicroMsg.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(210943);
        return;
      }
      localMultiProcessMMKV.putLong("openGL_api_service_time", l2);
      Log.e("MicroMsg.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private void startLeakMonitor()
  {
    AppMethodBeat.i(210937);
    com.tencent.mm.openglapihook.a.a.a(new com.tencent.mm.openglapihook.a.a.a()
    {
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210692);
        Log.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(210692);
      }
    });
    com.tencent.mm.openglapihook.a.bul();
    com.tencent.mm.openglapihook.a.a(new com.tencent.mm.openglapihook.a.a()
    {
      public final void a(OpenGLInfo paramAnonymousOpenGLInfo)
      {
        AppMethodBeat.i(210768);
        Log.e("MicroMsg.PluginGpuRes", "onMaybeLeak:".concat(String.valueOf(paramAnonymousOpenGLInfo)));
        AppMethodBeat.o(210768);
      }
      
      public final void b(OpenGLInfo paramAnonymousOpenGLInfo)
      {
        AppMethodBeat.i(210769);
        String str = paramAnonymousOpenGLInfo.bum();
        Object localObject1;
        int i;
        Object localObject2;
        if (str != null)
        {
          localObject1 = str.split("\n");
          if (localObject1.length > 0)
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).contains("libopenglapihook.so")) && (!((String)localObject2).contains("libhwui.so")) && (!((String)localObject2).contains("libutils.so")) && (!((String)localObject2).contains("libandroid_runtime.so")) && (!((String)localObject2).contains("libc.so")))
              {
                i = 0;
                label108:
                str = str.replace(" ", "_").replace("\n", ";").replace("\t", "").replace(",", "?");
              }
            }
          }
        }
        for (;;)
        {
          localObject1 = paramAnonymousOpenGLInfo.mxx;
          if ((i != 0) && (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Log.e("MicroMsg.PluginGpuRes", "ignore onLeak:".concat(String.valueOf(paramAnonymousOpenGLInfo)));
            AppMethodBeat.o(210769);
            return;
            i += 1;
            break;
          }
          Log.e("MicroMsg.PluginGpuRes", "handle onLeak:".concat(String.valueOf(paramAnonymousOpenGLInfo)));
          if (localObject1 != null) {
            localObject1 = ((String)localObject1).replace(" ", "_").replace("\n", ";").replace("\t", "");
          }
          for (;;)
          {
            localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
            paramAnonymousOpenGLInfo = paramAnonymousOpenGLInfo.activityName;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
            for (boolean bool = true;; bool = false)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(19854, new Object[] { paramAnonymousOpenGLInfo, Boolean.valueOf(bool), localObject1, Integer.valueOf(0), Integer.valueOf(0), str });
              AppMethodBeat.o(210769);
              return;
            }
          }
          i = 1;
          break label108;
          i = 1;
        }
      }
    });
    com.tencent.mm.openglapihook.a.bul();
    com.tencent.mm.openglapihook.a.k((Application)MMApplicationContext.getContext());
    AppMethodBeat.o(210937);
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(210949);
    Object localObject1 = new com.tencent.mm.gpu.g.a();
    int i = ((com.tencent.mm.gpu.g.a)localObject1).aER();
    int j = ((com.tencent.mm.gpu.g.a)localObject1).aEQ();
    int k = ((com.tencent.mm.gpu.g.a)localObject1).aEP();
    Object localObject2 = BitmapFactory.decodeResource(MMApplicationContext.getResources(), a.a.sqlite_lint_icon);
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
    localObject2 = new com.tencent.mm.gpu.g.a();
    int m = ((com.tencent.mm.gpu.g.a)localObject2).aER();
    int n = ((com.tencent.mm.gpu.g.a)localObject2).aEQ();
    int i1 = ((com.tencent.mm.gpu.g.a)localObject2).aEP();
    if ((i == m) && (k == i1) && (j == n))
    {
      Log.d("MicroMsg.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    Log.d("MicroMsg.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(210949);
  }
  
  public void action(double paramDouble)
  {
    AppMethodBeat.i(210945);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtM, true);
    Log.i("MicroMsg.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(210945);
      return;
    }
    startGpuHookService();
    Log.e("MicroMsg.PluginGpuRes", "sample success & do action");
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210875);
        PluginGpuRes.access$100(PluginGpuRes.this);
        AppMethodBeat.o(210875);
      }
    });
    AppMethodBeat.o(210945);
  }
  
  public void configure(g paramg) {}
  
  public long cycleMinutes()
  {
    return 0L;
  }
  
  public void dependency()
  {
    AppMethodBeat.i(210928);
    dependsOnRoot();
    AppMethodBeat.o(210928);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(210932);
    if (BuildInfo.IS_ARM64)
    {
      if ((BuildInfo.IS_FLAVOR_RED) || (d.RAG))
      {
        com.tencent.mm.plugin.performance.b.a.GNv.a(this);
        AppMethodBeat.o(210932);
        return;
      }
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtP, true))
      {
        AppMethodBeat.o(210932);
        return;
      }
      com.tencent.mm.plugin.performance.b.a.GNv.a(this);
    }
    AppMethodBeat.o(210932);
  }
  
  public void installed()
  {
    AppMethodBeat.i(210927);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(210927);
  }
  
  public String key()
  {
    return this.jUP;
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
  
  public double rate()
  {
    AppMethodBeat.i(210947);
    if ((BuildInfo.IS_FLAVOR_RED) || (d.RAG)) {}
    for (long l = 1L; l <= 0L; l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtH, 100000000L))
    {
      Log.e("MicroMsg.PluginGpuRes", "denominator <= -0L, does not need to rate()");
      AppMethodBeat.o(210947);
      return -1.0D;
    }
    double d = 1.0D / l;
    AppMethodBeat.o(210947);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes
 * JD-Core Version:    0.7.0.1
 */