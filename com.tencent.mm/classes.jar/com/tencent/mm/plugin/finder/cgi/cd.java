package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPassReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "reportData", "", "(ILjava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getReportData", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cd
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  private final int scene;
  private final String xdN;
  
  public cd(String paramString)
  {
    AppMethodBeat.i(232183);
    this.scene = 1;
    this.xdN = paramString;
    this.TAG = "Finder.NetSceneFinderPassReport";
    paramString = new d.a();
    paramString.vD(getType());
    Object localObject = new bgl();
    ((bgl)localObject).scene = this.scene;
    ((bgl)localObject).SRj = this.xdN;
    paramString.c((a)localObject);
    localObject = new bgm();
    ((bgm)localObject).setBaseResponse(new jh());
    paramString.d((a)localObject);
    paramString.TW("/cgi-bin/micromsg-bin/finderpassreport");
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "NetSceneFinderPassReport " + this.scene + ", " + this.xdN);
    AppMethodBeat.o(232183);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(232180);
    Log.i(this.TAG, "onGYNetEnd " + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(232180);
      return;
    }
    AppMethodBeat.o(232180);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(232181);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(232181);
    return i;
  }
  
  public final int getType()
  {
    return 4093;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cd
 * JD-Core Version:    0.7.0.1
 */