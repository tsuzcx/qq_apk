package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "eventName", "eventDesc", "coverUrl", "endTime", "", "scene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEventDesc", "()Ljava/lang/String;", "getEventName", "eventTopicId", "preCreateEventRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPreCreateEventRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getEventTopicId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cg
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xdU;
  private i callback;
  private final String coverUrl;
  private final String eventName;
  private d rr;
  private final String userName;
  public long xdR;
  private bhd xdS;
  private final String xdT;
  
  static
  {
    AppMethodBeat.i(277697);
    xdU = new a((byte)0);
    AppMethodBeat.o(277697);
  }
  
  private cg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    AppMethodBeat.i(277695);
    this.userName = paramString1;
    this.eventName = paramString2;
    this.xdT = paramString3;
    this.coverUrl = paramString4;
    paramString1 = new d.a();
    paramString1.TW("/cgi-bin/micromsg-bin/finderprecreateevent");
    paramString1.vD(getType());
    paramString2 = new bhd();
    paramString2.username = this.userName;
    paramString2.SRH = this.eventName;
    paramString2.SRI = this.xdT;
    paramString2.SRJ = this.coverUrl;
    paramString3 = ao.xcj;
    paramString2.SFL = ao.dnO();
    paramString2.Bjg = paramLong;
    paramString2.scene = paramInt;
    this.xdS = paramString2;
    paramString1.c((a)this.xdS);
    paramString1.d((a)new bhe());
    Log.i("Finder.LogPost.NetSceneFinderPost", "post userName:" + this.userName + " eventName:" + this.eventName + " eventDesc:" + this.xdT + " scene:" + paramInt);
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    AppMethodBeat.o(277695);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(277694);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPreCreateEventResponse");
        AppMethodBeat.o(277694);
        throw paramString;
      }
      this.xdR = ((bhe)params).SPF;
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(277694);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(277693);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(277693);
    return i;
  }
  
  public final int getType()
  {
    return 4050;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cg
 * JD-Core Version:    0.7.0.1
 */