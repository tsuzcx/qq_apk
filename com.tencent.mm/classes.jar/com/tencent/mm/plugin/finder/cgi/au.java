package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.ij;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xct;
  private i callback;
  private final int fSo;
  private final String fwt;
  private d rr;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(286519);
    xct = new a((byte)0);
    AppMethodBeat.o(286519);
  }
  
  public au(String paramString1, String paramString2, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(286518);
    this.userName = paramString1;
    this.fwt = paramString2;
    this.fSo = paramInt;
    paramString1 = new d.a();
    paramString1.TW("/cgi-bin/micromsg-bin/finderaudiencereservelive");
    paramString1.vD(getType());
    paramString2 = new apy();
    paramString2.SDn = this.userName;
    paramString2.fwt = this.fwt;
    paramString2.opType = this.fSo;
    parambid = new apz();
    paramString1.c((com.tencent.mm.cd.a)paramString2);
    paramString1.d((com.tencent.mm.cd.a)parambid);
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i("Finder.NetSceneAudienceReserveLive", "NetSceneAudienceReserveLive init userName:" + this.userName + ", noticeId:" + this.fwt + " ,optype:" + this.fSo + ' ');
    AppMethodBeat.o(286518);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(286517);
    Log.i("Finder.NetSceneAudienceReserveLive", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = com.tencent.mm.plugin.finder.live.a.xUC;
      paramString = this.userName;
      params = this.fwt;
      if (this.fSo != 1) {
        break label184;
      }
      bool1 = true;
      com.tencent.mm.plugin.finder.live.a.r(paramString, params, bool1);
      paramString = new ij();
      paramString.fFC.fwt = this.fwt;
      params = paramString.fFC;
      if (this.fSo != 1) {
        break label190;
      }
    }
    label184:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      params.fuZ = bool1;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(286517);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(286516);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.bGy("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(286516);
    return i;
  }
  
  public final int getType()
  {
    return 6276;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */