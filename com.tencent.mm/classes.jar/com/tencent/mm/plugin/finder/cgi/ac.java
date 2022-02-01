package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ac
  extends ad
  implements k
{
  private final String TAG;
  private f callback;
  private b rr;
  
  public ac(arn paramarn, aio paramaio)
  {
    super(paramarn);
    AppMethodBeat.i(201524);
    this.TAG = "Finder.NetSceneExtStatsReport";
    b.a locala = new b.a();
    locala.oS(getType());
    amx localamx = new amx();
    localamx.sbR = com.tencent.mm.model.v.aAK();
    localamx.actionType = 18054;
    localamx.rSz.add(paramaio);
    paramaio = v.rRb;
    localamx.GEg = v.a(paramarn);
    locala.c((a)localamx);
    paramarn = new amy();
    paramarn.setBaseResponse(new BaseResponse());
    locala.d((a)paramarn);
    locala.DN("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramarn = locala.aDS();
    p.g(paramarn, "builder.buildInstance()");
    this.rr = paramarn;
    AppMethodBeat.o(201524);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201522);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201522);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201523);
    ae.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201523);
      return;
    }
    AppMethodBeat.o(201523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */