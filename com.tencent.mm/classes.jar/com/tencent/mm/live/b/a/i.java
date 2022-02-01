package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class i
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwh;
  private g callback;
  private b gvE;
  private ie gwf;
  private if gwg;
  
  static
  {
    AppMethodBeat.i(189914);
    gwh = new a((byte)0);
    AppMethodBeat.o(189914);
  }
  
  public i(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189913);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ie());
    ((b.a)localObject).d((a)new if());
    ((b.a)localObject).op(3664);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/banlivecomment");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
      AppMethodBeat.o(189913);
      throw paramString;
    }
    this.gwf = ((ie)localObject);
    localObject = this.gwf;
    if (localObject != null) {
      ((ie)localObject).DMV = paramLong;
    }
    localObject = this.gwf;
    if (localObject != null) {
      ((ie)localObject).DMW = paramString;
    }
    localObject = this.gwf;
    if (localObject != null) {
      ((ie)localObject).DVV = paramBoolean;
    }
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + paramLong + ", roomId:" + paramString + ", enableComment:" + paramBoolean + ' ');
    AppMethodBeat.o(189913);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189911);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189911);
    return i;
  }
  
  public final int getType()
  {
    return 3664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189912);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189912);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
      AppMethodBeat.o(189912);
      throw paramString;
    }
    this.gwg = ((if)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189912);
      return;
    }
    AppMethodBeat.o(189912);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.i
 * JD-Core Version:    0.7.0.1
 */