package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.l;
import a.v;
import a.y;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "periodReport", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class i
{
  private static final long hYa;
  private static final ap hYb;
  private static final HashSet<o> hYc;
  private static final i.b hYd;
  public static final i hYe;
  
  static
  {
    AppMethodBeat.i(143874);
    hYe = new i();
    hYa = TimeUnit.MINUTES.toMillis(5L);
    hYb = new ap(Looper.getMainLooper(), (ap.a)i.g.hYt, true);
    hYc = new HashSet();
    hYd = new i.b();
    AppMethodBeat.o(143874);
  }
  
  public static void a(d paramd, int paramInt1, int paramInt2, String paramString, d.c paramc)
  {
    AppMethodBeat.i(143871);
    a.f.b.j.q(paramd, "component");
    a.f.b.j.q(paramString, "content");
    a.f.b.j.q(paramc, "priority");
    com.tencent.mm.plugin.appbrand.i locali;
    synchronized (hYc)
    {
      localObject = hYc;
      locali = paramd.getRuntime();
      if (locali == null)
      {
        paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(143871);
        throw paramd;
      }
    }
    boolean bool = ((HashSet)localObject).add((o)locali);
    if ((bool) && (hYc.size() == 1)) {
      hYb.nP(hYa);
    }
    if (bool)
    {
      localObject = paramd.getRuntime();
      a.f.b.j.p(localObject, "component.runtime");
      ((com.tencent.mm.plugin.appbrand.i)localObject).atk().a((c.a)new f(paramd));
    }
    Object localObject = y.BMg;
    h.qsU.B(1074L, 0L);
    hYd.a(new d(paramInt1, paramInt2, paramString, paramc, (com.tencent.mm.plugin.appbrand.jsapi.c)paramd));
    paramd = hYd.hYk;
    paramString = (Collection)new ArrayList(paramd.length);
    paramInt2 = paramd.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramString.add(Long.valueOf(paramd[paramInt1].size()));
      paramInt1 += 1;
    }
    if (a.a.j.v((Iterable)paramString) >= 65536L) {
      a(hYd.aEA(), c.hYm);
    }
    AppMethodBeat.o(143871);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(143872);
    a(hYd.aEA(), paramc);
    AppMethodBeat.o(143872);
  }
  
  private static void a(List<d> paramList, c paramc)
  {
    AppMethodBeat.i(143873);
    hYb.nP(hYa);
    ab.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + paramList.size() + ", reason=" + paramc.name());
    paramc = (Collection)paramList;
    if ((paramc == null) || (paramc.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(143873);
      return;
    }
    h.qsU.j(1074L, 1L, paramList.size());
    h.qsU.B(1074L, 4L);
    paramc = new com.tencent.mm.ai.b.a();
    paramc.rl("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
    paramc.kT(2946);
    bwa localbwa = new bwa();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      LinkedList localLinkedList = localbwa.xJD;
      daz localdaz = new daz();
      localdaz.type = locald.type;
      localdaz.wOQ = com.tencent.mm.bv.b.ank(locald.content);
      localLinkedList.add(localdaz);
    }
    paramc.a((a)localbwa);
    paramc.b((a)new bwb());
    com.tencent.mm.ipcinvoker.wx_extension.b.a(paramc.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new i.e(paramList));
    AppMethodBeat.o(143873);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "plugin-appbrand-integration_release"})
  static enum c
  {
    static
    {
      AppMethodBeat.i(143861);
      c localc1 = new c("TIMER_PERIOD", 0);
      hYl = localc1;
      c localc2 = new c("REACH_SLICE_LIMIT", 1);
      hYm = localc2;
      c localc3 = new c("RUNTIME_KILLED", 2);
      hYn = localc3;
      hYo = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(143861);
    }
    
    private c() {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContent", "()Ljava/lang/String;", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String content;
    final d.c hYh;
    int hYp;
    final com.tencent.mm.plugin.appbrand.jsapi.c hrA;
    final int id;
    final int type;
    
    public d(int paramInt1, int paramInt2, String paramString, d.c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
    {
      AppMethodBeat.i(143864);
      this.id = paramInt1;
      this.type = paramInt2;
      this.content = paramString;
      this.hYh = paramc;
      this.hrA = paramc1;
      AppMethodBeat.o(143864);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
  static final class f
    implements c.a
  {
    f(d paramd) {}
    
    public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
    {
      AppMethodBeat.i(143868);
      if (paramb == com.tencent.mm.plugin.appbrand.b.b.gYh)
      {
        paramString = i.hYe;
        i.b(i.c.hYn);
        paramString = i.hYe;
        i.c(this.hYs);
      }
      AppMethodBeat.o(143868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i
 * JD-Core Version:    0.7.0.1
 */