package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.r;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.webview.l.c.b;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic;", "", "()V", "PRELOAD_MAX_BYTES", "", "PRELOAD_MIN_BYTES", "TAG", "", "abTest", "", "getAbTest", "()Z", "abTest$delegate", "Lkotlin/Lazy;", "doingCache", "getDoingCache", "setDoingCache", "(Z)V", "fetchQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "getFetchQueue", "()Ljava/util/LinkedList;", "jsContextStatus", "", "getJsContextStatus", "()I", "setJsContextStatus", "(I)V", "lastManifestId", "getLastManifestId", "()Ljava/lang/String;", "setLastManifestId", "(Ljava/lang/String;)V", "lruList", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Landroid/os/Bundle;", "getLruList", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "preloadLimiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getPreloadLimiter", "()Lcom/tencent/mm/modelbiz/MpDataLimiter;", "useThumbPlayer", "getUseThumbPlayer", "useThumbPlayer$delegate", "cacheVideo", "", "data", "processName", "url", "position", "length", "cacheVideoInClientProcess", "doCacheVideo", "doFetch", "preloadTTPlayer", "preloadSize", "preloadVideo", "itemShowType", "extInfo", "getLatest", "kotlin.jvm.PlatformType", "FetchData", "JsStatus", "plugin-brandservice_release"})
public final class e
{
  private static final kotlin.f sKO;
  private static final kotlin.f sKP;
  private static final r sKQ;
  private static final LinkedList<a> sKR;
  private static int sKS;
  private static String sKT;
  private static boolean sKU;
  private static final com.tencent.mm.b.h<String, Bundle> sKV;
  public static final e sKW;
  
