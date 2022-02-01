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
import com.tencent.mm.ah.u;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.bz;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.m;
import d.g.a.m;
import d.g.b.ac;
import d.g.b.p;
import d.z;
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
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.at;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.br;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "isNative", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final String cUu = "com.tencent.mm:toolsmp";
  private static final AtomicBoolean dfX;
  private static final AtomicBoolean opk;
  private static final as opl;
  private static final ap opm;
  private static final l opn;
  private static final HashMap<Integer, Boolean> opo;
  private static final a opp;
  private static final d.f opq;
  private static final boolean opr = false;
  public static final k ops;
  
  static
  {
    AppMethodBeat.i(6685);
    ops = new k();
    TAG = "MicroMsg.PreloadLogic";
    dfX = new AtomicBoolean(false);
    opk = new AtomicBoolean(false);
    cUu = "com.tencent.mm:toolsmp";
    opl = new as(s.bQG());
    opm = new ap("webcached");
    opn = new l();
    opo = new HashMap();
    opp = new a();
    opq = d.g.O((d.g.a.a)g.opw);
    AppMethodBeat.o(6685);
  }
  
  public static void Yi(String paramString)
  {
    AppMethodBeat.i(6710);
    p.h(paramString, "url");
    ae.d(TAG, "removePreload %s", new Object[] { paramString });
    p.h(paramString, "url");
    String str = b.XX(paramString);
    ay localay = (ay)opl.aRy(str);
    if (localay != null)
    {
      localay.removeValueForKey(str);
      localay.removeValueForKey(b.Yd(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void Yj(String paramString)
  {
    AppMethodBeat.i(6715);
    p.h(paramString, "url");
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)n.opE, null);
    AppMethodBeat.o(6715);
  }
  
  public static long Yk(String paramString)
  {
    AppMethodBeat.i(6716);
    p.h(paramString, "url");
    paramString = b.Ye(paramString);
    ay localay = (ay)opl.aRy(paramString);
    if (localay != null)
    {
      long l = localay.getLong(paramString, 0L);
      AppMethodBeat.o(6716);
      return l;
    }
    AppMethodBeat.o(6716);
    return 0L;
  }
  
  private static com.tencent.mm.ak.b.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    jp localjp = new jp();
    localjp.oxI = d.bQb();
    localjp.FUP = s.bQF();
    localjp.FUO = new LinkedList();
    localjp.FUQ = paramInt2;
    localjp.FUR = paramInt3;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).opt;
      localObject3 = new cvu();
      ((cvu)localObject3).Url = ((String)localObject2);
      ((cvu)localObject3).FPk = 0;
      ((cvu)localObject3).Scene = paramInt1;
      localObject2 = opp.Yl((String)localObject2);
      if (localObject2 != null)
      {
        ((cvu)localObject3).FPk = ((fa)localObject2).FPk;
        if (!a((fa)localObject2, paramInt2)) {
          ((cvu)localObject3).FPk = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localjp.FUO.addAll((Collection)localObject1);
    ae.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localjp.FUO.size()) });
    ae.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new com.tencent.mm.ak.b.a();
    paramIterable.oS(2594);
    paramIterable.DN("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.oU(0);
    paramIterable.oV(0);
    paramIterable.c((com.tencent.mm.bw.a)localjp);
    paramIterable.d((com.tencent.mm.bw.a)new jq());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.g.a.ja(paramInt1, localjp.FUO.size());
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
  
  private static void a(Context paramContext, Intent paramIntent, final cmu paramcmu, boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(208839);
    paramString1 = new s(paramBoolean, paramString1, paramcmu);
    paramString2 = new t(paramBoolean, paramString2, paramcmu);
    if (paramcmu.hBV == 5) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.br.d.b(paramContext, paramString1.beJ(), paramString2.beJ(), paramIntent);
    AppMethodBeat.o(208839);
  }
  
  private static void a(Bundle paramBundle, final d.g.a.b<? super Bundle, z> paramb)
  {
    AppMethodBeat.i(6706);
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis() % 100L;
    ArrayList localArrayList = paramBundle.getStringArrayList("urls");
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject1 = localArrayList.get(0);
      p.g(localObject1, "urls[0]");
      localObject1 = b.Yd((String)localObject1);
      if (bQy().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)bQy().get(localObject1);
        if (paramBundle != null) {
          paramBundle.add(paramb);
        }
        ae.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
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
          p.g(localObject2, "urls[i]");
          localObject2 = (String)localObject2;
          Object localObject3 = ((ArrayList)localObject1).get(i);
          p.g(localObject3, "tmplTypes[i]");
          paramBundle.add(new d((String)localObject2, ((Number)localObject3).intValue()));
          localObject2 = localArrayList.get(i);
          p.g(localObject2, "urls[i]");
          localObject2 = b.Yd((String)localObject2);
          ((Map)bQy()).put(localObject2, new ConcurrentLinkedDeque());
          ae.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
        }
        i += 1;
        break;
      }
    }
    com.tencent.mm.ak.x.a(a((Iterable)paramBundle, k, m, n).aDS(), (x.a)new r(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(6706);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    p.h(???, "url");
    p.h(paramVarArgs, "params");
    if (opr)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new ac(3);
    ((ac)localObject1).add(???);
    ((ac)localObject1).add(Integer.valueOf(paramInt1));
    ((ac)localObject1).eR(paramVarArgs);
    localObject1 = d.a.j.ab(((ac)localObject1).toArray(new Object[((ac)localObject1).ddb.size()]));
    paramVarArgs = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (bz.IBe)
    {
      localObject2 = bz.IBe;
      localObject2 = (br)bz.fpX().get(paramVarArgs);
      if (localObject2 != null) {
        ((br)localObject2).gAf();
      }
      localObject2 = bz.IBe;
      localObject2 = bz.fpY();
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
    ??? = bz.IBe;
    ((Map)bz.fpX()).put(paramVarArgs, kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzR(), (m)new e(1000L, paramVarArgs, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private static void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, m<? super c, ? super jq, z> paramm)
  {
    AppMethodBeat.i(6704);
    Bundle localBundle = new Bundle();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).url);
    }
    localBundle.putStringArrayList("urls", new ArrayList((Collection)localObject1));
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).opt));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.g.ajO().ajq();
    p.g(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).akL())
    {
      a(localBundle, (d.g.a.b)new o(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, b.class, (com.tencent.mm.ipcinvoker.d)new p(paramm));
    AppMethodBeat.o(6704);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, cmu paramcmu, boolean paramBoolean1, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(208838);
    dog localdog = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zY(paramcmu.opt);
    if ((localdog == null) && ((paramcmu.hBV == 0) || (paramcmu.hBV == -1)))
    {
      ae.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramcmu + ".tmplType");
      AppMethodBeat.o(208838);
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
      ae.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(i) });
      label222:
      Object localObject;
      if (localdog == null)
      {
        parama = paramcmu.url;
        p.g(parama, "session.url");
        paramIntent.putExtra("rawUrl", UrlExKt.appendStats(a(parama, paramBoolean1, paramIntent), paramcmu));
        paramIntent.putExtra(e.m.JpC, true);
        parama = e.m.Jpq;
        localObject = h.oph;
        paramIntent.putExtra(parama, h.a.bQm());
        paramIntent.putExtra(e.m.Jpr, System.currentTimeMillis());
        paramIntent.putExtra(e.m.Jpt, paramcmu.url);
        localObject = e.m.Jpp;
        if (localdog == null) {
          break label906;
        }
        parama = localdog.toByteArray();
        paramIntent.putExtra((String)localObject, parama);
        paramIntent.putExtra(e.m.JpB, paramcmu.toByteArray());
        paramIntent.putExtra(e.m.Jpy, Process.myPid());
      }
      try
      {
        paramIntent.putExtra(e.m.Jpx, d.c(paramContext, (d.g.a.b)u.opM));
        if (paramBoolean2)
        {
          paramBoolean2 = paramcmu.HyL;
          if (!paramBoolean2) {}
        }
        for (;;)
        {
          try
          {
            p.h(paramIntent, "intent");
            com.tencent.mm.ipcinvoker.a.a(cUu, (Parcelable)paramIntent, (com.tencent.mm.ipcinvoker.b)v.opN, null);
            a(paramContext, paramIntent, paramcmu, paramBoolean1, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
            if (localdog != null)
            {
              com.tencent.mm.plugin.webview.g.a.gi(localdog.reportId, 106);
              com.tencent.mm.plugin.webview.g.a.XA(100);
              if (paramcmu.HyM)
              {
                com.tencent.mm.plugin.webview.g.a.gi(localdog.reportId, 231);
                com.tencent.mm.plugin.webview.g.a.XA(110);
              }
            }
            AppMethodBeat.o(208838);
            return true;
            i = 0;
            break;
            paramcmu.AXc = localdog.AXc;
            com.tencent.mm.plugin.webview.g.a.gi(localdog.reportId, 104);
            localObject = paramcmu.url;
            p.g(localObject, "session.url");
            localObject = cC((String)localObject, paramcmu.opt);
            if (localObject != null)
            {
              String str = ((fa)localObject).FPj;
              if (str != null)
              {
                if (!d.n.n.aD((CharSequence)str))
                {
                  i = 1;
                  if (i != 1) {
                    continue;
                  }
                  if (!((fa)localObject).FPq) {
                    break label953;
                  }
                  paramBoolean1 = false;
                  if ((((fa)localObject).FPq) || (paramcmu.hBV == 0))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra(e.m.Jpv, paramcmu.obQ);
                    localObject = ((fa)localObject).FPj;
                    p.g(localObject, "appMsgContext.ForceUrl");
                    localObject = a(UrlExKt.appendStats((String)localObject, paramcmu), paramBoolean1, paramIntent);
                    ae.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
                    paramIntent.putExtra("rawUrl", (String)localObject);
                    if (paramBoolean2) {
                      a(paramContext, paramIntent, paramcmu, paramBoolean1, "webview", ".ui.tools.WebViewUI");
                    }
                    com.tencent.mm.plugin.webview.g.a.gi(localdog.reportId, 107);
                    parama.success = true;
                    parama.message = "has forceUrl=".concat(String.valueOf(localObject));
                    AppMethodBeat.o(208838);
                    return true;
                  }
                }
                else
                {
                  i = 0;
                  continue;
                }
                paramIntent.putExtra(e.m.JpC, true);
                continue;
              }
            }
            parama = paramcmu.url;
            p.g(parama, "session.url");
            paramcmu.url = a(parama, paramBoolean1, paramIntent);
            paramIntent.putExtra("rawUrl", paramcmu.url);
            paramcmu.HyK = true;
            parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zW(localdog.opt);
            paramcmu.HyM = s.d(parama);
            boolean bool2 = p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
            if ((s.d(parama)) && (bool2))
            {
              bool1 = true;
              paramcmu.HyN = bool1;
              if ((!s.d(parama)) || (bool2)) {
                continue;
              }
              bool1 = true;
              paramcmu.HyO = bool1;
              if ((localObject == null) || (!l.b((fa)localObject))) {
                continue;
              }
              paramcmu.HyL = true;
              ae.i(TAG, "set contentId:%s", new Object[] { b.a((fa)localObject) });
              break label222;
            }
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            parama = paramcmu.url;
            p.g(parama, "session.url");
            a(paramContext, parama, paramcmu, (d.g.a.q)j.opz);
            break label222;
            label906:
            parama = null;
          }
          catch (Throwable parama)
          {
            ae.i(TAG, "updateWebview ex " + parama.getMessage());
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(208838);
        return false;
      }
    }
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(208835);
    p.h(paramContext, "context");
    p.h(paramString, "rawUrl");
    p.h(paramIntent, "intent");
    p.h(parama, "result");
    if (d.n.n.aD((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(208835);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(208835);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = opp.Yl(paramString);
      if (localObject != null) {
        i = ((fa)localObject).hFR;
      }
    }
    for (;;)
    {
      if ((i == 5) && (!com.tencent.mm.pluginsdk.ui.tools.x.fjk())) {}
      int k;
      for (boolean bool1 = true;; bool1 = false)
      {
        k = zK(i);
        if (k != -1) {
          break label193;
        }
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(i));
        AppMethodBeat.o(208835);
        return false;
        i = paramInt1;
        break;
      }
      label193:
      int m = y.getSessionId();
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
      paramIntent.putExtra(e.m.Jpz, i);
      paramIntent.putExtra(e.m.Jpu, m);
      paramIntent.putExtra(e.m.Jpv, j);
      paramIntent.putExtra(e.m.Jpw, paramInt2);
      paramIntent.putExtra(e.m.JpA, paramInt4);
      paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
      localObject = new cmu();
      ((cmu)localObject).id = m;
      ((cmu)localObject).url = paramString;
      ((cmu)localObject).hBV = i;
      ((cmu)localObject).opt = k;
      ((cmu)localObject).obQ = j;
      ((cmu)localObject).otZ = paramInt2;
      ((cmu)localObject).HyJ = paramInt3;
      boolean bool2;
      if (i != paramInt1)
      {
        bool2 = true;
        ((cmu)localObject).ooG = bool2;
        paramBoolean = ops.a(paramContext, paramIntent, (cmu)localObject, bool1, parama, paramBoolean);
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
        com.tencent.mm.plugin.webview.g.a.Xz(paramInt1);
        AppMethodBeat.o(208835);
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
  
  private static boolean a(fa paramfa, int paramInt)
  {
    AppMethodBeat.i(6702);
    dof localdof = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zW(paramInt);
    Object localObject = (CharSequence)paramfa.FPj;
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (s.a(localdof))
    {
      paramfa = paramfa.FPr;
      if (paramfa != null)
      {
        paramfa = ((Iterable)paramfa).iterator();
        while (paramfa.hasNext())
        {
          localObject = (dof)paramfa.next();
          ae.v(TAG, "checkDataVerVaild: " + ((dof)localObject).nJA + ' ' + localdof.nJA + ' ' + ((dof)localObject).HVg + ' ' + localdof.HVg);
          if ((((dof)localObject).nJA == localdof.nJA) && (p.i(((dof)localObject).HVg, localdof.HVg)))
          {
            ae.v(TAG, "checkDataVerVaild: " + ((dof)localObject).Version + " tmplInfo:" + localdof.Version);
            if (((dof)localObject).Version >= localdof.Version)
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
  
  private static void az(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    p.h(paramString, "netType");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)i.opy, null);
    AppMethodBeat.o(6691);
  }
  
  private static void b(List<d> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6703);
    h.a locala = h.oph;
    if (!h.a.bQn())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  public static as bQv()
  {
    return opl;
  }
  
  public static ap bQw()
  {
    return opm;
  }
  
  public static a bQx()
  {
    return opp;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<Bundle, z>>> bQy()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)opq.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  private static void bQz()
  {
    AppMethodBeat.i(6714);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", null, (com.tencent.mm.ipcinvoker.b)h.opx, null);
    AppMethodBeat.o(6714);
  }
  
  private static fa cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (d.n.n.aD((CharSequence)paramString))
    {
      ae.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (opp.cD(paramString, paramInt))
    {
      paramString = opp.Yl(paramString);
      AppMethodBeat.o(6700);
      return paramString;
    }
    AppMethodBeat.o(6700);
    return null;
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    a.bQD();
    ae.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bRh();
    AppMethodBeat.o(6688);
  }
  
  public static final void j(List<? extends List<String>> paramList, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6713);
    p.h(paramList, "items");
    if (opr)
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
      k = zM(paramInt);
      if (k == 0) {
        break label356;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label356;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
      localObject4 = ((List)localObject1).get(2);
      str = com.tencent.mm.compatible.util.q.encode((String)((List)localObject1).get(0));
      localObject5 = a((List)localObject1, 3, "");
      localObject6 = a((List)localObject1, 4, "");
      localObject7 = ((List)localObject1).get(1);
      localObject8 = a((List)localObject1, 5, "");
      localObject9 = a((List)localObject1, 6, "");
      localObject10 = a((List)localObject1, 7, "");
      if (!p.i((String)((List)localObject1).get(1), "-1")) {
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
      ((com.tencent.mm.plugin.report.service.g)localObject3).f(16468, new Object[] { Integer.valueOf(k), localObject4, str, localObject5, localObject6, Integer.valueOf(1), localObject7, localObject8, localObject9, localObject10, Integer.valueOf(i) });
      break label68;
      i = 0;
      break;
      localObject1 = null;
      break label236;
      i = 0;
      break label246;
    }
    label356:
    if (zl(zN(paramInt)))
    {
      k = b.zG(paramInt);
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
      paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        paramList.add(new d((String)((List)localObject2).get(0), zK(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).opt;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (opp.cD((String)localObject4, i))) {}
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
      localObject2 = d.a.j.b((Iterable)paramList, k);
      i = j;
      if (!((Collection)localObject2).isEmpty()) {
        i = 1;
      }
      if (i != 0)
      {
        b((List)localObject2, paramInt, m, 1);
        if (ae.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls toStrip:").append(k).append(" strip:").append(m).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(b.Yd(((d)((Iterator)localObject3).next()).url));
          }
          ae.v(paramList, (List)localObject2);
        }
      }
    }
    label458:
    label868:
    AppMethodBeat.o(6713);
    label672:
  }
  
  public static final void k(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6712);
    p.h(paramList, "items");
    if (opr)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!zl(zN(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = b.zG(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(Long.parseLong(paramList[0]), paramList[1]).hFT;
      if (i > 0) {
        p.g(paramList, "it");
      }
      for (paramList = d.a.j.b((Iterable)paramList, i);; paramList = (List)paramList)
      {
        d.a.j.a((Collection)localObject1, (Iterable)paramList);
        break;
      }
    }
    paramList = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
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
      ((Collection)localObject2).add(new d(paramList, zK(((com.tencent.mm.ah.v)localObject4).type)));
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
      i = ((d)localObject3).opt;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (opp.cD((String)localObject4, i))) {}
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
    localObject2 = d.a.j.b((Iterable)paramList, j);
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      b((List)localObject2, paramInt, k, 1);
      if (ae.getLogLevel() == 0)
      {
        paramList = TAG;
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer toStrip:").append(j).append(" strip:").append(k).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(b.Yd(((d)((Iterator)localObject3).next()).url));
            continue;
            i = 0;
            break;
          }
        }
        ae.v(paramList, (List)localObject2);
      }
    }
    AppMethodBeat.o(6712);
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(6686);
    if (opk.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    opk.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.cp.d.fWU();
      zH(paramInt);
      opk.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new q(paramInt));
    AppMethodBeat.o(6686);
  }
  
  private static void zH(int paramInt)
  {
    AppMethodBeat.i(6687);
    ae.i(TAG, "start in preCreate");
    az(paramInt, d.bQb());
    zJ(-1);
    bQz();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void zI(int paramInt)
  {
    AppMethodBeat.i(6689);
    zJ(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void zJ(int paramInt)
  {
    AppMethodBeat.i(6690);
    h.a locala = h.oph;
    if (!h.a.bQm())
    {
      AppMethodBeat.o(6690);
      return;
    }
    com.tencent.mm.ipcinvoker.a.a(cUu, (Parcelable)new IPCInteger(paramInt), (com.tencent.mm.ipcinvoker.b)m.opD, null);
    AppMethodBeat.o(6690);
  }
  
  private static int zK(int paramInt)
  {
    AppMethodBeat.i(208837);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if ((localb != null) && (localb.zk(paramInt)))
    {
      if (zl(102))
      {
        AppMethodBeat.o(208837);
        return 5;
      }
      AppMethodBeat.o(208837);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(208837);
      return -1;
    case 0: 
      if (zl(102))
      {
        AppMethodBeat.o(208837);
        return 5;
      }
      AppMethodBeat.o(208837);
      return 0;
    }
    if (zl(102))
    {
      AppMethodBeat.o(208837);
      return 5;
    }
    AppMethodBeat.o(208837);
    return 4;
  }
  
  private static int zM(int paramInt)
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
  
  private static int zN(int paramInt)
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
  
  public static final boolean zl(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6699);
    if (paramInt == 102)
    {
      AppMethodBeat.o(6699);
      return false;
    }
    if (opo.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = opo.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gkB();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = h.oph;
    if ((!h.a.bQu()) && ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG)))
    {
      localObject = (Map)opo;
      h.a locala = h.oph;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(i.bGK().getBoolean("preload_use", true)));
      localObject = opo.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gkB();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)opo;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)opo).put(Integer.valueOf(paramInt), Boolean.FALSE);
        ae.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (opo.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = opo.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          p.gkB();
        }
        p.g(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzS, 0) == 0)
        {
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzT, 0) == 0)
          {
            bool = false;
            continue;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzU, 0) & 0x1) == 0) {
              break label852;
            }
            bool = true;
            break;
            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzU, 0) & 0x2) == 0)
            {
              bool = false;
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzU, 0) & 0x4) == 0)
              {
                bool = false;
                continue;
                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzV, 0) & 0x1) == 0)
                {
                  bool = false;
                  continue;
                  if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzV, 0) & 0x2) == 0)
                  {
                    bool = false;
                    continue;
                    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzV, 0) & 0x4) == 0)
                    {
                      bool = false;
                      continue;
                      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzY, 0) == 0)
                      {
                        bool = false;
                        continue;
                        if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzZ, 0) & 0x1) == 0)
                        {
                          bool = false;
                          continue;
                          if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzZ, 0) & 0x2) == 0)
                          {
                            bool = false;
                            continue;
                            if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzZ, 0) & 0x4) == 0)
                            {
                              bool = false;
                              continue;
                              if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzR, 0) == 0)
                              {
                                bool = false;
                                continue;
                                if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAa, 0) & 0x1) == 0)
                                {
                                  bool = false;
                                  continue;
                                  i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAb, 0);
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
  
  public final void a(final Object paramObject, String paramString, cmu paramcmu, final d.g.a.q<? super WeakReference<Object>, ? super c, ? super fa, z> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(208840);
    p.h(paramObject, "context");
    p.h(paramString, "url");
    p.h(paramcmu, "session");
    p.h(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = h.oph;
    if (h.a.bQo())
    {
      ((c)localObject1).drc = true;
      paramq.d(paramObject, localObject1, new fa());
      AppMethodBeat.o(208840);
      return;
    }
    if ((d.n.n.aD((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.d(paramObject, localObject1, new fa());
      AppMethodBeat.o(208840);
      return;
    }
    localObject2 = cC(paramString, paramcmu.opt);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getAppMsgContext ");
    if (localObject2 == null) {
      bool = true;
    }
    ae.d(str, bool);
    if (localObject2 != null)
    {
      ((c)localObject1).drc = true;
      ((c)localObject1).bFZ = true;
      paramq.d(paramObject, localObject1, localObject2);
      AppMethodBeat.o(208840);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramcmu);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramcmu.opt));
    a((List)localObject1, paramcmu.opt, (m)new k(paramString, paramq, paramObject));
    AppMethodBeat.o(208840);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "save", "plugin-brandservice_release"})
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    public static boolean bQD()
    {
      AppMethodBeat.i(6642);
      k localk = k.ops;
      k.bQv().fnO();
      AppMethodBeat.o(6642);
      return true;
    }
    
    private final boolean c(fa paramfa, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (paramfa == null)
      {
        ae.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = k.ops;
      if (!k.b(paramfa, paramInt))
      {
        ae.v(this.TAG, "checkValid: invalid version:data(" + paramfa.FPm + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = h.oph;
      if (h.a.bQp()) {
        ae.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = paramfa.Url;
        p.g(localObject1, "appMsgContext.Url");
        localObject1 = b.Ye((String)localObject1);
        Object localObject2 = k.ops;
        localObject2 = (ay)k.bQv().aRy((String)localObject1);
        if (localObject2 != null) {}
        for (boolean bool = d.a((ay)localObject2, (String)localObject1, paramfa.FPi * 1000L); bool; bool = true)
        {
          ae.i(this.TAG, "checkValid: expire for " + paramfa.FPi);
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public final fa Yl(String paramString)
    {
      AppMethodBeat.i(6639);
      p.h(paramString, "url");
      String str = b.XX(paramString);
      Object localObject1 = k.ops;
      localObject1 = (ay)k.bQv().aRy(str);
      int i;
      if (localObject1 != null) {
        if (((ay)localObject1).containsKey(str))
        {
          localObject1 = ((ay)localObject1).decodeBytes(str);
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
          Object localObject3 = fa.class.newInstance();
          ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject3;
          localObject1 = (fa)localObject1;
          if (localObject1 == null) {
            break label192;
          }
          ((fa)localObject1).Url = paramString;
          ae.i(this.TAG, "found:" + str + " last modify:" + ((fa)localObject1).FPk);
          AppMethodBeat.o(6639);
          return localObject1;
        }
        catch (Exception localException)
        {
          label161:
          ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
      ae.i(this.TAG, "not found:".concat(String.valueOf(str)));
      AppMethodBeat.o(6639);
      return null;
    }
    
    public final void a(String paramString, fa paramfa)
    {
      AppMethodBeat.i(6641);
      p.h(paramString, "url");
      if (paramfa != null)
      {
        localObject1 = (CharSequence)paramfa.hFS;
        if ((localObject1 != null) && (!d.n.n.aD((CharSequence)localObject1))) {
          break label60;
        }
      }
      label60:
      for (int i = 1; i != 0; i = 0)
      {
        ae.e(this.TAG, "save fail, appMsgContext is null");
        AppMethodBeat.o(6641);
        return;
      }
      Object localObject1 = b.XX(paramString);
      Object localObject2 = paramfa.hFS;
      try
      {
        Object localObject3 = new fa();
        ((fa)localObject3).parseFrom(paramfa.toByteArray());
        ((fa)localObject3).hFS = null;
        Object localObject4 = ((fa)localObject3).toByteArray();
        localObject3 = k.ops;
        localObject3 = (ay)k.bQv().fnP();
        ((ay)localObject3).encode((String)localObject1, (byte[])localObject4);
        localObject4 = k.ops;
        localObject4 = b.D(b.a(k.bQw(), b.Yd(paramString)));
        p.g(localObject2, "content");
        Charset localCharset = d.n.d.UTF_8;
        p.h(localObject4, "$this$writeText");
        p.h(localObject2, "text");
        p.h(localCharset, "charset");
        localObject2 = ((String)localObject2).getBytes(localCharset);
        p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.l.b((com.tencent.mm.vfs.k)localObject4, (byte[])localObject2);
        d.b((ay)localObject3, b.Ye(paramString));
        ae.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + paramfa.FPk);
        AppMethodBeat.o(6641);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace(this.TAG, (Throwable)paramString, "save ".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
    }
    
    public final boolean cD(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      p.h(paramString, "url");
      fa localfa = Yl(paramString);
      if (localfa == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      Object localObject = k.ops;
      int i;
      if (localfa != null)
      {
        localObject = Integer.valueOf(localfa.hFR);
        i = k.zL(((Integer)localObject).intValue());
        if (i != -1) {
          break label122;
        }
      }
      for (;;)
      {
        boolean bool = c(localfa, paramInt);
        if (!bool) {
          ae.d(this.TAG, "init invalid:" + b.XX(paramString));
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.b<Bundle, z>
    {
      a(com.tencent.mm.ipcinvoker.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
  public static final class c
  {
    public boolean bFZ;
    public long bpc;
    public boolean drc;
    public boolean ooC;
    public long start;
    
    private c(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.drc = paramBoolean1;
      this.start = paramLong1;
      this.bpc = paramLong2;
      this.ooC = paramBoolean2;
      this.bFZ = false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"})
  static final class d
  {
    final int opt;
    final String url;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.opt = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class e
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    public e(long paramLong, String paramString, d.d.d paramd, int paramInt)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      p.h(paramd, "completion");
      paramd = new e(this.opu, this.kAY, paramd, this.obz);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(6658);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(6657);
      Object localObject1 = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6657);
        throw paramObject;
      case 0: 
        paramObject = this.ocz;
        long l = this.opu;
        this.ocA = paramObject;
        this.label = 1;
        if (at.a(l, this) == localObject1)
        {
          AppMethodBeat.o(6657);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ah)this.ocA;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.Nhr;
        AppMethodBeat.o(6657);
        return paramObject;
      }
      int i;
      Object localObject4;
      Object localObject3;
      for (;;)
      {
        synchronized (bz.IBe)
        {
          paramObject = bz.IBe;
          localObject1 = bz.fpY().get(this.kAY);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = bz.IBe;
            bz.fpY().remove(this.kAY);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break label1647;
            }
            paramObject = (List)paramObject;
            if ((!bv.fpT()) || (ae.getLogLevel() != 0)) {
              break label374;
            }
            if (((Collection)paramObject).isEmpty())
            {
              i = 1;
              if (i != 0) {
                break label374;
              }
              localObject1 = k.ops;
              localObject1 = k.bQA();
              ??? = new StringBuilder("preloadData addToPreload batch:");
              localObject4 = (Iterable)paramObject;
              localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(b.Yd(((ArrayList)((Iterator)localObject4).next()).get(0).toString()));
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
      ae.v((String)localObject1, (List)localObject3);
      label374:
      localObject1 = z.Nhr;
      localObject1 = (Iterable)d.a.j.i((Iterable)paramObject);
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
        if (paramObject.add(b.Yd((String)localObject4))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = k.ops;
        int j = k.zP(this.obz);
        if (j != 0)
        {
          ??? = ((Iterable)localObject1).iterator();
          if (((Iterator)???).hasNext())
          {
            paramObject = (ArrayList)((Iterator)???).next();
            localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
            localObject4 = k.ops;
            localObject4 = k.b((List)paramObject, 2, "");
            Object localObject5 = paramObject.get(0);
            if (localObject5 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject5 = com.tencent.mm.compatible.util.q.encode((String)localObject5);
            Object localObject6 = k.ops;
            localObject6 = k.b((List)paramObject, 3, "");
            Object localObject7 = k.ops;
            localObject7 = k.b((List)paramObject, 4, "");
            Object localObject8 = paramObject.get(1);
            Object localObject9 = k.ops;
            localObject9 = k.b((List)paramObject, 5, "");
            Object localObject10 = k.ops;
            localObject10 = k.b((List)paramObject, 6, "");
            Object localObject11 = k.ops;
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
              ((com.tencent.mm.plugin.report.service.g)localObject3).f(16468, new Object[] { Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7, Integer.valueOf(2), localObject8, localObject9, localObject10, localObject11, Integer.valueOf(i) });
              break;
              paramObject = null;
              break label901;
              i = 0;
              break label910;
            }
          }
        }
        paramObject = k.ops;
        if (k.zl(k.zQ(this.obz)))
        {
          j = b.zG(this.obz);
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
          paramObject = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
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
            localObject4 = k.ops;
            ??? = ((ArrayList)???).get(1);
            if (??? == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            paramObject.add(new k.d((String)localObject3, k.zL(((Integer)???).intValue())));
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
            i = ((k.d)localObject4).opt;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = k.ops;
              if (!k.bQx().cD((String)localObject3, i)) {
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
          localObject1 = z.Nhr;
          ??? = d.a.j.b((Iterable)paramObject, j);
          if (!((Collection)???).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            k.a(k.ops, (List)???, this.obz, k);
            if (ae.getLogLevel() == 0)
            {
              paramObject = k.ops;
              paramObject = k.bQA();
              localObject1 = new StringBuilder("preloadData addToPreload toStrip:").append(j).append(" strip:").append(k).append("  dispatch:");
              localObject3 = (Iterable)???;
              ??? = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)???).add(b.Yd(((k.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              ae.v(paramObject, (List)???);
            }
          }
          paramObject = z.Nhr;
        }
      }
      paramObject = z.Nhr;
      label1647:
      paramObject = bz.IBe;
      bz.fpX().remove(this.kAY);
      paramObject = z.Nhr;
      AppMethodBeat.o(6657);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6659);
      paramObject1 = ((e)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(6659);
      return paramObject1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class f
    extends d.g.b.q
    implements m<k.c, jq, z>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<? super Bundle, ? extends z>>>>
  {
    public static final g opw;
    
    static
    {
      AppMethodBeat.i(6662);
      opw = new g();
      AppMethodBeat.o(6662);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class h<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final h opx;
    
    static
    {
      AppMethodBeat.i(208826);
      opx = new h();
      AppMethodBeat.o(208826);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class i<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {
    public static final i opy;
    
    static
    {
      AppMethodBeat.i(208828);
      opy = new i();
      AppMethodBeat.o(208828);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.q<WeakReference<Object>, k.c, fa, z>
  {
    public static final j opz;
    
    static
    {
      AppMethodBeat.i(6664);
      opz = new j();
      AppMethodBeat.o(6664);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class k
    extends d.g.b.q
    implements m<k.c, jq, z>
  {
    k(String paramString, d.g.a.q paramq, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "tmplType", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class m<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid>
  {
    public static final m opD;
    
    static
    {
      AppMethodBeat.i(208830);
      opD = new m();
      AppMethodBeat.o(208830);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "url", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class n<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final n opE;
    
    static
    {
      AppMethodBeat.i(208832);
      opE = new n();
      AppMethodBeat.o(208832);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.b<Bundle, z>
  {
    o(m paramm)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class p<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    p(m paramm) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class q
    implements MessageQueue.IdleHandler
  {
    q(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.cp.d.fWU();
      k localk = k.ops;
      k.zO(this.obr);
      localk = k.ops;
      k.bQB().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class r
    implements x.a
  {
    r(long paramLong1, long paramLong2, d.g.a.b paramb, ArrayList paramArrayList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(6680);
      paramn = k.ops;
      ae.i(k.bQA(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = new Bundle();
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.g(paramb, "rr");
        if ((paramb.aEV() != null) && ((paramb.aEV() instanceof jq)))
        {
          paramb = paramb.aEV();
          if (paramb == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
            AppMethodBeat.o(6680);
            throw paramString;
          }
          paramb = (jq)paramb;
          paramString.putBoolean("success", true);
          paramString.putByteArray("response", paramb.toByteArray());
          paramn = paramb.FUT;
          p.g(paramn, "response.SceneControlList");
          if (!((Collection)paramn).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramn = s.bQG();
              localObject1 = new cyf();
              ((cyf)localObject1).FUT = paramb.FUT;
              paramn.encode("_msg_scene_strip", ((cyf)localObject1).toByteArray());
            }
          }
        }
      }
      for (;;)
      {
        paramString.putLong("start", this.opF);
        long l = System.currentTimeMillis();
        paramString.putLong("end", l);
        paramb = k.ops;
        ae.v(k.bQA(), "terry performance runCGI #" + paramb + ": " + this.opF + ',' + l);
        this.gll.invoke(paramString);
        paramString.putBoolean("mount", true);
        paramb = this.opH;
        p.g(paramb, "urls");
        paramb = ((Iterable)paramb).iterator();
        while (paramb.hasNext())
        {
          paramn = (String)paramb.next();
          p.g(paramn, "url");
          paramn = b.Yd(paramn);
          localObject1 = k.ops;
          localObject1 = (ConcurrentLinkedDeque)k.bQy().get(paramn);
          Object localObject2 = k.ops;
          k.bQy().remove(paramn);
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (d.g.a.b)((Iterator)localObject1).next();
              paramString.putString("id", paramn);
              ((d.g.a.b)localObject2).invoke(paramString);
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"getNativeService", "", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    s(boolean paramBoolean, String paramString, cmu paramcmu)
    {
      super();
    }
    
    public final String beJ()
    {
      if (this.opI) {}
      switch (paramcmu.hBV)
      {
      default: 
        return paramString1;
      }
      return "brandservice";
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"getNativeActivity", "", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    t(boolean paramBoolean, String paramString, cmu paramcmu)
    {
      super();
    }
    
    public final String beJ()
    {
      if ((this.opI) && (paramcmu.hBV == 5)) {
        return ".ui.timeline.video.BizVideoDetailUI";
      }
      return paramString2;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final u opM;
    
    static
    {
      AppMethodBeat.i(6684);
      opM = new u();
      AppMethodBeat.o(6684);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "intent", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class v<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Intent, IPCVoid>
  {
    public static final v opN;
    
    static
    {
      AppMethodBeat.i(208834);
      opN = new v();
      AppMethodBeat.o(208834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k
 * JD-Core Version:    0.7.0.1
 */