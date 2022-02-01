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
import com.tencent.mm.al.x.a;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.vfs.e;
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
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bj;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "POS_BIZ_ID", "", "POS_CHAT_NAME", "POS_CHAT_TYPE", "POS_CREATE_TIME", "POS_ITEM_SHOW_TYPE", "POS_SENDER", "POS_SESSION_ID", "POS_URL", "PROCESS_NAME", "", "TAG", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "infoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInfoManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "mpContentManager", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "getMpContentManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "stopPreload", "addToPreload", "url", "itemShowType", "openScene", "params", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "strip", "stripType", "canPreloadIn", "checkDataVerVaild", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getDataCacheTime", "", "getTmplVersion", "obtainTmplType", "bizTimeLineType", "isNative", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "removePreload", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "saveAppMsgContext", "data", "", "startActivity", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "defaultService", "defaultActivity", "startPreloadWebView", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "appendNativeParams", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_RUN_CGI", "MountableCGIResult", "MpUrl", "plugin-brandservice_release"})
public final class j
{
  private static final String TAG = "MicroMsg.PreloadLogic";
  private static final String cLt = "com.tencent.mm:toolsmp";
  private static final AtomicBoolean cWj;
  private static final AtomicBoolean ndV;
  private static final ar ndW;
  private static final com.tencent.mm.sdk.platformtools.ao ndX;
  private static final l ndY;
  private static final HashMap<Integer, Boolean> ndZ;
  private static final a nea;
  private static final d.f neb;
  private static final boolean nec = false;
  public static final j ned;
  
  static
  {
    AppMethodBeat.i(6685);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(j.class), "cgiCallbackList", "getCgiCallbackList()Ljava/util/concurrent/ConcurrentHashMap;")) };
    ned = new j();
    TAG = "MicroMsg.PreloadLogic";
    cWj = new AtomicBoolean(false);
    ndV = new AtomicBoolean(false);
    cLt = "com.tencent.mm:toolsmp";
    ndW = new ar(r.bDU());
    ndX = new com.tencent.mm.sdk.platformtools.ao("webcached");
    ndY = new l();
    ndZ = new HashMap();
    nea = new a();
    neb = d.g.E((d.g.a.a)g.neh);
    AppMethodBeat.o(6685);
  }
  
  public static void PC(String paramString)
  {
    AppMethodBeat.i(6710);
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "removePreload %s", new Object[] { paramString });
    d.g.b.k.h(paramString, "url");
    String str = b.Ps(paramString);
    ax localax = (ax)ndW.aFe(str);
    if (localax != null)
    {
      localax.removeValueForKey(str);
      localax.removeValueForKey(b.Py(paramString));
    }
    AppMethodBeat.o(6710);
  }
  
  public static final void PD(String paramString)
  {
    AppMethodBeat.i(6715);
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)n.nep, null);
    AppMethodBeat.o(6715);
  }
  
  public static long PE(String paramString)
  {
    AppMethodBeat.i(6716);
    d.g.b.k.h(paramString, "url");
    paramString = b.Pz(paramString);
    ax localax = (ax)ndW.aFe(paramString);
    if (localax != null)
    {
      long l = localax.getLong(paramString, 0L);
      AppMethodBeat.o(6716);
      return l;
    }
    AppMethodBeat.o(6716);
    return 0L;
  }
  
  private static com.tencent.mm.al.b.a a(Iterable<d> paramIterable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6708);
    ja localja = new ja();
    localja.nlG = d.bDp();
    localja.CEy = r.bDT();
    localja.CEx = new LinkedList();
    localja.CEz = paramInt2;
    localja.CEA = paramInt3;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a(paramIterable, 10));
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (d)localIterator.next();
      Object localObject2 = ((d)localObject3).url;
      paramInt2 = ((d)localObject3).nee;
      localObject3 = new cko();
      ((cko)localObject3).Url = ((String)localObject2);
      ((cko)localObject3).CyY = 0;
      ((cko)localObject3).Scene = paramInt1;
      localObject2 = nea.PF((String)localObject2);
      if (localObject2 != null)
      {
        ((cko)localObject3).CyY = ((eu)localObject2).CyY;
        if (!a((eu)localObject2, paramInt2)) {
          ((cko)localObject3).CyY = 0;
        }
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localja.CEx.addAll((Collection)localObject1);
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", new Object[] { Integer.valueOf(localja.CEx.size()) });
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "[batchSyncAppMsgContext]urlList:%s", new Object[] { paramIterable });
    paramIterable = new com.tencent.mm.al.b.a();
    paramIterable.nB(2594);
    paramIterable.wg("/cgi-bin/mmbiz-bin/batchgetappmsg");
    paramIterable.nD(0);
    paramIterable.nE(0);
    paramIterable.c((com.tencent.mm.bx.a)localja);
    paramIterable.d((com.tencent.mm.bx.a)new jb());
    switch (paramInt1)
    {
    default: 
      paramInt1 = 35;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.g.a.iv(paramInt1, localja.CEx.size());
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
  
  private static void a(Context paramContext, Intent paramIntent, final cbz paramcbz, boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(193102);
    paramString1 = new s(paramBoolean, paramString1, paramcbz);
    paramString2 = new t(paramBoolean, paramString2, paramcbz);
    if (paramcbz.gGx == 5) {
      paramIntent.putExtra("screen_orientation", 1);
    }
    com.tencent.mm.bs.d.b(paramContext, paramString1.aTF(), paramString2.aTF(), paramIntent);
    AppMethodBeat.o(193102);
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
      localObject1 = b.Py((String)localObject1);
      if (bDM().containsKey(localObject1))
      {
        paramBundle = (ConcurrentLinkedDeque)bDM().get(localObject1);
        if (paramBundle != null) {
          paramBundle.add(paramb);
        }
        com.tencent.mm.sdk.platformtools.ad.v(TAG, "terry trace cgi mounted:" + (String)localObject1 + '#' + l2);
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
          localObject2 = b.Py((String)localObject2);
          ((Map)bDM()).put(localObject2, new ConcurrentLinkedDeque());
          com.tencent.mm.sdk.platformtools.ad.v(TAG, "terry trace cgi send:" + (String)localObject2 + '#' + l2);
        }
        i += 1;
        break;
      }
    }
    com.tencent.mm.al.x.a(a((Iterable)paramBundle, k, m, n).atI(), (x.a)new r(l1, l2, paramb, localArrayList));
    AppMethodBeat.o(6706);
  }
  
  public static final void a(String arg0, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6711);
    d.g.b.k.h(???, "url");
    d.g.b.k.h(paramVarArgs, "params");
    if (nec)
    {
      AppMethodBeat.o(6711);
      return;
    }
    Object localObject1 = new d.g.b.y(3);
    ((d.g.b.y)localObject1).add(???);
    ((d.g.b.y)localObject1).add(Integer.valueOf(paramInt1));
    ((d.g.b.y)localObject1).eI(paramVarArgs);
    localObject1 = d.a.j.Z(((d.g.b.y)localObject1).toArray(new Object[((d.g.b.y)localObject1).cTm.size()]));
    paramVarArgs = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
    Object localObject2;
    synchronized (by.EXM)
    {
      localObject2 = by.EXM;
      localObject2 = (bj)by.eGX().get(paramVarArgs);
      if (localObject2 != null) {
        ((bj)localObject2).fLu();
      }
      localObject2 = by.EXM;
      localObject2 = by.eGY();
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
    ??? = by.EXM;
    ((Map)by.eGX()).put(paramVarArgs, kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.fLg(), (m)new e(1000L, paramVarArgs, null, paramInt2), 2));
    AppMethodBeat.o(6711);
  }
  
  private static void a(List<d> paramList, int paramInt1, int paramInt2, int paramInt3, m<? super c, ? super jb, d.y> paramm)
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
      paramList.add(Integer.valueOf(((d)((Iterator)localObject1).next()).nee));
    }
    localBundle.putIntegerArrayList("tmplTypes", new ArrayList((Collection)paramList));
    localBundle.putInt("openScene", paramInt1);
    localBundle.putInt("strip", paramInt2);
    localBundle.putInt("stripType", paramInt3);
    paramList = com.tencent.mm.kernel.g.afy().aeZ();
    d.g.b.k.g(paramList, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)paramList).agu())
    {
      a(localBundle, (d.g.a.b)new o(paramm));
      AppMethodBeat.o(6704);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, b.class, (com.tencent.mm.ipcinvoker.d)new p(paramm));
    AppMethodBeat.o(6704);
  }
  
  private final boolean a(Context paramContext, Intent paramIntent, cbz paramcbz, boolean paramBoolean1, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(193101);
    dch localdch = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.yo(paramcbz.nee);
    if ((localdch == null) && ((paramcbz.gGx == 0) || (paramcbz.gGx == -1)))
    {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "tmplParams is null");
      parama.success = false;
      parama.message = ("not support tmplType=" + paramcbz + ".tmplType");
      AppMethodBeat.o(193101);
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
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(902), Integer.valueOf(i) });
      label222:
      Object localObject;
      if (localdch == null)
      {
        parama = paramcbz.url;
        d.g.b.k.g(parama, "session.url");
        paramIntent.putExtra("rawUrl", UrlExKt.appendStats(a(parama, paramBoolean1, paramIntent), paramcbz));
        paramIntent.putExtra(e.m.FIw, true);
        parama = e.m.FIk;
        localObject = g.ndS;
        paramIntent.putExtra(parama, g.a.bDA());
        paramIntent.putExtra(e.m.FIl, System.currentTimeMillis());
        paramIntent.putExtra(e.m.FIn, paramcbz.url);
        localObject = e.m.FIj;
        if (localdch == null) {
          break label906;
        }
        parama = localdch.toByteArray();
        paramIntent.putExtra((String)localObject, parama);
        paramIntent.putExtra(e.m.FIv, paramcbz.toByteArray());
        paramIntent.putExtra(e.m.FIs, Process.myPid());
      }
      try
      {
        paramIntent.putExtra(e.m.FIr, d.b(paramContext, (d.g.a.b)u.ney));
        if (paramBoolean2)
        {
          paramBoolean2 = paramcbz.DYm;
          if (!paramBoolean2) {}
        }
        for (;;)
        {
          try
          {
            d.g.b.k.h(paramIntent, "intent");
            com.tencent.mm.ipcinvoker.a.a(cLt, (Parcelable)paramIntent, (com.tencent.mm.ipcinvoker.b)v.nez, null);
            a(paramContext, paramIntent, paramcbz, paramBoolean1, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
            if (localdch != null)
            {
              com.tencent.mm.plugin.webview.g.a.fL(localdch.reportId, 106);
              com.tencent.mm.plugin.webview.g.a.SW(100);
              if (paramcbz.DYn)
              {
                com.tencent.mm.plugin.webview.g.a.fL(localdch.reportId, 231);
                com.tencent.mm.plugin.webview.g.a.SW(110);
              }
            }
            AppMethodBeat.o(193101);
            return true;
            i = 0;
            break;
            paramcbz.yaG = localdch.yaG;
            com.tencent.mm.plugin.webview.g.a.fL(localdch.reportId, 104);
            localObject = paramcbz.url;
            d.g.b.k.g(localObject, "session.url");
            localObject = cq((String)localObject, paramcbz.nee);
            if (localObject != null)
            {
              String str = ((eu)localObject).CyX;
              if (str != null)
              {
                if (!d.n.n.aC((CharSequence)str))
                {
                  i = 1;
                  if (i != 1) {
                    continue;
                  }
                  if (!((eu)localObject).Cze) {
                    break label953;
                  }
                  paramBoolean1 = false;
                  if ((((eu)localObject).Cze) || (paramcbz.gGx == 0))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra(e.m.FIp, paramcbz.mSu);
                    localObject = ((eu)localObject).CyX;
                    d.g.b.k.g(localObject, "appMsgContext.ForceUrl");
                    localObject = a(UrlExKt.appendStats((String)localObject, paramcbz), paramBoolean1, paramIntent);
                    com.tencent.mm.sdk.platformtools.ad.i(TAG, "appMsgContext forceUrl:%s", new Object[] { localObject });
                    paramIntent.putExtra("rawUrl", (String)localObject);
                    if (paramBoolean2) {
                      a(paramContext, paramIntent, paramcbz, paramBoolean1, "webview", ".ui.tools.WebViewUI");
                    }
                    com.tencent.mm.plugin.webview.g.a.fL(localdch.reportId, 107);
                    parama.success = true;
                    parama.message = "has forceUrl=".concat(String.valueOf(localObject));
                    AppMethodBeat.o(193101);
                    return true;
                  }
                }
                else
                {
                  i = 0;
                  continue;
                }
                paramIntent.putExtra(e.m.FIw, true);
                continue;
              }
            }
            parama = paramcbz.url;
            d.g.b.k.g(parama, "session.url");
            paramcbz.url = a(parama, paramBoolean1, paramIntent);
            paramIntent.putExtra("rawUrl", paramcbz.url);
            paramcbz.DYl = true;
            parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.ym(localdch.nee);
            paramcbz.DYn = r.d(parama);
            boolean bool2 = d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
            if ((r.d(parama)) && (bool2))
            {
              bool1 = true;
              paramcbz.DYo = bool1;
              if ((!r.d(parama)) || (bool2)) {
                continue;
              }
              bool1 = true;
              paramcbz.DYp = bool1;
              if ((localObject == null) || (!k.b((eu)localObject))) {
                continue;
              }
              paramcbz.DYm = true;
              com.tencent.mm.sdk.platformtools.ad.i(TAG, "set contentId:%s", new Object[] { b.a((eu)localObject) });
              break label222;
            }
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            parama = paramcbz.url;
            d.g.b.k.g(parama, "session.url");
            a(paramContext, parama, paramcbz, (q)j.nek);
            break label222;
            label906:
            parama = null;
          }
          catch (Throwable parama)
          {
            com.tencent.mm.sdk.platformtools.ad.i(TAG, "updateWebview ex " + parama.getMessage());
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(193101);
        return false;
      }
    }
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(193098);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "rawUrl");
    d.g.b.k.h(paramIntent, "intent");
    d.g.b.k.h(parama, "result");
    if (d.n.n.aC((CharSequence)paramString))
    {
      parama.success = false;
      parama.message = "invalid url";
      AppMethodBeat.o(193098);
      return false;
    }
    if (!UrlExKt.isMpUrl(paramString))
    {
      parama.success = false;
      parama.message = "invalid host";
      AppMethodBeat.o(193098);
      return false;
    }
    Object localObject;
    int i;
    if (paramInt1 == -1)
    {
      localObject = nea.PF(paramString);
      if (localObject != null) {
        i = ((eu)localObject).gKq;
      }
    }
    for (;;)
    {
      if ((i == 5) && (!com.tencent.mm.pluginsdk.ui.tools.x.eAY())) {}
      int k;
      for (boolean bool1 = true;; bool1 = false)
      {
        k = ya(i);
        if (k != -1) {
          break label193;
        }
        parama.success = false;
        parama.message = "invalid itemShowType:".concat(String.valueOf(i));
        AppMethodBeat.o(193098);
        return false;
        i = paramInt1;
        break;
      }
      label193:
      int m = com.tencent.mm.storage.u.getSessionId();
      localObject = UrlExKt.getUrlParam(paramString, "scene");
      int j = paramInt2;
      CharSequence localCharSequence;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        j = paramInt2;
        if (new d.n.k("\\d+").aA(localCharSequence)) {
          j = Integer.parseInt((String)localObject);
        }
      }
      localObject = UrlExKt.getUrlParam(paramString, "subscene");
      paramInt2 = paramInt3;
      if (localObject != null)
      {
        localCharSequence = (CharSequence)localObject;
        paramInt2 = paramInt3;
        if (new d.n.k("\\d+").aA(localCharSequence)) {
          paramInt2 = Integer.parseInt((String)localObject);
        }
      }
      paramIntent.putExtra(e.m.FIt, i);
      paramIntent.putExtra(e.m.FIo, m);
      paramIntent.putExtra(e.m.FIp, j);
      paramIntent.putExtra(e.m.FIq, paramInt2);
      paramIntent.putExtra(e.m.FIu, paramInt4);
      paramInt3 = paramIntent.getIntExtra("geta8key_scene", 0);
      localObject = new cbz();
      ((cbz)localObject).id = m;
      ((cbz)localObject).url = paramString;
      ((cbz)localObject).gGx = i;
      ((cbz)localObject).nee = k;
      ((cbz)localObject).mSu = j;
      ((cbz)localObject).niJ = paramInt2;
      ((cbz)localObject).DYk = paramInt3;
      boolean bool2;
      if (i != paramInt1)
      {
        bool2 = true;
        ((cbz)localObject).ndr = bool2;
        paramBoolean = ned.a(paramContext, paramIntent, (cbz)localObject, bool1, parama, paramBoolean);
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
        com.tencent.mm.plugin.webview.g.a.SV(paramInt1);
        AppMethodBeat.o(193098);
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
  
  private static boolean a(eu parameu, int paramInt)
  {
    AppMethodBeat.i(6702);
    dcg localdcg = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.ym(paramInt);
    Object localObject = (CharSequence)parameu.CyX;
    if ((localObject == null) || (d.n.n.aC((CharSequence)localObject))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(6702);
      return true;
    }
    if (r.a(localdcg))
    {
      parameu = parameu.Czf;
      if (parameu != null)
      {
        parameu = ((Iterable)parameu).iterator();
        while (parameu.hasNext())
        {
          localObject = (dcg)parameu.next();
          if ((((dcg)localObject).mBH == localdcg.mBH) && (d.g.b.k.g(((dcg)localObject).EtL, localdcg.EtL)))
          {
            if (((dcg)localObject).Version >= localdcg.Version)
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
  
  private static void aw(int paramInt, String paramString)
  {
    AppMethodBeat.i(6691);
    d.g.b.k.h(paramString, "netType");
    Bundle localBundle = new Bundle();
    localBundle.putInt("openScene", paramInt);
    localBundle.putString("netType", paramString);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)localBundle, (com.tencent.mm.ipcinvoker.b)i.nej, null);
    AppMethodBeat.o(6691);
  }
  
  private static void b(List<d> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6703);
    g.a locala = g.ndS;
    if (!g.a.bDB())
    {
      AppMethodBeat.o(6703);
      return;
    }
    a(paramList, paramInt1, paramInt2, paramInt3, (m)new f(paramList));
    AppMethodBeat.o(6703);
  }
  
  public static ar bDJ()
  {
    return ndW;
  }
  
  public static com.tencent.mm.sdk.platformtools.ao bDK()
  {
    return ndX;
  }
  
  public static a bDL()
  {
    return nea;
  }
  
  public static ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<Bundle, d.y>>> bDM()
  {
    AppMethodBeat.i(6707);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)neb.getValue();
    AppMethodBeat.o(6707);
    return localConcurrentHashMap;
  }
  
  private static void bDN()
  {
    AppMethodBeat.i(6714);
    com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", null, (com.tencent.mm.ipcinvoker.b)h.nei, null);
    AppMethodBeat.o(6714);
  }
  
  private static void clear()
  {
    AppMethodBeat.i(6688);
    a.bDR();
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "clear() isOk:true");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bEr();
    AppMethodBeat.o(6688);
  }
  
  private static eu cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(6700);
    if (d.n.n.aC((CharSequence)paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "[findAppMsgContextInCache] url is null, return");
      AppMethodBeat.o(6700);
      return null;
    }
    if (nea.cr(paramString, paramInt))
    {
      paramString = nea.PF(paramString);
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
    if (nec)
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
        break label857;
      }
      k = yc(paramInt);
      if (k == 0) {
        break label356;
      }
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label356;
      }
      localObject1 = (List)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
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
    if (xA(yd(paramInt)))
    {
      k = b.xW(paramInt);
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
        paramList.add(new d((String)((List)localObject2).get(0), ya(Integer.parseInt((String)((List)localObject2).get(1)))));
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (d)localObject2;
        localObject4 = ((d)localObject3).url;
        i = ((d)localObject3).nee;
        if ((!UrlExKt.isMpUrl((String)localObject4)) || (nea.cr((String)localObject4, i))) {}
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
        if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0)
        {
          paramList = TAG;
          localObject1 = new StringBuilder("preloadData preloadByIdAndUrls strip:").append(k).append(" dispatch:");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(b.Py(((d)((Iterator)localObject3).next()).url));
          }
          com.tencent.mm.sdk.platformtools.ad.v(paramList, (List)localObject2);
        }
      }
    }
    label458:
    label857:
    AppMethodBeat.o(6713);
    label672:
  }
  
  public static final void j(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6712);
    d.g.b.k.h(paramList, "items");
    if (nec)
    {
      AppMethodBeat.o(6712);
      return;
    }
    if (!xA(yd(paramInt)))
    {
      AppMethodBeat.o(6712);
      return;
    }
    int j = b.xW(paramInt);
    paramList = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      paramList = (String[])((Iterator)localObject2).next();
      i = Integer.parseInt(paramList[2]);
      paramList = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(Long.parseLong(paramList[0]), paramList[1]).gKs;
      if (i > 0) {
        d.g.b.k.g(paramList, "it");
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
      localObject4 = (com.tencent.mm.ai.v)((Iterator)localObject3).next();
      localObject1 = ((com.tencent.mm.ai.v)localObject4).url;
      paramList = (List<String[]>)localObject1;
      if (localObject1 == null) {
        paramList = "";
      }
      ((Collection)localObject2).add(new d(paramList, ya(((com.tencent.mm.ai.v)localObject4).type)));
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
      i = ((d)localObject3).nee;
      if ((!UrlExKt.isMpUrl((String)localObject4)) || (nea.cr((String)localObject4, i))) {}
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
      if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0)
      {
        paramList = TAG;
        localObject1 = new StringBuilder("preloadData preloadByInfoIdAndBuffer strip:").append(j).append(" dispatch:");
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(b.Py(((d)((Iterator)localObject3).next()).url));
            continue;
            i = 0;
            break;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.v(paramList, (List)localObject2);
      }
    }
    AppMethodBeat.o(6712);
  }
  
  public static final void run(int paramInt)
  {
    AppMethodBeat.i(6686);
    if (ndV.get())
    {
      AppMethodBeat.o(6686);
      return;
    }
    ndV.set(true);
    if (paramInt == 10000)
    {
      com.tencent.mm.cr.d.fkP();
      xX(paramInt);
      ndV.set(false);
      AppMethodBeat.o(6686);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new q(paramInt));
    AppMethodBeat.o(6686);
  }
  
  public static final boolean xA(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(6699);
    if (paramInt == 102)
    {
      AppMethodBeat.o(6699);
      return false;
    }
    if (ndZ.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = ndZ.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    Object localObject = g.ndS;
    if ((!g.a.bDI()) && ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)))
    {
      localObject = (Map)ndZ;
      g.a locala = g.ndS;
      ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(h.buO().getBoolean("preload_use", true)));
      localObject = ndZ.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(6699);
      return bool;
    }
    for (;;)
    {
      try
      {
        localObject = (Map)ndZ;
        switch (paramInt)
        {
        case 1: 
          ((Map)localObject).put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        }
      }
      catch (Exception localException)
      {
        int i;
        ((Map)ndZ).put(Integer.valueOf(paramInt), Boolean.FALSE);
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(TAG, (Throwable)localException, "canPreloadIn", new Object[0]);
        continue;
        AppMethodBeat.o(6699);
        return false;
      }
      if (ndZ.containsKey(Integer.valueOf(paramInt)))
      {
        localObject = ndZ.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        d.g.b.k.g(localObject, "isPreloadOpen[openScene]!!");
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(6699);
        return bool;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plI, 0) == 0)
        {
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plJ, 0) == 0)
          {
            bool = false;
            continue;
            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plK, 0) & 0x1) == 0) {
              break label852;
            }
            bool = true;
            break;
            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plK, 0) & 0x2) == 0)
            {
              bool = false;
              continue;
              if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plK, 0) & 0x4) == 0)
              {
                bool = false;
                continue;
                if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plL, 0) & 0x1) == 0)
                {
                  bool = false;
                  continue;
                  if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plL, 0) & 0x2) == 0)
                  {
                    bool = false;
                    continue;
                    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plL, 0) & 0x4) == 0)
                    {
                      bool = false;
                      continue;
                      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plO, 0) == 0)
                      {
                        bool = false;
                        continue;
                        if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plP, 0) & 0x1) == 0)
                        {
                          bool = false;
                          continue;
                          if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plP, 0) & 0x2) == 0)
                          {
                            bool = false;
                            continue;
                            if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plP, 0) & 0x4) == 0)
                            {
                              bool = false;
                              continue;
                              if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plH, 0) == 0)
                              {
                                bool = false;
                                continue;
                                if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plQ, 0) & 0x1) == 0)
                                {
                                  bool = false;
                                  continue;
                                  i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plR, 0);
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
  
  private static void xX(int paramInt)
  {
    AppMethodBeat.i(6687);
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "start in preCreate");
    aw(paramInt, d.bDp());
    xZ(-1);
    bDN();
    clear();
    AppMethodBeat.o(6687);
  }
  
  public static final void xY(int paramInt)
  {
    AppMethodBeat.i(6689);
    xZ(paramInt);
    AppMethodBeat.o(6689);
  }
  
  private static void xZ(int paramInt)
  {
    AppMethodBeat.i(6690);
    g.a locala = g.ndS;
    if (!g.a.bDA())
    {
      AppMethodBeat.o(6690);
      return;
    }
    com.tencent.mm.ipcinvoker.a.a(cLt, (Parcelable)new IPCInteger(paramInt), (com.tencent.mm.ipcinvoker.b)m.neo, null);
    AppMethodBeat.o(6690);
  }
  
  private static int ya(int paramInt)
  {
    AppMethodBeat.i(193100);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if ((localb != null) && (localb.xz(paramInt)))
    {
      if (xA(102))
      {
        AppMethodBeat.o(193100);
        return 5;
      }
      AppMethodBeat.o(193100);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(193100);
      return -1;
    }
    if (xA(102))
    {
      AppMethodBeat.o(193100);
      return 5;
    }
    AppMethodBeat.o(193100);
    return 0;
  }
  
  private static int yc(int paramInt)
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
  
  private static int yd(int paramInt)
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
  
  public final void a(final Object paramObject, String paramString, cbz paramcbz, final q<? super WeakReference<Object>, ? super c, ? super eu, d.y> paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(193103);
    d.g.b.k.h(paramObject, "context");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramcbz, "session");
    d.g.b.k.h(paramq, "callback");
    paramObject = new WeakReference(paramObject);
    Object localObject1 = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte)0);
    Object localObject2 = g.ndS;
    if (g.a.bDC())
    {
      ((c)localObject1).dhg = true;
      paramq.d(paramObject, localObject1, new eu());
      AppMethodBeat.o(193103);
      return;
    }
    if ((d.n.n.aC((CharSequence)paramString)) || (!UrlExKt.isMpUrl(paramString)))
    {
      paramq.d(paramObject, localObject1, new eu());
      AppMethodBeat.o(193103);
      return;
    }
    localObject2 = cq(paramString, paramcbz.nee);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getAppMsgContext ");
    if (localObject2 == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ad.d(str, bool);
    if (localObject2 != null)
    {
      ((c)localObject1).dhg = true;
      ((c)localObject1).byc = true;
      paramq.d(paramObject, localObject1, localObject2);
      AppMethodBeat.o(193103);
      return;
    }
    paramString = UrlExKt.appendStats(paramString, paramcbz);
    localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(new d(paramString, paramcbz.nee));
    a((List)localObject1, paramcbz.nee, (m)new k(paramString, paramq, paramObject));
    AppMethodBeat.o(193103);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "", "clear", "get", "url", "has", "remove", "", "save", "plugin-brandservice_release"})
  public static final class a
  {
    private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";
    
    public static boolean bDR()
    {
      AppMethodBeat.i(6642);
      j localj = j.ned;
      j.bDJ().eEW();
      AppMethodBeat.o(6642);
      return true;
    }
    
    private final boolean c(eu parameu, int paramInt)
    {
      AppMethodBeat.i(6640);
      if (parameu == null)
      {
        com.tencent.mm.sdk.platformtools.ad.v(this.TAG, "checkValid: null");
        AppMethodBeat.o(6640);
        return false;
      }
      Object localObject1 = j.ned;
      if (!j.b(parameu, paramInt))
      {
        com.tencent.mm.sdk.platformtools.ad.v(this.TAG, "checkValid: invalid version:data(" + parameu.Cza + ')');
        AppMethodBeat.o(6640);
        return false;
      }
      localObject1 = g.ndS;
      if (g.a.bDD()) {
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "checkValid: debug to expire");
      }
      for (;;)
      {
        AppMethodBeat.o(6640);
        return true;
        localObject1 = parameu.Url;
        d.g.b.k.g(localObject1, "appMsgContext.Url");
        localObject1 = b.Pz((String)localObject1);
        Object localObject2 = j.ned;
        localObject2 = (ax)j.bDJ().aFe((String)localObject1);
        if (localObject2 != null) {}
        for (boolean bool = d.a((ax)localObject2, (String)localObject1, parameu.CyW * 1000L); bool; bool = true)
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "checkValid: expire for " + parameu.CyW);
          AppMethodBeat.o(6640);
          return false;
        }
      }
    }
    
    public final eu PF(String paramString)
    {
      AppMethodBeat.i(6639);
      d.g.b.k.h(paramString, "url");
      String str = b.Ps(paramString);
      Object localObject1 = j.ned;
      localObject1 = (ax)j.bDJ().aFe(str);
      int i;
      if (localObject1 != null) {
        if (((ax)localObject1).containsKey(str))
        {
          localObject1 = ((ax)localObject1).decodeBytes(str);
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
          Object localObject3 = eu.class.newInstance();
          ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bx.a)localObject3;
          localObject1 = (eu)localObject1;
          if (localObject1 == null) {
            break label192;
          }
          ((eu)localObject1).Url = paramString;
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "found:" + str + " last modify:" + ((eu)localObject1).CyY);
          AppMethodBeat.o(6639);
          return localObject1;
        }
        catch (Exception localException)
        {
          label161:
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "not found:".concat(String.valueOf(str)));
      AppMethodBeat.o(6639);
      return null;
    }
    
    public final void a(String paramString, eu parameu)
    {
      AppMethodBeat.i(6641);
      d.g.b.k.h(paramString, "url");
      if (parameu != null)
      {
        localObject1 = (CharSequence)parameu.gKr;
        if ((localObject1 != null) && (!d.n.n.aC((CharSequence)localObject1))) {
          break label60;
        }
      }
      label60:
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "save fail, appMsgContext is null");
        AppMethodBeat.o(6641);
        return;
      }
      Object localObject1 = b.Ps(paramString);
      Object localObject2 = parameu.gKr;
      try
      {
        Object localObject3 = new eu();
        ((eu)localObject3).parseFrom(parameu.toByteArray());
        ((eu)localObject3).gKr = null;
        Object localObject4 = ((eu)localObject3).toByteArray();
        localObject3 = j.ned;
        localObject3 = (ax)j.bDJ().eEX();
        ((ax)localObject3).encode((String)localObject1, (byte[])localObject4);
        localObject4 = j.ned;
        localObject4 = b.E(b.a(j.bDK(), b.Py(paramString)));
        d.g.b.k.g(localObject2, "content");
        Charset localCharset = d.n.d.UTF_8;
        d.g.b.k.h(localObject4, "$this$writeText");
        d.g.b.k.h(localObject2, "text");
        d.g.b.k.h(localCharset, "charset");
        localObject2 = ((String)localObject2).getBytes(localCharset);
        d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.f.b((e)localObject4, (byte[])localObject2);
        d.b((ax)localObject3, b.Pz(paramString));
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "saveInfo " + (String)localObject1 + " last modify:" + parameu.CyY);
        AppMethodBeat.o(6641);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(this.TAG, (Throwable)paramString, "save ".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
    }
    
    public final boolean cr(String paramString, int paramInt)
    {
      AppMethodBeat.i(6638);
      d.g.b.k.h(paramString, "url");
      eu localeu = PF(paramString);
      if (localeu == null)
      {
        AppMethodBeat.o(6638);
        return false;
      }
      Object localObject = j.ned;
      int i;
      if (localeu != null)
      {
        localObject = Integer.valueOf(localeu.gKq);
        i = j.yb(((Integer)localObject).intValue());
        if (i != -1) {
          break label122;
        }
      }
      for (;;)
      {
        boolean bool = c(localeu, paramInt);
        if (!bool) {
          com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "init invalid:" + b.Ps(paramString));
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
  public static final class c
  {
    public long bdV;
    public boolean byc;
    public boolean dhg;
    public boolean ndn;
    public long start;
    
    private c(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
    {
      this.dhg = paramBoolean1;
      this.start = paramLong1;
      this.bdV = paramLong2;
      this.ndn = paramBoolean2;
      this.byc = false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MpUrl;", "", "url", "", "tmplType", "", "(Ljava/lang/String;I)V", "getTmplType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "plugin-brandservice_release"})
  static final class d
  {
    final int nee;
    final String url;
    
    public d(String paramString, int paramInt)
    {
      AppMethodBeat.i(6650);
      this.url = paramString;
      this.nee = paramInt;
      AppMethodBeat.o(6650);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2"})
  public static final class e
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    public e(long paramLong, String paramString, d.d.d paramd, int paramInt)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6658);
      d.g.b.k.h(paramd, "completion");
      paramd = new e(this.nef, this.jCN, paramd, this.mSf);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(6658);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(6657);
      paramObject = d.d.a.a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6657);
        throw paramObject;
      case 0: 
        localObject1 = this.mTa;
        long l = this.nef;
        this.mTb = localObject1;
        this.label = 1;
        if (kotlinx.coroutines.ao.a(l, this) == paramObject)
        {
          AppMethodBeat.o(6657);
          return paramObject;
        }
        break;
      }
      int i;
      Object localObject4;
      Object localObject3;
      for (;;)
      {
        synchronized (by.EXM)
        {
          paramObject = by.EXM;
          localObject1 = by.eGY().get(this.jCN);
          paramObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramObject = null;
          }
          paramObject = (Queue)paramObject;
          if (paramObject != null)
          {
            localObject1 = by.EXM;
            by.eGY().remove(this.jCN);
            paramObject = new ArrayList((Collection)paramObject);
            if (paramObject == null) {
              break label1607;
            }
            paramObject = (List)paramObject;
            if ((!bu.eGT()) || (com.tencent.mm.sdk.platformtools.ad.getLogLevel() != 0)) {
              break label347;
            }
            if (((Collection)paramObject).isEmpty())
            {
              i = 1;
              if (i != 0) {
                break label347;
              }
              localObject1 = j.ned;
              localObject1 = j.bDO();
              ??? = new StringBuilder("preloadData addToPreload batch:");
              localObject4 = (Iterable)paramObject;
              localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              ((Collection)localObject3).add(b.Py(((ArrayList)((Iterator)localObject4).next()).get(0).toString()));
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
      com.tencent.mm.sdk.platformtools.ad.v((String)localObject1, (List)localObject3);
      label347:
      Object localObject1 = d.y.JfV;
      localObject1 = (Iterable)d.a.j.j((Iterable)paramObject);
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label448:
      while (((Iterator)localObject1).hasNext())
      {
        ??? = ((Iterator)localObject1).next();
        localObject3 = (ArrayList)???;
        if ((localObject3 != null) && ((((ArrayList)localObject3).get(0) instanceof String))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label448;
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
        if (paramObject.add(b.Py((String)localObject4))) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      if (!((List)localObject1).isEmpty())
      {
        paramObject = j.ned;
        int j = j.yf(this.mSf);
        if (j != 0)
        {
          ??? = ((Iterable)localObject1).iterator();
          if (((Iterator)???).hasNext())
          {
            paramObject = (ArrayList)((Iterator)???).next();
            localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
            localObject4 = j.ned;
            localObject4 = j.b((List)paramObject, 2, "");
            Object localObject5 = paramObject.get(0);
            if (localObject5 == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            localObject5 = p.encode((String)localObject5);
            Object localObject6 = j.ned;
            localObject6 = j.b((List)paramObject, 3, "");
            Object localObject7 = j.ned;
            localObject7 = j.b((List)paramObject, 4, "");
            Object localObject8 = paramObject.get(1);
            Object localObject9 = j.ned;
            localObject9 = j.b((List)paramObject, 5, "");
            Object localObject10 = j.ned;
            localObject10 = j.b((List)paramObject, 6, "");
            Object localObject11 = j.ned;
            localObject11 = j.b((List)paramObject, 7, "");
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
                label873:
                if (!paramObject.booleanValue()) {
                  break label975;
                }
                i = 1;
                label882:
                if (i == 0) {
                  break label980;
                }
              }
            }
            label975:
            label980:
            for (i = 1;; i = 0)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject3).f(16468, new Object[] { Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7, Integer.valueOf(2), localObject8, localObject9, localObject10, localObject11, Integer.valueOf(i) });
              break;
              paramObject = null;
              break label873;
              i = 0;
              break label882;
            }
          }
        }
        paramObject = j.ned;
        if (j.xA(j.yg(this.mSf)))
        {
          j = b.xW(this.mSf);
          localObject1 = (Iterable)localObject1;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1122:
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
                break label1122;
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
            localObject4 = j.ned;
            ??? = ((ArrayList)???).get(1);
            if (??? == null)
            {
              paramObject = new d.v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6657);
              throw paramObject;
            }
            paramObject.add(new j.d((String)localObject3, j.yb(((Integer)???).intValue())));
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          label1397:
          label1400:
          while (((Iterator)localObject1).hasNext())
          {
            ??? = ((Iterator)localObject1).next();
            localObject4 = (j.d)???;
            localObject3 = ((j.d)localObject4).url;
            i = ((j.d)localObject4).nee;
            if (UrlExKt.isMpUrl((String)localObject3))
            {
              localObject4 = j.ned;
              if (!j.bDL().cr((String)localObject3, i)) {
                break label1397;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label1400;
              }
              paramObject.add(???);
              break;
            }
          }
          paramObject = (List)paramObject;
          int k = Math.max(paramObject.size() - j, 0);
          localObject1 = d.y.JfV;
          ??? = d.a.j.b((Iterable)paramObject, j);
          if (!((Collection)???).isEmpty()) {
            i = 1;
          }
          while (i != 0)
          {
            j.a(j.ned, (List)???, this.mSf, k);
            if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0)
            {
              paramObject = j.ned;
              paramObject = j.bDO();
              localObject1 = new StringBuilder("preloadData addToPreload strip:").append(j).append(" dispatch:");
              localObject3 = (Iterable)???;
              ??? = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  ((Collection)???).add(b.Py(((j.d)((Iterator)localObject3).next()).url));
                  continue;
                  i = 0;
                  break;
                }
              }
              com.tencent.mm.sdk.platformtools.ad.v(paramObject, (List)???);
            }
          }
          paramObject = d.y.JfV;
        }
      }
      paramObject = d.y.JfV;
      label1607:
      paramObject = by.EXM;
      by.eGX().remove(this.jCN);
      paramObject = d.y.JfV;
      AppMethodBeat.o(6657);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6659);
      paramObject1 = ((e)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(6659);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class f
    extends d.g.b.l
    implements m<j.c, jb, d.y>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<d.g.a.b<? super Bundle, ? extends d.y>>>>
  {
    public static final g neh;
    
    static
    {
      AppMethodBeat.i(6662);
      neh = new g();
      AppMethodBeat.o(6662);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class h<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final h nei;
    
    static
    {
      AppMethodBeat.i(193089);
      nei = new h();
      AppMethodBeat.o(193089);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class i<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {
    public static final i nej;
    
    static
    {
      AppMethodBeat.i(193091);
      nej = new i();
      AppMethodBeat.o(193091);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class j
    extends d.g.b.l
    implements q<WeakReference<Object>, j.c, eu, d.y>
  {
    public static final j nek;
    
    static
    {
      AppMethodBeat.i(6664);
      nek = new j();
      AppMethodBeat.o(6664);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
  static final class k
    extends d.g.b.l
    implements m<j.c, jb, d.y>
  {
    k(String paramString, q paramq, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "tmplType", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class m<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid>
  {
    public static final m neo;
    
    static
    {
      AppMethodBeat.i(193093);
      neo = new m();
      AppMethodBeat.o(193093);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "url", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class n<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final n nep;
    
    static
    {
      AppMethodBeat.i(193095);
      nep = new n();
      AppMethodBeat.o(193095);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<Bundle, d.y>
  {
    o(m paramm)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class p<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    p(m paramm) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class q
    implements MessageQueue.IdleHandler
  {
    q(int paramInt) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(6679);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      com.tencent.mm.cr.d.fkP();
      j localj = j.ned;
      j.ye(this.mSb);
      localj = j.ned;
      j.bDP().set(false);
      AppMethodBeat.o(6679);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class r
    implements x.a
  {
    r(long paramLong1, long paramLong2, d.g.a.b paramb, ArrayList paramArrayList) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(6680);
      paramn = j.ned;
      com.tencent.mm.sdk.platformtools.ad.i(j.bDO(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = new Bundle();
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        d.g.b.k.g(paramb, "rr");
        if ((paramb.auM() != null) && ((paramb.auM() instanceof jb)))
        {
          paramb = paramb.auM();
          if (paramb == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
            AppMethodBeat.o(6680);
            throw paramString;
          }
          paramb = (jb)paramb;
          paramString.putBoolean("success", true);
          paramString.putByteArray("response", paramb.toByteArray());
          paramn = paramb.CEC;
          d.g.b.k.g(paramn, "response.SceneControlList");
          if (!((Collection)paramn).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              paramn = r.bDU();
              localObject1 = new cmx();
              ((cmx)localObject1).CEC = paramb.CEC;
              paramn.encode("_msg_scene_strip", ((cmx)localObject1).toByteArray());
            }
          }
        }
      }
      for (;;)
      {
        paramString.putLong("start", this.neq);
        long l = System.currentTimeMillis();
        paramString.putLong("end", l);
        paramb = j.ned;
        com.tencent.mm.sdk.platformtools.ad.v(j.bDO(), "terry performance runCGI #" + paramb + ": " + this.neq + ',' + l);
        this.fLH.aA(paramString);
        paramString.putBoolean("mount", true);
        paramb = this.nes;
        d.g.b.k.g(paramb, "urls");
        paramb = ((Iterable)paramb).iterator();
        while (paramb.hasNext())
        {
          paramn = (String)paramb.next();
          d.g.b.k.g(paramn, "url");
          paramn = b.Py(paramn);
          localObject1 = j.ned;
          localObject1 = (ConcurrentLinkedDeque)j.bDM().get(paramn);
          Object localObject2 = j.ned;
          j.bDM().remove(paramn);
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (d.g.a.b)((Iterator)localObject1).next();
              paramString.putString("id", paramn);
              ((d.g.a.b)localObject2).aA(paramString);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getNativeService", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    s(boolean paramBoolean, String paramString, cbz paramcbz)
    {
      super();
    }
    
    public final String aTF()
    {
      if (this.neu) {}
      switch (paramcbz.gGx)
      {
      default: 
        return paramString1;
      }
      return "brandservice";
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getNativeActivity", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    t(boolean paramBoolean, String paramString, cbz paramcbz)
    {
      super();
    }
    
    public final String aTF()
    {
      if ((this.neu) && (paramcbz.gGx == 5)) {
        return ".ui.timeline.video.BizVideoDetailUI";
      }
      return paramString2;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean>
  {
    public static final u ney;
    
    static
    {
      AppMethodBeat.i(6684);
      ney = new u();
      AppMethodBeat.o(6684);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "intent", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class v<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<Intent, IPCVoid>
  {
    public static final v nez;
    
    static
    {
      AppMethodBeat.i(193097);
      nez = new v();
      AppMethodBeat.o(193097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */