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
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "liveMicId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class t
  extends n
  implements k
{
  public static final a gTh;
  private f callback;
  private b gRX;
  private cti gTf;
  public ctj gTg;
  
  static
  {
    AppMethodBeat.i(215864);
    gTh = new a((byte)0);
    AppMethodBeat.o(215864);
  }
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215863);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new cti());
    ((b.a)localObject).d((a)new ctj());
    ((b.a)localObject).oS(760);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/refreshlivemic");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicRequest");
      AppMethodBeat.o(215863);
      throw paramString1;
    }
    this.gTf = ((cti)localObject);
    this.gTf.FKy = paramLong;
    this.gTf.FKz = paramString1;
    this.gTf.FKB = paramString2;
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", liveMicId:" + paramString2);
    AppMethodBeat.o(215863);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215861);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215861);
    return i;
  }
  
  public final int getType()
  {
    return 760;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215862);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215862);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicResponse");
      AppMethodBeat.o(215862);
      throw paramString;
    }
    this.gTg = ((ctj)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215862);
      return;
    }
    AppMethodBeat.o(215862);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.t
 * JD-Core Version:    0.7.0.1
 */