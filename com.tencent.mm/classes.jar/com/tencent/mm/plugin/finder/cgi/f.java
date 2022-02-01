package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.report.m.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dzp;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "plugin-finder_release"})
public final class f
  extends an<alh>
{
  public f(List<? extends cxk> paramList, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197260);
    b.a locala = new b.a();
    Object localObject = new alg();
    locala.c((a)localObject);
    ((alg)localObject).Dmz.addAll((Collection)paramList);
    ((alg)localObject).finderUsername = u.aqO();
    am localam = am.KJy;
    ((alg)localObject).Dkw = am.a(paramdzp);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramdzp = (cxk)paramList.next();
      localObject = m.KVt;
      m.a.a(paramdzp, "Finder.CgiFinderStatsReport");
    }
    paramList = new alh();
    paramList.setBaseResponse(new BaseResponse());
    paramList.getBaseResponse().ErrMsg = new cmf();
    locala.d((a)paramList);
    locala.wg("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.nB(3776);
    c(locala.atI());
    AppMethodBeat.o(197260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */