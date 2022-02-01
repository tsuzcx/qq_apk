package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class v
  extends q
  implements m
{
  public static final a hKL;
  private i callback;
  public String hJl;
  private d hJu;
  private cjf hKI;
  private cjg hKJ;
  public Boolean hKK;
  
  static
  {
    AppMethodBeat.i(207825);
    hKL = new a((byte)0);
    AppMethodBeat.o(207825);
  }
  
  public v()
  {
    AppMethodBeat.i(207824);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cjf());
    ((d.a)localObject).d((a)new cjg());
    ((d.a)localObject).sG(3895);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/liveverify");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
      AppMethodBeat.o(207824);
      throw ((Throwable)localObject);
    }
    this.hKI = ((cjf)localObject);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
    AppMethodBeat.o(207824);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207822);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207822);
    return i;
  }
  
  public final int getType()
  {
    return 3895;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207823);
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207823);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
      AppMethodBeat.o(207823);
      throw paramString;
    }
    this.hKJ = ((cjg)params);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.hKJ;
      if (params != null)
      {
        this.hKK = Boolean.valueOf(params.KKE);
        this.hJl = params.KKF;
        paramArrayOfByte = new StringBuilder("onGYNetEnd isVerify:");
        if (this.hKK != null) {
          break label181;
        }
      }
    }
    label181:
    for (params = "null";; params = this.hKK)
    {
      Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", params);
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207823);
      return;
    }
    AppMethodBeat.o(207823);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.v
 * JD-Core Version:    0.7.0.1
 */