  static
  {
    AppMethodBeat.i(265347);
    sKW = new e();
    sKO = kotlin.g.ar((kotlin.g.a.a)b.sLa);
    sKP = kotlin.g.ar((kotlin.g.a.a)g.sLn);
    if (BuildInfo.DEBUG) {}
    for (int i = 1000;; i = 600000)
    {
      sKQ = new r(i);
      sKR = new LinkedList();
      sKS = 1;
      sKT = "";
      i.bVn().iG(cBK());
      String str = ToolsMpProcessIPCService.PROCESS_NAME;
      p.j(str, "ToolsMpProcessIPCService.PROCESS_NAME");
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("abTest", cBK());
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.d)1.sKX, null);
      str = Appbrand0IPCService.PROCESS_NAME;
      p.j(str, "Appbrand0IPCService.PROCESS_NAME");
      localBundle = new Bundle();
      localBundle.putBoolean("abTest", cBK());
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.d)2.sKY, null);
      sKV = new com.tencent.mm.b.h(10);
      AppMethodBeat.o(265347);
      return;
    }
  }
  
  public static void G(String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(265343);
    if (!cBK())
    {
      AppMethodBeat.o(265343);
      return;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(265343);
      return;
    }
    if (!UrlExKt.isMpArticleUrl(paramString1))
    {
      AppMethodBeat.o(265343);
      return;
    }
    if ((paramInt < 0) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(265343);
      return;
    }
    String str = c.apJ(paramString1);
    if (sKQ.contains(str))
    {
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadLimiter contains id = ".concat(String.valueOf(str)));
      AppMethodBeat.o(265343);
      return;
    }
    sKQ.add(str);
    kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new f(paramString1, paramInt, paramString2, null), 2);
    AppMethodBeat.o(265343);
  }
  
  public static void GW(int paramInt)
  {
    sKS = paramInt;
  }
  
  public static void apS(String paramString)
  {
    AppMethodBeat.i(265342);
    p.k(paramString, "<set-?>");
    sKT = paramString;
    AppMethodBeat.o(265342);
  }
  
  private final void apT(String paramString)
  {
    for (;;)
    {
      final aa.f localf;
      Object localObject;
      try
      {
        AppMethodBeat.i(265346);
        if (sKV.size() <= 0)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doCacheVideo lruList is empty");
          sKU = false;
          AppMethodBeat.o(265346);
          return;
        }
        sKU = true;
        localf = new aa.f();
        localObject = sKV.keySet();
        p.j(localObject, "this.keySet()");
        localObject = (String)kotlin.a.j.g((Iterable)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(265346);
          continue;
        }
        localBundle = (Bundle)sKV.get(localObject);
      }
      finally {}
      Bundle localBundle;
      if (localBundle == null)
      {
        AppMethodBeat.o(265346);
      }
      else
      {
        localf.aaBC = localBundle;
        sKV.remove(localObject);
        kotlinx.coroutines.g.b((ak)br.abxo, null, (m)new c(paramString, localf, null), 3);
        AppMethodBeat.o(265346);
      }
    }
  }
  
  private static boolean cBK()
  {
    AppMethodBeat.i(265337);
    boolean bool = ((Boolean)sKO.getValue()).booleanValue();
    AppMethodBeat.o(265337);
    return bool;
  }
  
  public static boolean cBL()
  {
    AppMethodBeat.i(265339);
    boolean bool = ((Boolean)sKP.getValue()).booleanValue();
    AppMethodBeat.o(265339);
    return bool;
  }
  
  public static LinkedList<a> cBM()
  {
    return sKR;
  }
  
  public static int cBN()
  {
    return sKS;
  }
  
  public static String cBO()
  {
    return sKT;
  }
  
  private final void cBP()
  {
    m = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(265344);
        if ((Util.isNullOrNil((List)sKR)) || (sKS != 3))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "doFetch fetchQueue null, jsContextStatus = " + sKS);
          AppMethodBeat.o(265344);
          return;
        }
        try
        {
          localObject4 = (a)sKR.poll();
          if (localObject4 != null)
          {
            Log.i("MicroMsg.BizVideoPreloadLogic", "doFetch fetchData = ".concat(String.valueOf(localObject4)));
            localObject3 = new JSONObject();
            j = ((a)localObject4).llp;
            boolean bool = Util.isNullOrNil(((a)localObject4).extInfo);
            i = j;
            k = m;
            if (!bool) {
              i = j;
            }
          }
        }
        catch (Exception localException1)
        {
          Object localObject4;
          Object localObject3;
          int j;
          int i;
          Object localObject1;
          com.tencent.mm.plugin.ax.a locala;
          Log.printErrStackTrace("MicroMsg.BizVideoPreloadLogic", (Throwable)localException1, "", new Object[0]);
          AppMethodBeat.o(265344);
        }
      }
      finally {}
      try
      {
        localObject1 = new JSONObject(((a)localObject4).extInfo);
        i = j;
        j = ((JSONObject)localObject1).optInt("itemshowType");
        i = j;
        k = ((JSONObject)localObject1).optInt("preloadType");
        i = j;
      }
      catch (Exception localException2)
      {
        k = m;
        continue;
      }
      ((JSONObject)localObject3).put("itemShowType", i);
      ((JSONObject)localObject3).put("preloadType", k);
      ((JSONObject)localObject3).put("scene", 90);
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doFetch url = " + ((a)localObject4).url + "   json:" + localObject3);
      if (cBL()) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 50L, 1L, false);
      }
      localObject1 = w.sPP;
      locala = ((a)localObject4).sKZ;
      localObject4 = ((a)localObject4).url;
      localObject3 = ((JSONObject)localObject3).toString();
      p.j(localObject3, "json.toString()");
      localObject3 = kotlin.a.j.listOf(new String[] { localObject4, localObject3 });
      localObject4 = (b)d.sLe;
      p.k(locala, "manifest");
      p.k("fetch", "func");
      p.k(localObject3, "params");
      p.k(localObject4, "onCallback");
      ((w)localObject1).cDd().a(locala, "fetch", (List)localObject3, (b)localObject4);
      AppMethodBeat.o(265344);
      continue;
      continue;
      AppMethodBeat.o(265344);
    }
  }
  
  final void c(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(265345);
        if (Util.isNullOrNil(paramString2))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo url error");
          AppMethodBeat.o(265345);
          return;
        }
        str = i.bVn().aiO(paramString2);
        if (sKV.get(str) != null)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList contains");
          AppMethodBeat.o(265345);
          continue;
        }
        localh = sKV;
      }
      finally {}
      com.tencent.mm.b.h localh;
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString2);
      localBundle.putLong("position", paramLong1);
      localBundle.putLong("length", paramLong2);
      localBundle.putBoolean("useThumbPlayer", cBL());
      localh.put(str, localBundle);
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList.size = " + sKV.size() + ", position=" + paramLong1 + ", length=" + paramLong2 + ", url=" + paramString2);
      if (!sKU) {
        apT(paramString1);
      }
      AppMethodBeat.o(265345);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "", "url", "", "itemShowType", "", "extInfo", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getItemShowType", "()I", "setItemShowType", "(I)V", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "setManifest", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"})
  public static final class a
  {
    String extInfo;
    int llp;
    com.tencent.mm.plugin.ax.a sKZ;
    String url;
    
    public a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.ax.a parama)
    {
      AppMethodBeat.i(264341);
      this.url = paramString1;
      this.llp = paramInt;
      this.extInfo = paramString2;
      this.sKZ = parama;
      AppMethodBeat.o(264341);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(264344);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.url, paramObject.url)) || (this.llp != paramObject.llp) || (!p.h(this.extInfo, paramObject.extInfo)) || (!p.h(this.sKZ, paramObject.sKZ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(264344);
        return true;
      }
      AppMethodBeat.o(264344);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(264343);
      Object localObject = this.url;
      int i;
      int m;
      if (localObject != null)
      {
        i = localObject.hashCode();
        m = this.llp;
        localObject = this.extInfo;
        if (localObject == null) {
          break label92;
        }
      }
      label92:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.sKZ;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(264343);
        return (j + (i * 31 + m) * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(264342);
      String str = "FetchData(url=" + this.url + ", itemShowType=" + this.llp + ", extInfo=" + this.extInfo + ", manifest=" + this.sKZ + ")";
      AppMethodBeat.o(264342);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b sLa;
    
    static
    {
      AppMethodBeat.i(262269);
      sLa = new b();
      AppMethodBeat.o(262269);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    c(String paramString, aa.f paramf, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(258057);
      p.k(paramd, "completion");
      paramd = new c(this.qUr, localf, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(258057);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(258059);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(258059);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(258056);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(258056);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        com.tencent.mm.ipcinvoker.a.a(this.qUr, (Parcelable)localf.aaBC, (com.tencent.mm.ipcinvoker.d)1.sLd, null);
        this.L$0 = paramObject;
        this.label = 1;
        if (aw.a(1000L, this) == locala)
        {
          AppMethodBeat.o(258056);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      e.a(e.sKW, this.qUr);
      paramObject = x.aazN;
      AppMethodBeat.o(258056);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements b<String, x>
  {
    public static final d sLe;
    
    static
    {
      AppMethodBeat.i(264705);
      sLe = new d();
      AppMethodBeat.o(264705);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$preloadTTPlayer$1", "Lcom/tencent/thumbplayer/api/proxy/ITPPreloadProxy$IPreloadListener;", "onPrepareDownloadProgressUpdate", "", "playableDurationMS", "", "downloadSpeedKBs", "currentDownloadSizeByte", "", "totalFileSizeByte", "onPrepareError", "onPrepareSuccess", "plugin-brandservice_release"})
  public static final class e
    implements ITPPreloadProxy.IPreloadListener
  {
    e(String paramString1, String paramString2, long paramLong) {}
    
    public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(258191);
      Log.d("MicroMsg.BizVideoPreloadLogic", "preloadTTPlayer  onPrepareDownloadProgressUpdate   fileId:" + this.sLf + "   playableDurationMS:" + paramInt1 + "  currentDownloadSizeByte：" + paramLong1 + "   totalFileSizeByte:" + paramLong2);
      com.tencent.mm.plugin.appbrand.ae.a.a.c localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      com.tencent.mm.plugin.appbrand.ae.a.a.c.X(this.piM, paramLong1);
      AppMethodBeat.o(258191);
    }
    
    public final void onPrepareError()
    {
      AppMethodBeat.i(258190);
      Log.e("MicroMsg.BizVideoPreloadLogic", "preloadTTPlayer  onPrepareError  fileId:" + this.sLf);
      com.tencent.mm.plugin.appbrand.ae.a.a.c localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      com.tencent.mm.plugin.appbrand.ae.a.a.c.X(this.piM, 0L);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 53L, 1L, false);
      AppMethodBeat.o(258190);
    }
    
    public final void onPrepareSuccess()
    {
      AppMethodBeat.i(258189);
      Log.i("MicroMsg.BizVideoPreloadLogic", "preloadTTPlayer  onPrepareSuccess  fileId:" + this.sLf);
      com.tencent.mm.plugin.appbrand.ae.a.a.c localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      com.tencent.mm.plugin.appbrand.ae.a.a.c.X(this.piM, this.sLg);
      localc = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
      com.tencent.mm.plugin.appbrand.ae.a.a.c.bwi(this.sLf);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1379L, 52L, 1L, false);
      AppMethodBeat.o(258189);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    f(String paramString1, int paramInt, String paramString2, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(258648);
      p.k(paramd, "completion");
      paramd = new f(this.piM, paramInt, paramString2, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(258648);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(258653);
      paramObject1 = ((f)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(258653);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(258643);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(258643);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (kotlin.g.a.a)d.sLl;
      localObject2 = new aa.f();
      ((aa.f)localObject2).aaBC = null;
      Object localObject3;
      for (;;)
      {
        try
        {
          ((aa.f)localObject2).aaBC = ((ese)paramObject.invoke());
          if ((ese)((aa.f)localObject2).aaBC == null)
          {
            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo tmplParams not exist");
            paramObject = x.aazN;
            AppMethodBeat.o(258643);
            return paramObject;
          }
          paramObject = e.sKW;
          if (e.cBL()) {
            break;
          }
          paramObject = (ese)((aa.f)localObject2).aaBC;
          if (paramObject != null)
          {
            paramObject = paramObject.UtX;
            u.bBD(paramObject);
            paramObject = (ese)((aa.f)localObject2).aaBC;
            if (paramObject == null) {
              break label275;
            }
            paramObject = paramObject.UtX;
            if (u.agG(paramObject)) {
              break;
            }
            localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] preloadVideo ");
            localObject2 = (ese)((aa.f)localObject2).aaBC;
            paramObject = localObject1;
            if (localObject2 != null) {
              paramObject = ((ese)localObject2).UtX;
            }
            Log.i("MicroMsg.BizVideoPreloadLogic", paramObject + " not exist");
            paramObject = x.aazN;
            AppMethodBeat.o(258643);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo exception = ".concat(String.valueOf(paramObject)));
          paramObject = x.aazN;
          AppMethodBeat.o(258643);
          return paramObject;
        }
        paramObject = null;
        continue;
        label275:
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          localObject1 = (m)new e((aa.f)localObject2);
          paramObject = (b)b.sLj;
          localObject3 = (b)c.sLk;
          localObject1 = (com.tencent.mm.plugin.ax.a)((m)localObject1).invoke(this.piM, (ese)((aa.f)localObject2).aaBC);
          localObject4 = e.sKW;
          e.cBM().add(new e.a(this.piM, paramInt, paramString2, (com.tencent.mm.plugin.ax.a)localObject1));
          localObject4 = e.sKW;
          e.GW(((Number)paramObject.invoke(localObject1)).intValue());
          paramObject = e.sKW;
          int i = e.cBN();
          switch (i)
          {
          default: 
            localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] tmplParams initFilePath = ");
            paramObject = (ese)((aa.f)localObject2).aaBC;
            if (paramObject != null)
            {
              localObject1 = paramObject.UtX;
              paramObject = localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramObject = "";
            }
            paramObject = ((StringBuilder)localObject3).append(paramObject).append(", WebComponent.info = ");
            localObject1 = com.tencent.mm.plugin.webview.l.c.QBP;
            Log.d("MicroMsg.BizVideoPreloadLogic", c.b.eTh());
            paramObject = x.aazN;
            AppMethodBeat.o(258643);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          Object localObject4;
          paramObject = x.aazN;
          AppMethodBeat.o(258643);
          return paramObject;
        }
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo JsStatus.SHOULD_INIT");
        paramObject = (ese)((aa.f)localObject2).aaBC;
        if (paramObject != null)
        {
          paramObject = paramObject.UtX;
          p.j(paramObject, "tmplParams?.initFilePath");
          paramObject = (String)((b)localObject3).invoke(paramObject);
          if (paramObject != null)
          {
            localObject3 = e.sKW;
            e.GW(2);
            localObject3 = w.sPP;
            localObject4 = (b)a.sLi;
            p.k(localObject1, "manifest");
            p.k(paramObject, "script");
            p.k(localObject4, "onCallback");
            ((w)localObject3).cDd().a((com.tencent.mm.plugin.ax.a)localObject1, paramObject, (b)localObject4);
          }
        }
        else
        {
          paramObject = null;
          continue;
          e.a(e.sKW);
          continue;
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo jsStatus.INIT_ING");
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends q
      implements b<String, x>
    {
      public static final a sLi;
      
      static
      {
        AppMethodBeat.i(266502);
        sLi = new a();
        AppMethodBeat.o(266502);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "invoke"})
    static final class b
      extends q
      implements b<com.tencent.mm.plugin.ax.a, Integer>
    {
      public static final b sLj;
      
      static
      {
        AppMethodBeat.i(265289);
        sLj = new b();
        AppMethodBeat.o(265289);
      }
      
      b()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "path", "invoke"})
    static final class c
      extends q
      implements b<String, String>
    {
      public static final c sLk;
      
      static
      {
        AppMethodBeat.i(265684);
        sLk = new c();
        AppMethodBeat.o(265684);
      }
      
      c()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<ese>
    {
      public static final d sLl;
      
      static
      {
        AppMethodBeat.i(259693);
        sLl = new d();
        AppMethodBeat.o(259693);
      }
      
      d()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "tmpl", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
    static final class e
      extends q
      implements m<String, ese, com.tencent.mm.plugin.ax.a>
    {
      e(aa.f paramf)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final g sLn;
    
    static
    {
      AppMethodBeat.i(265186);
      sLn = new g();
      AppMethodBeat.o(265186);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.e
 * JD-Core Version:    0.7.0.1
 */