package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.a.v;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
final class i$a
{
  @Deprecated
  public static final i.a.a hYj;
  private final LinkedList<i.d> hYf;
  private long hYg;
  final d.c hYh;
  private final int hYi;
  
  static
  {
    AppMethodBeat.i(143857);
    hYj = new i.a.a((byte)0);
    AppMethodBeat.o(143857);
  }
  
  public i$a(d.c paramc, int paramInt)
  {
    AppMethodBeat.i(143856);
    this.hYh = paramc;
    this.hYi = paramInt;
    this.hYf = new LinkedList();
    AppMethodBeat.o(143856);
  }
  
  public final boolean a(i.d paramd)
  {
    AppMethodBeat.i(143854);
    j.q(paramd, "entry");
    if (paramd.hYp > this.hYi)
    {
      ab.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.hYh.name() + "], entry[" + paramd.hrA.getAppId() + ", " + paramd.id + ", " + paramd.type + ']');
      AppMethodBeat.o(143854);
      return false;
    }
    synchronized (this.hYf)
    {
      this.hYf.addLast(paramd);
      this.hYg += paramd.content.length();
      paramd = y.BMg;
      AppMethodBeat.o(143854);
      return true;
    }
  }
  
  public final List<i.d> hA(long paramLong)
  {
    AppMethodBeat.i(143855);
    long l;
    for (;;)
    {
      synchronized (this.hYf)
      {
        Object localObject1;
        if (this.hYf.isEmpty())
        {
          localObject1 = (List)v.BMx;
          AppMethodBeat.o(143855);
          return localObject1;
        }
        if (paramLong < 0L)
        {
          paramLong = ((i.d)this.hYf.peekFirst()).content.length();
          localObject1 = new LinkedList();
          l = paramLong;
          if ((this.hYf.isEmpty()) || (l <= 0L)) {
            break;
          }
          Object localObject3 = this.hYf.pollFirst();
          i.d locald = (i.d)localObject3;
          locald.hYp += 1;
          l -= locald.content.length();
          ((LinkedList)localObject1).addLast(localObject3);
        }
      }
    }
    this.hYg -= paramLong - l;
    if (this.hYg < 0L)
    {
      ab.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.hYh.name() + "] poll(" + paramLong + ") final bytesCount becomes minus");
      this.hYg = 0L;
    }
    List localList = (List)localObject2;
    AppMethodBeat.o(143855);
    return localList;
  }
  
  public final long size()
  {
    synchronized (this.hYf)
    {
      long l = this.hYg;
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i.a
 * JD-Core Version:    0.7.0.1
 */