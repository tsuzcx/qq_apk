package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.plugin.aw.c.b;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.plugin.ax.e;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.j;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Ljava.lang.Integer;>;
import kotlin.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "localManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$WebPrefetcherJsEngineImpl;", "manager", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "getManager", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "sMMTrimMemoryEventListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$MMTrimMemoryEventListener;", "clearAll", "", "createJsContext", "", "type", "", "url", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchEvent", "appId", "event", "data", "fetchManifestDebug", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFetchPkgType", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "inject", "script", "onCallback", "Lkotlin/Function1;", "invoke", "func", "params", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "releaseEngine", "shouldFetchContent", "shouldPrefetch", "MMTrimMemoryEventListener", "WebPrefetcherJsEngineImpl", "plugin-brandservice_release"})
public final class w
{
  private static final String TAG = "MicroMsg.WebPrefetcherManifest";
  private static final ReentrantLock sPL;
  private static final Condition sPM;
  private static b sPN;
  private static a sPO;
  public static final w sPP;
  
  static
  {
    AppMethodBeat.i(266136);
    sPP = new w();
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    sPL = localReentrantLock;
    sPM = localReentrantLock.newCondition();
    AppMethodBeat.o(266136);
  }
  
  public static com.tencent.mm.plugin.ax.a aqh(String paramString)
  {
    AppMethodBeat.i(266119);
    kotlin.g.b.p.k(paramString, "url");
    Object localObject = com.tencent.mm.plugin.ax.c.PwQ;
    localObject = s.sNX;
    paramString = c.a.a(paramString, s.cCx());
    AppMethodBeat.o(266119);
    return paramString;
  }
  
