package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.protocal.protobuf.ehw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class u
  extends q
  implements m
{
  public static final a kyb;
  private i callback;
  private d kwO;
  private ehv kxZ;
  private ehw kya;
  
  static
  {
    AppMethodBeat.i(198299);
    kyb = new a((byte)0);
    AppMethodBeat.o(198299);
  }
  
  public u(long paramLong, String paramString)
  {
    AppMethodBeat.i(198297);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new ehv());
    ((d.a)localObject).d((a)new ehw());
    ((d.a)localObject).vD(3557);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/sharelive");
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.kwO = ((d)localObject);
    localObject = this.kwO.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(198297);
      throw paramString;
    }
    this.kxZ = ((ehv)localObject);
    this.kxZ.klE = paramLong;
    this.kxZ.RFj = paramString;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(198297);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(198285);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(198285);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198292);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(198292);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(198292);
      throw paramString;
    }
    this.kya = ((ehw)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(198292);
      return;
    }
    AppMethodBeat.o(198292);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.a.u
 * JD-Core Version:    0.7.0.1
 */