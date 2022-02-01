package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.luggage.h.c;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.k;
import d.d.d<-Ljava.lang.Boolean;>;
import d.d.d<-Ljava.util.List<Ljava.lang.String;>;>;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "manager", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1;", "clearAll", "", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "url", "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "shouldPrefetch", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PrefetchJsAPI", "plugin-brandservice_release"})
public final class x
{
  private static final String TAG = "MicroMsg.WebPrefetcherManifest";
  private static final ReentrantLock ors;
  private static final Condition ort;
  private static final e oru;
  public static final x orv;
  
  static
  {
    AppMethodBeat.i(208967);
    orv = new x();
    TAG = "MicroMsg.WebPrefetcherManifest";
    ReentrantLock localReentrantLock = new ReentrantLock();
    ors = localReentrantLock;
    ort = localReentrantLock.newCondition();
    oru = new e();
    AppMethodBeat.o(208967);
  }
  
  public static j Yv(String paramString)
  {
    AppMethodBeat.i(208961);
    p.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    p.g(localUri, "uri");
    Object localObject1 = localUri.getHost();
    p.g(localObject1, "uri.host");
    String str1 = b.Yc((String)localObject1);
    localObject1 = t.oqh;
    localObject1 = (ay)t.bQI().aRy(str1);
    int i;
    if (localObject1 != null) {
      if (((ay)localObject1).containsKey(str1))
      {
        localObject1 = ((ay)localObject1).decodeBytes(str1);
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
      avt localavt;
      try
      {
        Object localObject3 = avs.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (avs)localObject1;
        if (localObject1 == null) {
          break label408;
        }
        localObject3 = ((avs)localObject1).GMO;
        p.g(localObject3, "ResInfos");
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label408;
        }
        localavt = (avt)((Iterator)localObject3).next();
        if (localUri == null) {
          continue;
        }
        Object localObject4 = localUri.getPath();
        if (localObject4 == null) {
          continue;
        }
        String str2 = localavt.uuA;
        p.g(str2, "res.Path");
        if (c.B((String)localObject4, str2) != true) {
          continue;
        }
        localObject4 = t.oqh;
        localObject4 = t.bQN();
        str2 = localavt.GMP;
        p.g(str2, "res.ManifestUrl");
        if (!((v)localObject4).Yu(b.Yc(str2)).exists()) {
          break label367;
        }
        Log.v(TAG, "match:#" + str1 + ", " + localavt.uuA + ", " + paramString);
        p.g(localavt, "res");
        paramString = new j((avs)localObject1, localavt, (byte)0);
        AppMethodBeat.o(208961);
        return paramString;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
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
      Log.w(TAG, "manifest lost:#" + str1 + ", " + localavt.uuA);
    }
    label408:
    Log.v(TAG, "not match:#" + str1 + ", " + paramString);
    AppMethodBeat.o(208961);
    return null;
  }
  
  public static avs Yw(String paramString)
  {
    AppMethodBeat.i(208962);
    p.h(paramString, "url");
    Uri localUri = Uri.parse(paramString);
    if (localUri != null) {}
    for (paramString = localUri.getHost(); (localUri == null) || (paramString == null); paramString = null)
    {
      AppMethodBeat.o(208962);
      return null;
    }
    paramString = b.Yc(paramString);
    Object localObject1 = t.oqh;
    localObject1 = (ay)t.bQI().aRy(paramString);
    int i;
    if (localObject1 != null) {
      if (((ay)localObject1).containsKey(paramString))
      {
        paramString = ((ay)localObject1).decodeBytes(paramString);
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
        localObject1 = avs.class.newInstance();
        ((com.tencent.mm.bw.a)localObject1).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject1;
        paramString = (avs)paramString;
        if (paramString == null) {
          break label321;
        }
        localObject1 = paramString.GMO;
        p.g(localObject1, "ResInfos");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label295;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        Object localObject4 = (avt)localObject3;
        String str = localUri.getPath();
        if (str == null) {
          break label290;
        }
        localObject4 = ((avt)localObject4).uuA;
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
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
    paramString.GMO = new LinkedList((Collection)localObject1);
    AppMethodBeat.o(208962);
    return paramString;
    label321:
    AppMethodBeat.o(208962);
    return null;
  }
  
  public static void clearAll()
  {
    AppMethodBeat.i(208966);
    e locale = oru;
    synchronized (locale.orC)
    {
      Object localObject2 = (Map)locale.orC;
      Map localMap = (Map)new LinkedHashMap(d.a.ae.ajS(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Map.Entry localEntry = (Map.Entry)localObject3;
        localEntry.getKey();
        locale.tY(((Number)localEntry.getValue()).intValue()).destroy();
        localMap.put(z.Nhr, ((Map.Entry)localObject3).getValue());
      }
    }
    localObject1.orC.clear();
    z localz = z.Nhr;
    AppMethodBeat.o(208966);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final Object a(String paramString, j paramj, d.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(208964);
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
      locala = d.d.a.a.Nif;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(208964);
        throw paramString;
      }
    }
    Object localObject = oru;
    String str = "__webprefetcher.fetch('" + paramString + "', '" + paramj.extInfo + "')";
    paramd.ocA = this;
    paramd.oqW = paramString;
    paramd.oqX = paramj;
    paramd.label = 1;
    paramd = ((e)localObject).a(paramj, str, paramd);
    paramj = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(208964);
      return locala;
      paramString = (String)paramd.oqW;
      paramj = (j)localObject;
    }
    paramd = (String)paramj;
    Log.v(TAG, "shouldPrefetch: '" + paramd + "', " + paramString);
    boolean bool = p.i((String)paramj, "true");
    AppMethodBeat.o(208964);
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
    //   33: putfield 451	d/g/b/y$f:NiY	Ljava/lang/Object;
    //   36: getstatic 100	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x:ors	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: checkcast 453	java/util/concurrent/locks/Lock
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 456 1 0
    //   49: getstatic 109	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x:oru	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/x$e;
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
    //   76: new 15	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x$d
    //   79: dup
    //   80: aload_2
    //   81: aload_1
    //   82: aload 4
    //   84: invokespecial 461	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x$d:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/j;Ljava/lang/String;Ld/g/b/y$f;)V
    //   87: checkcast 463	d/g/a/b
    //   90: invokevirtual 466	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x$e:a	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/j;Ljava/lang/String;Ld/g/a/b;)V
    //   93: getstatic 106	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x:ort	Ljava/util/concurrent/locks/Condition;
    //   96: ldc2_w 467
    //   99: getstatic 474	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   102: invokeinterface 480 4 0
    //   107: pop
    //   108: aload_3
    //   109: invokeinterface 483 1 0
    //   114: aload 4
    //   116: getfield 451	d/g/b/y$f:NiY	Ljava/lang/Object;
    //   119: checkcast 425	java/lang/String
    //   122: ifnull +43 -> 165
    //   125: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x:TAG	Ljava/lang/String;
    //   128: new 247	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 485
    //   135: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload 4
    //   140: getfield 451	d/g/b/y$f:NiY	Ljava/lang/Object;
    //   143: checkcast 425	java/lang/String
    //   146: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 487
    //   152: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 490	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 4
    //   167: getfield 451	d/g/b/y$f:NiY	Ljava/lang/Object;
    //   170: checkcast 425	java/lang/String
    //   173: ifnonnull +29 -> 202
    //   176: aload_1
    //   177: ldc_w 492
    //   180: invokestatic 497	d/n/n:nF	(Ljava/lang/String;Ljava/lang/String;)Z
    //   183: ifeq +19 -> 202
    //   186: getstatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/x:TAG	Ljava/lang/String;
    //   189: ldc_w 499
    //   192: aload_1
    //   193: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokevirtual 505	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokestatic 508	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 4
    //   204: getfield 451	d/g/b/y$f:NiY	Ljava/lang/Object;
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
    //   0	241	0	this	x
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
    AppMethodBeat.i(208965);
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
      locala = d.d.a.a.Nif;
      switch (paramd.label)
      {
      default: 
        paramj = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(208965);
        throw paramj;
      }
    }
    Object localObject = oru;
    paramd.ocA = this;
    paramd.oqW = paramj;
    paramd.label = 1;
    paramd = ((e)localObject).a(paramj, "__webprefetcher.getAllCaches()", paramd);
    paramj = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(208965);
      return locala;
      paramj = (j)localObject;
    }
    paramj = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ab.f((String)paramj), (d.g.a.m)c.ory);
    AppMethodBeat.o(208965);
    return paramj;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$PrefetchJsAPI;", "", "()V", "addCaches", "", "urls", "", "idkey", "id", "", "key", "value", "idkeyList", "list", "kv", "", "data", "log", "level", "tag", "msg", "plugin-brandservice_release"})
  static final class a
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void addCaches(String paramString)
    {
      AppMethodBeat.i(208938);
      p.h(paramString, "urls");
      x localx = x.orv;
      Log.i(x.getTAG(), "pending caches:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(208938);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkey(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(208941);
      com.tencent.mm.plugin.report.service.g.yxI.n(paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(208941);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void idkeyList(String paramString)
    {
      AppMethodBeat.i(208942);
      p.h(paramString, "list");
      paramString = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ab.f(paramString), (d.g.a.m)a.orw);
      com.tencent.mm.plugin.report.service.g.yxI.b(new ArrayList((Collection)paramString), false);
      AppMethodBeat.o(208942);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void kv(int paramInt, String paramString)
    {
      AppMethodBeat.i(208940);
      p.h(paramString, "data");
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramInt, paramString);
      AppMethodBeat.o(208940);
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void log(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(208939);
      p.h(paramString1, "tag");
      p.h(paramString2, "msg");
      paramString1 = "webPrefetcher[" + paramString1 + ']';
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208939);
        return;
        Log.v(paramString1, paramString2);
        AppMethodBeat.o(208939);
        return;
        Log.d(paramString1, paramString2);
        AppMethodBeat.o(208939);
        return;
        Log.i(paramString1, paramString2);
        AppMethodBeat.o(208939);
        return;
        Log.w(paramString1, paramString2);
        AppMethodBeat.o(208939);
        return;
        Log.e(paramString1, paramString2);
        AppMethodBeat.o(208939);
        return;
        Log.f(paramString1, paramString2);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
    static final class a
      extends q
      implements d.g.a.m<Integer, com.tencent.mm.ab.f, IDKey>
    {
      public static final a orw;
      
      static
      {
        AppMethodBeat.i(208937);
        orw = new a();
        AppMethodBeat.o(208937);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", gkn={114}, m="getAllCaches")
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
  static final class b
    extends d.d.b.a.d
  {
    int label;
    Object ocA;
    Object oqW;
    
    b(x paramx, d.d.d paramd)
    {
      super();
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(208943);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.orx.b(null, this);
      AppMethodBeat.o(208943);
      return paramObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class c
    extends q
    implements d.g.a.m<Integer, com.tencent.mm.ab.f, String>
  {
    public static final c ory;
    
    static
    {
      AppMethodBeat.i(208945);
      ory = new c();
      AppMethodBeat.o(208945);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
  static final class d
    extends q
    implements d.g.a.b<String, z>
  {
    d(j paramj, String paramString, y.f paramf)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "baseScript", "", "getBaseScript", "()Ljava/lang/String;", "baseScript$delegate", "Lkotlin/Lazy;", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearAll", "", "create", "id", "script", "domain", "bizScene", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "evaluateJavascript", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCallback", "plugin-brandservice_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    private final d.f orB;
    final HashMap<String, Integer> orC;
    
    e()
    {
      AppMethodBeat.i(208958);
      this.orB = d.g.O((d.g.a.a)a.orD);
      this.orC = new HashMap();
      AppMethodBeat.o(208958);
    }
    
    private final void a(final String paramString1, final String paramString2, final String paramString3, final int paramInt, final d.g.a.b<? super com.tencent.mm.plugin.appbrand.jsruntime.g, z> paramb)
    {
      AppMethodBeat.i(224146);
      Object localObject = x.orv;
      Log.i(x.getTAG(), "create domain:" + paramString3 + '#' + paramString1);
      localObject = bqS();
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)new b(this, paramString3, paramString1, paramInt, paramString2, paramb));
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).addJavascriptInterface(new x.a(), "__webprefetcher");
      ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject).evaluateJavascript((String)this.orB.getValue() + paramString2, (ValueCallback)new c((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject, this, paramString3, paramString1, paramInt, paramString2, paramb));
      AppMethodBeat.o(224146);
    }
    
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(208954);
      p.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.hv(paramInt);
      AppMethodBeat.o(208954);
      return paramIJSRuntime;
    }
    
    public final Object a(j paramj, String paramString, d.d.d<? super String> paramd)
    {
      AppMethodBeat.i(208957);
      d.d.h localh = new d.d.h(d.d.a.b.d(paramd));
      a(paramj, paramString, (d.g.a.b)new e((d.d.d)localh));
      paramj = localh.gkh();
      if (paramj == d.d.a.a.Nif) {
        p.h(paramd, "frame");
      }
      AppMethodBeat.o(208957);
      return paramj;
    }
    
    public final void a(j paramj, String paramString, final d.g.a.b<? super String, z> paramb)
    {
      AppMethodBeat.i(208956);
      p.h(paramj, "manifest");
      p.h(paramString, "script");
      p.h(paramb, "onCallback");
      String str1 = paramj.opj.GMP;
      p.g(str1, "manifest.manifest.ManifestUrl");
      str1 = b.Yc(str1);
      if (!this.orC.containsKey(str1))
      {
        Object localObject = t.oqh;
        localObject = com.tencent.mm.vfs.l.ah(t.bQN().Yu(str1));
        String str2 = paramj.opi.GMJ;
        p.g(str2, "manifest.domain.Domain");
        a(str1, (String)localObject, str2, paramj.nLC, (d.g.a.b)new d(paramString, paramb));
        AppMethodBeat.o(208956);
        return;
      }
      paramj = this.orC.get(str1);
      if (paramj == null) {
        p.gkB();
      }
      p.g(paramj, "contextMap[id]!!");
      tY(((Number)paramj).intValue()).evaluateJavascript(paramString, (ValueCallback)new y(paramb));
      AppMethodBeat.o(208956);
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(208953);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(208953);
      return paramConfig;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<String>
    {
      public static final a orD;
      
      static
      {
        AppMethodBeat.i(208948);
        orD = new a();
        AppMethodBeat.o(208948);
      }
      
      a()
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1$create$1$1"})
    static final class b
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      b(x.e parame, String paramString1, String paramString2, int paramInt, String paramString3, d.g.a.b paramb) {}
      
      public final void u(String paramString1, String paramString2)
      {
        AppMethodBeat.i(208949);
        x localx = x.orv;
        Log.e(x.getTAG(), "JsException:" + paramString1 + '\n' + paramString2);
        com.tencent.mm.plugin.report.service.g.yxI.f(21039, new Object[] { paramString3, paramString1, paramString1, paramString1 + " \t " + paramString2, Integer.valueOf(paramInt) });
        AppMethodBeat.o(208949);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1$create$1$2"})
    static final class c<T>
      implements ValueCallback<String>
    {
      c(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, x.e parame, String paramString1, String paramString2, int paramInt, String paramString3, d.g.a.b paramb) {}
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    static final class d
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsruntime.g, z>
    {
      d(String paramString, d.g.a.b paramb)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f="WebPrefetcherManifest.kt", gkn={107}, m="shouldPrefetch")
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"shouldPrefetch", "", "url", "", "manifest", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class f
    extends d.d.b.a.d
  {
    int label;
    Object ocA;
    Object oqW;
    Object oqX;
    
    f(x paramx, d.d.d paramd)
    {
      super();
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(208960);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.orx.a(null, null, this);
      AppMethodBeat.o(208960);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.x
 * JD-Core Version:    0.7.0.1
 */