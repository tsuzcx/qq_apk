package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class d
  extends k
{
  private static final String TAG = "Finder.FinderHotFeedFlowReporter";
  private static LinkedList<dij> snR;
  public static final a snS;
  
  static
  {
    AppMethodBeat.i(203212);
    snS = new a((byte)0);
    TAG = "Finder.FinderHotFeedFlowReporter";
    snR = new LinkedList();
    AppMethodBeat.o(203212);
  }
  
  public d(MMActivity paramMMActivity, aqy paramaqy)
  {
    super(paramMMActivity, paramaqy);
    AppMethodBeat.i(203211);
    AppMethodBeat.o(203211);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203210);
    p.h(paramb, "event");
    super.a(paramb);
    if (((paramb instanceof j)) && (((j)paramb).rNl != ((j)paramb).rRj))
    {
      paramb = FinderReporterUIC.tcM;
      c.c(FinderReporterUIC.cOy(), (a)new b(this));
    }
    AppMethodBeat.o(203210);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<dij> EK(int paramInt)
    {
      AppMethodBeat.i(203208);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = d.cDr();
        d.af(new LinkedList());
        ad.i(d.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (i.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            dij localdij = (dij)localIterator.next();
            Object localObject = l.spI;
            localObject = d.snS;
            l.a.a(localdij, d.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(203208);
        return localLinkedList;
      }
      AppMethodBeat.o(203208);
      return null;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.d
 * JD-Core Version:    0.7.0.1
 */