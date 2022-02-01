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
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "msgId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class h
  extends n
  implements k
{
  public static final a gSx;
  private f callback;
  private b gRX;
  private gj gSv;
  public gk gSw;
  
  static
  {
    AppMethodBeat.i(215816);
    gSx = new a((byte)0);
    AppMethodBeat.o(215816);
  }
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215815);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new gj());
    ((b.a)localObject).d((a)new gk());
    ((b.a)localObject).oS(3995);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/applylivemic");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicRequest");
      AppMethodBeat.o(215815);
      throw paramString1;
    }
    this.gSv = ((gj)localObject);
    this.gSv.FKy = paramLong;
    this.gSv.FKz = paramString1;
    this.gSv.FKA = paramString2;
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "apply live mic, liveId:" + paramLong + ", roomId:" + paramString1 + ", msgId:" + paramString2);
    AppMethodBeat.o(215815);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215813);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215813);
    return i;
  }
  
  public final int getType()
  {
    return 3995;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215814);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215814);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicResponse");
      AppMethodBeat.o(215814);
      throw paramString;
    }
    this.gSw = ((gk)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215814);
      return;
    }
    AppMethodBeat.o(215814);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.h
 * JD-Core Version:    0.7.0.1
 */