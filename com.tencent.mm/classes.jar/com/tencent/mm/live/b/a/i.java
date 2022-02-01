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
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class i
  extends n
  implements k
{
  public static final a gSA;
  private f callback;
  private b gRX;
  private il gSy;
  private im gSz;
  
  static
  {
    AppMethodBeat.i(215820);
    gSA = new a((byte)0);
    AppMethodBeat.o(215820);
  }
  
  public i(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215819);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new il());
    ((b.a)localObject).d((a)new im());
    ((b.a)localObject).oS(3664);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/banlivecomment");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
      AppMethodBeat.o(215819);
      throw paramString;
    }
    this.gSy = ((il)localObject);
    localObject = this.gSy;
    if (localObject != null) {
      ((il)localObject).FKy = paramLong;
    }
    localObject = this.gSy;
    if (localObject != null) {
      ((il)localObject).FKz = paramString;
    }
    localObject = this.gSy;
    if (localObject != null) {
      ((il)localObject).FTM = paramBoolean;
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + paramLong + ", roomId:" + paramString + ", enableComment:" + paramBoolean + ' ');
    AppMethodBeat.o(215819);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215817);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215817);
    return i;
  }
  
  public final int getType()
  {
    return 3664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215818);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215818);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
      AppMethodBeat.o(215818);
      throw paramString;
    }
    this.gSz = ((im)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215818);
      return;
    }
    AppMethodBeat.o(215818);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.i
 * JD-Core Version:    0.7.0.1
 */