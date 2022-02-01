package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.u;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends p
  implements m
{
  public static final a nbg;
  private h callback;
  private c nao;
  private final deo nbh;
  public dep nbi;
  
  static
  {
    AppMethodBeat.i(246868);
    nbg = new a((byte)0);
    AppMethodBeat.o(246868);
  }
  
  public o(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246858);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new deo());
    ((c.a)localObject).otF = ((a)new dep());
    ((c.a)localObject).funcId = 3797;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlive";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(246858);
      throw paramString;
    }
    this.nbh = ((deo)localObject);
    this.nbh.mMJ = paramLong;
    this.nbh.YBL = paramString;
    this.nbh.YJa = b.cX(paramArrayOfByte);
    AppMethodBeat.o(246858);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246874);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246874);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(246883);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246883);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(246883);
      throw paramString;
    }
    this.nbi = ((dep)params);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246883);
      return;
    }
    params = this.nbi;
    if (params == null)
    {
      params = null;
      u localu = u.mZl;
      if (params != null) {
        break label225;
      }
    }
    label225:
    for (params = paramArrayOfByte;; params = params.Op)
    {
      u.am(params);
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246883);
      return;
      params = params.YJa;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.a.o
 * JD-Core Version:    0.7.0.1
 */