  public static bom aqi(String paramString)
  {
    AppMethodBeat.i(266120);
    kotlin.g.b.p.k(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    if (localUri != null) {}
    for (paramString = localUri.getHost(); (localUri == null) || (paramString == null); paramString = null)
    {
      AppMethodBeat.o(266120);
      return null;
    }
    paramString = e.biE(paramString);
    Object localObject1 = s.sNX;
    localObject1 = (MultiProcessMMKV)s.cCx().findSlot(paramString);
    int i;
    if (localObject1 != null) {
      if (((MultiProcessMMKV)localObject1).containsKey(paramString))
      {
        paramString = ((MultiProcessMMKV)localObject1).decodeBytes(paramString);
        if (paramString != null) {
          if (paramString.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label255;
            }
            i = 1;
            label100:
            if (i == 0) {
              break label277;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = bom.class.newInstance();
        ((com.tencent.mm.cd.a)localObject1).parseFrom(paramString);
        paramString = (com.tencent.mm.cd.a)localObject1;
        paramString = (bom)paramString;
        if (paramString == null) {
          break label317;
        }
        localObject1 = paramString.SZy;
        kotlin.g.b.p.j(localObject1, "ResInfos");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label292;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        Object localObject4 = (bon)localObject3;
        String str = localUri.getPath();
        if (str == null) {
          break label287;
        }
        localObject4 = ((bon)localObject4).CqK;
        kotlin.g.b.p.j(localObject4, "res.Path");
        if (com.tencent.luggage.k.c.H(str, (String)localObject4) != true) {
          break label287;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        ((Collection)localObject1).add(localObject3);
        continue;
        i = 0;
      }
      catch (Exception paramString)
      {
        label255:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break label100;
      label277:
      paramString = null;
      continue;
      paramString = null;
      continue;
      label287:
      i = 0;
    }
    label292:
    paramString.SZy = new LinkedList((Collection)localObject1);
    AppMethodBeat.o(266120);
    return paramString;
    label317:
    AppMethodBeat.o(266120);
    return null;
  }
  
  public static Object b(String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(266130);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.k(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject2 = sPP.cDd();
    Object localObject1 = (kotlin.g.a.b)new c(locald);
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(localObject1, "onCompleted");
    localObject2 = ((Iterable)((com.tencent.mm.plugin.ax.c)localObject2).PwK).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.ax.d)((Iterator)localObject2).next()).g(paramString, (kotlin.g.a.b)localObject1));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = Boolean.FALSE;
        localObject1 = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramString));
      }
      paramString = localh.iBS();
      if (paramString == kotlin.d.a.a.aaAA) {
        kotlin.g.b.p.k(paramd, "frame");
      }
      AppMethodBeat.o(266130);
      return paramString;
    }
  }
  
  public static void cDe()
  {
    AppMethodBeat.i(266133);
    b localb = sPN;
    if (localb != null)
    {
      com.tencent.mm.plugin.appbrand.appcache.p localp2 = localb.gPi();
      com.tencent.mm.plugin.appbrand.appcache.p localp1 = localp2;
      if (!(localp2 instanceof Closeable)) {
        localp1 = null;
      }
      IO.safeClose((Closeable)localp1);
      localb.destroy();
    }
    sPN = null;
    AppMethodBeat.o(266133);
  }
  
  public static boolean cDf()
  {
    AppMethodBeat.i(266135);
    g.a locala = g.PHD;
    if ((g.a.gSI()) && (com.tencent.mm.plugin.webview.core.h.cqu().getInt("fetchManifestDebug", -1) == 1))
    {
      AppMethodBeat.o(266135);
      return true;
    }
    AppMethodBeat.o(266135);
    return false;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final Object a(com.tencent.mm.plugin.ax.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(266122);
    if ((paramd instanceof h))
    {
      localObject = (h)paramd;
      if ((((h)localObject).label & 0x80000000) != 0) {
        ((h)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new h(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266122);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = cDd();
    List localList = j.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = this;
    paramd.oDA = parama;
    paramd.pGq = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.ax.c)localObject).a(parama, "fetch", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(266122);
      return locala;
      paramString = (String)paramd.pGq;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ax.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    boolean bool = kotlin.g.b.p.h((String)parama, "true");
    AppMethodBeat.o(266122);
    return Boolean.valueOf(bool);
  }
  
  /* Error */
  public final String a(final String paramString, com.tencent.mm.plugin.ax.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 468
    //   5: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 127
    //   11: invokestatic 133	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_2
    //   15: ldc_w 469
    //   18: invokestatic 133	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: new 471	kotlin/g/b/aa$f
    //   24: dup
    //   25: invokespecial 472	kotlin/g/b/aa$f:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aconst_null
    //   33: putfield 475	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   36: getstatic 112	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:sPL	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: checkcast 477	java/util/concurrent/locks/Lock
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 480 1 0
    //   49: getstatic 105	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:sPP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/w;
    //   52: invokevirtual 290	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:cDd	()Lcom/tencent/mm/plugin/ax/c;
    //   55: aload_2
    //   56: ldc_w 481
    //   59: aload_1
    //   60: invokestatic 484	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   63: new 18	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w$f
    //   66: dup
    //   67: aload_2
    //   68: aload_1
    //   69: aload 4
    //   71: invokespecial 487	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w$f:<init>	(Lcom/tencent/mm/plugin/ax/a;Ljava/lang/String;Lkotlin/g/b/aa$f;)V
    //   74: checkcast 293	kotlin/g/a/b
    //   77: invokevirtual 490	com/tencent/mm/plugin/ax/c:a	(Lcom/tencent/mm/plugin/ax/a;Ljava/lang/String;Ljava/util/List;Lkotlin/g/a/b;)V
    //   80: getstatic 118	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:sPM	Ljava/util/concurrent/locks/Condition;
    //   83: ldc2_w 491
    //   86: getstatic 498	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   89: invokeinterface 504 4 0
    //   94: pop
    //   95: aload_3
    //   96: invokeinterface 507 1 0
    //   101: aload 4
    //   103: getfield 475	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   106: checkcast 412	java/lang/String
    //   109: ifnull +43 -> 152
    //   112: getstatic 107	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:TAG	Ljava/lang/String;
    //   115: new 439	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 509
    //   122: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: getfield 475	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   130: checkcast 412	java/lang/String
    //   133: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 511
    //   139: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 4
    //   154: getfield 475	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   157: checkcast 412	java/lang/String
    //   160: ifnonnull +30 -> 190
    //   163: aload_1
    //   164: ldc_w 516
    //   167: iconst_0
    //   168: invokestatic 522	kotlin/n/n:M	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   171: ifeq +19 -> 190
    //   174: getstatic 107	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:TAG	Ljava/lang/String;
    //   177: ldc_w 524
    //   180: aload_1
    //   181: invokestatic 527	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokevirtual 530	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 4
    //   192: getfield 475	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
    //   195: checkcast 412	java/lang/String
    //   198: astore_1
    //   199: ldc_w 468
    //   202: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: areturn
    //   209: astore_1
    //   210: aload_3
    //   211: invokeinterface 507 1 0
    //   216: ldc_w 468
    //   219: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	w
    //   0	229	1	paramString	String
    //   0	229	2	parama	com.tencent.mm.plugin.ax.a
    //   42	169	3	localLock	java.util.concurrent.locks.Lock
    //   28	163	4	localf	aa.f
    // Exception table:
    //   from	to	target	type
    //   49	95	209	finally
    //   2	49	224	finally
    //   95	152	224	finally
    //   152	190	224	finally
    //   190	205	224	finally
    //   210	224	224	finally
  }
  
  public final Object b(com.tencent.mm.plugin.ax.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(266123);
    if ((paramd instanceof g))
    {
      localObject = (g)paramd;
      if ((((g)localObject).label & 0x80000000) != 0) {
        ((g)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new g(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266123);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = cDd();
    List localList = j.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = this;
    paramd.oDA = parama;
    paramd.pGq = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.ax.c)localObject).a(parama, "shouldFetchContent", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(266123);
      return locala;
      paramString = (String)paramd.pGq;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ax.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "shouldFetchContent: '" + paramd + "', " + paramString);
    boolean bool = kotlin.g.b.p.h((String)parama, "true");
    AppMethodBeat.o(266123);
    return Boolean.valueOf(bool);
  }
  
  public final Object b(com.tencent.mm.plugin.ax.a parama, kotlin.d.d<? super List<String>> paramd)
  {
    AppMethodBeat.i(266127);
    if ((paramd instanceof d))
    {
      localObject = (d)paramd;
      if ((((d)localObject).label & 0x80000000) != 0) {
        ((d)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super List<String>>)localObject;; paramd = new d(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266127);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = cDd();
    paramd.L$0 = this;
    paramd.oDA = parama;
    paramd.label = 1;
    paramd = com.tencent.mm.plugin.ax.c.a((com.tencent.mm.plugin.ax.c)localObject, parama, "getAllCaches", paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(266127);
      return locala;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ax.a)localObject;
    }
    parama = (String)parama;
    int i;
    if (parama != null)
    {
      if (n.ba((CharSequence)parama)) {
        break label270;
      }
      i = 1;
      if (i == 0) {
        break label275;
      }
    }
    for (;;)
    {
      paramd = parama;
      if (parama == null) {
        paramd = "[]";
      }
      parama = new f(paramd);
      paramd = new LinkedList();
      int j = parama.length();
      i = 0;
      while (i < j)
      {
        paramd.add(parama.getString(((Number)Integer.valueOf(i)).intValue()));
        i += 1;
      }
      label270:
      i = 0;
      break;
      label275:
      parama = null;
    }
    parama = (List)paramd;
    AppMethodBeat.o(266127);
    return parama;
  }
  
  public final Object c(com.tencent.mm.plugin.ax.a parama, String paramString, kotlin.d.d<? super Integer> paramd)
  {
    AppMethodBeat.i(266124);
    if ((paramd instanceof e))
    {
      localObject = (e)paramd;
      if ((((e)localObject).label & 0x80000000) != 0) {
        ((e)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Integer>)localObject;; paramd = new e(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266124);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = (CharSequence)parama.PwJ.SZA;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266124);
      return Integer.valueOf(1);
    }
    localObject = cDd();
    List localList = j.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = this;
    paramd.oDA = parama;
    paramd.pGq = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.ax.c)localObject).a(parama, "getFetchPkgType", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(266124);
      return locala;
      paramString = (String)paramd.pGq;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ax.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "getFetchPkgType: '" + paramd + "', " + paramString);
    i = ((Number)Integer.valueOf(Util.safeParseInt((String)parama))).intValue();
    if (i != 0)
    {
      AppMethodBeat.o(266124);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(266124);
    return Integer.valueOf(1);
  }
  
  public final com.tencent.mm.plugin.ax.c cDd()
  {
    try
    {
      AppMethodBeat.i(266132);
      if (sPN == null) {
        sPN = new b();
      }
      if (sPO == null)
      {
        localObject1 = com.tencent.mm.plugin.aw.c.Pwj;
        if (c.b.gPS())
        {
          localObject1 = new a();
          ((a)localObject1).alive();
          sPO = (a)localObject1;
        }
      }
      Object localObject1 = sPN;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = (com.tencent.mm.plugin.ax.c)localObject1;
      AppMethodBeat.o(266132);
      return localObject1;
    }
    finally {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "()V", "callback", "", "event", "plugin-brandservice_release"})
  static final class a
    extends IListener<mv>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$WebPrefetcherJsEngineImpl;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "()V", "clearCache", "", "domain", "", "plugin-brandservice_release"})
  static final class b
    extends com.tencent.mm.plugin.ax.c
  {
    public b()
    {
      AppMethodBeat.i(266006);
      m.PuL.gPx();
      a((com.tencent.mm.plugin.ax.d)new a());
      a((com.tencent.mm.plugin.ax.d)new l());
      a((com.tencent.mm.plugin.ax.d)new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c());
      AppMethodBeat.o(266006);
    }
    
    public final void aml(String paramString)
    {
      AppMethodBeat.i(266005);
      kotlin.g.b.p.k(paramString, "domain");
      c.apF(paramString);
      AppMethodBeat.o(266005);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(kotlin.d.d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    
    d(w paramw, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(258549);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPQ.b(null, this);
      AppMethodBeat.o(258549);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getFetchPkgType", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    
    e(w paramw, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(257965);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPQ.c(null, null, this);
      AppMethodBeat.o(257965);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.b<String, x>
  {
    f(com.tencent.mm.plugin.ax.a parama, String paramString, aa.f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"shouldFetchContent", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    
    g(w paramw, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263699);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPQ.b(null, null, this);
      AppMethodBeat.o(263699);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"shouldPrefetch", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class h
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    
    h(w paramw, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266033);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.sPQ.a(null, null, this);
      AppMethodBeat.o(266033);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.w
 * JD-Core Version:    0.7.0.1
 */