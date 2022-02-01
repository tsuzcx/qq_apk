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
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "likeCount", "", "(JLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/LikeLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/LikeLiveResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends p
  implements m
{
  public static final a nbm;
  private h callback;
  private c nao;
  private dhv nbn;
  private dhw nbo;
  
  static
  {
    AppMethodBeat.i(246904);
    nbm = new a((byte)0);
    AppMethodBeat.o(246904);
  }
  
  public q(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(246896);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new dhv());
    ((c.a)localObject).otF = ((a)new dhw());
    ((c.a)localObject).funcId = 3957;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/likelive";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveRequest");
      AppMethodBeat.o(246896);
      throw paramString;
    }
    this.nbn = ((dhv)localObject);
    localObject = this.nbn;
    if (localObject != null) {
      ((dhv)localObject).mMJ = paramLong;
    }
    localObject = this.nbn;
    if (localObject != null) {
      ((dhv)localObject).YBL = paramString;
    }
    localObject = this.nbn;
    if (localObject != null) {
      ((dhv)localObject).count = paramInt;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "LikeLive liveId:" + paramLong + ", roomId:" + paramString + ", likeCount:" + paramInt);
    AppMethodBeat.o(246896);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246915);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246915);
    return i;
  }
  
  public final int getType()
  {
    return 3957;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246927);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246927);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LikeLiveResponse");
      AppMethodBeat.o(246927);
      throw paramString;
    }
    this.nbo = ((dhw)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveLike", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246927);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveLike$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.q
 * JD-Core Version:    0.7.0.1
 */