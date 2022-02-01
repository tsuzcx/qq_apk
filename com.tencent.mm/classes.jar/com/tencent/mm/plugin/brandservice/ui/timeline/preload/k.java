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
import com.tencent.mm.ak.x.a;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.vfs.e;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.b.w;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.as;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;
import kotlinx.coroutines.bo;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "isNative", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final String cIB = "com.tencent.mm:toolsmp";
  private static final AtomicBoolean cTF;
  private static final AtomicBoolean nGH;
  private static final aq nGI;
  private static final an nGJ;
  private static final l nGK;
  private static final HashMap<Integer, Boolean> nGL;
  private static final a nGM;
  private static final d.f nGN;
  private static final boolean nGO = false;
  public static final k nGP;
  
  static
  {
    AppMethodBeat.i(6685);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(k.class), "cgiCallbackList", "getCgiCallbackList()Ljava/util/concurrent/ConcurrentHashMap;")) };
    nGP = new k();
    TAG = "MicroMsg.PreloadLogic";
    cTF = new AtomicBoolean(false);
    nGH = new AtomicBoolean(false);
    cIB = "com.tencent.mm:toolsmp";
    nGI = new aq(s.bLh());
    nGJ = new an("webcached");
    nGK = new l();
    nGL = new HashMap();
    nGM = new a();
    nGN = d.g.K((d.g.a.a)g.nGT);
    AppMethodBeat.o(6685);
  }
  
  public static void TN(String paramString)
  {
    AppMethodBeat.i(6710);
    d.g.b.k.h(paramString, "url");
    ac.d(TAG, "removePreload %s", new Object[] { paramString });
    d.g.b.k.h(paramString, "url");
    String str = b.TD(paramString);
    aw localaw = (aw)nGI.aKv(str);
    if (localaw != null)
    {
      localaw.removeValueForKey(str);
      localaw.removeValueForKey(b.TJ(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void TO(String paramString)
  {
    AppMethodBeat.i(6715);
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)n.nHb, null);
    AppMethodBeat.o(6715);
  }
  
  public static long TP(String paramString)
  {
    AppMethodBeat.i(6716);
    d.g.b.k.h(paramString, "url");
    paramString = b.TK(paramString);
    aw localaw = (aw)nGI.aKv(paramString);
    if (localaw != null)
    {
      long l = localaw.getLong(paramString, 0L);
      AppMethodBeat.o(6716);
      return l;
    }
    AppMethodBeat.o(6716);
    return 0L;
  }
  
  private static com.tencent.mm.ak.b.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    jg localjg = new jg();
    localjg.nOG = d.bKC();
    localjg.DWY = s.bLg();
    localjg.DWX = new LinkedList();
    localjg.DWZ = paramInt2;
    localjg.DXa = paramInt3;
    Object localObject1 = (Collection)new ArrayList(j.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).nGQ;
      localObject3 = new cpv();
      ((cpv)localObject3).Url = ((String)localObject2);
      ((cpv)localObject3).DRu = 0;
      ((cpv)localObject3).Scene = paramInt1;
      localObject2 = nGM.TQ((String)localObject2);
      if (localObject2 != null)
      {
        ((cpv)localObject3).DRu = ((ew)localObject2).DRu;
        if (!a((ew)localObject2, paramInt2)) {
          ((cpv)localObject3).DRu = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localjg.DWX.addAll((Collection)localObject1);
    ac.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localjg.DWX.size()) });
    ac.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new com.tencent.mm.ak.b.a();
    paramIterable.op(2594);
    paramIterable.Am("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.or(0);
    paramIterable.os(0);
    paramIterable.c((com.tencent.mm.bw.a)localjg);
    paramIterable.d((com.tencent.mm.bw.a)new jh());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.g.a.iJ(paramInt1, localjg.DWX.size());
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
      if (!d.n.n.a((CharSequence)paramString, (CharSequence)"clicktime", false)) {
        paramIntent = UrlExKt.appendUrlParam((String)localObject, "clicktime", String.valueOf(i));
      }
      localObject = paramIntent;
      if (!d.n.n.a((CharSequence)paramString, (CharSequence)"enterid", false)) {
        localObject = UrlExKt.appendUrlParam(paramIntent, "enterid", String.valueOf(i));
      }
      AppMethodBeat.o(6696);
      return localObject;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, final chb paramchb, boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(198898);
    paramString1 = new s(paramBoolean, paramString1, paramchb);
    paramString2 = new t(paramBoolean, paramString2, paramchb);
    if (paramchb.hgY == 5) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.br.d.b(paramContext, paramString1.baD(), paramString2.baD(), paramIntent);
    AppMethodBeat.o(198898);
  }
  
  private static void a(Bundle paramBundle, final d.g.a.b<? super Bundle, d.y> paramb)
  {
    AppMethodBeat.i(6706);
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis() % 100L;
    ArrayList localArrayList = paramBundle.getStringArrayList("urls");
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject1 = localArrayList.get(0);
      d.g.b.k.g(localObject1, "urls[0]");
      localObject1 = b.TJ((String)localObject1);
      if (bKZ().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)bKZ().get(localObject1);
        if (paramBundle != null) {
          paramBundle.add(paramb);
        }
        ac.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
        AppMethodBeat.o(6706);
        return;
      }
    }
    Object localObject1 = paramBundle.getIntegerArrayList("tmplTypes");
    int k = paramBundle.getInt("openScene");
    int m = paramBundle.getInt("strip", 0);
    int n = paramBundle.getInt("stripType", 0);
    paramBundle = new LinkedList();
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
          d.g.b.k.g(localObject2, "urls[i]");
          localObject2 = (String)localObject2;
          Object localObject3 = ((ArrayList)localObject1).get(i);
          d.g.b.k.g(localObject3, "tmplTypes[i]");
          paramBundle.add(new d((String)localObject2, ((Number)localObject3).intValue()));
          localObject2 = localArrayList.get(i);
          d.g.b.k.g(localObject2, "urls[i]");
          localObject2 = b.TJ((String)localObject2);
          ((Map)bKZ()).put(localObject2, new ConcurrentLinkedDeque());
          ac.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
        }
        i += 1;
        break;
      }
    }
    com.tencent.mm.ak.x.a(a((Iterable)paramBundle, k, m, n).aAz(), (x.a)new r(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(6706);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    d.g.b.k.h(???, "url");
    d.g.b.k.h(paramVarArgs, "params");
    if (nGO)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new d.g.b.y(3);
    ((d.g.b.y)localObject1).add(???);
    ((d.g.b.y)localObject1).add(Integer.valueOf(paramInt1));
    ((d.g.b.y)localObject1).eL(paramVarArgs);
    localObject1 = j.ab(((d.g.b.y)localObject1).toArray(new Object[((d.g.b.y)localObject1).cQJ.size()]));
    paramVarArgs = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (bx.GuY)
    {
      localObject2 = bx.GuY;
      localObject2 = (bo)bx.eWs().get(paramVarArgs);
      if (localObject2 != null) {
        ((bo)localObject2).ged();
      }
      localObject2 = bx.GuY;
      localObject2 = bx.eWt();
      if (!((HashMap)localObject2).containsKey(paramVarArgs)) {
        ((Map)localObject2).put(paramVarArgs, new LinkedList());
      }
      localObject2 = ((HashMap)localObject2).get(paramVarArgs);
      if (localObject2 == null)
      {
        paramVarArgs = new d.v("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(6711);
        throw paramVarArgs;
      }
    }
    ((LinkedList)localObject2).add(localObject1);
    ??? = bx.GuY;
    ((Map)bx.eWs()).put(paramVarArgs, kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (m)new e(1000L, paramVarArgs, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private static void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, m<? super c, ? super jh, d.y> paramm)
  {
    AppMethodBeat.i(6704);
    Bundle localBundle = new Bundle();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).url);
    }
    localBundle.putStringArrayList("urls", new ArrayList((Collection)localObject1));
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).nGQ));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.g.agO().agp();
    d.g.b.k.g(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).ahL())
    {
      a(localBundle, (d.g.a.b)new o(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, b.class, (com.tencent.mm.ipcinvoker.d)new p(paramm));
    AppMethodBeat.o(6704);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, chb paramchb, boolean paramBoolean1, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(198897);
    dhu localdhu = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zf(paramchb.nGQ);
    if ((localdhu == null) && ((paramchb.hgY == 0) || (paramchb.hgY == -1)))
    {
      ac.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramchb + ".tmplType");
      AppMethodBeat.o(198897);
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
      ac.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(i) });
      label222:
      Object localObject;
      if (localdhu == null)
      {
        parama = paramchb.url;
        d.g.b.k.g(parama, "session.url");
        paramIntent.putExtra("rawUrl", UrlExKt.appendStats(a(parama, paramBoolean1, paramIntent), paramchb));
        paramIntent.putExtra(e.m.HhE, true);
        parama = e.m.Hhs;
        localObject = h.nGE;
        paramIntent.putExtra(parama, h.a.bKN());
        paramIntent.putExtra(e.m.Hht, System.currentTimeMillis());
        paramIntent.putExtra(e.m.Hhv, paramchb.url);
        localObject = e.m.Hhr;
        if (localdhu == null) {
          break label906;
        }
        parama = localdhu.toByteArray();
        paramIntent.putExtra((String)localObject, parama);
        paramIntent.putExtra(e.m.HhD, paramchb.toByteArray());
        paramIntent.putExtra(e.m.HhA, Process.myPid());
      }
      try
      {
        paramIntent.putExtra(e.m.Hhz, d.b(paramContext, (d.g.a.b)u.nHj));
        if (paramBoolean2)
        {
          paramBoolean2 = paramchb.Fvg;
          if (!paramBoolean2) {}
        }
        for (;;)
        {
          try
          {
            d.g.b.k.h(paramIntent, "intent");
            com.tencent.mm.ipcinvoker.a.a(cIB, (Parcelable)paramIntent, (com.tencent.mm.ipcinvoker.b)v.nHk, null);
            a(paramContext, paramIntent, paramchb, paramBoolean1, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
            if (localdhu != null)
            {
              com.tencent.mm.plugin.webview.g.a.fS(localdhu.reportId, 106);
              com.tencent.mm.plugin.webview.g.a.Ve(100);
              if (paramchb.Fvh)
              {
                com.tencent.mm.plugin.webview.g.a.fS(localdhu.reportId, 231);
                com.tencent.mm.plugin.webview.g.a.Ve(110);
              }
            }
            AppMethodBeat.o(198897);
            return true;
            i = 0;
            break;
            paramchb.znF = localdhu.znF;
            com.tencent.mm.plugin.webview.g.a.fS(localdhu.reportId, 104);
            localObject = paramchb.url;
            d.g.b.k.g(localObject, "session.url");
            localObject = cv((String)localObject, paramchb.nGQ);
            if (localObject != null)
            {
              String str = ((ew)localObject).DRt;
              if (str != null)
              {
                if (!d.n.n.aD((CharSequence)str))
                {
                  i = 1;
                  if (i != 1) {
                    continue;
                  }
                  if (!((ew)localObject).DRA) {
                    break label953;
                  }
                  paramBoolean1 = false;
                  if ((((ew)localObject).DRA) || (paramchb.hgY == 0))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra(e.m.Hhx, paramchb.nuJ);
                    localObject = ((ew)localObject).DRt;
                    d.g.b.k.g(localObject, "appMsgContext.ForceUrl");
                    localObject = a(UrlExKt.appendStats((String)localObject, paramchb), paramBoolean1, paramIntent);
                    ac.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
                    paramIntent.putExtra("rawUrl", (String)localObject);
                    if (paramBoolean2) {
                      a(paramContext, paramIntent, paramchb, paramBoolean1, "webview", ".ui.tools.WebViewUI");
                    }
                    com.tencent.mm.plugin.webview.g.a.fS(localdhu.reportId, 107);
                    parama.success = true;
                    parama.message = "has forceUrl=".concat(String.valueOf(localObject));
                    AppMethodBeat.o(198897);
                    return true;
                  }
                }
                else
                {
                  i = 0;
                  continue;
                }
                paramIntent.putExtra(e.m.HhE, true);
                continue;
              }
            }
            parama = paramchb.url;
            d.g.b.k.g(parama, "session.url");
            paramchb.url = a(parama, paramBoolean1, paramIntent);
            paramIntent.putExtra("rawUrl", paramchb.url);
            paramchb.Fvf = true;
            parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zd(localdhu.nGQ);
            paramchb.Fvh = s.d(parama);
            boolean bool2 = d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
            if ((s.d(parama)) && (bool2))
            {
              bool1 = true;
              paramchb.Fvi = bool1;
              if ((!s.d(parama)) || (bool2)) {
                continue;
              }
              bool1 = true;
              paramchb.Fvj = bool1;
              if ((localObject == null) || (!l.b((ew)localObject))) {
                continue;
              }
              paramchb.Fvg = true;
              ac.i(TAG, "set contentId:%s", new Object[] { b.a((ew)localObject) });
              break label222;
            }
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            parama = paramchb.url;
            d.g.b.k.g(parama, "session.url");
            a(paramContext, parama, paramchb, (q)j.nGW);
            break label222;
            label906:
            parama = null;
          }
          catch (Throwable parama)
          {
            ac.i(TAG, "updateWebview ex " + parama.getMessage());
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(198897);
        return false;
      }
    }
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(198894);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "rawUrl");
    d.g.b.k.h(paramIntent, "intent");
    d.g.b.k.h(parama, "result");
    if (d.n.n.aD((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(198894);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(198894);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = nGM.TQ(paramString);
      if (localObject != null) {
        i = ((ew)localObject).hkQ;
      }
    }
    for (;;)
    {
      if ((i == 5) && (!com.tencent.mm.pluginsdk.ui.tools.x.eQs())) {}
      int k;
      for (boolean bool1 = true;; bool1 = false)
      {
        k = yR(i);
        if (k != -1) {
          break label193;
        }
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(i));
        AppMethodBeat.o(198894);
        return false;
        i = paramInt1;
        break;
      }
      label193:
      int m = com.tencent.mm.storage.v.getSessionId();
      localObject = UrlExKt.getUrlParam(paramString, "scene");
      int j = paramInt2;
      CharSequence localCharSequence;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        j = paramInt2;
        if (new d.n.k("\\d+").aB(localCharSequence)) {
          j = Integer.parseInt((String)localObject);
        }
      }
      localObject = UrlExKt.getUrlParam(paramString, "subscene");
      paramInt2 = paramInt3;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        paramInt2 = paramInt3;
        if (new d.n.k("\\d+").aB(localCharSequence)) {
          paramInt2 = Integer.parseInt((String)localObject);
        }
      }
      paramIntent.putExtra(e.m.HhB, i);
      paramIntent.putExtra(e.m.Hhw, m);
      paramIntent.putExtra(e.m.Hhx, j);
      paramIntent.putExtra(e.m.Hhy, paramInt2);
      paramIntent.putExtra(e.m.HhC, paramInt4);
      paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
      localObject = new chb();
      ((chb)localObject).id = m;
      ((chb)localObject).url = paramString;
      ((chb)localObject).hgY = i;
      ((chb)localObject).nGQ = k;
      ((chb)localObject).nuJ = j;
      ((chb)localObject).nLC = paramInt2;
      ((chb)localObject).Fve = paramInt3;
      boolean bool2;
      if (i != paramInt1)
      {
        bool2 = true;
        ((chb)localObject).nGd = bool2;
        paramBoolean = nGP.a(paramContext, paramIntent, (chb)localObject, bool1, parama, paramBoolean);
        if (paramBoolean)
        {
          if ((paramInt4 != -1) && ((paramContext instanceof MMActivity)) && (paramInt4 == 1)) {
            ((MMActivity)paramContext).overridePendingTransition(2130772108, 2130772107);
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
        com.tencent.mm.plugin.webview.g.a.Vd(paramInt1);
        AppMethodBeat.o(198894);
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
  
  private static boolean a(ew paramew, int paramInt)
  {
    AppMethodBeat.i(6702);
    dht localdht = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zd(paramInt);
    Object localObject = (CharSequence)paramew.DRt;
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (s.a(localdht))
    {
      paramew = paramew.DRB;
      if (paramew != null)
      {
        paramew = ((Iterable)paramew).iterator();
        while (paramew.hasNext())
        {
          localObject = (dht)paramew.next();
          ac.v(TAG, "checkDataVerVaild: " + ((dht)localObject).ndI + ' ' + localdht.ndI + ' ' + ((dht)localObject).FQN + ' ' + localdht.FQN);
          if ((((dht)localObject).ndI == localdht.ndI) && (d.g.b.k.g(((dht)localObject).FQN, localdht.FQN)))
          {
            ac.v(TAG, "checkDataVerVaild: " + ((dht)localObject).Version + " tmplInfo:" + localdht.Version);
            if (((dht)localObject).Version >= localdht.Version)
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
  
  private static void ax(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    d.g.b.k.h(paramString, "netType");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)i.nGV, null);
    AppMethodBeat.o(6691);
  }
  
  private static void b(List<d> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6703);
    h.a locala = h.nGE;
    if (!h.a.bKO())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  public static aq bKW()
  {
    return nGI;
  }
  
  public static an bKX()
  {
    return nGJ;
  }
  
  public static a bKY()
  {
    return nGM;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<Bundle, d.y>>> bKZ()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)nGN.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  private static void bLa()
  {
    AppMethodBeat.i(6714);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", null, (com.tencent.mm.ipcinvoker.b)h.nGU, null);
    AppMethodBeat.o(6714);
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    a.bLe();
    ac.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bLF();
    AppMethodBeat.o(6688);
  }
  
  private static ew cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (d.n.n.aD((CharSequence)paramString))
    {
      ac.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (nGM.cw(paramString, paramInt))
    {
      paramString = nGM.TQ(paramString);
      AppMethodBeat.o(6700);
      return paramString;
    }
    AppMethodBeat.o(6700);
    return null;
  }
  
  public static final void i(List<? extends List<String>> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6713);
    d.g.b.k.h(paramList, "items");
    if (nGO)
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
      k = yT(paramInt);
      if (k == 0) {
        break label356;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label356;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
      localObject4 = ((List)localObject1).get(2);
      str = p.encode((String)((List)localObject1).get(0));
      localObject5 = a((List)localObject1, 3, "");
      localObject6 = a((List)localObject1, 4, "");
      localObject7 = ((List)localObject1).get(1);
      localObject8 = a((List)localObject1, 5, "");
      localObject9 = a((List)localObject1, 6, "");
      localObject10 = a((List)localObject1, 7, "");
      if (!d.g.b.k.g((String)((List)localObject1).get(1), "-1")) {
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
      ((com.tencent.mm.plugin.report.service.h)localObject3).f(16468, new Object[] { Integer.valueOf(k), localObject4, str, localObject5, localObject6, Integer.valueOf(1), localObject7, localObject8, localObject9, localObject10, Integer.valueOf(i) });
      break label68;
      i = 0;
      break;
      localObject1 = null;
      break label236;
      i = 0;
      break label246;
    }
    label356:
    if (ys(yU(paramInt)))
    {
      k = b.yN(paramInt);
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
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        paramList.add(new d((String)((List)localObject2).get(0), yR(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).nGQ;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (nGM.cw((String)localObject4, i))) {}
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
      localObject2 = j.b((Iterable)paramList, k);
      i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        b((List)localObject2, paramInt, m, 1);
        if (ac.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls toStrip:").append(k).append(" strip:").append(m).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(b.TJ(((d)((Iterator)localObject3).next()).url));
          }
          ac.v(paramList, (List)localObject2);
        }
      }
    }
    label458:
    label868:
    AppMethodBeat.o(6713);
    label672:
  }
  
  public static final void j(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6712);
    d.g.b.k.h(paramList, "items");
    if (nGO)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!ys(yU(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = b.yN(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(Long.parseLong(paramList[0]), paramList[1]).hkS;
      if (i > 0) {
        d.g.b.k.g(paramList, "it");
      }
      for (paramList = j.b((Iterable)paramList, i);; paramList = (List)paramList)
      {
        j.a((Collection)localObject1, (Iterable)paramList);
        break;
      }
    }
    paramList = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.ah.v)((Iterator)localObject3).next();
      localObject1 = ((com.tencent.mm.ah.v)localObject4).url;
      paramList = (List<String[]>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(new d(paramList, yR(((com.tencent.mm.ah.v)localObject4).type)));
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
      i = ((d)localObject3).nGQ;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (nGM.cw((String)localObject4, i))) {}
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
    localObject2 = j.b((Iterable)paramList, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      b((List)localObject2, paramInt, k, 1);
      if (ac.getLogLevel() == 0)
      {
        paramList = TAG;
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer toStrip:").append(j).append(" strip:").append(k).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(b.TJ(((d)((Iterator)localObject3).next()).url));
            continue;
            i = 0;
            break;
          }
        }
        ac.v(paramList, (List)localObject2);
      }
    }
    AppMethodBeat.o(6712);
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(6686);
    if (nGH.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    nGH.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.cq.d.fBf();
      yO(paramInt);
      nGH.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new q(paramInt));
    AppMethodBeat.o(6686);
  }
  
  private static void yO(int paramInt)
  {
    AppMethodBeat.i(6687);
    ac.i(TAG, "start in preCreate");
    ax(paramInt, d.bKC());
    yQ(-1);
    bLa();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void yP(int paramInt)
  {
    AppMethodBeat.i(6689);
    yQ(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void yQ(int paramInt)
  {
    AppMethodBeat.i(6690);
    h.a locala = h.nGE;
    if (!h.a.bKN())
    {
      AppMethodBeat.o(6690);
      return;
    }
    com.tencent.mm.ipcinvoker.a.a(cIB, (Parcelable)new IPCInteger(paramInt), (com.tencent.mm.ipcinvoker.b)m.nHa, null);
    AppMethodBeat.o(6690);
  }
  
  private static int yR(int paramInt)
  {
    AppMethodBeat.i(198896);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if ((localb != null) && (localb.yr(paramInt)))
    {
      if (ys(102))
      {
        AppMethodBeat.o(198896);
        return 5;
      }
      AppMethodBeat.o(198896);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(198896);
      return -1;
    case 0: 
      if (ys(102))
      {
        AppMethodBeat.o(198896);
        return 5;
      }
      AppMethodBeat.o(198896);
      return 0;
    }
    if (ys(102))
    {
      AppMethodBeat.o(198896);
      return 5;
    }
    AppMethodBeat.o(198896);
    return 4;
  }
  
  private static int yT(int paramInt)
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
  
  private static int yU(int paramInt)
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
  
  public static final boolean ys(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6699);
    if (paramInt == 102)
    {
      AppMethodBeat.o(6699);
      return false;
    }
    if (nGL.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = nGL.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = h.nGE;
    if ((!h.a.bKV()) && ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)))
    {
      localObject = (Map)nGL;
      h.a locala = h.nGE;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(i.bBL().getBoolean("preload_use", true)));
      localObject = nGL.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)nGL;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)nGL).put(Integer.valueOf(paramInt), Boolean.FALSE);
        ac.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (nGL.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = nGL.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        d.g.b.k.g(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPe, 0) == 0)
        {
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPf, 0) == 0)
          {
            bool = false;
            continue;
            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPg, 0) & 0x1) == 0) {
              break label852;
            }
            bool = true;
            break;
            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPg, 0) & 0x2) == 0)
            {
              bool = false;
              continue;
              if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPg, 0) & 0x4) == 0)
              {
                bool = false;
                continue;
                if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPh, 0) & 0x1) == 0)
                {
                  bool = false;
                  continue;
                  if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPh, 0) & 0x2) == 0)
                  {
                    bool = false;
                    continue;
                    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPh, 0) & 0x4) == 0)
                    {
                      bool = false;
                      continue;
                      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPk, 0) == 0)
                      {
                        bool = false;
                        continue;
                        if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPl, 0) & 0x1) == 0)
                        {
                          bool = false;
                          continue;
                          if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPl, 0) & 0x2) == 0)
                          {
                            bool = false;
                            continue;
                            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPl, 0) & 0x4) == 0)
                            {
                              bool = false;
                              continue;
                              if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPd, 0) == 0)
                              {
                                bool = false;
                                continue;
                                if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPm, 0) & 0x1) == 0)
                                {
                                  bool = false;
                                  continue;
                                  i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPn, 0);
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
      label852:
      bool = false;
    }
  }
  
  public final void a(final Object paramObject, String paramString, chb paramchb, final q<? super WeakReference<Object>, ? super c, ? super ew, d.y> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(198899);
    d.g.b.k.h(paramObject, "context");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramchb, "session");
    d.g.b.k.h(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = h.nGE;
    if (h.a.bKP())
    {
      ((c)localObject1).deB = true;
      paramq.d(paramObject, localObject1, new ew());
      AppMethodBeat.o(198899);
      return;
    }
    if ((d.n.n.aD((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.d(paramObject, localObject1, new ew());
      AppMethodBeat.o(198899);
      return;
    }
    localObject2 = cv(paramString, paramchb.nGQ);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getAppMsgContext ");
    if (localObject2 == null) {
      bool = true;
    }
    ac.d(str, bool);
    if (localObject2 != null)
    {
      ((c)localObject1).deB = true;
      ((c)localObject1).bvL = true;
      paramq.d(paramObject, localObject1, localObject2);
      AppMethodBeat.o(198899);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramchb);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramchb.nGQ));
    a((List)localObject1, paramchb.nGQ, (m)new k(paramString, paramq, paramObject));
    AppMethodBeat.o(198899);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "save", "plugin-brandservice_release"})
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    public static boolean bLe()
    {
      AppMethodBeat.i(6642);
      k localk = k.nGP;
      k.bKW().eUq();
      AppMethodBeat.o(6642);
      return true;
    }
    
    private final boolean c(ew paramew, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (paramew == null)
      {
        ac.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = k.nGP;
      if (!k.b(paramew, paramInt))
      {
        ac.v(this.TAG, "checkValid: invalid version:data(" + paramew.DRw + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = h.nGE;
      if (h.a.bKQ()) {
        ac.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = paramew.Url;
        d.g.b.k.g(localObject1, "appMsgContext.Url");
        localObject1 = b.TK((String)localObject1);
        Object localObject2 = k.nGP;
        localObject2 = (aw)k.bKW().aKv((String)localObject1);
        if (localObject2 != null) {}
        for (boolean bool = d.a((aw)localObject2, (String)localObject1, paramew.DRs * 1000L); bool; bool = true)
        {
          ac.i(this.TAG, "checkValid: expire for " + paramew.DRs);
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public final ew TQ(String paramString)
    {
      AppMethodBeat.i(6639);
      d.g.b.k.h(paramString, "url");
      String str = b.TD(paramString);
      Object localObject1 = k.nGP;
      localObject1 = (aw)k.bKW().aKv(str);
      int i;
      if (localObject1 != null) {
        if (((aw)localObject1).containsKey(str))
        {
          localObject1 = ((aw)localObject1).decodeBytes(str);
          if (localObject1 != null) {
            if (localObject1.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label161;
              }
              i = 1;
              label71:
              if (i == 0) {
                break label182;
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          Object localObject3 = ew.class.newInstance();
          ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject3;
          localObject1 = (ew)localObject1;
          if (localObject1 == null) {
            break label192;
          }
          ((ew)localObject1).Url = paramString;
          ac.i(this.TAG, "found:" + str + " last modify:" + ((ew)localObject1).DRu);
          AppMethodBeat.o(6639);
          return localObject1;
        }
        catch (Exception localException)
        {
          label161:
          ac.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break;
        i = 0;
        break label71;
        label182:
        Object localObject2 = null;
        continue;
        localObject2 = null;
      }
      label192:
      ac.i(this.TAG, "not found:".concat(String.valueOf(str)));
      AppMethodBeat.o(6639);
      return null;
    }
    
    public final void a(String paramString, ew paramew)
    {
      AppMethodBeat.i(6641);
      d.g.b.k.h(paramString, "url");
      if (paramew != null)
      {
        localObject1 = (CharSequence)paramew.hkR;
        if ((localObject1 != null) && (!d.n.n.aD((CharSequence)localObject1))) {
          break label60;
        }
      }
      label60:
      for (int i = 1; i != 0; i = 0)
      {
        ac.e(this.TAG, "save fail, appMsgContext is null");
        AppMethodBeat.o(6641);
        return;
      }
      Object localObject1 = b.TD(paramString);
      Object localObject2 = paramew.hkR;
      try
      {
        Object localObject3 = new ew();
        ((ew)localObject3).parseFrom(paramew.toByteArray());
        ((ew)localObject3).hkR = null;
        Object localObject4 = ((ew)localObject3).toByteArray();
        localObject3 = k.nGP;
        localObject3 = (aw)k.bKW().eUr();
        ((aw)localObject3).encode((String)localObject1, (byte[])localObject4);
        localObject4 = k.nGP;
        localObject4 = b.D(b.a(k.bKX(), b.TJ(paramString)));
        d.g.b.k.g(localObject2, "content");
        Charset localCharset = d.n.d.UTF_8;
        d.g.b.k.h(localObject4, "$this$writeText");
        d.g.b.k.h(localObject2, "text");
        d.g.b.k.h(localCharset, "charset");
        localObject2 = ((String)localObject2).getBytes(localCharset);
        d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.f.b((e)localObject4, (byte[])localObject2);
        d.b((aw)localObject3, b.TK(paramString));
        ac.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + paramew.DRu);
        AppMethodBeat.o(6641);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace(this.TAG, (Throwable)paramString, "save ".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
    }
    
    public final boolean cw(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      d.g.b.k.h(paramString, "url");
      ew localew = TQ(paramString);
      if (localew == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      Object localObject = k.nGP;
      int i;
      if (localew != null)
      {
        localObject = Integer.valueOf(localew.hkQ);
        i = k.yS(((Integer)localObject).intValue());
        if (i != -1) {
          break label122;
        }
      }
      for (;;)
      {
        boolean bool = c(localew, paramInt);
        if (!bool) {
          ac.d(this.TAG, "init invalid:" + b.TD(paramString));
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Bundle, d.y>
    {
      a(com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
  public static final class c
  {
    public long beH;
    public boolean bvL;
    public boolean deB;
    public boolean nFZ;
    public long start;
    
    private c(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.deB = paramBoolean1;
      this.start = paramLong1;
      this.beH = paramLong2;
      this.nFZ = paramBoolean2;
      this.bvL = false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"})
  static final class d
  {
    final int nGQ;
    final String url;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.nGQ = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class e
    extends d.d.b.a.i
    implements m<ag, d.d.d<? super d.y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    public e(long paramLong, String paramString, d.d.d paramd, int paramInt)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      d.g.b.k.h(paramd, "completion");
      paramd = new e(this.nGR, this.kdj, paramd, this.nuv);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(6658);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(6657);
      Object localObject1 = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6657);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
        long l = this.nGR;
        this.nvt = paramObject;
        this.label = 1;
        if (as.b(l, this) == localObject1)
        {
          AppMethodBeat.o(6657);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ag)this.nvt;
      }
      if (!ah.a(paramObject))
      {
        paramObject = d.y.KTp;
        AppMethodBeat.o(6657);
        return paramObject;
      }
      int i;
      Object localObject4;
      Object localObject3;
      for (;;)
      {
        synchronized (bx.GuY)
        {
          paramObject = bx.GuY;
          localObject1 = bx.eWt().get(this.kdj);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = bx.GuY;
            bx.eWt().remove(this.kdj);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break label1647;
            }
            paramObject = (List)paramObject;
            if ((!bt.eWo()) || (ac.getLogLevel() != 0)) {
              break label374;
            }
            if (((Collection)paramObject).isEmpty())
            {
              i = 1;
              if (i != 0) {
                break label374;
              }
              localObject1 = k.nGP;
              localObject1 = k.bLb();
              ??? = new StringBuilder("preloadData addToPreload batch:");
              localObject4 = (Iterable)paramObject;
              localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(b.TJ(((ArrayList)((Iterator)localObject4).next()).get(0).toString()));
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
      ac.v((String)localObject1, (List)localObject3);
      label374:
      localObject1 = d.y.KTp;
      localObject1 = (Iterable)j.i((Iterable)paramObject);
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label475:
      while (((Iterator)localObject1).hasNext())
      {
        ??? = ((Iterator)localObject1).next();
        localObject3 = (ArrayList)???;
        if ((localObject3 != null) && ((((ArrayList)localObject3).get(0) instanceof String))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label475;
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
          paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(6657);
          throw paramObject;
        }
        if (paramObject.add(b.TJ((String)localObject4))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = k.nGP;
        int j = k.yW(this.nuv);
        if (j != 0)
        {
          ??? = ((Iterable)localObject1).iterator();
          if (((Iterator)???).hasNext())
          {
            paramObject = (ArrayList)((Iterator)???).next();
            localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
            localObject4 = k.nGP;
            localObject4 = k.b((List)paramObject, 2, "");
            Object localObject5 = paramObject.get(0);
            if (localObject5 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject5 = p.encode((String)localObject5);
            Object localObject6 = k.nGP;
            localObject6 = k.b((List)paramObject, 3, "");
            Object localObject7 = k.nGP;
            localObject7 = k.b((List)paramObject, 4, "");
            Object localObject8 = paramObject.get(1);
            Object localObject9 = k.nGP;
            localObject9 = k.b((List)paramObject, 5, "");
            Object localObject10 = k.nGP;
            localObject10 = k.b((List)paramObject, 6, "");
            Object localObject11 = k.nGP;
            localObject11 = k.b((List)paramObject, 7, "");
            Object localObject12 = paramObject.get(1);
            if (localObject12 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            if (((Integer)localObject12).intValue() == -1)
            {
              paramObject = paramObject.get(0);
              if (paramObject == null)
              {
                paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(6657);
                throw paramObject;
              }
              paramObject = (String)paramObject;
              if (paramObject != null)
              {
                paramObject = Boolean.valueOf(UrlExKt.isMpArticleUrl(paramObject));
                label901:
                if (!paramObject.booleanValue()) {
                  break label1003;
                }
                i = 1;
                label910:
                if (i == 0) {
                  break label1008;
                }
              }
            }
            label1003:
            label1008:
            for (i = 1;; i = 0)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject3).f(16468, new Object[] { Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7, Integer.valueOf(2), localObject8, localObject9, localObject10, localObject11, Integer.valueOf(i) });
              break;
              paramObject = null;
              break label901;
              i = 0;
              break label910;
            }
          }
        }
        paramObject = k.nGP;
        if (k.ys(k.yX(this.nuv)))
        {
          j = b.yN(this.nuv);
          localObject1 = (Iterable)localObject1;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1150:
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((Iterator)localObject1).next();
            localObject3 = ((ArrayList)???).get(0);
            if (localObject3 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            if (!UrlExKt.isMpArticleUrl((String)localObject3)) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1150;
              }
              paramObject.add(???);
              break;
            }
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (ArrayList)((Iterator)localObject1).next();
            localObject3 = ((ArrayList)???).get(0);
            if (localObject3 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject3 = (String)localObject3;
            localObject4 = k.nGP;
            ??? = ((ArrayList)???).get(1);
            if (??? == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            paramObject.add(new k.d((String)localObject3, k.yS(((Integer)???).intValue())));
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1426:
          label1429:
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((Iterator)localObject1).next();
            localObject4 = (k.d)???;
            localObject3 = ((k.d)localObject4).url;
            i = ((k.d)localObject4).nGQ;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = k.nGP;
              if (!k.bKY().cw((String)localObject3, i)) {
                break label1426;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1429;
              }
              paramObject.add(???);
              break;
            }
          }
          paramObject = (List)paramObject;
          int k = Math.max(paramObject.size() - j, 0);
          localObject1 = d.y.KTp;
          ??? = j.b((Iterable)paramObject, j);
          if (!((Collection)???).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            k.a(k.nGP, (List)???, this.nuv, k);
            if (ac.getLogLevel() == 0)
            {
              paramObject = k.nGP;
              paramObject = k.bLb();
              localObject1 = new StringBuilder("preloadData addToPreload toStrip:").append(j).append(" strip:").append(k).append("  dispatch:");
              localObject3 = (Iterable)???;
              ??? = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)???).add(b.TJ(((k.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              ac.v(paramObject, (List)???);
            }
          }
          paramObject = d.y.KTp;
        }
      }
      paramObject = d.y.KTp;
      label1647:
      paramObject = bx.GuY;
      bx.eWs().remove(this.kdj);
      paramObject = d.y.KTp;
      AppMethodBeat.o(6657);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6659);
      paramObject1 = ((e)a(paramObject1, (d.d.d)paramObject2)).cO(d.y.KTp);
      AppMethodBeat.o(6659);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements m<k.c, jh, d.y>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<? super Bundle, ? extends d.y>>>>
  {
    public static final g nGT;
    
    static
    {
      AppMethodBeat.i(6662);
      nGT = new g();
      AppMethodBeat.o(6662);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class h<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final h nGU;
    
    static
    {
      AppMethodBeat.i(198885);
      nGU = new h();
      AppMethodBeat.o(198885);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class i<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {
    public static final i nGV;
    
    static
    {
      AppMethodBeat.i(198887);
      nGV = new i();
      AppMethodBeat.o(198887);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class j
    extends d.g.b.l
    implements q<WeakReference<Object>, k.c, ew, d.y>
  {
    public static final j nGW;
    
    static
    {
      AppMethodBeat.i(6664);
      nGW = new j();
      AppMethodBeat.o(6664);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class k
    extends d.g.b.l
    implements m<k.c, jh, d.y>
  {
    k(String paramString, q paramq, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "tmplType", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class m<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid>
  {
    public static final m nHa;
    
    static
    {
      AppMethodBeat.i(198889);
      nHa = new m();
      AppMethodBeat.o(198889);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "url", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class n<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final n nHb;
    
    static
    {
      AppMethodBeat.i(198891);
      nHb = new n();
      AppMethodBeat.o(198891);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<Bundle, d.y>
  {
    o(m paramm)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class p<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    p(m paramm) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class q
    implements MessageQueue.IdleHandler
  {
    q(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.cq.d.fBf();
      k localk = k.nGP;
      k.yV(this.nur);
      localk = k.nGP;
      k.bLc().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class r
    implements x.a
  {
    r(long paramLong1, long paramLong2, d.g.a.b paramb, ArrayList paramArrayList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(6680);
      paramn = k.nGP;
      ac.i(k.bLb(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = new Bundle();
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        d.g.b.k.g(paramb, "rr");
        if ((paramb.aBD() != null) && ((paramb.aBD() instanceof jh)))
        {
          paramb = paramb.aBD();
          if (paramb == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
            AppMethodBeat.o(6680);
            throw paramString;
          }
          paramb = (jh)paramb;
          paramString.putBoolean("success", true);
          paramString.putByteArray("response", paramb.toByteArray());
          paramn = paramb.DXc;
          d.g.b.k.g(paramn, "response.SceneControlList");
          if (!((Collection)paramn).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramn = s.bLh();
              localObject1 = new cse();
              ((cse)localObject1).DXc = paramb.DXc;
              paramn.encode("_msg_scene_strip", ((cse)localObject1).toByteArray());
            }
          }
        }
      }
      for (;;)
      {
        paramString.putLong("start", this.nHc);
        long l = System.currentTimeMillis();
        paramString.putLong("end", l);
        paramb = k.nGP;
        ac.v(k.bLb(), "terry performance runCGI #" + paramb + ": " + this.nHc + ',' + l);
        this.fPt.ay(paramString);
        paramString.putBoolean("mount", true);
        paramb = this.nHe;
        d.g.b.k.g(paramb, "urls");
        paramb = ((Iterable)paramb).iterator();
        while (paramb.hasNext())
        {
          paramn = (String)paramb.next();
          d.g.b.k.g(paramn, "url");
          paramn = b.TJ(paramn);
          localObject1 = k.nGP;
          localObject1 = (ConcurrentLinkedDeque)k.bKZ().get(paramn);
          Object localObject2 = k.nGP;
          k.bKZ().remove(paramn);
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (d.g.a.b)((Iterator)localObject1).next();
              paramString.putString("id", paramn);
              ((d.g.a.b)localObject2).ay(paramString);
            }
          }
        }
        paramInt1 = 0;
        break;
        paramString.putBoolean("success", false);
      }
      AppMethodBeat.o(6680);
      return 0;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getNativeService", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    s(boolean paramBoolean, String paramString, chb paramchb)
    {
      super();
    }
    
    public final String baD()
    {
      if (this.nHf) {}
      switch (paramchb.hgY)
      {
      default: 
        return paramString1;
      }
      return "brandservice";
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getNativeActivity", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    t(boolean paramBoolean, String paramString, chb paramchb)
    {
      super();
    }
    
    public final String baD()
    {
      if ((this.nHf) && (paramchb.hgY == 5)) {
        return ".ui.timeline.video.BizVideoDetailUI";
      }
      return paramString2;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final u nHj;
    
    static
    {
      AppMethodBeat.i(6684);
      nHj = new u();
      AppMethodBeat.o(6684);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "intent", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class v<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Intent, IPCVoid>
  {
    public static final v nHk;
    
    static
    {
      AppMethodBeat.i(198893);
      nHk = new v();
      AppMethodBeat.o(198893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k
 * JD-Core Version:    0.7.0.1
 */