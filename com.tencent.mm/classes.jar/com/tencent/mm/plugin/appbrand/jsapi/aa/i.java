package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.gme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "lastDoCgiTick", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "mayReportOnForeground", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class i
{
  public static final i ssg;
  private static final long ssh;
  private static final MTimerHandler ssi;
  private static final HashSet<w> ssj;
  private static final b ssk;
  private static long ssl;
  
  static
  {
    AppMethodBeat.i(50694);
    ssg = new i();
    ssh = TimeUnit.MINUTES.toMillis(5L);
    ssi = new MTimerHandler(Looper.getMainLooper(), i..ExternalSyntheticLambda2.INSTANCE, true);
    ssj = new HashSet();
    ssk = new b();
    AppMethodBeat.o(50694);
  }
  
  private static final void a(g paramg, String arg1, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    AppMethodBeat.i(325982);
    kotlin.g.b.s.u(paramg, "$component");
    int i;
    if (paramb == null)
    {
      i = -1;
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(325982);
      return;
      i = e.$EnumSwitchMapping$0[paramb.ordinal()];
      break;
      ssg.a(i.c.ssu);
      synchronized (ssj)
      {
        paramb = ssj;
        paramg = paramg.getRuntime();
        if (paramg == null)
        {
          paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
          AppMethodBeat.o(325982);
          throw paramg;
        }
      }
      paramb.remove((w)paramg);
      if (ssj.size() == 0) {
        ssi.stopTimer();
      }
      paramg = ah.aiuX;
      AppMethodBeat.o(325982);
      return;
      ssg.cuu();
    }
  }
  
  private final void a(i.c paramc)
  {
    AppMethodBeat.i(50692);
    a(ssk.cux(), paramc);
    AppMethodBeat.o(50692);
  }
  
  private static final void a(List paramList, int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(325986);
    kotlin.g.b.s.u(paramList, "$queue");
    Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    paramc = new WeakHashMap();
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        a(paramc, ((d)localObject2).aqX(), (d)localObject2);
      }
      h.OAn.p(1074L, 2L, paramList.size());
      h.OAn.p(1074L, 5L, 1L);
      paramList = paramc.entrySet();
      kotlin.g.b.s.s(paramList, "component2EntryMap.entries");
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label624;
      }
      localObject2 = (Map.Entry)paramList.next();
      paramc = (f)((Map.Entry)localObject2).getKey();
      if ((paramc != null) && (paramc.isRunning()))
      {
        paramc = new d.b().h(paramc);
        localObject1 = new HashMap();
        if (paramInt1 == 0) {}
        for (int i = paramInt2;; i = -9999)
        {
          ((HashMap)localObject1).put("errcode", Integer.valueOf(i));
          ((HashMap)localObject1).put("errmsg", paramString);
          localObject3 = ((Map.Entry)localObject2).getValue();
          kotlin.g.b.s.s(localObject3, "entry.value");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(Long.valueOf(((d)((Iterator)localObject4).next()).content.length()));
          }
          paramList = ((Iterable)paramList).iterator();
          i = 0;
          while (paramList.hasNext())
          {
            localObject1 = (d)paramList.next();
            if (!ssk.a((d)localObject1)) {
              a(paramc, ((d)localObject1).aqX(), (d)localObject1);
            } else {
              i += 1;
            }
          }
          if (i <= 0) {
            break;
          }
          h.OAn.p(1074L, 0L, i);
          break;
        }
        ((HashMap)localObject1).put("dataSize", Long.valueOf(p.D((Iterable)localObject3)));
        localObject2 = ((Map.Entry)localObject2).getValue();
        kotlin.g.b.s.s(localObject2, "entry.value");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(Integer.valueOf(((d)((Iterator)localObject3).next()).id));
        }
        ((HashMap)localObject1).put("idList", new JSONArray((Collection)p.p((Iterable)localObject2)));
        localObject2 = ah.aiuX;
        paramc.K((Map)localObject1).cpV();
      }
    }
    label624:
    AppMethodBeat.o(325986);
  }
  
  private final void a(List<d> paramList, i.c paramc)
  {
    for (;;)
    {
      eth localeth;
      try
      {
        AppMethodBeat.i(50693);
        ssi.startTimer(ssh);
        ssl = Util.currentTicks();
        Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + paramList.size() + ", reason=" + paramc.name());
        paramc = (Collection)paramList;
        if (paramc == null) {
          break label319;
        }
        if (paramc.isEmpty())
        {
          break label319;
          if (i != 0) {
            AppMethodBeat.o(50693);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        h.OAn.p(1074L, 1L, paramList.size());
        h.OAn.p(1074L, 4L, 1L);
        paramc = new c.a();
        paramc.uri = "/cgi-bin/mmbiz-bin/wxartrappsvr/route";
        paramc.funcId = 2946;
        localeth = new eth();
        Object localObject1 = ((Iterable)paramList).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (d)((Iterator)localObject1).next();
          LinkedList localLinkedList = localeth.ToF;
          gme localgme = new gme();
          localgme.type = ((d)localObject2).type;
          localgme.ZqH = com.tencent.mm.bx.b.bsj(((d)localObject2).content);
          localgme.appid = ((d)localObject2).appId;
          localObject2 = ah.aiuX;
          localLinkedList.add(localgme);
          continue;
        }
        localObject1 = ah.aiuX;
      }
      finally {}
      paramc.otE = ((a)localeth);
      paramc.otF = ((a)new eti());
      IPCRunCgi.a(paramc.bEF(), new i..ExternalSyntheticLambda0(paramList));
      AppMethodBeat.o(50693);
      continue;
      label319:
      int i = 1;
    }
  }
  
  private static final void a(WeakHashMap<f, LinkedList<d>> paramWeakHashMap, f paramf, d paramd)
  {
    AppMethodBeat.i(325984);
    if (paramf != null)
    {
      LinkedList localLinkedList2 = (LinkedList)paramWeakHashMap.get(paramf);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        ((Map)paramWeakHashMap).put(paramf, localLinkedList1);
      }
      localLinkedList1.addLast(paramd);
    }
    AppMethodBeat.o(325984);
  }
  
  private final void cuu()
  {
    try
    {
      AppMethodBeat.i(325972);
      if ((ssl > 0L) && (Util.ticksToNow(ssl) >= ssh)) {
        a(i.c.sss);
      }
      AppMethodBeat.o(325972);
      return;
    }
    finally {}
  }
  
  private static final boolean cuv()
  {
    AppMethodBeat.i(325980);
    ssg.a(i.c.sss);
    AppMethodBeat.o(325980);
    return true;
  }
  
  /* Error */
  public final void a(g paramg, int paramInt1, int paramInt2, String paramString, d.c paramc)
  {
    // Byte code:
    //   0: ldc_w 527
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 528
    //   10: invokestatic 167	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload 4
    //   15: ldc_w 529
    //   18: invokestatic 167	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc_w 530
    //   26: invokestatic 167	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: getstatic 154	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssj	Ljava/util/HashSet;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: getstatic 154	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssj	Ljava/util/HashSet;
    //   40: astore 8
    //   42: aload_1
    //   43: invokevirtual 190	com/tencent/mm/plugin/appbrand/g:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   46: astore 9
    //   48: aload 9
    //   50: ifnonnull +33 -> 83
    //   53: new 192	java/lang/NullPointerException
    //   56: dup
    //   57: ldc 194
    //   59: invokespecial 197	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: ldc_w 527
    //   66: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload 7
    //   74: monitorexit
    //   75: ldc_w 527
    //   78: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    //   83: aload 8
    //   85: aload 9
    //   87: checkcast 199	com/tencent/mm/plugin/appbrand/w
    //   90: invokevirtual 531	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   93: istore 6
    //   95: iload 6
    //   97: ifeq +22 -> 119
    //   100: getstatic 154	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssj	Ljava/util/HashSet;
    //   103: invokevirtual 206	java/util/HashSet:size	()I
    //   106: iconst_1
    //   107: if_icmpne +12 -> 119
    //   110: getstatic 149	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssi	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   113: getstatic 130	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssh	J
    //   116: invokevirtual 414	com/tencent/mm/sdk/platformtools/MTimerHandler:startTimer	(J)V
    //   119: iload 6
    //   121: ifeq +21 -> 142
    //   124: aload_1
    //   125: invokevirtual 190	com/tencent/mm/plugin/appbrand/g:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   128: getfield 537	com/tencent/mm/plugin/appbrand/AppBrandRuntime:qsB	Lcom/tencent/mm/plugin/appbrand/b/c;
    //   131: new 539	com/tencent/mm/plugin/appbrand/jsapi/aa/i$$ExternalSyntheticLambda1
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 542	com/tencent/mm/plugin/appbrand/jsapi/aa/i$$ExternalSyntheticLambda1:<init>	(Lcom/tencent/mm/plugin/appbrand/g;)V
    //   139: invokevirtual 547	com/tencent/mm/plugin/appbrand/b/c:a	(Lcom/tencent/mm/plugin/appbrand/b/c$a;)V
    //   142: getstatic 215	kotlin/ah:aiuX	Lkotlin/ah;
    //   145: astore 8
    //   147: aload 7
    //   149: monitorexit
    //   150: getstatic 290	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   153: ldc2_w 291
    //   156: lconst_0
    //   157: lconst_1
    //   158: invokevirtual 301	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   161: aload_0
    //   162: monitorenter
    //   163: getstatic 157	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssk	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$b;
    //   166: new 16	com/tencent/mm/plugin/appbrand/jsapi/aa/i$d
    //   169: dup
    //   170: iload_2
    //   171: iload_3
    //   172: aload 4
    //   174: aload 5
    //   176: aload_1
    //   177: checkcast 317	com/tencent/mm/plugin/appbrand/jsapi/f
    //   180: invokespecial 550	com/tencent/mm/plugin/appbrand/jsapi/aa/i$d:<init>	(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/aa/d$c;Lcom/tencent/mm/plugin/appbrand/jsapi/f;)V
    //   183: invokevirtual 379	com/tencent/mm/plugin/appbrand/jsapi/aa/i$b:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$d;)Z
    //   186: pop
    //   187: getstatic 553	com/tencent/mm/plugin/appbrand/jsapi/aa/i$e:avl	[I
    //   190: aload 5
    //   192: invokevirtual 556	com/tencent/mm/plugin/appbrand/jsapi/aa/d$c:ordinal	()I
    //   195: iaload
    //   196: iconst_1
    //   197: if_icmpne +31 -> 228
    //   200: getstatic 116	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssg	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i;
    //   203: getstatic 157	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssk	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$b;
    //   206: invokevirtual 223	com/tencent/mm/plugin/appbrand/jsapi/aa/i$b:cux	()Ljava/util/List;
    //   209: getstatic 559	com/tencent/mm/plugin/appbrand/jsapi/aa/i$c:ssv	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$c;
    //   212: invokespecial 226	com/tencent/mm/plugin/appbrand/jsapi/aa/i:a	(Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$c;)V
    //   215: getstatic 215	kotlin/ah:aiuX	Lkotlin/ah;
    //   218: astore_1
    //   219: aload_0
    //   220: monitorexit
    //   221: ldc_w 527
    //   224: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: getstatic 157	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssk	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$b;
    //   231: invokevirtual 562	com/tencent/mm/plugin/appbrand/jsapi/aa/i$b:cuw	()J
    //   234: ldc2_w 563
    //   237: lcmp
    //   238: iflt -23 -> 215
    //   241: getstatic 116	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssg	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i;
    //   244: getstatic 157	com/tencent/mm/plugin/appbrand/jsapi/aa/i:ssk	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$b;
    //   247: invokevirtual 223	com/tencent/mm/plugin/appbrand/jsapi/aa/i$b:cux	()Ljava/util/List;
    //   250: getstatic 567	com/tencent/mm/plugin/appbrand/jsapi/aa/i$c:sst	Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$c;
    //   253: invokespecial 226	com/tencent/mm/plugin/appbrand/jsapi/aa/i:a	(Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/aa/i$c;)V
    //   256: goto -41 -> 215
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: ldc_w 527
    //   265: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_1
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	i
    //   0	270	1	paramg	g
    //   0	270	2	paramInt1	int
    //   0	270	3	paramInt2	int
    //   0	270	4	paramString	String
    //   0	270	5	paramc	d.c
    //   93	27	6	bool	boolean
    //   32	116	7	localHashSet	HashSet
    //   40	106	8	localObject	Object
    //   46	40	9	localAppBrandRuntime	com.tencent.mm.plugin.appbrand.AppBrandRuntime
    // Exception table:
    //   from	to	target	type
    //   37	48	71	finally
    //   53	71	71	finally
    //   83	95	71	finally
    //   100	119	71	finally
    //   124	142	71	finally
    //   142	147	71	finally
    //   163	215	259	finally
    //   215	219	259	finally
    //   228	256	259	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    private static final i.a.a ssm;
    final d.c ssn;
    private final int sso;
    private final LinkedList<i.d> ssp;
    private long ssq;
    
    static
    {
      AppMethodBeat.i(50676);
      ssm = new i.a.a((byte)0);
      AppMethodBeat.o(50676);
    }
    
    public a(d.c paramc, int paramInt)
    {
      AppMethodBeat.i(50675);
      this.ssn = paramc;
      this.sso = paramInt;
      this.ssp = new LinkedList();
      AppMethodBeat.o(50675);
    }
    
    public final boolean a(i.d paramd)
    {
      AppMethodBeat.i(50673);
      kotlin.g.b.s.u(paramd, "entry");
      if (paramd.ssx > this.sso)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.ssn.name() + "], entry[" + paramd.appId + ", " + paramd.id + ", " + paramd.type + ']');
        AppMethodBeat.o(50673);
        return false;
      }
      synchronized (this.ssp)
      {
        this.ssp.addLast(paramd);
        this.ssq += paramd.content.length();
        paramd = ah.aiuX;
        AppMethodBeat.o(50673);
        return true;
      }
    }
    
    public final long cuw()
    {
      synchronized (this.ssp)
      {
        long l = this.ssq;
        return l;
      }
    }
    
    public final List<i.d> jK(long paramLong)
    {
      AppMethodBeat.i(50674);
      long l;
      for (;;)
      {
        synchronized (this.ssp)
        {
          Object localObject1;
          if (this.ssp.isEmpty())
          {
            localObject1 = (List)ab.aivy;
            AppMethodBeat.o(50674);
            return localObject1;
          }
          if (paramLong < 0L)
          {
            paramLong = ((i.d)this.ssp.peekFirst()).content.length();
            localObject1 = new LinkedList();
            l = paramLong;
            if ((this.ssp.isEmpty()) || (l <= 0L)) {
              break;
            }
            Object localObject3 = this.ssp.pollFirst();
            Object localObject4 = (i.d)localObject3;
            ((i.d)localObject4).ssx += 1;
            l -= ((i.d)localObject4).content.length();
            localObject4 = ah.aiuX;
            ((LinkedList)localObject1).addLast(localObject3);
          }
        }
      }
      this.ssq -= paramLong - l;
      if (this.ssq < 0L)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.ssn.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
        this.ssq = 0L;
      }
      List localList = (List)localObject2;
      AppMethodBeat.o(50674);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    private final i.a[] ssr;
    
    public b()
    {
      AppMethodBeat.i(50679);
      this.ssr = new i.a[] { new i.a(d.c.sse, 3), new i.a(d.c.ssc, 3), new i.a(d.c.ssd, 1) };
      AppMethodBeat.o(50679);
    }
    
    public final boolean a(i.d paramd)
    {
      AppMethodBeat.i(50677);
      kotlin.g.b.s.u(paramd, "entry");
      i.a[] arrayOfa = this.ssr;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        i.a locala = arrayOfa[i];
        if (locala.ssn == paramd.ssn)
        {
          boolean bool = locala.a(paramd);
          AppMethodBeat.o(50677);
          return bool;
        }
        i += 1;
      }
      AppMethodBeat.o(50677);
      return false;
    }
    
    public final long cuw()
    {
      AppMethodBeat.i(325971);
      i.a[] arrayOfa = this.ssr;
      Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        localCollection.add(Long.valueOf(arrayOfa[i].cuw()));
        i += 1;
      }
      long l = p.D((Iterable)localCollection);
      AppMethodBeat.o(325971);
      return l;
    }
    
    public final List<i.d> cux()
    {
      AppMethodBeat.i(50678);
      Object localObject = new LinkedList();
      long l1 = 0L;
      i.a[] arrayOfa = this.ssr;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        i.a locala = arrayOfa[i];
        long l2 = locala.cuw();
        ((LinkedList)localObject).addAll((Collection)locala.jK(65536L - l1));
        l1 += l2 - locala.cuw();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(50678);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "getComponentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    final String appId;
    final String content;
    private final WeakReference<f> hml;
    final int id;
    final d.c ssn;
    int ssx;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, d.c paramc, f paramf)
    {
      AppMethodBeat.i(50684);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.ssn = paramc;
      this.hml = new WeakReference(paramf);
      paramString = paramf.getAppId();
      kotlin.g.b.s.s(paramString, "component.appId");
      this.appId = paramString;
      AppMethodBeat.o(50684);
    }
    
    public final f aqX()
    {
      AppMethodBeat.i(50683);
      f localf = (f)this.hml.get();
      AppMethodBeat.o(50683);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.i
 * JD-Core Version:    0.7.0.1
 */