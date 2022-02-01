package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableComment", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/BanLiveCommentResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class i
  extends q
  implements m
{
  public static final a hJX;
  private com.tencent.mm.ak.i callback;
  private iy hJV;
  private iz hJW;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207773);
    hJX = new a((byte)0);
    AppMethodBeat.o(207773);
  }
  
  public i(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207772);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new iy());
    ((d.a)localObject).d((a)new iz());
    ((d.a)localObject).sG(3664);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/banlivecomment");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentRequest");
      AppMethodBeat.o(207772);
      throw paramString;
    }
    this.hJV = ((iy)localObject);
    localObject = this.hJV;
    if (localObject != null) {
      ((iy)localObject).hyH = paramLong;
    }
    localObject = this.hJV;
    if (localObject != null) {
      ((iy)localObject).KDQ = paramString;
    }
    localObject = this.hJV;
    if (localObject != null) {
      ((iy)localObject).KNv = paramBoolean;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "BanLiveComment liveId:" + paramLong + ", roomId:" + paramString + ", enableComment:" + paramBoolean + ' ');
    AppMethodBeat.o(207772);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(207770);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207770);
    return i;
  }
  
  public final int getType()
  {
    return 3664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207771);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207771);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BanLiveCommentResponse");
      AppMethodBeat.o(207771);
      throw paramString;
    }
    this.hJW = ((iz)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveBanLiveComment", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207771);
      return;
    }
    AppMethodBeat.o(207771);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveBanLiveComment$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.i
 * JD-Core Version:    0.7.0.1
 */