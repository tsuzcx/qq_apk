package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.ef;
import com.tencent.mm.autogen.mmdata.rpt.eg;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fillCardInfo", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "struct", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillCommonInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fillFeedInfo", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/plugin/report/AbsReportStruct;", "reportClick", "", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "feedIndex", "", "reportExpose", "dataList", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "refreshTime", "", "reportExposeInternal", "cardStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardExposeReportStruct;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends m
{
  public au(MMActivity paramMMActivity, bui parambui)
  {
    super((MMFragmentActivity)paramMMActivity, parambui);
    AppMethodBeat.i(331112);
    AppMethodBeat.o(331112);
  }
  
  public static <T extends a> T a(T paramT, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(331131);
    if ((paramT instanceof eg))
    {
      ((eg)paramT).oy(d.hF(paramBaseFinderFeed.bZA()));
      ((eg)paramT).oz(paramBaseFinderFeed.getSessionBuffer());
      ((eg)paramT).oB(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().longitude));
      ((eg)paramT).oA(String.valueOf(paramBaseFinderFeed.feedObject.getLocation().latitude));
    }
    for (;;)
    {
      AppMethodBeat.o(331131);
      return paramT;
      if ((paramT instanceof ef))
      {
        ((ef)paramT).op(d.hF(paramBaseFinderFeed.bZA()));
        ((ef)paramT).oq(paramBaseFinderFeed.getSessionBuffer());
      }
    }
  }
  
  public static <T extends a> T a(T paramT, q paramq)
  {
    AppMethodBeat.i(331120);
    if ((paramT instanceof eg))
    {
      ((eg)paramT).ov(paramq.eZo());
      ((eg)paramT).iCE = paramq.eZn().qvo;
      ((eg)paramT).ow(paramq.dnV());
      ((eg)paramT).ox(paramq.eZq());
    }
    for (;;)
    {
      AppMethodBeat.o(331120);
      return paramT;
      if ((paramT instanceof ef))
      {
        ((ef)paramT).on(paramq.eZo());
        ((ef)paramT).iCE = paramq.eZn().qvo;
        ((ef)paramT).oo(paramq.dnV());
      }
    }
  }
  
  public final <T extends a> T b(T paramT)
  {
    AppMethodBeat.i(331150);
    if ((paramT instanceof eg))
    {
      ((eg)paramT).or(this.Auc.sessionId);
      ((eg)paramT).os(this.Auc.zIO);
      ((eg)paramT).ot(this.Auc.zIB);
    }
    for (;;)
    {
      AppMethodBeat.o(331150);
      return paramT;
      if ((paramT instanceof ef))
      {
        ((ef)paramT).ok(this.Auc.sessionId);
        ((ef)paramT).ol(this.Auc.zIO);
        ((ef)paramT).om(this.Auc.zIB);
      }
    }
  }
  
  public final void e(List<b<c>> paramList, long paramLong)
  {
    AppMethodBeat.i(331144);
    s.u(paramList, "dataList");
    paramList = ((Iterable)paramList).iterator();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      eg localeg;
      int i;
      if (paramList.hasNext())
      {
        localObject1 = (b)paramList.next();
        localObject2 = ((c)((b)localObject1).agNK).ECd.FLL;
        if (localObject2 != null)
        {
          localeg = (eg)a((a)b((a)new eg()), (q)localObject2);
          localeg.ou(d.hF(paramLong));
          localeg.ioV = 1L;
          localeg.iCH = ((b)localObject1).afqR;
          localeg.iCJ = ((b)localObject1).HsA;
          localeg.iCK = ((b)localObject1).startTime;
          localeg.iCL = ((b)localObject1).endTime;
          localeg.iCM = ((b)localObject1).HsA;
          localeg.iCN = ((b)localObject1).startTime;
          localeg.iCO = ((b)localObject1).endTime;
          localObject1 = ((Iterable)((q)localObject2).FKS).iterator();
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
            p.kkW();
          }
          localObject2 = (BaseFinderFeed)localObject2;
          if (i < 3)
          {
            localObject2 = (eg)a((a)new eg(localeg.aIE()), (BaseFinderFeed)localObject2);
            ((eg)localObject2).iBT = i;
            ((eg)localObject2).bMH();
            i = j;
            continue;
            AppMethodBeat.o(331144);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.au
 * JD-Core Version:    0.7.0.1
 */