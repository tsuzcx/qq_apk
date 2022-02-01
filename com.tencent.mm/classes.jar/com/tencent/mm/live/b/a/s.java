package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class s
  extends n
  implements k
{
  public static final a gQw;
  private f callback;
  public String content;
  private com.tencent.mm.al.b gPp;
  private clh gQu;
  private cli gQv;
  
  static
  {
    AppMethodBeat.i(212240);
    gQw = new a((byte)0);
    AppMethodBeat.o(212240);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(212239);
    this.content = paramString1;
    paramString1 = new b.a();
    paramString1.c((a)new clh());
    paramString1.d((a)new cli());
    paramString1.oP(904);
    paramString1.Dl("/cgi-bin/micromsg-bin/postlivemessage");
    paramString1.oR(0);
    paramString1.oS(0);
    paramString1 = paramString1.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.gPp = paramString1;
    paramString1 = this.gPp.aEE();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(212239);
      throw paramString1;
    }
    this.gQu = ((clh)paramString1);
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.FIy = paramInt;
    }
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.GzS = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    }
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.Fsa = paramLong;
    }
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.Fsb = paramString2;
    }
    paramString1 = this.gQu;
    if (paramString1 != null) {
      paramString1.Fsc = (u.aAm() + System.currentTimeMillis());
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(212239);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212237);
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212237);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212238);
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212238);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(212238);
      throw paramString;
    }
    this.gQv = ((cli)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212238);
      return;
    }
    AppMethodBeat.o(212238);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */