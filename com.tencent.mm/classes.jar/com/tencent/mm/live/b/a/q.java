package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "likeCount", "", "(JLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LikeLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LikeLiveResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class q
  extends n
  implements k
{
  public static final a gQq;
  private f callback;
  private b gPp;
  private bud gQo;
  private bue gQp;
  
  static
  {
    AppMethodBeat.i(212232);
    gQq = new a((byte)0);
    AppMethodBeat.o(212232);
  }
  
  public q(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(212231);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bud());
    ((b.a)localObject).d((a)new bue());
    ((b.a)localObject).oP(3957);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/likelive");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveRequest");
      AppMethodBeat.o(212231);
      throw paramString;
    }
    this.gQo = ((bud)localObject);
    localObject = this.gQo;
    if (localObject != null) {
      ((bud)localObject).Fsa = paramLong;
    }
    localObject = this.gQo;
    if (localObject != null) {
      ((bud)localObject).Fsb = paramString;
    }
    localObject = this.gQo;
    if (localObject != null) {
      ((bud)localObject).count = paramInt;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "LikeLive liveId:" + paramLong + ", roomId:" + paramString + ", likeCount:" + paramInt);
    AppMethodBeat.o(212231);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212229);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.gPp, (k)this);
    AppMethodBeat.o(212229);
    return i;
  }
  
  public final int getType()
  {
    return 3957;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212230);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212230);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveResponse");
      AppMethodBeat.o(212230);
      throw paramString;
    }
    this.gQp = ((bue)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212230);
      return;
    }
    AppMethodBeat.o(212230);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.q
 * JD-Core Version:    0.7.0.1
 */