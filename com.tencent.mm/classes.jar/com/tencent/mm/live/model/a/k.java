package com.tencent.mm.live.model.a;

import android.text.TextUtils;
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
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "msgId", "micId", "micSdkId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends p
  implements m
{
  public static final a naU;
  private h callback;
  private adm naV;
  private adn naW;
  private c nao;
  
  static
  {
    AppMethodBeat.i(246864);
    naU = new a((byte)0);
    AppMethodBeat.o(246864);
  }
  
  public k(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(246854);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new adm());
    ((c.a)localObject).otF = ((a)new adn());
    ((c.a)localObject).funcId = 3509;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/closelivemic";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicRequest");
      AppMethodBeat.o(246854);
      throw paramString1;
    }
    this.naV = ((adm)localObject);
    this.naV.mMJ = paramLong;
    this.naV.YBL = paramString1;
    this.naV.cli_msg_id = paramString2;
    if (!TextUtils.isEmpty((CharSequence)paramString3)) {
      this.naV.YBM = paramString3;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString4)) {
      this.naV.ZlX = paramString4;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", msgId:" + paramString2 + ", micId:" + paramString3 + ", micSdkId:" + paramString4);
    AppMethodBeat.o(246854);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246872);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246872);
    return i;
  }
  
  public final int getType()
  {
    return 3509;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246880);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246880);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicResponse");
      AppMethodBeat.o(246880);
      throw paramString;
    }
    this.naW = ((adn)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246880);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.a.k
 * JD-Core Version:    0.7.0.1
 */