package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoModObject;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "bulletSwitch", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getObjectId", "()J", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ea
  extends dz
{
  public static final a ADJ;
  private h callback;
  public final long hKN;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336763);
    ADJ = new a((byte)0);
    AppMethodBeat.o(336763);
  }
  
  public ea(String paramString, long paramLong, int paramInt, bui parambui)
  {
    AppMethodBeat.i(336761);
    this.hKN = paramLong;
    dnx localdnx = new dnx();
    bn localbn = bn.ABz;
    localdnx.aaVc = bn.b(parambui);
    localdnx.username = paramString;
    localdnx.NIs = this.hKN;
    localdnx.aaVd = paramInt;
    parambui = new c.a();
    parambui.uri = "/cgi-bin/micromsg-bin/megavideomodobject";
    parambui.funcId = getType();
    parambui.otE = ((a)localdnx);
    parambui.otF = ((a)new dny());
    parambui = parambui.bEF();
    kotlin.g.b.s.s(parambui, "builder.buildInstance()");
    this.rr = parambui;
    Log.i("NetSceneMegaVideoModObject", "NetSceneMegaVideoModObject username=" + paramString + ", videoObjectId=" + this.hKN + ", bulletCommentSwitch=" + paramInt);
    AppMethodBeat.o(336761);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336775);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336775);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(336770);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336770);
    return i;
  }
  
  public final int getType()
  {
    return 4061;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoModObject$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ea
 * JD-Core Version:    0.7.0.1
 */