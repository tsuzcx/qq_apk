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
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends q
  implements m
{
  public static final a kxM;
  private i callback;
  private d kwO;
  private cpg kxK;
  private cph kxL;
  
  static
  {
    AppMethodBeat.i(194618);
    kxM = new a((byte)0);
    AppMethodBeat.o(194618);
  }
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194617);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cpg());
    ((d.a)localObject).d((a)new cph());
    ((d.a)localObject).vD(3559);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/kickaudience");
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    kotlin.g.b.p.j(localObject, "builder.buildInstance()");
    this.kwO = ((d)localObject);
    localObject = this.kwO.bhX();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(194617);
      throw paramString1;
    }
    this.kxK = ((cpg)localObject);
    localObject = this.kxK;
    if (localObject != null) {
      ((cpg)localObject).klE = paramLong;
    }
    localObject = this.kxK;
    if (localObject != null) {
      ((cpg)localObject).RFj = paramString1;
    }
    localObject = this.kxK;
    if (localObject != null) {
      ((cpg)localObject).username = paramString2;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(194617);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(194610);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(194610);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194614);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(194614);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(194614);
      throw paramString;
    }
    this.kxL = ((cph)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(194614);
      return;
    }
    AppMethodBeat.o(194614);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */