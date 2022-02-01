package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwC;
  private g callback;
  private b gvE;
  private boi gwA;
  private boj gwB;
  
  static
  {
    AppMethodBeat.i(189942);
    gwC = new a((byte)0);
    AppMethodBeat.o(189942);
  }
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189941);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new boi());
    ((b.a)localObject).d((a)new boj());
    ((b.a)localObject).op(3559);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/kickaudience");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(189941);
      throw paramString1;
    }
    this.gwA = ((boi)localObject);
    localObject = this.gwA;
    if (localObject != null) {
      ((boi)localObject).DMV = paramLong;
    }
    localObject = this.gwA;
    if (localObject != null) {
      ((boi)localObject).DMW = paramString1;
    }
    localObject = this.gwA;
    if (localObject != null) {
      ((boi)localObject).username = paramString2;
    }
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(189941);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189939);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189939);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189940);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189940);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(189940);
      throw paramString;
    }
    this.gwB = ((boj)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189940);
      return;
    }
    AppMethodBeat.o(189940);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */