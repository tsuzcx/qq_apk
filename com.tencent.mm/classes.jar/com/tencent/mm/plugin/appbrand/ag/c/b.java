package com.tencent.mm.plugin.appbrand.ag.c;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.c;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.thumbplayer.api.ITPPlayer;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/AppBrandThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "context", "Landroid/content/Context;", "mainLooper", "Landroid/os/Looper;", "mp4Only", "", "(Landroid/content/Context;Landroid/os/Looper;Z)V", "resourceLoader", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader;", "notifyOnError", "what", "", "extra", "pause", "", "prepareAsync", "release", "replaceResourceLoader", "setDataSource", "path", "", "referrer", "setDataSourceAsync", "onDataSourceSetListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnDataSourceSetListener;", "start", "startDownload", "stop", "stopDownload", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.appbrand.ag.b.a.a
{
  private static int lNX;
  public static final a utm;
  private static final int uto;
  private h utn;
  
  static
  {
    AppMethodBeat.i(318036);
    utm = new a((byte)0);
    c localc = (c)com.tencent.mm.kernel.h.ax(c.class);
    if (localc != null)
    {
      int j = localc.a(c.a.yPP, 16);
      i = j;
      if (-1 != j) {}
    }
    for (int i = 2147483647;; i = 16)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getTotalTPPlayerCountThreshold, ".concat(String.valueOf(i)));
      uto = i;
      AppMethodBeat.o(318036);
      return;
    }
  }
  
  private b(Context paramContext, Looper paramLooper, boolean paramBoolean)
  {
    super(paramContext, paramLooper, paramBoolean);
  }
  
  private final h a(h paramh)
  {
    try
    {
      AppMethodBeat.i(317911);
      stopDownload();
      this.utn = paramh;
      AppMethodBeat.o(317911);
      return paramh;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  private static final void a(b paramb, String paramString1, String paramString2, g.c paramc)
  {
    AppMethodBeat.i(317953);
    s.u(paramb, "this$0");
    paramb.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(317953);
  }
  
  public static final b b(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(317967);
    a locala = utm;
    s.u(paramContext, "context");
    paramContext = a.a(locala, paramContext, paramLooper, false, 4);
    AppMethodBeat.o(317967);
    return paramContext;
  }
  
  private final void startDownload()
  {
    try
    {
      AppMethodBeat.i(317921);
      h localh = this.utn;
      if (localh != null) {
        localh.startDownload();
      }
      AppMethodBeat.o(317921);
      return;
    }
    finally {}
  }
  
  /* Error */
  private final void stopDownload()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 165
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 132	com/tencent/mm/plugin/appbrand/ag/c/b:utn	Lcom/tencent/mm/plugin/appbrand/ag/c/h;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +54 -> 67
    //   16: aload_1
    //   17: getfield 169	com/tencent/mm/plugin/appbrand/ag/c/h:utF	Lcom/tencent/mm/plugin/appbrand/ag/c/g$b;
    //   20: getfield 175	com/tencent/mm/plugin/appbrand/ag/c/g$b:utB	Lcom/tencent/mm/plugin/appbrand/ag/c/g$a;
    //   23: getfield 181	com/tencent/mm/plugin/appbrand/ag/c/g$a:utA	Z
    //   26: ifne +32 -> 58
    //   29: aload_1
    //   30: getfield 185	com/tencent/mm/plugin/appbrand/ag/c/h:djQ	Ljava/lang/String;
    //   33: ldc 186
    //   35: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: getstatic 192	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utK	Lcom/tencent/mm/plugin/appbrand/ag/c/h$a$a;
    //   41: astore_2
    //   42: aload_1
    //   43: aload_1
    //   44: getfield 195	com/tencent/mm/plugin/appbrand/ag/c/h:utz	Ljava/lang/String;
    //   47: invokestatic 198	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   50: ldc 165
    //   52: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_1
    //   59: getfield 185	com/tencent/mm/plugin/appbrand/ag/c/h:djQ	Ljava/lang/String;
    //   62: ldc 200
    //   64: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc 165
    //   69: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -17 -> 55
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   11	48	1	localh	h
    //   75	4	1	localObject	Object
    //   41	1	2	locala	h.a.a
    // Exception table:
    //   from	to	target	type
    //   2	12	75	finally
    //   16	55	75	finally
    //   58	67	75	finally
    //   67	72	75	finally
  }
  
  public final void a(String paramString1, String paramString2, g.c paramc)
  {
    AppMethodBeat.i(318089);
    if (com.tencent.mm.plugin.appbrand.jsapi.video.e.f.cwx())
    {
      com.tencent.threadpool.h.ahAA.bm(new b..ExternalSyntheticLambda0(this, paramString1, paramString2, paramc));
      AppMethodBeat.o(318089);
      return;
    }
    super.a(paramString1, paramString2, paramc);
    AppMethodBeat.o(318089);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318075);
    s.u(paramString1, "path");
    Object localObject1 = f.uts;
    localObject1 = t.raH;
    label50:
    int i;
    label61:
    int j;
    label74:
    int k;
    if (t.bnM())
    {
      localObject1 = f.utv;
      localObject2 = (c)com.tencent.mm.kernel.h.ax(c.class);
      if (localObject2 != null) {
        break label184;
      }
      localObject2 = null;
      if (localObject2 != null) {
        break label207;
      }
      i = f.a((f)localObject1);
      localObject3 = f.values();
      int m = localObject3.length;
      j = 0;
      if (j >= m) {
        break label231;
      }
      localObject2 = localObject3[j];
      if (i != f.a((f)localObject2)) {
        break label216;
      }
      k = 1;
      label100:
      if (k == 0) {
        break label222;
      }
      label105:
      if (localObject2 != null) {
        break label237;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.TPDownloadStrategy", s.X("get, strategy: ", localObject1));
      if (f.utt != localObject1) {
        break label244;
      }
      Log.i("MicroMsg.AppBrandThumbMediaPlayer", "setDataSource, path: " + paramString1 + ", not proxy");
      com.tencent.mm.plugin.appbrand.ag.b.a.a.a((com.tencent.mm.plugin.appbrand.ag.b.a.a)this, paramString1, paramString2, false);
      AppMethodBeat.o(318075);
      return;
      localObject1 = f.utt;
      break;
      label184:
      localObject2 = Integer.valueOf(((c)localObject2).a(c.a.yPO, f.a((f)localObject1)));
      break label50;
      label207:
      i = ((Integer)localObject2).intValue();
      break label61;
      label216:
      k = 0;
      break label100;
      label222:
      j += 1;
      break label74;
      label231:
      localObject2 = null;
      break label105;
      label237:
      localObject1 = localObject2;
    }
    label244:
    Object localObject2 = new e(paramString1);
    Object localObject3 = i.utX;
    boolean bool = i.a((e)localObject2);
    localObject2 = ((e)localObject2).hqM;
    Log.i("MicroMsg.AppBrandThumbMediaPlayer", "setDataSource, path: " + paramString1 + ", isHls: " + bool + ", realSrc: " + (String)localObject2);
    if (bool)
    {
      com.tencent.mm.plugin.appbrand.ag.b.a.a.a((com.tencent.mm.plugin.appbrand.ag.b.a.a)this, (String)localObject2, paramString2, false);
      AppMethodBeat.o(318075);
      return;
    }
    switch (b.b.$EnumSwitchMapping$0[localObject1.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(318075);
      return;
      com.tencent.mm.plugin.appbrand.ag.b.a.a.a((com.tencent.mm.plugin.appbrand.ag.b.a.a)this, (String)localObject2, paramString2, false);
      AppMethodBeat.o(318075);
      return;
      com.tencent.mm.plugin.appbrand.ag.b.a.a.a((com.tencent.mm.plugin.appbrand.ag.b.a.a)this, (String)localObject2, paramString2, true);
      AppMethodBeat.o(318075);
      return;
      cNU().enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)a(new h(paramString1, (m)new b.c(this))));
      b((String)localObject2, paramString2, true, 11);
    }
  }
  
  public final boolean fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(318142);
    boolean bool1 = super.fB(paramInt1, paramInt2);
    Object localObject1 = this.utn;
    if (localObject1 != null)
    {
      Log.i(((h)localObject1).djQ, "onError");
      Object localObject2 = g.utx;
      localObject1 = ((h)localObject1).utF;
      s.u(localObject1, "cacheInfoHolder");
      localObject2 = ((g.b)localObject1).utB;
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("onCacheError, cacheInfo: ", localObject2));
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("onCacheError, cacheDeleted: ", Boolean.valueOf(new u(g.cOb(), s.X(((g.a)localObject2).utz, ".res")).diJ())));
      String str = ((g.a)localObject2).utz;
      boolean bool2 = new u(g.cOb(), s.X(str, ".mark")).diJ();
      boolean bool3 = new u(g.cOb(), s.X(str, ".temp.mark")).diJ();
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "clearMark, markDeleted: " + bool2 + ", tempMarkDeleted: " + bool3);
      ((g.b)localObject1).b(g.a.a((g.a)localObject2, false));
    }
    AppMethodBeat.o(318142);
    return bool1;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(318119);
    super.pause();
    stopDownload();
    AppMethodBeat.o(318119);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(318100);
    super.prepareAsync();
    startDownload();
    AppMethodBeat.o(318100);
  }
  
  public final void release()
  {
    AppMethodBeat.i(318134);
    super.release();
    stopDownload();
    synchronized (utm)
    {
      Log.d("MicroMsg.AppBrandThumbMediaPlayer", "onRelease, totalCount: " + lNX + ", TOTAL_PLAYER_COUNT_THRESHOLD: " + uto);
      lNX -= 1;
      AppMethodBeat.o(318134);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(318111);
    super.start();
    startDownload();
    AppMethodBeat.o(318111);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(318126);
    super.stop();
    stopDownload();
    AppMethodBeat.o(318126);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/AppBrandThumbMediaPlayer$Companion;", "", "()V", "DEFAULT_TOTAL_PLAYER_COUNT_THRESHOLD", "", "TAG", "", "TOTAL_PLAYER_COUNT_THRESHOLD", "totalCount", "create", "Lcom/tencent/mm/plugin/appbrand/video/thumb/AppBrandThumbMediaPlayer;", "context", "Landroid/content/Context;", "mainLooper", "Landroid/os/Looper;", "mp4Only", "", "onRelease", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private b a(Context paramContext, Looper paramLooper, boolean paramBoolean)
    {
      AppMethodBeat.i(317888);
      s.u(paramContext, "context");
      try
      {
        Log.d("MicroMsg.AppBrandThumbMediaPlayer", "create, totalCount: " + b.cNZ() + ", TOTAL_PLAYER_COUNT_THRESHOLD: " + b.cOa());
        if (b.cOa() <= b.cNZ())
        {
          Log.i("MicroMsg.AppBrandThumbMediaPlayer", "create, reach limit");
          return null;
        }
        a locala = b.utm;
        b.DM(b.cNZ() + 1);
        paramContext = new b(paramContext, paramLooper, paramBoolean, (byte)0);
        AppMethodBeat.o(317888);
        return paramContext;
      }
      finally
      {
        AppMethodBeat.o(317888);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.b
 * JD-Core Version:    0.7.0.1
 */