package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class h
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbG;
  private g callback;
  private b iaa;
  private dxj zbE;
  private dxk zbF;
  
  static
  {
    AppMethodBeat.i(202719);
    zbG = new a((byte)0);
    AppMethodBeat.o(202719);
  }
  
  public h(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202718);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new dxj());
    ((b.a)localObject).d((a)new dxk());
    ((b.a)localObject).nB(3664);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/banlivecomment");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
      AppMethodBeat.o(202718);
      throw paramString;
    }
    this.zbE = ((dxj)localObject);
    localObject = this.zbE;
    if (localObject != null) {
      ((dxj)localObject).LwA = paramLong;
    }
    localObject = this.zbE;
    if (localObject != null) {
      ((dxj)localObject).EEF = paramString;
    }
    localObject = this.zbE;
    if (localObject != null) {
      ((dxj)localObject).LwF = paramBoolean;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + paramLong + ", roomId:" + paramString + ", enableComment:" + paramBoolean + ' ');
    AppMethodBeat.o(202718);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202716);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202716);
    return i;
  }
  
  public final int getType()
  {
    return 3664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202717);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202717);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
      AppMethodBeat.o(202717);
      throw paramString;
    }
    this.zbF = ((dxk)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202717);
      return;
    }
    AppMethodBeat.o(202717);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.h
 * JD-Core Version:    0.7.0.1
 */