package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.dc;
import com.tencent.mm.f.b.a.dd;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fillCardInfo", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "struct", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillCommonInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillFeedInfo", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "reportClick", "", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "feedIndex", "", "reportExpose", "dataList", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "refreshTime", "", "reportExposeInternal", "cardStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardExposeReportStruct;", "plugin-finder_release"})
public final class ag
  extends g
{
  public ag(MMActivity paramMMActivity, bid parambid)
  {
    super((MMFragmentActivity)paramMMActivity, parambid);
    AppMethodBeat.i(287600);
    AppMethodBeat.o(287600);
  }
  
  public static <T extends a> T a(T paramT, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(287599);
    if ((paramT instanceof dd))
    {
      ((dd)paramT).oM(d.Fw(paramBaseFinderFeed.mf()));
      ((dd)paramT).oN(paramBaseFinderFeed.getSessionBuffer());
      ((dd)paramT).oP(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().longitude));
      ((dd)paramT).oO(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().latitude));
    }
    for (;;)
    {
      AppMethodBeat.o(287599);
      return paramT;
      if ((paramT instanceof dc))
      {
        ((dc)paramT).oD(d.Fw(paramBaseFinderFeed.mf()));
        ((dc)paramT).oE(paramBaseFinderFeed.getSessionBuffer());
      }
    }
  }
  
  public static <T extends a> T a(T paramT, com.tencent.mm.plugin.finder.storage.p paramp)
  {
    AppMethodBeat.i(287598);
    if ((paramT instanceof dd))
    {
      ((dd)paramT).oJ(paramp.dYH());
      ((dd)paramT).ht(paramp.dYG().lZJ);
      ((dd)paramT).oK(paramp.cKF());
      ((dd)paramT).oL(paramp.dYJ());
    }
    for (;;)
    {
      AppMethodBeat.o(287598);
      return paramT;
      if ((paramT instanceof dc))
      {
        ((dc)paramT).oB(paramp.dYH());
        ((dc)paramT).hq(paramp.dYG().lZJ);
        ((dc)paramT).oC(paramp.cKF());
      }
    }
  }
  
  public final <T extends a> T b(T paramT)
  {
    AppMethodBeat.i(287597);
    if ((paramT instanceof dd))
    {
      ((dd)paramT).oF(this.xbu.sessionId);
      ((dd)paramT).oG(this.xbu.wmL);
      ((dd)paramT).oH(this.xbu.wmz);
    }
    for (;;)
    {
      AppMethodBeat.o(287597);
      return paramT;
      if ((paramT instanceof dc))
      {
        ((dc)paramT).oy(this.xbu.sessionId);
        ((dc)paramT).oz(this.xbu.wmL);
        ((dc)paramT).oA(this.xbu.wmz);
      }
    }
  }
  
  public final void d(List<b<c>> paramList, long paramLong)
  {
    AppMethodBeat.i(287596);
    kotlin.g.b.p.k(paramList, "dataList");
    paramList = ((Iterable)paramList).iterator();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      dd localdd;
      int i;
      if (paramList.hasNext())
      {
        localObject1 = (b)paramList.next();
        localObject2 = ((c)((b)localObject1).YRY).zzX.AlT;
        if (localObject2 != null)
        {
          localdd = (dd)a((a)b((a)new dd()), (com.tencent.mm.plugin.finder.storage.p)localObject2);
          localdd.oI(d.Fw(paramLong));
          localdd.ahX();
          localdd.hs(((b)localObject1).XDo);
          localdd.hu(((b)localObject1).BHT);
          localdd.hv(((b)localObject1).startTime);
          localdd.hw(((b)localObject1).endTime);
          localdd.hy(((b)localObject1).BHT);
          localdd.hz(((b)localObject1).startTime);
          localdd.hA(((b)localObject1).endTime);
          localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.storage.p)localObject2).Alp).iterator();
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
            j.iBO();
          }
          localObject2 = (BaseFinderFeed)localObject2;
          if (i < 3)
          {
            localObject2 = (dd)a((a)new dd(localdd.agH()), (BaseFinderFeed)localObject2);
            ((dd)localObject2).hx(i);
            ((dd)localObject2).bpa();
            i = j;
            continue;
            AppMethodBeat.o(287596);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ag
 * JD-Core Version:    0.7.0.1
 */