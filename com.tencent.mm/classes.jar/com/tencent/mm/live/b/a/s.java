package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class s
  extends n
  implements k
{
  public static final a gTe;
  private f callback;
  public String content;
  private com.tencent.mm.ak.b gRX;
  private cmb gTc;
  private cmc gTd;
  
  static
  {
    AppMethodBeat.i(215860);
    gTe = new a((byte)0);
    AppMethodBeat.o(215860);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(215859);
    this.content = paramString1;
    paramString1 = new b.a();
    paramString1.c((a)new cmb());
    paramString1.d((a)new cmc());
    paramString1.oS(904);
    paramString1.DN("/cgi-bin/micromsg-bin/postlivemessage");
    paramString1.oU(0);
    paramString1.oV(0);
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.gRX = paramString1;
    paramString1 = this.gRX.aEU();
    if (paramString1 == null)
    {
      paramString1 = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(215859);
      throw paramString1;
    }
    this.gTc = ((cmb)paramString1);
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.GaV = paramInt;
    }
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.GTs = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    }
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.FKy = paramLong;
    }
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.FKz = paramString2;
    }
    paramString1 = this.gTc;
    if (paramString1 != null) {
      paramString1.FKA = (com.tencent.mm.model.v.aAC() + System.currentTimeMillis());
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(215859);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215857);
    ae.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215857);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215858);
    ae.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215858);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(215858);
      throw paramString;
    }
    this.gTd = ((cmc)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215858);
      return;
    }
    AppMethodBeat.o(215858);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */