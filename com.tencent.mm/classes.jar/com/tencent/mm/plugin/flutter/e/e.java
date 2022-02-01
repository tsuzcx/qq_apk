package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "downloadMgr", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "getDownloadMgr", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "setDownloadMgr", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;)V", "isEnablePlayInMobileNet", "", "videoService", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "getVideoService", "()Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "setVideoService", "(Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;)V", "isNetworkEnable", "isWifi", "setEnablePlayInMobileNet", "", "enable", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a HlR;
  private static e HlV;
  boolean HlS;
  b HlT;
  c HlU;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(263081);
    HlR = new a((byte)0);
    AppMethodBeat.o(263081);
  }
  
  public e()
  {
    AppMethodBeat.i(263060);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    this.HlT = new b(localContext);
    this.HlU = new c();
    AppMethodBeat.o(263060);
  }
  
  public static boolean fvh()
  {
    AppMethodBeat.i(263064);
    if (MMApplicationContext.getContext() != null)
    {
      boolean bool = NetUtil.isNetAvailable(MMApplicationContext.getContext());
      AppMethodBeat.o(263064);
      return bool;
    }
    AppMethodBeat.o(263064);
    return false;
  }
  
  public static boolean fvi()
  {
    AppMethodBeat.i(263068);
    if (MMApplicationContext.getContext() != null)
    {
      boolean bool = NetUtil.isWifi(MMApplicationContext.getContext());
      AppMethodBeat.o(263068);
      return bool;
    }
    AppMethodBeat.o(263068);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayerMgr;", "getInstance", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    /* Error */
    public final e fvk()
    {
      // Byte code:
      //   0: ldc 33
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 42	com/tencent/mm/plugin/flutter/e/e:fvj	()Lcom/tencent/mm/plugin/flutter/e/e;
      //   8: astore_1
      //   9: aload_1
      //   10: ifnull +10 -> 20
      //   13: ldc 33
      //   15: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   18: aload_1
      //   19: areturn
      //   20: aload_0
      //   21: monitorenter
      //   22: invokestatic 42	com/tencent/mm/plugin/flutter/e/e:fvj	()Lcom/tencent/mm/plugin/flutter/e/e;
      //   25: astore_1
      //   26: aload_1
      //   27: ifnull +12 -> 39
      //   30: aload_0
      //   31: monitorexit
      //   32: ldc 33
      //   34: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aload_1
      //   38: areturn
      //   39: new 6	com/tencent/mm/plugin/flutter/e/e
      //   42: dup
      //   43: invokespecial 46	com/tencent/mm/plugin/flutter/e/e:<init>	()V
      //   46: astore_1
      //   47: getstatic 50	com/tencent/mm/plugin/flutter/e/e:HlR	Lcom/tencent/mm/plugin/flutter/e/e$a;
      //   50: astore_2
      //   51: aload_1
      //   52: invokestatic 53	com/tencent/mm/plugin/flutter/e/e:a	(Lcom/tencent/mm/plugin/flutter/e/e;)V
      //   55: goto -25 -> 30
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: ldc 33
      //   63: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	a
      //   8	44	1	locale	e
      //   58	9	1	localObject	Object
      //   50	1	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   22	26	58	finally
      //   39	55	58	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.e
 * JD-Core Version:    0.7.0.1
 */