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
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class u
  extends q
  implements m
{
  public static final a hKH;
  private i callback;
  private d hJu;
  private dxu hKF;
  private dxv hKG;
  
  static
  {
    AppMethodBeat.i(207821);
    hKH = new a((byte)0);
    AppMethodBeat.o(207821);
  }
  
  public u(long paramLong, String paramString)
  {
    AppMethodBeat.i(207820);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new dxu());
    ((d.a)localObject).d((a)new dxv());
    ((d.a)localObject).sG(3557);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/sharelive");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(207820);
      throw paramString;
    }
    this.hKF = ((dxu)localObject);
    this.hKF.hyH = paramLong;
    this.hKF.KDQ = paramString;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(207820);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207818);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207818);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207819);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207819);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(207819);
      throw paramString;
    }
    this.hKG = ((dxv)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207819);
      return;
    }
    AppMethodBeat.o(207819);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.u
 * JD-Core Version:    0.7.0.1
 */