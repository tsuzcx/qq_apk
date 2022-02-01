package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderExtStatsReportRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aw
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d rr;
  private b ttH;
  private aqn tuQ;
  
  public aw(bbn parambbn, alc paramalc)
  {
    this(parambbn, (List)j.ac(new alc[] { paramalc }));
    AppMethodBeat.i(242356);
    AppMethodBeat.o(242356);
  }
  
  public aw(bbn parambbn, List<? extends alc> paramList)
  {
    super(parambbn);
    AppMethodBeat.i(242357);
    this.TAG = "Finder.NetSceneExtStatsReport";
    this.ttH = b.tyf;
    d.a locala = new d.a();
    locala.sG(getType());
    aqn localaqn = new aqn();
    localaqn.finderUsername = z.aUg();
    localaqn.actionType = 18054;
    localaqn.twP.addAll((Collection)paramList);
    paramList = am.tuw;
    localaqn.LAI = am.a(parambbn);
    this.tuQ = localaqn;
    locala.c((a)this.tuQ);
    parambbn = new aqo();
    parambbn.setBaseResponse(new BaseResponse());
    locala.d((a)parambbn);
    locala.MB("/cgi-bin/micromsg-bin/finderextstatsreport");
    parambbn = locala.aXF();
    p.g(parambbn, "builder.buildInstance()");
    this.rr = parambbn;
    AppMethodBeat.o(242357);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242355);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    if (paramInt2 >= 4) {
      this.ttH = b.tyd;
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242355);
      return;
    }
    AppMethodBeat.o(242355);
  }
  
  public final b cXS()
  {
    return this.ttH;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242354);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242354);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */