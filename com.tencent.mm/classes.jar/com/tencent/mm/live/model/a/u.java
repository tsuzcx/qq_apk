package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fbv;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends p
  implements m
{
  public static final a nby;
  private h callback;
  private c nao;
  private fbw nbA;
  private fbv nbz;
  
  static
  {
    AppMethodBeat.i(246908);
    nby = new a((byte)0);
    AppMethodBeat.o(246908);
  }
  
  public u(long paramLong, String paramString)
  {
    AppMethodBeat.i(246901);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new fbv());
    ((c.a)localObject).otF = ((a)new fbw());
    ((c.a)localObject).funcId = 3557;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sharelive";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(246901);
      throw paramString;
    }
    this.nbz = ((fbv)localObject);
    this.nbz.mMJ = paramLong;
    this.nbz.YBL = paramString;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(246901);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246922);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246922);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246929);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246929);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(246929);
      throw paramString;
    }
    this.nbA = ((fbw)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246929);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.u
 * JD-Core Version:    0.7.0.1
 */