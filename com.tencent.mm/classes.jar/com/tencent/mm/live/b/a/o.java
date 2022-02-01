package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.b.x;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class o
  extends q
  implements m
{
  public static final a hKp;
  private i callback;
  private d hJu;
  private final cfc hKn;
  public cfd hKo;
  
  static
  {
    AppMethodBeat.i(207797);
    hKp = new a((byte)0);
    AppMethodBeat.o(207797);
  }
  
  public o(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207796);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new cfc());
    ((d.a)localObject).d((a)new cfd());
    ((d.a)localObject).sG(3797);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/joinlive");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(207796);
      throw paramString;
    }
    this.hKn = ((cfc)localObject);
    this.hKn.hyH = paramLong;
    this.hKn.KDQ = paramString;
    this.hKn.LFp = b.cD(paramArrayOfByte);
    AppMethodBeat.o(207796);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207794);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207794);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(207795);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207795);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(207795);
      throw paramString;
    }
    this.hKo = ((cfd)params);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(207795);
        return;
      }
      AppMethodBeat.o(207795);
      return;
    }
    params = this.hKo;
    if (params != null) {}
    for (params = params.LFp;; params = null)
    {
      x localx = x.hJf;
      if (params != null) {
        paramArrayOfByte = params.zy;
      }
      x.ad(paramArrayOfByte);
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207795);
      return;
    }
    AppMethodBeat.o(207795);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.o
 * JD-Core Version:    0.7.0.1
 */