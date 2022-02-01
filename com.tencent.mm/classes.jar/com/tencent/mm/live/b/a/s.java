package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class s
  extends q
  implements m
{
  public static final a hKB;
  private i callback;
  public String content;
  private d hJu;
  private ddp hKA;
  private ddo hKz;
  
  static
  {
    AppMethodBeat.i(207813);
    hKB = new a((byte)0);
    AppMethodBeat.o(207813);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(207812);
    this.content = paramString1;
    paramString1 = new d.a();
    paramString1.c((a)new ddo());
    paramString1.d((a)new ddp());
    paramString1.sG(904);
    paramString1.MB("/cgi-bin/micromsg-bin/postlivemessage");
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.hJu = paramString1;
    paramString1 = this.hJu.aYJ();
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(207812);
      throw paramString1;
    }
    this.hKz = ((ddo)paramString1);
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.ybm = paramInt;
    }
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.LFp = b.cD(paramArrayOfByte);
    }
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.hyH = paramLong;
    }
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.KDQ = paramString2;
    }
    paramString1 = this.hKz;
    if (paramString1 != null) {
      paramString1.KDR = (z.aTY() + System.currentTimeMillis());
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(207812);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207810);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.hJu, (m)this);
    AppMethodBeat.o(207810);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207811);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207811);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(207811);
      throw paramString;
    }
    this.hKA = ((ddp)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207811);
      return;
    }
    AppMethodBeat.o(207811);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.s
 * JD-Core Version:    0.7.0.1
 */