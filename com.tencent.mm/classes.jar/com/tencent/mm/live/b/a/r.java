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
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableOpenReplay", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class r
  extends n
  implements k
{
  public static final a gTb;
  private f callback;
  private b gRX;
  private cgm gSZ;
  private cgn gTa;
  
  static
  {
    AppMethodBeat.i(215856);
    gTb = new a((byte)0);
    AppMethodBeat.o(215856);
  }
  
  public r(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215855);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new cgm());
    ((b.a)localObject).d((a)new cgn());
    ((b.a)localObject).oS(3712);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/openlivereplay");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayRequest");
      AppMethodBeat.o(215855);
      throw paramString;
    }
    this.gSZ = ((cgm)localObject);
    localObject = this.gSZ;
    if (localObject != null) {
      ((cgm)localObject).FKy = paramLong;
    }
    localObject = this.gSZ;
    if (localObject != null) {
      ((cgm)localObject).FKz = paramString;
    }
    localObject = this.gSZ;
    if (localObject != null) {
      ((cgm)localObject).Hih = paramBoolean;
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "open live replay liveId:" + paramLong + " roomId:" + paramString + " enableLiveReplay:" + paramBoolean);
    AppMethodBeat.o(215855);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215853);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215853);
    return i;
  }
  
  public final int getType()
  {
    return 3712;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215854);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215854);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayResponse");
      AppMethodBeat.o(215854);
      throw paramString;
    }
    this.gTa = ((cgn)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215854);
      return;
    }
    AppMethodBeat.o(215854);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.r
 * JD-Core Version:    0.7.0.1
 */