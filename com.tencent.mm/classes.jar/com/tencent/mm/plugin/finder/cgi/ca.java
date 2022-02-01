package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFansSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchFansResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ca
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public bus ABZ;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c oDw;
  
  private ca(String paramString, b paramb)
  {
    super(null);
    AppMethodBeat.i(336310);
    this.TAG = "Finder.NetSceneFinderFansSearch";
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/findersearchfans";
    bur localbur = new bur();
    localbur.query = paramString;
    localbur.BgS = paramb;
    paramb = bi.ABn;
    localbur.CJv = bi.a(null);
    localbur.finderUsername = z.bAW();
    locala.otE = ((a)localbur);
    locala.otF = ((a)new bus());
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.oDw = paramb;
    Log.i(this.TAG, kotlin.g.b.s.X("NetSceneFinderFansSearch init query ", paramString));
    this.ABZ = new bus();
    AppMethodBeat.o(336310);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336332);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchFansResponse");
      AppMethodBeat.o(336332);
      throw paramString;
    }
    this.ABZ = ((bus)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336332);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336323);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336323);
    return i;
  }
  
  public final int getType()
  {
    return 6665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ca
 * JD-Core Version:    0.7.0.1
 */