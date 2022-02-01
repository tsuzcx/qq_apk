package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.h.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dcw;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "plugin-finder_release"})
public final class j
  extends r<aob>
{
  public j(List<? extends dcw> paramList, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201113);
    b.a locala = new b.a();
    Object localObject = new aoa();
    locala.c((a)localObject);
    ((aoa)localObject).EGL.addAll((Collection)paramList);
    ((aoa)localObject).rfC = u.axE();
    q localq = q.qXH;
    ((aoa)localObject).EDL = q.a(paramanm);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramanm = (dcw)paramList.next();
      localObject = h.ryk;
      h.a.a(paramanm, "Finder.CgiFinderStatsReport");
    }
    paramList = new aob();
    paramList.setBaseResponse(new BaseResponse());
    paramList.getBaseResponse().ErrMsg = new crm();
    locala.d((a)paramList);
    locala.Am("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.op(3776);
    c(locala.aAz());
    AppMethodBeat.o(201113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */