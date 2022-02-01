package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.r;
import com.tencent.mm.b.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.webview.l.c.b;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic;", "", "()V", "PRELOAD_MAX_BYTES", "", "PRELOAD_MIN_BYTES", "TAG", "", "abTest", "", "getAbTest", "()Z", "abTest$delegate", "Lkotlin/Lazy;", "doingCache", "getDoingCache", "setDoingCache", "(Z)V", "fetchQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "getFetchQueue", "()Ljava/util/LinkedList;", "jsContextStatus", "", "getJsContextStatus", "()I", "setJsContextStatus", "(I)V", "lastManifestId", "getLastManifestId", "()Ljava/lang/String;", "setLastManifestId", "(Ljava/lang/String;)V", "lruList", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Landroid/os/Bundle;", "getLruList", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "preloadLimiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getPreloadLimiter", "()Lcom/tencent/mm/modelbiz/MpDataLimiter;", "cacheVideo", "", "data", "processName", "url", "position", "length", "cacheVideoInClientProcess", "doCacheVideo", "doFetch", "preloadVideo", "itemShowType", "extInfo", "getLatest", "kotlin.jvm.PlatformType", "FetchData", "JsStatus", "plugin-brandservice_release"})
public final class e
{
  private static final kotlin.f pAG;
  private static final r pAH;
  private static final LinkedList<a> pAI;
  private static int pAJ;
  private static String pAK;
  private static boolean pAL;
  private static final h<String, Bundle> pAM;
  public static final e pAN;
  
  static
  {
    AppMethodBeat.i(195597);
    pAN = new e();
    pAG = g.ah((kotlin.g.a.a)e.b.pAR);
    if (BuildInfo.DEBUG) {}
    for (int i = 1000;; i = 600000)
    {
      pAH = new r(i);
      pAI = new LinkedList();
      pAJ = 1;
      pAK = "";
      com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().hQ(cnF());
      String str = ToolsMpProcessIPCService.dkO;
      p.g(str, "ToolsMpProcessIPCService.PROCESS_NAME");
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("abTest", cnF());
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)e.1.pAO, null);
      str = Appbrand0IPCService.dkO;
      p.g(str, "Appbrand0IPCService.PROCESS_NAME");
      localBundle = new Bundle();
      localBundle.putBoolean("abTest", cnF());
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)e.2.pAP, null);
      pAM = new h(10);
      AppMethodBeat.o(195597);
      return;
    }
  }
  
  public static void Dn(int paramInt)
  {
    pAJ = paramInt;
  }
  
  public static void F(String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(195593);
    if (!cnF())
    {
      AppMethodBeat.o(195593);
      return;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(195593);
      return;
    }
    if (!UrlExKt.isMpArticleUrl(paramString1))
    {
      AppMethodBeat.o(195593);
      return;
    }
    if ((paramInt < 0) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(195593);
      return;
    }
    String str = c.ahX(paramString1);
    if (pAH.contains(str))
    {
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadLimiter contains id = ".concat(String.valueOf(str)));
      AppMethodBeat.o(195593);
      return;
    }
    pAH.add(str);
    kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new e(paramString1, paramInt, paramString2, null), 2);
    AppMethodBeat.o(195593);
  }
  
  public static void aig(String paramString)
  {
    AppMethodBeat.i(195592);
    p.h(paramString, "<set-?>");
    pAK = paramString;
    AppMethodBeat.o(195592);
  }
  
  private final void aih(String paramString)
  {
    for (;;)
    {
      final z.f localf;
      Object localObject;
      try
      {
        AppMethodBeat.i(195596);
        if (pAM.size() <= 0)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doCacheVideo lruList is empty");
          pAL = false;
          AppMethodBeat.o(195596);
          return;
        }
        pAL = true;
        localf = new z.f();
        localObject = pAM.keySet();
        p.g(localObject, "this.keySet()");
        localObject = (String)kotlin.a.j.g((Iterable)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(195596);
          continue;
        }
        localBundle = (Bundle)pAM.get(localObject);
      }
      finally {}
      Bundle localBundle;
      if (localBundle == null)
      {
        AppMethodBeat.o(195596);
      }
      else
      {
        localf.SYG = localBundle;
        pAM.remove(localObject);
        kotlinx.coroutines.f.b((ai)bn.TUK, null, (m)new c(paramString, localf, null), 3);
        AppMethodBeat.o(195596);
      }
    }
  }
  
  private static boolean cnF()
  {
    AppMethodBeat.i(195591);
    boolean bool = ((Boolean)pAG.getValue()).booleanValue();
    AppMethodBeat.o(195591);
    return bool;
  }
  
  public static LinkedList<a> cnG()
  {
    return pAI;
  }
  
  public static int cnH()
  {
    return pAJ;
  }
  
  public static String cnI()
  {
    return pAK;
  }
  
  /* Error */
  private final void cnJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 365
    //   5: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 143	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e:pAI	Ljava/util/LinkedList;
    //   11: checkcast 367	java/util/List
    //   14: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   17: ifne +10 -> 27
    //   20: getstatic 145	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e:pAJ	I
    //   23: iconst_3
    //   24: if_icmpeq +36 -> 60
    //   27: ldc 244
    //   29: new 372	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 374
    //   36: invokespecial 376	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: getstatic 145	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e:pAJ	I
    //   42: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc_w 365
    //   54: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: getstatic 143	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e:pAI	Ljava/util/LinkedList;
    //   63: invokevirtual 386	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   66: checkcast 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +184 -> 255
    //   74: ldc 244
    //   76: ldc_w 388
    //   79: aload_3
    //   80: invokestatic 252	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: new 390	org/json/JSONObject
    //   92: dup
    //   93: invokespecial 391	org/json/JSONObject:<init>	()V
    //   96: astore_2
    //   97: aload_2
    //   98: ldc_w 392
    //   101: aload_3
    //   102: getfield 395	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:iwc	I
    //   105: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload_2
    //   110: ldc_w 401
    //   113: iconst_0
    //   114: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_3
    //   119: getfield 403	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:extInfo	Ljava/lang/String;
    //   122: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   125: istore_1
    //   126: iload_1
    //   127: ifne +22 -> 149
    //   130: aload_2
    //   131: ldc_w 404
    //   134: new 390	org/json/JSONObject
    //   137: dup
    //   138: aload_3
    //   139: getfield 403	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:extInfo	Ljava/lang/String;
    //   142: invokespecial 405	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   145: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload_2
    //   150: ldc_w 410
    //   153: bipush 90
    //   155: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   158: pop
    //   159: ldc 244
    //   161: new 372	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 412
    //   168: invokespecial 376	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_3
    //   172: getfield 414	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:url	Ljava/lang/String;
    //   175: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: getstatic 423	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:pFf	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/y;
    //   187: astore 4
    //   189: aload_3
    //   190: getfield 427	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:pAQ	Lcom/tencent/mm/plugin/ad/a;
    //   193: astore 4
    //   195: aload_3
    //   196: getfield 414	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$a:url	Ljava/lang/String;
    //   199: astore_3
    //   200: aload_2
    //   201: invokevirtual 428	org/json/JSONObject:toString	()Ljava/lang/String;
    //   204: astore_2
    //   205: aload_2
    //   206: ldc_w 430
    //   209: invokestatic 173	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   212: aload 4
    //   214: ldc_w 432
    //   217: iconst_2
    //   218: anewarray 248	java/lang/String
    //   221: dup
    //   222: iconst_0
    //   223: aload_3
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload_2
    //   228: aastore
    //   229: invokestatic 436	kotlin/a/j:listOf	([Ljava/lang/Object;)Ljava/util/List;
    //   232: getstatic 440	com/tencent/mm/plugin/brandservice/ui/timeline/preload/e$d:pAV	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/e$d;
    //   235: checkcast 442	kotlin/g/a/b
    //   238: invokestatic 445	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:a	(Lcom/tencent/mm/plugin/ad/a;Ljava/lang/String;Ljava/util/List;Lkotlin/g/a/b;)V
    //   241: ldc_w 365
    //   244: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: goto -190 -> 57
    //   250: astore_2
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_2
    //   254: athrow
    //   255: ldc_w 365
    //   258: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: goto -204 -> 57
    //   264: astore 4
    //   266: goto -117 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	e
    //   125	2	1	bool	boolean
    //   96	132	2	localObject1	Object
    //   250	4	2	localObject2	Object
    //   69	155	3	localObject3	Object
    //   187	26	4	localObject4	Object
    //   264	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	27	250	finally
    //   27	57	250	finally
    //   60	70	250	finally
    //   74	126	250	finally
    //   130	149	250	finally
    //   149	247	250	finally
    //   255	261	250	finally
    //   130	149	264	java/lang/Exception
  }
  
  final void c(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(195595);
        if (Util.isNullOrNil(paramString2))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo url error");
          AppMethodBeat.o(195595);
          return;
        }
        str = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(paramString2);
        if (pAM.get(str) != null)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList contains");
          AppMethodBeat.o(195595);
          continue;
        }
        localh = pAM;
      }
      finally {}
      h localh;
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString2);
      localBundle.putLong("position", paramLong1);
      localBundle.putLong("length", paramLong2);
      localh.put(str, localBundle);
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList.size = " + pAM.size() + ", position=" + paramLong1 + ", length=" + paramLong2 + ", url=" + paramString2);
      if (!pAL) {
        aih(paramString1);
      }
      AppMethodBeat.o(195595);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "", "url", "", "itemShowType", "", "extInfo", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getItemShowType", "()I", "setItemShowType", "(I)V", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "setManifest", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
  public static final class a
  {
    String extInfo;
    int iwc;
    com.tencent.mm.plugin.ad.a pAQ;
    String url;
    
    public a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.ad.a parama)
    {
      AppMethodBeat.i(195566);
      this.url = paramString1;
      this.iwc = paramInt;
      this.extInfo = paramString2;
      this.pAQ = parama;
      AppMethodBeat.o(195566);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195569);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.url, paramObject.url)) || (this.iwc != paramObject.iwc) || (!p.j(this.extInfo, paramObject.extInfo)) || (!p.j(this.pAQ, paramObject.pAQ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(195569);
        return true;
      }
      AppMethodBeat.o(195569);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(195568);
      Object localObject = this.url;
      int i;
      int m;
      if (localObject != null)
      {
        i = localObject.hashCode();
        m = this.iwc;
        localObject = this.extInfo;
        if (localObject == null) {
          break label92;
        }
      }
      label92:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.pAQ;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(195568);
        return (j + (i * 31 + m) * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195567);
      String str = "FetchData(url=" + this.url + ", itemShowType=" + this.iwc + ", extInfo=" + this.extInfo + ", manifest=" + this.pAQ + ")";
      AppMethodBeat.o(195567);
      return str;
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.BizVideoPreloadLogic$doCacheVideo$2", f="BizVideoPreloadLogic.kt", hxM={276}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    c(String paramString, z.f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(195575);
      p.h(paramd, "completion");
      paramd = new c(this.pAS, localf, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(195575);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195576);
      paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(195576);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(195574);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195574);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        com.tencent.mm.ipcinvoker.a.a(this.pAS, (Parcelable)localf.SYG, (com.tencent.mm.ipcinvoker.b)1.pAU, null);
        this.L$0 = paramObject;
        this.label = 1;
        if (au.a(1000L, this) == locala)
        {
          AppMethodBeat.o(195574);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      e.a(e.pAN, this.pAS);
      paramObject = x.SXb;
      AppMethodBeat.o(195574);
      return paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final d pAV;
    
    static
    {
      AppMethodBeat.i(195578);
      pAV = new d();
      AppMethodBeat.o(195578);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.BizVideoPreloadLogic$preloadVideo$1", f="BizVideoPreloadLogic.kt", hxM={}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class e
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    e(String paramString1, int paramInt, String paramString2, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(195589);
      p.h(paramd, "completion");
      paramd = new e(this.mkH, paramInt, paramString2, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(195589);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195590);
      paramObject1 = ((e)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(195590);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(195588);
      Object localObject2 = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195588);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (kotlin.g.a.a)e.e.d.pBa;
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = null;
      try
      {
        ((z.f)localObject2).SYG = ((eic)paramObject.invoke());
        if ((eic)((z.f)localObject2).SYG != null)
        {
          paramObject = (eic)((z.f)localObject2).SYG;
          if (paramObject == null) {
            break label193;
          }
        }
        Object localObject3;
        label193:
        for (paramObject = paramObject.Nhr; !s.YS(paramObject); paramObject = null)
        {
          localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] preloadVideo ");
          localObject2 = (eic)((z.f)localObject2).SYG;
          paramObject = localObject1;
          if (localObject2 != null) {
            paramObject = ((eic)localObject2).Nhr;
          }
          Log.i("MicroMsg.BizVideoPreloadLogic", paramObject + " not exist");
          paramObject = x.SXb;
          AppMethodBeat.o(195588);
          return paramObject;
        }
        try
        {
          localObject1 = (m)new e.e.e((z.f)localObject2);
          paramObject = (kotlin.g.a.b)b.pAY;
          localObject3 = (kotlin.g.a.b)e.e.c.pAZ;
          localObject1 = (com.tencent.mm.plugin.ad.a)((m)localObject1).invoke(this.mkH, (eic)((z.f)localObject2).SYG);
          locale = e.pAN;
          e.cnG().add(new e.a(this.mkH, paramInt, paramString2, (com.tencent.mm.plugin.ad.a)localObject1));
          locale = e.pAN;
          e.Dn(((Number)paramObject.invoke(localObject1)).intValue());
          paramObject = e.pAN;
          i = e.cnH();
          switch (i)
          {
          default: 
            localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] tmplParams initFilePath = ");
            paramObject = (eic)((z.f)localObject2).SYG;
            if (paramObject != null)
            {
              localObject1 = paramObject.Nhr;
              paramObject = localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramObject = "";
            }
            paramObject = ((StringBuilder)localObject3).append(paramObject).append(", WebComponent.info = ");
            localObject1 = com.tencent.mm.plugin.webview.l.c.JDf;
            Log.d("MicroMsg.BizVideoPreloadLogic", c.b.ejA());
            paramObject = x.SXb;
            AppMethodBeat.o(195588);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          paramObject = x.SXb;
          AppMethodBeat.o(195588);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo exception = ".concat(String.valueOf(paramObject)));
        paramObject = x.SXb;
        AppMethodBeat.o(195588);
        return paramObject;
      }
      for (;;)
      {
        e locale;
        int i;
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo JsStatus.SHOULD_INIT");
        paramObject = (eic)((z.f)localObject2).SYG;
        if (paramObject != null) {}
        for (paramObject = paramObject.Nhr;; paramObject = null)
        {
          p.g(paramObject, "tmplParams?.initFilePath");
          paramObject = (String)((kotlin.g.a.b)localObject3).invoke(paramObject);
          if (paramObject == null) {
            break;
          }
          localObject3 = e.pAN;
          e.Dn(2);
          localObject3 = y.pFf;
          y.b((com.tencent.mm.plugin.ad.a)localObject1, paramObject, (kotlin.g.a.b)a.pAX);
          break;
        }
        e.a(e.pAN);
        continue;
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo jsStatus.INIT_ING");
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<String, x>
    {
      public static final a pAX;
      
      static
      {
        AppMethodBeat.i(195580);
        pAX = new a();
        AppMethodBeat.o(195580);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.ad.a, Integer>
    {
      public static final b pAY;
      
      static
      {
        AppMethodBeat.i(195582);
        pAY = new b();
        AppMethodBeat.o(195582);
      }
      
      b()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.e
 * JD-Core Version:    0.7.0.1
 */