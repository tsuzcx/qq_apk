package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "likeCount", "", "(JLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LikeLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LikeLiveResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zck;
  private g callback;
  private b iaa;
  private eao zci;
  private eap zcj;
  
  static
  {
    AppMethodBeat.i(202751);
    zck = new a((byte)0);
    AppMethodBeat.o(202751);
  }
  
  public p(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(202750);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new eao());
    ((b.a)localObject).d((a)new eap());
    ((b.a)localObject).nB(3957);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/likelive");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveRequest");
      AppMethodBeat.o(202750);
      throw paramString;
    }
    this.zci = ((eao)localObject);
    localObject = this.zci;
    if (localObject != null) {
      ((eao)localObject).LwA = paramLong;
    }
    localObject = this.zci;
    if (localObject != null) {
      ((eao)localObject).EEF = paramString;
    }
    localObject = this.zci;
    if (localObject != null) {
      ((eao)localObject).count = paramInt;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "LikeLive liveId:" + paramLong + ", roomId:" + paramString + ", likeCount:" + paramInt);
    AppMethodBeat.o(202750);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202748);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202748);
    return i;
  }
  
  public final int getType()
  {
    return 3957;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202749);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202749);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveResponse");
      AppMethodBeat.o(202749);
      throw paramString;
    }
    this.zcj = ((eap)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202749);
      return;
    }
    AppMethodBeat.o(202749);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */