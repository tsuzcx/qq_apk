package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class d
  extends l
{
  private static final String TAG = "Finder.FinderHotFeedFlowReporter";
  private static LinkedList<dje> sxI;
  public static final a sxJ;
  
  static
  {
    AppMethodBeat.i(203753);
    sxJ = new a((byte)0);
    TAG = "Finder.FinderHotFeedFlowReporter";
    sxI = new LinkedList();
    AppMethodBeat.o(203753);
  }
  
  public d(MMActivity paramMMActivity, arn paramarn)
  {
    super(paramMMActivity, paramarn);
    AppMethodBeat.i(203752);
    AppMethodBeat.o(203752);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203751);
    p.h(paramb, "event");
    super.a(paramb);
    if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.j)) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).rVz != ((com.tencent.mm.plugin.finder.event.base.j)paramb).rZL))
    {
      paramb = FinderReporterUIC.tnG;
      c.c(FinderReporterUIC.cRd(), (a)new b(this));
    }
    AppMethodBeat.o(203751);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<dje> Fd(int paramInt)
    {
      AppMethodBeat.i(203749);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = d.cFj();
        d.af(new LinkedList());
        ae.i(d.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (com.tencent.mm.sdk.platformtools.j.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            dje localdje = (dje)localIterator.next();
            Object localObject = m.szT;
            localObject = d.sxJ;
            m.a.a(localdje, d.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(203749);
        return localLinkedList;
      }
      AppMethodBeat.o(203749);
      return null;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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