package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFansSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchFansResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bd
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d lKU;
  public bij xcJ;
  
  private bd(String paramString, b paramb)
  {
    super(null);
    AppMethodBeat.i(280543);
    this.TAG = "Finder.NetSceneFinderFansSearch";
    d.a locala = new d.a();
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/findersearchfans");
    bii localbii = new bii();
    localbii.query = paramString;
    localbii.xHE = paramb;
    paramb = ao.xcj;
    localbii.yjp = ao.a(null);
    localbii.finderUsername = z.bdh();
    locala.c((a)localbii);
    locala.d((a)new bij());
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.lKU = paramb;
    Log.i(this.TAG, "NetSceneFinderFansSearch init query ".concat(String.valueOf(paramString)));
    this.xcJ = new bij();
    AppMethodBeat.o(280543);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(280542);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchFansResponse");
      AppMethodBeat.o(280542);
      throw paramString;
    }
    this.xcJ = ((bij)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(280542);
      return;
    }
    AppMethodBeat.o(280542);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(280541);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(280541);
    return i;
  }
  
  public final int getType()
  {
    return 6665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bd
 * JD-Core Version:    0.7.0.1
 */