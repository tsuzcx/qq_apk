package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import androidx.lifecycle.q;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.plugin.ay.c.b;
import com.tencent.mm.plugin.az.c.a;
import com.tencent.mm.plugin.az.e;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
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
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Ljava.lang.Integer;>;
import kotlin.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import kotlin.d.h;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "localManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$WebPrefetcherJsEngineImpl;", "manager", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "getManager", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "sMMTrimMemoryEventListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$MMTrimMemoryEventListener;", "clearAll", "", "createJsContext", "", "type", "", "url", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchEvent", "appId", "event", "data", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFetchPkgType", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "inject", "script", "onCallback", "Lkotlin/Function1;", "invoke", "func", "params", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "releaseEngine", "shouldFetchContent", "shouldPrefetch", "MMTrimMemoryEventListener", "WebPrefetcherJsEngineImpl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebPrefetcherManifest
{
  private static final String TAG;
  public static final WebPrefetcherManifest vUW = new WebPrefetcherManifest();
  private static final ReentrantLock vUX;
  private static final Condition vUY;
  private static a vUZ;
  private static MMTrimMemoryEventListener vVa;
  
  static
  {
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    vUX = localReentrantLock;
    vUY = localReentrantLock.newCondition();
  }
  
  public static com.tencent.mm.plugin.az.a ajG(String paramString)
  {
    s.u(paramString, "url");
    Object localObject = com.tencent.mm.plugin.az.c.WmU;
    localObject = r.vTf;
    return c.a.a(paramString, r.dfH());
  }
  
  public static ccy ajH(String paramString)
  {
    s.u(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    if (localUri == null)
    {
      paramString = null;
      if ((localUri != null) && (paramString != null)) {
        break label35;
      }
    }
    label35:
    do
    {
      return null;
      paramString = localUri.getHost();
      break;
      paramString = e.bim(paramString);
      localObject1 = r.vTf;
      localObject1 = (MultiProcessMMKV)r.dfH().findSlot(paramString);
      if (localObject1 != null) {
        break label187;
      }
      paramString = null;
      paramString = (ccy)paramString;
    } while (paramString == null);
    Object localObject1 = paramString.aams;
    s.s(localObject1, "ResInfos");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label271:
    label279:
    for (;;)
    {
      label107:
      if (!((Iterator)localObject2).hasNext()) {
        break label281;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (ccz)localObject3;
      String str = localUri.getPath();
      if (str != null)
      {
        localObject4 = ((ccz)localObject4).IcT;
        s.s(localObject4, "res.Path");
        if (com.tencent.luggage.l.c.L(str, (String)localObject4) != true) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label279;
        }
        ((Collection)localObject1).add(localObject3);
        break label107;
        label187:
        if (((MultiProcessMMKV)localObject1).containsKey(paramString))
        {
          paramString = ((MultiProcessMMKV)localObject1).decodeBytes(paramString);
          if (paramString != null)
          {
            if (paramString.length == 0)
            {
              i = 1;
              label212:
              if (i != 0) {
                break label250;
              }
            }
            for (i = 1;; i = 0)
            {
              for (;;)
              {
                if (i == 0) {
                  break label271;
                }
                try
                {
                  localObject1 = ccy.class.newInstance();
                  ((com.tencent.mm.bx.a)localObject1).parseFrom(paramString);
                  paramString = (com.tencent.mm.bx.a)localObject1;
                }
                catch (Exception paramString)
                {
                  label250:
                  Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
                }
              }
              i = 0;
              break label212;
            }
          }
        }
        paramString = null;
        break;
      }
    }
    label281:
    paramString.aams = new LinkedList((Collection)localObject1);
    return paramString;
  }
  
  public static void dgA()
  {
    a locala = vUZ;
    if (locala != null)
    {
      localObject = locala.iox();
      if (!(localObject instanceof Closeable)) {
        break label38;
      }
    }
    label38:
    for (Object localObject = (Closeable)localObject;; localObject = null)
    {
      IO.safeClose((Closeable)localObject);
      locala.destroy();
      vUZ = null;
      return;
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static Object j(String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    h localh = new h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject2 = vUW.dgz();
    Object localObject1 = (kotlin.g.a.b)new b(locald);
    s.u(paramString, "url");
    s.u(localObject1, "onCompleted");
    localObject2 = ((Iterable)((com.tencent.mm.plugin.az.c)localObject2).WmV).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.az.d)((Iterator)localObject2).next()).l(paramString, (kotlin.g.a.b)localObject1));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = Boolean.FALSE;
        localObject1 = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramString));
      }
      paramString = localh.kli();
      if (paramString == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      return paramString;
    }
  }
  
  public final Object a(com.tencent.mm.plugin.az.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
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
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = dgz();
    List localList = p.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.az.c)localObject).a(parama, "fetch", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      return locala;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.az.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    return Boolean.valueOf(s.p(parama, "true"));
  }
  
  /* Error */
  public final String a(final String paramString, com.tencent.mm.plugin.az.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 115
    //   5: invokestatic 121	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_2
    //   9: ldc_w 427
    //   12: invokestatic 121	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: new 429	kotlin/g/b/ah$f
    //   18: dup
    //   19: invokespecial 430	kotlin/g/b/ah$f:<init>	()V
    //   22: astore 4
    //   24: getstatic 104	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:vUX	Ljava/util/concurrent/locks/ReentrantLock;
    //   27: checkcast 432	java/util/concurrent/locks/Lock
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface 435 1 0
    //   37: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:vUW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;
    //   40: invokevirtual 299	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:dgz	()Lcom/tencent/mm/plugin/az/c;
    //   43: aload_2
    //   44: ldc_w 436
    //   47: aload_1
    //   48: invokestatic 439	kotlin/a/p:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   51: new 18	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$e
    //   54: dup
    //   55: aload 4
    //   57: aload_1
    //   58: invokespecial 442	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$e:<init>	(Lkotlin/g/b/ah$f;Ljava/lang/String;)V
    //   61: checkcast 302	kotlin/g/a/b
    //   64: invokevirtual 445	com/tencent/mm/plugin/az/c:a	(Lcom/tencent/mm/plugin/az/a;Ljava/lang/String;Ljava/util/List;Lkotlin/g/a/b;)V
    //   67: getstatic 110	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:vUY	Ljava/util/concurrent/locks/Condition;
    //   70: ldc2_w 446
    //   73: getstatic 453	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   76: invokeinterface 459 4 0
    //   81: pop
    //   82: aload_3
    //   83: invokeinterface 462 1 0
    //   88: aload 4
    //   90: getfield 465	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   93: ifnull +40 -> 133
    //   96: getstatic 99	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:TAG	Ljava/lang/String;
    //   99: new 395	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 467
    //   106: invokespecial 398	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload 4
    //   111: getfield 465	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   114: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc_w 469
    //   120: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 472	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: getfield 465	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   138: ifnonnull +27 -> 165
    //   141: aload_1
    //   142: ldc_w 474
    //   145: iconst_0
    //   146: invokestatic 480	kotlin/n/n:U	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   149: ifeq +16 -> 165
    //   152: getstatic 99	com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest:TAG	Ljava/lang/String;
    //   155: ldc_w 482
    //   158: aload_1
    //   159: invokestatic 486	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 4
    //   167: getfield 465	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   170: checkcast 374	java/lang/String
    //   173: astore_1
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_1
    //   177: areturn
    //   178: astore_1
    //   179: aload_3
    //   180: invokeinterface 462 1 0
    //   185: aload_1
    //   186: athrow
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	WebPrefetcherManifest
    //   0	192	1	paramString	String
    //   0	192	2	parama	com.tencent.mm.plugin.az.a
    //   30	150	3	localLock	java.util.concurrent.locks.Lock
    //   22	144	4	localf	ah.f
    // Exception table:
    //   from	to	target	type
    //   37	82	178	finally
    //   2	37	187	finally
    //   82	133	187	finally
    //   133	165	187	finally
    //   165	174	187	finally
    //   179	187	187	finally
  }
  
  public final Object b(com.tencent.mm.plugin.az.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    if ((paramd instanceof f))
    {
      localObject = (f)paramd;
      if ((((f)localObject).label & 0x80000000) != 0) {
        ((f)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new f(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = dgz();
    List localList = p.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.az.c)localObject).a(parama, "shouldFetchContent", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      return locala;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.az.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "shouldFetchContent: '" + paramd + "', " + paramString);
    return Boolean.valueOf(s.p(parama, "true"));
  }
  
  public final Object b(com.tencent.mm.plugin.az.a parama, kotlin.d.d<? super List<String>> paramd)
  {
    int j = 0;
    if ((paramd instanceof c))
    {
      localObject = (c)paramd;
      if ((((c)localObject).label & 0x80000000) != 0) {
        ((c)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super List<String>>)localObject;; paramd = new c(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = dgz();
    paramd.label = 1;
    paramd = com.tencent.mm.plugin.az.c.a((com.tencent.mm.plugin.az.c)localObject, parama, "getAllCaches", paramd);
    parama = paramd;
    if (paramd == locala)
    {
      return locala;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.az.a)localObject;
    }
    paramd = (String)parama;
    int i;
    if (paramd == null)
    {
      parama = "[]";
      parama = new com.tencent.mm.ad.f(parama);
      paramd = new LinkedList();
      int k = parama.length();
      if (k > 0)
      {
        i = j;
        do
        {
          j = i + 1;
          paramd.add(parama.getString(i));
          i = j;
        } while (j < k);
      }
      return (List)paramd;
    }
    if (!n.bp((CharSequence)paramd))
    {
      i = 1;
      label240:
      if (i == 0) {
        break label262;
      }
    }
    for (;;)
    {
      parama = paramd;
      if (paramd != null) {
        break;
      }
      parama = "[]";
      break;
      i = 0;
      break label240;
      label262:
      paramd = null;
    }
  }
  
  public final Object c(com.tencent.mm.plugin.az.a parama, String paramString, kotlin.d.d<? super Integer> paramd)
  {
    if ((paramd instanceof d))
    {
      localObject = (d)paramd;
      if ((((d)localObject).label & 0x80000000) != 0) {
        ((d)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Integer>)localObject;; paramd = new d(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = (CharSequence)parama.WmT.aamu;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return Integer.valueOf(1);
    }
    localObject = dgz();
    List localList = p.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = paramString;
    paramd.label = 1;
    paramd = ((com.tencent.mm.plugin.az.c)localObject).a(parama, "getFetchPkgType", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      return locala;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.az.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "getFetchPkgType: '" + paramd + "', " + paramString);
    i = Util.safeParseInt((String)parama);
    if (i != 0) {
      return Integer.valueOf(i);
    }
    return Integer.valueOf(1);
  }
  
  public final com.tencent.mm.plugin.az.c dgz()
  {
    try
    {
      if (vUZ == null) {
        vUZ = new a();
      }
      if (vVa == null)
      {
        localObject1 = com.tencent.mm.plugin.ay.c.Wmq;
        if (c.b.ipi())
        {
          localObject1 = new MMTrimMemoryEventListener();
          ((MMTrimMemoryEventListener)localObject1).alive();
          vVa = (MMTrimMemoryEventListener)localObject1;
        }
      }
      Object localObject1 = vUZ;
      s.checkNotNull(localObject1);
      localObject1 = (com.tencent.mm.plugin.az.c)localObject1;
      return localObject1;
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "()V", "callback", "", "event", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    public MMTrimMemoryEventListener()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$WebPrefetcherJsEngineImpl;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "()V", "clearCache", "", "domain", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends com.tencent.mm.plugin.az.c
  {
    public a()
    {
      k.WkZ.ioQ();
      a((com.tencent.mm.plugin.az.d)new a());
      a((com.tencent.mm.plugin.az.d)new l());
      a((com.tencent.mm.plugin.az.d)new com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c());
    }
    
    public final void aft(String paramString)
    {
      s.u(paramString, "domain");
      c.ajg(paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(kotlin.d.d<? super Boolean> paramd)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    int label;
    
    c(WebPrefetcherManifest paramWebPrefetcherManifest, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      this.result = paramObject;
      this.label |= 0x80000000;
      return this.vVb.b(null, (kotlin.d.d)this);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(WebPrefetcherManifest paramWebPrefetcherManifest, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      this.result = paramObject;
      this.label |= 0x80000000;
      return this.vVb.c(null, null, (kotlin.d.d)this);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bizId", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(ah.f<String> paramf, String paramString)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    f(WebPrefetcherManifest paramWebPrefetcherManifest, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      this.result = paramObject;
      this.label |= 0x80000000;
      return this.vVb.b(null, null, (kotlin.d.d)this);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    g(WebPrefetcherManifest paramWebPrefetcherManifest, kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      this.result = paramObject;
      this.label |= 0x80000000;
      return this.vVb.a(null, null, (kotlin.d.d)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest
 * JD-Core Version:    0.7.0.1
 */