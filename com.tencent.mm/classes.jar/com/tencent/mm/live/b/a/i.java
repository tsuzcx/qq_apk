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
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class i
  extends n
  implements k
{
  public static final a gPS;
  private f callback;
  private il gPQ;
  private im gPR;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212200);
    gPS = new a((byte)0);
    AppMethodBeat.o(212200);
  }
  
  public i(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212199);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new il());
    ((b.a)localObject).d((a)new im());
    ((b.a)localObject).oP(3664);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/banlivecomment");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
      AppMethodBeat.o(212199);
      throw paramString;
    }
    this.gPQ = ((il)localObject);
    localObject = this.gPQ;
    if (localObject != null) {
      ((il)localObject).Fsa = paramLong;
    }
    localObject = this.gPQ;
    if (localObject != null) {
      ((il)localObject).Fsb = paramString;
    }
    localObject = this.gPQ;
    if (localObject != null) {
      ((il)localObject).FBr = paramBoolean;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + paramLong + ", roomId:" + paramString + ", enableComment:" + paramBoolean + ' ');
    AppMethodBeat.o(212199);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212197);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212197);
    return i;
  }
  
  public final int getType()
  {
    return 3664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212198);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212198);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
      AppMethodBeat.o(212198);
      throw paramString;
    }
    this.gPR = ((im)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212198);
      return;
    }
    AppMethodBeat.o(212198);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.i
 * JD-Core Version:    0.7.0.1
 */