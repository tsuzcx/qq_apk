package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderShareIconExposeReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastFeedId", "", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getObserverForExposeReport", "()Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "plugin-finder_release"})
public final class p
{
  public final d xxI;
  long xym;
  
  public p(final bid parambid)
  {
    AppMethodBeat.i(284288);
    this.xxI = ((d)new a(this, parambid));
    AppMethodBeat.o(284288);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/report/FinderShareIconExposeReporter$observerForExposeReport$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class a
    extends d
  {
    a(bid parambid) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(269978);
      kotlin.g.b.p.k(paramb, "ev");
      if (((paramb instanceof h)) && (this.zWH.xym != ((h)paramb).xrl))
      {
        am localam = am.zZN;
        am.a(parambid, "forward", false, (JSONObject)new i());
        localam = am.zZN;
        am.a(parambid, "tridot", false, (JSONObject)new i());
        this.zWH.xym = ((h)paramb).xrl;
      }
      AppMethodBeat.o(269978);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(269979);
      kotlin.g.b.p.k(paramc, "dispatcher");
      kotlin.g.b.p.k(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4)))
      {
        AppMethodBeat.o(269979);
        return true;
      }
      AppMethodBeat.o(269979);
      return false;
    }
    
    public final boolean dpw()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */