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
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "isClose", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class j
  extends n
  implements k
{
  public static final a gSD;
  private f callback;
  private b gRX;
  private zj gSB;
  private zk gSC;
  
  static
  {
    AppMethodBeat.i(215824);
    gSD = new a((byte)0);
    AppMethodBeat.o(215824);
  }
  
  public j(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215823);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new zj());
    ((b.a)localObject).d((a)new zk());
    ((b.a)localObject).oS(3530);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/closeapplylivemic");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "close live id:" + paramLong + " wechatRoomId:" + paramString + " isClose:" + paramBoolean);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicRequest");
      AppMethodBeat.o(215823);
      throw paramString;
    }
    this.gSB = ((zj)localObject);
    this.gSB.FKy = paramLong;
    this.gSB.FKz = paramString;
    paramString = this.gSB;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.Grn = paramBoolean;
      AppMethodBeat.o(215823);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215821);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215821);
    return i;
  }
  
  public final int getType()
  {
    return 3530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215822);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215822);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicResponse");
      AppMethodBeat.o(215822);
      throw paramString;
    }
    this.gSC = ((zk)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215822);
      return;
    }
    AppMethodBeat.o(215822);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.j
 * JD-Core Version:    0.7.0.1
 */