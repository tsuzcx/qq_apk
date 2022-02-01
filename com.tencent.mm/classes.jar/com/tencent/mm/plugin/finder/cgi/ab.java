package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ab
  extends ac
  implements k
{
  private final String TAG;
  private f callback;
  private b rr;
  
  public ab(aqy paramaqy, aie paramaie)
  {
    super(paramaqy);
    AppMethodBeat.i(201102);
    this.TAG = "Finder.NetSceneExtStatsReport";
    b.a locala = new b.a();
    locala.oP(getType());
    aml localaml = new aml();
    localaml.rTn = u.aAu();
    localaml.actionType = 18054;
    localaml.rKn.add(paramaie);
    paramaie = v.rIR;
    localaml.Gle = v.a(paramaqy);
    locala.c((a)localaml);
    paramaqy = new amm();
    paramaqy.setBaseResponse(new BaseResponse());
    locala.d((a)paramaqy);
    locala.Dl("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramaqy = locala.aDC();
    p.g(paramaqy, "builder.buildInstance()");
    this.rr = paramaqy;
    AppMethodBeat.o(201102);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201100);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201100);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201101);
    ad.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201101);
      return;
    }
    AppMethodBeat.o(201101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */