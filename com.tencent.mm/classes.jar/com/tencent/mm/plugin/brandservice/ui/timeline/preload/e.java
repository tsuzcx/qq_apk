package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.r;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.webview.l.c.b;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic;", "", "()V", "PRELOAD_MAX_BYTES", "", "PRELOAD_MIN_BYTES", "TAG", "", "abTest", "", "getAbTest", "()Z", "abTest$delegate", "Lkotlin/Lazy;", "doingCache", "getDoingCache", "setDoingCache", "(Z)V", "fetchQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "getFetchQueue", "()Ljava/util/LinkedList;", "jsContextStatus", "", "getJsContextStatus", "()I", "setJsContextStatus", "(I)V", "lastManifestId", "getLastManifestId", "()Ljava/lang/String;", "setLastManifestId", "(Ljava/lang/String;)V", "lruList", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Landroid/os/Bundle;", "getLruList", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "preloadLimiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getPreloadLimiter", "()Lcom/tencent/mm/modelbiz/MpDataLimiter;", "cacheVideo", "", "data", "processName", "url", "position", "length", "videoType", "cacheVideoInClientProcess", "useThumbPlayer", "doCacheVideo", "doFetch", "preloadTTPlayer", "preloadSize", "preloadVideo", "itemShowType", "extInfo", "getLatest", "kotlin.jvm.PlatformType", "FetchData", "JsStatus", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e vQH;
  private static final kotlin.j vQI;
  private static final r vQJ;
  private static final LinkedList<a> vQK;
  private static int vQL;
  private static String vQM;
  private static boolean vQN;
  private static final com.tencent.mm.b.h<String, Bundle> vQO;
  
  static
  {
    AppMethodBeat.i(303280);
    vQH = new e();
    vQI = kotlin.k.cm((kotlin.g.a.a)b.vQQ);
    if (BuildInfo.DEBUG) {}
    for (int i = 1000;; i = 600000)
    {
      vQJ = new r(i);
      vQK = new LinkedList();
      vQL = 1;
      vQM = "";
      i.cvD().sAz = deV();
      String str = ToolsMpProcessIPCService.PROCESS_NAME;
      s.s(str, "PROCESS_NAME");
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("abTest", deV());
      ah localah = ah.aiuX;
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, e..ExternalSyntheticLambda1.INSTANCE);
      str = Appbrand0IPCService.PROCESS_NAME;
      s.s(str, "PROCESS_NAME");
      localBundle = new Bundle();
      localBundle.putBoolean("abTest", deV());
      localah = ah.aiuX;
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, e..ExternalSyntheticLambda0.INSTANCE);
      vQO = new com.tencent.mm.b.h(10);
      AppMethodBeat.o(303280);
      return;
    }
  }
  
  public static void Hv(int paramInt)
  {
    vQL = paramInt;
  }
  
  public static void I(String paramString1, final int paramInt, final String paramString2)
  {
    AppMethodBeat.i(303220);
    Log.i("MicroMsg.BizVideoPreloadLogic", s.X("preloadVideo itemShowType:", Integer.valueOf(paramInt)));
    if (!deV())
    {
      AppMethodBeat.o(303220);
      return;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(303220);
      return;
    }
    if ((!UrlExKt.isMpArticleUrl(paramString1)) && (!UrlExKt.isMpRecWeb(paramString1)))
    {
      AppMethodBeat.o(303220);
      return;
    }
    Object localObject = com.tencent.mm.plugin.webview.k.k.Xtc;
    if (!com.tencent.mm.plugin.webview.k.k.iCU())
    {
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] is not thumbPlayer , do not preload");
      AppMethodBeat.o(303220);
      return;
    }
    localObject = c.ajk(paramString1);
    if (vQJ.contains((String)localObject))
    {
      Log.i("MicroMsg.BizVideoPreloadLogic", s.X("[TRACE_VIDEO_PRELOAD] preloadLimiter contains id = ", localObject));
      AppMethodBeat.o(303220);
      return;
    }
    vQJ.add((String)localObject);
    kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new f(paramString1, paramInt, paramString2, null), 2);
    AppMethodBeat.o(303220);
  }
  
  public static void ajt(String paramString)
  {
    AppMethodBeat.i(303209);
    s.u(paramString, "<set-?>");
    vQM = paramString;
    AppMethodBeat.o(303209);
  }
  
  private final void aju(final String paramString)
  {
    for (;;)
    {
      ah.f localf;
      Object localObject;
      try
      {
        AppMethodBeat.i(303241);
        if (vQO.size() <= 0)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doCacheVideo lruList is empty");
          vQN = false;
          AppMethodBeat.o(303241);
          return;
        }
        vQN = true;
        localf = new ah.f();
        localObject = vQO.keySet();
        s.s(localObject, "this.keySet()");
        localObject = (String)p.g((Iterable)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(303241);
          continue;
        }
        localBundle = (Bundle)vQO.get(localObject);
      }
      finally {}
      Bundle localBundle;
      if (localBundle == null)
      {
        AppMethodBeat.o(303241);
      }
      else
      {
        localf.aqH = localBundle;
        vQO.remove(localObject);
        kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new c(localf, paramString, null), 3);
        AppMethodBeat.o(303241);
      }
    }
  }
  
  private static final void b(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303246);
    i.cvD().sAz = paramBundle.getBoolean("abTest");
    AppMethodBeat.o(303246);
  }
  
  private static final void c(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303248);
    i.cvD().sAz = paramBundle.getBoolean("abTest");
    AppMethodBeat.o(303248);
  }
  
  public static void dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(369887);
    I(paramString, paramInt, "");
    AppMethodBeat.o(369887);
  }
  
  private static boolean deV()
  {
    AppMethodBeat.i(303200);
    boolean bool = ((Boolean)vQI.getValue()).booleanValue();
    AppMethodBeat.o(303200);
    return bool;
  }
  
  public static LinkedList<a> deW()
  {
    return vQK;
  }
  
  public static int deX()
  {
    return vQL;
  }
  
  public static String deY()
  {
    return vQM;
  }
  
  private final void deZ()
  {
    m = 0;
    for (;;)
    {
      int j;
      int i;
      try
      {
        AppMethodBeat.i(303235);
        if ((Util.isNullOrNil((List)vQK)) || (vQL != 3))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", s.X("doFetch fetchQueue null, jsContextStatus = ", Integer.valueOf(vQL)));
          AppMethodBeat.o(303235);
          return;
        }
      }
      finally {}
      try
      {
        localObject4 = (a)vQK.poll();
        if (localObject4 != null)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", s.X("doFetch fetchData = ", localObject4));
          localObject1 = new JSONObject();
          j = ((a)localObject4).nQm;
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
        Log.printErrStackTrace("MicroMsg.BizVideoPreloadLogic", (Throwable)localException1, "", new Object[0]);
        AppMethodBeat.o(303235);
      }
      try
      {
        localObject3 = new JSONObject(((a)localObject4).extInfo);
        i = j;
        j = ((JSONObject)localObject3).optInt("itemshowType");
        i = j;
        k = ((JSONObject)localObject3).optInt("preloadType");
        i = j;
      }
      catch (Exception localException2)
      {
        k = m;
        continue;
      }
      ((JSONObject)localObject1).put("itemShowType", i);
      ((JSONObject)localObject1).put("preloadType", k);
      ((JSONObject)localObject1).put("scene", 90);
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doFetch url = " + ((a)localObject4).url + "   json:" + localObject1);
      Object localObject3 = com.tencent.mm.plugin.webview.k.k.Xtc;
      if (com.tencent.mm.plugin.webview.k.k.iCU()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 50L, 1L, false);
      }
      localObject3 = WebPrefetcherManifest.vUW;
      com.tencent.mm.plugin.az.a locala = ((a)localObject4).vQP;
      Object localObject4 = ((a)localObject4).url;
      Object localObject1 = ((JSONObject)localObject1).toString();
      s.s(localObject1, "json.toString()");
      localObject1 = p.listOf(new String[] { localObject4, localObject1 });
      localObject4 = (kotlin.g.a.b)d.vQT;
      s.u(locala, "manifest");
      s.u("fetch", "func");
      s.u(localObject1, "params");
      s.u(localObject4, "onCallback");
      ((WebPrefetcherManifest)localObject3).dgz().a(locala, "fetch", (List)localObject1, (kotlin.g.a.b)localObject4);
      AppMethodBeat.o(303235);
    }
  }
  
  final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(303306);
        if (Util.isNullOrNil(paramString2))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo url error");
          AppMethodBeat.o(303306);
          return;
        }
        i.cvD();
        str = i.abO(paramString2);
        if (vQO.get(str) != null)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList contains");
          AppMethodBeat.o(303306);
          continue;
        }
        localh = vQO;
      }
      finally {}
      com.tencent.mm.b.h localh;
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString2);
      localBundle.putLong("position", paramLong1);
      localBundle.putLong("length", paramLong2);
      Object localObject = com.tencent.mm.plugin.webview.k.k.Xtc;
      localBundle.putBoolean("useThumbPlayer", com.tencent.mm.plugin.webview.k.k.iCU());
      localBundle.putInt("videoType", paramInt);
      localObject = ah.aiuX;
      localh.put(str, localBundle);
      Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList.size = " + vQO.size() + ", position=" + paramLong1 + ", length=" + paramLong2 + ", videoType=" + paramInt + ", url=" + paramString2);
      if (!vQN) {
        aju(paramString1);
      }
      AppMethodBeat.o(303306);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "", "url", "", "itemShowType", "", "extInfo", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getItemShowType", "()I", "setItemShowType", "(I)V", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "setManifest", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    String extInfo;
    int nQm;
    String url;
    com.tencent.mm.plugin.az.a vQP;
    
    public a(String paramString1, int paramInt, String paramString2, com.tencent.mm.plugin.az.a parama)
    {
      AppMethodBeat.i(303225);
      this.url = paramString1;
      this.nQm = paramInt;
      this.extInfo = paramString2;
      this.vQP = parama;
      AppMethodBeat.o(303225);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(303242);
      if (this == paramObject)
      {
        AppMethodBeat.o(303242);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(303242);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.url, paramObject.url))
      {
        AppMethodBeat.o(303242);
        return false;
      }
      if (this.nQm != paramObject.nQm)
      {
        AppMethodBeat.o(303242);
        return false;
      }
      if (!s.p(this.extInfo, paramObject.extInfo))
      {
        AppMethodBeat.o(303242);
        return false;
      }
      if (!s.p(this.vQP, paramObject.vQP))
      {
        AppMethodBeat.o(303242);
        return false;
      }
      AppMethodBeat.o(303242);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(303238);
      int j = this.url.hashCode();
      int k = this.nQm;
      if (this.extInfo == null) {}
      for (int i = 0;; i = this.extInfo.hashCode())
      {
        int m = this.vQP.hashCode();
        AppMethodBeat.o(303238);
        return (i + (j * 31 + k) * 31) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(303233);
      String str = "FetchData(url=" + this.url + ", itemShowType=" + this.nQm + ", extInfo=" + this.extInfo + ", manifest=" + this.vQP + ')';
      AppMethodBeat.o(303233);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final b vQQ;
    
    static
    {
      AppMethodBeat.i(303228);
      vQQ = new b();
      AppMethodBeat.o(303228);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(ah.f<Bundle> paramf, String paramString, d<? super c> paramd)
    {
      super(paramd);
    }
    
    private static final void d(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
    {
      AppMethodBeat.i(303219);
      paramf = e.vQH;
      e.a(paramBundle.getString("url"), paramBundle.getLong("position"), paramBundle.getLong("length"), paramBundle.getBoolean("useThumbPlayer"), paramBundle.getInt("videoType"));
      AppMethodBeat.o(303219);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(303251);
      paramObject = (d)new c(this.vQR, paramString, paramd);
      AppMethodBeat.o(303251);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(303245);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303245);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        StringBuilder localStringBuilder = new StringBuilder("[TRACE_VIDEO_PRELOAD] doCacheVideo  url:");
        paramObject = (Bundle)this.vQR.aqH;
        if (paramObject == null)
        {
          paramObject = null;
          localStringBuilder = localStringBuilder.append(paramObject).append("  length:");
          paramObject = (Bundle)this.vQR.aqH;
          if (paramObject != null) {
            break label187;
          }
        }
        label187:
        for (paramObject = localObject;; paramObject = kotlin.d.b.a.b.BF(paramObject.getLong("length")))
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", paramObject);
          com.tencent.mm.ipcinvoker.a.a(paramString, (Parcelable)this.vQR.aqH, e.c..ExternalSyntheticLambda0.INSTANCE);
          paramObject = (d)this;
          this.label = 1;
          if (bb.e(1000L, paramObject) != locala) {
            break label204;
          }
          AppMethodBeat.o(303245);
          return locala;
          paramObject = paramObject.getString("url");
          break;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label204:
      e.a(e.vQH, paramString);
      paramObject = ah.aiuX;
      AppMethodBeat.o(303245);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    public static final d vQT;
    
    static
    {
      AppMethodBeat.i(303249);
      vQT = new d();
      AppMethodBeat.o(303249);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$preloadTTPlayer$1", "Lcom/tencent/thumbplayer/api/proxy/ITPPreloadProxy$IPreloadListener;", "onPrepareDownloadProgressUpdate", "", "playableDurationMS", "", "downloadSpeedKBs", "currentDownloadSizeByte", "", "totalFileSizeByte", "onPrepareError", "onPrepareSuccess", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ITPPreloadProxy.IPreloadListener
  {
    e(String paramString1, String paramString2, long paramLong) {}
    
    public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(303286);
      Log.i("MicroMsg.BizVideoPreloadLogic", "preloadTTPlayer  onPrepareDownloadProgressUpdate   fileId:" + this.vQU + "   playableDurationMS:" + paramInt1 + "  currentDownloadSizeByte：" + paramLong1 + "   totalFileSizeByte:" + paramLong2);
      com.tencent.mm.plugin.appbrand.ag.b.a.c localc = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
      com.tencent.mm.plugin.appbrand.ag.b.a.c.ab(this.mrs, paramLong1);
      AppMethodBeat.o(303286);
    }
    
    public final void onPrepareError()
    {
      AppMethodBeat.i(303272);
      Log.e("MicroMsg.BizVideoPreloadLogic", s.X("preloadTTPlayer  onPrepareError  fileId:", this.vQU));
      com.tencent.mm.plugin.appbrand.ag.b.a.c localc = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
      com.tencent.mm.plugin.appbrand.ag.b.a.c.ab(this.mrs, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 53L, 1L, false);
      AppMethodBeat.o(303272);
    }
    
    public final void onPrepareSuccess()
    {
      AppMethodBeat.i(303263);
      Log.i("MicroMsg.BizVideoPreloadLogic", s.X("preloadTTPlayer  onPrepareSuccess  fileId:", this.vQU));
      Object localObject = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
      com.tencent.mm.plugin.appbrand.ag.b.a.c.ab(this.mrs, this.vQV);
      localObject = com.tencent.mm.plugin.appbrand.ag.b.a.c.utd;
      localObject = this.vQU;
      for (;;)
      {
        try
        {
          CharSequence localCharSequence = (CharSequence)localObject;
          if (localCharSequence == null) {
            continue;
          }
          if (!n.bp(localCharSequence)) {
            continue;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)localException, "", new Object[0]);
          continue;
          int i = 1;
          continue;
        }
        if (i == 0) {
          ((MultiProcessMMKV)com.tencent.mm.plugin.appbrand.ag.b.a.c.cNY().getSlotForWrite()).encode(com.tencent.mm.plugin.appbrand.ag.b.a.c.agN((String)localObject), true);
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 52L, 1L, false);
        AppMethodBeat.o(303263);
        return;
        i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    f(String paramString1, int paramInt, String paramString2, d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(303445);
      paramObject = (d)new f(this.mrs, paramInt, paramString2, paramd);
      AppMethodBeat.o(303445);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(303437);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303437);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (kotlin.g.a.a)d.vRa;
      localObject2 = new ah.f();
      Object localObject3;
      for (;;)
      {
        try
        {
          ((ah.f)localObject2).aqH = paramObject.invoke();
          if (((ah.f)localObject2).aqH == null)
          {
            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo tmplParams not exist");
            paramObject = ah.aiuX;
            AppMethodBeat.o(303437);
            return paramObject;
          }
          paramObject = com.tencent.mm.plugin.webview.k.k.Xtc;
          if (com.tencent.mm.plugin.webview.k.k.iCU()) {
            break;
          }
          paramObject = (fnn)((ah.f)localObject2).aqH;
          if (paramObject == null)
          {
            paramObject = null;
            y.bDX(paramObject);
            paramObject = (fnn)((ah.f)localObject2).aqH;
            if (paramObject != null) {
              break label249;
            }
            paramObject = null;
            if (y.ZC(paramObject)) {
              break;
            }
            localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] preloadVideo ");
            paramObject = (fnn)((ah.f)localObject2).aqH;
            if (paramObject != null) {
              break label257;
            }
            paramObject = localObject1;
            Log.i("MicroMsg.BizVideoPreloadLogic", paramObject + " not exist");
            paramObject = ah.aiuX;
            AppMethodBeat.o(303437);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          Log.i("MicroMsg.BizVideoPreloadLogic", s.X("[TRACE_VIDEO_PRELOAD] preloadVideo exception = ", paramObject));
          paramObject = ah.aiuX;
          AppMethodBeat.o(303437);
          return paramObject;
        }
        paramObject = paramObject.abNy;
        continue;
        label249:
        paramObject = paramObject.abNy;
        continue;
        label257:
        paramObject = paramObject.abNy;
      }
      for (;;)
      {
        try
        {
          localObject1 = (m)new e((ah.f)localObject2);
          paramObject = (kotlin.g.a.b)b.vQY;
          localObject3 = (kotlin.g.a.b)c.vQZ;
          localObject1 = (com.tencent.mm.plugin.az.a)((m)localObject1).invoke(this.mrs, ((ah.f)localObject2).aqH);
          localObject4 = e.vQH;
          e.deW().add(new e.a(this.mrs, paramInt, paramString2, (com.tencent.mm.plugin.az.a)localObject1));
          localObject4 = e.vQH;
          e.Hv(((Number)paramObject.invoke(localObject1)).intValue());
          paramObject = e.vQH;
          int i = e.deX();
          switch (i)
          {
          default: 
            localObject3 = new StringBuilder("[TRACE_VIDEO_PRELOAD] tmplParams initFilePath = ");
            paramObject = (fnn)((ah.f)localObject2).aqH;
            if (paramObject != null) {
              break label614;
            }
            paramObject = "";
            paramObject = ((StringBuilder)localObject3).append(paramObject).append(", WebComponent.info = ");
            localObject1 = com.tencent.mm.plugin.webview.l.c.XuL;
            Log.d("MicroMsg.BizVideoPreloadLogic", c.b.gca());
            paramObject = ah.aiuX;
            AppMethodBeat.o(303437);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          Object localObject4;
          paramObject = ah.aiuX;
          AppMethodBeat.o(303437);
          return paramObject;
        }
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo JsStatus.SHOULD_INIT");
        paramObject = (fnn)((ah.f)localObject2).aqH;
        if (paramObject == null)
        {
          paramObject = null;
          s.s(paramObject, "tmplParams?.initFilePath");
          paramObject = (String)((kotlin.g.a.b)localObject3).invoke(paramObject);
          if (paramObject != null)
          {
            localObject3 = e.vQH;
            e.Hv(2);
            localObject3 = WebPrefetcherManifest.vUW;
            localObject4 = (kotlin.g.a.b)a.vQX;
            s.u(localObject1, "manifest");
            s.u(paramObject, "script");
            s.u(localObject4, "onCallback");
            ((WebPrefetcherManifest)localObject3).dgz().a((com.tencent.mm.plugin.az.a)localObject1, paramObject, (kotlin.g.a.b)localObject4);
          }
        }
        else
        {
          paramObject = paramObject.abNy;
          continue;
          e.a(e.vQH);
          continue;
          Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo jsStatus.INIT_ING");
          continue;
          label614:
          localObject1 = paramObject.abNy;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<String, ah>
    {
      public static final a vQX;
      
      static
      {
        AppMethodBeat.i(302980);
        vQX = new a();
        AppMethodBeat.o(302980);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.az.a, Integer>
    {
      public static final b vQY;
      
      static
      {
        AppMethodBeat.i(302977);
        vQY = new b();
        AppMethodBeat.o(302977);
      }
      
      b()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "", "path"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<String, String>
    {
      public static final c vQZ;
      
      static
      {
        AppMethodBeat.i(302990);
        vQZ = new c();
        AppMethodBeat.o(302990);
      }
      
      c()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<fnn>
    {
      public static final d vRa;
      
      static
      {
        AppMethodBeat.i(302976);
        vRa = new d();
        AppMethodBeat.o(302976);
      }
      
      d()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "tmpl", "Lcom/tencent/mm/protocal/protobuf/TmplParams;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements m<String, fnn, com.tencent.mm.plugin.az.a>
    {
      e(ah.f<fnn> paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.e
 * JD-Core Version:    0.7.0.1
 */