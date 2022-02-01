package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "likeCount", "", "(JLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LikeLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LikeLiveResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class q
  extends n
  implements k
{
  public static final a gSY;
  private f callback;
  private b gRX;
  private bux gSW;
  private buy gSX;
  
  static
  {
    AppMethodBeat.i(215852);
    gSY = new a((byte)0);
    AppMethodBeat.o(215852);
  }
  
  public q(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(215851);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bux());
    ((b.a)localObject).d((a)new buy());
    ((b.a)localObject).oS(3957);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/likelive");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveRequest");
      AppMethodBeat.o(215851);
      throw paramString;
    }
    this.gSW = ((bux)localObject);
    localObject = this.gSW;
    if (localObject != null) {
      ((bux)localObject).FKy = paramLong;
    }
    localObject = this.gSW;
    if (localObject != null) {
      ((bux)localObject).FKz = paramString;
    }
    localObject = this.gSW;
    if (localObject != null) {
      ((bux)localObject).count = paramInt;
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "LikeLive liveId:" + paramLong + ", roomId:" + paramString + ", likeCount:" + paramInt);
    AppMethodBeat.o(215851);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215849);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.gRX, (k)this);
    AppMethodBeat.o(215849);
    return i;
  }
  
  public final int getType()
  {
    return 3957;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215850);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215850);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveResponse");
      AppMethodBeat.o(215850);
      throw paramString;
    }
    this.gSX = ((buy)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215850);
      return;
    }
    AppMethodBeat.o(215850);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.q
 * JD-Core Version:    0.7.0.1
 */