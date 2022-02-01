package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends q
  implements m
{
  public static final a kxA;
  private i callback;
  private final String kie;
  private final String ktU;
  private d kwO;
  private final aeo kxy;
  public aep kxz;
  
  static
  {
    AppMethodBeat.i(196443);
    kxA = new a((byte)0);
    AppMethodBeat.o(196443);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196440);
    this.kie = paramString1;
    this.ktU = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)new aeo());
    paramString1.d((a)new aep());
    paramString1.vD(3501);
    paramString1.TW("/cgi-bin/micromsg-bin/createlive");
    paramString1.vF(0);
    paramString1.vG(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.kie + " roomId:" + this.ktU);
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.kwO = paramString1;
    paramString1 = this.kwO.bhX();
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(196440);
      throw paramString1;
    }
    this.kxy = ((aeo)paramString1);
    this.kxy.Srb = this.kie;
    this.kxy.RFj = this.ktU;
    AppMethodBeat.o(196440);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(196429);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(196429);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196434);
    p.k(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(196434);
      throw paramString;
    }
    this.kxz = ((aep)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(196434);
      return;
    }
    AppMethodBeat.o(196434);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */