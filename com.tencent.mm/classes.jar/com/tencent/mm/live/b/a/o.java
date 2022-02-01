package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ean;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class o
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zch;
  private g callback;
  private b iaa;
  private eam zcf;
  private ean zcg;
  
  static
  {
    AppMethodBeat.i(202747);
    zch = new a((byte)0);
    AppMethodBeat.o(202747);
  }
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202746);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new eam());
    ((b.a)localObject).d((a)new ean());
    ((b.a)localObject).nB(3559);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/kickaudience");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(202746);
      throw paramString1;
    }
    this.zcf = ((eam)localObject);
    localObject = this.zcf;
    if (localObject != null) {
      ((eam)localObject).LwA = paramLong;
    }
    localObject = this.zcf;
    if (localObject != null) {
      ((eam)localObject).EEF = paramString1;
    }
    localObject = this.zcf;
    if (localObject != null) {
      ((eam)localObject).username = paramString2;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(202746);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202744);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202744);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202745);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202745);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(202745);
      throw paramString;
    }
    this.zcg = ((ean)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202745);
      return;
    }
    AppMethodBeat.o(202745);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.o
 * JD-Core Version:    0.7.0.1
 */