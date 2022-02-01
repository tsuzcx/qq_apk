package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "likeCount", "", "(JLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LikeLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LikeLiveResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  public static final a hKv;
  private i callback;
  private d hJu;
  private cie hKt;
  private cif hKu;
  
  static
  {
    AppMethodBeat.i(207805);
    hKv = new a((byte)0);
    AppMethodBeat.o(207805);
  }
  
  public q(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(207804);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cie());
    ((d.a)localObject).d((a)new cif());
    ((d.a)localObject).sG(3957);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/likelive");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveRequest");
      AppMethodBeat.o(207804);
      throw paramString;
    }
    this.hKt = ((cie)localObject);
    localObject = this.hKt;
    if (localObject != null) {
      ((cie)localObject).hyH = paramLong;
    }
    localObject = this.hKt;
    if (localObject != null) {
      ((cie)localObject).KDQ = paramString;
    }
    localObject = this.hKt;
    if (localObject != null) {
      ((cie)localObject).count = paramInt;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "LikeLive liveId:" + paramLong + ", roomId:" + paramString + ", likeCount:" + paramInt);
    AppMethodBeat.o(207804);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207802);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207802);
    return i;
  }
  
  public final int getType()
  {
    return 3957;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207803);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207803);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveResponse");
      AppMethodBeat.o(207803);
      throw paramString;
    }
    this.hKu = ((cif)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
      AppMethodBeat.o(207803);
      return;
    }
    AppMethodBeat.o(207803);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.q
 * JD-Core Version:    0.7.0.1
 */