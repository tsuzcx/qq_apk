package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.fed;
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
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "lastDoCgiTick", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "mayReportOnForeground", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class h
{
  private static final long mpk;
  private static final MTimerHandler mpl;
  private static final HashSet<com.tencent.mm.plugin.appbrand.q> mpm;
  private static final b mpn;
  private static long mpo;
  public static final h mpp;
  
  static
  {
    AppMethodBeat.i(50694);
    mpp = new h();
    mpk = TimeUnit.MINUTES.toMillis(5L);
    mpl = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)g.mpF, true);
    mpm = new HashSet();
    mpn = new b();
    AppMethodBeat.o(50694);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(50692);
    a(mpn.bIC(), paramc);
    AppMethodBeat.o(50692);
  }
  
  private final void a(List<d> paramList, c paramc)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(50693);
        mpl.startTimer(mpk);
        mpo = Util.currentTicks();
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
        com.tencent.mm.plugin.report.service.h.CyF.n(1074L, 1L, paramList.size());
        com.tencent.mm.plugin.report.service.h.CyF.F(1074L, 4L);
        paramc = new d.a();
        paramc.MB("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
        paramc.sG(2946);
        dqf localdqf = new dqf();
        Iterator localIterator = ((Iterable)paramList).iterator();
        if (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          LinkedList localLinkedList = localdqf.MTn;
          fed localfed = new fed();
          localfed.type = locald.type;
          localfed.Lqh = com.tencent.mm.bw.b.bfZ(locald.content);
          localfed.dNI = locald.appId;
          localLinkedList.add(localfed);
          continue;
        }
        paramc.c((a)localdqf);
      }
      finally {}
      paramc.d((a)new dqg());
      IPCRunCgi.a(paramc.aXF(), (IPCRunCgi.a)new e(paramList));
      AppMethodBeat.o(50693);
      continue;
      label305:
      int i = 1;
    }
  }
  
  private final void bIA()
  {
    try
    {
      AppMethodBeat.i(228504);
      if ((mpo > 0L) && (Util.ticksToNow(mpo) >= mpk)) {
        a(c.mpw);
      }
      AppMethodBeat.o(228504);
      return;
    }
    finally {}
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, int paramInt1, int paramInt2, String paramString, c.c paramc)
  {
    AppMethodBeat.i(50691);
    p.h(paramd, "component");
    p.h(paramString, "content");
    p.h(paramc, "priority");
    AppBrandRuntime localAppBrandRuntime;
    synchronized (mpm)
    {
      localObject = mpm;
      localAppBrandRuntime = paramd.getRuntime();
      if (localAppBrandRuntime == null)
      {
        paramd = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(50691);
        throw paramd;
      }
    }
    boolean bool = ((HashSet)localObject).add((com.tencent.mm.plugin.appbrand.q)localAppBrandRuntime);
    if ((bool) && (mpm.size() == 1)) {
      mpl.startTimer(mpk);
    }
    if (bool)
    {
      localObject = paramd.getRuntime();
      p.g(localObject, "component.runtime");
      ((AppBrandRuntime)localObject).brl().a((c.a)new f(paramd));
    }
    Object localObject = x.SXb;
    com.tencent.mm.plugin.report.service.h.CyF.F(1074L, 0L);
    try
    {
      mpn.a(new d(paramInt1, paramInt2, paramString, paramc, (f)paramd));
      switch (i.haE[paramc.ordinal()])
      {
      }
      for (;;)
      {
        paramd = mpn.mpv;
        paramString = (Collection)new ArrayList(paramd.length);
        paramInt2 = paramd.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          paramString.add(Long.valueOf(paramd[paramInt1].size()));
          paramInt1 += 1;
          continue;
          mpp.a(mpn.bIC(), c.mpz);
        }
        for (;;)
        {
          paramd = x.SXb;
          return;
          if (j.C((Iterable)paramString) >= 65536L) {
            mpp.a(mpn.bIC(), c.mpx);
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(50691);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
  static final class a
  {
    @Deprecated
    public static final h.a.a mpu;
    private final LinkedList<h.d> mpq;
    private long mpr;
    final c.c mps;
    private final int mpt;
    
    static
    {
      AppMethodBeat.i(50676);
      mpu = new h.a.a((byte)0);
      AppMethodBeat.o(50676);
    }
    
    public a(c.c paramc, int paramInt)
    {
      AppMethodBeat.i(50675);
      this.mps = paramc;
      this.mpt = paramInt;
      this.mpq = new LinkedList();
      AppMethodBeat.o(50675);
    }
    
    public final List<h.d> Bh(long paramLong)
    {
      AppMethodBeat.i(50674);
      long l;
      for (;;)
      {
        synchronized (this.mpq)
        {
          Object localObject1;
          if (this.mpq.isEmpty())
          {
            localObject1 = (List)v.SXr;
            AppMethodBeat.o(50674);
            return localObject1;
          }
          if (paramLong < 0L)
          {
            paramLong = ((h.d)this.mpq.peekFirst()).content.length();
            localObject1 = new LinkedList();
            l = paramLong;
            if ((this.mpq.isEmpty()) || (l <= 0L)) {
              break;
            }
            Object localObject3 = this.mpq.pollFirst();
            h.d locald = (h.d)localObject3;
            locald.mpB += 1;
            l -= locald.content.length();
            ((LinkedList)localObject1).addLast(localObject3);
          }
        }
      }
      this.mpr -= paramLong - l;
      if (this.mpr < 0L)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.mps.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
        this.mpr = 0L;
      }
      List localList = (List)localObject2;
      AppMethodBeat.o(50674);
      return localList;
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50673);
      p.h(paramd, "entry");
      if (paramd.mpB > this.mpt)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.mps.name() + "], entry[" + paramd.appId + ", " + paramd.id + ", " + paramd.type + ']');
        AppMethodBeat.o(50673);
        return false;
      }
      synchronized (this.mpq)
      {
        this.mpq.addLast(paramd);
        this.mpr += paramd.content.length();
        paramd = x.SXb;
        AppMethodBeat.o(50673);
        return true;
      }
    }
    
    public final long size()
    {
      synchronized (this.mpq)
      {
        long l = this.mpr;
        return l;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
  static final class b
  {
    final h.a[] mpv;
    
    public b()
    {
      AppMethodBeat.i(50679);
      this.mpv = new h.a[] { new h.a(c.c.mph, 3), new h.a(c.c.mpf, 3), new h.a(c.c.mpg, 1) };
      AppMethodBeat.o(50679);
    }
    
    public final boolean a(h.d paramd)
    {
      AppMethodBeat.i(50677);
      p.h(paramd, "entry");
      h.a[] arrayOfa = this.mpv;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        if (locala.mps == paramd.mps)
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
    
    public final List<h.d> bIC()
    {
      AppMethodBeat.i(50678);
      Object localObject = new LinkedList();
      long l1 = 0L;
      h.a[] arrayOfa = this.mpv;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        h.a locala = arrayOfa[i];
        long l2 = locala.size();
        ((LinkedList)localObject).addAll((Collection)locala.Bh(65536L - l1));
        l1 += l2 - locala.size();
        i += 1;
      }
      localObject = (List)localObject;
      AppMethodBeat.o(50678);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "IMMEDIATE", "plugin-appbrand-integration_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(50680);
      c localc1 = new c("TIMER_PERIOD", 0);
      mpw = localc1;
      c localc2 = new c("REACH_SLICE_LIMIT", 1);
      mpx = localc2;
      c localc3 = new c("RUNTIME_KILLED", 2);
      mpy = localc3;
      c localc4 = new c("IMMEDIATE", 3);
      mpz = localc4;
      mpA = new c[] { localc1, localc2, localc3, localc4 };
      AppMethodBeat.o(50680);
    }
    
    private c() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String appId;
    final String content;
    private final WeakReference<f> dps;
    final int id;
    int mpB;
    final c.c mps;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, c.c paramc, f paramf)
    {
      AppMethodBeat.i(50684);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.mps = paramc;
      this.dps = new WeakReference(paramf);
      paramString = paramf.getAppId();
      p.g(paramString, "component.appId");
      this.appId = paramString;
      AppMethodBeat.o(50684);
    }
    
    public final f NN()
    {
      AppMethodBeat.i(50683);
      f localf = (f)this.dps.get();
      AppMethodBeat.o(50683);
      return localf;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(List paramList) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(50687);
      Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      paramd = new WeakHashMap();
      Object localObject1 = new kotlin.g.b.q(paramd)
      {
        public final void a(f paramAnonymousf, h.d paramAnonymousd)
        {
          AppMethodBeat.i(50686);
          p.h(paramAnonymousd, "entry");
          if (paramAnonymousf != null)
          {
            LinkedList localLinkedList2 = (LinkedList)this.mpD.get(paramAnonymousf);
            LinkedList localLinkedList1 = localLinkedList2;
            if (localLinkedList2 == null)
            {
              localLinkedList1 = new LinkedList();
              ((Map)this.mpD).put(paramAnonymousf, localLinkedList1);
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
        localObject2 = ((Iterable)this.mpC).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (h.d)((Iterator)localObject2).next();
          ((1)localObject1).a(((h.d)localObject3).NN(), (h.d)localObject3);
        }
        com.tencent.mm.plugin.report.service.h.CyF.n(1074L, 2L, this.mpC.size());
        com.tencent.mm.plugin.report.service.h.CyF.F(1074L, 5L);
        paramd = paramd.entrySet();
        p.g(paramd, "component2EntryMap.entries");
        paramd = ((Iterable)paramd).iterator();
      }
      for (;;)
      {
        if (!paramd.hasNext()) {
          break label629;
        }
        localObject3 = (Map.Entry)paramd.next();
        localObject1 = (f)((Map.Entry)localObject3).getKey();
        if (localObject1 != null)
        {
          localObject1 = new c.b().g((f)localObject1);
          localObject2 = new HashMap();
          if (paramInt1 == 0) {}
          for (int i = paramInt2;; i = -9999)
          {
            ((HashMap)localObject2).put("errcode", Integer.valueOf(i));
            ((HashMap)localObject2).put("errmsg", paramString);
            localObject4 = ((Map.Entry)localObject3).getValue();
            p.g(localObject4, "entry.value");
            Object localObject5 = (Iterable)localObject4;
            localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext()) {
              ((Collection)localObject4).add(Long.valueOf(((h.d)((Iterator)localObject5).next()).content.length()));
            }
            localObject2 = ((Iterable)this.mpC).iterator();
            i = 0;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (h.d)((Iterator)localObject2).next();
              localObject4 = h.mpp;
              if (!h.bIB().a((h.d)localObject3)) {
                ((1)localObject1).a(((h.d)localObject3).NN(), (h.d)localObject3);
              } else {
                i += 1;
              }
            }
            if (i <= 0) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.CyF.n(1074L, 0L, i);
            break;
          }
          ((HashMap)localObject2).put("dataSize", Long.valueOf(j.C((Iterable)localObject4)));
          localObject3 = ((Map.Entry)localObject3).getValue();
          p.g(localObject3, "entry.value");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(Integer.valueOf(((h.d)((Iterator)localObject4).next()).id));
          }
          ((HashMap)localObject2).put("idList", new JSONArray((Collection)j.p((Iterable)localObject3)));
          ((s)localObject1).K((Map)localObject2).bEo();
        }
      }
      label629:
      AppMethodBeat.o(50687);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
  static final class f
    implements c.a
  {
    f(com.tencent.mm.plugin.appbrand.d paramd) {}
    
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
        h.a(h.mpp, h.c.mpy);
        paramString = h.mpp;
        h.f(this.mpE);
        AppMethodBeat.o(50688);
        return;
        h.a(h.mpp);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements MTimerHandler.CallBack
  {
    public static final g mpF;
    
    static
    {
      AppMethodBeat.i(50690);
      mpF = new g();
      AppMethodBeat.o(50690);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50689);
      h.a(h.mpp, h.c.mpw);
      AppMethodBeat.o(50689);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.h
 * JD-Core Version:    0.7.0.1
 */