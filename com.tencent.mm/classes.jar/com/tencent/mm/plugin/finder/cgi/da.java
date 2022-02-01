package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoModObject;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "bulletSwitch", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getObjectId", "()J", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class da
  extends cx
{
  public static final a xey;
  private i callback;
  private d rr;
  public final long xbk;
  
  static
  {
    AppMethodBeat.i(288069);
    xey = new a((byte)0);
    AppMethodBeat.o(288069);
  }
  
  public da(String paramString, long paramLong, int paramInt, bid parambid)
  {
    AppMethodBeat.i(288068);
    this.xbk = paramLong;
    cws localcws = new cws();
    as localas = as.xco;
    localcws.TFv = as.b(parambid);
    localcws.username = paramString;
    localcws.HLs = this.xbk;
    localcws.TFw = paramInt;
    parambid = new d.a();
    parambid.TW("/cgi-bin/micromsg-bin/megavideomodobject");
    parambid.vD(getType());
    parambid.c((a)localcws);
    parambid.d((a)new cwt());
    parambid = parambid.bgN();
    p.j(parambid, "builder.buildInstance()");
    this.rr = parambid;
    Log.i("NetSceneMegaVideoModObject", "NetSceneMegaVideoModObject username=" + paramString + ", videoObjectId=" + this.xbk + ", bulletCommentSwitch=" + paramInt);
    AppMethodBeat.o(288068);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(288066);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(288066);
      return;
    }
    AppMethodBeat.o(288066);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(288065);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(288065);
    return i;
  }
  
  public final int getType()
  {
    return 4061;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoModObject$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.da
 * JD-Core Version:    0.7.0.1
 */