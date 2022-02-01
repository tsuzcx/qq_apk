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
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "isClose", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class j
  extends q
  implements m
{
  public static final a hKa;
  private i callback;
  private aaz hJY;
  private aba hJZ;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207777);
    hKa = new a((byte)0);
    AppMethodBeat.o(207777);
  }
  
  public j(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207776);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new aaz());
    ((d.a)localObject).d((a)new aba());
    ((d.a)localObject).sG(3530);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/closeapplylivemic");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "close live id:" + paramLong + " wechatRoomId:" + paramString + " isClose:" + paramBoolean);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicRequest");
      AppMethodBeat.o(207776);
      throw paramString;
    }
    this.hJY = ((aaz)localObject);
    this.hJY.hyH = paramLong;
    this.hJY.KDQ = paramString;
    paramString = this.hJY;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.Lml = paramBoolean;
      AppMethodBeat.o(207776);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207774);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207774);
    return i;
  }
  
  public final int getType()
  {
    return 3530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207775);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207775);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicResponse");
      AppMethodBeat.o(207775);
      throw paramString;
    }
    this.hJZ = ((aba)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207775);
      return;
    }
    AppMethodBeat.o(207775);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.j
 * JD-Core Version:    0.7.0.1
 */