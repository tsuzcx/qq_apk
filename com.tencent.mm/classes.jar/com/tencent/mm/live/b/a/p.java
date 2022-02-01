package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends n
  implements k
{
  public static final a gQn;
  private f callback;
  private b gPp;
  private bsv gQl;
  private bsw gQm;
  
  static
  {
    AppMethodBeat.i(212228);
    gQn = new a((byte)0);
    AppMethodBeat.o(212228);
  }
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212227);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bsv());
    ((b.a)localObject).d((a)new bsw());
    ((b.a)localObject).oP(3559);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/kickaudience");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    d.g.b.p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(212227);
      throw paramString1;
    }
    this.gQl = ((bsv)localObject);
    localObject = this.gQl;
    if (localObject != null) {
      ((bsv)localObject).Fsa = paramLong;
    }
    localObject = this.gQl;
    if (localObject != null) {
      ((bsv)localObject).Fsb = paramString1;
    }
    localObject = this.gQl;
    if (localObject != null) {
      ((bsv)localObject).username = paramString2;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(212227);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212225);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212225);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212226);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212226);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(212226);
      throw paramString;
    }
    this.gQm = ((bsw)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212226);
      return;
    }
    AppMethodBeat.o(212226);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */