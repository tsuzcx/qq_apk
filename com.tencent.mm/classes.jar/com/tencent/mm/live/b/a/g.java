package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.dvs;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "status", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "(JLcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/SetAnchorStatusResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class g
  extends q
  implements m
{
  public static final a hJR;
  private i callback;
  private dvs hJP;
  private dvt hJQ;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207765);
    hJR = new a((byte)0);
    AppMethodBeat.o(207765);
  }
  
  public g(long paramLong, ciq paramciq)
  {
    AppMethodBeat.i(207764);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new dvs());
    ((d.a)localObject).d((a)new dvt());
    ((d.a)localObject).sG(3852);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/setanchorstatus");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramciq = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusRequest");
      AppMethodBeat.o(207764);
      throw paramciq;
    }
    this.hJP = ((dvs)localObject);
    this.hJP.hyH = paramLong;
    this.hJP.MnG = b.cD(paramciq.toByteArray());
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "liveId:" + paramLong + " status:[" + paramciq.MnD + ", " + paramciq.MnE + ']');
    AppMethodBeat.o(207764);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(207762);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207762);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207763);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207763);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SetAnchorStatusResponse");
      AppMethodBeat.o(207763);
      throw paramString;
    }
    this.hJQ = ((dvt)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveAnchorStatus", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207763);
      return;
    }
    AppMethodBeat.o(207763);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAnchorStatus$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.g
 * JD-Core Version:    0.7.0.1
 */