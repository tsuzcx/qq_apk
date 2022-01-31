package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.c.e;
import a.f.a.q;
import a.f.b.t;
import a.f.b.v;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.aw;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "DELAY_TIME", "", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "lastPreloadId", "preloadLimiter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadLimiter;", "getPreloadLimiter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadLimiter;", "preloadUrl", "Ljava/util/Queue;", "", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "Landroid/support/v4/util/Pair;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getServiceAndActivity", "defaultService", "defaultActivity", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "isNative", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "contentId", "appendNativeParams", "getTmplType", "getUrl", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_CheckReport", "IPCInvoke_CheckTmplVer", "IPCInvoke_PreloadWebview", "IPCInvoke_RUN_CGI", "IPCInvoke_Report", "IPCInvoke_UpdateWebview", "MountableCGIResult", "PreloadLimiter", "PreloadSession", "plugin-brandservice_release"})
public final class PreloadLogic
{
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final String bXW = "com.tencent.mm:toolsmp";
  private static final AtomicBoolean chl;
  private static final AtomicBoolean kbA;
  private static final PreloadLogic.o kbB;
  private static final HashMap<Integer, Boolean> kbC;
  private static final PreloadLogic.a kbD;
  private static final a.f kbE;
  private static long kbF;
  private static Queue<List<Object>> kbG;
  private static final boolean kbH = false;
  private static final PreloadLogic.i kbI;
  public static final PreloadLogic kbJ;
  
  static
  {
    AppMethodBeat.i(14913);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(PreloadLogic.class), "cgiCallbackList", "getCgiCallbackList()Ljava/util/concurrent/ConcurrentHashMap;")) };
    kbJ = new PreloadLogic();
    TAG = "MicroMsg.PreloadLogic";
    chl = new AtomicBoolean(false);
    kbA = new AtomicBoolean(false);
    bXW = "com.tencent.mm:toolsmp";
    kbB = new PreloadLogic.o();
    kbC = new HashMap();
    kbD = new PreloadLogic.a();
    kbE = a.g.j((a.f.a.a)PreloadLogic.l.kca);
    kbG = (Queue)new LinkedList();
    kbI = new PreloadLogic.i();
    AppMethodBeat.o(14913);
  }
  
  public static final void GW(String paramString)
  {
    AppMethodBeat.i(14935);
    a.f.b.j.q(paramString, "url");
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", (Parcelable)localBundle, PreloadLogic.f.class, null);
    AppMethodBeat.o(14935);
  }
  
  private static int O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156346);
    if ((paramBoolean) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rT(paramInt)))
    {
      if (rU(102))
      {
        AppMethodBeat.o(156346);
        return 5;
      }
      AppMethodBeat.o(156346);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(156346);
      return -1;
    }
    if (rU(102))
    {
      AppMethodBeat.o(156346);
      return 5;
    }
    AppMethodBeat.o(156346);
    return 0;
  }
  
  private static com.tencent.mm.ai.b.a a(Iterable<? extends android.support.v4.e.j<String, Integer>> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14930);
    id localid = new id();
    localid.wuH = d.aXm();
    localid.wuI = o.aXN();
    localid.wuG = new LinkedList();
    localid.wuJ = paramInt2;
    localid.wuK = paramInt3;
    Object localObject = (Collection)new ArrayList(a.a.j.d(paramIterable));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      android.support.v4.e.j localj = (android.support.v4.e.j)localIterator.next();
      bux localbux = new bux();
      localbux.Url = a(localj);
      localbux.wqj = 0;
      localbux.Scene = paramInt1;
      eh localeh = kbD.GX(a(localj));
      if (localeh != null)
      {
        localbux.wqj = localeh.wqj;
        if (!a(localeh, b(localj))) {
          localbux.wqj = 0;
        }
      }
      ((Collection)localObject).add(localbux);
    }
    localObject = (List)localObject;
    localid.wuG.addAll((Collection)localObject);
    ab.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localid.wuG.size()) });
    ab.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new com.tencent.mm.ai.b.a();
    paramIterable.kT(2594);
    paramIterable.rl("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.kU(0);
    paramIterable.kV(0);
    paramIterable.a((com.tencent.mm.bv.a)localid);
    paramIterable.b((com.tencent.mm.bv.a)new ie());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.preload.a.gL(paramInt1, localid.wuG.size());
      AppMethodBeat.o(14930);
      return paramIterable;
      paramInt1 = 34;
      continue;
      paramInt1 = 35;
    }
  }
  
  private static String a(android.support.v4.e.j<String, Integer> paramj)
  {
    AppMethodBeat.i(14936);
    paramj = paramj.first;
    if (paramj == null) {
      a.f.b.j.ebi();
    }
    paramj = (String)paramj;
    AppMethodBeat.o(14936);
    return paramj;
  }
  
  private static String a(String paramString, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(152695);
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramIntent.putExtra("bizEnterId", i);
    if (paramBoolean) {}
    for (paramIntent = p.I(p.I(paramString, "isNativePage", "1"), "enterid", String.valueOf(i));; paramIntent = paramString)
    {
      Object localObject = paramIntent;
      if (!a.l.m.a((CharSequence)paramString, (CharSequence)"clicktime", false)) {
        localObject = p.I(paramIntent, "clicktime", String.valueOf(i));
      }
      AppMethodBeat.o(152695);
      return localObject;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, PreloadLogic.PreloadSession paramPreloadSession, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152697);
    paramString1 = new PreloadLogic.v(paramBoolean, paramString1, paramPreloadSession);
    paramString2 = new PreloadLogic.w(paramBoolean, paramString2, paramPreloadSession);
    paramString1 = paramString1.aXs();
    paramString2 = paramString2.aXs();
    switch (paramPreloadSession.fgh)
    {
    }
    for (;;)
    {
      com.tencent.mm.bq.d.b(paramContext, paramString1, paramString2, paramIntent);
      AppMethodBeat.o(152697);
      return;
      paramIntent.putExtra("webview_bg_color_rsID", 2131689763);
    }
  }
  
  private static void a(Bundle paramBundle, a.f.a.b<? super Bundle, y> paramb)
  {
    AppMethodBeat.i(14928);
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis() % 100L;
    ArrayList localArrayList = paramBundle.getStringArrayList("urls");
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject1 = localArrayList.get(0);
      a.f.b.j.p(localObject1, "urls[0]");
      localObject1 = b.GR((String)localObject1);
      if (aXD().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)aXD().get(localObject1);
        if (paramBundle != null) {
          paramBundle.add(paramb);
        }
        ab.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
        AppMethodBeat.o(14928);
        return;
      }
    }
    Object localObject1 = paramBundle.getIntegerArrayList("tmplTypes");
    int j = paramBundle.getInt("openScene");
    int k = paramBundle.getInt("strip", 0);
    int m = paramBundle.getInt("stripType", 0);
    paramBundle = new LinkedList();
    int n = localArrayList.size();
    int i = 0;
    while (i < n)
    {
      paramBundle.add(new android.support.v4.e.j(localArrayList.get(i), ((ArrayList)localObject1).get(i)));
      Object localObject2 = localArrayList.get(i);
      a.f.b.j.p(localObject2, "urls[i]");
      localObject2 = b.GR((String)localObject2);
      ((Map)aXD()).put(localObject2, new ConcurrentLinkedDeque());
      ab.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
      i += 1;
    }
    w.a(a((Iterable)paramBundle, j, k, m).ado(), (w.a)new PreloadLogic.u(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(14928);
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(152700);
    a.f.b.j.q(paramString, "url");
    a.f.b.j.q(paramVarArgs, "params");
    if (kbH)
    {
      AppMethodBeat.o(152700);
      return;
    }
    long l = System.currentTimeMillis();
    kotlinx.coroutines.f.a((ac)aw.CIf, (e)ao.epI(), (a.f.a.m)new PreloadLogic.j(l, paramString, paramInt1, paramVarArgs, paramInt2, null));
    AppMethodBeat.o(152700);
  }
  
  private static void a(List<? extends android.support.v4.e.j<String, Integer>> paramList, int paramInt1, int paramInt2, int paramInt3, a.f.a.m<? super PreloadLogic.h, ? super ie, y> paramm)
  {
    AppMethodBeat.i(14926);
    Bundle localBundle = new Bundle();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(a((android.support.v4.e.j)((Iterator)localObject2).next()));
    }
    localBundle.putStringArrayList("urls", new ArrayList((Collection)localObject1));
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(Integer.valueOf(b((android.support.v4.e.j)((Iterator)localObject1).next())));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.g.RI().Rj();
    a.f.b.j.p(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).SD())
    {
      a(localBundle, (a.f.a.b)new PreloadLogic.r(paramm));
      AppMethodBeat.o(14926);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", (Parcelable)localBundle, PreloadLogic.e.class, (c)new s(paramm));
    AppMethodBeat.o(14926);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, PreloadLogic.PreloadSession paramPreloadSession, boolean paramBoolean1, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(152696);
    TmplParams localTmplParams = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sw(paramPreloadSession.kbM);
    if ((localTmplParams == null) && (paramPreloadSession.fgh == 0))
    {
      ab.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramPreloadSession + ".tmplType");
      AppMethodBeat.o(152696);
      return false;
    }
    boolean bool1 = WXHardCoderJNI.hcBizEnable;
    int j = WXHardCoderJNI.hcBizDelay;
    int k = WXHardCoderJNI.hcBizCPU;
    int m = WXHardCoderJNI.hcBizIO;
    if (WXHardCoderJNI.hcBizThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, TAG);
      ab.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(i) });
      if (localTmplParams != null) {
        break;
      }
      paramIntent.putExtra("rawUrl", p.a(a(paramPreloadSession.url, paramBoolean1, paramIntent), paramPreloadSession));
      paramIntent.putExtra(e.l.yVw, true);
      parama = e.l.yVk;
      Object localObject = g.kbz;
      paramIntent.putExtra(parama, g.a.aXt());
      paramIntent.putExtra(e.l.yVl, System.currentTimeMillis());
      paramIntent.putExtra(e.l.yVn, paramPreloadSession.url);
      paramIntent.putExtra(e.l.yVj, (Parcelable)localTmplParams);
      paramIntent.putExtra(e.l.yVv, (Parcelable)paramPreloadSession);
      paramIntent.putExtra(e.l.yVs, Process.myPid());
      try
      {
        paramIntent.putExtra(e.l.yVr, d.a(paramContext, (a.f.a.b)PreloadLogic.x.kco));
        if (paramBoolean2) {
          a(paramContext, paramIntent, paramPreloadSession, paramBoolean1, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
        }
        if (localTmplParams != null)
        {
          com.tencent.mm.plugin.webview.preload.a.gK(localTmplParams.uYL, 106);
          com.tencent.mm.plugin.webview.preload.a.JZ(100);
          if (paramPreloadSession.kbS)
          {
            com.tencent.mm.plugin.webview.preload.a.gK(localTmplParams.uYL, 231);
            com.tencent.mm.plugin.webview.preload.a.JZ(110);
          }
        }
        AppMethodBeat.o(152696);
        return true;
      }
      catch (Exception paramContext)
      {
        String str;
        AppMethodBeat.o(152696);
        return false;
      }
    }
    localObject = localTmplParams.kbP;
    a.f.b.j.p(localObject, "tmplParams.uid");
    a.f.b.j.q(localObject, "<set-?>");
    paramPreloadSession.kbP = ((String)localObject);
    com.tencent.mm.plugin.webview.preload.a.gK(localTmplParams.uYL, 104);
    localObject = bL(paramPreloadSession.url, paramPreloadSession.kbM);
    if (localObject != null)
    {
      str = ((eh)localObject).wqi;
      if (str != null) {
        if (!a.l.m.ap((CharSequence)str))
        {
          i = 1;
          if (i != 1) {
            break label632;
          }
          if (!((eh)localObject).wqq) {
            break label950;
          }
          paramBoolean1 = false;
        }
      }
    }
    label916:
    label922:
    label950:
    for (;;)
    {
      if ((((eh)localObject).wqq) || (paramPreloadSession.fgh == 0)) {
        paramIntent = new Intent();
      }
      for (;;)
      {
        localObject = ((eh)localObject).wqi;
        a.f.b.j.p(localObject, "appMsgContext.ForceUrl");
        localObject = a(p.a((String)localObject, paramPreloadSession), paramBoolean1, paramIntent);
        ab.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
        paramIntent.putExtra("rawUrl", (String)localObject);
        if (paramBoolean2) {
          a(paramContext, paramIntent, paramPreloadSession, paramBoolean1, "webview", ".ui.tools.WebViewUI");
        }
        com.tencent.mm.plugin.webview.preload.a.gK(localTmplParams.uYL, 107);
        parama.success = true;
        parama.message = "has forceUrl=".concat(String.valueOf(localObject));
        AppMethodBeat.o(152696);
        return true;
        i = 0;
        break;
        paramIntent.putExtra(e.l.yVw, true);
      }
      label632:
      parama = a(paramPreloadSession.url, paramBoolean1, paramIntent);
      a.f.b.j.q(parama, "<set-?>");
      paramPreloadSession.url = parama;
      paramIntent.putExtra("rawUrl", paramPreloadSession.url);
      paramPreloadSession.kbQ = true;
      parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.su(localTmplParams.kbM);
      paramPreloadSession.kbS = o.d(parama);
      boolean bool2 = a.f.b.j.e(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
      if ((o.d(parama)) && (bool2))
      {
        bool1 = true;
        label721:
        paramPreloadSession.kbT = bool1;
        if ((!o.d(parama)) || (bool2)) {
          break label916;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramPreloadSession.kbU = bool1;
        if ((localObject == null) || (!b.b((eh)localObject))) {
          break label922;
        }
        paramPreloadSession.kbR = true;
        i = paramPreloadSession.kbM;
        parama = b.a((eh)localObject);
        str = paramIntent.getStringExtra("rawUrl");
        a.f.b.j.p(str, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
        str = p.a(str, paramPreloadSession);
        a.f.b.j.q(parama, "contentId");
        a.f.b.j.q(str, "url");
        Bundle localBundle = new Bundle();
        localBundle.putInt("tmplType", i);
        localBundle.putString("contentId", parama);
        localBundle.putString("url", str);
        localBundle.putLong("startLoadPage", System.currentTimeMillis());
        com.tencent.mm.ipcinvoker.f.a(bXW, (Parcelable)localBundle, PreloadLogic.g.class, null);
        ab.i(TAG, "set contentId:%s", new Object[] { b.a((eh)localObject) });
        break;
        bool1 = false;
        break label721;
      }
      a(paramContext, paramPreloadSession.url, paramPreloadSession, (q)PreloadLogic.m.kcb);
      break;
    }
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(152692);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramString, "rawUrl");
    a.f.b.j.q(paramIntent, "intent");
    a.f.b.j.q(parama, "result");
    if (a.l.m.ap((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(152692);
      return false;
    }
    if (!p.GI(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(152692);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = kbD.GX(paramString);
      if (localObject != null) {
        i = ((eh)localObject).wqp;
      }
    }
    for (int j = i;; j = paramInt1)
    {
      int k = O(j, paramBoolean1);
      if (k == -1)
      {
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(j));
        AppMethodBeat.o(152692);
        return false;
        i = paramInt1;
        break;
      }
      int m = s.getSessionId();
      boolean bool;
      if (paramInt2 == 90)
      {
        paramString = p.I(p.I(paramString, "scene", String.valueOf(paramInt2)), "subscene", String.valueOf(paramInt3));
        paramIntent.putExtra(e.l.yVt, j);
        paramIntent.putExtra(e.l.yVo, m);
        paramIntent.putExtra(e.l.yVp, paramInt2);
        paramIntent.putExtra(e.l.yVq, paramInt3);
        paramIntent.putExtra(e.l.yVu, paramInt4);
        paramString = new PreloadLogic.PreloadSession(m, paramString, paramInt1, k, paramInt2, paramInt3, paramIntent.getIntExtra("geta8key_scene", 0));
        if (j == paramInt1) {
          break label536;
        }
        bool = true;
        label304:
        paramString.kaV = bool;
        paramBoolean1 = kbJ.a(paramContext, paramIntent, paramString, paramBoolean1, parama, paramBoolean2);
        if (paramBoolean1)
        {
          if ((paramInt4 != -1) && ((paramContext instanceof MMActivity)) && (paramInt4 == 1)) {
            ((MMActivity)paramContext).overridePendingTransition(2131034230, 2131034229);
          }
          switch (paramInt2)
          {
          default: 
            paramInt1 = -1;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.preload.a.JY(paramInt1);
        AppMethodBeat.o(152692);
        return paramBoolean1;
        localObject = p.dj(paramString, "scene");
        i = paramInt2;
        CharSequence localCharSequence;
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          i = paramInt2;
          if (new a.l.k("\\d+").ao(localCharSequence)) {
            i = Integer.parseInt((String)localObject);
          }
        }
        localObject = p.dj(paramString, "subscene");
        if (localObject != null)
        {
          localCharSequence = (CharSequence)localObject;
          if (new a.l.k("\\d+").ao(localCharSequence)) {
            paramInt3 = Integer.parseInt((String)localObject);
          }
          paramInt2 = i;
          break;
        }
        paramInt2 = i;
        break;
        label536:
        bool = false;
        break label304;
        paramInt1 = 0;
        continue;
        paramInt1 = 1;
        continue;
        paramInt1 = 2;
        continue;
        paramInt1 = 3;
      }
    }
  }
  
  private static boolean a(eh parameh, int paramInt)
  {
    AppMethodBeat.i(152699);
    ckj localckj = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.su(paramInt);
    Object localObject = (CharSequence)parameh.wqi;
    if ((localObject == null) || (a.l.m.ap((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(152699);
      return true;
    }
    if (o.a(localckj))
    {
      parameh = parameh.wqr;
      if (parameh != null)
      {
        parameh = ((Iterable)parameh).iterator();
        while (parameh.hasNext())
        {
          localObject = (ckj)parameh.next();
          if ((((ckj)localObject).jKs == localckj.jKs) && (a.f.b.j.e(((ckj)localObject).xUp, localckj.xUp)))
          {
            if (((ckj)localObject).Version >= localckj.Version)
            {
              AppMethodBeat.o(152699);
              return true;
            }
            AppMethodBeat.o(152699);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(152699);
    return false;
  }
  
  public static PreloadLogic.a aXC()
  {
    return kbD;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<a.f.a.b<Bundle, y>>> aXD()
  {
    AppMethodBeat.i(14929);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)kbE.getValue();
    AppMethodBeat.o(14929);
    return localConcurrentHashMap;
  }
  
  public static PreloadLogic.i aXE()
  {
    return kbI;
  }
  
  private static void aXF()
  {
    AppMethodBeat.i(14934);
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, PreloadLogic.b.class, null);
    AppMethodBeat.o(14934);
  }
  
  private static void aj(int paramInt, String paramString)
  {
    AppMethodBeat.i(14919);
    a.f.b.j.q(paramString, "netType");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", (Parcelable)localBundle, PreloadLogic.c.class, null);
    AppMethodBeat.o(14919);
  }
  
  private static int b(android.support.v4.e.j<String, Integer> paramj)
  {
    AppMethodBeat.i(14937);
    paramj = paramj.second;
    if (paramj == null) {
      a.f.b.j.ebi();
    }
    int i = ((Number)paramj).intValue();
    AppMethodBeat.o(14937);
    return i;
  }
  
  private static eh bL(String paramString, int paramInt)
  {
    AppMethodBeat.i(14924);
    a.f.b.j.q(paramString, "url");
    if (a.l.m.ap((CharSequence)paramString))
    {
      ab.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(14924);
      return null;
    }
    if (kbD.bM(paramString, paramInt))
    {
      paramString = kbD.GX(paramString);
      AppMethodBeat.o(14924);
      return paramString;
    }
    AppMethodBeat.o(14924);
    return null;
  }
  
  private static void clear()
  {
    AppMethodBeat.i(14916);
    b.aXe();
    ab.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.aXQ();
    AppMethodBeat.o(14916);
  }
  
  public static final void i(List<? extends List<String>> paramList, int paramInt)
  {
    AppMethodBeat.i(14933);
    a.f.b.j.q(paramList, "items");
    if (kbH)
    {
      AppMethodBeat.o(14933);
      return;
    }
    kbF = 0L;
    kbG.clear();
    kotlinx.coroutines.f.a((ac)aw.CIf, (e)ao.epI(), (a.f.a.m)new PreloadLogic.p(paramList, paramInt, null));
    AppMethodBeat.o(14933);
  }
  
  public static final void j(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(14932);
    a.f.b.j.q(paramList, "items");
    if (kbH)
    {
      AppMethodBeat.o(14932);
      return;
    }
    if (!rU(sn(paramInt)))
    {
      AppMethodBeat.o(14932);
      return;
    }
    kbF = 0L;
    kbG.clear();
    kotlinx.coroutines.f.a((ac)aw.CIf, (e)ao.epI(), (a.f.a.m)new PreloadLogic.q(paramInt, paramList, null));
    AppMethodBeat.o(14932);
  }
  
  public static final boolean rU(int paramInt)
  {
    AppMethodBeat.i(14923);
    if (paramInt == 102)
    {
      AppMethodBeat.o(14923);
      return false;
    }
    boolean bool;
    if (kbC.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = kbC.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        a.f.b.j.ebi();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(14923);
      return bool;
    }
    Object localObject = g.kbz;
    if ((!g.a.aXB()) && ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG)))
    {
      localObject = (Map)kbC;
      g.a locala = g.kbz;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(h.aSs().getBoolean("preload_use", true)));
      localObject = kbC.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        a.f.b.j.ebi();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(14923);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)kbC;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)kbC).put(Integer.valueOf(paramInt), Boolean.FALSE);
        ab.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(14923);
        return false;
      }
      if (kbC.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = kbC.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          a.f.b.j.ebi();
        }
        a.f.b.j.p(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(14923);
        return bool;
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTZ, 0) != 0)
        {
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUa, 0) == 0) {
            break label855;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUb, 0) & 0x1) == 0) {
            break label860;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUb, 0) & 0x2) == 0) {
            break label865;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUb, 0) & 0x4) == 0) {
            break label870;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUc, 0) & 0x1) == 0) {
            break label875;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUc, 0) & 0x2) == 0) {
            break label880;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUc, 0) & 0x4) == 0) {
            break label885;
          }
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUf, 0) == 0) {
            break label890;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUg, 0) & 0x1) == 0) {
            break label895;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUg, 0) & 0x2) == 0) {
            break label900;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUg, 0) & 0x4) == 0) {
            break label905;
          }
          bool = true;
          continue;
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTY, 0) == 0) {
            break label910;
          }
          bool = true;
          continue;
          if ((((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUh, 0) & 0x1) == 0) {
            break label915;
          }
          bool = true;
          continue;
          i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUi, 0);
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
      label855:
      bool = false;
      continue;
      label860:
      bool = false;
      continue;
      label865:
      bool = false;
      continue;
      label870:
      bool = false;
      continue;
      label875:
      bool = false;
      continue;
      label880:
      bool = false;
      continue;
      label885:
      bool = false;
      continue;
      label890:
      bool = false;
      continue;
      label895:
      bool = false;
      continue;
      label900:
      bool = false;
      continue;
      label905:
      bool = false;
      continue;
      label910:
      bool = false;
      continue;
      label915:
      bool = false;
    }
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(14914);
    if (kbA.get())
    {
      AppMethodBeat.o(14914);
      return;
    }
    if (paramInt == 10000)
    {
      com.tencent.mm.cn.d.aNX();
      sj(paramInt);
      kbA.set(false);
      AppMethodBeat.o(14914);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new PreloadLogic.t(paramInt));
    AppMethodBeat.o(14914);
  }
  
  private static void sj(int paramInt)
  {
    AppMethodBeat.i(152689);
    ab.i(TAG, "start in preCreate");
    aj(paramInt, d.aXm());
    sl(-1);
    aXF();
    clear();
    AppMethodBeat.o(152689);
  }
  
  public static final void sk(int paramInt)
  {
    AppMethodBeat.i(152690);
    sl(paramInt);
    AppMethodBeat.o(152690);
  }
  
  private static void sl(int paramInt)
  {
    AppMethodBeat.i(152691);
    g.a locala = g.kbz;
    if (!g.a.aXt())
    {
      AppMethodBeat.o(152691);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a(bXW, (Parcelable)new IPCInteger(paramInt), PreloadLogic.d.class, null);
    AppMethodBeat.o(152691);
  }
  
  private static int sn(int paramInt)
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
  
  public final void a(Object paramObject, String paramString, PreloadLogic.PreloadSession paramPreloadSession, q<? super WeakReference<Object>, ? super PreloadLogic.h, ? super eh, y> paramq)
  {
    AppMethodBeat.i(14925);
    a.f.b.j.q(paramObject, "context");
    a.f.b.j.q(paramString, "url");
    a.f.b.j.q(paramPreloadSession, "session");
    a.f.b.j.q(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new PreloadLogic.h(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = g.kbz;
    if (g.a.aXv())
    {
      ((PreloadLogic.h)localObject1).csk = true;
      paramq.d(paramObject, localObject1, new eh());
      AppMethodBeat.o(14925);
      return;
    }
    if ((a.l.m.ap((CharSequence)paramString)) || (!p.GI(paramString)))
    {
      paramq.d(paramObject, localObject1, new eh());
      AppMethodBeat.o(14925);
      return;
    }
    localObject2 = bL(paramString, paramPreloadSession.kbM);
    if (localObject2 != null)
    {
      ((PreloadLogic.h)localObject1).csk = true;
      ((PreloadLogic.h)localObject1).aZZ = true;
      paramq.d(paramObject, localObject1, localObject2);
      AppMethodBeat.o(14925);
      return;
    }
    paramString = p.a(paramString, paramPreloadSession);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new android.support.v4.e.j(paramString, Integer.valueOf(paramPreloadSession.kbM)));
    a((List)localObject1, paramPreloadSession.kbM, (a.f.a.m)new PreloadLogic.n(paramString, paramq, paramObject));
    AppMethodBeat.o(14925);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class s<T>
    implements c<ResultType>
  {
    s(a.f.a.m paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic
 * JD-Core Version:    0.7.0.1
 */