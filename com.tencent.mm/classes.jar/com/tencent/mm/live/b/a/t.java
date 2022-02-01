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
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "liveMicId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/RefreshLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class t
  extends q
  implements m
{
  public static final a hKE;
  private i callback;
  private d hJu;
  private dly hKC;
  public dlz hKD;
  
  static
  {
    AppMethodBeat.i(207817);
    hKE = new a((byte)0);
    AppMethodBeat.o(207817);
  }
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207816);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new dly());
    ((d.a)localObject).d((a)new dlz());
    ((d.a)localObject).sG(760);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/refreshlivemic");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicRequest");
      AppMethodBeat.o(207816);
      throw paramString1;
    }
    this.hKC = ((dly)localObject);
    this.hKC.hyH = paramLong;
    this.hKC.KDQ = paramString1;
    this.hKC.KDS = paramString2;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", liveMicId:" + paramString2);
    AppMethodBeat.o(207816);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207814);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207814);
    return i;
  }
  
  public final int getType()
  {
    return 760;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207815);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207815);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RefreshLiveMicResponse");
      AppMethodBeat.o(207815);
      throw paramString;
    }
    this.hKD = ((dlz)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveRefreshMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207815);
      return;
    }
    AppMethodBeat.o(207815);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveRefreshMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.t
 * JD-Core Version:    0.7.0.1
 */