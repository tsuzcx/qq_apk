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
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class u
  extends n
  implements k
{
  public static final a gTk;
  private f callback;
  private b gRX;
  private deq gTi;
  private der gTj;
  
  static
  {
    AppMethodBeat.i(215868);
    gTk = new a((byte)0);
    AppMethodBeat.o(215868);
  }
  
  public u(long paramLong, String paramString)
  {
    AppMethodBeat.i(215867);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new deq());
    ((b.a)localObject).d((a)new der());
    ((b.a)localObject).oS(3557);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/sharelive");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(215867);
      throw paramString;
    }
    this.gTi = ((deq)localObject);
    this.gTi.FKy = paramLong;
    this.gTi.FKz = paramString;
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(215867);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215865);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215865);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215866);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215866);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(215866);
      throw paramString;
    }
    this.gTj = ((der)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215866);
      return;
    }
    AppMethodBeat.o(215866);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.u
 * JD-Core Version:    0.7.0.1
 */