package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "", "offset", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMoreGamesResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cc
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACc;
  public bmk ACd;
  private com.tencent.mm.am.h callback;
  private c oDw;
  
  static
  {
    AppMethodBeat.i(336315);
    ACc = new a((byte)0);
    AppMethodBeat.o(336315);
  }
  
  private cc(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(336295);
    this.ACd = new bmk();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/finderlivesearchmoregames";
    bmj localbmj = new bmj();
    localbmj.YIZ = z.bAW();
    localbmj.ZVb = paramString1;
    localbmj.ZVc = paramString2;
    localbmj.scene = 0;
    t localt = t.GgN;
    localbmj.ZRz = t.feU();
    ((c.a)localObject).otE = ((a)localbmj);
    ((c.a)localObject).otF = ((a)new bmk());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.oDw = ((c)localObject);
    Log.i("Finder.NetSceneFinderGameSearch", "NetSceneFinderGameSearch init: query = " + paramString1 + ", offset = " + paramString2 + ", scene = 0");
    AppMethodBeat.o(336295);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336355);
    Log.i("Finder.NetSceneFinderGameSearch", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveSearchMoreGamesResponse");
      AppMethodBeat.o(336355);
      throw paramString;
    }
    this.ACd = ((bmk)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336355);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336325);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336325);
    return i;
  }
  
  public final int getType()
  {
    return 4140;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cc
 * JD-Core Version:    0.7.0.1
 */