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
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.efu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends p
  implements m
{
  public static final a nbs;
  private h callback;
  public String content;
  private c nao;
  private eft nbt;
  private efu nbu;
  
  static
  {
    AppMethodBeat.i(246897);
    nbs = new a((byte)0);
    AppMethodBeat.o(246897);
  }
  
  public s(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(246891);
    this.content = paramString1;
    paramString1 = new c.a();
    paramString1.otE = ((a)new eft());
    paramString1.otF = ((a)new efu());
    paramString1.funcId = 904;
    paramString1.uri = "/cgi-bin/micromsg-bin/postlivemessage";
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.nao = paramString1;
    paramString1 = c.b.b(this.nao.otB);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(246891);
      throw paramString1;
    }
    this.nbt = ((eft)paramString1);
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.content = this.content;
    }
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.msg_type = paramInt;
    }
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.YJa = b.cX(paramArrayOfByte);
    }
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.mMJ = paramLong;
    }
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.YBL = paramString2;
    }
    paramString1 = this.nbt;
    if (paramString1 != null) {
      paramString1.cli_msg_id = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + this.content + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(246891);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246910);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246910);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246921);
    Log.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246921);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(246921);
      throw paramString;
    }
    this.nbu = ((efu)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246921);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.s
 * JD-Core Version:    0.7.0.1
 */