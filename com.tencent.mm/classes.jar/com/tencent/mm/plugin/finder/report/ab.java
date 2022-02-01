package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderShareIconExposeReporter;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastFeedId", "", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getObserverForExposeReport", "()Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
{
  public final d AUT;
  long AVm;
  
  public ab(final bui parambui)
  {
    AppMethodBeat.i(331296);
    this.AUT = ((d)new a(this, parambui));
    AppMethodBeat.o(331296);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderShareIconExposeReporter$observerForExposeReport$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    a(ab paramab, bui parambui) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(331072);
      s.u(paramb, "ev");
      if (((paramb instanceof h)) && (this.Fsj.AVm != ((h)paramb).AOv))
      {
        bb localbb = bb.FuK;
        bb.a(parambui, "forward", false, (JSONObject)new i());
        localbb = bb.FuK;
        bb.a(parambui, "tridot", false, (JSONObject)new i());
        this.Fsj.AVm = ((h)paramb).AOv;
      }
      AppMethodBeat.o(331072);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(331082);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4)))
      {
        AppMethodBeat.o(331082);
        return true;
      }
      AppMethodBeat.o(331082);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ab
 * JD-Core Version:    0.7.0.1
 */