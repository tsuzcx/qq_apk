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
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.vfs.o;
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
import kotlin.g.b.ad;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "kotlin.jvm.PlatformType", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "isNative", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"})
public final class m
{
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final String dkO;
  private static final AtomicBoolean dxh;
  private static final AtomicBoolean pCM;
  private static final MMKVSlotManager pCN;
  private static final MMFileSlotManager pCO;
  private static final m.l pCP;
  private static final HashMap<Integer, Boolean> pCQ;
  private static final a pCR;
  private static final kotlin.f pCS;
  private static final boolean pCT = false;
  public static final m pCU;
  
  static
  {
    AppMethodBeat.i(6685);
    pCU = new m();
    TAG = "MicroMsg.PreloadLogic";
    dxh = new AtomicBoolean(false);
    pCM = new AtomicBoolean(false);
    dkO = ToolsMpProcessIPCService.dkO;
    pCN = new MMKVSlotManager(u.coo(), 0L, 2, null);
    pCO = new MMFileSlotManager("webcached", 0L, 2, null);
    pCP = new m.l();
    pCQ = new HashMap();
    pCR = new a();
    pCS = kotlin.g.ah((kotlin.g.a.a)m.g.pCX);
    AppMethodBeat.o(6685);
  }
  
  public static final boolean CR(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6699);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class) != null)
    {
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class);
      kotlin.g.b.p.g(localObject, "MMKernel.service(IBizTeenModeService::class.java)");
      if (!((com.tencent.mm.api.q)localObject).Vu())
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
    if (pCQ.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = pCQ.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = j.pCC;
    if ((!j.a.coc()) && ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)))
    {
      localObject = (Map)pCQ;
      j.a locala = j.pCC;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(k.cdi().getBoolean("preload_use", true)));
      localObject = pCQ.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)pCQ;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)pCQ).put(Integer.valueOf(paramInt), Boolean.FALSE);
        Log.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (pCQ.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = pCQ.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSd, 0) == 0)
        {
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSe, 0) == 0)
          {
            bool = false;
            continue;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSf, 0) & 0x1) == 0) {
              break label896;
            }
            bool = true;
            break;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSf, 0) & 0x2) == 0)
            {
              bool = false;
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSf, 0) & 0x4) == 0)
              {
                bool = false;
                continue;
                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSg, 0) & 0x1) == 0)
                {
                  bool = false;
                  continue;
                  if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSg, 0) & 0x2) == 0)
                  {
                    bool = false;
                    continue;
                    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSg, 0) & 0x4) == 0)
                    {
                      bool = false;
                      continue;
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSj, 0) == 0)
                      {
                        bool = false;
                        continue;
                        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSk, 0) & 0x1) == 0)
                        {
                          bool = false;
                          continue;
                          if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSk, 0) & 0x2) == 0)
                          {
                            bool = false;
                            continue;
                            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSk, 0) & 0x4) == 0)
                            {
                              bool = false;
                              continue;
                              if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSc, 0) == 0)
                              {
                                bool = false;
                                continue;
                                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSl, 0) & 0x1) == 0)
                                {
                                  bool = false;
                                  continue;
                                  i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSm, 0);
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
  
  private static void Do(int paramInt)
  {
    AppMethodBeat.i(6687);
    Log.i(TAG, "start in preCreate");
    aE(paramInt, f.getNetWorkType());
    Dq(-1);
    coh();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void Dp(int paramInt)
  {
    AppMethodBeat.i(6689);
    Dq(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void Dq(int paramInt)
  {
    AppMethodBeat.i(6690);
    Object localObject = j.pCC;
    if (!j.a.cnU())
    {
      AppMethodBeat.o(6690);
      return;
    }
    localObject = dkO;
    kotlin.g.b.p.g(localObject, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)new IPCInteger(paramInt), (com.tencent.mm.ipcinvoker.b)m.m.pDe, null);
    AppMethodBeat.o(6690);
  }
  
  private static int Dr(int paramInt)
  {
    AppMethodBeat.i(195633);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
    if ((localb != null) && (localb.CQ(paramInt)))
    {
      if (CR(102))
      {
        AppMethodBeat.o(195633);
        return 5;
      }
      AppMethodBeat.o(195633);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(195633);
      return -1;
    case 0: 
      if (CR(102))
      {
        AppMethodBeat.o(195633);
        return 5;
      }
      AppMethodBeat.o(195633);
      return 0;
    }
    if (CR(102))
    {
      AppMethodBeat.o(195633);
      return 5;
    }
    AppMethodBeat.o(195633);
    return 4;
  }
  
  private static int Dt(int paramInt)
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
  
  private static int Du(int paramInt)
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
  
  private static d.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    ke localke = new ke();
    localke.pLm = f.getNetWorkType();
    localke.KOx = u.con();
    localke.KOw = new LinkedList();
    localke.KOy = paramInt2;
    localke.KOz = paramInt3;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).pCV;
      localObject3 = new don();
      ((don)localObject3).Url = ((String)localObject2);
      ((don)localObject3).KIS = 0;
      ((don)localObject3).Scene = paramInt1;
      localObject2 = pCR.ail((String)localObject2);
      if (localObject2 != null)
      {
        ((don)localObject3).KIS = ((fn)localObject2).KIS;
        if (!a((fn)localObject2, paramInt2)) {
          ((don)localObject3).KIS = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localke.KOw.addAll((Collection)localObject1);
    Log.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localke.KOw.size()) });
    Log.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new d.a();
    paramIterable.sG(2594);
    paramIterable.MB("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.sI(0);
    paramIterable.sJ(0);
    paramIterable.c((com.tencent.mm.bw.a)localke);
    paramIterable.d((com.tencent.mm.bw.a)new kf());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.h.a.kh(paramInt1, localke.KOw.size());
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
    if (paramBoolean) {}
    for (Object localObject = UrlExKt.appendUrlParam(paramString, "isNativePage", "2");; localObject = paramString)
    {
      paramIntent = (Intent)localObject;
      if (!kotlin.n.n.a((CharSequence)paramString, (CharSequence)"clicktime", false)) {
        paramIntent = UrlExKt.appendUrlParam((String)localObject, "clicktime", String.valueOf(i));
      }
      localObject = paramIntent;
      if (!kotlin.n.n.a((CharSequence)paramString, (CharSequence)"enterid", false)) {
        localObject = UrlExKt.appendUrlParam(paramIntent, "enterid", String.valueOf(i));
      }
      AppMethodBeat.o(6696);
      return localObject;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, final dei paramdei, boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(195635);
    paramString1 = new s(paramBoolean, paramString1, paramdei);
    paramString2 = new t(paramBoolean, paramString2, paramdei);
    if (paramdei.iwc == 5) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.br.c.b(paramContext, paramString1.bAa(), paramString2.bAa(), paramIntent);
    AppMethodBeat.o(195635);
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
      kotlin.g.b.p.g(localObject1, "urls[0]");
      localObject1 = c.aib((String)localObject1);
      if (cog().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)cog().get(localObject1);
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
            kotlin.g.b.p.g(localObject2, "urls[i]");
            localObject2 = (String)localObject2;
            if (localObject1 == null) {
              kotlin.g.b.p.hyc();
            }
            Object localObject3 = ((ArrayList)localObject1).get(i);
            kotlin.g.b.p.g(localObject3, "tmplTypes!![i]");
            paramBundle.add(new d((String)localObject2, ((Number)localObject3).intValue()));
            localObject2 = localArrayList.get(i);
            kotlin.g.b.p.g(localObject2, "urls[i]");
            localObject2 = c.aib((String)localObject2);
            ((Map)cog()).put(localObject2, new ConcurrentLinkedDeque());
            Log.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
          }
          i += 1;
          break;
        }
      }
    }
    aa.a(a((Iterable)paramBundle, k, m, n).aXF(), (aa.a)new r(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(6706);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    kotlin.g.b.p.h(???, "url");
    kotlin.g.b.p.h(paramVarArgs, "params");
    if (pCT)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new ad(3);
    ((ad)localObject1).add(???);
    ((ad)localObject1).add(Integer.valueOf(paramInt1));
    ((ad)localObject1).eS(paramVarArgs);
    paramVarArgs = kotlin.a.j.ac(((ad)localObject1).toArray(new Object[((ad)localObject1).dtS.size()]));
    localObject1 = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject2 = (bu)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject1);
      if (localObject2 != null) {
        ((bu)localObject2).a(null);
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
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject1, kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (kotlin.g.a.m)new e(1000L, (String)localObject1, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private final void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, kotlin.g.a.m<? super m.c, ? super kf, x> paramm)
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
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).pCV));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.g.aAe().azG();
    kotlin.g.b.p.g(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).aBb())
    {
      a(localBundle, (kotlin.g.a.b)new o(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, b.class, (com.tencent.mm.ipcinvoker.d)new p(paramm));
    AppMethodBeat.o(6704);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, dei paramdei, boolean paramBoolean1, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(195634);
    eic localeic = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DE(paramdei.pCV);
    if ((localeic == null) && ((paramdei.iwc == 0) || (paramdei.iwc == -1)))
    {
      Log.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramdei + ".tmplType");
      AppMethodBeat.o(195634);
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
      label227:
      Object localObject;
      if (localeic == null)
      {
        parama = paramdei.url;
        kotlin.g.b.p.g(parama, "session.url");
        paramIntent.putExtra("rawUrl", UrlExKt.appendStats(a(parama, paramBoolean1, paramIntent), paramdei));
        kotlin.g.b.p.g(paramIntent.putExtra(e.p.OzD, true), "intent.putExtra(Constant…wUI.KTmplForeceUrl, true)");
        parama = e.p.Ozr;
        localObject = j.pCC;
        paramIntent.putExtra(parama, j.a.cnU());
        paramIntent.putExtra(e.p.Ozs, System.currentTimeMillis());
        paramIntent.putExtra(e.p.Ozu, paramdei.url);
        localObject = e.p.Ozq;
        if (localeic == null) {
          break label923;
        }
        parama = localeic.toByteArray();
        paramIntent.putExtra((String)localObject, parama);
        paramIntent.putExtra(e.p.OzC, paramdei.toByteArray());
        paramIntent.putExtra(e.p.Ozz, Process.myPid());
      }
      try
      {
        paramIntent.putExtra(e.p.Ozy, f.c(paramContext, (kotlin.g.a.b)u.pDn));
        if (paramBoolean2)
        {
          paramBoolean2 = paramdei.MJs;
          if (!paramBoolean2) {}
        }
        for (;;)
        {
          try
          {
            kotlin.g.b.p.h(paramIntent, "intent");
            parama = dkO;
            kotlin.g.b.p.g(parama, "PROCESS_NAME");
            com.tencent.mm.ipcinvoker.a.a(parama, (Parcelable)paramIntent, (com.tencent.mm.ipcinvoker.b)m.v.pDo, null);
            a(paramContext, paramIntent, paramdei, paramBoolean1, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
            if (localeic != null)
            {
              com.tencent.mm.plugin.webview.h.a.gH(localeic.reportId, 106);
              com.tencent.mm.plugin.webview.h.a.agi(100);
              if (paramdei.MJt)
              {
                com.tencent.mm.plugin.webview.h.a.gH(localeic.reportId, 231);
                com.tencent.mm.plugin.webview.h.a.agi(110);
              }
            }
            AppMethodBeat.o(195634);
            return true;
            i = 0;
            break;
            paramdei.hFF = localeic.hFF;
            com.tencent.mm.plugin.webview.h.a.gH(localeic.reportId, 104);
            localObject = paramdei.url;
            kotlin.g.b.p.g(localObject, "session.url");
            localObject = cI((String)localObject, paramdei.pCV);
            if (localObject != null)
            {
              String str = ((fn)localObject).KIR;
              if (str != null)
              {
                if (!kotlin.n.n.aL((CharSequence)str))
                {
                  i = 1;
                  if (i != 1) {
                    continue;
                  }
                  if (!((fn)localObject).KIY) {
                    break label970;
                  }
                  paramBoolean1 = false;
                  if ((((fn)localObject).KIY) || (paramdei.iwc == 0))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra(e.p.Ozw, paramdei.pmM);
                    localObject = ((fn)localObject).KIR;
                    kotlin.g.b.p.g(localObject, "appMsgContext.ForceUrl");
                    localObject = a(UrlExKt.appendStats((String)localObject, paramdei), paramBoolean1, paramIntent);
                    Log.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
                    paramIntent.putExtra("rawUrl", (String)localObject);
                    if (paramBoolean2) {
                      a(paramContext, paramIntent, paramdei, paramBoolean1, "webview", ".ui.tools.WebViewUI");
                    }
                    com.tencent.mm.plugin.webview.h.a.gH(localeic.reportId, 107);
                    parama.success = true;
                    parama.message = "has forceUrl=".concat(String.valueOf(localObject));
                    AppMethodBeat.o(195634);
                    return true;
                  }
                }
                else
                {
                  i = 0;
                  continue;
                }
                paramIntent.putExtra(e.p.OzD, true);
                continue;
              }
            }
            parama = paramdei.url;
            kotlin.g.b.p.g(parama, "session.url");
            paramdei.url = a(parama, paramBoolean1, paramIntent);
            paramIntent.putExtra("rawUrl", paramdei.url);
            paramdei.MJr = true;
            parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DC(localeic.pCV);
            paramdei.MJt = u.d(parama);
            boolean bool2 = kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
            if ((u.d(parama)) && (bool2))
            {
              bool1 = true;
              paramdei.MJu = bool1;
              if ((!u.d(parama)) || (bool2)) {
                continue;
              }
              bool1 = true;
              paramdei.MJv = bool1;
              if ((localObject == null) || (!n.b((fn)localObject))) {
                continue;
              }
              paramdei.MJs = true;
              Log.i(TAG, "set contentId:%s", new Object[] { c.a((fn)localObject) });
              break label227;
            }
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            parama = paramdei.url;
            kotlin.g.b.p.g(parama, "session.url");
            a(paramContext, parama, paramdei, (kotlin.g.a.q)m.j.pDa);
            break label227;
            label923:
            parama = null;
          }
          catch (Throwable parama)
          {
            Log.i(TAG, "updateWebview ex " + parama.getMessage());
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(195634);
        return false;
      }
    }
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(195631);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "rawUrl");
    kotlin.g.b.p.h(paramIntent, "intent");
    kotlin.g.b.p.h(parama, "result");
    if (kotlin.n.n.aL((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(195631);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(195631);
      return false;
    }
    if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext))
    {
      Log.i(TAG, "Block mp rawUrl %s", new Object[] { paramString });
      parama.success = false;
      parama.message = "mp url currently blocked";
      AppMethodBeat.o(195631);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = pCR.ail(paramString);
      if (localObject != null) {
        i = ((fn)localObject).iAb;
      }
    }
    for (;;)
    {
      if ((i == 5) && (!z.gsK())) {}
      int k;
      for (boolean bool1 = true;; bool1 = false)
      {
        k = Dr(i);
        if (k != -1) {
          break label242;
        }
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(i));
        AppMethodBeat.o(195631);
        return false;
        i = paramInt1;
        break;
      }
      label242:
      int m = ab.getSessionId();
      localObject = UrlExKt.getUrlParam(paramString, "scene");
      int j = paramInt2;
      CharSequence localCharSequence;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        j = paramInt2;
        if (new kotlin.n.k("\\d+").aJ(localCharSequence)) {
          j = Integer.parseInt((String)localObject);
        }
      }
      localObject = UrlExKt.getUrlParam(paramString, "subscene");
      paramInt2 = paramInt3;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        paramInt2 = paramInt3;
        if (new kotlin.n.k("\\d+").aJ(localCharSequence)) {
          paramInt2 = Integer.parseInt((String)localObject);
        }
      }
      paramIntent.putExtra(e.p.OzA, i);
      paramIntent.putExtra(e.p.Ozv, m);
      paramIntent.putExtra(e.p.Ozw, j);
      paramIntent.putExtra(e.p.Ozx, paramInt2);
      paramIntent.putExtra(e.p.OzB, paramInt4);
      paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
      localObject = new dei();
      ((dei)localObject).id = m;
      ((dei)localObject).url = paramString;
      ((dei)localObject).iwc = i;
      ((dei)localObject).pCV = k;
      ((dei)localObject).pmM = j;
      ((dei)localObject).pHw = paramInt2;
      ((dei)localObject).MJq = paramInt3;
      boolean bool2;
      if (i != paramInt1)
      {
        bool2 = true;
        ((dei)localObject).pCb = bool2;
        paramBoolean = pCU.a(paramContext, paramIntent, (dei)localObject, bool1, parama, paramBoolean);
        if (paramBoolean)
        {
          if ((paramInt4 != -1) && ((paramContext instanceof MMActivity)) && (paramInt4 == 1)) {
            ((MMActivity)paramContext).overridePendingTransition(2130772132, 2130772131);
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
        com.tencent.mm.plugin.webview.h.a.agh(paramInt1);
        AppMethodBeat.o(195631);
        return paramBoolean;
        bool2 = false;
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
  
  private static boolean a(fn paramfn, int paramInt)
  {
    AppMethodBeat.i(6702);
    eib localeib = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DC(paramInt);
    Object localObject = (CharSequence)paramfn.KIR;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (u.a(localeib))
    {
      paramfn = paramfn.KIZ;
      if (paramfn != null)
      {
        paramfn = ((Iterable)paramfn).iterator();
        while (paramfn.hasNext())
        {
          localObject = (eib)paramfn.next();
          Log.v(TAG, "checkDataVerVaild: " + ((eib)localObject).oUv + ' ' + localeib.oUv + ' ' + ((eib)localObject).Nhq + ' ' + localeib.Nhq);
          if ((((eib)localObject).oUv == localeib.oUv) && (kotlin.g.b.p.j(((eib)localObject).Nhq, localeib.Nhq)))
          {
            Log.v(TAG, "checkDataVerVaild: " + ((eib)localObject).Version + " tmplInfo:" + localeib.Version);
            if (((eib)localObject).Version >= localeib.Version)
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
  
  private static void aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    kotlin.g.b.p.h(paramString, "netType");
    String str = MainProcessIPCService.dkO;
    kotlin.g.b.p.g(str, "MainProcessIPCService.PROCESS_NAME");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)i.pCZ, null);
    AppMethodBeat.o(6691);
  }
  
  public static void aii(String paramString)
  {
    AppMethodBeat.i(6710);
    kotlin.g.b.p.h(paramString, "url");
    Log.d(TAG, "removePreload %s", new Object[] { paramString });
    kotlin.g.b.p.h(paramString, "url");
    String str = c.ahX(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)pCN.findSlot(str);
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.removeValueForKey(str);
      localMultiProcessMMKV.removeValueForKey(c.aib(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void aij(String paramString)
  {
    AppMethodBeat.i(6715);
    kotlin.g.b.p.h(paramString, "url");
    String str = MainProcessIPCService.dkO;
    kotlin.g.b.p.g(str, "MainProcessIPCService.PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)m.n.pDf, null);
    AppMethodBeat.o(6715);
  }
  
  public static long aik(String paramString)
  {
    AppMethodBeat.i(6716);
    kotlin.g.b.p.h(paramString, "url");
    paramString = c.aic(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)pCN.findSlot(paramString);
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
    j.a locala = j.pCC;
    if (!j.a.cnV())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (kotlin.g.a.m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  private static fn cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (kotlin.n.n.aL((CharSequence)paramString))
    {
      Log.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (pCR.cJ(paramString, paramInt))
    {
      paramString = pCR.ail(paramString);
      AppMethodBeat.o(6700);
      return paramString;
    }
    AppMethodBeat.o(6700);
    return null;
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    a.col();
    Log.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coR();
    AppMethodBeat.o(6688);
  }
  
  public static MMKVSlotManager cod()
  {
    return pCN;
  }
  
  public static MMFileSlotManager coe()
  {
    return pCO;
  }
  
  public static a cof()
  {
    return pCR;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, x>>> cog()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)pCS.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  private static void coh()
  {
    AppMethodBeat.i(6714);
    String str = MainProcessIPCService.dkO;
    kotlin.g.b.p.g(str, "MainProcessIPCService.PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, null, (com.tencent.mm.ipcinvoker.b)m.h.pCY, null);
    AppMethodBeat.o(6714);
  }
  
  public static final void j(List<? extends List<String>> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6713);
    kotlin.g.b.p.h(paramList, "items");
    if (pCT)
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
      k = Dt(paramInt);
      if (k == 0) {
        break label356;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label356;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
      localObject4 = ((List)localObject1).get(2);
      str = com.tencent.mm.compatible.util.q.encode((String)((List)localObject1).get(0));
      localObject5 = a((List)localObject1, 3, "");
      localObject6 = a((List)localObject1, 4, "");
      localObject7 = ((List)localObject1).get(1);
      localObject8 = a((List)localObject1, 5, "");
      localObject9 = a((List)localObject1, 6, "");
      localObject10 = a((List)localObject1, 7, "");
      if (!kotlin.g.b.p.j((String)((List)localObject1).get(1), "-1")) {
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
    if (CR(Du(paramInt)))
    {
      k = c.Dm(paramInt);
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
        paramList.add(new d((String)((List)localObject2).get(0), Dr(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).pCV;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (pCR.cJ((String)localObject4, i))) {}
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
      localObject2 = kotlin.a.j.b((Iterable)paramList, k);
      i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        pCU.b((List)localObject2, paramInt, m, 1);
        if (Log.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls toStrip:").append(k).append(" strip:").append(m).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(c.aib(((d)((Iterator)localObject3).next()).url));
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
    kotlin.g.b.p.h(paramList, "items");
    if (pCT)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!CR(Du(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = c.Dm(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(Long.parseLong(paramList[0]), paramList[1]).iAd;
      if (i > 0) {
        kotlin.g.b.p.g(paramList, "it");
      }
      for (paramList = kotlin.a.j.b((Iterable)paramList, i);; paramList = (List)paramList)
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
      ((Collection)localObject2).add(new d(paramList, Dr(((v)localObject4).type)));
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
      i = ((d)localObject3).pCV;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (pCR.cJ((String)localObject4, i))) {}
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
    localObject2 = kotlin.a.j.b((Iterable)paramList, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      pCU.b((List)localObject2, paramInt, k, 1);
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
            ((Collection)localObject2).add(c.aib(((d)((Iterator)localObject3).next()).url));
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
    if (pCM.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    pCM.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.cr.d.hiy();
      Do(paramInt);
      pCM.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new q(paramInt));
    AppMethodBeat.o(6686);
  }
  
  public final void a(final Object paramObject, String paramString, dei paramdei, final kotlin.g.a.q<? super WeakReference<Object>, ? super m.c, ? super fn, x> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(195636);
    kotlin.g.b.p.h(paramObject, "context");
    kotlin.g.b.p.h(paramString, "url");
    kotlin.g.b.p.h(paramdei, "session");
    kotlin.g.b.p.h(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new m.c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = j.pCC;
    if (j.a.cnW())
    {
      ((m.c)localObject1).isSuccess = true;
      paramq.d(paramObject, localObject1, new fn());
      AppMethodBeat.o(195636);
      return;
    }
    if ((kotlin.n.n.aL((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.d(paramObject, localObject1, new fn());
      AppMethodBeat.o(195636);
      return;
    }
    localObject2 = cI(paramString, paramdei.pCV);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getAppMsgContext ");
    if (localObject2 == null) {
      bool = true;
    }
    Log.d(str, bool);
    if (localObject2 != null)
    {
      ((m.c)localObject1).isSuccess = true;
      ((m.c)localObject1).bGq = true;
      paramq.d(paramObject, localObject1, localObject2);
      AppMethodBeat.o(195636);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramdei);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramdei.pCV));
    a(this, (List)localObject1, paramdei.pCV, (kotlin.g.a.m)new k(paramString, paramq, paramObject));
    AppMethodBeat.o(195636);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "save", "plugin-brandservice_release"})
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    private final boolean c(fn paramfn, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (paramfn == null)
      {
        Log.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = m.pCU;
      if (!m.b(paramfn, paramInt))
      {
        Log.v(this.TAG, "checkValid: invalid version:data(" + paramfn.KIU + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = j.pCC;
      if (j.a.cnX()) {
        Log.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = paramfn.Url;
        kotlin.g.b.p.g(localObject1, "appMsgContext.Url");
        localObject1 = c.aic((String)localObject1);
        Object localObject2 = m.pCU;
        localObject2 = (MultiProcessMMKV)m.cod().findSlot((String)localObject1);
        if (localObject2 != null) {}
        for (boolean bool = f.a((MultiProcessMMKV)localObject2, (String)localObject1, paramfn.KIQ * 1000L); bool; bool = true)
        {
          Log.i(this.TAG, "checkValid: expire for " + paramfn.KIQ);
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public static boolean col()
    {
      AppMethodBeat.i(6642);
      m localm = m.pCU;
      m.cod().verifyAllSlot();
      AppMethodBeat.o(6642);
      return true;
    }
    
    public final void a(String paramString, fn paramfn)
    {
      AppMethodBeat.i(6641);
      kotlin.g.b.p.h(paramString, "url");
      if (paramfn != null)
      {
        localObject1 = (CharSequence)paramfn.iAc;
        if ((localObject1 != null) && (!kotlin.n.n.aL((CharSequence)localObject1))) {
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
      Object localObject1 = c.ahX(paramString);
      Object localObject2 = paramfn.iAc;
      try
      {
        Object localObject3 = new fn();
        ((fn)localObject3).parseFrom(paramfn.toByteArray());
        ((fn)localObject3).iAc = null;
        Object localObject4 = ((fn)localObject3).toByteArray();
        localObject3 = m.pCU;
        localObject3 = (MultiProcessMMKV)m.cod().getSlot();
        ((MultiProcessMMKV)localObject3).encode((String)localObject1, (byte[])localObject4);
        localObject4 = m.pCU;
        localObject4 = c.H(c.a(m.coe(), c.aib(paramString)));
        kotlin.g.b.p.g(localObject2, "content");
        Charset localCharset = kotlin.n.d.UTF_8;
        kotlin.g.b.p.h(localObject4, "$this$writeText");
        kotlin.g.b.p.h(localObject2, "text");
        kotlin.g.b.p.h(localCharset, "charset");
        localObject2 = ((String)localObject2).getBytes(localCharset);
        kotlin.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.p.b((o)localObject4, (byte[])localObject2);
        f.b((MultiProcessMMKV)localObject3, c.aic(paramString));
        Log.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + paramfn.KIS);
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
    
    public final fn ail(String paramString)
    {
      AppMethodBeat.i(6639);
      kotlin.g.b.p.h(paramString, "url");
      String str = c.ahX(paramString);
      Object localObject1 = m.pCU;
      localObject1 = (MultiProcessMMKV)m.cod().findSlot(str);
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
          Object localObject3 = fn.class.newInstance();
          ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject3;
          localObject1 = (fn)localObject1;
          if (localObject1 == null) {
            break label195;
          }
          ((fn)localObject1).Url = paramString;
          Log.i(this.TAG, "found:" + str + " last modify:" + ((fn)localObject1).KIS);
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
    
    public final boolean cJ(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      kotlin.g.b.p.h(paramString, "url");
      fn localfn = ail(paramString);
      if (localfn == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      Object localObject = m.pCU;
      int i;
      if (localfn != null)
      {
        localObject = Integer.valueOf(localfn.iAb);
        i = m.Ds(((Integer)localObject).intValue());
        if (i != -1) {
          break label122;
        }
      }
      for (;;)
      {
        boolean bool = c(localfn, paramInt);
        if (!bool) {
          Log.d(this.TAG, "init invalid:" + c.ahX(paramString));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Bundle, x>
    {
      a(com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"})
  static final class d
  {
    final int pCV;
    final String url;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.pCV = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class e
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    public e(long paramLong, String paramString, kotlin.d.d paramd, int paramInt)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      kotlin.g.b.p.h(paramd, "completion");
      paramd = new e(this.$delay, this.$key, paramd, this.pmv);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(6658);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6659);
      paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(6659);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6657);
      Object localObject1 = kotlin.d.a.a.SXO;
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
        if (au.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6657);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!aj.a(paramObject))
      {
        paramObject = x.SXb;
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
              localObject1 = m.pCU;
              localObject1 = m.coi();
              ??? = new StringBuilder("preloadData addToPreload batch:");
              localObject4 = (Iterable)paramObject;
              localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(c.aib(((ArrayList)((Iterator)localObject4).next()).get(0).toString()));
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
      localObject1 = x.SXb;
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
        if (paramObject.add(c.aib((String)localObject4))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = m.pCU;
        int j = m.Dv(this.pmv);
        if (j != 0)
        {
          ??? = ((Iterable)localObject1).iterator();
          if (((Iterator)???).hasNext())
          {
            paramObject = (ArrayList)((Iterator)???).next();
            localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
            localObject4 = m.pCU;
            localObject4 = m.b((List)paramObject, 2, "");
            Object localObject5 = paramObject.get(0);
            if (localObject5 == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject5 = com.tencent.mm.compatible.util.q.encode((String)localObject5);
            Object localObject6 = m.pCU;
            localObject6 = m.b((List)paramObject, 3, "");
            Object localObject7 = m.pCU;
            localObject7 = m.b((List)paramObject, 4, "");
            Object localObject8 = paramObject.get(1);
            Object localObject9 = m.pCU;
            localObject9 = m.b((List)paramObject, 5, "");
            Object localObject10 = m.pCU;
            localObject10 = m.b((List)paramObject, 6, "");
            Object localObject11 = m.pCU;
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
        paramObject = m.pCU;
        if (m.CR(m.Dw(this.pmv)))
        {
          j = c.Dm(this.pmv);
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
            localObject4 = m.pCU;
            ??? = ((ArrayList)???).get(1);
            if (??? == null)
            {
              paramObject = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            paramObject.add(new m.d((String)localObject3, m.Ds(((Integer)???).intValue())));
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
            i = ((m.d)localObject4).pCV;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = m.pCU;
              if (!m.cof().cJ((String)localObject3, i)) {
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
          localObject1 = x.SXb;
          ??? = kotlin.a.j.b((Iterable)paramObject, j);
          if (!((Collection)???).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            m.a(m.pCU, (List)???, this.pmv, k);
            if (Log.getLogLevel() == 0)
            {
              paramObject = m.pCU;
              paramObject = m.coi();
              localObject1 = new StringBuilder("preloadData addToPreload toStrip:").append(j).append(" strip:").append(k).append("  dispatch:");
              localObject3 = (Iterable)???;
              ??? = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)???).add(c.aib(((m.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              Log.v(paramObject, (List)???);
            }
          }
          paramObject = x.SXb;
        }
      }
      paramObject = x.SXb;
      label1662:
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = x.SXb;
      AppMethodBeat.o(6657);
      return paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.m<m.c, kf, x>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class i<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {
    public static final i pCZ;
    
    static
    {
      AppMethodBeat.i(195624);
      pCZ = new i();
      AppMethodBeat.o(195624);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<m.c, kf, x>
  {
    k(String paramString, kotlin.g.a.q paramq, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Bundle, x>
  {
    o(kotlin.g.a.m paramm)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class p<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    p(kotlin.g.a.m paramm) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class q
    implements MessageQueue.IdleHandler
  {
    q(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.cr.d.hiy();
      m.a(m.pCU, this.pmo);
      m localm = m.pCU;
      m.coj().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class r
    implements aa.a
  {
    r(long paramLong1, long paramLong2, kotlin.g.a.b paramb, ArrayList paramArrayList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(6680);
      paramq = m.pCU;
      Log.i(m.coi(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = new Bundle();
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        kotlin.g.b.p.g(paramd, "rr");
        if ((paramd.aYK() != null) && ((paramd.aYK() instanceof kf)))
        {
          paramd = paramd.aYK();
          if (paramd == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
            AppMethodBeat.o(6680);
            throw paramString;
          }
          paramd = (kf)paramd;
          paramString.putBoolean("success", true);
          paramString.putByteArray("response", paramd.toByteArray());
          paramq = paramd.KOB;
          kotlin.g.b.p.g(paramq, "response.SceneControlList");
          if (!((Collection)paramq).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramq = u.coo();
              localObject1 = new dra();
              ((dra)localObject1).KOB = paramd.KOB;
              paramq.encode("_msg_scene_strip", ((dra)localObject1).toByteArray());
            }
          }
        }
      }
      for (;;)
      {
        paramString.putLong("start", this.pDg);
        long l = System.currentTimeMillis();
        paramString.putLong("end", l);
        paramd = m.pCU;
        Log.v(m.coi(), "terry performance runCGI #" + paramb + ": " + this.pDg + ',' + l);
        this.gWe.invoke(paramString);
        paramString.putBoolean("mount", true);
        paramd = this.pDi;
        if (paramd == null) {
          break label466;
        }
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramq = (String)paramd.next();
          kotlin.g.b.p.g(paramq, "url");
          paramq = c.aib(paramq);
          localObject1 = m.pCU;
          localObject1 = (ConcurrentLinkedDeque)m.cog().get(paramq);
          Object localObject2 = m.pCU;
          m.cog().remove(paramq);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"getNativeService", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    s(boolean paramBoolean, String paramString, dei paramdei)
    {
      super();
    }
    
    public final String bAa()
    {
      if (this.pDj) {}
      switch (paramdei.iwc)
      {
      default: 
        return paramString1;
      }
      return "brandservice";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"getNativeActivity", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    t(boolean paramBoolean, String paramString, dei paramdei)
    {
      super();
    }
    
    public final String bAa()
    {
      if ((this.pDj) && (paramdei.iwc == 5)) {
        return ".ui.timeline.video.BizVideoDetailUI";
      }
      return paramString2;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final u pDn;
    
    static
    {
      AppMethodBeat.i(6684);
      pDn = new u();
      AppMethodBeat.o(6684);
    }
    
    u()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.m
 * JD-Core Version:    0.7.0.1
 */