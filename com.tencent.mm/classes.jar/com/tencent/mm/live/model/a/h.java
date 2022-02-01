package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "msgId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends p
  implements m
{
  public static final a naL;
  private com.tencent.mm.am.h callback;
  private hd naM;
  public he naN;
  private c nao;
  
  static
  {
    AppMethodBeat.i(246869);
    naL = new a((byte)0);
    AppMethodBeat.o(246869);
  }
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246861);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new hd());
    ((c.a)localObject).otF = ((a)new he());
    ((c.a)localObject).funcId = 3995;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/applylivemic";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicRequest");
      AppMethodBeat.o(246861);
      throw paramString1;
    }
    this.naM = ((hd)localObject);
    this.naM.mMJ = paramLong;
    this.naM.YBL = paramString1;
    this.naM.cli_msg_id = paramString2;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "apply live mic, liveId:" + paramLong + ", roomId:" + paramString1 + ", msgId:" + paramString2);
    AppMethodBeat.o(246861);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(246877);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246877);
    return i;
  }
  
  public final int getType()
  {
    return 3995;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246882);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246882);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicResponse");
      AppMethodBeat.o(246882);
      throw paramString;
    }
    this.naN = ((he)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246882);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.h
 * JD-Core Version:    0.7.0.1
 */