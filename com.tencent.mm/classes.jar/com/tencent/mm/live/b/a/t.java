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
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "liveMicId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class t
  extends n
  implements k
{
  public static final a gQz;
  private f callback;
  private b gPp;
  private cso gQx;
  public csp gQy;
  
  static
  {
    AppMethodBeat.i(212244);
    gQz = new a((byte)0);
    AppMethodBeat.o(212244);
  }
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212243);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new cso());
    ((b.a)localObject).d((a)new csp());
    ((b.a)localObject).oP(760);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/refreshlivemic");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicRequest");
      AppMethodBeat.o(212243);
      throw paramString1;
    }
    this.gQx = ((cso)localObject);
    this.gQx.Fsa = paramLong;
    this.gQx.Fsb = paramString1;
    this.gQx.Fsd = paramString2;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", liveMicId:" + paramString2);
    AppMethodBeat.o(212243);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212241);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212241);
    return i;
  }
  
  public final int getType()
  {
    return 760;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212242);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212242);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicResponse");
      AppMethodBeat.o(212242);
      throw paramString;
    }
    this.gQy = ((csp)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212242);
      return;
    }
    AppMethodBeat.o(212242);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.t
 * JD-Core Version:    0.7.0.1
 */