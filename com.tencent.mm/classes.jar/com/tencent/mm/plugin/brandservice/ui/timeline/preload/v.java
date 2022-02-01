package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.luggage.h.c;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.e;
import d.a.ae;
import d.d.d<-Ljava.lang.Boolean;>;
import d.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.xwalk.core.Log;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "manager", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1;", "clearAll", "", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "url", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "shouldPrefetch", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PrefetchJsAPI", "plugin-brandservice_release"})
public final class v
{
  private static final String TAG = "MicroMsg.WebPrefetcherManifest";
  private static final ReentrantLock ngf;
  private static final Condition ngg;
  private static final e ngh;
  public static final v ngi;
  
  static
  {
    AppMethodBeat.i(193229);
    ngi = new v();
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    ngf = localReentrantLock;
    ngg = localReentrantLock.newCondition();
    ngh = new e();
    AppMethodBeat.o(193229);
  }
  
  public static i PO(String paramString)
  {
    AppMethodBeat.i(193224);
    d.g.b.k.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    d.g.b.k.g(localUri, "uri");
    Object localObject1 = localUri.getHost();
    d.g.b.k.g(localObject1, "uri.host");
    String str1 = b.Px((String)localObject1);
    localObject1 = s.neQ;
    localObject1 = (ax)s.bDV().aFe(str1);
    int i;
    if (localObject1 != null) {
      if (((ax)localObject1).containsKey(str1))
      {
        localObject1 = ((ax)localObject1).decodeBytes(str1);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label331;
            }
            i = 1;
            label92:
            if (i == 0) {
              break label354;
            }
          }
        }
      }
    }
    for (;;)
    {
      aod localaod;
      try
      {
        Object localObject3 = aoc.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (aoc)localObject1;
        if (localObject1 == null) {
          break label405;
        }
        localObject3 = ((aoc)localObject1).Dpo;
        d.g.b.k.g(localObject3, "ResInfos");
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label405;
        }
        localaod = (aod)((Iterator)localObject3).next();
        Object localObject4 = localUri.getPath();
        d.g.b.k.g(localObject4, "uri.path");
        String str2 = localaod.sdZ;
        d.g.b.k.g(str2, "res.Path");
        if (!c.a((String)localObject4, str2, true)) {
          continue;
        }
        localObject4 = s.neQ;
        localObject4 = s.bEa();
        str2 = localaod.Dpp;
        d.g.b.k.g(str2, "res.ManifestUrl");
        if (!((u)localObject4).PN(b.Px(str2)).exists()) {
          break label364;
        }
        Log.v(TAG, "match:#" + str1 + ", " + localaod.sdZ + ", " + paramString);
        d.g.b.k.g(localaod, "res");
        paramString = new i((aoc)localObject1, localaod);
        AppMethodBeat.o(193224);
        return paramString;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      label331:
      i = 0;
      break label92;
      label354:
      Object localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      label364:
      Log.w(TAG, "manifest lost:#" + str1 + ", " + localaod.sdZ);
    }
    label405:
    Log.v(TAG, "not match:#" + str1 + ", " + paramString);
    AppMethodBeat.o(193224);
    return null;
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(193228);
    e locale = ngh;
    synchronized (locale.ngp)
    {
      Object localObject2 = (Map)locale.ngp;
      Map localMap = (Map)new LinkedHashMap(ae.adL(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Map.Entry localEntry = (Map.Entry)localObject3;
        localEntry.getKey();
        locale.sy(((Number)localEntry.getValue()).intValue()).destroy();
        localMap.put(y.JfV, ((Map.Entry)localObject3).getValue());
      }
    }
    localObject1.ngp.clear();
    y localy = y.JfV;
    AppMethodBeat.o(193228);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final Object a(String paramString, i parami, d.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(193226);
    if ((paramd instanceof f))
    {
      localObject = (f)paramd;
      if ((((f)localObject).label & 0x80000000) != 0) {
        ((f)localObject).label += -2147483648;
      }
    }
    d.d.a.a locala;
    for (paramd = (d.d.d<? super Boolean>)localObject;; paramd = new f(this, paramd))
    {
      localObject = paramd.result;
      locala = d.d.a.a.JgJ;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(193226);
        throw paramString;
      }
    }
    Object localObject = ngh;
    String str = "__webprefetcher.fetch('" + paramString + "')";
    paramd.mTb = this;
    paramd.nfO = paramString;
    paramd.nfP = parami;
    paramd.label = 1;
    paramd = ((e)localObject).a(parami, str, paramd);
    parami = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(193226);
      return locala;
      paramString = (String)paramd.nfO;
      parami = (i)localObject;
    }
    paramd = (String)parami;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    boolean bool = d.g.b.k.g((String)parami, "true");
    AppMethodBeat.o(193226);
    return Boolean.valueOf(bool);
  }
  
  /* Error */
  public final String a(final String paramString, i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 421
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 120
    //   11: invokestatic 126	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_2
    //   15: ldc_w 422
    //   18: invokestatic 126	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: new 424	d/g/b/v$e
    //   24: dup
    //   25: invokespecial 425	d/g/b/v$e:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aconst_null
    //   33: putfield 428	d/g/b/v$e:Jhw	Ljava/lang/Object;
    //   36: getstatic 100	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v:ngf	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: checkcast 430	java/util/concurrent/locks/Lock
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 433 1 0
    //   49: getstatic 109	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v:ngh	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/v$e;
    //   52: aload_2
    //   53: new 248	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 435
    //   60: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 388
    //   70: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: new 15	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v$d
    //   79: dup
    //   80: aload_2
    //   81: aload_1
    //   82: aload 4
    //   84: invokespecial 438	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v$d:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;Ljava/lang/String;Ld/g/b/v$e;)V
    //   87: checkcast 440	d/g/a/b
    //   90: invokevirtual 443	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v$e:a	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/i;Ljava/lang/String;Ld/g/a/b;)V
    //   93: getstatic 106	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v:ngg	Ljava/util/concurrent/locks/Condition;
    //   96: ldc2_w 444
    //   99: getstatic 451	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   102: invokeinterface 457 4 0
    //   107: pop
    //   108: aload_3
    //   109: invokeinterface 460 1 0
    //   114: aload 4
    //   116: getfield 428	d/g/b/v$e:Jhw	Ljava/lang/Object;
    //   119: checkcast 402	java/lang/String
    //   122: ifnull +43 -> 165
    //   125: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v:TAG	Ljava/lang/String;
    //   128: new 248	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 462
    //   135: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload 4
    //   140: getfield 428	d/g/b/v$e:Jhw	Ljava/lang/Object;
    //   143: checkcast 402	java/lang/String
    //   146: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 464
    //   152: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 467	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 4
    //   167: getfield 428	d/g/b/v$e:Jhw	Ljava/lang/Object;
    //   170: checkcast 402	java/lang/String
    //   173: ifnonnull +29 -> 202
    //   176: aload_1
    //   177: ldc_w 469
    //   180: invokestatic 475	d/n/n:mA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   183: ifeq +19 -> 202
    //   186: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/v:TAG	Ljava/lang/String;
    //   189: ldc_w 477
    //   192: aload_1
    //   193: invokestatic 480	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokevirtual 483	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokestatic 486	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 4
    //   204: getfield 428	d/g/b/v$e:Jhw	Ljava/lang/Object;
    //   207: checkcast 402	java/lang/String
    //   210: astore_1
    //   211: ldc_w 421
    //   214: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: areturn
    //   221: astore_1
    //   222: aload_3
    //   223: invokeinterface 460 1 0
    //   228: ldc_w 421
    //   231: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	v
    //   0	241	1	paramString	String
    //   0	241	2	parami	i
    //   42	181	3	localLock	java.util.concurrent.locks.Lock
    //   28	175	4	locale	d.g.b.v.e
    // Exception table:
    //   from	to	target	type
    //   49	108	221	finally
    //   2	49	236	finally
    //   108	165	236	finally
    //   165	202	236	finally
    //   202	217	236	finally
    //   222	236	236	finally
  }
  
  public final Object b(i parami, d.d.d<? super List<String>> paramd)
  {
    AppMethodBeat.i(193227);
    if ((paramd instanceof b))
    {
      localObject = (b)paramd;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    d.d.a.a locala;
    for (paramd = (d.d.d<? super List<String>>)localObject;; paramd = new b(this, paramd))
    {
      localObject = paramd.result;
      locala = d.d.a.a.JgJ;
      switch (paramd.label)
      {
      default: 
        parami = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(193227);
        throw parami;
      }
    }
    Object localObject = ngh;
    paramd.mTb = this;
    paramd.nfO = parami;
    paramd.label = 1;
    paramd = ((e)localObject).a(parami, "__webprefetcher.getAllCaches()", paramd);
    parami = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(193227);
      return locala;
      parami = (i)localObject;
    }
    parami = com.tencent.mm.plugin.webview.k.a.a(new com.tencent.mm.ac.f((String)parami), (d.g.a.m)c.ngl);
    AppMethodBeat.o(193227);
    return parami;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$PrefetchJsAPI;", "", "()V", "addCaches", "", "urls", "", "idkey", "id", "", "key", "value", "idkeyList", "list", "kv", "", "data", "log", "level", "tag", "msg", "plugin-brandservice_release"})
  static final class a
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void addCaches(String paramString)
    {
      AppMethodBeat.i(193199);
      d.g.b.k.h(paramString, "urls");
      v localv = v.ngi;
      Log.i(v.getTAG(), "pending caches:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(193199);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkey(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(193202);
      com.tencent.mm.plugin.report.service.h.vKh.m(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(193202);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkeyList(String paramString)
    {
      AppMethodBeat.i(193203);
      d.g.b.k.h(paramString, "list");
      paramString = com.tencent.mm.plugin.webview.k.a.a(new com.tencent.mm.ac.f(paramString), (d.g.a.m)a.ngj);
      com.tencent.mm.plugin.report.service.h.vKh.b(new ArrayList((Collection)paramString), false);
      AppMethodBeat.o(193203);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void kv(int paramInt, String paramString)
    {
      AppMethodBeat.i(193201);
      d.g.b.k.h(paramString, "data");
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(paramInt, paramString);
      AppMethodBeat.o(193201);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void log(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(193200);
      d.g.b.k.h(paramString1, "tag");
      d.g.b.k.h(paramString2, "msg");
      paramString1 = "webPrefetcher[" + paramString1 + ']';
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193200);
        return;
        Log.v(paramString1, paramString2);
        AppMethodBeat.o(193200);
        return;
        Log.d(paramString1, paramString2);
        AppMethodBeat.o(193200);
        return;
        Log.i(paramString1, paramString2);
        AppMethodBeat.o(193200);
        return;
        Log.w(paramString1, paramString2);
        AppMethodBeat.o(193200);
        return;
        Log.e(paramString1, paramString2);
        AppMethodBeat.o(193200);
        return;
        Log.f(paramString1, paramString2);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.m<Integer, com.tencent.mm.ac.f, IDKey>
    {
      public static final a ngj;
      
      static
      {
        AppMethodBeat.i(193198);
        ngj = new a();
        AppMethodBeat.o(193198);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", l={105}, m="getAllCaches")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
  static final class b
    extends d.d.b.a.d
  {
    int label;
    Object mTb;
    Object nfO;
    
    b(v paramv, d.d.d paramd)
    {
      super();
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(193204);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ngk.b(null, this);
      AppMethodBeat.o(193204);
      return paramObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.m<Integer, com.tencent.mm.ac.f, String>
  {
    public static final c ngl;
    
    static
    {
      AppMethodBeat.i(193206);
      ngl = new c();
      AppMethodBeat.o(193206);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    d(i parami, String paramString, d.g.b.v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "baseScript", "", "getBaseScript", "()Ljava/lang/String;", "baseScript$delegate", "Lkotlin/Lazy;", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearAll", "", "create", "id", "script", "domain", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "evaluateJavascript", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCallback", "plugin-brandservice_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    private final d.f ngo;
    final HashMap<String, Integer> ngp;
    
    static
    {
      AppMethodBeat.i(193215);
      $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(e.class), "baseScript", "getBaseScript()Ljava/lang/String;")) };
      AppMethodBeat.o(193215);
    }
    
    e()
    {
      AppMethodBeat.i(193221);
      this.ngo = d.g.E((d.g.a.a)a.ngq);
      this.ngp = new HashMap();
      AppMethodBeat.o(193221);
    }
    
    private final void a(final String paramString1, final String paramString2, final String paramString3, final d.g.a.b<? super com.tencent.mm.plugin.appbrand.jsruntime.g, y> paramb)
    {
      AppMethodBeat.i(193218);
      Object localObject = v.ngi;
      Log.i(v.getTAG(), "create domain:" + paramString3 + '#' + paramString1);
      localObject = bfE();
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)c.ngw);
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).addJavascriptInterface(new v.a(), "__webprefetcher");
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).evaluateJavascript((String)this.ngo.getValue() + paramString2, (ValueCallback)new b((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject, this, paramString2, paramString1, paramString3, paramb));
      AppMethodBeat.o(193218);
    }
    
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(193217);
      d.g.b.k.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.hE(paramInt);
      AppMethodBeat.o(193217);
      return paramIJSRuntime;
    }
    
    public final Object a(i parami, String paramString, d.d.d<? super String> paramd)
    {
      AppMethodBeat.i(193220);
      d.d.h localh = new d.d.h(d.d.a.b.d(paramd));
      a(parami, paramString, (d.g.a.b)new e((d.d.d)localh));
      parami = localh.fvB();
      if (parami == d.d.a.a.JgJ) {
        d.g.b.k.h(paramd, "frame");
      }
      AppMethodBeat.o(193220);
      return parami;
    }
    
    public final void a(i parami, String paramString, final d.g.a.b<? super String, y> paramb)
    {
      AppMethodBeat.i(193219);
      d.g.b.k.h(parami, "manifest");
      d.g.b.k.h(paramString, "script");
      d.g.b.k.h(paramb, "onCallback");
      String str = parami.ndU.Dpp;
      d.g.b.k.g(str, "manifest.manifest.ManifestUrl");
      str = b.Px(str);
      if (!this.ngp.containsKey(str))
      {
        Object localObject = s.neQ;
        localObject = com.tencent.mm.vfs.f.ag(s.bEa().PN(str));
        parami = parami.ndT.Dpj;
        d.g.b.k.g(parami, "manifest.domain.Domain");
        a(str, (String)localObject, parami, (d.g.a.b)new d(paramString, paramb));
        AppMethodBeat.o(193219);
        return;
      }
      parami = this.ngp.get(str);
      if (parami == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.g(parami, "contextMap[id]!!");
      sy(((Number)parami).intValue()).evaluateJavascript(paramString, (ValueCallback)new w(paramb));
      AppMethodBeat.o(193219);
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(193216);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(193216);
      return paramConfig;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      public static final a ngq;
      
      static
      {
        AppMethodBeat.i(193209);
        ngq = new a();
        AppMethodBeat.o(193209);
      }
      
      a()
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1$create$1$2"})
    static final class b<T>
      implements ValueCallback<String>
    {
      b(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, v.e parame, String paramString1, String paramString2, String paramString3, d.g.a.b paramb) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException"})
    static final class c
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      public static final c ngw;
      
      static
      {
        AppMethodBeat.i(193212);
        ngw = new c();
        AppMethodBeat.o(193212);
      }
      
      public final void t(String paramString1, String paramString2)
      {
        AppMethodBeat.i(193211);
        v localv = v.ngi;
        Log.e(v.getTAG(), "JsException:" + paramString1 + '\n' + paramString2);
        AppMethodBeat.o(193211);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsruntime.g, y>
    {
      d(String paramString, d.g.a.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.b<String, y>
    {
      e(d.d.d paramd)
      {
        super();
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", l={100}, m="shouldPrefetch")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"shouldPrefetch", "", "url", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class f
    extends d.d.b.a.d
  {
    int label;
    Object mTb;
    Object nfO;
    Object nfP;
    
    f(v paramv, d.d.d paramd)
    {
      super();
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(193223);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ngk.a(null, null, this);
      AppMethodBeat.o(193223);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */