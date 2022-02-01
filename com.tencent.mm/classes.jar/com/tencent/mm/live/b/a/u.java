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
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class u
  extends n
  implements k
{
  public static final a gQC;
  private f callback;
  private b gPp;
  private ddw gQA;
  private ddx gQB;
  
  static
  {
    AppMethodBeat.i(212248);
    gQC = new a((byte)0);
    AppMethodBeat.o(212248);
  }
  
  public u(long paramLong, String paramString)
  {
    AppMethodBeat.i(212247);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ddw());
    ((b.a)localObject).d((a)new ddx());
    ((b.a)localObject).oP(3557);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/sharelive");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(212247);
      throw paramString;
    }
    this.gQA = ((ddw)localObject);
    this.gQA.Fsa = paramLong;
    this.gQA.Fsb = paramString;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(212247);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212245);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212245);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212246);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212246);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(212246);
      throw paramString;
    }
    this.gQB = ((ddx)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212246);
      return;
    }
    AppMethodBeat.o(212246);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.u
 * JD-Core Version:    0.7.0.1
 */