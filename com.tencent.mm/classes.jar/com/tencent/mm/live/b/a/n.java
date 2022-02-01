package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class n
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static final a zce;
  private g callback;
  private com.tencent.mm.al.b iaa;
  private final eak zcb;
  public eal zcc;
  
  static
  {
    AppMethodBeat.i(202743);
    zce = new a((byte)0);
    AppMethodBeat.o(202743);
  }
  
  public n(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202742);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new eak());
    ((b.a)localObject).d((a)new eal());
    ((b.a)localObject).nB(3797);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/joinlive");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((com.tencent.mm.al.b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(202742);
      throw paramString;
    }
    this.zcb = ((eak)localObject);
    this.zcb.LwA = paramLong;
    this.zcb.EEF = paramString;
    this.zcb.LyM = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    AppMethodBeat.o(202742);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202740);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202740);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(202741);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202741);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(202741);
      throw paramString;
    }
    this.zcc = ((eal)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(202741);
        return;
      }
      AppMethodBeat.o(202741);
      return;
    }
    paramq = this.zcc;
    if (paramq != null) {}
    for (paramq = paramq.LyM;; paramq = null)
    {
      f localf = f.rGw;
      if (paramq != null) {
        paramArrayOfByte = paramq.getBytes();
      }
      f.jdMethod_do(paramArrayOfByte);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(202741);
      return;
    }
    AppMethodBeat.o(202741);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.n
 * JD-Core Version:    0.7.0.1
 */