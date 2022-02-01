package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "cutLive", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class a
  extends n
  implements k
{
  public static final a gSa;
  private f callback;
  private b gRX;
  private zp gRY;
  private zq gRZ;
  
  static
  {
    AppMethodBeat.i(215788);
    gSa = new a((byte)0);
    AppMethodBeat.o(215788);
  }
  
  public a(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215787);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new zp());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new zq());
    ((b.a)localObject).oS(3583);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/closelive");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    ae.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "close live id:" + paramLong + " wechatRoomId:" + paramString + " cutLive:" + paramBoolean);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveRequest");
      AppMethodBeat.o(215787);
      throw paramString;
    }
    this.gRY = ((zp)localObject);
    this.gRY.FKy = paramLong;
    this.gRY.FKz = paramString;
    this.gRY.Grq = paramBoolean;
    AppMethodBeat.o(215787);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215785);
    ae.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215785);
    return i;
  }
  
  public final int getType()
  {
    return 3583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215786);
    ae.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215786);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveResponse");
      AppMethodBeat.o(215786);
      throw paramString;
    }
    this.gRZ = ((zq)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215786);
      return;
    }
    AppMethodBeat.o(215786);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.a
 * JD-Core Version:    0.7.0.1
 */