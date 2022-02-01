package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "scanBeforeA8KeyListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1;", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "canSyncWxaUsername", "", "username", "", "checkIfWaitWxaAttrsPreloadDone", "block", "Lkotlin/Function0;", "", "onRegister", "onUnregister", "triggerPreDownload", "scene", "", "appId", "triggerPreDownloadForPath", "path", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "prefetchUsernameList", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b, y
{
  private static final d.a qIO;
  private final PreDownloadServiceExportImpl.wxaQRScanSheetPreloadListener.1 qIP;
  private final PreDownloadServiceExportImpl.scanBeforeA8KeyListener.1 qIQ;
  
  static
  {
    AppMethodBeat.i(180434);
    qIO = new d.a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(320475);
    this.qIP = new PreDownloadServiceExportImpl.wxaQRScanSheetPreloadListener.1(this, f.hfK);
    this.qIQ = new PreDownloadServiceExportImpl.scanBeforeA8KeyListener.1(f.hfK);
    AppMethodBeat.o(320475);
  }
  
  static boolean VG(String paramString)
  {
    AppMethodBeat.i(320479);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (au.Hh(paramString)) && (ag.ax(paramString, false)); i = 0)
    {
      AppMethodBeat.o(320479);
      return true;
    }
    AppMethodBeat.o(320479);
    return false;
  }
  
  public final void VF(String paramString)
  {
    AppMethodBeat.i(320512);
    if (!VG(paramString))
    {
      AppMethodBeat.o(320512);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1342, 2);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yPa, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", s.X("triggerPrefetchChattingItemAppBrandPiece username:", paramString));
      h localh = h.qIX;
      s.checkNotNull(paramString);
      h.a(p.listOf(paramString), q.a.qZz);
    }
    AppMethodBeat.o(320512);
  }
  
  public final void bL(String paramString, int paramInt)
  {
    AppMethodBeat.i(320491);
    String[] arrayOfString = AppBrandGlobalSystemConfig.ckD().qXl;
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    for (;;)
    {
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int j = 1; (j == 0) && (str.equals(paramString)); j = 0)
        {
          Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + paramString + "] blacklist, just return");
          AppMethodBeat.o(320491);
          return;
        }
        i += 1;
      }
      c.a(new c(paramString, paramInt, 2));
      AppMethodBeat.o(320491);
      return;
    }
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(320515);
    this.qIP.alive();
    this.qIQ.alive();
    AppMethodBeat.o(320515);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(320518);
    this.qIP.dead();
    this.qIQ.dead();
    AppMethodBeat.o(320518);
  }
  
  /* Error */
  public final void cM(List<String> paramList)
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 250	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 251	java/util/LinkedList:<init>	()V
    //   12: astore 4
    //   14: aload_1
    //   15: invokeinterface 257 1 0
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface 263 1 0
    //   27: ifeq +89 -> 116
    //   30: aload_1
    //   31: invokeinterface 267 1 0
    //   36: checkcast 202	java/lang/String
    //   39: astore 5
    //   41: aload 5
    //   43: checkcast 100	java/lang/CharSequence
    //   46: astore 6
    //   48: aload 6
    //   50: ifnull +13 -> 63
    //   53: aload 6
    //   55: invokeinterface 104 1 0
    //   60: ifne +51 -> 111
    //   63: iconst_1
    //   64: istore_2
    //   65: iload_2
    //   66: ifne -45 -> 21
    //   69: aload 5
    //   71: invokestatic 273	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   74: ldc_w 274
    //   77: invokevirtual 278	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: invokestatic 120	com/tencent/mm/plugin/appbrand/appcache/predownload/d:VG	(Ljava/lang/String;)Z
    //   87: ifeq -66 -> 21
    //   90: aload 5
    //   92: invokestatic 172	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 281	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   102: pop
    //   103: goto -82 -> 21
    //   106: astore 5
    //   108: goto -87 -> 21
    //   111: iconst_0
    //   112: istore_2
    //   113: goto -48 -> 65
    //   116: aload 4
    //   118: invokevirtual 284	java/util/LinkedList:size	()I
    //   121: ifle +81 -> 202
    //   124: getstatic 126	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   127: sipush 1342
    //   130: iconst_1
    //   131: invokevirtual 130	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   134: getstatic 290	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   137: ifne +9 -> 146
    //   140: getstatic 293	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   143: ifeq +65 -> 208
    //   146: iconst_1
    //   147: istore_3
    //   148: ldc 132
    //   150: invokestatic 137	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   153: checkcast 132	com/tencent/mm/plugin/expt/b/c
    //   156: getstatic 296	com/tencent/mm/plugin/expt/b/c$a:yOY	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   159: iload_3
    //   160: invokeinterface 147 3 0
    //   165: ifeq +37 -> 202
    //   168: ldc 149
    //   170: ldc_w 298
    //   173: aload 4
    //   175: invokevirtual 284	java/util/LinkedList:size	()I
    //   178: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokestatic 157	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: getstatic 168	com/tencent/mm/plugin/appbrand/appcache/predownload/h:qIX	Lcom/tencent/mm/plugin/appbrand/appcache/predownload/h;
    //   190: astore_1
    //   191: aload 4
    //   193: checkcast 253	java/util/List
    //   196: getstatic 307	com/tencent/mm/plugin/appbrand/config/q$a:qZy	Lcom/tencent/mm/plugin/appbrand/config/q$a;
    //   199: invokestatic 187	com/tencent/mm/plugin/appbrand/appcache/predownload/h:a	(Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/config/q$a;)V
    //   202: ldc 248
    //   204: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: return
    //   208: iconst_0
    //   209: istore_3
    //   210: goto -62 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	d
    //   0	213	1	paramList	List<String>
    //   64	49	2	i	int
    //   147	63	3	bool	boolean
    //   12	180	4	localLinkedList	java.util.LinkedList
    //   39	59	5	str	String
    //   106	1	5	localObject	Object
    //   46	8	6	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   69	103	106	finally
  }
  
  public final void cN(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(320510);
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1342, 1);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          bool = true;
        }
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOY, bool))
        {
          Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", s.X("triggerPrefetchMallIndexWeAppV2 list.size:", Integer.valueOf(paramList.size())));
          h localh = h.qIX;
          h.a(paramList, q.a.qZy);
        }
      }
      AppMethodBeat.o(320510);
      return;
    }
  }
  
  public final void chp()
  {
    AppMethodBeat.i(180433);
    if (!VG("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1342, 4);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOZ, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      h localh = h.qIX;
      h.a(p.listOf("gh_8c10d2f0f25e@app"), q.a.qZz);
    }
    AppMethodBeat.o(180433);
  }
  
  public final void y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320500);
    c.a(new c(paramString1, paramString2, paramInt, null));
    AppMethodBeat.o(320500);
  }
  
  public final void z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320496);
    c.a(new c(paramString1, null, paramInt, paramString2));
    AppMethodBeat.o(320496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d
 * JD-Core Version:    0.7.0.1
 */