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
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "msgId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class h
  extends q
  implements m
{
  public static final a hJU;
  private i callback;
  private gw hJS;
  public gx hJT;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207769);
    hJU = new a((byte)0);
    AppMethodBeat.o(207769);
  }
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207768);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new gw());
    ((d.a)localObject).d((a)new gx());
    ((d.a)localObject).sG(3995);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/applylivemic");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicRequest");
      AppMethodBeat.o(207768);
      throw paramString1;
    }
    this.hJS = ((gw)localObject);
    this.hJS.hyH = paramLong;
    this.hJS.KDQ = paramString1;
    this.hJS.KDR = paramString2;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "apply live mic, liveId:" + paramLong + ", roomId:" + paramString1 + ", msgId:" + paramString2);
    AppMethodBeat.o(207768);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207766);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207766);
    return i;
  }
  
  public final int getType()
  {
    return 3995;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207767);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207767);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicResponse");
      AppMethodBeat.o(207767);
      throw paramString;
    }
    this.hJT = ((gx)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207767);
      return;
    }
    AppMethodBeat.o(207767);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.h
 * JD-Core Version:    0.7.0.1
 */