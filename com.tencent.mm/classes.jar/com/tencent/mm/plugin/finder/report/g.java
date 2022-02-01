package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.base.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class g
  extends o
{
  private static final String TAG = "Finder.FinderHotFeedFlowReporter";
  private static LinkedList<ecq> vej;
  public static final a vek;
  
  static
  {
    AppMethodBeat.i(250557);
    vek = new a((byte)0);
    TAG = "Finder.FinderHotFeedFlowReporter";
    vej = new LinkedList();
    AppMethodBeat.o(250557);
  }
  
  public g(MMFragmentActivity paramMMFragmentActivity, bbn parambbn)
  {
    super(paramMMFragmentActivity, parambbn);
    AppMethodBeat.i(250556);
    AppMethodBeat.o(250556);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(250555);
    kotlin.g.b.p.h(paramb, "event");
    super.a(paramb);
    if (((paramb instanceof j)) && (((j)paramb).tCi != ((j)paramb).tIC))
    {
      paramb = FinderReporterUIC.wzC;
      d.c(FinderReporterUIC.dIB(), (a)new b(this));
    }
    AppMethodBeat.o(250555);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<ecq> Kc(int paramInt)
    {
      AppMethodBeat.i(250553);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = g.dnQ();
        g.au(new LinkedList());
        Log.i(g.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (BuildInfo.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            ecq localecq = (ecq)localIterator.next();
            Object localObject = p.vgC;
            localObject = g.vek;
            p.a.a(localecq, g.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(250553);
        return localLinkedList;
      }
      AppMethodBeat.o(250553);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */