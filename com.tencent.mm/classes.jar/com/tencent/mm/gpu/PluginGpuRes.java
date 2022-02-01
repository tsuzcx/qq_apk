package com.tencent.mm.gpu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;

public class PluginGpuRes
  extends f
  implements com.tencent.mm.gpu.a.a, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.performance.dice.a.a
{
  private static int mvc = 0;
  private static boolean mve = false;
  private String[] mva;
  private boolean mvb;
  private String mvd;
  
  public PluginGpuRes()
  {
    AppMethodBeat.i(231755);
    this.mva = new String[] { com.tencent.mm.gpu.b.a.mvg };
    this.mvb = false;
    this.mvd = "GPU_MEMORY_OPENGL_HOOK";
    AppMethodBeat.o(231755);
  }
  
  public static int getCurrSpend()
  {
    return mvc / 60000;
  }
  
  private boolean isInWhiteList(String paramString)
  {
    AppMethodBeat.i(231771);
    if ((paramString == null) || ("".equals(paramString)))
    {
      AppMethodBeat.o(231771);
      return false;
    }
    String[] arrayOfString = this.mva;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(231771);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(231771);
    return false;
  }
  
  public static boolean isSkipModel()
  {
    return mve;
  }
  
  private static void skipCurrentModel()
  {
    mve = true;
  }
  
  private void start()
  {
    AppMethodBeat.i(231759);
    Log.d("MicroMsg.PluginGpuRes", "PluginGpuRes execute");
    if (this.mvb)
    {
      Log.e("MicroMsg.PluginGpuRes", "PluginGpuRes have start(), re entry start() maybe error");
      AppMethodBeat.o(231759);
      return;
    }
    AppMethodBeat.o(231759);
  }
  
  private void startGLHook()
  {
    AppMethodBeat.i(231763);
    com.tencent.mm.gpu.c.a.hook();
    AppMethodBeat.o(231763);
  }
  
  private void startGpuHookService()
  {
    AppMethodBeat.i(231777);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    long l1 = localMultiProcessMMKV.getLong("openGL_api_service_time", -1L);
    if (l1 == -1L) {
      localMultiProcessMMKV.putLong("openGL_api_service_time", System.currentTimeMillis());
    }
    for (;;)
    {
      com.tencent.mm.gpu.c.a.aXN();
      AppMethodBeat.o(231777);
      return;
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < 604800000L)
      {
        Log.e("MicroMsg.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
        AppMethodBeat.o(231777);
        return;
      }
      localMultiProcessMMKV.putLong("openGL_api_service_time", l2);
      Log.e("MicroMsg.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
    }
  }
  
  private static void testMemoryShake()
  {
    AppMethodBeat.i(231780);
    Object localObject1 = new com.tencent.mm.gpu.e.a();
    int i = ((com.tencent.mm.gpu.e.a)localObject1).aXS();
    int j = ((com.tencent.mm.gpu.e.a)localObject1).aXR();
    int k = ((com.tencent.mm.gpu.e.a)localObject1).aXQ();
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
    localObject2 = new com.tencent.mm.gpu.e.a();
    int m = ((com.tencent.mm.gpu.e.a)localObject2).aXS();
    int n = ((com.tencent.mm.gpu.e.a)localObject2).aXR();
    int i1 = ((com.tencent.mm.gpu.e.a)localObject2).aXQ();
    if ((i == m) && (k == i1) && (j == n))
    {
      Log.d("MicroMsg.PluginGpuRes", "testMemoryShake: init == new");
      skipCurrentModel();
    }
    Log.d("MicroMsg.PluginGpuRes", "testMemoryShake: init != new");
    GLES20.glDeleteTextures(1, (int[])localObject1, 0);
    AppMethodBeat.o(231780);
  }
  
  public void action(double paramDouble)
  {
    AppMethodBeat.i(231798);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGq, true);
    Log.i("MicroMsg.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(231798);
      return;
    }
    Log.e("MicroMsg.PluginGpuRes", "sample success & do action");
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231757);
        PluginGpuRes.access$000(PluginGpuRes.this);
        AppMethodBeat.o(231757);
      }
    });
    AppMethodBeat.o(231798);
  }
  
  public void configure(g paramg) {}
  
  public long cycleMinutes()
  {
    return 0L;
  }
  
  public void dependency()
  {
    AppMethodBeat.i(231789);
    dependsOnRoot();
    AppMethodBeat.o(231789);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(231792);
    if (((Build.VERSION.SDK_INT == 29) || (Build.VERSION.SDK_INT == 30)) && ((MMApplicationContext.isMainProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isAppBrandProcess())) && (Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_background_graphic_release", "0"), 0) > 0))
    {
      com.tencent.mm.z.a.a.start();
      Log.i("MicroMsg.PluginGpuRes", "[OpenglLeakPlugin: GraphicCacheRelease start success]");
    }
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(231792);
      return;
    }
    AppMethodBeat.o(231792);
  }
  
  public void installed()
  {
    AppMethodBeat.i(231787);
    alias(com.tencent.mm.gpu.a.a.class);
    AppMethodBeat.o(231787);
  }
  
  public String key()
  {
    return this.mvd;
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
  
  public double rate()
  {
    AppMethodBeat.i(231802);
    if ((BuildInfo.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.Yxk)) {}
    for (long l = 1L; l <= 0L; l = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGl, 100000000L))
    {
      Log.e("MicroMsg.PluginGpuRes", "denominator <= -0L, does not need to rate()");
      AppMethodBeat.o(231802);
      return -1.0D;
    }
    double d = 1.0D / l;
    AppMethodBeat.o(231802);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes
 * JD-Core Version:    0.7.0.1
 */