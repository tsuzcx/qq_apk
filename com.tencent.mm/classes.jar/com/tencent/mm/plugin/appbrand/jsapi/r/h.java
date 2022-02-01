package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.y;
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
import org.json.JSONArray;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "periodReport", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class h
{
  private static final HashSet<o> kJA;
  private static final b kJB;
  public static final h kJC;
  private static final long kJy;
  private static final au kJz;
  
  static
  {
    AppMethodBeat.i(50694);
    kJC = new h();
    kJy = TimeUnit.MINUTES.toMillis(5L);
    kJz = new au(Looper.getMainLooper(), (au.a)g.kJR, true);
    kJA = new HashSet();
    kJB = new b();
    AppMethodBeat.o(50694);
  }
  
  public static void a(d paramd, int paramInt1, int paramInt2, String paramString, c.c paramc)
  {
    AppMethodBeat.i(50691);
    k.h(paramd, "component");
    k.h(paramString, "content");
    k.h(paramc, "priority");
    AppBrandRuntime localAppBrandRuntime;
    synchronized (kJA)
    {
      localObject = kJA;
      localAppBrandRuntime = paramd.getRuntime();
      if (localAppBrandRuntime == null)
      {
        paramd = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(50691);
        throw paramd;
      }
    }
    boolean bool = ((HashSet)localObject).add((o)localAppBrandRuntime);
    if ((bool) && (kJA.size() == 1)) {
      kJz.Ah(kJy);
    }
    if (bool)
    {
      localObject = paramd.getRuntime();
      k.g(localObject, "component.runtime");
      ((AppBrandRuntime)localObject).aSC().a((c.a)new f(paramd));
    }
    Object localObject = y.KTp;
    com.tencent.mm.plugin.report.service.h.wUl.A(1074L, 0L);
    kJB.a(new d(paramInt1, paramInt2, paramString, paramc, (com.tencent.mm.plugin.appbrand.jsapi.c)paramd));
    paramd = kJB.kJI;
    paramString = (Collection)new ArrayList(paramd.length);
    paramInt2 = paramd.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramString.add(Long.valueOf(paramd[paramInt1].size()));
      paramInt1 += 1;
    }
    if (j.w((Iterable)paramString) >= 65536L) {
      a(kJB.biI(), c.kJK);
    }
    AppMethodBeat.o(50691);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(50692);
    a(kJB.biI(), paramc);
    AppMethodBeat.o(50692);
  }
  
  private static void a(List<d> paramList, c paramc)
  {
    AppMethodBeat.i(50693);
    kJz.Ah(kJy);
    ac.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + paramList.size() + ", reason=" + paramc.name());
    paramc = (Collection)paramList;
    if ((paramc == null) || (paramc.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50693);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.n(1074L, 1L, paramList.size());
    com.tencent.mm.plugin.report.service.h.wUl.A(1074L, 4L);
    paramc = new b.a();
    paramc.Am("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
    paramc.op(2946);
    crk localcrk = new crk();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      LinkedList localLinkedList = localcrk.FEl;
      ebp localebp = new ebp();
      localebp.type = locald.type;
      localebp.EuB = com.tencent.mm.bw.b.aIw(locald.content);
      localebp.djj = locald.appId;
      localLinkedList.add(localebp);
    }
    paramc.c((a)localcrk);
    paramc.d((a)new crl());
    IPCRunCgi.a(paramc.aAz(), (IPCRunCgi.a)new e(paramList));
    AppMethodBeat.o(50693);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
  static final class a
  {
    @Deprecated
    public static final a kJH;
    private final LinkedList<h.d> kJD;
    private long kJE;
    final c.c kJF;
    private final int kJG;
    
    static
    {
      AppMethodBeat.i(50676);
      kJH = new a((byte)0);
      AppMethodBeat.o(50676);
    }
    
    public a(c.c paramc, int paramInt)
    {
      AppMethodBeat.i(50675);
      this.kJF = paramc;
      this.kJG = paramInt;
      this.kJD = new LinkedList();
      AppMethodBeat.o(50675);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50673);
      k.h(paramd, "entry");
      if (paramd.kJN > this.kJG)
      {
        ac.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.kJF.name() + "], entry[" + paramd.appId + ", " + paramd.id + ", " + paramd.type + ']');
        AppMethodBeat.o(50673);
        return false;
      }
      synchronized (this.kJD)
      {
        this.kJD.addLast(paramd);
        this.kJE += paramd.content.length();
        paramd = y.KTp;
        AppMethodBeat.o(50673);
        return true;
      }
    }
    
    public final List<h.d> qQ(long paramLong)
    {
      AppMethodBeat.i(50674);
      long l;
      for (;;)
      {
        synchronized (this.kJD)
        {
          Object localObject1;
          if (this.kJD.isEmpty())
          {
            localObject1 = (List)d.a.v.KTF;
            AppMethodBeat.o(50674);
            return localObject1;
          }
          if (paramLong < 0L)
          {
            paramLong = ((h.d)this.kJD.peekFirst()).content.length();
            localObject1 = new LinkedList();
            l = paramLong;
            if ((this.kJD.isEmpty()) || (l <= 0L)) {
              break;
            }
            Object localObject3 = this.kJD.pollFirst();
            h.d locald = (h.d)localObject3;
            locald.kJN += 1;
            l -= locald.content.length();
            ((LinkedList)localObject1).addLast(localObject3);
          }
        }
      }
      this.kJE -= paramLong - l;
      if (this.kJE < 0L)
      {
        ac.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.kJF.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
        this.kJE = 0L;
      }
      List localList = (List)localObject2;
      AppMethodBeat.o(50674);
      return localList;
    }
    
    public final long size()
    {
      synchronized (this.kJD)
      {
        long l = this.kJE;
        return l;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
  static final class b
  {
    final h.a[] kJI;
    
    public b()
    {
      AppMethodBeat.i(50679);
      this.kJI = new h.a[] { new h.a(c.c.kJu, 3), new h.a(c.c.kJv, 1) };
      AppMethodBeat.o(50679);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50677);
      k.h(paramd, "entry");
      h.a[] arrayOfa = this.kJI;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        if (locala.kJF == paramd.kJF)
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
    
    public final List<h.d> biI()
    {
      AppMethodBeat.i(50678);
      Object localObject = new LinkedList();
      long l1 = 0L;
      h.a[] arrayOfa = this.kJI;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        long l2 = locala.size();
        ((LinkedList)localObject).addAll((Collection)locala.qQ(65536L - l1));
        l1 += l2 - locala.size();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(50678);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "plugin-appbrand-integration_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(50680);
      c localc1 = new c("TIMER_PERIOD", 0);
      kJJ = localc1;
      c localc2 = new c("REACH_SLICE_LIMIT", 1);
      kJK = localc2;
      c localc3 = new c("RUNTIME_KILLED", 2);
      kJL = localc3;
      kJM = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(50680);
    }
    
    private c() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String appId;
    private final WeakReference<com.tencent.mm.plugin.appbrand.jsapi.c> cMz;
    final String content;
    final int id;
    final c.c kJF;
    int kJN;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, c.c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
    {
      AppMethodBeat.i(50684);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.kJF = paramc;
      this.cMz = new WeakReference(paramc1);
      paramString = paramc1.getAppId();
      k.g(paramString, "component.appId");
      this.appId = paramString;
      AppMethodBeat.o(50684);
    }
    
    public final com.tencent.mm.plugin.appbrand.jsapi.c CM()
    {
      AppMethodBeat.i(50683);
      com.tencent.mm.plugin.appbrand.jsapi.c localc = (com.tencent.mm.plugin.appbrand.jsapi.c)this.cMz.get();
      AppMethodBeat.o(50683);
      return localc;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(List paramList) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(50687);
      ac.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      paramb = new WeakHashMap();
      Object localObject1 = new d.g.b.l(paramb)
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramAnonymousc, h.d paramAnonymousd)
        {
          AppMethodBeat.i(50686);
          k.h(paramAnonymousd, "entry");
          if (paramAnonymousc != null)
          {
            LinkedList localLinkedList2 = (LinkedList)this.kJP.get(paramAnonymousc);
            LinkedList localLinkedList1 = localLinkedList2;
            if (localLinkedList2 == null)
            {
              localLinkedList1 = new LinkedList();
              ((Map)this.kJP).put(paramAnonymousc, localLinkedList1);
            }
            localLinkedList1.addLast(paramAnonymousd);
          }
          AppMethodBeat.o(50686);
        }
      };
      Object localObject2;
      Object localObject3;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = ((Iterable)this.kJO).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (h.d)((Iterator)localObject2).next();
          ((1)localObject1).a(((h.d)localObject3).CM(), (h.d)localObject3);
        }
        com.tencent.mm.plugin.report.service.h.wUl.n(1074L, 2L, this.kJO.size());
        com.tencent.mm.plugin.report.service.h.wUl.A(1074L, 5L);
        paramb = paramb.entrySet();
        k.g(paramb, "component2EntryMap.entries");
        paramb = ((Iterable)paramb).iterator();
      }
      for (;;)
      {
        if (!paramb.hasNext()) {
          break label629;
        }
        localObject3 = (Map.Entry)paramb.next();
        localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.c)((Map.Entry)localObject3).getKey();
        if (localObject1 != null)
        {
          localObject1 = new c.b().g((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1);
          localObject2 = new HashMap();
          if (paramInt1 == 0) {}
          for (int i = paramInt2;; i = -9999)
          {
            ((HashMap)localObject2).put("errcode", Integer.valueOf(i));
            ((HashMap)localObject2).put("errmsg", paramString);
            localObject4 = ((Map.Entry)localObject3).getValue();
            k.g(localObject4, "entry.value");
            Object localObject5 = (Iterable)localObject4;
            localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext()) {
              ((Collection)localObject4).add(Long.valueOf(((h.d)((Iterator)localObject5).next()).content.length()));
            }
            localObject2 = ((Iterable)this.kJO).iterator();
            i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (h.d)((Iterator)localObject2).next();
              localObject4 = h.kJC;
              if (!h.biG().a((h.d)localObject3)) {
                ((1)localObject1).a(((h.d)localObject3).CM(), (h.d)localObject3);
              } else {
                i += 1;
              }
            }
            if (i <= 0) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(1074L, 0L, i);
            break;
          }
          ((HashMap)localObject2).put("dataSize", Long.valueOf(j.w((Iterable)localObject4)));
          localObject3 = ((Map.Entry)localObject3).getValue();
          k.g(localObject3, "entry.value");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(Integer.valueOf(((h.d)((Iterator)localObject4).next()).id));
          }
          ((HashMap)localObject2).put("idList", new JSONArray((Collection)j.l((Iterable)localObject3)));
          ((p)localObject1).A((Map)localObject2).beN();
        }
      }
      label629:
      AppMethodBeat.o(50687);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
  static final class f
    implements c.a
  {
    f(d paramd) {}
    
    public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
    {
      AppMethodBeat.i(50688);
      if (paramb == com.tencent.mm.plugin.appbrand.b.b.jqX)
      {
        paramString = h.kJC;
        h.b(h.c.kJL);
        paramString = h.kJC;
        h.e(this.kJQ);
      }
      AppMethodBeat.o(50688);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements au.a
  {
    public static final g kJR;
    
    static
    {
      AppMethodBeat.i(50690);
      kJR = new g();
      AppMethodBeat.o(50690);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50689);
      h localh = h.kJC;
      h.biH();
      AppMethodBeat.o(50689);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.h
 * JD-Core Version:    0.7.0.1
 */