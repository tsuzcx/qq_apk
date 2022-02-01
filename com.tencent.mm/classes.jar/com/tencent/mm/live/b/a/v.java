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
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class v
  extends n
  implements k
{
  public static final a gQG;
  private f callback;
  public String gOx;
  private b gPp;
  private bva gQD;
  private bvb gQE;
  public Boolean gQF;
  
  static
  {
    AppMethodBeat.i(212252);
    gQG = new a((byte)0);
    AppMethodBeat.o(212252);
  }
  
  public v()
  {
    AppMethodBeat.i(212251);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bva());
    ((b.a)localObject).d((a)new bvb());
    ((b.a)localObject).oP(3895);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/liveverify");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
      AppMethodBeat.o(212251);
      throw ((Throwable)localObject);
    }
    this.gQD = ((bva)localObject);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
    AppMethodBeat.o(212251);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212249);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212249);
    return i;
  }
  
  public final int getType()
  {
    return 3895;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212250);
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212250);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
      AppMethodBeat.o(212250);
      throw paramString;
    }
    this.gQE = ((bvb)paramq);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.gQE;
      if (paramq != null)
      {
        this.gQF = Boolean.valueOf(paramq.Fyz);
        this.gOx = paramq.FyA;
        paramArrayOfByte = new StringBuilder("onGYNetEnd isVerify:");
        if (this.gQF != null) {
          break label181;
        }
      }
    }
    label181:
    for (paramq = "null";; paramq = this.gQF)
    {
      ad.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", paramq);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212250);
      return;
    }
    AppMethodBeat.o(212250);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.v
 * JD-Core Version:    0.7.0.1
 */