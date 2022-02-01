package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbP;
  private g callback;
  private b iaa;
  private final String qVO;
  private final String qud;
  private final dxy zbN;
  public dxz zbO;
  
  static
  {
    AppMethodBeat.i(202731);
    zbP = new a((byte)0);
    AppMethodBeat.o(202731);
  }
  
  public k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202730);
    this.qud = paramString1;
    this.qVO = paramString2;
    paramString1 = new b.a();
    paramString1.c((a)new dxy());
    paramString1.d((a)new dxz());
    paramString1.nB(3501);
    paramString1.wg("/cgi-bin/micromsg-bin/createlive");
    paramString1.nD(0);
    paramString1.nE(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.qud + " roomId:" + this.qVO);
    paramString1 = paramString1.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.iaa = paramString1;
    paramString1 = this.iaa.auL();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(202730);
      throw paramString1;
    }
    this.zbN = ((dxy)paramString1);
    this.zbN.LwZ = this.qud;
    this.zbN.EEF = this.qVO;
    AppMethodBeat.o(202730);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202728);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202728);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202729);
    d.g.b.k.h(paramq, "rr");
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(202729);
      throw paramString;
    }
    this.zbO = ((dxz)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202729);
      return;
    }
    AppMethodBeat.o(202729);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.k
 * JD-Core Version:    0.7.0.1
 */