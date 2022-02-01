package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class o
  extends n
  implements k
{
  public static final a gQk;
  private f callback;
  private com.tencent.mm.al.b gPp;
  private final bro gQi;
  public brp gQj;
  
  static
  {
    AppMethodBeat.i(212224);
    gQk = new a((byte)0);
    AppMethodBeat.o(212224);
  }
  
  public o(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212223);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bro());
    ((b.a)localObject).d((a)new brp());
    ((b.a)localObject).oP(3797);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/joinlive");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((com.tencent.mm.al.b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(212223);
      throw paramString;
    }
    this.gQi = ((bro)localObject);
    this.gQi.Fsa = paramLong;
    this.gQi.Fsb = paramString;
    this.gQi.GzS = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    AppMethodBeat.o(212223);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212221);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212221);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(212222);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212222);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(212222);
      throw paramString;
    }
    this.gQj = ((brp)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(212222);
        return;
      }
      AppMethodBeat.o(212222);
      return;
    }
    paramq = this.gQj;
    if (paramq != null) {}
    for (paramq = paramq.GzS;; paramq = null)
    {
      g localg = g.gOr;
      if (paramq != null) {
        paramArrayOfByte = paramq.getBytes();
      }
      g.P(paramArrayOfByte);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212222);
      return;
    }
    AppMethodBeat.o(212222);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.o
 * JD-Core Version:    0.7.0.1
 */