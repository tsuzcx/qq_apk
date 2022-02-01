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
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableOpenReplay", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends p
  implements m
{
  public static final a nbp;
  private h callback;
  private c nao;
  private dyk nbq;
  private dyl nbr;
  
  static
  {
    AppMethodBeat.i(246895);
    nbp = new a((byte)0);
    AppMethodBeat.o(246895);
  }
  
  public r(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246888);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new dyk());
    ((c.a)localObject).otF = ((a)new dyl());
    ((c.a)localObject).funcId = 3712;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/openlivereplay";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayRequest");
      AppMethodBeat.o(246888);
      throw paramString;
    }
    this.nbq = ((dyk)localObject);
    localObject = this.nbq;
    if (localObject != null) {
      ((dyk)localObject).mMJ = paramLong;
    }
    localObject = this.nbq;
    if (localObject != null) {
      ((dyk)localObject).YBL = paramString;
    }
    localObject = this.nbq;
    if (localObject != null) {
      ((dyk)localObject).aaNm = paramBoolean;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "open live replay liveId:" + paramLong + " roomId:" + paramString + " enableLiveReplay:" + paramBoolean);
    AppMethodBeat.o(246888);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246909);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246909);
    return i;
  }
  
  public final int getType()
  {
    return 3712;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246917);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246917);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayResponse");
      AppMethodBeat.o(246917);
      throw paramString;
    }
    this.nbr = ((dyl)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246917);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.r
 * JD-Core Version:    0.7.0.1
 */