package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "downloadMgr", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "getDownloadMgr", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "setDownloadMgr", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;)V", "isEnablePlayInMobileNet", "", "videoService", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "getVideoService", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "setVideoService", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;)V", "isNetworkEnable", "isWifi", "setEnablePlayInMobileNet", "", "enable", "Companion", "plugin-flutter_release"})
public final class e
{
  private static e tjl;
  public static final a tjm;
  private final String TAG;
  boolean tji;
  b tjj;
  c tjk;
  
  static
  {
    AppMethodBeat.i(219191);
    tjm = new a((byte)0);
    AppMethodBeat.o(219191);
  }
  
  public e()
  {
    AppMethodBeat.i(219190);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.tjj = new b(localContext);
    this.tjk = new c();
    AppMethodBeat.o(219190);
  }
  
  public static boolean cQs()
  {
    AppMethodBeat.i(219188);
    if (aj.getContext() != null)
    {
      boolean bool = NetUtil.isNetAvailable(aj.getContext());
      AppMethodBeat.o(219188);
      return bool;
    }
    AppMethodBeat.o(219188);
    return false;
  }
  
  public static boolean chr()
  {
    AppMethodBeat.i(219189);
    if (aj.getContext() != null)
    {
      boolean bool = NetUtil.isWifi(aj.getContext());
      AppMethodBeat.o(219189);
      return bool;
    }
    AppMethodBeat.o(219189);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    /* Error */
    public final e cQu()
    {
      // Byte code:
      //   0: ldc 30
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 39	com/tencent/mm/plugin/flutter/e/e:cQt	()Lcom/tencent/mm/plugin/flutter/e/e;
      //   8: astore_1
      //   9: aload_1
      //   10: ifnull +10 -> 20
      //   13: ldc 30
      //   15: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   18: aload_1
      //   19: areturn
      //   20: aload_0
      //   21: monitorenter
      //   22: invokestatic 39	com/tencent/mm/plugin/flutter/e/e:cQt	()Lcom/tencent/mm/plugin/flutter/e/e;
      //   25: astore_1
      //   26: aload_1
      //   27: ifnull +12 -> 39
      //   30: aload_0
      //   31: monitorexit
      //   32: ldc 30
      //   34: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aload_1
      //   38: areturn
      //   39: new 6	com/tencent/mm/plugin/flutter/e/e
      //   42: dup
      //   43: invokespecial 43	com/tencent/mm/plugin/flutter/e/e:<init>	()V
      //   46: astore_1
      //   47: aload_1
      //   48: invokestatic 46	com/tencent/mm/plugin/flutter/e/e:a	(Lcom/tencent/mm/plugin/flutter/e/e;)V
      //   51: goto -21 -> 30
      //   54: astore_1
      //   55: aload_0
      //   56: monitorexit
      //   57: ldc 30
      //   59: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: aload_1
      //   63: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   8	40	1	locale	e
      //   54	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   22	26	54	finally
      //   39	51	54	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.e
 * JD-Core Version:    0.7.0.1
 */