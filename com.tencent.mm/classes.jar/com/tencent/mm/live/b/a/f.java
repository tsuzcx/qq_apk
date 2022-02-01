package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "audience", "", "roomId", "liveMicId", "msgId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class f
  extends n
  implements k
{
  public static final a gSr;
  private com.tencent.mm.ak.f callback;
  private b gRX;
  private ar gSp;
  private as gSq;
  
  static
  {
    AppMethodBeat.i(215808);
    gSr = new a((byte)0);
    AppMethodBeat.o(215808);
  }
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(215807);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ar());
    ((b.a)localObject).d((a)new as());
    ((b.a)localObject).oS(3800);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/acceptlivemic");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicRequest");
      AppMethodBeat.o(215807);
      throw paramString1;
    }
    this.gSp = ((ar)localObject);
    this.gSp.FKy = paramLong;
    this.gSp.gTB = paramString1;
    this.gSp.FKz = paramString2;
    this.gSp.FKB = paramString3;
    this.gSp.FKA = paramString4;
    AppMethodBeat.o(215807);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(215805);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215805);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215806);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215806);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicResponse");
      AppMethodBeat.o(215806);
      throw paramString;
    }
    this.gSq = ((as)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215806);
      return;
    }
    AppMethodBeat.o(215806);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.f
 * JD-Core Version:    0.7.0.1
 */