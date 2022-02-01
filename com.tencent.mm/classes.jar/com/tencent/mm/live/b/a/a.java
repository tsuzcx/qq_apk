package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxt;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zaW;
  private g callback;
  private b iaa;
  private dxt zaU;
  private dxu zaV;
  
  static
  {
    AppMethodBeat.i(202691);
    zaW = new a((byte)0);
    AppMethodBeat.o(202691);
  }
  
  public a(long paramLong, String paramString)
  {
    AppMethodBeat.i(202690);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bx.a)new dxt());
    ((b.a)localObject).d((com.tencent.mm.bx.a)new dxu());
    ((b.a)localObject).nB(3583);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/closelive");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "close live id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveRequest");
      AppMethodBeat.o(202690);
      throw paramString;
    }
    this.zaU = ((dxt)localObject);
    this.zaU.LwA = paramLong;
    this.zaU.EEF = paramString;
    AppMethodBeat.o(202690);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202688);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202688);
    return i;
  }
  
  public final int getType()
  {
    return 3583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202689);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202689);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveResponse");
      AppMethodBeat.o(202689);
      throw paramString;
    }
    this.zaV = ((dxu)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202689);
      return;
    }
    AppMethodBeat.o(202689);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.a
 * JD-Core Version:    0.7.0.1
 */