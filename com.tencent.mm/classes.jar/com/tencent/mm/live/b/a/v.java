package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class v
  extends n
  implements k
{
  public static final a gTo;
  private f callback;
  private b gRX;
  public String gRf;
  private bvu gTl;
  private bvv gTm;
  public Boolean gTn;
  
  static
  {
    AppMethodBeat.i(215872);
    gTo = new a((byte)0);
    AppMethodBeat.o(215872);
  }
  
  public v()
  {
    AppMethodBeat.i(215871);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bvu());
    ((b.a)localObject).d((a)new bvv());
    ((b.a)localObject).oS(3895);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/liveverify");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
      AppMethodBeat.o(215871);
      throw ((Throwable)localObject);
    }
    this.gTl = ((bvu)localObject);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
    AppMethodBeat.o(215871);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215869);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215869);
    return i;
  }
  
  public final int getType()
  {
    return 3895;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215870);
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215870);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
      AppMethodBeat.o(215870);
      throw paramString;
    }
    this.gTm = ((bvv)paramq);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.gTm;
      if (paramq != null)
      {
        this.gTn = Boolean.valueOf(paramq.FQX);
        this.gRf = paramq.FQY;
        paramArrayOfByte = new StringBuilder("onGYNetEnd isVerify:");
        if (this.gTn != null) {
          break label181;
        }
      }
    }
    label181:
    for (paramq = "null";; paramq = this.gTn)
    {
      ae.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", paramq);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215870);
      return;
    }
    AppMethodBeat.o(215870);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.v
 * JD-Core Version:    0.7.0.1
 */