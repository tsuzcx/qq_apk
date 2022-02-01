package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.luggage.h.c;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.e;
import d.a.ae;
import d.d.d<-Ljava.lang.Boolean;>;
import d.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
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
import org.xwalk.core.Log;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "manager", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1;", "clearAll", "", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "url", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "shouldPrefetch", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PrefetchJsAPI", "plugin-brandservice_release"})
public final class w
{
  private static final String TAG = "MicroMsg.WebPrefetcherManifest";
  private static final ReentrantLock olB;
  private static final Condition olC;
  private static final e olD;
  public static final w olE;
  
  static
  {
    AppMethodBeat.i(209979);
    olE = new w();
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    olB = localReentrantLock;
    olC = localReentrantLock.newCondition();
    olD = new e();
    AppMethodBeat.o(209979);
  }
  
  public static j XI(String paramString)
  {
    AppMethodBeat.i(209973);
    p.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    p.g(localUri, "uri");
    Object localObject1 = localUri.getHost();
    p.g(localObject1, "uri.host");
    String str1 = b.Xq((String)localObject1);
    localObject1 = t.okg;
    localObject1 = (ax)t.bPJ().aQb(str1);
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
              break label334;
            }
            i = 1;
            label92:
            if (i == 0) {
              break label357;
            }
          }
        }
      }
    }
    for (;;)
    {
      avd localavd;
      try
      {
        Object localObject3 = avc.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (avc)localObject1;
        if (localObject1 == null) {
          break label408;
        }
        localObject3 = ((avc)localObject1).Gtq;
        p.g(localObject3, "ResInfos");
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label408;
        }
        localavd = (avd)((Iterator)localObject3).next();
        if (localUri == null) {
          continue;
        }
        Object localObject4 = localUri.getPath();
        if (localObject4 == null) {
          continue;
        }
        String str2 = localavd.ujc;
        p.g(str2, "res.Path");
        if (c.B((String)localObject4, str2) != true) {
          continue;
        }
        localObject4 = t.okg;
        localObject4 = t.bPO();
        str2 = localavd.Gtr;
        p.g(str2, "res.ManifestUrl");
        if (!((v)localObject4).XH(b.Xq(str2)).exists()) {
          break label367;
        }
        Log.v(TAG, "match:#" + str1 + ", " + localavd.ujc + ", " + paramString);
        p.g(localavd, "res");
        paramString = new j((avc)localObject1, localavd, (byte)0);
        AppMethodBeat.o(209973);
        return paramString;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      label334:
      i = 0;
      break label92;
      label357:
      Object localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      label367:
      Log.w(TAG, "manifest lost:#" + str1 + ", " + localavd.ujc);
    }
    label408:
    Log.v(TAG, "not match:#" + str1 + ", " + paramString);
    AppMethodBeat.o(209973);
    return null;
  }
  
  public static avc XJ(String paramString)
  {
    AppMethodBeat.i(209974);
    p.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    if (localUri != null) {}
    for (paramString = localUri.getHost(); (localUri == null) || (paramString == null); paramString = null)
    {
      AppMethodBeat.o(209974);
      return null;
    }
    paramString = b.Xq(paramString);
    Object localObject1 = t.okg;
    localObject1 = (ax)t.bPJ().aQb(paramString);
    int i;
    if (localObject1 != null) {
      if (((ax)localObject1).containsKey(paramString))
      {
        paramString = ((ax)localObject1).decodeBytes(paramString);
        if (paramString != null) {
          if (paramString.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label257;
            }
            i = 1;
            label102:
            if (i == 0) {
              break label280;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = avc.class.newInstance();
        ((com.tencent.mm.bx.a)localObject1).parseFrom(paramString);
        paramString = (com.tencent.mm.bx.a)localObject1;
        paramString = (avc)paramString;
        if (paramString == null) {
          break label321;
        }
        localObject1 = paramString.Gtq;
        p.g(localObject1, "ResInfos");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label295;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        Object localObject4 = (avd)localObject3;
        String str = localUri.getPath();
        if (str == null) {
          break label290;
        }
        localObject4 = ((avd)localObject4).ujc;
        p.g(localObject4, "res.Path");
        if (c.B(str, (String)localObject4) != true) {
          break label290;
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
        label257:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break label102;
      label280:
      paramString = null;
      continue;
      paramString = null;
      continue;
      label290:
      i = 0;
    }
    label295:
    paramString.Gtq = new LinkedList((Collection)localObject1);
    AppMethodBeat.o(209974);
    return paramString;
    label321:
    AppMethodBeat.o(209974);
    return null;
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(209978);
    e locale = olD;
    synchronized (locale.olL)
    {
      Object localObject2 = (Map)locale.olL;
      Map localMap = (Map)new LinkedHashMap(ae.aji(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Map.Entry localEntry = (Map.Entry)localObject3;
        localEntry.getKey();
        locale.tS(((Number)localEntry.getValue()).intValue()).destroy();
        localMap.put(z.MKo, ((Map.Entry)localObject3).getValue());
      }
    }
    localObject1.olL.clear();
    z localz = z.MKo;
    AppMethodBeat.o(209978);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final Object a(String paramString, j paramj, d.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(209976);
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
      locala = d.d.a.a.MLc;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(209976);
        throw paramString;
      }
    }
    Object localObject = olD;
    String str = "__webprefetcher.fetch('" + paramString + "', '" + paramj.extInfo + "')";
    paramd.nWR = this;
    paramd.olg = paramString;
    paramd.olh = paramj;
    paramd.label = 1;
    paramd = ((e)localObject).a(paramj, str, paramd);
    paramj = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(209976);
      return locala;
      paramString = (String)paramd.olg;
      paramj = (j)localObject;
    }
    paramd = (String)paramj;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    boolean bool = p.i((String)paramj, "true");
    AppMethodBeat.o(209976);
    return Boolean.valueOf(bool);
  }
  
  /* Error */
  public final String a(final String paramString, j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 444
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 120
    //   11: invokestatic 126	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_2
    //   15: ldc_w 445
    //   18: invokestatic 126	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: new 447	d/g/b/y$f
    //   24: dup
    //   25: invokespecial 448	d/g/b/y$f:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: aconst_null
    //   33: putfield 451	d/g/b/y$f:MLV	Ljava/lang/Object;
    //   36: getstatic 100	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:olB	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: checkcast 453	java/util/concurrent/locks/Lock
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 456 1 0
    //   49: getstatic 109	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:olD	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/w$e;
    //   52: aload_2
    //   53: new 247	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 458
    //   60: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 411
    //   70: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: new 15	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w$d
    //   79: dup
    //   80: aload_2
    //   81: aload_1
    //   82: aload 4
    //   84: invokespecial 461	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w$d:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/j;Ljava/lang/String;Ld/g/b/y$f;)V
    //   87: checkcast 463	d/g/a/b
    //   90: invokevirtual 466	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w$e:a	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/j;Ljava/lang/String;Ld/g/a/b;)V
    //   93: getstatic 106	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:olC	Ljava/util/concurrent/locks/Condition;
    //   96: ldc2_w 467
    //   99: getstatic 474	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   102: invokeinterface 480 4 0
    //   107: pop
    //   108: aload_3
    //   109: invokeinterface 483 1 0
    //   114: aload 4
    //   116: getfield 451	d/g/b/y$f:MLV	Ljava/lang/Object;
    //   119: checkcast 425	java/lang/String
    //   122: ifnull +43 -> 165
    //   125: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:TAG	Ljava/lang/String;
    //   128: new 247	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 485
    //   135: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload 4
    //   140: getfield 451	d/g/b/y$f:MLV	Ljava/lang/Object;
    //   143: checkcast 425	java/lang/String
    //   146: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 487
    //   152: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 490	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 4
    //   167: getfield 451	d/g/b/y$f:MLV	Ljava/lang/Object;
    //   170: checkcast 425	java/lang/String
    //   173: ifnonnull +29 -> 202
    //   176: aload_1
    //   177: ldc_w 492
    //   180: invokestatic 497	d/n/n:nz	(Ljava/lang/String;Ljava/lang/String;)Z
    //   183: ifeq +19 -> 202
    //   186: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/w:TAG	Ljava/lang/String;
    //   189: ldc_w 499
    //   192: aload_1
    //   193: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokevirtual 505	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokestatic 508	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 4
    //   204: getfield 451	d/g/b/y$f:MLV	Ljava/lang/Object;
    //   207: checkcast 425	java/lang/String
    //   210: astore_1
    //   211: ldc_w 444
    //   214: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: areturn
    //   221: astore_1
    //   222: aload_3
    //   223: invokeinterface 483 1 0
    //   228: ldc_w 444
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
    //   0	241	0	this	w
    //   0	241	1	paramString	String
    //   0	241	2	paramj	j
    //   42	181	3	localLock	java.util.concurrent.locks.Lock
    //   28	175	4	localf	y.f
    // Exception table:
    //   from	to	target	type
    //   49	108	221	finally
    //   2	49	236	finally
    //   108	165	236	finally
    //   165	202	236	finally
    //   202	217	236	finally
    //   222	236	236	finally
  }
  
  public final Object b(j paramj, d.d.d<? super List<String>> paramd)
  {
    AppMethodBeat.i(209977);
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
      locala = d.d.a.a.MLc;
      switch (paramd.label)
      {
      default: 
        paramj = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(209977);
        throw paramj;
      }
    }
    Object localObject = olD;
    paramd.nWR = this;
    paramd.olg = paramj;
    paramd.label = 1;
    paramd = ((e)localObject).a(paramj, "__webprefetcher.getAllCaches()", paramd);
    paramj = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(209977);
      return locala;
      paramj = (j)localObject;
    }
    paramj = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ac.f((String)paramj), (d.g.a.m)c.olH);
    AppMethodBeat.o(209977);
    return paramj;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$PrefetchJsAPI;", "", "()V", "addCaches", "", "urls", "", "idkey", "id", "", "key", "value", "idkeyList", "list", "kv", "", "data", "log", "level", "tag", "msg", "plugin-brandservice_release"})
  static final class a
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void addCaches(String paramString)
    {
      AppMethodBeat.i(209949);
      p.h(paramString, "urls");
      w localw = w.olE;
      Log.i(w.getTAG(), "pending caches:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(209949);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkey(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(209952);
      com.tencent.mm.plugin.report.service.g.yhR.n(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(209952);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkeyList(String paramString)
    {
      AppMethodBeat.i(209953);
      p.h(paramString, "list");
      paramString = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ac.f(paramString), (d.g.a.m)a.olF);
      com.tencent.mm.plugin.report.service.g.yhR.b(new ArrayList((Collection)paramString), false);
      AppMethodBeat.o(209953);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void kv(int paramInt, String paramString)
    {
      AppMethodBeat.i(209951);
      p.h(paramString, "data");
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(paramInt, paramString);
      AppMethodBeat.o(209951);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void log(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(209950);
      p.h(paramString1, "tag");
      p.h(paramString2, "msg");
      paramString1 = "webPrefetcher[" + paramString1 + ']';
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(209950);
        return;
        Log.v(paramString1, paramString2);
        AppMethodBeat.o(209950);
        return;
        Log.d(paramString1, paramString2);
        AppMethodBeat.o(209950);
        return;
        Log.i(paramString1, paramString2);
        AppMethodBeat.o(209950);
        return;
        Log.w(paramString1, paramString2);
        AppMethodBeat.o(209950);
        return;
        Log.e(paramString1, paramString2);
        AppMethodBeat.o(209950);
        return;
        Log.f(paramString1, paramString2);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
    static final class a
      extends q
      implements d.g.a.m<Integer, com.tencent.mm.ac.f, IDKey>
    {
      public static final a olF;
      
      static
      {
        AppMethodBeat.i(209948);
        olF = new a();
        AppMethodBeat.o(209948);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", gfL={113}, m="getAllCaches")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
  static final class b
    extends d.d.b.a.d
  {
    int label;
    Object nWR;
    Object olg;
    
    b(w paramw, d.d.d paramd)
    {
      super();
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(209954);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.olG.b(null, this);
      AppMethodBeat.o(209954);
      return paramObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class c
    extends q
    implements d.g.a.m<Integer, com.tencent.mm.ac.f, String>
  {
    public static final c olH;
    
    static
    {
      AppMethodBeat.i(209956);
      olH = new c();
      AppMethodBeat.o(209956);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
  static final class d
    extends q
    implements d.g.a.b<String, z>
  {
    d(j paramj, String paramString, y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "baseScript", "", "getBaseScript", "()Ljava/lang/String;", "baseScript$delegate", "Lkotlin/Lazy;", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearAll", "", "create", "id", "script", "domain", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "evaluateJavascript", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCallback", "plugin-brandservice_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    private final d.f olK;
    final HashMap<String, Integer> olL;
    
    e()
    {
      AppMethodBeat.i(209970);
      this.olK = d.g.O((d.g.a.a)a.olM);
      this.olL = new HashMap();
      AppMethodBeat.o(209970);
    }
    
    private final void a(final String paramString1, final String paramString2, final String paramString3, final d.g.a.b<? super com.tencent.mm.plugin.appbrand.jsruntime.g, z> paramb)
    {
      AppMethodBeat.i(209967);
      Object localObject = w.olE;
      Log.i(w.getTAG(), "create domain:" + paramString3 + '#' + paramString1);
      localObject = bqj();
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)c.olS);
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).addJavascriptInterface(new w.a(), "__webprefetcher");
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).evaluateJavascript((String)this.olK.getValue() + paramString2, (ValueCallback)new b((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject, this, paramString2, paramString1, paramString3, paramb));
      AppMethodBeat.o(209967);
    }
    
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(209966);
      p.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.hv(paramInt);
      AppMethodBeat.o(209966);
      return paramIJSRuntime;
    }
    
    public final Object a(j paramj, String paramString, d.d.d<? super String> paramd)
    {
      AppMethodBeat.i(209969);
      d.d.h localh = new d.d.h(d.d.a.b.d(paramd));
      a(paramj, paramString, (d.g.a.b)new e((d.d.d)localh));
      paramj = localh.gfF();
      if (paramj == d.d.a.a.MLc) {
        p.h(paramd, "frame");
      }
      AppMethodBeat.o(209969);
      return paramj;
    }
    
    public final void a(j paramj, String paramString, final d.g.a.b<? super String, z> paramb)
    {
      AppMethodBeat.i(209968);
      p.h(paramj, "manifest");
      p.h(paramString, "script");
      p.h(paramb, "onCallback");
      String str = paramj.ojj.Gtr;
      p.g(str, "manifest.manifest.ManifestUrl");
      str = b.Xq(str);
      if (!this.olL.containsKey(str))
      {
        Object localObject = t.okg;
        localObject = com.tencent.mm.vfs.f.ah(t.bPO().XH(str));
        paramj = paramj.oji.Gtl;
        p.g(paramj, "manifest.domain.Domain");
        a(str, (String)localObject, paramj, (d.g.a.b)new d(paramString, paramb));
        AppMethodBeat.o(209968);
        return;
      }
      paramj = this.olL.get(str);
      if (paramj == null) {
        p.gfZ();
      }
      p.g(paramj, "contextMap[id]!!");
      tS(((Number)paramj).intValue()).evaluateJavascript(paramString, (ValueCallback)new x(paramb));
      AppMethodBeat.o(209968);
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(209965);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(209965);
      return paramConfig;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<String>
    {
      public static final a olM;
      
      static
      {
        AppMethodBeat.i(209959);
        olM = new a();
        AppMethodBeat.o(209959);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1$create$1$2"})
    static final class b<T>
      implements ValueCallback<String>
    {
      b(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, w.e parame, String paramString1, String paramString2, String paramString3, d.g.a.b paramb) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException"})
    static final class c
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      public static final c olS;
      
      static
      {
        AppMethodBeat.i(209962);
        olS = new c();
        AppMethodBeat.o(209962);
      }
      
      public final void u(String paramString1, String paramString2)
      {
        AppMethodBeat.i(209961);
        w localw = w.olE;
        Log.e(w.getTAG(), "JsException:" + paramString1 + '\n' + paramString2);
        AppMethodBeat.o(209961);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    static final class d
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsruntime.g, z>
    {
      d(String paramString, d.g.a.b paramb)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
    static final class e
      extends q
      implements d.g.a.b<String, z>
    {
      e(d.d.d paramd)
      {
        super();
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", gfL={106}, m="shouldPrefetch")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"shouldPrefetch", "", "url", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class f
    extends d.d.b.a.d
  {
    int label;
    Object nWR;
    Object olg;
    Object olh;
    
    f(w paramw, d.d.d paramd)
    {
      super();
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(209972);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.olG.a(null, null, this);
      AppMethodBeat.o(209972);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.w
 * JD-Core Version:    0.7.0.1
 */