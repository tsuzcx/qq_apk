package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ad.c.a;
import com.tencent.mm.plugin.ad.e;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "manager", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1;", "clearAll", "", "dispatchEvent", "appId", "url", "event", "data", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "inject", "type", "", "script", "onCallback", "Lkotlin/Function1;", "invoke", "func", "params", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "shouldPrefetch", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-brandservice_release"})
public final class y
{
  private static final String TAG = "MicroMsg.WebPrefetcherManifest";
  private static final ReentrantLock pFc;
  private static final Condition pFd;
  private static final c pFe;
  public static final y pFf;
  
  static
  {
    AppMethodBeat.i(195761);
    pFf = new y();
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    pFc = localReentrantLock;
    pFd = localReentrantLock.newCondition();
    pFe = new c();
    AppMethodBeat.o(195761);
  }
  
  public static void a(com.tencent.mm.plugin.ad.a parama, String paramString, List<? extends Object> paramList, b<? super String, x> paramb)
  {
    AppMethodBeat.i(195759);
    p.h(parama, "manifest");
    p.h(paramString, "func");
    p.h(paramList, "params");
    p.h(paramb, "onCallback");
    pFe.a(parama, paramString, paramList, paramb);
    AppMethodBeat.o(195759);
  }
  
  public static com.tencent.mm.plugin.ad.a aiu(String paramString)
  {
    AppMethodBeat.i(195752);
    p.h(paramString, "url");
    Object localObject = com.tencent.mm.plugin.ad.c.ICA;
    localObject = v.pDG;
    paramString = c.a.a(paramString, v.coq());
    AppMethodBeat.o(195752);
    return paramString;
  }
  
  public static bhc aiv(String paramString)
  {
    AppMethodBeat.i(195753);
    p.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    if (localUri != null) {}
    for (paramString = localUri.getHost(); (localUri == null) || (paramString == null); paramString = null)
    {
      AppMethodBeat.o(195753);
      return null;
    }
    paramString = e.aWU(paramString);
    Object localObject1 = v.pDG;
    localObject1 = (MultiProcessMMKV)v.coq().findSlot(paramString);
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
              break label276;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = bhc.class.newInstance();
        ((com.tencent.mm.bw.a)localObject1).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject1;
        paramString = (bhc)paramString;
        if (paramString == null) {
          break label316;
        }
        localObject1 = paramString.LQU;
        p.g(localObject1, "ResInfos");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label291;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        Object localObject4 = (bhd)localObject3;
        String str = localUri.getPath();
        if (str == null) {
          break label286;
        }
        localObject4 = ((bhd)localObject4).xut;
        p.g(localObject4, "res.Path");
        if (com.tencent.luggage.h.c.B(str, (String)localObject4) != true) {
          break label286;
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
      label276:
      paramString = null;
      continue;
      paramString = null;
      continue;
      label286:
      i = 0;
    }
    label291:
    paramString.LQU = new LinkedList((Collection)localObject1);
    AppMethodBeat.o(195753);
    return paramString;
    label316:
    AppMethodBeat.o(195753);
    return null;
  }
  
  public static void b(com.tencent.mm.plugin.ad.a parama, String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(195758);
    p.h(parama, "manifest");
    p.h(paramString, "script");
    p.h(paramb, "onCallback");
    Object localObject = pFe;
    p.h(parama, "manifest");
    p.h(paramString, "script");
    p.h(paramb, "onCallback");
    localObject = ((Iterable)((com.tencent.mm.plugin.ad.c)localObject).ICu).iterator();
    while ((((Iterator)localObject).hasNext()) && (!((com.tencent.mm.plugin.ad.d)((Iterator)localObject).next()).a(parama, paramString, paramb))) {}
    AppMethodBeat.o(195758);
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(195757);
    c localc = pFe;
    synchronized (localc.IBO)
    {
      Object localObject2 = (Map)localc.IBO;
      Map localMap = (Map)new LinkedHashMap(ae.atJ(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Map.Entry localEntry = (Map.Entry)localObject3;
        localEntry.getKey();
        localc.xX(((Number)localEntry.getValue()).intValue()).destroy();
        localMap.put(x.SXb, ((Map.Entry)localObject3).getValue());
      }
    }
    localObject1.IBO.clear();
    x localx = x.SXb;
    AppMethodBeat.o(195757);
  }
  
  public static void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(195760);
    p.h(paramString3, "event");
    c localc = pFe;
    p.h(paramString3, "event");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (n.aL(localCharSequence)))
    {
      i = 1;
      if (i != 0)
      {
        paramString2 = (CharSequence)paramString2;
        if ((paramString2 != null) && (!n.aL(paramString2))) {
          break label130;
        }
      }
    }
    label130:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString2 = ((Iterable)localc.ICu).iterator();
        while ((paramString2.hasNext()) && (!((com.tencent.mm.plugin.ad.d)paramString2.next()).S(paramString1, paramString3, paramString4))) {}
      }
      AppMethodBeat.o(195760);
      return;
      i = 0;
      break;
    }
  }
  
  public final Object a(com.tencent.mm.plugin.ad.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(195755);
    if ((paramd instanceof d))
    {
      localObject = (d)paramd;
      if ((((d)localObject).label & 0x80000000) != 0) {
        ((d)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new d(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.SXO;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195755);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = pFe;
    List localList = j.listOf(new String[] { paramString, parama.extInfo });
    paramd.L$0 = this;
    paramd.pED = parama;
    paramd.pEE = paramString;
    paramd.label = 1;
    paramd = ((c)localObject).a(parama, "fetch", localList, paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(195755);
      return locala;
      paramString = (String)paramd.pEE;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ad.a)localObject;
    }
    paramd = (String)parama;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    boolean bool = p.j((String)parama, "true");
    AppMethodBeat.o(195755);
    return Boolean.valueOf(bool);
  }
  
  /* Error */
  public final String a(final String paramString, com.tencent.mm.plugin.ad.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 449
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 122
    //   11: invokestatic 111	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_2
    //   15: ldc 105
    //   17: invokestatic 111	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: new 451	kotlin/g/b/z$f
    //   23: dup
    //   24: invokespecial 452	kotlin/g/b/z$f:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aconst_null
    //   32: putfield 455	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   35: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:pFc	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: checkcast 457	java/util/concurrent/locks/Lock
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface 460 1 0
    //   48: getstatic 96	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:pFe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/y$c;
    //   51: aload_2
    //   52: ldc_w 461
    //   55: aload_1
    //   56: invokestatic 464	kotlin/a/j:listOf	(Ljava/lang/Object;)Ljava/util/List;
    //   59: new 8	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y$b
    //   62: dup
    //   63: aload_2
    //   64: aload_1
    //   65: aload 4
    //   67: invokespecial 467	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y$b:<init>	(Lcom/tencent/mm/plugin/ad/a;Ljava/lang/String;Lkotlin/g/b/z$f;)V
    //   70: checkcast 469	kotlin/g/a/b
    //   73: invokevirtual 116	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y$c:a	(Lcom/tencent/mm/plugin/ad/a;Ljava/lang/String;Ljava/util/List;Lkotlin/g/a/b;)V
    //   76: getstatic 93	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:pFd	Ljava/util/concurrent/locks/Condition;
    //   79: ldc2_w 470
    //   82: getstatic 477	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   85: invokeinterface 483 4 0
    //   90: pop
    //   91: aload_3
    //   92: invokeinterface 486 1 0
    //   97: aload 4
    //   99: getfield 455	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   102: checkcast 391	java/lang/String
    //   105: ifnull +43 -> 148
    //   108: getstatic 82	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:TAG	Ljava/lang/String;
    //   111: new 418	java/lang/StringBuilder
    //   114: dup
    //   115: ldc_w 488
    //   118: invokespecial 421	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload 4
    //   123: getfield 455	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   126: checkcast 391	java/lang/String
    //   129: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 490
    //   135: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 4
    //   150: getfield 455	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   153: checkcast 391	java/lang/String
    //   156: ifnonnull +30 -> 186
    //   159: aload_1
    //   160: ldc_w 495
    //   163: iconst_0
    //   164: invokestatic 499	kotlin/n/n:J	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   167: ifeq +19 -> 186
    //   170: getstatic 82	com/tencent/mm/plugin/brandservice/ui/timeline/preload/y:TAG	Ljava/lang/String;
    //   173: ldc_w 501
    //   176: aload_1
    //   177: invokestatic 504	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 507	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 510	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 4
    //   188: getfield 455	kotlin/g/b/z$f:SYG	Ljava/lang/Object;
    //   191: checkcast 391	java/lang/String
    //   194: astore_1
    //   195: ldc_w 449
    //   198: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: areturn
    //   205: astore_1
    //   206: aload_3
    //   207: invokeinterface 486 1 0
    //   212: ldc_w 449
    //   215: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	y
    //   0	225	1	paramString	String
    //   0	225	2	parama	com.tencent.mm.plugin.ad.a
    //   41	166	3	localLock	java.util.concurrent.locks.Lock
    //   27	160	4	localf	z.f
    // Exception table:
    //   from	to	target	type
    //   48	91	205	finally
    //   2	48	220	finally
    //   91	148	220	finally
    //   148	186	220	finally
    //   186	201	220	finally
    //   206	220	220	finally
  }
  
  public final Object b(com.tencent.mm.plugin.ad.a parama, kotlin.d.d<? super List<String>> paramd)
  {
    AppMethodBeat.i(195756);
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super List<String>>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.SXO;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195756);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = pFe;
    paramd.L$0 = this;
    paramd.pED = parama;
    paramd.label = 1;
    paramd = com.tencent.mm.plugin.ad.c.a((com.tencent.mm.plugin.ad.c)localObject, parama, "getAllCaches", paramd);
    parama = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(195756);
      return locala;
      ResultKt.throwOnFailure(localObject);
      parama = (com.tencent.mm.plugin.ad.a)localObject;
    }
    parama = (String)parama;
    int i;
    if (parama != null)
    {
      if (n.aL((CharSequence)parama)) {
        break label269;
      }
      i = 1;
      if (i == 0) {
        break label274;
      }
    }
    for (;;)
    {
      paramd = parama;
      if (parama == null) {
        paramd = "[]";
      }
      parama = new com.tencent.mm.ab.f(paramd);
      paramd = new LinkedList();
      int j = parama.length();
      i = 0;
      while (i < j)
      {
        paramd.add(parama.getString(((Number)Integer.valueOf(i)).intValue()));
        i += 1;
      }
      label269:
      i = 0;
      break;
      label274:
      parama = null;
    }
    parama = (List)paramd;
    AppMethodBeat.o(195756);
    return parama;
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", hxM={76}, m="getAllCaches")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object pED;
    
    a(y paramy, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(195747);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.pFg.b(null, this);
      AppMethodBeat.o(195747);
      return paramObject;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
  static final class b
    extends q
    implements b<String, x>
  {
    b(com.tencent.mm.plugin.ad.a parama, String paramString, z.f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "clearCache", "", "domain", "", "plugin-brandservice_release"})
  public static final class c
    extends com.tencent.mm.plugin.ad.c
  {
    c()
    {
      AppMethodBeat.i(195750);
      m.IAG.fWP();
      a((com.tencent.mm.plugin.ad.d)new a());
      a((com.tencent.mm.plugin.ad.d)new l());
      AppMethodBeat.o(195750);
    }
    
    public final void aer(String paramString)
    {
      AppMethodBeat.i(195749);
      p.h(paramString, "domain");
      c.ahS(paramString);
      AppMethodBeat.o(195749);
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", hxM={69}, m="shouldPrefetch")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"shouldPrefetch", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object pED;
    Object pEE;
    
    d(y paramy, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(195751);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.pFg.a(null, null, this);
      AppMethodBeat.o(195751);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.y
 * JD-Core Version:    0.7.0.1
 */