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
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "audience", "", "roomId", "liveMicId", "msgId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class f
  extends q
  implements m
{
  public static final a hJO;
  private i callback;
  private at hJM;
  private au hJN;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207761);
    hJO = new a((byte)0);
    AppMethodBeat.o(207761);
  }
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207760);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new at());
    ((d.a)localObject).d((a)new au());
    ((d.a)localObject).sG(3800);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/acceptlivemic");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicRequest");
      AppMethodBeat.o(207760);
      throw paramString1;
    }
    this.hJM = ((at)localObject);
    this.hJM.hyH = paramLong;
    this.hJM.hFJ = paramString1;
    this.hJM.KDQ = paramString2;
    this.hJM.KDS = paramString3;
    this.hJM.KDR = paramString4;
    AppMethodBeat.o(207760);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207758);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207758);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207759);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207759);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicResponse");
      AppMethodBeat.o(207759);
      throw paramString;
    }
    this.hJN = ((au)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207759);
      return;
    }
    AppMethodBeat.o(207759);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.f
 * JD-Core Version:    0.7.0.1
 */