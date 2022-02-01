package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFansSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchFansResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ba
  extends ax
{
  private final String TAG;
  private i callback;
  private d iUB;
  public bbt tva;
  
  private ba(String paramString, b paramb)
  {
    super(null);
    AppMethodBeat.i(242371);
    this.TAG = "Finder.NetSceneFinderFansSearch";
    d.a locala = new d.a();
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/findersearchfans");
    bbs localbbs = new bbs();
    localbbs.query = paramString;
    localbbs.tVM = paramb;
    paramb = am.tuw;
    localbbs.uli = am.a(null);
    localbbs.finderUsername = z.aUg();
    locala.c((a)localbbs);
    locala.d((a)new bbt());
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.iUB = paramb;
    Log.i(this.TAG, "NetSceneFinderFansSearch init query ".concat(String.valueOf(paramString)));
    this.tva = new bbt();
    AppMethodBeat.o(242371);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242370);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchFansResponse");
      AppMethodBeat.o(242370);
      throw paramString;
    }
    this.tva = ((bbt)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242370);
      return;
    }
    AppMethodBeat.o(242370);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242369);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(242369);
    return i;
  }
  
  public final int getType()
  {
    return 6665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ba
 * JD-Core Version:    0.7.0.1
 */