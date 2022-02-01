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
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "isClose", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends p
  implements m
{
  public static final a naR;
  private h callback;
  private adi naS;
  private adj naT;
  private c nao;
  
  static
  {
    AppMethodBeat.i(246851);
    naR = new a((byte)0);
    AppMethodBeat.o(246851);
  }
  
  public j(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246843);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new adi());
    ((c.a)localObject).otF = ((a)new adj());
    ((c.a)localObject).funcId = 3530;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/closeapplylivemic";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "close live id:" + paramLong + " wechatRoomId:" + paramString + " isClose:" + paramBoolean);
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicRequest");
      AppMethodBeat.o(246843);
      throw paramString;
    }
    this.naS = ((adi)localObject);
    this.naS.mMJ = paramLong;
    this.naS.YBL = paramString;
    paramString = this.naS;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.ZlV = paramBoolean;
      AppMethodBeat.o(246843);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246862);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246862);
    return i;
  }
  
  public final int getType()
  {
    return 3530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246875);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246875);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicResponse");
      AppMethodBeat.o(246875);
      throw paramString;
    }
    this.naT = ((adj)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246875);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.j
 * JD-Core Version:    0.7.0.1
 */