package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class u
  extends n
  implements com.tencent.mm.network.k
{
  public static final a BLI;
  private eba AHZ;
  private ebb AYu;
  public Boolean AZw;
  private g callback;
  private b iaa;
  public String ivl;
  
  static
  {
    AppMethodBeat.i(202771);
    BLI = new a((byte)0);
    AppMethodBeat.o(202771);
  }
  
  public u()
  {
    AppMethodBeat.i(202770);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new eba());
    ((b.a)localObject).d((a)new ebb());
    ((b.a)localObject).nB(3895);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/liveverify");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
      AppMethodBeat.o(202770);
      throw ((Throwable)localObject);
    }
    this.AHZ = ((eba)localObject);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
    AppMethodBeat.o(202770);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202768);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202768);
    return i;
  }
  
  public final int getType()
  {
    return 3895;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202769);
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202769);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
      AppMethodBeat.o(202769);
      throw paramString;
    }
    this.AYu = ((ebb)paramq);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.AYu;
      if (paramq != null)
      {
        this.AZw = Boolean.valueOf(paramq.LwD);
        this.ivl = paramq.LwE;
        paramArrayOfByte = new StringBuilder("onGYNetEnd isVerify:");
        if (this.AZw != null) {
          break label181;
        }
      }
    }
    label181:
    for (paramq = "null";; paramq = this.AZw)
    {
      ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", paramq);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202769);
      return;
    }
    AppMethodBeat.o(202769);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.u
 * JD-Core Version:    0.7.0.1
 */