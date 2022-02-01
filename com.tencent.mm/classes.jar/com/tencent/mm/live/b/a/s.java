package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class s
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwL;
  private g callback;
  public String content;
  private com.tencent.mm.ak.b gvE;
  private cgi gwJ;
  private cgj gwK;
  
  static
  {
    AppMethodBeat.i(189954);
    gwL = new a((byte)0);
    AppMethodBeat.o(189954);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(189953);
    this.content = paramString1;
    paramString1 = new b.a();
    paramString1.c((a)new cgi());
    paramString1.d((a)new cgj());
    paramString1.op(904);
    paramString1.Am("/cgi-bin/micromsg-bin/postlivemessage");
    paramString1.or(0);
    paramString1.os(0);
    paramString1 = paramString1.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.gvE = paramString1;
    paramString1 = this.gvE.aBC();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(189953);
      throw paramString1;
    }
    this.gwJ = ((cgi)paramString1);
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.EcB = paramInt;
    }
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.EQB = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    }
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.DMV = paramLong;
    }
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.DMW = paramString2;
    }
    paramString1 = this.gwJ;
    if (paramString1 != null) {
      paramString1.DMX = (u.axw() + System.currentTimeMillis());
    }
    ac.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(189953);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189951);
    ac.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189951);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189952);
    ac.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189952);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(189952);
      throw paramString;
    }
    this.gwK = ((cgj)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189952);
      return;
    }
    AppMethodBeat.o(189952);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */