package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.brandservice.a.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.vfs.r;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<[Ljava.lang.String;>;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "kotlin.jvm.PlatformType", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isNative", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"})
public final class m
{
  private static final String PROCESS_NAME;
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final AtomicBoolean fpT;
  private static final AtomicBoolean sMY;
  private static final MMKVSlotManager sMZ;
  private static final MMFileSlotManager sNa;
  private static final l sNb;
  private static final HashMap<Integer, Boolean> sNc;
  private static final a sNd;
  private static final kotlin.f sNe;
  private static final boolean sNf = false;
  public static final m sNg;
  
  static
  {
    AppMethodBeat.i(6685);
    sNg = new m();
    TAG = "MicroMsg.PreloadLogic";
    fpT = new AtomicBoolean(false);
    sMY = new AtomicBoolean(false);
    PROCESS_NAME = ToolsMpProcessIPCService.PROCESS_NAME;
    sMZ = new MMKVSlotManager(q.cCt(), 0L, 2, null);
    sNa = new MMFileSlotManager("webcached", 0L, 2, null);
    sNb = new l();
    sNc = new HashMap();
    sNd = new a();
    sNe = kotlin.g.ar((kotlin.g.a.a)g.sNj);
    AppMethodBeat.o(6685);
  }
  
  private static void GX(int paramInt)
  {
    AppMethodBeat.i(6687);
    Log.i(TAG, "start in preCreate");
    aG(paramInt, f.getNetWorkType());
    GZ(-1);
    cCn();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void GY(int paramInt)
  {
    AppMethodBeat.i(6689);
    GZ(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void GZ(int paramInt)
  {
    AppMethodBeat.i(6690);
    Object localObject = j.sMO;
    if (!j.a.cCa())
    {
      AppMethodBeat.o(6690);
      return;
    }
    localObject = PROCESS_NAME;
    p.j(localObject, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)new IPCInteger(paramInt), (com.tencent.mm.ipcinvoker.d)m.sNq, null);
    AppMethodBeat.o(6690);
  }
  
  public static final boolean Gw(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6699);
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class) != null)
    {
      localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class);
      p.j(localObject, "MMKernel.service(IBizTeenModeService::class.java)");
      if (!((com.tencent.mm.api.q)localObject).ZN())
      {
        AppMethodBeat.o(6699);
        return false;
      }
    }
    if (paramInt == 102)
    {
      AppMethodBeat.o(6699);
      return false;
    }
    if (sNc.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = sNc.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.iCn();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = j.sMO;
    if ((!j.a.cCi()) && ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)))
    {
      localObject = (Map)sNc;
      j.a locala = j.sMO;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(k.cqu().getBoolean("preload_use", true)));
      localObject = sNc.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.iCn();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)sNc;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)sNc).put(Integer.valueOf(paramInt), Boolean.FALSE);
        Log.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (sNc.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = sNc.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          p.iCn();
        }
        p.j(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyC, 0) == 0)
        {
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyD, 0) == 0)
          {
            bool = false;
            continue;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyE, 0) & 0x1) == 0) {
              break label896;
            }
            bool = true;
            break;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyE, 0) & 0x2) == 0)
            {
              bool = false;
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyE, 0) & 0x4) == 0)
              {
                bool = false;
                continue;
                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyF, 0) & 0x1) == 0)
                {
                  bool = false;
                  continue;
                  if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyF, 0) & 0x2) == 0)
                  {
                    bool = false;
                    continue;
                    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyF, 0) & 0x4) == 0)
                    {
                      bool = false;
                      continue;
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyI, 0) == 0)
                      {
                        bool = false;
                        continue;
                        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyJ, 0) & 0x1) == 0)
                        {
                          bool = false;
                          continue;
                          if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyJ, 0) & 0x2) == 0)
                          {
                            bool = false;
                            continue;
                            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyJ, 0) & 0x4) == 0)
                            {
                              bool = false;
                              continue;
                              if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyB, 0) == 0)
                              {
                                bool = false;
                                continue;
                                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyK, 0) & 0x1) == 0)
                                {
                                  bool = false;
                                  continue;
                                  i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyL, 0);
                                  if ((i & 0x1) == 0)
                                  {
                                    bool = false;
                                    continue;
                                    bool = false;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        bool = false;
      }
    }
    for (;;)
    {
      break;
      label896:
      bool = false;
    }
  }
  
  private static int Ha(int paramInt)
  {
    AppMethodBeat.i(261158);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(261158);
      return -1;
    case 0: 
      if (Gw(102))
      {
        AppMethodBeat.o(261158);
        return 5;
      }
      AppMethodBeat.o(261158);
      return 0;
    }
    if (Gw(102))
    {
      AppMethodBeat.o(261158);
      return 5;
    }
    AppMethodBeat.o(261158);
    return 4;
  }
  
  private static int Hb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  private static int Hc(int paramInt)
  {
    int i = 2;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 0: 
    case 92: 
      return i;
    case 1: 
      return 13;
    case 2: 
      return 14;
    }
    return 6;
  }
  
  private static com.tencent.mm.an.d.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    ju localju = new ju();
    localju.sSU = f.getNetWorkType();
    localju.RPv = q.cCs();
    localju.RPu = new LinkedList();
    localju.RPw = paramInt2;
    localju.RPx = paramInt3;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).sNh;
      localObject3 = new dyh();
      ((dyh)localObject3).Url = ((String)localObject2);
      ((dyh)localObject3).RKi = 0;
      ((dyh)localObject3).CPw = paramInt1;
      localObject2 = sNd.apX((String)localObject2);
      if (localObject2 != null)
      {
        ((dyh)localObject3).RKi = ((fh)localObject2).RKi;
        if (!a((fh)localObject2, paramInt2)) {
          ((dyh)localObject3).RKi = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localju.RPu.addAll((Collection)localObject1);
    Log.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localju.RPu.size()) });
    Log.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new com.tencent.mm.an.d.a();
    paramIterable.vD(2594);
    paramIterable.TW("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.vF(0);
    paramIterable.vG(0);
    paramIterable.c((com.tencent.mm.cd.a)localju);
    paramIterable.d((com.tencent.mm.cd.a)new jv());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.h.a.lz(paramInt1, localju.RPu.size());
      AppMethodBeat.o(6708);
      return paramIterable;
      paramInt1 = 34;
      continue;
      paramInt1 = 35;
    }
  }
  
  private static <T extends List<? extends C>, C> C a(T paramT, int paramInt, C paramC)
  {
    AppMethodBeat.i(6709);
    if (paramT.size() > paramInt)
    {
      paramT = paramT.get(paramInt);
      AppMethodBeat.o(6709);
      return paramT;
    }
    AppMethodBeat.o(6709);
    return paramC;
  }
  
  private static String a(String paramString, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(6696);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramIntent.putExtra("bizEnterId", i);
    if (!kotlin.n.n.a((CharSequence)paramString, (CharSequence)"clicktime", false)) {}
    for (paramIntent = UrlExKt.appendUrlParam(paramString, "clicktime", String.valueOf(i));; paramIntent = paramString)
    {
      Object localObject = paramIntent;
      if (!kotlin.n.n.a((CharSequence)paramString, (CharSequence)"enterid", false)) {
        localObject = UrlExKt.appendUrlParam(paramIntent, "enterid", String.valueOf(i));
      }
      AppMethodBeat.o(6696);
      return localObject;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, dny paramdny, String paramString1, String paramString2)
  {
    AppMethodBeat.i(261171);
    if (paramdny.llp == 5) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.by.c.b(paramContext, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(261171);
  }
  
  private static void a(Bundle paramBundle, final kotlin.g.a.b<? super Bundle, x> paramb)
  {
    AppMethodBeat.i(6706);
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis() % 100L;
    ArrayList localArrayList = paramBundle.getStringArrayList("urls");
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject1 = localArrayList.get(0);
      p.j(localObject1, "urls[0]");
      localObject1 = c.apN((String)localObject1);
      if (cCm().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)cCm().get(localObject1);
        if (paramBundle != null) {
          paramBundle.add(paramb);
        }
        Log.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
        AppMethodBeat.o(6706);
        return;
      }
    }
    Object localObject1 = paramBundle.getIntegerArrayList("tmplTypes");
    int k = paramBundle.getInt("openScene");
    int m = paramBundle.getInt("strip", 0);
    int n = paramBundle.getInt("stripType", 0);
    paramBundle = new LinkedList();
    if (localArrayList != null)
    {
      int i1 = localArrayList.size();
      int i = 0;
      if (i < i1)
      {
        Object localObject2 = (CharSequence)localArrayList.get(i);
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0)
          {
            localObject2 = localArrayList.get(i);
            p.j(localObject2, "urls[i]");
            localObject2 = (String)localObject2;
            if (localObject1 == null) {
              p.iCn();
            }
            Object localObject3 = ((ArrayList)localObject1).get(i);
            p.j(localObject3, "tmplTypes!![i]");
            paramBundle.add(new d((String)localObject2, ((Number)localObject3).intValue()));
            localObject2 = localArrayList.get(i);
            p.j(localObject2, "urls[i]");
            localObject2 = c.apN((String)localObject2);
            ((Map)cCm()).put(localObject2, new ConcurrentLinkedDeque());
            Log.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
          }
          i += 1;
          break;
        }
      }
    }
    aa.a(a((Iterable)paramBundle, k, m, n).bgN(), (aa.a)new r(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(6706);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    p.k(???, "url");
    p.k(paramVarArgs, "params");
    if (sNf)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new ae(3);
    ((ae)localObject1).add(???);
    ((ae)localObject1).add(Integer.valueOf(paramInt1));
    ((ae)localObject1).eZ(paramVarArgs);
    paramVarArgs = kotlin.a.j.ag(((ae)localObject1).toArray(new Object[((ae)localObject1).fmA.size()]));
    localObject1 = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject2 = (by)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject1);
      if (localObject2 != null) {
        ((by)localObject2).a(null);
      }
      localObject2 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!((HashMap)localObject2).containsKey(localObject1)) {
        ((Map)localObject2).put(localObject1, new LinkedList());
      }
      localObject2 = ((HashMap)localObject2).get(localObject1);
      if (localObject2 == null)
      {
        paramVarArgs = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(6711);
        throw paramVarArgs;
      }
    }
    ((LinkedList)localObject2).add(paramVarArgs);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject1, kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new e(1000L, (String)localObject1, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private final void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, kotlin.g.a.m<? super c, ? super jv, x> paramm)
  {
    AppMethodBeat.i(6704);
    Bundle localBundle = new Bundle();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).url);
    }
    localBundle.putStringArrayList("urls", new ArrayList((Collection)localObject1));
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).sNh));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.h.aHD().aHf();
    p.j(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).aIE())
    {
      a(localBundle, (kotlin.g.a.b)new o(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, b.class, (com.tencent.mm.ipcinvoker.f)new p(paramm));
    AppMethodBeat.o(6704);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, dny paramdny, c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(261167);
    ese localese = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.Hn(paramdny.sNh);
    if ((localese == null) && ((paramdny.llp == 0) || (paramdny.llp == -1)))
    {
      Log.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramdny + ".tmplType");
      AppMethodBeat.o(261167);
      return false;
    }
    boolean bool1 = WXHardCoderJNI.hcBizEnable;
    int j = WXHardCoderJNI.hcBizDelay;
    int k = WXHardCoderJNI.hcBizCPU;
    int m = WXHardCoderJNI.hcBizIO;
    int i;
    if (WXHardCoderJNI.hcBizThr) {
      i = Process.myTid();
    }
    for (;;)
    {
      i = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, TAG);
      Log.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(i) });
      label226:
      Object localObject;
      if (localese == null)
      {
        parama = paramdny.url;
        p.j(parama, "session.url");
        paramIntent.putExtra("rawUrl", UrlExKt.appendStats(a(parama, false, paramIntent), paramdny));
        p.j(paramIntent.putExtra(f.r.VSR, true), "intent.putExtra(Constant…wUI.KTmplForeceUrl, true)");
        parama = f.r.VSF;
        localObject = j.sMO;
        paramIntent.putExtra(parama, j.a.cCa());
        paramIntent.putExtra(f.r.VSG, System.currentTimeMillis());
        paramIntent.putExtra(f.r.VSI, paramdny.url);
        localObject = f.r.VSE;
        if (localese == null) {
          break label905;
        }
        parama = localese.toByteArray();
        paramIntent.putExtra((String)localObject, parama);
        paramIntent.putExtra(f.r.VSQ, paramdny.toByteArray());
        paramIntent.putExtra(f.r.VSN, Process.myPid());
      }
      try
      {
        paramIntent.putExtra(f.r.VSM, f.c(paramContext, (kotlin.g.a.b)s.sNv));
        if (paramBoolean)
        {
          paramBoolean = paramdny.TVh;
          if (!paramBoolean) {}
        }
        try
        {
          p.k(paramIntent, "intent");
          parama = PROCESS_NAME;
          p.j(parama, "PROCESS_NAME");
          com.tencent.mm.ipcinvoker.a.a(parama, (Parcelable)paramIntent, (com.tencent.mm.ipcinvoker.d)t.sNw, null);
          a(paramContext, paramIntent, paramdny, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
          if (localese != null)
          {
            com.tencent.mm.plugin.webview.h.a.gU(localese.reportId, 106);
            com.tencent.mm.plugin.webview.h.a.anX(100);
            if (paramdny.TVi)
            {
              com.tencent.mm.plugin.webview.h.a.gU(localese.reportId, 231);
              com.tencent.mm.plugin.webview.h.a.anX(110);
            }
          }
          AppMethodBeat.o(261167);
          return true;
          i = 0;
          continue;
          paramdny.ktM = localese.ktM;
          com.tencent.mm.plugin.webview.h.a.gU(localese.reportId, 104);
          localObject = paramdny.url;
          p.j(localObject, "session.url");
          localObject = de((String)localObject, paramdny.sNh);
          if (localObject != null)
          {
            String str = ((fh)localObject).RKh;
            if (str != null)
            {
              if (!kotlin.n.n.ba((CharSequence)str))
              {
                i = 1;
                if (i != 1) {
                  break label704;
                }
                if ((!((fh)localObject).RKo) && (paramdny.llp != 0)) {
                  break label692;
                }
                paramIntent = new Intent();
                paramIntent.putExtra(f.r.VSK, paramdny.svv);
              }
              for (;;)
              {
                localObject = ((fh)localObject).RKh;
                p.j(localObject, "appMsgContext.ForceUrl");
                localObject = a(UrlExKt.appendStats((String)localObject, paramdny), false, paramIntent);
                Log.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
                paramIntent.putExtra("rawUrl", (String)localObject);
                if (paramBoolean) {
                  a(paramContext, paramIntent, paramdny, "webview", ".ui.tools.WebViewUI");
                }
                com.tencent.mm.plugin.webview.h.a.gU(localese.reportId, 107);
                parama.success = true;
                parama.message = "has forceUrl=".concat(String.valueOf(localObject));
                AppMethodBeat.o(261167);
                return true;
                i = 0;
                break;
                label692:
                paramIntent.putExtra(f.r.VSR, true);
              }
            }
          }
          label704:
          parama = paramdny.url;
          p.j(parama, "session.url");
          paramdny.url = a(parama, false, paramIntent);
          paramIntent.putExtra("rawUrl", paramdny.url);
          paramdny.TVg = true;
          parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.Hl(localese.sNh);
          paramdny.TVi = q.d(parama);
          boolean bool2 = p.h(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.getPrefix(), "mptmpl://");
          if ((q.d(parama)) && (bool2))
          {
            bool1 = true;
            label792:
            paramdny.TVj = bool1;
            if ((!q.d(parama)) || (bool2)) {
              break label868;
            }
          }
          label868:
          for (bool1 = true;; bool1 = false)
          {
            paramdny.TVk = bool1;
            if ((localObject == null) || (!n.b((fh)localObject))) {
              break label874;
            }
            paramdny.TVh = true;
            Log.i(TAG, "set contentId:%s", new Object[] { c.a((fh)localObject) });
            break;
            bool1 = false;
            break label792;
          }
          label874:
          parama = paramdny.url;
          p.j(parama, "session.url");
          a(paramContext, parama, paramdny, (kotlin.g.a.q)j.sNm);
          break label226;
          label905:
          parama = null;
        }
        catch (Throwable parama)
        {
          for (;;)
          {
            Log.i(TAG, "updateWebview ex " + parama.getMessage());
          }
        }
        return false;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "startPreloadWebView", new Object[0]);
        AppMethodBeat.o(261167);
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(261153);
    p.k(paramContext, "context");
    p.k(paramString, "rawUrl");
    p.k(paramIntent, "intent");
    p.k(parama, "result");
    if (kotlin.n.n.ba((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(261153);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(261153);
      return false;
    }
    if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext))
    {
      Log.i(TAG, "Block mp rawUrl %s", new Object[] { paramString });
      parama.success = false;
      parama.message = "mp url currently blocked";
      AppMethodBeat.o(261153);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = sNd.apX(paramString);
      if (localObject != null) {
        i = ((fh)localObject).lpx;
      }
    }
    for (;;)
    {
      if (i == 5) {
        com.tencent.mm.pluginsdk.ui.tools.ab.hnS();
      }
      int k = Ha(i);
      if (k == -1)
      {
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(i));
        AppMethodBeat.o(261153);
        return false;
        i = paramInt1;
      }
      else
      {
        int m = com.tencent.mm.storage.ab.getSessionId();
        localObject = UrlExKt.getUrlParam(paramString, "scene");
        int j = paramInt2;
        CharSequence localCharSequence;
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          j = paramInt2;
          if (new kotlin.n.k("\\d+").aY(localCharSequence)) {
            j = Integer.parseInt((String)localObject);
          }
        }
        localObject = UrlExKt.getUrlParam(paramString, "subscene");
        paramInt2 = paramInt3;
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          paramInt2 = paramInt3;
          if (new kotlin.n.k("\\d+").aY(localCharSequence)) {
            paramInt2 = Integer.parseInt((String)localObject);
          }
        }
        paramIntent.putExtra(f.r.VSO, i);
        paramIntent.putExtra(f.r.VSJ, m);
        paramIntent.putExtra(f.r.VSK, j);
        paramIntent.putExtra(f.r.VSL, paramInt2);
        paramIntent.putExtra(f.r.VSP, paramInt4);
        paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
        localObject = new dny();
        ((dny)localObject).id = m;
        ((dny)localObject).url = paramString;
        ((dny)localObject).llp = i;
        ((dny)localObject).sNh = k;
        ((dny)localObject).svv = j;
        ((dny)localObject).wGA = paramInt2;
        ((dny)localObject).TVf = paramInt3;
        boolean bool;
        if (i != paramInt1)
        {
          bool = true;
          ((dny)localObject).sMn = bool;
          paramBoolean = sNg.a(paramContext, paramIntent, (dny)localObject, parama, paramBoolean);
          if (paramBoolean)
          {
            if ((paramInt4 != -1) && ((paramContext instanceof MMActivity)) && (paramInt4 == 1)) {
              ((MMActivity)paramContext).overridePendingTransition(com.tencent.mm.plugin.brandservice.d.a.push_up_in, com.tencent.mm.plugin.brandservice.d.a.push_empty_out);
            }
            switch (j)
            {
            default: 
              paramInt1 = -1;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.webview.h.a.anW(paramInt1);
          AppMethodBeat.o(261153);
          return paramBoolean;
          bool = false;
          break;
          paramInt1 = 0;
          continue;
          paramInt1 = 1;
          continue;
          paramInt1 = 2;
          continue;
          paramInt1 = 3;
        }
        i = paramInt1;
      }
    }
  }
  
  private static boolean a(fh paramfh, int paramInt)
  {
    AppMethodBeat.i(6702);
    esd localesd = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.Hl(paramInt);
    Object localObject = (CharSequence)paramfh.RKh;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (q.a(localesd))
    {
      paramfh = paramfh.RKp;
      if (paramfh != null)
      {
        paramfh = ((Iterable)paramfh).iterator();
        while (paramfh.hasNext())
        {
          localObject = (esd)paramfh.next();
          Log.v(TAG, "checkDataVerVaild: " + ((esd)localObject).rWu + ' ' + localesd.rWu + ' ' + ((esd)localObject).UtW + ' ' + localesd.UtW);
          if ((((esd)localObject).rWu == localesd.rWu) && (p.h(((esd)localObject).UtW, localesd.UtW)))
          {
            Log.v(TAG, "checkDataVerVaild: " + ((esd)localObject).rWt + " tmplInfo:" + localesd.rWt);
            if (((esd)localObject).rWt >= localesd.rWt)
            {
              AppMethodBeat.o(6702);
              return true;
            }
            AppMethodBeat.o(6702);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(6702);
    return false;
  }
  
  private static void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    p.k(paramString, "netType");
    String str = MainProcessIPCService.PROCESS_NAME;
    p.j(str, "MainProcessIPCService.PROCESS_NAME");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.d)i.sNl, null);
    AppMethodBeat.o(6691);
  }
  
  public static void apU(String paramString)
  {
    AppMethodBeat.i(6710);
    p.k(paramString, "url");
    Log.d(TAG, "removePreload %s", new Object[] { paramString });
    p.k(paramString, "url");
    String str = c.apJ(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)sMZ.findSlot(str);
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.removeValueForKey(str);
      localMultiProcessMMKV.removeValueForKey(c.apN(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void apV(String paramString)
  {
    AppMethodBeat.i(6715);
    p.k(paramString, "url");
    String str = MainProcessIPCService.PROCESS_NAME;
    p.j(str, "MainProcessIPCService.PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.d)n.sNr, null);
    AppMethodBeat.o(6715);
  }
  
  public static long apW(String paramString)
  {
    AppMethodBeat.i(6716);
    p.k(paramString, "url");
    paramString = c.apO(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)sMZ.findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      long l = localMultiProcessMMKV.getLong(paramString, 0L);
      AppMethodBeat.o(6716);
      return l;
    }
    AppMethodBeat.o(6716);
    return 0L;
  }
  
  private final void b(List<d> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6703);
    j.a locala = j.sMO;
    if (!j.a.cCb())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (kotlin.g.a.m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  public static MMKVSlotManager cCj()
  {
    return sMZ;
  }
  
  public static MMFileSlotManager cCk()
  {
    return sNa;
  }
  
  public static a cCl()
  {
    return sNd;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, x>>> cCm()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)sNe.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  private static void cCn()
  {
    AppMethodBeat.i(6714);
    String str = MainProcessIPCService.PROCESS_NAME;
    p.j(str, "MainProcessIPCService.PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, null, (com.tencent.mm.ipcinvoker.d)h.sNk, null);
    AppMethodBeat.o(6714);
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    a.cCr();
    Log.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.cDn();
    AppMethodBeat.o(6688);
  }
  
  private static fh de(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (kotlin.n.n.ba((CharSequence)paramString))
    {
      Log.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (sNd.df(paramString, paramInt))
    {
      paramString = sNd.apX(paramString);
      AppMethodBeat.o(6700);
      return paramString;
    }
    AppMethodBeat.o(6700);
    return null;
  }
  
  public static final void j(List<? extends List<String>> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6713);
    p.k(paramList, "items");
    if (sNf)
    {
      AppMethodBeat.o(6713);
      return;
    }
    int k;
    Object localObject2;
    label68:
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label871;
      }
      k = Hb(paramInt);
      if (k == 0) {
        break label356;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label356;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
      localObject4 = ((List)localObject1).get(2);
      str = com.tencent.mm.compatible.util.q.aT((String)((List)localObject1).get(0));
      localObject5 = a((List)localObject1, 3, "");
      localObject6 = a((List)localObject1, 4, "");
      localObject7 = ((List)localObject1).get(1);
      localObject8 = a((List)localObject1, 5, "");
      localObject9 = a((List)localObject1, 6, "");
      localObject10 = a((List)localObject1, 7, "");
      if (!p.h((String)((List)localObject1).get(1), "-1")) {
        break label346;
      }
      localObject1 = (String)((List)localObject1).get(0);
      if (localObject1 == null) {
        break label340;
      }
      localObject1 = Boolean.valueOf(UrlExKt.isMpArticleUrl((String)localObject1));
      label236:
      if (!((Boolean)localObject1).booleanValue()) {
        break label346;
      }
      i = 1;
      label246:
      if (i == 0) {
        break label351;
      }
    }
    label340:
    label346:
    label351:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject3).a(16468, new Object[] { Integer.valueOf(k), localObject4, str, localObject5, localObject6, Integer.valueOf(1), localObject7, localObject8, localObject9, localObject10, Integer.valueOf(i) });
      break label68;
      i = 0;
      break;
      localObject1 = null;
      break label236;
      i = 0;
      break label246;
    }
    label356:
    if (Gw(Hc(paramInt)))
    {
      k = c.GU(paramInt);
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!UrlExKt.isMpArticleUrl((String)((List)localObject2).get(0))) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label458;
          }
          paramList.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        paramList.add(new d((String)((List)localObject2).get(0), Ha(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).sNh;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (sNd.df((String)localObject4, i))) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label672;
          }
          paramList.add(localObject2);
          break;
        }
      }
      paramList = (List)paramList;
      int m = Math.max(paramList.size() - k, 0);
      localObject2 = kotlin.a.j.c((Iterable)paramList, k);
      i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        sNg.b((List)localObject2, paramInt, m, 1);
        if (Log.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls toStrip:").append(k).append(" strip:").append(m).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(c.apN(((d)((Iterator)localObject3).next()).url));
          }
          Log.v(paramList, (List)localObject2);
        }
      }
    }
    label458:
    label871:
    AppMethodBeat.o(6713);
    label672:
  }
  
  public static final void k(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6712);
    p.k(paramList, "items");
    if (sNf)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!Gw(Hc(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = c.GU(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(Long.parseLong(paramList[0]), paramList[1]).lpz;
      if (i > 0) {
        p.j(paramList, "it");
      }
      for (paramList = kotlin.a.j.c((Iterable)paramList, i);; paramList = (List)paramList)
      {
        kotlin.a.j.a((Collection)localObject1, (Iterable)paramList);
        break;
      }
    }
    paramList = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (v)((Iterator)localObject3).next();
      localObject1 = ((v)localObject4).url;
      paramList = (List<String[]>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(new d(paramList, Ha(((v)localObject4).type)));
    }
    localObject1 = (Iterable)localObject2;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label382:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (d)localObject2;
      localObject4 = ((d)localObject3).url;
      i = ((d)localObject3).sNh;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (sNd.df((String)localObject4, i))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label382;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = (List)paramList;
    int k = Math.max(paramList.size() - j, 0);
    localObject2 = kotlin.a.j.c((Iterable)paramList, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      sNg.b((List)localObject2, paramInt, k, 1);
      if (Log.getLogLevel() == 0)
      {
        paramList = TAG;
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer toStrip:").append(j).append(" strip:").append(k).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(c.apN(((d)((Iterator)localObject3).next()).url));
            continue;
            i = 0;
            break;
          }
        }
        Log.v(paramList, (List)localObject2);
      }
    }
    AppMethodBeat.o(6712);
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(6686);
    if (sMY.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    sMY.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.xwebutil.c.ikh();
      GX(paramInt);
      sMY.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new q(paramInt));
    AppMethodBeat.o(6686);
  }
  
  public final void a(final Object paramObject, String paramString, dny paramdny, final kotlin.g.a.q<? super WeakReference<Object>, ? super c, ? super fh, x> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(261201);
    p.k(paramObject, "context");
    p.k(paramString, "url");
    p.k(paramdny, "session");
    p.k(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = j.sMO;
    if (j.a.cCc())
    {
      ((c)localObject1).isSuccess = true;
      paramq.c(paramObject, localObject1, new fh());
      AppMethodBeat.o(261201);
      return;
    }
    if ((kotlin.n.n.ba((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.c(paramObject, localObject1, new fh());
      AppMethodBeat.o(261201);
      return;
    }
    localObject2 = de(paramString, paramdny.sNh);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getAppMsgContext ");
    if (localObject2 == null) {
      bool = true;
    }
    Log.d(str, bool);
    if (localObject2 != null)
    {
      ((c)localObject1).isSuccess = true;
      ((c)localObject1).bpU = true;
      paramq.c(paramObject, localObject1, localObject2);
      AppMethodBeat.o(261201);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramdny);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramdny.sNh));
    a(this, (List)localObject1, paramdny.sNh, (kotlin.g.a.m)new k(paramString, paramq, paramObject));
    AppMethodBeat.o(261201);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "save", "plugin-brandservice_release"})
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    private final boolean c(fh paramfh, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (paramfh == null)
      {
        Log.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = m.sNg;
      if (!m.b(paramfh, paramInt))
      {
        Log.v(this.TAG, "checkValid: invalid version:data(" + paramfh.RKk + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = j.sMO;
      if (j.a.cCd()) {
        Log.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = paramfh.Url;
        p.j(localObject1, "appMsgContext.Url");
        localObject1 = c.apO((String)localObject1);
        Object localObject2 = m.sNg;
        localObject2 = (MultiProcessMMKV)m.cCj().findSlot((String)localObject1);
        if (localObject2 != null) {}
        for (boolean bool = f.a((MultiProcessMMKV)localObject2, (String)localObject1, paramfh.RKg * 1000L); bool; bool = true)
        {
          Log.i(this.TAG, "checkValid: expire for " + paramfh.RKg);
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public static boolean cCr()
    {
      AppMethodBeat.i(6642);
      m localm = m.sNg;
      m.cCj().verifyAllSlot();
      AppMethodBeat.o(6642);
      return true;
    }
    
    public final void a(String paramString, fh paramfh)
    {
      AppMethodBeat.i(6641);
      p.k(paramString, "url");
      if (paramfh != null)
      {
        localObject1 = (CharSequence)paramfh.lpy;
        if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
          break label60;
        }
      }
      label60:
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(this.TAG, "save fail, appMsgContext is null");
        AppMethodBeat.o(6641);
        return;
      }
      Object localObject1 = c.apJ(paramString);
      Object localObject2 = paramfh.lpy;
      try
      {
        Object localObject3 = new fh();
        ((fh)localObject3).parseFrom(paramfh.toByteArray());
        ((fh)localObject3).lpy = null;
        Object localObject4 = ((fh)localObject3).toByteArray();
        localObject3 = m.sNg;
        localObject3 = (MultiProcessMMKV)m.cCj().getSlotForWrite();
        ((MultiProcessMMKV)localObject3).encode((String)localObject1, (byte[])localObject4);
        localObject4 = m.sNg;
        localObject4 = c.G(c.a(m.cCk(), c.apN(paramString)));
        p.j(localObject2, "content");
        Charset localCharset = kotlin.n.d.UTF_8;
        p.k(localObject4, "$this$writeText");
        p.k(localObject2, "text");
        p.k(localCharset, "charset");
        localObject2 = ((String)localObject2).getBytes(localCharset);
        p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        r.b((com.tencent.mm.vfs.q)localObject4, (byte[])localObject2);
        f.b((MultiProcessMMKV)localObject3, c.apO(paramString));
        Log.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + paramfh.RKi);
        AppMethodBeat.o(6641);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramString, "save ".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
    }
    
    public final fh apX(String paramString)
    {
      AppMethodBeat.i(6639);
      p.k(paramString, "url");
      String str = c.apJ(paramString);
      Object localObject1 = m.sNg;
      localObject1 = (MultiProcessMMKV)m.cCj().findSlot(str);
      int i;
      if (localObject1 != null) {
        if (((MultiProcessMMKV)localObject1).containsKey(str))
        {
          localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
          if (localObject1 != null) {
            if (localObject1.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label162;
              }
              i = 1;
              label71:
              if (i == 0) {
                break label185;
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          Object localObject3 = fh.class.newInstance();
          ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.cd.a)localObject3;
          localObject1 = (fh)localObject1;
          if (localObject1 == null) {
            break label195;
          }
          ((fh)localObject1).Url = paramString;
          Log.i(this.TAG, "found:" + str + " last modify:" + ((fh)localObject1).RKi);
          AppMethodBeat.o(6639);
          return localObject1;
        }
        catch (Exception localException)
        {
          label162:
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break;
        i = 0;
        break label71;
        label185:
        Object localObject2 = null;
        continue;
        localObject2 = null;
      }
      label195:
      Log.i(this.TAG, "not found:".concat(String.valueOf(str)));
      AppMethodBeat.o(6639);
      return null;
    }
    
    public final boolean df(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      p.k(paramString, "url");
      fh localfh = apX(paramString);
      if (localfh == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      Object localObject = m.sNg;
      int i;
      if (localfh != null)
      {
        localObject = Integer.valueOf(localfh.lpx);
        i = m.Hd(((Integer)localObject).intValue());
        if (i != -1) {
          break label122;
        }
      }
      for (;;)
      {
        boolean bool = c(localfh, paramInt);
        if (!bool) {
          Log.d(this.TAG, "init invalid:" + c.apJ(paramString));
        }
        AppMethodBeat.o(6638);
        return bool;
        localObject = null;
        break;
        label122:
        paramInt = i;
      }
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Bundle, x>
    {
      a(com.tencent.mm.ipcinvoker.f paramf)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
  public static final class c
  {
    public long aYz;
    public boolean bpU;
    public boolean isSuccess;
    public boolean sMk;
    public long start;
    
    private c(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.isSuccess = paramBoolean1;
      this.start = paramLong1;
      this.aYz = paramLong2;
      this.sMk = paramBoolean2;
      this.bpU = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"})
  static final class d
  {
    final int sNh;
    final String url;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.sNh = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class e
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public e(long paramLong, String paramString, kotlin.d.d paramd, int paramInt)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      p.k(paramd, "completion");
      paramd = new e(this.$delay, this.$key, paramd, this.soM);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(6658);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6659);
      paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(6659);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6657);
      Object localObject1 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6657);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        long l = this.$delay;
        this.L$0 = paramObject;
        this.label = 1;
        if (aw.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6657);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!al.a(paramObject))
      {
        paramObject = x.aazN;
        AppMethodBeat.o(6657);
        return paramObject;
      }
      int i;
      Object localObject4;
      Object localObject3;
      for (;;)
      {
        synchronized (__BATCH_RUN_OBJ.INSTANCE)
        {
          localObject1 = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break label1662;
            }
            paramObject = (List)paramObject;
            if ((!WeChatEnvironment.hasDebugger()) || (Log.getLogLevel() != 0)) {
              break label383;
            }
            if (((Collection)paramObject).isEmpty())
            {
              i = 1;
              if (i != 0) {
                break label383;
              }
              localObject1 = m.sNg;
              localObject1 = m.cCo();
              ??? = new StringBuilder("preloadData addToPreload batch:");
              localObject4 = (Iterable)paramObject;
              localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(c.apN(((ArrayList)((Iterator)localObject4).next()).get(0).toString()));
              continue;
            }
          }
          else
          {
            paramObject = null;
          }
        }
        i = 0;
      }
      Log.v((String)localObject1, (List)localObject3);
      label383:
      localObject1 = x.aazN;
      localObject1 = (Iterable)kotlin.a.j.m((Iterable)paramObject);
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label484:
      while (((Iterator)localObject1).hasNext())
      {
        ??? = ((Iterator)localObject1).next();
        localObject3 = (ArrayList)???;
        if ((localObject3 != null) && ((((ArrayList)localObject3).get(0) instanceof String))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label484;
          }
          paramObject.add(???);
          break;
        }
      }
      ??? = (Iterable)paramObject;
      paramObject = new HashSet();
      localObject1 = new ArrayList();
      ??? = ((Iterable)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = ((Iterator)???).next();
        localObject4 = ((ArrayList)localObject3).get(0);
        if (localObject4 == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(6657);
          throw paramObject;
        }
        if (paramObject.add(c.apN((String)localObject4))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = m.sNg;
        int j = m.He(this.soM);
        if (j != 0)
        {
          ??? = ((Iterable)localObject1).iterator();
          if (((Iterator)???).hasNext())
          {
            paramObject = (ArrayList)((Iterator)???).next();
            localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
            localObject4 = m.sNg;
            localObject4 = m.b((List)paramObject, 2, "");
            Object localObject5 = paramObject.get(0);
            if (localObject5 == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject5 = com.tencent.mm.compatible.util.q.aT((String)localObject5);
            Object localObject6 = m.sNg;
            localObject6 = m.b((List)paramObject, 3, "");
            Object localObject7 = m.sNg;
            localObject7 = m.b((List)paramObject, 4, "");
            Object localObject8 = paramObject.get(1);
            Object localObject9 = m.sNg;
            localObject9 = m.b((List)paramObject, 5, "");
            Object localObject10 = m.sNg;
            localObject10 = m.b((List)paramObject, 6, "");
            Object localObject11 = m.sNg;
            localObject11 = m.b((List)paramObject, 7, "");
            Object localObject12 = paramObject.get(1);
            if (localObject12 == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            if (((Integer)localObject12).intValue() == -1)
            {
              paramObject = paramObject.get(0);
              if (paramObject == null)
              {
                paramObject = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(6657);
                throw paramObject;
              }
              paramObject = (String)paramObject;
              if (paramObject != null)
              {
                paramObject = Boolean.valueOf(UrlExKt.isMpArticleUrl(paramObject));
                label916:
                if (!paramObject.booleanValue()) {
                  break label1018;
                }
                i = 1;
                label925:
                if (i == 0) {
                  break label1023;
                }
              }
            }
            label1018:
            label1023:
            for (i = 1;; i = 0)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject3).a(16468, new Object[] { Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7, Integer.valueOf(2), localObject8, localObject9, localObject10, localObject11, Integer.valueOf(i) });
              break;
              paramObject = null;
              break label916;
              i = 0;
              break label925;
            }
          }
        }
        paramObject = m.sNg;
        if (m.Gw(m.Hf(this.soM)))
        {
          j = c.GU(this.soM);
          localObject1 = (Iterable)localObject1;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1165:
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((Iterator)localObject1).next();
            localObject3 = ((ArrayList)???).get(0);
            if (localObject3 == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            if (!UrlExKt.isMpArticleUrl((String)localObject3)) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1165;
              }
              paramObject.add(???);
              break;
            }
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (ArrayList)((Iterator)localObject1).next();
            localObject3 = ((ArrayList)???).get(0);
            if (localObject3 == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject3 = (String)localObject3;
            localObject4 = m.sNg;
            ??? = ((ArrayList)???).get(1);
            if (??? == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            paramObject.add(new m.d((String)localObject3, m.Hd(((Integer)???).intValue())));
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1441:
          label1444:
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((Iterator)localObject1).next();
            localObject4 = (m.d)???;
            localObject3 = ((m.d)localObject4).url;
            i = ((m.d)localObject4).sNh;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = m.sNg;
              if (!m.cCl().df((String)localObject3, i)) {
                break label1441;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1444;
              }
              paramObject.add(???);
              break;
            }
          }
          paramObject = (List)paramObject;
          int k = Math.max(paramObject.size() - j, 0);
          localObject1 = x.aazN;
          ??? = kotlin.a.j.c((Iterable)paramObject, j);
          if (!((Collection)???).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            m.a(m.sNg, (List)???, this.soM, k);
            if (Log.getLogLevel() == 0)
            {
              paramObject = m.sNg;
              paramObject = m.cCo();
              localObject1 = new StringBuilder("preloadData addToPreload toStrip:").append(j).append(" strip:").append(k).append("  dispatch:");
              localObject3 = (Iterable)???;
              ??? = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)???).add(c.apN(((m.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              Log.v(paramObject, (List)???);
            }
          }
          paramObject = x.aazN;
        }
      }
      paramObject = x.aazN;
      label1662:
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = x.aazN;
      AppMethodBeat.o(6657);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.m<m.c, jv, x>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<? super Bundle, ? extends x>>>>
  {
    public static final g sNj;
    
    static
    {
      AppMethodBeat.i(6662);
      sNj = new g();
      AppMethodBeat.o(6662);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class h<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {
    public static final h sNk;
    
    static
    {
      AppMethodBeat.i(258816);
      sNk = new h();
      AppMethodBeat.o(258816);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class i<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<Bundle, IPCVoid>
  {
    public static final i sNl;
    
    static
    {
      AppMethodBeat.i(263518);
      sNl = new i();
      AppMethodBeat.o(263518);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.q<WeakReference<Object>, m.c, fh, x>
  {
    public static final j sNm;
    
    static
    {
      AppMethodBeat.i(6664);
      sNm = new j();
      AppMethodBeat.o(6664);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<m.c, jv, x>
  {
    k(String paramString, kotlin.g.a.q paramq, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
  public static final class l
    extends HashMap<Integer, String>
  {
    l()
    {
      AppMethodBeat.i(6666);
      put(Integer.valueOf(1), "100463");
      put(Integer.valueOf(3), "100486");
      AppMethodBeat.o(6666);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "tmplType", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class m<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<IPCInteger, IPCVoid>
  {
    public static final m sNq;
    
    static
    {
      AppMethodBeat.i(264385);
      sNq = new m();
      AppMethodBeat.o(264385);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class n<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<IPCString, IPCVoid>
  {
    public static final n sNr;
    
    static
    {
      AppMethodBeat.i(257542);
      sNr = new n();
      AppMethodBeat.o(257542);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Bundle, x>
  {
    o(kotlin.g.a.m paramm)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class p<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    p(kotlin.g.a.m paramm) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class q
    implements MessageQueue.IdleHandler
  {
    q(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.xwebutil.c.ikh();
      m.a(m.sNg, this.soG);
      m localm = m.sNg;
      m.cCp().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class r
    implements aa.a
  {
    r(long paramLong1, long paramLong2, kotlin.g.a.b paramb, ArrayList paramArrayList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(6680);
      paramq = m.sNg;
      Log.i(m.cCo(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = new Bundle();
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.j(paramd, "rr");
        if ((paramd.bhY() != null) && ((paramd.bhY() instanceof jv)))
        {
          paramd = paramd.bhY();
          if (paramd == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
            AppMethodBeat.o(6680);
            throw paramString;
          }
          paramd = (jv)paramd;
          paramString.putBoolean("success", true);
          paramString.putByteArray("response", paramd.toByteArray());
          paramq = paramd.RPz;
          p.j(paramq, "response.SceneControlList");
          if (!((Collection)paramq).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramq = q.cCt();
              localObject1 = new eaw();
              ((eaw)localObject1).RPz = paramd.RPz;
              paramq.encode("_msg_scene_strip", ((eaw)localObject1).toByteArray());
            }
          }
        }
      }
      for (;;)
      {
        paramString.putLong("start", this.sNs);
        long l = System.currentTimeMillis();
        paramString.putLong("end", l);
        paramd = m.sNg;
        Log.v(m.cCo(), "terry performance runCGI #" + paramb + ": " + this.sNs + ',' + l);
        this.jFa.invoke(paramString);
        paramString.putBoolean("mount", true);
        paramd = this.sNu;
        if (paramd == null) {
          break label466;
        }
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramq = (String)paramd.next();
          p.j(paramq, "url");
          paramq = c.apN(paramq);
          localObject1 = m.sNg;
          localObject1 = (ConcurrentLinkedDeque)m.cCm().get(paramq);
          Object localObject2 = m.sNg;
          m.cCm().remove(paramq);
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (kotlin.g.a.b)((Iterator)localObject1).next();
              paramString.putString("id", paramq);
              ((kotlin.g.a.b)localObject2).invoke(paramString);
            }
          }
        }
        paramInt1 = 0;
        break;
        paramString.putBoolean("success", false);
      }
      label466:
      AppMethodBeat.o(6680);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final s sNv;
    
    static
    {
      AppMethodBeat.i(6684);
      sNv = new s();
      AppMethodBeat.o(6684);
    }
    
    s()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "intent", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class t<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<Intent, IPCVoid>
  {
    public static final t sNw;
    
    static
    {
      AppMethodBeat.i(257837);
      sNw = new t();
      AppMethodBeat.o(257837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.m
 * JD-Core Version:    0.7.0.1
 */