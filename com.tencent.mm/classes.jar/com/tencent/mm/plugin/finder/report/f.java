package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "Companion", "plugin-finder_release"})
public final class f
  extends l
{
  private static LinkedList<cxk> KUC;
  public static final a KUD;
  private static final String TAG = "Finder.FinderHotFeedFlowReporter";
  
  static
  {
    AppMethodBeat.i(198778);
    KUD = new a((byte)0);
    TAG = "Finder.FinderHotFeedFlowReporter";
    KUC = new LinkedList();
    AppMethodBeat.o(198778);
  }
  
  public f(MMActivity paramMMActivity, dzp paramdzp)
  {
    super(paramMMActivity, paramdzp);
    AppMethodBeat.i(198777);
    AppMethodBeat.o(198777);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(198776);
    k.h(paramc, "event");
    super.a(paramc);
    if (((paramc instanceof com.tencent.mm.plugin.finder.event.base.l)) && (((com.tencent.mm.plugin.finder.event.base.l)paramc).qGl != ((com.tencent.mm.plugin.finder.event.base.l)paramc).qsk))
    {
      paramc = FinderReporterUIC.Ljl;
      com.tencent.mm.ad.c.e(FinderReporterUIC.fXw(), (a)new b(this));
    }
    AppMethodBeat.o(198776);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "streamCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getWaitForReportStatsListAndClear", "tabType", "", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<cxk> ahn(int paramInt)
    {
      AppMethodBeat.i(198774);
      if (paramInt == 4)
      {
        LinkedList localLinkedList = f.fTU();
        f.ad(new LinkedList());
        ad.i(f.access$getTAG$cp(), "streamCgiStats returnList " + localLinkedList.size());
        if (h.DEBUG)
        {
          Iterator localIterator = ((Iterable)localLinkedList).iterator();
          while (localIterator.hasNext())
          {
            cxk localcxk = (cxk)localIterator.next();
            Object localObject = m.KVt;
            localObject = f.KUD;
            m.a.a(localcxk, f.access$getTAG$cp());
          }
        }
        AppMethodBeat.o(198774);
        return localLinkedList;
      }
      AppMethodBeat.o(198774);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */