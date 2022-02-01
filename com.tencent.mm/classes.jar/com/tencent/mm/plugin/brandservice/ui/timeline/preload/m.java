package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.brandservice.SubCoreBrandService;
import com.tencent.mm.plugin.brandservice.d.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c.2;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.erl;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.fnm;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.al;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "kotlin.jvm.PlatformType", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removeAllPreload", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "isNative", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final String PROCESS_NAME;
  private static final String TAG;
  private static final AtomicBoolean huc;
  public static final m vSK;
  private static final AtomicBoolean vSL;
  private static final MMKVSlotManager vSM;
  private static final MMFileSlotManager vSN;
  private static final j vSO;
  private static final HashMap<Integer, Boolean> vSP;
  private static final a vSQ;
  private static final kotlin.j vSR;
  private static final boolean vSS = false;
  
  static
  {
    AppMethodBeat.i(6685);
    vSK = new m();
    TAG = "MicroMsg.PreloadLogic";
    huc = new AtomicBoolean(false);
    vSL = new AtomicBoolean(false);
    PROCESS_NAME = ToolsMpProcessIPCService.PROCESS_NAME;
    vSM = new MMKVSlotManager(q.dfF(), 0L, 2, null);
    vSN = new MMFileSlotManager("webcached", 0L, 2, null);
    vSO = new j();
    vSP = new HashMap();
    vSQ = new a();
    vSR = kotlin.k.cm((kotlin.g.a.a)g.vSW);
    AppMethodBeat.o(6685);
  }
  
  public static final boolean GV(int paramInt)
  {
    AppMethodBeat.i(6699);
    if (paramInt == 102)
    {
      AppMethodBeat.o(6699);
      return false;
    }
    boolean bool;
    if (vSP.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = vSP.get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "isPreloadOpen[openScene]!!");
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = j.vSB;
    if ((!j.a.dfu()) && ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)))
    {
      localObject = (Map)vSP;
      j.a locala = j.vSB;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(k.cTb().getBoolean("preload_use", true)));
      localObject = vSP.get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "isPreloadOpen[openScene]!!");
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)vSP;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)vSP).put(Integer.valueOf(paramInt), Boolean.FALSE);
        Log.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (vSP.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = vSP.get(Integer.valueOf(paramInt));
        s.checkNotNull(localObject);
        s.s(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMj, 1) != 0)
        {
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMk, 1) == 0) {
            break label869;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMl, 7) & 0x1) == 0) {
            break label874;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMl, 7) & 0x2) == 0) {
            break label879;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMl, 7) & 0x4) == 0) {
            break label884;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMm, 7) & 0x1) == 0) {
            break label889;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMm, 7) & 0x2) == 0) {
            break label894;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMm, 7) & 0x4) == 0) {
            break label899;
          }
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMp, 1) == 0) {
            break label904;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMq, 7) & 0x1) == 0) {
            break label909;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMq, 7) & 0x2) == 0) {
            break label914;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMq, 7) & 0x4) == 0) {
            break label919;
          }
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMi, 1) == 0) {
            break label924;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMr, 1) & 0x1) == 0) {
            break label929;
          }
          bool = true;
          continue;
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMs, 1);
          if ((i & 0x1) != 0)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
          bool = false;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      bool = false;
      continue;
      label869:
      bool = false;
      continue;
      label874:
      bool = false;
      continue;
      label879:
      bool = false;
      continue;
      label884:
      bool = false;
      continue;
      label889:
      bool = false;
      continue;
      label894:
      bool = false;
      continue;
      label899:
      bool = false;
      continue;
      label904:
      bool = false;
      continue;
      label909:
      bool = false;
      continue;
      label914:
      bool = false;
      continue;
      label919:
      bool = false;
      continue;
      label924:
      bool = false;
      continue;
      label929:
      bool = false;
    }
  }
  
  private static int HA(int paramInt)
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
  
  private static int HB(int paramInt)
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
  
  private static void Hw(int paramInt)
  {
    AppMethodBeat.i(6687);
    Log.i(TAG, "start in preCreate");
    aT(paramInt, f.getNetWorkType());
    Hy(-1);
    dfA();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void Hx(int paramInt)
  {
    AppMethodBeat.i(6689);
    Hy(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void Hy(int paramInt)
  {
    AppMethodBeat.i(6690);
    Object localObject = j.vSB;
    if (!j.a.dfl())
    {
      AppMethodBeat.o(6690);
      return;
    }
    localObject = PROCESS_NAME;
    s.s(localObject, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)new IPCInteger(paramInt), m..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(6690);
  }
  
  private static int Hz(int paramInt)
  {
    AppMethodBeat.i(303304);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(303304);
      return -1;
    case 0: 
      if (GV(102))
      {
        AppMethodBeat.o(303304);
        return 5;
      }
      AppMethodBeat.o(303304);
      return 0;
    }
    if (GV(102))
    {
      AppMethodBeat.o(303304);
      return 5;
    }
    AppMethodBeat.o(303304);
    return 4;
  }
  
  private static final int a(long paramLong1, long paramLong2, kotlin.g.a.b paramb, ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(303473);
    s.u(paramb, "$callback");
    Log.i(TAG, "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (c.c.b(paramc.otC) != null) && ((c.c.b(paramc.otC) instanceof kr)))
    {
      paramc = c.c.b(paramc.otC);
      if (paramc == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
        AppMethodBeat.o(303473);
        throw paramb;
      }
      paramc = (kr)paramc;
      paramString.putBoolean("success", true);
      paramString.putByteArray("response", paramc.toByteArray());
      paramp = paramc.YMN;
      s.s(paramp, "response.SceneControlList");
      if (!((Collection)paramp).isEmpty())
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramp = q.dfF();
          euk localeuk = new euk();
          localeuk.YMN = paramc.YMN;
          paramc = ah.aiuX;
          paramp.encode("_msg_scene_strip", localeuk.toByteArray());
        }
      }
    }
    for (;;)
    {
      paramString.putLong("start", paramLong1);
      long l = System.currentTimeMillis();
      paramString.putLong("end", l);
      Log.v(TAG, "terry performance runCGI #" + paramLong2 + ": " + paramLong1 + ',' + l);
      paramb.invoke(paramString);
      paramString.putBoolean("mount", true);
      if (paramArrayList == null) {
        break label478;
      }
      paramb = ((Iterable)paramArrayList).iterator();
      while (paramb.hasNext())
      {
        paramArrayList = (String)paramb.next();
        s.s(paramArrayList, "url");
        paramArrayList = c.ajo(paramArrayList);
        paramc = (ConcurrentLinkedDeque)dfy().get(paramArrayList);
        dfy().remove(paramArrayList);
        if (paramc != null)
        {
          paramc = ((Iterable)paramc).iterator();
          while (paramc.hasNext())
          {
            paramp = (kotlin.g.a.b)paramc.next();
            paramString.putString("id", paramArrayList);
            paramp.invoke(paramString);
          }
        }
      }
      paramInt1 = 0;
      break;
      paramString.putBoolean("success", false);
    }
    label478:
    AppMethodBeat.o(303473);
    return 0;
  }
  
  private static com.tencent.mm.am.c.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    kq localkq = new kq();
    localkq.vYk = f.getNetWorkType();
    localkq.YMI = q.dfE();
    localkq.YMH = new LinkedList();
    localkq.YMJ = paramInt2;
    localkq.YMK = paramInt3;
    localkq.YML = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.mY(true);
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).vST;
      localObject3 = new erl();
      ((erl)localObject3).Url = ((String)localObject2);
      ((erl)localObject3).YHC = 0;
      ((erl)localObject3).IJG = paramInt1;
      localObject2 = vSQ.ajy((String)localObject2);
      if (localObject2 != null)
      {
        ((erl)localObject3).YHC = ((gb)localObject2).YHC;
        if (!a((gb)localObject2, paramInt2)) {
          ((erl)localObject3).YHC = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localkq.YMH.addAll((Collection)localObject1);
    Log.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localkq.YMH.size()) });
    Log.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = localkq.YML;
    s.s(paramIterable, "batchGetAppMsgReq.TypeInfoList");
    paramIterable = ((Iterable)paramIterable).iterator();
    while (paramIterable.hasNext())
    {
      localObject1 = (abv)paramIterable.next();
      Log.v(TAG, "[batchSyncAppMsgContext] typeInfo: type: %s, uids: %s, uidInUse: %s, controlFlag: %s", new Object[] { Integer.valueOf(((abv)localObject1).vhJ), ((abv)localObject1).Zkr, ((abv)localObject1).Zks, Long.valueOf(((abv)localObject1).Zkt) });
    }
    paramIterable = new com.tencent.mm.am.c.a();
    paramIterable.funcId = 2594;
    paramIterable.uri = "/cgi-bin/mmbiz-bin/batchgetappmsg";
    paramIterable.otG = 0;
    paramIterable.respCmdId = 0;
    paramIterable.otE = ((com.tencent.mm.bx.a)localkq);
    paramIterable.otF = ((com.tencent.mm.bx.a)new kr());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.g.a.nk(paramInt1, localkq.YMH.size());
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
  
  private static void a(Context paramContext, Intent paramIntent, egp paramegp, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303329);
    if (com.tencent.mm.message.e.uA(paramegp.nQm)) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.br.c.b(paramContext, paramString1, paramString2, paramIntent);
    AppMethodBeat.o(303329);
  }
  
  private static void a(Bundle paramBundle, kotlin.g.a.b<? super Bundle, ah> paramb)
  {
    AppMethodBeat.i(6706);
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis() % 100L;
    ArrayList localArrayList = paramBundle.getStringArrayList("urls");
    if ((localArrayList != null) && (localArrayList.size() == 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = localArrayList.get(0);
      s.s(localObject1, "urls[0]");
      localObject1 = c.ajo((String)localObject1);
      if (!dfy().containsKey(localObject1)) {
        break;
      }
      paramBundle = (ConcurrentLinkedDeque)dfy().get(localObject1);
      if (paramBundle != null) {
        paramBundle.add(paramb);
      }
      Log.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
      AppMethodBeat.o(6706);
      return;
    }
    Object localObject1 = paramBundle.getIntegerArrayList("tmplTypes");
    int m = paramBundle.getInt("openScene");
    int n = paramBundle.getInt("strip", 0);
    int i1 = paramBundle.getInt("stripType", 0);
    paramBundle = new LinkedList();
    int i2;
    if (localArrayList != null)
    {
      i2 = localArrayList.size();
      if (i2 <= 0) {}
    }
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      Object localObject2 = (CharSequence)localArrayList.get(i);
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0)
        {
          localObject2 = localArrayList.get(i);
          s.s(localObject2, "urls[i]");
          localObject2 = (String)localObject2;
          s.checkNotNull(localObject1);
          Object localObject3 = ((ArrayList)localObject1).get(i);
          s.s(localObject3, "tmplTypes!![i]");
          paramBundle.add(new d((String)localObject2, ((Number)localObject3).intValue()));
          localObject2 = localArrayList.get(i);
          s.s(localObject2, "urls[i]");
          localObject2 = c.ajo((String)localObject2);
          ((Map)dfy()).put(localObject2, new ConcurrentLinkedDeque());
          Log.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
        }
        if (k < i2) {
          break;
        }
        z.a(a((Iterable)paramBundle, m, n, i1).bEF(), new m..ExternalSyntheticLambda0(l1, l2, paramb, localArrayList), true);
        AppMethodBeat.o(6706);
        return;
      }
    }
  }
  
  private static void a(Bundle paramBundle, kotlin.g.a.m<? super c, ? super kr, ah> paramm)
  {
    AppMethodBeat.i(303393);
    boolean bool = paramBundle.getBoolean("success");
    c localc = new c(bool, paramBundle.getLong("start"), paramBundle.getLong("end"), paramBundle.getBoolean("mount"), (byte)0);
    if (bool)
    {
      kr localkr = new kr();
      localkr.parseFrom(paramBundle.getByteArray("response"));
      LinkedList localLinkedList;
      Object localObject1;
      if (localc.vRZ)
      {
        Log.v(TAG, "cgi mount");
        localLinkedList = localkr.YMM;
        s.s(localLinkedList, "");
        localObject1 = (Iterable)localLinkedList;
        Object localObject2 = (Collection)new ArrayList();
        Object localObject3 = ((Iterable)localObject1).iterator();
        label166:
        label217:
        label220:
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          localObject1 = (gb)localObject4;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label217;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label220;
            }
            ((Collection)localObject2).add(localObject4);
            break;
            localObject1 = ((gb)localObject1).Url;
            break label166;
          }
        }
        localObject2 = ((Iterable)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = ((gb)localObject1).Url;
          s.s(localObject3, "appMsgContext.Url");
        } while (!s.p(c.ajo((String)localObject3), paramBundle.getString("id")));
      }
      for (paramBundle = (Bundle)localObject1;; paramBundle = null)
      {
        paramBundle = (gb)paramBundle;
        localLinkedList.clear();
        localLinkedList.add(paramBundle);
        paramm.invoke(localc, localkr);
        AppMethodBeat.o(303393);
        return;
      }
    }
    paramm.invoke(localc, new kr());
    AppMethodBeat.o(303393);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    s.u(???, "url");
    s.u(paramVarArgs, "params");
    if (vSS)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new al(3);
    ((al)localObject1).add(???);
    ((al)localObject1).add(Integer.valueOf(paramInt1));
    ((al)localObject1).hx(paramVarArgs);
    paramVarArgs = kotlin.a.p.al(((al)localObject1).toArray(new Object[((al)localObject1).hqL.size()]));
    localObject1 = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (__BATCH_RUN_OBJ.INSTANCE)
    {
      localObject2 = (cb)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject1);
      if (localObject2 != null) {
        ((cb)localObject2).a(null);
      }
      localObject2 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
      if (!((HashMap)localObject2).containsKey(localObject1)) {
        ((Map)localObject2).put(localObject1, new LinkedList());
      }
      localObject2 = ((HashMap)localObject2).get(localObject1);
      if (localObject2 == null)
      {
        paramVarArgs = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<T of com.tencent.mm.sdk.platformtools.MMBatchRunKt.batchRun$lambda-1$lambda-0>");
        AppMethodBeat.o(6711);
        throw paramVarArgs;
      }
    }
    ((LinkedList)localObject2).add(paramVarArgs);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject1, kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new e(1000L, (String)localObject1, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private static void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, kotlin.g.a.m<? super c, ? super kr, ah> paramm)
  {
    AppMethodBeat.i(6704);
    Bundle localBundle = new Bundle();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).url);
    }
    localBundle.putStringArrayList("urls", new ArrayList((Collection)localObject1));
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).vST));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      a(localBundle, (kotlin.g.a.b)new k(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, b.class, new m..ExternalSyntheticLambda6(paramm));
    AppMethodBeat.o(6704);
  }
  
  private static final void a(kotlin.g.a.m paramm, Bundle paramBundle)
  {
    AppMethodBeat.i(303467);
    s.u(paramm, "$callback");
    s.s(paramBundle, "bundle");
    a(paramBundle, paramm);
    AppMethodBeat.o(303467);
  }
  
  /* Error */
  private final boolean a(Context paramContext, Intent paramIntent, egp paramegp, com.tencent.mm.plugin.brandservice.api.c.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1103
    //   3: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: getfield 1104	com/tencent/mm/protocal/protobuf/egp:vST	I
    //   10: invokestatic 1108	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b:HQ	(I)Lcom/tencent/mm/protocal/protobuf/fnn;
    //   13: astore 13
    //   15: aload 13
    //   17: ifnonnull +69 -> 86
    //   20: aload_3
    //   21: getfield 827	com/tencent/mm/protocal/protobuf/egp:nQm	I
    //   24: ifeq +11 -> 35
    //   27: aload_3
    //   28: getfield 827	com/tencent/mm/protocal/protobuf/egp:nQm	I
    //   31: iconst_m1
    //   32: if_icmpne +54 -> 86
    //   35: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   38: ldc_w 1110
    //   41: invokestatic 1112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 4
    //   46: iconst_0
    //   47: putfield 1116	com/tencent/mm/plugin/brandservice/api/c$a:success	Z
    //   50: aload 4
    //   52: new 597	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 1118
    //   59: invokespecial 600	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_3
    //   63: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1120
    //   69: invokevirtual 609	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 615	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: putfield 1123	com/tencent/mm/plugin/brandservice/api/c$a:message	Ljava/lang/String;
    //   78: ldc_w 1103
    //   81: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_0
    //   85: ireturn
    //   86: getstatic 1128	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizEnable	Z
    //   89: istore 10
    //   91: getstatic 1131	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizDelay	I
    //   94: istore 7
    //   96: getstatic 1134	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizCPU	I
    //   99: istore 8
    //   101: getstatic 1137	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizIO	I
    //   104: istore 9
    //   106: getstatic 1140	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizThr	Z
    //   109: ifeq +328 -> 437
    //   112: invokestatic 1145	android/os/Process:myTid	()I
    //   115: istore 6
    //   117: iload 10
    //   119: iload 7
    //   121: iload 8
    //   123: iload 9
    //   125: iload 6
    //   127: getstatic 1148	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizTimeout	I
    //   130: sipush 902
    //   133: getstatic 1151	com/tencent/mm/hardcoder/WXHardCoderJNI:hcBizAction	J
    //   136: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   139: invokestatic 1155	com/tencent/mm/hardcoder/WXHardCoderJNI:startPerformance	(ZIIIIIIJLjava/lang/String;)I
    //   142: istore 6
    //   144: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   147: ldc_w 1157
    //   150: iconst_2
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: sipush 902
    //   159: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: iload 6
    //   167: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload 13
    //   176: ifnonnull +267 -> 443
    //   179: aload_3
    //   180: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   183: astore 4
    //   185: aload 4
    //   187: ldc_w 1160
    //   190: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   193: aload_2
    //   194: ldc_w 1161
    //   197: aload 4
    //   199: aload_2
    //   200: invokestatic 1164	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:d	(Ljava/lang/String;Landroid/content/Intent;)Ljava/lang/String;
    //   203: aload_3
    //   204: invokestatic 1170	com/tencent/mm/plugin/brandservice/ui/timeline/preload/UrlExKt:appendStats	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/egp;)Ljava/lang/String;
    //   207: invokevirtual 1173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   210: pop
    //   211: aload_2
    //   212: getstatic 1178	com/tencent/mm/ui/f$s:adwZ	Ljava/lang/String;
    //   215: iconst_1
    //   216: invokevirtual 1181	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   219: pop
    //   220: getstatic 1184	com/tencent/mm/ui/f$s:adwO	Ljava/lang/String;
    //   223: astore 4
    //   225: getstatic 351	com/tencent/mm/plugin/brandservice/ui/timeline/preload/j:vSB	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/j$a;
    //   228: astore 12
    //   230: aload_2
    //   231: aload 4
    //   233: invokestatic 482	com/tencent/mm/plugin/brandservice/ui/timeline/preload/j$a:dfl	()Z
    //   236: invokevirtual 1181	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   239: pop
    //   240: aload_2
    //   241: getstatic 1187	com/tencent/mm/ui/f$s:adwP	Ljava/lang/String;
    //   244: invokestatic 593	java/lang/System:currentTimeMillis	()J
    //   247: invokevirtual 1190	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   250: pop
    //   251: aload_2
    //   252: getstatic 1193	com/tencent/mm/ui/f$s:adwR	Ljava/lang/String;
    //   255: aload_3
    //   256: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   259: invokevirtual 1173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   262: pop
    //   263: getstatic 1196	com/tencent/mm/ui/f$s:adwN	Ljava/lang/String;
    //   266: astore 12
    //   268: aload 13
    //   270: ifnonnull +639 -> 909
    //   273: aconst_null
    //   274: astore 4
    //   276: aload_2
    //   277: aload 12
    //   279: aload 4
    //   281: invokevirtual 1199	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   284: pop
    //   285: aload_2
    //   286: getstatic 1202	com/tencent/mm/ui/f$s:adwY	Ljava/lang/String;
    //   289: aload_3
    //   290: invokevirtual 1203	com/tencent/mm/protocal/protobuf/egp:toByteArray	()[B
    //   293: invokevirtual 1199	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   296: pop
    //   297: aload_2
    //   298: getstatic 1206	com/tencent/mm/ui/f$s:adwV	Ljava/lang/String;
    //   301: invokestatic 1209	android/os/Process:myPid	()I
    //   304: invokevirtual 840	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   307: pop
    //   308: aload_2
    //   309: getstatic 1212	com/tencent/mm/ui/f$s:adwU	Ljava/lang/String;
    //   312: aload_1
    //   313: getstatic 1216	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m$m:vTb	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/m$m;
    //   316: checkcast 620	kotlin/g/a/b
    //   319: invokestatic 1219	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:e	(Landroid/content/Context;Lkotlin/g/a/b;)Z
    //   322: invokevirtual 1181	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   325: pop
    //   326: iload 5
    //   328: ifeq +58 -> 386
    //   331: aload_3
    //   332: getfield 1222	com/tencent/mm/protocal/protobuf/egp:ablR	Z
    //   335: istore 5
    //   337: iload 5
    //   339: ifeq +35 -> 374
    //   342: aload_2
    //   343: ldc_w 1223
    //   346: invokestatic 509	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   349: getstatic 261	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:PROCESS_NAME	Ljava/lang/String;
    //   352: astore 4
    //   354: aload 4
    //   356: ldc_w 483
    //   359: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   362: aload 4
    //   364: aload_2
    //   365: checkcast 489	android/os/Parcelable
    //   368: getstatic 1228	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m$$ExternalSyntheticLambda1:INSTANCE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/m$$ExternalSyntheticLambda1;
    //   371: invokestatic 500	com/tencent/mm/ipcinvoker/a:a	(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/d;)V
    //   374: aload_1
    //   375: aload_2
    //   376: aload_3
    //   377: ldc_w 1230
    //   380: ldc_w 1232
    //   383: invokestatic 1234	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:a	(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/protocal/protobuf/egp;Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 13
    //   388: ifnull +41 -> 429
    //   391: aload 13
    //   393: getfield 1239	com/tencent/mm/protocal/protobuf/fnn:reportId	I
    //   396: bipush 106
    //   398: invokestatic 1242	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   401: bipush 100
    //   403: invokestatic 1245	com/tencent/mm/plugin/webview/g/a:atP	(I)V
    //   406: aload_3
    //   407: getfield 1248	com/tencent/mm/protocal/protobuf/egp:ablS	Z
    //   410: ifeq +19 -> 429
    //   413: aload 13
    //   415: getfield 1239	com/tencent/mm/protocal/protobuf/fnn:reportId	I
    //   418: sipush 231
    //   421: invokestatic 1242	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   424: bipush 110
    //   426: invokestatic 1245	com/tencent/mm/plugin/webview/g/a:atP	(I)V
    //   429: ldc_w 1103
    //   432: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: iconst_1
    //   436: ireturn
    //   437: iconst_0
    //   438: istore 6
    //   440: goto -323 -> 117
    //   443: aload_3
    //   444: aload 13
    //   446: getfield 1251	com/tencent/mm/protocal/protobuf/fnn:mXG	Ljava/lang/String;
    //   449: putfield 1252	com/tencent/mm/protocal/protobuf/egp:mXG	Ljava/lang/String;
    //   452: aload 13
    //   454: getfield 1239	com/tencent/mm/protocal/protobuf/fnn:reportId	I
    //   457: bipush 104
    //   459: invokestatic 1242	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   462: aload_3
    //   463: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   466: astore 12
    //   468: aload 12
    //   470: ldc_w 1160
    //   473: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   476: aload 12
    //   478: aload_3
    //   479: getfield 1104	com/tencent/mm/protocal/protobuf/egp:vST	I
    //   482: invokestatic 1256	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:dG	(Ljava/lang/String;I)Lcom/tencent/mm/protocal/protobuf/gb;
    //   485: astore 14
    //   487: aload 14
    //   489: ifnull +189 -> 678
    //   492: aload 14
    //   494: getfield 1259	com/tencent/mm/protocal/protobuf/gb:YHB	Ljava/lang/String;
    //   497: astore 12
    //   499: aload 12
    //   501: ifnull +177 -> 678
    //   504: aload 12
    //   506: checkcast 879	java/lang/CharSequence
    //   509: invokestatic 1265	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   512: ifne +160 -> 672
    //   515: iconst_1
    //   516: istore 6
    //   518: iload 6
    //   520: iconst_1
    //   521: if_icmpne +157 -> 678
    //   524: iconst_1
    //   525: istore 6
    //   527: iload 6
    //   529: ifeq +180 -> 709
    //   532: aload 14
    //   534: ifnonnull +150 -> 684
    //   537: aconst_null
    //   538: astore 12
    //   540: aload 12
    //   542: invokevirtual 345	java/lang/Boolean:booleanValue	()Z
    //   545: ifne +10 -> 555
    //   548: aload_3
    //   549: getfield 827	com/tencent/mm/protocal/protobuf/egp:nQm	I
    //   552: ifne +145 -> 697
    //   555: new 836	android/content/Intent
    //   558: dup
    //   559: invokespecial 1266	android/content/Intent:<init>	()V
    //   562: astore_2
    //   563: aload 14
    //   565: getfield 1259	com/tencent/mm/protocal/protobuf/gb:YHB	Ljava/lang/String;
    //   568: astore 12
    //   570: aload 12
    //   572: ldc_w 1268
    //   575: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   578: aload 12
    //   580: aload_3
    //   581: invokestatic 1170	com/tencent/mm/plugin/brandservice/ui/timeline/preload/UrlExKt:appendStats	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/egp;)Ljava/lang/String;
    //   584: aload_2
    //   585: invokestatic 1164	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:d	(Ljava/lang/String;Landroid/content/Intent;)Ljava/lang/String;
    //   588: astore 12
    //   590: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   593: ldc_w 1270
    //   596: iconst_1
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload 12
    //   604: aastore
    //   605: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   608: aload_2
    //   609: ldc_w 1161
    //   612: aload 12
    //   614: invokevirtual 1173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   617: pop
    //   618: iload 5
    //   620: ifeq +15 -> 635
    //   623: aload_1
    //   624: aload_2
    //   625: aload_3
    //   626: ldc_w 1272
    //   629: ldc_w 1274
    //   632: invokestatic 1234	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:a	(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/protocal/protobuf/egp;Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 13
    //   637: getfield 1239	com/tencent/mm/protocal/protobuf/fnn:reportId	I
    //   640: bipush 107
    //   642: invokestatic 1242	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   645: aload 4
    //   647: iconst_1
    //   648: putfield 1116	com/tencent/mm/plugin/brandservice/api/c$a:success	Z
    //   651: aload 4
    //   653: ldc_w 1276
    //   656: aload 12
    //   658: invokestatic 1280	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   661: putfield 1123	com/tencent/mm/plugin/brandservice/api/c$a:message	Ljava/lang/String;
    //   664: ldc_w 1103
    //   667: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: iconst_1
    //   671: ireturn
    //   672: iconst_0
    //   673: istore 6
    //   675: goto -157 -> 518
    //   678: iconst_0
    //   679: istore 6
    //   681: goto -154 -> 527
    //   684: aload 14
    //   686: getfield 1283	com/tencent/mm/protocal/protobuf/gb:YHI	Z
    //   689: invokestatic 382	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   692: astore 12
    //   694: goto -154 -> 540
    //   697: aload_2
    //   698: getstatic 1178	com/tencent/mm/ui/f$s:adwZ	Ljava/lang/String;
    //   701: iconst_1
    //   702: invokevirtual 1181	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   705: pop
    //   706: goto -143 -> 563
    //   709: aload_3
    //   710: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   713: astore 4
    //   715: aload 4
    //   717: ldc_w 1160
    //   720: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   723: aload_3
    //   724: aload 4
    //   726: aload_2
    //   727: invokestatic 1164	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:d	(Ljava/lang/String;Landroid/content/Intent;)Ljava/lang/String;
    //   730: putfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   733: aload_2
    //   734: ldc_w 1161
    //   737: aload_3
    //   738: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   741: invokevirtual 1173	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   744: pop
    //   745: aload_3
    //   746: iconst_1
    //   747: putfield 1286	com/tencent/mm/protocal/protobuf/egp:ablQ	Z
    //   750: aload 13
    //   752: getfield 1287	com/tencent/mm/protocal/protobuf/fnn:vST	I
    //   755: invokestatic 1291	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b:HO	(I)Lcom/tencent/mm/protocal/protobuf/fnm;
    //   758: astore 4
    //   760: aload_3
    //   761: aload 4
    //   763: invokestatic 1294	com/tencent/mm/plugin/brandservice/ui/timeline/preload/q:d	(Lcom/tencent/mm/protocal/protobuf/fnm;)Z
    //   766: putfield 1248	com/tencent/mm/protocal/protobuf/egp:ablS	Z
    //   769: invokestatic 1297	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b:getPrefix	()Ljava/lang/String;
    //   772: ldc_w 1299
    //   775: invokestatic 955	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   778: istore 11
    //   780: aload 4
    //   782: invokestatic 1294	com/tencent/mm/plugin/brandservice/ui/timeline/preload/q:d	(Lcom/tencent/mm/protocal/protobuf/fnm;)Z
    //   785: ifeq +81 -> 866
    //   788: iload 11
    //   790: ifeq +76 -> 866
    //   793: iconst_1
    //   794: istore 10
    //   796: aload_3
    //   797: iload 10
    //   799: putfield 1302	com/tencent/mm/protocal/protobuf/egp:ablT	Z
    //   802: aload 4
    //   804: invokestatic 1294	com/tencent/mm/plugin/brandservice/ui/timeline/preload/q:d	(Lcom/tencent/mm/protocal/protobuf/fnm;)Z
    //   807: ifeq +65 -> 872
    //   810: iload 11
    //   812: ifne +60 -> 872
    //   815: iconst_1
    //   816: istore 10
    //   818: aload_3
    //   819: iload 10
    //   821: putfield 1305	com/tencent/mm/protocal/protobuf/egp:ablU	Z
    //   824: aload 14
    //   826: ifnull +52 -> 878
    //   829: aload 14
    //   831: invokestatic 1310	com/tencent/mm/plugin/brandservice/ui/timeline/preload/n:b	(Lcom/tencent/mm/protocal/protobuf/gb;)Z
    //   834: ifeq +44 -> 878
    //   837: aload_3
    //   838: iconst_1
    //   839: putfield 1222	com/tencent/mm/protocal/protobuf/egp:ablR	Z
    //   842: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   845: ldc_w 1312
    //   848: iconst_1
    //   849: anewarray 4	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload 14
    //   856: invokestatic 1315	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c:a	(Lcom/tencent/mm/protocal/protobuf/gb;)Ljava/lang/String;
    //   859: aastore
    //   860: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   863: goto -643 -> 220
    //   866: iconst_0
    //   867: istore 10
    //   869: goto -73 -> 796
    //   872: iconst_0
    //   873: istore 10
    //   875: goto -57 -> 818
    //   878: aload_3
    //   879: getfield 1158	com/tencent/mm/protocal/protobuf/egp:url	Ljava/lang/String;
    //   882: astore 4
    //   884: aload 4
    //   886: ldc_w 1160
    //   889: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   892: aload_0
    //   893: aload_1
    //   894: aload 4
    //   896: aload_3
    //   897: getstatic 1319	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m$h:vSX	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/m$h;
    //   900: checkcast 1321	kotlin/g/a/q
    //   903: invokevirtual 1324	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:a	(Ljava/lang/Object;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/egp;Lkotlin/g/a/q;)V
    //   906: goto -686 -> 220
    //   909: aload 13
    //   911: invokevirtual 1325	com/tencent/mm/protocal/protobuf/fnn:toByteArray	()[B
    //   914: astore 4
    //   916: goto -640 -> 276
    //   919: astore 4
    //   921: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   924: ldc_w 1327
    //   927: aload 4
    //   929: invokevirtual 1330	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   932: invokestatic 1280	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   935: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: goto -564 -> 374
    //   941: astore_1
    //   942: getstatic 247	com/tencent/mm/plugin/brandservice/ui/timeline/preload/m:TAG	Ljava/lang/String;
    //   945: aload_1
    //   946: checkcast 433	java/lang/Throwable
    //   949: ldc_w 1331
    //   952: iconst_0
    //   953: anewarray 4	java/lang/Object
    //   956: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   959: ldc_w 1103
    //   962: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   965: iconst_0
    //   966: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	this	m
    //   0	967	1	paramContext	Context
    //   0	967	2	paramIntent	Intent
    //   0	967	3	paramegp	egp
    //   0	967	4	parama	com.tencent.mm.plugin.brandservice.api.c.a
    //   0	967	5	paramBoolean	boolean
    //   115	565	6	i	int
    //   94	26	7	j	int
    //   99	23	8	k	int
    //   104	20	9	m	int
    //   89	785	10	bool1	boolean
    //   778	33	11	bool2	boolean
    //   228	465	12	localObject	Object
    //   13	897	13	localfnn	com.tencent.mm.protocal.protobuf.fnn
    //   485	370	14	localgb	gb
    // Exception table:
    //   from	to	target	type
    //   342	374	919	finally
    //   308	326	941	java/lang/Exception
    //   331	337	941	java/lang/Exception
    //   374	386	941	java/lang/Exception
    //   391	429	941	java/lang/Exception
    //   921	938	941	java/lang/Exception
  }
  
  private static boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.api.c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(303287);
    s.u(paramContext, "context");
    s.u(paramString, "rawUrl");
    s.u(paramIntent, "intent");
    s.u(parama, "result");
    if (n.bp((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(303287);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(303287);
      return false;
    }
    if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramContext))
    {
      Log.i(TAG, "Block mp rawUrl %s", new Object[] { paramString });
      parama.success = false;
      parama.message = "mp url currently blocked";
      AppMethodBeat.o(303287);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = vSQ.ajy(paramString);
      if (localObject == null) {
        i = paramInt1;
      }
    }
    for (;;)
    {
      if (i == 16)
      {
        paramIntent.putExtra("immersiveVideoStyle", 1);
        paramIntent.putExtra("immersivePageBgIsDark", 1);
        paramIntent.putExtra("webview_bg_color_rsID", 17170444);
      }
      int k = Hz(i);
      if (k == -1)
      {
        parama.success = false;
        parama.message = s.X("invalid itemShowType:", Integer.valueOf(i));
        AppMethodBeat.o(303287);
        return false;
        i = ((gb)localObject).nUA;
      }
      else
      {
        int m = ad.getSessionId();
        localObject = UrlExKt.getUrlParam(paramString, "scene");
        int j = paramInt2;
        CharSequence localCharSequence;
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          j = paramInt2;
          if (new kotlin.n.k("\\d+").bm(localCharSequence)) {
            j = Integer.parseInt((String)localObject);
          }
        }
        localObject = UrlExKt.getUrlParam(paramString, "subscene");
        paramInt2 = paramInt3;
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          paramInt2 = paramInt3;
          if (new kotlin.n.k("\\d+").bm(localCharSequence)) {
            paramInt2 = Integer.parseInt((String)localObject);
          }
        }
        paramIntent.putExtra(f.s.adwW, i);
        paramIntent.putExtra(f.s.adwS, m);
        if (paramIntent.getIntExtra("KOpenArticleSceneFromScene", -1) == -1) {
          paramIntent.putExtra("KOpenArticleSceneFromScene", j);
        }
        paramIntent.putExtra(f.s.adwT, paramInt2);
        paramIntent.putExtra(f.s.adwX, paramInt4);
        paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
        localObject = new egp();
        ((egp)localObject).id = m;
        ((egp)localObject).url = paramString;
        ((egp)localObject).nQm = i;
        ((egp)localObject).vST = k;
        ((egp)localObject).vAZ = j;
        ((egp)localObject).AcJ = paramInt2;
        ((egp)localObject).ablP = paramInt3;
        boolean bool;
        if (i != paramInt1)
        {
          bool = true;
          ((egp)localObject).vSc = bool;
          paramBoolean = vSK.a(paramContext, paramIntent, (egp)localObject, parama, paramBoolean);
          if (paramBoolean)
          {
            if ((paramInt4 != -1) && ((paramContext instanceof MMActivity)) && (paramInt4 == 1)) {
              ((MMActivity)paramContext).overridePendingTransition(d.a.push_up_in, d.a.push_empty_out);
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
          com.tencent.mm.plugin.webview.g.a.atO(paramInt1);
          AppMethodBeat.o(303287);
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
  
  private static boolean a(gb paramgb, int paramInt)
  {
    AppMethodBeat.i(6702);
    fnm localfnm = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.HO(paramInt);
    Object localObject = (CharSequence)paramgb.YHB;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (q.a(localfnm))
    {
      paramgb = paramgb.YHJ;
      if (paramgb != null)
      {
        paramgb = ((Iterable)paramgb).iterator();
        while (paramgb.hasNext())
        {
          localObject = (fnm)paramgb.next();
          Log.v(TAG, "checkDataVerVaild: " + ((fnm)localObject).vhJ + ' ' + localfnm.vhJ + ' ' + ((fnm)localObject).abNx + ' ' + localfnm.abNx);
          if ((((fnm)localObject).vhJ == localfnm.vhJ) && (s.p(((fnm)localObject).abNx, localfnm.abNx)))
          {
            Log.v(TAG, "checkDataVerVaild: " + ((fnm)localObject).crz + " tmplInfo:" + localfnm.crz);
            if (((fnm)localObject).crz >= localfnm.crz)
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
  
  private static void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    s.u(paramString, "netType");
    String str = MainProcessIPCService.PROCESS_NAME;
    s.s(str, "PROCESS_NAME");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    paramString = ah.aiuX;
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)localBundle, m..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(6691);
  }
  
  public static void ajv(String paramString)
  {
    AppMethodBeat.i(6710);
    s.u(paramString, "url");
    Log.d(TAG, "removePreload %s", new Object[] { paramString });
    s.u(paramString, "url");
    String str = c.ajk(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)vSM.findSlot(str);
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.removeValueForKey(str);
      localMultiProcessMMKV.removeValueForKey(c.ajo(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void ajw(String paramString)
  {
    AppMethodBeat.i(6715);
    s.u(paramString, "url");
    String str = MainProcessIPCService.PROCESS_NAME;
    s.s(str, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), m..ExternalSyntheticLambda4.INSTANCE);
    AppMethodBeat.o(6715);
  }
  
  public static long ajx(String paramString)
  {
    AppMethodBeat.i(6716);
    s.u(paramString, "url");
    paramString = c.ajp(paramString);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)vSM.findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(6716);
      return 0L;
    }
    long l = localMultiProcessMMKV.getLong(paramString, 0L);
    AppMethodBeat.o(6716);
    return l;
  }
  
  private static final void b(Intent paramIntent, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303464);
    s.s(paramIntent, "intent");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.aj(paramIntent);
    AppMethodBeat.o(303464);
  }
  
  private static final void b(IPCInteger paramIPCInteger, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303459);
    paramf = com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.vXb;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.HS(paramIPCInteger.value);
    AppMethodBeat.o(303459);
  }
  
  private final void b(List<d> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6703);
    j.a locala = j.vSB;
    if (!j.a.dfm())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (kotlin.g.a.m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    boolean bool = a.dfD();
    Log.i(TAG, s.X("clear() isOk:", Boolean.valueOf(bool)));
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.dgN();
    AppMethodBeat.o(6688);
  }
  
  private static String d(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(303312);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramIntent.putExtra("bizEnterId", i);
    if (!n.a((CharSequence)paramString, (CharSequence)"clicktime", false)) {}
    for (paramIntent = UrlExKt.appendUrlParam(paramString, "clicktime", String.valueOf(i));; paramIntent = paramString)
    {
      Object localObject = paramIntent;
      if (!n.a((CharSequence)paramString, (CharSequence)"enterid", false)) {
        localObject = UrlExKt.appendUrlParam(paramIntent, "enterid", String.valueOf(i));
      }
      AppMethodBeat.o(303312);
      return localObject;
    }
  }
  
  private static gb dG(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (n.bp((CharSequence)paramString))
    {
      Log.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (vSQ.dH(paramString, paramInt))
    {
      paramString = vSQ.ajy(paramString);
      AppMethodBeat.o(6700);
      return paramString;
    }
    AppMethodBeat.o(6700);
    return null;
  }
  
  private static void dfA()
  {
    AppMethodBeat.i(6714);
    String str = MainProcessIPCService.PROCESS_NAME;
    s.s(str, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(str, null, m..ExternalSyntheticLambda5.INSTANCE);
    AppMethodBeat.o(6714);
  }
  
  public static MMKVSlotManager dfv()
  {
    return vSM;
  }
  
  public static MMFileSlotManager dfw()
  {
    return vSN;
  }
  
  public static a dfx()
  {
    return vSQ;
  }
  
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, ah>>> dfy()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)vSR.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  public static void dfz()
  {
    AppMethodBeat.i(303432);
    Log.d(TAG, "removeAllPreload");
    vSM.clearAll();
    AppMethodBeat.o(303432);
  }
  
  private static final void e(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303462);
    int i = paramBundle.getInt("openScene", 10000);
    paramBundle = paramBundle.getString("netType", "unknown");
    s.s(paramBundle, "netType");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.a(i, paramBundle, new int[0]);
    AppMethodBeat.o(303462);
  }
  
  private static final void e(IPCVoid paramIPCVoid, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303476);
    paramf = SubCoreBrandService.dbN().db.query("BizAppMsgReportContext", null, null, null, null, null, "reportTime DESC limit 50");
    paramIPCVoid = new LinkedList();
    while (paramf.moveToNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a locala = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a();
      locala.convertFrom(paramf);
      paramIPCVoid.add(locala);
    }
    paramf.close();
    paramf = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c.eC(paramIPCVoid);
    if ((paramf == null) || (paramf.size() <= 0))
    {
      SubCoreBrandService.dbN().eB(paramIPCVoid);
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "list is null, return");
      AppMethodBeat.o(303476);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.rG(53);
    z.a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c.d(paramf, 1).bEF(), new c.2(paramf, paramIPCVoid));
    AppMethodBeat.o(303476);
  }
  
  private static final void n(IPCString paramIPCString, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(303478);
    paramIPCString = paramIPCString.value;
    if (Util.isNullOrNil(paramIPCString))
    {
      Log.w("MicroMsg.Preload.BizAppMsgReportMgr", "url is null, err");
      AppMethodBeat.o(303478);
      return;
    }
    paramf = new gj();
    paramf.Url = paramIPCString;
    com.tencent.mm.plugin.webview.g.a.rG(50);
    com.tencent.mm.plugin.webview.g.a.rG(56);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.c.a(paramf, 0);
    AppMethodBeat.o(303478);
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(6686);
    if (vSL.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    vSL.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.xwebutil.c.jQE();
      Hw(paramInt);
      vSL.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new l(paramInt));
    AppMethodBeat.o(6686);
  }
  
  public static final void s(List<? extends List<String>> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6713);
    s.u(paramList, "items");
    if (vSS)
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
        break label868;
      }
      k = HA(paramInt);
      if (k == 0) {
        break label353;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label353;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
      localObject4 = ((List)localObject1).get(2);
      str = r.cg((String)((List)localObject1).get(0));
      localObject5 = a((List)localObject1, 3, "");
      localObject6 = a((List)localObject1, 4, "");
      localObject7 = ((List)localObject1).get(1);
      localObject8 = a((List)localObject1, 5, "");
      localObject9 = a((List)localObject1, 6, "");
      localObject10 = a((List)localObject1, 7, "");
      if (!s.p(((List)localObject1).get(1), "-1")) {
        break label343;
      }
      localObject1 = (String)((List)localObject1).get(0);
      if (localObject1 != null) {
        break label330;
      }
      localObject1 = null;
      label226:
      if (!((Boolean)localObject1).booleanValue()) {
        break label343;
      }
      i = 1;
      label236:
      if (i == 0) {
        break label348;
      }
    }
    label330:
    label343:
    label348:
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject3).b(16468, new Object[] { Integer.valueOf(k), localObject4, str, localObject5, localObject6, Integer.valueOf(1), localObject7, localObject8, localObject9, localObject10, Integer.valueOf(i) });
      break label68;
      i = 0;
      break;
      localObject1 = Boolean.valueOf(UrlExKt.isMpArticleUrl((String)localObject1));
      break label226;
      i = 0;
      break label236;
    }
    label353:
    if (GV(HB(paramInt)))
    {
      k = c.Ht(paramInt);
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
            break label455;
          }
          paramList.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        paramList.add(new d((String)((List)localObject2).get(0), Hz(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).vST;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (vSQ.dH((String)localObject4, i))) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label669;
          }
          paramList.add(localObject2);
          break;
        }
      }
      paramList = (List)paramList;
      int m = Math.max(paramList.size() - k, 0);
      localObject2 = kotlin.a.p.c((Iterable)paramList, k);
      i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        vSK.b((List)localObject2, paramInt, m, 1);
        if (Log.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls toStrip:").append(k).append(" strip:").append(m).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(c.ajo(((d)((Iterator)localObject3).next()).url));
          }
          Log.v(paramList, (List)localObject2);
        }
      }
    }
    label455:
    label868:
    AppMethodBeat.o(6713);
    label669:
  }
  
  public static final void t(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6712);
    s.u(paramList, "items");
    if (vSS)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!GV(HB(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = c.Ht(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(Long.parseLong(paramList[0]), paramList[1]).nUC;
      if (i > 0) {
        s.s(paramList, "it");
      }
      for (paramList = kotlin.a.p.c((Iterable)paramList, i);; paramList = (List)paramList)
      {
        s.s(paramList, "service<IAppMsgBizHelper…else it\n                }");
        kotlin.a.p.a((Collection)localObject1, (Iterable)paramList);
        break;
      }
    }
    paramList = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.message.v)((Iterator)localObject3).next();
      localObject1 = ((com.tencent.mm.message.v)localObject4).url;
      paramList = (List<String[]>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(new d(paramList, Hz(((com.tencent.mm.message.v)localObject4).type)));
    }
    localObject1 = (Iterable)localObject2;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label389:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (d)localObject2;
      localObject4 = ((d)localObject3).url;
      i = ((d)localObject3).vST;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (vSQ.dH((String)localObject4, i))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label389;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = (List)paramList;
    int k = Math.max(paramList.size() - j, 0);
    localObject2 = kotlin.a.p.c((Iterable)paramList, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      vSK.b((List)localObject2, paramInt, k, 1);
      if (Log.getLogLevel() == 0)
      {
        paramList = TAG;
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer toStrip:").append(j).append(" strip:").append(k).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(c.ajo(((d)((Iterator)localObject3).next()).url));
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
  
  public final void a(final Object paramObject, final String paramString, egp paramegp, kotlin.g.a.q<? super WeakReference<Object>, ? super c, ? super gb, ah> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(303536);
    s.u(paramObject, "context");
    s.u(paramString, "url");
    s.u(paramegp, "session");
    s.u(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = j.vSB;
    if (j.a.dfn())
    {
      ((c)localObject1).isSuccess = true;
      paramString = ah.aiuX;
      paramq.invoke(paramObject, localObject1, new gb());
      AppMethodBeat.o(303536);
      return;
    }
    if ((n.bp((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.invoke(paramObject, localObject1, new gb());
      AppMethodBeat.o(303536);
      return;
    }
    localObject2 = dG(paramString, paramegp.vST);
    String str = TAG;
    if (localObject2 == null) {
      bool = true;
    }
    Log.d(str, s.X("getAppMsgContext ", Boolean.valueOf(bool)));
    if (localObject2 != null)
    {
      ((c)localObject1).isSuccess = true;
      ((c)localObject1).djy = true;
      paramString = ah.aiuX;
      paramq.invoke(paramObject, localObject1, localObject2);
      AppMethodBeat.o(303536);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramegp);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramegp.vST));
    a(this, (List)localObject1, paramegp.vST, (kotlin.g.a.m)new i(paramq, paramObject, paramString));
    AppMethodBeat.o(303536);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "removeAll", "save", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    private final boolean c(gb paramgb, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (paramgb == null)
      {
        Log.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = m.vSK;
      if (!m.b(paramgb, paramInt))
      {
        Log.v(this.TAG, "checkValid: invalid version:data(" + paramgb.YHE + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = j.vSB;
      if (j.a.dfo()) {
        Log.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = paramgb.Url;
        s.s(localObject1, "appMsgContext.Url");
        localObject1 = c.ajp((String)localObject1);
        Object localObject2 = m.vSK;
        localObject2 = (MultiProcessMMKV)m.dfv().findSlot((String)localObject1);
        if (localObject2 == null) {}
        for (boolean bool = true; bool; bool = f.a((MultiProcessMMKV)localObject2, (String)localObject1, paramgb.YHA * 1000L))
        {
          Log.i(this.TAG, s.X("checkValid: expire for ", Integer.valueOf(paramgb.YHA)));
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public static boolean dfD()
    {
      AppMethodBeat.i(6642);
      m localm = m.vSK;
      m.dfv().verifyAllSlot();
      AppMethodBeat.o(6642);
      return true;
    }
    
    public final void a(String paramString, gb paramgb)
    {
      AppMethodBeat.i(6641);
      s.u(paramString, "url");
      if (paramgb != null)
      {
        localObject1 = (CharSequence)paramgb.nUB;
        if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
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
      Object localObject1 = c.ajk(paramString);
      String str = paramgb.nUB;
      try
      {
        Object localObject2 = new gb();
        ((gb)localObject2).parseFrom(paramgb.toByteArray());
        ((gb)localObject2).nUB = null;
        Object localObject3 = ((gb)localObject2).toByteArray();
        localObject2 = m.vSK;
        localObject2 = (MultiProcessMMKV)m.dfv().getSlotForWrite();
        ((MultiProcessMMKV)localObject2).encode((String)localObject1, (byte[])localObject3);
        localObject3 = m.vSK;
        localObject3 = c.I(c.a(m.dfw(), c.ajo(paramString)));
        s.s(str, "content");
        com.tencent.mm.vfs.v.i((com.tencent.mm.vfs.u)localObject3, str);
        f.b((MultiProcessMMKV)localObject2, c.ajp(paramString));
        Log.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + Integer.valueOf(paramgb.YHC));
        AppMethodBeat.o(6641);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramString, s.X("save ", localObject1), new Object[0]);
        }
      }
    }
    
    public final gb ajy(String paramString)
    {
      AppMethodBeat.i(6639);
      s.u(paramString, "url");
      String str = c.ajk(paramString);
      Object localObject1 = m.vSK;
      localObject1 = (MultiProcessMMKV)m.dfv().findSlot(str);
      if (localObject1 == null) {}
      label126:
      Object localObject2;
      label167:
      label190:
      for (localObject1 = null;; localObject2 = null)
      {
        localObject1 = (gb)localObject1;
        if (localObject1 == null) {
          break;
        }
        ((gb)localObject1).Url = paramString;
        Log.i(this.TAG, "found:" + str + " last modify:" + ((gb)localObject1).YHC);
        AppMethodBeat.o(6639);
        return localObject1;
        if (((MultiProcessMMKV)localObject1).containsKey(str))
        {
          localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
          if (localObject1 != null)
          {
            if (localObject1.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label167;
              }
            }
            for (int i = 1;; i = 0)
            {
              for (;;)
              {
                if (i == 0) {
                  break label190;
                }
                try
                {
                  Object localObject3 = gb.class.newInstance();
                  ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
                  localObject1 = (com.tencent.mm.bx.a)localObject3;
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                }
              }
              i = 0;
              break label126;
            }
          }
        }
      }
      Log.i(this.TAG, s.X("not found:", str));
      AppMethodBeat.o(6639);
      return null;
    }
    
    public final boolean dH(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      s.u(paramString, "url");
      gb localgb = ajy(paramString);
      if (localgb == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      m localm = m.vSK;
      int i = m.HC(localgb.nUA);
      if (i == -1) {}
      for (;;)
      {
        boolean bool = c(localgb, paramInt);
        if (!bool) {
          Log.d(this.TAG, s.X("init invalid:", c.ajk(paramString)));
        }
        AppMethodBeat.o(6638);
        return bool;
        paramInt = i;
      }
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<Bundle, ah>
    {
      a(com.tencent.mm.ipcinvoker.f<Bundle> paramf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public long axI;
    public boolean djy;
    public boolean isSuccess;
    public long start;
    public boolean vRZ;
    
    private c(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.isSuccess = paramBoolean1;
      this.start = paramLong1;
      this.axI = paramLong2;
      this.vRZ = paramBoolean2;
      this.djy = false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
  {
    final String url;
    final int vST;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.vST = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public e(long paramLong, String paramString, kotlin.d.d paramd, int paramInt)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      paramd = new e(this.$delay, this.$key, paramd, this.vSU);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(6658);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6657);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6657);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        long l = this.$delay;
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (bb.e(l, (kotlin.d.d)localObject2) == localObject1)
        {
          AppMethodBeat.o(6657);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (!ar.a(paramObject))
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(6657);
        return paramObject;
      }
      localObject1 = __BATCH_RUN_OBJ.INSTANCE;
      Object localObject2 = this.$key;
      int i;
      Object localObject3;
      label354:
      for (;;)
      {
        try
        {
          paramObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(localObject2);
          if ((paramObject instanceof Queue))
          {
            paramObject = (Queue)paramObject;
            if (paramObject == null)
            {
              paramObject = null;
              if (paramObject == null) {
                break label1437;
              }
              paramObject = (List)paramObject;
              if ((!WeChatEnvironment.hasDebugger()) || (Log.getLogLevel() != 0)) {
                break label374;
              }
              if (!((Collection)paramObject).isEmpty()) {
                break label354;
              }
              i = 1;
              if (i != 0) {
                break label374;
              }
              localObject1 = m.aUw();
              localObject3 = (Iterable)paramObject;
              localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              ((Collection)localObject2).add(c.ajo(((ArrayList)((Iterator)localObject3).next()).get(0).toString()));
              continue;
            }
          }
          else
          {
            paramObject = null;
            continue;
          }
          __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(localObject2);
          paramObject = new ArrayList((Collection)paramObject);
          continue;
          i = 0;
        }
        finally
        {
          AppMethodBeat.o(6657);
        }
      }
      Log.v((String)localObject1, s.X("preloadData addToPreload batch:", (List)localObject2));
      label374:
      localObject1 = (Iterable)kotlin.a.p.m((Iterable)paramObject);
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label470:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (ArrayList)localObject2;
        if ((localObject3 != null) && ((((ArrayList)localObject3).get(0) instanceof String))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label470;
          }
          paramObject.add(localObject2);
          break;
        }
      }
      localObject2 = (Iterable)paramObject;
      paramObject = new HashSet();
      localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (paramObject.add(c.ajo((String)((ArrayList)localObject3).get(0)))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = m.vSK;
        int j = m.HD(this.vSU);
        Object localObject4;
        if (j != 0)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            paramObject = (ArrayList)((Iterator)localObject2).next();
            localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
            localObject4 = m.vSK;
            localObject4 = m.b((List)paramObject, 2, "");
            String str = r.cg((String)paramObject.get(0));
            Object localObject5 = m.vSK;
            localObject5 = m.b((List)paramObject, 3, "");
            Object localObject6 = m.vSK;
            localObject6 = m.b((List)paramObject, 4, "");
            Object localObject7 = paramObject.get(1);
            Object localObject8 = m.vSK;
            localObject8 = m.b((List)paramObject, 5, "");
            Object localObject9 = m.vSK;
            localObject9 = m.b((List)paramObject, 6, "");
            Object localObject10 = m.vSK;
            localObject10 = m.b((List)paramObject, 7, "");
            if (((Integer)paramObject.get(1)).intValue() == -1)
            {
              paramObject = (String)paramObject.get(0);
              if (paramObject == null)
              {
                paramObject = null;
                label784:
                if (!paramObject.booleanValue()) {
                  break label892;
                }
                i = 1;
                label793:
                if (i == 0) {
                  break label897;
                }
              }
            }
            label897:
            for (i = 1;; i = 0)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject3).b(16468, new Object[] { Integer.valueOf(j), localObject4, str, localObject5, localObject6, Integer.valueOf(2), localObject7, localObject8, localObject9, localObject10, Integer.valueOf(i) });
              break;
              paramObject = Boolean.valueOf(UrlExKt.isMpArticleUrl(paramObject));
              break label784;
              label892:
              i = 0;
              break label793;
            }
          }
        }
        paramObject = m.vSK;
        if (m.GV(m.HE(this.vSU)))
        {
          j = c.Ht(this.vSU);
          localObject1 = (Iterable)localObject1;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1012:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (!UrlExKt.isMpArticleUrl((String)((ArrayList)localObject2).get(0))) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1012;
              }
              paramObject.add(localObject2);
              break;
            }
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArrayList)((Iterator)localObject1).next();
            localObject3 = (String)((ArrayList)localObject2).get(0);
            localObject4 = m.vSK;
            paramObject.add(new m.d((String)localObject3, m.HC(((Integer)((ArrayList)localObject2).get(1)).intValue())));
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1233:
          label1236:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            localObject4 = (m.d)localObject2;
            localObject3 = ((m.d)localObject4).url;
            i = ((m.d)localObject4).vST;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = m.vSK;
              if (!m.dfx().dH((String)localObject3, i)) {
                break label1233;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1236;
              }
              paramObject.add(localObject2);
              break;
            }
          }
          paramObject = (List)paramObject;
          int k = Math.max(paramObject.size() - j, 0);
          localObject2 = kotlin.a.p.c((Iterable)paramObject, j);
          if (!((Collection)localObject2).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            m.a(m.vSK, (List)localObject2, this.vSU, k);
            if (Log.getLogLevel() == 0)
            {
              paramObject = m.aUw();
              localObject1 = new StringBuilder("preloadData addToPreload toStrip:").append(j).append(" strip:").append(k).append("  dispatch:");
              localObject3 = (Iterable)localObject2;
              localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)localObject2).add(c.ajo(((m.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              Log.v(paramObject, (List)localObject2);
            }
          }
        }
      }
      label1437:
      __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
      paramObject = ah.aiuX;
      AppMethodBeat.o(6657);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.m<m.c, kr, ah>
  {
    f(List<m.d> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<? super Bundle, ? extends ah>>>>
  {
    public static final g vSW;
    
    static
    {
      AppMethodBeat.i(6662);
      vSW = new g();
      AppMethodBeat.o(6662);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.q<WeakReference<Object>, m.c, gb, ah>
  {
    public static final h vSX;
    
    static
    {
      AppMethodBeat.i(6664);
      vSX = new h();
      AppMethodBeat.o(6664);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<m.c, kr, ah>
  {
    i(kotlin.g.a.q<? super WeakReference<Object>, ? super m.c, ? super gb, ah> paramq, WeakReference<Object> paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends HashMap<Integer, String>
  {
    j()
    {
      AppMethodBeat.i(6666);
      put(Integer.valueOf(1), "100463");
      put(Integer.valueOf(3), "100486");
      AppMethodBeat.o(6666);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bundle, ah>
  {
    k(kotlin.g.a.m<? super m.c, ? super kr, ah> paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements MessageQueue.IdleHandler
  {
    l(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.xwebutil.c.jQE();
      m.a(m.vSK, this.vCi);
      m.dfB().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final m vTb;
    
    static
    {
      AppMethodBeat.i(6684);
      vTb = new m();
      AppMethodBeat.o(6684);
    }
    
    m()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.m
 * JD-Core Version:    0.7.0.1
 */