package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "offset", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMoreGamesResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bf
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcN;
  private i callback;
  private d lKU;
  public bcj xcM;
  
  static
  {
    AppMethodBeat.i(285913);
    xcN = new a((byte)0);
    AppMethodBeat.o(285913);
  }
  
  private bf(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(285912);
    this.xcM = new bcj();
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/finderlivesearchmoregames");
    bci localbci = new bci();
    localbci.RLN = z.bdh();
    localbci.SNL = paramString1;
    localbci.SNM = paramString2;
    localbci.scene = 0;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.ADF;
    localbci.SLA = com.tencent.mm.plugin.finder.utils.p.ecZ();
    ((d.a)localObject).c((a)localbci);
    ((d.a)localObject).d((a)new bcj());
    localObject = ((d.a)localObject).bgN();
    kotlin.g.b.p.j(localObject, "builder.buildInstance()");
    this.lKU = ((d)localObject);
    Log.i("Finder.NetSceneFinderGameSearch", "NetSceneFinderGameSearch init: query = " + paramString1 + ", offset = " + paramString2 + ", scene = 0");
    AppMethodBeat.o(285912);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(285911);
    Log.i("Finder.NetSceneFinderGameSearch", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveSearchMoreGamesResponse");
      AppMethodBeat.o(285911);
      throw paramString;
    }
    this.xcM = ((bcj)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(285911);
      return;
    }
    AppMethodBeat.o(285911);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(285910);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(285910);
    return i;
  }
  
  public final int getType()
  {
    return 4140;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bf
 * JD-Core Version:    0.7.0.1
 */