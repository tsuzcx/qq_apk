package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isVerify", "", "Ljava/lang/Boolean;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/LiveVerifyResponse;)V", "verifyUrl", "", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "getVerifyUrl", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends p
  implements m
{
  public static final a nbB;
  private h callback;
  public String nag;
  private c nao;
  private djb nbC;
  private djc nbD;
  public Boolean nbE;
  
  static
  {
    AppMethodBeat.i(246907);
    nbB = new a((byte)0);
    AppMethodBeat.o(246907);
  }
  
  public v()
  {
    AppMethodBeat.i(246900);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new djb());
    ((c.a)localObject).otF = ((a)new djc());
    ((c.a)localObject).funcId = 3895;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/liveverify";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyRequest");
      AppMethodBeat.o(246900);
      throw ((Throwable)localObject);
    }
    this.nbC = ((djb)localObject);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "live verify request.");
    AppMethodBeat.o(246900);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246919);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246919);
    return i;
  }
  
  public final int getType()
  {
    return 3895;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246928);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246928);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveVerifyResponse");
      AppMethodBeat.o(246928);
      throw paramString;
    }
    this.nbD = ((djc)params);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.nbD;
      if (params != null)
      {
        this.nbE = Boolean.valueOf(params.YII);
        this.nag = params.YIJ;
        if (this.nbE != null) {
          break label170;
        }
      }
    }
    label170:
    for (params = "null";; params = this.nbE)
    {
      Log.i("MicroMsg.LiveNetScene.NetSceneLiveVerify", kotlin.g.b.s.X("onGYNetEnd isVerify:", params));
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246928);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveVerify$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.v
 * JD-Core Version:    0.7.0.1
 */