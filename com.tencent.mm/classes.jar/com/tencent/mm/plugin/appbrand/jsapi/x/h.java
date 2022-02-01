package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.fpe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
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
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "lastDoCgiTick", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "mayReportOnForeground", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class h
{
  private static final long pnp;
  private static final MTimerHandler pnq;
  private static final HashSet<com.tencent.mm.plugin.appbrand.t> pnr;
  private static final b pns;
  private static long pnt;
  public static final h pnu;
  
  static
  {
    AppMethodBeat.i(50694);
    pnu = new h();
    pnp = TimeUnit.MINUTES.toMillis(5L);
    pnq = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)h.g.pnK, true);
    pnr = new HashSet();
    pns = new b();
    AppMethodBeat.o(50694);
  }
  
  private final void a(h.c paramc)
  {
    AppMethodBeat.i(50692);
    a(pns.bUk(), paramc);
    AppMethodBeat.o(50692);
  }
  
  private final void a(List<d> paramList, h.c paramc)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(50693);
        pnq.startTimer(pnp);
        pnt = Util.currentTicks();
        Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + paramList.size() + ", reason=" + paramc.name());
        paramc = (Collection)paramList;
        if (paramc == null) {
          break label305;
        }
        if (paramc.isEmpty())
        {
          break label305;
          if (i != 0) {
            AppMethodBeat.o(50693);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(1074L, 1L, paramList.size());
        com.tencent.mm.plugin.report.service.h.IzE.F(1074L, 4L);
        paramc = new d.a();
        paramc.TW("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
        paramc.vD(2946);
        eab localeab = new eab();
        Iterator localIterator = ((Iterable)paramList).iterator();
        if (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          LinkedList localLinkedList = localeab.SKD;
          fpe localfpe = new fpe();
          localfpe.type = locald.type;
          localfpe.SrE = com.tencent.mm.cd.b.bss(locald.content);
          localfpe.appid = locald.appId;
          localLinkedList.add(localfpe);
          continue;
        }
        paramc.c((a)localeab);
      }
      finally {}
      paramc.d((a)new eac());
      IPCRunCgi.a(paramc.bgN(), (IPCRunCgi.a)new e(paramList));
      AppMethodBeat.o(50693);
      continue;
      label305:
      int i = 1;
    }
  }
  
  private final void bUh()
  {
    try
    {
      AppMethodBeat.i(274670);
      if ((pnt > 0L) && (Util.ticksToNow(pnt) >= pnp)) {
        a(h.c.pnB);
      }
      AppMethodBeat.o(274670);
      return;
    }
    finally {}
  }
  
  public final void a(g paramg, int paramInt1, int paramInt2, String paramString, c.c paramc)
  {
    AppMethodBeat.i(50691);
    p.k(paramg, "component");
    p.k(paramString, "content");
    p.k(paramc, "priority");
    AppBrandRuntime localAppBrandRuntime;
    synchronized (pnr)
    {
      localObject = pnr;
      localAppBrandRuntime = paramg.getRuntime();
      if (localAppBrandRuntime == null)
      {
        paramg = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(50691);
        throw paramg;
      }
    }
    boolean bool = ((HashSet)localObject).add((com.tencent.mm.plugin.appbrand.t)localAppBrandRuntime);
    if ((bool) && (pnr.size() == 1)) {
      pnq.startTimer(pnp);
    }
    if (bool)
    {
      localObject = paramg.getRuntime();
      p.j(localObject, "component.runtime");
      ((AppBrandRuntime)localObject).bCb().a((c.a)new f(paramg));
    }
    Object localObject = x.aazN;
    com.tencent.mm.plugin.report.service.h.IzE.F(1074L, 0L);
    try
    {
      pns.a(new d(paramInt1, paramInt2, paramString, paramc, (e)paramg));
      switch (i.jLJ[paramc.ordinal()])
      {
      }
      for (;;)
      {
        paramg = pns.pnA;
        paramString = (Collection)new ArrayList(paramg.length);
        paramInt2 = paramg.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          paramString.add(Long.valueOf(paramg[paramInt1].bUj()));
          paramInt1 += 1;
          continue;
          pnu.a(pns.bUk(), h.c.pnE);
        }
        for (;;)
        {
          paramg = x.aazN;
          return;
          if (j.C((Iterable)paramString) >= 65536L) {
            pnu.a(pns.bUk(), h.c.pnC);
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(50691);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
  static final class a
  {
    @Deprecated
    public static final h.a.a pnz;
    private final LinkedList<h.d> pnv;
    private long pnw;
    final c.c pnx;
    private final int pny;
    
    static
    {
      AppMethodBeat.i(50676);
      pnz = new h.a.a((byte)0);
      AppMethodBeat.o(50676);
    }
    
    public a(c.c paramc, int paramInt)
    {
      AppMethodBeat.i(50675);
      this.pnx = paramc;
      this.pny = paramInt;
      this.pnv = new LinkedList();
      AppMethodBeat.o(50675);
    }
    
    public final List<h.d> Hu(long paramLong)
    {
      AppMethodBeat.i(50674);
      long l;
      for (;;)
      {
        synchronized (this.pnv)
        {
          Object localObject1;
          if (this.pnv.isEmpty())
          {
            localObject1 = (List)v.aaAd;
            AppMethodBeat.o(50674);
            return localObject1;
          }
          if (paramLong < 0L)
          {
            paramLong = ((h.d)this.pnv.peekFirst()).content.length();
            localObject1 = new LinkedList();
            l = paramLong;
            if ((this.pnv.isEmpty()) || (l <= 0L)) {
              break;
            }
            Object localObject3 = this.pnv.pollFirst();
            h.d locald = (h.d)localObject3;
            locald.pnG += 1;
            l -= locald.content.length();
            ((LinkedList)localObject1).addLast(localObject3);
          }
        }
      }
      this.pnw -= paramLong - l;
      if (this.pnw < 0L)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.pnx.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
        this.pnw = 0L;
      }
      List localList = (List)localObject2;
      AppMethodBeat.o(50674);
      return localList;
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50673);
      p.k(paramd, "entry");
      if (paramd.pnG > this.pny)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.pnx.name() + "], entry[" + paramd.appId + ", " + paramd.id + ", " + paramd.type + ']');
        AppMethodBeat.o(50673);
        return false;
      }
      synchronized (this.pnv)
      {
        this.pnv.addLast(paramd);
        this.pnw += paramd.content.length();
        paramd = x.aazN;
        AppMethodBeat.o(50673);
        return true;
      }
    }
    
    public final long bUj()
    {
      synchronized (this.pnv)
      {
        long l = this.pnw;
        return l;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
  static final class b
  {
    final h.a[] pnA;
    
    public b()
    {
      AppMethodBeat.i(50679);
      this.pnA = new h.a[] { new h.a(c.c.pnm, 3), new h.a(c.c.pnk, 3), new h.a(c.c.pnl, 1) };
      AppMethodBeat.o(50679);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50677);
      p.k(paramd, "entry");
      h.a[] arrayOfa = this.pnA;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        if (locala.pnx == paramd.pnx)
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
    
    public final List<h.d> bUk()
    {
      AppMethodBeat.i(50678);
      Object localObject = new LinkedList();
      long l1 = 0L;
      h.a[] arrayOfa = this.pnA;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        long l2 = locala.bUj();
        ((LinkedList)localObject).addAll((Collection)locala.Hu(65536L - l1));
        l1 += l2 - locala.bUj();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(50678);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String appId;
    final String content;
    private final WeakReference<e> fhY;
    final int id;
    int pnG;
    final c.c pnx;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, c.c paramc, e parame)
    {
      AppMethodBeat.i(50684);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.pnx = paramc;
      this.fhY = new WeakReference(parame);
      paramString = parame.getAppId();
      p.j(paramString, "component.appId");
      this.appId = paramString;
      AppMethodBeat.o(50684);
    }
    
    public final e QK()
    {
      AppMethodBeat.i(50683);
      e locale = (e)this.fhY.get();
      AppMethodBeat.o(50683);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(List paramList) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(50687);
      Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      paramd = new WeakHashMap();
      Object localObject1 = new q(paramd)
      {
        public final void a(e paramAnonymouse, h.d paramAnonymousd)
        {
          AppMethodBeat.i(50686);
          p.k(paramAnonymousd, "entry");
          if (paramAnonymouse != null)
          {
            LinkedList localLinkedList2 = (LinkedList)this.pnI.get(paramAnonymouse);
            LinkedList localLinkedList1 = localLinkedList2;
            if (localLinkedList2 == null)
            {
              localLinkedList1 = new LinkedList();
              ((Map)this.pnI).put(paramAnonymouse, localLinkedList1);
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
        localObject2 = ((Iterable)this.pnH).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (h.d)((Iterator)localObject2).next();
          ((1)localObject1).a(((h.d)localObject3).QK(), (h.d)localObject3);
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(1074L, 2L, this.pnH.size());
        com.tencent.mm.plugin.report.service.h.IzE.F(1074L, 5L);
        paramd = paramd.entrySet();
        p.j(paramd, "component2EntryMap.entries");
        paramd = ((Iterable)paramd).iterator();
      }
      for (;;)
      {
        if (!paramd.hasNext()) {
          break label629;
        }
        localObject3 = (Map.Entry)paramd.next();
        localObject1 = (e)((Map.Entry)localObject3).getKey();
        if (localObject1 != null)
        {
          localObject1 = new c.b().i((e)localObject1);
          localObject2 = new HashMap();
          if (paramInt1 == 0) {}
          for (int i = paramInt2;; i = -9999)
          {
            ((HashMap)localObject2).put("errcode", Integer.valueOf(i));
            ((HashMap)localObject2).put("errmsg", paramString);
            localObject4 = ((Map.Entry)localObject3).getValue();
            p.j(localObject4, "entry.value");
            Object localObject5 = (Iterable)localObject4;
            localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext()) {
              ((Collection)localObject4).add(Long.valueOf(((h.d)((Iterator)localObject5).next()).content.length()));
            }
            localObject2 = ((Iterable)this.pnH).iterator();
            i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (h.d)((Iterator)localObject2).next();
              localObject4 = h.pnu;
              if (!h.bUi().a((h.d)localObject3)) {
                ((1)localObject1).a(((h.d)localObject3).QK(), (h.d)localObject3);
              } else {
                i += 1;
              }
            }
            if (i <= 0) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.p(1074L, 0L, i);
            break;
          }
          ((HashMap)localObject2).put("dataSize", Long.valueOf(j.C((Iterable)localObject4)));
          localObject3 = ((Map.Entry)localObject3).getValue();
          p.j(localObject3, "entry.value");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(Integer.valueOf(((h.d)((Iterator)localObject4).next()).id));
          }
          ((HashMap)localObject2).put("idList", new JSONArray((Collection)j.p((Iterable)localObject3)));
          ((r)localObject1).D((Map)localObject2).bPO();
        }
      }
      label629:
      AppMethodBeat.o(50687);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
  static final class f
    implements c.a
  {
    f(g paramg) {}
    
    public final void a(String paramString, com.tencent.mm.plugin.appbrand.a.b paramb)
    {
      AppMethodBeat.i(50688);
      if (paramb == null)
      {
        AppMethodBeat.o(50688);
        return;
      }
      switch (i.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(50688);
        return;
        h.a(h.pnu, h.c.pnD);
        paramString = h.pnu;
        h.g(this.pnJ);
        AppMethodBeat.o(50688);
        return;
        h.a(h.pnu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.h
 * JD-Core Version:    0.7.0.1
 */