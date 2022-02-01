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
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "username", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/KickAudienceRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/KickAudienceResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class p
  extends q
  implements m
{
  public static final a hKs;
  private i callback;
  private d hJu;
  private cgk hKq;
  private cgl hKr;
  
  static
  {
    AppMethodBeat.i(207801);
    hKs = new a((byte)0);
    AppMethodBeat.o(207801);
  }
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207800);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cgk());
    ((d.a)localObject).d((a)new cgl());
    ((d.a)localObject).sG(3559);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/kickaudience");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    kotlin.g.b.p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceRequest");
      AppMethodBeat.o(207800);
      throw paramString1;
    }
    this.hKq = ((cgk)localObject);
    localObject = this.hKq;
    if (localObject != null) {
      ((cgk)localObject).hyH = paramLong;
    }
    localObject = this.hKq;
    if (localObject != null) {
      ((cgk)localObject).KDQ = paramString1;
    }
    localObject = this.hKq;
    if (localObject != null) {
      ((cgk)localObject).username = paramString2;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "kick audience liveId:" + paramLong + ", roomId:" + paramString1 + ", username:" + paramString2);
    AppMethodBeat.o(207800);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207798);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207798);
    return i;
  }
  
  public final int getType()
  {
    return 3559;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207799);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207799);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KickAudienceResponse");
      AppMethodBeat.o(207799);
      throw paramString;
    }
    this.hKr = ((cgl)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveKickAudience", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207799);
      return;
    }
    AppMethodBeat.o(207799);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveKickAudience$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.p
 * JD-Core Version:    0.7.0.1
 */