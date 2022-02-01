package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class b
  extends g
{
  private static final String TAG = "Finder.FinderHotFeedFlowReporter";
  private static LinkedList<dcw> rxb;
  public static final a rxc;
  
  static
  {
    AppMethodBeat.i(202715);
    rxc = new a((byte)0);
    TAG = "Finder.FinderHotFeedFlowReporter";
    rxb = new LinkedList();
    AppMethodBeat.o(202715);
  }
  
  public b(MMActivity paramMMActivity, anm paramanm)
  {
    super(paramMMActivity, paramanm);
    AppMethodBeat.i(202714);
    AppMethodBeat.o(202714);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(202713);
    k.h(paramb, "event");
    super.a(paramb);
    if (((paramb instanceof j)) && (((j)paramb).raQ != ((j)paramb).rdL))
    {
      paramb = FinderReporterUIC.seQ;
      c.c(FinderReporterUIC.cGf(), (a)new b(this));
    }
    AppMethodBeat.o(202713);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<dcw> DQ(int paramInt)
    {
      AppMethodBeat.i(202711);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = b.cwP();
        b.ae(new LinkedList());
        ac.i(b.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (com.tencent.mm.sdk.platformtools.h.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            dcw localdcw = (dcw)localIterator.next();
            Object localObject = h.ryk;
            localObject = b.rxc;
            h.a.a(localdcw, b.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(202711);
        return localLinkedList;
      }
      AppMethodBeat.o(202711);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */