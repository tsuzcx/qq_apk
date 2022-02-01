package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "audience", "", "roomId", "liveMicId", "msgId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbk;
  private g callback;
  private b iaa;
  private dxf zbh;
  private dxg zbj;
  
  static
  {
    AppMethodBeat.i(202707);
    zbk = new a((byte)0);
    AppMethodBeat.o(202707);
  }
  
  public e(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202706);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new dxf());
    ((b.a)localObject).d((a)new dxg());
    ((b.a)localObject).nB(3800);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/acceptlivemic");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicRequest");
      AppMethodBeat.o(202706);
      throw paramString1;
    }
    this.zbh = ((dxf)localObject);
    this.zbh.LwA = paramLong;
    this.zbh.CaG = paramString1;
    this.zbh.EEF = paramString2;
    this.zbh.LwC = paramString3;
    this.zbh.LwB = paramString4;
    AppMethodBeat.o(202706);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(202704);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202704);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202705);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202705);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicResponse");
      AppMethodBeat.o(202705);
      throw paramString;
    }
    this.zbj = ((dxg)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202705);
      return;
    }
    AppMethodBeat.o(202705);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.e
 * JD-Core Version:    0.7.0.1
 */