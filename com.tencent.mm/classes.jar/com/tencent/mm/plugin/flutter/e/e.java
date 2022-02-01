package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "downloadMgr", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "getDownloadMgr", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "setDownloadMgr", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;)V", "isEnablePlayInMobileNet", "", "videoService", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "getVideoService", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "setVideoService", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;)V", "isNetworkEnable", "isWifi", "setEnablePlayInMobileNet", "", "enable", "Companion", "plugin-flutter_release"})
public final class e
{
  private static e tud;
  public static final a tue;
  private final String TAG;
  boolean tua;
  b tub;
  c tuc;
  
  static
  {
    AppMethodBeat.i(213520);
    tue = new a((byte)0);
    AppMethodBeat.o(213520);
  }
  
  public e()
  {
    AppMethodBeat.i(213519);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.tub = new b(localContext);
    this.tuc = new c();
    AppMethodBeat.o(213519);
  }
  
  public static boolean cSX()
  {
    AppMethodBeat.i(213517);
    if (ak.getContext() != null)
    {
      boolean bool = NetUtil.isNetAvailable(ak.getContext());
      AppMethodBeat.o(213517);
      return bool;
    }
    AppMethodBeat.o(213517);
    return false;
  }
  
  public static boolean ciH()
  {
    AppMethodBeat.i(213518);
    if (ak.getContext() != null)
    {
      boolean bool = NetUtil.isWifi(ak.getContext());
      AppMethodBeat.o(213518);
      return bool;
    }
    AppMethodBeat.o(213518);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    /* Error */
    public final e cSZ()
    {
      // Byte code:
      //   0: ldc 30
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 39	com/tencent/mm/plugin/flutter/e/e:cSY	()Lcom/tencent/mm/plugin/flutter/e/e;
      //   8: astore_1
      //   9: aload_1
      //   10: ifnull +10 -> 20
      //   13: ldc 30
      //   15: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   18: aload_1
      //   19: areturn
      //   20: aload_0
      //   21: monitorenter
      //   22: invokestatic 39	com/tencent/mm/plugin/flutter/e/e:cSY	()Lcom/tencent/mm/plugin/flutter/e/e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.e
 * JD-Core Version:    0.7.0.1
 */