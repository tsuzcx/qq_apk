package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ix;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "promoToken", "scene", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Ljava/lang/Integer;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "getPromoToken", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bp
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ABE;
  private final Integer AAE;
  private final String ABF;
  private com.tencent.mm.am.h callback;
  private final String hAR;
  private final int hYl;
  private c rr;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(336462);
    ABE = new a((byte)0);
    AppMethodBeat.o(336462);
  }
  
  private bp(String paramString1, String paramString2, int paramInt, bui parambui, String paramString3, Integer paramInteger)
  {
    super(parambui);
    AppMethodBeat.i(336453);
    this.userName = paramString1;
    this.hAR = paramString2;
    this.hYl = paramInt;
    this.ABF = paramString3;
    this.AAE = paramInteger;
    paramString1 = new c.a();
    paramString1.uri = "/cgi-bin/micromsg-bin/finderaudiencereservelive";
    paramString1.funcId = getType();
    paramString2 = new ats();
    paramString2.Azl = this.userName;
    paramString2.hAR = this.hAR;
    paramString2.opType = this.hYl;
    paramString2.ZEl = this.ABF;
    parambui = this.AAE;
    if (parambui == null) {}
    for (paramInt = 0;; paramInt = parambui.intValue())
    {
      paramString2.scene = paramInt;
      parambui = new att();
      paramString1.otE = ((a)paramString2);
      paramString1.otF = ((a)parambui);
      paramString1 = paramString1.bEF();
      kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      Log.i("Finder.com.tencent.mm.plugin.finder.cgi.NetSceneAudienceReserveLive", "com.tencent.mm.plugin.finder.cgi.NetSceneAudienceReserveLive init userName:" + this.userName + ", noticeId:" + this.hAR + " ,optype:" + this.hYl + " ,promoToken:" + this.ABF);
      AppMethodBeat.o(336453);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(336481);
    Log.i("Finder.com.tencent.mm.plugin.finder.cgi.NetSceneAudienceReserveLive", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (aj)com.tencent.mm.kernel.h.ax(aj.class);
      params = this.userName;
      String str = this.hAR;
      if (this.hYl != 1) {
        break label187;
      }
      bool1 = true;
      paramString.u(params, str, bool1);
      paramString = new ix();
      paramString.hKA.hAR = this.hAR;
      params = paramString.hKA;
      if (this.hYl != 1) {
        break label193;
      }
    }
    label187:
    label193:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      params.hzt = bool1;
      paramString.publish();
      AppMethodBeat.o(336481);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336467);
    this.callback = paramh;
    c localc = this.rr;
    paramh = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      paramh = null;
    }
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(336467);
    return i;
  }
  
  public final int getType()
  {
    return 6276;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAudienceReserveLive$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bp
 * JD-Core Version:    0.7.0.1
 */