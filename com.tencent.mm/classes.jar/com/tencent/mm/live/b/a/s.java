package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "liveMicId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class s
  extends n
  implements com.tencent.mm.network.k
{
  public static final a Agz;
  private ebo Agx;
  public ebp Agy;
  private g callback;
  private b iaa;
  
  static
  {
    AppMethodBeat.i(202763);
    Agz = new a((byte)0);
    AppMethodBeat.o(202763);
  }
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202762);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ebo());
    ((b.a)localObject).d((a)new ebp());
    ((b.a)localObject).nB(760);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/refreshlivemic");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicRequest");
      AppMethodBeat.o(202762);
      throw paramString1;
    }
    this.Agx = ((ebo)localObject);
    this.Agx.LwA = paramLong;
    this.Agx.EEF = paramString1;
    this.Agx.LwC = paramString2;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", liveMicId:" + paramString2);
    AppMethodBeat.o(202762);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202760);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202760);
    return i;
  }
  
  public final int getType()
  {
    return 760;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202761);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202761);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicResponse");
      AppMethodBeat.o(202761);
      throw paramString;
    }
    this.Agy = ((ebp)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202761);
      return;
    }
    AppMethodBeat.o(202761);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */