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
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableOpenReplay", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class r
  extends q
  implements m
{
  public static final a hKy;
  private i callback;
  private d hJu;
  private cwt hKw;
  private cwu hKx;
  
  static
  {
    AppMethodBeat.i(207809);
    hKy = new a((byte)0);
    AppMethodBeat.o(207809);
  }
  
  public r(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207808);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cwt());
    ((d.a)localObject).d((a)new cwu());
    ((d.a)localObject).sG(3712);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/openlivereplay");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayRequest");
      AppMethodBeat.o(207808);
      throw paramString;
    }
    this.hKw = ((cwt)localObject);
    localObject = this.hKw;
    if (localObject != null) {
      ((cwt)localObject).hyH = paramLong;
    }
    localObject = this.hKw;
    if (localObject != null) {
      ((cwt)localObject).KDQ = paramString;
    }
    localObject = this.hKw;
    if (localObject != null) {
      ((cwt)localObject).MnK = paramBoolean;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "open live replay liveId:" + paramLong + " roomId:" + paramString + " enableLiveReplay:" + paramBoolean);
    AppMethodBeat.o(207808);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207806);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207806);
    return i;
  }
  
  public final int getType()
  {
    return 3712;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207807);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207807);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayResponse");
      AppMethodBeat.o(207807);
      throw paramString;
    }
    this.hKx = ((cwu)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207807);
      return;
    }
    AppMethodBeat.o(207807);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.r
 * JD-Core Version:    0.7.0.1
 */