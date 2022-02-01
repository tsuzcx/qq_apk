package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPassReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "reportData", "", "(ILjava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getReportData", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dc
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String ACW;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  private final int scene;
  
  public dc(String paramString)
  {
    AppMethodBeat.i(336564);
    this.scene = 1;
    this.ACW = paramString;
    this.TAG = "Finder.NetSceneFinderPassReport";
    paramString = new c.a();
    paramString.funcId = getType();
    Object localObject = new bsb();
    ((bsb)localObject).scene = this.scene;
    ((bsb)localObject).YUu = this.ACW;
    paramString.otE = ((a)localObject);
    localObject = new bsc();
    ((bsc)localObject).setBaseResponse(new kd());
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/finderpassreport";
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "NetSceneFinderPassReport " + this.scene + ", " + this.ACW);
    AppMethodBeat.o(336564);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336570);
    Log.i(this.TAG, "onGYNetEnd " + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336570);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336583);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336583);
    return i;
  }
  
  public final int getType()
  {
    return 4093;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dc
 * JD-Core Version:    0.7.0.1
 */