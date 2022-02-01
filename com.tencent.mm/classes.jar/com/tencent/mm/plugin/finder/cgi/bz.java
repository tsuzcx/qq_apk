package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "eventTopicId", "", "finderUserName", "", "objectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bz
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xdu;
  private i callback;
  private d rr;
  public final int scene;
  public final Long xdt;
  
  static
  {
    AppMethodBeat.i(272148);
    xdu = new a((byte)0);
    AppMethodBeat.o(272148);
  }
  
  public bz(int paramInt, Long paramLong1, String paramString, Long paramLong2, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(272147);
    this.scene = paramInt;
    this.xdt = paramLong2;
    d.a locala = new d.a();
    locala.vD(getType());
    beq localbeq = new beq();
    if (paramLong1 != null) {
      localbeq.SPF = ((Number)paramLong1).longValue();
    }
    localbeq.RLN = paramString;
    paramLong2 = this.xdt;
    if (paramLong2 != null) {
      localbeq.object_id = ((Number)paramLong2).longValue();
    }
    localbeq.scene = this.scene;
    paramLong2 = ao.xcj;
    localbeq.RLM = ao.a(parambid);
    aqe localaqe = localbeq.RLM;
    if (localaqe != null) {
      if (parambid == null) {
        break label273;
      }
    }
    label273:
    for (paramLong2 = Integer.valueOf(parambid.fGo);; paramLong2 = null)
    {
      localaqe.scene = paramLong2.intValue();
      locala.c((a)localbeq);
      paramLong2 = new ber();
      paramLong2.setBaseResponse(new jh());
      locala.d((a)paramLong2);
      locala.TW("/cgi-bin/micromsg-bin/findermodevent");
      paramLong2 = locala.bgN();
      p.j(paramLong2, "builder.buildInstance()");
      this.rr = paramLong2;
      Log.i("Finder.NetSceneFinderModEvent", "NetSceneFinderModEvent init eventTopicId: " + paramLong1 + " userName: " + paramString + ", objectId:" + this.xdt);
      AppMethodBeat.o(272147);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(272146);
    Log.i("Finder.NetSceneFinderModEvent", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(272146);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(272145);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(272145);
    return i;
  }
  
  public final int getType()
  {
    return 5909;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent$Companion;", "", "()V", "CANCEL_PIN_FEED_TOP_SCENE", "", "DELETE_SCENE", "PIN_FEED_TOP_SCENE", "REMOVE_SCENE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bz
 * JD-Core Version:    0.7.0.1
 */