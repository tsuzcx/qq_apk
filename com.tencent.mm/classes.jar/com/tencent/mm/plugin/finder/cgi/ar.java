package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ar
  extends ax
  implements m
{
  public static final a tuK;
  private i callback;
  private final String dDJ;
  private final int dYx;
  private d rr;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(242338);
    tuK = new a((byte)0);
    AppMethodBeat.o(242338);
  }
  
  public ar(String paramString1, String paramString2, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242337);
    this.userName = paramString1;
    this.dDJ = paramString2;
    this.dYx = paramInt;
    paramString1 = new d.a();
    paramString1.MB("/cgi-bin/micromsg-bin/finderaudiencereservelive");
    paramString1.sG(getType());
    paramString2 = new aor();
    paramString2.LAN = this.userName;
    paramString2.dDJ = this.dDJ;
    paramString2.opType = this.dYx;
    parambbn = new aos();
    paramString1.c((com.tencent.mm.bw.a)paramString2);
    paramString1.d((com.tencent.mm.bw.a)parambbn);
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i("Finder.NetSceneAudienceReserveLive", "NetSceneAudienceReserveLive init userName:" + this.userName + ", noticeId:" + this.dDJ + " ,optype:" + this.dYx + ' ');
    AppMethodBeat.o(242337);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(242336);
    Log.i("Finder.NetSceneAudienceReserveLive", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = com.tencent.mm.plugin.finder.live.a.ufi;
      paramString = this.userName;
      params = this.dDJ;
      if (this.dYx != 1) {
        break label184;
      }
      bool1 = true;
      com.tencent.mm.plugin.finder.live.a.q(paramString, params, bool1);
      paramString = new hw();
      paramString.dMx.dDJ = this.dDJ;
      params = paramString.dMx;
      if (this.dYx != 1) {
        break label190;
      }
    }
    label184:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      params.dCs = bool1;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(242336);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242335);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.btv("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(242335);
    return i;
  }
  
  public final int getType()
  {
    return 6276;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */