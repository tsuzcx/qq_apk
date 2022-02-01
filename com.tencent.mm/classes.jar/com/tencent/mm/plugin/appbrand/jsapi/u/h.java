package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.a.j;
import d.g.a.m;
import d.g.b.q;
import d.l;
import d.z;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "periodReport", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class h
{
  private static final long ljE;
  private static final aw ljF;
  private static final HashSet<com.tencent.mm.plugin.appbrand.p> ljG;
  private static final b ljH;
  public static final h ljI;
  
  static
  {
    AppMethodBeat.i(50694);
    ljI = new h();
    ljE = TimeUnit.MINUTES.toMillis(5L);
    ljF = new aw(Looper.getMainLooper(), (aw.a)g.ljX, true);
    ljG = new HashSet();
    ljH = new b();
    AppMethodBeat.o(50694);
  }
  
  public static void a(d paramd, int paramInt1, int paramInt2, String paramString, c.c paramc)
  {
    AppMethodBeat.i(50691);
    d.g.b.p.h(paramd, "component");
    d.g.b.p.h(paramString, "content");
    d.g.b.p.h(paramc, "priority");
    AppBrandRuntime localAppBrandRuntime;
    synchronized (ljG)
    {
      localObject = ljG;
      localAppBrandRuntime = paramd.getRuntime();
      if (localAppBrandRuntime == null)
      {
        paramd = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(50691);
        throw paramd;
      }
    }
    boolean bool = ((HashSet)localObject).add((com.tencent.mm.plugin.appbrand.p)localAppBrandRuntime);
    if ((bool) && (ljG.size() == 1)) {
      ljF.Dv(ljE);
    }
    if (bool)
    {
      localObject = paramd.getRuntime();
      d.g.b.p.g(localObject, "component.runtime");
      ((AppBrandRuntime)localObject).aWq().a((c.a)new f(paramd));
    }
    Object localObject = z.Nhr;
    g.yxI.A(1074L, 0L);
    ljH.a(new d(paramInt1, paramInt2, paramString, paramc, (com.tencent.mm.plugin.appbrand.jsapi.c)paramd));
    paramd = ljH.ljO;
    paramString = (Collection)new ArrayList(paramd.length);
    paramInt2 = paramd.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramString.add(Long.valueOf(paramd[paramInt1].size()));
      paramInt1 += 1;
    }
    if (j.y((Iterable)paramString) >= 65536L) {
      a(ljH.bnd(), c.ljQ);
    }
    AppMethodBeat.o(50691);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(50692);
    a(ljH.bnd(), paramc);
    AppMethodBeat.o(50692);
  }
  
  private static void a(List<d> paramList, c paramc)
  {
    AppMethodBeat.i(50693);
    ljF.Dv(ljE);
    ae.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + paramList.size() + ", reason=" + paramc.name());
    paramc = (Collection)paramList;
    if ((paramc == null) || (paramc.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50693);
      return;
    }
    g.yxI.n(1074L, 1L, paramList.size());
    g.yxI.A(1074L, 4L);
    paramc = new b.a();
    paramc.DN("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
    paramc.oS(2946);
    cxl localcxl = new cxl();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      LinkedList localLinkedList = localcxl.HIc;
      ejk localejk = new ejk();
      localejk.type = locald.type;
      localejk.GuC = com.tencent.mm.bw.b.aPw(locald.content);
      localejk.dwb = locald.appId;
      localLinkedList.add(localejk);
    }
    paramc.c((a)localcxl);
    paramc.d((a)new cxm());
    IPCRunCgi.a(paramc.aDS(), (IPCRunCgi.a)new e(paramList));
    AppMethodBeat.o(50693);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
  static final class a
  {
    @Deprecated
    public static final a ljN;
    private final LinkedList<h.d> ljJ;
    private long ljK;
    final c.c ljL;
    private final int ljM;
    
    static
    {
      AppMethodBeat.i(50676);
      ljN = new a((byte)0);
      AppMethodBeat.o(50676);
    }
    
    public a(c.c paramc, int paramInt)
    {
      AppMethodBeat.i(50675);
      this.ljL = paramc;
      this.ljM = paramInt;
      this.ljJ = new LinkedList();
      AppMethodBeat.o(50675);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50673);
      d.g.b.p.h(paramd, "entry");
      if (paramd.ljT > this.ljM)
      {
        ae.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.ljL.name() + "], entry[" + paramd.appId + ", " + paramd.id + ", " + paramd.type + ']');
        AppMethodBeat.o(50673);
        return false;
      }
      synchronized (this.ljJ)
      {
        this.ljJ.addLast(paramd);
        this.ljK += paramd.content.length();
        paramd = z.Nhr;
        AppMethodBeat.o(50673);
        return true;
      }
    }
    
    public final long size()
    {
      synchronized (this.ljJ)
      {
        long l = this.ljK;
        return l;
      }
    }
    
    public final List<h.d> tc(long paramLong)
    {
      AppMethodBeat.i(50674);
      long l;
      for (;;)
      {
        synchronized (this.ljJ)
        {
          Object localObject1;
          if (this.ljJ.isEmpty())
          {
            localObject1 = (List)d.a.v.NhH;
            AppMethodBeat.o(50674);
            return localObject1;
          }
          if (paramLong < 0L)
          {
            paramLong = ((h.d)this.ljJ.peekFirst()).content.length();
            localObject1 = new LinkedList();
            l = paramLong;
            if ((this.ljJ.isEmpty()) || (l <= 0L)) {
              break;
            }
            Object localObject3 = this.ljJ.pollFirst();
            h.d locald = (h.d)localObject3;
            locald.ljT += 1;
            l -= locald.content.length();
            ((LinkedList)localObject1).addLast(localObject3);
          }
        }
      }
      this.ljK -= paramLong - l;
      if (this.ljK < 0L)
      {
        ae.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.ljL.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
        this.ljK = 0L;
      }
      List localList = (List)localObject2;
      AppMethodBeat.o(50674);
      return localList;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
  static final class b
  {
    final h.a[] ljO;
    
    public b()
    {
      AppMethodBeat.i(50679);
      this.ljO = new h.a[] { new h.a(c.c.ljA, 3), new h.a(c.c.ljB, 1) };
      AppMethodBeat.o(50679);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50677);
      d.g.b.p.h(paramd, "entry");
      h.a[] arrayOfa = this.ljO;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        if (locala.ljL == paramd.ljL)
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
    
    public final List<h.d> bnd()
    {
      AppMethodBeat.i(50678);
      Object localObject = new LinkedList();
      long l1 = 0L;
      h.a[] arrayOfa = this.ljO;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        long l2 = locala.size();
        ((LinkedList)localObject).addAll((Collection)locala.tc(65536L - l1));
        l1 += l2 - locala.size();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(50678);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "plugin-appbrand-integration_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(50680);
      c localc1 = new c("TIMER_PERIOD", 0);
      ljP = localc1;
      c localc2 = new c("REACH_SLICE_LIMIT", 1);
      ljQ = localc2;
      c localc3 = new c("RUNTIME_KILLED", 2);
      ljR = localc3;
      ljS = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(50680);
    }
    
    private c() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String appId;
    private final WeakReference<com.tencent.mm.plugin.appbrand.jsapi.c> cYN;
    final String content;
    final int id;
    final c.c ljL;
    int ljT;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, c.c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
    {
      AppMethodBeat.i(50684);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.ljL = paramc;
      this.cYN = new WeakReference(paramc1);
      paramString = paramc1.getAppId();
      d.g.b.p.g(paramString, "component.appId");
      this.appId = paramString;
      AppMethodBeat.o(50684);
    }
    
    public final com.tencent.mm.plugin.appbrand.jsapi.c Eo()
    {
      AppMethodBeat.i(50683);
      com.tencent.mm.plugin.appbrand.jsapi.c localc = (com.tencent.mm.plugin.appbrand.jsapi.c)this.cYN.get();
      AppMethodBeat.o(50683);
      return localc;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(List paramList) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(50687);
      ae.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      paramb = new WeakHashMap();
      Object localObject1 = new q(paramb)
      {
        public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramAnonymousc, h.d paramAnonymousd)
        {
          AppMethodBeat.i(50686);
          d.g.b.p.h(paramAnonymousd, "entry");
          if (paramAnonymousc != null)
          {
            LinkedList localLinkedList2 = (LinkedList)this.ljV.get(paramAnonymousc);
            LinkedList localLinkedList1 = localLinkedList2;
            if (localLinkedList2 == null)
            {
              localLinkedList1 = new LinkedList();
              ((Map)this.ljV).put(paramAnonymousc, localLinkedList1);
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
        localObject2 = ((Iterable)this.ljU).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (h.d)((Iterator)localObject2).next();
          ((1)localObject1).a(((h.d)localObject3).Eo(), (h.d)localObject3);
        }
        g.yxI.n(1074L, 2L, this.ljU.size());
        g.yxI.A(1074L, 5L);
        paramb = paramb.entrySet();
        d.g.b.p.g(paramb, "component2EntryMap.entries");
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
            d.g.b.p.g(localObject4, "entry.value");
            Object localObject5 = (Iterable)localObject4;
            localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext()) {
              ((Collection)localObject4).add(Long.valueOf(((h.d)((Iterator)localObject5).next()).content.length()));
            }
            localObject2 = ((Iterable)this.ljU).iterator();
            i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (h.d)((Iterator)localObject2).next();
              localObject4 = h.ljI;
              if (!h.bnb().a((h.d)localObject3)) {
                ((1)localObject1).a(((h.d)localObject3).Eo(), (h.d)localObject3);
              } else {
                i += 1;
              }
            }
            if (i <= 0) {
              break;
            }
            g.yxI.n(1074L, 0L, i);
            break;
          }
          ((HashMap)localObject2).put("dataSize", Long.valueOf(j.y((Iterable)localObject4)));
          localObject3 = ((Map.Entry)localObject3).getValue();
          d.g.b.p.g(localObject3, "entry.value");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(Integer.valueOf(((h.d)((Iterator)localObject4).next()).id));
          }
          ((HashMap)localObject2).put("idList", new JSONArray((Collection)j.l((Iterable)localObject3)));
          ((com.tencent.mm.plugin.appbrand.jsapi.p)localObject1).H((Map)localObject2).bja();
        }
      }
      label629:
      AppMethodBeat.o(50687);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
  static final class f
    implements c.a
  {
    f(d paramd) {}
    
    public final void a(String paramString, com.tencent.mm.plugin.appbrand.a.b paramb)
    {
      AppMethodBeat.i(50688);
      if (paramb == com.tencent.mm.plugin.appbrand.a.b.jOd)
      {
        paramString = h.ljI;
        h.b(h.c.ljR);
        paramString = h.ljI;
        h.f(this.ljW);
      }
      AppMethodBeat.o(50688);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements aw.a
  {
    public static final g ljX;
    
    static
    {
      AppMethodBeat.i(50690);
      ljX = new g();
      AppMethodBeat.o(50690);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50689);
      h localh = h.ljI;
      h.bnc();
      AppMethodBeat.o(50689);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.h
 * JD-Core Version:    0.7.0.1
 */