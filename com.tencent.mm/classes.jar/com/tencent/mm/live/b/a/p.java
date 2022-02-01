package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends n
  implements k
{
  public static final a gSV;
  private f callback;
  private b gRX;
  private btp gST;
  private btq gSU;
  
  static
  {
    AppMethodBeat.i(215848);
    gSV = new a((byte)0);
    AppMethodBeat.o(215848);
  }
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215847);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new btp());
    ((b.a)localObject).d((a)new btq());
    ((b.a)localObject).oS(3559);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/kickaudience");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    d.g.b.p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(215847);
      throw paramString1;
    }
    this.gST = ((btp)localObject);
    localObject = this.gST;
    if (localObject != null) {
      ((btp)localObject).FKy = paramLong;
    }
    localObject = this.gST;
    if (localObject != null) {
      ((btp)localObject).FKz = paramString1;
    }
    localObject = this.gST;
    if (localObject != null) {
      ((btp)localObject).username = paramString2;
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(215847);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215845);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215845);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215846);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215846);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(215846);
      throw paramString;
    }
    this.gSU = ((btq)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215846);
      return;
    }
    AppMethodBeat.o(215846);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */