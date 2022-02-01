package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fillCardInfo", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "struct", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillCommonInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillFeedInfo", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "reportClick", "", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "feedIndex", "", "reportExpose", "dataList", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "refreshTime", "", "reportExposeInternal", "cardStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardExposeReportStruct;", "plugin-finder_release"})
public final class ac
  extends e
{
  public ac(MMActivity paramMMActivity, bbn parambbn)
  {
    super((MMFragmentActivity)paramMMActivity, parambbn);
    AppMethodBeat.i(250832);
    AppMethodBeat.o(250832);
  }
  
  public static <T extends a> T a(T paramT, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(250831);
    if ((paramT instanceof cm))
    {
      ((cm)paramT).mt(d.zs(paramBaseFinderFeed.lT()));
      ((cm)paramT).mu(paramBaseFinderFeed.getSessionBuffer());
      ((cm)paramT).mw(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().dTj));
      ((cm)paramT).mv(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().latitude));
    }
    for (;;)
    {
      AppMethodBeat.o(250831);
      return paramT;
      if ((paramT instanceof cl))
      {
        ((cl)paramT).mk(d.zs(paramBaseFinderFeed.lT()));
        ((cl)paramT).ml(paramBaseFinderFeed.getSessionBuffer());
      }
    }
  }
  
  public static <T extends a> T a(T paramT, o paramo)
  {
    AppMethodBeat.i(250830);
    if ((paramT instanceof cm))
    {
      ((cm)paramT).mq(paramo.dxF());
      ((cm)paramT).gB(paramo.dxE().jjN);
      ((cm)paramT).mr(paramo.cxc());
      ((cm)paramT).ms(paramo.dxH());
    }
    for (;;)
    {
      AppMethodBeat.o(250830);
      return paramT;
      if ((paramT instanceof cl))
      {
        ((cl)paramT).mi(paramo.dxF());
        ((cl)paramT).gy(paramo.dxE().jjN);
        ((cl)paramT).mj(paramo.cxc());
      }
    }
  }
  
  public final <T extends a> T b(T paramT)
  {
    AppMethodBeat.i(250829);
    if ((paramT instanceof cm))
    {
      ((cm)paramT).mm(this.ttO.sessionId);
      ((cm)paramT).mn(this.ttO.sGQ);
      ((cm)paramT).mo(this.ttO.sGE);
    }
    for (;;)
    {
      AppMethodBeat.o(250829);
      return paramT;
      if ((paramT instanceof cl))
      {
        ((cl)paramT).mf(this.ttO.sessionId);
        ((cl)paramT).mg(this.ttO.sGQ);
        ((cl)paramT).mh(this.ttO.sGE);
      }
    }
  }
  
  public final void e(List<b<c>> paramList, long paramLong)
  {
    AppMethodBeat.i(250828);
    p.h(paramList, "dataList");
    paramList = ((Iterable)paramList).iterator();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      cm localcm;
      int i;
      if (paramList.hasNext())
      {
        localObject1 = (b)paramList.next();
        localObject2 = ((c)((b)localObject1).RqA).uNJ.vEF;
        if (localObject2 != null)
        {
          localcm = (cm)a((a)b((a)new cm()), (o)localObject2);
          localcm.mp(d.zs(paramLong));
          localcm.adi();
          localcm.gA(((b)localObject1).Qgj);
          localcm.gC(((b)localObject1).wVY);
          localcm.gD(((b)localObject1).startTime);
          localcm.gE(((b)localObject1).endTime);
          localcm.gG(((b)localObject1).wVY);
          localcm.gH(((b)localObject1).startTime);
          localcm.gI(((b)localObject1).endTime);
          localObject1 = ((Iterable)((o)localObject2).vDZ).iterator();
          i = 0;
        }
      }
      else
      {
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          int j = i + 1;
          if (i < 0) {
            j.hxH();
          }
          localObject2 = (BaseFinderFeed)localObject2;
          if (i < 3)
          {
            localObject2 = (cm)a((a)new cm(localcm.abV()), (BaseFinderFeed)localObject2);
            ((cm)localObject2).gF(i);
            ((cm)localObject2).bfK();
            i = j;
            continue;
            AppMethodBeat.o(250828);
          }
          else
          {
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ac
 * JD-Core Version:    0.7.0.1
 */