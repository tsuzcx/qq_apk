package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class s
  extends q
  implements m
{
  public static final a kxV;
  private i callback;
  public String content;
  private d kwO;
  private dne kxT;
  private dnf kxU;
  
  static
  {
    AppMethodBeat.i(196839);
    kxV = new a((byte)0);
    AppMethodBeat.o(196839);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(196837);
    this.content = paramString1;
    paramString1 = new d.a();
    paramString1.c((a)new dne());
    paramString1.d((a)new dnf());
    paramString1.vD(904);
    paramString1.TW("/cgi-bin/micromsg-bin/postlivemessage");
    paramString1.vF(0);
    paramString1.vG(0);
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.kwO = paramString1;
    paramString1 = this.kwO.bhX();
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(196837);
      throw paramString1;
    }
    this.kxT = ((dne)paramString1);
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.msg_type = paramInt;
    }
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.RLO = b.cU(paramArrayOfByte);
    }
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.klE = paramLong;
    }
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.RFj = paramString2;
    }
    paramString1 = this.kxT;
    if (paramString1 != null) {
      paramString1.cli_msg_id = (z.bcZ() + System.currentTimeMillis());
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(196837);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(196829);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.kwO, (m)this);
    AppMethodBeat.o(196829);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196834);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(196834);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(196834);
      throw paramString;
    }
    this.kxU = ((dnf)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(196834);
      return;
    }
    AppMethodBeat.o(196834);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */