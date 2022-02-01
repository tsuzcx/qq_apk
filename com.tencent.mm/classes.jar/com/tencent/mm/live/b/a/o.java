package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class o
  extends n
  implements k
{
  public static final a gSS;
  private f callback;
  private com.tencent.mm.ak.b gRX;
  private final bsi gSQ;
  public bsj gSR;
  
  static
  {
    AppMethodBeat.i(215844);
    gSS = new a((byte)0);
    AppMethodBeat.o(215844);
  }
  
  public o(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215843);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bsi());
    ((b.a)localObject).d((a)new bsj());
    ((b.a)localObject).oS(3797);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/joinlive");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(215843);
      throw paramString;
    }
    this.gSQ = ((bsi)localObject);
    this.gSQ.FKy = paramLong;
    this.gSQ.FKz = paramString;
    this.gSQ.GTs = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    AppMethodBeat.o(215843);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215841);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215841);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(215842);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215842);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(215842);
      throw paramString;
    }
    this.gSR = ((bsj)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(215842);
        return;
      }
      AppMethodBeat.o(215842);
      return;
    }
    paramq = this.gSR;
    if (paramq != null) {}
    for (paramq = paramq.GTs;; paramq = null)
    {
      g localg = g.gQZ;
      if (paramq != null) {
        paramArrayOfByte = paramq.getBytes();
      }
      g.P(paramArrayOfByte);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215842);
      return;
    }
    AppMethodBeat.o(215842);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.o
 * JD-Core Version:    0.7.0.1
 */